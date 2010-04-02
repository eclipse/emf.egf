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

public class SwitchClass extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
  protected static String nl;
  public static synchronized SwitchClass create(String lineSeparator)
  {
    nl = lineSeparator;
    SwitchClass result = new SwitchClass();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * The <b>Switch</b> for the model's inheritance hierarchy." + NL + " * It supports the call {@link #doSwitch(EObject) doSwitch(object)}" + NL + " * to invoke the <code>caseXXX</code> method for each class of the model," + NL + " * starting with the actual class of the object" + NL + " * and proceeding up the inheritance hierarchy" + NL + " * until a non-null result is returned," + NL + " * which is the result of the switch." + NL + " * <!-- end-user-doc -->" + NL + " * @see ";
  protected final String TEXT_5 = NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = NL + "{";
  protected final String TEXT_7 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_8 = " copyright = ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * The cached model package" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected static ";
  protected final String TEXT_12 = " modelPackage;" + NL + "" + NL + "\t/**" + NL + "\t * Creates an instance of the switch." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_13 = "()" + NL + "\t{" + NL + "\t\tif (modelPackage == null)" + NL + "\t\t{" + NL + "\t\t\tmodelPackage = ";
  protected final String TEXT_14 = ".eINSTANCE;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the first non-null result returned by a <code>caseXXX</code> call." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_15 = " doSwitch(EObject theEObject)" + NL + "\t{" + NL + "\t\treturn doSwitch(theEObject.eClass(), theEObject);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the first non-null result returned by a <code>caseXXX</code> call." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_16 = " doSwitch(EClass theEClass, EObject theEObject)" + NL + "\t{" + NL + "\t\tif (theEClass.eContainer() == modelPackage)" + NL + "\t\t{" + NL + "\t\t\treturn doSwitch(theEClass.getClassifierID(), theEObject);" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_17 = "<";
  protected final String TEXT_18 = ">";
  protected final String TEXT_19 = " eSuperTypes = theEClass.getESuperTypes();" + NL + "\t\t\treturn" + NL + "\t\t\t\teSuperTypes.isEmpty() ?" + NL + "\t\t\t\t\tdefaultCase(theEObject) :" + NL + "\t\t\t\t\tdoSwitch(";
  protected final String TEXT_20 = "(EClass)";
  protected final String TEXT_21 = "eSuperTypes.get(0), theEObject);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @return the first non-null result returned by a <code>caseXXX</code> call." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_22 = " doSwitch(int classifierID, EObject theEObject)" + NL + "\t{" + NL + "\t\tswitch (classifierID)" + NL + "\t\t{";
  protected final String TEXT_23 = NL + "\t\t\tcase ";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ":" + NL + "\t\t\t{" + NL + "\t\t\t\t";
  protected final String TEXT_26 = "@SuppressWarnings(\"unchecked\") ";
  protected final String TEXT_27 = " ";
  protected final String TEXT_28 = " = (";
  protected final String TEXT_29 = ")theEObject;" + NL + "\t\t\t\t";
  protected final String TEXT_30 = " ";
  protected final String TEXT_31 = " = case";
  protected final String TEXT_32 = "(";
  protected final String TEXT_33 = ");";
  protected final String TEXT_34 = NL + "\t\t\t\tif (";
  protected final String TEXT_35 = " == null) ";
  protected final String TEXT_36 = " = case";
  protected final String TEXT_37 = "(";
  protected final String TEXT_38 = "(";
  protected final String TEXT_39 = ")";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\t\t\tif (";
  protected final String TEXT_42 = " == null) ";
  protected final String TEXT_43 = " = defaultCase(theEObject);" + NL + "\t\t\t\treturn ";
  protected final String TEXT_44 = ";" + NL + "\t\t\t}";
  protected final String TEXT_45 = NL + "\t\t\tdefault: return defaultCase(theEObject);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_46 = NL + NL + "\t/**" + NL + "\t * Returns the result of interpreting the object as an instance of '<em>";
  protected final String TEXT_47 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * This implementation returns null;" + NL + "\t * returning a non-null result will terminate the switch." + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param object the target of the switch." + NL + "\t * @return the result of interpreting the object as an instance of '<em>";
  protected final String TEXT_48 = "</em>'." + NL + "\t * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_49 = " case";
  protected final String TEXT_50 = "(";
  protected final String TEXT_51 = " object)" + NL + "\t{" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_52 = NL + NL + "\t/**" + NL + "\t * Returns the result of interpreting the object as an instance of '<em>EObject</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * This implementation returns null;" + NL + "\t * returning a non-null result will terminate the switch, but this is the last case anyway." + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param object the target of the switch." + NL + "\t * @return the result of interpreting the object as an instance of '<em>EObject</em>'." + NL + "\t * @see #doSwitch(org.eclipse.emf.ecore.EObject)" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_53 = " defaultCase(EObject object)" + NL + "\t{" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "} //";
  protected final String TEXT_54 = NL;
  protected final String TEXT_55 = NL;

	public SwitchClass()
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
    
    stringBuffer.append(TEXT_54);
    stringBuffer.append(TEXT_55);
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
className = genPackage.getSwitchClassName();
arguments = null;
canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
canGenerate = canGenerate && (genPackage.hasClassifiers() && genPackage.isAdapterFactory() && !genPackage.getGenClasses().isEmpty());

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
    genModel.addImport("org.eclipse.emf.ecore.EClass");
    genModel.addImport("org.eclipse.emf.ecore.EObject");
    if (!genPackage.hasJavaLangConflict() && !genPackage.getUtilitiesPackageName().equals(genPackage.getInterfacePackageName())) genModel.addImport(genPackage.getInterfacePackageName() + ".*");
    
String templateParameterName = null;
if (genModel.useGenerics())
{
  Set<String> usedNames = new HashSet<String>();
  for (GenEnum genEnum : genPackage.getGenEnums())
  {
    usedNames.add(genEnum.getName());
  }
  for (GenClass genClass : genPackage.getAllSwitchGenClasses())
  {
    if (!genClass.isDynamic() && !genClass.isExternalInterface())
    {
      usedNames.add(genClass.getName());
    }
    for (GenTypeParameter genTypeParameter : genClass.getGenTypeParameters())
    {
      usedNames.add(genTypeParameter.getName());
    }
  }
  templateParameterName = "T";
  for (int i = 1; usedNames.contains(templateParameterName); ++i)
  {
    templateParameterName = "T" + i;
  }
}

    String templateParameters = genModel.useGenerics() ? "<" + templateParameterName + ">" : "";
    String returnType = genModel.useGenerics() ? templateParameterName : genModel.getImportedName("java.lang.Object");
    genModel.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genPackage.getSwitchClassName());
    stringBuffer.append(templateParameters);
    stringBuffer.append(TEXT_6);
    if (genModel.hasCopyrightField()) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genModel.getImportedName("java.lang.String"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genModel.getCopyrightFieldLiteral());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genPackage.getSwitchClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(returnType);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(returnType);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genModel.getImportedName("java.util.List"));
    if (genModel.useGenerics()) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    if (!genModel.useGenerics()) {
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(returnType);
    stringBuffer.append(TEXT_22);
    for (GenClass genClass : genPackage.getGenClasses()) {
    if (!genClass.isExternalInterface() && !genClass.isEObject() || genClass.isMapEntry()) { String result = "result".equals(genClass.getSafeUncapName()) ? "theResult" : "result"; 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genPackage.getImportedPackageInterfaceName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genPackage.getClassifierID(genClass));
    stringBuffer.append(TEXT_25);
    if (genClass.isUncheckedCast() || genClass.isMapEntry() && genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) {
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceWildTypeArguments());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(returnType);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(result);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genPackage.getClassUniqueName(genClass));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_33);
    for (GenClass baseGenClass : genClass.getSwitchGenClasses()) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(result);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(result);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genPackage.getClassUniqueName(baseGenClass));
    stringBuffer.append(TEXT_37);
    if (genClass.isMapEntry()) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(baseGenClass.getImportedInterfaceName());
    stringBuffer.append(baseGenClass.getInterfaceTypeArguments());
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(genClass.getSafeUncapName());
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(result);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(result);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(result);
    stringBuffer.append(TEXT_44);
    }
    }
    stringBuffer.append(TEXT_45);
    for (GenClass genClass : genPackage.getAllSwitchGenClasses()) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genClass.getFormattedName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genClass.getTypeParameters());
    stringBuffer.append(returnType);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genPackage.getClassUniqueName(genClass));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genClass.getImportedInterfaceName());
    stringBuffer.append(genClass.getInterfaceTypeArguments());
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(returnType);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genPackage.getSwitchClassName());
    genModel.emitSortedImports();
    }
    }