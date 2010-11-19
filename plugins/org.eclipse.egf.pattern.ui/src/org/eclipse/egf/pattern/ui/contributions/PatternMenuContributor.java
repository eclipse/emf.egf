/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.contributions;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.ProjectHelper;
import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.ui.contributor.EditorMenuContributor;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternNameHelper;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.model.pattern.commands.PatternLibraryRemovePatternCommand;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.engine.TranslationHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.PatternInitializer;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;

/**
 * @author Thomas Guiu
 */
public class PatternMenuContributor extends EditorMenuContributor {

    public static final String EDIT_ACTION_ID = "edit-pattern"; //$NON-NLS-1$

    public static final String EDIT_TEMPLATE_ACTION_ID = "edit-template-pattern"; //$NON-NLS-1$   

    private final EditPatternAction editAction = new EditPatternAction();

    private final EditTemplatePatternAction editTemplateAction = new EditTemplatePatternAction();

    private final GeneratePatternAction generateAction = new GeneratePatternAction();

    @Override
    public void menuAboutToShow(IMenuManager menuManager) {
        IStructuredSelection selection2 = (IStructuredSelection) _selection;
        if (selection2.size() == 1) {
            if (selection2.getFirstElement() instanceof PatternLibrary) {
                IContributionItem item = menuManager.find(EGFCommonUIConstants.CREATE_CHILD);
                MenuManager createChildMenuManager = null;
                if (item != null && item instanceof MenuManager) {
                    createChildMenuManager = (MenuManager) item;
                } else {
                    createChildMenuManager = new MenuManager(CoreUIMessages.MenuContributor_newChildGroup_label);
                    menuManager.insertBefore(EGFCommonUIConstants.CREATE_SIBLING, createChildMenuManager);
                }
                PatternLibrary library = (PatternLibrary) selection2.getFirstElement();
                IPlatformFcore fcore = null;
                if (library.eResource() != null && library.eResource() instanceof IPlatformFcoreProvider) {
                    fcore = ((IPlatformFcoreProvider) library.eResource()).getIPlatformFcore();
                }
                for (String name : EGFPatternPlugin.getPatternNatures()) {
                    try {
                        PatternExtension patternExtension = EGFPatternPlugin.getPatternExtension(name);
                        CommandParameter descriptor = new CommandParameter(null, PatternPackage.Literals.PATTERN_LIBRARY__ELEMENTS, patternExtension.getFactory().createPattern(null, PatternNameHelper.getNewPatternName(fcore, library)));
                        CreateChildAction createChildAction = new CreatePatternAction(_activeEditorPart, _selection, descriptor, library);
                        createChildAction.setText(Messages.bind(Messages.ViewpointContributor_newPattern_label, name));
                        createChildAction.setImageDescriptor(ImageDescriptor.createFromURL(patternExtension.getImageURL()));
                        createChildMenuManager.add(createChildAction);
                    } catch (CoreException ce) {
                        Activator.getDefault().logError(ce);
                    }
                }
                // menuManager.insertBefore("edit", createChildAction);
            } else if (selection2.getFirstElement() instanceof Pattern) {
                menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, editAction);
                menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, editTemplateAction);
            } else if (selection2.getFirstElement() instanceof PatternViewpoint) {
                menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, generateAction);
            }
        }
    }

    private final class CreatePatternAction extends CreateChildAction {

        private final PatternLibrary _library;

        public CreatePatternAction(IEditorPart editorPart, ISelection selection, Object descriptor, PatternLibrary library) {
            super(editorPart, selection, descriptor);
            _library = library;
        }

        @Override
        protected Command createActionCommand(EditingDomain innerEditingDomain, Collection<?> collection) {

            final Command createActionCommand = super.createActionCommand(innerEditingDomain, collection);

            if (UnexecutableCommand.INSTANCE.equals(createActionCommand)) {
                return UnexecutableCommand.INSTANCE;
            }

            return createActionCommand.chain(new AbstractCommand() {

                protected Collection<Pattern> _patterns;

                @Override
                public boolean canExecute() {
                    if (super.canExecute() == false) {
                        return false;
                    }
                    if (_library.eResource() == null || _library.eResource() instanceof IPlatformFcoreProvider == false) {
                        return false;
                    }
                    IPlatformFcore fcore = ((IPlatformFcoreProvider) _library.eResource()).getIPlatformFcore();
                    if (fcore == null) {
                        return false;
                    }
                    return true;
                }

                @Override
                protected boolean prepare() {
                    return true;
                }

                public void execute() {
                    Collection<?> affectedObjects = createActionCommand.getAffectedObjects();
                    Pattern pattern = (Pattern) affectedObjects.iterator().next();
                    _patterns = Collections.singletonList(pattern);
                    // update method file URIs
                    IPlatformFcore fcore = ((IPlatformFcoreProvider) _library.eResource()).getIPlatformFcore();
                    for (PatternMethod method : pattern.getMethods()) {
                        method.setPatternFilePath(TemplateModelFileHelper.computeFileURI(fcore, method));
                    }
                    // create template files
                    IProject project = EMFHelper.getProject(_library.eResource());
                    try {
                        PatternInitializer initializer = ExtensionHelper.getExtension(pattern.getNature()).createInitializer(project, pattern);
                        initializer.initContent();
                    } catch (PatternException e) {
                        Activator.getDefault().logError(e);
                    } catch (MissingExtensionException e) {
                        Activator.getDefault().logError(e);
                    }
                }

                @Override
                public void undo() {
                    PatternLibraryRemovePatternCommand.performDeletePatterns(_library.eResource(), _patterns);
                }

                public void redo() {
                    PatternLibraryRemovePatternCommand.performRestorePatterns(_library.eResource(), _patterns);
                }

            });
        }
    }

    private final class GeneratePatternAction extends Action {

        public GeneratePatternAction() {
            super(Messages.ViewpointContributor_generatePatternAction_label);
            setId(getText());
        }

        @Override
        public void run() {
            if (_selection == null) {
                throw new IllegalStateException();
            }
            IStructuredSelection sselection = (IStructuredSelection) _selection;
            if (sselection.isEmpty() || !(sselection.getFirstElement() instanceof EObject)) {
                throw new IllegalStateException();
            }
            final Resource resource = ((EObject) sselection.getFirstElement()).eResource();

            WorkspaceJob job = new WorkspaceJob(NLS.bind(org.eclipse.egf.pattern.l10n.EGFPatternMessages.pattern_translation_label, resource.getURI())) {

                @Override
                public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {

                    MultiStatus statii = new MultiStatus(Activator.getDefault().getPluginID(), IStatus.ERROR, org.eclipse.egf.pattern.l10n.EGFPatternMessages.PatternTranslation_pattern_exception, null);
                    Set<Pattern> patterns = new HashSet<Pattern>();
                    PatternHelper patternCollector = PatternHelper.createCollector();
                    try {
                        patterns.addAll(patternCollector.getPatterns(resource.getURI()));
                        TranslationHelper.translate(monitor, patterns);
                    } catch (OperationCanceledException oce) {
                        throw oce;
                    } catch (Throwable t) {
                        if (t instanceof CoreException) {
                            statii.add(((CoreException) t).getStatus());
                        } else {
                            statii.add(Activator.getDefault().newStatus(Status.ERROR, org.eclipse.egf.pattern.l10n.EGFPatternMessages.PatternTranslation_pattern_exception, t));
                        }
                    } finally {
                        monitor.done();
                        patterns.clear();
                        patternCollector.clear();
                    }
                    return statii.getChildren().length != 0 ? statii : Status.OK_STATUS;

                }

            };
            job.setRule(ProjectHelper.getRule(Collections.singletonList(EMFHelper.getProject(resource))));
            job.schedule();

        }
    }

    private abstract class PatternAction extends Action {

        public PatternAction(String label, String id) {
            super(label);
            setId(id);
        }

        protected Pattern getPattern() {
            if (_selection == null)
                throw new IllegalStateException();
            IStructuredSelection sselection = (IStructuredSelection) _selection;
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
            super(Messages.ViewpointContributor_openTemplateAction_label, EDIT_TEMPLATE_ACTION_ID);
        }

        @Override
        public void run() {
            Pattern patternInTransactionalEditingDomain = getPatternInTransactionalEditingDomain();
            if (patternInTransactionalEditingDomain == null)
                MessageDialog.openInformation(_parent.getPage().getWorkbenchWindow().getShell(), Messages.ViewpointContributor_missingPattern_title, Messages.ViewpointContributor_missingPattern_message);
            else {
                // PatternTemplateEditor.openEditor(parent.getPage(),
                // patternInTransactionalEditingDomain, null);
                Pattern pattern = getPattern();
                EditHelper.openTemplateBasicEditor(_parent.getPage(), pattern);
                // String editor = TemplateExtensionRegistry.getEditor(pattern);
                // if (editor != null) {
                // EditHelper.openTemplateEditor(_parent.getPage(), pattern,
                // editor);
                // }
            }
        }

    }

    private final class EditPatternAction extends PatternAction {

        public EditPatternAction() {
            super(Messages.ViewpointContributor_openAction_label, EDIT_ACTION_ID);
        }

        @Override
        public void run() {
            EditHelper.openPatternEditor(_parent.getPage(), getPattern());
        }
    }

}
