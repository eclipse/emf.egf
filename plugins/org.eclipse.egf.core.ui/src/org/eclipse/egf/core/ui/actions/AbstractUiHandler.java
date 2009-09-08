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
package org.eclipse.egf.core.ui.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.runtime.IAdaptable;

/**
 * This class extends the {@link AbstractHandler} implementation class to provide a method to get the selected elements matching an expected type.
 * @author Guillaume Brocard
 */
public abstract class AbstractUiHandler extends AbstractHandler {
  /**
   * Return the selected objects in current selection matching given expected type.
   * @param event_p
   * @param expectedSelectionType_p
   * @return an empty list if no object is found matching expected type.
   */
  protected <T> List<T> getSelection(ExecutionEvent event_p, Class<T> expectedSelectionType_p) {
    List<T> result = new ArrayList<T>(0);
    // Precondition.
    if (null == event_p) {
      return result;
    }
    EvaluationContext applicationContext = (EvaluationContext) event_p.getApplicationContext();
    // Precondition.
    if (null == applicationContext) {
      return result;
    }
    // Get default variable as context.
    Collection<?> defaultVariable = (Collection<?>) applicationContext.getDefaultVariable();
    // Loop over the context variables.
    for (Object currentVariable : defaultVariable) {
      T adapter = getAdapter(currentVariable, expectedSelectionType_p);
      if (null != adapter) {
        result.add(adapter);
      }
    }
    return result;
  }

  /**
   * Get an adapted instance for given object in specified type.
   * @param <T>
   * @param object_p
   * @param expectedSelectionType_p
   * @return <code>null</code> if given object is not the expected type or not adaptable to expected type.
   */
  private <T> T getAdapter(Object object_p, Class<T> expectedSelectionType_p) {
    T result = null;
    // Check given object is instance of expected class.
    if (expectedSelectionType_p.isInstance(object_p)) {
      result = expectedSelectionType_p.cast(object_p);
    }
    // Given object is adaptable, try to get an instance of expected type.
    if ((null == result) && (object_p instanceof IAdaptable)) {
      result = expectedSelectionType_p.cast(((IAdaptable) object_p).getAdapter(expectedSelectionType_p));
    }
    return result;
  }
}
