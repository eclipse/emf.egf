/**
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.core.producer.context;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.core.helper.BundleSessionHelper;
import org.eclipse.egf.core.helper.EObjectHelper;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.producer.l10n.CoreProducerMessages;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * 
 * @author Xavier Maysonnave
 * 
 */
public abstract class ProductionContext<T extends Object> implements IProductionContext<T> {

  protected class Data {

    private T _key;

    private Class<?> _clazz;

    private Object _value;

    public Data(T key, Class<?> clazz, Object value) throws InvocationException {
      if (key == null) {
        throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
      }
      _key = key;
      if (clazz == null) {
        throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_class, getName()));
      }
      _clazz = clazz;
      // null value is a valid value
      if (value != null && _clazz.isInstance(value) == false) {
        throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { _clazz.getName(), EObjectHelper.getText(_key), value.getClass().getName(), getName() }));
      }
      _value = value;
    }

    public Class<?> getType() {
      return _clazz;
    }

    public Object getValue() {
      return _value;
    }

    public void setValue(Object value) throws InvocationException {
      // null value is a valid value
      if (value != null && _clazz.isInstance(value) == false) {
        throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { _clazz.getName(), EObjectHelper.getText(_key), value.getClass().getName(), getName() }));
      }
      _value = value;
    }

  }

  private Object _element;

  private ProjectBundleSession _projectBundleSession;

  protected IProductionContext<?> _parent;

  protected final Map<T, Data> _inputDatas = new HashMap<T, Data>();

  protected final Map<T, Data> _outputDatas = new HashMap<T, Data>();

  public ProductionContext(Object element, ProjectBundleSession projectBundleSession) {
    Assert.isNotNull(element);
    Assert.isNotNull(projectBundleSession);
    _element = element;
    _projectBundleSession = projectBundleSession;
  }

  public ProductionContext(IProductionContext<?> parent, Object element, ProjectBundleSession projectBundleSession) {
    Assert.isNotNull(element);
    Assert.isNotNull(projectBundleSession);
    _parent = parent;
    _element = element;
    _projectBundleSession = projectBundleSession;
  }

  public Object getElement() {
    return _element;
  }

  public IProductionContext<?> getParent() {
    return _parent;
  }

  public Bundle getBundle(String id) throws InvocationException {
    try {
      return _projectBundleSession.getBundle(id);
    } catch (CoreException ce) {
      throw new InvocationException(ce);
    }
  }

  public Bundle getBundle(IProject project) throws InvocationException {
    try {
      return _projectBundleSession.getBundle(project);
    } catch (CoreException ce) {
      throw new InvocationException(ce);
    }
  }

  public Bundle getBundle(IPlatformExtensionPoint platformExtensionPoint) throws InvocationException {
    try {
      return BundleSessionHelper.getBundle(_projectBundleSession, platformExtensionPoint);
    } catch (CoreException ce) {
      throw new InvocationException(ce);
    }
  }

  public void clear() {
    _inputDatas.clear();
    _outputDatas.clear();
  }

  public abstract String getName();

  public void addInputData(T key, Class<?> clazz, Object object) throws InvocationException {
    if (_inputDatas.put(key, new Data(key, clazz, object)) != null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_non_unique_key, EObjectHelper.getText(key), getName()));
    }
  }

  public void addOutputData(T key, Class<?> clazz, Object object) throws InvocationException {
    if (_outputDatas.put(key, new Data(key, clazz, object)) != null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_non_unique_key, EObjectHelper.getText(key), getName()));
    }
  }

  public void setOutputValue(Object key, Object value) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
    }
    // Propagate Value to parent if necessary
    if (getParent() != null) {
      getParent().setOutputValue(key, value);
    }
    // Fetch available data
    Data data = _outputDatas.get(key);
    if (data == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, EObjectHelper.getText(key), getName()));
    }
    // null value is a valid value
    if (value != null && (ClassHelper.asSubClass(value.getClass(), data.getType()) == false || data.getType().isInstance(value) == false)) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { data.getType().getName(), EObjectHelper.getText(key), value.getClass().getName(), getName() }));
    }
    // Set local value
    data.setValue(value);
  }

  public Class<?> getInputValueType(Object key) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
    }
    // Looking for Parent Value Type if available
    Class<?> valueType = null;
    if (getParent() != null) {
      valueType = getParent().getInputValueType(key);
    }
    // Looking for local Value Type if necessary
    if (valueType == null) {
      Data data = _inputDatas.get(key);
      if (data != null) {
        valueType = data.getType();
      }
    }
    return valueType;
  }

  public <R> R getInputValue(Object key, Class<R> clazz) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
    }
    // Looking for Parent Value if available
    R value = null;
    if (getParent() != null) {
      value = getParent().getInputValue(key, clazz);
    }
    // Looking for local value if necessary
    if (value == null) {
      Data data = _inputDatas.get(key);
      if (data != null) {
        value = getValue(key, clazz, data);
      }
    }
    return value;
  }

  public Collection<T> getInputValueKeys() throws InvocationException {
    return _inputDatas.keySet();
  }

  public Class<?> getOutputValueType(Object key) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
    }
    // Looking for Parent Value Type if available
    Class<?> valueType = null;
    if (getParent() != null) {
      valueType = getParent().getOutputValueType(key);
    }
    // Looking for local Value Type if necessary
    if (valueType == null) {
      Data data = _outputDatas.get(key);
      if (data != null) {
        valueType = data.getType();
      }
    }
    return valueType;
  }

  public <R> R getOutputValue(Object key, Class<R> clazz) throws InvocationException {
    // Usual Tests
    if (key == null) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, getName()));
    }
    // Looking for Parent Value if available
    R value = null;
    if (getParent() != null) {
      value = getParent().getOutputValue(key, clazz);
    }
    // Looking for local value if necessary
    if (value == null) {
      Data data = _outputDatas.get(key);
      if (data != null) {
        value = getValue(key, clazz, data);
      }
    }
    return value;
  }

  public Collection<T> getOutputValueKeys() throws InvocationException {
    return _outputDatas.keySet();
  }

  protected <R> R getValue(Object key, Class<R> clazz, Data data) throws InvocationException {
    if (data == null || data.getValue() == null) {
      return null;
    }
    if (ClassHelper.asSubClass(data.getValue().getClass(), clazz) == false) {
      throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] { data.getType().getName(), EObjectHelper.getText(key), clazz.getName(), getName() }));
    }
    try {
      return clazz.cast(data.getValue());
    } catch (ClassCastException cce) {
      throw new InvocationException(cce);
    }
  }

}
