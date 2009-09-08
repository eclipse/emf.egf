/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.viewers;

import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.model.edit.IImageKeys;
import org.eclipse.egf.model.provider.FactoryComponentEditPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


/**
 * A label provider that provides with pattern or pattern library handling.
 * @author Guillaume Brocard
 */
public class DefaultPatternStructureLabelProvider extends LabelProvider {
  /**
   * Is given descriptor a pattern one ?
   * @param descriptor_p
   * @return
   */
  protected boolean isPattern(IDescriptor descriptor_p) {
    Object type = descriptor_p.getValue(IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE);
    return IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_PATTERN.equals(type);
  }

  /**
   * Is given descriptor a library one ?
   * @param descriptor_p
   * @return
   */
  protected boolean isLibrary(IDescriptor descriptor_p) {
    Object type = descriptor_p.getValue(IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE);
    return IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_LIBRARY.equals(type);
  }

  /**
   * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
   */
  @Override
  public String getText(Object element_p) {
    IDescriptor descriptor = (IDescriptor) element_p;
    StringBuilder result = new StringBuilder();
    return result.append((String) descriptor.getValue(ExtensionPointHelper.ATT_NAME)).toString();
  }

  /**
   * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
   */
  @Override
  public Image getImage(Object element_p) {
    Image result = null;
    IDescriptor descriptor = (IDescriptor) element_p;
    if (isLibrary(descriptor)) {
      result = ExtendedImageRegistry.INSTANCE.getImage(FactoryComponentEditPlugin.INSTANCE.getImage(IImageKeys.IMG_PATTERN_LIBRARY_ID));
    } else if (isPattern(descriptor)) {
      result = ExtendedImageRegistry.INSTANCE.getImage(FactoryComponentEditPlugin.INSTANCE.getImage(IImageKeys.IMG_PATTERN_MODEL_ID));
    }
    return result;
  }
}
