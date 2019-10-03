/**
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
 */
package org.eclipse.egf.model.pattern;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 8116611457122932191L;

    public PatternRuntimeException(Throwable cause) {
        super(cause);
    }

}
