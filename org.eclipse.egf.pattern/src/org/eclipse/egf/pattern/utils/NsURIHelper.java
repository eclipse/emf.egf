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

package org.eclipse.egf.pattern.utils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author Thomas Guiu
 * 
 */
public class NsURIHelper {
    public static String getFullName(EObject obj) {
        String nsURI = null;
        String typeName = null;
        EClass eClass = obj.eClass();
        nsURI = eClass.getEPackage().getNsURI();
        typeName = eClass.getName();
        if (nsURI == null || typeName == null)
            return null;
        return nsURI + "#//" + typeName;
    }
}
