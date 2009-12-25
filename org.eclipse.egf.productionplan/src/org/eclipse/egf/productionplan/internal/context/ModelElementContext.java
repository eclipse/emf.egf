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

import org.eclipse.egf.core.production.internal.context.ProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ModelElement;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ModelElementContext<Q extends ModelElement> extends ProductionContext<Q> {

  private String _name;

  public ModelElementContext(Q element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  @Override
  public String getName() {
    if (_name == null) {
      _name = getElement().getName() != null && getElement().getName().trim().length() != 0 ? getElement().getName().trim() : getElement().getID() != null && getElement().getID().trim().length() != 0 ? getElement().getID().trim() : "Unknown"; //$NON-NLS-1$
    }
    return _name;
  }

}
