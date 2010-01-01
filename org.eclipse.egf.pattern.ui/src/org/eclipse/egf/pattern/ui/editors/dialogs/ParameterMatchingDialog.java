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

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

public class ParameterMatchingDialog extends SelectionStatusDialog {

    public ParameterMatchingDialog(Shell parent) {
        super(parent);
        
    }
    
    protected Control createDialogArea(Composite parent) {
        Composite dialogArea = (Composite) super.createDialogArea(parent);
        GridLayout layout = new GridLayout(2,true);
        dialogArea.setLayout(layout);
        
        // TODO:0001091 Issue.
        createCallerArea(dialogArea);
        createCalleeArea(dialogArea);
        
        return dialogArea;
    }
    
    private void createCallerArea(Composite dialogArea) {
//        Composite callerArea = new Composite(dialogArea, SWT.NONE);
//        GridLayout layout = new GridLayout();
//        callerArea.setLayout(layout);
        
    }

    private void createCalleeArea(Composite dialogArea) {
    }

    private Label createPatternNameLabel(Composite container){
        return null;
    }
    
    private TableViewer createParameterTable(Composite container){
        return null;
    }
    
    @Override
    protected void computeResult() {
    }

}
