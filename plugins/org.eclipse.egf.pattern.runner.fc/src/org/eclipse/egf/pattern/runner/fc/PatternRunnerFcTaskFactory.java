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

import org.eclipse.egf.core.task.AbstractTask;
import org.eclipse.egf.pattern.runner.task.PatternRunnerTaskFactory;


/**
 * @author Guillaume Brocard
 */
public class PatternRunnerFcTaskFactory extends PatternRunnerTaskFactory {
  
  /**
   * @see org.eclipse.egf.pattern.runner.task.PatternRunnerTaskFactory#createTask()
   */
  @Override
  public AbstractTask createTask() {
    return new PatternRunnerFcTask();
  }
  
}
