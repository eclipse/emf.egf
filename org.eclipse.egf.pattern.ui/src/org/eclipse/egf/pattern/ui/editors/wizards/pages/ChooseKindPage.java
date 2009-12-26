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

package org.eclipse.egf.pattern.ui.editors.wizards.pages;

import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author xrchen
 * 
 */
public class ChooseKindPage extends WizardPage {

    private CallTypeEnum selectedKind;

    private CallTypeEnum defaultKind = CallTypeEnum.Add;

    private Button methodCall;

    private Button patternCall;

    private Button patternInjectedCall;

    private Button superPatternCall;

    private Label label;

    public ChooseKindPage(ISelection selection, CallTypeEnum defaultKind) {
        super(Messages.ChooseKindPage_title);
        setTitle(Messages.ChooseKindPage_title);
        setDescription(Messages.ChooseKindPage_description);
        this.defaultKind = defaultKind;
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);

        label = new Label(container, SWT.NONE);
        label.setText(Messages.ChooseKindPage_label_text);

        methodCall = new Button(container, SWT.RADIO);
        methodCall.setText(Messages.ChooseKindPage_radio_methodCall);
        methodCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                selectedKind = CallTypeEnum.METHOD_CALL;
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        patternCall = new Button(container, SWT.RADIO);
        patternCall.setText(Messages.ChooseKindPage_radio_patternCall);
        patternCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                selectedKind = CallTypeEnum.PATTERN_CALL;
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        patternInjectedCall = new Button(container, SWT.RADIO);
        patternInjectedCall.setText(Messages.ChooseKindPage_radio_patternInjectedCall);
        patternInjectedCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                selectedKind = CallTypeEnum.PATTERNINJECTED_CALL;
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        superPatternCall = new Button(container, SWT.RADIO);
        superPatternCall.setText(Messages.ChooseKindPage_radio_superPatternCall);
        superPatternCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                selectedKind = CallTypeEnum.SUPERPATTERN_CALL;
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        setDefaultSelection();

        setControl(container);
    }

    /**
     * If to edit the call, get the default selection of kind of call.
     */
    private void setDefaultSelection() {
        if (defaultKind != CallTypeEnum.Add) {
            label.setEnabled(false);
            methodCall.setEnabled(false);
            patternCall.setEnabled(false);
            patternInjectedCall.setEnabled(false);
            superPatternCall.setEnabled(false);
            selectedKind = defaultKind;
            switch (selectedKind) {
            case METHOD_CALL:
                methodCall.setSelection(true);
                break;
            case PATTERN_CALL:
                patternCall.setSelection(true);
                break;
            case PATTERNINJECTED_CALL:
                patternInjectedCall.setSelection(true);
                break;
            case SUPERPATTERN_CALL:
                superPatternCall.setSelection(true);
                break;
            }
        }
    }

    public CallTypeEnum getKind() {
        return selectedKind;
    }

}
