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
package org.eclipse.egf.pde.pattern.internal.plugin.command;

import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * Base class to implement commands that change something regarding 'pattern' extensions : either a pattern library or a pattern.
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternElementCommand extends AbstractExtensionChangesCommand {
  
  /**
   * Pattern element ids : <parent library full id, local id>.
   */
  private Couple<String, String> _patternElementIds;
  
  /**
   * Full pattern element id.
   */
  private String _patternElementFullId;
  
  /**
   * Reference to the pattern element name.
   */
  private String _patternElementName;

  /**
   * Constructor.
   * @param patternElementFullId_p Pattern element full id as defined by the pattern plug-in.
   */
  protected AbstractPatternElementCommand(String patternElementFullId_p, String patternElementName_p) {
    _patternElementFullId = patternElementFullId_p;
    _patternElementIds = PatternHelper.deresolveId(patternElementFullId_p);
    _patternElementName = patternElementName_p;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionPointId()
   */
  @Override
  protected String getExtensionPointId() {
    return IPatternConstants.PATTERN_EXTENSION_POINT_FULL_ID;
  }

  /**
   * Get the pattern element id.
   * @return the local id is returned.
   */
  public String getPatternElementId() {
    return _patternElementIds.getValue();
  }

  /**
   * Get the parent library full id.
   * @return
   */
  public String getParentLibraryId() {
    return _patternElementIds.getKey();
  }

  /**
   * Get the pattern element full id.
   * @return
   */
  public String getPatternElementFullId() {
    return _patternElementFullId;
  }

  /**
   * Get the pattern element name.
   * @return
   */
  public String getPatternElementName() {
    return _patternElementName;
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#getExtensionChildName()
   */
  @Override
  final protected String getExtensionChildName() {
    return IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY;
  }

  /**
   * Get the plug-in element for given library full id.
   * @param libraryId_p
   * @return
   */
  protected IPluginElement getLibrary(String libraryId_p) {
    IPluginElement result = null;
    String[] tokens = StringHelper.getTokens(libraryId_p, String.valueOf(IPatternConstants.LIBRARY_PATTERN_ID_SEPARATOR));
    // Loop over tokens to retrieve the plug-in element according to given library id.
    for (int i = 0; i < tokens.length; i++) {
      // The extension itself is located at the zero index, use classic method to get the plug-in element.
      if (i == 0) {
        result = getExtensionElementWithId(tokens[i]);
      } else {
        // other tokens represent children.
        result = getElement(
          result, 
          IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY, 
          ExtensionPointHelper.ATT_ID, 
          tokens[i], 
          false
        );
      }
    }
    return result;
  }

  /**
   * Get the pattern element for specified id from given parent plug-in element.<br>
   * If the pattern element does not exist, it is created.
   * @param parent_p
   * @param patternElementId_p the local id.
   * @param createIfMissing_p
   * @return
   */
  protected IPluginElement getPatternElement(
    IPluginElement parent_p, 
    String patternElementId_p, 
    String patternElementChildNodeName_p, 
    boolean createIfMissing_p
  ) {
    return getElement(
      parent_p, 
      patternElementChildNodeName_p, 
      getExtensionChildIdAttribute(), 
      patternElementId_p, 
      createIfMissing_p
    );
  }
  
}