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

package org.eclipse.egf.core.producer;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * @author Guiu
 * 
 */
public class InvocationException extends Exception {

    /**
     * Optional Diagnostic
     */
    private Diagnostic _diagnostic;

    /**
    * 
    */
    private static final long serialVersionUID = -9002049838656655457L;

    /**
     * @param message
     * @param cause
     */
    public InvocationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public InvocationException(String message) {
        this(message, null);
    }

    /**
     * @param cause
     */
    public InvocationException(Throwable cause) {
        this(null, cause);
    }

    /**
     * @param diagnostic
     */
    public void setDiagnostic(Diagnostic diagnostic) {
        _diagnostic = diagnostic;
    }

    /**
     * @return _diagnostic
     */
    public Diagnostic getDiagnostic() {
        return _diagnostic;
    }

}
