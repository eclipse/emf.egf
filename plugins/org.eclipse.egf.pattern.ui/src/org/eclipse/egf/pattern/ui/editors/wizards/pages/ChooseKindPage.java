/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.wizards.pages;

import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ChooseKindPage extends WizardPage {

    private CallTypeEnum _selectedKind;

    private Button _methodCall;

    private Button _patternCall;

    private Button patternInjectedCall;

    private Button _superPatternCall;

    private Button _strategyCall;

    public ChooseKindPage(ISelection selection) {
        super(Messages.ChooseKindPage_title);
        setTitle(Messages.ChooseKindPage_title);
        setDescription(Messages.ChooseKindPage_description);
    }

    public void createControl(Composite parent) {

        Composite container = new Composite(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 1;
        container.setLayoutData(gd);
        GridLayout layout = new GridLayout(1, false);
        container.setFont(parent.getFont());
        container.setLayout(layout);

        Group group = new Group(container, SWT.NONE);
        group.setLayout(new GridLayout(1, false));
        group.setText(Messages.ChooseKindPage_label_text);
        group.setFont(parent.getFont());
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 1;
        group.setLayoutData(gd);

        _methodCall = new Button(group, SWT.RADIO);
        _methodCall.setText(Messages.ChooseKindPage_radio_methodCall);
        _selectedKind = CallTypeEnum.METHOD_CALL;
        _methodCall.setSelection(true);
        _methodCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                _selectedKind = CallTypeEnum.METHOD_CALL;
                getContainer().updateButtons();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        _patternCall = new Button(group, SWT.RADIO);
        _patternCall.setText(Messages.ChooseKindPage_radio_patternCall);
        _patternCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                _selectedKind = CallTypeEnum.PATTERN_CALL;
                getContainer().updateButtons();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        patternInjectedCall = new Button(group, SWT.RADIO);
        patternInjectedCall.setText(Messages.ChooseKindPage_radio_patternInjectedCall);
        patternInjectedCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                _selectedKind = CallTypeEnum.PATTERNINJECTED_CALL;
                getContainer().updateButtons();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        _superPatternCall = new Button(group, SWT.RADIO);
        _superPatternCall.setText(Messages.ChooseKindPage_radio_superPatternCall);
        _superPatternCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                _selectedKind = CallTypeEnum.SUPERPATTERN_CALL;
                getContainer().updateButtons();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        _strategyCall = new Button(group, SWT.RADIO);
        _strategyCall.setText(Messages.ChooseKindPage_radio_backCall);
        _strategyCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                _selectedKind = CallTypeEnum.BACK_CALL;
                getContainer().updateButtons();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
                // Nothing to do
            }

        });

        setControl(container);
    }

    @Override
    public IWizardPage getNextPage() {
        return super.getNextPage();
    }

    public CallTypeEnum getKind() {
        return _selectedKind;
    }

}
