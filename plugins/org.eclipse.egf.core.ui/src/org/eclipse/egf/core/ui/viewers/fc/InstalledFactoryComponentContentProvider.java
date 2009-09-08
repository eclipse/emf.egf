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
package org.eclipse.egf.core.ui.viewers.fc;

import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.egf.core.ui.viewers.AbstractAdaptedModelElementContentProvider;
import org.eclipse.emf.common.notify.AdapterFactory;


/**
 * Content provider implementation used to display factory components in an "Installed Factory Components" view for instance.
 * @author Guillaume Brocard
 */
public class InstalledFactoryComponentContentProvider extends AbstractAdaptedModelElementContentProvider {
  /**
   * @see org.eclipse.egf.core.ui.viewers.AbstractAdaptedModelElementContentProvider#getAdapterFactory()
   */
  @Override
  protected AdapterFactory getAdapterFactory() {
    return EgfUiActivator.getDefault().getEditingDomainInReadOnly().getAdapterFactory();
  }
}
