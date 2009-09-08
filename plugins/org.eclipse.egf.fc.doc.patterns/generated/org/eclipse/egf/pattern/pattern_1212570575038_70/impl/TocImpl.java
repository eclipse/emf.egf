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
package org.eclipse.egf.pattern.pattern_1212570575038_70.impl;

import org.eclipse.egf.pattern.impl.PatternImpl;

import org.eclipse.egf.pattern.pattern_1212570575038_70.Pattern_1212570575038_70Package;
import org.eclipse.egf.pattern.pattern_1212570575038_70.Toc;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Toc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TocImpl extends PatternImpl implements Toc {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TocImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Pattern_1212570575038_70Package.Literals.TOC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateBody(Object classLoader_p) {
		StringBuilder builder = new StringBuilder();
		builder.append(generateToc());
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePreMatching() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/generated/Pattern.1212570575038.70/generatePreMatching.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generatePostMatching() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/generated/Pattern.1212570575038.70/generatePostMatching.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateHeader() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212570575038.70/PatternMethod.1212570582615.71.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateFooter() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212570575038.70/PatternMethod.1212570582615.72.pt"));
		return builder.toString();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateToc() {
		StringBuilder builder = new StringBuilder();
		builder.append(org.eclipse.egf.pattern.production.template.TemplateHelper.readTemplateFile("asset.1212677795454.8/templates/Pattern.1212570575038.70/PatternMethod.1212571946819.75.pt"));
		return builder.toString();
		
	}

} //TocImpl
