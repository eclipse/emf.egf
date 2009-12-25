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

import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * @author Thomas Guiu
 * 
 */
public class OverviewPage extends PatternEditorPage {

    public static final String ID = "OverviewPage";

    public OverviewPage(FormEditor editor) {
        super(editor, ID, Messages.OverviewPage_title);

    }

    protected void createFormContent(IManagedForm managedForm) {
        FormToolkit toolkit = managedForm.getToolkit();
        ScrolledForm form = managedForm.getForm();
        form.getBody().setLayout(new GridLayout());

        // form.setText("Hello");
        final Text text = toolkit.createText(form.getBody(), getPattern().getName(), SWT.BORDER);
        text.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                Pattern pattern = getPattern();

                String text2 = text.getText();
                Command cmd = SetCommand.create(getEditingDomain(), pattern, FcorePackage.eINSTANCE.getModelElement_Name(), text2);
                if (cmd.canExecute()) {
                    getEditingDomain().getCommandStack().execute(cmd);
                }
                // pattern.setName(text2);
                // firePropertyChange(IEditorPart.PROP_DIRTY);
            }
        });
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        text.setLayoutData(gd);

    }

    private void fillBody(IManagedForm managedForm, FormToolkit toolkit) {
        Composite body = managedForm.getForm().getBody();
        body.setLayout(new GridLayout());
        managedForm.addPart(new SectionPart(body, toolkit, Section.DESCRIPTION | ExpandableComposite.TITLE_BAR));
    }

}
