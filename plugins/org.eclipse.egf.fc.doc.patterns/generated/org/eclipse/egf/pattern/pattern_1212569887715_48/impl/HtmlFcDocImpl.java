/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.pattern_1212569887715_48.impl;

import org.eclipse.egf.pattern.impl.PatternImpl;

import org.eclipse.egf.pattern.pattern_1212569887715_48.HtmlFcDoc;
import org.eclipse.egf.pattern.pattern_1212569887715_48.Pattern_1212569887715_48Package;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Html Fc Doc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class HtmlFcDocImpl extends PatternImpl implements HtmlFcDoc {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HtmlFcDocImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Pattern_1212569887715_48Package.Literals.HTML_FC_DOC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateBody(Object classLoader_p) {
		StringBuilder builder = new StringBuilder();
		builder.append(init());
		builder.append(generateHtmlHeaderPage());
		builder.append(generateFcDescription());
		builder.append(generateContractDescription());
		builder.append(generatePatternDescription());
		builder.append(generateMappingDescription());
		builder.append(generateFactoryDescription());
		builder.append(generateHtmlEndingPage());
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePreMatching() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/generated/Pattern.1212569887715.48/generatePreMatching.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePostMatching() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/generated/Pattern.1212569887715.48/generatePostMatching.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateHeader() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212569917570.49.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateFooter() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212569917570.50.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateHtmlHeaderPage() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570146610.55.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateHtmlEndingPage() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570161763.56.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateFcDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570188118.57.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateContractDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570199601.58.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePatternDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570213692.59.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateMappingDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570313129.64.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateFactoryDescription() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570335781.65.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String init() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212765036913.16.pt"));
		return builder.toString();
		
	}

} //HtmlFcDocImpl
