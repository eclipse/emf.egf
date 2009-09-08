/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 **/
package org.eclipse.egf.pattern.ecore;

import java.util.List;

import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.relations.ParameterRelation;


/**
 * Pattern condition helper.
 * @author Guillaume Brocard
 */
public class PatternConditionHelper {
  
  /**
   * Get all parameters for identified pattern.<br>
   * Does not look for parameters in current workspace.<br>
   * <b>Should only be used by the condition producer generated result</b>!
   * @param patternFullId_p The full id of the pattern.
   * @return null if pattern could not be found, or empty list if it does not declare any parameter.
   */
  public static List<ParameterRelation> getPatternParameters(String patternFullId_p) {
    List<ParameterRelation> result = null;
    // Ask pattern seeker to resolve path to pattern.
    List<PatternData> patternDataList = new PatternSeeker(false).getPatternsData(patternFullId_p);
    if (patternDataList.isEmpty() == false) {
      // There should be only one possible pattern data (for one pattern full id).
      PatternData patternData = patternDataList.get(0);
      result = patternData.getAllParameters();
    }
    return result;
  }
  
}
