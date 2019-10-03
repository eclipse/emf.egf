/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.eclipse.build.ui;

import org.eclipse.egf.model.editor.dialogs.ActivitySelectionDialog;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * @author Matthieu Helleboid
 * 
 */
public class BuildcoreAdapterFactoryContentProvider extends AdapterFactoryContentProvider {

	public BuildcoreAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public IPropertySource getPropertySource(Object object) {
		return super.getPropertySource(object);
	}

	@Override
	protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
		if (object instanceof EgfActivity) {
			final EgfActivity egfActivity = (EgfActivity) object;
			final String uriString = egfActivity.getUri();

			return new PropertySource(object, itemPropertySource) {
				@Override
				protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
					return new PropertyDescriptor(object, itemPropertyDescriptor) {
						@Override
						public CellEditor createPropertyEditor(Composite composite) {
							return new ExtendedDialogCellEditor(composite, getLabelProvider()) {

								@Override
								protected Object openDialogBox(Control control) {
									ActivitySelectionDialog dialog = new ActivitySelectionDialog(control.getShell(), false);
									
									if (dialog.open() == Window.OK) {
										Object result = dialog.getFirstResult();
										if (result != null && result instanceof Activity) {
											URI uri = EcoreUtil.getURI(((Activity) result));
											return uri.toString();
										}
									}
									
									return uriString;
								}
							};
						}
					};
				}
			};
		}

		return super.createPropertySource(object, itemPropertySource);
	}
}
