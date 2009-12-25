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
package org.eclipse.egf.model.internal.context;

import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.internal.context.ProductionContext;
import org.eclipse.egf.model.context.IModelProductionContextFactory;
import org.eclipse.egf.model.fcore.Activity;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ModelProductionContextFactory implements IModelProductionContextFactory {

  public IProductionContext createModelProductionContext(IProductionContext parent, Activity activity) {
    return new ProductionContext(parent, activity.getExternalName());
  }

  public IProductionContext createModelProductionContext(Activity activity) {
    return new ProductionContext(activity.getExternalName());
  }

}
