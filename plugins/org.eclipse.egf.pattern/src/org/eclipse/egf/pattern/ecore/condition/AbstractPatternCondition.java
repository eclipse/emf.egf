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
package org.eclipse.egf.pattern.ecore.condition;

import org.eclipse.egf.core.context.ProductionContext;

/**
 * A default root implementation that provides a context to the condition class real implementation.
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternCondition implements IPatternCondition {
  
  /**
   * The production context reference.
   */
  private ProductionContext _context;

  /**
   * @see org.eclipse.egf.pattern.ecore.condition.IPatternCondition#setContext(org.eclipse.egf.core.context.ProductionContext)
   */
  public void setContext(ProductionContext context_p) {
    _context = context_p;
  }

  /**
   * Get available production context.
   * @return <code>null</code> if none is available.
   */
  protected ProductionContext getContext() {
    return _context;
  }
  
}
