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

public class InterfacedeclaredFieldGenFeatureoverride 
{
  protected static String nl;
  public static synchronized InterfacedeclaredFieldGenFeatureoverride create(String lineSeparator)
  {
    nl = lineSeparator;
    InterfacedeclaredFieldGenFeatureoverride result = new InterfacedeclaredFieldGenFeatureoverride();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    ";
  protected final String TEXT_2 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_3 = "() <em>";
  protected final String TEXT_4 = "</em>}' ";
  protected final String TEXT_5 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_6 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = ";" + NL;
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * The empty value for the '{@link #";
  protected final String TEXT_10 = "() <em>";
  protected final String TEXT_11 = "</em>}' array accessor." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_12 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */";
  protected final String TEXT_13 = NL + "\t@SuppressWarnings(\"unchecked\")";
  protected final String TEXT_14 = NL + "\tprotected static final ";
  protected final String TEXT_15 = "[] ";
  protected final String TEXT_16 = "_EEMPTY_ARRAY = new ";
  protected final String TEXT_17 = " [0]";
  protected final String TEXT_18 = ";" + NL;
  protected final String TEXT_19 = NL + "\t/**" + NL + "\t * The default value of the '{@link #";
  protected final String TEXT_20 = "() <em>";
  protected final String TEXT_21 = "</em>}' ";
  protected final String TEXT_22 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_23 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */";
  protected final String TEXT_24 = NL + "\t@SuppressWarnings(\"unchecked\")";
  protected final String TEXT_25 = NL + "\tprotected static final ";
  protected final String TEXT_26 = " ";
  protected final String TEXT_27 = "; // TODO The default value literal \"";
  protected final String TEXT_28 = "\" is not valid.";
  protected final String TEXT_29 = " = ";
  protected final String TEXT_30 = ";";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_33 = " = 0;" + NL;
  protected final String TEXT_34 = NL + "\t/**" + NL + "\t * The offset of the flags representing the value of the '{@link #";
  protected final String TEXT_35 = "() <em>";
  protected final String TEXT_36 = "</em>}' ";
  protected final String TEXT_37 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_38 = "_EFLAG_OFFSET = ";
  protected final String TEXT_39 = ";" + NL + "" + NL + "\t/**" + NL + "\t * The flags representing the default value of the '{@link #";
  protected final String TEXT_40 = "() <em>";
  protected final String TEXT_41 = "</em>}' ";
  protected final String TEXT_42 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_43 = "_EFLAG_DEFAULT = ";
  protected final String TEXT_44 = ".ordinal()";
  protected final String TEXT_45 = ".VALUES.indexOf(";
  protected final String TEXT_46 = ")";
  protected final String TEXT_47 = " << ";
  protected final String TEXT_48 = "_EFLAG_OFFSET;" + NL + "" + NL + "\t/**" + NL + "\t * The array of enumeration values for '{@link ";
  protected final String TEXT_49 = " ";
  protected final String TEXT_50 = "}'" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprivate static final ";
  protected final String TEXT_51 = "[] ";
  protected final String TEXT_52 = "_EFLAG_VALUES = ";
  protected final String TEXT_53 = ".values()";
  protected final String TEXT_54 = "(";
  protected final String TEXT_55 = "[])";
  protected final String TEXT_56 = ".VALUES.toArray(new ";
  protected final String TEXT_57 = "[";
  protected final String TEXT_58 = ".VALUES.size()])";
  protected final String TEXT_59 = ";" + NL;
  protected final String TEXT_60 = NL + "\t/**" + NL + "\t * The flag";
  protected final String TEXT_61 = " representing the value of the '{@link #";
  protected final String TEXT_62 = "() <em>";
  protected final String TEXT_63 = "</em>}' ";
  protected final String TEXT_64 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_65 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_66 = "_EFLAG = ";
  protected final String TEXT_67 = " << ";
  protected final String TEXT_68 = "_EFLAG_OFFSET";
  protected final String TEXT_69 = ";" + NL;
  protected final String TEXT_70 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
  protected final String TEXT_71 = "() <em>";
  protected final String TEXT_72 = "</em>}' ";
  protected final String TEXT_73 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
  protected final String TEXT_74 = "()" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_75 = " ";
  protected final String TEXT_76 = " = ";
  protected final String TEXT_77 = ";" + NL;
  protected final String TEXT_78 = NL + "\t/**" + NL + "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected int ";
  protected final String TEXT_79 = " = 0;" + NL;
  protected final String TEXT_80 = NL + "\t/**" + NL + "\t * The flag representing whether the ";
  protected final String TEXT_81 = " ";
  protected final String TEXT_82 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final int ";
  protected final String TEXT_83 = "_ESETFLAG = 1 << ";
  protected final String TEXT_84 = ";" + NL;
  protected final String TEXT_85 = NL + "\t/**" + NL + "\t * This is true if the ";
  protected final String TEXT_86 = " ";
  protected final String TEXT_87 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected boolean ";
  protected final String TEXT_88 = "ESet;" + NL;
  protected final String TEXT_89 = NL;
  protected final String TEXT_90 = NL;
  protected final String TEXT_91 = NL;
  protected final String TEXT_92 = NL;

	public InterfacedeclaredFieldGenFeatureoverride()
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
    
    stringBuffer.append(TEXT_91);
    stringBuffer.append(TEXT_92);
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
    if (genFeature.isListType() || genFeature.isReferenceType()) {
    if (genClass.isField(genFeature)) {
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genFeature.getImportedInternalType(genClass));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genFeature.getSafeName());
    stringBuffer.append(TEXT_8);
    }
    if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) { String rawListItemType = genFeature.getRawListItemType(); int index = rawListItemType.indexOf('['); String head = rawListItemType; String tail = ""; if (index != -1) { head = rawListItemType.substring(0, index); tail = rawListItemType.substring(index); } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genFeature.getGetArrayAccessor());
    stringBuffer.append(TEXT_12);
    if (genFeature.getQualifiedListItemType(genClass).contains("<")) {
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(rawListItemType);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(head);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(tail);
    stringBuffer.append(TEXT_18);
    }
    } else {
    if (genFeature.hasEDefault() && (!genFeature.isVolatile() || !genModel.isReflectiveDelegation() && (!genFeature.hasDelegateFeature() || !genFeature.isUnsettable()))) { String staticDefaultValue = genFeature.getStaticDefaultValue();
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_23);
    if (genModel.useGenerics() && genFeature.isListDataType() && genFeature.isSetDefaultValue()) {
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genFeature.getEDefault());
    if ("".equals(staticDefaultValue)) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genFeature.getEcoreFeature().getDefaultValueLiteral());
    stringBuffer.append(TEXT_28);
    } else {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(staticDefaultValue);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genModel.getNonNLS(staticDefaultValue));
    }
    stringBuffer.append(TEXT_31);
    }
    if (genClass.isField(genFeature)) {
    if (genClass.isFlag(genFeature)) { int flagIndex = genClass.getFlagIndex(genFeature);
    if (flagIndex > 31 && flagIndex % 32 == 0) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genClass.getFlagsField(genFeature));
    stringBuffer.append(TEXT_33);
    }
    if (genFeature.isEnumType()) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(flagIndex % 32);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_43);
    if (isJDK50) {
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_44);
    } else {
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genFeature.getEDefault());
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genFeature.getTypeGenClassifier().getFormattedName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_52);
    if (isJDK50) {
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_53);
    } else {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genClass.getFlagSize(genFeature) > 1 ? "s" : "");
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genClass.getFlagMask(genFeature));
    stringBuffer.append(TEXT_67);
    if (genFeature.isEnumType()) {
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_68);
    } else {
    stringBuffer.append(flagIndex % 32);
    }
    stringBuffer.append(TEXT_69);
    } else {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genFeature.getGetAccessor());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genFeature.getImportedType(genClass));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(genFeature.getSafeName());
    if (genFeature.hasEDefault()) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genFeature.getEDefault());
    }
    stringBuffer.append(TEXT_77);
    }
    }
    }
    if (genClass.isESetField(genFeature)) {
    if (genClass.isESetFlag(genFeature)) { int flagIndex = genClass.getESetFlagIndex(genFeature);
    if (flagIndex > 31 && flagIndex % 32 == 0) {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genClass.getESetFlagsField(genFeature));
    stringBuffer.append(TEXT_79);
    }
    stringBuffer.append(TEXT_80);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(genFeature.getUpperName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(flagIndex % 32 );
    stringBuffer.append(TEXT_84);
    } else {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(genFeature.getFeatureKind());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(genFeature.getUncapName());
    stringBuffer.append(TEXT_88);
    }
    }
    stringBuffer.append(TEXT_89);
    final Map<String, Object> parameters__2NuhIGKMEd_wNQtGaQlw = new HashMap<String, Object>();
