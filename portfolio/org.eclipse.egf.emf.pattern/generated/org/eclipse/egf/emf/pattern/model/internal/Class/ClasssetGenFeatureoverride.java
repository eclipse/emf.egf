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

public class ClasssetGenFeatureoverride 
{
  protected static String nl;
  public static synchronized ClasssetGenFeatureoverride create(String lineSeparator)
  {
    nl = lineSeparator;
    ClasssetGenFeatureoverride result = new ClasssetGenFeatureoverride();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\tvoid set";
  protected final String TEXT_5 = "(";
  protected final String TEXT_6 = " value);" + NL;
  protected final String TEXT_7 = NL + "\tpublic void set";
  protected final String TEXT_8 = "_";
  protected final String TEXT_9 = "(";
  protected final String TEXT_10 = " ";
  protected final String TEXT_11 = ")" + NL + "\t{";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "\t\teDynamicSet(";
  protected final String TEXT_14 = ", ";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = "new ";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = "new";
  protected final String TEXT_19 = ")";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\teSet(";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = "new ";
  protected final String TEXT_24 = "(";
  protected final String TEXT_25 = "new";
  protected final String TEXT_26 = ")";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\tif (new";
  protected final String TEXT_29 = " != eInternalContainer() || (eContainerFeatureID() != ";
  protected final String TEXT_30 = " && new";
  protected final String TEXT_31 = " != null))" + NL + "\t\t{" + NL + "\t\t\tif (";
  protected final String TEXT_32 = ".isAncestor(this, ";
  protected final String TEXT_33 = "new";
  protected final String TEXT_34 = "))" + NL + "\t\t\t\tthrow new ";
  protected final String TEXT_35 = "(\"Recursive containment not allowed for \" + toString());";
  protected final String TEXT_36 = NL + "\t\t\t";
  protected final String TEXT_37 = " msgs = null;" + NL + "\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\tmsgs = eBasicRemoveFromContainer(msgs);" + NL + "\t\t\tif (new";
  protected final String TEXT_38 = " != null)" + NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_39 = ")new";
  protected final String TEXT_40 = ").eInverseAdd(this, ";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ".class, msgs);" + NL + "\t\t\tmsgs = basicSet";
  protected final String TEXT_43 = "(";
  protected final String TEXT_44 = "new";
  protected final String TEXT_45 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
  protected final String TEXT_46 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_47 = "(this, ";
  protected final String TEXT_48 = ".SET, ";
  protected final String TEXT_49 = ", new";
  protected final String TEXT_50 = ", new";
  protected final String TEXT_51 = "));";
  protected final String TEXT_52 = NL + "\t\t";
  protected final String TEXT_53 = " ";
  protected final String TEXT_54 = " = (";
  protected final String TEXT_55 = ")eVirtualGet(";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "\t\tif (new";
  protected final String TEXT_58 = " != ";
  protected final String TEXT_59 = ")" + NL + "\t\t{" + NL + "\t\t\t";
  protected final String TEXT_60 = " msgs = null;" + NL + "\t\t\tif (";
  protected final String TEXT_61 = " != null)";
  protected final String TEXT_62 = NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_63 = ")";
  protected final String TEXT_64 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_65 = ", null, msgs);" + NL + "\t\t\tif (new";
  protected final String TEXT_66 = " != null)" + NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_67 = ")new";
  protected final String TEXT_68 = ").eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
  protected final String TEXT_69 = ", null, msgs);";
  protected final String TEXT_70 = NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_71 = ")";
  protected final String TEXT_72 = ").eInverseRemove(this, ";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ".class, msgs);" + NL + "\t\t\tif (new";
  protected final String TEXT_75 = " != null)" + NL + "\t\t\t\tmsgs = ((";
  protected final String TEXT_76 = ")new";
  protected final String TEXT_77 = ").eInverseAdd(this, ";
  protected final String TEXT_78 = ", ";
  protected final String TEXT_79 = ".class, msgs);";
  protected final String TEXT_80 = NL + "\t\t\tmsgs = basicSet";
  protected final String TEXT_81 = "(";
  protected final String TEXT_82 = "new";
  protected final String TEXT_83 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
  protected final String TEXT_84 = NL + "\t\telse" + NL + "\t\t{";
  protected final String TEXT_85 = NL + "\t\t\tboolean old";
  protected final String TEXT_86 = "ESet = eVirtualIsSet(";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\t\t\tboolean old";
  protected final String TEXT_89 = "ESet = (";
  protected final String TEXT_90 = " & ";
  protected final String TEXT_91 = "_ESETFLAG) != 0;";
  protected final String TEXT_92 = NL + "\t\t\t";
  protected final String TEXT_93 = " |= ";
  protected final String TEXT_94 = "_ESETFLAG;";
  protected final String TEXT_95 = NL + "\t\t\tboolean old";
  protected final String TEXT_96 = "ESet = ";
  protected final String TEXT_97 = "ESet;";
  protected final String TEXT_98 = NL + "\t\t\t";
  protected final String TEXT_99 = "ESet = true;";
  protected final String TEXT_100 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
  protected final String TEXT_101 = "(this, ";
  protected final String TEXT_102 = ".SET, ";
  protected final String TEXT_103 = ", new";
  protected final String TEXT_104 = ", new";
  protected final String TEXT_105 = ", !old";
  protected final String TEXT_106 = "ESet));";
  protected final String TEXT_107 = NL + "\t\t}";
  protected final String TEXT_108 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_109 = "(this, ";
  protected final String TEXT_110 = ".SET, ";
  protected final String TEXT_111 = ", new";
  protected final String TEXT_112 = ", new";
  protected final String TEXT_113 = "));";
  protected final String TEXT_114 = NL + "\t\t";
  protected final String TEXT_115 = " old";
  protected final String TEXT_116 = " = (";
  protected final String TEXT_117 = " & ";
  protected final String TEXT_118 = "_EFLAG) != 0;";
  protected final String TEXT_119 = NL + "\t\t";
  protected final String TEXT_120 = " old";
  protected final String TEXT_121 = " = ";
  protected final String TEXT_122 = "_EFLAG_VALUES[(";
  protected final String TEXT_123 = " & ";
  protected final String TEXT_124 = "_EFLAG) >>> ";
  protected final String TEXT_125 = "_EFLAG_OFFSET];";
  protected final String TEXT_126 = NL + "\t\tif (new";
  protected final String TEXT_127 = ") ";
  protected final String TEXT_128 = " |= ";
  protected final String TEXT_129 = "_EFLAG; else ";
  protected final String TEXT_130 = " &= ~";
  protected final String TEXT_131 = "_EFLAG;";
  protected final String TEXT_132 = NL + "\t\tif (new";
  protected final String TEXT_133 = " == null) new";
  protected final String TEXT_134 = " = ";
  protected final String TEXT_135 = "_EDEFAULT;" + NL + "\t\t";
  protected final String TEXT_136 = " = ";
  protected final String TEXT_137 = " & ~";
  protected final String TEXT_138 = "_EFLAG | ";
  protected final String TEXT_139 = "new";
  protected final String TEXT_140 = ".ordinal()";
  protected final String TEXT_141 = ".VALUES.indexOf(new";
  protected final String TEXT_142 = ")";
  protected final String TEXT_143 = " << ";
  protected final String TEXT_144 = "_EFLAG_OFFSET;";
  protected final String TEXT_145 = NL + "\t\t";
  protected final String TEXT_146 = " old";
  protected final String TEXT_147 = " = ";
  protected final String TEXT_148 = ";";
  protected final String TEXT_149 = NL + "\t\t";
  protected final String TEXT_150 = " ";
  protected final String TEXT_151 = " = new";
  protected final String TEXT_152 = " == null ? ";
  protected final String TEXT_153 = " : new";
  protected final String TEXT_154 = ";";
  protected final String TEXT_155 = NL + "\t\t";
  protected final String TEXT_156 = " = new";
  protected final String TEXT_157 = " == null ? ";
  protected final String TEXT_158 = " : new";
  protected final String TEXT_159 = ";";
  protected final String TEXT_160 = NL + "\t\t";
  protected final String TEXT_161 = " ";
  protected final String TEXT_162 = " = ";
  protected final String TEXT_163 = "new";
  protected final String TEXT_164 = ";";
  protected final String TEXT_165 = NL + "\t\t";
  protected final String TEXT_166 = " = ";
  protected final String TEXT_167 = "new";
  protected final String TEXT_168 = ";";
  protected final String TEXT_169 = NL + "\t\tObject old";
  protected final String TEXT_170 = " = eVirtualSet(";
  protected final String TEXT_171 = ", ";
  protected final String TEXT_172 = ");";
  protected final String TEXT_173 = NL + "\t\tboolean isSetChange = old";
  protected final String TEXT_174 = " == EVIRTUAL_NO_VALUE;";
  protected final String TEXT_175 = NL + "\t\tboolean old";
  protected final String TEXT_176 = "ESet = (";
  protected final String TEXT_177 = " & ";
  protected final String TEXT_178 = "_ESETFLAG) != 0;";
  protected final String TEXT_179 = NL + "\t\t";
  protected final String TEXT_180 = " |= ";
  protected final String TEXT_181 = "_ESETFLAG;";
  protected final String TEXT_182 = NL + "\t\tboolean old";
  protected final String TEXT_183 = "ESet = ";
  protected final String TEXT_184 = "ESet;";
  protected final String TEXT_185 = NL + "\t\t";
  protected final String TEXT_186 = "ESet = true;";
  protected final String TEXT_187 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_188 = "(this, ";
  protected final String TEXT_189 = ".SET, ";
  protected final String TEXT_190 = ", ";
  protected final String TEXT_191 = "isSetChange ? ";
  protected final String TEXT_192 = " : old";
  protected final String TEXT_193 = "old";
  protected final String TEXT_194 = ", ";
  protected final String TEXT_195 = "new";
  protected final String TEXT_196 = ", ";
  protected final String TEXT_197 = "isSetChange";
  protected final String TEXT_198 = "!old";
  protected final String TEXT_199 = "ESet";
  protected final String TEXT_200 = "));";
  protected final String TEXT_201 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
  protected final String TEXT_202 = "(this, ";
  protected final String TEXT_203 = ".SET, ";
  protected final String TEXT_204 = ", ";
  protected final String TEXT_205 = "old";
  protected final String TEXT_206 = " == EVIRTUAL_NO_VALUE ? ";
  protected final String TEXT_207 = " : old";
  protected final String TEXT_208 = "old";
  protected final String TEXT_209 = ", ";
  protected final String TEXT_210 = "new";
  protected final String TEXT_211 = "));";
  protected final String TEXT_212 = NL;
  protected final String TEXT_213 = NL + "\t\t((";
  protected final String TEXT_214 = ".Internal)((";
  protected final String TEXT_215 = ".Internal.Wrapper)get";
  protected final String TEXT_216 = "()).featureMap()).set(";
  protected final String TEXT_217 = ", ";
  protected final String TEXT_218 = "new ";
  protected final String TEXT_219 = "(";
  protected final String TEXT_220 = "new";
  protected final String TEXT_221 = ")";
  protected final String TEXT_222 = ");";
  protected final String TEXT_223 = NL + "\t\t((";
  protected final String TEXT_224 = ".Internal)get";
  protected final String TEXT_225 = "()).set(";
  protected final String TEXT_226 = ", ";
  protected final String TEXT_227 = "new ";
  protected final String TEXT_228 = "(";
  protected final String TEXT_229 = "new";
  protected final String TEXT_230 = ")";
  protected final String TEXT_231 = ");";
  protected final String TEXT_232 = NL + "\t\t";
  protected final String TEXT_233 = NL;
  protected final String TEXT_234 = "    ";
  protected final String TEXT_235 = NL + "\t}" + NL;
  protected final String TEXT_236 = NL;
  protected final String TEXT_237 = NL;
  protected final String TEXT_238 = NL;

	public ClasssetGenFeatureoverride()
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
    
    stringBuffer.append(TEXT_237);
    stringBuffer.append(TEXT_238);
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
    final Map<String, Object> parameters__zh9KUGJ_EdFqczH3ESmRw = new HashMap<String, Object>();
parameters__zh9KUGJ_EdFqczH3ESmRw.put("genFeature", genFeature);
parameters__zh9KUGJ_EdFqczH3ESmRw.put("genClass", genClass);
parameters__zh9KUGJ_EdFqczH3ESmRw.put("genPackage", genPackage);
parameters__zh9KUGJ_EdFqczH3ESmRw.put("genModel", genModel);
parameters__zh9KUGJ_EdFqczH3ESmRw.put("isJDK50", isJDK50);
parameters__zh9KUGJ_EdFqczH3ESmRw.put("isInterface", isInterface);
parameters__zh9KUGJ_EdFqczH3ESmRw.put("isImplementation", isImplementation);
parameters__zh9KUGJ_EdFqczH3ESmRw.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__zh9KUGJ_EdFqczH3ESmRw.put("singleWildcard", singleWildcard);
parameters__zh9KUGJ_EdFqczH3ESmRw.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__zh9KUGJ_EdFqczH3ESmRw.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0nXIoGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__zh9KUGJ_EdFqczH3ESmRw);

    //Class/setGenFeature.javadoc.override.javajetinc
    } else {
    stringBuffer.append(TEXT_2);
    if (isJDK50) { //Class/setGenFeature.annotations.insert.javajetinc
    stringBuffer.append(TEXT_3);
    final Map<String, Object> parameters__zh9KUWJ_EdFqczH3ESmRw = new HashMap<String, Object>();
parameters__zh9KUWJ_EdFqczH3ESmRw.put("genFeature", genFeature);
parameters__zh9KUWJ_EdFqczH3ESmRw.put("genClass", genClass);
parameters__zh9KUWJ_EdFqczH3ESmRw.put("genPackage", genPackage);
parameters__zh9KUWJ_EdFqczH3ESmRw.put("genModel", genModel);
parameters__zh9KUWJ_EdFqczH3ESmRw.put("isJDK50", isJDK50);
parameters__zh9KUWJ_EdFqczH3ESmRw.put("isInterface", isInterface);
parameters__zh9KUWJ_EdFqczH3ESmRw.put("isImplementation", isImplementation);
parameters__zh9KUWJ_EdFqczH3ESmRw.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__zh9KUWJ_EdFqczH3ESmRw.put("singleWildcard", singleWildcard);
parameters__zh9KUWJ_EdFqczH3ESmRw.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__zh9KUWJ_EdFqczH3ESmRw.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0nqqoGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__zh9KUWJ_EdFqczH3ESmRw);

    }
    }
    if (!isImplementation) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_6);
    } else { GenOperation setAccessorOperation = genClass.getSetAccessorOperation(genFeature);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genFeature.getAccessorName());
    if (genClass.hasCollidingSetAccessorOperation(genFeature)) {
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(setAccessorOperation == null ? "new" + genFeature.getCapName() : setAccessorOperation.getGenParameters().get(0).getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    final Map<String, Object> parameters__zh9KUmJ_EdFqczH3ESmRw = new HashMap<String, Object>();
parameters__zh9KUmJ_EdFqczH3ESmRw.put("setAccessorOperation", setAccessorOperation);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("genFeature", genFeature);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("genClass", genClass);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("genPackage", genPackage);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("genModel", genModel);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("isJDK50", isJDK50);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("isInterface", isInterface);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("isImplementation", isImplementation);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("singleWildcard", singleWildcard);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__zh9KUmJ_EdFqczH3ESmRw.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0nz0kGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__zh9KUmJ_EdFqczH3ESmRw);

    if (genModel.isDynamicDelegation()) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_15);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genFeature.getObjectType(genClass));
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genFeature.getCapName());
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    } else if (genModel.isReflectiveDelegation()) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_22);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genFeature.getObjectType(genClass));
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genFeature.getCapName());
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    } else if (!genFeature.isVolatile()) {
    if (genFeature.isContainer()) { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genFeature.getEObjectCast());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genModel.getImportedName("java.lang.IllegalArgumentException"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genModel.getNonNLS());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(reverseOffsetCorrection);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(targetClass.getRawImportedInterfaceName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_45);
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_51);
    }
    } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_61);
    if (!genFeature.isBidirectional()) {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(negativeOffsetCorrection);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(negativeOffsetCorrection);
    stringBuffer.append(TEXT_69);
    } else { GenFeature reverseFeature = genFeature.getReverse(); GenClass targetClass = reverseFeature.getGenClass(); String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(reverseOffsetCorrection);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(targetClass.getRawImportedInterfaceName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
    stringBuffer.append(reverseOffsetCorrection);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(targetClass.getRawImportedInterfaceName());
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_83);
    if (genFeature.isUnsettable()) {
    stringBuffer.append(TEXT_84);
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_87);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_94);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_96);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_99);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_113);
    }
    }
    } else {
    if (genClass.isFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_118);
    } else {
    stringBuffer.append(TEXT_119);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_121);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_125);
    }
    }
    if (genFeature.isBooleanType()) {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_131);
    } else {
    stringBuffer.append(TEXT_132);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_138);
    if (isJDK50) {
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_140);
    } else {
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_144);
    }
    } else {
    if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_148);
    }
    }
    if (genFeature.isEnumType()) {
    if (genModel.isVirtualDelegation()) {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_153);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_154);
    } else {
    stringBuffer.append(TEXT_155);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_159);
    }
    } else {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_160);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_164);
    } else {
    stringBuffer.append(TEXT_165);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(genFeature.getInternalTypeCast());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_168);
    }
    }
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_169);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_172);
    }
    }
    if (genFeature.isUnsettable()) {
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_173);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_174);
    } else if (genClass.isESetFlag(genFeature)) {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_175);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_176);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_178);
    }
    stringBuffer.append(TEXT_179);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_181);
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_182);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_184);
    }
    stringBuffer.append(TEXT_185);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_186);
    }
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_187);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_190);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_191);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_192);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_193);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_194);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_196);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_197);
    } else {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_199);
    }
    stringBuffer.append(TEXT_200);
    }
    } else {
    if (!genModel.isSuppressNotification()) {
    stringBuffer.append(TEXT_201);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
    stringBuffer.append(positiveOffsetCorrection);
    stringBuffer.append(TEXT_204);
    if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_205);
    stringBuffer.append(genFeature.getCapName());
    stringBuffer.append(TEXT_206);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_207);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(TEXT_208);
    stringBuffer.append(genFeature.getCapName());
    }
    stringBuffer.append(TEXT_209);
    if (genClass.isFlag(genFeature)) {
    stringBuffer.append(TEXT_210);
    stringBuffer.append(genFeature.getCapName());
    } else {
    stringBuffer.append(genFeature.getSafeName());
    }
    stringBuffer.append(TEXT_211);
    }
    }
    }
    stringBuffer.append(TEXT_212);
    final Map<String, Object> parameters__ziG7UGJ_EdFqczH3ESmRw = new HashMap<String, Object>();
