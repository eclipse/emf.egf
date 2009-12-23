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
package org.eclipse.egf.pde.ui.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.core.helper.EclipseBuilderHelper;
import org.eclipse.egf.core.natures.FactoryComponentNatures;
import org.eclipse.egf.pde.EGFPDEPlugin;
import org.eclipse.egf.pde.internal.FactoryComponentGeneratorHelper;
import org.eclipse.egf.pde.internal.ui.wizard.page.FactoryComponentContentPage;
import org.eclipse.egf.pde.internal.ui.wizard.page.FactoryComponentTemplateListSelectionPage;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.pde.core.build.IBuildModelFactory;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;
import org.eclipse.pde.internal.ui.PDEPlugin;
import org.eclipse.pde.internal.ui.PDEUIMessages;
import org.eclipse.pde.internal.ui.elements.ElementList;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.NewWizard;
import org.eclipse.pde.internal.ui.wizards.WizardElement;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationOperation;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationPage;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData;
import org.eclipse.pde.ui.IPluginContentWizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;


/**
 * This wizard allows the end-user to create a new factory component project. <br>
 * This wizard is located in Eclipse workbench new menu entry.
 * @author fournier
 */
public class NewFactoryComponentProjectWizard extends NewWizard {
  
  /**
   * Factory component wizard id.
   */
  public final static String IMG_WIZARD_FACTORY_COMPONENT = "wizban/fc.gif"; //$NON-NLS-1$
  
  /**
   * Constant defining factory component content extension point id.
   */
  public static final String FACTORY_COMPONENT_CONTENT_EXTENSION_POINT_ID = "factoryComponentContent"; //$NON-NLS-1$
  
  /**
   * Constant defining factory component content wizard tag.
   */
  public static final String TAG_WIZARD = "wizard"; //$NON-NLS-1$
  
  /**
   * Constant defining the default factory component template used.
   */
  private static final String DEFAULT_FACTORY_COMPONENT_TEMPLATE_ID = "org.eclipse.egf.pde.emptyFactoryComponent"; //$NON-NLS-1$
  
  /**
   * Plug-in field data.
   */
  private PluginFieldData _pluginData;
  
  /**
   * Main page.
   */
  protected NewProjectCreationPage _mainPage;
  
  /**
   * FactoryComponent plug-in content page.
   */
  protected FactoryComponentContentPage _pluginContentPage;
  
  /**
   * FactoryComponent templates page.
   */
  protected FactoryComponentTemplateListSelectionPage _wizardListPage;

  /**
   * Project provider.
   */
  private IProjectProvider _projectProvider;
  private ElementList _availableContributedTemplateBasedWizards;

