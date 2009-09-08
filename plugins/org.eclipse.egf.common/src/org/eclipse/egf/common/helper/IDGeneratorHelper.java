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
package org.eclipse.egf.common.helper;

import org.eclipse.egf.common.constant.ICommonConstants;

/**
 * Helper to generate object unique id.
 * @author fournier
 */
public class IDGeneratorHelper {
  
  /**
   * Id suffix.
   */
  private volatile static int __idSuffix = 0;

  /**
   * Generate unique id for given object.
   * @param object_p
   * @return the not null generated unique id.
   */
  public static String generateUID(Object object_p) {
    String prefix = null;
    // If given object is not null, use it to create a prefix.
    if (object_p != null) {
      // Create prefix.
      prefix = object_p.getClass().getSimpleName();
    }
    return generatePrefixUID(prefix);
  }

  /**
   * Generate unique id using given prefix.
   * @param prefix_p
   * @return the not null generated unique id.
   */
  public static String generatePrefixUID(String prefix_p) {
    String prefix = prefix_p;
    if (prefix == null) {
      prefix = ICommonConstants.EMPTY_STRING;
    }    
    return new StringBuilder(StringHelper.replaceNonWordCharactersWithDot(prefix))
      .append(ICommonConstants.DOT_CHARACTER)
      .append(System.currentTimeMillis())
      .append(ICommonConstants.DOT_CHARACTER)
      .append(__idSuffix++)
      .toString();
  }
}
