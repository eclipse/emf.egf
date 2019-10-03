/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-v2.0.
 *
 *  SPDX-License-Identifier: EPL-2.0
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.domain;

/**
 * @author Thomas Guiu
 * 
 */
public class DomainException extends Exception {

    private static final long serialVersionUID = -6377819790367064733L;

    public DomainException(String message) {
        super(message);

    }

    public DomainException(Throwable cause) {
        super(cause);

    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);

    }

}
