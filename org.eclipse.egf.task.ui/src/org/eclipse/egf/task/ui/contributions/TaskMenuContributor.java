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

package org.eclipse.egf.task.ui.contributions;

import org.eclipse.egf.common.ui.constant.EGFCommonUIConstants;
import org.eclipse.egf.core.ui.contributor.MenuContributor;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.ftask.task.TaskHook;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * @author Thomas Guiu
 * 
 */
public class TaskMenuContributor extends MenuContributor {

  @Override
  public void menuAboutToShow(IMenuManager menuManager) {
    IStructuredSelection selection2 = (IStructuredSelection) selection;
    if (selection2.size() == 1) {
      if (selection2.getFirstElement() instanceof Activity) {
        IContributionItem item = menuManager.find(EGFCommonUIConstants.CREATE_SIBLING);
        MenuManager createSiblingMenuManager = null;
        if (item != null && item instanceof MenuManager) {
          createSiblingMenuManager = (MenuManager) item;
        } else {
          createSiblingMenuManager = new MenuManager(CoreUIMessages.MenuContributor_siblingChildGroup_label);
          menuManager.insertAfter(EGFCommonUIConstants.CREATE_CHILD, createSiblingMenuManager);
        }

        // TODO voir MultiRootTaskJavaCreateAction

        for (String kind : TaskHook.HELPER.getKinds()) {
          // createSiblingMenuManager.add(new
          // MultiRootTaskJavaCreateAction(activeEditorPart, new
          // StructuredSelection(domain.getParent(object))));

          // descriptor = new CommandParameter(null,
          // PatternPackage.Literals.PATTERN_LIBRARY__ELEMENTS,
          // FcoreFactory.eINSTANCE.createFactoryComponent());
          // createChildAction = new
          // CreateChildAction(activeEditorPart, selection,
          // descriptor);
          // createChildAction.setText("Task "+kind);
          // createChildAction.setImageDescriptor(ImageDescriptor.createFromURL(patternExtension.getImageURL()));
          // createSiblingMenuManager.add(createChildAction);

        }

      }
    }
  }

}
