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
package org.eclipse.egf.core.context;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.egf.common.constant.ICommonConstants;


/**
 * @author fournier
 */
public class ProductionContext {
  /**
   * Map of <String, Object> that defines a context.
   */
  private Map<String, Object> _values;

  /**
   * Constructor.
   */
  public ProductionContext() {
    initializeValues();
  }

  /**
   * Constructor. Use given context to initialize internal map values.<br>
   * Thus new context contains at least all given one values (as accessible at construction time).
   * @param productionContext_p
   */
  public ProductionContext(ProductionContext productionContext_p) {
    if (null != productionContext_p) {
      _values = productionContext_p.getValues();
    } else {
      initializeValues();
    }
  }

  /**
   * Add a new context element.
   * @param name_p
   * @param value_p
   * @param fcId_p
   * Equivalent to {@link #addContextElement(String, Object, String, boolean)} with override set to <code>false</code>.
   */
  public void addContextElement(String name_p, Object value_p, String fcId_p) {
    addContextElement(name_p, value_p, fcId_p, false);
  }

  /**
   * Add a new context element.
   * @param name_p
   * @param value_p
   * @param fcId_p
   * @param override_p Should existing value be overridden ? <code>true</code> if so, <code>false</code> otherwise (existing value should remain unmodified).
   */
  public void addContextElement(String name_p, Object value_p, String fcId_p, boolean override_p) {
    String contextElementKey = fcId_p + ICommonConstants.SLASH_CHARACTER + name_p;
    // Make sure to avoid external context values to be overridden by the local (e.g production plan) context values.
    // Unless override was set to true.
    if (override_p || !_values.containsKey(contextElementKey)) {
      _values.put(contextElementKey, value_p);
    }
  }

  /**
   * Get context element value for given name.
   * @param name_p
   * @param fcId_p
   * @return a value or null if not found.
   */
  public Object getContextElementValue(String name_p, String fcId_p) {
    return _values.get(fcId_p + ICommonConstants.SLASH_CHARACTER + name_p);
  }

  /**
   * Initialize this with an empty map as values holder.
   */
  protected void initializeValues() {
    _values = new HashMap<String, Object>(0);
  }

  /**
   * Get a clone (shallow) copy of the values map.
   * @return
   */
  @SuppressWarnings("unchecked")
  protected Map<String, Object> getValues() {
    return (Map<String, Object>) ((HashMap<String, Object>) _values).clone();
  }
}
