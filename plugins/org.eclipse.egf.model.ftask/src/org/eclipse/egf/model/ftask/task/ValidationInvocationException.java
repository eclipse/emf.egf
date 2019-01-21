/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.model.ftask.task;

import org.eclipse.egf.core.producer.InvocationException;

/**
 * @author Matthieu Helleboid
 *
 */
public class ValidationInvocationException extends InvocationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1648978282925540628L;

	public ValidationInvocationException(String message) {
		super(message);
	}

}
