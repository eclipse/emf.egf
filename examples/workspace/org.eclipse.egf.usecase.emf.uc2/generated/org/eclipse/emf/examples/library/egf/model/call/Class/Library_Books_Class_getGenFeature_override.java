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

public class Library_Books_Class_getGenFeature_override extends org.eclipse.egf.emf.pattern.model.call.Class.ClassgetGenFeatureoverride {

    protected static String nl;

    public static synchronized Library_Books_Class_getGenFeature_override create(String lineSeparator) {
        nl = lineSeparator;
        Library_Books_Class_getGenFeature_override result = new Library_Books_Class_getGenFeature_override();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;

    protected final String TEXT_1 = "    /**" + NL + "     * <!-- begin-user-doc -->" + NL + "     * <!-- end-user-doc -->" + NL + "     * @generated" + NL + "     */" + NL + "    public ";

    protected final String TEXT_2 = " ";

    protected final String TEXT_3 = "_";

    protected final String TEXT_4 = "() " + NL + "    {" + NL + "        if (books == null) {    " + NL + "            // create a custom list implementation that synchronizes its content" + NL + "            //    with the \"stock\" superset" + NL + "            books = new ";

    protected final String TEXT_5 = "<Book>(Book.class, this, EXTLibraryPackage.LIBRARY__BOOKS) {" + NL + "                private static final long serialVersionUID = 1L;" + NL + "    " + NL + "                @Override" + NL + "                protected void didAdd(int index, Book newObject) {"
            + NL + "                    if (getStock().indexOf(newObject) == -1) {" + NL + "                        // these lists are unordered, so index doesn't matter" + NL + "                        getStock().add(newObject);" + NL + "                    }" + NL + "                }" + NL
            + "    " + NL + "                @Override" + NL + "                protected void didRemove(int index, Book oldObject) {" + NL + "                    if (getStock().indexOf(oldObject) != -1) {" + NL + "                        // these lists are unordered, so index doesn't matter" + NL
            + "                        getStock().remove(oldObject);" + NL + "                    }" + NL + "                }" + NL + "    " + NL + "                @Override" + NL + "                protected void didSet(int index, Book newObject, Book oldObject) {" + NL
            + "                    didRemove(index, oldObject);" + NL + "                    didAdd(index, newObject);" + NL + "                }" + NL + "            };" + NL + "        }" + NL + "        return books;" + NL + "    }";

    protected final String TEXT_6 = NL;

    protected final String TEXT_7 = NL;

    public Library_Books_Class_getGenFeature_override() {
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
        List<Object> isGWTList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> publicStaticFinalFlagList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> singleWildcardList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> negativeOffsetCorrectionList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> positiveOffsetCorrectionList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> negativeOperationOffsetCorrectionList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> positiveOperationOffsetCorrectionList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object genFeatureParameter : genFeatureList) {
            for (Object genClassParameter : genClassList) {
                for (Object genPackageParameter : genPackageList) {
                    for (Object genModelParameter : genModelList) {
                        for (Object isJDK50Parameter : isJDK50List) {
                            for (Object isInterfaceParameter : isInterfaceList) {
                                for (Object isImplementationParameter : isImplementationList) {
                                    for (Object isGWTParameter : isGWTList) {
                                        for (Object publicStaticFinalFlagParameter : publicStaticFinalFlagList) {
                                            for (Object singleWildcardParameter : singleWildcardList) {
                                                for (Object negativeOffsetCorrectionParameter : negativeOffsetCorrectionList) {
                                                    for (Object positiveOffsetCorrectionParameter : positiveOffsetCorrectionList) {
                                                        for (Object negativeOperationOffsetCorrectionParameter : negativeOperationOffsetCorrectionList) {
                                                            for (Object positiveOperationOffsetCorrectionParameter : positiveOperationOffsetCorrectionList) {

                                                                this.genFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) genFeatureParameter;
                                                                this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
                                                                this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
                                                                this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
                                                                this.isJDK50 = (java.lang.Boolean) isJDK50Parameter;
                                                                this.isInterface = (java.lang.Boolean) isInterfaceParameter;
                                                                this.isImplementation = (java.lang.Boolean) isImplementationParameter;
                                                                this.isGWT = (java.lang.Boolean) isGWTParameter;
                                                                this.publicStaticFinalFlag = (java.lang.String) publicStaticFinalFlagParameter;
                                                                this.singleWildcard = (java.lang.String) singleWildcardParameter;
                                                                this.negativeOffsetCorrection = (java.lang.String) negativeOffsetCorrectionParameter;
                                                                this.positiveOffsetCorrection = (java.lang.String) positiveOffsetCorrectionParameter;
                                                                this.negativeOperationOffsetCorrection = (java.lang.String) negativeOperationOffsetCorrectionParameter;
                                                                this.positiveOperationOffsetCorrection = (java.lang.String) positiveOperationOffsetCorrectionParameter;

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
            }
        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_6);
        stringBuffer.append(TEXT_7);
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
            parameterValues.put("genFeature", this.genFeature);
            parameterValues.put("genClass", this.genClass);
            parameterValues.put("genPackage", this.genPackage);
            parameterValues.put("genModel", this.genModel);
            parameterValues.put("isJDK50", this.isJDK50);
            parameterValues.put("isInterface", this.isInterface);
            parameterValues.put("isImplementation", this.isImplementation);
            parameterValues.put("isGWT", this.isGWT);
            parameterValues.put("publicStaticFinalFlag", this.publicStaticFinalFlag);
            parameterValues.put("singleWildcard", this.singleWildcard);
            parameterValues.put("negativeOffsetCorrection", this.negativeOffsetCorrection);
            parameterValues.put("positiveOffsetCorrection", this.positiveOffsetCorrection);
            parameterValues.put("negativeOperationOffsetCorrection", this.negativeOperationOffsetCorrection);
            parameterValues.put("positiveOperationOffsetCorrection", this.positiveOperationOffsetCorrection);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
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
        parameters.put("isGWT", this.isGWT);
        parameters.put("publicStaticFinalFlag", this.publicStaticFinalFlag);
        parameters.put("singleWildcard", this.singleWildcard);
        parameters.put("negativeOffsetCorrection", this.negativeOffsetCorrection);
        parameters.put("positiveOffsetCorrection", this.positiveOffsetCorrection);
        parameters.put("negativeOperationOffsetCorrection", this.negativeOperationOffsetCorrection);
        parameters.put("positiveOperationOffsetCorrection", this.positiveOperationOffsetCorrection);
        return parameters;
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(genFeature.getImportedType(genClass));
        stringBuffer.append(TEXT_2);
        stringBuffer.append(genFeature.getGetAccessor());
        if (genClass.hasCollidingGetAccessorOperation(genFeature)) {
            stringBuffer.append(TEXT_3);
        }
        stringBuffer.append(TEXT_4);
        stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectEList"));
        stringBuffer.append(TEXT_5);
    }

    public boolean preCondition() throws Exception {
        if ("Library".equals(genFeature.getGenClass().getEcoreClass().getName()) && "books".equals(genFeature.getName())) {
            return true;
        }
        return false;
    }
}
