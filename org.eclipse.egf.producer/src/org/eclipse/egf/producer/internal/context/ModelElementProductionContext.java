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
package org.eclipse.egf.producer.internal.context;

import org.eclipse.egf.core.helper.EObjectHelper;
import org.eclipse.egf.core.producer.context.ProductionContext;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.producer.context.IModelElementProductionContext;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ModelElementProductionContext<T extends ModelElement> extends ProductionContext<T> implements IModelElementProductionContext<T> {

  public ModelElementProductionContext(ModelElement element, ProjectBundleSession projectBundleSession) {
    super(element, projectBundleSession);
  }

  public ModelElementProductionContext(IModelElementProductionContext<?> parent, ModelElement element, ProjectBundleSession projectBundleSession) {
    super(parent, element, projectBundleSession);
  }

  @Override
  public ModelElement getElement() {
    return (ModelElement) super.getElement();
  }

  @Override
  public IModelElementProductionContext<?> getParent() {
    return (IModelElementProductionContext<?>) super.getParent();
  }

  @Override
  public String getName() {
    return EObjectHelper.getText(getElement());
  }

}
