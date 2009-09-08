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

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.AbstractFormPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Abstract pattern details.<br>
 * Details part of the Master/Details pattern.<br>
 * Use together with an {@link AbstractPatternBlock}.
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternDetails extends AbstractFormPart implements IDetailsPage {
  
  /**
   * Master part.
   */
  private IFormPart _masterPart;

  /**
   * Constructor.
   * @param toolkit_p
   * @param masterPart_p
   */
  public AbstractPatternDetails(IFormPart masterPart_p) {
    _masterPart = masterPart_p;
  }

  /**
   * Get tool kit.
   * @return
   */
  protected FormToolkit getToolkit() {
    return getManagedForm().getToolkit();
  }

  /**
   * Get initial content required at construction time.<br>
   * Default implementation returns null.
   * @return
   */
  protected Object getInitialContent() {
    return null;
  }

  /**
   * @see org.eclipse.ui.forms.IDetailsPage#createContents(org.eclipse.swt.widgets.Composite)
   */
  public void createContents(Composite parent_p) {
    // Do create contents.
    doCreateContents(getToolkit(), parent_p, getInitialContent());
  }

  /**
   * Do create contents.
   * @param parent_p
   */
  protected abstract void doCreateContents(FormToolkit toolkit_p, Composite parent_p, Object initialContent_p);

  /**
   * @see org.eclipse.ui.forms.IPartSelectionListener#selectionChanged(org.eclipse.ui.forms.IFormPart, org.eclipse.jface.viewers.ISelection)
   */
  public void selectionChanged(IFormPart part_p, ISelection selection_p) {
    if (part_p.equals(_masterPart) && (selection_p instanceof IStructuredSelection)) {
      handleSelectionChanged((IStructuredSelection) selection_p);
    }
  }

  /**
   * Selection has changed, refresh content if needed.
   * @param selection_p
   */
  protected void handleSelectionChanged(IStructuredSelection selection_p) {
    // Default implementation does nothing.
  }
  
}
