/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.runner.fc;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.CoreActivator;
import org.eclipse.egf.model.FactoryComponent;
import org.eclipse.egf.pattern.runner.task.PatternElementRunnerTask;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * @author Guillaume Brocard
 */
public class PatternRunnerFcTask extends PatternElementRunnerTask {
  
  /**
   * Factory Component Id key.
   */
  private static final String FACTORY_COMPONENT_ID = "factoryComponentId"; //$NON-NLS-1$
  
  /**
   * Keep a reference on loaded factory component.
   */
  private FactoryComponent _factoryComponent;

  /**
   * @see org.eclipse.egf.pattern.runner.task.PatternElementRunnerTask#getModel()
   */
  @Override
  protected Resource getModel() {
    Resource fakedResource = null;
    // Get provided factory component id.
    String factoryComponentId = (String) getContextElementValue(FACTORY_COMPONENT_ID);
    // Precondition.
    if (null == factoryComponentId) {
      return fakedResource;
    }
    _factoryComponent = CoreActivator.getDefault().getFactoryComponent(factoryComponentId);
    if (null != _factoryComponent) {
      fakedResource = new ResourceImpl();
      fakedResource.getContents().add(_factoryComponent);
    }
    return fakedResource;
  }

  /**
   * @see org.eclipse.egf.pattern.runner.task.PatternElementRunnerTask#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor progressMonitor_p) {
    boolean isOk = super.doExecute(progressMonitor_p);
    // Since a resource was created to match pattern runner API, all added objects reference it through eResource() method.
    // Hence, we must detach the created resource from its content.
    if (null != _factoryComponent) {
      // Generic way to detach a FC from its resource (a FC has no container in FactoryComponent meta-model).
      EcoreUtil.remove(_factoryComponent);
    }
    return isOk;
  }
  
}
