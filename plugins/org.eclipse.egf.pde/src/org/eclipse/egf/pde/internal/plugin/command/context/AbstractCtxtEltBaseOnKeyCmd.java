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

import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * Base class to implement commands that deal with context element based on a simple key in context extension-point.
 * @author fournier
 */
public abstract class AbstractCtxtEltBaseOnKeyCmd extends AbstractContextElementCommand {
  /**
   * Key value.
   */
  private String _keyValue;
  /**
   * Key type value.
   */
  private String _keyType;

  /**
   * Constructor.
   * @param contextId_p
   * @param contextElementId_p
   * @param keyValue_p
   * @param keyType_p
   * @param value_p
   */
  protected AbstractCtxtEltBaseOnKeyCmd(String contextId_p, String contextElementId_p, String keyValue_p, String keyType_p, String value_p) {
    super(contextId_p, contextElementId_p, value_p);
    _keyValue = keyValue_p;
    _keyType = keyType_p;
  }

  /**
   * Get the key value.
   * @return the keyValue
   */
  protected String getKeyIdAttributeValue() {
    return _keyValue;
  }

  /**
   * Get the key value.
   * @return the keyValue
   */
  protected String getKeyIdAttribute() {
    return ExtensionPointHelper.ATT_NAME;
  }

  /**
   * Set a simple key for given context element according to parameters values.
   * @param contextElement_p
   * @param keyNodeName_p
   * @param keyIdAttribute_p
   * @param keyIdAttributeValue_p
   */
  protected void setKeyValue(IPluginElement contextElement_p, String keyNodeName_p, String keyIdAttribute_p, String keyIdAttributeValue_p) {
    setSingleChild(contextElement_p, keyNodeName_p, keyIdAttribute_p, keyIdAttributeValue_p);
  }

  /**
   * Return the key type value
   * @return the keyType as a fully qualified class name.
   */
  protected String getKeyType() {
    return _keyType;
  }
}
