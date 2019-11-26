//Generated with EGF 1.6.2.qualifier
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

public class Interfaceinterfacejavadocoverride {
	protected static String nl;

	public static synchronized Interfaceinterfacejavadocoverride create(String lineSeparator) {
		nl = lineSeparator;
		Interfaceinterfacejavadocoverride result = new Interfaceinterfacejavadocoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL
			+ " * A representation of the model object '<em><b>";
	protected final String TEXT_2 = "</b></em>'." + NL + " * <!-- end-user-doc -->";
	protected final String TEXT_3 = NL + " *" + NL + " * <!-- begin-model-doc -->" + NL + " * ";
	protected final String TEXT_4 = NL + " * <!-- end-model-doc -->";
	protected final String TEXT_5 = NL + " *";
	protected final String TEXT_6 = NL + " * <p>" + NL + " * The following features are supported:" + NL + " * </p>"
			+ NL + " * <ul>";
	protected final String TEXT_7 = NL + " *   <li>{@link ";
	protected final String TEXT_8 = "#";
	protected final String TEXT_9 = " <em>";
	protected final String TEXT_10 = "</em>}</li>";
	protected final String TEXT_11 = NL + " * </ul>";
	protected final String TEXT_12 = NL + " * @see ";
	protected final String TEXT_13 = "#get";
	protected final String TEXT_14 = "()";
	protected final String TEXT_15 = NL + " * @model ";
	protected final String TEXT_16 = NL + " *        ";
	protected final String TEXT_17 = NL + " * @model";
	protected final String TEXT_18 = NL + " * @extends ";
	protected final String TEXT_19 = NL + " * ";
	protected final String TEXT_20 = NL + " * @generated" + NL + " */" + NL;
	protected final String TEXT_21 = NL;

	public Interfaceinterfacejavadocoverride() {
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

		stringBuffer.append(TEXT_21);
		stringBuffer.append(TEXT_21);
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
		stringBuffer.append(genClass.getFormattedName());
		stringBuffer.append(TEXT_2);
		if (genClass.hasDocumentation()) {
			stringBuffer.append(TEXT_3);
			stringBuffer.append(genClass.getDocumentation(genModel.getIndentation(stringBuffer)));
			stringBuffer.append(TEXT_4);
		}
		stringBuffer.append(TEXT_5);
		if (!genClass.getGenFeatures().isEmpty()) {
			stringBuffer.append(TEXT_6);
			for (GenFeature genFeature : genClass.getGenFeatures()) {
				if (!genFeature.isSuppressedGetVisibility()) {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(genClass.getRawQualifiedInterfaceName());
					stringBuffer.append(TEXT_8);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_9);
					stringBuffer.append(genFeature.getFormattedName());
					stringBuffer.append(TEXT_10);
				}
			}
			stringBuffer.append(TEXT_11);
		}
		stringBuffer.append(TEXT_5);
		if (!genModel.isSuppressEMFMetaData()) {
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genClass.getClassifierAccessorName());
			stringBuffer.append(TEXT_14);
		}
		if (!genModel.isSuppressEMFModelTags()) {
			boolean first = true;
			for (StringTokenizer stringTokenizer = new StringTokenizer(genClass.getModelInfo(), "\n\r"); stringTokenizer
					.hasMoreTokens();) {
				String modelInfo = stringTokenizer.nextToken();
				if (first) {
					first = false;
					stringBuffer.append(TEXT_15);
					stringBuffer.append(modelInfo);
				} else {
					stringBuffer.append(TEXT_16);
					stringBuffer.append(modelInfo);
				}
			}
			if (first) {
				stringBuffer.append(TEXT_17);
			}
		}
		if (genClass.needsRootExtendsInterfaceExtendsTag()) {
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genModel.getImportedName(genModel.getRootExtendsInterface()));
		}
		if (genClass.hasImplicitAPITags(true)) {
			stringBuffer.append(TEXT_19);
			stringBuffer.append(genClass.getImplicitAPITags(genModel.getIndentation(stringBuffer), true));
		}
		stringBuffer.append(TEXT_20);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}