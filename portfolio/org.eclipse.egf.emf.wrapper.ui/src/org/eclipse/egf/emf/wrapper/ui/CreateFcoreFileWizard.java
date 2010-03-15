package org.eclipse.egf.emf.wrapper.ui;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.egf.emf.wrapper.CreateFcoreUtil;
import org.eclipse.egf.model.fcore.presentation.FcoreModelWizard;
import org.eclipse.jface.wizard.IWizardPage;

public class CreateFcoreFileWizard extends FcoreModelWizard {

  private IFile _input;

  public CreateFcoreFileWizard(IFile input) {
    _input = input;
  }

  @Override
  public void addPage(IWizardPage page) {
    if (page == newFileCreationPage)
      super.addPage(page);
  }

  @Override
  public void addPages() {
    super.addPages();
    newFileCreationPage.setFileName(getFileName());
  }

  @Override
  public boolean performFinish() {
    try {
      new CreateFcoreUtil().createFcoreFile(_input, getFcoreFullPath());
      return true;
    } catch (IOException ioe) {
      Activator.getDefault().logError(ioe);
    }
    return false;
  }

  private String getFileName() {
    return _input.getFullPath().removeFileExtension().addFileExtension(FILE_EXTENSIONS.get(0)).lastSegment();
  }

  private IPath getFcoreFullPath() {
    return newFileCreationPage.getContainerFullPath().append(newFileCreationPage.getFileName());
  }

}
