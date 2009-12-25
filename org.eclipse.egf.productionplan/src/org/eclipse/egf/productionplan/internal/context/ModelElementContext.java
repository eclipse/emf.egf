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

import org.eclipse.egf.core.helper.EObjectHelper;
import org.eclipse.egf.core.production.internal.context.ProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ModelElement;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ModelElementContext<Q extends ModelElement> extends ProductionContext<Q> {

  public ModelElementContext(Q element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  @Override
  public String getName() {
    return EObjectHelper.getText(getElement());
  }

}
