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
package org.eclipse.egf.pattern.execution;

import java.util.Map;

import org.eclipse.egf.core.context.ProductionContext;
import org.eclipse.emf.ecore.EObject;


/**
 * Classes which implement this interface provide a method<br>
 * that deals with the event that is generated when a pattern execution is finished.<br>
 * Implementors must provide a default constructor.
 * @author Guillaume Brocard
 */
public interface IPatternExecutionReporter {
  /**
   * Sent when a pattern overall execution has just finished.
   * @param patternFullId_p the full identifier of the pattern that the execution is finished for.
   * @param output_p the output resulting from the pattern execution.
   */
  public void patternExecutionFinished(String output_p, String patternFullId_p, ProductionContext context_p);

  /**
   * Sent when a pattern loop execution is finished.
   * @param output_p The loop output.
   * @param patternFullId_p The full id of the pattern that declares the loop.
   * @param context_p The production context of the pattern execution.
   * @param tuple_p The contextual loop tuple. This object should not be kept by the implementor for it is used for every possible tuple values.
   */
  public void patternLoopExecutionFinished(String output_p, String patternFullId_p, ProductionContext context_p, Map<String, EObject> tuple_p);
}
