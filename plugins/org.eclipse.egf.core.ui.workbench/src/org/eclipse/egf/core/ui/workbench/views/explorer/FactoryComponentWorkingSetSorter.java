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
package org.eclipse.egf.core.ui.workbench.views.explorer;

import java.text.Collator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @author Guillaume Brocard
 */
public class FactoryComponentWorkingSetSorter extends ViewerSorter {
  /**
   * Constructor.
   */
  public FactoryComponentWorkingSetSorter() {
    // Do nothing.
  }

  /**
   * Constructor.
   * @param collator_p
   */
  public FactoryComponentWorkingSetSorter(Collator collator_p) {
    super(collator_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(Viewer viewer_p, Object e1_p, Object e2_p) {
    // Do not sort given objects.
    return 0;
  }
}
