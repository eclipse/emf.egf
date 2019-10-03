/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.collector;

import java.util.List;
import java.util.Set;

import org.eclipse.egf.model.pattern.PatternLibrary;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternLibraryCollector extends Collector<PatternLibrary> {

    public static final PatternLibraryCollector INSTANCE = new PatternLibraryCollector();

    @Override
    protected void casePatternLibrary(PatternLibrary lib, List<PatternLibrary> result, Set<String> ids) {
        final String id = lib.getID();
        if (!result.contains(lib) && (ids == null || ids.isEmpty() || (id != null && ids.contains(id))))
            result.add(lib);
        super.casePatternLibrary(lib, result, ids);
    }

    private PatternLibraryCollector() {
        super();
    }

}
