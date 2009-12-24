/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ecore;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.core.platform.resource.ResourceHelper;
import org.eclipse.egf.pattern.execution.ProjectClassLoaderHelper;
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

/**
 * The purpose is to handle ecore models from the workspace as well as runtime
 * ones.
 * 
 * TODO Une fois terminée, cette classe devrait pltot se trouver dans core ou
 * platform <br>
 * TODO lire les point extension du workspace pour trouver les modeles<br>
 * TODO ecouter les modifs pour savoir quand le modele est regénéré (par exemple
 * des classes package ou factory générées)
 * 
 * @author Thomas Guiu
 * 
 */
public class EPackageHelper {
    public static final EPackage.Registry REGISTRY = new EPackageRegistryImpl(EPackage.Registry.INSTANCE);
    private static final Map<String, String> nsuri2basePackage = new HashMap<String, String>();

    public static String getBasePackage(EPackage ePackage) {
        String name = nsuri2basePackage.get(ePackage.getNsURI());
        if (name != null)
            return name;
        String nsURI = ePackage.getNsURI();
        URI uri = EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(nsURI);
        Resource res = loadResource(uri);
        for (EObject obj : res.getContents()) {
            if (obj instanceof GenModel) {
                GenModel genModel = (GenModel) obj;
                for (GenPackage gPack : genModel.getGenPackages()) {
                    EPackage ecorePackage = gPack.getEcorePackage();
                    if (ePackage.getName().equals(ecorePackage.getName()) && ePackage.getNsPrefix().equals(ecorePackage.getNsPrefix()) && ePackage.getNsURI().equals(ecorePackage.getNsURI())) {
                        nsuri2basePackage.put(ePackage.getNsURI(), gPack.getBasePackage());
                        return gPack.getBasePackage();
                    }
                }
            }
        }

        return null;
    }

    /**
     * This method will be used by the workspace resource listener
     */
    public static void registerPackage(IProject project, String classname) throws RegistrationExcpetion {
        try {
            Class<?> loadClass = ProjectClassLoaderHelper.getProjectClassLoader(project).loadClass(classname);
            Field declaredField = loadClass.getDeclaredField("eINSTANCE");
            EPackage ePackage = (EPackage) declaredField.get(null);
            REGISTRY.put(ePackage.getNsURI(), new Descriptor(ePackage));

            // computing basePackage
            int index = classname.lastIndexOf(ePackage.getName());
            if (index == -1)
                throw new IllegalStateException();
            if (index == 0)
                nsuri2basePackage.put(ePackage.getNsURI(), "");
            else
                // to remove the last dot
                nsuri2basePackage.put(ePackage.getNsURI(), classname.substring(index - 1));
        } catch (Exception e) {
            throw new RegistrationExcpetion(e);
        }
    }

    public static class RegistrationExcpetion extends Exception {
        private RegistrationExcpetion(Throwable cause) {
            super(cause);
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

        @Override
        public EFactory getEFactory() {

            return epackage.getEFactoryInstance();
        }

        @Override
        public EPackage getEPackage() {

            return epackage;
        }

    }

}
