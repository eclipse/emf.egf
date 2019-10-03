/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.collector;

import java.util.List;
import java.util.Set;

import org.eclipse.egf.model.pattern.Pattern;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternCollector extends Collector<Pattern> {

    public static final PatternCollector INSTANCE = new PatternCollector();

    @Override
    protected void casePattern(Pattern source, List<Pattern> result, Set<String> ids) {
        final Pattern pattern = source;
        final String id = pattern.getID();
        if (!result.contains(pattern) && (ids == null || ids.isEmpty() || (id != null && ids.contains(id))))
            result.add(pattern);
    }

    private PatternCollector() {
        super();
    }

}
