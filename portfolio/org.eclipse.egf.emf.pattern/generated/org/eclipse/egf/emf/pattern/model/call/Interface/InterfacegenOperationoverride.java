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

public class InterfacegenOperationoverride {
    protected static String nl;

    public static synchronized InterfacegenOperationoverride create(String lineSeparator) {
        nl = lineSeparator;
        InterfacegenOperationoverride result = new InterfacegenOperationoverride();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_3 = NL;
    protected final String TEXT_4 = NL + "\t";
    protected final String TEXT_5 = " ";
    protected final String TEXT_6 = "(";
    protected final String TEXT_7 = ")";
    protected final String TEXT_8 = ";" + NL;
    protected final String TEXT_9 = NL + "\tpublic ";
    protected final String TEXT_10 = " ";
    protected final String TEXT_11 = "(";
    protected final String TEXT_12 = ")";
    protected final String TEXT_13 = NL + "\t{";
    protected final String TEXT_14 = NL + "\t\t";
    protected final String TEXT_15 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// -> specify the condition that violates the invariant" + NL + "\t\t// -> verify the details of the diagnostic, including severity and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
    protected final String TEXT_16 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
    protected final String TEXT_17 = ".add" + NL + "\t\t\t\t\t(new ";
    protected final String TEXT_18 = NL + "\t\t\t\t\t\t(";
    protected final String TEXT_19 = ".ERROR," + NL + "\t\t\t\t\t\t ";
    protected final String TEXT_20 = ".DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t ";
    protected final String TEXT_21 = ".";
    protected final String TEXT_22 = "," + NL + "\t\t\t\t\t\t ";
    protected final String TEXT_23 = ".INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\", new Object[] { \"";
    protected final String TEXT_24 = "\", ";
    protected final String TEXT_25 = ".getObjectLabel(this, ";
    protected final String TEXT_26 = ") }),";
    protected final String TEXT_27 = NL + "\t\t\t\t\t\t new Object [] { this }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
    protected final String TEXT_28 = NL;
    protected final String TEXT_29 = "  ";
    protected final String TEXT_30 = NL + "\t}" + NL;
    protected final String TEXT_31 = NL;
    protected final String TEXT_32 = NL;
    protected final String TEXT_33 = NL;
    protected final String TEXT_34 = NL;

    public InterfacegenOperationoverride() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> genOperationList = null;
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

        for (Object genOperationParameter : genOperationList) {
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

                                                    this.genOperation = (org.eclipse.emf.codegen.ecore.genmodel.GenOperation) genOperationParameter;
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

        stringBuffer.append(TEXT_33);
        stringBuffer.append(TEXT_34);
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
            parameterValues.put("genOperation", this.genOperation);
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

    protected org.eclipse.emf.codegen.ecore.genmodel.GenOperation genOperation = null;

    public void set_genOperation(org.eclipse.emf.codegen.ecore.genmodel.GenOperation object) {
        this.genOperation = object;
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
        parameters.put("genOperation", this.genOperation);
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

        if (isInterface) {
            stringBuffer.append(TEXT_1);
            {
                final Map<String, Object> callParameters = new HashMap<String, Object>();
                callParameters.put("genOperation", genOperation);
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
                CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_02HWUGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            }

            //Class/genOperation.javadoc.override.javajetinc
        } else {
            stringBuffer.append(TEXT_2);
            if (isJDK50) { //Class/genOperation.annotations.insert.javajetinc
                stringBuffer.append(TEXT_3);
                {
                    final Map<String, Object> callParameters = new HashMap<String, Object>();
                    callParameters.put("genOperation", genOperation);
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
                    CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_02tzQGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                }

            }
        }
        if (!isImplementation) {
            stringBuffer.append(TEXT_4);
            stringBuffer.append(genOperation.getTypeParameters(genClass));
            stringBuffer.append(genOperation.getImportedType(genClass));
            stringBuffer.append(TEXT_5);
            stringBuffer.append(genOperation.getName());
            stringBuffer.append(TEXT_6);
            stringBuffer.append(genOperation.getParameters(genClass));
            stringBuffer.append(TEXT_7);
            stringBuffer.append(genOperation.getThrows(genClass));
            stringBuffer.append(TEXT_8);
        } else {
            stringBuffer.append(TEXT_9);
            stringBuffer.append(genOperation.getTypeParameters(genClass));
            stringBuffer.append(genOperation.getImportedType(genClass));
            stringBuffer.append(TEXT_10);
            stringBuffer.append(genOperation.getName());
            stringBuffer.append(TEXT_11);
            stringBuffer.append(genOperation.getParameters(genClass));
            stringBuffer.append(TEXT_12);
            stringBuffer.append(genOperation.getThrows(genClass));
            stringBuffer.append(TEXT_13);
            if (genOperation.hasBody()) {
                stringBuffer.append(TEXT_14);
                stringBuffer.append(genOperation.getBody(genModel.getIndentation(stringBuffer)));
            } else if (genOperation.isInvariant()) {
                GenClass opClass = genOperation.getGenClass();
                String diagnostics = genOperation.getGenParameters().get(0).getName();
                String context = genOperation.getGenParameters().get(1).getName();
                stringBuffer.append(TEXT_15);
                stringBuffer.append(diagnostics);
                stringBuffer.append(TEXT_16);
                stringBuffer.append(diagnostics);
                stringBuffer.append(TEXT_17);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
                stringBuffer.append(TEXT_18);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
                stringBuffer.append(TEXT_19);
                stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
                stringBuffer.append(TEXT_20);
                stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
                stringBuffer.append(TEXT_21);
                stringBuffer.append(opClass.getOperationID(genOperation));
                stringBuffer.append(TEXT_22);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
                stringBuffer.append(TEXT_23);
                stringBuffer.append(genOperation.getName());
                stringBuffer.append(TEXT_24);
                stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
                stringBuffer.append(TEXT_25);
                stringBuffer.append(context);
                stringBuffer.append(TEXT_26);
                stringBuffer.append(genModel.getNonNLS());
                stringBuffer.append(genModel.getNonNLS(2));
                stringBuffer.append(TEXT_27);
            } else {
                stringBuffer.append(TEXT_28);
                {
                    final Map<String, Object> callParameters = new HashMap<String, Object>();
                    callParameters.put("genOperation", genOperation);
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
                    CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0229MGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                }

                //Class/implementedGenOperation.todo.override.javajetinc
                stringBuffer.append(TEXT_29);
            }
            stringBuffer.append(TEXT_30);
        }
        stringBuffer.append(TEXT_31);
        {
            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("genOperation", genOperation);
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
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03AuMGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_32);
    }

    public boolean preCondition() throws Exception {
        return true;
    }
}