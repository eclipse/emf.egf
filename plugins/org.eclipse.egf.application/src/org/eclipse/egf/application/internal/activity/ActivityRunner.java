/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.application.internal.activity;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.application.internal.activator.EGFApplicationPlugin;
import org.eclipse.egf.application.internal.l10n.ApplicationMessages;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ActivityRunner {

  protected List<Activity> _activities;

  public ActivityRunner(Activity activity) {
    if (activity != null) {
      _activities = Collections.singletonList(activity);
    }
  }

  public ActivityRunner(List<Activity> activities) {
    _activities = activities;
  }

  public void run(IProgressMonitor monitor) throws CoreException {
    // Nothing to process
    if (_activities == null || _activities.isEmpty()) {
      return;
    }
    // Process Activities
    for (Activity activity : _activities) {
      IActivityManager<Activity> manager = null;
      try {
        // Retrieve an ActivityManager
        manager = EGFProducerPlugin.getActivityManagerProducer(activity).createActivityManager(activity);
        // Initialize Context
        manager.initializeContext();
      } catch (Throwable t) {
        throw new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityRunner_ActivityRunner_Exception, EcoreUtil.getURI(activity)), t));
      }
      try {
        // Pre-Invoke validation
        Diagnostic diagnostic = manager.canInvoke();
        if (diagnostic.getSeverity() == Diagnostic.ERROR) {
          throw DiagnosticException.toCoreException(new DiagnosticException(diagnostic));
        }
      } catch (CoreException ce) {
        throw ce;
      } catch (InvocationException ie) {
        throw new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityRunner_PreInvokeProblems_message, EcoreUtil.getURI(activity)), ie));
      }
      Diagnostic diagnostic = null;
      try {
        // Invoke
        int ticks = manager.getSteps();
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, EMFHelper.getText(manager.getElement())), (1000 * ticks));
        if (ticks == 1) {
          EGFApplicationPlugin.getDefault().logInfo(NLS.bind(ProducerMessages.Activity_Invocation, EMFHelper.getText(activity)));
        } else {
          EGFApplicationPlugin.getDefault().logInfo(NLS.bind(ProducerMessages.Activity_Invocations, EMFHelper.getText(activity), ticks));
        }
        diagnostic = manager.invoke(subMonitor.newChild(1000 * ticks, SubMonitor.SUPPRESS_NONE));
      } catch (Throwable t) {
        throw new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityRunner_ActivityRunner_Exception, EcoreUtil.getURI(activity)), t));
      }
      // Post Invoke Validation
      if (diagnostic.getSeverity() == Diagnostic.ERROR) {
        throw DiagnosticException.toCoreException(new DiagnosticException(diagnostic));
      }
      try {
        // Dispose
        manager.dispose();
      } catch (Throwable t) {
        throw new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, ApplicationMessages.ActivityRunner_ActivityRunner_Exception, t));
      }
    }
  }

}
