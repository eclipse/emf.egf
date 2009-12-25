/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.production.context;

import org.eclipse.egf.core.production.InvocationException;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IProductionContext<Q extends Object> {

  public String getName();

  public Q getElement();

  public void reset();

  public Class<?> getInputValueType(String name) throws InvocationException;

  public <T extends Object> T getInputValue(String name, Class<T> clazz) throws InvocationException;

  public Class<?> getOutputValueType(String name) throws InvocationException;

  public <T extends Object> T getOutputValue(String name, Class<T> clazz) throws InvocationException;

  public void setOutputValue(String name, Object value) throws InvocationException;

}
