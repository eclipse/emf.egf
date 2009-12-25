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
package org.eclipse.egf.core.internal.context;

import org.eclipse.egf.core.context.IContext;
import org.eclipse.egf.core.context.IContextFactory;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ContextFactory implements IContextFactory {

  public IContext createContext(IContext parent) {
    return new Context(parent);
  }

  public IContext createContext() {
    return new Context();
  }

}
