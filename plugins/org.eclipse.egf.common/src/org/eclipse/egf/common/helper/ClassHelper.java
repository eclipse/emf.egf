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
 * @author Xavier Maysonnave
 * 
 */
public class ClassHelper {

    private ClassHelper() {
        // Prevent Instantiation
    }

    public static boolean isSubClass(Class<?> clazz, Class<?> type) {
        if (clazz == null || type == null) {
            return false;
        }
        // Same type
        if (clazz.getName().equals(type.getName())) {
            return true;
        }
        // ClassLoader issues, String check
        for (Class<?> innerClass : clazz.getInterfaces()) {
            if (innerClass.getName().equals(type.getName())) {
                return true;
            }
        }
        // Parent Checking
        if (clazz.getSuperclass() != null) {
            if (isSubClass(clazz.getSuperclass(), type)) {
                return true;
            }
        }
        return false;
    }

}
