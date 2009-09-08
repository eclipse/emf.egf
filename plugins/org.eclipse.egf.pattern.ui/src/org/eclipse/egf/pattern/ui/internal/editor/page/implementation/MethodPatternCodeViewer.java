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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.ui.helper.FormHelper;
import org.eclipse.egf.common.ui.helper.FormHelper.LayoutType;
import org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler;
import org.eclipse.egf.common.ui.viewers.IContentHandler;
import org.eclipse.egf.common.ui.viewers.IOrderedContentProvider;
import org.eclipse.egf.common.ui.viewers.OrderedListViewerWithAddAndRemove;
import org.eclipse.egf.pattern.ecore.AnnotationHandler;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage;
import org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationListener;
import org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider;
import org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.PatternCodeActionWizard;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * Method pattern code viewer.<br>
 * Suitable for modifying the pattern code of a pattern method, whether this method is public (generate) or an internal one (any other one).
 * @author Guillaume Brocard
 */
public class MethodPatternCodeViewer extends OrderedListViewerWithAddAndRemove implements DisposeListener {
  /**
   * Containing page.
   */
  protected AbstractPatternPage _page;
  /**
   * Content handler.
   */
  protected MethodPatternCodeContentHandler _contentHandler;
  /**
   * Content provider.
   */
  private MethodPatternCodeContentProvider _contentProvider;
  /**
   * Label provider.
   */
  private MethodPatternCodeLabelProvider _labelProvider;
  /**
   * Available actions are pattern code ones that can be created.
   */
  private List<String> _availableActions;
  /**
   * Should next and back buttons be allowed while creating a new action ?
   */
  private boolean _allowNextAndBack;
  /**
   * Should method pattern code annotation be recomputed every time a change happens ?
   */
  private boolean _recomputeOnChanges;

  /**
   * Constructor.
   * @param page_p
   * @param parent_p
   */
  public MethodPatternCodeViewer(AbstractPatternPage patternPage_p, Composite parent_p) {
    super(parent_p);
    _page = patternPage_p;
    _labelProvider.setPatternData(_page.getPatternData());
    _contentHandler.setPatternPage(_page);
  }

