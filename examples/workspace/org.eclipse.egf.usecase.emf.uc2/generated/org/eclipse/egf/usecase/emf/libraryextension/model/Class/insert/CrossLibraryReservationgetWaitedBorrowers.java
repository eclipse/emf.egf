//Generated on Mon Nov 07 17:45:08 CET 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.usecase.emf.libraryextension.model.Class.insert;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class CrossLibraryReservationgetWaitedBorrowers extends org.eclipse.egf.emf.pattern.model.call.Class.Classinsert {
	protected static String nl;

	public static synchronized CrossLibraryReservationgetWaitedBorrowers create(String lineSeparator) {
		nl = lineSeparator;
		CrossLibraryReservationgetWaitedBorrowers result = new CrossLibraryReservationgetWaitedBorrowers();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t//INJECTED-CODE-BEGIN : CrossLibraryReservationImpl#getWaitedBorrowers()" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Override" + NL + "\tpublic EList<Borrower> getWaitedBorrowers() {" + NL + "" + NL + "\t\tBasicEList<Borrower> waitedBorrowers = new BasicEList<Borrower>();" + NL + "\t\tEList<CirculatingItem> wantedItems = getItem();" + NL + "" + NL + "\t\tEList<EquippedLibrary> libraries = getInvolvedLibraries();" + NL + "\t\tlibraries.add((EquippedLibrary) (eContainer().eContainer()));" + NL + "" + NL + "\t\tfor (EquippedLibrary currentLibrary : libraries) {" + NL + "\t\t\t// get the borrows of the current Library" + NL
			+ "\t\t\tEList<Borrow> currentLibraryBorrows = currentLibrary" + NL + "\t\t\t\t\t.getBorrowingSystem().getActiveBorrows();" + NL + "" + NL + "\t\t\tfor (Borrow currentBorrow : currentLibraryBorrows) {" + NL + "\t\t\t\tfor (CirculatingItem currentWantedItem : wantedItems) {" + NL + "\t\t\t\t\tif (currentBorrow.getItem().contains(currentWantedItem)) {" + NL + "\t\t\t\t\t\tBorrower incriminatedBorrower = currentBorrow" + NL + "\t\t\t\t\t\t\t\t.getBorrower();" + NL + "\t\t\t\t\t\tif (!waitedBorrowers.contains(incriminatedBorrower))" + NL + "\t\t\t\t\t\t\twaitedBorrowers.add(currentBorrow.getBorrower());" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\treturn waitedBorrowers;" + NL + "\t}" + NL
			+ "\t//INJECTED-CODE-END : CrossLibraryReservationImpl#getWaitedBorrowers()";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public CrossLibraryReservationgetWaitedBorrowers() {
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
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
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
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
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

		// add java imports
		genModel.getImportedName("org.eclipse.emf.common.util.EList");
		genModel.getImportedName("org.eclipse.emf.common.util.BasicEList");
		genModel.getImportedName("org.eclipse.egf.examples.LibraryExtension.Borrow");
		genModel.getImportedName("org.eclipse.egf.examples.extlibrary.Borrower");
		genModel.getImportedName("org.eclipse.egf.examples.extlibrary.CirculatingItem");
		genModel.getImportedName("org.eclipse.egf.examples.extlibrary.EquippedLibrary");

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return "CrossLibraryReservation".equals(genClass.getName());
	}

	public boolean preCondition() {
		return true;
	}
}