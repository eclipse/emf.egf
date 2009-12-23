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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Helper to generate object unique id.
 * @author fournier
 */
public class IDGeneratorHelper {
  
  /**
   * Generate unique id for given EObject.
   * @param eObject_p
   * @return the not null generated unique id.
   */
  public static String generateUID(EObject eObject_p) {
    String prefix = null;
    // If given object is not null, use it to create a prefix.
    if (eObject_p != null) {
      // Create prefix.
      prefix = eObject_p.eClass().getName();
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
      .append(EcoreUtil.generateUUID())
      .toString();
  }
  
}
