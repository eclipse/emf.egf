/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityManagerProducer {

  public abstract EClass getActivity();

  protected abstract IActivityManager doCreateActivityManager(Activity activity) throws InvocationException;

  protected abstract IActivityManager doCreateActivityManager(Bundle bundle, Activity activity) throws InvocationException;

  public IActivityManager createActivityManager(Activity activity) throws InvocationException {
    if (matchNature(activity) == false) {
      throw new InvocationException(NLS.bind(ProducerMessages.ActivityManagerProducer_type_error, getActivity().eClass().getName(), activity.eClass().getName()));
    }
    return doCreateActivityManager(activity);
  }

  public IActivityManager createActivityManager(Bundle bundle, Activity activity) throws InvocationException {
    if (matchNature(activity) == false) {
      throw new InvocationException(NLS.bind(ProducerMessages.ActivityManagerProducer_type_error, getActivity().eClass().getName(), activity.eClass().getName()));
    }
    return doCreateActivityManager(bundle, activity);
  }

  public boolean matchNature(Activity activity) {
    Assert.isNotNull(activity);
    Assert.isNotNull(getActivity());
    return getActivity() == EMFHelper.solveAgainstStaticPackage(activity.eClass());
  }

}
