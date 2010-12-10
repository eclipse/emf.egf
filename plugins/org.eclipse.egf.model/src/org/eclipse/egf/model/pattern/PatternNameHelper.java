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

import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.helper.ValidationHelper;

/**
 * @author Xavier Maysonnave
 *
 */
public class PatternNameHelper {

    public static final String DEFAULT_PATTERN_NAME = "myPattern"; //$NON-NLS-1$ 

    private PatternNameHelper() {
        // Prevent instantiation
    }

    public static void setUniquePatternName(IPlatformFcore fcore, Pattern pattern) {
        if (fcore == null || pattern == null || pattern.getContainer() == null) {
            return;
        }
        for (int i = 0;; i++) {
            if (ValidationHelper.isUniqueNameWithinBundle(fcore, pattern.getContainer(), pattern)) {
                break;
            }
            pattern.setName(i == 0 ? DEFAULT_PATTERN_NAME : DEFAULT_PATTERN_NAME + "_" + i); //$NON-NLS-1$
        }
        return;
    }

}
