/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.editor.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.common.ui.helper.EditorHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.transaction.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.action.Action;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcorePropertySheetPage extends ExtendedPropertySheetPage {

  protected class FcoreLocateValueAction extends Action {

    public FcoreLocateValueAction() {
      setText(EMFEditUIPlugin.INSTANCE.getString("_UI_LocateValue_action")); //$NON-NLS-1$
      setToolTipText(EMFEditUIPlugin.INSTANCE.getString("_UI_LocateValue_action_tool_tip")); //$NON-NLS-1$
      setImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(EMFEditUIPlugin.INSTANCE.getImage("full/elcl16/LocateValue"))); //$NON-NLS-1$
      setDisabledImageDescriptor(ExtendedImageRegistry.INSTANCE.getImageDescriptor(EMFEditUIPlugin.INSTANCE.getImage("full/dlcl16/LocateValue"))); //$NON-NLS-1$
    }

    @Override
    public void run() {
      // Process Selection
      Map<Resource, List<EObject>> resources = new HashMap<Resource, List<EObject>>();
      for (Object object : objectsToSelect) {
        EObject eObject = (EObject) editingDomain.getWrapper(object);
        Resource resource = eObject.eResource();
        if (resource != null) {
          List<EObject> eObjects = resources.get(resource);
          if (eObjects == null) {
            eObjects = new ArrayList<EObject>();
            resources.put(resource, eObjects);
          }
          eObjects.add(eObject);
        }
      }
      // Open and select
      EditorHelper.openEditorsAndSelect(resources);
    }
  }

  /**
   * Initializes me with the editing domain in which I create transactions.
   * 
   * @param editingDomain
   *          my editing domain
   */
  public FcorePropertySheetPage(AdapterFactoryEditingDomain editingDomain) {
    super(editingDomain);
    locateValueAction = new FcoreLocateValueAction();
  }

}
