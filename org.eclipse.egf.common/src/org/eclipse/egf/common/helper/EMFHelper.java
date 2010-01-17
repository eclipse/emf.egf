/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.helper;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EMFHelper {

  // back-up for unregistered packages
  private static AdapterFactory __defaultFactory = new ReflectiveItemProviderAdapterFactory();

  private static AdapterFactory __factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

  private EMFHelper() {
    // Prevent instantiation
  }

  public static IResource getWorkspaceResource(Resource resource) {
    if (resource == null) {
      return null;
    }
    URI uri = resource.getURI();
    if (uri.isPlatformResource()) {
      String platformString = uri.toPlatformString(true);
      return ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
    }
    return null;
  }

  /**
   * Get root package for given one.<br>
   * Root package being the eldest parent package.
   * 
   * @param ePackage
   * @return
   */
  public static EPackage getRootPackage(EPackage ePackage) {
    if (ePackage == null) {
      EGFCommonPlugin.getDefault().logWarning("Unable to solve a Root EPackage for a null EPackage"); //$NON-NLS-1$
      return null;
    }
    EPackage result = null;
    EPackage rootPackage = ePackage;
    while (rootPackage != null) {
      result = rootPackage;
      rootPackage = result.getESuperPackage();
    }
    if (result == null) {
      EGFCommonPlugin.getDefault().logWarning(NLS.bind("Unable to solve a Root EPackage for {0}", ePackage)); //$NON-NLS-1$
    }
    return result;
  }

  /**
   * Get static ecore package from serialized one.<br>
   * That implies that the corresponding ecore model has been generated once.
   * 
   * @param ePackage
   * @return null if no generated package could be found.
   */
  public static EPackage getStaticPackage(EPackage ePackage) {
    EPackage ePackageStatic = null;
    // Get the equivalent from the Global EPackage registry.
    Object staticPackage = null;
    if (ePackage != null && ePackage.getNsURI() != null) {
      staticPackage = EPackage.Registry.INSTANCE.get(ePackage.getNsURI());
    }
    if (staticPackage != null) {
      if (staticPackage instanceof EPackage) {
        ePackageStatic = (EPackage) staticPackage;
      } else if (staticPackage instanceof EPackage.Descriptor) {
        ePackageStatic = ((EPackage.Descriptor) staticPackage).getEPackage();
      }
    } else {
      if (ePackage != null) {
        EGFCommonPlugin.getDefault().logWarning(NLS.bind("Unable to get static EPackage for {0}", ePackage)); //$NON-NLS-1$
      } else {
        EGFCommonPlugin.getDefault().logWarning("Unable to get static EPackage"); //$NON-NLS-1$          
      }
      ePackageStatic = ePackage;
    }
    return ePackageStatic;
  }

  public static EClassifier solveAgainstStaticPackage(EClassifier eClassifier) {
    if (eClassifier == null) {
      return null;
    }
    EPackage ePackage = getStaticPackage(getRootPackage(eClassifier.getEPackage()));
    if (ePackage != null && ePackage.eResource() != null) {
      URI uri = EcoreUtil.getURI(eClassifier);
      if (uri == null) {
        return eClassifier;
      }
      EObject eObject = ePackage.eResource().getEObject(uri.fragment());
      EClassifier solvedEClassifier = eObject instanceof EClassifier ? (EClassifier) eObject : eObject.eClass();
      if (solvedEClassifier != null) {
        return solvedEClassifier;
      }
    } else {
      EGFCommonPlugin.getDefault().logWarning(NLS.bind("Unable to solve EClassifier {0} against its static EPackage", eClassifier)); //$NON-NLS-1$
    }
    return eClassifier;
  }

  public static EObject solveAgainstStaticPackage(EPackage ePackage, EObject eObject) {
    if (eObject == null) {
      return null;
    }
    EPackage solvedEPackage = getStaticPackage(getRootPackage(ePackage));
    if (solvedEPackage != null && solvedEPackage.eResource() != null) {
      URI uri = EcoreUtil.getURI(eObject);
      if (uri == null) {
        return eObject;
      }
      EObject solvedEObject = solvedEPackage.eResource().getEObject(uri.fragment());
      if (solvedEObject != null) {
        return solvedEObject;
      }
    } else {
      EGFCommonPlugin.getDefault().logWarning(NLS.bind("Unable to solve EObject {0} against its static EPackage", eObject)); //$NON-NLS-1$
    }
    return eObject;
  }

  /**
   * Obtains a textual representation of the specified object, as for
   * display in messages. If no suitable factory is registered for model element,
   * then the EMF reflective item provider is used.
   * 
   * @param object
   *          the model element for which to get text
   * @return the corresponding text
   */
  public static String getText(Object object) {
    if (object == null || object instanceof EObject == false) {
      if (object == null) {
        return null;
      }
      return object.toString();
    }
    EObject eObject = (EObject) object;
    IItemLabelProvider provider = (IItemLabelProvider) __factory.adapt(eObject, IItemLabelProvider.class);
    if (provider == null) {
      // for backward compatibility, try looking in the resource set
      provider = (IItemLabelProvider) getRegisteredAdapter(eObject, IItemLabelProvider.class);
    }
    if (provider == null) {
      provider = (IItemLabelProvider) __defaultFactory.adapt(eObject, IItemLabelProvider.class);
    }
    String result = provider.getText(eObject);
    if (result != null) {
      // don't want leading or trailing blanks in messages
      result = result.trim();
    }
    return result;
  }

  /**
   * Obtains an IItemLabelProvider of the specified model element, as for
   * display in messages. If no suitable factory is registered, then
   * the EMF reflective item provider is used.
   * 
   * @param eObject
   *          the model element for which to get text
   * @return the corresponding text
   */
  public static IItemLabelProvider getItemLabelProvider(EObject eObject) {
    if (eObject == null) {
      return null;
    }
    IItemLabelProvider provider = (IItemLabelProvider) __factory.adapt(eObject, IItemLabelProvider.class);
    if (provider == null) {
      // for backward compatibility, try looking in the resource set
      provider = (IItemLabelProvider) getRegisteredAdapter(eObject, IItemLabelProvider.class);
    }
    if (provider == null) {
      provider = (IItemLabelProvider) __defaultFactory.adapt(eObject, IItemLabelProvider.class);
    }
    return provider;
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
