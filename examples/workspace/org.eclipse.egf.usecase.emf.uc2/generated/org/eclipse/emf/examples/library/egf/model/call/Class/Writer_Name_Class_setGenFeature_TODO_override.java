package org.eclipse.emf.examples.library.egf.model.call.Class;

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

public class Writer_Name_Class_setGenFeature_TODO_override extends org.eclipse.egf.emf.pattern.model.call.Class.ClasssetGenFeatureTODOoverride {
    protected static String nl;

    public static synchronized Writer_Name_Class_setGenFeature_TODO_override create(String lineSeparator) {
        nl = lineSeparator;
        Writer_Name_Class_setGenFeature_TODO_override result = new Writer_Name_Class_setGenFeature_TODO_override();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "    if (newName == null || newName.length() == 0) {" + NL + "        setFirstName(null);" + NL + "        setLastName(null);" + NL + "    } else {" + NL + "        int comma = newName.indexOf(',');" + NL + "        if (comma < 0) {" + NL + "            comma = newName.indexOf(' ');" + NL + "        }" + NL + "        if (comma >= 0) {" + NL + "            setFirstName(newName.substring(0, comma).trim());" + NL + "            setLastName(newName.substring(comma + 1).trim());" + NL + "        } else {" + NL + "            setFirstName(newName);" + NL + "            setLastName(null);" + NL + "        }" + NL + "    }";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public Writer_Name_Class_setGenFeature_TODO_override() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> setAccessorOperationList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
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

        for (Object setAccessorOperationParameter : setAccessorOperationList) {
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

                                                        this.setAccessorOperation = (org.eclipse.emf.codegen.ecore.genmodel.GenOperation) setAccessorOperationParameter;
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
        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(TEXT_3);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("setAccessorOperation", this.setAccessorOperation);
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

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("setAccessorOperation", this.setAccessorOperation);
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
    }

    public boolean preCondition() throws Exception {
        if ("Writer".equals(genFeature.getGenClass().getEcoreClass().getName()) && "name".equals(genFeature.getName())) {
            return true;
        }
        return false;
    }
}