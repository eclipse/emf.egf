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

package org.eclipse.egf.pattern.ui.editors.pages;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

/**
 * @author Thomas Guiu
 * 
 */
public class OverviewPage extends PatternEditorPage {

    public static final String ID = "OverviewPage";

    private Text text;

    private Text label;

    public OverviewPage(FormEditor editor) {
        super(editor, ID, Messages.OverviewPage_title);

    }

    protected void doCreateFormContent(IManagedForm managedForm) {
        FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();
        form.getBody().setLayout(new GridLayout());

        text = toolkit.createText(form.getBody(), getPattern().getName(), SWT.BORDER);
        text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    }

    void bindName() {
        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), FcorePackage.Literals.MODEL_ELEMENT__NAME);
        IWidgetValueProperty textProp = WidgetProperties.text(SWT.Modify);
        IObservableValue uiObs = textProp.observeDelayed(400, text);
        IObservableValue mObs = mprop.observe(getPattern());

        addBinding(ctx.bindValue(uiObs, mObs, new EMFUpdateValueStrategy().setBeforeSetValidator(new IValidator() {

            public IStatus validate(Object value) {

                return Status.OK_STATUS;
            }
        }), null));
    }

    @Override
    protected void bind() {
        bindName();
    }
}
