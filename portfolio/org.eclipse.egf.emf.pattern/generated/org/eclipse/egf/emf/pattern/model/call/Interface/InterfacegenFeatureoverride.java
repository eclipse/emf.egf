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

public class InterfacegenFeatureoverride 
{
  protected static String nl;
  public static synchronized InterfacegenFeatureoverride create(String lineSeparator)
  {
    nl = lineSeparator;
    InterfacegenFeatureoverride result = new InterfacegenFeatureoverride();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  ";
  protected final String TEXT_2 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = "[] ";
  protected final String TEXT_5 = "();" + NL;
  protected final String TEXT_6 = NL + "\tpublic ";
  protected final String TEXT_7 = "[] ";
  protected final String TEXT_8 = "()" + NL + "\t{";
  protected final String TEXT_9 = NL + "\t\t";
  protected final String TEXT_10 = " list = (";
  protected final String TEXT_11 = ")";
  protected final String TEXT_12 = "();" + NL + "\t\tif (list.isEmpty()) return ";
  protected final String TEXT_13 = "(";
  protected final String TEXT_14 = "[])";
  protected final String TEXT_15 = "_EEMPTY_ARRAY;";
  protected final String TEXT_16 = NL + "\t\tif (";
  protected final String TEXT_17 = " == null || ";
  protected final String TEXT_18 = ".isEmpty()) return ";
  protected final String TEXT_19 = "(";
  protected final String TEXT_20 = "[])";
  protected final String TEXT_21 = "_EEMPTY_ARRAY;" + NL + "\t\t";
  protected final String TEXT_22 = " list = (";
  protected final String TEXT_23 = ")";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "\t\tlist.shrink();" + NL + "\t\treturn (";
  protected final String TEXT_26 = "[])list.data();" + NL + "\t}" + NL;
  protected final String TEXT_27 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_28 = NL + "\t";
  protected final String TEXT_29 = " get";
  protected final String TEXT_30 = "(int index);" + NL;
  protected final String TEXT_31 = NL + "\tpublic ";
  protected final String TEXT_32 = " get";
  protected final String TEXT_33 = "(int index)" + NL + "\t{" + NL + "\t\treturn ";
  protected final String TEXT_34 = "(";
  protected final String TEXT_35 = ")";
  protected final String TEXT_36 = "().get(index);" + NL + "\t}" + NL;
  protected final String TEXT_37 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_38 = NL + "\tint get";
  protected final String TEXT_39 = "Length();" + NL;
  protected final String TEXT_40 = NL + "\tpublic int get";
  protected final String TEXT_41 = "Length()" + NL + "\t{";
  protected final String TEXT_42 = NL + "\t\treturn ";
  protected final String TEXT_43 = "().size();";
  protected final String TEXT_44 = NL + "\t\treturn ";
  protected final String TEXT_45 = " == null ? 0 : ";
  protected final String TEXT_46 = ".size();";
  protected final String TEXT_47 = NL + "\t}" + NL;
  protected final String TEXT_48 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_49 = NL + "\tvoid set";
  protected final String TEXT_50 = "(";
  protected final String TEXT_51 = "[] new";
  protected final String TEXT_52 = ");" + NL;
  protected final String TEXT_53 = NL + "\tpublic void set";
  protected final String TEXT_54 = "(";
  protected final String TEXT_55 = "[] new";
  protected final String TEXT_56 = ")" + NL + "\t{" + NL + "\t\t((";
  protected final String TEXT_57 = ")";
  protected final String TEXT_58 = "()).setData(new";
  protected final String TEXT_59 = ".length, new";
  protected final String TEXT_60 = ");" + NL + "\t}" + NL;
  protected final String TEXT_61 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_62 = NL + "\tvoid set";
  protected final String TEXT_63 = "(int index, ";
  protected final String TEXT_64 = " element);" + NL;
  protected final String TEXT_65 = NL + "\tpublic void set";
  protected final String TEXT_66 = "(int index, ";
  protected final String TEXT_67 = " element)" + NL + "\t{" + NL + "\t\t";
  protected final String TEXT_68 = "().set(index, element);" + NL + "\t}" + NL;
  protected final String TEXT_69 = NL;
  protected final String TEXT_70 = "  ";
  protected final String TEXT_71 = NL;
  protected final String TEXT_72 = "  ";
  protected final String TEXT_73 = NL;
  protected final String TEXT_74 = "  ";
  protected final String TEXT_75 = NL;
  protected final String TEXT_76 = "  ";
  protected final String TEXT_77 = NL;
  protected final String TEXT_78 = "  ";
  protected final String TEXT_79 = NL;
  protected final String TEXT_80 = "  ";
  protected final String TEXT_81 = NL;
  protected final String TEXT_82 = "  ";
  protected final String TEXT_83 = NL;
  protected final String TEXT_84 = NL;
  protected final String TEXT_85 = NL;
  protected final String TEXT_86 = NL;

	public InterfacegenFeatureoverride()
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
    
    stringBuffer.append(TEXT_85);
    stringBuffer.append(TEXT_86);
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

    stringBuffer.append(TEXT_1);
    if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
    stringBuffer.append(TEXT_2);
    if (!isImplementation) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_8);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(genFeature.getListTemplateArguments(genClass));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(genFeature.getListTemplateArguments(genClass));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_12);
    if (genModel.useGenerics() && !genFeature.getListItemType(genClass).contains("<") && !genFeature.getListItemType(null).equals(genFeature.getListItemType(genClass))) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_15);
    } else {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_18);
    if (genModel.useGenerics() && !genFeature.getListItemType(genClass).contains("<") && !genFeature.getListItemType(null).equals(genFeature.getListItemType(genClass))) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(genFeature.getListTemplateArguments(genClass));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(genFeature.getListTemplateArguments(genClass));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    if (!isImplementation) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_30);
    } else {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_33);
    if (!genModel.useGenerics()) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    if (!isImplementation) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_39);
    } else {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_41);
    if (genFeature.isVolatile()) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_43);
    } else {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    if (!isImplementation) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_52);
    } else {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(genFeature.getListTemplateArguments(genClass));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    if (!isImplementation) {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_64);
    } else {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genFeature.getListItemType(genClass));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_68);
    }
    }
    if (genFeature.isGet() && (isImplementation || !genFeature.isSuppressedGetVisibility())) {
    stringBuffer.append(TEXT_69);
    final Map<String, Object> parameters__5AVCAGNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5AVCAGNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5AVCAGNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5AVCAGNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5AVCAGNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5AVCAGNEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5AVCAGNEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5AVCAGNEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5AVCAGNEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5AVCAGNEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5AVCAGNEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5AVCAGNEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0vkCYGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5AVCAGNEEdLjd_RFzaClA);

    //Class/getGenFeature.override.javajetinc
    stringBuffer.append(TEXT_70);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicGet()) {
    stringBuffer.append(TEXT_71);
    final Map<String, Object> parameters__5AVCAWNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5AVCAWNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5AVCAWNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5AVCAWNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5AVCAWNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5AVCAWNEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5AVCAWNEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5AVCAWNEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5AVCAWNEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5AVCAWNEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5AVCAWNEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5AVCAWNEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0wwVMGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5AVCAWNEEdLjd_RFzaClA);

    //Class/basicGetGenFeature.override.javajetinc
    stringBuffer.append(TEXT_72);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicSet()) {
    stringBuffer.append(TEXT_73);
    final Map<String, Object> parameters__5AVCAmNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5AVCAmNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5AVCAmNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5AVCAmNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5AVCAmNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5AVCAmNEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5AVCAmNEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5AVCAmNEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5AVCAmNEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5AVCAmNEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5AVCAmNEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5AVCAmNEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0xWLEGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5AVCAmNEEdLjd_RFzaClA);

    //Class/basicSetGenFeature.override.javajetinc
    stringBuffer.append(TEXT_74);
    }
    if (genFeature.isSet() && (isImplementation || !genFeature.isSuppressedSetVisibility())) {
    stringBuffer.append(TEXT_75);
    final Map<String, Object> parameters__5AVCA2NEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5AVCA2NEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5AVCA2NEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5AVCA2NEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5AVCA2NEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5AVCA2NEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5AVCA2NEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5AVCA2NEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5AVCA2NEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5AVCA2NEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5AVCA2NEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5AVCA2NEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0yPi8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5AVCA2NEEdLjd_RFzaClA);

    //Class/setGenFeature.override.javajetinc
    stringBuffer.append(TEXT_76);
    }
    if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicUnset()) {
    stringBuffer.append(TEXT_77);
    final Map<String, Object> parameters__5AVCBGNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5AVCBGNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5AVCBGNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5AVCBGNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5AVCBGNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5AVCBGNEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5AVCBGNEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5AVCBGNEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5AVCBGNEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5AVCBGNEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5AVCBGNEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5AVCBGNEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0zSEwGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5AVCBGNEEdLjd_RFzaClA);

    //Class.basicUnsetGenFeature.override.javajetinc
    stringBuffer.append(TEXT_78);
    }
    if (genFeature.isUnset() && (isImplementation || !genFeature.isSuppressedUnsetVisibility())) {
    stringBuffer.append(TEXT_79);
    final Map<String, Object> parameters__5AVCBWNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5AVCBWNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5AVCBWNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5AVCBWNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5AVCBWNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5AVCBWNEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5AVCBWNEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5AVCBWNEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5AVCBWNEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5AVCBWNEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5AVCBWNEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5AVCBWNEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0z4hsGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5AVCBWNEEdLjd_RFzaClA);

    //Class/unsetGenFeature.override.javajetinc
    stringBuffer.append(TEXT_80);
    }
    if (genFeature.isIsSet() && (isImplementation || !genFeature.isSuppressedIsSetVisibility())) {
    stringBuffer.append(TEXT_81);
    final Map<String, Object> parameters__5AVCBmNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5AVCBmNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5AVCBmNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5AVCBmNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5AVCBmNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5AVCBmNEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5AVCBmNEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5AVCBmNEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5AVCBmNEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5AVCBmNEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5AVCBmNEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5AVCBmNEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_00oIkGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5AVCBmNEEdLjd_RFzaClA);

    //Class/isSetGenFeature.override.javajetinc
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    final Map<String, Object> parameters__5AeL8GNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5AeL8GNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5AeL8GNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5AeL8GNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5AeL8GNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5AeL8GNEEdLjd_RFzaClA.put("isJDK50", isJDK50);
parameters__5AeL8GNEEdLjd_RFzaClA.put("isInterface", isInterface);
parameters__5AeL8GNEEdLjd_RFzaClA.put("isImplementation", isImplementation);
parameters__5AeL8GNEEdLjd_RFzaClA.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__5AeL8GNEEdLjd_RFzaClA.put("singleWildcard", singleWildcard);
parameters__5AeL8GNEEdLjd_RFzaClA.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__5AeL8GNEEdLjd_RFzaClA.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_010bYGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5AeL8GNEEdLjd_RFzaClA);

    stringBuffer.append(TEXT_84);
    }
    }