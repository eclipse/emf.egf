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

package org.eclipse.egf.pattern.ui.editors.dialogs;

import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.egf.pattern.ui.editors.wizards.OpenTypeWizard;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.internal.core.BinaryType;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

@SuppressWarnings("restriction")
public class VariablesEditDialog extends SelectionStatusDialog {

    private Text nameText;

    private Text typeText;

    private String name;

    private String typeName;

    private String type;

    private TransactionalEditingDomain editingDomain;

    public VariablesEditDialog(Shell shell, Object selectItem, TransactionalEditingDomain editingDomain) {
        super(shell);
        this.editingDomain = editingDomain;
        setDefaultValue(selectItem);
    }

    private void setDefaultValue(Object selectItem) {
        if (selectItem instanceof PatternVariable) {
            PatternVariable PatternVariable = (PatternVariable) selectItem;
            type = PatternVariable.getType();
            setValue(PatternVariable);
        } else if (selectItem instanceof PatternParameter) {
            PatternParameter patternParameter = (PatternParameter) selectItem;
            type = patternParameter.getType();
            setValue(patternParameter);
        }
    }

    private void setValue(ModelElement selection) {
        name = selection.getName();
        typeName = ParametersTableLabelProvider.getType(type);
    }

    protected Control createDialogArea(Composite parent) {
        Composite dialogArea = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        dialogArea.setLayout(layout);

        createLabel(dialogArea, Messages.ParametersEditDialog_Name);
        nameText = new Text(dialogArea, SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        nameText.setLayoutData(gd);
        nameText.setText(name);
        nameText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                name = nameText.getText();
            }
        });

        createLabel(dialogArea, Messages.ParametersEditDialog_Type);
        typeText = new Text(dialogArea, SWT.READ_ONLY | SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        typeText.setLayoutData(gd);
        typeText.setText(typeName);
        typeText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                typeName = typeText.getText();
            }
        });
        Button typeButton = new Button(dialogArea, SWT.PUSH);
        gd = new GridData();
        typeButton.setLayoutData(gd);
        typeButton.setText(Messages.ParametersEditDialog_Browse);
        typeButton.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                OpenTypeWizard wizard = new OpenTypeWizard(editingDomain, type);
                wizard.init(PlatformUI.getWorkbench(), null);
                WizardDialog dialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
                int returnValue = dialog.open();
                if (Window.OK == returnValue) {
                    Object selectType = wizard.getSelectType();
                    if (selectType instanceof String) {
                        if (selectType != null && !"".equals(selectType)) {
                            type = (String) selectType;
                            typeText.setText(ParametersTableLabelProvider.getType(type));
                        }
                    } else if (selectType instanceof BinaryType) {
                        if (selectType != null) {
                            type = ((BinaryType) selectType).getFullyQualifiedName();
                            typeText.setText(((BinaryType) selectType).getElementName());
                        }
                    }
                }

            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        return dialogArea;
    }

    public static Label createLabel(Composite parent, String content) {
        Label label = new Label(parent, SWT.NONE);
        label.setText(content);
        return label;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    protected void computeResult() {
    }

}
