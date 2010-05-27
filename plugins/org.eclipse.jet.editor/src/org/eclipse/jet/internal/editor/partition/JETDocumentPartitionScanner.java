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
package org.eclipse.jet.internal.editor.partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.JavaTextTools;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.internal.editor.autoedit.JETTemplateAutoEditStrategy;
import org.eclipse.jet.internal.editor.configuration.delegates.IJETDefaultTextColorerDelegate;
import org.eclipse.jet.internal.editor.contentassist.JETCustomTagAssistProcessor;
import org.eclipse.jet.internal.editor.contentassist.JETDirectiveAssistProcessor;
import org.eclipse.jet.internal.editor.contentassist.JETJavaDeclarationAssistProcessor;
import org.eclipse.jet.internal.editor.contentassist.JETJavaExpressionAssistProcessor;
import org.eclipse.jet.internal.editor.contentassist.JETJavaScriptletAssistProcessor;
import org.eclipse.jet.internal.editor.formatter.JETCustomTagFormattingStrategy;
import org.eclipse.jet.internal.editor.formatter.JETDirectiveFormattingStrategy;
import org.eclipse.jet.internal.editor.formatter.JETJavaDeclarationFormattingStrategy;
import org.eclipse.jet.internal.editor.formatter.JETJavaExpressionFormattingStrategy;
import org.eclipse.jet.internal.editor.formatter.JETJavaScriptletFormattingStrategy;
import org.eclipse.jet.internal.editor.rules.ASTJETCommentRule;
import org.eclipse.jet.internal.editor.rules.ASTJETCustomTagRule;
import org.eclipse.jet.internal.editor.rules.ASTJETDirectiveRule;
import org.eclipse.jet.internal.editor.rules.ASTJETJavaDeclarationRule;
import org.eclipse.jet.internal.editor.rules.ASTJETJavaExpressionRule;
import org.eclipse.jet.internal.editor.rules.ASTJETJavaScriptletRule;
import org.eclipse.jet.internal.editor.scanners.JETCommentScanner;
import org.eclipse.jet.internal.editor.scanners.JETCustomTagScanner;
import org.eclipse.jet.internal.editor.scanners.JETDirectiveScanner;
import org.eclipse.jet.internal.editor.scanners.JETJavaDeclarationScanner;
import org.eclipse.jet.internal.editor.scanners.JETJavaExpressionScanner;
import org.eclipse.jet.internal.editor.scanners.JETJavaScriptletScanner;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

/**
 * @author pelder
 * 
 */
public class JETDocumentPartitionScanner extends RuleBasedPartitionScanner {

	public static final String JET_COMMENT = "__jet_comment";
	public static final String JET_CUSTOM_TAG = "__jet_xml_tag";
	public static final String JET_DIRECTIVE = "__jet_directive";
	public static final String JET_JAVA_DECLARATION = "__jet_java_declaration";
	public static final String JET_JAVA_EXPRESSION = "__jet_java_expression";
	public static final String JET_JAVA_SCRIPTLET = "__jet_java_scriptlet";

	private Map tokenScanners;
	private Map damagerRepairers;
	private Map damagersOnly;
	private Map repairersOnly;
	private Map completionProcessors;
	private Map formattingStrategies;
	private JETTextEditor editor;

	private List contentTypes;
	private JETCustomTagScanner tagScanner;
	private JETDirectiveScanner directiveScanner;
	private JETJavaDeclarationScanner declarationScanner;
	private JETJavaExpressionScanner expressionScanner;
	private JETJavaScriptletScanner scriptletScanner;
	private JETCommentScanner commentScanner;

	private IContentAssistProcessor tagAssistProcessor;
	private IContentAssistProcessor scriptletAssistProcessor;
	private IContentAssistProcessor expressionAssistProcessor;
	private IContentAssistProcessor declarationAssistProcessor;

	private IContentAssistProcessor directiveAssistProcessor;
	private IFormattingStrategy tagFormattingStrategy;
	private IFormattingStrategy scriptletFormattingStrategy;
	private IFormattingStrategy expressionFormattingStrategy;
	private IFormattingStrategy declarationFormattingStrategy;
	private IFormattingStrategy directiveFormattingStrategy;

