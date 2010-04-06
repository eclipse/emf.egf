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

package org.eclipse.egf.pattern.ecore;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.common.helper.JavaHelper;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * The purpose is to handle ecore models from the workspace as well as runtime
 * ones.
 * 
 * TODO Une fois terminée, cette classe devrait pltot se trouver dans core ou
 * platform <br>
 * TODO revoir l'utilisation de ProjectClassLoaderHelper <br>
 * 
 * @author Thomas Guiu
 * 
 */
public class EPackageHelper {

  public static final String INSTANCE_FIELD_NAME = "eINSTANCE"; //$NON-NLS-1$

  public static final EPackage.Registry REGISTRY = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);

  private static final Map<String, String> nsuri2basePackage = new HashMap<String, String>();

  private static EPackage getTopEPackage(EPackage ePackage) {
    if (ePackage.getESuperPackage() != null)
      return getTopEPackage(ePackage.getESuperPackage());
    return ePackage;
  }

  public static String getBasePackage(EPackage ePackage) {
    String name = nsuri2basePackage.get(ePackage.getNsURI());
    if (name != null)
      return name;
    String nsUri = getTopEPackage(ePackage).getNsURI();
    URI uri = EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(nsUri);
    Resource res = loadResource(uri);
    for (EObject obj : res.getContents()) {
      if (obj instanceof GenModel) {
        GenModel genModel = (GenModel) obj;
        for (GenPackage gPack : genModel.getAllGenPackagesWithClassifiers()) {
          EPackage ecorePackage = gPack.getEcorePackage();
          if (ePackage.getName().equals(ecorePackage.getName()) && ePackage.getNsPrefix().equals(ecorePackage.getNsPrefix()) && ePackage.getNsURI().equals(ecorePackage.getNsURI())) {
            String basePackageName = gPack.getInterfacePackageName();
            nsuri2basePackage.put(ePackage.getNsURI(), basePackageName);
            return basePackageName;
          }
        }
      }
    }

    return null;
  }

  public static void unregisterPackage(IProject project, String classname) throws RegistrationException {
    try {
      IJavaProject javaProject = JavaCore.create(project);
      if (javaProject.exists()) {
        Class<?> loadClass = JavaHelper.getProjectClassLoader(javaProject).loadClass(classname);
        Field declaredField = loadClass.getDeclaredField(INSTANCE_FIELD_NAME);
        EPackage ePackage = (EPackage) declaredField.get(null);
        String nsURI = ePackage.getNsURI();
        removePackage2registry(ePackage);
        nsuri2basePackage.remove(nsURI);
      }
    } catch (Exception e) {
      throw new RegistrationException(Messages.bind(Messages.registration_error2, classname, project.getName()), e);
    }
  }

  /**
   * This method will be used by the workspace resource listener
   */
  public static void registerPackage(IProject project, String classname) throws RegistrationException {
    try {
      IJavaProject javaProject = JavaCore.create(project);
      if (javaProject.exists()) {
        Class<?> loadClass = JavaHelper.getProjectClassLoader(javaProject).loadClass(classname);
        Field declaredField = loadClass.getDeclaredField(INSTANCE_FIELD_NAME);
        EPackage ePackage = (EPackage) declaredField.get(null);
        String nsURI = ePackage.getNsURI();
        addPackage2registry(ePackage);
        // computing basePackage
        int index = classname.lastIndexOf("."); //$NON-NLS-1$
        if (index == -1) {
          throw new IllegalStateException();
        }
        if (index == 0) {
          nsuri2basePackage.put(nsURI, ""); //$NON-NLS-1$
        } else {
          // to remove the last dot
          nsuri2basePackage.put(nsURI, classname.substring(0, index));
        }
      }
    } catch (Exception e) {
      throw new RegistrationException(Messages.bind(Messages.registration_error2, classname, project.getName()), e);
    }
  }

  private static void addPackage2registry(EPackage ePackage) {
    String nsURI = ePackage.getNsURI();
    REGISTRY.put(nsURI, new Descriptor(ePackage));
    for (EPackage child : ePackage.getESubpackages())
      addPackage2registry(child);
  }

  private static void removePackage2registry(EPackage ePackage) {
    String nsURI = ePackage.getNsURI();
    REGISTRY.remove(nsURI);
    for (EPackage child : ePackage.getESubpackages())
      removePackage2registry(child);
  }

  public static class RegistrationException extends Exception {
    private static final long serialVersionUID = 1L;

    private RegistrationException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  private static Resource loadResource(URI uri) {
    // TODO it may be interesting to keep loaded resources for future
    // uses ... however, workspace resources may change.
    ResourceSetImpl set = new ResourceSetImpl();
    Resource res = ResourceHelper.loadResource(set, uri);
    return res;
  }

  private static class Descriptor implements EPackage.Descriptor {

    private EPackage epackage;

    public Descriptor(EPackage ePackage) {
      super();
      this.epackage = ePackage;
    }

    public EFactory getEFactory() {
      return epackage.getEFactoryInstance();
    }

    public EPackage getEPackage() {
      return epackage;
    }

  }

}
