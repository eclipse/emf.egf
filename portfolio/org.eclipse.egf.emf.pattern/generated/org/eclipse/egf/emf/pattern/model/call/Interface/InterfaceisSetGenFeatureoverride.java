package org.eclipse.egf.emf.pattern.model.call.Interface;

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

public class InterfaceisSetGenFeatureoverride 
{
  protected static String nl;
  public static synchronized InterfaceisSetGenFeatureoverride create(String lineSeparator)
  {
    nl = lineSeparator;
    InterfaceisSetGenFeatureoverride result = new InterfaceisSetGenFeatureoverride();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\tboolean isSet";
  protected final String TEXT_5 = "();" + NL;
  protected final String TEXT_6 = NL + "\tpublic boolean isSet";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = "()" + NL + "\t{";
  protected final String TEXT_9 = NL + "\t\treturn eDynamicIsSet(";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\treturn eIsSet(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = " ";
  protected final String TEXT_16 = " = (";
  protected final String TEXT_17 = ")eVirtualGet(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\treturn ";
  protected final String TEXT_20 = " != null && ((";
  protected final String TEXT_21 = ".Unsettable";
  protected final String TEXT_22 = ")";
  protected final String TEXT_23 = ").isSet();";
  protected final String TEXT_24 = NL + "\t\treturn eVirtualIsSet(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\treturn (";
  protected final String TEXT_27 = " & ";
  protected final String TEXT_28 = "_ESETFLAG) != 0;";
  protected final String TEXT_29 = NL + "\t\treturn ";
  protected final String TEXT_30 = "ESet;";
  protected final String TEXT_31 = NL + "\t\treturn !((";
  protected final String TEXT_32 = ".Internal)((";
  protected final String TEXT_33 = ".Internal.Wrapper)get";
  protected final String TEXT_34 = "()).featureMap()).isEmpty(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\t\treturn !((";
  protected final String TEXT_37 = ".Internal)get";
  protected final String TEXT_38 = "()).isEmpty(";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t\t";
  protected final String TEXT_41 = NL;
  protected final String TEXT_42 = "    ";
  protected final String TEXT_43 = NL + "\t}" + NL;
  protected final String TEXT_44 = NL;
  protected final String TEXT_45 = NL;
  protected final String TEXT_46 = NL;

	public InterfaceisSetGenFeatureoverride()
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

    
List<Object> genFeatureList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genClassList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genPackageList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genModelList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> isJDK50List = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> isInterfaceList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> isImplementationList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> publicStaticFinalFlagList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> singleWildcardList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> negativeOffsetCorrectionList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> positiveOffsetCorrectionList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object genFeatureParameter : genFeatureList ) {
for (Object genClassParameter : genClassList ) {
for (Object genPackageParameter : genPackageList ) {
for (Object genModelParameter : genModelList ) {
for (Object isJDK50Parameter : isJDK50List ) {
for (Object isInterfaceParameter : isInterfaceList ) {
for (Object isImplementationParameter : isImplementationList ) {
for (Object publicStaticFinalFlagParameter : publicStaticFinalFlagList ) {
for (Object singleWildcardParameter : singleWildcardList ) {
for (Object negativeOffsetCorrectionParameter : negativeOffsetCorrectionList ) {
for (Object positiveOffsetCorrectionParameter : positiveOffsetCorrectionList ) {

this.genFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature)genFeatureParameter;
this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass)genClassParameter;
this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage)genPackageParameter;
this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel)genModelParameter;
this.isJDK50 = (java.lang.Boolean)isJDK50Parameter;
this.isInterface = (java.lang.Boolean)isInterfaceParameter;
this.isImplementation = (java.lang.Boolean)isImplementationParameter;
this.publicStaticFinalFlag = (java.lang.String)publicStaticFinalFlagParameter;
this.singleWildcard = (java.lang.String)singleWildcardParameter;
this.negativeOffsetCorrection = (java.lang.String)negativeOffsetCorrectionParameter;
this.positiveOffsetCorrection = (java.lang.String)positiveOffsetCorrectionParameter;


    orchestration(ctx);
    
}
}
}
}
}
}
}
}
}
}
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();

    
    
