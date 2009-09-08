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
package org.eclipse.egf.pattern.condition.gen;

import java.util.Map;

import org.eclipse.egf.core.context.ProductionContext;
import org.eclipse.egf.pattern.ecore.condition.ConditionClassOutput;
import org.eclipse.egf.pattern.execution.IPatternExecutionReporter;
import org.eclipse.emf.ecore.EObject;


/**
 * The execution reporter that handles the pattern condition class generation.<br>
 * No Java class is written on the disk at this point. Instead resulting content is delivered to {@link ConditionClassOutput}.
 * @author Guillaume Brocard
 */
public class ConditionExecutionReporter implements IPatternExecutionReporter {
  
  /**
   * A unique key for exchanging pattern full id with pattern execution.
   */
  public static final String PATTERN_FULL_ID = "Pattern.1213692237160.91_PFI"; //$NON-NLS-1$

  /**
   * @see org.eclipse.egf.pattern.execution.IPatternExecutionReporter#patternExecutionFinished(java.lang.String, java.lang.String,
   *      org.eclipse.egf.core.context.ProductionContext)
   */
  public void patternExecutionFinished(
    String output_p, 
    String patternFullId_p, 
    ProductionContext context_p
  ) {
    ConditionClassOutput.getSharedInstance().setGeneratedConditionClassContent(
      output_p, 
      (String) context_p.getContextElementValue(PATTERN_FULL_ID, PATTERN_FULL_ID)
    );
  }

  /**
   * @see org.eclipse.egf.pattern.execution.IPatternExecutionReporter#patternLoopExecutionFinished(java.lang.String, java.lang.String,
   *      org.eclipse.egf.core.context.ProductionContext, java.util.Map)
   */
  public void patternLoopExecutionFinished(
    String output_p, 
    String patternFullId_p, 
    ProductionContext context_p, 
    Map<String, EObject> tuple_p
  ) {
    // There is no loop in ConditionGenerator.
    // Simply ignore this part.
  }
  
}
