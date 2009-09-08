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
package org.eclipse.egf.core.ui.wizard.page;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.ui.helper.FieldEditorHelper;
import org.eclipse.egf.common.ui.toolkit.fields.IFieldEditor;
import org.eclipse.egf.core.ui.internal.help.IHelpContextIds;
import org.eclipse.egf.core.ui.wizard.Messages;
import org.eclipse.egf.model.ModelPackage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


/**
 * Base class to implement Domain wizard pages.
 * @author fournier
 */
public abstract class AbstractDomainWizardPage extends AbstractModelElementWizardPage {
  
  /**
   * Domain file extension.
   */
  private static final String DOMAIN_FILE_EXTENSION = "*.ecore"; //$NON-NLS-1$
  
  /**
   * Relative file path for the domain ecore file.
   */
  protected static final String DEFAULT_DOMAIN_FILE_NAME = "domain/domain.ecore"; //$NON-NLS-1$
  
  /**
   * Relative domain folder path where domain files are located.
   */
  protected static final String DOMAIN_RELATIVE_FOLDER_PATH = "model"; //$NON-NLS-1$
  
  /**
   * Field editor that contains the path.
   */
  private IFieldEditor _domainFileNameFieldEditor;

  /**
   * Constructor.
   * @param pageName_p
   */
  public AbstractDomainWizardPage(String pageName_p) {
    super(pageName_p);
  }

  /**
   * Constructor.
   * @param pageName_p
   * @param title_p
   * @param titleImage_p
   */
  public AbstractDomainWizardPage(String pageName_p, String title_p, ImageDescriptor titleImage_p) {
    super(pageName_p, title_p, titleImage_p);
  }

  /**
   * Return the default domain file path.<br>
   * The default domain file is located within the hosting project under model/domain/domain.ecore.
   * @return
   */
  protected String getDefaultDomainFilePath() {
    // Get the folder where domain files are located.
    IFolder domainFolder = getDomainFolder();
    IFile domainFile = domainFolder.getFile(DEFAULT_DOMAIN_FILE_NAME);
    // Removing the project folder to keep a coherence with what it is expected in plug-in file.
    IPath relativeDomainFilePath = domainFile.getFullPath().removeFirstSegments(1);
    return relativeDomainFilePath.toString();
  }

  /**
   * Create the field editor to enter the domain file name.
   * @param parent_p
   */
  protected void createDomainFileFieldEditor(Composite parent_p) {
    IFolder domainFolder = getDomainFolder();
    // Set initial Pattern
    String pattern = getDomainFileExtension();
    _domainFileNameFieldEditor = FieldEditorHelper.createDomainFieldEditor(
      parent_p, 
      Messages.NewDomainWizardPage_Domain_Title,
      Messages.EditDomainWizardPage_OpenResourceDialog_Title, 
      domainFolder, 
      pattern,
      isReadOnly()
    );
    // Domain path text
    Text domainPath = (Text) _domainFileNameFieldEditor.getValueControl();
    // Create the data binding between the text field and the related model element attribute.
    bindTextToAttribute(domainPath, ModelPackage.Literals.DOMAIN__PATH, getModelElement(), null);
  }

  /**
   * Return whether or not the selected Domain file exists.
   * @return
   */
  protected boolean isDomainSelectedExist() {
    boolean result = false;
    // The page is complete when file path entered exists.
    String relativeDomainPath = ((Text) getDomainFileNameFieldEditor().getValueControl()).getText();
    IJavaProject hostingProject = getHostingProject();
    if (null != hostingProject) {
      IProject containerProject = hostingProject.getProject();
      IFile domainFile = containerProject.getFile(relativeDomainPath);
      result = domainFile.exists();
    }
    return result;
  }

  /**
   * Return the folder where domain files are located.
   * @return
   */
  private IFolder getDomainFolder() {
    IFolder result = null;
    // Get hosting project.
    IJavaProject hostingProject = getHostingProject();
    if (null != hostingProject) {
      IProject project = hostingProject.getProject();
      result = project.getFolder(DOMAIN_RELATIVE_FOLDER_PATH);
      FileHelper.ensurePathAvailability(result.toString());
    }
    return result;
  }

  /**
   * Return the file extension of domain files.
   * @return
   */
  private String getDomainFileExtension() {
    return DOMAIN_FILE_EXTENSION;
  }

  /**
   * @see org.eclipse.egf.core.ui.wizard.page.AbstractModelElementWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return IHelpContextIds.NEW_DOMAIN_WIZARD_PAGE;
  }

  /**
   * Return the domain field editor.
   * @return the domainFileNameFieldEditor
   */
  protected IFieldEditor getDomainFileNameFieldEditor() {
    return _domainFileNameFieldEditor;
  }
  
}
