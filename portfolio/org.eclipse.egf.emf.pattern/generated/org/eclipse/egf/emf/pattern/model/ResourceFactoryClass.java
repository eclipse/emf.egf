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
  public static synchronized ResourceFactoryClass create(String lineSeparator)
  {
    nl = lineSeparator;
    ResourceFactoryClass result = new ResourceFactoryClass();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "package ";
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
  protected final String TEXT_29 = NL + "\t\t";
  protected final String TEXT_30 = " result = new ";
  protected final String TEXT_31 = "(uri);" + NL + "\t\tresult.getDefaultSaveOptions().put(";
  protected final String TEXT_32 = ".OPTION_EXTENDED_META_DATA, ";
  protected final String TEXT_33 = "Boolean.TRUE";
  protected final String TEXT_34 = "extendedMetaData";
  protected final String TEXT_35 = ");" + NL + "\t\tresult.getDefaultLoadOptions().put(";
  protected final String TEXT_36 = ".OPTION_EXTENDED_META_DATA, ";
  protected final String TEXT_37 = "Boolean.TRUE";
  protected final String TEXT_38 = "extendedMetaData";
  protected final String TEXT_39 = ");" + NL + "" + NL + "\t\tresult.getDefaultSaveOptions().put(";
  protected final String TEXT_40 = ".OPTION_SCHEMA_LOCATION, Boolean.TRUE);" + NL + "" + NL + "\t\tresult.getDefaultLoadOptions().put(";
  protected final String TEXT_41 = ".OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);" + NL + "\t\tresult.getDefaultSaveOptions().put(";
  protected final String TEXT_42 = ".OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);" + NL + "" + NL + "\t\tresult.getDefaultLoadOptions().put(";
  protected final String TEXT_43 = ".OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);";
  protected final String TEXT_44 = NL + "\t\tresult.getDefaultLoadOptions().put(";
  protected final String TEXT_45 = ".OPTION_USE_DATA_CONVERTER, Boolean.TRUE);";
  protected final String TEXT_46 = NL + "\t\t";
  protected final String TEXT_47 = " result = new ";
  protected final String TEXT_48 = "(uri);" + NL + "\t\tresult.getDefaultSaveOptions().put(";
  protected final String TEXT_49 = ".OPTION_XML_MAP, xmlMap);" + NL + "\t\tresult.getDefaultLoadOptions().put(";
  protected final String TEXT_50 = ".OPTION_XML_MAP, xmlMap);";
  protected final String TEXT_51 = NL + "\t\tResource result = new ";
  protected final String TEXT_52 = "(uri);";
  protected final String TEXT_53 = NL + "\t\treturn result;";
  protected final String TEXT_54 = NL + "\t}" + NL + "" + NL + "} //";
  protected final String TEXT_55 = NL;
  protected final String TEXT_56 = NL;

	public ResourceFactoryClass()
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

this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage)parameterParameter;


    orchestration(ctx);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_55);
    stringBuffer.append(TEXT_56);
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

    
GenPackage genPackage = parameter;
targetPath = genPackage.getGenModel().getModelDirectory();
packageName = genPackage.getUtilitiesPackageName();
className = genPackage.getResourceFactoryClassName();
arguments = null;
canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
canGenerate = canGenerate && (genPackage.getResource() != GenResourceKind.NONE_LITERAL);

    }
    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
if (!canGenerate)
    return;
new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());
Object argument = parameter;
if (arguments != null)
    argument = ((Object[]) arguments)[0];

    
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

    GenPackage genPackage = (GenPackage)argument; GenModel genModel=genPackage.getGenModel();
    stringBuffer.append(TEXT_1);
    
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("argument", parameter);
CallHelper.executeWithInjection("_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), parameters);

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
    if (genPackage.hasExtendedMetaData()) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genPackage.getResourceClassName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
    stringBuffer.append(TEXT_32);
    if (genPackage.hasTargetNamespace()){
    stringBuffer.append(TEXT_33);
    }else{
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
    stringBuffer.append(TEXT_36);
    if (genPackage.hasTargetNamespace()){
    stringBuffer.append(TEXT_37);
    }else{
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
    stringBuffer.append(TEXT_43);
    if (genPackage.isDataTypeConverters() && genPackage.hasDocumentRoot()) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genPackage.getResourceClassName());
    stringBuffer.append(TEXT_45);
    }
    } else if (genPackage.hasXMLMap()) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genPackage.getResourceClassName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
    stringBuffer.append(TEXT_50);
    } else {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genPackage.getResourceClassName());
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    //ResourceFactoryClass/createResource.override.javajetinc
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genPackage.getResourceFactoryClassName());
    genModel.emitSortedImports();
    }
    }