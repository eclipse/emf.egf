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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.ui.editors.dialogs.ListBuilderDialog;
import org.eclipse.egf.pattern.ui.editors.providers.PatternElementLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.PatternElementcontentProvider;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.EList;
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
public abstract class AbstractPatternListPropertyEditorContributor<E> extends DefaultPropertyEditorContributor {

    protected abstract EList<E> getElements(Object object);

    public final CellEditor createPropertyEditor(final Composite composite, final Object object, IItemPropertyDescriptor descriptor) {
        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {
            @Override
            protected Object openDialogBox(Control cellEditorWindow) {
                IStructuredContentProvider contentProvider = new PatternElementcontentProvider();
                IBaseLabelProvider labelProvider = new PatternElementLabelProvider();

                List<PatternLibrary> possibleValues = new ArrayList<PatternLibrary>(PatternHelper.createCollector().getAllLibraries());
                List<E> initialValues = new ArrayList<E>(getElements(object));
                ListBuilderDialog<E, PatternLibrary> dialog = new ListBuilderDialog<E, PatternLibrary>(composite.getShell(), contentProvider, labelProvider, possibleValues, initialValues);
                if (dialog.open() == Window.OK) {
                    return dialog.getResult();
                }
                return null;
            }
        };
    }
}
