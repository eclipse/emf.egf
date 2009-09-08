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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.StringHelper;
import org.eclipse.egf.common.ui.viewers.DefaultTreeNode;
import org.eclipse.egf.common.ui.viewers.ITreeNode;
import org.eclipse.egf.model.edit.IImageKeys;
import org.eclipse.egf.model.provider.FactoryComponentEditPlugin;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.relations.ParameterRelation;
import org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.IParameterHandler;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.InternalMethodHandler;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.InternalMethodHelper;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.InternalMethodHelper.IInternalMethodHandlerFactory;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;


/**
 * Pattern editor content outline page.
 * @author Guillaume Brocard
 */
public class PatternEditorContentOutlinePage extends ContentOutlinePage implements IDoubleClickListener, IPatternModificationListener {
  /**
   * In-use pattern data.
   */
  private PatternData _patternData;
  /**
   * Is pattern editable ?
   */
  private boolean _isEditable;

  /**
   * Constructor.
   * @param patternData_p
   * @param patternIsEditable_p
   */
  public PatternEditorContentOutlinePage(PatternData patternData_p, boolean patternIsEditable_p) {
    _patternData = patternData_p;
    _isEditable = patternIsEditable_p;
  }

  /**
   * @see org.eclipse.ui.views.contentoutline.ContentOutlinePage#createControl(org.eclipse.swt.widgets.Composite)
   */
  @Override
  public void createControl(Composite parent_p) {
    // Create and get viewer.
    super.createControl(parent_p);
    TreeViewer viewer = getTreeViewer();
    // Then set its content provider.
    viewer.setContentProvider(new OutlineContentProvider());
    // Its label provider.
    viewer.setLabelProvider(new OutlineLabelProvider());
    // Make it a double click listener.
    viewer.addDoubleClickListener(this);
    // Set sorter.
    viewer.setSorter(new OutlineViewerSorter());
    // Finally, set initial input to pattern data.
    viewer.setInput(new RootNode());
  }

  /**
   * @see org.eclipse.ui.part.Page#dispose()
   */
  @Override
  public void dispose() {
    super.dispose();
    // Remove selection provider.
    getSite().setSelectionProvider(null);
  }

  /**
   * @see org.eclipse.jface.viewers.IDoubleClickListener#doubleClick(org.eclipse.jface.viewers.DoubleClickEvent)
   */
  public void doubleClick(DoubleClickEvent event_p) {
    IStructuredSelection selection = (IStructuredSelection) event_p.getSelection();
    Object selectedElement = selection.getFirstElement();
    if (selectedElement instanceof InternalMethodHandler) {
      InternalMethodHelper.openMethodContent(_patternData, (InternalMethodHandler) selectedElement, _isEditable);
    }
  }

