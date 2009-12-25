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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EMFHelper {

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
   * @param package_p
   * @return
   */
  public static EPackage getRootPackage(EPackage package_p) {
    if (package_p == null) {
      EGFCommonPlugin.getDefault().logWarning("Unable to solve a Root EPackage for a null EPackage"); //$NON-NLS-1$
      return null;
    }
    EPackage result = null;
    EPackage rootPackage = package_p;
    while (rootPackage != null) {
      result = rootPackage;
      rootPackage = result.getESuperPackage();
    }
    if (result == null) {
      EGFCommonPlugin.getDefault().logWarning(NLS.bind("Unable to solve a Root EPackage for {0}", package_p)); //$NON-NLS-1$
    }
    return result;
  }

  /**
   * Get static ecore package from serialized one.<br>
   * That implies that the corresponding ecore model has been generated once.
   * 
   * @param serializedPackage_p
   * @return null if no generated package could be found.
   */
  public static EPackage getStaticPackage(EPackage serializedPackage_p) {
    EPackage staticPackageInstance = null;
    // Get the equivalent from the Global EPackage registry.
    //
    Object staticPackage = null;
    if (serializedPackage_p != null && serializedPackage_p.getNsURI() != null) {
      staticPackage = EPackage.Registry.INSTANCE.get(serializedPackage_p.getNsURI());
    }
    if (staticPackage != null) {
      if (staticPackage instanceof EPackage) {
        staticPackageInstance = (EPackage) staticPackage;
      } else if (staticPackage instanceof EPackage.Descriptor) {
        staticPackageInstance = ((EPackage.Descriptor) staticPackage).getEPackage();
      }
    } else {
      if (serializedPackage_p != null) {
        EGFCommonPlugin.getDefault().logWarning(NLS.bind("Unable to get static EPackage for {0}", serializedPackage_p)); //$NON-NLS-1$
      } else {
        EGFCommonPlugin.getDefault().logWarning("Unable to get static EPackage"); //$NON-NLS-1$          
      }
      staticPackageInstance = serializedPackage_p;
    }
    return staticPackageInstance;
  }

  public static EClassifier solveAgainstStaticPackage(EClassifier eClassifier_p) {
    EClassifier eClassifier = eClassifier_p;
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

  public static EObject solveAgainstStaticPackage(EPackage package_p, EObject eObject_p) {
    EObject eObject = eObject_p;
    if (eObject_p == null) {
      return null;
    }
    EPackage ePackage = getStaticPackage(getRootPackage(package_p));
    if (ePackage != null && ePackage.eResource() != null) {
      URI uri = EcoreUtil.getURI(eObject);
      if (uri == null) {
        return eObject;
      }
      EObject solvedEObject = ePackage.eResource().getEObject(uri.fragment());
      if (solvedEObject != null) {
        return solvedEObject;
      }
    } else {
      EGFCommonPlugin.getDefault().logWarning(NLS.bind("Unable to solve EObject {0} against its static EPackage", eObject)); //$NON-NLS-1$
    }
    return eObject;
  }

}
