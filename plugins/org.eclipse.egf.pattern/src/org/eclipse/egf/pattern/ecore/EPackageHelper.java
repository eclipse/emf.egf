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

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.egf.pattern.Activator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

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

    private static void init() {

        for (IPlatformGenModel genModel : EGFCorePlugin.getPlatformGenModels()) {
            addEcoreModel(genModel);
        }
        EGFPlatformPlugin.getPlatformManager().addPlatformExtensionPointListener(new IPlatformExtensionPointListener() {

            public void platformExtensionPointChanged(IPlatformExtensionPointDelta delta) {
                for (IPlatformGenModel genModel : delta.getAddedPlatformExtensionPoints(IPlatformGenModel.class)) {
                    addEcoreModel(genModel);
                }
                for (IPlatformGenModel genModel : delta.getRemovedPlatformExtensionPoints(IPlatformGenModel.class)) {
                    removePackageFromRegistry(genModel);
                }
            }
        });
    }

    private static void addEcoreModel(IPlatformGenModel genModel) {
        try {
            try {
                URI uri = genModel.getGenModelURI();
                if (uri == null)
                    handleClassname(genModel);
                else
                    handleURI(uri);
            } catch (Exception e) {
                // don't care since we will try another way
            }
            addPackage2registry(genModel);
        } catch (Exception e) {
            Activator.getDefault().logError(e);
        }

    }

    private static void handleClassname(IPlatformGenModel genModel) {
        String classname = genModel.getGeneratedPackage();
        int index = classname.lastIndexOf("."); //$NON-NLS-1$
        if (index == -1) {
            throw new IllegalStateException();
        }
        if (index == 0) {
            nsuri2basePackage.put(genModel.getNamespace(), ""); //$NON-NLS-1$
        } else {
            // to remove the last dot
            nsuri2basePackage.put(genModel.getNamespace(), classname.substring(0, index));
        }

    }

    private static void handleURI(URI uri) {
        ResourceSetImpl set = new ResourceSetImpl();
        Resource res = ResourceHelper.loadResource(set, uri);
        try {
            for (EObject obj : res.getContents()) {
                if (obj instanceof GenModel) {
                    GenModel genModel2 = (GenModel) obj;
                    for (GenPackage gPack : genModel2.getAllGenPackagesWithClassifiers()) {
                        EPackage ecorePackage = gPack.getEcorePackage();
                        String basePackageName = gPack.getInterfacePackageName();
                        nsuri2basePackage.put(ecorePackage.getNsURI(), basePackageName);

                    }
                }
            }
        } finally {
            res.unload();
        }
    }

    public static String getBasePackage(EPackage ePackage) {

        if (nsuri2basePackage.isEmpty())
            init();
        String nsURI = ePackage.getNsURI();
        String name = nsuri2basePackage.get(nsURI);
        if (name == null)
            throw new IllegalStateException();
        return name;
    }

    private static void addPackage2registry(IPlatformGenModel genModel) {
        String nsURI = genModel.getNamespace();
        if (!REGISTRY.containsKey(nsURI))
            REGISTRY.put(nsURI, new Descriptor2(genModel));
    }

    private static void removePackageFromRegistry(IPlatformGenModel genModel) {
        String nsURI = genModel.getNamespace();
        REGISTRY.remove(nsURI);
    }

    public static class RegistrationException extends Exception {
        private static final long serialVersionUID = 1L;

        private RegistrationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private static class Descriptor2 implements EPackage.Descriptor {

        private final IPlatformGenModel genModel;

        private Descriptor2(IPlatformGenModel genModel) {
            super();
            this.genModel = genModel;

        }

        public EFactory getEFactory() {

            return null;
        }

        public EPackage getEPackage() {
            try {
                Class<?> javaClass = getGenModel().getPlatformBundle().getBundle().loadClass(getGenModel().getGeneratedPackage());
                Field field = javaClass.getField("eINSTANCE");
                Object result = field.get(null);
                return (EPackage) result;
            } catch (ClassNotFoundException e) {
                throw new WrappedException(e);
            } catch (IllegalAccessException e) {
                throw new WrappedException(e);
            } catch (NoSuchFieldException e) {
                throw new WrappedException(e);
            }
        }

        public IPlatformGenModel getGenModel() {
            return genModel;
        }
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
