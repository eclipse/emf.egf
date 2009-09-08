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
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.common.ui.viewers.AbstractTooltipLabelProvider;


/**
 * A label provider that provides with pattern or pattern library handling.<br>
 * Also supports tooltips that display containing FC name, and origin (workspace or platform).
 * @author Guillaume Brocard
 */
public class PatternStructureLabelProviderWithTooltip extends AbstractTooltipLabelProvider {
  /**
   * Constructor.
   * @param labelProvider_p
   */
  public PatternStructureLabelProviderWithTooltip() {
    super(new DefaultPatternStructureLabelProvider());
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.AbstractTooltipLabelProvider#getToolTipText(java.lang.Object)
   */
  @Override
  public String getToolTipText(Object element_p) {
    IDescriptor descriptor = (IDescriptor) element_p;
    String containingFcName = (String) descriptor.getValue(IPatternConstants.PATTERN_EXTENSION_CONTAINING_FC_NAME);
    Boolean fromWorkspace = (Boolean) descriptor.getValue(IPatternConstants.PATTERN_EXTENSION_FROM_WORKSPACE);
    return StringHelper.formatMessage(Messages.PatternStructureLabelProviderWithTooltip_Tooltip_Message, new Object[] { containingFcName, fromWorkspace.booleanValue() ? Messages.PatternStructureLabelProviderWithTooltip_Tooltip_LocationName_Workspace : Messages.PatternStructureLabelProviderWithTooltip_Tooltip_LocationName_Platform});
  }
}