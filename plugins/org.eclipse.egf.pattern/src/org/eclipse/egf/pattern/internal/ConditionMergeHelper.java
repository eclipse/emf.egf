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

import static org.eclipse.egf.pattern.ecore.condition.IConditionConstants.USER_CODE_BEGINNING_DELIMITER;
import static org.eclipse.egf.pattern.ecore.condition.IConditionConstants.USER_CODE_END_DELIMITER;

import java.io.ByteArrayInputStream;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.pattern.PatternActivator;
import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper;
import org.eclipse.emf.common.util.URI;


/**
 * Helper to merge easily merge previous condition generation with new ones.
 * @author Guillaume Brocard
 */
public class ConditionMergeHelper {
  
  private ConditionMergeHelper() {
    // Prevent Instantiation
  }
  
  /**
   * Merge given new content with given previous one.
   * @param newContent_p the new content to merge.
   * @param previousContent_p the previous content to merge
   * @return the merged content.
   */
  public static String merge(String newContent_p, String previousContent_p) {
    String mergedContent = ICommonConstants.EMPTY_STRING;
    // Initialize a merger.
    JMerger merger = getJMerger();
    // Set as source the new content.
    merger.setSourceCompilationUnit(merger.createCompilationUnitForContents(newContent_p));
    // Set as target the previous content.
    ByteArrayInputStream previousContentInputStream = new ByteArrayInputStream(previousContent_p.getBytes());
    merger.setTargetCompilationUnit(merger.createCompilationUnitForInputStream(previousContentInputStream));
    // Merge the source with the target.
    merger.merge();
    // Get the merged content.
    mergedContent = merger.getTargetCompilationUnit().getContents();
    // Extract the previous user-code between delimiters.
    String previousDelimitedContent = StringHelper.substring(
      USER_CODE_BEGINNING_DELIMITER, 
      USER_CODE_END_DELIMITER, 
      previousContent_p, 
      true
    );
    // If successfully extracted, let's continue.
    if (previousDelimitedContent != null) {
      // Extract the user-code between delimiters.
      String newDelimitedContent = StringHelper.substring(
        USER_CODE_BEGINNING_DELIMITER, 
        USER_CODE_END_DELIMITER, 
        mergedContent, 
        true
      );
      // If delimited contents are different ones, replace newDelimitedContent in merged content with the previous one.
      // Developers won't happy to lose their code.
      if (previousDelimitedContent.equals(newDelimitedContent) == false) {
        mergedContent = mergedContent.replace(newDelimitedContent, previousDelimitedContent);
      }
    }
    return mergedContent;
  }

  /**
   * Creates and initializes a new JMerger
   * @return JMerger
   */
  private static JMerger getJMerger() {
    // Get the merge file URL.
    URI mergeFileURI = FileHelper.getFileFullUri(getRelativePathToMergeFile());
    // Install a JControlModel.
    JControlModel controlModel = new JControlModel();
    controlModel.initialize(new ASTFacadeHelper(), mergeFileURI.toString());
    JMerger jmerger = new JMerger(controlModel);
    return jmerger;
  }

  /**
   * Get merge.xml file relative path to workspace.<br>
   * Default implementation points to pattern condition class merge file.
   * @return
   */
  protected static String getRelativePathToMergeFile() {
    return new StringBuilder(ICommonConstants.SLASH_CHARACTER)
      .append(PatternActivator.getDefault().getPluginID())
      .append("/resources/merge.xml") //$NON-NLS-1$
      .toString();
  }
  
}