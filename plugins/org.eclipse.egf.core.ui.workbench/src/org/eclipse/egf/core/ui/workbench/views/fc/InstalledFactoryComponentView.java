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
package org.eclipse.egf.core.ui.workbench.views.fc;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.egf.core.ui.EgfUiActivator;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;


/**
 * This class provides the IViewPart for the deployed factory components view in the Eclipse workbench.<br>
 * This view display all deployed factory components : ie installed in the running Eclipse platform as plug-ins.
 * @author Guillaume Brocard
 */
public class InstalledFactoryComponentView extends AbstractFactoryComponentView {
  /**
   * Identifier of the installed factory components view (declared in related plugin.xml).
   */
  public static final String VIEW_ID = "org.eclipse.egf.core.ui.workbench.views.fc.installedAssetView"; //$NON-NLS-1$

  /**
   * Identifier of the installed factory components view content provider (declared in related plugin.xml).
   */
  private static final String CONTENT_PROVIDER_ID = "org.eclipse.egf.core.ui.workbench.views.fc.installedAssetViewContent"; //$NON-NLS-1$

  /**
   * @see org.eclipse.egf.core.ui.workbench.views.fc.AbstractFactoryComponentView#getContentProviderId()
   */
  @Override
  protected String getContentProviderId() {
    return CONTENT_PROVIDER_ID;
  }

  /**
   * @see org.eclipse.ui.navigator.CommonNavigator#getInitialInput()
   */
  @Override
  protected IAdaptable getInitialInput() {
    return EgfUiActivator.getDefault().getFactoryComponentInPlatormInput();
  }

  /**
   * @see org.eclipse.egf.core.ui.workbench.views.fc.AbstractFactoryComponentView#getEditingDomain()
   */
  @Override
  protected AdapterFactoryEditingDomain getEditingDomain() {
    return EgfUiActivator.getDefault().getEditingDomainInReadOnly();
  }
}