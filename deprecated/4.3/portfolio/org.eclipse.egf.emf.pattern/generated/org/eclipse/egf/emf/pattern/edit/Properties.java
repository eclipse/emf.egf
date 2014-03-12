//Generated on Thu May 02 17:41:08 CEST 2013 with EGF 1.0.0.qualifier
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

public class Properties extends org.eclipse.egf.emf.pattern.base.GenModelJava {
    protected static String nl;

    public static synchronized Properties create(String lineSeparator) {
        nl = lineSeparator;
        Properties result = new Properties();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL + "package ";
    protected final String TEXT_3 = ";" + NL;
    protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "public interface ";
    protected final String TEXT_5 = "Properties extends ";
    protected final String TEXT_6 = NL + "{";
    protected final String TEXT_7 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_CreateChild_text\")" + NL + "\t@DefaultMessage(\"{0}\")" + NL + "\tString createChildText(Object type);" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_CreateChild_text2\")" + NL + "\t@DefaultMessage(\"{1} ";
    protected final String TEXT_8 = "| ";
    protected final String TEXT_9 = "{0}\")" + NL + "\tString createChildText2(Object type, Object feature);" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_CreateChild_text3\")" + NL + "\t@DefaultMessage(\"{0}\")" + NL + "\tString createChildText3(Object feature);" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_CreateChild_tooltip\")" + NL + "\t@DefaultMessage(\"Create New {0} Under {1} Feature\")" + NL + "\tString createChildTooltip(Object type, Object feature);" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
            + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_CreateChild_description\")" + NL + "\t@DefaultMessage(\"Create a new child of type {0} for the {1} feature of the selected {2}.\")" + NL + "\tString createChildDescripition(Object type, Object feature, Object selection);" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_CreateSibling_description\")" + NL + "\t@DefaultMessage(\"Create a new sibling of type {0} for the selected {2}, under the {1} feature of their parent.\")" + NL + "\tString createSiblingDescription(Object type, Object feature, Object selection);" + NL;
    protected final String TEXT_10 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_PropertyDescriptor_description\")" + NL + "\t@DefaultMessage(\"The {0} of the {1}\")" + NL + "\tString propertyDescriptorDescription(Object feature, Object type);" + NL;
    protected final String TEXT_11 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_";
    protected final String TEXT_12 = "_type\")" + NL + "\t@DefaultMessage(\"";
    protected final String TEXT_13 = "\")" + NL + "\tString ";
    protected final String TEXT_14 = "Type();" + NL;
    protected final String TEXT_15 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_Unknown_type\")" + NL + "\t@DefaultMessage(\"Object\")" + NL + "\tString unknownType();" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_Unknown_datatype\")" + NL + "\t@DefaultMessage(\"Value\")" + NL + "\tString unknownDatatype();" + NL;
    protected final String TEXT_16 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_";
    protected final String TEXT_17 = "_";
    protected final String TEXT_18 = "_feature\")" + NL + "\t@DefaultMessage(\"";
    protected final String TEXT_19 = "\")" + NL + "\tString ";
    protected final String TEXT_20 = "_";
    protected final String TEXT_21 = "Feature();" + NL;
    protected final String TEXT_22 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_";
    protected final String TEXT_23 = "_";
    protected final String TEXT_24 = "_description\")" + NL + "\t@DefaultMessage(\"";
    protected final String TEXT_25 = "\")" + NL + "\tString ";
    protected final String TEXT_26 = "_";
    protected final String TEXT_27 = "Description();" + NL;
    protected final String TEXT_28 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_Unknown_feature\")" + NL + "\t@DefaultMessage(\"Unspecified\")" + NL + "\tString unknownFeature();" + NL;
    protected final String TEXT_29 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"_UI_";
    protected final String TEXT_30 = "_";
    protected final String TEXT_31 = "_literal\")" + NL + "\t@DefaultMessage(\"";
    protected final String TEXT_32 = "\")" + NL + "\tString ";
    protected final String TEXT_33 = "_";
    protected final String TEXT_34 = "Literal();" + NL;
    protected final String TEXT_35 = NL;
    protected final String TEXT_36 = " = ";
    protected final String TEXT_37 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Key(\"";
    protected final String TEXT_38 = "\")" + NL + "\t@DefaultMessage(\"";
    protected final String TEXT_39 = "\")" + NL + "\tString ";
    protected final String TEXT_40 = "();" + NL;
    protected final String TEXT_41 = NL + "}";
    protected final String TEXT_42 = NL;
    protected final String TEXT_43 = NL;
    protected final String TEXT_44 = NL;

    public Properties() {
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

        stringBuffer.append(TEXT_43);
        stringBuffer.append(TEXT_44);
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
        targetPath = genModel.getEditPluginDirectory();
        packageName = genModel.getEditPluginPackageName();
        className = genModel.getEditPluginClassName() + "Properties";

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
         * Copyright (c) 2010 Ed Merks and others.
         * All rights reserved.   This program and the accompanying materials
         * are made available under the terms of the Eclipse Public License v1.0
         * which accompanies this distribution, and is available at
         * http://www.eclipse.org/legal/epl-v10.html
         *
         * Contributors:
         *   Ed Merks - Initial API and implementation
         */

        GenModel genModel = (GenModel) argument; /* Trick to import java.util.* without warnings */
        Iterator.class.getName();
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
        stringBuffer.append(genModel.getEditPluginPackageName());
        stringBuffer.append(TEXT_3);
        genModel.markImportLocation(stringBuffer);
        stringBuffer.append(TEXT_4);
        stringBuffer.append(genModel.getEditPluginClassName());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(genModel.getImportedName("com.google.gwt.i18n.client.Messages"));
        stringBuffer.append(TEXT_6);
        if (genModel.isCreationCommands()) {
            stringBuffer.append(TEXT_7);
            if (genModel.isCreationSubmenus()) {
                stringBuffer.append(TEXT_8);
            }
            stringBuffer.append(TEXT_9);
        }
        stringBuffer.append(TEXT_10);
        for (GenPackage genPackage : genModel.getAllGenAndUsedGenPackagesWithClassifiers()) {
            if (genPackage.getGenModel() == genModel || !genPackage.getGenModel().hasEditSupport()) {
                for (GenClass genClass : genPackage.getGenClasses()) {
                    stringBuffer.append(TEXT_11);
                    stringBuffer.append(genClass.getName());
                    stringBuffer.append(TEXT_12);
                    stringBuffer.append(genClass.getFormattedName());
                    stringBuffer.append(TEXT_13);
                    stringBuffer.append(genClass.getUncapName());
                    stringBuffer.append(TEXT_14);
                }
            }
        }
        stringBuffer.append(TEXT_15);
        for (GenFeature genFeature : genModel.getFilteredAllGenFeatures()) {
            String description = genFeature.getPropertyDescription();
            stringBuffer.append(TEXT_16);
            stringBuffer.append(genFeature.getGenClass().getName());
            stringBuffer.append(TEXT_17);
            stringBuffer.append(genFeature.getName());
            stringBuffer.append(TEXT_18);
            stringBuffer.append(genFeature.getFormattedName());
            stringBuffer.append(TEXT_19);
            stringBuffer.append(genFeature.getGenClass().getUncapName());
            stringBuffer.append(TEXT_20);
            stringBuffer.append(genFeature.getCapName());
            stringBuffer.append(TEXT_21);
            if (description != null && description.length() > 0) {
                stringBuffer.append(TEXT_22);
                stringBuffer.append(genFeature.getGenClass().getName());
                stringBuffer.append(TEXT_23);
                stringBuffer.append(genFeature.getName());
                stringBuffer.append(TEXT_24);
                stringBuffer.append(description);
                stringBuffer.append(TEXT_25);
                stringBuffer.append(genFeature.getGenClass().getUncapName());
                stringBuffer.append(TEXT_26);
                stringBuffer.append(genFeature.getCapName());
                stringBuffer.append(TEXT_27);
            }
        }
        stringBuffer.append(TEXT_28);
        for (GenPackage genPackage : genModel.getAllGenAndUsedGenPackagesWithClassifiers()) {
            if (genPackage.getGenModel() == genModel || !genPackage.getGenModel().hasEditSupport()) {
                for (GenEnum genEnum : genPackage.getGenEnums()) {
                    for (GenEnumLiteral genEnumLiteral : genEnum.getGenEnumLiterals()) {
                        stringBuffer.append(TEXT_29);
                        stringBuffer.append(genEnum.getName());
                        stringBuffer.append(TEXT_30);
                        stringBuffer.append(genEnumLiteral.getName());
                        stringBuffer.append(TEXT_31);
                        stringBuffer.append(genEnumLiteral.getLiteral());
                        stringBuffer.append(TEXT_32);
                        stringBuffer.append(genEnum.getSafeUncapName());
                        stringBuffer.append(TEXT_33);
                        stringBuffer.append(genEnumLiteral.getName());
                        stringBuffer.append(TEXT_34);
                    }
                }
            }
        }
        for (String category : genModel.getPropertyCategories()) {
            stringBuffer.append(TEXT_35);
            stringBuffer.append(genModel.getPropertyCategoryKey(category));
            stringBuffer.append(TEXT_36);
            stringBuffer.append(category);
            stringBuffer.append(TEXT_37);
            stringBuffer.append(genModel.getPropertyCategoryKey(category));
            stringBuffer.append(TEXT_38);
            stringBuffer.append(category);
            stringBuffer.append(TEXT_39);
            stringBuffer.append(genModel.getPropertyCategoryKey(category));
            stringBuffer.append(TEXT_40);
        }
        stringBuffer.append(TEXT_41);
        genModel.emitSortedImports();
        stringBuffer.append(TEXT_42);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        GenModel genModel = parameter;
        genModel = parameter.getGenModel();
        boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
        canGenerate = canGenerate && (genModel.getRuntimePlatform() == GenRuntimePlatform.GWT) && (!genModel.sameEditEditorProject());
        return canGenerate;
    }
}