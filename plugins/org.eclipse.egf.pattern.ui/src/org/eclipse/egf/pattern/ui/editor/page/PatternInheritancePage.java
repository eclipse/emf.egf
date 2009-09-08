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
import java.util.List;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler;
import org.eclipse.egf.common.descriptor.pattern.helper.PatternDescriptorStrategy;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.ui.helper.FormHelper;
import org.eclipse.egf.common.ui.helper.FormHelper.LayoutType;
import org.eclipse.egf.common.ui.toolkit.viewers.AbstractTransferViewer;
import org.eclipse.egf.common.ui.toolkit.viewers.TransferTreeViewer;
import org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler;
import org.eclipse.egf.core.ui.viewers.PatternStructureLabelProviderWithTooltip;
import org.eclipse.egf.pattern.Pattern;
import org.eclipse.egf.pattern.ecore.AbstractPatternGenerator;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.production.template.TemplateHelper;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider;
import org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler;
import org.eclipse.egf.pde.pattern.reader.PlatformPatternExtensionReader;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * @author Guillaume Brocard
 */
public class PatternInheritancePage extends AbstractPatternPage {
  
  /**
   * Page id.
   */
  protected static final String ID = "egf_pattern_inheritance_page"; //$NON-NLS-1$
  
  /**
   * Help context id.
   */
  protected static final String HELP_CONTEXT_ID = PatternUiActivator.getDefault().getPluginID() + ICommonConstants.DOT_CHARACTER + ID;

