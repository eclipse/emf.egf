package org.eclipse.egf.emf.pattern.model.internal.Interface;

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

public class InterfacegetGenFeatureoverride 
{
  protected static String nl;
  public static synchronized InterfacegetGenFeatureoverride create(String lineSeparator)
  {
    nl = lineSeparator;
    InterfacegetGenFeatureoverride result = new InterfacegetGenFeatureoverride();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = " ";
  protected final String TEXT_6 = "();" + NL;
  protected final String TEXT_7 = NL + "\t@SuppressWarnings(\"unchecked\")";
  protected final String TEXT_8 = NL + "\tpublic ";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = "_";
  protected final String TEXT_11 = "()" + NL + "\t{";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "\t\treturn ";
  protected final String TEXT_14 = "(";
  protected final String TEXT_15 = "(";
  protected final String TEXT_16 = ")eDynamicGet(";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ", true, ";
  protected final String TEXT_19 = ")";
  protected final String TEXT_20 = ").";
  protected final String TEXT_21 = "()";
  protected final String TEXT_22 = ";";
  protected final String TEXT_23 = NL + "\t\treturn ";
  protected final String TEXT_24 = "(";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = ")eGet(";
  protected final String TEXT_27 = ", true)";
  protected final String TEXT_28 = ").";
  protected final String TEXT_29 = "()";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL + "\t\t";
  protected final String TEXT_32 = " ";
  protected final String TEXT_33 = " = (";
  protected final String TEXT_34 = ")eVirtualGet(";
  protected final String TEXT_35 = ");";
  protected final String TEXT_36 = NL + "\t\tif (";
  protected final String TEXT_37 = " == null)" + NL + "\t\t{";
  protected final String TEXT_38 = NL + "\t\t\teVirtualSet(";
  protected final String TEXT_39 = ", ";
  protected final String TEXT_40 = " = new ";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\t\t\t";
  protected final String TEXT_43 = " = new ";
  protected final String TEXT_44 = ";";
  protected final String TEXT_45 = NL + "\t\t}" + NL + "\t\treturn ";
  protected final String TEXT_46 = ";";
  protected final String TEXT_47 = NL + "\t\tif (eContainerFeatureID() != ";
  protected final String TEXT_48 = ") return null;" + NL + "\t\treturn (";
  protected final String TEXT_49 = ")eContainer();";
  protected final String TEXT_50 = NL + "\t\t";
  protected final String TEXT_51 = " ";
  protected final String TEXT_52 = " = (";
  protected final String TEXT_53 = ")eVirtualGet(";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\t\tif (";
  protected final String TEXT_57 = " != null && ";
  protected final String TEXT_58 = ".eIsProxy())" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_59 = " old";
  protected final String TEXT_60 = " = (";
  protected final String TEXT_61 = ")";
  protected final String TEXT_62 = ";" + NL + "\t\t\t";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = "eResolveProxy(old";
  protected final String TEXT_65 = ");" + NL + "\t\t\tif (";
  protected final String TEXT_66 = " != old";
  protected final String TEXT_67 = ")" + NL + "\t\t\t{";
  protected final String TEXT_68 = NL + "\t\t\t\t";
  protected final String TEXT_69 = " new";
  protected final String TEXT_70 = " = (";
  protected final String TEXT_71 = ")";
  protected final String TEXT_72 = ";";
  protected final String TEXT_73 = NL + "\t\t\t\t";
  protected final String TEXT_74 = " msgs = old";
  protected final String TEXT_75 = ".eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_76 = ", null, null);";
  protected final String TEXT_77 = NL + "\t\t\t\t";
  protected final String TEXT_78 = " msgs =  old";
  protected final String TEXT_79 = ".eInverseRemove(this, ";
  protected final String TEXT_80 = ", ";
  protected final String TEXT_81 = ".class, null);";
  protected final String TEXT_82 = NL + "\t\t\t\tif (new";
  protected final String TEXT_83 = ".eInternalContainer() == null)" + NL + "\t\t\t\t{";
  protected final String TEXT_84 = NL + "\t\t\t\t\tmsgs = new";
  protected final String TEXT_85 = ".eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_86 = ", null, msgs);";
  protected final String TEXT_87 = NL + "\t\t\t\t\tmsgs =  new";
  protected final String TEXT_88 = ".eInverseAdd(this, ";
  protected final String TEXT_89 = ", ";
  protected final String TEXT_90 = ".class, msgs);";
  protected final String TEXT_91 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (msgs != null) msgs.dispatch();";
  protected final String TEXT_92 = NL + "\t\t\t\teVirtualSet(";
  protected final String TEXT_93 = ", ";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "\t\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\t\teNotify(new ";
  protected final String TEXT_96 = "(this, ";
  protected final String TEXT_97 = ".RESOLVE, ";
  protected final String TEXT_98 = ", old";
  protected final String TEXT_99 = ", ";
  protected final String TEXT_100 = "));";
  protected final String TEXT_101 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_102 = NL + "\t\treturn (";
  protected final String TEXT_103 = ")eVirtualGet(";
  protected final String TEXT_104 = ", ";
  protected final String TEXT_105 = ");";
  protected final String TEXT_106 = NL + "\t\treturn (";
  protected final String TEXT_107 = " & ";
  protected final String TEXT_108 = "_EFLAG) != 0;";
  protected final String TEXT_109 = NL + "\t\treturn ";
  protected final String TEXT_110 = "_EFLAG_VALUES[(";
  protected final String TEXT_111 = " & ";
  protected final String TEXT_112 = "_EFLAG) >>> ";
  protected final String TEXT_113 = "_EFLAG_OFFSET];";
  protected final String TEXT_114 = NL + "\t\treturn ";
  protected final String TEXT_115 = ";";
  protected final String TEXT_116 = NL + "\t\t";
  protected final String TEXT_117 = " ";
  protected final String TEXT_118 = " = basicGet";
  protected final String TEXT_119 = "();" + NL + "\t\treturn ";
  protected final String TEXT_120 = " != null && ";
  protected final String TEXT_121 = ".eIsProxy() ? ";
  protected final String TEXT_122 = "eResolveProxy((";
  protected final String TEXT_123 = ")";
  protected final String TEXT_124 = ") : ";
  protected final String TEXT_125 = ";";
  protected final String TEXT_126 = NL + "\t\treturn new ";
  protected final String TEXT_127 = "((";
  protected final String TEXT_128 = ".Internal)((";
  protected final String TEXT_129 = ".Internal.Wrapper)get";
  protected final String TEXT_130 = "()).featureMap().";
  protected final String TEXT_131 = "list(";
  protected final String TEXT_132 = "));";
  protected final String TEXT_133 = NL + "\t\treturn (";
  protected final String TEXT_134 = ")get";
  protected final String TEXT_135 = "().";
  protected final String TEXT_136 = "list(";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL + "\t\treturn ((";
  protected final String TEXT_139 = ".Internal.Wrapper)get";
  protected final String TEXT_140 = "()).featureMap().list(";
  protected final String TEXT_141 = ");";
  protected final String TEXT_142 = NL + "\t\treturn get";
  protected final String TEXT_143 = "().list(";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "\t\treturn ";
  protected final String TEXT_146 = "(";
  protected final String TEXT_147 = "(";
  protected final String TEXT_148 = ")";
  protected final String TEXT_149 = "((";
  protected final String TEXT_150 = ".Internal.Wrapper)get";
  protected final String TEXT_151 = "()).featureMap().get(";
  protected final String TEXT_152 = ", true)";
  protected final String TEXT_153 = ").";
  protected final String TEXT_154 = "()";
  protected final String TEXT_155 = ";";
  protected final String TEXT_156 = NL + "\t\treturn ";
  protected final String TEXT_157 = "(";
  protected final String TEXT_158 = "(";
  protected final String TEXT_159 = ")";
  protected final String TEXT_160 = "get";
  protected final String TEXT_161 = "().get(";
  protected final String TEXT_162 = ", true)";
  protected final String TEXT_163 = ").";
  protected final String TEXT_164 = "()";
  protected final String TEXT_165 = ";";
  protected final String TEXT_166 = NL + "\t\t";
  protected final String TEXT_167 = NL;
  protected final String TEXT_168 = "      ";
  protected final String TEXT_169 = NL + "\t}" + NL;
  protected final String TEXT_170 = NL;
  protected final String TEXT_171 = NL;
  protected final String TEXT_172 = NL;

