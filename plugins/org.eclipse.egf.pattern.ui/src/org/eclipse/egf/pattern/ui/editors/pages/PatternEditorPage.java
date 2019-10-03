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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.editors.PatternEditor;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class PatternEditorPage extends FormPage {

    protected final DataBindingContext ctx = new EMFDataBindingContext();

    private final List<Binding> bindings = new ArrayList<Binding>();

    public PatternEditorPage(FormEditor editor, String id, String title) {
        super(editor, id, title);

    }

    protected Pattern getPattern() {
        return ((PatternEditorInput) getEditorInput()).getPattern();
    }

    protected void execute(Command cmd) {
        getEditingDomain().getCommandStack().execute(cmd);
    }

    protected TransactionalEditingDomain getEditingDomain() {
        return ((PatternEditor) getEditor()).getEditingDomain();
    }

    @Override
    protected final void createFormContent(IManagedForm managedForm) {
        doCreateFormContent(managedForm);
        bind();
    }

    protected void addBinding(Binding binding) {
        bindings.add(binding);
    }

    protected boolean isReadOnly() {
        return ((PatternEditorInput) getEditorInput()).isReadOnly();
    }

    protected abstract void checkReadOnlyModel();

    protected abstract void bind();

    protected abstract void doCreateFormContent(IManagedForm managedForm);

    public final void rebind(PatternEditorInput editorInput) {
        setInput(editorInput);
        if (bindings.isEmpty() == false) {
            ctx.getValidationRealm().asyncExec(new Runnable() {

                public void run() {
                    for (Binding binding : bindings) {
                        ctx.removeBinding(binding);
                    }
                    bindings.clear();
                    bind();
                }

            });
        }
    }

}
