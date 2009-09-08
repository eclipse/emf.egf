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

import org.eclipse.egf.core.extensionpoint.IFactoryComponentConstants;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * This commands creates or updates a contextElement based on a contractElementReference in an extension matching context extension-point.
 * @author fournier
 */
public class SetCtxtEltBasedOnContractEltRefCmd extends AbstractCtxtEltBasedOnContractEltRefCmd {
  /**
   * Constructor.
   * @param contextId_p
   *          id of the context extension used as parent.
   * @param contextElementId_p
   *          id of the context element.
   * @param contractElementReferenceId_p
   *          id of the contract element reference.
   * @param value_p
   *          value set as stringValue or classValue.
   */
  public SetCtxtEltBasedOnContractEltRefCmd(String contextId_p, String contextElementId_p, String contractElementReferenceId_p, String value_p) {
    super(contextId_p, contextElementId_p, contractElementReferenceId_p, value_p);
  }

  /**
   * @see org.eclipse.egf.pde.plugin.command.AbstractExtensionChangesCommand#execute()
   */
  @Override
  public void execute() {
    super.execute();
    // Create or update context element.
    IPluginElement contextElement = doCreateContextElement();
    // Set contract element reference content.
    setContractElementReference(contextElement, IFactoryComponentConstants.CONTRACT_REF_CHILD, getContractElementReferenceIdAttribute(),
                                getContractElementReferenceIdAttributeValue());
  }
}
