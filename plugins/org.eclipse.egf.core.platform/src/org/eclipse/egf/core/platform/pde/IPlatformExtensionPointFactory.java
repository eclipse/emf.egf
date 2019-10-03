/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.core.platform.pde;

/**
 * @author Xavier Maysonnave
 * 
 */
public interface IPlatformExtensionPointFactory<T extends IPlatformExtensionPoint> {

    public T createExtensionPoint(IPlatformBundle platformBundle, Object object);

}
