/**
 * <copyright>
 * 
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
 * 
 * </copyright>
 */
package org.eclipse.egf.portfolio.task.ant.ui.contributions;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.ui.dialogs.ResourcesSelectionDialog;
import org.eclipse.egf.portfolio.task.ant.Activator;
import org.eclipse.egf.portfolio.task.ant.ui.Messages;
import org.eclipse.egf.task.ui.contributions.AbstractTaskEditorContributor;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author xiaoru chen
 * 
 */
public class TaskAntEditorContributor extends AbstractTaskEditorContributor {

    public static String FILE_EXTENSION_ANT = "xml"; //$NON-NLS-1$

    private static final String SCHEME_PLATFORM_PLUGIN = "platform:/plugin";

    public TaskAntEditorContributor() {
        super(Activator.KIND_ANT);
    }

    @Override
    public CellEditor createPropertyEditor(Composite composite, Object object, IItemPropertyDescriptor descriptor) {
        return createRubyPropertyEditor(composite, object, descriptor);
    }

    private CellEditor createRubyPropertyEditor(final Composite composite, Object object, IItemPropertyDescriptor descriptor) {
        final String value = getValue(object);

        final Resource resource = ((EObject) object).eResource();

        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {

            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                IProject project = EMFHelper.getProject(resource);
                if (project == null) {
                    return value;
                }
                IContainer root = ResourcesPlugin.getWorkspace().getRoot();
                ResourcesSelectionDialog dialog = new ResourcesSelectionDialog(composite.getShell(), false, root, 1, FILE_EXTENSION_ANT);
                dialog.setTitle(NLS.bind(Messages._UI_SelectAntResource, "")); //$NON-NLS-1$
                if (dialog.open() == IDialogConstants.OK_ID) {
                    final Object[] result = dialog.getResult();
                    IFile file = (IFile) result[0];
                    IPath path = file.getFullPath();
                    URI platformURI = URI.createURI(SCHEME_PLATFORM_PLUGIN + path.toString());
                    return platformURI.toString();
                }
                return value;
            }
        };
    }

}