	public InterfacegetGenFeatureoverride()
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
    
    stringBuffer.append(TEXT_171);
    stringBuffer.append(TEXT_172);
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
    final Map<String, Object> parameters__rR3BwGKSEd8eoMv8ZThYQ = new HashMap<String, Object>();
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("genFeature", genFeature);
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("genClass", genClass);
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("genPackage", genPackage);
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("genModel", genModel);
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("isJDK50", isJDK50);
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("isInterface", isInterface);
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("isImplementation", isImplementation);
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("singleWildcard", singleWildcard);
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__rR3BwGKSEd8eoMv8ZThYQ.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0vtMUGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__rR3BwGKSEd8eoMv8ZThYQ);

    //Class/getGenFeature.javadoc.override.javajetinc
    } else {
    stringBuffer.append(TEXT_2);
    if (isJDK50) { //Class/getGenFeature.annotations.insert.javajetinc
    stringBuffer.append(TEXT_3);
    final Map<String, Object> parameters__rR3BwWKSEd8eoMv8ZThYQ = new HashMap<String, Object>();
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("genFeature", genFeature);
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("genClass", genClass);
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("genPackage", genPackage);
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("genModel", genModel);
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("isJDK50", isJDK50);
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("isInterface", isInterface);
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("isImplementation", isImplementation);
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("singleWildcard", singleWildcard);
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__rR3BwWKSEd8eoMv8ZThYQ.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0wTpQGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__rR3BwWKSEd8eoMv8ZThYQ);

    }
    }
    if (!isImplementation) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_6);
    } else {
    if (genModel.useGenerics() && ((genFeature.isContainer() || genFeature.isResolveProxies()) && !genFeature.isListType() && !(genModel.isReflectiveDelegation() && genModel.isDynamicDelegation()) && genFeature.isUncheckedCast(genClass) || genFeature.isListType() && !genFeature.isFeatureMapType() && (genModel.isReflectiveDelegation() || genModel.isVirtualDelegation() || genModel.isDynamicDelegation()) || genFeature.isListDataType() && genFeature.hasDelegateFeature())) {
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genFeature.getGetAccessor());
    if (genClass.hasCollidingGetAccessorOperation(genFeature)) {
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    final Map<String, Object> parameters__rR3BwmKSEd8eoMv8ZThYQ = new HashMap<String, Object>();
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("genFeature", genFeature);
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("genClass", genClass);
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("genPackage", genPackage);
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("genModel", genModel);
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("isJDK50", isJDK50);
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("isInterface", isInterface);
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("isImplementation", isImplementation);
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("singleWildcard", singleWildcard);
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__rR3BwmKSEd8eoMv8ZThYQ.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0wczMGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__rR3BwmKSEd8eoMv8ZThYQ);

    if (genModel.isDynamicDelegation()) {
    stringBuffer.append(TEXT_13);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genFeature.getObjectType(genClass));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(!genFeature.isEffectiveSuppressEMFTypes());
    stringBuffer.append(TEXT_19);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    } else if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_23);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genFeature.getObjectType(genClass));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_27);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_29);
    }
    stringBuffer.append(TEXT_30);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isListType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_37);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genClass.getListConstructor(genFeature));
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genClass.getListConstructor(genFeature));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes() ? ".map()" : "");
    stringBuffer.append(TEXT_46);
    } else if (genFeature.isContainer()) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_49);
    } else {
    if (genFeature.isResolveProxies()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    if (genFeature.hasEDefault()) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genFeature.getEDefault());
    }
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genFeature.getSafeNameAsEObject());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast(genClass));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_67);
    if (genFeature.isEffectiveContains()) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_72);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(negativeOffsetCorrection);
    stringBuffer.append(TEXT_76);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
    stringBuffer.append(TEXT_77);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(reverseOffsetCorrection);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(targetClass.getRawImportedInterfaceName());
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_83);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(negativeOffsetCorrection);
    stringBuffer.append(TEXT_86);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(reverseOffsetCorrection);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(targetClass.getRawImportedInterfaceName());
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    } else if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_94);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_100);
    }
    stringBuffer.append(TEXT_101);
    }
    if (!genFeature.isResolveProxies() && genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_102);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    if (genFeature.hasEDefault()) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(genFeature.getEDefault());
    }
    stringBuffer.append(TEXT_105);
    } else if (genClass.isFlag(genFeature)) {
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_108);
    } else {
    stringBuffer.append(TEXT_109);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_113);
    }
    } else {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_115);
    }
    }
    } else {//volatile
    if (genFeature.isResolveProxies() && !genFeature.isListType()) {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(genFeature.getSafeNameAsEObject());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(genFeature.getNonEObjectInternalTypeCast(genClass));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_125);
    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (genFeature.isFeatureMapType()) {
    String featureMapEntryTemplateArgument = isJDK50 ? "<" + genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap") + ".Entry>" : "";
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(genFeature.getImportedEffectiveFeatureMapWrapperClass());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_130);
    stringBuffer.append(featureMapEntryTemplateArgument);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_132);
    } else {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(featureMapEntryTemplateArgument);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_137);
    }
    } else if (genFeature.isListType()) {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_138);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_141);
    } else {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_144);
    }
    } else {
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_145);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_146);
    }
    if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType()) {
    stringBuffer.append(TEXT_147);
    stringBuffer.append(genFeature.getObjectType(genClass));
    stringBuffer.append(TEXT_148);
    }
    stringBuffer.append(TEXT_149);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_152);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_153);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_154);
    }
    stringBuffer.append(TEXT_155);
    } else {
    stringBuffer.append(TEXT_156);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_157);
    }
    if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType()) {
    stringBuffer.append(TEXT_158);
    stringBuffer.append(genFeature.getObjectType(genClass));
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_162);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genFeature.getPrimitiveValueFunction());
    stringBuffer.append(TEXT_164);
    }
    stringBuffer.append(TEXT_165);
    }
    }
    } else if (genClass.getGetAccessorOperation(genFeature) != null) {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(genClass.getGetAccessorOperation(genFeature).getBody(genModel.getIndentation(stringBuffer)));
    } else {
    stringBuffer.append(TEXT_167);
    final Map<String, Object> parameters__rSALsGKSEd8eoMv8ZThYQ = new HashMap<String, Object>();
parameters__rSALsGKSEd8eoMv8ZThYQ.put("genFeature", genFeature);
parameters__rSALsGKSEd8eoMv8ZThYQ.put("genClass", genClass);
parameters__rSALsGKSEd8eoMv8ZThYQ.put("genPackage", genPackage);
parameters__rSALsGKSEd8eoMv8ZThYQ.put("genModel", genModel);
parameters__rSALsGKSEd8eoMv8ZThYQ.put("isJDK50", isJDK50);
parameters__rSALsGKSEd8eoMv8ZThYQ.put("isInterface", isInterface);
parameters__rSALsGKSEd8eoMv8ZThYQ.put("isImplementation", isImplementation);
parameters__rSALsGKSEd8eoMv8ZThYQ.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__rSALsGKSEd8eoMv8ZThYQ.put("singleWildcard", singleWildcard);
parameters__rSALsGKSEd8eoMv8ZThYQ.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__rSALsGKSEd8eoMv8ZThYQ.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0wmkMGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__rSALsGKSEd8eoMv8ZThYQ);

    //Class/getGenFeature.todo.override.javajetinc
    stringBuffer.append(TEXT_168);
    }
    }
    stringBuffer.append(TEXT_169);
    }
    stringBuffer.append(TEXT_170);
    }
    }