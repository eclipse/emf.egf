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
package org.eclipse.egf.core.internal.context;

import org.eclipse.egf.core.context.IProductionContext;
import org.eclipse.egf.core.context.IProductionContextFactory;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ProductionContextFactory implements IProductionContextFactory {

  public IProductionContext createProductionContext() {
    return new ProductionContext(null);
  }

  public IProductionContext createProductionContext(IProductionContext parent) {
    return new ProductionContext(parent);
  }

}
