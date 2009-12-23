/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.extension;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.factorycomponent.ModelElement;
import org.eclipse.egf.model.pattern.Library;
import org.eclipse.egf.model.pattern.Parameter;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.SuperMethod;
import org.eclipse.egf.pattern.PatternConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * @author Guiu
 * 
 */
public abstract class PatternFactory {

	public static final String HEADER_METHOD_NAME = "header";
	public static final String FOOTER_METHOD_NAME = "footer";
	public static final String BODY_METHOD_NAME = "body";

	public Pattern createDebugPattern1(Library lib) {
		Pattern createPattern = createPattern(lib, "MyPattern");
		return createPattern;
	}

	// currently broken since there is a problem with SuperMethod
	public List<Pattern> createDebugPattern2(Library lib) {
		List<Pattern> result = new ArrayList<Pattern>();
		Pattern parent = createPattern(lib, "parent");
		Pattern child = createPattern(lib, "child");
		child.setSuperPattern(parent);
		SuperMethod superMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createSuperMethod();
		superMethod.setName(BODY_METHOD_NAME);
		child.getOrchestration().add(superMethod);
		result.add(child);
		result.add(parent);

		return result;
	}

	public List<Pattern> createDebugPattern3(Library lib) {
		List<Pattern> result = new ArrayList<Pattern>();
		Pattern parent = createPattern(lib, "parent");
		Pattern child = createPattern(lib, "child");
		parent.getOrchestration().add(child);
		result.add(parent);
		result.add(child);

		return result;

	}

	public List<Pattern> createDebugPattern4(Library lib) {
		List<Pattern> result = new ArrayList<Pattern>();
		Pattern parent = createPattern(lib, "parent");
		Parameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createParameter();
		param1.setName("parentP");
		param1.setType(EcorePackage.eINSTANCE.getEClass());
		parent.getParameters().add(param1);

		Pattern child = createPattern(lib, "child");
		Parameter param2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createParameter();
		param2.setName("childP");
		param2.setType(EcorePackage.eINSTANCE.getEClass());
		child.getParameters().add(param2);

		parent.getOrchestration().add(child);
		result.add(parent);
		result.add(child);

		return result;
	}

	public Pattern createPattern(Library lib, String patternName) {
		Pattern pattern = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPattern();
		pattern.setName(patternName);
		if (lib != null)
			lib.getElements().add(pattern);
		checkId(pattern);
		addNature(pattern);

		// 1 - create default content
		PatternMethod headerMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
		checkId(headerMethod);
		pattern.getAllMethods().add(headerMethod);
		pattern.setHeaderMethod(headerMethod);
		initHeader(headerMethod);

		PatternMethod bodyMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
		checkId(bodyMethod);
		pattern.getAllMethods().add(bodyMethod);
		initBody(bodyMethod);

		PatternMethod footerMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
		checkId(footerMethod);
		pattern.getAllMethods().add(footerMethod);
		pattern.setFooterMethod(footerMethod);
		initFooter(footerMethod);

		// 2 - set up default orchestration
		pattern.getOrchestration().add(bodyMethod);
		return pattern;
	}

	/**
	 * @param footerMethod
	 */
	protected void initFooter(PatternMethod method) {
		method.setName(FOOTER_METHOD_NAME);
		method.setPatternFilePath(createURI(method));

	}

	/**
	 * @param bodyMethod
	 */
	protected void initBody(PatternMethod method) {
		method.setName(BODY_METHOD_NAME);
		method.setPatternFilePath(createURI(method));
	}

	/**
	 * @param headerMethod
	 */
	protected void initHeader(PatternMethod method) {
		method.setName(HEADER_METHOD_NAME);
		method.setPatternFilePath(createURI(method));
	}

	/**
	 * @param pattern
	 */
	protected abstract void addNature(Pattern pattern);

	/**
	 * @param footerMethod
	 * @return
	 */

	private URI createURI(PatternMethod method) {
		URI uri = URI.createFileURI("templates/pattern." + method.getPattern().getID() + "/method." + method.getID() + "." + PatternConstants.PATTERN_UNIT_FILE_EXTENSION);
		return uri;
	}

	/**
	 * @param element
	 */
	private void checkId(ModelElement element) {
		if (element.getID() == null || "".equals(element.getID()))
			throw new IllegalStateException();
	}

}
