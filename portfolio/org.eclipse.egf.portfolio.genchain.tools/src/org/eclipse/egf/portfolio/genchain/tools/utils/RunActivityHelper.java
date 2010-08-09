/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools.utils;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.l10n.EGFCoreMessages;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.portfolio.genchain.tools.Activator;
import org.eclipse.egf.producer.EGFProducerPlugin;
import org.eclipse.egf.producer.manager.ActivityManagerProducer;
import org.eclipse.egf.producer.manager.IActivityManager;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.osgi.util.NLS;

/**
 * 
 * @author Thomas Guiu
 */
public class RunActivityHelper {

    public static void run(Activity activity, IProgressMonitor monitor) throws InvocationException, CoreException {
        ActivityManagerProducer<Activity> producer = EGFProducerPlugin.getActivityManagerProducer(activity);
        // Create a Manager
        final IActivityManager manager = producer.createActivityManager(activity);
        manager.initializeContext();

        Diagnostic preInvoke = manager.canInvoke();
        if (preInvoke.getSeverity() == Diagnostic.ERROR) {
            IStatus status = new Status(IStatus.ERROR, Activator.getDefault().getPluginID(), IStatus.OK, preInvoke.getMessage(), null);
            throw new CoreException(status);
        }
        final int ticks = manager.getSteps();

        // Invoke
        SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(EGFCoreMessages.Production_Invoke, EMFHelper.getText(manager.getElement())), (1000 * ticks));
        manager.invoke(subMonitor.newChild(1000 * ticks, SubMonitor.SUPPRESS_NONE));
        if (subMonitor.isCanceled()) {
            throw new OperationCanceledException();
        }
    }
}
