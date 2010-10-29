/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.common.helper.ClassHelper;
import org.eclipse.egf.common.helper.EMFHelper;
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
public abstract class ProductionContext<P extends Object, T extends Object> implements IProductionContext<P, T> {

    public static final String __inputMode = "Input"; //$NON-NLS-1$

    public static final String __outputMode = "Output"; //$NON-NLS-1$

    protected class Data {

        private T _key;

        private Class<?> _clazz;

        private Object _value;

        private String _mode;

        public Data(T key, Class<?> clazz, Object value, String mode) throws InvocationException {
            if (key == null) {
                throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, mode, getName()));
            }
            _key = key;
            if (clazz == null) {
                throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_class, new Object[] {
                        mode, EMFHelper.getText(_key), getName()
                }));
            }
            _clazz = clazz;
            // null value is a valid value
            if (value != null && _clazz.isInstance(value) == false) {
                throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] {
                        _clazz.getName(), mode, EMFHelper.getText(_key), value.getClass().getName(), getName()
                }));
            }
            _value = value;
            _mode = mode;
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
                throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] {
                        _clazz.getName(), _mode, EMFHelper.getText(_key), value.getClass().getName(), getName()
                }));
            }
            _value = value;
        }

    }

    protected String _name;

    protected ProjectBundleSession _projectBundleSession;

    protected P _element;

    protected IProductionContext<?, ?> _parent;

    protected final Map<T, Data> _inputDatas = new HashMap<T, Data>();

    protected final Map<T, Data> _outputDatas = new HashMap<T, Data>();

    public ProductionContext(ProjectBundleSession projectBundleSession, P element, String name) {
        Assert.isNotNull(projectBundleSession);
        Assert.isNotNull(element);
        Assert.isNotNull(name);
        _projectBundleSession = projectBundleSession;
        _element = element;
        _name = name;
    }

    public ProductionContext(IProductionContext<?, ?> parent, ProjectBundleSession projectBundleSession, P element, String name) {
        Assert.isNotNull(projectBundleSession);
        Assert.isNotNull(element);
        Assert.isNotNull(name);
        _parent = parent;
        _projectBundleSession = projectBundleSession;
        _element = element;
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public P getElement() {
        return _element;
    }

    public IProductionContext<?, ?> getParent() {
        return _parent;
    }

    public Bundle getBundle(String id) throws InvocationException {
        try {
            return _projectBundleSession.getBundle(id);
        } catch (CoreException ce) {
            throw new InvocationException(ce);
        }
    }

    public void clear() {
        _inputDatas.clear();
        _outputDatas.clear();
    }

    public boolean isSetAtRuntime(Object key) throws InvocationException {
        // Usual Tests
        if (key == null) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, __inputMode, getName()));
        }
        // Looking for Parent
        if (getParent() != null) {
            return getParent().isSetAtRuntime(key);
        }
        return false;
    }

    public void addInputData(T key, Class<?> clazz, Object object, boolean check) throws InvocationException {
        if (_inputDatas.put(key, new Data(key, clazz, object, __inputMode)) != null) {
            if (check) {
                throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_non_unique_key, new Object[] {
                        __inputMode, EMFHelper.getText(key), getName()
                }));
            }
        }
    }

    public void addOutputData(T key, Class<?> clazz, Object object, boolean check) throws InvocationException {
        if (_outputDatas.put(key, new Data(key, clazz, object, __outputMode)) != null) {
            if (check) {
                throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_non_unique_key, new Object[] {
                        __outputMode, EMFHelper.getText(key), getName()
                }));
            }
        }
    }

    public void setOutputValue(Object key, Object value) throws InvocationException {
        // Usual Tests
        if (key == null) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, __outputMode, getName()));
        }
        // Propagate Value to parent if necessary
        if (getParent() != null) {
            getParent().setOutputValue(key, value);
        }
        // Fetch available output data
        Data outputData = _outputDatas.get(key);
        if (outputData == null) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_unknown_key, new Object[] {
                    __outputMode, EMFHelper.getText(key), getName()
            }));
        }
        // null value is a valid value
        if (value != null && (ClassHelper.isSubClass(value.getClass(), outputData.getType()) == false || outputData.getType().isInstance(value) == false)) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] {
                    outputData.getType().getName(), __outputMode, EMFHelper.getText(key), value.getClass().getName(), getName()
            }));
        }
        // Set output value
        outputData.setValue(value);
        // Set input value if it exists
        Data inputData = _inputDatas.get(key);
        if (inputData != null) {
            inputData.setValue(value);
        }
    }

    public Class<?> getInputValueType(Object key) throws InvocationException {
        // Usual Tests
        if (key == null) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, __inputMode, getName()));
        }
        // Looking for Parent Value Type if available
        Class<?> valueType = null;
        if (getParent() != null) {
            valueType = getParent().getInputValueType(key);
        }
        // Looking for local Value Type if necessary
        if (valueType == null) {
            Data inputData = _inputDatas.get(key);
            if (inputData != null) {
                valueType = inputData.getType();
            }
        }
        return valueType;
    }

    public <R> R getInputValue(Object key, Class<R> clazz) throws InvocationException {
        // Usual Tests
        if (key == null) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, __inputMode, getName()));
        }
        // Looking for Parent Value if available
        R value = null;
        if (getParent() != null) {
            value = getParent().getInputValue(key, clazz);
        }
        // Looking for local value if necessary
        if (value == null) {
            Data inputData = _inputDatas.get(key);
            if (inputData != null) {
                value = getValue(key, clazz, inputData, __inputMode);
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
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, __outputMode, getName()));
        }
        // Looking for Parent Value Type if available
        Class<?> valueType = null;
        if (getParent() != null) {
            valueType = getParent().getOutputValueType(key);
        }
        // Looking for local Value Type if necessary
        if (valueType == null) {
            Data outputData = _outputDatas.get(key);
            if (outputData != null) {
                valueType = outputData.getType();
            }
        }
        return valueType;
    }

    public <R> R getOutputValue(Object key, Class<R> clazz) throws InvocationException {
        // Usual Tests
        if (key == null) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_null_key, __outputMode, getName()));
        }
        // Looking for Parent Value if available
        R value = null;
        if (getParent() != null) {
            value = getParent().getOutputValue(key, clazz);
        }
        // Looking for local value if necessary
        if (value == null) {
            Data outputData = _outputDatas.get(key);
            if (outputData != null) {
                value = getValue(key, clazz, outputData, __outputMode);
            }
        }
        return value;
    }

    public Collection<T> getOutputValueKeys() throws InvocationException {
        return _outputDatas.keySet();
    }

    protected <R> R getValue(Object key, Class<R> clazz, Data data, String mode) throws InvocationException {
        if (data == null || data.getValue() == null) {
            return null;
        }
        if (ClassHelper.isSubClass(data.getValue().getClass(), clazz) == false) {
            throw new InvocationException(NLS.bind(CoreProducerMessages.ProductionContext_wrong_type, new Object[] {
                    data.getType().getName(), mode, EMFHelper.getText(key), clazz.getName(), getName()
            }));
        }
        try {
            return clazz.cast(data.getValue());
        } catch (ClassCastException cce) {
            throw new InvocationException(cce);
        }
    }

}
