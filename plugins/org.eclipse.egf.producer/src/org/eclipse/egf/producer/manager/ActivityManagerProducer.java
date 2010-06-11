/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.producer.manager;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Invocation;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityManagerProducer<P extends Activity> {

    public abstract EClass getActivity();

    protected abstract IActivityManager<P> doCreateActivityManager(P activity) throws InvocationException;

    protected abstract IActivityManager<P> doCreateActivityManager(Bundle bundle, P activity) throws InvocationException;

    protected abstract <T extends Invocation> IActivityManager<P> doCreateActivityManager(IModelElementManager<T, InvocationContract> parent, P activity) throws InvocationException;

    public IActivityManager<P> createActivityManager(P activity) throws InvocationException {
        if (matchNature(activity) == false) {
            throw new InvocationException(NLS.bind(ProducerMessages.ActivityManagerProducer_type_error, getActivity().eClass().getName(), activity.eClass().getName()));
        }
        return doCreateActivityManager(activity);
    }

    public IActivityManager<P> createActivityManager(Bundle bundle, P activity) throws InvocationException {
        if (matchNature(activity) == false) {
            throw new InvocationException(NLS.bind(ProducerMessages.ActivityManagerProducer_type_error, getActivity().eClass().getName(), activity.eClass().getName()));
        }
        return doCreateActivityManager(bundle, activity);
    }

    public <T extends Invocation> IActivityManager<P> createActivityManager(IModelElementManager<T, InvocationContract> parent, P activity) throws InvocationException {
        if (matchNature(activity) == false) {
            throw new InvocationException(NLS.bind(ProducerMessages.ActivityManagerProducer_type_error, getActivity().eClass().getName(), activity.eClass().getName()));
        }
        return doCreateActivityManager(parent, activity);
    }

    public boolean matchNature(Activity activity) {
        Assert.isNotNull(activity);
        Assert.isNotNull(getActivity());
        return getActivity() == EMFHelper.solveAgainstStaticPackage(activity.eClass());
    }

}
