/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
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
public class GIFPatternExecutionReporter extends CodegenPatternExecutionReporter {

  @Override
  public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
    super.loopFinished(output, outputWithCallBack, context, parameterValues);

    generateGIF(output, context);
  }

}