parameters__ziG7UGJ_EdFqczH3ESmRw.put("setAccessorOperation", setAccessorOperation);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("genFeature", genFeature);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("genClass", genClass);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("genPackage", genPackage);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("genModel", genModel);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("isJDK50", isJDK50);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("isInterface", isInterface);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("isImplementation", isImplementation);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("singleWildcard", singleWildcard);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__ziG7UGJ_EdFqczH3ESmRw.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0qMaMGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__ziG7UGJ_EdFqczH3ESmRw);

    } else if (genFeature.hasDelegateFeature()) { GenFeature delegateFeature = genFeature.getDelegateFeature();
    if (delegateFeature.isWrappedFeatureMapType()) {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_217);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_218);
    stringBuffer.append(genFeature.getObjectType(genClass));
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    stringBuffer.append(genFeature.getCapName());
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_221);
    }
    stringBuffer.append(TEXT_222);
    } else {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(delegateFeature.getAccessorName());
    stringBuffer.append(TEXT_225);
    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_226);
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_227);
    stringBuffer.append(genFeature.getObjectType(genClass));
    stringBuffer.append(TEXT_228);
    }
    stringBuffer.append(TEXT_229);
    stringBuffer.append(genFeature.getCapName());
    if (!isJDK50 && genFeature.isPrimitiveType()) {
    stringBuffer.append(TEXT_230);
    }
    stringBuffer.append(TEXT_231);
    }
    } else if (setAccessorOperation != null) {
    stringBuffer.append(TEXT_232);
    stringBuffer.append(setAccessorOperation.getBody(genModel.getIndentation(stringBuffer)));
    } else {
    stringBuffer.append(TEXT_233);
    final Map<String, Object> parameters__ziG7UWJ_EdFqczH3ESmRw = new HashMap<String, Object>();
parameters__ziG7UWJ_EdFqczH3ESmRw.put("setAccessorOperation", setAccessorOperation);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("genFeature", genFeature);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("genClass", genClass);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("genPackage", genPackage);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("genModel", genModel);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("isJDK50", isJDK50);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("isInterface", isInterface);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("isImplementation", isImplementation);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("singleWildcard", singleWildcard);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__ziG7UWJ_EdFqczH3ESmRw.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0qMaRWJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__ziG7UWJ_EdFqczH3ESmRw);

    //Class/setGenFeature.todo.override.javajetinc
    stringBuffer.append(TEXT_234);
    }
    stringBuffer.append(TEXT_235);
    }
    stringBuffer.append(TEXT_236);
    }
    }