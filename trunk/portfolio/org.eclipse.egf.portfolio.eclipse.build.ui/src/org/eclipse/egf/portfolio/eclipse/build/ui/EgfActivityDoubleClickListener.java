/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *
 * </copyright>
 */

package org.eclipse.egf.portfolio.eclipse.build.ui;

import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.presentation.BuildCoreEditorPlugin;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfActivity;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PartInitException;

/**
 * @author Matthieu Helleboid
 * 
 */
public class EgfActivityDoubleClickListener implements IDoubleClickListener {

	public void doubleClick(DoubleClickEvent event) {
		if (event.getSelection().isEmpty()) {
			return;
		}

		final Object object = ((IStructuredSelection) event.getSelection())
				.getFirstElement();
		if (object instanceof EgfActivity) {
			EgfActivity egfActivity = (EgfActivity) object;
			try {
				EditorHelper.openEditor(URI.createURI(egfActivity.getUri()));
			} catch (PartInitException e) {
				BuildCoreEditorPlugin.getPlugin().log(e);
			}
		}

	}

}
