/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.ui;

import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.ui.contributor.ViewpointContributor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.PatternInitializer;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.ui.editors.PatternEditor;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.egf.pattern.ui.editors.templateEditor.TemplateExtensionRegistry;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternViewpointContributor extends ViewpointContributor {

    public static final String EDIT_ACTION_ID = "edit-pattern"; //$NON-NLS-1$

    public static final String EDIT_TEMPLATE_ACTION_ID = "edit-template-pattern"; //$NON-NLS-1$   

    private final EditPatternAction editAction = new EditPatternAction();

    private final EditTemplatePatternAction editTemplateAction = new EditTemplatePatternAction();

    private boolean addActions() {
        if (selection == null)
            return false;
        IStructuredSelection sselection = (IStructuredSelection) selection;
        if (sselection.size() != 1 || !(sselection.getFirstElement() instanceof PatternElement))
            return false;

        return true;
    }

    @Override
    public void menuAboutToShow(IMenuManager menuManager) {
        IStructuredSelection selection2 = (IStructuredSelection) selection;
        if (addActions()) {
            if (selection2.getFirstElement() instanceof PatternLibrary) {
                IContributionItem item = menuManager.find(EGFCommonUIConstants.CREATE_CHILD);
                MenuManager createChildMenuManager = null;
                if (item != null && item instanceof MenuManager) {
                    createChildMenuManager = (MenuManager) item;
                } else {
                    createChildMenuManager = new MenuManager(Messages.ViewpointContributor_newChildGroup_label);
                    menuManager.insertBefore(EGFCommonUIConstants.CREATE_SIBLING, createChildMenuManager);
                }
                Map<String, PatternExtension> extensions = ExtensionHelper.getExtensions();
                for (String nature : extensions.keySet()) {
                    PatternExtension patternExtension = extensions.get(nature);
                    CommandParameter descriptor = new CommandParameter(null, PatternPackage.Literals.PATTERN_LIBRARY__ELEMENTS, patternExtension.getFactory().createPattern(null, "myPattern"));
                    CreateChildAction createChildAction = new CreatePatternAction(activeEditorPart, selection, descriptor, (PatternLibrary) selection2.getFirstElement());
                    createChildAction.setText(Messages.bind(Messages.ViewpointContributor_newPattern_label, nature));
                    createChildAction.setImageDescriptor(ImageDescriptor.createFromURL(patternExtension.getImageURL()));
                    createChildMenuManager.add(createChildAction);
                }
                // menuManager.insertBefore("edit", createChildAction);
            } else if (selection2.getFirstElement() instanceof Pattern) {
                menuManager.insertBefore(EGFCommonUIConstants.EDIT_MENU_GROUP, editAction);
                menuManager.insertBefore(EGFCommonUIConstants.EDIT_MENU_GROUP, editTemplateAction);
            }
        }
    }

    private final class CreatePatternAction extends CreateChildAction {

        private final PatternLibrary library;

        public CreatePatternAction(IEditorPart editorPart, ISelection selection, Object descriptor, PatternLibrary library) {
            super(editorPart, selection, descriptor);
            this.library = library;
        }

        @Override
        protected Command createActionCommand(EditingDomain editingDomain, Collection<?> collection) {

            final Command createActionCommand = super.createActionCommand(editingDomain, collection);
            if (UnexecutableCommand.INSTANCE.equals(createActionCommand))
                return UnexecutableCommand.INSTANCE;
            return createActionCommand.chain(new AbstractCommand() {

                @Override
                protected boolean prepare() {
                    return true;
                }

                public void execute() {
                    Collection<?> affectedObjects = createActionCommand.getAffectedObjects();
                    Pattern pattern = (Pattern) affectedObjects.iterator().next();
                    // update method file URIs
                    for (PatternMethod m : pattern.getMethods()) {
                        m.setPatternFilePath(PatternHelper.Filename.computeFileURI(m));
                    }

                    // create template files
                    IProject project = EGFCorePlugin.getPlatformFcore(library.eResource()).getPlatformBundle().getProject();
                    try {
                        PatternInitializer initializer = ExtensionHelper.getExtension(pattern.getNature()).createInitializer(project, pattern);
                        initializer.initContent();
                    } catch (PatternException e) {
                        Activator.getDefault().logError(e);

                    } catch (MissingExtensionException e) {
                        Activator.getDefault().logError(e);

                    }
                }

                public void undo() {
                    Collection<?> affectedObjects = createActionCommand.getAffectedObjects();
                    Pattern pattern = (Pattern) affectedObjects.iterator().next();
                    IProject project = EGFCorePlugin.getPlatformFcore(library.eResource()).getPlatformBundle().getProject();
                    IFile currentFile = null;
                    try {
                        for (PatternMethod m : pattern.getMethods()) {
                            currentFile = project.getFile(m.getPatternFilePath().path());
                            currentFile.delete(true, false, null);
                        }
                        if (currentFile != null && currentFile.getParent() != null)
                            currentFile.getParent().delete(true, null);
                    } catch (CoreException e) {
                        Activator.getDefault().logError(e);
                    }

                }

                public void redo() {
                }
            });
        }
    }

    private final class TestAction extends Action {

        public TestAction(String text) {
            super(text);
            setId(text);
        }

        @Override
        public void run() {

            super.run();
        }
    }

    private abstract class PatternAction extends Action {

        public PatternAction(String label, String id) {
            super(label);
            setId(id);
        }

        protected Pattern getPattern() {
            if (selection == null)
                throw new IllegalStateException();
            IStructuredSelection sselection = (IStructuredSelection) selection;
            if (sselection.size() != 1 || !(sselection.getFirstElement() instanceof Pattern))
                throw new IllegalStateException();
            return (Pattern) sselection.getFirstElement();
        }

        protected Pattern getPatternInTransactionalEditingDomain() {
            Pattern pattern = getPattern();
            return PatternHelper.TRANSACTIONNAL_COLLECTOR.getPattern(pattern.getID());
        }
    }

    private final class EditTemplatePatternAction extends PatternAction {

        public EditTemplatePatternAction() {
            super(Messages.ViewpointContributor_editTemplateAction_label, EDIT_TEMPLATE_ACTION_ID);
        }

        @Override
        public void run() {
            Pattern patternInTransactionalEditingDomain = getPatternInTransactionalEditingDomain();
            if (patternInTransactionalEditingDomain == null)
                MessageDialog.openInformation(parent.getPage().getWorkbenchWindow().getShell(), Messages.ViewpointContributor_missingPattern_title, Messages.ViewpointContributor_missingPattern_message);
            else{
                //PatternTemplateEditor.openEditor(parent.getPage(), patternInTransactionalEditingDomain, null);
                Pattern pattern = getPattern();
                String editor = TemplateExtensionRegistry.getEditor(pattern);
                if (editor != null) {
                    try {
                        PatternEditorInput input = new PatternEditorInput(pattern.eResource(), pattern.getID());
                        IDE.openEditor(parent.getPage(), input, editor);
                    } catch (PartInitException e) {
                        Activator.getDefault().logError(e);
                    }
                }
            }
        }
    }

    private final class EditPatternAction extends PatternAction {

        public EditPatternAction() {
            super(Messages.ViewpointContributor_editAction_label, EDIT_ACTION_ID);
        }

        @Override
        public void run() {
            Pattern patternInTransactionalEditingDomain = getPatternInTransactionalEditingDomain();
            if (patternInTransactionalEditingDomain == null)
                MessageDialog.openInformation(parent.getPage().getWorkbenchWindow().getShell(), Messages.ViewpointContributor_missingPattern_title, Messages.ViewpointContributor_missingPattern_message);
            else
                PatternEditor.openEditor(parent.getPage(), patternInTransactionalEditingDomain);
        }
    }

}
