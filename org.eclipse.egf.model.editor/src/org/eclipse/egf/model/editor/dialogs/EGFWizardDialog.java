/**
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.editor.dialogs;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFWizardDialog extends WizardDialog {

  public EGFWizardDialog(Shell parentShell, IWizard newWizard) {
    super(parentShell, newWizard);
  }

  public void finishDialog() {
    finishPressed();
  }

}
