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
package org.eclipse.egf.pattern.ui.internal.editor;

import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;

/**
 * @author Guillaume Brocard
 *
 */
public interface IPatternModificationNotification {
  /**
   * A new element has been added.
   */
  int ADDED = 1;
  /**
   * An element has been removed.
   */
  int REMOVED = 2;
  /**
   * An element has been renamed.
   */
  int RENAMED = 3;
  /**
   * A value has been set to another one.
   */
  int SET = 4;
  /**
   * The model has been saved.
   */
  int SAVED = 5;

  /**
   * Get the type of change that has occurred.<br>
   * The valid types of events are defined by the constants in this class.
   * @return the type of change that has occurred.
   */
  int getEventType();
  /**
   * Get pattern data scope attached to the event.
   * @return
   */
  PatternData getPatternData();
  /**
   * Get the object affected by the change.<br>
   * There might be none, in case of shared values modification for instance.
   * @return null if no affected object could be provided.
   */
  Object getNotifier();
  /**
   * Get the new value after the change occurred.<br>
   * The type of the value depends on the notifier and the event types.
   * @return
   */
  Object getNewValue();
  /**
   * Get the value before the change occurred.<br>
   * The type of the value depends on the notifier and the event types.
   * @return
   */
  Object getOldValue();
}