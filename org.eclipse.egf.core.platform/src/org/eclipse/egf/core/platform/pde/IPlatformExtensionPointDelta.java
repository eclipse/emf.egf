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
package org.eclipse.egf.core.platform.pde;

public interface IPlatformExtensionPointDelta {

  public IPlatformExtensionPoint[] getAddedPlatformExtensionPoints();

  public IPlatformExtensionPoint[] getRemovedPlatformExtensionPoints();

  public <T extends IPlatformExtensionPoint> T[] getAddedPlatformExtensionPoints(Class<T> clazz);

  public <T extends IPlatformExtensionPoint> T[] getRemovedPlatformExtensionPoints(Class<T> clazz);

}
