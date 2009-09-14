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
package org.eclipse.egf.pattern.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.pde.pattern.reader.WorkspacePatternExtensionReader;

public class PatternRegistry {
  
  public static Map<String, IDescriptor> getPatterns(IProject project_p) {
    // Check
    if (project_p == null) {
      return null;
    }
    Map<String, IDescriptor> patterns = new HashMap<String, IDescriptor>();
    // Load root descriptor           
    IDescriptor rootDescriptor = new WorkspacePatternExtensionReader().getPatternLibraries(project_p);
    if (rootDescriptor != null) {
      // Load available patterns in this project
      getPatterns(patterns, rootDescriptor);
    }
    return patterns;
  }
  
  private static void getPatterns(Map<String, IDescriptor> patterns_p, IDescriptor descriptor_p) {
    // Check
    if (patterns_p == null || descriptor_p == null) {
      return;
    }
    // Pattern Type
    if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_PATTERN.equals(descriptor_p.getValue(IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE))) {
      // Pattern analysis
      String shortID = (String) descriptor_p.getValue(ExtensionPointHelper.ATT_ID);
      if (shortID != null && shortID.trim().length() > 0) {
        patterns_p.put(shortID, descriptor_p);
      }
    } else {
      // Children analysis
      for (IDescriptor childDescriptor : descriptor_p.getChildren()) {
        getPatterns(patterns_p, childDescriptor);
      }      
    }
    return;
  }  

}
