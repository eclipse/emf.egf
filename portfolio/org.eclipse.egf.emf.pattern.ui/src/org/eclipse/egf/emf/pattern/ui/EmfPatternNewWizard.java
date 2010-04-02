package org.eclipse.egf.emf.pattern.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.emf.pattern.FcoreUtil;
import org.eclipse.egf.model.fcore.presentation.FcoreModelWizard;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

public class EmfPatternNewWizard extends FcoreModelWizard {

    private IFile _genModel;

    public EmfPatternNewWizard(IFile genModel) {
        _genModel = genModel;
    }

    @Override
    public void addPage(IWizardPage page) {
        if (page == newFileCreationPage)
            super.addPage(page);
    }

    @Override
    public void addPages() {
        super.addPages();
        newFileCreationPage.setFileName(getFileName());
    }

    @Override
    public boolean performFinish() {

        // Nothing to do
        if (_genModel == null) {
            return true;
        }

        final Throwable[] throwable = new Throwable[1];
        final IFile fcore = getFcore();

        // Convert and Process current Project
        WorkspaceModifyOperation convertOperation = new ConvertProjectOperation(_genModel.getProject(), true, true) {
            @Override
            public List<String> addDependencies() {
                List<String> dependencies = new ArrayList<String>(1);
                dependencies.add("org.eclipse.egf.pattern"); //$NON-NLS-1$
                dependencies.add("org.eclipse.egf.pattern.ftask"); //$NON-NLS-1$
                dependencies.add("org.eclipse.egf.model.ftask"); //$NON-NLS-1$
                dependencies.add("org.eclipse.egf.emf.pattern"); //$NON-NLS-1$
                dependencies.add("org.eclipse.egf.emf.pattern.base"); //$NON-NLS-1$
                return dependencies;
            }

            @Override
            public List<String> addSourceFolders() {
                List<String> sourceFolders = new ArrayList<String>(1);
                sourceFolders.add("src"); //$NON-NLS-1$
                sourceFolders.add("generated"); //$NON-NLS-1$
                return sourceFolders;
            }
        };
        try {
            getContainer().run(false, false, convertOperation);
        } catch (Throwable t) {
            throwable[0] = t;
        }

        // Save resource
        if (throwable[0] == null) {
            WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
                @Override
                protected void execute(IProgressMonitor monitor) {
                    try {
                        SubMonitor.convert(monitor, Messages.EmfPatternNewWizard_0, 1000);
                        try {
                            new FcoreUtil().createFcoreFile(_genModel, fcore, monitor);
                        } catch (Exception ioe) {
                            throwable[0] = ioe;
                        }
                    } finally {
                        monitor.done();
                    }
                }
            };
            try {
                getContainer().run(false, true, operation);
            } catch (Throwable t) {
                throwable[0] = t;
            }
        }

        // Select the new file resource in the current view.
        if (throwable[0] == null) {
            IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
            IWorkbenchPage page = workbenchWindow.getActivePage();
            final IWorkbenchPart activePart = page.getActivePart();
            if (activePart instanceof ISetSelectionTarget) {
                final ISelection targetSelection = new StructuredSelection(_genModel);
                getShell().getDisplay().asyncExec(new Runnable() {
                    public void run() {
                        ((ISetSelectionTarget) activePart).selectReveal(targetSelection);
                    }
                });
            }
            // Open an editor on the new file.
            try {
                page.openEditor(new FileEditorInput(fcore), workbench.getEditorRegistry().getDefaultEditor(fcore.getFullPath().toString()).getId());
            } catch (Throwable t) {
                throwable[0] = t;
            }
        }

        // Display errors if any
        if (throwable[0] != null && throwable[0] instanceof InterruptedException == false) {
            ThrowableHandler.handleThrowable(Activator.getDefault().getPluginID(), throwable[0]);
            return false;
        }

        return true;
    }

    private String getFileName() {
        return _genModel.getFullPath().removeFileExtension().addFileExtension(FILE_EXTENSIONS.get(0)).lastSegment();
    }

    private IFile getFcore() {
        return _genModel.getProject().getFile(newFileCreationPage.getContainerFullPath().removeFirstSegments(1).append(newFileCreationPage.getFileName()));
    }
}
