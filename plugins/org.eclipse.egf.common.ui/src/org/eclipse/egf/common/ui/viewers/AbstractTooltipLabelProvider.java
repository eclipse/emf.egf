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
package org.eclipse.egf.common.ui.viewers;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

/**
 * Base class to implement label providers with tooltip support to use in JFace viewers.
 * @author Guillaume Brocard
 */
public abstract class AbstractTooltipLabelProvider extends CellLabelProvider implements ILabelProvider {
  /**
   * The time in milliseconds the tool tip is shown for.
   */
  protected static final int TOOLTIP_TIME_DISPLAYED = 7000;
  /**
   * The time in milliseconds until the tool tip is displayed.
   */
  protected static final int DISPLAY_DELAY_TIME = 2000;
  /**
   * Time in milliseconds the tool tip is shown for.
   */
  private int _tooltipTimeDisplayed;
  /**
   * Rime in milliseconds until the tool tip is displayed.
   */
  private int _tooltipDisplayDelayTime;
  /**
   * Label provider used to get text and image for given object.
   */
  private ILabelProvider _labelProvider;

  /**
   * Constructor.
   * @param labelProvider_p label provider that provides the text and the image for given element.
   * @param tooltipTimeDisplayed_p time in milliseconds the tool tip is shown for.
   * @param tooltipDisplayDelayTime_p time in milliseconds until the tool tip is displayed.
   */
  protected AbstractTooltipLabelProvider(ILabelProvider labelProvider_p, int tooltipTimeDisplayed_p, int tooltipDisplayDelayTime_p) {
    _labelProvider = labelProvider_p;
    _tooltipTimeDisplayed = tooltipTimeDisplayed_p;
    _tooltipDisplayDelayTime = tooltipDisplayDelayTime_p;
  }

  /**
   * Constructor.
   * @param labelProvider_p label provider that provides the text and the image for given element.
   * @param tooltipTimeDisplayed_p time in milliseconds the tool tip is shown for.
   * @param tooltipDisplayDelayTime_p time in milliseconds until the tool tip is displayed.
   */
  protected AbstractTooltipLabelProvider(ILabelProvider labelProvider_p) {
    this(labelProvider_p, TOOLTIP_TIME_DISPLAYED, DISPLAY_DELAY_TIME);
  }

  /**
   * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipText(java.lang.Object)
   */
  @Override
  public abstract String getToolTipText(Object element_p);

  /**
   * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipShift(java.lang.Object)
   */
  @Override
  public Point getToolTipShift(Object object_p) {
    return new Point(5, 5);
  }

  /**
   * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipDisplayDelayTime(java.lang.Object)
   */
  @Override
  public int getToolTipDisplayDelayTime(Object object_p) {
    return _tooltipDisplayDelayTime;
  }

  /**
   * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipTimeDisplayed(java.lang.Object)
   */
  @Override
  public int getToolTipTimeDisplayed(Object object_p) {
    return _tooltipTimeDisplayed;
  }

  /**
   * @see org.eclipse.jface.viewers.CellLabelProvider#update(org.eclipse.jface.viewers.ViewerCell)
   */
  @Override
  public void update(ViewerCell viewer_p) {
    Object element = viewer_p.getElement();
    viewer_p.setText(getText(element));
    viewer_p.setImage(getImage(element));
  }

  /**
   * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
   */
  public Image getImage(Object element_p) {
    return _labelProvider.getImage(element_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
   */
  public String getText(Object element_p) {
    return _labelProvider.getText(element_p);
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
   */
  @Override
  public void addListener(ILabelProviderListener listener_p) {
    super.addListener(listener_p);
    _labelProvider.addListener(listener_p);
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
   */
  @Override
  public void dispose() {
    super.dispose();
    _labelProvider.dispose();
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
   */
  @Override
  public boolean isLabelProperty(Object element_p, String property_p) {
    return super.isLabelProperty(element_p, property_p) && _labelProvider.isLabelProperty(element_p, property_p);
  }

  /**
   * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
   */
  @Override
  public void removeListener(ILabelProviderListener listener_p) {
    super.removeListener(listener_p);
    _labelProvider.removeListener(listener_p);
  }
}
