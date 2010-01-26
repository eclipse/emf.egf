/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.pattern.ui.contributors;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.PatternEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author Thomas Guiu
 * 
 */
class EditHelper {
    public static void openEditor(IWorkbenchPage page, String patternId) {
        Pattern pattern = PatternHelper.TRANSACTIONNAL_COLLECTOR.getPattern(patternId);
        if (pattern == null)
            MessageDialog.openInformation(page.getWorkbenchWindow().getShell(), Messages.ViewpointContributor_missingPattern_title, Messages.ViewpointContributor_missingPattern_message);
        else
            PatternEditor.openEditor(page, pattern);
    }

}
