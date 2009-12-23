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
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * @author Guiu
 * 
 */
public abstract class PatternFactory {

    public static final String INIT_METHOD_NAME = "init";
    public static final String HEADER_METHOD_NAME = "header";
    public static final String FOOTER_METHOD_NAME = "footer";
    public static final String BODY_METHOD_NAME = "body";

    public Pattern createDebugPattern1(PatternLibrary lib) {
        Pattern createPattern = createPattern(lib, "MyPattern");
        return createPattern;
    }

    public List<Pattern> createDebugPattern3(PatternLibrary lib) {
        List<Pattern> result = new ArrayList<Pattern>();
        Pattern parent = createPattern(lib, "parent");
        Pattern child = createPattern(lib, "child");
        PatternCall patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
        patternCall.setCalled(child);
        parent.getOrchestration().add(patternCall);
        result.add(parent);
        result.add(child);

        return result;

    }

    public List<Pattern> createDebugPattern5(PatternLibrary lib) {
        List<Pattern> result = new ArrayList<Pattern>();
        Pattern parent = createPattern(lib, "parent");
        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("parentP1");
        param1.setType(EcorePackage.eINSTANCE.getEClass());
        parent.getParameters().add(param1);
        PatternParameter param12 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param12.setName("parentP2");
        param12.setType(EcorePackage.eINSTANCE.getEClass());
        parent.getParameters().add(param12);

        Pattern child = createPattern(lib, "child");
        PatternParameter param2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param2.setName("childP");
        param2.setType(EcorePackage.eINSTANCE.getEClass());
        child.getParameters().add(param2);
        PatternCall patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
        patternCall.getParameterMatching().put(param12, param2);
        patternCall.setCalled(child);

        parent.getOrchestration().add(patternCall);
        result.add(parent);
        result.add(child);

        return result;
    }

    public List<Pattern> createDebugPattern4(PatternLibrary lib) {
        List<Pattern> result = new ArrayList<Pattern>();
        Pattern parent = createPattern(lib, "parent");
        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("parentP");
        param1.setType(EcorePackage.eINSTANCE.getEClass());
        parent.getParameters().add(param1);

        Pattern child = createPattern(lib, "child");
        PatternParameter param2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param2.setName("childP");
        param2.setType(EcorePackage.eINSTANCE.getEClass());
        child.getParameters().add(param2);
        PatternCall patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
        patternCall.setCalled(child);

        parent.getOrchestration().add(patternCall);
        result.add(parent);
        result.add(child);

        return result;
    }

    public Pattern createPattern(PatternLibrary lib, String patternName) {
        Pattern pattern = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPattern();
        pattern.setName(patternName);
        if (lib != null)
            lib.getElements().add(pattern);
        checkId(pattern);
        addNature(pattern);

        PatternVariable var1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternVariable();
        checkId(var1);
        var1.setName("var1");
        pattern.getVariables().add(var1);
        PatternVariable var2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternVariable();
        checkId(var2);
        var2.setName("var2");
        pattern.getVariables().add(var2);

        // 1 - create default content
        PatternMethod headerMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        checkId(headerMethod);
        pattern.getMethods().add(headerMethod);
        pattern.setHeaderMethod(headerMethod);
        initHeader(headerMethod);

        PatternMethod initMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        checkId(initMethod);
        pattern.getMethods().add(initMethod);
        pattern.setInitMethod(initMethod);
        initIinit(initMethod);

        PatternMethod bodyMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        checkId(bodyMethod);
        pattern.getMethods().add(bodyMethod);
        initBody(bodyMethod);

        PatternMethod footerMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        checkId(footerMethod);
        pattern.getMethods().add(footerMethod);
        pattern.setFooterMethod(footerMethod);
        initFooter(footerMethod);

        // 2 - set up default orchestration
        MethodCall methodCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createMethodCall();
        methodCall.setCalled(bodyMethod);
        pattern.getOrchestration().add(methodCall);
        return pattern;
    }

    /**
     * @param footerMethod
     */
    protected void initFooter(PatternMethod method) {
        method.setName(FOOTER_METHOD_NAME);
        method.setPatternFilePath(createURI(method));
        initFooterContent(method); // TODO use simple String.replace()
    }

    /**
     * @param method
     */
    private void initFooterContent(PatternMethod method) {
        // read template
        // get Map of name-values
        // replace
        // write result to method.getPatternFilePath (là je vais avoir besoin du
        // nom du projet :( )
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
     * @param headerMethod
     */
    protected void initIinit(PatternMethod method) {
        method.setName(INIT_METHOD_NAME);
        method.setPatternFilePath(createURI(method));
    }

    private URI createURI(PatternMethod method) {

        return PatternHelper.Filename.computeFileURI(method);
    }

    /**
     * @param pattern
     */
    protected abstract void addNature(Pattern pattern);

    /**
     * @param element
     */
    private void checkId(ModelElement element) {
        if (element.getID() == null || "".equals(element.getID()))
            throw new IllegalStateException();
    }

}
