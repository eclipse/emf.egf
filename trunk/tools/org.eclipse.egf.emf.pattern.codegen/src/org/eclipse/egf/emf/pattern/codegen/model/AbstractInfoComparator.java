/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.emf.pattern.codegen.model;

import java.util.Comparator;

/**
 * @author Matthieu Helleboid
 * 
 */
public final class AbstractInfoComparator implements Comparator<AbstractInfo> {
    public int compare(AbstractInfo abstractInfo1, AbstractInfo abstractInfo2) {
        int partCompare = abstractInfo1.getPartType().compareTo(abstractInfo2.getPartType());
        if (partCompare != 0)
            return partCompare;

        int contentCompare = abstractInfo1.getContentType().compareTo(abstractInfo2.getContentType());
        return contentCompare;
    }
}