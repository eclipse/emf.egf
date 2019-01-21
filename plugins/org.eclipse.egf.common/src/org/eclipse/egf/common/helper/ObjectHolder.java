/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.common.helper;

/**
 * @author Guiu
 * 
 */
public class ObjectHolder<E> {

    public E object;

    public ObjectHolder() {
    }

    public ObjectHolder(E object) {
        super();
        this.object = object;
    }

    @Override
    public String toString() {
        return object == null ? "null" : object.toString(); //$NON-NLS-1$
    }

}
