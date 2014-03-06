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

package org.eclipse.egf.pattern.ui.editors.wizards.pages;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ChooseMethodCallPage extends ChooseCallPage {

    public ChooseMethodCallPage(Pattern pattern, ISelection selection, Object item) {
        super(pattern, selection, item);
    }

    @Override
    protected Table createParentTable() {
        return new Table(_container, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
    }

}
