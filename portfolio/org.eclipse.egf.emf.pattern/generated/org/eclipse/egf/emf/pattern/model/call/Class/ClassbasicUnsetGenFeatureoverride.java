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

public class ClassbasicUnsetGenFeatureoverride {
    protected static String nl;

    public static synchronized ClassbasicUnsetGenFeatureoverride create(String lineSeparator) {
        nl = lineSeparator;
        ClassbasicUnsetGenFeatureoverride result = new ClassbasicUnsetGenFeatureoverride();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL + "\tpublic ";
    protected final String TEXT_4 = " basicUnset";
    protected final String TEXT_5 = "(";
    protected final String TEXT_6 = " msgs)" + NL + "\t{";
    protected final String TEXT_7 = NL + "\t\treturn eDynamicInverseRemove((";
    protected final String TEXT_8 = ")";
    protected final String TEXT_9 = "basicGet";
    protected final String TEXT_10 = "(), ";
    protected final String TEXT_11 = ", msgs);";
    protected final String TEXT_12 = "Object old";
    protected final String TEXT_13 = " = ";
    protected final String TEXT_14 = "eVirtualUnset(";
    protected final String TEXT_15 = ");";
    protected final String TEXT_16 = NL + "\t\t";
    protected final String TEXT_17 = " old";
    protected final String TEXT_18 = " = ";
    protected final String TEXT_19 = ";";
    protected final String TEXT_20 = NL + "\t\t";
    protected final String TEXT_21 = " = null;";
    protected final String TEXT_22 = NL + "\t\tboolean isSetChange = old";
    protected final String TEXT_23 = " != EVIRTUAL_NO_VALUE;";
    protected final String TEXT_24 = NL + "\t\tboolean old";
    protected final String TEXT_25 = "ESet = (";
    protected final String TEXT_26 = " & ";
    protected final String TEXT_27 = "_ESETFLAG) != 0;";
    protected final String TEXT_28 = NL + "\t\t";
    protected final String TEXT_29 = " &= ~";
    protected final String TEXT_30 = "_ESETFLAG;";
    protected final String TEXT_31 = NL + "\t\tboolean old";
    protected final String TEXT_32 = "ESet = ";
    protected final String TEXT_33 = "ESet;";
    protected final String TEXT_34 = NL + "\t\t";
    protected final String TEXT_35 = "ESet = false;";
    protected final String TEXT_36 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t{" + NL + "\t\t\t";
    protected final String TEXT_37 = " notification = new ";
    protected final String TEXT_38 = "(this, ";
    protected final String TEXT_39 = ".UNSET, ";
    protected final String TEXT_40 = ", ";
    protected final String TEXT_41 = "isSetChange ? old";
    protected final String TEXT_42 = " : null";
    protected final String TEXT_43 = "old";
    protected final String TEXT_44 = ", null, ";
    protected final String TEXT_45 = "isSetChange";
    protected final String TEXT_46 = "old";
    protected final String TEXT_47 = "ESet";
    protected final String TEXT_48 = ");" + NL + "\t\t\tif (msgs == null) msgs = notification; else msgs.add(notification);" + NL + "\t\t}" + NL + "\t\treturn msgs;";
    protected final String TEXT_49 = NL;
    protected final String TEXT_50 = "    ";
    protected final String TEXT_51 = NL + "\t}" + NL + NL;
    protected final String TEXT_52 = NL;
    protected final String TEXT_53 = NL;

    public ClassbasicUnsetGenFeatureoverride() {
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

        stringBuffer.append(TEXT_52);
        stringBuffer.append(TEXT_53);
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
        if (isJDK50) { //Class/basicUnsetGenFeature.annotations.insert.javajetinc
            stringBuffer.append(TEXT_2);
            {
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
                CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0qpGIGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            }

        }
        stringBuffer.append(TEXT_3);
        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
        stringBuffer.append(TEXT_4);
        stringBuffer.append(genFeature.getAccessorName());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
        stringBuffer.append(TEXT_6);
        if (genModel.isDynamicDelegation()) {
            stringBuffer.append(TEXT_7);
            stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
            stringBuffer.append(TEXT_8);
            if (genFeature.isResolveProxies()) {
                stringBuffer.append(TEXT_9);
                stringBuffer.append(genFeature.getAccessorName());
            } else {
                stringBuffer.append(genFeature.getGetAccessor());
            }
            stringBuffer.append(TEXT_10);
            stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
            stringBuffer.append(positiveOffsetCorrection);
            stringBuffer.append(TEXT_11);
        } else if (!genFeature.isVolatile()) {
            if (genModel.isVirtualDelegation()) {
                if (!genModel.isSuppressNotification()) {
                    stringBuffer.append(TEXT_12);
                    stringBuffer.append(genFeature.getCapName());
                    stringBuffer.append(TEXT_13);
                }
                stringBuffer.append(TEXT_14);
                stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                stringBuffer.append(positiveOffsetCorrection);
                stringBuffer.append(TEXT_15);
            } else {
                if (!genModel.isSuppressNotification()) {
                    stringBuffer.append(TEXT_16);
                    stringBuffer.append(genFeature.getImportedType(genClass));
                    stringBuffer.append(TEXT_17);
                    stringBuffer.append(genFeature.getCapName());
                    stringBuffer.append(TEXT_18);
                    stringBuffer.append(genFeature.getSafeName());
                    stringBuffer.append(TEXT_19);
                }
                stringBuffer.append(TEXT_20);
                stringBuffer.append(genFeature.getSafeName());
                stringBuffer.append(TEXT_21);
            }
            if (genModel.isVirtualDelegation()) {
                if (!genModel.isSuppressNotification()) {
                    stringBuffer.append(TEXT_22);
                    stringBuffer.append(genFeature.getCapName());
                    stringBuffer.append(TEXT_23);
                }
            } else if (genClass.isESetFlag(genFeature)) {
                if (!genModel.isSuppressNotification()) {
                    stringBuffer.append(TEXT_24);
                    stringBuffer.append(genFeature.getCapName());
                    stringBuffer.append(TEXT_25);
                    stringBuffer.append(genClass.getESetFlagsField(genFeature));
                    stringBuffer.append(TEXT_26);
                    stringBuffer.append(genFeature.getUpperName());
                    stringBuffer.append(TEXT_27);
                }
                stringBuffer.append(TEXT_28);
                stringBuffer.append(genClass.getESetFlagsField(genFeature));
                stringBuffer.append(TEXT_29);
                stringBuffer.append(genFeature.getUpperName());
                stringBuffer.append(TEXT_30);
            } else {
                if (!genModel.isSuppressNotification()) {
                    stringBuffer.append(TEXT_31);
                    stringBuffer.append(genFeature.getCapName());
                    stringBuffer.append(TEXT_32);
                    stringBuffer.append(genFeature.getUncapName());
                    stringBuffer.append(TEXT_33);
                }
                stringBuffer.append(TEXT_34);
                stringBuffer.append(genFeature.getUncapName());
                stringBuffer.append(TEXT_35);
            }
            if (!genModel.isSuppressNotification()) {
                stringBuffer.append(TEXT_36);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
                stringBuffer.append(TEXT_37);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
                stringBuffer.append(TEXT_38);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
                stringBuffer.append(TEXT_39);
                stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
                stringBuffer.append(positiveOffsetCorrection);
                stringBuffer.append(TEXT_40);
                if (genModel.isVirtualDelegation()) {
                    stringBuffer.append(TEXT_41);
                    stringBuffer.append(genFeature.getCapName());
                    stringBuffer.append(TEXT_42);
                } else {
                    stringBuffer.append(TEXT_43);
                    stringBuffer.append(genFeature.getCapName());
                }
                stringBuffer.append(TEXT_44);
                if (genModel.isVirtualDelegation()) {
                    stringBuffer.append(TEXT_45);
                } else {
                    stringBuffer.append(TEXT_46);
                    stringBuffer.append(genFeature.getCapName());
                    stringBuffer.append(TEXT_47);
                }
                stringBuffer.append(TEXT_48);
            }
        } else {
            stringBuffer.append(TEXT_49);
            {
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
                CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0qy3IGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            }

            //Class/basicUnsetGenFeature.todo.override.javajetinc
            stringBuffer.append(TEXT_50);
        }
        stringBuffer.append(TEXT_51);
    }

    public boolean preCondition() throws Exception {
        return true;
    }
}