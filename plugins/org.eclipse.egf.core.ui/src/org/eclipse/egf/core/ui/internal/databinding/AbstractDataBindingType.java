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
package org.eclipse.egf.core.ui.internal.databinding;

import java.beans.PropertyChangeListener;

/**
 * Base type to implement Type involved in JFace data binding through BeansObservables.<br>
 * Provides 2 methods to prevent from errors raised by the data binding framework due to sub-classes are not real JavaBean Types.
 * @author Guillaume Brocard
 */
public abstract class AbstractDataBindingType {
  /**
   * Do nothing.
   */
  public void addPropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p) {
    // Do nothing.
  }

  /**
   * Do nothing.
   */
  public void removePropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p) {
    // Do nothing.
  }
}
