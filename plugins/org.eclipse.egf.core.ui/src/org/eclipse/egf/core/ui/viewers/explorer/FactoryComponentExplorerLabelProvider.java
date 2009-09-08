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
package org.eclipse.egf.core.ui.viewers.explorer;

import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.viewers.AdaptedModelElementLabelProvider;

/**
 * Label provider for the factory components explorer view.
 * @author Guillaume Brocard
 */
public class FactoryComponentExplorerLabelProvider extends AdaptedModelElementLabelProvider {
  /**
   * Constructor.
   */
  public FactoryComponentExplorerLabelProvider() {
    super(EgfUiActivator.getDefault().getEditingDomain().getAdapterFactory());
  }
}
