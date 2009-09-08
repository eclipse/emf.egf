/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.workbench.action.explorer.create;

import org.eclipse.egf.core.ui.workbench.IImageKeys;
import org.eclipse.egf.core.ui.workbench.EgfWorkbenchActivator;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;


/**
 * Base class to implement actions that create a pattern library.
 * @author Guillaume Brocard
 */
public abstract class AbstractCreatePatternLibraryAction extends CreateModelElementAction {

  /**
   * Constructor.
   * @param shell_p
   * @param selectionProvider_p
   * @param readOnlyMode_p
   */
  protected AbstractCreatePatternLibraryAction(Shell shell_p, ISelectionProvider selectionProvider_p, boolean readOnlyMode_p) {
    super(shell_p, selectionProvider_p, readOnlyMode_p);
    setImageDescriptor(EgfWorkbenchActivator.getDefault().getImageDescriptor(IImageKeys.IMG_NEW_PATTERN_LIBRARY));
  }
}