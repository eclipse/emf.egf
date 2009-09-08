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
package org.eclipse.egf.pattern.pattern_1213692237160_91.impl;

import org.eclipse.egf.pattern.impl.PatternImpl;

import org.eclipse.egf.pattern.pattern_1213692237160_91.Condition;
import org.eclipse.egf.pattern.pattern_1213692237160_91.Pattern_1213692237160_91Package;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ConditionImpl extends PatternImpl implements Condition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Pattern_1213692237160_91Package.Literals.CONDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateBody(Object classLoader_p) {
		StringBuilder builder = new StringBuilder();
		builder.append(classSkeleton());
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePreMatching() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1213692164306.87/templates/generated/Pattern.1213692237160.91/generatePreMatching.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePostMatching() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1213692164306.87/templates/generated/Pattern.1213692237160.91/generatePostMatching.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateHeader() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1213692164306.87/templates/Pattern.1213692237160.91/PatternMethod.1213692242862.92.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateFooter() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1213692164306.87/templates/Pattern.1213692237160.91/PatternMethod.1213692242862.93.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String classSkeleton() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1213692164306.87/templates/Pattern.1213692237160.91/PatternMethod.1213692563382.98.pt"));
		return builder.toString();
		
	}

} //ConditionImpl
