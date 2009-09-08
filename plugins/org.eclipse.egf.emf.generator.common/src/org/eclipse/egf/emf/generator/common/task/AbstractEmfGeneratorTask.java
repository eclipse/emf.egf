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
package org.eclipse.egf.emf.generator.common.task;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.core.task.AbstractTask;
import org.eclipse.egf.core.ui.actions.AbstractGenerateCodeOperation;
import org.eclipse.egf.fc.generator.java.model.AbstractGenModelGeneratorAdapterFactory;


/**
 * Base class to implement tasks that perform code generation based on EMF generators such as Edit, Editor...
 * @author Guillaume Brocard
 */
public abstract class AbstractEmfGeneratorTask extends AbstractTask {
  
  /**
   * Log4j reference logger.
   */
  private static final Logger __logger = Logger.getLogger(AbstractEmfGeneratorTask.class.getPackage().getName());
  
  /**
   * Define a constant according to contract defined by EMF generator edit factory component.
   */
  private static final String ECORE_MODEL_PATH = "modelRelativePath"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by EMF generator edit factory component.
   */
  private static final String GENERATOR_ADAPTER_FACTORY = "generatorAdapterFactory"; //$NON-NLS-1$
  
  /**
   * Define a constant according to contract defined by java generator factory component.<br>
   * That allows to define its own merge rules.
   */
  private static final String MERGE_RULES_RELATIVE_PATH = "mergeRulesPath"; //$NON-NLS-1$

  /**
   * @see org.eclipse.egf.core.task.AbstractTask#doExecute(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  protected boolean doExecute(IProgressMonitor progressMonitor_p) {
    // Get the EMF generate code operation to run.
    AbstractGenerateCodeOperation operation = getEmfGenerateCodeOperation();
    // Set the project folder.
    operation.setModelPath(getModelPath());
    AbstractGenModelGeneratorAdapterFactory generatorAdapterFactory = getGeneratorAdapterFactory();
    String mergeRulesPath = getMergeRulesRelativePath();
    // Set the EMF Merge rules file (if any).
    if (null != mergeRulesPath) {
      generatorAdapterFactory.setMergeRulesRelativePath(mergeRulesPath);
    }
    operation.setGeneratorAdapterFactory(generatorAdapterFactory);
    try {
      operation.run(progressMonitor_p);
    } catch (Exception exception_p) {
      StringBuilder loggerMessage = new StringBuilder("AbstractEmfGeneratorTask.doExecute(..) _ "); //$NON-NLS-1$
      loggerMessage.append("Failed to generate EMF code").append(" for model:").append(getModelPath()); //$NON-NLS-1$ //$NON-NLS-2$
      __logger.warn(loggerMessage.toString(), exception_p);
    }
    return operation.getResult();
  }

  /**
   * Get the {@link AbstractGenerateCodeOperation} instance to execute.
   * @return
   */
  protected abstract AbstractGenerateCodeOperation getEmfGenerateCodeOperation();

  /**
   * Return the Ecore model path
   * @return
   */
  private String getModelPath() {
    return (String) getContextElementValue(ECORE_MODEL_PATH);
  }

  /**
   * Get the generator adapter factory.
   * @return
   */
  private AbstractGenModelGeneratorAdapterFactory getGeneratorAdapterFactory() {
    return (AbstractGenModelGeneratorAdapterFactory) getContextElementValue(GENERATOR_ADAPTER_FACTORY);
  }

  /**
   * Get the merge rules file relative path as defined by {@link FileHelper}.
   * @return
   */
  private String getMergeRulesRelativePath() {
    return (String) getContextElementValue(MERGE_RULES_RELATIVE_PATH);
  }
  
}