  /**
   * Constructor.
   */
  public NewFactoryComponentProjectWizard() {
    setDefaultPageImageDescriptor(EGFPDEPlugin.getDefault().getImageDescriptor(IMG_WIZARD_FACTORY_COMPONENT));
    setDialogSettings(PDEPlugin.getDefault().getDialogSettings());
    setWindowTitle(Messages.NewFactoryComponentProjectWizard_Title);
    setNeedsProgressMonitor(true);
    _pluginData = new PluginFieldData();
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#addPages()
   */
  @Override
  public void addPages() {
    // Create the main
    createMainPage();
    // Create plug-in content page.
    createPluginContentPage();
    // Create template wizard page.
    createTemplatePage();
  }

  protected void createTemplatePage() {
    _availableContributedTemplateBasedWizards = getAvailableCodegenWizards();
    _wizardListPage = new FactoryComponentTemplateListSelectionPage(
      _availableContributedTemplateBasedWizards, 
      _pluginContentPage, 
      PDEUIMessages.WizardListSelectionPage_templates
    );
    _wizardListPage.setInitialTemplateId(DEFAULT_FACTORY_COMPONENT_TEMPLATE_ID);
    addPage(_wizardListPage);
  }

  private ElementList getAvailableCodegenWizards() {
    ElementList wizards = new ElementList("AssetCodegenWizards"); //$NON-NLS-1$
    IConfigurationElement[] elements = ExtensionPointHelper.getConfigurationElements(
      EGFPDEPlugin.getDefault().getPluginID(), 
      FACTORY_COMPONENT_CONTENT_EXTENSION_POINT_ID
    );
    for (int j = 0; j < elements.length; j++) {
      if (elements[j].getName().equals(TAG_WIZARD)) {
        WizardElement element = createWizardElement(elements[j]);
        if (element != null) {
          wizards.add(element);
        }
      }
    }
    return wizards;
  }

  protected WizardElement createWizardElement(IConfigurationElement config) {
    String name = config.getAttribute(WizardElement.ATT_NAME);
    String id = config.getAttribute(WizardElement.ATT_ID);
    String className = config.getAttribute(WizardElement.ATT_CLASS);
    // Precondition.
    if (name == null || id == null || className == null)
      return null;
    WizardElement element = new WizardElement(config);
    String imageName = config.getAttribute(WizardElement.ATT_ICON);
    if (imageName != null) {
      String pluginID = config.getNamespaceIdentifier();
      Image image = PDEPlugin.getDefault().getLabelProvider().getImageFromPlugin(pluginID, imageName);
      element.setImage(image);
    }
    return element;
  }

  /**
   * Create the plug-in content page.
   */
  protected void createPluginContentPage() {
    _pluginContentPage = new FactoryComponentContentPage("FactoryComponentContentPage", _projectProvider, _mainPage, _pluginData); //$NON-NLS-1$
    addPage(_pluginContentPage);
  }

  /**
   * Create the main page.
   */
  protected void createMainPage() {
    _mainPage = new NewProjectCreationPage("NewProjectCreationPage", _pluginData, false, getSelection()) { //$NON-NLS-1$
      @Override
      public void createControl(Composite parent_p) {
        super.createControl(parent_p);
      }
    };
    _mainPage.setTitle(Messages.NewFactoryComponentProjectWizardMainPage_Title);
    _mainPage.setDescription(Messages.NewFactoryComponentProjectWizardMainPage_Description);
    addPage(_mainPage);

    _projectProvider = new IProjectProvider() {
      public String getProjectName() {
        return _mainPage.getProjectName();
      }
      public IProject getProject() {
        return _mainPage.getProjectHandle();
      }

      public IPath getLocationPath() {
        return _mainPage.getLocationPath();
      }
    };
  }
 
  /**
   * @see org.eclipse.jface.wizard.Wizard#canFinish()
   */
  @Override
  public boolean canFinish() {
    return super.canFinish() && getContainer().getCurrentPage() != _mainPage;
  }

  /**
   * @see org.eclipse.jface.wizard.Wizard#performFinish()
   */
  @Override
  public boolean performFinish() {
    boolean result = false;
    try {
      _mainPage.updateData();
      _pluginContentPage.updateData();
      IPluginContentWizard contentWizard = _wizardListPage.getSelectedWizard();
      // If template-based wizard is not used (ie contentWizard is null), select default one.
      if (contentWizard == null) {
        WizardElement defaultWizardElement = getWizardElement(_availableContributedTemplateBasedWizards, DEFAULT_FACTORY_COMPONENT_TEMPLATE_ID);
        contentWizard = (IPluginContentWizard) defaultWizardElement.createExecutableExtension();
        contentWizard.init(_pluginContentPage.getData());
      }
      // Let's create the stuffs.
      getContainer().run(
        false, 
        false, 
        new NewProjectCreationOperation(_pluginData, _projectProvider, contentWizard) {
          @Override
          protected void createSourceOutputBuildEntries(WorkspaceBuildModel model_p, IBuildModelFactory factory_p) throws CoreException {
            super.createSourceOutputBuildEntries(model_p, factory_p);
            // Add the 'generated' source folder in the source entry of the build.properties
            // Get the 'SOURCE.<LIBRARY_NAME>'
            String libraryName = _pluginData.getLibraryName();
            if (libraryName == null) {
              libraryName = String.valueOf(ICommonConstants.DOT_CHARACTER);
            }
            FactoryComponentGeneratorHelper.addGeneratedSourceFolderInLibrarySources(model_p, libraryName);
          }
          @Override
          protected void createContents(IProgressMonitor monitor_p, IProject project_p) throws CoreException, JavaModelException, InvocationTargetException, InterruptedException {
            super.createContents(monitor_p, project_p);
            // Check FactoryComponent Nature
            if (project_p.hasNature(FactoryComponentNatures.FACTORY_COMPONENT_NATURE) == false) {
              EclipseBuilderHelper.addNatureToProject(
                project_p, 
                FactoryComponentNatures.FACTORY_COMPONENT_NATURE, 
                null
              );
            }
          }          
        }
      );
      result = true;
    } catch (Exception e) {
      StringBuilder msg = new StringBuilder("NewFactoryComponentProjectWizard.performFinish(..) _ "); //$NON-NLS-1$
      EGFPDEPlugin.getDefault().log(msg.toString(), e);
      if (EGFPDEPlugin.getDefault().isDebugging()) {
        EGFConsolePlugin.getConsole().logThrowable(msg.toString(), e);
      }
    }
    return result;
  }

  /**
   * Get a wizard element for given id in given {@link ElementList} instance.
   * @param elementList_p
   * @param wizardElementId_p
   * @return null if not found.
   */
  public static WizardElement getWizardElement(ElementList elementList_p, String wizardElementId_p) {
    WizardElement result = null;
    // Get the children of the list.
    Object[] children = elementList_p.getChildren();
    // Loop over contained wizard elements to find the one for given id.
    for (int i = 0; i < children.length && (null == result); i++) {
      WizardElement currentWizardElement = (WizardElement) children[i];
      if (currentWizardElement.getID().equals(wizardElementId_p)) {
        result = currentWizardElement;
      }
    }
    return result;
  }

  /**
   * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  public void init(IWorkbench workbench_p, IStructuredSelection selection_p) {
    // Do nothing.
  }
  
}
