/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.base;

import org.eclipse.emf.ecore.EClass;

/**
 * @author Matthieu Helleboid
 *
 */
public class EMFPatternHelper {

    public static boolean isSameEClass(EClass eClass1, EClass eClass2) {
        return getURI(eClass1).equals(getURI(eClass2));
    }

    public static String getURI(EClass eClass) {
        return eClass.getEPackage().getNsURI() + "#" + eClass.getName(); //$NON-NLS-1$
    }

}