  /**
   * Get pattern data.
   * @return
   */
  protected PatternData getPatternData() {
    return _patternData;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationListener#notifyChanged(org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification)
   */
  public void notifyChanged(IPatternModificationNotification notification_p) {
    int type = notification_p.getEventType();
    switch (type) {
      case IPatternModificationNotification.SET:
      case IPatternModificationNotification.RENAMED:
        Object notifier = notification_p.getNotifier();
        elementModified(notifier);
      break;
      case IPatternModificationNotification.ADDED:
        Object newValue = notification_p.getNewValue();
        elementAdded(newValue);
      break;
      case IPatternModificationNotification.REMOVED:
        Object oldValue = notification_p.getOldValue();
        elementRemoved(oldValue);
      break;
      case IPatternModificationNotification.SAVED:
        // Clear cached values.
        getPatternDataNode().clear();
        // Refresh the viewer.
        getTreeViewer().refresh();
      break;
      default:
      break;
    }
  }

  /**
   * Element renamed, refresh viewer.
   * @param element_p
   */
  protected void elementModified(Object element_p) {
    PatternDataNode patternDataNode = getPatternDataNode();
    Object elementToRefresh = patternDataNode.getNode(element_p);
    // Refresh element, if any.
    if (null != elementToRefresh) {
      getTreeViewer().update(elementToRefresh, null);
    }
  }

  /**
   * A new element has been added to the pattern, display it in outline page, if needed.
   * @param newElement_p
   */
  protected void elementAdded(Object newElement_p) {
    PatternDataNode patternDataNode = getPatternDataNode();
    Object elementToAdd = patternDataNode.addNode(newElement_p);
    // Refresh viewer.
    if (null != elementToAdd) {
      getTreeViewer().add(patternDataNode, elementToAdd);
    }
  }

  /**
   * An existing element has been removed from the pattern, remove it from outline page, if needed.
   * @param oldElement_p
   */
  protected void elementRemoved(Object oldElement_p) {
    PatternDataNode patternDataNode = getPatternDataNode();
    Object elementToRemove = patternDataNode.removeNode(oldElement_p);
    // Refresh viewer.
    if (null != elementToRemove) {
      getTreeViewer().remove(patternDataNode, new Object[] { elementToRemove });
    }
  }

  /**
   * Get pattern data node.
   * @return
   */
  protected PatternDataNode getPatternDataNode() {
    ITreeNode firstChild = ((ITreeNode) getTreeViewer().getInput()).getChildren()[0];
    return (PatternDataNode) firstChild;
  }

  /**
   * Root node.
   * @author Guillaume Brocard
   */
  protected class RootNode extends DefaultTreeNode {
    /**
     * Children reminder.
     */
    private ITreeNode[] _children;

    /**
     * Constructor.
     */
    protected RootNode() {
      super(null);
      _children = new ITreeNode[] { new PatternDataNode(this) };
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.ITreeNode#getChildren()
     */
    @Override
    public ITreeNode[] getChildren() {
      return _children;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.ITreeNode#hasChildren()
     */
    @Override
    public boolean hasChildren() {
      // There is at least one child, that is the pattern data node.
      return true;
    }
  }

  /**
   * Pattern data node.
   * @author Guillaume Brocard
   */
  public class PatternDataNode extends DefaultTreeNode {
    /**
     * Reminder of known children.
     */
    private List<ITreeNode> _children;
    /**
     * Method handler factory.
     */
    private IInternalMethodHandlerFactory _methodHandlerFactory;

    /**
     * Constructor.
     * @param parent_p
     */
    protected PatternDataNode(ITreeNode parent_p) {
      super(parent_p);
    }

    /**
     * Clear cached contents.
     */
    protected void clear() {
      _children.clear();
      _children = null;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.DefaultTreeNode#isHandling(java.lang.Object)
     */
    @Override
    public boolean isHandling(Object element_p) {
      return (element_p instanceof PatternData);
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.ITreeNode#getChildren()
     */
    @Override
    public ITreeNode[] getChildren() {
      if (null == _children) {
        // Deal with internal methods first.
        if (null == _methodHandlerFactory) {
          // Create internal method handler factory.
          _methodHandlerFactory = new IInternalMethodHandlerFactory() {
            public InternalMethodHandler createNewHandler(EOperation method_p) {
              return new PatternMethodNode(method_p, PatternDataNode.this);
            }
          };
        }
        InternalMethodHandler[] internalMethods = InternalMethodHelper.getInternalMethodsFromInput(getPatternData(), _methodHandlerFactory);
        _children = new ArrayList<ITreeNode>(internalMethods.length);
        for (InternalMethodHandler handler : internalMethods) {
          _children.add((ITreeNode) handler);
        }
        // Then deal with parameters.
        for (ParameterRelation parameter : getPatternData().getAllParameters()) {
          _children.add(createNewNode(parameter));
        }
      }
      return _children.toArray(new ITreeNode[_children.size()]);
    }

    /**
     * Create a new node for given element.
     * @param element_p
     * @return null if no node could be created.
     */
    protected ITreeNode createNewNode(Object element_p) {
      ITreeNode result = null;
      if (element_p instanceof EOperation) {
        result = (ITreeNode) _methodHandlerFactory.createNewHandler((EOperation) element_p);
      } else if (element_p instanceof ParameterRelation) {
        result = new PatternParameterNode((ParameterRelation) element_p, this);
      }
      return result;
    }

    /**
     * Add a new node for given element.
     * @param method_p A not null, not already handled element.
     * @return newly created tree node, or null if given element is null or already handled.
     */
    protected ITreeNode addNode(Object element_p) {
      // Precondition.
      if (null != getNode(element_p)) {
        return null;
      }
      // Supplied factory only creates the ITreeNode variant of the method handler.
      ITreeNode newNode = createNewNode(element_p);
      if (null != newNode) {
        _children.add(newNode);
      }
      return newNode;
    }

    /**
     * Remove existing node for given element.
     * @param element_p A not null, already handled element.
     * @return removed node, or null if it could not be found.
     */
    protected ITreeNode removeNode(Object element_p) {
      ITreeNode nodeToRemove = getNode(element_p);
      if (null != nodeToRemove) {
        _children.remove(nodeToRemove);
      }
      return nodeToRemove;
    }

    /**
     * Get node for given element.
     * @param element_p
     * @return null if it could not be found.
     */
    protected ITreeNode getNode(Object element_p) {
      ITreeNode result = null;
      // Precondition.
      if (null == _children) {
        return result;
      }
      // Cycle through known children.
      for (ITreeNode treeNode : _children) {
        // Retain only those of the correct type.
        if (treeNode.isHandling(element_p)) {
          result = treeNode;
          break;
        }
      }
      return result;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.ITreeNode#hasChildren()
     */
    @Override
    public boolean hasChildren() {
      return true;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
      return getPatternData().getPatternLogicalName();
    }
  }

  /**
   * Pattern method node.
   * @author Guillaume Brocard
   */
  protected class PatternMethodNode extends InternalMethodHandler implements ITreeNode {
    /**
     * Parent node.
     */
    private ITreeNode _parent;

    /**
     * Constructor.
     * @param method_p
     * @param parent_p
     */
    public PatternMethodNode(EOperation method_p, ITreeNode parent_p) {
      super(method_p, PatternEditorContentOutlinePage.this.getPatternData());
      _parent = parent_p;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.ITreeNode#getChildren()
     */
    public ITreeNode[] getChildren() {
      return null;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.ITreeNode#getParent()
     */
    public ITreeNode getParent() {
      return _parent;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.ITreeNode#hasChildren()
     */
    public boolean hasChildren() {
      return false;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.ITreeNode#isHandling(java.lang.Object)
     */
    public boolean isHandling(Object element_p) {
      return (element_p instanceof EOperation) && isHandlerFor((EOperation) element_p);
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.ITreeNode#comparisonPriority()
     */
    public int comparisonPriority() {
      // Methods have always less priority than parameters.
      return 2;
    }
  }

  /**
   * Pattern parameter node.
   * @author Guillaume Brocard
   */
  protected class PatternParameterNode extends DefaultTreeNode implements IParameterHandler {
    /**
     * Displayed parameter relation.
     */
    private ParameterRelation _parameterRelation;

    /**
     * Constructor.
     * @param parameter_p
     * @param parent_p
     */
    protected PatternParameterNode(ParameterRelation parameter_p, ITreeNode parent_p) {
      super(parent_p);
      _parameterRelation = parameter_p;
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.IParameterHandler#getParameter()
     */
    public ParameterRelation getParameter() {
      return _parameterRelation;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.DefaultTreeNode#isHandling(java.lang.Object)
     */
    @Override
    public boolean isHandling(Object element_p) {
      return (element_p == _parameterRelation);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.IParameterHandler#isInherited()
     */
    public boolean isInherited() {
      return !getPatternData().getPattern().equals(_parameterRelation.eContainer());
    }

    /**
     * Get name of the pattern that defines the parameter.
     * @return
     */
    protected String getDefiningPatternName() {
      return ((Pattern) _parameterRelation.eContainer()).getName();
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.DefaultTreeNode#hasChildren()
     */
    @Override
    public boolean hasChildren() {
      return false;
    }

    /**
     * @see org.eclipse.egf.common.ui.viewers.DefaultTreeNode#comparisonPriority()
     */
    @Override
    public int comparisonPriority() {
      if (isInherited()) {
        // Inherited parameters have more priority...
        return 0;
      }
      // ...than local ones.
      return 1;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
      return _parameterRelation.getName() + ICommonConstants.WHITE_SPACE_CHARACTER + ICommonConstants.COLON_CHARACTER + ICommonConstants.WHITE_SPACE_CHARACTER
             + _parameterRelation.getType().getName();
    }
  }

  /**
   * Pattern editor outline label provider.
   * @author Guillaume Brocard
   */
  protected class OutlineLabelProvider extends LabelProvider implements ILabelDecorator {
    /**
     * Inherited parameter prefix text.
     */
    private static final String INHERITED_PARAMETER_PREFIX = "({0}->) {1}"; //$NON-NLS-1$

    /**
     * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
     */
    @Override
    public Image getImage(Object element_p) {
      Image result = null;
      if (element_p instanceof PatternDataNode) {
        result = ExtendedImageRegistry.INSTANCE.getImage(FactoryComponentEditPlugin.INSTANCE.getImage(IImageKeys.IMG_PATTERN_MODEL_ID));
      } else {
        ImageRegistry imageRegistry = JavaPlugin.getDefault().getImageRegistry();
        if (element_p instanceof PatternMethodNode) {
          result = imageRegistry.get(JavaPluginImages.IMG_MISC_PROTECTED);
        } else if (element_p instanceof PatternParameterNode) {
          result = imageRegistry.get(JavaPluginImages.IMG_FIELD_PROTECTED);
        }
      }
      return decorateImage(result, element_p);
    }

    /**
     * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
     */
    @Override
    public String getText(Object element_p) {
      return decorateText(super.getText(element_p), element_p);
    }

    /**
     * @see org.eclipse.jface.viewers.ILabelDecorator#decorateImage(org.eclipse.swt.graphics.Image, java.lang.Object)
     */
    public Image decorateImage(Image image_p, Object element_p) {
      int flag = computeFlag(element_p);
      ImageDescriptor baseImage = ImageDescriptor.createFromImage(image_p);
      return JavaPlugin.getImageDescriptorRegistry().get(new JavaElementImageDescriptor(baseImage, flag, JavaElementImageProvider.BIG_SIZE));
    }

    /**
     * Compute flag for given element.
     * @param element_p
     * @return
     */
    protected int computeFlag(Object element_p) {
      // Default flag, does nothing.
      int flag = 0;
      // Pattern data node.
      if (element_p instanceof PatternDataNode) {
        // If it is extending another pattern, decorate it as implementor.
        if (null != getPatternData().getParentPattern()) {
          flag |= JavaElementImageDescriptor.IMPLEMENTS;
        }
      } else if (element_p instanceof PatternMethodNode) { // Pattern method node.
        if (((PatternMethodNode) element_p).isOverriding()) {
          flag |= JavaElementImageDescriptor.OVERRIDES;
        }
      } else if (element_p instanceof PatternParameterNode) {
        if (((PatternParameterNode) element_p).isInherited()) {
          flag |= JavaElementImageDescriptor.IMPLEMENTS;
        }
      }
      return flag;
    }

    /**
     * @see org.eclipse.jface.viewers.ILabelDecorator#decorateText(java.lang.String, java.lang.Object)
     */
    public String decorateText(String text_p, Object element_p) {
      String result = text_p;
      if (element_p instanceof PatternParameterNode) {
        PatternParameterNode node = (PatternParameterNode) element_p;
        if (node.isInherited()) {
          result = StringHelper.formatMessage(
            INHERITED_PARAMETER_PREFIX, 
            new Object[] { 
              node.getDefiningPatternName(), 
              result 
            }
          );
        }
      }
      return result;
    }
  }

  /**
   * Pattern editor outline content provider.
   * @author Guillaume Brocard
   */
  protected class OutlineContentProvider extends AbstractPatternPageContentProvider implements ITreeContentProvider {
    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doDispose()
     */
    @Override
    protected void doDispose() {
      // Nothing to do here, yet.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#getViewer()
     */
    @Override
    protected TreeViewer getViewer() {
      return (TreeViewer) super.getViewer();
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementUpdated(java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    protected void doHandleElementUpdated(Object oldInput_p, Object newInput_p) {
      // Update viewer.
      getViewer().update(newInput_p, null);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementsAdded(java.lang.Object)
     */
    @Override
    protected void doHandleElementsAdded(Object addedElements_p) {
      // TODO
      // Still to be implemented.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementsRemoved(java.lang.Object)
     */
    @Override
    protected void doHandleElementsRemoved(Object removedElements_p) {
      // TODO
      // Still to be implemented.
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement_p) {
      return getChildren(inputElement_p);
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    public Object[] getChildren(Object parentElement_p) {
      Object[] result = null;
      if (parentElement_p instanceof ITreeNode) {
        result = ((ITreeNode) parentElement_p).getChildren();
      }
      // Expand viewer.
      getViewer().setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
      return result;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    public Object getParent(Object element_p) {
      Object parent = null;
      if (element_p instanceof ITreeNode) {
        parent = ((ITreeNode) element_p).getParent();
      }
      return parent;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    public boolean hasChildren(Object element_p) {
      boolean result = false;
      if (element_p instanceof ITreeNode) {
        result = ((ITreeNode) element_p).hasChildren();
      }
      return result;
    }
  }

  /**
   * Pattern editor outline sorter.
   * @author Guillaume Brocard
   */
  protected class OutlineViewerSorter extends ViewerSorter {
    /**
     * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(Viewer viewer_p, Object e1_p, Object e2_p) {
      int result = 0;
      // Compare tree nodes based on priorities.
      if ((e1_p instanceof ITreeNode) && (e2_p instanceof ITreeNode)) {
        result = ((ITreeNode) e1_p).comparisonPriority() - ((ITreeNode) e2_p).comparisonPriority();
      }
      // If that led to nowhere, compare using natural ViewerSorter order.
      if (0 == result) {
        result = super.compare(viewer_p, e1_p, e2_p);
      }
      return result;
    }
  }
  
}