	private PartitionScannerBasedDamagerRepairer jetTextContentDamagerRepairer;

	private JavaSourceViewerConfiguration javaSourceViewConfig;

	public JETDocumentPartitionScanner(JETTextEditor editor) {
		this.editor = editor;
		List rules = new ArrayList();
		org.eclipse.jface.text.rules.IToken jetComments = new Token(
				"__jet_comment");
		org.eclipse.jface.text.rules.IToken jetCustomTags = new Token(
				"__jet_xml_tag");
		org.eclipse.jface.text.rules.IToken jetDirective = new Token(
				"__jet_directive");
		org.eclipse.jface.text.rules.IToken jetJavaDeclaration = new Token(
				"__jet_java_declaration");
		org.eclipse.jface.text.rules.IToken jetJavaExpression = new Token(
				"__jet_java_expression");
		org.eclipse.jface.text.rules.IToken jetJavaScriptlet = new Token(
				"__jet_java_scriptlet");
		rules.add(new ASTJETCommentRule(editor, jetComments));
		rules.add(new ASTJETCustomTagRule(editor, jetCustomTags));
		rules.add(new ASTJETDirectiveRule(editor, jetDirective));
		rules.add(new ASTJETJavaDeclarationRule(editor, jetJavaDeclaration));
		rules.add(new ASTJETJavaExpressionRule(editor, jetJavaExpression));
		rules.add(new ASTJETJavaScriptletRule(editor, jetJavaScriptlet));
		IPredicateRule result[] = new IPredicateRule[rules.size()];
		result = (IPredicateRule[]) rules.toArray(result);
		setPredicateRules(result);

		// used to get Java auto edit strategies without using internal JDT
		// APIs.
		javaSourceViewConfig = new JavaSourceViewerConfiguration(
				new JavaTextTools(editor.getEditorPreferenceStore())
						.getColorManager(), editor.getEditorPreferenceStore(),
				editor, "__dftl_partitioning");
	}

	public int getNextCharacterOffset() {
		return fOffset;
	}

	public String[] getContentTypes() {
		if (contentTypes == null) {
			contentTypes = new ArrayList();
			contentTypes.add(IDocument.DEFAULT_CONTENT_TYPE);
			contentTypes.add("__jet_comment");
			contentTypes.add("__jet_xml_tag");
			contentTypes.add("__jet_directive");
			contentTypes.add("__jet_java_declaration");
			contentTypes.add("__jet_java_expression");
			contentTypes.add("__jet_java_scriptlet");
		}
		String result[] = new String[contentTypes.size()];
		result = (String[]) contentTypes.toArray(result);
		return result;
	}

	private void initTokenScanners() {
		tokenScanners = new HashMap();
		tokenScanners.put("__jet_comment", getCommentScanner());
		tokenScanners.put("__jet_xml_tag", getCustomTagScanner());
		tokenScanners.put("__jet_directive", getDirectiveScanner());
		tokenScanners
				.put("__jet_java_declaration", getJavaDeclarationScanner());
		tokenScanners.put("__jet_java_expression", getJavaExpressionScanner());
		tokenScanners.put("__jet_java_scriptlet", getJavaScriptletScanner());
	}

	private void initCompletionProcessors(ContentAssistant assistant) {
		completionProcessors = new HashMap();
		completionProcessors.put(IDocument.DEFAULT_CONTENT_TYPE,
				getTextElementAssistProcessor(assistant));
		completionProcessors.put("__jet_comment",
				getCommentAssistProcessor(assistant));
		completionProcessors.put("__jet_xml_tag",
				getCustomTagAssistProcessor(assistant));
		completionProcessors.put("__jet_directive",
				getDirectiveAssistProcessor(assistant));
		completionProcessors.put("__jet_java_declaration",
				getJavaDeclarationAssistProcessor(assistant));
		completionProcessors.put("__jet_java_expression",
				getJavaExpressionAssistProcessor(assistant));
		completionProcessors.put("__jet_java_scriptlet",
				getJavaScriptletAssistProcessor(assistant));
	}

