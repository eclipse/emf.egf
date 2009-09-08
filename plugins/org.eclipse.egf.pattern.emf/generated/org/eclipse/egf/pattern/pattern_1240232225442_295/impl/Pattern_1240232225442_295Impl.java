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
package org.eclipse.egf.pattern.pattern_1240232225442_295.impl;

import org.eclipse.egf.pattern.impl.PatternImpl;

import org.eclipse.egf.pattern.pattern_1240232225442_295.Pattern_1240232225442_295;
import org.eclipse.egf.pattern.pattern_1240232225442_295.Pattern_1240232225442_295Package;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Pattern 1240232225442 295</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class Pattern_1240232225442_295Impl extends PatternImpl implements
		Pattern_1240232225442_295 {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Pattern_1240232225442_295Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Pattern_1240232225442_295Package.Literals.PATTERN_1240232225442_295;
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
						.readTemplateFile("emf.patterns/templates/generated/Pattern.1240232225442.295/generatePreMatching.pt"));
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
						.readTemplateFile("emf.patterns/templates/generated/Pattern.1240232225442.295/generatePostMatching.pt"));
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
						.readTemplateFile("emf.patterns/templates/Pattern.1240232225442.295/PatternMethod.1240232231066.296.pt"));
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
						.readTemplateFile("emf.patterns/templates/Pattern.1240232225442.295/PatternMethod.1240232231066.297.pt"));
		return builder.toString();

	}

} // Pattern_1240232225442_295Impl
