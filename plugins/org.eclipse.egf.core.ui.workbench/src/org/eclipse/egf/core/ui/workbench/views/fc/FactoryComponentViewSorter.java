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
package org.eclipse.egf.core.ui.workbench.views.fc;

import java.text.Collator;

import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;


/**
 * Implements a sorting strategy to display named model elements in the right order in a tree viewer.
 * @author fournier
 */
public class FactoryComponentViewSorter extends ViewerSorter {
  /**
   * Constructor.
   */
  public FactoryComponentViewSorter() {
    // Do nothing.
  }

  /**
   * Constructor.
   * @param collator_p
   */
  public FactoryComponentViewSorter(Collator collator_p) {
    super(collator_p);
  }

  /**
   * Constructor.
   * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(Viewer viewer_p, Object object1_p, Object object2_p) {
    int result = 0;
    // Preconditions
    if (!(object1_p instanceof NamedModelElementWithId) || !(object2_p instanceof NamedModelElementWithId)) {
      result = super.compare(viewer_p, object1_p, object2_p);
    } else {
      // getSortingPriority
      int value1 = CoreActivator.getDefault().getSortingPriority((NamedModelElementWithId) object1_p);
      int value2 = CoreActivator.getDefault().getSortingPriority((NamedModelElementWithId) object2_p);
      result = value1 - value2;
    }
    return result;
  }
}
