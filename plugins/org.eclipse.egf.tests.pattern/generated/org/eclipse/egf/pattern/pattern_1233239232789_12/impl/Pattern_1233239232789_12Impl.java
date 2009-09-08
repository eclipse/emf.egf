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
package org.eclipse.egf.pattern.pattern_1233239232789_12.impl;

import org.eclipse.egf.pattern.impl.PatternImpl;

import org.eclipse.egf.pattern.pattern_1233239232789_12.Pattern_1233239232789_12;
import org.eclipse.egf.pattern.pattern_1233239232789_12.Pattern_1233239232789_12Package;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern 1233239232789 12</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class Pattern_1233239232789_12Impl extends PatternImpl implements Pattern_1233239232789_12 {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Pattern_1233239232789_12Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Pattern_1233239232789_12Package.Literals.PATTERN_1233239232789_12;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateBody(Object classLoader_p) {
		StringBuilder builder = new StringBuilder();
		builder.append(displayMessage());
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePreMatching() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("factoryComponent.1233238712534.8/templates/generated/Pattern.1233239232789.12/generatePreMatching.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePostMatching() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("factoryComponent.1233238712534.8/templates/generated/Pattern.1233239232789.12/generatePostMatching.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateHeader() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("factoryComponent.1233238712534.8/templates/Pattern.1233239232789.12/PatternMethod.1233239241420.13.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateFooter() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("factoryComponent.1233238712534.8/templates/Pattern.1233239232789.12/PatternMethod.1233239241420.14.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String displayMessage() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("factoryComponent.1233238712534.8/templates/Pattern.1233239232789.12/PatternMethod.1233240180720.15.pt"));
		return builder.toString();
		
	}

} //Pattern_1233239232789_12Impl
