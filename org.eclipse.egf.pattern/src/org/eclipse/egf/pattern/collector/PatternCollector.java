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

/**
 * @author Thomas Guiu
 * 
 */
public class PatternCollector extends Collector<Pattern> {

    public static final PatternCollector INSTANCE = new PatternCollector();

    @Override
    protected void casePattern(Pattern source, Set<Pattern> result, Set<String> ids) {
        final Pattern pattern = (Pattern) source;
        final String id = pattern.getID();
        if (ids == null || ids.isEmpty() || (id != null && ids.contains(id)))
            result.add(pattern);
    }

    private PatternCollector() {
        super();

    }

}
