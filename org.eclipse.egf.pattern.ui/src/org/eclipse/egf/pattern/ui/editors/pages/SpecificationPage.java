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

import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.ui.forms.editor.FormEditor;

/**
 * @author Thomas Guiu
 * 
 */
public class SpecificationPage extends PatternEditorPage {
    public static final String ID = "SpecificationPage";

    public SpecificationPage(FormEditor editor) {
        super(editor, ID, Messages.SpecificationPage_title);

    }

}