  /**
   * Get containing page, if any.
   * @return Containing page, or null if none.
   */
  protected AbstractPatternPage getPage() {
    return _page;
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.AbstractViewerWithButtons#createViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected StructuredViewer createViewer(Composite composite_p) {
    FormToolkit toolkit = new FormToolkit(composite_p.getDisplay());
    // Create list viewer.
    Composite listComposite = FormHelper.createCompositeWithLayoutType(toolkit, composite_p, LayoutType.GRID_LAYOUT, 1, false);
    ListViewer viewer = new ListViewer(listComposite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
    Control listControl = viewer.getControl();
    listControl.addDisposeListener(this);
    FormHelper.updateControlLayoutDataWithLayoutTypeData(listControl, LayoutType.GRID_LAYOUT);
    _contentHandler = new MethodPatternCodeContentHandler();
    _contentProvider = new MethodPatternCodeContentProvider();
    viewer.setContentProvider(_contentProvider);
    _labelProvider = new MethodPatternCodeLabelProvider();
    viewer.setLabelProvider(_labelProvider);
    toolkit.adapt(listComposite);
    return viewer;
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.OrderedListViewerWithAddAndRemove#createRemoveButtonHandler()
   */
  @Override
  protected SelectionChangedHandler createRemoveButtonHandler() {
    SelectionChangedHandler result = new SelectionChangedHandler() {
      @Override
      protected boolean doHandleSelection(ISelection selection_p) {
        boolean enabled = (selection_p instanceof IStructuredSelection);
        // Precondition.
        if (!enabled) {
          return enabled;
        }
        // Action read template can't be removed !
        Object selectedElement = ((IStructuredSelection) selection_p).getFirstElement();
        enabled = (null != selectedElement);
        if (enabled) {
          String actionType = ((MethodActionHandler) selectedElement).getAction().getKey();
          enabled = !PatternConstants.PC_TAG_READ.equals(actionType);
        }
        return enabled;
      }
    };
    return result;
  }

  /**
   * Initialize viewer.
   * @param availableActions_p list of actions that can be created (and thus are available) by the user.
   * @param allowNextAndBack_p should user be able to modify both the action type and its parameter ? true if so, false otherwise. In this case, the user is
   *          only capable of choosing the action type.
   * @param recomputeOnChanges_p should method pattern code annotations be recomputed each time a change occurs ? true if so, false if it is saved later using
   *          the {@link #savePatternCode()} method.
   */
  public void initialize(List<String> availableActions_p, boolean allowNextAndBack_p, boolean recomputeOnChanges_p) {
    _availableActions = availableActions_p;
    _allowNextAndBack = allowNextAndBack_p;
    _recomputeOnChanges = recomputeOnChanges_p;
    if ((null != _page) && (null != _contentProvider)) {
      _page.getEditor().addPatternModificationListener(_contentProvider);
    }
  }

  /**
   * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
   */
  public void widgetDisposed(DisposeEvent e_p) {
    if ((null != _page) && (null != _contentProvider)) {
      _page.getEditor().removePatternModificationListener(_contentProvider);
    }
  }

  /**
   * Set viewer input to given not null one.
   * @param input_p
   */
  public void setInput(EOperation method_p) {
    StructuredViewer viewer = getDecoratedViewer();
    if (null != viewer) {
      _contentHandler.setMethod(method_p);
      viewer.setInput(method_p);
    }
  }

  /**
   * Set selection for this viewer.
   * @param empty_p
   */
  public void setSelection(ISelection selection_p) {
    StructuredViewer viewer = getDecoratedViewer();
    if (null != viewer) {
      viewer.setSelection(selection_p);
    }
  }

  /**
   * Save pattern code for handled method.
   */
  public void savePatternCode() {
    _contentHandler.savePatternCodeAnnotation();
  }

  /**
   * @see org.eclipse.egf.common.ui.viewers.OrderedListViewerWithAddAndRemove#getContentHandler()
   */
  @Override
  protected IContentHandler getContentHandler() {
    return _contentHandler;
  }

  /**
   * Method pattern code content handler.
   * @author Guillaume Brocard
   */
  protected class MethodPatternCodeContentHandler extends DefaultContentHandler {
    /**
     * Handled pattern method.
     */
    private EOperation _method;
    /**
     * Annotation handler.
     */
    private AnnotationHandler _annotationHandler;
    /**
     * Known action handlers.
     */
    private List<MethodActionHandler> _actions;

    /**
     * Constructor.
     */
    protected MethodPatternCodeContentHandler() {
      super(null, null);
      _annotationHandler = new AnnotationHandler();
    }

    /**
     * Is given method handled by this handler ?
     * @param method_p
     * @return
     */
    protected boolean isHandlerFor(EOperation method_p) {
      // Test against handled method.
      boolean result = (null != _method) && _method.equals(method_p);
      // This is handled method, stop here.
      if (result) {
        return result;
      }
      // Else, is there at least one handler pointing to this method ?
      result = !getHandlersFor(method_p).isEmpty();
      return result;
    }

    /**
     * Get handlers using with given method.
     * @param method_p
     * @return
     */
    protected List<MethodActionHandler> getHandlersFor(EOperation method_p) {
      // Preconditions.
      Assert.isNotNull(_actions);
      Assert.isNotNull(method_p);
      // Cycle through existing handlers.
      List<MethodActionHandler> result = new ArrayList<MethodActionHandler>(0);
      for (MethodActionHandler actionHandler : _actions) {
        // Get handlers that are pointed to given method.
        if (method_p == actionHandler.getPointedElement()) {
          result.add(actionHandler);
        }
      }
      return result;
    }

    /**
     * Set method.
     * @param method_p
     */
    protected void setMethod(EOperation method_p) {
      _method = method_p;
      if (null != _actions) {
        _actions.clear();
      }
    }

    /**
     * Get handled method pattern code actions.
     * @return List of actions as defined by {@link MethodActionHandler}.
     */
    protected List<MethodActionHandler> getActions() {
      // Get actions lazily.
      if ((null == _actions) || _actions.isEmpty()) {
        // Get actions as couples.
        List<Couple<String, String>> actionsAsCouples = _annotationHandler.getOrderedActionsFor(_method);
        // Create corresponding list of handlers.
        _actions = new ArrayList<MethodActionHandler>(actionsAsCouples.size());
        for (Couple<String, String> action : actionsAsCouples) {
          // Create a new handler containing both the couple and its model representation.
          MethodActionHandler methodHandler = new MethodActionHandler(getPatternData(), action);
          // Resolve pointed model element, if any.
          resolvePointedElement(methodHandler);
          // Add new handler to resulting collection.
          _actions.add(methodHandler);
        }
      }
      return _actions;
    }

    /**
     * Resolve current method handler pointed model element, if any.<br>
     * Should such model element be resolved, then the given handler is modified accordingly (ie is pointing to the resolved element).<br>
     * If none, the given handler is left unmodified.
     * @param methodHandler_p A not null method handler, that is to contain the action couple at least (should be so, by construction).
     */
    protected void resolvePointedElement(MethodActionHandler methodHandler_p) {
      // Preconditions.
      Assert.isNotNull(methodHandler_p);
      Couple<String, String> action = methodHandler_p.getAction();
      Assert.isNotNull(action);
      // Get action type.
      String actionType = action.getKey();
      // Only point to model element in case of a method call.
      if (PatternConstants.PC_TAG_CALL.equals(actionType)) {
        String methodName = action.getValue();
        // TODO Guillaume.
        // Find all needs for search by name, and replace them with a call to PatternHelper.
        // Get existing operations.
        List<EOperation> existingOperations = getPattern().getEOperations();
        for (EOperation operation : existingOperations) {
          // Found matching model element.
          if (operation.getName().equals(methodName)) {
            methodHandler_p.setPointedElement(operation);
            break;
          }
        }
      }
    }

    /**
     * Extract list of actions as couples from internal representation.
     * @return
     */
    private List<Couple<String, String>> extractActionsAsCouples() {
      // Preconditions.
      Assert.isNotNull(_actions);
      // Extract list of couples from handlers one.
      List<Couple<String, String>> actionsAsCouples = new ArrayList<Couple<String, String>>(_actions.size());
      for (MethodActionHandler actionHandler : _actions) {
        actionsAsCouples.add(actionHandler.getAction());
      }
      return actionsAsCouples;
    }

    /**
     * Save pattern code annotation, according to current actions list state.
     */
    protected void savePatternCodeAnnotation() {
      List<Couple<String, String>> actionsAsCouples = extractActionsAsCouples();
      // Recompute operation content.
      _annotationHandler.recomputeAnnotationFromActions(_method, actionsAsCouples);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler#notifyModification()
     */
    @SuppressWarnings("synthetic-access")
    @Override
    protected void notifyModification() {
      // Recompute before notifying, if needed.
      if (_recomputeOnChanges) {
        savePatternCodeAnnotation();
      }
      // Notify editor.
      super.notifyModification();
    }

    /**
     * Given method has been removed, remove actions that are referencing it.
     * @param parameterName_p
     */
    protected List<MethodActionHandler> removeActionsUsing(EOperation method_p) {
      // Precondition.
      Assert.isNotNull(_actions);
      // Remove actions using given parameter.
      List<MethodActionHandler> removedActions = new ArrayList<MethodActionHandler>(0);
      removedActions.addAll(_actions);
      for (MethodActionHandler actionHandler : _actions) {
        // Remove this action handler from the list of removed ones.
        if (actionHandler.getPointedElement() != method_p) {
          removedActions.remove(actionHandler);
        }
      }
      // Remove elements from known actions.
      _actions.removeAll(removedActions);
      // Notify changes to editor.
      notifyModification();
      return removedActions;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.IContentHandler#createNewElement()
     */
    @SuppressWarnings("synthetic-access")
    @Override
    public Object createNewElement() {
      // Create result.
      MethodActionHandler result = new MethodActionHandler(getPatternData(), new Couple<String, String>(null, null));
      // Open selection wizard.
      WizardDialog wizardDialog =
                                  new WizardDialog(_page.getSite().getShell(), new PatternCodeActionWizard(_page.getPatternData(), result.getAction(),
                                                                                                           _availableActions, _allowNextAndBack));
      int returnCode = wizardDialog.open();
      if (Window.OK == returnCode) {
        // Resolve pointed element.
        resolvePointedElement(result);
        // Add it to the known list of actions.
        _actions.add(result);
        // Notify changes to editor.
        notifyModification();
      } else {
        result = null;
      }
      // Finally, return it.
      return result;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.IContentHandler#removeElement(java.lang.Object)
     */
    @Override
    public void removeElement(Object element_p) {
      // Remove action from known actions.
      _actions.remove(element_p);
      // Notify changes to editor.
      notifyModification();
    }

    /**
     * Swap elements in the actions list.
     * @param firstIndex_p
     * @param secondIndex_p
     */
    protected void swapElements(int firstIndex_p, int secondIndex_p) {
      // Swap elements in the actions list.
      Collections.swap(_actions, firstIndex_p, secondIndex_p);
      // Notify changes to editor.
      notifyModification();
    }
  }

  /**
   * Method pattern code content provider.
   * @author Guillaume Brocard
   */
  protected class MethodPatternCodeContentProvider extends AbstractPatternPageContentProvider implements IOrderedContentProvider, IPatternModificationListener {
    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#getViewer()
     */
    @Override
    protected ListViewer getViewer() {
      return (ListViewer) super.getViewer();
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doDispose()
     */
    @Override
    protected void doDispose() {
      // Nothing to do yet.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementUpdated(java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    protected void doHandleElementUpdated(Object oldInput_p, Object newInput_p) {
      getViewer().update(newInput_p, null);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementsAdded(java.lang.Object)
     */
    @Override
    protected void doHandleElementsAdded(Object addedElements_p) {
      getViewer().add(addedElements_p);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementsRemoved(java.lang.Object)
     */
    @Override
    protected void doHandleElementsRemoved(Object removedElements_p) {
      getViewer().remove(removedElements_p);
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.IOrderedContentProvider#swap(int, int)
     */
    public void swap(int elementPosition1_p, int elementPosition2_p) {
      _contentHandler.swapElements(elementPosition1_p, elementPosition2_p);
      getViewer().refresh();
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement_p) {
      Object[] result = null;
      if (inputElement_p instanceof EOperation) {
        // Get actions from generate method content.
        result = _contentHandler.getActions().toArray();
      }
      return result;
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationListener#notifyChanged(org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification)
     */
    public void notifyChanged(IPatternModificationNotification notification_p) {
      int type = notification_p.getEventType();
      if (IPatternModificationNotification.REMOVED == type) {
        Object oldValue = notification_p.getOldValue();
        if (oldValue instanceof EOperation) {
          methodRemoved((EOperation) oldValue);
        }
      } else if (IPatternModificationNotification.RENAMED == type) {
        Object notifier = notification_p.getNotifier();
        if (notifier instanceof EOperation) {
          EOperation operation = (EOperation) notifier;
          methodNameChanged(operation, (String) notification_p.getOldValue(), (String) notification_p.getNewValue());
        }
      } else if (IPatternModificationNotification.SET == type) {
        Object notifier = notification_p.getNotifier();
        if (notifier instanceof MethodActionHandler) {
          MethodActionHandler handler = (MethodActionHandler) notifier;
          parameterSwitched(handler);
        }
      }
    }

    /**
     * Parameter value of handled action has been modified.
     * @param patternCodeAction_p A not null action handler.
     */
    protected void parameterSwitched(MethodActionHandler patternCodeAction_p) {
      // Precondition.
      Assert.isNotNull(patternCodeAction_p);
      // Action has already been modified by sender, just ensure pointed element is correct.
      _contentHandler.resolvePointedElement(patternCodeAction_p);
      // Refresh the viewer.
      getViewer().refresh(patternCodeAction_p);
    }

    /**
     * Method name changed.
     * @param method_p
     * @param oldMethodName_p
     * @param newMethodName_p
     */
    protected void methodNameChanged(EOperation method_p, String oldMethodName_p, String newMethodName_p) {
      if (_contentHandler.isHandlerFor(method_p)) {
        List<MethodActionHandler> handlers = _contentHandler.getHandlersFor(method_p);
        if (!handlers.isEmpty()) {
          for (MethodActionHandler actionHandler : handlers) {
            // Change known name.
            actionHandler.getAction().setValue(((EOperation) actionHandler.getPointedElement()).getName());
            getViewer().refresh(actionHandler);
          }
        } else {
          // Viewer is directly handling this method, simply refresh the whole thing.
          getViewer().refresh();
        }
      }
    }

    /**
     * Method removed.
     * @param removedMethod_p
     */
    protected void methodRemoved(EOperation removedMethod_p) {
      // Precondition.
      Assert.isNotNull(removedMethod_p);
      // Remove from known actions.
      List<MethodActionHandler> removedActions = _contentHandler.removeActionsUsing(removedMethod_p);
      // Then remove from viewer.
      if ((null != removedActions) && !removedActions.isEmpty()) {
        for (MethodActionHandler actionHandler : removedActions) {
          doHandleElementsRemoved(actionHandler);
        }
      }
    }
  }
}
