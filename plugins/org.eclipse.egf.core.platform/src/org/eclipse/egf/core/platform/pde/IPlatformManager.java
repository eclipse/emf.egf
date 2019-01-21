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

import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IPlatformManager {

	//	public IPlatformBundle[] getPlatformBundles();

	public IPlatformBundle getPlatformBundle(String id);

	public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz);

	public <T extends IPlatformExtensionPoint> T[] getRuntimePlatformExtensionPoints(Class<T> clazz);

	public <T extends IPlatformExtensionPoint> T[] getWorkspacePlatformExtensionPoints(Class<T> clazz);

	public <T extends IPlatformExtensionPoint> T[] getRuntimePlatformExtensionPoints(String id, Class<T> clazz);

	public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(String id, Class<T> clazz);

	public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(IPluginModelBase model, Class<T> class1);

	public void addPlatformExtensionPointListener(IPlatformExtensionPointListener listener);

	public void removePlatformExtensionPointListener(IPlatformExtensionPointListener listener);

	public void dispose();
}
