/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.producer.context;

import java.util.Collection;

import org.eclipse.egf.core.producer.InvocationException;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IProductionContext<P extends Object, T extends Object> {

    public String getName();

    public P getElement();

    public boolean isSetAtRuntime(Object key) throws InvocationException;

    public IProductionContext<?, ?> getParent();

    public Bundle getBundle(String id) throws InvocationException;

    public Class<?> getInputValueType(Object key) throws InvocationException;

    public <R> R getInputValue(Object key, Class<R> clazz) throws InvocationException;

    public Collection<T> getInputValueKeys() throws InvocationException;

    public Class<?> getOutputValueType(Object key) throws InvocationException;

    public <R> R getOutputValue(Object key, Class<R> clazz) throws InvocationException;

    public Collection<T> getOutputValueKeys() throws InvocationException;

    public void setOutputValue(Object key, Object value) throws InvocationException;

}
