/*******************************************************************************
 * Copyright (c) 2005, 2007 ILOG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Joel Cheuoua - Initial API and implementation
 *******************************************************************************/
package org.eclipse.jet.internal.editor.scanners;

import org.eclipse.jet.internal.editor.configuration.JETEditorPreferenceConstants;
import org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.RuleBasedScanner;

public class JETCommentScanner extends RuleBasedScanner {

	public JETCommentScanner(JETTokenStyleManager manager, IPreferenceStore preferenceStore) {
    setDefaultReturnToken(manager.requestToken("__jet_comment", 
        JETEditorPreferenceConstants.JET_COMMENT_FG_COLOR, 
        JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR, 
        JETEditorPreferenceConstants.JET_COMMENT_BOLD, 
        JETEditorPreferenceConstants.JET_COMMENT_ITALIC, 
        null, 
        null));
	}
}
