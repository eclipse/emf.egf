/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.dialogs;

import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog;
import org.eclipse.jdt.ui.dialogs.TypeSelectionExtension;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeSelectionDialog extends FilteredTypesSelectionDialog {

    private static final String DIALOG_SETTINGS = "org.eclipse.egf.core.ui.dialogs.TypeSelectionDialog"; //$NON-NLS-1$ 

    public TypeSelectionDialog(Shell parent, boolean multi, IRunnableContext context, IJavaProject javaProject, int elementKinds) {
        super(parent, multi, context, javaProject != null ? SearchEngine.createJavaSearchScope(new IJavaElement[] {
            javaProject
        }) : SearchEngine.createWorkspaceScope(), elementKinds, null);
        setTitle(CoreUIMessages.TypeSelection_dialogTitle);
        setMessage(CoreUIMessages.TypeSelectionDialog_dialogMessage);
        if (javaProject != null) {
            setSeparatorLabel(NLS.bind(CoreUIMessages._UI_FilteredItemsSelectionDialog_separatorLabel, javaProject.getProject().getName()));
        } else {
            setSeparatorLabel(CoreUIMessages._UI_FilteredItemsSelectionDialog_workspaceSeparatorLabel);
        }
    }

    public TypeSelectionDialog(Shell parent, boolean multi, IRunnableContext context, IJavaProject javaProject, int elementKinds, TypeSelectionExtension extension) {
        super(parent, multi, context, javaProject != null ? SearchEngine.createJavaSearchScope(new IJavaElement[] {
            javaProject
        }) : SearchEngine.createWorkspaceScope(), elementKinds, extension);
        setTitle(NLS.bind(CoreUIMessages._UI_SelectType, extension.getFilterExtension()));
        setTitle(CoreUIMessages.TypeSelection_dialogTitle);
        setMessage(CoreUIMessages.TypeSelectionDialog_dialogMessage);
        if (javaProject != null) {
            setSeparatorLabel(NLS.bind(CoreUIMessages._UI_FilteredItemsSelectionDialog_separatorLabel, javaProject.getProject().getName()));
        } else {
            setSeparatorLabel(CoreUIMessages._UI_FilteredItemsSelectionDialog_workspaceSeparatorLabel);
        }
    }

    public TypeSelectionDialog(Shell parent, boolean multi, IRunnableContext context, int elementKinds) {
        super(parent, multi, context, SearchEngine.createWorkspaceScope(), elementKinds, null);
        setTitle(CoreUIMessages.TypeSelection_dialogTitle);
        setMessage(CoreUIMessages.TypeSelectionDialog_dialogMessage);
        setSeparatorLabel(CoreUIMessages._UI_FilteredItemsSelectionDialog_workspaceSeparatorLabel);
    }

    public TypeSelectionDialog(Shell parent, boolean multi, IRunnableContext context, int elementKinds, TypeSelectionExtension extension) {
        super(parent, multi, context, SearchEngine.createWorkspaceScope(), elementKinds, extension);
        setTitle(CoreUIMessages.TypeSelection_dialogTitle);
        setMessage(CoreUIMessages.TypeSelectionDialog_dialogMessage);
        setSeparatorLabel(CoreUIMessages._UI_FilteredItemsSelectionDialog_workspaceSeparatorLabel);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog#getDialogSettings()
     */
    @Override
    protected IDialogSettings getDialogSettings() {
        IDialogSettings settings = EGFCoreUIPlugin.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);
        if (settings == null) {
            settings = EGFCoreUIPlugin.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
        }
        return settings;
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.window.Window#open()
     */
    @Override
    public int open() {
        return super.open();
    }

    /**
     * Returns the list of selections made by the user, or <code>null</code>
     * if the selection was canceled.
     * 
     * @return the array of selected elements, or <code>null</code> if Cancel
     *         was pressed
     */
    @Override
    public Object[] getResult() {
        computeResult();
        return super.getResult();
    }

    public Control createPage(Composite parent) {
        return dialogArea = createDialogArea(parent);
    }

}
