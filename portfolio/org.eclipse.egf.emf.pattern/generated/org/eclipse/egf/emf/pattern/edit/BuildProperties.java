//Generated on Mon Jan 23 11:17:18 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.emf.pattern.edit;

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

public class BuildProperties extends org.eclipse.egf.emf.pattern.base.GenModelText {
    protected static String nl;

    public static synchronized BuildProperties create(String lineSeparator) {
        nl = lineSeparator;
        BuildProperties result = new BuildProperties();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL + NL + "bin.includes = ";
    protected final String TEXT_3 = ",\\";
    protected final String TEXT_4 = NL + "               icons/,\\";
    protected final String TEXT_5 = NL + "               META-INF/,\\";
    protected final String TEXT_6 = NL + "               plugin.xml,\\";
    protected final String TEXT_7 = NL + "               plugin.properties" + NL + "jars.compile.order = ";
    protected final String TEXT_8 = NL + "source.";
    protected final String TEXT_9 = " = ";
    protected final String TEXT_10 = NL + "output.";
    protected final String TEXT_11 = " = bin/" + NL;
    protected final String TEXT_12 = NL;
    protected final String TEXT_13 = NL;

    public BuildProperties() {
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

            this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) parameterParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_12);
        stringBuffer.append(TEXT_13);
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

        GenModel genModel = parameter;
        targetPathName = genModel.getEditProjectDirectory() + "/build.properties";
        overwrite = genModel.isUpdateClasspath() && !new CodegenGeneratorAdapter(parameter).exists(new CodegenGeneratorAdapter(parameter).toURI(genModel.getEditProjectDirectory()).appendSegment("plugin.xml"));
        encoding = "ISO-8859-1";

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
    }

    protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenModel genModel = parameter;
        argument = parameter;

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
    }

    protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditDirectory(), genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        /**
         * <copyright>
         *
         * Copyright (c) 2002-2010 IBM Corporation and others.
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

        GenModel genModel = (GenModel) argument;
        String pluginClassesLocation = genModel.isRuntimeJar() ? genModel.getEditPluginID() + ".jar" : ".";
        List<String> sourceFolders = genModel.getEditSourceFolders();
        stringBuffer.append(TEXT_1);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderProperties" args="parameter:argument"%>

            InternalPatternContext ictx = (InternalPatternContext) ctx;
            new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
            stringBuffer.setLength(0);

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("argument", parameter);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_FEoPwCwuEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(pluginClassesLocation);
        stringBuffer.append(TEXT_3);
        if (genModel.getRuntimePlatform() != GenRuntimePlatform.GWT) {
            stringBuffer.append(TEXT_4);
        }
        if (genModel.isBundleManifest()) {
            stringBuffer.append(TEXT_5);
        }
        if (genModel.getRuntimePlatform() != GenRuntimePlatform.GWT) {
            stringBuffer.append(TEXT_6);
        }
        stringBuffer.append(TEXT_7);
        stringBuffer.append(pluginClassesLocation);
        boolean first = true;
        for (Iterator<String> i = sourceFolders.iterator(); i.hasNext();) {
            String sourceFolder = i.next();
            if (i.hasNext()) {
                sourceFolder += ",\\";
            }
            if (first) {
                stringBuffer.append(TEXT_8);
                stringBuffer.append(pluginClassesLocation);
                stringBuffer.append(TEXT_9);
                stringBuffer.append(sourceFolder);
                first = false;
            } else {
                stringBuffer.append(sourceFolder);
            }
        }
        stringBuffer.append(TEXT_10);
        stringBuffer.append(pluginClassesLocation);
        stringBuffer.append(TEXT_11);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        GenModel genModel = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
        canGenerate = canGenerate && true;
        return canGenerate;
    }
}