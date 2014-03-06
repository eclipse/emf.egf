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
