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
package org.eclipse.egf.pattern;

import org.osgi.framework.BundleContext;

import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.egf.common.activator.AbstractActivator;
import org.eclipse.egf.common.progress.IProgressRunnable;
import org.eclipse.egf.common.progress.ProgressReporter;
import org.eclipse.egf.fc.builder.java.JavaBuilderActivator;
import org.eclipse.egf.fc.generator.java.JavaGeneratorActivator;
import org.eclipse.egf.pattern.production.Messages;
import org.eclipse.egf.pattern.production.PatternProducer;


/**
 * @author brocard
 */
public class PatternActivator extends AbstractActivator {
  /**
   * Activator shared instance.
   */
  private static PatternActivator __activator;
  /**
   * Pattern producer.
   */
  private PatternProducer _patternProducer;

  /**
   * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(BundleContext context_p) throws Exception {
    super.start(context_p);
    // Get activator instance.
    __activator = this;
    // Ensure dependencies.
    JavaGeneratorActivator.getDefault();
    JavaBuilderActivator.getDefault();
  }

  /**
   * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context_p) throws Exception {
    __activator = null;
  }

  /**
   * Get shared instance.
   * @return
   */
  public static PatternActivator getDefault() {
    return __activator;
  }

  /**
   * Produce patterns pointed out by given ids path.
   * @param fullId_p Either the absolute id of a library, or the absolute id of a pattern.
   * @param forkJob_p Should production be executed in a job ? If true, there is no need for a specific progress monitor.
   * @param progressMonitor_p A progress monitor to use in case of a synchronous production (can be null if no progress reporting is required).
   * @return
   */
  public boolean producePatterns(
    final String fullId_p, 
    boolean forkJob_p, 
    IProgressMonitor progressMonitor_p
  ) {
    boolean result = true;
    // Lazy allocation.
    if (_patternProducer == null) {
      _patternProducer = new PatternProducer();
    }
    // Create progress runnable.
    final PatternProducer patternProducer = _patternProducer;
    IProgressRunnable producePattern = new IProgressRunnable() {
      public String getReportingTitle() {
        return Messages.PatternProducer_ProgressReporting_Title + fullId_p;
      }
      public boolean run(IProgressMonitor runnableProgressMonitor_p) {
        return patternProducer.producePatterns(fullId_p, runnableProgressMonitor_p);
      }
    };
    // Execute it.
    if (forkJob_p) {
      ProgressReporter.asyncExec(producePattern);
    } else {
      ProgressReporter.syncExec(producePattern, progressMonitor_p);
    }
    return result;
  }
  
}
