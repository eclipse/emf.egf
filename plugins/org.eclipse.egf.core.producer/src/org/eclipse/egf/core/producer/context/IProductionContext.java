/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
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
