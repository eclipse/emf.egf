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

import java.util.List;

import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog;
import org.eclipse.jdt.ui.dialogs.TypeSelectionExtension;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.viewers.StructuredSelection;
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

    private List<ISelectionDialogListener> _selectionListeners = new UniqueEList<ISelectionDialogListener>();

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

    public boolean addSelectionListeners(ISelectionDialogListener listener) {
        if (listener == null) {
            return false;
        }
        return _selectionListeners.add(listener);
    }

    public boolean removeSelectionListeners(ISelectionDialogListener listener) {
        if (listener == null) {
            return false;
        }
        return _selectionListeners.remove(listener);
    }

    public void notifySelectionListeners(Object[] selected) {
        for (ISelectionDialogListener listener : _selectionListeners) {
            listener.handleSelected(selected);
        }
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    /**
     * TypeSelectionDialog inherit from an internal class
     * As such the inherited open is hidden.
     * 
     * @see org.eclipse.jface.window.Window#open()
     */
    @Override
    public int open() {
        return super.open();
    }

    /**
     * Hack to use a dialog in a wizard page
     * 
     * @return the current shell or its parent shell
     */
    @Override
    public Shell getShell() {
        return super.getShell() != null ? super.getShell() : getParentShell();
    }

    /**
     * Handle selection
     * 
     * @param selection
     *            the new selection
     */
    @Override
    protected void handleSelected(StructuredSelection selection) {
        super.handleSelected(selection);
        if (selection.size() != 0) {
            List<IType> types = new UniqueEList<IType>();
            for (Object object : selection.toList()) {
                if (object instanceof TypeNameMatch) {
                    types.add(((TypeNameMatch) object).getType());
                }
            }
            notifySelectionListeners(types.toArray());
        }
    }

    /**
     * Hack to use a dialog in a wizard page
     * 
     * @return Control
     * 
     */
    public Control createPage(Composite parent) {
        return dialogArea = createDialogArea(parent);
    }

}
