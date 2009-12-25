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

package org.eclipse.egf.pattern.strategy;

import java.util.List;
import java.util.Set;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.emf.ecore.EObject;

public class PatternCollector {

    public void collect(EObject source, final Set<Pattern> result) {
        if (result == null)
            throw new IllegalArgumentException();
        if (source == null)
            throw new IllegalArgumentException();
        doCollect(source, result);
    }

    private void doCollect(EObject source, final Set<Pattern> result) {
        switch (source.eClass().getClassifierID()) {
        case FcorePackage.FACTORY_COMPONENT:
            for (Viewpoint viewpoint : ((FactoryComponent) source).getViewpointContainer().getViewpoints())
                doCollect(viewpoint, result);
            return;
        case PatternPackage.PATTERN_VIEWPOINT:
            for (PatternLibrary lib : ((PatternViewpoint) source).getLibraries())
                doCollect(lib, result);
            return;
        case PatternPackage.PATTERN_LIBRARY:
            for (PatternElement elem : ((PatternLibrary) source).getElements())
                doCollect(elem, result);
            return;
        case PatternPackage.PATTERN:
            result.add((Pattern) source);
            return;
        }
    }

    public void collect(List<EObject> source, final Set<Pattern> result) {
        if (result == null)
            throw new IllegalArgumentException();
        if (source == null)
            throw new IllegalArgumentException();
        for (EObject obj : source)
            collect(obj, result);
    }

    public void collect(EObject[] source, final Set<Pattern> result) {

        if (result == null)
            throw new IllegalArgumentException();
        if (source == null)
            throw new IllegalArgumentException();
        for (EObject obj : source)
            collect(obj, result);
    }
}
