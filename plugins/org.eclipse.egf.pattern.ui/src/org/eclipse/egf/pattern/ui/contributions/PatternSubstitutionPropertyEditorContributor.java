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

import org.eclipse.egf.core.ui.contributor.DefaultPropertyEditorContributor;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.Substitution;
import org.eclipse.egf.model.pattern.TypePatternSubstitution;
import org.eclipse.egf.pattern.ui.editors.providers.PatternElementLabelProvider;
import org.eclipse.egf.pattern.ui.editors.providers.PatternElementcontentProvider;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Thomas Guiu
 * 
 */
public class PatternSubstitutionPropertyEditorContributor extends DefaultPropertyEditorContributor {

    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        return checkFeature(object, descriptor, PatternPackage.Literals.TYPE_PATTERN_SUBSTITUTION__SUBSTITUTIONS) && object instanceof TypePatternSubstitution;
    }

    public CellEditor createPropertyEditor(final Composite composite, Object object, IItemPropertyDescriptor descriptor) {

        final TypePatternSubstitution value = (TypePatternSubstitution) object;
        return new ExtendedDialogCellEditor(composite, getLabelProvider(object, descriptor)) {
            protected Object openDialogBox(Control cellEditorWindow) {
                IStructuredContentProvider contentProvider = new PatternElementcontentProvider();
                IBaseLabelProvider labelProvider = new PatternElementLabelProvider();
                EList<Substitution> substitutions = new BasicEList<Substitution>();
                Substitution newSubstitution = PatternFactory.eINSTANCE.createSubstitution();
                URI uri = URI.createPlatformPluginURI("org.eclipse.egf.example.strategy.modeldriven/default.fcore#_RzMnwPuUEd6-V5xjQsdIkw", false);
                EObject toSubstitute = value.eResource().getResourceSet().getEObject(uri, true);
                EObject eObject = value.eResource().getEObject("_QXb_oEO6Ed-eQLst0bhiHw");

                substitutions.add(newSubstitution);
                newSubstitution.setOutgoing((Pattern) toSubstitute);
                newSubstitution.getIncoming().add((Pattern) eObject);
                MessageDialog.openInformation(composite.getShell(), "Substitution", "done!");
                return substitutions;
            }
        };
    }
}
