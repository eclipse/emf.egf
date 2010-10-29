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

    private static final String DEFAULT_PATTERN_NAME = "myPattern"; //$NON-NLS-1$ 

    private PatternNameHelper() {
        // Prevent instantiation
    }

    public static String getNewPatternName(IPlatformFcore fcore, PatternLibrary library) {
        if (fcore == null || library == null) {
            return DEFAULT_PATTERN_NAME;
        }
        // Fake a new pattern to get a unique name
        Pattern pattern = PatternFactory.eINSTANCE.createPattern();
        for (int i = 0;; i++) {
            pattern.setName(i == 0 ? DEFAULT_PATTERN_NAME : DEFAULT_PATTERN_NAME + "_" + i); //$NON-NLS-1$
            if (ValidationHelper.isUniqueNameWithinBundle(fcore, library, pattern)) {
                break;
            }
        }
        return pattern.getName();
    }

}
