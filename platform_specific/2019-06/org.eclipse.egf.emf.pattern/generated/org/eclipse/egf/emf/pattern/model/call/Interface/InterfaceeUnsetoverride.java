//Generated with EGF 1.6.1.201902111324
package org.eclipse.egf.emf.pattern.model.call.Interface;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil;
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

public class InterfaceeUnsetoverride {
	protected static String nl;

	public static synchronized InterfaceeUnsetoverride create(String lineSeparator) {
		nl = lineSeparator;
		InterfaceeUnsetoverride result = new InterfaceeUnsetoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_2 = NL + "\t@Override";
	protected final String TEXT_3 = NL + "\tpublic void eUnset(int featureID)" + NL + "\t{" + NL
			+ "\t\tswitch (featureID";
	protected final String TEXT_4 = ")" + NL + "\t\t{";
	protected final String TEXT_5 = NL + "\t\t\tcase ";
	protected final String TEXT_6 = ":";
	protected final String TEXT_7 = NL + "\t\t\t\t((";
	protected final String TEXT_8 = ".Internal.Wrapper)";
	protected final String TEXT_9 = "()).featureMap().clear();";
	protected final String TEXT_10 = NL + "\t\t\t\t";
	protected final String TEXT_11 = "().clear();";
	protected final String TEXT_12 = NL + "\t\t\t\tunset";
	protected final String TEXT_13 = "();";
	protected final String TEXT_14 = NL + "\t\t\t\tset";
	protected final String TEXT_15 = "((";
	protected final String TEXT_16 = ")null);";
	protected final String TEXT_17 = "__ESETTING_DELEGATE.dynamicUnset(this, null, 0);";
	protected final String TEXT_18 = "(";
	protected final String TEXT_19 = ");";
	protected final String TEXT_20 = NL + "\t\t\t\treturn;";
	protected final String TEXT_21 = NL + "\t\t\tdefault:";
	protected final String TEXT_22 = NL + "\t\t}";
	protected final String TEXT_23 = NL;
	protected final String TEXT_24 = "\t\tsuper.eUnset(featureID);";
	protected final String TEXT_25 = "\t\teDynamicUnset(featureID);";
	protected final String TEXT_26 = NL + "\t}" + NL + NL;
	protected final String TEXT_27 = NL;

	public InterfaceeUnsetoverride() {
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
		List<Object> useInterfaceOverrideAnnotationList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> isGWTList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> forceDefaultCaseList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> indentDefaultCaseList = null;
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
								for (Object useInterfaceOverrideAnnotationParameter : useInterfaceOverrideAnnotationList) {
									for (Object isGWTParameter : isGWTList) {
										for (Object forceDefaultCaseParameter : forceDefaultCaseList) {
											for (Object indentDefaultCaseParameter : indentDefaultCaseList) {
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
																		this.useInterfaceOverrideAnnotation = (java.lang.Boolean) useInterfaceOverrideAnnotationParameter;
																		this.isGWT = (java.lang.Boolean) isGWTParameter;
																		this.forceDefaultCase = (java.lang.Boolean) forceDefaultCaseParameter;
																		this.indentDefaultCase = (java.lang.String) indentDefaultCaseParameter;
																		this.publicStaticFinalFlag = (java.lang.String) publicStaticFinalFlagParameter;
																		this.singleWildcard = (java.lang.String) singleWildcardParameter;
																		this.negativeOffsetCorrection = (java.lang.String) negativeOffsetCorrectionParameter;
																		this.positiveOffsetCorrection = (java.lang.String) positiveOffsetCorrectionParameter;
																		this.negativeOperationOffsetCorrection = (java.lang.String) negativeOperationOffsetCorrectionParameter;
																		this.positiveOperationOffsetCorrection = (java.lang.String) positiveOperationOffsetCorrectionParameter;

																		if (preCondition(ctx)) {
																			ctx.setNode(new Node.Container(currentNode,
																					getClass()));
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
				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_27);
		stringBuffer.append(TEXT_27);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("genClass", this.genClass);
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("isJDK50", this.isJDK50);
			parameterValues.put("isInterface", this.isInterface);
			parameterValues.put("isImplementation", this.isImplementation);
			parameterValues.put("useInterfaceOverrideAnnotation", this.useInterfaceOverrideAnnotation);
			parameterValues.put("isGWT", this.isGWT);
			parameterValues.put("forceDefaultCase", this.forceDefaultCase);
			parameterValues.put("indentDefaultCase", this.indentDefaultCase);
			parameterValues.put("publicStaticFinalFlag", this.publicStaticFinalFlag);
			parameterValues.put("singleWildcard", this.singleWildcard);
			parameterValues.put("negativeOffsetCorrection", this.negativeOffsetCorrection);
			parameterValues.put("positiveOffsetCorrection", this.positiveOffsetCorrection);
			parameterValues.put("negativeOperationOffsetCorrection", this.negativeOperationOffsetCorrection);
			parameterValues.put("positiveOperationOffsetCorrection", this.positiveOperationOffsetCorrection);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
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

	protected java.lang.Boolean useInterfaceOverrideAnnotation = null;

	public void set_useInterfaceOverrideAnnotation(java.lang.Boolean object) {
		this.useInterfaceOverrideAnnotation = object;
	}

	protected java.lang.Boolean isGWT = null;

	public void set_isGWT(java.lang.Boolean object) {
		this.isGWT = object;
	}

	protected java.lang.Boolean forceDefaultCase = null;

	public void set_forceDefaultCase(java.lang.Boolean object) {
		this.forceDefaultCase = object;
	}

	protected java.lang.String indentDefaultCase = null;

	public void set_indentDefaultCase(java.lang.String object) {
		this.indentDefaultCase = object;
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

	protected java.lang.String negativeOperationOffsetCorrection = null;

	public void set_negativeOperationOffsetCorrection(java.lang.String object) {
		this.negativeOperationOffsetCorrection = object;
	}

	protected java.lang.String positiveOperationOffsetCorrection = null;

	public void set_positiveOperationOffsetCorrection(java.lang.String object) {
		this.positiveOperationOffsetCorrection = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genClass", this.genClass);
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		parameters.put("isJDK50", this.isJDK50);
		parameters.put("isInterface", this.isInterface);
		parameters.put("isImplementation", this.isImplementation);
		parameters.put("useInterfaceOverrideAnnotation", this.useInterfaceOverrideAnnotation);
		parameters.put("isGWT", this.isGWT);
		parameters.put("forceDefaultCase", this.forceDefaultCase);
		parameters.put("indentDefaultCase", this.indentDefaultCase);
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
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_2);
		}
		stringBuffer.append(TEXT_3);
		stringBuffer.append(negativeOffsetCorrection);
		stringBuffer.append(TEXT_4);
		for (GenFeature genFeature : genClass.getEUnsetGenFeatures()) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
			stringBuffer.append(TEXT_6);
			if (genFeature.isListType() && !genFeature.isUnsettable()) {
				if (genFeature.isWrappedFeatureMapType()) {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_8);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_9);
				} else {
					stringBuffer.append(TEXT_10);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_11);
				}
			} else if (genFeature.isUnsettable()) {
				stringBuffer.append(TEXT_12);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_13);
			} else if (!genFeature.hasEDefault()) {
				stringBuffer.append(TEXT_14);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_15);
				stringBuffer.append(genFeature.getImportedType(genClass));
				stringBuffer.append(TEXT_16);
			} else if (genFeature.hasSettingDelegate()) {
				stringBuffer.append(TEXT_10);
				stringBuffer.append(genFeature.getUpperName());
				stringBuffer.append(TEXT_17);
			} else {
				stringBuffer.append(TEXT_14);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_18);
				stringBuffer.append(genFeature.getEDefault());
				stringBuffer.append(TEXT_19);
			}
			stringBuffer.append(TEXT_20);
		}
		if (forceDefaultCase) {
			stringBuffer.append(TEXT_21);
		} else { // {
			stringBuffer.append(TEXT_22);
		}
		if (genModel.isMinimalReflectiveMethods()) {
			stringBuffer.append(TEXT_23);
			stringBuffer.append(indentDefaultCase);
			stringBuffer.append(TEXT_24);
			if (forceDefaultCase) {
				stringBuffer.append(TEXT_20);
			}
		} else {
			stringBuffer.append(TEXT_23);
			stringBuffer.append(indentDefaultCase);
			stringBuffer.append(TEXT_25);
			if (forceDefaultCase) {
				stringBuffer.append(TEXT_20);
			}
		}
		if (forceDefaultCase) { // {
			stringBuffer.append(TEXT_22);
		} // }
		stringBuffer.append(TEXT_26);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}