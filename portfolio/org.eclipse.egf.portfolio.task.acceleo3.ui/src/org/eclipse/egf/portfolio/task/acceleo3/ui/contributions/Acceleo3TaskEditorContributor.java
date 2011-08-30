/**
 * <copyright>
 * 
 * Copyright (c) 2011 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.portfolio.task.acceleo3.ui.contributions;

import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.portfolio.task.acceleo3.ui.Activator;
import org.eclipse.egf.portfolio.task.acceleo3.ui.Messages;
import org.eclipse.egf.task.ui.contributions.AbstractTaskEditorContributor;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * Class to contribute to implementation selection in task property view.
 * 
 * @author Florian Barbin
 * 
 */
public class Acceleo3TaskEditorContributor extends
		AbstractTaskEditorContributor {

	public Acceleo3TaskEditorContributor() {
		super(Activator.KIND_ACCELEO3);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CellEditor createPropertyEditor(Composite composite, Object object,
			IItemPropertyDescriptor descriptor) {
		return createAcceleo3PropertyEditor(composite, object, descriptor);
	}

	
	private CellEditor createAcceleo3PropertyEditor(final Composite composite,
			Object object, IItemPropertyDescriptor descriptor) {
		final String value = getValue(object);

		return new ExtendedDialogCellEditor(composite, getLabelProvider(object,
				descriptor)) {

			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				SelectionDialog dialog;
				try {
					final IType type = findType(AbstractAcceleoGenerator.class, ResourcesPlugin.getWorkspace().getRoot().getProjects());
					dialog = JavaUI.createTypeDialog(composite.getShell(),
							new ProgressMonitorDialog(composite.getShell()),
							SearchEngine.createHierarchyScope(type),
							IJavaElementSearchConstants.CONSIDER_TYPES, false);
					dialog.setTitle(NLS.bind(
							Messages._UI_SelectAcceleoGenerationClass, ""));
					if (dialog.open() == IDialogConstants.OK_ID) {
						final Object[] result = dialog.getResult();
						Object selectedClass = result[0];
						if(selectedClass instanceof IType) {
							String toReturnString = new String();
							if(((IType) selectedClass).getJavaProject() != null && ((IType) selectedClass).getJavaProject().getProject() != null)
								toReturnString += "project = " + ((IType) selectedClass).getJavaProject().getProject().getName() + "\n";
							toReturnString += "class = " + ((IType) selectedClass).getFullyQualifiedName();
							return toReturnString;
						}
					}
				} catch (JavaModelException e) {
					Activator.getDefault().logError(e);
				} catch (CoreException e) {
					Activator.getDefault().logError(e);
				}
				return value;

			}

			private IType findType(final Class<?> type, IProject[] projects) throws CoreException {
				for(IProject project : projects) {
					if (project.isOpen()) {
						IJavaProject javaProject = (IJavaProject) project.getNature(JavaCore.NATURE_ID);
						if(javaProject != null) {
							IType iType = javaProject.findType(type.getName());
							if(iType != null) {
								return iType;
							}
						}
					}
				}
				return null;
			}
		};
	}

}
