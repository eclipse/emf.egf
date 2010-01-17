/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.pattern.jet.ui.editor;

import org.eclipse.jet.internal.editor.JETTextEditor;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class JetTextEditor extends JETTextEditor {

    public JetTextEditor() {
        super();
        setSourceViewerConfiguration(new JetSourceViewerConfigure(this));
        setDocumentProvider(new JetDocumentProvider(this));
    }
}
