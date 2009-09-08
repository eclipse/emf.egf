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
package org.eclipse.egf.common.ui.toolkit.fields;

import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * This implementation customized the one provided by org.eclipse.jface.preference package.
 * @author fournier
 */
public class CRadioGroupFieldEditor extends RadioGroupFieldEditor {
  
  /**
   * Value of the selected radio button.
   */
  protected Object _selectedRadioButtonValue;
  
  /**
   * Parent of the radio button group.
   */
  private Composite _parent;
  
  /**
   * Use a group ?
   */
  private boolean _useGroup;   

  /**
   * Constructor.
   * @param name_p
   * @param labelText_p
   * @param numColumns_p
   * @param labelAndValues_p
   * @param parent_p
   * @param readOnly_p 
   */
  public CRadioGroupFieldEditor(
    String name_p, 
    String labelText_p, 
    int numColumns_p, 
    String[][] labelAndValues_p, 
    Composite parent_p
  ) {
    super(name_p, labelText_p, numColumns_p, labelAndValues_p, parent_p);
    initialize(parent_p, false);
  }

  /**
   * Constructor.
   * @param name_p
   * @param labelText_p
   * @param numColumns_p
   * @param labelAndValues_p
   * @param parent_p
   * @param useGroup_p
   */
  public CRadioGroupFieldEditor(
    String name_p, 
    String labelText_p, 
    int numColumns_p, 
    String[][] labelAndValues_p, 
    Composite parent_p, 
    boolean useGroup_p
  ) {
    super(name_p, labelText_p, numColumns_p, labelAndValues_p, parent_p, useGroup_p);
    initialize(parent_p, useGroup_p);
  }

  /**
   * Initialize a listener to be aware of selection changes.
   */
  private void initialize(Composite parent_p, boolean useGroup_p) {
    setPropertyChangeListener(
      new IPropertyChangeListener() {
        /**
         * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
         */
        public void propertyChange(PropertyChangeEvent event_p) {
          _selectedRadioButtonValue = event_p.getNewValue();
        }
      }
    );
    // Store the parent.
    _parent = parent_p;
    // Store the use group
    _useGroup = useGroup_p;
  }

  /**
   * Select a radio value depending on given radio button value.
   * @param value_p
   */
  public void selectRadioButtonFor(Object value_p) {
    // Precondition
    if (null == value_p) {
      return;
    }
    // Get the composite used to store radio buttons.
    Composite radioButtonGroup = getRadioBoxControl(_parent);
    // Get contained radio buttons.
    Control[] buttons = radioButtonGroup.getChildren();
    // Loop over contained buttons
    for (Control control : buttons) {
      Button radioButton = (Button) control;
      // Get the related value for current radio button.
      Object radioButtonValue = radioButton.getData();
      if (value_p.equals(radioButtonValue)) {
        // Select the UI button.
        radioButton.setSelection(true);
        // Set the radio button data as the selected radio button data.
        _selectedRadioButtonValue = radioButtonValue;
      } else {
        radioButton.setSelection(false);
      }
    }
  }

  /**
   * Return the value of the selected radio button.
   * @return a not null value.
   */
  public Object getSelectedRadioButton() {
    return _selectedRadioButtonValue;
  }

  /**
   * @see org.eclipse.jface.preference.RadioGroupFieldEditor#doFillIntoGrid(org.eclipse.swt.widgets.Composite, int)
   */
  @Override
  protected void doFillIntoGrid(Composite parent, int numColumns) {
    if (_useGroup) {
      Control control = getRadioBoxControl(parent);
      GridData gd = new GridData();
      gd.horizontalAlignment = SWT.FILL;
      gd.horizontalSpan = numColumns;
      control.setLayoutData(gd);
    } else {
      super.doFillIntoGrid(parent, numColumns);
    }
  }
  
}
