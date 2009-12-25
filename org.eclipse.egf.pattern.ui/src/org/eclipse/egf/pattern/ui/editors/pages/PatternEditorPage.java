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

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.editors.PatternEditor;
import org.eclipse.egf.pattern.ui.editors.PatternEditorInput;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class PatternEditorPage extends FormPage {

    public PatternEditorPage(FormEditor editor, String id, String title) {
        super(editor, id, title);

    }

    protected Pattern getPattern() {
        return ((PatternEditorInput) getEditorInput()).getPattern();
    }

    public TransactionalEditingDomain getEditingDomain() {
        return ((PatternEditor) getEditor()).getEditingDomain();
    }

}
