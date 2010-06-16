/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.dev.pattern.contributions;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.helper.ObjectHolder;
import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.ui.contributor.EditorMenuContributor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.PatternFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * 
 * 
 * @author Thomas Guiu
 * 
 */
public class PatternMenuContributor extends EditorMenuContributor {

    private final AddConditionAction generateAction = new AddConditionAction();

    @Override
    public void menuAboutToShow(IMenuManager menuManager) {
        IStructuredSelection selection2 = (IStructuredSelection) _selection;
        if (selection2.size() == 1 && selection2.getFirstElement() instanceof PatternViewpoint) {
            menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, generateAction);
        }
    }

    private final class AddConditionAction extends Action {

        public AddConditionAction() {
            super("Add conditions");//$NON-NLS-1$
            setId(getText());
        }

        @Override
        public void run() {
            if (_selection == null)
                throw new IllegalStateException();
            IStructuredSelection sselection = (IStructuredSelection) _selection;
            if (sselection.isEmpty() || !(sselection.getFirstElement() instanceof EObject))
                throw new IllegalStateException();

            final Resource resource = ((EObject) sselection.getFirstElement()).eResource();
            final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
            final ObjectHolder<Exception> exception = new ObjectHolder<Exception>();

            final Set<Pattern> patterns = new HashSet<Pattern>();
            PatternHelper patternCollector = PatternHelper.TRANSACTIONNAL_COLLECTOR;
            patterns.addAll(patternCollector.getPatterns(resource.getURI()));
            editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
                @Override
                protected void doExecute() {
                    try {
                        for (Pattern pattern : patterns) {
                            PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
                            if (pattern.getConditionMethod() == null) {

                                PatternMethod preConditionMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
                                pattern.getMethods().add(preConditionMethod);
                                pattern.setConditionMethod(preConditionMethod);
                                preConditionMethod.setName(PatternFactory.PRECONDITION_METHOD_NAME);
                                preConditionMethod.setPatternFilePath(extension.getFactory().createURI(preConditionMethod));

                                IProject project = PatternHelper.getPlatformFcore(pattern).getPlatformBundle().getProject();
                                extension.createInitializer(project, pattern).updateSpecialMethods(false);
                            }
                        }
                    } catch (Exception e) {
                        org.eclipse.egf.dev.Activator.getDefault().logError(e);
                    } finally {
                        patterns.clear();
                    }
                }
            });

            // save fcore
            try {
                editingDomain.runExclusive(new Runnable() {
                    public void run() {
                        try {
                            resource.save(Collections.EMPTY_MAP);
                        } catch (IOException e) {
                            org.eclipse.egf.dev.Activator.getDefault().logError(e);
                        }
                    }
                });
            } catch (InterruptedException ie) {
                return;
            }

        }
    }

}
