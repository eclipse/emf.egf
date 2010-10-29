/**
 * <copyright>
 * 
 * Copyright (c) 2002-2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * Xavier Maysonnave - Thales Corporate Services S.A.S - Target Platform contribution
 * 
 * </copyright>
 * 
 * $Id: EcoreActionBarContributor.java,v 1.19 2008/12/22 14:25:27 emerks Exp $
 */
package org.eclipse.emf.codegen.ecore.genmodel.presentation;

import org.eclipse.emf.codegen.ecore.genmodel.provider.GenModelEditPlugin;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

/**
 * This is the action bar contributor for the GenModel model editor.
 */
public class TargetPlatformGenModelActionBarContributor extends GenModelActionBarContributor {

    /**
     * This creates an instance of the contributor.
     */
    public TargetPlatformGenModelActionBarContributor() {
        super();
    }

    /**
     * This adds menu contributions for the generate actions.
     */
    @Override
    public void contributeToMenu(IMenuManager menuManager) {
        generateMenuManager = new MenuManager(GenModelEditPlugin.INSTANCE.getString("_UI_Generate_menu"), "org.eclipse.emf.codegen.ecore.targetPlatformGenmodelMenuID"); //$NON-NLS-1$ //$NON-NLS-2$
        menuManager.insertAfter("additions", generateMenuManager); //$NON-NLS-1$
        generateMenuManager.add(new Separator("annotation-actions")); //$NON-NLS-1$
        generateMenuManager.add(showGenAnnotationsAction);
        generateMenuManager.add(new Separator("global-actions")); //$NON-NLS-1$
    }

    /**
     * This populates the pop-up menu before it appears.
     */
    @Override
    public void menuAboutToShow(IMenuManager menuManager) {

        // Add our standard marker.
        //
        if ((style & ADDITIONS_LAST_STYLE) == 0) {
            menuManager.add(new Separator("additions")); //$NON-NLS-1$
        }
        menuManager.add(new Separator("edit")); //$NON-NLS-1$

        // Add the edit menu actions.
        //
        menuManager.add(new ActionContributionItem(undoAction));
        menuManager.add(new ActionContributionItem(redoAction));
        menuManager.add(new Separator());
        menuManager.add(new ActionContributionItem(cutAction));
        menuManager.add(new ActionContributionItem(copyAction));
        menuManager.add(new ActionContributionItem(pasteAction));
        menuManager.add(new Separator());
        menuManager.add(new ActionContributionItem(deleteAction));
        menuManager.add(new Separator());

        if ((style & ADDITIONS_LAST_STYLE) != 0) {
            menuManager.add(new Separator("additions")); //$NON-NLS-1$
            menuManager.add(new Separator());
        }
        // Add our other standard marker.
        //
        menuManager.add(new Separator("additions-end")); //$NON-NLS-1$

        addGlobalActions(menuManager);

        refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());

        menuManager.insertBefore("edit", new Separator("open-actions")); //$NON-NLS-1$ //$NON-NLS-2$
        menuManager.insertAfter("open-actions", openGenModelAction); //$NON-NLS-1$
        menuManager.insertAfter("open-actions", openEcoreAction); //$NON-NLS-1$

        if (showGenAnnotationsAction.isChecked()) {
            menuManager.insertBefore("edit", new Separator("annotation-actions")); //$NON-NLS-1$ //$NON-NLS-2$
            if (addDetailAction.isEnabled())
                menuManager.insertAfter("annotation-actions", addDetailAction); //$NON-NLS-1$
            if (annotateAction.isEnabled())
                menuManager.insertAfter("annotation-actions", annotateAction); //$NON-NLS-1$
        }
    }

}
