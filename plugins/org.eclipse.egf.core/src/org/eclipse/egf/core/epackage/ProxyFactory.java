/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.epackage;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.loader.IClassLoader;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.internal.epackage.ProxyEClass;
import org.eclipse.egf.core.internal.epackage.ProxyEClassifier;
import org.eclipse.egf.core.internal.epackage.ProxyEDataType;
import org.eclipse.egf.core.internal.epackage.ProxyEPackage;
import org.eclipse.egf.core.internal.epackage.ProxyERoot;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Xavier Maysonnave
 *
 */
public class ProxyFactory {

    private ProxyFactory() {
        // Prevent Instantiation
    }

    public static IProxyERoot buildIProxyERoot(IPlatformGenModel genModel) {
        if (genModel == null) {
            return null;
        }
        // EPackage
        EPackage ePackage = genModel.getEPackage();
        if (ePackage == null) {
            return null;
        }
        // ProxyERoot
        ProxyERoot root = new ProxyERoot(genModel.getNsURI());
        // ProxyEPackage
        ProxyEPackage proxy = new ProxyEPackage(root, ePackage.getName(), genModel.getGeneratedPackage(), genModel.getNsURI());
        root.addChildren(proxy);
        // Process EClassifiers
        for (EClassifier eClassifier : ePackage.getEClassifiers()) {
            proxy.addChildren(buildProxyEClassifier(proxy, eClassifier));
        }
        return root;
    }

    protected static ProxyEClassifier buildProxyEClassifier(IProxyEPackage proxy, EClassifier eClassifier) {
        if (eClassifier instanceof EClass) {
            return new ProxyEClass(proxy, eClassifier.getName(), eClassifier.getInstanceClassName(), EcoreUtil.getURI(eClassifier));
        }
        return new ProxyEDataType(proxy, eClassifier.getName(), eClassifier.getInstanceClassName(), EcoreUtil.getURI(eClassifier));
    }

    @SuppressWarnings("rawtypes")
    public static IProxyERoot buildIProxyERoot(IClassLoader loader, IPlatformGenModel genModel) throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        // EPackage
        Class<?> clazz = loader.loadClass(genModel.getGeneratedPackage());
        Field field = clazz.getField("eINSTANCE"); //$NON-NLS-1$
        Object object = field.get(null);
        Method method = clazz.getMethod("getNsURI", new Class[] {}); //$NON-NLS-1$
        String nsURI = (String) method.invoke(object);
        method = clazz.getMethod("getName", new Class[] {}); //$NON-NLS-1$
        String name = (String) method.invoke(object);
        // ProxyERoot
        ProxyERoot root = new ProxyERoot(URI.createURI(nsURI));
        // ProxyEPackage
        URI NsURI = URI.createURI(nsURI);
        ProxyEPackage proxy = new ProxyEPackage(root, name, genModel.getGeneratedPackage(), NsURI);
        root.addChildren(proxy);
        // EClassifiers
        method = clazz.getMethod("getEClassifiers", new Class[] {}); //$NON-NLS-1$
        for (Object innerObject : (List) method.invoke(object)) {
            innerObject = buildProxyEClassifier(loader, proxy, innerObject);
            if (innerObject != null) {
                proxy.addChildren((ProxyEClassifier) innerObject);
            }
        }
        return root;
    }

    protected static ProxyEClassifier buildProxyEClassifier(IClassLoader loader, IProxyEPackage proxy, Object object) throws IllegalArgumentException, IllegalAccessException, SecurityException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Method getName = object.getClass().getMethod("getName", new Class[] {}); //$NON-NLS-1$
        String name = (String) getName.invoke(object);
        // Solve EClassifier URI against EcoreUtil
        Class<?> ecoreUtil = loader.loadClass("org.eclipse.emf.ecore.util.EcoreUtil"); //$NON-NLS-1$
        Class<?> eObject = loader.loadClass("org.eclipse.emf.ecore.EObject"); //$NON-NLS-1$
        Method getUri = ecoreUtil.getMethod("getURI", new Class[] { eObject}); //$NON-NLS-1$
        Object innerObject = getUri.invoke(ecoreUtil, eObject.cast(object));
        if (innerObject == null) {
            return null;
        }
        // Build proxy
        URI uri = URI.createURI(innerObject.toString());
        if ("org.eclipse.emf.ecore.impl.EClassImpl".equals(object.getClass().getName())) { //$NON-NLS-1$
            return new ProxyEClass(proxy, name, EMFHelper.getInstanceClassName(loader, object, uri), uri);
        }
        return new ProxyEDataType(proxy, name, EMFHelper.getInstanceClassName(loader, object, uri), uri);
    }

}
