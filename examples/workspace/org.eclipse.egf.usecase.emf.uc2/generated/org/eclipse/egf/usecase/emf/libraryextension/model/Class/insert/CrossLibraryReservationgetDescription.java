package org.eclipse.egf.usecase.emf.libraryextension.model.Class.insert;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class CrossLibraryReservationgetDescription extends org.eclipse.egf.emf.pattern.model.call.Class.Classinsert {
    protected static String nl;

    public static synchronized CrossLibraryReservationgetDescription create(String lineSeparator) {
        nl = lineSeparator;
        CrossLibraryReservationgetDescription result = new CrossLibraryReservationgetDescription();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t// INJECTED-CODE-BEGIN : CrossLibraryReservationImpl#getDescription()" + NL + "\tpublic String getDescription() {" + NL + "" + NL + "\t\tString result = \"\";" + NL + "" + NL + "\t\tString descrFormat = getDescriptionFormat();" + NL + "\t\tif (null != descrFormat)" + NL + "\t\t\tresult = result + descrFormat;" + NL + "" + NL + "\t\tString items = \"\";" + NL + "\t\tEList<CirculatingItem> myItems = getItem();" + NL + "" + NL + "\t\tfor (CirculatingItem circulatingItem : myItems) {" + NL + "\t\t\tif (items.length() > 0) {" + NL + "\t\t\t\titems = items + (\";\");" + NL + "\t\t\t}" + NL + "\t\t\tif (circulatingItem instanceof Book)" + NL + "\t\t\t\titems = items + (((Book) circulatingItem).getTitle());" + NL + "" + NL
            + "\t\t\tif (circulatingItem instanceof BookOnTape)" + NL + "\t\t\t\titems = items + ((BookOnTape) circulatingItem).getTitle();" + NL + "" + NL + "\t\t\tif (circulatingItem instanceof VideoCassette)" + NL + "\t\t\t\titems = items + (((VideoCassette) circulatingItem).getTitle());" + NL + "\t\t}" + NL + "" + NL + "\t\tBorrower reservationBorrower = getBorrower();" + NL + "\t\tString borrowerName = \"\";" + NL + "" + NL + "\t\tif (null != reservationBorrower)" + NL + "\t\t\tif (null != reservationBorrower.getFirstName())" + NL + "\t\t\t\tif (null != reservationBorrower.getLastName())" + NL + "\t\t\t\t\tborrowerName = reservationBorrower.getFirstName() + \" \"" + NL + "\t\t\t\t\t\t\t+ reservationBorrower.getLastName();" + NL + "" + NL + "\t\tString waitedBorrowerNames = \"\";"
            + NL + "\t\tString involvedLibrariesString = \"\";" + NL + "" + NL + "\t\tfor (Borrower currentBorrower : getWaitedBorrowers()) {" + NL + "\t\t\tif (waitedBorrowerNames.length() > 0) {" + NL + "\t\t\t\twaitedBorrowerNames += \";\";" + NL + "\t\t\t}" + NL + "\t\t\twaitedBorrowerNames += currentBorrower.getFirstName() + \" \"" + NL + "\t\t\t\t\t+ currentBorrower.getLastName();" + NL + "\t\t}" + NL + "" + NL + "\t\tfor (EquippedLibrary currentLibrary : getInvolvedLibraries()) {" + NL + "\t\t\tif (involvedLibrariesString.length() > 0) {" + NL + "\t\t\t\tinvolvedLibrariesString += \";\";" + NL + "\t\t\t}" + NL + "\t\t\tinvolvedLibrariesString += currentLibrary.getName();" + NL + "\t\t}" + NL + "" + NL + "\t\tif (isFinished())" + NL + "\t\t\tresult = result + \"[DONE] items [\";"
            + NL + "\t\telse" + NL + "\t\t\tresult = result + \"[TODO] items [\";" + NL + "" + NL + "\t\tresult = result + items;" + NL + "\t\tresult = result + (\"] for [\");" + NL + "\t\tresult = result + (borrowerName);" + NL + "\t\tresult = result + (\"] waiting these borrowers [\");" + NL + "\t\tresult = result + waitedBorrowerNames;" + NL + "\t\tresult = result + \"] from these libraries [\";" + NL + "\t\tresult = result + involvedLibrariesString;" + NL + "\t\tresult = result + \"]\";" + NL + "\t\treturn result;" + NL + "\t}" + NL + "\t// INJECTED-CODE-BEGIN : CrossLibraryReservationImpl#getDescription()";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public CrossLibraryReservationgetDescription() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

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
    }

    public boolean preCondition() throws Exception {
        return "CrossLibraryReservation".equals(genClass.getName());
    }
}