	private void initFormattingStrategies() {
		formattingStrategies = new HashMap();
		formattingStrategies.put(IDocument.DEFAULT_CONTENT_TYPE,
				getTextElementFormattingStrategy());
		formattingStrategies.put("__jet_comment",
				getCommentFormattingStrategy());
		formattingStrategies.put("__jet_xml_tag",
				getCustomTagFormattingStrategy());
		formattingStrategies.put("__jet_directive",
				getDirectiveFormattingStrategy());
		formattingStrategies.put("__jet_java_declaration",
				getJavaDeclarationFormattingStrategy());
		formattingStrategies.put("__jet_java_expression",
				getJavaExpressionFormattingStrategy());
		formattingStrategies.put("__jet_java_scriptlet",
				getJavaScriptletFormattingStrategy());
	}

	private void initDamagerRepairers() {
		damagerRepairers = new HashMap();
		damagerRepairers.put("__jet_comment",
				createDefaultDamagerRepairer("__jet_comment"));
		damagerRepairers.put("__jet_xml_tag",
				createDefaultDamagerRepairer("__jet_xml_tag"));
		damagerRepairers.put("__jet_directive",
				createDefaultDamagerRepairer("__jet_directive"));
		damagerRepairers.put("__jet_java_declaration",
				createDefaultDamagerRepairer("__jet_java_declaration"));
		damagerRepairers.put("__jet_java_expression",
				createDefaultDamagerRepairer("__jet_java_expression"));
		damagerRepairers.put("__jet_java_scriptlet",
				createDefaultDamagerRepairer("__jet_java_scriptlet"));
		if (createJETTextContentDamagerRepairer() != null)
			damagerRepairers.put(IDocument.DEFAULT_CONTENT_TYPE,
					jetTextContentDamagerRepairer);
	}

	private void initDamagersOnly() {
		damagersOnly = new HashMap();
	}

	protected void initRepairersOnly() {
		repairersOnly = new HashMap();
	}

	protected IFormattingStrategy getTextElementFormattingStrategy() {
		return null;
	}

	protected IFormattingStrategy getCommentFormattingStrategy() {
		return null;
	}

	protected IFormattingStrategy getCustomTagFormattingStrategy() {
		if (tagFormattingStrategy == null)
			tagFormattingStrategy = new JETCustomTagFormattingStrategy();
		return tagFormattingStrategy;
	}

	protected IFormattingStrategy getJavaScriptletFormattingStrategy() {
		if (scriptletFormattingStrategy == null)
			scriptletFormattingStrategy = new JETJavaScriptletFormattingStrategy();
		return scriptletFormattingStrategy;
	}

	protected IFormattingStrategy getJavaExpressionFormattingStrategy() {
		if (expressionFormattingStrategy == null)
			expressionFormattingStrategy = new JETJavaExpressionFormattingStrategy();
		return expressionFormattingStrategy;
	}

	protected IFormattingStrategy getJavaDeclarationFormattingStrategy() {
		if (declarationFormattingStrategy == null)
			declarationFormattingStrategy = new JETJavaDeclarationFormattingStrategy();
		return declarationFormattingStrategy;
	}

	protected IFormattingStrategy getDirectiveFormattingStrategy() {
		if (directiveFormattingStrategy == null)
			directiveFormattingStrategy = new JETDirectiveFormattingStrategy();
		return directiveFormattingStrategy;
	}

	protected IContentAssistProcessor getTextElementAssistProcessor(
			ContentAssistant assistant) {
		return null;
	}

	protected IContentAssistProcessor getCommentAssistProcessor(
			ContentAssistant assistant) {
		return null;
	}

	protected IContentAssistProcessor getCustomTagAssistProcessor(
			ContentAssistant assistant) {
		if (tagAssistProcessor == null)
			tagAssistProcessor = new JETCustomTagAssistProcessor(editor);
		return tagAssistProcessor;
	}

