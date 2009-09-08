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
 */
public class DefaultPatternModificationNotification implements IPatternModificationNotification {
  /**
   * Event type.
   */
  private int _eventType;
  /**
   * The new value.
   */
  private Object _newValue;
  /**
   * The notifier.
   */
  private Object _notifier;
  /**
   * The old value.
   */
  private Object _oldValue;
  /**
   * Pattern data scope.
   */
  private PatternData _patternData;

  /**
   * Set the type of change that has occurred.<br>
   * The valid types of events are defined by the constants in this class.
   * @param type_p the type of change that has occurred.
   */
  public void setEventType(int type_p) {
    _eventType = type_p;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification#getEventType()
   */
  public int getEventType() {
    return _eventType;
  }

  /**
   * Set the new value implied by the change.<br>
   * The type of the value depends on the notifier and the event types.
   * @param newValue_p The new value.
   */
  public void setNewValue(Object newValue_p) {
    _newValue = newValue_p;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification#getNewValue()
   */
  public Object getNewValue() {
    return _newValue;
  }

  /**
   * Set the object affected by the change.<br>
   * There might be none, in case of shared values modification for instance.
   * @param notifier_p null to reset.
   */
  public void setNotifier(Object notifier_p) {
    _notifier = notifier_p;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification#getNotifier()
   */
  public Object getNotifier() {
    return _notifier;
  }

  /**
   * Set the value before the change occurred.<br>
   * The type of the value depends on the notifier and the event types.
   * @param oldValue_p The value before the change occurred.
   */
  public void setOldValue(Object oldValue_p) {
    _oldValue = oldValue_p;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification#getOldValue()
   */
  public Object getOldValue() {
    return _oldValue;
  }

  /**
   * Set pattern data scope for this event.
   * @param patternData_p
   */
  public void setPatternData(PatternData patternData_p) {
    _patternData = patternData_p;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification#getPatternData()
   */
  public PatternData getPatternData() {
    return _patternData;
  }

  /**
   * Create a new notification.
   * @param eventType_p
   * @param notifier_p
   * @param oldValue_p
   * @param newValue_p
   * @return
   */
  public static DefaultPatternModificationNotification createNotification(int eventType_p, Object notifier_p, Object oldValue_p, Object newValue_p) {
    DefaultPatternModificationNotification result = new DefaultPatternModificationNotification();
    result.setEventType(eventType_p);
    result.setNotifier(notifier_p);
    result.setOldValue(oldValue_p);
    result.setNewValue(newValue_p);
    return result;
  }
}
