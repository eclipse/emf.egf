/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.model.editor.contributions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.core.ui.dialogs.TypeSelectionDialog;
import org.eclipse.egf.model.editor.EGFModelEditorPlugin;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.types.TypeClass;
import org.eclipse.egf.model.types.TypesPackage;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

/**
 * @author Xavier Maysonnave
 * 
 */
public class TypeClassEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        // It should be a TypeClass in a non null resource
        if (object instanceof TypeClass == false || ((TypeClass) object).eResource() == null) {
            return false;
        }
        // Check applicable Feature
        if (checkFeature(object, descriptor, TypesPackage.Literals.TYPE_ABSTRACT_CLASS__VALUE) && (((TypeClass) object).eContainer() instanceof Contract || ((TypeClass) object).eContainer() instanceof OrchestrationParameter)) {
            return true;
        }
        return false;
    }

    public CellEditor createPropertyEditor(final Composite composite, final Object object, IItemPropertyDescriptor descriptor) {

        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {

            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                // Current TypeClass
                TypeClass typeClass = (TypeClass) object;
                // IProject lookup
                IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(typeClass.eResource().getURI().segment(1));
                if (project == null) {
                    return null;
                }
                // IJavaProject lookup
                IJavaProject javaProject = null;
                try {
                    if (project.isAccessible() && project.hasNature(JavaCore.NATURE_ID)) {
                        javaProject = JavaCore.create(project);
                    }
                } catch (CoreException ce) {
                    ThrowableHandler.handleThrowable(EGFModelEditorPlugin.getPlugin().getSymbolicName(), ce);
                    return null;
                }
                if (javaProject == null) {
                    return null;
                }
                // Dialog
                try {
                    TypeSelectionDialog dialog = new TypeSelectionDialog(composite.getShell(), false, PlatformUI.getWorkbench().getProgressService(), javaProject, IJavaSearchConstants.CLASS_AND_INTERFACE);
                    if (dialog.open() != IDialogConstants.OK_ID) {
                        return null;
                    }
                    Object innerResult = dialog.getFirstResult();
                    if (innerResult instanceof IType) {
                        return ((IType) innerResult).getFullyQualifiedName();
                    }
                } finally {
                    try {
                        javaProject.close();
                    } catch (JavaModelException jme) {
                        // Ignore
                    }
                }
                return null;
            }

        };

    }
}
