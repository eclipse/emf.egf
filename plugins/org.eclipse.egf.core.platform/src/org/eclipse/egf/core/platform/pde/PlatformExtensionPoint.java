/**
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
 */
package org.eclipse.egf.core.platform.pde;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.core.platform.internal.pde.AbstractPlatformExtensionPoint;
import org.eclipse.emf.common.util.URI;

public abstract class PlatformExtensionPoint extends AbstractPlatformExtensionPoint implements IPlatformExtensionPoint, Comparable<IPlatformExtensionPoint> {

	private String _id;

	public PlatformExtensionPoint(IPlatformBundle bundle, String id) {
		super(bundle);
		Assert.isNotNull(id);
		Assert.isLegal(id.trim().length() > 0);
		_id = id.trim();
	}

	public PlatformExtensionPoint(IPlatformBundle bundle, String id, String uniqueIdentifier, int handleId) {
		super(bundle, uniqueIdentifier, handleId);
		Assert.isNotNull(id);
		Assert.isLegal(id.trim().length() > 0);
		_id = id.trim();
	}

	public String getId() {
		return _id;
	}

	public String getUniqueIdentifier() {
		return _uniqueIdentifier;
	}

	public int getHandleId() {
		return _handleId;
	}

	public IPlatformBundle getPlatformBundle() {
		return _platformBundle;
	}

	public int compareTo(IPlatformExtensionPoint platformExtensionPoint) {
		return getId().compareTo(platformExtensionPoint.getId());
	}

	@Override
	public int hashCode() {
		return (_platformBundle.getBundleId() + URI.decode(getId())).hashCode();
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (this == object) {
			return true;
		}
		if (!(object instanceof IPlatformExtensionPoint)) {
			return false;
		}
		IPlatformExtensionPoint platformExtensionPoint = (IPlatformExtensionPoint) object;
		if (!platformExtensionPoint.getPlatformBundle().equals(getPlatformBundle())) {
			return false;
		}
		if (getId().compareTo(platformExtensionPoint.getId()) != 0) {
			return false;
		}
		if (getUniqueIdentifier() != null && platformExtensionPoint.getUniqueIdentifier() != null) {
			if (getUniqueIdentifier().compareTo(platformExtensionPoint.getUniqueIdentifier()) != 0) {
				return false;
			}
			return getHandleId() == platformExtensionPoint.getHandleId();
		}
		return true;
	}

	@Override
	public String toString() {
		return getId();
	}

}
