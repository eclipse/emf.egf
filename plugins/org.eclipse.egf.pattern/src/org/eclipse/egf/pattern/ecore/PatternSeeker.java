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
package org.eclipse.egf.pattern.ecore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.helper.PatternLibrarySequenceHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pde.pattern.reader.IPatternExtensionReader;
import org.eclipse.egf.pde.pattern.reader.PlatformPatternExtensionReader;
import org.eclipse.egf.pde.pattern.reader.WorkspacePatternExtensionReader;


/**
 * A pattern seeker that takes a full id as parameter and is able to retrieve all corresponding patterns.<br>
 * The full id can either be the id of a library or the id of a single pattern.
 * @author Guillaume Brocard
 */
public class PatternSeeker {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PatternSeeker.class.getPackage().getName());
  
  /**
   * Pattern extension readers.
   */
  private List<IPatternExtensionReader> _readers;

  /**
   * Constructor.
   * @param searchInWorkspace_p Should extensions be read in workspace too ?
   */
  public PatternSeeker(boolean searchInWorkspace_p) {
    _readers = new ArrayList<IPatternExtensionReader>(1);
    if (searchInWorkspace_p) {
      _readers.add(new WorkspacePatternExtensionReader());
    }
    _readers.add(new PlatformPatternExtensionReader());
  }

  /**
   * Get patterns from full id.<br>
   * @param fullId_p The full id is composed of the chain of containing libraries and optionally the pattern id, separated by the <i>#</i> character.<br>
   *          E.g :
   *          <ul>
   *          <li> <i>HelloWorld.Library1#Library2#Pattern1</i><br>
   *          In this case, only Pattern1 will be produced.
   *          <li> <i>HelloWorld.Library1#Library2</i><br>
   *          In this one, the whole library Library2 will be produced, according to its orchestration class.
   *          </ul>
   * @return not null, may be empty if no pattern to produce could be found.
   */
  public List<PatternData> getPatternsData(String fullId_p) {
    // Create resulting list.
    List<PatternData> result = new ArrayList<PatternData>(0);
    // Search for corresponding patterns.
    getPatternsData(fullId_p, fullId_p, null, result);
    return result;
  }

  /**
   * Get root library from its id.
   * @param libraryId_p
   * @return
   */
  protected IDescriptor getRootLibraryFromId(String libraryId_p) {
    IDescriptor result = null;
    // Iterate over declared possible readers.
    for (Iterator<IPatternExtensionReader> readers = _readers.iterator(); readers.hasNext() && result == null;) {
      result = readers.next().getPatternLibrary(libraryId_p);
    }
    return result;
  }

  /**
   * Get children libraries of given one.
   * @param parentLibrary_p
   * @return
   */
  protected List<IDescriptor> getChildrenLibraries(IDescriptor parentLibrary_p) {
    // All children.
    List<IDescriptor> children = parentLibrary_p.getChildren();
    List<IDescriptor> result = new ArrayList<IDescriptor>(children.size());
    // Keep only those that have the 'library' type set.
    for (IDescriptor descriptor : children) {
      if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY.equals(descriptor.getValue(IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE))) {
        result.add(descriptor);
      }
    }
    return result;
  }

  /**
   * Get patterns data from given full id.
   * @param fullId_p The original full id.
   * @param partialId_p The partial id, as required by the search step.
   * @param library_p The extension point element representing a library at given search step.
   * @param data_p Resulting list of patterns data (to produce).
   */
  protected void getPatternsData(String fullId_p, String partialId_p, IDescriptor library_p, List<PatternData> data_p) {
    // Precondition.
    if (partialId_p == null) {
      return;
    }
    // Search libraries/patterns separator in pattern id.
    int separatorPosition = partialId_p.indexOf(IPatternConstants.LIBRARY_PATTERN_ID_SEPARATOR);
    // Check that path is composed of one library at least.
    if (separatorPosition > 0) {
      // There is still work to do before reaching the end-of-chain library.
      String libraryId = partialId_p.substring(0, separatorPosition);
      IDescriptor library = null;
      if (library_p == null) {
        // No parent library, look for first one.
        library = getRootLibraryFromId(libraryId);
      } else {
        // Look for children libraries.
        List<IDescriptor> libraries = getChildrenLibraries(library_p);
        for (Iterator<IDescriptor> librariesIterator = libraries.iterator(); librariesIterator.hasNext() && library == null;) {
          IDescriptor currentLibrary = librariesIterator.next();
          // Got the one !
          if (libraryId.equals(currentLibrary.getValue(ExtensionPointHelper.ATT_ID))) {
            library = currentLibrary;
          }
        }
      }
      // Go on with this selected level of library.
      if (library != null) {
        getPatternsData(
          fullId_p, 
          partialId_p.substring(separatorPosition + 1, partialId_p.length()), 
          library, 
          data_p
        );
      }
    } else if (library_p != null) {
      // At this point, the parent library is reached.
      // It contains either the library or the pattern to produce.
      doGetPatternPaths(partialId_p, library_p, data_p);
    } else {
      // No parent library, asking for root library production
      // (indeed a pattern is contained in one and only one library).
      IDescriptor library = getRootLibraryFromId(fullId_p);
      resolveLibraryData(library, data_p);
    }
  }

  /**
   * Do retrieved all patterns data from reached library.
   * @param partialId_p Either a library or pattern id.
   * @param library_p Reached parent library.
   * @param data_p Resulting patterns data list.
   */
  protected void doGetPatternPaths(String partialId_p, IDescriptor library_p, List<PatternData> data_p) {
    // Look for a child element that is identified by the given partial id.
    List<IDescriptor> children = library_p.getChildren();
    // Search among existing children.
    for (Iterator<IDescriptor> descriptors = children.iterator(); descriptors.hasNext();) {
      IDescriptor currentElement = descriptors.next();
      if (partialId_p.equals(currentElement.getValue(ExtensionPointHelper.ATT_ID))) {
        String descriptorType = (String) currentElement.getValue(IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE);
        if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY.equals(descriptorType)) {
          // Found library to produce, add its patterns data.
          resolveLibraryData(currentElement, data_p);
        } else {
          // Found pattern to produce, add its path.
          PatternData patternData = resolvePatternData(currentElement);
          if (patternData != null) {
            data_p.add(patternData);
          }
        }
        break;
      }
    }
  }

  /**
   * Resolve library patterns data that should be produced.
   * @param library_p
   * @param data_p
   */
  protected void resolveLibraryData(IDescriptor library_p, List<PatternData> data_p) {
    // The containing library is reached, look for its patterns.
    // First of all, try and use the orchestration string as a list of patterns/libraries to produce.
    String orchestrationString = (String) library_p.getValue(IPatternConstants.LIBRARY_PRODUCTION_ORCHESTRATION_ATTRIBUTE_NAME);
    String[] ids = null;
    if (orchestrationString != null) {
      ids = StringHelper.getTokens(orchestrationString, PatternLibrarySequenceHelper.SEQUENCE_SEPARATORS);
    }
    // Get library elements.
    List<IDescriptor> elements = library_p.getChildren();
    // Cycle through the ids.
    Map<String, IDescriptor> elementsFromId = null;
    if (ids != null) {
      // First, create the map of (id, configuration element) that will be used while searching by ids.
      elementsFromId = new HashMap<String, IDescriptor>(elements.size());
      for (IDescriptor element : elements) {
        elementsFromId.put((String) element.getValue(ExtensionPointHelper.ATT_ID), element);
      }
      // Then do return pattern paths, according to orchestration ids.
      for (String currentId : ids) {
        // Get element from id, according to the orchestration schema.
        IDescriptor currentElement = elementsFromId.get(currentId);
        // Do resolve paths.
        doResolveLibraryData(currentElement, data_p);
      }
    } else { // No orchestration defined, simply cycle through existing child elements in declaration order.
      for (IDescriptor element : elements) {
        // Do resolve paths.
        doResolveLibraryData(element, data_p);
      }
    }
  }

  /**
   * Do resolve given library child data.
   * @param libraryChild_p
   * @param data_p
   */
  protected void doResolveLibraryData(IDescriptor libraryChild_p, List<PatternData> data_p) {
    if (libraryChild_p == null || data_p == null) {
      return;
    }
    // The child element is a library itself, resolve as a library then.
    String childType = (String) libraryChild_p.getValue(IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE);
    if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY.equals(childType)) {
      resolveLibraryData(libraryChild_p, data_p);
    } else { // The child element is a pattern, add its data to the resulting list.
      PatternData patternData = resolvePatternData(libraryChild_p);
      if (patternData != null) {
        data_p.add(patternData);
      }
    }
  }

  /**
   * Resolve pattern data from its descriptor.
   * @param pattern_p
   * @return
   */
  protected PatternData resolvePatternData(IDescriptor pattern_p) {
    // Create corresponding pattern structure.
    PatternData result = null;
    // Get file path.
    String fileDeclaredPath = (String) pattern_p.getValue(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME);
    // Could not retrieve ecore relative path, return null.
    if (fileDeclaredPath == null) {
      return result;
    }
    // Try and load pattern model.
    try {
      result = new PatternHandler().load(fileDeclaredPath);
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("PatternProducer.resolvePatternData(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return result;
  }
  
}
