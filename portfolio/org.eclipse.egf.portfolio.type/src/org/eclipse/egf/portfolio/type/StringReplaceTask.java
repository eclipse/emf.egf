/**
 * <copyright>
 * 
 * Copyright (c) 2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.portfolio.type;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;

/**
 * @author Benoit Langlois
 * 
 */
public class StringReplaceTask implements ITaskProduction {

  private static final String FIRST_VALUE = "first"; //$NON-NLS-1$
  private static final String ALL_VALUE = "all"; //$NON-NLS-1$

  public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    // Nothing to do
  }

  public void doExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    String result = new String();
    String inValue = productionContext.getInputValue(TypeConstants.IN_VALUE_NAME_CONTRACT, String.class);
    String occurrenceValue = productionContext.getInputValue(TypeConstants.OCCURRENCE_NAME_CONTRACT, String.class);
    String regexValue = productionContext.getInputValue(TypeConstants.REGEX_NAME_CONTRACT, String.class);
    String replacementValue = productionContext.getInputValue(TypeConstants.REPLACEMENT_NAME_CONTRACT, String.class);

    if (inValue != null && inValue.trim().length() > 0) {
      result = inValue;
      if (occurrenceValue.equals(FIRST_VALUE)) {
        result = inValue.replaceFirst(regexValue, replacementValue);
      } else {
        if (occurrenceValue.equals(ALL_VALUE)) {
          result = inValue.replaceAll(regexValue, replacementValue);
        }
      }
    }

    productionContext.setOutputValue(TypeConstants.OUT_VALUE_NAME_CONTRACT, result);

  }

  public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    // Nothing to do
  }

}
