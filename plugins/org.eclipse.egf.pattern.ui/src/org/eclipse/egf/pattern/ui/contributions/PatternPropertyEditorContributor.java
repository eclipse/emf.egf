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

package org.eclipse.egf.pattern.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.TypePatternList;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.editors.dialogs.ListBuilderDialog;
import org.eclipse.egf.pattern.ui.editors.providers.PatternElementLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.PatternElementcontentProvider;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternPropertyEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, PatternPackage.Literals.TYPE_PATTERN_LIST__ELEMENTS) && object instanceof TypePatternList;
    }

    public CellEditor createPropertyEditor(final Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final TypePatternList value = (TypePatternList) object;
        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {
            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                IStructuredContentProvider contentProvider = new PatternElementcontentProvider();
                IBaseLabelProvider labelProvider = new PatternElementLabelProvider();

                List<PatternElement> possibleValues = new ArrayList<PatternElement>(PatternHelper.createCollector().getAllLibraries());
                List<PatternElement> initialValues = new ArrayList<PatternElement>(value.getElements());
                ListBuilderDialog<PatternElement> dialog = new ListBuilderDialog<PatternElement>(composite.getShell(), contentProvider, labelProvider, possibleValues, initialValues);
                if (dialog.open() == Window.OK) {
                    return dialog.getResult();
                }
                return null;
            }
        };
    }
}
