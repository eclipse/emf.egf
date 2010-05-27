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
package org.eclipse.egf.application.activity;

import java.util.List;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.egf.application.internal.activator.EGFApplicationPlugin;
import org.eclipse.egf.application.internal.activity.ActivityRunner;
import org.eclipse.egf.application.internal.l10n.ApplicationMessages;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.osgi.util.NLS;

public class ActivityApplication implements IApplication {

  /**
   * This is called with the command line arguments of a headless workbench invocation.
   */
  public Object run(Object object) throws Exception {
    // Usual tests
    if (object == null || object instanceof String[] == false || ((String[]) object).length < 2 || IApplicationConfigurationConstants.ACTIVITIES_PROGRAM_ARGUMENTS.equals(((String[]) object)[0]) == false) {
      System.err.println(ApplicationMessages.ActivityApplication_Arguments_Usage);
      return IApplicationConfigurationConstants.EXIT_ERROR;
    }
    // Retrieve our Editing Domain
    TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);
    // Build a list of activities if any
    List<Activity> activities = new UniqueEList<Activity>();
    for (int i = 1; i < ((String[]) object).length; i++) {
      String activity = ((String[]) object)[i];
      // Ignore null parameters
      if (activity == null) {
        continue;
      }
      URI uri = null;
      try {
        // Build a uri
        uri = URI.createURI(activity);
      } catch (Throwable t) {
        EGFApplicationPlugin.getDefault().logError(new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityApplication_Invalid_URI_Argument, i, activity), t)));
        continue;
      }
      EObject eObject = null;
      // Load it in our Editing Domain
      try {
        eObject = editingDomain.getResourceSet().getEObject(uri, true);
      } catch (Throwable t) {
        EGFApplicationPlugin.getDefault().logError(new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityApplication_EObject_Loading_Error, i, uri.toString()), t)));
        continue;
      }
      // Verify if we face an Activity
      if (eObject == null || eObject instanceof Activity == false) {
        EGFApplicationPlugin.getDefault().logError(new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityApplication_Invalid_Activity_Argument, i, uri.toString()), null)));
        continue;
      }
      // to be runned activities
      activities.add((Activity) eObject);
    }
    if (activities.isEmpty()) {
      return IApplication.EXIT_OK;
    }
    return runHelper(activities);
  }

  public Object start(IApplicationContext context) throws Exception {
    String[] args = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
    // Usual tests
    if (args == null || args.length < 2 || IApplicationConfigurationConstants.ACTIVITIES_PROGRAM_ARGUMENTS.equals(args[0]) == false) {
      System.err.println(ApplicationMessages.ActivityApplication_Arguments_Usage);
      return IApplicationConfigurationConstants.EXIT_ERROR;
    }
    return run(args);
  }

  public void stop() {
    // Subclasses may override
  }

  public static Object runHelper(final List<Activity> activities) throws Exception {
    try {
      final IWorkspace workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
        public void run(IProgressMonitor monitor) throws CoreException {
          try {
            ActivityRunner runner = new ActivityRunner(activities);
            runner.run(monitor);
          } finally {
            monitor.done();
          }
        }
      };
      workspace.run(runnable, new CodeGenUtil.EclipseUtil.StreamProgressMonitor(System.out));
    } catch (Exception e) {
      throw e;
    }
    return IApplication.EXIT_OK;
  }

}
