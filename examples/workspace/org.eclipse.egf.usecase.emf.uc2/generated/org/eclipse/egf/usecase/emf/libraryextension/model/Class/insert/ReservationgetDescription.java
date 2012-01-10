//Generated on Tue Jan 10 14:51:20 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.usecase.emf.libraryextension.model.Class.insert;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ReservationgetDescription extends org.eclipse.egf.emf.pattern.model.call.Class.Classinsert {
	protected static String nl;

	public static synchronized ReservationgetDescription create(String lineSeparator) {
		nl = lineSeparator;
		ReservationgetDescription result = new ReservationgetDescription();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "//INJECTED-CODE-BEGIN : ReservationImpl#getDescription()" + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * <!-- end-user-doc -->" + NL + " * @generated" + NL + " */" + NL + "@Override" + NL + "public String getDescription() {" + NL + "\tString result= \"\";" + NL + "" + NL + "\tString descrFormat = getDescriptionFormat();" + NL + "\tif (null!=descrFormat)" + NL + "\t\tresult= result + descrFormat;" + NL + "" + NL + "\tString items = \"\";" + NL + "\tEList<CirculatingItem> myItems = getItem();" + NL + "" + NL + "\tfor (CirculatingItem circulatingItem : myItems) {" + NL + "\t\tif (items.length()>0){" + NL + "\t\t\titems= items + (\";\");" + NL + "\t\t}" + NL + "\t\tif (circulatingItem instanceof Book)" + NL
			+ "\t\t\titems= items + (((Book)circulatingItem).getTitle());" + NL + "" + NL + "\t\tif (circulatingItem instanceof BookOnTape)" + NL + "\t\t\titems= items + ((BookOnTape)circulatingItem).getTitle();" + NL + "" + NL + "\t\tif (circulatingItem instanceof VideoCassette)" + NL + "\t\t\titems= items + (((VideoCassette)circulatingItem).getTitle());" + NL + "\t}" + NL + "" + NL + "\tString borrowerName = getBorrower().getFirstName() +\" \"+getBorrower().getLastName();" + NL + "" + NL + "\tif (isFinished())" + NL + "\t\tresult = result + \"[DONE] items [\";" + NL + "\telse" + NL + "\t\tresult = result + \"[TODO] items [\";" + NL + "" + NL + "\tresult=result + items;" + NL + "\tresult=result + (\"] for [\");" + NL + "\tresult=result + (borrowerName);" + NL
			+ "\tresult=result + (\"]\");" + NL + "" + NL + "\treturn result;" + NL + "}" + NL + "//INJECTED-CODE-END : ReservationImpl#getDescription()";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public ReservationgetDescription() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

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

															if (preCondition(ctx)) {
																ctx.setNode(new Node.Container(currentNode, getClass()));
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
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
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
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
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

		// add java imports
		genModel.getImportedName("org.eclipse.emf.common.util.EList");
		genModel.getImportedName("org.eclipse.egf.examples.extlibrary.CirculatingItem");
		genModel.getImportedName("org.eclipse.egf.examples.extlibrary.Book");
		genModel.getImportedName("org.eclipse.egf.examples.extlibrary.BookOnTape");
		genModel.getImportedName("org.eclipse.egf.examples.extlibrary.VideoCassette");

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return "Reservation".equals(genClass.getName());
	}
}