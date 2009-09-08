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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation;

import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler;


/**
 * A proxy to a pattern method action.
 * @author Guillaume Brocard
 */
public class MethodActionHandler extends DefaultContentHandler {
  /**
   * The element referenced by the action parameter.<br>
   * Either the element by itself or a proxy/identifier of this element.
   */
  private Object _pointedElement;
  /**
   * The action at the time of creation of this handler.<br>
   * Note that it is guaranteed to be different from the one returned from a new call to any annotation handler.
   */
  private Couple<String, String> _action;

  /**
   * Constructor.
   * @param patternData_p
   * @param action_p
   */
  public MethodActionHandler(PatternData patternData_p, Couple<String, String> action_p) {
    super(patternData_p, null);
    _action = action_p;
  }

  /**
   * Get action pointed element.
   * @return Null if none.
   */
  public Object getPointedElement() {
    return _pointedElement;
  }

  /**
   * Set action pointed element.
   * @param pointedElement_p
   */
  public void setPointedElement(Object pointedElement_p) {
    _pointedElement = pointedElement_p;
  }

  /**
   * Get action.
   * @return
   */
  public Couple<String, String> getAction() {
    return _action;
  }
}
