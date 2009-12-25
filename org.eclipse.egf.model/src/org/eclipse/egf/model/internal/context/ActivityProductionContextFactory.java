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

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.context.IProductionContext;
import org.eclipse.egf.model.context.IActivityProductionContextFactory;
import org.eclipse.egf.model.fcore.Activity;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ActivityProductionContextFactory implements IActivityProductionContextFactory {

  public IProductionContext createTaskProductionContext(IProductionContext parent, Activity activity) {
    return EGFCorePlugin.getProductionContextFactory().createProductionContext(parent);
  }

}
