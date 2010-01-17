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

package org.eclipse.egf.producer.context;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.core.session.ProjectBundleSession;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityProductionContextProducer {

  public abstract <R extends IInvocationProductionContext> Class<R> getParentProductionContext();

  public abstract EClass getActivity();

  protected abstract IActivityProductionContext doCreateActivityProductionContext(IInvocationProductionContext parent, Activity activity, ProjectBundleSession projectBundleSession) throws InvocationException;

  public IActivityProductionContext createActivityProductionContext(IInvocationProductionContext parent, Activity activity, ProjectBundleSession projectBundleSession) throws InvocationException {
    if (matchNature(activity) == false) {
      throw new InvocationException(NLS.bind(ProducerMessages.ActivityManagerProducer_type_error, getActivity().eClass().getName(), activity.eClass().getName()));
    }
    if (matchParentProductionContext(parent) == false) {
      throw new InvocationException(NLS.bind(ProducerMessages.ActivityProductionContextProducer_type_error, getParentProductionContext().getName(), parent.getClass().getName()));
    }
    return doCreateActivityProductionContext(parent, activity, projectBundleSession);
  }

  public boolean matchNature(Activity activity) {
    Assert.isNotNull(activity);
    Assert.isNotNull(getActivity());
    return getActivity() == EMFHelper.solveAgainstStaticPackage(activity.eClass());
  }

  public boolean matchParentProductionContext(IInvocationProductionContext parent) {
    Assert.isNotNull(parent);
    Assert.isNotNull(getParentProductionContext());
    return getParentProductionContext() == parent.getClass();
  }

}
