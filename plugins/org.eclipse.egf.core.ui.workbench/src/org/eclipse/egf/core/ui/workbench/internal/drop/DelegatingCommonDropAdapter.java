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
package org.eclipse.egf.core.ui.workbench.internal.drop;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Item;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.INavigatorContentService;
import org.eclipse.ui.part.PluginDropAdapter;

/**
 * <p>
 * This class is a clone of the one provided by org.eclipse.ui.navigator plug-in but due to restrictions on DND, we have to re-implement it to workaround bug
 * #150688.<br>
 * This class exists to override CommonDropAdapter#determineLocation(org.eclipse.swt.dnd.DropTargetEvent) method. Hence, this method is getting to behave
 * normally again regarding DND feedbacks.<br>
 * Since {@link CommonDropAdapter} is a final class, this one delegates to it to get CommonDropAdapter services.
 */
public class DelegatingCommonDropAdapter extends PluginDropAdapter {
  private CommonDropAdapter _commonDropAdapter;

  /**
   * Create a DropAdapter that handles a drop based on the given content service and selection provider.
   * @param contentService_p The content service this Drop Adapter is associated with
   * @param structuredViewer_p The viewer this DropAdapter is associated with.
   */
  public DelegatingCommonDropAdapter(INavigatorContentService contentService_p, StructuredViewer structuredViewer_p) {
    super(structuredViewer_p);
    _commonDropAdapter = new CommonDropAdapter(contentService_p, structuredViewer_p);
  }

  /**
   * {@link CommonDropAdapter#drop(DropTargetEvent)}
   */
  @Override
  public void drop(DropTargetEvent event_p) {
    int location = determineLocation(event_p);
    switch (location) {
      case LOCATION_BEFORE:
        event_p.feedback = DND.FEEDBACK_INSERT_BEFORE;
      break;
      case LOCATION_AFTER:
        event_p.feedback = DND.FEEDBACK_INSERT_AFTER;
    }
    _commonDropAdapter.drop(event_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ViewerDropAdapter#getFeedbackEnabled()
   */
  @Override
  public boolean getFeedbackEnabled() {
    return _commonDropAdapter.getFeedbackEnabled();
  }

  /**
   * @see org.eclipse.ui.part.PluginDropAdapter#performDrop(java.lang.Object)
   */
  @Override
  public boolean performDrop(Object data_p) {
    return _commonDropAdapter.performDrop(data_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ViewerDropAdapter#setFeedbackEnabled(boolean)
   */
  @Override
  public void setFeedbackEnabled(boolean value_p) {
    _commonDropAdapter.setFeedbackEnabled(value_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ViewerDropAdapter#setScrollExpandEnabled(boolean)
   */
  @Override
  public void setScrollExpandEnabled(boolean value_p) {
    super.setScrollExpandEnabled(value_p);
    _commonDropAdapter.setScrollExpandEnabled(value_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ViewerDropAdapter#setSelectionFeedbackEnabled(boolean)
   */
  @Override
  public void setSelectionFeedbackEnabled(boolean value_p) {
    _commonDropAdapter.setSelectionFeedbackEnabled(value_p);
  }

  /**
   * {@link CommonDropAdapter#getSupportedDropTransfers()}
   * @return
   */
  public Transfer[] getSupportedDropTransfers() {
    return _commonDropAdapter.getSupportedDropTransfers();
  }

  /**
   * {@link CommonDropAdapter#dragEnter(DropTargetEvent)}
   */
  @Override
  public void dragEnter(DropTargetEvent event_p) {
    _commonDropAdapter.dragEnter(event_p);
  }

  /**
   * {@link CommonDropAdapter#dragLeave(DropTargetEvent)}
   */
  @Override
  public void dragLeave(DropTargetEvent event_p) {
    _commonDropAdapter.dragLeave(event_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ViewerDropAdapter#dragOperationChanged(org.eclipse.swt.dnd.DropTargetEvent)
   */
  @Override
  public void dragOperationChanged(DropTargetEvent event_p) {
    _commonDropAdapter.dragOperationChanged(event_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ViewerDropAdapter#dragOver(org.eclipse.swt.dnd.DropTargetEvent)
   */
  @Override
  public void dragOver(DropTargetEvent event_p) {
    // Force to have auto scroll & expand disabled.
    setScrollExpandEnabled(false);
    // Call CommonDropAdapter to make sure DND works for patterns or libraries.
    _commonDropAdapter.dragOver(event_p);
    // Call super method to workaround the feedback issue coming from CommonDropAdapter for factory component invocation order.
    super.dragOver(event_p);
  }

  /**
   * @see org.eclipse.jface.viewers.ViewerDropAdapter#dropAccept(org.eclipse.swt.dnd.DropTargetEvent)
   */
  @Override
  public void dropAccept(DropTargetEvent event_p) {
    _commonDropAdapter.dropAccept(event_p);
  }

  /**
   * {@link CommonDropAdapter#validateDrop(Object, int, TransferData)}
   */
  @Override
  public boolean validateDrop(Object dropTarget_p, int dropOperation_p, TransferData transferData_p) {
    return _commonDropAdapter.validateDrop(dropTarget_p, dropOperation_p, transferData_p);
  }

  /**
   * 
   */
  @Override
  public Rectangle getBounds(Item item) {
    return _commonDropAdapter.getBounds(item);
  }

  /**
   * @see org.eclipse.jface.viewers.ViewerDropAdapter#getCurrentLocation()
   */
  @Override
  public int getCurrentLocation() {
    return _commonDropAdapter.getCurrentLocation();
  }

  /**
   * @see org.eclipse.jface.viewers.ViewerDropAdapter#getCurrentOperation()
   */
  @Override
  public int getCurrentOperation() {
    return _commonDropAdapter.getCurrentOperation();
  }

  /**
   * /**
   * @see org.eclipse.ui.part.PluginDropAdapter#getCurrentTransfer()
   */
  @Override
  public TransferData getCurrentTransfer() {
    return _commonDropAdapter.getCurrentTransfer();
  }
}
