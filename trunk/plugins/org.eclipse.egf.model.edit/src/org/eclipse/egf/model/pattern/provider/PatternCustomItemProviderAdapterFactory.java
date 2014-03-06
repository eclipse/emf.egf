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
package org.eclipse.egf.model.pattern.provider;

import org.eclipse.emf.common.notify.Adapter;

/**
 * @author Xavier Maysonnave
 * 
 */
public class PatternCustomItemProviderAdapterFactory extends PatternItemProviderAdapterFactory {

  /**
   * This constructs an instance.
   */
  public PatternCustomItemProviderAdapterFactory() {
    super();
  }

  /**
   * This creates an adapter for a {@link org.eclipse.egf.model.pattern.Pattern}.
   */
  @Override
  public Adapter createPatternAdapter() {
    if (patternItemProvider == null) {
      patternItemProvider = new PatternCustomItemProvider(this);
    }
    return patternItemProvider;
  }

}
