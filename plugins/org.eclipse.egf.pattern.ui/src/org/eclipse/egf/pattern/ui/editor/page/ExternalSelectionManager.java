/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.ui.editor.page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * A default implementation of an external selection manager.<br>
 * Handlers are registered to the type of the first selected object.<br>
 * It is assumed that every other object in the selection is of the same type.<br>
 * Thus handlers registering to this manager are most likely to deal with the first selected object only (although that is not mandatory).
 * @author Guillaume Brocard
 */
public class ExternalSelectionManager implements IExternalSelectionProvider {
  
  /**
   * The map of external selection handlers.<br>
   * Handlers are registered for a type of selected object.
   */
  @SuppressWarnings("unchecked")
  private Map<Class, Collection<IExternalSelectionHandler>> _externalSelectionHandlers;

  /**
   * Dispose.
   */
  public void dispose() {
    if (null != _externalSelectionHandlers) {
      _externalSelectionHandlers.clear();
    }
    _externalSelectionHandlers = null;
  }

  /**
   * Add a new handler for given type.<br>
   * Several different handlers can be added for the same type.
   * @param selectedObjectType_p The selected object type, must be not null.
   * @param handler_p The new handler, must be not null.
   */
  @SuppressWarnings("unchecked")
  public void addExternalHandlerFor(Class selectedObjectType_p, IExternalSelectionHandler handler_p) {
    // Preconditions.
    if ((null == selectedObjectType_p) || (null == handler_p)) {
      return;
    }
    // Lazy creation.
    if (null == _externalSelectionHandlers) {
      _externalSelectionHandlers = new HashMap<Class, Collection<IExternalSelectionHandler>>(1);
    }
    // Get collection of handlers for given type.
    Collection<IExternalSelectionHandler> handlers = _externalSelectionHandlers.get(selectedObjectType_p);
    // Lazy creation.
    if (null == handlers) {
      // Do not allow twice the same subscription.
      handlers = new HashSet<IExternalSelectionHandler>(1);
      _externalSelectionHandlers.put(selectedObjectType_p, handlers);
    }
    // Do add the handler.
    handlers.add(handler_p);
  }

  /**
   * Remove all handlers for given type.
   * @param type_p The type of the selected object.
   */
  @SuppressWarnings("unchecked")
  public void removeHandlersForType(Class type_p) {
    // Preconditions.
    if ((null == type_p) || (null == _externalSelectionHandlers)) {
      return;
    }
    // Remove all handlers for given type.
    _externalSelectionHandlers.remove(type_p);
    // Then clean map if it is no longer needed.
    if (_externalSelectionHandlers.isEmpty()) {
      _externalSelectionHandlers = null;
    }
  }

  /**
   * Remove given handler from all possible registrations.<br>
   * That is remove the handler, whatever the types it may be registered for.
   * @param handler_p The handler to remove, must be not null.
   */
  @SuppressWarnings("unchecked")
  public void removeExternalHandler(IExternalSelectionHandler handler_p) {
    // Preconditions.
    if ((null == handler_p) || (null == _externalSelectionHandlers)) {
      return;
    }
    List<Class> typesToRemove = new ArrayList<Class>(0);
    // Cycle through collections of handlers.
    for (Entry<Class, Collection<IExternalSelectionHandler>> entrySet : _externalSelectionHandlers.entrySet()) {
      // Remove the handler.
      Collection<IExternalSelectionHandler> handlersCollection = entrySet.getValue();
      handlersCollection.remove(handler_p);
      // Remove handlers collection, if it is then empty.
      if (handlersCollection.isEmpty()) {
        typesToRemove.add(entrySet.getKey());
      }
    }
    // Remove useless managed types.
    for (Class type : typesToRemove) {
      removeHandlersForType(type);
    }
  }

  /**
   * Remove given handler for given type.
   * @param handler_p The handler to remove, must be not null.
   * @param type_p The type the handler is to be removed for. If null, the handler is removed for all types. This is strictly equivalent to calling
   *          {@link #removeExternalHandler(IExternalSelectionHandler)} then.
   */
  @SuppressWarnings("unchecked")
  public void removeExternalHandler(IExternalSelectionHandler handler_p, Class type_p) {
    // Preconditions.
    if ((null == handler_p) || (null == _externalSelectionHandlers)) {
      return;
    }
    // If type is provided, remove for this type only.
    if (null != type_p) {
      Collection<IExternalSelectionHandler> handlers = _externalSelectionHandlers.get(type_p);
      // If there is at least one handler for this type (by construction), try and remove given one.
      if (null != handlers) {
        handlers.remove(handler_p);
        // If there is no longer any handler for this type, remove the empty collection from the map.
        if (handlers.isEmpty()) {
          removeHandlersForType(type_p);
        }
      }
    } else {
      // Remove for all types.
      removeExternalHandler(handler_p);
    }
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.IExternalSelectionProvider#fireExternalSelection(java.lang.Object,
   *      org.eclipse.jface.viewers.IStructuredSelection)
   */
  @SuppressWarnings("unchecked")
  public void fireExternalSelection(Object firstSelectedObject_p, IStructuredSelection selection_p) {
    // Precondition.
    if ((null == _externalSelectionHandlers) || (null == firstSelectedObject_p)) {
      return;
    }
    // Cycle through collections of handlers.
    for (Entry<Class, Collection<IExternalSelectionHandler>> entrySet : _externalSelectionHandlers.entrySet()) {
      Class type = entrySet.getKey();
      // If selected object is such an instance, go for associated handlers.
      if (type.isInstance(firstSelectedObject_p)) {
        // Get handlers.
        Collection<IExternalSelectionHandler> handlers = entrySet.getValue();
        // Launch selection for all handlers.
        for (IExternalSelectionHandler externalSelectionHandler : handlers) {
          externalSelectionHandler.handleSelection(firstSelectedObject_p, selection_p);
        }
      }
    }
  }
  
}