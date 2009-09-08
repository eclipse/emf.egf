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
package org.eclipse.egf.pattern.runner.contract.type;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.core.context.ProductionContext;
import org.eclipse.egf.pattern.execution.IPatternExecutionReporter;
import org.eclipse.emf.ecore.EObject;


/**
 * Simple pattern execution reporter using LOG4J to trace pattern execution.
 * @author Guillaume Brocard
 */
public class PatternExecutionReporter implements IPatternExecutionReporter {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(PatternExecutionReporter.class.getPackage().getName());

  /**
   * @see org.eclipse.egf.pattern.execution.IPatternExecutionReporter#patternExecutionFinished(java.lang.String, java.lang.String,
   *      org.eclipse.egf.core.context.ProductionContext)
   */
  public void patternExecutionFinished(String output_p, String patternFullId_p, ProductionContext context_p) {
    if (__logger.isInfoEnabled()) {
      StringBuilder loggerMessage = new StringBuilder("PatternExecutionReporter.patternExecutionFinished(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Start of ").append(patternFullId_p).append(ICommonConstants.EOL_CHARACTER); //$NON-NLS-1$
      loggerMessage.append(output_p);
      loggerMessage.append("End of ").append(patternFullId_p).append(ICommonConstants.EOL_CHARACTER); //$NON-NLS-1$
      __logger.info(loggerMessage.toString());
    }
  }

  /**
   * @see org.eclipse.egf.pattern.execution.IPatternExecutionReporter#patternLoopExecutionFinished(java.lang.String, java.lang.String,
   *      org.eclipse.egf.core.context.ProductionContext, java.util.Map)
   */
  public void patternLoopExecutionFinished(String output_p, String patternFullId_p, ProductionContext context_p, Map<String, EObject> tuple_p) {
    if (__logger.isInfoEnabled()) {
      StringBuilder loggerMessage = new StringBuilder("PatternExecutionReporter.patternLoopExecutionFinished(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Start of a loop in ").append(patternFullId_p).append(ICommonConstants.EOL_CHARACTER); //$NON-NLS-1$
      loggerMessage.append(output_p);
      loggerMessage.append("End of a loop in ").append(patternFullId_p).append(ICommonConstants.EOL_CHARACTER); //$NON-NLS-1$
      __logger.info(loggerMessage.toString());
    }
  }
}
