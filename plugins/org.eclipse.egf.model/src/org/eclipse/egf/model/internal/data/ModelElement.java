/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.internal.data;

import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.egf.model.ModelActivator;
import org.eclipse.egf.model.data.helper.IFactoryComponentLoadingHelper;
import org.eclipse.egf.model.data.reader.descriptor.IFactoryComponentReader;
import org.eclipse.egf.model.internal.helper.ModelUIDGeneratorHelper;


/**
 * Base class for every EGF model element.
 * @author fournier
 */
public abstract class ModelElement extends MinimalEObjectImpl.Container implements IAdaptable {
  
  /**
   * Reference to the factory component reader that is able to retrieve data.
   */
  private IFactoryComponentReader _factoryComponentReader;
  
  /**
   * Map of registered adaptables.<br>
   * Key value is the adapted class type; value is the instance object.
   */
  private Map<Class<?>, Object> _adaptables;

  /**
   * Generate a unique business id.
   * @return
   */
  protected String generateId() {
    return ModelUIDGeneratorHelper.getInstance().createUID(this);
  }

  /**
   * Get the business id of current element.
   * @return
   */
  public abstract String getId();

  /**
   * Set given business id.
   * @param id_p
   */
  public abstract void setId(String id_p);

  /**
   * Get a readable name of current element.
   * @return
   */
  public abstract String getName();

  /**
   * Set given name.
   * @param name_p
   */
  public abstract void setName(String name_p);

  /**
   * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapterType_p) {
    Object result = null;
    // If adaptable map exists, try to get the associated object to given adapter type.
    if (null != _adaptables) {
      result = _adaptables.get(adapterType_p);
    }
    return result;
  }

  /**
   * Set given object which is an instance of the given class type associated with given object.
   */
  public void setAdapter(Class<?> type_p, Object instance_p) {
    if (null == _adaptables) {
      _adaptables = new HashMap<Class<?>, Object>(1);
    }
    _adaptables.put(type_p, instance_p);
  }

  /**
   * Set the factory component reader that has been used to collect data for this object.
   * @param reader_p
   */
  public void setFactoryComponentReader(IFactoryComponentReader reader_p) {
    _factoryComponentReader = reader_p;
  }

  /**
   * Get the factory component reader that has been used to collect data for this object.
   * @return a reader
   */
  public IFactoryComponentReader getFactoryComponentReader() {
    return _factoryComponentReader;
  }

  /**
   * Get factory component loading helper.
   * @return
   */
  protected IFactoryComponentLoadingHelper getFactoryComponentLoadingHelper() {
    return ModelActivator.getDefault().getFactoryComponentLoadingHelper();
  }

  /**
   * Do nothing.
   */
  public void addPropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p) {
    // Do nothing. This method has been created to avoid annoying error message when ModelElement objects are involved in JFace data binding.
  }

  /**
   * Do nothing.
   */
  public void removePropertyChangeListener(String propertyName_p, PropertyChangeListener listener_p) {
    // Do nothing. This method has been created to avoid annoying error message when ModelElement objects are involved in JFace data binding.
  }
  
}
