/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.workbench.perspective;

import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.egf.core.ui.workbench.views.explorer.FactoryComponentProjectExplorer;
import org.eclipse.egf.core.ui.workbench.views.fc.InstalledFactoryComponentView;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.progress.IProgressConstants;


public class EgfPerspective implements IPerspectiveFactory {
  /**
   * Identifier to the MDSoFA perspective.
   */
  public static final String PERSPECTIVE_ID = "org.eclipse.egf.core.ui.workbench.perspective"; //$NON-NLS-1$

  /**
   * Tag for the bottom center editor folder.
   */
  private static final String BOTTOM_CENTER_EDITOR = "bottom"; //$NON-NLS-1$
  /**
   * Tag for the top left folder.
   */
  private static final String TOP_LEFT = "topLeft"; //$NON-NLS-1$
  /**
   * Tag for the bottom left folder.
   */
  private static final String BOTTOM_LEFT = "bottomLeft"; //$NON-NLS-1$

  /**
   * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
   */
  public void createInitialLayout(IPageLayout layout_p) {
    String editorArea = layout_p.getEditorArea();
    // Top left folder.
    IFolderLayout topLeftFolder = layout_p.createFolder(TOP_LEFT, IPageLayout.LEFT, 0.25f, editorArea);
    topLeftFolder.addView(JavaUI.ID_PACKAGES);
    topLeftFolder.addView(JavaUI.ID_TYPE_HIERARCHY);
    topLeftFolder.addPlaceholder(IPageLayout.ID_RES_NAV);
    // Bottom left folder.
    IFolderLayout bottomLeftFolderFolder = layout_p.createFolder(BOTTOM_LEFT, IPageLayout.BOTTOM, 0.5f, TOP_LEFT);
    bottomLeftFolderFolder.addView(IPageLayout.ID_OUTLINE);
    bottomLeftFolderFolder.addView(IPageLayout.ID_PROP_SHEET);
    // Bottom center folder.
    IFolderLayout bottomCenterFolder = layout_p.createFolder(BOTTOM_CENTER_EDITOR, IPageLayout.BOTTOM, 0.66f, editorArea);
    // MDSofa Views.
    bottomCenterFolder.addView(FactoryComponentProjectExplorer.VIEW_ID);
    bottomCenterFolder.addView(InstalledFactoryComponentView.VIEW_ID);
    // Classic views.
    bottomCenterFolder.addView(IPageLayout.ID_PROBLEM_VIEW);
    bottomCenterFolder.addView(JavaUI.ID_JAVADOC_VIEW);
    bottomCenterFolder.addPlaceholder(IPageLayout.ID_BOOKMARKS);
    bottomCenterFolder.addPlaceholder(IProgressConstants.PROGRESS_VIEW_ID);
    // Views - java & MDSoFa
    layout_p.addShowViewShortcut(JavaUI.ID_PACKAGES);
    layout_p.addShowViewShortcut(JavaUI.ID_TYPE_HIERARCHY);
    layout_p.addShowViewShortcut(FactoryComponentProjectExplorer.VIEW_ID);
    layout_p.addShowViewShortcut(InstalledFactoryComponentView.VIEW_ID);
    // views - standard workbench
    layout_p.addShowViewShortcut(IPageLayout.ID_OUTLINE);
    layout_p.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
    layout_p.addShowViewShortcut(IPageLayout.ID_RES_NAV);
    layout_p.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
    layout_p.addShowViewShortcut(IProgressConstants.PROGRESS_VIEW_ID);
    // New actions - Java & MDSoFa project creation wizard
    layout_p.addNewWizardShortcut("org.eclipse.egf.core.ui.workbench.NewAssetProjectWizard"); //$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.JavaProjectWizard"); //$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewPackageCreationWizard"); //$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewClassCreationWizard"); //$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewInterfaceCreationWizard"); //$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewEnumCreationWizard"); //$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewAnnotationCreationWizard"); //$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSourceFolderCreationWizard"); //$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.jdt.ui.wizards.NewSnippetFileCreationWizard"); //$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");//$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");//$NON-NLS-1$
    layout_p.addNewWizardShortcut("org.eclipse.ui.editors.wizards.UntitledTextFileWizard");//$NON-NLS-1$
    // Action sets.
    layout_p.addActionSet(IDebugUIConstants.LAUNCH_ACTION_SET);
    layout_p.addActionSet(JavaUI.ID_ACTION_SET);
    layout_p.addActionSet(JavaUI.ID_ELEMENT_CREATION_ACTION_SET);
    layout_p.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
    // Add perspectives shortcuts.
    layout_p.addPerspectiveShortcut(PERSPECTIVE_ID);
    layout_p.addPerspectiveShortcut(JavaUI.ID_PERSPECTIVE);
  }
}
