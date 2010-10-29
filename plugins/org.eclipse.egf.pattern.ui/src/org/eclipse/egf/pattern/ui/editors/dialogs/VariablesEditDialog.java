/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.dialogs;

import org.eclipse.egf.core.epackage.EObjectWrapper;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.egf.pattern.ui.editors.providers.ParametersTableLabelProvider;
import org.eclipse.egf.pattern.ui.editors.wizards.OpenTypeWizard;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IType;
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

/**
 * 
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class VariablesEditDialog extends SelectionStatusDialog {

    private Text _nameText;

    private Text _typeText;

    private String _name;

    private String _typeName;

    private String _type;

    private EObject _current;

    public VariablesEditDialog(Shell shell, Object selectItem) {
        super(shell);
        setDefaultValue(selectItem);
    }

    private void setDefaultValue(Object selectItem) {
        if (selectItem instanceof PatternVariable) {
            PatternVariable patternVariable = (PatternVariable) selectItem;
            _type = patternVariable.getType();
            _current = patternVariable;
            setValue(patternVariable);
        } else if (selectItem instanceof PatternParameter) {
            PatternParameter patternParameter = (PatternParameter) selectItem;
            _type = patternParameter.getType();
            _current = patternParameter;
            setValue(patternParameter);
        }
    }

    private void setValue(NamedModelElement selection) {
        _name = selection.getName();
        _typeName = ParametersTableLabelProvider.getType(_type);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        composite.setLayout(layout);

        createLabel(composite, Messages.ParametersEditDialog_Name);
        _nameText = new Text(composite, SWT.BORDER);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        _nameText.setLayoutData(gd);
        _nameText.setText(_name);
        _nameText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                _name = _nameText.getText();
            }

        });

        createLabel(composite, Messages.ParametersEditDialog_Type);
        _typeText = new Text(composite, SWT.READ_ONLY | SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        _typeText.setLayoutData(gd);
        _typeText.setText(_typeName);
        _typeText.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                _typeName = _typeText.getText();
            }

        });
        Button typeButton = new Button(composite, SWT.PUSH);
        gd = new GridData();
        typeButton.setLayoutData(gd);
        typeButton.setText(Messages.ParametersEditDialog_Browse);
        typeButton.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                OpenTypeWizard wizard = new OpenTypeWizard(_type, _current);
                wizard.init(PlatformUI.getWorkbench(), null);
                WizardDialog dialog = new WizardDialog(getShell(), wizard);
                if (dialog.open() == Window.OK) {
                    Object object = wizard.getSelectType();
                    if (object instanceof EObjectWrapper) {
                        _type = ((EObjectWrapper) object).getNsURI().toString();
                        _typeText.setText(ParametersTableLabelProvider.getType(_type));
                    } else if (object instanceof IType) {
                        _type = ((IType) object).getFullyQualifiedName();
                        _typeText.setText(((IType) object).getElementName());
                    }
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });
        return composite;
    }

    public static Label createLabel(Composite parent, String content) {
        Label label = new Label(parent, SWT.NONE);
        label.setText(content);
        return label;
    }

    public String getName() {
        return _name;
    }

    public String getType() {
        return _type;
    }

    @Override
    protected void computeResult() {
        // Nothing to do
    }

}
