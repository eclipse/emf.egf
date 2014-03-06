package org.eclipse.egf.emf.pattern.codegen.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.emf.pattern.codegen.CodegenFcoreUtil;
import org.eclipse.egf.model.fcore.presentation.FcoreModelWizard;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

public class ReverseCodegenWizard extends FcoreModelWizard {

    private static final String EMF_PATTERN_FCORE = "EMF_Pattern.fcore"; //$NON-NLS-1$

    private static final String ORG_ECLIPSE_EMF_CODEGEN_ECORE = "org.eclipse.emf.codegen.ecore"; //$NON-NLS-1$

    @Override
    public void addPage(IWizardPage page) {
        if (page == newFileCreationPage) 
            super.addPage(page);
    }
    
    @Override
    public void addPages() {
        super.addPages();

        newFileCreationPage.setFileName(EMF_PATTERN_FCORE);
        newFileCreationPage.setAllowExistingResources(true);
    }

    @Override
    public boolean canFinish() {
        if (getFcore().exists()) 
            newFileCreationPage.setMessage(Messages.ReverseCodegenWizard_1, IMessageProvider.WARNING);

        return super.canFinish();
    }
    
    @Override
    public boolean performFinish() {        
        final Throwable[] throwable = new Throwable[1];
        final IFile fcore = getFcore();

        // Convert and Process current Project
        ConvertProjectOperation convertOperation = new ConvertProjectOperation(getFcore().getProject(), true, true);
        convertOperation.setInitialDependencies(new String[] {"org.eclipse.egf.model.ftask", "org.eclipse.egf.emf.pattern.base"});
        convertOperation.setInitialSourceFolders(new String[] {"generated"});
        
        
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
                        SubMonitor.convert(monitor, Messages.ReverseCodegenWizard_0, 1000);
                        try {
                            new CodegenFcoreUtil().createFcoreFile(fcore, ORG_ECLIPSE_EMF_CODEGEN_ECORE, monitor);
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
                final ISelection targetSelection = new StructuredSelection(fcore);
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

    private IFile getFcore() {
        return newFileCreationPage.getModelFile();
    }
}
