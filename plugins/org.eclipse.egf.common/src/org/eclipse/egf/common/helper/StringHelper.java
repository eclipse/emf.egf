/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.helper;

/**
 * String helper.
 * 
 * @author Xavier Maysonnave
 */
public class StringHelper {

    private StringHelper() {
        // Prevent Instantiation
    }

    /**
     * Lower case the first character of a string
     * 
     * @param s
     * @return new String with the first character lower cased
     */
    public static String toLowerFirst(String s) {
        if (s == null || s.trim().length() == 0) {
            return s;
        }
        String source = s.trim();
        if (source.length() == 1) {
            return source.toLowerCase();
        }
        return source.substring(0, 1).toLowerCase() + source.substring(1);
    }

    /**
     * Upper case the first character of a string
     * 
     * @param s
     * @return new String with the first character uper cased
     */
    public static String toUpperFirst(String s) {
        if (s == null || s.trim().length() == 0) {
            return s;
        }
        String source = s.trim();
        if (source.length() == 1) {
            return source.toUpperCase();
        }
        return source.substring(0, 1).toUpperCase() + source.substring(1);
    }

}
