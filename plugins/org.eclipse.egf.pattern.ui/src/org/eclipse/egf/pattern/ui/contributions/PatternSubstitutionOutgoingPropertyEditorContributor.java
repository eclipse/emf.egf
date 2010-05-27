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

package org.eclipse.egf.pattern.ui.contributions;

import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.dialogs.PatternSelectionDialog;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternSubstitutionOutgoingPropertyEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, PatternPackage.Literals.SUBSTITUTION__OUTGOING) && object instanceof Substitution;
    }

    public CellEditor createPropertyEditor(final Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final Substitution value = (Substitution) object;
        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {
            protected Object openDialogBox(Control cellEditorWindow) {

                PatternSelectionDialog dialog = new PatternSelectionDialog(new Shell(), value.getOutgoing());
                dialog.setTitle(Messages.SpecificationPage_browse_dialog_title);
                if (dialog.open() == Window.OK) {
                    return dialog.getCurrentPattern();
                }
                return null;
            }
        };
    }

}