method_doGenerate(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("genFeature", this.genFeature);
    parameterValues.put("genClass", this.genClass);
    parameterValues.put("genPackage", this.genPackage);
    parameterValues.put("genModel", this.genModel);
    parameterValues.put("isJDK50", this.isJDK50);
    parameterValues.put("isInterface", this.isInterface);
    parameterValues.put("isImplementation", this.isImplementation);
    parameterValues.put("publicStaticFinalFlag", this.publicStaticFinalFlag);
    parameterValues.put("singleWildcard", this.singleWildcard);
    parameterValues.put("negativeOffsetCorrection", this.negativeOffsetCorrection);
    parameterValues.put("positiveOffsetCorrection", this.positiveOffsetCorrection);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 

protected org.eclipse.emf.codegen.ecore.genmodel.GenFeature genFeature = null;
public void set_genFeature(org.eclipse.emf.codegen.ecore.genmodel.GenFeature object) {
this.genFeature = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenClass genClass = null;
public void set_genClass(org.eclipse.emf.codegen.ecore.genmodel.GenClass object) {
this.genClass = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage = null;
public void set_genPackage(org.eclipse.emf.codegen.ecore.genmodel.GenPackage object) {
this.genPackage = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;
public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel object) {
this.genModel = object;
}
protected java.lang.Boolean isJDK50 = null;
public void set_isJDK50(java.lang.Boolean object) {
this.isJDK50 = object;
}
protected java.lang.Boolean isInterface = null;
public void set_isInterface(java.lang.Boolean object) {
this.isInterface = object;
}
protected java.lang.Boolean isImplementation = null;
public void set_isImplementation(java.lang.Boolean object) {
this.isImplementation = object;
}
protected java.lang.String publicStaticFinalFlag = null;
public void set_publicStaticFinalFlag(java.lang.String object) {
this.publicStaticFinalFlag = object;
}
protected java.lang.String singleWildcard = null;
public void set_singleWildcard(java.lang.String object) {
this.singleWildcard = object;
}
protected java.lang.String negativeOffsetCorrection = null;
public void set_negativeOffsetCorrection(java.lang.String object) {
this.negativeOffsetCorrection = object;
}
protected java.lang.String positiveOffsetCorrection = null;
public void set_positiveOffsetCorrection(java.lang.String object) {
this.positiveOffsetCorrection = object;
}
public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("genFeature", this.genFeature);
parameters.put("genClass", this.genClass);
parameters.put("genPackage", this.genPackage);
parameters.put("genModel", this.genModel);
parameters.put("isJDK50", this.isJDK50);
parameters.put("isInterface", this.isInterface);
parameters.put("isImplementation", this.isImplementation);
parameters.put("publicStaticFinalFlag", this.publicStaticFinalFlag);
parameters.put("singleWildcard", this.singleWildcard);
parameters.put("negativeOffsetCorrection", this.negativeOffsetCorrection);
parameters.put("positiveOffsetCorrection", this.positiveOffsetCorrection);
return parameters; }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    if (isInterface) {
    stringBuffer.append(TEXT_1);
    final Map<String, Object> parameters__5G4V8GNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5G4V8GNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5G4V8GNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5G4V8GNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5G4V8GNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5G4V8GNEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5G4V8GNEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5G4V8GNEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5G4V8GNEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5G4V8GNEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5G4V8GNEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5G4V8GNEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_00x5kGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5G4V8GNEEdLjd_RFzaClA);

    //Class/isSetGenFeature.javadoc.override.javajetinc
    } else {
    stringBuffer.append(TEXT_2);
    if (isJDK50) { //Class/isSetGenFeature.annotations.insert.javajetinc
    stringBuffer.append(TEXT_3);
    final Map<String, Object> parameters__5G4V8WNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5G4V8WNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5G4V8WNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5G4V8WNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5G4V8WNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5G4V8WNEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5G4V8WNEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5G4V8WNEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5G4V8WNEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5G4V8WNEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5G4V8WNEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5G4V8WNEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_01hgcGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5G4V8WNEEdLjd_RFzaClA);

    }
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genFeature.getAccessorName());
    if (genClass.hasCollidingIsSetAccessorOperation(genFeature)) {
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    if (genModel.isDynamicDelegation()) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_11);
    } else if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_13);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(singleWildcard);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_23);
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_25);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_28);
    } else {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_30);
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_35);
    } else {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_39);
    }
    } else if (genClass.getIsSetAccessorOperation(genFeature) != null) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genClass.getIsSetAccessorOperation(genFeature).getBody(genModel.getIndentation(stringBuffer)));
    } else {
    stringBuffer.append(TEXT_41);
    final Map<String, Object> parameters__5G4V8mNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5G4V8mNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5G4V8mNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5G4V8mNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5G4V8mNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5G4V8mNEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5G4V8mNEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5G4V8mNEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5G4V8mNEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5G4V8mNEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5G4V8mNEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5G4V8mNEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_01qqYGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5G4V8mNEEdLjd_RFzaClA);

    //Class/isSetGenFeature.todo.override.javajetinc
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    }
    stringBuffer.append(TEXT_44);
    }
    }