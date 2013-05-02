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
package org.eclipse.emf.importer.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.converter.ui.OpenWizardActionDelegate;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;

/**
 * Reloads a GenModel file and the Ecore files behind it.
 * 
 * @since 2.1.0
 */
public class TargetPlatformGenModelReloadActionDelegate extends OpenWizardActionDelegate {

    @Override
    protected IWizard createWizard(IWorkbench workbench, Shell shell, IFile innerFile) {
        TargetPlatformEMFModelWizard wizard = new TargetPlatformEMFModelWizard(innerFile);
        wizard.init(workbench, new StructuredSelection(innerFile));
        return wizard;
    }

}
