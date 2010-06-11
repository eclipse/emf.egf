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

import java.util.Arrays;

import org.eclipse.egf.common.ui.EGFCommonUIPlugin;
import org.eclipse.egf.common.ui.ICommonUIImages;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @author Xavier Maysonnave
 * 
 */
public class PlatformPackageDialog extends ElementListSelectionDialog {

    protected boolean isTarget = true;

    public PlatformPackageDialog(Shell parent) {
        super(parent, new LabelProvider() {

            @Override
            public String getText(Object element) {
                if (element == null || element instanceof IPlatformGenModel == false) {
                    return element == null ? "" : element.toString();//$NON-NLS-1$
                }
                return ((IPlatformGenModel) element).getURI().toString();
            }

            @Override
            public Image getImage(Object element) {
                return EGFCommonUIPlugin.getDefault().getImage(ICommonUIImages.EPACKAGE_IMAGE_PATH);
            }

        });

        setMultipleSelection(true);
        setMessage(CoreUIMessages._UI_SelectRegisteredPackageURI);
        setFilter("*"); //$NON-NLS-1$
        setTitle(CoreUIMessages._UI_RegisteredPackageSelection_label);
    }

    public boolean isTarget() {
        return isTarget;
    }

    protected void updateElements() {
        Object[] result = null;
        if (isTarget) {
            result = EGFCorePlugin.getPlatformGenModels();
        } else {
            result = EPackage.Registry.INSTANCE.keySet().toArray(new Object[EPackage.Registry.INSTANCE.size()]);
        }
        Arrays.sort(result);
        setListElements(result);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite result = (Composite) super.createDialogArea(parent);
        Composite buttonGroup = new Composite(result, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        buttonGroup.setLayout(layout);
        final Button targetButton = new Button(buttonGroup, SWT.RADIO);
        targetButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent event) {
                isTarget = targetButton.getSelection();
                updateElements();
            }

        });
        targetButton.setText(CoreUIMessages._UI_TargetPlatform_label);
        Button runtimeTimeVersionButton = new Button(buttonGroup, SWT.RADIO);
        runtimeTimeVersionButton.setText(CoreUIMessages._UI_RuntimeVersion_label);
        targetButton.setSelection(true);
        updateElements();
        return result;
    }

}
