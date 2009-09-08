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

import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.data.reader.descriptor.ITypedDescriptor;


/**
 * Base class to describe the content of a EGF model element read from {@link IFactoryComponentReader} instance.
 * @author fournier
 */
public abstract class AbstractDescriptor extends GenericDescriptor implements ITypedDescriptor {
  /**
   * Reference to the factory component reader that creates this descriptor.
   */
  private IFactoryComponentReader _factoryComponentReader;
  /**
   * Reference to the id.
   */
  private String _id;
  private String _description;

  /**
   * Default constructor.
   */
  protected AbstractDescriptor() {
    this(null);
  }

  /**
   * Constructor.
   * @param reader_p
   */
  protected AbstractDescriptor(IFactoryComponentReader reader_p) {
    _factoryComponentReader = reader_p;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.ITypedDescriptor#getFactoryComponentReader()
   */
  public IFactoryComponentReader getFactoryComponentReader() {
    return _factoryComponentReader;
  }

  /**
   * Set given factory component reader as the one that creates this descriptor.
   * @param factoryComponentReader_p
   */
  public void setFactoryComponentReader(IFactoryComponentReader factoryComponentReader_p) {
    _factoryComponentReader = factoryComponentReader_p;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.ITypedDescriptor#getId()
   */
  public String getId() {
    return _id;
  }

  /**
   * Set the identifier.
   * @param id_p
   */
  public void setId(String id_p) {
    _id = id_p;
  }

  /**
   * @see org.eclipse.egf.model.data.reader.descriptor.ITypedDescriptor#getDescription()
   */
  public String getDescription() {
    return _description;
  }
  /**
   * Set the description.
   * @param description_p
   */
  public void setDescription(String description_p) {
    _description = description_p;
  }
}
