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
package org.eclipse.egf.core.ui.internal.viewers;

import org.eclipse.egf.common.ui.viewers.AbstractTooltipLabelProvider;
import org.eclipse.egf.core.data.helper.DataHelper;
import org.eclipse.egf.model.NamedModelElementWithId;
import org.eclipse.jface.viewers.ILabelProvider;


/**
 * Provides a custom tool tip label provider to use in TreeViewer.<br>
 * It handles {@link NamedModelElementWithId} objects.<br>
 * The tool tip content is the description feature for given {@link NamedModelElementWithId#getDescription()}.
 * @author Guillaume Brocard
 */
public class CustomTooltipLabelProvider extends AbstractTooltipLabelProvider {
  /**
   * Constructor.
   * @param labelProvider_p label provider that provides the text and the image for given element.
   */
  public CustomTooltipLabelProvider(ILabelProvider labelProvider_p) {
    super(labelProvider_p);
  }

  /**
   * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipText(java.lang.Object)
   */
  @Override
  public String getToolTipText(Object element_p) {
    String result = null;
    if (element_p instanceof NamedModelElementWithId) {
      result = DataHelper.getDescription((NamedModelElementWithId) element_p);
    }
    return (null == result) ? Messages.CustomTooltipLabelProvider_No_Tooltip_Title : result;
  }
}
