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
package org.eclipse.egf.portfolio.task.jet.ui.contributions;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.portfolio.task.jet.ui.Activator;
import org.eclipse.egf.portfolio.task.jet.ui.Messages;
import org.eclipse.egf.task.ui.contributions.AbstractTaskEditorContributor;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

/**
 * 
 * @author Florian Barbin
 * 
 */
public class JetTaskEditorContributor extends AbstractTaskEditorContributor {

	public JetTaskEditorContributor() {
		super(Activator.JET_KIND);
	}

	@Override
	public CellEditor createPropertyEditor(final Composite composite,
			Object object, IItemPropertyDescriptor descriptor) {
		final String value = getValue(object);

		return new ExtendedDialogCellEditor(composite, getLabelProvider(object,
				descriptor)) {

			private String FILE_EXTENSION_JET = "jet";

			@Override
			protected Object openDialogBox(Control cellEditorWindow) {

				IContainer root = ResourcesPlugin.getWorkspace().getRoot();
				FilteredResourcesSelectionDialog dialog = new FilteredResourcesSelectionDialog(
						composite.getShell(), false, root, 1) {
					@Override
					protected ItemsFilter createFilter() {
						return new ResourceExtensionFilter();
					}

					/**
					 * Filters resources using pattern and showDerived flag. It
					 * overrides ItemsFilter.
					 */
					final class ResourceExtensionFilter extends ResourceFilter {

						@Override
						public boolean matchItem(Object item) {
							boolean match = super.matchItem(item);
							if (!match) {
								return match;
							}
							String currentExtension = ((IResource) item)
									.getFileExtension();
							return (currentExtension != null && currentExtension
									.endsWith(FILE_EXTENSION_JET));
						}

					}
				};
				dialog.setTitle(Messages._UI_SelectJetTemplate);
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
