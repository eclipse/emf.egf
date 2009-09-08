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

import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.widgets.FormToolkit;


/**
 * @author Guillaume Brocard
 */
public abstract class AbstractPatternBlock extends MasterDetailsBlock {
  /**
   * Pattern data.
   */
  private PatternData _patternData;
  /**
   * Master part.
   */
  private IFormPart _masterPart;

  /**
   * Set pattern data.
   * @param patternData_p
   */
  protected void setPatternData(PatternData patternData_p) {
    _patternData = patternData_p;
  }

  /**
   * Get master form part.
   * @return
   */
  protected IFormPart getMasterPart() {
    return _masterPart;
  }

  /**
   * @see org.eclipse.ui.forms.MasterDetailsBlock#createMasterPart(org.eclipse.ui.forms.IManagedForm, org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected void createMasterPart(final IManagedForm managedForm_p, Composite parent_p) {
    final Couple<Viewer, IFormPart> selectionCouple = doCreateMasterFormContent(managedForm_p.getToolkit(), parent_p, _patternData, managedForm_p);
    if (null != selectionCouple) {
      _masterPart = selectionCouple.getValue();
      // Add selection part.
      managedForm_p.addPart(_masterPart);
      // Register selection changed listener.
      selectionCouple.getKey().addSelectionChangedListener(new ISelectionChangedListener() {
        @SuppressWarnings("synthetic-access")
        public void selectionChanged(SelectionChangedEvent event_p) {
          managedForm_p.fireSelectionChanged(_masterPart, event_p.getSelection());
        }
      });
    }
  }

  /**
   * Do create master form content.
   * @param toolkit_p The managed form toolkit.
   * @param parent_p The shashed composite, used to display both master and details.
   * @param patternData_p The pattern data.
   * @param managedForm_p The owner of given parent composite.
   * @return the viewer which selection should be listened to, and its containing form part.
   */
  protected abstract Couple<Viewer, IFormPart> doCreateMasterFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p, IManagedForm managedForm_p);

  /**
   * @see org.eclipse.ui.forms.MasterDetailsBlock#createToolBarActions(org.eclipse.ui.forms.IManagedForm)
   */
  @Override
  protected void createToolBarActions(IManagedForm managedForm_p) {
    // No contribution to the tool bar.
  }
}
