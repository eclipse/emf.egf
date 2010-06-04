package org.eclipse.egf.emf.pattern.model.internal.Class;

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

public class ClassunsetGenFeatureoverride 
{
  protected static String nl;
  public static synchronized ClassunsetGenFeatureoverride create(String lineSeparator)
  {
    nl = lineSeparator;
    ClassunsetGenFeatureoverride result = new ClassunsetGenFeatureoverride();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\tvoid unset";
  protected final String TEXT_5 = "();" + NL;
  protected final String TEXT_6 = NL + "\tpublic void unset";
  protected final String TEXT_7 = "_";
  protected final String TEXT_8 = "()" + NL + "\t{";
  protected final String TEXT_9 = NL + "\t\teDynamicUnset(";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\teUnset(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = " ";
  protected final String TEXT_16 = " = (";
  protected final String TEXT_17 = ")eVirtualGet(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\tif (";
  protected final String TEXT_20 = " != null) ((";
  protected final String TEXT_21 = ".Unsettable";
  protected final String TEXT_22 = ")";
  protected final String TEXT_23 = ").unset();";
  protected final String TEXT_24 = NL + "\t\t";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = " = (";
  protected final String TEXT_27 = ")eVirtualGet(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\tif (";
  protected final String TEXT_30 = " != null)" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_31 = " msgs = null;";
  protected final String TEXT_32 = NL + "\t\t\tmsgs = ((";
  protected final String TEXT_33 = ")";
  protected final String TEXT_34 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_35 = ", null, msgs);";
  protected final String TEXT_36 = NL + "\t\t\tmsgs = ((";
  protected final String TEXT_37 = ")";
  protected final String TEXT_38 = ").eInverseRemove(this, ";
  protected final String TEXT_39 = ", ";
  protected final String TEXT_40 = ".class, msgs);";
  protected final String TEXT_41 = NL + "\t\t\tmsgs = basicUnset";
  protected final String TEXT_42 = "(msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{";
  protected final String TEXT_43 = NL + "\t\t\tboolean old";
  protected final String TEXT_44 = "ESet = eVirtualIsSet(";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "\t\t\tboolean old";
  protected final String TEXT_47 = "ESet = (";
  protected final String TEXT_48 = " & ";
  protected final String TEXT_49 = "_ESETFLAG) != 0;";
  protected final String TEXT_50 = NL + "\t\t\t";
  protected final String TEXT_51 = " &= ~";
  protected final String TEXT_52 = "_ESETFLAG;";
  protected final String TEXT_53 = NL + "\t\t\tboolean old";
  protected final String TEXT_54 = "ESet = ";
  protected final String TEXT_55 = "ESet;";
  protected final String TEXT_56 = NL + "\t\t\t";
  protected final String TEXT_57 = "ESet = false;";
  protected final String TEXT_58 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
  protected final String TEXT_59 = "(this, ";
  protected final String TEXT_60 = ".UNSET, ";
  protected final String TEXT_61 = ", null, null, old";
  protected final String TEXT_62 = "ESet));";
  protected final String TEXT_63 = NL + "\t\t}";
  protected final String TEXT_64 = NL + "\t\t";
  protected final String TEXT_65 = " old";
  protected final String TEXT_66 = " = (";
  protected final String TEXT_67 = " & ";
  protected final String TEXT_68 = "_EFLAG) != 0;";
  protected final String TEXT_69 = NL + "\t\t";
  protected final String TEXT_70 = " old";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = "_EFLAG_VALUES[(";
  protected final String TEXT_73 = " & ";
  protected final String TEXT_74 = "_EFLAG) >>> ";
  protected final String TEXT_75 = "_EFLAG_OFFSET];";
  protected final String TEXT_76 = NL + "\t\tObject old";
  protected final String TEXT_77 = " = eVirtualUnset(";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\t\t";
  protected final String TEXT_80 = " old";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";";
  protected final String TEXT_83 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_84 = " != EVIRTUAL_NO_VALUE;";
  protected final String TEXT_85 = NL + "\t\tboolean old";
  protected final String TEXT_86 = "ESet = (";
  protected final String TEXT_87 = " & ";
  protected final String TEXT_88 = "_ESETFLAG) != 0;";
  protected final String TEXT_89 = NL + "\t\tboolean old";
  protected final String TEXT_90 = "ESet = ";
  protected final String TEXT_91 = "ESet;";
  protected final String TEXT_92 = NL + "\t\t";
  protected final String TEXT_93 = " = null;";
  protected final String TEXT_94 = NL + "\t\t";
  protected final String TEXT_95 = " &= ~";
  protected final String TEXT_96 = "_ESETFLAG;";
  protected final String TEXT_97 = NL + "\t\t";
  protected final String TEXT_98 = "ESet = false;";
  protected final String TEXT_99 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_100 = "(this, ";
  protected final String TEXT_101 = ".UNSET, ";
  protected final String TEXT_102 = ", ";
  protected final String TEXT_103 = "isSetChange ? old";
  protected final String TEXT_104 = " : null";
  protected final String TEXT_105 = "old";
  protected final String TEXT_106 = ", null, ";
  protected final String TEXT_107 = "isSetChange";
  protected final String TEXT_108 = "old";
  protected final String TEXT_109 = "ESet";
  protected final String TEXT_110 = "));";
  protected final String TEXT_111 = NL + "\t\tif (";
  protected final String TEXT_112 = ") ";
  protected final String TEXT_113 = " |= ";
  protected final String TEXT_114 = "_EFLAG; else ";
  protected final String TEXT_115 = " &= ~";
  protected final String TEXT_116 = "_EFLAG;";
  protected final String TEXT_117 = NL + "\t\t";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = " & ~";
  protected final String TEXT_120 = "_EFLAG | ";
  protected final String TEXT_121 = "_EFLAG_DEFAULT;";
  protected final String TEXT_122 = NL + "\t\t";
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = ";";
  protected final String TEXT_125 = NL + "\t\t";
  protected final String TEXT_126 = " &= ~";
  protected final String TEXT_127 = "_ESETFLAG;";
  protected final String TEXT_128 = NL + "\t\t";
  protected final String TEXT_129 = "ESet = false;";
  protected final String TEXT_130 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_131 = "(this, ";
  protected final String TEXT_132 = ".UNSET, ";
  protected final String TEXT_133 = ", ";
  protected final String TEXT_134 = "isSetChange ? old";
  protected final String TEXT_135 = " : ";
  protected final String TEXT_136 = "old";
  protected final String TEXT_137 = ", ";
  protected final String TEXT_138 = ", ";
  protected final String TEXT_139 = "isSetChange";
  protected final String TEXT_140 = "old";
  protected final String TEXT_141 = "ESet";
  protected final String TEXT_142 = "));";
  protected final String TEXT_143 = NL + "\t\t((";
  protected final String TEXT_144 = ".Internal)((";
  protected final String TEXT_145 = ".Internal.Wrapper)get";
  protected final String TEXT_146 = "()).featureMap()).clear(";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = NL + "\t\t((";
  protected final String TEXT_149 = ".Internal)get";
  protected final String TEXT_150 = "()).clear(";
  protected final String TEXT_151 = ");";
  protected final String TEXT_152 = NL + "\t\t";
  protected final String TEXT_153 = NL;
  protected final String TEXT_154 = "    ";
  protected final String TEXT_155 = NL + "\t}" + NL;
  protected final String TEXT_156 = NL;
  protected final String TEXT_157 = NL;
  protected final String TEXT_158 = NL;

	public ClassunsetGenFeatureoverride()
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
    
    stringBuffer.append(TEXT_157);
    stringBuffer.append(TEXT_158);
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
    final Map<String, Object> parameters__SMKCQGKKEdvV655ccA3JQ = new HashMap<String, Object>();
parameters__SMKCQGKKEdvV655ccA3JQ.put("genFeature", genFeature);
parameters__SMKCQGKKEdvV655ccA3JQ.put("genClass", genClass);
parameters__SMKCQGKKEdvV655ccA3JQ.put("genPackage", genPackage);
parameters__SMKCQGKKEdvV655ccA3JQ.put("genModel", genModel);
parameters__SMKCQGKKEdvV655ccA3JQ.put("isJDK50", isJDK50);
parameters__SMKCQGKKEdvV655ccA3JQ.put("isInterface", isInterface);
parameters__SMKCQGKKEdvV655ccA3JQ.put("isImplementation", isImplementation);
parameters__SMKCQGKKEdvV655ccA3JQ.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__SMKCQGKKEdvV655ccA3JQ.put("singleWildcard", singleWildcard);
parameters__SMKCQGKKEdvV655ccA3JQ.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__SMKCQGKKEdvV655ccA3JQ.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0rPjEGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__SMKCQGKKEdvV655ccA3JQ);

    //Class/unsetGenFeature.javadoc.override.javajetinc
    } else {
    stringBuffer.append(TEXT_2);
    if (isJDK50) { //Class/unsetGenFeature.annotations.insert.javajetinc
    stringBuffer.append(TEXT_3);
    final Map<String, Object> parameters__SMKCQWKKEdvV655ccA3JQ = new HashMap<String, Object>();
parameters__SMKCQWKKEdvV655ccA3JQ.put("genFeature", genFeature);
parameters__SMKCQWKKEdvV655ccA3JQ.put("genClass", genClass);
parameters__SMKCQWKKEdvV655ccA3JQ.put("genPackage", genPackage);
parameters__SMKCQWKKEdvV655ccA3JQ.put("genModel", genModel);
parameters__SMKCQWKKEdvV655ccA3JQ.put("isJDK50", isJDK50);
parameters__SMKCQWKKEdvV655ccA3JQ.put("isInterface", isInterface);
parameters__SMKCQWKKEdvV655ccA3JQ.put("isImplementation", isImplementation);
parameters__SMKCQWKKEdvV655ccA3JQ.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__SMKCQWKKEdvV655ccA3JQ.put("singleWildcard", singleWildcard);
parameters__SMKCQWKKEdvV655ccA3JQ.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__SMKCQWKKEdvV655ccA3JQ.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0rrn8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__SMKCQWKKEdvV655ccA3JQ);

    }
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genFeature.getAccessorName());
    if (genClass.hasCollidingUnsetAccessorOperation(genFeature)) {
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
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_31);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(negativeOffsetCorrection);
    stringBuffer.append(TEXT_35);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(reverseOffsetCorrection);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(targetClass.getRawImportedInterfaceName());
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_42);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_45);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_49);
    }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_52);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_57);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_62);
    }
    stringBuffer.append(TEXT_63);
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_68);
    } else {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_75);
    }
    }
    } else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_78);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_79);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_82);
    }
    }
    if (!genModel.isSuppressNotification()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_84);
    } else if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_88);
    } else {
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_91);
    }
    }
    if (genFeature.isReferenceType()) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_93);
    if (!genModel.isVirtualDelegation()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_96);
    } else {
    stringBuffer.append(TEXT_97);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_98);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_102);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_104);
    } else {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_106);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_107);
    } else {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_116);
    } else {
    stringBuffer.append(TEXT_117);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_121);
    }
    } else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_122);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_124);
    }
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (genClass.isESetFlag(genFeature)) {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_127);
    } else {
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_129);
    }
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_133);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(genFeature.getEDefault());
    } else {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_137);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_138);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_139);
    } else {
    stringBuffer.append(TEXT_140);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    }
    }
    }
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_143);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_147);
    } else {
    stringBuffer.append(TEXT_148);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_151);
    }
    } else if (genClass.getUnsetAccessorOperation(genFeature) != null) {
    stringBuffer.append(TEXT_152);
    stringBuffer.append(genClass.getUnsetAccessorOperation(genFeature).getBody(genModel.getIndentation(stringBuffer)));
    } else {
    stringBuffer.append(TEXT_153);
    final Map<String, Object> parameters__SMKCQmKKEdvV655ccA3JQ = new HashMap<String, Object>();
parameters__SMKCQmKKEdvV655ccA3JQ.put("genFeature", genFeature);
parameters__SMKCQmKKEdvV655ccA3JQ.put("genClass", genClass);
parameters__SMKCQmKKEdvV655ccA3JQ.put("genPackage", genPackage);
parameters__SMKCQmKKEdvV655ccA3JQ.put("genModel", genModel);
parameters__SMKCQmKKEdvV655ccA3JQ.put("isJDK50", isJDK50);
parameters__SMKCQmKKEdvV655ccA3JQ.put("isInterface", isInterface);
parameters__SMKCQmKKEdvV655ccA3JQ.put("isImplementation", isImplementation);
parameters__SMKCQmKKEdvV655ccA3JQ.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__SMKCQmKKEdvV655ccA3JQ.put("singleWildcard", singleWildcard);
parameters__SMKCQmKKEdvV655ccA3JQ.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__SMKCQmKKEdvV655ccA3JQ.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0r_J8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__SMKCQmKKEdvV655ccA3JQ);

    //Class/unsetGenFeature.todo.override.javajetinc
    stringBuffer.append(TEXT_154);
    }
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    }
    }