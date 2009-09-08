/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.ui.internal.dialogs;

import java.util.List;

import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.viewers.AdaptedModelElementLabelProvider;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;


/**
 * A class to select model element objects in .
 * @author Guillaume Brocard
 */
public class ModelElementSelectionDialog extends ElementListSelectionDialog {
  
  /**
   * Constructor.<br>
   * Multiple selection is set to <code>false</code>.
   * @param parent_p
   */
  public ModelElementSelectionDialog(Shell parent_p) {
    // This dialog do not modify data, let's use the right adapter factory accordingly.
    super(parent_p, new AdaptedModelElementLabelProvider(EgfUiActivator.getDefault().getEditingDomainInReadOnly().getAdapterFactory()));
    setMultipleSelection(false);
  }

  /**
   * Sets the elements of the list.
   * @param modelElements_p the elements of the list.
   */
  public void setElements(List<? extends NamedModelElementWithId> modelElements_p) {
    setElements(modelElements_p.toArray());
  }
  
}