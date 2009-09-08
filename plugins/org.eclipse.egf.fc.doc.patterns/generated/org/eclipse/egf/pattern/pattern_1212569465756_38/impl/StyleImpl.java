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
package org.eclipse.egf.pattern.pattern_1212569465756_38.impl;

import org.eclipse.egf.pattern.impl.PatternImpl;

import org.eclipse.egf.pattern.pattern_1212569465756_38.Pattern_1212569465756_38Package;
import org.eclipse.egf.pattern.pattern_1212569465756_38.Style;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StyleImpl extends PatternImpl implements Style {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Pattern_1212569465756_38Package.Literals.STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateBody(Object classLoader_p) {
		StringBuilder builder = new StringBuilder();
		builder.append(generateContent());
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePreMatching() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/generated/Pattern.1212569465756.38/generatePreMatching.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePostMatching() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/generated/Pattern.1212569465756.38/generatePostMatching.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateHeader() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569498953.39.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateFooter() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569498953.40.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateContent() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212569465756.38/PatternMethod.1212569805510.43.pt"));
		return builder.toString();
		
	}

} //StyleImpl