	protected IContentAssistProcessor getJavaScriptletAssistProcessor(
			ContentAssistant assistant) {
		if (scriptletAssistProcessor == null)
			scriptletAssistProcessor = new JETJavaScriptletAssistProcessor(
					editor);
		return scriptletAssistProcessor;
	}

	protected IContentAssistProcessor getJavaExpressionAssistProcessor(
			ContentAssistant assistant) {
		if (expressionAssistProcessor == null)
			expressionAssistProcessor = new JETJavaExpressionAssistProcessor(
					editor);
		return expressionAssistProcessor;
	}

	protected IContentAssistProcessor getJavaDeclarationAssistProcessor(
			ContentAssistant assistant) {
		if (declarationAssistProcessor == null)
			declarationAssistProcessor = new JETJavaDeclarationAssistProcessor(
					editor);
		return declarationAssistProcessor;
	}

	protected IContentAssistProcessor getDirectiveAssistProcessor(
			ContentAssistant assistant) {
		if (directiveAssistProcessor == null)
			directiveAssistProcessor = new JETDirectiveAssistProcessor(editor);
		return directiveAssistProcessor;
	}

	protected ITokenScanner getCommentScanner() {
		org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager tokenStyleManager = editor
				.getTokenStyleManager();
		org.eclipse.jface.preference.IPreferenceStore preferenceStore = editor
				.getEditorPreferenceStore();
		if (commentScanner == null)
			commentScanner = new JETCommentScanner(tokenStyleManager,
					preferenceStore);
		return commentScanner;
	}

	protected ITokenScanner getCustomTagScanner() {
		org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager tokenStyleManager = editor
				.getTokenStyleManager();
		org.eclipse.jface.preference.IPreferenceStore preferenceStore = editor
				.getEditorPreferenceStore();
		if (tagScanner == null)
			tagScanner = new JETCustomTagScanner(tokenStyleManager,
					preferenceStore);
		return tagScanner;
	}

	protected ITokenScanner getJavaScriptletScanner() {
		org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager tokenStyleManager = editor
				.getTokenStyleManager();
		org.eclipse.jface.preference.IPreferenceStore preferenceStore = editor
				.getEditorPreferenceStore();
		if (scriptletScanner == null)
			scriptletScanner = new JETJavaScriptletScanner(tokenStyleManager,
					preferenceStore);
		return scriptletScanner;
	}

	protected ITokenScanner getJavaExpressionScanner() {
		org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager tokenStyleManager = editor
				.getTokenStyleManager();
		org.eclipse.jface.preference.IPreferenceStore preferenceStore = editor
				.getEditorPreferenceStore();
		if (expressionScanner == null)
			expressionScanner = new JETJavaExpressionScanner(tokenStyleManager,
					preferenceStore);
		return expressionScanner;
	}

	protected ITokenScanner getJavaDeclarationScanner() {
		org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager tokenStyleManager = editor
				.getTokenStyleManager();
		org.eclipse.jface.preference.IPreferenceStore preferenceStore = editor
				.getEditorPreferenceStore();
		if (declarationScanner == null)
			declarationScanner = new JETJavaDeclarationScanner(
					tokenStyleManager, preferenceStore);
		return declarationScanner;
	}

	protected ITokenScanner getDirectiveScanner() {
		org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager tokenStyleManager = editor
				.getTokenStyleManager();
		org.eclipse.jface.preference.IPreferenceStore preferenceStore = editor
				.getEditorPreferenceStore();
		if (directiveScanner == null)
			directiveScanner = new JETDirectiveScanner(tokenStyleManager,
					preferenceStore);
		return directiveScanner;
	}

	public ITokenScanner getTokenScanner(String contentType) {
		if (tokenScanners == null)
			initTokenScanners();
		ITokenScanner scanner = (ITokenScanner) tokenScanners.get(contentType);
		return scanner;
	}

