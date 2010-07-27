/**
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
 */

package org.eclipse.egf.task.ui.contributions;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.ui.dialogs.ResourcesSelectionDialog;
import org.eclipse.egf.task.EGFTaskPlugin;
import org.eclipse.egf.task.ui.l10n.EGFTaskUIMessages;
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
public class TaskRubyEditorContributor extends AbstractTaskEditorContributor {

    public static String FILE_EXTENSION_RUBY = "rb"; //$NON-NLS-1$

    private static final String SCHEME_PLATFORM_PLUGIN = "platform:/plugin";

    public TaskRubyEditorContributor() {
        super(EGFTaskPlugin.KIND_RUBY);
    }

    @Override
    public CellEditor createPropertyEditor(Composite composite, Object object, IItemPropertyDescriptor descriptor) {
        return createRubyPropertyEditor(composite, object, descriptor);
    }

    public CellEditor createRubyPropertyEditor(final Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final String value = getValue(object);

        final Resource resource = ((EObject) object).eResource();

        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {

            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                IProject project = EMFHelper.getProject(resource);
                if (project == null) {
                    return value;
                }
                //TODO in a perfect world we would need a dialog to choose file from the runtime too.
                IContainer root = (IContainer) ResourcesPlugin.getWorkspace().getRoot();
                ResourcesSelectionDialog dialog = new ResourcesSelectionDialog(composite.getShell(), false, root, 1, FILE_EXTENSION_RUBY);
                dialog.setTitle(NLS.bind(EGFTaskUIMessages._UI_SelectRubyResource, "")); //$NON-NLS-1$
                if (dialog.open() == IDialogConstants.OK_ID) {
                    final Object[] result = dialog.getResult();
                    IFile file = (IFile) result[0];
                    IPath path = file.getFullPath();
                    URI platformURI = URI.createURI(SCHEME_PLATFORM_PLUGIN + path.toString());
                    return platformURI.toString();
                } else {
                    return value;
                }
            }
        };
    }
}
