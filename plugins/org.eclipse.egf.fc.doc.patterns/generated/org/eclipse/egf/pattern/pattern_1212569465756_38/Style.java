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
package org.eclipse.egf.pattern.pattern_1212569465756_38;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Style</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.egf.pattern.pattern_1212569465756_38.Pattern_1212569465756_38Package#getStyle()
 * @model
 * @generated
 */
public interface Style extends Pattern {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='CALL(generateContent);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(generateContent());\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateBody(Object classLoader_p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/generated/Pattern.1212569465756.38/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/generated/Pattern.1212569465756.38/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/generated/Pattern.1212569465756.38/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/generated/Pattern.1212569465756.38/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212569498953.39'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569498953.39.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569498953.39.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212569498953.40'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569498953.40.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569498953.40.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212569805510.43'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569805510.43.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569805510.43.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateContent();

} // Style
