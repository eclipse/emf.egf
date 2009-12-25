/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.extension;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.model.fcore.ModelElement;
import org.eclipse.egf.model.pattern.BasicQuery;
import org.eclipse.egf.model.pattern.MethodCall;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternCall;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternInjectedCall;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternParameter;
import org.eclipse.egf.model.pattern.PatternVariable;
import org.eclipse.egf.model.pattern.Query;
import org.eclipse.egf.pattern.PatternHelper;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

/**
 * @author Guiu
 * 
 */
public abstract class PatternFactory {

    public static final String INIT_METHOD_NAME = "init";
    public static final String HEADER_METHOD_NAME = "header";
    public static final String FOOTER_METHOD_NAME = "footer";
    public static final String BODY_METHOD_NAME = "body";

    public void createDebugPattern16(PatternLibrary lib) {
        Pattern p1 = createPattern(lib, "Pattern Called");
        Pattern p2 = createPattern(lib, "Pattern Parent");
        Pattern p3 = createPattern(lib, "Pattern Child");

        p3.setSuperPattern(p2);

        // set up P1
        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("myCalledParam");
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass");
        param1.setQuery(createBasicQuery());
        p1.getParameters().add(param1);

        // set up P2
        PatternParameter param2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param2.setName("myChildParam");
        param2.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass");
        param2.setQuery(createBasicQuery());
        p2.getParameters().add(param2);

        // set up P3
        PatternCall patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
        patternCall.setCalled(p1);
        patternCall.getParameterMatching().put(param1, param2);
        p3.getOrchestration().add(patternCall);
    }

    public void createDebugPattern15(PatternLibrary lib) {
        Pattern p1 = createPattern(lib, "Pattern GrandParent");
        Pattern p2 = createPattern(lib, "Pattern Parent");
        Pattern p3 = createPattern(lib, "Pattern Child");

        p2.setSuperPattern(p1);
        p3.setSuperPattern(p2);

        // set up P1
        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("myGrandParentParam");
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass");
        param1.setQuery(createBasicQuery());
        p1.getParameters().add(param1);

        // set up P2
        p2.getOrchestration().clear();

        // set up P3
        p3.getOrchestration().clear();
    }

