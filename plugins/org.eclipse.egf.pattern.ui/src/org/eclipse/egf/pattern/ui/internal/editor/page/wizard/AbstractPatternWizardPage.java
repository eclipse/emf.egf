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
package org.eclipse.egf.pattern.ui.internal.editor.page.wizard;

import org.eclipse.egf.common.ui.helper.FormHelper;
import org.eclipse.egf.common.ui.helper.FormHelper.LayoutType;
import org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * Abstract pattern wizard page.<br>
 * Allows for the creation of a unique structured viewer, that displays the page element selection.
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternWizardPage extends AbstractWizardPage implements ISelectionChangedListener {
  
  /**
   * Structured viewer.
   */
  private StructuredViewer _structuredViewer;
  
  /**
   * Complete status, true if page is completed, false otherwise.
   */
  private boolean _completeStatus;
  
  /**
   * Form toolkit.
   */
  private FormToolkit _formToolkit;

  /**
   * Constructor.
   * @param pageId_p
   */
  public AbstractPatternWizardPage(String pageId_p) {
    super(pageId_p);
    _completeStatus = false;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getCompleteStatus()
   */
  @Override
  protected boolean getCompleteStatus() {
    return _completeStatus;
  }

  /**
   * Create and initialize the viewer.
   * @return A not null viewer reference.
   */
  protected abstract StructuredViewer createViewer(Composite parent_p);

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#createPageArea(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createPageArea(Composite parent_p) {
    _formToolkit = new FormToolkit(parent_p.getDisplay());
    Composite composite = FormHelper.createCompositeWithLayoutType(
      _formToolkit, 
      parent_p, 
      LayoutType.GRID_LAYOUT, 
      1, 
      false
    );
    _structuredViewer = createViewer(composite);
    FormHelper.updateControlLayoutDataWithLayoutTypeData(
      _structuredViewer.getControl(), 
      LayoutType.GRID_LAYOUT
    );
    _structuredViewer.addSelectionChangedListener(this);
    _formToolkit.adapt(composite);
    Color background = parent_p.getBackground();
    composite.setBackground(background);
    endPageAreaCreation(_structuredViewer);
  }

  protected FormToolkit getToolkit() {
    return _formToolkit;
  }

  /**
   * Give the viewer creator back the opportunity to change the viewer representation after/if it has been adapted.
   * @param viewer_p
   */
  protected void endPageAreaCreation(StructuredViewer viewer_p) {
    // Default implementation does nothing.
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#handlePageContentEnablement(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected boolean isReadOnly() {
    return false;
  }

  /**
   * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
   */
  public void selectionChanged(SelectionChangedEvent event_p) {
    ISelection selection = event_p.getSelection();
    if (selection instanceof IStructuredSelection) {
      Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
      _completeStatus = delegateSelectionChanged(selectedElement);
    }
    updateButtons();
  }

  /**
   * Delegate selection changed.<br>
   * Given selected element might be null.<br>
   * @param selectedElement_p
   * @return true if selection completes the page, false otherwise.
   */
  protected abstract boolean delegateSelectionChanged(Object selectedElement_p);
  
}
