/**
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
 */
package org.eclipse.egf.model.fcore.provider;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

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
      IItemLabelProvider provider = (IItemLabelProvider) (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory()).adapt(invocationContract.getInvocation(), IItemLabelProvider.class);
      if (provider == null) {
        invocation = EMFHelper.getText(invocationContract.getInvocation());
      } else {
        invocation = provider.getText(invocationContract.getInvocation());
      }
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
