/**
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 */
package org.eclipse.egf.model.pattern.provider;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.egf.model.pattern.Pattern} object.
 */
public class PatternCustomItemProvider extends PatternItemProvider {

  /**
   * This constructs an instance from a factory and a notifier.
   */
  public PatternCustomItemProvider(AdapterFactory adapterFactory) {
    super(adapterFactory);
  }

  /**
   * This returns the label text for the adapted class.
   */
  @Override
  public String getText(Object object) {
    Pattern pattern = (Pattern) object;
    EObject root = EcoreUtil.getRootContainer(pattern, true);
    String activity = null;
    if (root != null) {
      IItemLabelProvider provider = (IItemLabelProvider) (((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory()).adapt(root, IItemLabelProvider.class);
      if (provider == null) {
        activity = EMFHelper.getText(root);
      } else {
        activity = provider.getText(root);
      }
    }
    String name = pattern.getName();
    String label = "[" + getString("_UI_Pattern_type") + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    if (name != null && name.trim().length() != 0) {
      label = name + " " + label; //$NON-NLS-1$
    }
    if (activity != null && activity.trim().length() != 0) {
      label = activity + " -> " + label; //$NON-NLS-1$
    }
    return label;
  }

}
