/**
 * <copyright>
 * 
 * Copyright (c) 2002-2007 IBM Corporation and others.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * Xavier Maysonnave - Thales Corporate Services S.A.S - Target Platform contribution
 * 
 * </copyright>
 * 
 * $Id: EcoreActionBarContributor.java,v 1.19 2008/12/22 14:25:27 emerks Exp $
 */
package org.eclipse.emf.ecore.presentation;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.ui.dialogs.TargetPlatformEcoreDialog;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * This is the action bar contributor for the Ecore model editor.
 */
public class TargetPlatformEcoreActionBarContributor extends EcoreActionBarContributor {

    public static class ExtendedTargetPlatformLoadResourceAction extends LoadResourceAction {

        @Override
        public void run() {
            Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
            ExtendedTargetPlatformEcoreDialog loadResourceDialog = new ExtendedTargetPlatformEcoreDialog(shell, domain);
            if (loadResourceDialog.open() == Window.OK && loadResourceDialog.getRegisteredPackages().isEmpty() == false) {
                String source = EcoreEditorPlugin.INSTANCE.getSymbolicName();
                BasicDiagnostic diagnosic = new BasicDiagnostic(Diagnostic.INFO, source, 0, EcoreEditorPlugin.INSTANCE.getString("_UI_RuntimePackageDetail_message"), null); //$NON-NLS-1$
                for (EPackage ePackage : loadResourceDialog.getRegisteredPackages()) {
                    diagnosic.add(new BasicDiagnostic(Diagnostic.INFO, source, 0, ePackage.getNsURI(), null));
                }
                new DiagnosticDialog(shell, EcoreEditorPlugin.INSTANCE.getString("_UI_Information_title"), EcoreEditorPlugin.INSTANCE.getString("_UI_RuntimePackageHeader_message"), diagnosic, Diagnostic.INFO).open(); //$NON-NLS-1$  //$NON-NLS-2$
            }
        }

    }

    public static class ExtendedTargetPlatformEcoreDialog extends TargetPlatformEcoreDialog {

        protected Set<EPackage> registeredPackages = new LinkedHashSet<EPackage>();

        public ExtendedTargetPlatformEcoreDialog(Shell parent, EditingDomain domain) {
            super(parent, domain);
        }

        @Override
        protected boolean processResource(Resource resource) {
            // Put all static package in the package registry.
            //
            ResourceSet resourceSet = _domain.getResourceSet();
            if (resourceSet.getResources().contains(resource) == false) {
                Registry packageRegistry = resourceSet.getPackageRegistry();
                if (packageRegistry != null) {
                    for (EPackage ePackage : EMFHelper.getAllPackages(resource)) {
                        packageRegistry.put(ePackage.getNsURI(), ePackage);
                        registeredPackages.add(ePackage);
                    }
                }
            }
            return true;
        }

        public Set<EPackage> getRegisteredPackages() {
            return registeredPackages;
        }
    }

    /**
     * This creates an instance of the contributor.
     */
    public TargetPlatformEcoreActionBarContributor() {
        super();
        loadResourceAction = new ExtendedTargetPlatformLoadResourceAction();
    }

}
