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
package org.eclipse.egf.pattern.production.jet;

/**
 * Default jet produced template skeleton.<br>
 * Note that the argument name is unchanged due to EMF compatibility issues.
 * @author Guillaume Brocard
 */
public interface IGenerator {
  
  /**
   * Apply template generation, and get result as a {@link String}.
   * @param argument
   * @return
   */
  public String generate(Object argument);
  
}
