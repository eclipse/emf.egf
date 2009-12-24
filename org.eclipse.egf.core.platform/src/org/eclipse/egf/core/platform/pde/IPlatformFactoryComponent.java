/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 * 
 */
package org.eclipse.egf.core.platform.pde;

import org.eclipse.emf.common.util.URI;
import org.eclipse.pde.core.plugin.IPluginElement;

public interface IPlatformFactoryComponent extends Comparable<IPlatformFactoryComponent> {

  public URI getURI();

  public URI getPreviousURI();

  public String getId();

  public IPluginElement getPluginElement();

  public IPlatformPlugin getPlatformPlugin();

  public String getName();

}
