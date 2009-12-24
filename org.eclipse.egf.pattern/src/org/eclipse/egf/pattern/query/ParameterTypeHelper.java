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

package org.eclipse.egf.pattern.query;

import org.eclipse.egf.core.platform.resource.ResourceHelper;
import org.eclipse.egf.pattern.Messages;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * TODO we need to manage ecore models from the workspace.
 * 
 * @author Thomas Guiu
 * 
 */
public class ParameterTypeHelper {
    public static final ParameterTypeHelper INSTANCE = new ParameterTypeHelper();

    /**
     * Compute the literal value associated to the given type.<br/>
     * It can be a java classname or an uri to an EObject.
     * 
     * 
     */
    public String getTypeLiteral(String type) {
        if (type == null || "".equals(type))
            throw new IllegalArgumentException();
        int index = type.indexOf('#');
        if (index == -1)
            return type;
        EPackage ePackage = getEPackage(type, index);
        String nsURI = ePackage.getNsURI();
        URI uri = EcorePlugin.getEPackageNsURIToGenModelLocationMap().get(nsURI);
        Resource res = loadResource(uri);
        for (EObject obj : res.getContents()) {
            if (obj instanceof GenModel) {
                GenModel genModel = (GenModel) obj;
                for (GenPackage gPack : genModel.getGenPackages()) {
                    EPackage ecorePackage = gPack.getEcorePackage();
                    if (ePackage.getName().equals(ecorePackage.getName()) && ePackage.getNsPrefix().equals(ecorePackage.getNsPrefix()) && ePackage.getNsURI().equals(ecorePackage.getNsURI())) {
                        return gPack.getBasePackage() + "." + ePackage.getName() + "." + getClassName(type, index);
                    }
                }
            }
        }
        throw new IllegalStateException(Messages.bind(Messages.assembly_error7, type));
    }

    /**
     * load the type described in the string parameter.<br/>
     * It can be a java classname or an uri to an EObject.
     */
    public Object loadClass(String type) {
        if (type == null || "".equals(type))
            throw new IllegalArgumentException();
        int index = type.indexOf('#');
        if (index > 0) {
            return loadEClass(type, index);
        }
        try {
            return getClass().getClassLoader().loadClass(type);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    private EClass loadEClass(String type, int index) {
        String nsuri = getNsURI(type, index);
        String className = getClassName(type, index);

        EPackage ePackage = getEPackage(type, index);
        EClass eClassifier = (EClass) ePackage.getEClassifier(className);
        if (eClassifier == null)
            throw new IllegalStateException(Messages.bind(Messages.classloader_error3, className, nsuri));
        return eClassifier;
    }

    private EPackage getEPackage(String type, int index) {
        return EPackage.Registry.INSTANCE.getEPackage(getNsURI(type, index));
    }

    private String getNsURI(String type, int index) {
        return type.substring(0, index);
    }

    private String getClassName(String type, int index) {
        String className = type.substring(index + 1);
        if (className.startsWith("//"))
            return className.substring(2);
        return className;
    }

    private Resource loadResource(URI uri) {
        // TODO it may be interesting to keep loaded resources for future
        // uses ... however, workspace resources may change.
        ResourceSetImpl set = new ResourceSetImpl();
        Resource res = ResourceHelper.loadResource(set, uri);
        return res;
    }

    private ParameterTypeHelper() {
    }

}
