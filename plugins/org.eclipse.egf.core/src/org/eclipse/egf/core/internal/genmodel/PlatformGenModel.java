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
 * 
 */
package org.eclipse.egf.core.internal.genmodel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.helper.URIHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.epackage.EClassWrapper;
import org.eclipse.egf.core.epackage.EClassifierWrapper;
import org.eclipse.egf.core.epackage.EDataTypeWrapper;
import org.eclipse.egf.core.epackage.EPackageWrapper;
import org.eclipse.egf.core.epackage.ERootWrapper;
import org.eclipse.egf.core.genmodel.IPlatformGenModel;
import org.eclipse.egf.core.platform.loader.BundleClassLoaderFactory;
import org.eclipse.egf.core.platform.loader.IBundleClassLoader;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.PlatformExtensionPointURI;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

public final class PlatformGenModel extends PlatformExtensionPointURI implements IPlatformGenModel {

    private String _generatedPackage;

    private String _genModel;

    private URI _genModelURI;

    private static Map<URI, URI> _targetPlatformGenModelLocationMap;

    private static Map<URI, IPlatformGenModel> _nsURIToTargetPlatformGenModel;

    private static Map<URI, URI> _runtimePlatformGenModelLocationMap;

    private static Map<URI, IPlatformGenModel> _nsURIToRuntimePlatformGenModel;

    /**
     * Returns a map from {@link EPackage#getNsURI() package namespace URI} (represented as a String)
     * to the location of the GenModel containing a GenPackage for the package (represented as a {@link URI URI}).
     * 
     * @return a map from package namespace to GenModel location.
     */
    public static Map<URI, URI> getTargetPlatformGenModelLocationMap() {
        if (_targetPlatformGenModelLocationMap == null) {
            _targetPlatformGenModelLocationMap = new HashMap<URI, URI>();
        }
        return _targetPlatformGenModelLocationMap;
    }

    public static Map<URI, IPlatformGenModel> getTargetPlatformGenModels() {
        if (_nsURIToTargetPlatformGenModel == null) {
            _nsURIToTargetPlatformGenModel = new HashMap<URI, IPlatformGenModel>();
        }
        return _nsURIToTargetPlatformGenModel;
    }

    /**
     * Returns a map from {@link EPackage#getNsURI() package namespace URI} (represented as a String)
     * to the location of the GenModel containing a GenPackage for the package (represented as a {@link URI URI}).
     * 
     * @return a map from package namespace to GenModel location.
     */
    public static Map<URI, URI> getRuntimePlatformGenModelLocationMap() {
        if (_runtimePlatformGenModelLocationMap == null) {
            _runtimePlatformGenModelLocationMap = new HashMap<URI, URI>();
        }
        return _runtimePlatformGenModelLocationMap;
    }

    public static Map<URI, IPlatformGenModel> getRuntimePlatformGenModels() {
        if (_nsURIToRuntimePlatformGenModel == null) {
            _nsURIToRuntimePlatformGenModel = new HashMap<URI, IPlatformGenModel>();
        }
        return _nsURIToRuntimePlatformGenModel;
    }

    public static URI getEPackageNsURI(URI nsURI) {
        if (nsURI == null) {
            return null;
        }
        String uri = nsURI.toString();
        if (uri.contains("#//") == false) { //$NON-NLS-1$
            return nsURI;
        }
        return URI.createURI(uri.substring(0, uri.indexOf("#//"))); //$NON-NLS-1$
    }

    public static String getBasePackage(IPlatformGenModel genModel) {
        String classname = genModel.getGeneratedPackage();
        int index = classname.lastIndexOf("."); //$NON-NLS-1$
        if (index == -1 || index == 0) {
            return null;
        }
        return classname.substring(0, index);
    }

    public static ERootWrapper buildERootWrapper(IPlatformGenModel genModel) {
        // EPackage
        EPackage ePackage = genModel.getEPackage();
        if (ePackage == null) {
            return null;
        }
        // ERootWrapepr
        ERootWrapper root = new ERootWrapper(genModel.getNsURI());
        // EPackageWrapper
        EPackageWrapper wrapper = new EPackageWrapper(root, ePackage.getName(), genModel.getNsURI());
        root.getChildren().add(wrapper);
        // EClassifiers
        for (EClassifier eClassifier : ePackage.getEClassifiers()) {
            wrapper.getChildren().add(buildEObjectWrapper(wrapper, eClassifier));
        }
        return root;
    }

    public static EClassifierWrapper buildEObjectWrapper(EPackageWrapper wrapper, EClassifier eClassifier) {
        if (eClassifier instanceof EClass) {
            return new EClassWrapper(wrapper, eClassifier.getName(), EcoreUtil.getURI(eClassifier));
        }
        return new EDataTypeWrapper(wrapper, eClassifier.getName(), EcoreUtil.getURI(eClassifier));
    }

