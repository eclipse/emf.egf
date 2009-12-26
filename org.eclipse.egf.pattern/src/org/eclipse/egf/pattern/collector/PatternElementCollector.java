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

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternLibrary;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternElementCollector extends Collector<PatternElement> {

    public static final PatternElementCollector INSTANCE = new PatternElementCollector();

    @Override
    protected void casePatternLibrary(PatternLibrary lib, Set<PatternElement> result, Set<String> ids) {
        final String id = lib.getID();
        if (ids == null || ids.isEmpty() || (id != null && ids.contains(id)))
            result.add(lib);
        super.casePatternLibrary(lib, result, ids);
    }

    protected void casePattern(Pattern source, Set<PatternElement> result, Set<String> ids) {
        final Pattern pattern = (Pattern) source;
        final String id = pattern.getID();
        if (ids == null || ids.isEmpty() || (id != null && ids.contains(id)))
            result.add(pattern);
    }

    private PatternElementCollector() {
        super();
    }

}
