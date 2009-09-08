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
package org.eclipse.egf.core.ui.internal.data;

import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.model.data.helper.ModelHelper;


/**
 * Provides useful services based on model elements and UI aspects.
 * @author Guillaume Brocard
 */
public class UIDataHelper {
  /**
   * Get the factory component id of a factory component from its name.
   * @param factoryComponentName_p
   * @return the factory component id or null if not found.
   */
  public static String getFactoryComponentIdFor(String factoryComponentName_p) {
    String result = null;
    FactoryComponent searchedFc = null;
    // Search in all factory components located in both workspace and target platform.
    searchedFc = ModelHelper.getFactoryComponentFrom(factoryComponentName_p, EgfUiActivator.getDefault().getAllFactoryComponents());
    // Searched factory component must be found, because it was selected from the UI.
    if (null != searchedFc) {
      result = searchedFc.getId();
    }
    return result;
  }
}