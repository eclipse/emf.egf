package org.eclipse.egf.emf.pattern.editor;

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

public class HomeHTML extends org.eclipse.egf.emf.pattern.base.GenModelText {
    protected static String nl;

    public static synchronized HomeHTML create(String lineSeparator) {
        nl = lineSeparator;
        HomeHTML result = new HomeHTML();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<!doctype html>" + NL + "<html style=\"height : 100%\"> " + NL + "  <head>" + NL + "    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">" + NL + "" + NL + "    <!--                                           -->" + NL + "    <!-- Any title is fine                         -->" + NL + "    <!--                                           -->" + NL + "    <title>";
    protected final String TEXT_2 = " Application</title>" + NL + "    " + NL + "    <style TYPE=\"text/css\">" + NL + "      <!--" + NL + "        .ToolBar" + NL + "        {" + NL + "          background-color: #d0e4f6;" + NL + "        }" + NL + "        .ToolBarButton" + NL + "        {" + NL + "          float: left;" + NL + "          margin-top: 5px;" + NL + "        }" + NL + "        .ToolBarButtonLeftMargin" + NL + "        {" + NL + "          float: left;" + NL + "          margin-left: 10px;" + NL + "          margin-top: 5px;" + NL + "        }" + NL + "        .Header" + NL + "        {" + NL + "          background-color: #628cd5;" + NL + "          color: #FFFFFF;" + NL + "          float: left;" + NL + "          font-weight: bold;" + NL
            + "          font-size: xx-large;" + NL + "        }" + NL + "        .HeaderLabel" + NL + "        {" + NL + "          float: left;" + NL + "          margin-left: 10px;" + NL + "        }" + NL + "        .PropertiesTitle" + NL + "        {" + NL + "          background-color: #628cd5;" + NL + "          color: #FFFFFF;" + NL + "          font-weight: bold;" + NL + "          font-size: large;" + NL + "        }" + NL + "        .PropertiesTitleLabel" + NL + "        {" + NL + "          float: left;" + NL + "          margin-left: 5px;" + NL + "        }" + NL + "      -->" + NL + "    </style>" + NL + "" + NL + "    <!--                                           -->" + NL + "    <!-- This script loads your compiled module.   -->" + NL
            + "    <!-- If you add any GWT meta tags, they must   -->" + NL + "    <!-- be added before this line.                -->" + NL + "    <script type=\"text/javascript\" language=\"javascript\" src=\"";
    protected final String TEXT_3 = "/";
    protected final String TEXT_4 = ".nocache.js\"></script>" + NL + "  </head>" + NL + "" + NL + "  <body style=\"height : 100%\">" + NL + "    <div id=\"main\" style=\"height : 100%\">" + NL + "    </div>" + NL + "  </body>" + NL + "</html>" + NL;
    protected final String TEXT_5 = NL;
    protected final String TEXT_6 = NL;

    public HomeHTML() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> parameterList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object parameterParameter : parameterList) {

            this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) parameterParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_5);
        stringBuffer.append(TEXT_6);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        method_preGenerate(ictx.getBuffer(), ictx);

        method_doGenerate(ictx.getBuffer(), ictx);
        {
            ictx.setExecutionCurrentIndex(ictx.getBuffer().length());
            ictx.getExecutionBuffer().append(ictx.getBuffer());
            final Map<String, Object> parameters = getParameters();
            CallbackContext ctx_callback = new CallbackContext(ictx);
            CallHelper.callBack(ctx_callback, parameters);
        }

        method_postGenerate(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("parameter", this.parameter);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("parameter", this.parameter);
        return parameters;
    }

    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenModel genModel = parameter;
        targetPathName = genModel.getEditorProjectDirectory() + "/war/" + genModel.getEditorHomePageName() + ".html";
        overwrite = false;
        encoding = "UTF-8";

    }

    protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GenModel genModel = parameter;
        argument = parameter;

    }

    protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditorDirectory(), genModel, GenBaseGeneratorAdapter.EDITOR_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        /**
         * <copyright>
         *
         * Copyright (c) 2010 Ed Merks and others.
         * All rights reserved.   This program and the accompanying materials
         * are made available under the terms of the Eclipse Public License v1.0
         * which accompanies this distribution, and is available at
         * http://www.eclipse.org/legal/epl-v10.html
         * 
         * Contributors: 
         *   Ed Merks - Initial API and implementation
         *
         * </copyright>
         */

        GenModel genModel = (GenModel) argument; /* Trick to import java.util.* without warnings */
        Iterator.class.getName();
        stringBuffer.append(TEXT_1);
        stringBuffer.append(genModel.getModelName());
        stringBuffer.append(TEXT_2);
        stringBuffer.append(genModel.getQualifiedEditorModuleName());
        stringBuffer.append(TEXT_3);
        stringBuffer.append(genModel.getQualifiedEditorModuleName());
        stringBuffer.append(TEXT_4);
    }

    public boolean preCondition() throws Exception {
        GenModel genModel = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditorProject");
        canGenerate = canGenerate && (genModel.getRuntimePlatform() == GenRuntimePlatform.GWT);
        return canGenerate;
    }
}