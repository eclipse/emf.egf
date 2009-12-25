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
package org.eclipse.egf.productionplan.internal.context;

import org.eclipse.egf.core.production.InvocationException;
import org.eclipse.egf.core.production.internal.context.ProductionContext;
import org.eclipse.egf.model.fcore.ModelElement;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ModelElementContext<Q extends ModelElement> extends ProductionContext<Q> {

  public ModelElementContext(Q element) {
    super(element);
  }

  @Override
  public String getName() {
    return getElement().getExternalName() != null ? getElement().getExternalName() : "Unknown"; //$NON-NLS-1$ 
  }

  @Override
  protected void addInputData(String name, Class<?> clazz, Object object) throws InvocationException {
    super.addInputData(name, clazz, object);
  }

  @Override
  protected void addOutputData(String name, Class<?> clazz, Object object) throws InvocationException {
    super.addOutputData(name, clazz, object);
  }

}
