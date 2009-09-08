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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard;

import java.util.List;

import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler;
import org.eclipse.egf.common.descriptor.pattern.helper.PatternDescriptorStrategy;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.core.ui.viewers.PatternStructureLabelProviderWithTooltip;
import org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider;
import org.eclipse.egf.pde.pattern.reader.PlatformPatternExtensionReader;
import org.eclipse.egf.pde.pattern.reader.WorkspacePatternExtensionReader;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


/**
 * @author Guillaume Brocard
 */
public class PatternIdParameterSelectionPage extends AbstractPatternCodeWizardPage {
  
  /**
   * Page unique id.
   */
  protected static final String PAGE_ID = "actionPatternIdParameter"; //$NON-NLS-1$

  /**
   * Constructor.
   */
  public PatternIdParameterSelectionPage() {
    super(PAGE_ID);
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getPageDescription()
   */
  @Override
  protected String getPageDescription() {
    return Messages.PatternIdParameterSelectionPage_Description;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.PatternIdParameterSelectionPage_Title;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.AbstractPatternCodeWizardPage#createViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected StructuredViewer createViewer(Composite parent_p) {
    TreeViewer result = new TreeViewer(parent_p, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
    // Content provider.
    result.setContentProvider(new PatternIdContentProvider());
    // Label provider.
    result.setLabelProvider(new PatternStructureLabelProviderWithTooltip());
    ColumnViewerToolTipSupport.enableFor(result);
    // Set initial input.
    Couple<Object, Object> initializedContent = initializeContent();
    result.setInput(initializedContent.getKey());
    // Set initial selection.
    Object initialSelection = initializedContent.getValue();
    if (initialSelection != null) {
      result.setSelection(new StructuredSelection(initialSelection));
    }
    return result;
  }

  /**
   * Get view initial input content.
   * @return {@link Couple}(Key = initial input, Value = initial selection).
   */
  protected Couple<Object, Object> initializeContent() {
    // Create root descriptor.
    GenericDescriptor rootDescriptor = new GenericDescriptor();
    // Read descriptors from workspace and platform.
    PatternDescriptorStrategy.retainRootOnly(
      rootDescriptor, 
      new WorkspacePatternExtensionReader().getPatternLibraries()
    );
    PatternDescriptorStrategy.retainRootOnly(
      rootDescriptor, 
      new PlatformPatternExtensionReader().getPatternLibraries()
    );
    // Get existing value.
    final String fullId = getWizard().getActionParameter();
    final IDescriptor[] initialSelection = new IDescriptor[] { null };
    // Search for corresponding descriptor.
    if (fullId != null) {
      new PatternDescriptorStrategy(){
        @Override
        protected boolean stopSearch(IDescriptor parentDescriptor_p) {
          return (initialSelection[0] != null);
        }
      }.iterateThroughPatternExtensionDescriptor(
        new IPatternDescriptorHandler() {
          public void handleDescriptor(IDescriptor descriptor_p) {
            // Nothing to do here.
          }
          public void handleLibraryDescriptor(IDescriptor descriptor_p, String parentLibraryId_p) {
            if (fullId.equals(parentLibraryId_p)) {
              initialSelection[0] = descriptor_p;
            }
          }
          public void handlePatternDescriptor(IDescriptor descriptor_p, String patternFullId_p) {
            if (fullId.equals(patternFullId_p)) {
              initialSelection[0] = descriptor_p;
            }
          }
        }, 
        rootDescriptor
      );
    }
    return new Couple<Object, Object>(rootDescriptor, initialSelection[0]);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.AbstractPatternCodeWizardPage#delegateSelectionChanged(java.lang.Object)
   */
  @Override
  protected boolean delegateSelectionChanged(Object selectedElement_p) {
    IDescriptor descriptor = (IDescriptor) selectedElement_p;
    String fullId = null;
    // Only takes into account the selection of a pattern (libraries are excluded).
    if (IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_PATTERN.equals(descriptor.getValue(IPatternConstants.PATTERN_EXTENSION_POINT_CHILD_TYPE))) {
      fullId = PatternDescriptorStrategy.getDescriptorFullId(descriptor);
      getWizard().setActionParameter(fullId);
    }
    return fullId != null;
  }

  /**
   * Pattern id content provider.
   */
  protected class PatternIdContentProvider extends AbstractPatternPageContentProvider implements ITreeContentProvider {
    
    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doDispose()
     */
    @Override
    protected void doDispose() {
      // Nothing to do.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementUpdated(java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    protected void doHandleElementUpdated(Object oldInput_p, Object newInput_p) {
      // Nothing to do.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementsAdded(java.lang.Object)
     */
    @Override
    protected void doHandleElementsAdded(Object addedElements_p) {
      // Nothing to do.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementsRemoved(java.lang.Object)
     */
    @Override
    protected void doHandleElementsRemoved(Object removedElements_p) {
      // Nothing to do.
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
      IDescriptor descriptor = (IDescriptor) parentElement_p;
      return descriptor.getChildren().toArray();
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
      IDescriptor descriptor = (IDescriptor) element_p;
      List<IDescriptor> children = descriptor.getChildren();
      return children != null && children.size() > 0;
    }
    
  }
  
}
