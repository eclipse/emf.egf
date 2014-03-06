/**
 * <copyright>
 * 
 * Copyright (c) 2009-2011 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.portfolio.task.atl.ui.contributions;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.core.ui.dialogs.ResourcesSelectionDialog;
import org.eclipse.egf.portfolio.task.atl.ui.Activator;
import org.eclipse.egf.portfolio.task.atl.ui.Messages;
import org.eclipse.egf.task.ui.contributions.AbstractTaskEditorContributor;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Florian Barbin
 * 
 */

public class AtlTaskEditorContributor extends AbstractTaskEditorContributor {
	public AtlTaskEditorContributor() {
		super(Activator.KIND_ATL);
	}

	@Override
	public CellEditor createPropertyEditor(Composite composite, Object object,
			IItemPropertyDescriptor descriptor) {
		return createAtlPropertyEditor(composite, object, descriptor);
	}

	private CellEditor createAtlPropertyEditor(final Composite composite,
			Object object, IItemPropertyDescriptor descriptor) {
		final String value = getValue(object);

		return new ExtendedDialogCellEditor(composite, getLabelProvider(object,
				descriptor)) {

			private String FILE_EXTENSION_ASM = "asm";

			@Override
			protected Object openDialogBox(Control cellEditorWindow) {

				IContainer root = ResourcesPlugin.getWorkspace().getRoot();
				ResourcesSelectionDialog dialog = new ResourcesSelectionDialog(
						composite.getShell(), false, root, 1,
						FILE_EXTENSION_ASM) {

					@Override
					protected IDialogSettings getDialogSettings() {
						IDialogSettings dialogSettings = super
								.getDialogSettings();
						dialogSettings.put("ShowDerived", true);
						return dialogSettings;
					}
				};
				dialog.setTitle(NLS.bind(Messages._UI_SelectASMFIle, "")); //$NON-NLS-1$
				if (dialog.open() == IDialogConstants.OK_ID) {
					final Object[] result = dialog.getResult();
					IFile file = (IFile) result[0];
					IPath path = file.getFullPath();
					URI platformURI = URI.createPlatformResourceURI(path
							.toOSString(), true);
					return platformURI.toString();
				}
				return value;

			}
		};
	}
}
