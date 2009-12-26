package org.eclipse.egf.pattern.ui.editors.wizards.pages;

import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.internal.ui.dialogs.OpenTypeSelectionDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

@SuppressWarnings("restriction")
public class ChooseJavaTypePage extends OpenTypeSelectionDialog {

    private Shell shell;
    public ChooseJavaTypePage(Shell shell) {
        super(shell, false, PlatformUI.getWorkbench().getProgressService(), SearchEngine.createWorkspaceScope(), IJavaSearchConstants.TYPE);
        this.shell = shell;
    }

    public Shell getShell() {
        return shell;
    }
    
    public Control createPage(Composite parent) {
        return dialogArea = createDialogArea(parent);
    }
    
    public void computeResult() {
        super.computeResult();
    }

}
