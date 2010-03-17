/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.model.editor.dialogs;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Thomas Guiu
 * 
 */
public class TaskSelectionDialog extends ActivitySelectionDialog {

    public TaskSelectionDialog(Shell parentShell, Resource context, Activity activity, boolean multipleSelection) {
        super(parentShell, context, activity, multipleSelection);

    }

    protected boolean selectElement(EObject eObject) {

        return eObject instanceof Task;
    }

}
