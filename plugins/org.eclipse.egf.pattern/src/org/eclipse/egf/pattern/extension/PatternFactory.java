/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.extension;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egf.core.fcore.IPlatformFcoreProvider;
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
import org.eclipse.egf.model.pattern.SuperCall;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

/**
 * @author Guiu
 */
public abstract class PatternFactory {

    public static final String INIT_METHOD_NAME = "init"; //$NON-NLS-1$

    public static final String HEADER_METHOD_NAME = "header"; //$NON-NLS-1$

    public static final String FOOTER_METHOD_NAME = "footer"; //$NON-NLS-1$

    public static final String PRECONDITION_METHOD_NAME = "preCondition"; //$NON-NLS-1$

    public static final String BODY_METHOD_NAME = "body"; //$NON-NLS-1$

    public static boolean isSpecialMethod(String name) {
        return HEADER_METHOD_NAME.equals(name) || INIT_METHOD_NAME.equals(name) || PRECONDITION_METHOD_NAME.equals(name) || FOOTER_METHOD_NAME.equals(name);
    }

    public void createDebugPatternUC5(PatternLibrary lib) {

        Pattern p1 = createPattern(lib, "Pattern UN"); //$NON-NLS-1$

        PatternVariable var1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternVariable();
        var1.setName("myVar"); //$NON-NLS-1$
        var1.setType("String"); //$NON-NLS-1$
        p1.getVariables().add(var1);

        PatternMethod method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("My_Method_1"); //$NON-NLS-1$
        p1.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));

    }

    public void createDebugPatternUC4(PatternLibrary lib) {

        Pattern parentPattern = createPattern(lib, "Pattern UN"); //$NON-NLS-1$
        Pattern childPattern = createPattern(lib, "Pattern DEUX"); //$NON-NLS-1$

        PatternVariable var1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternVariable();
        var1.setName("myVar"); //$NON-NLS-1$
        var1.setType("String"); //$NON-NLS-1$
        parentPattern.getVariables().add(var1);
        PatternInjectedCall patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternInjectedCall();
        patternCall.setContext(var1);
        patternCall.setCalled(childPattern);

        childPattern.getVariables().add(var1);

    }

    public void createDebugPatternUC3(PatternLibrary lib) {

        Pattern p1 = createPattern(lib, "Pattern Called"); //$NON-NLS-1$
        Pattern p2 = createPattern(lib, "Pattern Parent"); //$NON-NLS-1$
        Pattern p3 = createPattern(lib, "Pattern Child"); //$NON-NLS-1$

        p1.setSuperPattern(p2);

        // set up P1
        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("myCalledParam"); //$NON-NLS-1$
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass"); //$NON-NLS-1$
        param1.setQuery(createBasicQuery());
        p1.getParameters().add(param1);

        // set up P2
        PatternParameter param2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param2.setName("myChildParam"); //$NON-NLS-1$
        param2.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass"); //$NON-NLS-1$
        param2.setQuery(createBasicQuery());
        p2.getParameters().add(param2);

        // set up P3
        PatternCall patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
        patternCall.setCalled(p1);
        patternCall.getParameterMatching().put(param1, param2);
        p3.getOrchestration().add(patternCall);

    }

    public void createDebugPattern15(PatternLibrary lib) {

        Pattern p1 = createPattern(lib, "Pattern GrandParent"); //$NON-NLS-1$
        Pattern p2 = createPattern(lib, "Pattern Parent"); //$NON-NLS-1$
        Pattern p3 = createPattern(lib, "Pattern Child"); //$NON-NLS-1$

        p2.setSuperPattern(p1);
        p3.setSuperPattern(p2);

        // set up P1
        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("myGrandParentParam"); //$NON-NLS-1$
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass"); //$NON-NLS-1$
        param1.setQuery(createBasicQuery());
        p1.getParameters().add(param1);

        // set up P2
        p2.getOrchestration().clear();

        // set up P3
        p3.getOrchestration().clear();

    }

    public void createDebugPattern14(PatternLibrary lib) {

        Pattern p1 = createPattern(lib, "Pattern GrandParent"); //$NON-NLS-1$
        Pattern p2 = createPattern(lib, "Pattern Parent"); //$NON-NLS-1$
        Pattern p3 = createPattern(lib, "Pattern Child"); //$NON-NLS-1$

        p2.setSuperPattern(p1);
        p3.setSuperPattern(p2);

        // set up P1
        PatternMethod method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("test1"); //$NON-NLS-1$
        p1.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));
        PatternMethod method2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method2.setName("test2"); //$NON-NLS-1$
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
        method1.setName("test1"); //$NON-NLS-1$
        p2.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));

        p2.getOrchestration().clear();

        // set up P3
        method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("test2"); //$NON-NLS-1$
        p3.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));

        p3.getOrchestration().clear();

    }

    public void createDebugPattern13(PatternLibrary lib) {

        Pattern p1 = createPattern(lib, "Pattern UN"); //$NON-NLS-1$
        Pattern p2 = createPattern(lib, "Pattern DEUX"); //$NON-NLS-1$
        Pattern p3 = createPattern(lib, "Pattern TROIS"); //$NON-NLS-1$

        p2.setSuperPattern(p1);
        p3.setSuperPattern(p1);

        PatternMethod method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("run1"); //$NON-NLS-1$
        p1.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));

        MethodCall methodCall1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createMethodCall();
        methodCall1.setCalled(method1);
        p1.getOrchestration().add(methodCall1);

        // P2 overrides method run1
        method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("run1"); //$NON-NLS-1$
        p2.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));
        p2.getOrchestration().clear();

        // P3 overrides the orchestration
        p3.getOrchestration().clear();
        // TODO... need to add a superPatternCall
    }

    public void createDebugPattern12(PatternLibrary lib) {

        Pattern p1 = createPattern(lib, "Pattern UN"); //$NON-NLS-1$
        Pattern p2 = createPattern(lib, "Pattern DEUX"); //$NON-NLS-1$
        Pattern p3 = createPattern(lib, "Pattern TROIS"); //$NON-NLS-1$

        PatternMethod method1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        method1.setName("run1"); //$NON-NLS-1$
        p1.getMethods().add(method1);
        method1.setPatternFilePath(createURI(method1));

        MethodCall methodCall1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createMethodCall();
        methodCall1.setCalled(method1);
        p1.getOrchestration().add(methodCall1);

        p2.setSuperPattern(p1);
        p3.setSuperPattern(p2);

    }

    @SuppressWarnings("unused")
    public void createDebugPattern11(PatternLibrary lib) {

        Pattern p1 = createPattern(lib, "Pattern UN"); //$NON-NLS-1$
        Pattern p2 = createPattern(lib, "Pattern DEUX"); //$NON-NLS-1$
        Pattern p3 = createPattern(lib, "Pattern TROIS"); //$NON-NLS-1$

        PatternLibrary subLib = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternLibrary();
        subLib.setName("subLib"); //$NON-NLS-1$
        // lib.getPatterns().add(subLib);

        Pattern sp1 = createPattern(subLib, "Sub UN"); //$NON-NLS-1$
        Pattern sp2 = createPattern(subLib, "Sub DEUX"); //$NON-NLS-1$
        Pattern sp3 = createPattern(subLib, "Sub TROIS"); //$NON-NLS-1$

        EList<PatternElement> rule1 = new BasicEList<PatternElement>();
        rule1.add(subLib);
        rule1.add(p1);
        rule1.add(p2);
        // make sure the list is ok before putting it into the map
        lib.getFilters().put("rule1", rule1); //$NON-NLS-1$

        EList<PatternElement> srule1 = new BasicEList<PatternElement>();
        srule1.add(sp2);
        srule1.add(sp1);
        subLib.getFilters().put("rule12", srule1); //$NON-NLS-1$

    }

    public List<Pattern> createDebugPatternUC2(PatternLibrary lib) {

        List<Pattern> result = new ArrayList<Pattern>();
        Pattern p1 = createPattern(lib, "Pattern UN"); //$NON-NLS-1$
        Pattern p2 = createPattern(lib, "Pattern DEUX"); //$NON-NLS-1$
        Pattern p3 = createPattern(lib, "Pattern TROIS"); //$NON-NLS-1$

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
        Pattern parentPattern = createPattern(lib, "ParentPattern"); //$NON-NLS-1$
        Pattern childPattern = createPattern(lib, "ChildPattern"); //$NON-NLS-1$

        PatternVariable var1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternVariable();
        var1.setName("myVar"); //$NON-NLS-1$
        var1.setType("String"); //$NON-NLS-1$
        parentPattern.getVariables().add(var1);

        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("myParam"); //$NON-NLS-1$
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass"); //$NON-NLS-1$
        param1.setQuery(createBasicQuery());
        childPattern.getParameters().add(param1);

        PatternInjectedCall iCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternInjectedCall();
        iCall.setContext(var1);
        iCall.setCalled(childPattern);
        // iCall.setPattern(parentPattern);
        parentPattern.getOrchestration().add(iCall);

        // PatternCall call =
        // PatternFactory.eINSTANCE.createPatternCall();
        // call.setCalled(childPattern);
        // call.setPattern(parentPattern);

        result.add(parentPattern);
        result.add(childPattern);
        return result;

    }

    public List<Pattern> createDebugPattern6(PatternLibrary lib) {
        List<Pattern> result = new ArrayList<Pattern>();
        Pattern createPattern = createPattern(lib, "MyPattern"); //$NON-NLS-1$
        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("myParam"); //$NON-NLS-1$
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass"); //$NON-NLS-1$
        param1.setQuery(createBasicQuery());
        createPattern.getParameters().add(param1);
        result.add(createPattern);
        return result;
    }

    private Query createBasicQuery() {
        BasicQuery createBasicQuery = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createBasicQuery();
        createBasicQuery.setExtensionId("org.eclipse.egf.pattern.basic.query"); //$NON-NLS-1$
        return createBasicQuery;
    }

    public Pattern createDebugPattern1(PatternLibrary lib) {
        Pattern createPattern = createPattern(lib, "MyPattern"); //$NON-NLS-1$
        return createPattern;
    }

    public List<Pattern> createDebugPattern3(PatternLibrary lib) {
        List<Pattern> result = new ArrayList<Pattern>();
        Pattern parent = createPattern(lib, "parent"); //$NON-NLS-1$
        Pattern child = createPattern(lib, "child"); //$NON-NLS-1$
        PatternCall patternCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternCall();
        patternCall.setCalled(child);
        parent.getOrchestration().add(patternCall);
        result.add(parent);
        result.add(child);

        return result;

    }

    public List<Pattern> createDebugPatternUC1(PatternLibrary lib) {
        List<Pattern> result = new ArrayList<Pattern>();
        Pattern parent = createPattern(lib, "parent"); //$NON-NLS-1$
        Pattern child = createPattern(lib, "child"); //$NON-NLS-1$
        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("parentP1"); //$NON-NLS-1$
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass"); //$NON-NLS-1$
        parent.getParameters().add(param1);
        PatternParameter param12 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param12.setName("parentP2"); //$NON-NLS-1$
        param12.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass"); //$NON-NLS-1$
        parent.getParameters().add(param12);

        PatternParameter param2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param2.setName("childP"); //$NON-NLS-1$
        param2.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass"); //$NON-NLS-1$
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
        Pattern parent = createPattern(lib, "parent"); //$NON-NLS-1$
        PatternParameter param1 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param1.setName("parentP"); //$NON-NLS-1$
        param1.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass"); //$NON-NLS-1$
        parent.getParameters().add(param1);

        Pattern child = createPattern(lib, "child"); //$NON-NLS-1$
        PatternParameter param2 = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternParameter();
        param2.setName("childP"); //$NON-NLS-1$
        param2.setType("http://www.eclipse.org/emf/2002/Ecore#//EClass"); //$NON-NLS-1$
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
        // checkId(pattern);
        addNature(pattern);

        /*
         * PatternVariable var1 =
         * PatternFactory.eINSTANCE
         * .createPatternVariable();
         * checkId(var1);
         * var1.setName("var1");
         * var1.setType("String");
         * pattern.getVariables().add(var1);
         * PatternVariable var2 =
         * PatternFactory.eINSTANCE
         * .createPatternVariable();
         * checkId(var2);
         * var2.setName("var2");
         * var2.setType("java.util.List");
         * pattern.getVariables().add(var2);
         */
        // 1 - create default content
        PatternMethod headerMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        pattern.getMethods().add(headerMethod);
        pattern.setHeaderMethod(headerMethod);
        initHeader(headerMethod);

        PatternMethod initMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        pattern.getMethods().add(initMethod);
        pattern.setInitMethod(initMethod);
        initIinit(initMethod);

        PatternMethod preConditionMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        pattern.getMethods().add(preConditionMethod);
        pattern.setConditionMethod(preConditionMethod);
        initPreCondition(preConditionMethod);

        PatternMethod bodyMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        pattern.getMethods().add(bodyMethod);
        initBody(bodyMethod);

        PatternMethod footerMethod = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternMethod();
        pattern.getMethods().add(footerMethod);
        pattern.setFooterMethod(footerMethod);
        initFooter(footerMethod);

        // 2 - set up default orchestration
        SuperCall superCall = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createSuperCall();
        pattern.getOrchestration().add(superCall);
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

    protected void initBody(PatternMethod method) {
        method.setName(BODY_METHOD_NAME);
        method.setPatternFilePath(createURI(method));
    }

    protected void initHeader(PatternMethod method) {
        method.setName(HEADER_METHOD_NAME);
        method.setPatternFilePath(createURI(method));
    }

    protected void initIinit(PatternMethod method) {
        method.setName(INIT_METHOD_NAME);
        method.setPatternFilePath(createURI(method));
    }

    protected void initPreCondition(PatternMethod method) {
        method.setName(PRECONDITION_METHOD_NAME);
        method.setPatternFilePath(createURI(method));
    }

    public URI createURI(PatternMethod method) {
        if (method.getID() == null || method.eResource() == null || method.eResource() instanceof IPlatformFcoreProvider == false)
            return null;
        return TemplateModelFileHelper.computeFileURI(((IPlatformFcoreProvider) method.eResource()).getIPlatformFcore(), method);
    }

    /**
     * @param pattern
     */
    protected abstract void addNature(Pattern pattern);

}
