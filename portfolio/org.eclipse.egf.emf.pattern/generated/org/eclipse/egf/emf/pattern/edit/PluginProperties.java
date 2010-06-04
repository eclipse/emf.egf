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

public class PluginProperties extends org.eclipse.egf.emf.pattern.base.GenModelProperties {
  protected static String nl;
  public static synchronized PluginProperties create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginProperties result = new PluginProperties();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "pluginName = ";
  protected final String TEXT_3 = " Edit Support" + NL + "providerName = www.example.org" + NL;
  protected final String TEXT_4 = NL + "_UI_CreateChild_text = {0}" + NL + "_UI_CreateChild_text2 = {1} ";
  protected final String TEXT_5 = "| ";
  protected final String TEXT_6 = "{0}" + NL + "_UI_CreateChild_text3 = {1}" + NL + "_UI_CreateChild_tooltip = Create New {0} Under {1} Feature" + NL + "_UI_CreateChild_description = Create a new child of type {0} for the {1} feature of the selected {2}." + NL + "_UI_CreateSibling_description = Create a new sibling of type {0} for the selected {2}, under the {1} feature of their parent." + NL;
  protected final String TEXT_7 = NL + "_UI_PropertyDescriptor_description = The {0} of the {1}" + NL;
  protected final String TEXT_8 = NL + "_UI_";
  protected final String TEXT_9 = "_type = ";
  protected final String TEXT_10 = NL + "_UI_Unknown_type = Object" + NL + "" + NL + "_UI_Unknown_datatype= Value" + NL;
  protected final String TEXT_11 = NL + "_UI_";
  protected final String TEXT_12 = "_";
  protected final String TEXT_13 = "_feature = ";
  protected final String TEXT_14 = NL + "_UI_";
  protected final String TEXT_15 = "_";
  protected final String TEXT_16 = "_description = ";
  protected final String TEXT_17 = NL + "_UI_Unknown_feature = Unspecified" + NL;
  protected final String TEXT_18 = NL + "_UI_";
  protected final String TEXT_19 = "_";
  protected final String TEXT_20 = "_literal = ";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = NL;
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL;

	public PluginProperties()
	{
	//Here is the constructor
StringBuffer stringBuffer = new StringBuffer();

    // add initialisation of the pattern variables (declaration has been already done).
    
	}
  	
  	public String generate(Object argument) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    InternalPatternContext ctx = (InternalPatternContext)argument;
Map<String, String> queryCtx = null;
IQuery.ParameterDescription paramDesc = null;

    
List<Object> parameterList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object parameterParameter : parameterList ) {

this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel)parameterParameter;


    orchestration(ctx);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
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
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 

public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("parameter", this.parameter);
return parameters; }

    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
GenModel genModel = parameter;
targetPathName = genModel.getEditProjectDirectory() + "/plugin.properties";

    }
    protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
GenModel genModel = parameter;
argument = parameter;

    }
    protected void method_setCanGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
GenModel genModel = parameter;
canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
canGenerate = canGenerate && true;

    }
    protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
if (canGenerate)
    new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditDirectory(), genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

    }
    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
if (!canGenerate)
    return;

    
/**
 * <copyright>
 *
 * Copyright (c) 2002-2007 IBM Corporation and others.
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

    GenModel genModel = (GenModel)argument; /* Trick to import java.util.* without warnings */Iterator.class.getName();
    stringBuffer.append(TEXT_1);
    final Map<String, Object> parameters__rqcg4GKSEd8eoMv8ZThYQ = new HashMap<String, Object>();
parameters__rqcg4GKSEd8eoMv8ZThYQ.put("argument", parameter);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_FEoPwCwuEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), parameters__rqcg4GKSEd8eoMv8ZThYQ);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_3);
    if (genModel.isCreationCommands()) {
    stringBuffer.append(TEXT_4);
    if (genModel.isCreationSubmenus()) {
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    for (GenPackage genPackage : genModel.getAllGenAndUsedGenPackagesWithClassifiers()) {
    if (genPackage.getGenModel() == genModel || !genPackage.getGenModel().hasEditSupport()) { 
    for (GenClass genClass : genPackage.getGenClasses()) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genClass.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genClass.getFormattedName());
    }
    }
    }
    stringBuffer.append(TEXT_10);
    for (GenFeature genFeature : genModel.getFilteredAllGenFeatures()) { String description = genFeature.getPropertyDescription();
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genFeature.getGenClass().getName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genFeature.getFormattedName());
    if (description != null && description.length() > 0) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genFeature.getGenClass().getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(description);
    }
    }
    stringBuffer.append(TEXT_17);
    for (GenPackage genPackage : genModel.getAllGenAndUsedGenPackagesWithClassifiers()) {
    if (genPackage.getGenModel() == genModel || !genPackage.getGenModel().hasEditSupport()) {
    for (GenEnum genEnum : genPackage.getGenEnums()) {
    for (GenEnumLiteral genEnumLiteral : genEnum.getGenEnumLiterals()) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genEnum.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genEnumLiteral.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genEnumLiteral.getLiteral());
    }
    }
    }
    }
    for (String category : genModel.getPropertyCategories()) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genModel.getPropertyCategoryKey(category));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(category);
    }
    stringBuffer.append(TEXT_23);
    }
    }