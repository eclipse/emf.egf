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
package org.eclipse.egf.batch.application.taskdefs;

import org.apache.tools.ant.BuildException;
import org.eclipse.egf.common.ant.AbstractAntTask;


/**
 * Base class to implement contributed Ant task that runs factory component.
 * @author Guillaume Brocard
 */
public abstract class AbstractFactoryComponentRunnerTask extends AbstractAntTask {
  /**
   * Store the id of the executed factory component.
   */
  private String _factoryComponentId;

  /**
   * @see org.eclipse.egf.common.ant.AbstractAntTask#checkAttributes()
   */
  @Override
  protected void checkAttributes() throws BuildException {
    assertTrue("Factory Component Id must be provided", (null != _factoryComponentId)); //$NON-NLS-1$
  }

  /**
   * Set the id of executed factory component.
   * @param factoryComponentId_p
   */
  public void setFactoryComponentId(String factoryComponentId_p) {
    _factoryComponentId = factoryComponentId_p;
  }

  /**
   * Return the factory component id set through {@link #setFactoryComponentId(String)} method.
   * @return the factoryComponentId or <code>null</code> if not set.
   */
  protected String getFactoryComponentId() {
    return _factoryComponentId;
  }
}
