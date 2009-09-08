/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pattern.pattern_1233239232789_12;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern 1233239232789 12</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.egf.pattern.pattern_1233239232789_12.Pattern_1233239232789_12Package#getPattern_1233239232789_12()
 * @model
 * @generated
 */
public interface Pattern_1233239232789_12 extends Pattern {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='CALL(displayMessage);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(displayMessage());\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateBody(Object classLoader_p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(factoryComponent.1233238712534.8/templates/generated/Pattern.1233239232789.12/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"factoryComponent.1233238712534.8/templates/generated/Pattern.1233239232789.12/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(factoryComponent.1233238712534.8/templates/generated/Pattern.1233239232789.12/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"factoryComponent.1233238712534.8/templates/generated/Pattern.1233239232789.12/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1233239241420.13'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(factoryComponent.1233238712534.8/templates/Pattern.1233239232789.12/PatternMethod.1233239241420.13.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"factoryComponent.1233238712534.8/templates/Pattern.1233239232789.12/PatternMethod.1233239241420.13.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1233239241420.14'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(factoryComponent.1233238712534.8/templates/Pattern.1233239232789.12/PatternMethod.1233239241420.14.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"factoryComponent.1233238712534.8/templates/Pattern.1233239232789.12/PatternMethod.1233239241420.14.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1233240180720.15'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(factoryComponent.1233238712534.8/templates/Pattern.1233239232789.12/PatternMethod.1233240180720.15.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"factoryComponent.1233238712534.8/templates/Pattern.1233239232789.12/PatternMethod.1233240180720.15.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String displayMessage();

} // Pattern_1233239232789_12
