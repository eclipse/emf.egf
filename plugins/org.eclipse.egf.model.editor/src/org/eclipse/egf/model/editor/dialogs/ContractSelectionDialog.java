/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.editor.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.provider.FcoreItemProviderAdapterFactory;
import org.eclipse.egf.model.fcore.provider.FcoreResourceItemProviderAdapterFactory;
import org.eclipse.egf.model.fprod.provider.FprodItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class ContractSelectionDialog extends AbstractCheckboxSelectionDialog {

    private final String SETTINGS_ID = EGFModelEditorPlugin.getPlugin().getSymbolicName() + ".SCOPED_SAVE_SELECTION_DIALOG"; //$NON-NLS-1$    

    private List<Contract> _contracts = new ArrayList<Contract>();

    private ComposedAdapterFactory _adapterFactory;

    public ContractSelectionDialog(Shell parentShell) {
        super(parentShell);
        setShellStyle(getShellStyle() | SWT.RESIZE);
        setShowSelectAllButtons(true);
        // Create an adapter factory that yields item providers.
        _adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
        _adapterFactory.addAdapterFactory(new FcoreResourceItemProviderAdapterFactory());
        _adapterFactory.addAdapterFactory(new FprodItemProviderAdapterFactory());
        _adapterFactory.addAdapterFactory(new FcoreItemProviderAdapterFactory());
        _adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getContentProvider()
     */
    @Override
    protected IContentProvider getContentProvider() {
        return new AdapterFactoryContentProvider(_adapterFactory);
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getLabelProvider()
     */
    @Override
    protected ILabelProvider getLabelProvider() {
        return new LabelProvider() {

            ILabelProvider _labelProvider = new AdapterFactoryLabelProvider(_adapterFactory);

            @Override
            public String getText(Object object) {
                return _labelProvider.getText(object);
            }

            @Override
            public Image getImage(Object object) {
                return _labelProvider.getImage(object);
            }
        };
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getDialogSettingsId()
     */
    @Override
    protected String getDialogSettingsId() {
        return SETTINGS_ID;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getViewerInput()
     */
    @Override
    protected Object getViewerInput() {
        return new ItemProvider(_adapterFactory, _contracts);
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#getViewerLabel()
     */
    @Override
    protected String getViewerLabel() {
        return ModelEditorMessages.InvokeActivityWizard_Contract_select;
    }

    /**
     * Returns the list of initial element selections.
     * 
     * @return List
     */
    @Override
    protected List<?> getInitialElementSelections() {
        return _contracts;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog# addViewerListeners(org.eclipse.jface.viewers.StructuredViewer)
     */
    @Override
    protected void addViewerListeners(StructuredViewer viewer) {
        // Override to remove listener that affects the ok button
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.egf.core.ui.dialogs.AbstractCheckboxSelectionDialog#isValid()
     */
    @Override
    protected boolean isValid() {
        return true;
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
     * Hack to use a dialog in a wizard page
     * 
     * @return Control
     * 
     */
    public Control createPage(Composite parent) {
        return dialogArea = createDialogArea(parent);
    }

    public void setContracts(List<Contract> contracts) {
        if (contracts == null) {
            _contracts = new ArrayList<Contract>();
        } else {
            _contracts = contracts;
        }
        initializeControls();
    }

}