parameters__2NuhIGKMEd_wNQtGaQlw.put("genFeature", genFeature);
parameters__2NuhIGKMEd_wNQtGaQlw.put("genClass", genClass);
parameters__2NuhIGKMEd_wNQtGaQlw.put("genPackage", genPackage);
parameters__2NuhIGKMEd_wNQtGaQlw.put("genModel", genModel);
parameters__2NuhIGKMEd_wNQtGaQlw.put("isJDK50", isJDK50);
parameters__2NuhIGKMEd_wNQtGaQlw.put("isInterface", isInterface);
parameters__2NuhIGKMEd_wNQtGaQlw.put("isImplementation", isImplementation);
parameters__2NuhIGKMEd_wNQtGaQlw.put("publicStaticFinalFlag", publicStaticFinalFlag);
parameters__2NuhIGKMEd_wNQtGaQlw.put("singleWildcard", singleWildcard);
parameters__2NuhIGKMEd_wNQtGaQlw.put("negativeOffsetCorrection", negativeOffsetCorrection);
parameters__2NuhIGKMEd_wNQtGaQlw.put("positiveOffsetCorrection", positiveOffsetCorrection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0vHWcGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__2NuhIGKMEd_wNQtGaQlw);

    stringBuffer.append(TEXT_90);
    }
    }