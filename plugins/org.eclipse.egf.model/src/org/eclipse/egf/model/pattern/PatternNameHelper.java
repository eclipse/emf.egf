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
package org.eclipse.egf.model.pattern;

import java.util.List;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.domain.RuntimePlatformResourceSet;
import org.eclipse.egf.core.domain.TargetPlatformResourceSet;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Xavier Maysonnave
 *
 */
public class PatternNameHelper {

    public static final String DEFAULT_PATTERN_NAME = "myPattern"; //$NON-NLS-1$ 

    private PatternNameHelper() {
        // Prevent instantiation
    }

    public static void setUniquePatternName(IPlatformFcore fcore, Pattern pattern, List<String> names) {
        if (fcore == null || pattern == null || names == null) {
            return;
        }
        for (int i = 0;; i++) {
            if (names.contains(pattern.getName()) == false) {
                break;
            }
            pattern.setName(i == 0 ? DEFAULT_PATTERN_NAME : DEFAULT_PATTERN_NAME + "_" + i); //$NON-NLS-1$
        }
        return;
    }

    public static List<String> getPatternNameWithinBundle(IPlatformFcore fcore, PatternLibrary library, Pattern pattern) {
        List<String> names = new UniqueEList<String>();
        for (Pattern innerPattern : getPatterns(fcore, library)) {
            if (innerPattern.getName() != null && innerPattern.getName().trim().length() != 0 && pattern != innerPattern) {
                names.add(innerPattern.getName());
            }
        }
        return names;
    }

    public static List<Pattern> getPatterns(IPlatformFcore fcore, PatternLibrary library, Pattern pattern, String patternName) {
        List<Pattern> patterns = new UniqueEList<Pattern>();
        if (patternName == null || patternName.trim().length() == 0) {
            return patterns;
        }
        for (Pattern innerPattern : getPatterns(fcore, library)) {
            if (pattern != innerPattern && patternName.equals(innerPattern.getName())) {
                patterns.add(innerPattern);
            }
        }
        return patterns;
    }

    public static List<Pattern> getPatterns(IPlatformFcore fcore, PatternLibrary library) {
        List<Pattern> patterns = new UniqueEList<Pattern>();
        if (fcore == null || library == null || library.getName() == null || library.getName().trim().length() == 0) {
            return patterns;
        }
        ResourceSet resourceSet = null;
        if (library.eResource() != null) {
            resourceSet = library.eResource().getResourceSet();
        }
        if (resourceSet == null) {
            if (fcore.isRuntime()) {
                resourceSet = new RuntimePlatformResourceSet();
            } else {
                resourceSet = new TargetPlatformResourceSet();
            }
        }
        IPlatformFcore[] fcores = null;
        if (fcore.isRuntime()) {
            fcores = EGFCorePlugin.getRuntimePlatformFcores(fcore.getBundle());
        } else {
            fcores = EGFCorePlugin.getTargetPlatformFcores(fcore.getPluginModelBase());
        }
        for (IPlatformFcore innerFcore : fcores) {
            Resource resource = resourceSet.getResource(innerFcore.getURI(), true);
            for (EObject root : resource.getContents()) {
                for (EObject innerEObject : EMFHelper.getAllProperContents(PatternPackage.eINSTANCE.getPattern(), root)) {
                    Pattern innerPattern = (Pattern) innerEObject;
                    if (innerPattern.getContainer().getName().equals(library.getName())) {
                        patterns.add((Pattern) innerEObject);
                    }
                }
            }
        }
        return patterns;
    }

}
