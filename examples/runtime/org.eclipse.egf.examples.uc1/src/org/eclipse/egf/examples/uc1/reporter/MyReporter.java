/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.examples.uc1.reporter;

import java.util.Map;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

/**
 * @author Benoit Langlois
 * 
 */

public class MyReporter implements PatternExecutionReporter {

  public void executionFinished(String output, PatternContext context) {
	  String message = new String ("--------------\nResult of pattern:\n" + output);
	  
	  // Message on the default console
	  System.out.println(message); //$NON-NLS-1$

	  // Message on the EGF console
	  EGFCorePlugin.getDefault().logInfo(message);
 }

  public void loopFinished(String output, PatternContext context, Map<String, Object> parameterValues) {
	  // TODO Auto-generated method stub
  }

}