	private PartitionScannerBasedDamagerRepairer createJETTextContentDamagerRepairer() {
		if (jetTextContentDamagerRepairer == null) {
			IJETDefaultTextColorerDelegate delegate = editor
					.getCurrentColorerDelegate();
			if (delegate != null) {
				RuleBasedPartitionScanner partitionScanner = new RuleBasedPartitionScanner();
				partitionScanner.setPredicateRules(delegate
						.getPartitioningRules());
				jetTextContentDamagerRepairer = new PartitionScannerBasedDamagerRepairer(
						partitionScanner, delegate);
			}
		}
		return jetTextContentDamagerRepairer;
	}

	public void updateJETTextContentDamagerRepairer() {
		if (jetTextContentDamagerRepairer != null) {
			IJETDefaultTextColorerDelegate delegate = editor
					.getCurrentColorerDelegate();
			if (delegate != null) {
				RuleBasedPartitionScanner partitionScanner = new RuleBasedPartitionScanner();
				partitionScanner.setPredicateRules(delegate
						.getPartitioningRules());
				jetTextContentDamagerRepairer
						.setPartitionScanner(partitionScanner);
				jetTextContentDamagerRepairer.setTokenScannerProvider(delegate);
			}
		}
	}

	private DefaultDamagerRepairer createDefaultDamagerRepairer(
			String contentType) {
		ITokenScanner tokenScanner = getTokenScanner(contentType);
		return tokenScanner != null ? new DefaultDamagerRepairer(tokenScanner)
				: null;
	}

	public IPresentationDamager getDamager(String contentType) {
		if (damagerRepairers == null)
			initDamagerRepairers();
		IPresentationDamager damager = (IPresentationDamager) damagerRepairers
				.get(contentType);
		if (damager == null) {
			if (damagersOnly == null)
				initDamagersOnly();
			damager = (IPresentationDamager) damagersOnly.get(contentType);
		}
		return damager;
	}

	public IPresentationRepairer getRepairer(String contentType) {
		if (damagerRepairers == null)
			initDamagerRepairers();
		IPresentationRepairer repairer = (IPresentationRepairer) damagerRepairers
				.get(contentType);
		if (repairer == null) {
			if (repairersOnly == null)
				initRepairersOnly();
			repairer = (IPresentationRepairer) repairersOnly.get(contentType);
		}
		return repairer;
	}

	public IContentAssistProcessor getCompletionProcessor(String contentType,
			ContentAssistant assistant) {
		if (completionProcessors == null)
			initCompletionProcessors(assistant);
		IContentAssistProcessor processor = (IContentAssistProcessor) completionProcessors
				.get(contentType);
		return processor;
	}

	public IFormattingStrategy getFormattingStrategy(String contentType) {
		if (formattingStrategies == null)
			initFormattingStrategies();
		IFormattingStrategy formatter = (IFormattingStrategy) formattingStrategies
				.get(contentType);
		return formatter;
	}

	public IAutoEditStrategy[] getAutoEditStrategies(String contentType) {
		IAutoEditStrategy result[] = (IAutoEditStrategy[]) null;
		if ("__jet_directive".equals(contentType))
			result = (new IAutoEditStrategy[] { new JETTemplateAutoEditStrategy() });
		else if ("__jet_java_scriptlet".equals(contentType)) {
			final List resultList = new ArrayList();
			resultList.addAll(Arrays.asList(javaSourceViewConfig
					.getAutoEditStrategies(null, "__dftl_partitioning")));
			resultList.add(new JETTemplateAutoEditStrategy());
			result = (IAutoEditStrategy[]) resultList
					.toArray(new IAutoEditStrategy[resultList.size()]);
		} else if ("__jet_java_declaration".equals(contentType)) {
			final List resultList = new ArrayList();
			resultList.addAll(Arrays.asList(javaSourceViewConfig
					.getAutoEditStrategies(null, "__dftl_partitioning")));
			resultList.add(new JETTemplateAutoEditStrategy());
			result = (IAutoEditStrategy[]) resultList
					.toArray(new IAutoEditStrategy[resultList.size()]);
		}
		return result;
	}

}