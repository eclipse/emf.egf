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

public class PluginProperties extends org.eclipse.egf.emf.pattern.base.GenModelProperties {
    protected static String nl;

    public static synchronized PluginProperties create(String lineSeparator) {
        nl = lineSeparator;
        PluginProperties result = new PluginProperties();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL + NL + "# ====================================================================" + NL + "# To code developer:" + NL + "#   Do NOT change the properties between this line and the" + NL + "#   \"%%% END OF TRANSLATED PROPERTIES %%%\" line." + NL + "#   Make a new property name, append to the end of the file and change" + NL + "#   the code to use the new property." + NL + "# ====================================================================" + NL + "" + NL + "# ====================================================================" + NL + "# %%% END OF TRANSLATED PROPERTIES %%%" + NL + "# ====================================================================" + NL + "" + NL + "pluginName = ";
    protected final String TEXT_3 = " Editor" + NL + "providerName = www.example.org" + NL;
    protected final String TEXT_4 = NL + "_UI_";
    protected final String TEXT_5 = "_menu = &";
    protected final String TEXT_6 = " Editor";
    protected final String TEXT_7 = NL;
    protected final String TEXT_8 = NL + "_UI_CreateChild_menu_item = &New Child" + NL + "_UI_CreateSibling_menu_item = N&ew Sibling" + NL;
    protected final String TEXT_9 = NL + "_UI_ShowPropertiesView_menu_item = Show &Properties View" + NL + "_UI_RefreshViewer_menu_item = &Refresh" + NL + "" + NL + "_UI_SelectionPage_label = Selection";
    protected final String TEXT_10 = NL + "_UI_ParentPage_label = Parent" + NL + "_UI_ListPage_label = List" + NL + "_UI_TreePage_label = Tree" + NL + "_UI_TablePage_label = Table" + NL + "_UI_TreeWithColumnsPage_label = Tree with Columns" + NL + "_UI_ObjectColumn_label = Object" + NL + "_UI_SelfColumn_label = Self";
    protected final String TEXT_11 = NL + NL + "_UI_NoObjectSelected = Selected Nothing" + NL + "_UI_SingleObjectSelected = Selected Object: {0}" + NL + "_UI_MultiObjectSelected = Selected {0} Objects" + NL + "" + NL + "_UI_OpenEditorError_label = Open Editor" + NL + "" + NL + "_UI_Wizard_category = Example EMF Model Creation Wizards" + NL + "" + NL + "_UI_CreateModelError_message = Problems encountered in file \"{0}\"" + NL;
    protected final String TEXT_12 = NL + "_UI_";
    protected final String TEXT_13 = "_label = ";
    protected final String TEXT_14 = " Model" + NL + "_UI_";
    protected final String TEXT_15 = "_description = Create a new ";
    protected final String TEXT_16 = " model" + NL;
    protected final String TEXT_17 = NL + "_UI_";
    protected final String TEXT_18 = "_label = ";
    protected final String TEXT_19 = " Model Editor" + NL + "" + NL + "_UI_";
    protected final String TEXT_20 = "FilenameDefaultBase = My" + NL + "_UI_";
    protected final String TEXT_21 = "FilenameExtension = ";
    protected final String TEXT_22 = NL;
    protected final String TEXT_23 = NL + "_UI_Wizard_label = New" + NL + "" + NL + "_WARN_FilenameExtension = The file name must end in \".{0}\"" + NL + "" + NL + "_UI_ModelObject = &Model Object" + NL + "_UI_XMLEncoding = &XML Encoding" + NL + "_UI_XMLEncodingChoices = ";
    protected final String TEXT_24 = NL + "_UI_Wizard_initial_object_description = Specify a file name and select a model object to create";
    protected final String TEXT_25 = NL + "_UI_Wizard_initial_object_description = Select a model object to create";
    protected final String TEXT_26 = NL + NL + "_UI_FileConflict_label = File Conflict" + NL + "_WARN_FileConflict = There are unsaved changes that conflict with changes made outside the editor.  Do you wish to discard this editor's changes?" + NL;
    protected final String TEXT_27 = NL + "_UI_";
    protected final String TEXT_28 = "_ActionSet_label = ";
    protected final String TEXT_29 = " Action Set" + NL + "_UI_Perspective_label = ";
    protected final String TEXT_30 = NL + NL + "_UI_Browse_label = &Browse..." + NL + "_UI_File_label = &File" + NL + "_UI_Question_title = Question" + NL + "_WARN_FileConflict = The file \"{0}\" already exists.  Do you want to replace the existing file?" + NL + "_UI_Error_title = Error" + NL + "_WARN_No_Editor = There is no editor registered for the file \"{0}\"." + NL + "" + NL + "_UI_Application_title = ";
    protected final String TEXT_31 = " Application" + NL + "_UI_Menu_File_label = &File" + NL + "_UI_Menu_New_label = &New" + NL + "_UI_Menu_Open_label = &Open..." + NL + "_UI_Menu_Open_description = Opens a model object file" + NL + "_UI_Menu_OpenURI_label = &Open URI..." + NL + "_UI_Menu_OpenURI_description = Opens a model object loading it from a URI" + NL + "_UI_Menu_Edit_label = &Edit" + NL + "_UI_Menu_Window_label = &Window" + NL + "_UI_Menu_Help_label = &Help" + NL + "_UI_Menu_About_label = ";
    protected final String TEXT_32 = " &About..." + NL + "_UI_About_title = ";
    protected final String TEXT_33 = " Application" + NL + "_UI_About_text = ";
    protected final String TEXT_34 = " Application about box goes here." + NL;
    protected final String TEXT_35 = NL + "_UI_";
    protected final String TEXT_36 = "_ActionSet_label = ";
    protected final String TEXT_37 = " Model Action Set";
    protected final String TEXT_38 = NL;
    protected final String TEXT_39 = NL;
    protected final String TEXT_40 = NL;
    protected final String TEXT_41 = NL;

    public PluginProperties() {
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

        stringBuffer.append(TEXT_40);
        stringBuffer.append(TEXT_41);
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
        targetPathName = genModel.getEditorProjectDirectory() + "/plugin.properties";

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

        GenModel genModel = (GenModel) argument;
        if (false) {/* Trick to import java.util.* without warnings */
            Iterator.class.getName();
        }
        stringBuffer.append(TEXT_1);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderProperties" args="parameter:argument"%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("argument", parameter);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_FEoPwCwuEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(genModel.getModelName());
        stringBuffer.append(TEXT_3);
        boolean hasMultiPageEditor = false;
        for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
            if (genPackage.isMultipleEditorPages()) {
                hasMultiPageEditor = true;
            }
            stringBuffer.append(TEXT_4);
            stringBuffer.append(genPackage.getEditorClassName());
            stringBuffer.append(TEXT_5);
            stringBuffer.append(genPackage.getPrefix());
            stringBuffer.append(TEXT_6);
        }
        stringBuffer.append(TEXT_7);
        if (genModel.isCreationCommands()) {
            stringBuffer.append(TEXT_8);
        }
        stringBuffer.append(TEXT_9);
        if (hasMultiPageEditor) {
            stringBuffer.append(TEXT_10);
        }
        stringBuffer.append(TEXT_11);
        for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
            if (genPackage.isGenerateModelWizard()) {
                stringBuffer.append(TEXT_12);
                stringBuffer.append(genPackage.getModelWizardClassName());
                stringBuffer.append(TEXT_13);
                stringBuffer.append(genPackage.getPrefix());
                stringBuffer.append(TEXT_14);
                stringBuffer.append(genPackage.getModelWizardClassName());
                stringBuffer.append(TEXT_15);
                stringBuffer.append(genPackage.getPrefix());
                stringBuffer.append(TEXT_16);
            }
            stringBuffer.append(TEXT_17);
            stringBuffer.append(genPackage.getEditorClassName());
            stringBuffer.append(TEXT_18);
            stringBuffer.append(genPackage.getPrefix());
            stringBuffer.append(TEXT_19);
            stringBuffer.append(genPackage.getEditorClassName());
            stringBuffer.append(TEXT_20);
            stringBuffer.append(genPackage.getEditorClassName());
            stringBuffer.append(TEXT_21);
            stringBuffer.append(genPackage.getPrefix().toLowerCase());
            stringBuffer.append(TEXT_22);
        }
        stringBuffer.append(TEXT_23);
        stringBuffer.append(genModel.getXMLEncodingChoices());
        if (genModel.isRichClientPlatform()) {
            stringBuffer.append(TEXT_24);
        } else {
            stringBuffer.append(TEXT_25);
        }
        stringBuffer.append(TEXT_26);
        if (genModel.isRichClientPlatform()) {
            stringBuffer.append(TEXT_27);
            stringBuffer.append(genModel.getEditorAdvisorClassName());
            stringBuffer.append(TEXT_28);
            stringBuffer.append(genModel.getModelName());
            stringBuffer.append(TEXT_29);
            stringBuffer.append(genModel.getModelName());
            stringBuffer.append(TEXT_30);
            stringBuffer.append(genModel.getModelName());
            stringBuffer.append(TEXT_31);
            stringBuffer.append(genModel.getModelName());
            stringBuffer.append(TEXT_32);
            stringBuffer.append(genModel.getModelName());
            stringBuffer.append(TEXT_33);
            stringBuffer.append(genModel.getModelName());
            stringBuffer.append(TEXT_34);
            for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
                if (genPackage.isGenerateModelWizard()) {
                    stringBuffer.append(TEXT_35);
                    stringBuffer.append(genPackage.getModelWizardClassName());
                    stringBuffer.append(TEXT_36);
                    stringBuffer.append(genPackage.getPrefix());
                    stringBuffer.append(TEXT_37);
                }
            }
            stringBuffer.append(TEXT_38);
        }
        stringBuffer.append(TEXT_39);
    }

    public boolean preCondition() throws Exception {
        GenModel genModel = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditorProject");
        canGenerate = canGenerate && true;
        return canGenerate;
    }
}