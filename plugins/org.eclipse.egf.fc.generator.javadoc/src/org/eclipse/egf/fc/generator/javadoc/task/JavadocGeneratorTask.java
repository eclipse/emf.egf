/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.fc.generator.javadoc.task;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.task.AbstractTask;
import org.eclipse.egf.fc.generator.javadoc.internal.task.JavadocGeneratorOperation;


/**
 * @author brocard
 */
public class JavadocGeneratorTask extends AbstractTask {
  /**
   * Log4j reference logger.
   */
  static final Logger __logger = Logger.getLogger(JavadocGeneratorTask.class.getPackage().getName());
  /**
   * Define a constant according to contract defined by JavadocGenerator factory component.
   */
  private static final String FACTORY_COMPONENT_PROJECT_NAME = "assetProjectName"; //$NON-NLS-1$
  /**
   * Define a constant according to contract defined by JavadocGenerator asset.
   */
  private static final String SRC_DIRECTORY = "sourceDirectory"; //$NON-NLS-1$

  /**
   * Return the factory component project name
   * @return
   */
  private String getFactoryComponentProjectName() {
    return (String) getContextElementValue(FACTORY_COMPONENT_PROJECT_NAME);
  }

  /**
   * Return the source directory.
   * @return
   */
  private String getSourceDirectory() {
    return (String) getContextElementValue(SRC_DIRECTORY);
  }

  /**
   * @see org.eclipse.egf.core.task.AbstractTask#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor progressMonitor_p) {
    JavadocGeneratorOperation generatorOperation = new JavadocGeneratorOperation(getFactoryComponentProjectName(), getSourceDirectory());
    generatorOperation.setTicksCount(getTicksCount());
    try {
      generatorOperation.run(progressMonitor_p);
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("JavadocGeneratorTask.doExecute(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Failed to generate java doc for ").append(getFactoryComponentProjectName()); //$NON-NLS-1$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return generatorOperation.getResult();
  }
}
