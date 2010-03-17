/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.provider;

import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.emf.common.notify.AdapterFactory;

/**
 * @author Xavier Maysonnave
 * 
 */
public class InvocationContractCustomItemProvider extends InvocationContractItemProvider {

  public InvocationContractCustomItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the label text for the adapted class.
   */
  @Override
  public String getText(Object object) {
    InvocationContract invocationContract = (InvocationContract) object;
    String invocation = null;
    if (invocationContract.getInvocation() != null) {
      invocation = invocationContract.getInvocation().getName();
    }
    String invoked = null;
    if (invocationContract.getInvokedContract() != null) {
      invoked = invocationContract.getInvokedContract().getName();
      String mode = null;
      if (invocationContract.getInvokedContract().getMode() != null) {
        mode = "[" + invocationContract.getInvokedContract().getMode().getLiteral() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
      }
      if ((invoked == null || invoked.length() == 0) && mode != null) {
        invoked = mode;
      } else if (mode != null) {
        invoked = invoked + " " + mode; //$NON-NLS-1$
      }
    }
    String label = "[" + getString("_UI_InvocationContract_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    if (invoked != null) {
      label = invoked + " " + label; //$NON-NLS-1$
    }
    if (invocation != null) {
      label = invocation + " -> " + label; //$NON-NLS-1$
    }
    return label;
  }

}