  /**
   * Constructor.
   * @param editor_p
   */
  public PatternInheritancePage(FormEditor editor_p) {
    super(editor_p, ID, Messages.PatternInheritancePage_Title);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#doCreateFormContent(org.eclipse.ui.forms.widgets.FormToolkit,
   *      org.eclipse.swt.widgets.Composite, org.eclipse.egf.pattern.ecore.PatternHandler.PatternData, org.eclipse.ui.forms.IManagedForm)
   */
  @Override
  protected void doCreateFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p, IManagedForm managedForm_p) {
    // Create inheritance composite.
    FormHelper.updateCompositeLayoutWithLayoutType(parent_p, LayoutType.GRID_LAYOUT, 1, false);
    // Create description label.
    toolkit_p.createLabel(parent_p, Messages.PatternInheritancePage_Description_Label, SWT.WRAP);
    new ParentsViewer().createViewer(toolkit_p, parent_p, patternData_p);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#createPatternBlock()
   */
  @Override
  protected AbstractPatternBlock createPatternBlock() {
    return null;
  }

  /**
   * Parents viewer.<br>
   * Handles both possible parents and selected one through a transfer viewer.
   * @author Guillaume Brocard
   */
  protected class ParentsViewer {
    
    /**
     * Transfer viewer.
     */
    private TransferTreeViewer _viewer;
    
    /**
     * Current pattern.
     */
    private IDescriptor _currentPattern;
    
    /**
     * Current parent.
     */
    private IDescriptor _currentParent;
    
    
    /**
     * Current parent full id.
     */
    private String _currentParentFullId;
    
    /**
     * Root content descriptor.
     */
    private IDescriptor _rootDescriptor;

    /**
     * Create viewer and initialize it.
     * @param parent_p
     */
    protected void createViewer(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p) {
      int style = AbstractTransferViewer.SINGLE_SELECTION_VIEWER 
        | AbstractTransferViewer.ALL_BUTTONS 
        & ~AbstractTransferViewer.ADD_ALL_BUTTON
        & ~AbstractTransferViewer.REMOVE_ALL_BUTTON;
      _viewer = new TransferTreeViewer(
        parent_p, 
        style, 
        SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER
      );
      // Get buttons composite.
      Composite buttonsComposite = _viewer.getButtonsContainer();
      // Initialize content.
      initializeContent(patternData_p);
      // Initialize listeners.
      initializeListeners(patternData_p);
      // Initialize left viewer.
      initializeLeftViewer((AbstractTreeViewer) _viewer.getLeftViewer());
      // Initialize right viewer.
      initializeRightViewer((AbstractTreeViewer) _viewer.getRightViewer(), patternData_p);
      toolkit_p.adapt(_viewer.getControl(), true, true);
      // Enable or disable buttons.
      buttonsComposite.setEnabled(isEditable());
      toolkit_p.adapt(buttonsComposite, true, true);
    }

    /**
     * Initialize content before displaying it.
     * @param patternData_p
     */
    protected void initializeContent(PatternData patternData_p) {
      // Create root descriptor.
      GenericDescriptor rootDescriptor = new GenericDescriptor();
      // Read descriptors from workspace and platform.
      // TODO Guillaume.
      // Analyze more precisely the reason for this behavior.
      // Due to prod00015931.
      // Do no longer add workspace libraries to the set of possible parents.
      // End of prod00015931.
      PatternDescriptorStrategy.retainRootOnly(
        rootDescriptor, 
        new PlatformPatternExtensionReader().getPatternLibraries()
      );
      _rootDescriptor = rootDescriptor;
      // Get current parent.
      Pattern parentPattern = patternData_p.getParentPattern();
      final String patternfullId = patternData_p.getPattern().getId();
      final IDescriptor[] currentPattern = new IDescriptor[] { null };
      if (parentPattern != null) {
        _currentParentFullId = parentPattern.getId();
      }
      PatternDescriptorStrategy strategy = new PatternDescriptorStrategy();
      strategy.iterateThroughPatternExtensionDescriptor(
        new IPatternDescriptorHandler() {
          public void handleDescriptor(IDescriptor descriptor_p) {
            // Not interested in this handle.
          }
          public void handleLibraryDescriptor(IDescriptor descriptor_p, String parentLibraryId_p) {
            // Not interested in this handle.
          }
          @SuppressWarnings("synthetic-access")
          public void handlePatternDescriptor(IDescriptor descriptor_p, String patternFullId_p) {
            if (patternFullId_p.equals(_currentParentFullId)) {
              _currentParent = descriptor_p;
            } else if (patternFullId_p.equals(patternfullId)) {
              currentPattern[0] = descriptor_p;
            }
          }
        }, 
        rootDescriptor
      );
      // Found current pattern, remove it from possible values.
      _currentPattern = currentPattern[0];
    }

    /**
     * Get a root descriptor for given descriptor.
     * @param descriptor_p
     * @return
     */
    protected IDescriptor getRootDescriptorFor(IDescriptor descriptor_p) {
      GenericDescriptor result = new GenericDescriptor();
      if (descriptor_p != null) {
        IDescriptor parentDescriptor = descriptor_p.getParent();
        result.addChild(parentDescriptor);
      }
      return result;
    }

    /**
     * Initialize left viewer.
     * @param leftViewer_p
     */
    protected void initializeLeftViewer(AbstractTreeViewer leftViewer_p) {
      // Expand to 1 levels automatically.
      leftViewer_p.setAutoExpandLevel(2);
      // Set a string comparator.
      leftViewer_p.setComparator(new ViewerComparator());
      // Set content provider.
      _viewer.setLeftContentProvider(new ParentsContentProvider(true, _currentParent, _currentPattern, null));
      // Set label provider.
      _viewer.setLeftLabelProvider(new PatternStructureLabelProviderWithTooltip());
      ColumnViewerToolTipSupport.enableFor(leftViewer_p);
      // Set initial input.
      _viewer.setLeftInput(_rootDescriptor);
    }

    /**
     * Initialize right viewer.
     * @param rightViewer_p
     */
    protected void initializeRightViewer(AbstractTreeViewer rightViewer_p, PatternData patternData_p) {
      // Expand to 1 level automatically.
      rightViewer_p.setAutoExpandLevel(2);
      // Set content provider.
      _viewer.setRightContentProvider(new ParentsContentProvider(false, _currentParent, null, new InheritanceHandler(patternData_p)));
      // Set label provider.
      _viewer.setRightLabelProvider(new PatternStructureLabelProviderWithTooltip());
      ColumnViewerToolTipSupport.enableFor(rightViewer_p);
      // Set initial input.
      _viewer.setRightInput(getRootDescriptorFor(_currentParent));
    }

    /**
     * Initialize viewer handlers.
     * @param pattern_p
     */
    protected void initializeListeners(final PatternData patternData_p) {
      // Add button handler.
      SelectionChangedHandler addButtonHandler = new ParentsButtonHandler() {
        @Override
        protected boolean postCondition() {
          boolean result = true;
          // If pattern already has a super type, disable add button.
          List<EClass> parents = patternData_p.getPattern().getESuperTypes();
          if (parents.size() > 0) {
            EClass parent = parents.get(0);
            // Pattern has a parent of pattern type.
            result = parent instanceof Pattern == false;
          }
          return result;
        }
      };
      // Register add button handler.
      _viewer.setSelectionChangedHandler(addButtonHandler, AbstractTransferViewer.ADD_SELECTED_BUTTON);
      // Register remove button handler.
      _viewer.setSelectionChangedHandler(new ParentsButtonHandler(), AbstractTransferViewer.REMOVE_SELECTED_BUTTON);
    }
  }

  /**
   * Buttons handler.<br>
   * Decide if add and remove button should be enabled or disabled, depending on current selection and an extra external condition.
   */
  protected class ParentsButtonHandler extends SelectionChangedHandler { 
    
    /**
     * @see org.eclipse.egf.common.ui.toolkit.widgets.handler.SelectionChangedHandler#doHandleSelection(org.eclipse.jface.viewers.ISelection)
     */
    @Override
    protected boolean doHandleSelection(ISelection selection_p) {
      boolean result = false;
      if (selection_p instanceof StructuredSelection) {
        StructuredSelection selection = (StructuredSelection) selection_p;
        // There should be only one element selected.
        Object selectedElement = selection.getFirstElement();
        if (selectedElement instanceof IDescriptor) {
          // Only a descriptor of pattern is usable from left to right and vice-versa.
          IDescriptor selectedDescriptor = (IDescriptor) selectedElement;
          result = IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_PATTERN.equals(
            selectedDescriptor.getValue(IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE)
          );
        }
      }
      return result & postCondition();
    }

    /**
     * Possible post condition implementation.<br>
     * If false, overall selection is discarded, else decision is up to {@link #doHandleSelection(ISelection)}.
     * @return
     */
    protected boolean postCondition() {
      return true;
    }
    
  }

  /**
   * Parents content provider.<br>
   * Do handle {@link IDescriptor} as managed elements.
   */
  protected class ParentsContentProvider extends AbstractPatternPageContentProvider implements ITreeContentProvider {
    
    /**
     * Is current viewer the left one (true) or the right one (false) ?
     */
    private boolean _leftViewer;
    
    /**
     * Current chosen parent.
     */
    private IDescriptor _currentParent;
    
    /**
     * Current pattern descriptor.
     */
    private IDescriptor _currentPattern;
    
    /**
     * Inheritance handler.
     */
    private InheritanceHandler _handler;

    /**
     * Constructor.
     * @param leftViewer_p is this a provider for the left (true) or right (false) viewer ?
     * @param currentParent_p existing pattern parent at construction time. Null if none.
     * @param currentPattern_p descriptor for current pattern. Should not be visible on either trees. Not mandatory for the right viewer.
     * @param handler_p The handler for pattern modifications. Null if that is not relevant for this content provider.
     */
    protected ParentsContentProvider(boolean leftViewer_p, IDescriptor currentParent_p, IDescriptor currentPattern_p, InheritanceHandler handler_p) {
      _leftViewer = leftViewer_p;
      _currentParent = currentParent_p;
      _currentPattern = currentPattern_p;
      _handler = handler_p;
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#getInitialInput()
     */
    @Override
    protected GenericDescriptor getInitialInput() {
      return (GenericDescriptor) super.getInitialInput();
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#getViewer()
     */
    @Override
    protected TreeViewer getViewer() {
      return (TreeViewer) super.getViewer();
    }

    /**
     * Set current parent reference.<br>
     * Also update pattern model, if this feature is available.
     * @param descriptor_p
     */
    private void setCurrentParent(IDescriptor descriptor_p) {
      _currentParent = descriptor_p;
      // Update pattern model.
      if (_handler != null) {
        _handler.setParentDescriptor(_currentParent);
      }
    }

    /**
     * Get descriptor from given input.
     * @param elements_p
     * @return null if no descriptor could be found.
     */
    protected IDescriptor getDescriptor(Object elements_p) {
      return (IDescriptor) getElement(elements_p, IDescriptor.class);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doHandleElementsAdded(java.lang.Object)
     */
    @Override
    protected void doHandleElementsAdded(Object addedElements_p) {
      IDescriptor addedElement = getDescriptor(addedElements_p);
      // Precondition.
      if (addedElement == null) {
        return;
      }
      // Add element.
      IDescriptor parent = addedElement.getParent();
      if (_leftViewer) {
        setCurrentParent(null);
        Object treePath = parent == null ? getInitialInput() : parent;
        getViewer().add(treePath, addedElement);
      } else {
        // Right viewer is populated with selected parent.
        setCurrentParent(addedElement);
        // Add child to initial input.
        IDescriptor parentDescriptor = _currentParent.getParent();
        getInitialInput().addChild(parentDescriptor);
        // Then refresh the viewer.
        getViewer().add(getInitialInput(), parentDescriptor);
      }
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doHandleElementsRemoved(java.lang.Object)
     */
    @Override
    protected void doHandleElementsRemoved(Object removedElements_p) {
      IDescriptor removedElement = getDescriptor(removedElements_p);
      // Precondition.
      if (removedElement == null) {
        return;
      }
      IDescriptor parent = removedElement.getParent();
      // Left viewer is amputated from selected parent.
      if (_leftViewer) {
        setCurrentParent(removedElement);
        // Remove element.
        getViewer().remove(parent, new Object[] { removedElement });
      } else {
        // Right viewer does not have anymore a selected parent.
        setCurrentParent(null);
        // Remove child from initial input.
        getInitialInput().getChildren().remove(parent);
        // Then refresh the viewer.
        getViewer().remove(getInitialInput(), new Object[] { parent });
      }
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doHandleElementUpdated(java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    protected void doHandleElementUpdated(Object oldInput_p, Object newInput_p) {
      // Nothing to do here.
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    public Object[] getChildren(Object parentElement_p) {
      Object[] result = null;
      IDescriptor desciptor = (IDescriptor) parentElement_p;
      List<IDescriptor> children = desciptor.getChildren();
      if (children != null) {
        List<IDescriptor> resultingChildren = null;
        if (_leftViewer) {
          // Left viewer does not want to display neither current parent nor current pattern.
          resultingChildren = new ArrayList<IDescriptor>(children.size());
          resultingChildren.addAll(children);
          resultingChildren.remove(_currentParent);
          resultingChildren.remove(_currentPattern);
        } else {
          // Right viewer does not want to display the other possible children of current container.
          if (parentElement_p != getInitialInput()) {
            resultingChildren = new ArrayList<IDescriptor>(1);
            resultingChildren.add(_currentParent);
            // Do retain only elements both from current children list and current parent.
            // If displayed element does not hold current parent, then the resulting list will be empty.
            // But that is an error case.
            resultingChildren.retainAll(children);
          } else {
            // For initial input, simply step next to contained library.
            resultingChildren = children;
          }
        }
        result = resultingChildren.toArray();
      }
      return result;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    public Object getParent(Object element_p) {
      IDescriptor descriptor = (IDescriptor) element_p;
      return descriptor.getParent();
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    public boolean hasChildren(Object element_p) {
      // Left viewer may have no child for given element.
      Object[] children = getChildren(element_p);
      return children != null && children.length > 0;
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement_p) {
      return getChildren(inputElement_p);
    }

    /**
     * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage.AbstractPatternPageContentProvider#doDispose()
     */
    @Override
    public void doDispose() {
      _currentParent = null;
      _currentPattern = null;
      _handler = null;
    }
    
  }

  /**
   * Inheritance handler.
   */
  private class InheritanceHandler extends DefaultContentHandler {
    
    /**
     * Constructor.
     * @param patternData_p
     */
    protected InheritanceHandler(PatternData patternData_p) {
      super(patternData_p, PatternInheritancePage.this);
    }

    /**
     * Set pattern new parent using given descriptor.
     * @param descriptor_p
     */
    public void setParentDescriptor(IDescriptor descriptor_p) {
      String patternName = null;
      String ecoreUri = null;
      if (descriptor_p != null) {
        patternName = (String) descriptor_p.getValue(ExtensionPointHelper.ATT_NAME);
        ecoreUri = (String) descriptor_p.getValue(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME);
      }
      // Switch from logical relative path to physical one.
      ecoreUri = TemplateHelper.getPhysicalRelativePath(ecoreUri);
      // Set new parent.
      AbstractPatternGenerator.setPatternParent(getPattern(), patternName, ecoreUri, null);
      notifyModification();
    }
    
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#getHelpContextId()
   */
  @Override
  public String getHelpContextId() {
    return HELP_CONTEXT_ID;
  }
  
}
