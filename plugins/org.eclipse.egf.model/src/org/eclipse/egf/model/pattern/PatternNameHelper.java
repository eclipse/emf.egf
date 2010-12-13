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

import org.eclipse.egf.core.fcore.IPlatformFcore;

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

}
