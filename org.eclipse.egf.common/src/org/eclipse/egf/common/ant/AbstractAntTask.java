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
package org.eclipse.egf.common.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.ant.core.AntCorePlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * Base class for the tasks that are defined in this plug-in. Provides common behavior and facilities.<br>
 * Code was copied from EMFTask class provided by org.eclipse.emf.ant plug-in.
 * @author Guillaume Brocard
 */
public abstract class AbstractAntTask extends Task {
  /**
   * Throws a <tt>BuildException</tt> if <tt>expression_p</tt> is false.
   * @param message_p
   * @param expression_p
   * @throws BuildException
   */
  public static void assertTrue(String message_p, boolean expression_p) throws BuildException {
    if (!expression_p) {
      throw new BuildException(message_p);
    }
  }

  /**
   * Get the ANT progress monitor.
   * @return a not null {@link IProgressMonitor}
   */
  protected IProgressMonitor getProgressMonitor() {
    try {
      if (getProject() != null) {
        IProgressMonitor progressMonitor = (IProgressMonitor) getProject().getReferences().get(AntCorePlugin.ECLIPSE_PROGRESS_MONITOR);
        if (progressMonitor != null) {
          return progressMonitor;
        }
      }
    } catch (Exception exception_p) {
      // Ignore
    }
    return new NullProgressMonitor();
  }

  /**
   * @see org.apache.tools.ant.Task#execute()
   */
  @Override
  public final void execute() throws BuildException {
    checkAttributes();
    try {
      doExecute();
    } catch (Exception exception_p) {
      if (exception_p instanceof BuildException) {
        throw (BuildException) exception_p;
      }
      throw new BuildException(exception_p);
    }
  }

  /**
   * All the attribute checks should be performed in this method.
   * @throws BuildException
   */
  protected void checkAttributes() throws BuildException {
    // Subclasses may override this method
  }

  /**
   * Performs the task specific code.
   * @throws Exception
   */
  abstract protected void doExecute() throws Exception;
}
