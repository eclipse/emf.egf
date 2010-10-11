package org.eclipse.egf.emf.pattern.model.call.Class;

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

public class ClassunsetGenFeatureoverride {
    protected static String nl;

    public static synchronized ClassunsetGenFeatureoverride create(String lineSeparator) {
        nl = lineSeparator;
        ClassunsetGenFeatureoverride result = new ClassunsetGenFeatureoverride();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_4 = NL;
    protected final String TEXT_5 = NL + "\tvoid unset";
    protected final String TEXT_6 = "();" + NL;
    protected final String TEXT_7 = NL + "\tpublic void unset";
    protected final String TEXT_8 = "_";
    protected final String TEXT_9 = "()" + NL + "\t{";
    protected final String TEXT_10 = NL + "\t\teDynamicUnset(";
    protected final String TEXT_11 = ", ";
    protected final String TEXT_12 = ");";
    protected final String TEXT_13 = NL + "\t\teUnset(";
    protected final String TEXT_14 = ");";
    protected final String TEXT_15 = NL + "\t\t";
    protected final String TEXT_16 = " ";
    protected final String TEXT_17 = " = (";
    protected final String TEXT_18 = ")eVirtualGet(";
    protected final String TEXT_19 = ");";
    protected final String TEXT_20 = NL + "\t\tif (";
    protected final String TEXT_21 = " != null) ((";
    protected final String TEXT_22 = ".Unsettable";
    protected final String TEXT_23 = ")";
    protected final String TEXT_24 = ").unset();";
    protected final String TEXT_25 = NL + "\t\t";
    protected final String TEXT_26 = " ";
    protected final String TEXT_27 = " = (";
    protected final String TEXT_28 = ")eVirtualGet(";
    protected final String TEXT_29 = ");";
    protected final String TEXT_30 = NL + "\t\tif (";
    protected final String TEXT_31 = " != null)" + NL + "\t\t{" + NL + "\t\t\t";
    protected final String TEXT_32 = " msgs = null;";
    protected final String TEXT_33 = NL + "\t\t\tmsgs = ((";
    protected final String TEXT_34 = ")";
    protected final String TEXT_35 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
    protected final String TEXT_36 = ", null, msgs);";
    protected final String TEXT_37 = NL + "\t\t\tmsgs = ((";
    protected final String TEXT_38 = ")";
    protected final String TEXT_39 = ").eInverseRemove(this, ";
    protected final String TEXT_40 = ", ";
    protected final String TEXT_41 = ".class, msgs);";
    protected final String TEXT_42 = NL + "\t\t\tmsgs = basicUnset";
    protected final String TEXT_43 = "(msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}" + NL + "\t\telse" + NL + "\t\t{";
    protected final String TEXT_44 = NL + "\t\t\tboolean old";
    protected final String TEXT_45 = "ESet = eVirtualIsSet(";
    protected final String TEXT_46 = ");";
    protected final String TEXT_47 = NL + "\t\t\tboolean old";
    protected final String TEXT_48 = "ESet = (";
    protected final String TEXT_49 = " & ";
    protected final String TEXT_50 = "_ESETFLAG) != 0;";
    protected final String TEXT_51 = NL + "\t\t\t";
    protected final String TEXT_52 = " &= ~";
    protected final String TEXT_53 = "_ESETFLAG;";
    protected final String TEXT_54 = NL + "\t\t\tboolean old";
    protected final String TEXT_55 = "ESet = ";
    protected final String TEXT_56 = "ESet;";
    protected final String TEXT_57 = NL + "\t\t\t";
    protected final String TEXT_58 = "ESet = false;";
    protected final String TEXT_59 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
    protected final String TEXT_60 = "(this, ";
    protected final String TEXT_61 = ".UNSET, ";
    protected final String TEXT_62 = ", null, null, old";
    protected final String TEXT_63 = "ESet));";
    protected final String TEXT_64 = NL + "\t\t}";
    protected final String TEXT_65 = NL + "\t\t";
    protected final String TEXT_66 = " old";
    protected final String TEXT_67 = " = (";
    protected final String TEXT_68 = " & ";
    protected final String TEXT_69 = "_EFLAG) != 0;";
    protected final String TEXT_70 = NL + "\t\t";
    protected final String TEXT_71 = " old";
    protected final String TEXT_72 = " = ";
    protected final String TEXT_73 = "_EFLAG_VALUES[(";
    protected final String TEXT_74 = " & ";
    protected final String TEXT_75 = "_EFLAG) >>> ";
    protected final String TEXT_76 = "_EFLAG_OFFSET];";
    protected final String TEXT_77 = NL + "\t\tObject old";
    protected final String TEXT_78 = " = eVirtualUnset(";
    protected final String TEXT_79 = ");";
    protected final String TEXT_80 = NL + "\t\t";
    protected final String TEXT_81 = " old";
    protected final String TEXT_82 = " = ";
    protected final String TEXT_83 = ";";
    protected final String TEXT_84 = NL + "\t\tboolean isSetChange = old";
    protected final String TEXT_85 = " != EVIRTUAL_NO_VALUE;";
    protected final String TEXT_86 = NL + "\t\tboolean old";
    protected final String TEXT_87 = "ESet = (";
    protected final String TEXT_88 = " & ";
    protected final String TEXT_89 = "_ESETFLAG) != 0;";
    protected final String TEXT_90 = NL + "\t\tboolean old";
    protected final String TEXT_91 = "ESet = ";
    protected final String TEXT_92 = "ESet;";
    protected final String TEXT_93 = NL + "\t\t";
    protected final String TEXT_94 = " = null;";
    protected final String TEXT_95 = NL + "\t\t";
    protected final String TEXT_96 = " &= ~";
    protected final String TEXT_97 = "_ESETFLAG;";
    protected final String TEXT_98 = NL + "\t\t";
    protected final String TEXT_99 = "ESet = false;";
    protected final String TEXT_100 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
    protected final String TEXT_101 = "(this, ";
    protected final String TEXT_102 = ".UNSET, ";
    protected final String TEXT_103 = ", ";
    protected final String TEXT_104 = "isSetChange ? old";
    protected final String TEXT_105 = " : null";
    protected final String TEXT_106 = "old";
    protected final String TEXT_107 = ", null, ";
    protected final String TEXT_108 = "isSetChange";
    protected final String TEXT_109 = "old";
    protected final String TEXT_110 = "ESet";
    protected final String TEXT_111 = "));";
    protected final String TEXT_112 = NL + "\t\tif (";
    protected final String TEXT_113 = ") ";
    protected final String TEXT_114 = " |= ";
    protected final String TEXT_115 = "_EFLAG; else ";
    protected final String TEXT_116 = " &= ~";
    protected final String TEXT_117 = "_EFLAG;";
    protected final String TEXT_118 = NL + "\t\t";
    protected final String TEXT_119 = " = ";
    protected final String TEXT_120 = " & ~";
    protected final String TEXT_121 = "_EFLAG | ";
    protected final String TEXT_122 = "_EFLAG_DEFAULT;";
    protected final String TEXT_123 = NL + "\t\t";
    protected final String TEXT_124 = " = ";
    protected final String TEXT_125 = ";";
    protected final String TEXT_126 = NL + "\t\t";
    protected final String TEXT_127 = " &= ~";
    protected final String TEXT_128 = "_ESETFLAG;";
    protected final String TEXT_129 = NL + "\t\t";
    protected final String TEXT_130 = "ESet = false;";
    protected final String TEXT_131 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
    protected final String TEXT_132 = "(this, ";
    protected final String TEXT_133 = ".UNSET, ";
    protected final String TEXT_134 = ", ";
    protected final String TEXT_135 = "isSetChange ? old";
    protected final String TEXT_136 = " : ";
    protected final String TEXT_137 = "old";
    protected final String TEXT_138 = ", ";
    protected final String TEXT_139 = ", ";
    protected final String TEXT_140 = "isSetChange";
    protected final String TEXT_141 = "old";
    protected final String TEXT_142 = "ESet";
    protected final String TEXT_143 = "));";
    protected final String TEXT_144 = NL + "\t\t((";
    protected final String TEXT_145 = ".Internal)((";
    protected final String TEXT_146 = ".Internal.Wrapper)get";
    protected final String TEXT_147 = "()).featureMap()).clear(";
    protected final String TEXT_148 = ");";
    protected final String TEXT_149 = NL + "\t\t((";
    protected final String TEXT_150 = ".Internal)get";
    protected final String TEXT_151 = "()).clear(";
    protected final String TEXT_152 = ");";
    protected final String TEXT_153 = NL + "\t\t";
    protected final String TEXT_154 = NL;
    protected final String TEXT_155 = NL + "\t}" + NL;
    protected final String TEXT_156 = NL;
    protected final String TEXT_157 = NL;
    protected final String TEXT_158 = NL;

    public ClassunsetGenFeatureoverride() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
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

        for (Object genFeatureParameter : genFeatureList) {
            for (Object genClassParameter : genClassList) {
                for (Object genPackageParameter : genPackageList) {
                    for (Object genModelParameter : genModelList) {
                        for (Object isJDK50Parameter : isJDK50List) {
                            for (Object isInterfaceParameter : isInterfaceList) {
                                for (Object isImplementationParameter : isImplementationList) {
                                    for (Object publicStaticFinalFlagParameter : publicStaticFinalFlagList) {
                                        for (Object singleWildcardParameter : singleWildcardList) {
                                            for (Object negativeOffsetCorrectionParameter : negativeOffsetCorrectionList) {
                                                for (Object positiveOffsetCorrectionParameter : positiveOffsetCorrectionList) {

                                                    this.genFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) genFeatureParameter;
                                                    this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
                                                    this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
                                                    this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
                                                    this.isJDK50 = (java.lang.Boolean) isJDK50Parameter;
                                                    this.isInterface = (java.lang.Boolean) isInterfaceParameter;
                                                    this.isImplementation = (java.lang.Boolean) isImplementationParameter;
                                                    this.publicStaticFinalFlag = (java.lang.String) publicStaticFinalFlagParameter;
                                                    this.singleWildcard = (java.lang.String) singleWildcardParameter;
                                                    this.negativeOffsetCorrection = (java.lang.String) negativeOffsetCorrectionParameter;
                                                    this.positiveOffsetCorrection = (java.lang.String) positiveOffsetCorrectionParameter;

                                                    if (preCondition())
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
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_157);
        stringBuffer.append(TEXT_158);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        method_doGenerate(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
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
            ictx.clearBuffer();
        }
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
        return parameters;
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        if (isInterface) {
            stringBuffer.append(TEXT_2);
            {
                //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.unsetGenFeature.javadoc.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

                final Map<String, Object> callParameters = new HashMap<String, Object>();
                callParameters.put("genFeature", genFeature);
                callParameters.put("genClass", genClass);
                callParameters.put("genPackage", genPackage);
                callParameters.put("genModel", genModel);
                callParameters.put("isJDK50", isJDK50);
                callParameters.put("isInterface", isInterface);
                callParameters.put("isImplementation", isImplementation);
                callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
                callParameters.put("singleWildcard", singleWildcard);
                callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
                callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
                CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0rPjEGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            }

            //Class/unsetGenFeature.javadoc.override.javajetinc
        } else {
            stringBuffer.append(TEXT_3);
            if (isJDK50) { //Class/unsetGenFeature.annotations.insert.javajetinc
                stringBuffer.append(TEXT_4);
                {
                    //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.unsetGenFeature.annotations.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

                    final Map<String, Object> callParameters = new HashMap<String, Object>();
                    callParameters.put("genFeature", genFeature);
                    callParameters.put("genClass", genClass);
                    callParameters.put("genPackage", genPackage);
                    callParameters.put("genModel", genModel);
                    callParameters.put("isJDK50", isJDK50);
                    callParameters.put("isInterface", isInterface);
                    callParameters.put("isImplementation", isImplementation);
                    callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
                    callParameters.put("singleWildcard", singleWildcard);
                    callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
                    callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
                    CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0rrn8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                }

            }
        }
        if (!isImplementation) {
            stringBuffer.append(TEXT_5);
            stringBuffer.append(genFeature.getAccessorName());
            stringBuffer.append(TEXT_6);
        } else {
            stringBuffer.append(TEXT_7);
            stringBuffer.append(genFeature.getAccessorName());
            if (genClass.hasCollidingUnsetAccessorOperation(genFeature)) {
                stringBuffer.append(TEXT_8);
            }
            stringBuffer.append(TEXT_9);
            if (genModel.isDynamicDelegation()) {
                stringBuffer.append(TEXT_10);
                stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                stringBuffer.append(TEXT_11);
                stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
                stringBuffer.append(TEXT_12);
            } else if (genModel.isReflectiveDelegation()) {
                stringBuffer.append(TEXT_13);
                stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
                stringBuffer.append(TEXT_14);
            } else if (!genFeature.isVolatile()) {
                if (genFeature.isListType()) {
                    if (genModel.isVirtualDelegation()) {
                        stringBuffer.append(TEXT_15);
                        stringBuffer.append(genFeature.getImportedType(genClass));
                        stringBuffer.append(TEXT_16);
                        stringBuffer.append(genFeature.getSafeName());
                        stringBuffer.append(TEXT_17);
                        stringBuffer.append(genFeature.getImportedType(genClass));
                        stringBuffer.append(TEXT_18);
                        stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(positiveOffsetCorrection);
                        stringBuffer.append(TEXT_19);
                    }
                    stringBuffer.append(TEXT_20);
                    stringBuffer.append(genFeature.getSafeName());
                    stringBuffer.append(TEXT_21);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
                    stringBuffer.append(TEXT_22);
                    stringBuffer.append(singleWildcard);
                    stringBuffer.append(TEXT_23);
                    stringBuffer.append(genFeature.getSafeName());
                    stringBuffer.append(TEXT_24);
                } else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
                    if (genModel.isVirtualDelegation()) {
                        stringBuffer.append(TEXT_25);
                        stringBuffer.append(genFeature.getImportedType(genClass));
                        stringBuffer.append(TEXT_26);
                        stringBuffer.append(genFeature.getSafeName());
                        stringBuffer.append(TEXT_27);
                        stringBuffer.append(genFeature.getImportedType(genClass));
                        stringBuffer.append(TEXT_28);
                        stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(positiveOffsetCorrection);
                        stringBuffer.append(TEXT_29);
                    }
                    stringBuffer.append(TEXT_30);
                    stringBuffer.append(genFeature.getSafeName());
                    stringBuffer.append(TEXT_31);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
                    stringBuffer.append(TEXT_32);
                    if (!genFeature.isBidirectional()) {
                        stringBuffer.append(TEXT_33);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
                        stringBuffer.append(TEXT_34);
                        stringBuffer.append(genFeature.getSafeName());
                        stringBuffer.append(TEXT_35);
                        stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(negativeOffsetCorrection);
                        stringBuffer.append(TEXT_36);
                    } else {
                        GenFeature reverseFeature = genFeature.getReverse();
                        GenClass targetClass = reverseFeature.getGenClass();
                        String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
                        stringBuffer.append(TEXT_37);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
                        stringBuffer.append(TEXT_38);
                        stringBuffer.append(genFeature.getSafeName());
                        stringBuffer.append(TEXT_39);
                        stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
                        stringBuffer.append(reverseOffsetCorrection);
                        stringBuffer.append(TEXT_40);
                        stringBuffer.append(targetClass.getRawImportedInterfaceName());
                        stringBuffer.append(TEXT_41);
                    }
                    stringBuffer.append(TEXT_42);
                    stringBuffer.append(genFeature.getAccessorName());
                    stringBuffer.append(TEXT_43);
                    if (genModel.isVirtualDelegation()) {
                        stringBuffer.append(TEXT_44);
                        stringBuffer.append(genFeature.getCapName());
                        stringBuffer.append(TEXT_45);
                        stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(positiveOffsetCorrection);
                        stringBuffer.append(TEXT_46);
                    } else if (genClass.isESetFlag(genFeature)) {
                        if (!genModel.isSuppressNotification()) {
                            stringBuffer.append(TEXT_47);
                            stringBuffer.append(genFeature.getCapName());
                            stringBuffer.append(TEXT_48);
                            stringBuffer.append(genClass.getESetFlagsField(genFeature));
                            stringBuffer.append(TEXT_49);
                            stringBuffer.append(genFeature.getUpperName());
                            stringBuffer.append(TEXT_50);
                        }
                        stringBuffer.append(TEXT_51);
                        stringBuffer.append(genClass.getESetFlagsField(genFeature));
                        stringBuffer.append(TEXT_52);
                        stringBuffer.append(genFeature.getUpperName());
                        stringBuffer.append(TEXT_53);
                    } else {
                        if (!genModel.isSuppressNotification()) {
                            stringBuffer.append(TEXT_54);
                            stringBuffer.append(genFeature.getCapName());
                            stringBuffer.append(TEXT_55);
                            stringBuffer.append(genFeature.getUncapName());
                            stringBuffer.append(TEXT_56);
                        }
                        stringBuffer.append(TEXT_57);
                        stringBuffer.append(genFeature.getUncapName());
                        stringBuffer.append(TEXT_58);
                    }
                    if (!genModel.isSuppressNotification()) {
                        stringBuffer.append(TEXT_59);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
                        stringBuffer.append(TEXT_60);
                        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
                        stringBuffer.append(TEXT_61);
                        stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(positiveOffsetCorrection);
                        stringBuffer.append(TEXT_62);
                        stringBuffer.append(genFeature.getCapName());
                        stringBuffer.append(TEXT_63);
                    }
                    stringBuffer.append(TEXT_64);
                } else {
                    if (genClass.isFlag(genFeature)) {
                        if (!genModel.isSuppressNotification()) {
                            if (genFeature.isBooleanType()) {
                                stringBuffer.append(TEXT_65);
                                stringBuffer.append(genFeature.getImportedType(genClass));
                                stringBuffer.append(TEXT_66);
                                stringBuffer.append(genFeature.getCapName());
                                stringBuffer.append(TEXT_67);
                                stringBuffer.append(genClass.getFlagsField(genFeature));
                                stringBuffer.append(TEXT_68);
                                stringBuffer.append(genFeature.getUpperName());
                                stringBuffer.append(TEXT_69);
                            } else {
                                stringBuffer.append(TEXT_70);
                                stringBuffer.append(genFeature.getImportedType(genClass));
                                stringBuffer.append(TEXT_71);
                                stringBuffer.append(genFeature.getCapName());
                                stringBuffer.append(TEXT_72);
                                stringBuffer.append(genFeature.getUpperName());
                                stringBuffer.append(TEXT_73);
                                stringBuffer.append(genClass.getFlagsField(genFeature));
                                stringBuffer.append(TEXT_74);
                                stringBuffer.append(genFeature.getUpperName());
                                stringBuffer.append(TEXT_75);
                                stringBuffer.append(genFeature.getUpperName());
                                stringBuffer.append(TEXT_76);
                            }
                        }
                    } else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
                        stringBuffer.append(TEXT_77);
                        stringBuffer.append(genFeature.getCapName());
                        stringBuffer.append(TEXT_78);
                        stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                        stringBuffer.append(positiveOffsetCorrection);
                        stringBuffer.append(TEXT_79);
                    } else {
                        if (!genModel.isSuppressNotification()) {
                            stringBuffer.append(TEXT_80);
                            stringBuffer.append(genFeature.getImportedType(genClass));
                            stringBuffer.append(TEXT_81);
                            stringBuffer.append(genFeature.getCapName());
                            stringBuffer.append(TEXT_82);
                            stringBuffer.append(genFeature.getSafeName());
                            stringBuffer.append(TEXT_83);
                        }
                    }
                    if (!genModel.isSuppressNotification()) {
                        if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
                            stringBuffer.append(TEXT_84);
                            stringBuffer.append(genFeature.getCapName());
                            stringBuffer.append(TEXT_85);
                        } else if (genClass.isESetFlag(genFeature)) {
                            stringBuffer.append(TEXT_86);
                            stringBuffer.append(genFeature.getCapName());
                            stringBuffer.append(TEXT_87);
                            stringBuffer.append(genClass.getESetFlagsField(genFeature));
                            stringBuffer.append(TEXT_88);
                            stringBuffer.append(genFeature.getUpperName());
                            stringBuffer.append(TEXT_89);
                        } else {
                            stringBuffer.append(TEXT_90);
                            stringBuffer.append(genFeature.getCapName());
                            stringBuffer.append(TEXT_91);
                            stringBuffer.append(genFeature.getUncapName());
                            stringBuffer.append(TEXT_92);
                        }
                    }
                    if (genFeature.isReferenceType()) {
                        stringBuffer.append(TEXT_93);
                        stringBuffer.append(genFeature.getSafeName());
                        stringBuffer.append(TEXT_94);
                        if (!genModel.isVirtualDelegation()) {
                            if (genClass.isESetFlag(genFeature)) {
                                stringBuffer.append(TEXT_95);
                                stringBuffer.append(genClass.getESetFlagsField(genFeature));
                                stringBuffer.append(TEXT_96);
                                stringBuffer.append(genFeature.getUpperName());
                                stringBuffer.append(TEXT_97);
                            } else {
                                stringBuffer.append(TEXT_98);
                                stringBuffer.append(genFeature.getUncapName());
                                stringBuffer.append(TEXT_99);
                            }
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
                            if (genModel.isVirtualDelegation()) {
                                stringBuffer.append(TEXT_104);
                                stringBuffer.append(genFeature.getCapName());
                                stringBuffer.append(TEXT_105);
                            } else {
                                stringBuffer.append(TEXT_106);
                                stringBuffer.append(genFeature.getCapName());
                            }
                            stringBuffer.append(TEXT_107);
                            if (genModel.isVirtualDelegation()) {
                                stringBuffer.append(TEXT_108);
                            } else {
                                stringBuffer.append(TEXT_109);
                                stringBuffer.append(genFeature.getCapName());
                                stringBuffer.append(TEXT_110);
                            }
                            stringBuffer.append(TEXT_111);
                        }
                    } else {
                        if (genClass.isFlag(genFeature)) {
                            if (genFeature.isBooleanType()) {
                                stringBuffer.append(TEXT_112);
                                stringBuffer.append(genFeature.getEDefault());
                                stringBuffer.append(TEXT_113);
                                stringBuffer.append(genClass.getFlagsField(genFeature));
                                stringBuffer.append(TEXT_114);
                                stringBuffer.append(genFeature.getUpperName());
                                stringBuffer.append(TEXT_115);
                                stringBuffer.append(genClass.getFlagsField(genFeature));
                                stringBuffer.append(TEXT_116);
                                stringBuffer.append(genFeature.getUpperName());
                                stringBuffer.append(TEXT_117);
                            } else {
                                stringBuffer.append(TEXT_118);
                                stringBuffer.append(genClass.getFlagsField(genFeature));
                                stringBuffer.append(TEXT_119);
                                stringBuffer.append(genClass.getFlagsField(genFeature));
                                stringBuffer.append(TEXT_120);
                                stringBuffer.append(genFeature.getUpperName());
                                stringBuffer.append(TEXT_121);
                                stringBuffer.append(genFeature.getUpperName());
                                stringBuffer.append(TEXT_122);
                            }
                        } else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
                            stringBuffer.append(TEXT_123);
                            stringBuffer.append(genFeature.getSafeName());
                            stringBuffer.append(TEXT_124);
                            stringBuffer.append(genFeature.getEDefault());
                            stringBuffer.append(TEXT_125);
                        }
                        if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
                            if (genClass.isESetFlag(genFeature)) {
                                stringBuffer.append(TEXT_126);
                                stringBuffer.append(genClass.getESetFlagsField(genFeature));
                                stringBuffer.append(TEXT_127);
                                stringBuffer.append(genFeature.getUpperName());
                                stringBuffer.append(TEXT_128);
                            } else {
                                stringBuffer.append(TEXT_129);
                                stringBuffer.append(genFeature.getUncapName());
                                stringBuffer.append(TEXT_130);
                            }
                        }
                        if (!genModel.isSuppressNotification()) {
                            stringBuffer.append(TEXT_131);
                            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
                            stringBuffer.append(TEXT_132);
                            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
                            stringBuffer.append(TEXT_133);
                            stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                            stringBuffer.append(positiveOffsetCorrection);
                            stringBuffer.append(TEXT_134);
                            if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
                                stringBuffer.append(TEXT_135);
                                stringBuffer.append(genFeature.getCapName());
                                stringBuffer.append(TEXT_136);
                                stringBuffer.append(genFeature.getEDefault());
                            } else {
                                stringBuffer.append(TEXT_137);
                                stringBuffer.append(genFeature.getCapName());
                            }
                            stringBuffer.append(TEXT_138);
                            stringBuffer.append(genFeature.getEDefault());
                            stringBuffer.append(TEXT_139);
                            if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
                                stringBuffer.append(TEXT_140);
                            } else {
                                stringBuffer.append(TEXT_141);
                                stringBuffer.append(genFeature.getCapName());
                                stringBuffer.append(TEXT_142);
                            }
                            stringBuffer.append(TEXT_143);
                        }
                    }
                }
            } else if (genFeature.hasDelegateFeature()) {
                GenFeature delegateFeature = genFeature.getDelegateFeature();
                if (delegateFeature.isWrappedFeatureMapType()) {
                    stringBuffer.append(TEXT_144);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
                    stringBuffer.append(TEXT_145);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
                    stringBuffer.append(TEXT_146);
                    stringBuffer.append(delegateFeature.getAccessorName());
                    stringBuffer.append(TEXT_147);
                    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
                    stringBuffer.append(TEXT_148);
                } else {
                    stringBuffer.append(TEXT_149);
                    stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
                    stringBuffer.append(TEXT_150);
                    stringBuffer.append(delegateFeature.getAccessorName());
                    stringBuffer.append(TEXT_151);
                    stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
                    stringBuffer.append(TEXT_152);
                }
            } else if (genClass.getUnsetAccessorOperation(genFeature) != null) {
                stringBuffer.append(TEXT_153);
                stringBuffer.append(genClass.getUnsetAccessorOperation(genFeature).getBody(genModel.getIndentation(stringBuffer)));
            } else {
                stringBuffer.append(TEXT_154);
                {
                    //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.unsetGenFeature.TODO.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

                    final Map<String, Object> callParameters = new HashMap<String, Object>();
                    callParameters.put("genFeature", genFeature);
                    callParameters.put("genClass", genClass);
                    callParameters.put("genPackage", genPackage);
                    callParameters.put("genModel", genModel);
                    callParameters.put("isJDK50", isJDK50);
                    callParameters.put("isInterface", isInterface);
                    callParameters.put("isImplementation", isImplementation);
                    callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
                    callParameters.put("singleWildcard", singleWildcard);
                    callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
                    callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
                    CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0r_J8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                }

                //Class/unsetGenFeature.todo.override.javajetinc
            }
            stringBuffer.append(TEXT_155);
        }
        stringBuffer.append(TEXT_156);
    }

    public boolean preCondition() throws Exception {
        return true;
    }
}