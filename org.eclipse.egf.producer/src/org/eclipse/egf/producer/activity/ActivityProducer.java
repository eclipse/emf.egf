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

package org.eclipse.egf.producer.activity;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.producer.l10n.ProducerMessages;
import org.eclipse.egf.producer.manager.IModelElementProducerManager;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

/**
 * @author Xavier Maysonnave
 * 
 */
public abstract class ActivityProducer {

  public abstract Activity getActivity();

  protected abstract IModelElementProducerManager doCreateManager(Activity activity) throws InvocationException;

  protected abstract IModelElementProducerManager doCreateManager(Bundle bundle, Activity activity) throws InvocationException;

  public IModelElementProducerManager createManager(Activity activity) throws InvocationException {
    if (matchNature(activity) == false) {
      throw new InvocationException(NLS.bind(ProducerMessages.Activity_type_error, getActivity().eClass().getName(), activity.eClass().getName()));
    }
    return doCreateManager(activity);
  }

  public IModelElementProducerManager createManager(Bundle bundle, Activity activity) throws InvocationException {
    if (matchNature(activity) == false) {
      throw new InvocationException(NLS.bind(ProducerMessages.Activity_type_error, getActivity().eClass().getName(), activity.eClass().getName()));
    }
    return doCreateManager(bundle, activity);
  }

  public boolean matchNature(Activity activity) {
    Assert.isNotNull(activity);
    Assert.isNotNull(getActivity());
    return getActivity().eClass().equals(activity.eClass());
  }

  /**
   * Tells if the activity can be executed.
   * 
   * @return a Diagnostic
   */
  public Diagnostic canExecute(Activity activity) {
    return Diagnostic.OK_INSTANCE;
  }

}
