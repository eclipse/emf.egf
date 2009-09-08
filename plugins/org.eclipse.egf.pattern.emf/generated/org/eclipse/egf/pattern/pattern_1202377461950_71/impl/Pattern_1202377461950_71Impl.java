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
package org.eclipse.egf.pattern.pattern_1202377461950_71.impl;

import org.eclipse.egf.pattern.impl.PatternImpl;

import org.eclipse.egf.pattern.pattern_1202377461950_71.Pattern_1202377461950_71;
import org.eclipse.egf.pattern.pattern_1202377461950_71.Pattern_1202377461950_71Package;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Pattern 1202377461950 71</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class Pattern_1202377461950_71Impl extends PatternImpl implements
		Pattern_1202377461950_71 {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Pattern_1202377461950_71Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Pattern_1202377461950_71Package.Literals.PATTERN_1202377461950_71;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String generatePreMatching() {
		StringBuilder builder = new StringBuilder();
		builder
				.append(org.eclipse.egf.pattern.production.template.TemplateHelper
						.readTemplateFile("org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377461950.71/generatePreMatching.pt"));
		return builder.toString();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String generatePostMatching() {
		StringBuilder builder = new StringBuilder();
		builder
				.append(org.eclipse.egf.pattern.production.template.TemplateHelper
						.readTemplateFile("org.eclipse.egf.pattern.emf/templates/generated/Pattern.1202377461950.71/generatePostMatching.pt"));
		return builder.toString();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String generateHeader() {
		StringBuilder builder = new StringBuilder();
		builder
				.append(org.eclipse.egf.pattern.production.template.TemplateHelper
						.readTemplateFile("org.eclipse.egf.pattern.emf/templates/Pattern.1202377461950.71/PatternMethod.1202377461950.72.pt"));
		return builder.toString();

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String generateFooter() {
		StringBuilder builder = new StringBuilder();
		builder
				.append(org.eclipse.egf.pattern.production.template.TemplateHelper
						.readTemplateFile("org.eclipse.egf.pattern.emf/templates/Pattern.1202377461950.71/PatternMethod.1202377461950.73.pt"));
		return builder.toString();

	}

} // Pattern_1202377461950_71Impl
