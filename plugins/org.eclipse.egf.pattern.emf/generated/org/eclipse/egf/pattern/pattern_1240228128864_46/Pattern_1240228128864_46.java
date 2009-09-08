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
package org.eclipse.egf.pattern.pattern_1240228128864_46;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Pattern 1240228128864 46</b></em>'. <!-- end-user-doc -->
 * 
 * 
 * @see org.eclipse.egf.pattern.pattern_1240228128864_46.Pattern_1240228128864_46Package#getPattern_1240228128864_46()
 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern/production Path='editor/build.propertiesjet' Compilation='true' BufferModification='false'"
 * @generated
 */
public interface Pattern_1240228128864_46 extends Pattern {
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
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/generated/Pattern.1240228128864.46/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/generated/Pattern.1240228128864.46/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/generated/Pattern.1240228128864.46/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/generated/Pattern.1240228128864.46/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1240228135285.47'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1240228128864.46/PatternMethod.1240228135285.47.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1240228128864.46/PatternMethod.1240228135285.47.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1240228135285.48'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1240228128864.46/PatternMethod.1240228135285.48.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1240228128864.46/PatternMethod.1240228135285.48.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model annotation=
	 *        "http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1240228209850.51'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(emf.patterns/templates/Pattern.1240228128864.46/PatternMethod.1240228209850.51.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"emf.patterns/templates/Pattern.1240228128864.46/PatternMethod.1240228209850.51.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String include();

} // Pattern_1240228128864_46
