/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.egf.common.EGFCommonPlugin;
import org.eclipse.egf.common.loader.IClassLoader;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
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

    public static String getInstanceClassName(EPackage ePackage, URI uri) {
        if (ePackage == null || uri == null) {
            return null;
        }
        if (uri.hasFragment()) {
            EObject eObject = ePackage.eResource().getEObject(uri.fragment());
            if (eObject != null && eObject instanceof EClassifier) {
                return ((EClassifier) eObject).getInstanceClassName();
            }
        }
        return null;
    }

    public static String getInstanceClassName(IClassLoader loader, Object object, URI uri) throws IllegalArgumentException, IllegalAccessException, SecurityException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        if (object == null || uri == null) {
            return null;
        }
        Object ePackage = getEPackage(loader, object);
        if (ePackage == null) {
            return null;
        }
        if (uri.hasFragment()) {
            object = ePackage.getClass().getMethod("eResource", new Class[] {}).invoke(ePackage); //$NON-NLS-1$
            if (object != null) {
                object = object.getClass().getMethod("getEObject", new Class[] { java.lang.String.class}).invoke(object, uri.fragment()); //$NON-NLS-1$
                if (object != null) {
                    // EClassifier
                    Class<?> eClassifier = loader.loadClass("org.eclipse.emf.ecore.EClassifier"); //$NON-NLS-1$
                    if (eClassifier.isInstance(object)) {
                        return (String) object.getClass().getMethod("getInstanceClassName", new Class[] {}).invoke(object); //$NON-NLS-1$
                    }
                }
            }
        }
        return null;
    }

    public static URI getEPackageNsURI(EPackage ePackage, URI uri) {
        if (ePackage == null || uri == null) {
            return null;
        }
        if (uri.hasFragment()) {
            EObject eObject = ePackage.eResource().getEObject(uri.fragment());
            if (eObject != null) {
                ePackage = getEPackage(eObject);
                if (ePackage != null) {
                    return URI.createURI(ePackage.getNsURI());
                }
            }
        }
        return URI.createURI(ePackage.getNsURI());
    }

    public static URI getEPackageNsURI(IClassLoader loader, String generatedPackage, URI uri) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, SecurityException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        if (loader == null || generatedPackage == null || generatedPackage.trim().length() == 0 || uri == null) {
            return null;
        }
        // EPackage
        Class<?> eGeneratedPackage = loader.loadClass(generatedPackage.trim());
        if (eGeneratedPackage != null && uri.hasFragment()) {
            Object object = eGeneratedPackage.getField("eINSTANCE").get(null); //$NON-NLS-1$
            if (object != null) {
                object = eGeneratedPackage.getMethod("eResource", new Class[] {}).invoke(object); //$NON-NLS-1$
                if (object != null) {
                    object = object.getClass().getMethod("getEObject", new Class[] { java.lang.String.class}).invoke(object, uri.fragment()); //$NON-NLS-1$
                    if (object != null) {
                        object = EMFHelper.getEPackage(loader, object);
                        if (object != null && loader.loadClass("org.eclipse.emf.ecore.EPackage").isInstance(object)) { //$NON-NLS-1$
                            return URI.createURI(object.getClass().getMethod("getNsURI", new Class[] {}).invoke(object).toString()); //$NON-NLS-1$
                        }
                    }
                }
            }
        }
        return null;
    }

    public static Object getEPackage(IClassLoader loader, Object object) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        if (loader == null || object == null) {
            return null;
        }
        // EObject
        Class<?> eObject = loader.loadClass("org.eclipse.emf.ecore.EObject"); //$NON-NLS-1$
        if (eObject.isInstance(object) == false) {
            return null;
        }
        // EPackage
        Class<?> ePackage = loader.loadClass("org.eclipse.emf.ecore.EPackage"); //$NON-NLS-1$
        if (ePackage.isInstance(object)) {
            return object;
        }
        // EClassifier
        Class<?> eClassifier = loader.loadClass("org.eclipse.emf.ecore.EClassifier"); //$NON-NLS-1$
        if (eClassifier.isInstance(object)) {
            return object.getClass().getMethod("getEPackage", new Class[] {}).invoke(object); //$NON-NLS-1$
        }
        // EOperation
        Class<?> eOperation = loader.loadClass("org.eclipse.emf.ecore.EOperation"); //$NON-NLS-1$
        if (eOperation.isInstance(object)) {
            Method getEContainingClass = object.getClass().getMethod("getEContainingClass", new Class[] {}); //$NON-NLS-1$
            object = getEContainingClass.invoke(object);
            return object.getClass().getMethod("getEPackage", new Class[] {}).invoke(object); //$NON-NLS-1$
        }
        // EStructuralFeature
        Class<?> eStructuralFeature = loader.loadClass("org.eclipse.emf.ecore.EStructuralFeature"); //$NON-NLS-1$
        if (eStructuralFeature.isInstance(object)) {
            Method getEContainingClass = object.getClass().getMethod("getEContainingClass", new Class[] {}); //$NON-NLS-1$
            object = getEContainingClass.invoke(object);
            return object.getClass().getMethod("getEPackage", new Class[] {}).invoke(object); //$NON-NLS-1$
        }
        // EAnnotation
        Class<?> eAnnotation = loader.loadClass("org.eclipse.emf.ecore.EAnnotation"); //$NON-NLS-1$
        if (eAnnotation.isInstance(object)) {
            Method getEModelElement = object.getClass().getMethod("getEModelElement", new Class[] {}); //$NON-NLS-1$
            return getEPackage(loader, getEModelElement.invoke(object));
        }
        // EParameter
        Class<?> eParameter = loader.loadClass("org.eclipse.emf.ecore.EParameter"); //$NON-NLS-1$
        if (eParameter.isInstance(object)) {
            Method getEOperation = object.getClass().getMethod("getEOperation", new Class[] {}); //$NON-NLS-1$
            return getEPackage(loader, getEOperation.invoke(object));
        }
        // Meta-Class analysis
        return getEPackage(loader, object.getClass().getMethod("eClass", new Class[] {}).invoke(object)); //$NON-NLS-1$
    }

    public static EPackage getEPackage(EObject eObject) {
        if (eObject == null) {
            return null;
        }
        if (eObject instanceof EPackage) {
            return (EPackage) eObject;
        } else if (eObject instanceof EClassifier) {
            return ((EClassifier) eObject).getEPackage();
        } else if (eObject instanceof EOperation) {
            return ((EOperation) eObject).getEContainingClass().getEPackage();
        } else if (eObject instanceof EStructuralFeature) {
            return ((EStructuralFeature) eObject).getEContainingClass().getEPackage();
        } else if (eObject instanceof EAnnotation) {
            return getEPackage(((EAnnotation) eObject).getEModelElement());
        } else if (eObject instanceof EParameter) {
            return getEPackage(((EParameter) eObject).getEOperation());
        }
        return getEPackage(eObject.eClass());
    }

    public static Collection<EPackage> getAllPackages(Resource resource) {
        if (resource == null) {
            return null;
        }
        List<EPackage> result = new ArrayList<EPackage>();
        for (TreeIterator<?> j = new EcoreUtil.ContentTreeIterator<Object>(resource.getContents()) {

            private static final long serialVersionUID = 1L;

            @Override
            protected Iterator<? extends EObject> getEObjectChildren(EObject eObject) {
                return eObject instanceof EPackage ? ((EPackage) eObject).getESubpackages().iterator() : Collections.<EObject> emptyList().iterator();
            }

        }; j.hasNext();) {
            Object content = j.next();
            if (content instanceof EPackage) {
                result.add((EPackage) content);
            }
        }
        return result;
    }

    public static Collection<EObject> getAllProperContents(EClassifier eClassifier, EObject owner) {
        Collection<EObject> result = new ArrayList<EObject>();
        if (eClassifier == null || owner == null) {
            return result;
        }
        for (TreeIterator<EObject> j = EcoreUtil.getAllProperContents(owner, false); j.hasNext();) {
            EObject eObject = j.next();
            if (eClassifier.isInstance(eObject)) {
                result.add(eObject);
            }
        }
        return result;
    }

    public static IResource getWorkspaceResource(Resource resource) {
        if (resource == null) {
            return null;
        }
        URI uri = resource.getURI();
        if (uri != null && resource.getResourceSet() != null) {
            URIConverter converter = resource.getResourceSet().getURIConverter();
            if (converter != null) {
                uri = converter.normalize(uri);
            }
        }
        if (uri != null && uri.isPlatformResource()) {
            return ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true));
        }
        return null;
    }

    public static IProject getProject(Resource resource) {
        IResource iResource = getWorkspaceResource(resource);
        if (iResource != null) {
            return iResource.getProject();
        }
        return null;
    }

    public static IJavaProject getJavaProject(Resource resource) {
        IProject project = getProject(resource);
        if (project != null && project.isAccessible()) {
            IJavaProject javaProject = JavaCore.create(project);
            if (javaProject.exists()) {
                return javaProject;
            }
        }
        return null;
    }

    /**
     * Get root package for given one.<br>
     * Root package being the eldest parent package.
     * 
     * @param ePackage
     * @return EPackage
     */
    public static EPackage getRootPackage(EPackage ePackage) {
        if (ePackage == null) {
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
        if (ePackage == null) {
            return null;
        }
        EPackage ePackageStatic = null;
        // Get the equivalent from the Global EPackage registry.
        Object staticPackage = null;
        if (ePackage.getNsURI() != null) {
            staticPackage = EPackage.Registry.INSTANCE.get(ePackage.getNsURI());
        }
        if (staticPackage != null) {
            if (staticPackage instanceof EPackage) {
                ePackageStatic = (EPackage) staticPackage;
            } else if (staticPackage instanceof EPackage.Descriptor) {
                ePackageStatic = ((EPackage.Descriptor) staticPackage).getEPackage();
            }
        } else {
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
            if (eObject == null) {
                return eClassifier;
            }
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
     *            the model element for which to get text
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
     *            the model element for which to get text
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
     *            the model element to adapt
     * @param type
     *            indicates the type of adapter to obtain
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

    /**
     * A cross referencer that finds resolved proxies against a particular URI while
     * ignoring non resolved proxies.
     */
    public static class URIProxyCrossReferencer extends CrossReferencer {

        private static final long serialVersionUID = 1L;

        private URI _uri;

        /**
         * Creates an instance for the given resource.
         * 
         * @param resource
         *            the resource to cross reference.
         */
        protected URIProxyCrossReferencer(Resource resource, URI uri) {
            super(Collections.singleton(resource));
            _uri = uri;
        }

        /**
         * Return true if potential cross references that are proxies should be resolved.
         * 
         * @return if the cross referencer should resolve proxies.
         */
        @Override
        protected boolean resolve() {
            return false;
        }

        /**
         * Return true if the specified eReference from eObject to crossReferencedEObject should be
         * considered a cross reference by this cross referencer.
         * 
         * @param eObject
         *            an object in the cross referencer's content tree.
         * @param eReference
         *            a reference from the object.
         * @param crossReferencedEObject
         *            the target of the specified reference.
         * @return if the cross referencer should consider the specified reference a cross reference.
         */
        @Override
        protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
            if (crossReferencedEObject.eIsProxy() == false) {
                return false;
            }
            URI uri = EcoreUtil.getURI(crossReferencedEObject);
            if (uri == null) {
                return false;
            }
            uri = uri.trimFragment();
            if (_uri.equals(uri)) {
                return true;
            }
            return false;
        }

        /**
         * Returns the map of proxy references for this cross referencer.
         * 
         * @return a map of cross references.
         */
        protected Map<EObject, Collection<EStructuralFeature.Setting>> findProxyCrossReferences() {
            crossReference();
            done();
            return this;
        }

        /**
         * Returns a map of all proxy references from the specified content tree.
         * 
         * @param resource
         *            a resource whose content tree should be considered.
         * @return a map of cross references.
         */
        public static Map<EObject, Collection<EStructuralFeature.Setting>> find(Resource resource, URI uri) {
            return new URIProxyCrossReferencer(resource, uri).findProxyCrossReferences();
        }

    }

}
