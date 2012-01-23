//Generated on Mon Jan 23 11:17:14 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.emf.pattern.model;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ResourceFactoryClass extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
    protected static String nl;

    public static synchronized ResourceFactoryClass create(String lineSeparator) {
        nl = lineSeparator;
        ResourceFactoryClass result = new ResourceFactoryClass();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL + "package ";
    protected final String TEXT_3 = ";" + NL;
    protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * The <b>Resource Factory</b> associated with the package." + NL + " * <!-- end-user-doc -->" + NL + " * @see ";
    protected final String TEXT_5 = NL + " * @generated" + NL + " */" + NL + "public class ";
    protected final String TEXT_6 = " extends ";
    protected final String TEXT_7 = NL + "{";
    protected final String TEXT_8 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
    protected final String TEXT_9 = " copyright = ";
    protected final String TEXT_10 = ";";
    protected final String TEXT_11 = NL;
    protected final String TEXT_12 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
    protected final String TEXT_13 = " extendedMetaData;" + NL;
    protected final String TEXT_14 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
    protected final String TEXT_15 = " xmlMap = new ";
    protected final String TEXT_16 = "();" + NL;
    protected final String TEXT_17 = NL + "\t/**" + NL + "\t * Creates an instance of the resource factory." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
    protected final String TEXT_18 = "()" + NL + "\t{" + NL + "\t\tsuper();";
    protected final String TEXT_19 = NL + "\t\textendedMetaData = new ";
    protected final String TEXT_20 = "(new ";
    protected final String TEXT_21 = "(";
    protected final String TEXT_22 = ".Registry.INSTANCE));" + NL + "\t\textendedMetaData.putPackage(null, ";
    protected final String TEXT_23 = ".eINSTANCE);";
    protected final String TEXT_24 = NL + "\t\txmlMap.setNoNamespacePackage(";
    protected final String TEXT_25 = ".eINSTANCE);";
    protected final String TEXT_26 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Creates an instance of the resource." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_27 = NL + "\t@Override";
    protected final String TEXT_28 = NL + "\tpublic Resource createResource(URI uri)" + NL + "\t{";
    protected final String TEXT_29 = NL;
    protected final String TEXT_30 = NL + "\t}" + NL + "" + NL + "} //";
    protected final String TEXT_31 = NL;
    protected final String TEXT_32 = NL;
    protected final String TEXT_33 = NL;

    public ResourceFactoryClass() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;
        Node.Container currentNode = ctx.getNode();

        List<Object> parameterList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object parameterParameter : parameterList) {

            this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) parameterParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_32);
        stringBuffer.append(TEXT_33);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        method_preGenerate(new StringBuffer(), ictx);

        method_doGenerate(new StringBuffer(), ictx);
        {
            final Map<String, Object> parameters = getParameters();
            CallbackContext ctx_callback = new CallbackContext(ictx);
            CallHelper.callBack(ctx_callback, parameters);
        }

        method_postGenerate(new StringBuffer(), ictx);

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("parameter", this.parameter);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("parameter", this.parameter);
        return parameters;
    }

    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenPackage genPackage = parameter;
        targetPath = genPackage.getGenModel().getModelDirectory();
        packageName = genPackage.getUtilitiesPackageName();
        className = genPackage.getResourceFactoryClassName();

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
    }

    protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenPackage genPackage = parameter;
        argument = parameter;

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
    }

    protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        /**
         * <copyright>
         *
         * Copyright (c) 2002-2006 IBM Corporation and others.
         * All rights reserved.   This program and the accompanying materials
         * are made available under the terms of the Eclipse Public License v1.0
         * which accompanies this distribution, and is available at
         * http://www.eclipse.org/legal/epl-v10.html
         *
         * Contributors:
         *   IBM - Initial API and implementation
         *
         * </copyright>
         */

        GenPackage genPackage = (GenPackage) argument;
        GenModel genModel = genPackage.getGenModel();
        stringBuffer.append(TEXT_1);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

            InternalPatternContext ictx = (InternalPatternContext) ctx;
            new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
            stringBuffer.setLength(0);

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("argument", parameter);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(genPackage.getUtilitiesPackageName());
        stringBuffer.append(TEXT_3);
        genModel.getImportedName("org.eclipse.emf.common.util.URI");
        genModel.getImportedName("org.eclipse.emf.ecore.resource.Resource");
        genModel.markImportLocation(stringBuffer);
        stringBuffer.append(TEXT_4);
        stringBuffer.append(genPackage.getQualifiedResourceClassName());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(genPackage.getResourceFactoryClassName());
        stringBuffer.append(TEXT_6);
        stringBuffer.append(genPackage.getImportedResourceFactoryBaseClassName());
        stringBuffer.append(TEXT_7);
        if (genModel.hasCopyrightField()) {
            stringBuffer.append(TEXT_8);
            stringBuffer.append(genModel.getImportedName("java.lang.String"));
            stringBuffer.append(TEXT_9);
            stringBuffer.append(genModel.getCopyrightFieldLiteral());
            stringBuffer.append(TEXT_10);
            stringBuffer.append(genModel.getNonNLS());
            stringBuffer.append(TEXT_11);
        }
        if (genPackage.hasExtendedMetaData() && !genPackage.hasTargetNamespace()) {
            stringBuffer.append(TEXT_12);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.ExtendedMetaData"));
            stringBuffer.append(TEXT_13);
        } else if (genPackage.hasXMLMap()) {
            stringBuffer.append(TEXT_14);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource$XMLMap"));
            stringBuffer.append(TEXT_15);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.impl.XMLMapImpl"));
            stringBuffer.append(TEXT_16);
        }
        stringBuffer.append(TEXT_17);
        stringBuffer.append(genPackage.getResourceFactoryClassName());
        stringBuffer.append(TEXT_18);
        if (genPackage.hasExtendedMetaData() && !genPackage.hasTargetNamespace()) {
            stringBuffer.append(TEXT_19);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.BasicExtendedMetaData"));
            stringBuffer.append(TEXT_20);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.EPackageRegistryImpl"));
            stringBuffer.append(TEXT_21);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EPackage"));
            stringBuffer.append(TEXT_22);
            stringBuffer.append(genPackage.getImportedPackageInterfaceName());
            stringBuffer.append(TEXT_23);
        } else if (genPackage.hasXMLMap() && !genPackage.hasTargetNamespace()) {
            stringBuffer.append(TEXT_24);
            stringBuffer.append(genPackage.getImportedPackageInterfaceName());
            stringBuffer.append(TEXT_25);
        }
        stringBuffer.append(TEXT_26);
        if (genModel.useClassOverrideAnnotation()) {
            stringBuffer.append(TEXT_27);
        }
        stringBuffer.append(TEXT_28);
        stringBuffer.append(TEXT_29);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.ResourceFactoryClass.ResourceFactoryClass.createResource.override" args="genPackage:genPackage,genModel:genModel"%>

            InternalPatternContext ictx = (InternalPatternContext) ctx;
            new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
            stringBuffer.setLength(0);

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("genPackage", genPackage);
            callParameters.put("genModel", genModel);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0uqqgWJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        //ResourceFactoryClass/createResource.override.javajetinc
        stringBuffer.append(TEXT_30);
        stringBuffer.append(genPackage.getResourceFactoryClassName());
        genModel.emitSortedImports();
        stringBuffer.append(TEXT_31);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        GenPackage genPackage = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
        canGenerate = canGenerate && (genPackage.getResource() != GenResourceKind.NONE_LITERAL);
        return canGenerate;
    }
}