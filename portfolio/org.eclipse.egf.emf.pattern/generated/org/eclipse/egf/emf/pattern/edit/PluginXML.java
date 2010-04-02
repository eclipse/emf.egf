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

public class PluginXML extends org.eclipse.egf.emf.pattern.base.GenModelText {
  protected static String nl;
  public static synchronized PluginXML create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginXML result = new PluginXML();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL + NL;
  protected final String TEXT_2 = NL + NL;
  protected final String TEXT_3 = NL + "<plugin>";
  protected final String TEXT_4 = NL + "<plugin" + NL + "      name=\"%pluginName\"" + NL + "      id=\"";
  protected final String TEXT_5 = "\"" + NL + "      version=\"1.0.0\"" + NL + "      provider-name=\"%providerName\"" + NL + "      class=\"";
  protected final String TEXT_6 = "$Implementation\">" + NL + "" + NL + "   <requires>";
  protected final String TEXT_7 = NL + "      <import plugin=\"";
  protected final String TEXT_8 = "\"";
  protected final String TEXT_9 = " export=\"true\"";
  protected final String TEXT_10 = "/>";
  protected final String TEXT_11 = NL + "   </requires>" + NL + "" + NL + "   <runtime>";
  protected final String TEXT_12 = NL + "      <library name=\"";
  protected final String TEXT_13 = ".jar\">";
  protected final String TEXT_14 = NL + "      <library name=\".\">";
  protected final String TEXT_15 = NL + "         <export name=\"*\"/>" + NL + "      </library>" + NL + "   </runtime>";
  protected final String TEXT_16 = NL + NL + "   <extension point=\"org.eclipse.emf.edit.itemProviderAdapterFactories\">" + NL + "      <factory" + NL + "            uri=\"";
  protected final String TEXT_17 = "\"" + NL + "            class=\"";
  protected final String TEXT_18 = "\"" + NL + "            supportedTypes=";
  protected final String TEXT_19 = NL + "              ";
  protected final String TEXT_20 = "\"/>";
  protected final String TEXT_21 = NL + "   </extension>";
  protected final String TEXT_22 = NL + NL + "   <extension point=\"org.eclipse.emf.edit.childCreationExtenders\">";
  protected final String TEXT_23 = NL + "      <extender" + NL + "            uri=\"";
  protected final String TEXT_24 = "\"" + NL + "            class=\"";
  protected final String TEXT_25 = "$";
  protected final String TEXT_26 = "\"/>";
  protected final String TEXT_27 = NL + "   </extension>";
  protected final String TEXT_28 = NL + NL + "   <extension point=\"org.eclipse.emf.ecore.generated_package\">" + NL + "      <package" + NL + "            uri=\"";
  protected final String TEXT_29 = "\"";
  protected final String TEXT_30 = NL + "            class=\"";
  protected final String TEXT_31 = "\"" + NL + "            genModel=\"";
  protected final String TEXT_32 = "\"/>";
  protected final String TEXT_33 = NL + "            class=\"";
  protected final String TEXT_34 = "\"/>";
  protected final String TEXT_35 = NL + "   </extension>";
  protected final String TEXT_36 = NL + NL + "   <extension point=\"org.eclipse.emf.ecore.content_parser\">" + NL + "      <parser" + NL + "            contentTypeIdentifier=\"";
  protected final String TEXT_37 = "\"" + NL + "            class=\"";
  protected final String TEXT_38 = "\"/>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.core.contenttype.contentTypes\">" + NL + "      <content-type" + NL + "            base-type=\"";
  protected final String TEXT_39 = "\"" + NL + "            file-extensions=\"";
  protected final String TEXT_40 = "\"" + NL + "            id=\"";
  protected final String TEXT_41 = "\"" + NL + "            name=\"%_UI_";
  protected final String TEXT_42 = "_content_type\"" + NL + "            priority=\"normal\">" + NL + "         <describer class=\"org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl$Describer\">";
  protected final String TEXT_43 = NL + "            <parameter name=\"namespace\" value=\"";
  protected final String TEXT_44 = "\"/>";
  protected final String TEXT_45 = NL + "            <parameter name=\"kind\" value=\"xmi\"/>";
  protected final String TEXT_46 = NL + "         </describer>" + NL + "      </content-type>" + NL + "   </extension>";
  protected final String TEXT_47 = NL + NL + "   <extension point=\"org.eclipse.emf.ecore.extension_parser\">" + NL + "      <parser" + NL + "            type=\"";
  protected final String TEXT_48 = "\"" + NL + "            class=\"";
  protected final String TEXT_49 = "\"/>" + NL + "   </extension>";
  protected final String TEXT_50 = NL + NL + "</plugin>";
  protected final String TEXT_51 = NL;
  protected final String TEXT_52 = NL;

