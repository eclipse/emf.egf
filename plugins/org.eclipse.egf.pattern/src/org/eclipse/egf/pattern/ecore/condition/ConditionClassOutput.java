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

/**
 * Container for the generated output.
 * @author Guillaume Brocard
 */
public class ConditionClassOutput {
  
  /**
   * Shared instance.
   */
  private static ConditionClassOutput __shared;
  
  /**
   * Generated condition class content.
   */
  private String _generatedConditionClassContent;
  
  /**
   * Pattern that should own the result.
   */
  private String _patternFullId;

  /**
   * Constructor.
   */
  private ConditionClassOutput() {
    __shared = this;
  }

  /**
   * Get shared instance at the time of calling.
   * @return
   */
  public static ConditionClassOutput getSharedInstance() {
    if (null == __shared) {
      __shared = new ConditionClassOutput();
    }
    return __shared;
  }

  /**
   * Reset stored values.
   */
  public void reset() {
    _generatedConditionClassContent = null;
    _patternFullId = null;
  }

  /**
   * Get generated condition class content.
   * @param patternFullId_p Identified owner of the result.
   * @return null if there is no result for identified pattern.
   */
  public String getGeneratedConditionClassContent(String patternFullId_p) {
    if (patternFullId_p == null || patternFullId_p.equals(_patternFullId) == false) {
      return null;
    }
    return _generatedConditionClassContent;
  }

  /**
   * Set generated condition class content for identified pattern.
   * @param generatedConditionClassContent_p
   * @param patternFullId_p
   */
  public void setGeneratedConditionClassContent(String generatedConditionClassContent_p, String patternFullId_p) {
    _patternFullId = patternFullId_p;
    _generatedConditionClassContent = generatedConditionClassContent_p;
  }
  
}
