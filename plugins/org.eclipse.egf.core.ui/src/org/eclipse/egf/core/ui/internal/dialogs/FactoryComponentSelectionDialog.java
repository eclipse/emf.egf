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
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.swt.widgets.Shell;


/**
 * A class to select factory components from either the eclipse platform or the current workspace.
 * @author Guillaume Brocard
 */
public class FactoryComponentSelectionDialog extends ModelElementSelectionDialog {
  
  /**
   * Reference to a filtered factory component.
   */
  private List<FactoryComponent> _filteredFactoryComponents;

  /**
   * Constructor.
   * @param parent_p
   */
  public FactoryComponentSelectionDialog(Shell parent_p) {
    super(parent_p);
    setTitle(Messages.FactoryComponentSelectionDialog_Title);
    setMessage(Messages.FactoryComponentSelectionDialog_Message);
    setMultipleSelection(false);
  }

  /**
   * Set given factory component as filtered and non displayed in the dialog.
   * @param filteredFactoryComponents_p
   */
  public void setFilteredFactoryComponents(List<FactoryComponent> filteredFactoryComponents_p) {
    _filteredFactoryComponents = filteredFactoryComponents_p;
  }

  /**
   * @see org.eclipse.ui.dialogs.AbstractElementListSelectionDialog#setListElements(java.lang.Object[])
   */
  @Override
  protected void setListElements(Object[] elements_p) {
    List<FactoryComponent> allFactoryComponents = getInitialInput();
    // Remove filtered factory components.
    if (_filteredFactoryComponents != null) {
      allFactoryComponents.removeAll(_filteredFactoryComponents);
    }
    // Set the factory component array.
    super.setListElements(allFactoryComponents.toArray());
  }

  /**
   * Return the initial factory components.<br>
   * Default implementation returns a list containing all factory components located in both workspace and target platform.
   * @return a not null list.
   */
  protected List<FactoryComponent> getInitialInput() {
    // Get factory components from both workspace and target platform.
    return EgfUiActivator.getDefault().getAllFactoryComponents();
  }
  
}