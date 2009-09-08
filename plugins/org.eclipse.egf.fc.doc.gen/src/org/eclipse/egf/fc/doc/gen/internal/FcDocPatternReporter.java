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
package org.eclipse.egf.fc.doc.gen.internal;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.core.context.ProductionContext;
import org.eclipse.egf.pattern.execution.IPatternExecutionReporter;
import org.eclipse.egf.pde.EgfPdeActivator;
import org.eclipse.emf.ecore.EObject;


/**
 * Pattern Reporter that persisted FC documentation files.
 * @author Guillaume Brocard
 */
public class FcDocPatternReporter implements IPatternExecutionReporter {
  // Pattern library id that contains patterns involved in documentation generation.
  private static final String LIBRARY_FULL_ID = "patternLibrary.1212569425341.37"; //$NON-NLS-1$
  private static final String STYLE_PATTERN_FULL_ID = PatternHelper.getFullId(LIBRARY_FULL_ID, "Pattern.1212569465756.38"); //$NON-NLS-1$
  private static final String HTML_FC_DOC_PATTERN_FULL_ID = PatternHelper.getFullId(LIBRARY_FULL_ID, "Pattern.1212569887715.48"); //$NON-NLS-1$
  private static final String TOC_PATTERN_FULL_ID = PatternHelper.getFullId(LIBRARY_FULL_ID, "Pattern.1212570575038.70"); //$NON-NLS-1$

  /**
   * @see org.eclipse.egf.pattern.execution.IPatternExecutionReporter#patternExecutionFinished(java.lang.String, java.lang.String,
   *      org.eclipse.egf.core.context.ProductionContext)
   */
  public void patternExecutionFinished(String output_p, String patternFullId_p, ProductionContext context_p) {
    // Get the factory component that documentation is generated for.
    String updatedFactoryComponentId =
                                       (String) context_p.getContextElementValue(IFcDocGeneratorConstants.CONTRACT_ELEMENT_UPDATED_FC,
                                                                                 IFcDocGeneratorConstants.FC_DOC_GENERATOR_ID);
    // Get its hosting project.
    IProject project = EgfPdeActivator.getDefault().getProjectForFactoryComponent(updatedFactoryComponentId);
    IFile persistedFile = null;
    if (STYLE_PATTERN_FULL_ID.equals(patternFullId_p)) {
      persistedFile = project.getFile(IFcDocGeneratorConstants.STYLE_FILE_RELATIVE_PATH);
      // Persist the style file.
    } else if (HTML_FC_DOC_PATTERN_FULL_ID.equals(patternFullId_p)) {
      // Persist the fc html page file.
      persistedFile = project.getFile(IFcDocGeneratorConstants.FC_DOC_HTML_FILE_RELATIVE_PATH);
    } else if (TOC_PATTERN_FULL_ID.equals(patternFullId_p)) {
      // Persist the toc file.
      persistedFile = project.getFile(IFcDocGeneratorConstants.TOC_FILE_RELATIVE_PATH);
    }
    if (null != persistedFile) {
      FileHelper.writeFile(persistedFile.getFullPath().toString(), true, output_p);
    }
  }

  /**
   * @see org.eclipse.egf.pattern.execution.IPatternExecutionReporter#patternLoopExecutionFinished(java.lang.String, java.lang.String,
   *      org.eclipse.egf.core.context.ProductionContext, java.util.Map)
   */
  public void patternLoopExecutionFinished(String output_p, String patternFullId_p, ProductionContext context_p, Map<String, EObject> tuple_p) {
    // Do nothing.
  }
}
