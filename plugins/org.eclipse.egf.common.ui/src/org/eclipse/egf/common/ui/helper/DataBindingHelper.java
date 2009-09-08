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
package org.eclipse.egf.common.ui.helper;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;

/**
 * Data binding helper.
 * @author Guillaume Brocard
 */
public class DataBindingHelper {
  /**
   * Create data binding between given control text attribute and named property of given object (referred to as the property holder).<br>
   * Also register given value change listener for changes on named property.
   * @param control_p
   * @param propertyName_p
   * @param propertyHolder_p
   * @param listener_p
   */
  public static void bindTextToProperty(Control control_p, String propertyName_p, Object propertyHolder_p, IValueChangeListener listener_p) {
    // Create data binding.
    DataBindingContext bindingContext = new DataBindingContext();
    IObservableValue observedProperty = BeansObservables.observeValue(propertyHolder_p, propertyName_p);
    // Set listener, if any.
    if (null != listener_p) {
      observedProperty.addValueChangeListener(listener_p);
    }
    // Observe text of given control, and bind it.
    ISWTObservableValue observedText = SWTObservables.observeText(control_p, SWT.Modify);
    bindingContext.bindValue(observedText, observedProperty, null, null);
  }

  /**
   * Create data binding between given control selection state and named property of given object (referred to as the property holder).<br>
   * Also register given value change listener for changes on named property.
   * @param control_p
   * @param propertyName_p
   * @param propertyHolder_p
   * @param listener_p
   */
  public static void bindControlSelectionToProperty(Control control_p, String propertyName_p, Object propertyHolder_p, IValueChangeListener listener_p) {
    // Create data binding.
    DataBindingContext bindingContext = new DataBindingContext();
    IObservableValue observedProperty = BeansObservables.observeValue(propertyHolder_p, propertyName_p);
    // Set listener, if any.
    if (null != listener_p) {
      observedProperty.addValueChangeListener(listener_p);
    }
    // Observe text of given control, and bind it.
    ISWTObservableValue observedControl = SWTObservables.observeSelection(control_p);
    bindingContext.bindValue(observedControl, observedProperty, null, null);
  }
}
