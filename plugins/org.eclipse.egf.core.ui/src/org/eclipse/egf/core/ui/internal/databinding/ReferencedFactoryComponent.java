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

import org.eclipse.egf.model.FactoryComponent;

/**
 * Class to support a reference to an {@link FactoryComponent}.
 * @author fournier
 */
public class ReferencedFactoryComponent extends AbstractDataBindingType {
  /**
   * Property used to create data binding with this object.
   */
  public static final String PROPERTY_NAME = "name"; //$NON-NLS-1$
  /**
   * Store the name of the referenced factory component.
   */
  private String _name;

  /**
   * Constructor.
   * @param name of the referenced factory component.
   */
  public ReferencedFactoryComponent(String name_p) {
    _name = name_p;
  }

  /**
   * Return the name of the referenced factory component.
   * @return
   */
  public String getName() {
    return _name;
  }

  /**
   * Set the name of the referenced factory component to given one.
   * @param name_p
   */
  public void setName(String name_p) {
    _name = name_p;
  }
}