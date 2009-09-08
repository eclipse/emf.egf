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
package org.eclipse.egf.core.reader.descriptor;

import org.eclipse.egf.model.Type;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.data.reader.descriptor.IContextElementDescriptor;


/**
 * Describe the content of a context element read from an {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public class ContextElementDescriptor extends AbstractDescriptor implements IContextElementDescriptor {
  private String _contractReferenceId;
  private String _key;
  private String _readableValue;
  private Type _type;
  private String _pluginId;

  /**
   * Constructor.
   */
  public ContextElementDescriptor() {
    this(null);
  }

  /**
   * Constructor.
   * @param reader_p
   */
  public ContextElementDescriptor(IFactoryComponentReader reader_p) {
    super(reader_p);
  }

  /**
   * Get the contract reference id.
   * @return can be null.
   */
  public String getContractReferenceId() {
    return _contractReferenceId;
  }

  /**
   * Set given contract reference id.
   * @param contractReferenceId_p
   */
  public void setContractReferenceId(String contractReferenceId_p) {
    _contractReferenceId = contractReferenceId_p;
  }

  /**
   * Get the key
   * @return can be null.
   */
  public String getKey() {
    return _key;
  }

  /**
   * Set given key.
   * @param key_p
   */
  public void setKey(String key_p) {
    _key = key_p;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IContextElementDescriptor#getReadableValue()
   */
  public String getReadableValue() {
    return _readableValue;
  }

  /**
   * Set given readable value.
   * @param readableValue_p
   */
  public void setReadableValue(String readableValue_p) {
    _readableValue = readableValue_p;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IContextElementDescriptor#getType()
   */
  public Type getType() {
    return _type;
  }

  /**
   * Set direct type.
   * @param
   */
  public void setType(Type type_p) {
    _type = type_p;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.IContextElementDescriptor#getPluginId()
   */
  public String getPluginId() {
    return _pluginId;
  }

  /**
   * Set the plug-in id.
   * @param pluginId_p the pluginId to set
   */
  public void setPluginId(String pluginId_p) {
    _pluginId = pluginId_p;
  }
}
