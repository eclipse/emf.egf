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
package org.eclipse.egf.pde.internal.plugin.command.context;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.core.extensionpoint.IContextConstants;
import org.eclipse.egf.core.extensionpoint.IContractConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This commands creates or updates a contextElement based on a simple key in an extension matching context extension-point.
 * @author fournier
 */
public class SetCtxtEltBasedOnKeyCmd extends AbstractCtxtEltBaseOnKeyCmd {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(SetCtxtEltBasedOnKeyCmd.class.getPackage().getName());

  /**
   * @param contextId_p id of the context extension used as parent.
   * @param contextElementId_p id of the context element.
   * @param keyValue_p key value to set
   * @param keyType_p key type value.
   * @param value_p value set as stringValue or classValue.
   */
  public SetCtxtEltBasedOnKeyCmd(String contextId_p, String contextElementId_p, String keyValue_p, String keyType_p, String value_p) {
    super(contextId_p, contextElementId_p, keyValue_p, keyType_p, value_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Create or update context element.
    IPluginElement contextElement = doCreateContextElement();
    // Set content related to the key.
    setKeyValue(contextElement, IContextConstants.CONTEXT_ELEMENT_KEY_CHILD, getKeyIdAttribute(), getKeyIdAttributeValue());
  }

  /**
   * Set value child element.
   * @param contextElement_p
   * @param value_p the value to set.
   */
  @Override
  protected void setValue(IPluginElement contextElement_p) {
    // Check if the child already exists ?
    IPluginElement valueElement = createContextValueElement(contextElement_p);
    try {
      valueElement.setAttribute(IContractConstants.CONTRACT_ELEMENT_CHILD_ATT_VALUE, getValue());
      valueElement.setAttribute(ExtensionPointHelper.ATT_CLASS, getKeyType());
    } catch (CoreException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("SetCtxtEltBasedOnKeyCmd.setValue(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString());
    }
  }
}
