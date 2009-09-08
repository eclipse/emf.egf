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
package org.eclipse.egf.pattern.pattern_1202377458283_68;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Pattern 1202377458283 68</b></em>'. <!-- end-user-doc -->
 * 
 * 
 * @see org.eclipse.egf.pattern.pattern_1202377458283_68.Pattern_1202377458283_68Package#getPattern_1202377458283_68()
 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern/production Path='model/Class/setGenFeature.override.javajetinc' Compilation='false' BufferModification='false'"
 * @generated
 */
public interface Pattern_1202377458283_68 extends Pattern {
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
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377458283.68/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377458283.68/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377458283.68/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377458283.68/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1202377458283.69'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(org.eclipse.egf.pattern.emf/templates/Pattern.1202377458283.68/PatternMethod.1202377458283.69.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"org.eclipse.egf.pattern.emf/templates/Pattern.1202377458283.68/PatternMethod.1202377458283.69.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1202377458283.70'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(org.eclipse.egf.pattern.emf/templates/Pattern.1202377458283.68/PatternMethod.1202377458283.70.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"org.eclipse.egf.pattern.emf/templates/Pattern.1202377458283.68/PatternMethod.1202377458283.70.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

} // Pattern_1202377458283_68
