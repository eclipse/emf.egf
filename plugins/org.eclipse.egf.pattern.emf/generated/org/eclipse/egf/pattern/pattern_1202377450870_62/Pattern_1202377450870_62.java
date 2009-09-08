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
package org.eclipse.egf.pattern.pattern_1202377450870_62;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Pattern 1202377450870 62</b></em>'. <!-- end-user-doc -->
 * 
 * 
 * @see org.eclipse.egf.pattern.pattern_1202377450870_62.Pattern_1202377450870_62Package#getPattern_1202377450870_62()
 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern/production Path='model/Class/basicSetGenFeature.post.insert.javajetinc' Compilation='false' BufferModification='false'"
 * @generated
 */
public interface Pattern_1202377450870_62 extends Pattern {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	String generateBody(Object classLoader_p);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377450870.62/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377450870.62/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377450870.62/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377450870.62/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1202377450870.63'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(org.eclipse.egf.pattern.emf/templates/Pattern.1202377450870.62/PatternMethod.1202377450870.63.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"org.eclipse.egf.pattern.emf/templates/Pattern.1202377450870.62/PatternMethod.1202377450870.63.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1202377450870.64'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(org.eclipse.egf.pattern.emf/templates/Pattern.1202377450870.62/PatternMethod.1202377450870.64.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"org.eclipse.egf.pattern.emf/templates/Pattern.1202377450870.62/PatternMethod.1202377450870.64.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

} // Pattern_1202377450870_62
