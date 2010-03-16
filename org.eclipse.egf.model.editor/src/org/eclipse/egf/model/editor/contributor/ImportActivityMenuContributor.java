/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.model.editor.contributor;

import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.core.ui.contributor.MenuContributor;
import org.eclipse.egf.model.editor.l10n.ModelEditorMessages;
import org.eclipse.egf.model.editor.wizards.ImportActivityWizard;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;

/**
 * @author Xavier Maysonnave
 * 
 */
public class ImportActivityMenuContributor extends MenuContributor {

  public static final String IMPORT_ACTIVITY_ACTION_ID = "import-activity"; //$NON-NLS-1$  

  private final ImportActivityAction importActivityContractAction = new ImportActivityAction();

  @Override
  public void menuAboutToShow(IMenuManager menuManager) {
    IStructuredSelection selection2 = (IStructuredSelection) selection;
    if (selection2.size() == 1) {
      if (selection2.getFirstElement() instanceof ProductionPlan || selection2.getFirstElement() instanceof ProductionPlanInvocation) {
        importActivityContractAction.setEnabled(importActivityContractAction.isEnabled());
        menuManager.insertBefore(EGFCommonUIConstants.OPEN_MENU_GROUP, importActivityContractAction);
      }
    }
  }

  private class ImportActivityAction extends Action {

    public ImportActivityAction() {
      super(ModelEditorMessages.ActivityMenuContributor_importAction_label);
      setId(IMPORT_ACTIVITY_ACTION_ID);
    }

    @Override
    public boolean isEnabled() {
      EObject eObject = getEObject();
      if (eObject == null) {
        return false;
      }
      EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
      if (eObject.eResource() == null || domain == null) {
        return false;
      }
      if (domain.isReadOnly(eObject.eResource())) {
        return false;
      }
      return true;
    }

    protected EObject getEObject() {
      if (selection == null) {
        return null;
      }
      IStructuredSelection sselection = (IStructuredSelection) selection;
      if (sselection.size() != 1) {
        return null;
      }
      Object object = sselection.getFirstElement();
      if (object instanceof ProductionPlan) {
        return (ProductionPlan) object;
      } else if (object instanceof ProductionPlanInvocation) {
        return (ProductionPlanInvocation) object;
      }
      return null;
    }

    @Override
    public void run() {
      EObject eObject = getEObject();
      if (eObject == null) {
        return;
      }
      // Instantiates and initializes the wizard
      ImportActivityWizard wizard = new ImportActivityWizard();
      wizard.init(activeEditorPart.getSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection) selection);
      // Instantiates the wizard container with the wizard and opens it
      WizardDialog dialog = new WizardDialog(activeEditorPart.getSite().getShell(), wizard);
      dialog.create();
      dialog.open();
    }

  }

}
