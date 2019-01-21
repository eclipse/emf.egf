/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.egf.core.domain.RuntimePlatformResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
        // Prepare a dynamic bundle session
        ProjectBundleSession session = new ProjectBundleSession(EGFApplicationPlugin.getDefault().getBundle().getBundleContext());
        // Prepare a runtime platform resource set
        ResourceSet resourceSet = new RuntimePlatformResourceSet();

        try {

            // Locate workspace fcores
            List<IPlatformFcore> workspaceFcores = new UniqueEList<IPlatformFcore>();
            for (Activity activity : _activities) {
                for (Resource resource : activity.getResources()) {
                    if (resource instanceof IPlatformFcoreProvider) {
                        IPlatformFcore fcore = ((IPlatformFcoreProvider) resource).getIPlatformFcore();
                        // Runtime or target associated with a runtime bundle
                        if (fcore.isRuntime() || fcore.getBundle() != null) {
                            continue;
                        }
                        // Workspace Bundle
                        if (fcore.isWorkspace()) {
                            workspaceFcores.add(fcore);
                            continue;
                        }
                        // Cannot associate a Bundle to a target platform fcore
                        throw new CoreException(EGFProducerPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(EGFCoreMessages.TargetPlatform_ExtensionPoint_no_bundle, fcore.getPlatformBundle().getBundleId()), null));
                    }
                }
            }

            SubMonitor subMonitor = SubMonitor.convert(monitor, ApplicationMessages.ActivityRunner_Run, (100 * workspaceFcores.size()) + (_activities.size() * 1000));

            // Load workspace bundles in runtime
            for (IPlatformFcore workspaceFcore : workspaceFcores) {
                SubMonitor childSubMonitor = subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE);
                childSubMonitor = SubMonitor.convert(childSubMonitor, NLS.bind(EGFCoreMessages.Production_Load_Bundle, workspaceFcore.getPlatformBundle().getBundleId()), 100);
                try {
                    session.getBundle(workspaceFcore.getPlatformBundle().getProject());
                } catch (Throwable t) {
                    if (t instanceof CoreException) {
                        throw (CoreException) t;
                    }
                    throw new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityRunner_Exception, workspaceFcore.getPlatformBundle().getBundleId()), t));
                }
            }

            // Process Activities
            for (Activity activity : _activities) {

                SubMonitor childSubMonitor = subMonitor.newChild(1000, SubMonitor.SUPPRESS_NONE);
                childSubMonitor = SubMonitor.convert(childSubMonitor, NLS.bind(EGFCoreMessages.Production_Invoke, EMFHelper.getText(activity)), 1000);

                IActivityManager<Activity> manager = null;
                try {
                    activity = (Activity) resourceSet.getEObject(EcoreUtil.getURI(activity), true);
                } catch (Throwable t) {
                    throw new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityRunner_Exception, EcoreUtil.getURI(activity)), t));
                }
                try {
                    // Create a Manager
                    manager = EGFProducerPlugin.getActivityManagerProducer(activity).createActivityManager(activity);
                    // Assign a ProjectBundleSession
                    manager.setProjectBundleSession(session);
                    // Initialize Context
                    manager.initializeContext();
                } catch (Throwable t) {
                    if (t instanceof CoreException) {
                        throw (CoreException) t;
                    }
                    throw new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityRunner_Exception, EcoreUtil.getURI(activity)), t));
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
                    if (ticks == 1) {
                        EGFApplicationPlugin.getDefault().logInfo(NLS.bind(ProducerMessages.Activity_Invocation, EMFHelper.getText(activity)));
                    } else {
                        EGFApplicationPlugin.getDefault().logInfo(NLS.bind(ProducerMessages.Activity_Invocations, EMFHelper.getText(activity), ticks));
                    }
                    diagnostic = manager.invoke(childSubMonitor.newChild(1000 * ticks, SubMonitor.SUPPRESS_NONE));
                } catch (Throwable t) {
                    throw new CoreException(EGFApplicationPlugin.getDefault().newStatus(IStatus.ERROR, NLS.bind(ApplicationMessages.ActivityRunner_Exception, EcoreUtil.getURI(activity)), t));
                }

                // Post Invoke Validation
                if (diagnostic.getSeverity() == Diagnostic.ERROR) {
                    throw DiagnosticException.toCoreException(new DiagnosticException(diagnostic));
                }

            }

        } finally {
            session.dispose();
            monitor.done();
        }

    }
}
