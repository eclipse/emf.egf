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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jet.internal.editor.configuration.JETEditorPreferenceConstants;
import org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager;
import org.eclipse.jet.internal.editor.rules.WordListDetectorRule;
import org.eclipse.jet.taglib.TagLibrary;
import org.eclipse.jet.taglib.TagLibraryManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;

public class JETCustomTagScanner extends RuleBasedScanner {

	public JETCustomTagScanner(JETTokenStyleManager manager,
			IPreferenceStore preferenceStore) {
		IToken tagElementName = manager.requestToken(
				"__jet_custom_tag_elementName",
				JETEditorPreferenceConstants.JET_CUSTOM_TAG_FG_COLOR,
				JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR,
				JETEditorPreferenceConstants.JET_CUSTOM_TAG_BOLD,
				JETEditorPreferenceConstants.JET_CUSTOM_TAG_ITALIC, null,
				JETEditorPreferenceConstants.JET_CUSTOM_TAG_UNDERLINE);

		IToken string = manager.requestToken("__jet_custom_tag_string",
				PreferenceConstants.EDITOR_STRING_COLOR,
				JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR,
				PreferenceConstants.EDITOR_STRING_BOLD,
				PreferenceConstants.EDITOR_STRING_ITALIC, null,
				PreferenceConstants.EDITOR_STRING_UNDERLINE);

		Collection tagNames = new ArrayList();
		String[] tagLibIds = TagLibraryManager.getInstance()
				.getKnownLibraryIds();
		for (int i = 0; i < tagLibIds.length; i++) {
			String id = tagLibIds[i];
			TagLibrary tagLib = TagLibraryManager.getInstance().getTagLibrary(
					id, true);
			String[] names = tagLib.getTagNames();
			for (int j = 0; j < names.length; j++) {
				String name = names[j];
				tagNames.add(tagLib.getDefaultPrefix() + ":" + name);
			}
		}

		IRule[] rules = new IRule[3];

		// Add rule for double quotes
		rules[0] = new SingleLineRule("\"", "\"", string, '\\');
		// Add a rule for single quotes
		rules[1] = new SingleLineRule("'", "'", string, '\\');
		// Add a rule for the custom tag identifier
		rules[2] = new WordListDetectorRule(tagElementName, tagNames);

		setRules(rules);

		IToken defaultReturnToken = manager.requestToken("__jet_custom_tag",
				JETEditorPreferenceConstants.JET_CUSTOM_TAG_FG_COLOR,
				JETEditorPreferenceConstants.JET_DEFAULT_BG_COLOR, null, null,
				null, null);
		setDefaultReturnToken(defaultReturnToken);
	}
}
