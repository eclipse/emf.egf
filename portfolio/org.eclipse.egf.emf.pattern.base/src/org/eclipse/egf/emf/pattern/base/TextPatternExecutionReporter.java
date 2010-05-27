/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.base;

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;

/**
 * @author Matthieu Helleboid
 * 
 */
public class TextPatternExecutionReporter extends CodegenPatternExecutionReporter {

  @Override
  public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
    super.loopFinished(output, outputWithCallBack, context, parameterValues);

    if (!canGenerate)
      return;

    generateText(output, context);
  }
}
