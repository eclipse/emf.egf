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

    private int kind = 0;// 0:metodCall 1:patternCall 2:patternInjectedCall 3:superPatternCall
    
    private int defaultKind;
    
    public ChooseKindPage(ISelection selection, int defaultKind) {
        super("ChooseKind");
        setTitle("ChooseKind");
        setDescription("Choose a kind of call.");
        this.defaultKind = defaultKind;
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);

        Label label = new Label(container, SWT.NONE);
        label.setText("Please to choose the kind of call:");

        Button metodCall = new Button(container, SWT.RADIO);
        metodCall.setText("metodCall");
        metodCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                kind = 0;
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        Button patternCall = new Button(container, SWT.RADIO);
        patternCall.setText("patternCall");
        patternCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                kind = 1;
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        Button patternInjectedCall = new Button(container, SWT.RADIO);
        patternInjectedCall.setText("patternInjectedCall");
        patternInjectedCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                kind = 2;
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        Button superPatternCall = new Button(container, SWT.RADIO);
        superPatternCall.setText("superPatternCall");
        superPatternCall.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent e) {
                kind = 3;
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        if(defaultKind!= -1){
            metodCall.setEnabled(false);
            patternCall.setEnabled(false);
            patternInjectedCall.setEnabled(false);
            superPatternCall.setEnabled(false);
            kind = defaultKind;
            switch (kind) {
            case 0:
                metodCall.setFocus();
                break;
            case 1:
                patternCall.setFocus();
                break;
            case 2:
                patternInjectedCall.setFocus();
                break;
            case 3:
                superPatternCall.setFocus();
                break;
            }
        }
        setControl(container);
    }

    public int getKind() {
        return kind;
    }

}