	public PluginXML()
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
    
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0, executionIndex = ictx.getExecutionBuffer().length();

    super.orchestration(new SuperOrchestrationContext(ictx));

    
method_preGenerate(ictx.getBuffer(), ictx);
    
method_doGenerate(ictx.getBuffer(), ictx);
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
index = ictx.getBuffer().length();
ictx.getExecutionBuffer().append(ictx.getBuffer());
parameters.put("parameter", this.parameter);
CallbackContext ctx_callback = new CallbackContext(ictx);
CallHelper.callBack(ctx_callback, parameters);
}

    
method_postGenerate(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(index));
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 


    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
GenModel genModel = parameter;
targetPathName = genModel.getEditProjectDirectory() + "/plugin.xml";
arguments = null;
overwrite = false;
encoding = "UTF-8";
canGenerate = new CodegenGeneratorAdapter(genModel).canGenerate(parameter, "org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
canGenerate = canGenerate && (!genModel.sameEditEditorProject());

    }
    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
if (!canGenerate)
    return;
new CodegenGeneratorAdapter(genModel).ensureProjectExists(genModel.getEditDirectory(), genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());
Object argument = parameter;
if (arguments != null)
    argument = ((Object[]) arguments)[0];

    
/**
 * <copyright>
 *
 * Copyright (c) 2002-2005 IBM Corporation and others.
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

    GenModel genModel = (GenModel)argument;
    stringBuffer.append(TEXT_1);
    
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("argument", parameter);
CallHelper.executeWithInjection("__h1VkCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), parameters);

    stringBuffer.append(TEXT_2);
    if (genModel.isBundleManifest()) {
    stringBuffer.append(TEXT_3);
    } else {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genModel.getEditPluginID());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genModel.getQualifiedEditPluginClassName());
    stringBuffer.append(TEXT_6);
    for (String pluginID : genModel.getEditRequiredPlugins()) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_8);
    if (!pluginID.startsWith("org.eclipse.core.runtime")) {
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    if (genModel.isRuntimeJar()) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genModel.getEditPluginID());
    stringBuffer.append(TEXT_13);
    } else {
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    }
    for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
    if (!genPackage.getGenClasses().isEmpty()) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genPackage.getQualifiedItemProviderAdapterFactoryClassName());
    stringBuffer.append(TEXT_18);
    for (ListIterator<?> j = genPackage.getProviderSupportedTypes().listIterator(); j.hasNext(); ) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(j.hasPrevious() ? " " : "\"");
    stringBuffer.append(j.next());
    if (!j.hasNext()) {
    stringBuffer.append(TEXT_20);
    }
    }
    stringBuffer.append(TEXT_21);
    if (genPackage.isChildCreationExtenders()) { Map<GenPackage, Map<GenClass, List<GenClass.ChildCreationData>>> extendedChildCreationData = genPackage.getExtendedChildCreationData();
    if (!extendedChildCreationData.isEmpty()) {
    stringBuffer.append(TEXT_22);
    for (Map.Entry<GenPackage, Map<GenClass, List<GenClass.ChildCreationData>>> entry : extendedChildCreationData.entrySet()) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(entry.getKey().getNSURI());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genPackage.getQualifiedItemProviderAdapterFactoryClassName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genPackage.getChildCreationExtenderName(entry.getKey()));
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    }
    }
    }
    }
    if (genModel.sameModelEditProject()) {
    for (GenPackage genPackage : genModel.getAllGenPackagesWithClassifiers()) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_29);
    if (genModel.hasLocalGenModel()) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genModel.getRelativeGenModelLocation());
    stringBuffer.append(TEXT_32);
    } else {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    if (genPackage.isContentType()) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genPackage.getContentTypeIdentifier());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genPackage.getQualifiedEffectiveResourceFactoryClassName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genPackage.isXMIResource() ? "org.eclipse.emf.ecore.xmi" : "org.eclipse.core.runtime.xml");
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genPackage.getFileExtensions());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genPackage.getContentTypeIdentifier());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genPackage.getPrefix());
    stringBuffer.append(TEXT_42);
    if (genPackage.hasTargetNamespace()) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_44);
    }
    if (genPackage.isXMIResource()) {
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    } else if (genPackage.getResource() != GenResourceKind.NONE_LITERAL) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genPackage.getFileExtension());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genPackage.getQualifiedResourceFactoryClassName());
    stringBuffer.append(TEXT_49);
    }
    }
    }
    stringBuffer.append(TEXT_50);
    }
    }