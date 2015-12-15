/**
 * Copyright (c) 2015 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.core.domain;

import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author Thomas Guiu
 */
public class EgfResourceSet extends ResourceSetImpl {

	private boolean runtimeOnly;

	public EgfResourceSet() {
		this(false);

	}

	public EgfResourceSet(boolean runtimeOnly) {
		this.runtimeOnly = runtimeOnly;
		if (!runtimeOnly)
			setURIConverter(EGFPlatformPlugin.getPlatformURIConverter());
	}

	public boolean isRuntimeOnly() {
		return runtimeOnly;
	}

}
