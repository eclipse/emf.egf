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
package org.eclipse.egf.pattern.ui.editor.page.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler;
import org.eclipse.egf.common.descriptor.pattern.helper.PatternDescriptorStrategy;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pde.pattern.reader.PlatformPatternExtensionReader;
import org.eclipse.egf.pde.pattern.reader.WorkspacePatternExtensionReader;


/**
 * @author Guillaume Brocard
 */
public class DisplayHelper {
  
  /**
   * Default text width in chars.
   */
  public static int DEFAULT_TEXT_WIDTH_IN_CHARS = 60;
  
  /**
   * Default text height in chars.
   */
  public static int DEFAULT_TEXT_HEIGHT_IN_CHARS = 10;

  /**
   * Get displayable full name from given pattern or library full id.<br>
   * This method can become very costly, since it depends on the number of available pattern elements in the workspace and in the target platform.<br>
   * The time consumption is linear with the number of pattern elements.
   * @param fullId_p
   * @return
   */
  public String getPatternOrLibraryFullName(final String fullId_p) {
    String result = ICommonConstants.EMPTY_STRING;
    // Precondition.
    if (fullId_p == null) {
      return result.toString();
    }
    // Create temporary completeness structure.
    // In this map, every short id is associated with its name.
    final Map<String, String> shortIdToName = new HashMap<String, String>(0);
    // Retain the order of the short IDs.
    List<String> order = new ArrayList<String>(0);
    // Decompose the full id, initializing the map to unknown values.
    String loopId = fullId_p;
    while (loopId != null) {
      // Store previous loop id.
      String previousId = loopId;
      // Split current id.
      Couple<String, String> deresolvedId = PatternHelper.deresolveId(loopId);
      // New loop id is previous one minus trailing short id.
      loopId = deresolvedId.getKey();
      // Short id.
      String shortId = deresolvedId.getValue();
      // Store inverse order.
      order.add(shortId);
      // Initialize map with the unknown name for this short id.
      shortIdToName.put(shortId, ICommonConstants.EMPTY_STRING);
      // If loop id and previous id are the same, then the loop is over, there is no more stage.
      if (loopId.equals(previousId)) {
        loopId = null;
      }
    }
    // Should search stop now ?
    final boolean[] completed = new boolean[] { false };
    // Create root descriptor.
    GenericDescriptor rootDescriptor = new GenericDescriptor();
    // Read descriptors from workspace and platform.
    PatternDescriptorStrategy.retainRootOnly(
      rootDescriptor, 
      new WorkspacePatternExtensionReader().getPatternLibraries()
    );
    PatternDescriptorStrategy.retainRootOnly(
      rootDescriptor, 
      new PlatformPatternExtensionReader().getPatternLibraries()
    );
    // Search for names.
    new PatternDescriptorStrategy() {
      @Override
      protected boolean stopSearch(IDescriptor parentDescriptor_p) {
        return completed[0];
      }
    }.iterateThroughPatternExtensionDescriptor(
      new IPatternDescriptorHandler() {
        public void handleDescriptor(IDescriptor descriptor_p) {
          // Nothing to do here.
        }
        public void handleLibraryDescriptor(IDescriptor descriptor_p, String parentLibraryId_p) {
          if (completed[0] == false) {
            completed[0] = completeName(fullId_p, shortIdToName, descriptor_p);
          }
        }
        public void handlePatternDescriptor(IDescriptor descriptor_p, String patternFullId_p) {
          if (completed[0] == false) {
            completed[0] = completeName(fullId_p, shortIdToName, descriptor_p);
          }
        }
      }, 
      rootDescriptor
    );
    // Reconstruct name.
    if (completed[0]) {
      for (String shortId : order) {
        result = shortIdToName.get(shortId) + ((ICommonConstants.EMPTY_STRING == result) ? result : ICommonConstants.SLASH_CHARACTER + result);
      }
    }
    return result;
  }

  /**
   * Complete pattern full name with given descriptor candidate.
   * @param toBeResolvedFullId_p
   * @param decomposition_p
   * @param descriptor_p
   * @return
   */
  protected boolean completeName(String toBeResolvedFullId_p, Map<String, String> decomposition_p, IDescriptor descriptor_p) {
    boolean result = false;
    String candidateShortId = (String) descriptor_p.getValue(ExtensionPointHelper.ATT_ID);
    if (toBeResolvedFullId_p.contains(candidateShortId)) {
      // Candidate name is part of the full name.
      String candidateName = (String) descriptor_p.getValue(ExtensionPointHelper.ATT_NAME);
      // Add its value to the candidate name.
      decomposition_p.put(candidateShortId, candidateName);
      // Full name is resolved, if the decomposition is complete, ie does not contain unknown values anymore.
      result = decomposition_p.values().contains(ICommonConstants.EMPTY_STRING) == false;
    }
    return result;
  }
  
}