    @SuppressWarnings("rawtypes")
    public static ERootWrapper buildERootWrapper(IBundleClassLoader loader, IPlatformGenModel genModel) throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        // EPackage
        Class<?> clazz = loader.loadClass(genModel.getGeneratedPackage());
        Field field = clazz.getField("eINSTANCE"); //$NON-NLS-1$
        Object object = field.get(null);
        Method method = clazz.getMethod("getNsURI", new Class[] {}); //$NON-NLS-1$
        String nsURI = (String) method.invoke(object);
        method = clazz.getMethod("getName", new Class[] {}); //$NON-NLS-1$
        String name = (String) method.invoke(object);
        // ERootWrapepr
        ERootWrapper root = new ERootWrapper(URI.createURI(nsURI));
        // EPackageWrapper
        EPackageWrapper wrapper = new EPackageWrapper(root, name, URI.createURI(nsURI));
        root.getChildren().add(wrapper);
        // EClassifiers
        method = clazz.getMethod("getEClassifiers", new Class[] {}); //$NON-NLS-1$
        for (Object innerObject : (List) method.invoke(object)) {
            wrapper.getChildren().add(buildEObjectWrapper(wrapper, innerObject));
        }
        return root;
    }

    public static EClassifierWrapper buildEObjectWrapper(EPackageWrapper wrapper, Object object) throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchMethodException, InvocationTargetException {
        Method method = object.getClass().getMethod("getName", new Class[] {}); //$NON-NLS-1$
        String name = (String) method.invoke(object);
        if ("org.eclipse.emf.ecore.impl.EClassImpl".equals(object.getClass().getName())) { //$NON-NLS-1$
            return new EClassWrapper(wrapper, name, URI.createURI(wrapper.getNsURI() + "#//" + name)); //$NON-NLS-1$
        }
        return new EDataTypeWrapper(wrapper, name, URI.createURI(wrapper.getNsURI() + "#//" + name)); //$NON-NLS-1$
    }

    public PlatformGenModel(IPlatformBundle bundle, String uri, String className, String genModel) {
        super(bundle, uri);
        Assert.isNotNull(className);
        Assert.isLegal(className.trim().length() != 0);
        Assert.isLegal(bundle.isRuntime() == false);
        _generatedPackage = className.trim();
        if (genModel != null && genModel.trim().length() != 0) {
            _genModel = genModel.trim();
            _genModelURI = URIHelper.getPlatformPluginURI(getPlatformBundle().getBundleId(), URI.decode(_genModel), false);
            getTargetPlatformGenModelLocationMap().put(getNsURI(), _genModelURI);
        }
        getTargetPlatformGenModels().put(getNsURI(), this);
    }

    public PlatformGenModel(IPlatformBundle bundle, String uri, String uniqueIdentifier, int handleId, String className, String genModel) {
        super(bundle, uri, uniqueIdentifier, handleId);
        Assert.isNotNull(className);
        Assert.isLegal(className.trim().length() != 0);
        Assert.isLegal(bundle.isRuntime());
        _generatedPackage = className.trim();
        if (genModel != null && genModel.trim().length() != 0) {
            _genModel = genModel.trim();
            _genModelURI = URIHelper.getPlatformPluginURI(getPlatformBundle().getBundleId(), URI.decode(_genModel), false);
            getRuntimePlatformGenModelLocationMap().put(getNsURI(), _genModelURI);
        }
        getRuntimePlatformGenModels().put(getNsURI(), this);
    }

    public URI getNsURI() {
        return getURI();
    }

    public String getGeneratedPackage() {
        return _generatedPackage;
    }

    public String getGenModel() {
        return _genModel;
    }

    public URI getGenModelURI() {
        return _genModelURI;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object) == false) {
            return false;
        }
        if (object instanceof IPlatformGenModel == false) {
            return false;
        }
        IPlatformGenModel platformGenModel = (IPlatformGenModel) object;
        if (platformGenModel.getGeneratedPackage().equals(getGeneratedPackage()) == false) {
            return false;
        }
        if (platformGenModel.getGenModel() == null && getGenModel() == null) {
            return true;
        }
        if (platformGenModel.getGenModel() == null || getGenModel() == null) {
            return false;
        }
        if (platformGenModel.getGenModel().equals(getGenModel()) == false) {
            return false;
        }
        return true;
    }

    public String getBasePackage() {
        return getBasePackage(this);
    }

    public EPackageWrapper getEPackageWrapper() {
        ERootWrapper wrapper = getERootWrapper();
        if (wrapper != null && wrapper.getChildren().size() == 1) {
            return wrapper.getChildren().get(0);
        }
        return null;
    }

    public ERootWrapper getERootWrapper() {
        // Load the static resource
        try {
            if (getBundle() == null) {
                IBundleClassLoader loader = BundleClassLoaderFactory.getBundleClassLoader(getPluginModelBase());
                return buildERootWrapper(loader, this);
            }
            return buildERootWrapper(this);
        } catch (Throwable t) {
            EGFCorePlugin.getDefault().logError(t);
        }
        return null;
    }

    public EPackage getEPackage() {
        if (getBundle() != null) {
            return EPackage.Registry.INSTANCE.getEPackage(getNsURI().toString());
        }
        return null;
    }

    @Override
    protected void dispose() {
        if (isTarget() || isWorkspace()) {
            getTargetPlatformGenModelLocationMap().remove(getNsURI());
            getTargetPlatformGenModels().remove(getNsURI());
        } else {
            getRuntimePlatformGenModelLocationMap().remove(getNsURI());
            getRuntimePlatformGenModels().remove(getNsURI());
        }
    }

}
