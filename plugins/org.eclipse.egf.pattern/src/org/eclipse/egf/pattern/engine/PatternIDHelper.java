/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO drop this class and introduce a new type for contracts
 * 
 * @author Thomas Guiu
 * 
 */
public class PatternIDHelper {

    public static String merge(List<String> ids) {
        if (ids.isEmpty())
            return ""; //$NON-NLS-1$
        StringBuilder builder = new StringBuilder(400);
        for (String id : ids)
            builder.append(",").append(id); //$NON-NLS-1$
        return builder.substring(1);
    }

    public static List<String> split(String value) {
        String[] split = value.split(","); //$NON-NLS-1$
        List<String> result = new ArrayList<String>(split.length);
        for (String token : split)
            result.add(token.trim());
        return result;
    }

}
