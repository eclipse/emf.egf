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
package org.eclipse.egf.pattern.validation;

import org.eclipse.egf.pattern.Pattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;


/**
 * Pattern validator delegated implementation.
 * @author Guillaume Brocard
 */
public class PatternDelegatedValidator {
  
  /**
   * Validated instance of the model.
   */
  private Pattern _pattern;

  /**
   * Constructor.
   * @param pattern_p Pattern model instance to validate.
   */
  public PatternDelegatedValidator(Pattern pattern_p) {
    _pattern = pattern_p;
  }

  /**
   * Is parent name conflicting with pattern one ?
   * @return
   */
  public boolean parentNameCollision() {
    boolean result = false;
    // Get parents.
    EList<EClass> parents = _pattern.getESuperTypes();
    // No parent, so no collision.
    if (parents.isEmpty()) {
      return result;
    }
    // Find parent pattern.
    Pattern parentPattern = null;
    for (EClass parent : parents) {
      if (parent instanceof Pattern) {
        parentPattern = (Pattern) parent;
        break;
      }
    }
    // Still no parent, and still no collision.
    if (null == parentPattern) {
      return result;
    }
    // Pattern generated class name.
    String patternClassName = _pattern.getName();
    // Parent pattern generated class name.
    String parentPatternName = parentPattern.getName();
    result = (null != patternClassName) && patternClassName.equals(parentPatternName);
    return result;
  }
  
}
