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
package org.eclipse.egf.pattern.pattern_1212570575038_70;

import org.eclipse.egf.pattern.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Toc</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.egf.pattern.pattern_1212570575038_70.Pattern_1212570575038_70Package#getToc()
 * @model
 * @generated
 */
public interface Toc extends Pattern {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='CALL(generateToc);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(generateToc());\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateBody(Object classLoader_p);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/generated/Pattern.1212570575038.70/generatePreMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/generated/Pattern.1212570575038.70/generatePreMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePreMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/generated/Pattern.1212570575038.70/generatePostMatching.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/generated/Pattern.1212570575038.70/generatePostMatching.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generatePostMatching();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212570582615.71'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212570575038.70/PatternMethod.1212570582615.71.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212570575038.70/PatternMethod.1212570582615.71.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateHeader();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212570582615.72'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212570575038.70/PatternMethod.1212570582615.72.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212570575038.70/PatternMethod.1212570582615.72.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateFooter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/egf/1.0.0/uid body='PatternMethod.1212571946819.75'"
	 *        annotation="http://www.eclipse.org/egf/1.0.0/Pattern body='READ(asset.1212677795454.8/templates/Pattern.1212570575038.70/PatternMethod.1212571946819.75.pt);'"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='StringBuilder builder = new StringBuilder();\nbuilder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile(\"asset.1212677795454.8/templates/Pattern.1212570575038.70/PatternMethod.1212571946819.75.pt\"));\nreturn builder.toString();\n'"
	 * @generated
	 */
	String generateToc();

} // Toc
