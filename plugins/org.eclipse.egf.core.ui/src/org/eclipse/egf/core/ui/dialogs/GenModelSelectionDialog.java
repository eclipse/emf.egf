/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *
 * </copyright>
 * 
 */
package org.eclipse.egf.core.ui.dialogs;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;

import org.eclipse.egf.core.ui.viewers.GenModelViewerFilter;


/**
 * @author Xavier Maysonnave
 */
public class GenModelSelectionDialog extends WorkspaceResourceDialog {
  
  public GenModelSelectionDialog(Shell parent) {
    super(parent, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
    setAllowMultiple(false);
    setTitle(Messages._UI_SelectGenModel_message);
    addFilter(createDefaultViewerFilter(true));
    addFilter(new GenModelViewerFilter());    
    loadContents();
  }

}
