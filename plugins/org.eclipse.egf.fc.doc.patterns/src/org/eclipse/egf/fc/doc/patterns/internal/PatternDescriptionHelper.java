/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.fc.doc.patterns.internal;

import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.model.AbstractPatternElement;
import org.eclipse.egf.model.PatternLibrary;
import org.eclipse.egf.model.PatternModel;
import org.eclipse.egf.model.PatternViewpoint;


/**
 * Provide a method to get a HTML content as pattern viewpoint description.
 * @author Guillaume Brocard
 */
public class PatternDescriptionHelper {
  /**
   * Define a tag to display the pattern model icon.
   */
  private static final String PATTERN_MODEL_IMG_TAG =
                                                      "<img src=\"../../../org.eclipse.egf.model.edit/icons/full/obj16/PatternModel.gif\" border=\"0\" /> "; //$NON-NLS-1$
  /**
   * Define a tag to display the pattern library icon.
   */
  private static final String PATTERN_LIBRARY_IMG_TAG =
                                                        "<img src=\"../../../org.eclipse.egf.model.edit/icons/full/obj16/PatternLibrary.gif\" border=\"0\" /> "; //$NON-NLS-1$
  /**
   * Defines a tag to begin an unordered list.
   */
  private static final String UNORDERED_LIST_TAG_START = "<ul>"; //$NON-NLS-1$
  /**
   * Defines a tag to close an unordered list.
   */
  private static final String UNORDERED_LIST_TAG_END = "</ul>"; //$NON-NLS-1$
  /**
   * Defines a tag to begin a list item.
   */
  private static final String LIST_ITEM_TAG_START = "<li>"; //$NON-NLS-1$
  /**
   * Defines a tag to close a list item.
   */
  private static final String LIST_ITEM_TAG_END = "</li>"; //$NON-NLS-1$

  /**
   * Generate an HTML description for libraries and patterns contained by specified pattern viewpoint.
   * @param patternViewpoint_p
   * @return a not null string.
   */
  public static String generateDescription(PatternViewpoint patternViewpoint_p) {
    StringBuilder result = new StringBuilder();
    // Precondition.
    if (null == patternViewpoint_p) {
      return result.toString();
    }
    // Get contained libraries.
    List<PatternLibrary> libraries = patternViewpoint_p.getLibraries();
    if (!libraries.isEmpty()) {
      result.append(UNORDERED_LIST_TAG_START);
      Iterator<PatternLibrary> iterator = libraries.iterator();
      while (iterator.hasNext()) {
        PatternLibrary currentPatternLibrary = iterator.next();
        result.append(generateLibraryDescription(currentPatternLibrary));
      }
      result.append(UNORDERED_LIST_TAG_END);
    }
    return result.toString();
  }

  /**
   * Generate an HTML description for specified library.
   * @param patternLibrary_p
   * @return a not null string.
   */
  private static String generateLibraryDescription(PatternLibrary patternLibrary_p) {
    StringBuilder result = new StringBuilder();
    // Open an HTML list entry to describe specified library.
    result.append(LIST_ITEM_TAG_START).append(PATTERN_LIBRARY_IMG_TAG);
    // Append library name.
    result.append(patternLibrary_p.getName());
    Iterator<AbstractPatternElement> iterator = patternLibrary_p.getPatternElements().iterator();
    // Open a new list for library children.
    result.append(UNORDERED_LIST_TAG_START);
    while (iterator.hasNext()) {
      AbstractPatternElement currentPatternElement = iterator.next();
      if (currentPatternElement instanceof PatternLibrary) {
        result.append(generateLibraryDescription((PatternLibrary) currentPatternElement));
      } else if (currentPatternElement instanceof PatternModel) {
        result.append(generatePatternDescription((PatternModel) currentPatternElement));
      }
    }
    // Close the list for library children.
    result.append(UNORDERED_LIST_TAG_END);
    // Close specified library HTML list entry.
    result.append(LIST_ITEM_TAG_END);
    return result.toString();
  }

  /**
   * Generate pattern description for specified one.
   * @param patternModel_p
   * @return a not null string.
   */
  private static Object generatePatternDescription(PatternModel patternModel_p) {
    StringBuilder result = new StringBuilder();
    // Open an HTML list entry to describe specified pattern.
    result.append(LIST_ITEM_TAG_START).append(PATTERN_MODEL_IMG_TAG);
    // Append pattern name.
    result.append(patternModel_p.getName());
    // Close specified pattern HTML list entry.
    result.append(LIST_ITEM_TAG_END);
    return result.toString();
  }
}
