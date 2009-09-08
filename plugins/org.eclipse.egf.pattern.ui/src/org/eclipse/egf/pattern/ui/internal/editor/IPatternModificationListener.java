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

/**
 * Pattern modifications listener.
 * @author Guillaume Brocard
 */
public interface IPatternModificationListener {
  /**
   * Notify that a change to the pattern model has occurred.
   * @param notification_p a description of the change.
   */
  void notifyChanged(IPatternModificationNotification notification_p);
}
