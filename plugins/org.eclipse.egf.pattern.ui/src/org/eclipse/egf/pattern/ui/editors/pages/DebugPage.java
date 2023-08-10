/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.pages;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
public class DebugPage extends PatternEditorPage {

    public static final String ID = "OverviewPage"; //$NON-NLS-1$

    private Text text;

    private Text label;

    public DebugPage(FormEditor editor) {
        super(editor, ID, Messages.OverviewPage_title);
    }

    @Override
    protected void doCreateFormContent(IManagedForm managedForm) {
        FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();
        form.getBody().setLayout(new GridLayout());

        text = toolkit.createText(form.getBody(), getPattern().getName(), SWT.BORDER);
        text.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                Pattern pattern = getPattern();// pattern.eResource()
                // System.out.println("pattern = " + pattern + "\tresource = " +
                // pattern.eResource());
                // System.out.println("Parent is " + pattern.getSuperPattern()
                // == null ? "none" : pattern.getSuperPattern().getName()));
                System.out.println("Parent = " + pattern.getSuperPattern() + "\t"); //$NON-NLS-1$ //$NON-NLS-2$
                // String text2 = text.getText();
                // Command cmd = SetCommand.create(getEditingDomain(), pattern,
                // FcorePackage.Literals.MODEL_ELEMENT__NAME, text2);
                // if (cmd.canExecute()) {
                // execute(cmd);
                // }
            }

        });
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        text.setLayoutData(gd);

        label = toolkit.createText(form.getBody(), "", SWT.BORDER); //$NON-NLS-1$
        gd = new GridData(GridData.FILL_HORIZONTAL);
        label.setLayoutData(gd);

    }

    @Override
    protected void checkReadOnlyModel() {
        // Do nothing
    }

    protected void bindParentName() {
        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME);
        IWidgetValueProperty labelProp = WidgetProperties.text(SWT.Modify);
        IObservableValue uiObs = labelProp.observeDelayed(400, label);
        IObservableValue mObs = mprop.observe(getPattern().getSuperPattern());
        addBinding(ctx.bindValue(uiObs, mObs, new EMFUpdateValueStrategy().setBeforeSetValidator(new IValidator() {

            public IStatus validate(Object value) {

                return Status.OK_STATUS;
            }

        }), null));
    }

    protected void bindName() {
        IEMFEditValueProperty mprop = EMFEditProperties.value(getEditingDomain(), FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME);
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
        bindParentName();
    }

}
