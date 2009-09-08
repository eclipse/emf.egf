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
package org.eclipse.egf.core.ui.data.listener;

import org.eclipse.egf.core.ui.data.explorer.FactoryComponentWorkingSet;
import org.eclipse.jface.util.PropertyChangeEvent;


/**
 * Interface to implement listeners that observe factory component working sets in the workspace.
 * @author Guillaume Brocard
 */
public interface IWorkingSetListener {
  /**
   * Called when working set label changes.
   * @param workingSet_p
   * @param event_p
   */
  public void workingSetLabelChanged(FactoryComponentWorkingSet workingSet_p, PropertyChangeEvent event_p);

  /**
   * Called when working set name changes.
   * @param workingSet_p
   * @param event_p
   */
  public void workingSetNameChanged(FactoryComponentWorkingSet workingSet_p, PropertyChangeEvent event_p);

  /**
   * Called when a working set is added.
   * @param workingSet_p
   * @param event_p
   */
  public void workingSetAdded(FactoryComponentWorkingSet workingSet_p, PropertyChangeEvent event_p);

  /**
   * Called when a working set is removed
   * @param workingSet_p
   * @param event_p
   */
  public void workingSetRemoved(FactoryComponentWorkingSet workingSet_p, PropertyChangeEvent event_p);

  /**
   * Called when a working set content changes.
   * @param workingSet_p
   * @param event_p
   */
  public void workingSetContentChanged(FactoryComponentWorkingSet workingSet_p, PropertyChangeEvent event_p);

  /**
   * Called when working sets are modified from the Package Explorer.
   * @param event_p
   */
  public void workingSetModelChanged(PropertyChangeEvent event_p);
}
