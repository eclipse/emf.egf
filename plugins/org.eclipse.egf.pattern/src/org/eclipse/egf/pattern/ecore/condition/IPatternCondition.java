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
 * Pattern condition interface.<br>
 * Defines a static condition that the pattern parameters should meet so as to select elements for pattern matching.<br>
 * The parameters instances that meet this condition at runtime are selected as potential entries for the pattern matching.<br>
 * <b>Internal purpose only.</b><br>
 * The pattern framework automatically creates a new Java class implementing this interface for each new pattern that requires
 * a condition between its parameters. The pattern developer is then asked to fill the generated 'check' method content for the condition
 * definition. The framework automatically generates the content of the {@link #check(Object...)} method, pointing to the check
 * method filled by the developer.<br>
 * Eventually, there is to be a merge when pattern parameters have changed between existing check code and new check method signature.
 * @author brocard
 */
public interface IPatternCondition {
  
  /**
   * Check that given parameters meet the pattern condition.<br>
   * The pattern condition is not supposed to be accessed from the Java code.<br>
   * Instead use the pattern ui to get full details about the condition.
   * @param parameters_p
   * @return
   */
  public boolean check(Object... parameters_p);

  /**
   * Set production context available for this condition.
   * @param context_p the context to use as available one. <code>null</code> if none.
   */
  public void setContext(ProductionContext context_p);
  
}
