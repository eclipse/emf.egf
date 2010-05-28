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

package org.eclipse.egf.model.editor.dialogs;

import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Thomas Guiu
 * 
 */
public class FactoryComponentSelectionDialog extends ActivitySelectionDialog {

  public FactoryComponentSelectionDialog(Shell parentShell, Activity activity, boolean multipleSelection) {
    super(parentShell, activity, multipleSelection);
    setTitle(NLS.bind(CoreUIMessages._UI_GenericSelectionDialog_dialogTitle, FactoryComponent.class.getSimpleName()));
    setMessage(NLS.bind(CoreUIMessages._UI_GenericSelectionDialog_dialogMessage, FactoryComponent.class.getSimpleName()));
  }

  @Override
  protected boolean selectElement(EObject eObject) {
    return eObject instanceof FactoryComponent;
  }

}
