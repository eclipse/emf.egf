/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
        // Type Checking
        try {
            clazz.asSubclass(type);
        } catch (ClassCastException cce) {
            return false;
        }
        return true;
    }

}
