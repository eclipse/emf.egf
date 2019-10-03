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
package org.eclipse.egf.model.editor.provider;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcorePropertySource extends PropertySource {

  /**
   * An instance is constructed from an object and its item property source.
   */
  public FcorePropertySource(Object object, IItemPropertySource itemPropertySource) {
    super(object, itemPropertySource);
  }

  @Override
  protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
    return new FcorePropertyDescriptor(object, itemPropertyDescriptor);
  }

}
