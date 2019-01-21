/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools.ui.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.portfolio.genchain.tools.ui.Messages;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * @author Thomas Guiu
 * 
 */
public class NewFilePage extends WizardNewFileCreationPage {

    private static final String FILE_EXTENSION = "generationchain";//$NON-NLS-1$

    public NewFilePage(String pageName, IStructuredSelection selection) {
        super(pageName, selection);
        setFileName("My.generationchain");//$NON-NLS-1$
    }

    public IFile getModelFile() {
        return ResourcesPlugin.getWorkspace().getRoot().getFile(getContainerFullPath().append(getFileName()));
    }

    public void createControl(Composite parent) {
        super.createControl(parent);
        validatePage();
    }

    @Override
    protected boolean validatePage() {
        if (super.validatePage()) {
            String extension = new Path(getFileName()).getFileExtension();
            if (extension == null || !FILE_EXTENSION.equals(extension)) {
                setErrorMessage(Messages.bind(Messages.genchain_wizard_extension_error, FILE_EXTENSION));
                return false;
            }
            return true;
        }
        return false;
    }

}
