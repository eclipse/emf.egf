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
package org.eclipse.egf.model.fcore.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.egf.model.fcore.util.FcoreResourceImpl;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcoreResourceItemProviderAdapterFactory extends ResourceItemProviderAdapterFactory implements IResourceChildCreationExtender {

  /**
   * The fcore resource URI.
   */
  public static String FCORE_URI = "org.eclipse.egf.model.fcore.util"; //$NON-NLS-1$

  protected static Package fcoreResourceImplPackage = FcoreResourceImpl.class.getPackage();

  protected FcoreResourceItemProvider _fcoreResourceItemProvider;

  /**
   * This helps manage the child creation extenders.
   */
  protected ResourceChildCreationExtenderManager resourceChildCreationExtenderManager = new ResourceChildCreationExtenderManager(EGFModelEditPlugin.INSTANCE, FCORE_URI);

  @Override
  public Adapter createAdapter(Notifier target) {
    if (target instanceof FcoreResourceImpl) {
      return createFcoreResourceAdapter();
    }
    return createResourceSetAdapter();
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * 
   * @return whether this factory is applicable for the type of the object.
   */
  @Override
  public boolean isFactoryForType(Object type) {
    return type == fcoreResourceImplPackage || type instanceof FcoreResourceImpl || type instanceof ResourceSet || supportedTypes.contains(type);
  }

  /**
   * This creates an adapter for a {@link org.eclipse.egf.model.fcore.util.FcoreResourceImpl}.
   */
  public Adapter createFcoreResourceAdapter() {
    if (_fcoreResourceItemProvider == null) {
      _fcoreResourceItemProvider = new FcoreResourceItemProvider(this, resourceChildCreationExtenderManager);
    }
    return _fcoreResourceItemProvider;
  }

  public ResourceChildCreationExtenderManager getResourceChildCreationExtenderManager() {
    return resourceChildCreationExtenderManager;
  }

  public List<IChildCreationExtender> getChildCreationExtenders() {
    return resourceChildCreationExtenderManager.getChildCreationExtenders();
  }

  public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
    return resourceChildCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
  }

  public ResourceLocator getResourceLocator() {
    return resourceChildCreationExtenderManager;
  }

  public Collection<EClass> getRoots() {
    if (_fcoreResourceItemProvider == null) {
      createFcoreResourceAdapter();
    }
    return _fcoreResourceItemProvider.getRoots();
  }

}
