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
package org.eclipse.egf.pattern.runner.ui;

import java.util.Collections;
import java.util.List;

import org.eclipse.egf.common.descriptor.GenericDescriptor;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.descriptor.pattern.helper.IPatternDescriptorHandler;
import org.eclipse.egf.common.descriptor.pattern.helper.PatternDescriptorStrategy;
import org.eclipse.egf.core.ui.viewers.PatternStructureLabelProviderWithTooltip;
import org.eclipse.egf.pde.pattern.reader.PlatformPatternExtensionReader;
import org.eclipse.egf.pde.pattern.reader.WorkspacePatternExtensionReader;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;


/**
 * A class to select either a pattern or a library.
 * @author Guillaume Brocard
 */
public class PatternSelectionDialog extends ElementTreeSelectionDialog {
  
  private Object[] _initialSelection;
  
  private GenericDescriptor _rootDescriptor;

  /**
   * Constructor.
   * @param parent_p
   * @param labelProvider_p
   * @param contentProvider_p
   */
  public PatternSelectionDialog(Shell parent_p) {
    super(parent_p, new PatternStructureLabelProviderWithTooltip(), new PatternIdContentProvider());
    // Set the title.
    setTitle(Messages.PatternSelectionDialog_Title);
    // Set Message.
    setMessage(Messages.PatternSelectionDialog_Message);
    // Single selection mode.
    setAllowMultiple(false);
  }

  /**
   * @see org.eclipse.ui.dialogs.ElementTreeSelectionDialog#createTreeViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected TreeViewer createTreeViewer(Composite parent_p) {
    TreeViewer result = super.createTreeViewer(parent_p);
    // Enable tooltip support.
    ColumnViewerToolTipSupport.enableFor(result);
    return result;
  }

  /**
   * @see org.eclipse.ui.dialogs.ElementTreeSelectionDialog#open()
   */
  @Override
  public int open() {
    populateDialogContent();
    return super.open();
  }

  /**
   * Populate the dialog content.
   */
  protected void populateDialogContent() {
    _rootDescriptor = new GenericDescriptor();
    // Read descriptors from workspace and platform to retrieve all patterns.
    PatternDescriptorStrategy.retainRootOnly(_rootDescriptor, new WorkspacePatternExtensionReader().getPatternLibraries());
    PatternDescriptorStrategy.retainRootOnly(_rootDescriptor, new PlatformPatternExtensionReader().getPatternLibraries());
    // Set the initial input.
    setInput(_rootDescriptor);
  }

  /**
   * @see org.eclipse.ui.dialogs.SelectionDialog#setInitialSelections(java.lang.Object[])
   */
  @Override
  public void setInitialSelections(Object[] selectedElements_p) {
    _initialSelection = selectedElements_p;
  }

  /**
   * @see org.eclipse.ui.dialogs.SelectionDialog#getInitialElementSelections()
   */
  @Override
  @SuppressWarnings("unchecked")
  protected List getInitialElementSelections() {
    List result = Collections.emptyList();
    if ((null != _initialSelection) && (_initialSelection.length > 0)) {
      // Lookup the pattern for the initial selection (i.e a full id)
      IDescriptor retrievedPattern = findPattern((String) _initialSelection[0]);
      if (null != retrievedPattern) {
        result = Collections.singletonList(retrievedPattern);
      }
    }
    return result;
  }

  /**
   * Find a pattern or a library from its full id.
   * @param fullId_p
   * @return null if not found.
   */
  protected IDescriptor findPattern(final String fullId_p) {
    final IDescriptor[] initialSelection = new IDescriptor[] { null };
    new PatternDescriptorStrategy() {
      @Override
      protected boolean stopSearch(IDescriptor parentDescriptor_p) {
        return initialSelection[0] != null;
      }
    }.iterateThroughPatternExtensionDescriptor(
      new IPatternDescriptorHandler() {
        public void handleDescriptor(IDescriptor descriptor_p) {
          // Nothing to do here.
        }
        public void handleLibraryDescriptor(IDescriptor descriptor_p, String parentLibraryId_p) {
          if (fullId_p.equals(parentLibraryId_p)) {
            initialSelection[0] = descriptor_p;
          }
        }
        public void handlePatternDescriptor(IDescriptor descriptor_p, String patternFullId_p) {
          if (fullId_p.equals(patternFullId_p)) {
            initialSelection[0] = descriptor_p;
          }
        }
      }, 
      _rootDescriptor
    );
    return initialSelection[0];
  }
  
}