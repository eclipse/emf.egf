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
import org.eclipse.egf.pde.util.ExtensionHelper;
import org.eclipse.pde.core.plugin.IPluginElement;


/**
 * Base class to implement commands that deal with context element in context extension-point.
 * @author fournier
 */
public abstract class AbstractContextElementCommand extends AbstractContextCommand {
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(AbstractContextElementCommand.class.getPackage().getName());
  /**
   * Context element id value.
   */
  private String _contextElementId;
  /**
   * Context element value used as either as string value or classValue.
   */
  private String _value;

  /**
   * Constructor.
   * @param contextId_p id of the context used as parent.
   * @param contextElementId_p id of the context element.
   * @param value_p value set as stringValue or classValue.
   */
  protected AbstractContextElementCommand(String contextId_p, String contextElementId_p, String value_p) {
    super(contextId_p);
    _contextElementId = contextElementId_p;
    _value = value_p;
  }

  /**
   * Get the value for context element id attribute.<br>
   * It's either a contract element reference id value or a simple string value used as a key.
   * @return the contextElementIdentifier
   */
  protected String getContextElementIdAttributeValue() {
    return _contextElementId;
  }

  /**
   * Get id attribute for the context element.
   * @return
   */
  protected String getContextElementIdAttribute() {
    return ExtensionPointHelper.ATT_ID;
  }

  /**
   * Create a context value plug-in element.
   * @param contextElement_p
   * @return
   */
  protected IPluginElement createContextValueElement(IPluginElement contextElement_p) {
    IPluginElement result = null;
    // Look up for the value as a child of given context element.
    IPluginElement[] valueElements = ExtensionHelper.getPluginElement(contextElement_p, IContextConstants.CONTEXT_ELEMENT_VALUE_CHILD);
    // If nothing is retrieved, create it.
    if (valueElements.length == 0) {
      result = ExtensionHelper.createPluginElement(contextElement_p, IContextConstants.CONTEXT_ELEMENT_VALUE_CHILD);
    } else {
      // Get the first element.
      result = valueElements[0];
    }
    return result;
  }

  /**
   * Set value child element.
   * @param contextElement_p
   * @param value_p the value to set.
   */
  protected void setValue(IPluginElement contextElement_p) {
    // Check if the child already exists ?
    IPluginElement valueElement = createContextValueElement(contextElement_p);
    try {
      valueElement.setAttribute(IContractConstants.CONTRACT_ELEMENT_CHILD_ATT_VALUE, _value);
    } catch (CoreException exception_p) {
      StringBuilder loggerMessage = new StringBuilder("AbstractContextElementCommand.setValue(..) _ "); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString());
    }
  }

  /**
   * Create a context element with its value set.
   * @return
   */
  protected IPluginElement doCreateContextElement() {
    // Get the extension where this context element is stored.
    IPluginElement extension = getExtensionElementWithId(getContextId());
    // Look up for a contextElement related to contextElement id.
    String contextElementIdAttribute = getContextElementIdAttribute();
    String contextElementIdValue = getContextElementIdAttributeValue();
    IPluginElement contextElement = createExtensionElementChild(extension, IContextConstants.CONTEXT_CHILD, contextElementIdAttribute, contextElementIdValue);
    // Set context element children.
    setValue(contextElement);
    return contextElement;
  }

  /**
   * Return the context element value.
   * @return the value
   */
  protected String getValue() {
    return _value;
  }
}