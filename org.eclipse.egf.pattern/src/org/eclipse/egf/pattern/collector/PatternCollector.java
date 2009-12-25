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

package org.eclipse.egf.pattern.collector;

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

/**
 * @author Thomas Guiu
 * 
 */
public class PatternCollector extends Collector<Pattern> {

    public static final PatternCollector INSTANCE = new PatternCollector();

    protected void doCollect(EObject source, final Set<Pattern> result, final Set<String> ids) {
        if (FcorePackage.eINSTANCE.equals(source.eClass().getEPackage())) {
            switch (source.eClass().getClassifierID()) {
            case FcorePackage.FACTORY_COMPONENT:
                for (Viewpoint viewpoint : ((FactoryComponent) source).getViewpointContainer().getViewpoints())
                    doCollect(viewpoint, result, ids);
                return;
            }
        }
        if (PatternPackage.eINSTANCE.equals(source.eClass().getEPackage())) {
            switch (source.eClass().getClassifierID()) {
            case PatternPackage.PATTERN_VIEWPOINT:
                for (PatternLibrary lib : ((PatternViewpoint) source).getLibraries())
                    doCollect(lib, result, ids);
                return;
            case PatternPackage.PATTERN_LIBRARY:
                for (PatternElement elem : ((PatternLibrary) source).getElements())
                    doCollect(elem, result, ids);
                return;
            case PatternPackage.PATTERN:
                final Pattern pattern = (Pattern) source;
                final String id = pattern.getID();
                if (ids == null || ids.isEmpty() || (id != null && ids.contains(id)))
                    result.add(pattern);
                return;
            }
        }
    }

    private PatternCollector() {
        super();

    }

}
