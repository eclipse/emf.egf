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
package org.eclipse.egf.pattern.pattern_1213692237160_91;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.egf.pattern.pattern_1213692237160_91.Pattern_1213692237160_91Package#getCondition()
 * @model
 * @generated
 */
public interface Condition extends Pattern {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='CALL(classSkeleton);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(classSkeleton());\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateBody(Object classLoader_p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1213692164306.87/templates/generated/Pattern.1213692237160.91/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1213692164306.87/templates/generated/Pattern.1213692237160.91/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1213692164306.87/templates/generated/Pattern.1213692237160.91/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1213692164306.87/templates/generated/Pattern.1213692237160.91/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1213692242862.92'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1213692164306.87/templates/Pattern.1213692237160.91/PatternMethod.1213692242862.92.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1213692164306.87/templates/Pattern.1213692237160.91/PatternMethod.1213692242862.92.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1213692242862.93'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1213692164306.87/templates/Pattern.1213692237160.91/PatternMethod.1213692242862.93.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1213692164306.87/templates/Pattern.1213692237160.91/PatternMethod.1213692242862.93.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1213692563382.98'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1213692164306.87/templates/Pattern.1213692237160.91/PatternMethod.1213692563382.98.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1213692164306.87/templates/Pattern.1213692237160.91/PatternMethod.1213692563382.98.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String classSkeleton();

} // Condition
