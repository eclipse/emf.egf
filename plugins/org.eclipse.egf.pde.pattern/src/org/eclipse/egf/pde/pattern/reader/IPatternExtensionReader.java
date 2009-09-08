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
package org.eclipse.egf.pde.pattern.reader;

import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;

/**
 * Pattern extension reader contract.<br>
 * By default, one implementation is provided per possible source of extensions.
 * @author Guillaume Brocard
 */
public interface IPatternExtensionReader {
  
  /**
   * Get library descriptor from its full id.<br>
   * Must be a root library, that is not one contained in another one.<br>
   * So as to get such libraries, user should be giving the root containing library id and then parse resulting descriptor to reach expected one.<br>
   * If so, the use of PatternSeeker from pattern plug-in is always recommended.
   * @param libraryFullId_p Can't be null.
   * @return Null if no root library with given id could be found.
   */
  public IDescriptor getPatternLibrary(String libraryFullId_p);

  /**
   * Get all root library descriptors.<br>
   * See {@link #getPatternLibrary(String)} for description of a root library.
   * @return
   * A descriptor that contains an arbitrary number of container descriptors before reaching root library descriptors.<br>
   * So as to use this result properly, users should test the descriptor type by calling {@link IDescriptor#getValue(String)} with
   * parameter {@link IPatternConstants#PATTERN_EXTENSION_POINT_CHILD_TYPE}.<br>
   * If returned value is different from {@link IPatternConstants#PATTERN_EXTENSION_POINT_CHILD_LIBRARY} then a library
   * descriptor is not reached yet.<br> The first descriptor that returns a correct type is indeed a root library descriptor.<br>
   * It does not have any children, if none could be found.
   */
  public IDescriptor getPatternLibraries();

  /**
   * Get all root library descriptors for given factory component id.<br>
   * See {@link #getPatternLibrary(String)} for description of a root library.
   * @param fcId_p The factory component id.
   * @return
   * A descriptor that contains an arbitrary number of container descriptors before reaching root library descriptors.<br>
   * So as to use this result properly, users should test the descriptor type by calling {@link IDescriptor#getValue(String)} with
   * parameter {@link IPatternConstants#PATTERN_EXTENSION_POINT_CHILD_TYPE}.<br>
   * If returned value is different from {@link IPatternConstants#PATTERN_EXTENSION_POINT_CHILD_LIBRARY} then a library
   * descriptor is not reached yet.<br> The first descriptor that returns a correct type is indeed a root library descriptor.<br>
   * It does not have any children, if none could be found.
   */
  public IDescriptor getPatternLibraries(String fcId_p);
  
}
