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
package org.eclipse.egf.core.ui.dialogs;

import java.util.Arrays;

import org.eclipse.egf.common.helper.CollectionHelper;
import org.eclipse.egf.common.ui.EGFCommonUIPlugin;
import org.eclipse.egf.common.ui.ICommonUIImages;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TargetPlatformPackageDialog extends ElementListSelectionDialog {

    public TargetPlatformPackageDialog(Shell parent, boolean multi) {

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

        setMultipleSelection(multi);
        setMessage(CoreUIMessages._UI_SelectRegisteredPackageURI);
        setFilter("*"); //$NON-NLS-1$
        setTitle(CoreUIMessages._UI_RegisteredPackageSelection_label);

    }

    protected void updateElements() {
        IPlatformGenModel[] elements = EGFCorePlugin.getPlatformGenModels();
        Arrays.sort(elements);
        setListElements(elements);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite result = (Composite) super.createDialogArea(parent);
        updateElements();
        return result;
    }

    public IPlatformGenModel[] getSelectedPlatformGenModels() {
        Object[] objects = getResult();
        if (objects != null) {
            return CollectionHelper.toArray(Arrays.asList(objects), IPlatformGenModel.class);
        }
        return null;
    }

}
