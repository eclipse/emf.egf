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
package org.eclipse.egf.core.production.internal.context;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.egf.core.internal.context.EGFContext;
import org.eclipse.egf.core.production.EGFCoreProductionPlugin;
import org.eclipse.egf.core.production.context.IProductionContext;
import org.eclipse.egf.core.production.session.ProjectBundleSession;

/**
 * 
 * @author Xavier Maysonnave
 * 
 */
public class ProductionContext extends EGFContext implements IProductionContext {

  private ProjectBundleSession _projectBundleSession;

  private String _name;

  public ProductionContext(String name) {
    _name = name;
  }

  public ProductionContext(IProductionContext parent, String name) {
    super(parent);
    _name = name;
  }

  public ProjectBundleSession getProjectBundleSession() {
    if (getParent() != null) {
      return ((IProductionContext) getParent()).getProjectBundleSession();
    }
    if (_projectBundleSession == null) {
      _projectBundleSession = new ProjectBundleSession(EGFCoreProductionPlugin.getDefault().getBundle().getBundleContext());
    }
    return _projectBundleSession;
  }

  public String getName() {
    return _name;
  }

  public void dispose() throws CoreException {
    if (_projectBundleSession != null) {
      _projectBundleSession.dispose();
    }
  }

}