    public void createDebugPattern14(PatternLibrary lib) {
        Pattern p1 = createPattern(lib, "Pattern GrandParent");
        Pattern p2 = createPattern(lib, "Pattern Parent");
        Pattern p3 = createPattern(lib, "Pattern Child");

        p2.setSuperPattern(p1);
        p3.setSuperPattern(p2);

        // set up P1
        PatternMethod method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("test1");
        p1.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));
        PatternMethod method2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method2.setName("test2");
        p1.getMethods().add(method2);
        method2.setPatternFilePath(createURI(method2));

        MethodCall methodCall1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createMethodCall();
        methodCall1.setCalled(method1);
        p1.getOrchestration().add(methodCall1);
        MethodCall methodCall2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createMethodCall();
        methodCall2.setCalled(method2);
        p1.getOrchestration().add(methodCall2);

        // set up P2
        method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("test1");
        p2.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));

        p2.getOrchestration().clear();

        // set up P3
        method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("test2");
        p3.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));

        p3.getOrchestration().clear();
    }

    public void createDebugPattern13(PatternLibrary lib) {
        Pattern p1 = createPattern(lib, "Pattern UN");
        Pattern p2 = createPattern(lib, "Pattern DEUX");
        Pattern p3 = createPattern(lib, "Pattern TROIS");

        p2.setSuperPattern(p1);
        p3.setSuperPattern(p1);

        PatternMethod method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("run1");
        p1.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));

        MethodCall methodCall1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createMethodCall();
        methodCall1.setCalled(method1);
        p1.getOrchestration().add(methodCall1);

        // P2 overrides method run1
        method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("run1");
        p2.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));
        p2.getOrchestration().clear();

        // P3 overrides the orchestration
        p3.getOrchestration().clear();
        // TODO... need to add a superPatternCall
    }

    public void createDebugPattern12(PatternLibrary lib) {
        Pattern p1 = createPattern(lib, "Pattern UN");
        Pattern p2 = createPattern(lib, "Pattern DEUX");
        Pattern p3 = createPattern(lib, "Pattern TROIS");

        PatternMethod method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("run1");
        p1.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));

        MethodCall methodCall1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createMethodCall();
        methodCall1.setCalled(method1);
        p1.getOrchestration().add(methodCall1);

        p2.setSuperPattern(p1);
        p3.setSuperPattern(p2);
    }

    public void createDebugPattern11(PatternLibrary lib) {
        Pattern p1 = createPattern(lib, "Pattern UN");
        Pattern p2 = createPattern(lib, "Pattern DEUX");
        Pattern p3 = createPattern(lib, "Pattern TROIS");

        PatternLibrary subLib = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternLibrary();
        subLib.setName("subLib");
        lib.getElements().add(subLib);

        Pattern sp1 = createPattern(subLib, "Sub UN");
        Pattern sp2 = createPattern(subLib, "Sub DEUX");
        Pattern sp3 = createPattern(subLib, "Sub TROIS");

        EList<PatternElement> rule1 = new BasicEList<PatternElement>();
        rule1.add(subLib);
        rule1.add(p1);
        rule1.add(p2);
        // make sure the list is ok before putting it into the map
        lib.getFilters().put("rule1", rule1);

        EList<PatternElement> srule1 = new BasicEList<PatternElement>();
        srule1.add(sp2);
        srule1.add(sp1);
        subLib.getFilters().put("rule12", srule1);

    }

    public void createDebugPattern9(PatternLibrary lib) {
        Pattern p1 = createPattern(lib, "Pattern UN");
        Pattern p2 = createPattern(lib, "Pattern DEUX");
        Pattern p3 = createPattern(lib, "Pattern TROIS");

        PatternLibrary subLib = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternLibrary();
        subLib.setName("subLib");
        lib.getElements().add(subLib);

        Pattern sp1 = createPattern(subLib, "Sub UN");
        Pattern sp2 = createPattern(subLib, "Sub DEUX");
        Pattern sp3 = createPattern(subLib, "Sub TROIS");

    }

    public List<Pattern> createDebugPattern8(PatternLibrary lib) {
        List<Pattern> result = new ArrayList<Pattern>();
        Pattern p1 = createPattern(lib, "Pattern UN");
        Pattern p2 = createPattern(lib, "Pattern DEUX");
        Pattern p3 = createPattern(lib, "Pattern TROIS");

        PatternCall patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
        patternCall.setCalled(p2);
        p1.getOrchestration().add(patternCall);

        patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
        patternCall.setCalled(p3);
        p2.getOrchestration().add(patternCall);

        result.add(p3);
        result.add(p1);
        result.add(p2);
        return result;
    }

    public List<Pattern> createDebugPattern7(PatternLibrary lib) {
        List<Pattern> result = new ArrayList<Pattern>();
        Pattern parentPattern = createPattern(lib, "ParentPattern");
        Pattern childPattern = createPattern(lib, "ChildPattern");

        PatternVariable var1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternVariable();
        var1.setName("myVar");
        var1.setType("String");
        parentPattern.getVariables().add(var1);

        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("myParam");
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass");
        param1.setQuery(createBasicQuery());
        childPattern.getParameters().add(param1);

        PatternInjectedCall iCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternInjectedCall();
        iCall.setContext(var1);
        iCall.setCalled(childPattern);
        iCall.setPattern(parentPattern);

        // PatternCall call =
        // org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
        // call.setCalled(childPattern);
        // call.setPattern(parentPattern);

        result.add(parentPattern);
        result.add(childPattern);
        return result;
    }

    public List<Pattern> createDebugPattern6(PatternLibrary lib) {
        List<Pattern> result = new ArrayList<Pattern>();
        Pattern createPattern = createPattern(lib, "MyPattern");
        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("myParam");
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass");
        param1.setQuery(createBasicQuery());
        createPattern.getParameters().add(param1);
        result.add(createPattern);
        return result;
    }

    private Query createBasicQuery() {
        BasicQuery createBasicQuery = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createBasicQuery();
        createBasicQuery.setExtensionId("org.eclipse.egf.pattern.basic.query");
        return createBasicQuery;
    }

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
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass");
        parent.getParameters().add(param1);
        PatternParameter param12 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param12.setName("parentP2");
        param12.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass");
        parent.getParameters().add(param12);

        Pattern child = createPattern(lib, "child");
        PatternParameter param2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param2.setName("childP");
        param2.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass");
        child.getParameters().add(param2);
        PatternCall patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
        patternCall.getParameterMatching().put(param2, param12);
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
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass");
        parent.getParameters().add(param1);

        Pattern child = createPattern(lib, "child");
        PatternParameter param2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param2.setName("childP");
        param2.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass");
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

        /*
         * PatternVariable var1 =
         * org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE
         * .createPatternVariable();
         * checkId(var1);
         * var1.setName("var1");
         * var1.setType("String");
         * pattern.getVariables().add(var1);
         * PatternVariable var2 =
         * org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE
         * .createPatternVariable();
         * checkId(var2);
         * var2.setName("var2");
         * var2.setType("java.util.List");
         * pattern.getVariables().add(var2);
         */
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
