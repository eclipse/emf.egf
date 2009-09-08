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
package org.eclipse.egf.pattern.pattern_1212569887715_48;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Html Fc Doc</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.egf.pattern.pattern_1212569887715_48.Pattern_1212569887715_48Package#getHtmlFcDoc()
 * @model
 * @generated
 */
public interface HtmlFcDoc extends Pattern {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='CALL(init);CALL(generateHtmlHeaderPage);CALL(generateFcDescription);CALL(generateContractDescription);CALL(generatePatternDescription);CALL(generateMappingDescription);CALL(generateFactoryDescription);CALL(generateHtmlEndingPage);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(init());\nbuilder.append(generateHtmlHeaderPage());\nbuilder.append(generateFcDescription());\nbuilder.append(generateContractDescription());\nbuilder.append(generatePatternDescription());\nbuilder.append(generateMappingDescription());\nbuilder.append(generateFactoryDescription());\nbuilder.append(generateHtmlEndingPage());\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateBody(Object classLoader_p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/generated/Pattern.1212569887715.48/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/generated/Pattern.1212569887715.48/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/generated/Pattern.1212569887715.48/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/generated/Pattern.1212569887715.48/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212569917570.49'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212569917570.49.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212569917570.49.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212569917570.50'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212569917570.50.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212569917570.50.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212570146610.55'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570146610.55.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570146610.55.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHtmlHeaderPage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212570161763.56'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570161763.56.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570161763.56.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHtmlEndingPage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212570188118.57'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570188118.57.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570188118.57.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFcDescription();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212570199601.58'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570199601.58.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570199601.58.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateContractDescription();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212570213692.59'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570213692.59.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570213692.59.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePatternDescription();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212570313129.64'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570313129.64.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570313129.64.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateMappingDescription();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212570335781.65'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570335781.65.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212570335781.65.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFactoryDescription();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212765036913.16'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212765036913.16.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569887715.48/PatternMethod.1212765036913.16.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String init();

} // HtmlFcDoc
