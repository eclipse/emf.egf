/**
 * Copyright (c) 2004, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.core.helper;

import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EObjectHelper {

  // back-up for unregistered packages
  private static AdapterFactory defaultFactory = new ReflectiveItemProviderAdapterFactory();

  private static AdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

  private EObjectHelper() {
    // Prevent instantiation
  }

  public static EObject loadEObject(ResourceSet resourceSet, EObject eObject) {
    if (resourceSet == null || eObject == null || EcoreUtil.getURI(eObject) == null) {
      return null;
    }
    // Clear the previous URIConverter content
    resourceSet.getURIConverter().getURIMap().clear();
    // Assign a fresh platform aware URIConverter
    resourceSet.getURIConverter().getURIMap().putAll(EGFCorePlugin.computePlatformURIMap());
    // Load
    return resourceSet.getEObject(EcoreUtil.getURI(eObject), true);
  }

  /**
   * Obtains a textual representation of the specified model element, as for
   * display in error messages. If no suitable factory is registered, then
   * the EMF reflective item provider is used.
   * 
   * @param eObject
   *          the model element for which to get text
   * @return the corresponding text
   */
  public static String getText(EObject eObject) {
    IItemLabelProvider provider = (IItemLabelProvider) factory.adapt(eObject, IItemLabelProvider.class);
    if (provider == null) {
      // for backward compatibility, try looking in the resource set
      provider = (IItemLabelProvider) getRegisteredAdapter(eObject, IItemLabelProvider.class);
    }
    if (provider == null) {
      provider = (IItemLabelProvider) defaultFactory.adapt(eObject, IItemLabelProvider.class);
    }
    String result = provider.getText(eObject);
    if (result != null) {
      // don't want leading or trailing blanks in messages
      result = result.trim();
    }
    return result;
  }

  /**
   * Similar to the {@link EcoreUtil#getRegisteredAdapter(EObject, Object)} method, attempts to
   * adapt the given <code>eObject</code> to the
   * specified <code>type</code> using adapter factories registered on its
   * resource set. The difference is, that this method anticipates that
   * adapter factories from multiple disjoint metamodels may be registered,
   * that adapt different kinds of objects to the same types. This method
   * will try them all until it either gets a successful adaptation or runs
   * out of factories.
   * 
   * @param eObject
   *          the model element to adapt
   * @param type
   *          indicates the type of adapter to obtain
   * @return the available registered adapter, or <code>null</code> if no
   *         suitable adapter factory is found
   */
  private static Object getRegisteredAdapter(EObject eObject, Object type) {
    Object result = EcoreUtil.getExistingAdapter(eObject, type);
    if (result == null) {
      Resource resource = eObject.eResource();
      if (resource != null) {
        ResourceSet resourceSet = resource.getResourceSet();
        if (resourceSet != null) {
          List<AdapterFactory> factories = resourceSet.getAdapterFactories();
          // iterate only as long as we don't find an adapter factory
          // that successfully adapted the eObject
          for (Iterator<AdapterFactory> iter = factories.iterator(); iter.hasNext() && (result == null);) {
            AdapterFactory next = iter.next();
            if (next.isFactoryForType(type)) {
              result = next.adapt(eObject, type);
            }
          }
        }
      }
    }
    return result;
  }

}
