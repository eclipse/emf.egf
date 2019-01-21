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
 * 
 */
package org.eclipse.egf.core.internal.fcore;

import org.eclipse.core.runtime.Path;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.PlatformExtensionPointURI;

public final class PlatformFcore extends PlatformExtensionPointURI implements IPlatformFcore {

	private String _name;

	public PlatformFcore(IPlatformBundle bundle, String id) {
		super(bundle, id);
		_name = new Path(getURI().lastSegment()).removeFileExtension().toString();
	}

	public PlatformFcore(IPlatformBundle bundle, String id, String uniqueIdentifier, int handleId) {
		super(bundle, id, uniqueIdentifier, handleId);
		_name = new Path(getURI().lastSegment()).removeFileExtension().toString();
	}

	public String getName() {
		return _name;
	}

}
