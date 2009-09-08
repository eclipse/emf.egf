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
package org.eclipse.egf.common.descriptor.pattern.helper;

import java.util.List;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;


/**
 * Pattern descriptor various strategies implementation.
 * @author Guillaume Brocard
 */
public class PatternDescriptorStrategy {
  
  /**
   * Iterate through descriptors starting from given parent one.
   * @param handler_p
   * @param descriptor_p
   */
  public void iterateThroughPatternExtensionDescriptor(IPatternDescriptorHandler handler_p, IDescriptor descriptor_p) {
    // Preconditions.
    if (handler_p == null || descriptor_p == null) {
      return;
    }
    // Handle pattern extension descriptor.
    handlePatternExtensionDescriptor(handler_p, descriptor_p, null);
  }

  /**
   * Handler descriptor for a pattern extension (extension point patternExtension).
   * @param handler_p
   * @param descriptor_p
   * @param idPrefix_p
   */
  protected void handlePatternExtensionDescriptor(
    IPatternDescriptorHandler handler_p, 
    IDescriptor descriptor_p, 
    String idPrefix_p
  ) {
    // Get descriptor type...
    Object descriptorType = descriptor_p.getValue(IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE);
    // ... children...
    List<IDescriptor> children = descriptor_p.getChildren();
    // ... and id.
    String currentId = (String) descriptor_p.getValue(ExtensionPointHelper.ATT_ID);
    StringBuilder idPrefix = new StringBuilder();
    // Library case.
    if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY.equals(descriptorType)) {
      if (idPrefix_p == null || idPrefix_p.trim().length() == 0) {      
        idPrefix.append(currentId);
      } else {
        idPrefix
          .append(idPrefix_p)
          .append(IPatternConstants.LIBRARY_PATTERN_ID_SEPARATOR)
          .append(currentId);
      }
      handler_p.handleLibraryDescriptor(descriptor_p, idPrefix.toString());
    } else if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_PATTERN.equals(descriptorType)) { // Pattern case.
      children = null;
      idPrefix
        .append(idPrefix_p)
        .append(IPatternConstants.LIBRARY_PATTERN_ID_SEPARATOR)
        .append(currentId);
      handler_p.handlePatternDescriptor(descriptor_p, idPrefix.toString());
    } else { // Unknown case.
      handler_p.handleDescriptor(descriptor_p);
    }
    // Should search be stopped for current branch ?
    if (children != null && stopSearch(descriptor_p)) {
      children = null;
    }
    // Go for the children.
    if (children != null) {
      for (IDescriptor descriptor : children) {
        handlePatternExtensionDescriptor(handler_p, descriptor, idPrefix.toString());
      }
    }
  }

  /**
   * Should search be stopped for potential children of given descriptor ?
   * @param parentDescriptor_p
   * @return true if search should be interrupted, false if it should continue.
   * Default implementation does return false, that is, search is never interrupted for given branch.
   */
  protected boolean stopSearch(IDescriptor parentDescriptor_p) {
    return false;
  }

  /**
   * Handle root descriptor content by retaining only root libraries.
   * @param rootDescriptor_p
   * @param childContainer_p
   */
  public static void retainRootOnly(GenericDescriptor rootDescriptor_p, IDescriptor childContainer_p) {
    // Precondition.
    if (childContainer_p == null) {
      return;
    }
    // This descriptor is not a root library one, since it does not have any type.
    if (childContainer_p.getValue(IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE) == null) {
      List<IDescriptor> children = childContainer_p.getChildren();
      // Iterate through container children.
      for (IDescriptor descriptor : children) {
        retainRootOnly(rootDescriptor_p, descriptor);
      }
    } else {
      // First adding value descriptor reached, add it to root descriptor.
      rootDescriptor_p.addChild(childContainer_p);
    }
  }

  /**
   * Get full id for given library/pattern descriptor.
   * @param descriptor_p
   * @return
   */
  public static String getDescriptorFullId(IDescriptor descriptor_p) {
    String result = null;
    // Precondition.
    if (descriptor_p == null) {
      return result;
    }
    // Initialize result to empty string.
    result = ICommonConstants.EMPTY_STRING;
    // Let takes into account the whole description chain.
    IDescriptor currentParent = descriptor_p;
    while (currentParent != null) {
      String parentId = (String) currentParent.getValue(ExtensionPointHelper.ATT_ID);
      if (parentId != null && parentId.trim().length() > 0) {
        if (result.length() > 0) {
          result = new StringBuilder(parentId)
            .append(IPatternConstants.LIBRARY_PATTERN_ID_SEPARATOR)
            .append(result)
            .toString();
        } else {
          // Do not add library/pattern separator for trailing id.
          result = parentId;
        }
      }
      currentParent = currentParent.getParent();
    }
    return result;
  }
  
}
