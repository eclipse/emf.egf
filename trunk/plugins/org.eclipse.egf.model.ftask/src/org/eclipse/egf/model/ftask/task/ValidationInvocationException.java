/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
