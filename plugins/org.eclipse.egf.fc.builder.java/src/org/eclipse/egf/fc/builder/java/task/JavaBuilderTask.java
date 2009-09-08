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
package org.eclipse.egf.fc.builder.java.task;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.task.AbstractTask;
import org.eclipse.egf.fc.builder.java.internal.task.JavaBuilderOperation;


/**
 * Java project builder task.
 * 
 * @author brocard
 */
public class JavaBuilderTask extends AbstractTask {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(JavaBuilderTask.class.getPackage().getName());
  
  /**
   * Define project name constant according to contract definition.
   */
  private static final String FACTORY_COMPONENT_PROJECT_NAME = "assetProjectName"; //$NON-NLS-1$

  /**
   * Return the factory component project name
   * @return
   */
  private String getFactoryComponentProjectName() {
    return (String) getContextElementValue(FACTORY_COMPONENT_PROJECT_NAME);
  }

  /**
   * @see org.eclipse.egf.core.task.AbstractTask#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor progressMonitor_p) {
    String fcProjectName = getFactoryComponentProjectName();
    JavaBuilderOperation builderOperation = new JavaBuilderOperation(fcProjectName);
    builderOperation.setTicksCount(getTicksCount());
    try {
      builderOperation.run(progressMonitor_p);
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("JavaBuilderTask.doExecute(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Failed to build ").append(fcProjectName); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return builderOperation.getResult();
  }
  
}
