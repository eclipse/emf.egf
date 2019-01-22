//Generated with EGF 1.5.0.qualifier
package org.eclipse.egf.emf.pattern.model.call.Class;

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

public class ClassgetGenFeaturejavadocoverride {
	protected static String nl;

	public static synchronized ClassgetGenFeaturejavadocoverride create(String lineSeparator) {
		nl = lineSeparator;
		ClassgetGenFeaturejavadocoverride result = new ClassgetGenFeaturejavadocoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "\t/**" + NL + "\t * Returns the value of the '<em><b>";
	protected final String TEXT_2 = "</b></em>' ";
	protected final String TEXT_3 = ".";
	protected final String TEXT_4 = NL + "\t * The key is of type ";
	protected final String TEXT_5 = "list of {@link ";
	protected final String TEXT_6 = "}";
	protected final String TEXT_7 = "{@link ";
	protected final String TEXT_8 = "," + NL + "\t * and the value is of type ";
	protected final String TEXT_9 = ",";
	protected final String TEXT_10 = NL + "\t * The list contents are of type {@link ";
	protected final String TEXT_11 = NL + "\t * The default value is <code>";
	protected final String TEXT_12 = "</code>.";
	protected final String TEXT_13 = NL + "\t * The literals are from the enumeration {@link ";
	protected final String TEXT_14 = "}.";
	protected final String TEXT_15 = NL + "\t * It is bidirectional and its opposite is '{@link ";
	protected final String TEXT_16 = "#";
	protected final String TEXT_17 = " <em>";
	protected final String TEXT_18 = "</em>}'.";
	protected final String TEXT_19 = NL;
	protected final String TEXT_20 = NL + "\t * <!-- begin-user-doc -->";
	protected final String TEXT_21 = NL + "\t * <p>" + NL + "\t * If the meaning of the '<em>";
	protected final String TEXT_22 = "</em>' ";
	protected final String TEXT_23 = " isn't clear," + NL + "\t * there really should be more of a description here..."
			+ NL + "\t * </p>";
	protected final String TEXT_24 = NL + "\t * <!-- end-user-doc -->";
	protected final String TEXT_25 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
	protected final String TEXT_26 = NL + "\t * <!-- end-model-doc -->";
	protected final String TEXT_27 = NL + "\t * @return the value of the '<em>";
	protected final String TEXT_28 = NL + "\t * @see ";
	protected final String TEXT_29 = NL + "\t * @see #isSet";
	protected final String TEXT_30 = "()";
	protected final String TEXT_31 = NL + "\t * @see #unset";
	protected final String TEXT_32 = NL + "\t * @see #set";
	protected final String TEXT_33 = "(";
	protected final String TEXT_34 = ")";
	protected final String TEXT_35 = "#get";
	protected final String TEXT_36 = NL + "\t * @model ";
	protected final String TEXT_37 = NL + "\t *        ";
	protected final String TEXT_38 = NL + "\t * @model";
	protected final String TEXT_39 = NL + "\t * @generated" + NL + "\t */" + NL;
	protected final String TEXT_40 = NL;

	public ClassgetGenFeaturejavadocoverride() {
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
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_40);
		stringBuffer.append(TEXT_40);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
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
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
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

	protected java.lang.Boolean isGWT = null;

	public void set_isGWT(java.lang.Boolean object) {
		this.isGWT = object;
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
		stringBuffer.append(genFeature.getFormattedName());
		stringBuffer.append(TEXT_2);
		stringBuffer.append(genFeature.getFeatureKind());
		stringBuffer.append(TEXT_3);
		if (genFeature.isListType() && genFeature.getEcoreFeature().getEGenericType().getETypeParameter() == null) {
			if (genFeature.isMapType()) {
				GenFeature keyFeature = genFeature.getMapEntryTypeGenClass().getMapEntryKeyFeature();
				GenFeature valueFeature = genFeature.getMapEntryTypeGenClass().getMapEntryValueFeature();
				stringBuffer.append(TEXT_4);
				if (keyFeature.isListType()) {
					stringBuffer.append(TEXT_5);
					stringBuffer.append(keyFeature.getQualifiedListItemType(genClass));
					stringBuffer.append(TEXT_6);
				} else {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(keyFeature.getType(genClass));
					stringBuffer.append(TEXT_6);
				}
				stringBuffer.append(TEXT_8);
				if (valueFeature.isListType()) {
					stringBuffer.append(TEXT_5);
					stringBuffer.append(valueFeature.getQualifiedListItemType(genClass));
					stringBuffer.append(TEXT_6);
				} else {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(valueFeature.getType(genClass));
					stringBuffer.append(TEXT_6);
				}
				stringBuffer.append(TEXT_9);
			} else if (!genFeature.isWrappedFeatureMapType() && !(genModel.isSuppressEMFMetaData()
					&& "org.eclipse.emf.ecore.EObject".equals(genFeature.getQualifiedListItemType(genClass)))) {
				String typeName = genFeature.getQualifiedListItemType(genClass);
				String head = typeName;
				String tail = "";
				int index = typeName.indexOf('<');
				if (index == -1) {
					index = typeName.indexOf('[');
				}
				if (index != -1) {
					head = typeName.substring(0, index);
					tail = "<code>" + CodeGenUtil.xmlEscapeEncode(typeName.substring(index)) + "</code>";
				}

				stringBuffer.append(TEXT_10);
				stringBuffer.append(head);
				stringBuffer.append(TEXT_6);
				stringBuffer.append(tail);
				stringBuffer.append(TEXT_3);
			}
		} else if (genFeature.isSetDefaultValue()) {
			stringBuffer.append(TEXT_11);
			stringBuffer.append(genFeature.getDefaultValue());
			stringBuffer.append(TEXT_12);
		}
		if (genFeature.getTypeGenEnum() != null) {
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
			stringBuffer.append(TEXT_14);
		}
		if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) {
			GenFeature reverseGenFeature = genFeature.getReverse();
			if (!reverseGenFeature.isSuppressedGetVisibility()) {
				stringBuffer.append(TEXT_15);
				stringBuffer.append(reverseGenFeature.getGenClass().getRawQualifiedInterfaceName());
				stringBuffer.append(TEXT_16);
				stringBuffer.append(reverseGenFeature.getGetAccessor());
				stringBuffer.append(TEXT_17);
				stringBuffer.append(reverseGenFeature.getFormattedName());
				stringBuffer.append(TEXT_18);
			}
		}
		stringBuffer.append(TEXT_19);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.getGenFeature.javadoc.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("genFeature", genFeature);
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			callParameters.put("isJDK50", isJDK50);
			callParameters.put("isInterface", isInterface);
			callParameters.put("isImplementation", isImplementation);
			callParameters.put("isGWT", isGWT);
			callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
			callParameters.put("singleWildcard", singleWildcard);
			callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
			callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
			callParameters.put("negativeOperationOffsetCorrection", negativeOperationOffsetCorrection);
			callParameters.put("positiveOperationOffsetCorrection", positiveOperationOffsetCorrection);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0lIUAGJ-Ed-FqczH3ESmRw",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_20);
		if (!genFeature.hasDocumentation()) {
			stringBuffer.append(TEXT_21);
			stringBuffer.append(genFeature.getFormattedName());
			stringBuffer.append(TEXT_22);
			stringBuffer.append(genFeature.getFeatureKind());
			stringBuffer.append(TEXT_23);
		}
		stringBuffer.append(TEXT_24);
		if (genFeature.hasDocumentation()) {
			stringBuffer.append(TEXT_25);
			stringBuffer.append(genFeature.getDocumentation(genModel.getIndentation(stringBuffer)));
			stringBuffer.append(TEXT_26);
		}
		stringBuffer.append(TEXT_27);
		stringBuffer.append(genFeature.getFormattedName());
		stringBuffer.append(TEXT_22);
		stringBuffer.append(genFeature.getFeatureKind());
		stringBuffer.append(TEXT_3);
		if (genFeature.getTypeGenEnum() != null) {
			stringBuffer.append(TEXT_28);
			stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
		}
		if (genFeature.isUnsettable()) {
			if (!genFeature.isSuppressedIsSetVisibility()) {
				stringBuffer.append(TEXT_29);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_30);
			}
			if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
				stringBuffer.append(TEXT_31);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_30);
			}
		}
		if (genFeature.isChangeable() && !genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
			stringBuffer.append(TEXT_32);
			stringBuffer.append(genFeature.getAccessorName());
			stringBuffer.append(TEXT_33);
			stringBuffer.append(genFeature.getRawImportedBoundType());
			stringBuffer.append(TEXT_34);
		}
		if (!genModel.isSuppressEMFMetaData()) {
			stringBuffer.append(TEXT_28);
			stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
			stringBuffer.append(TEXT_35);
			stringBuffer.append(genFeature.getFeatureAccessorName());
			stringBuffer.append(TEXT_30);
		}
		if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) {
			GenFeature reverseGenFeature = genFeature.getReverse();
			if (!reverseGenFeature.isSuppressedGetVisibility()) {
				stringBuffer.append(TEXT_28);
				stringBuffer.append(reverseGenFeature.getGenClass().getRawQualifiedInterfaceName());
				stringBuffer.append(TEXT_16);
				stringBuffer.append(reverseGenFeature.getGetAccessor());
			}
		}
		if (!genModel.isSuppressEMFModelTags()) {
			boolean first = true;
			for (StringTokenizer stringTokenizer = new StringTokenizer(genFeature.getModelInfo(),
					"\n\r"); stringTokenizer.hasMoreTokens();) {
				String modelInfo = stringTokenizer.nextToken();
				if (first) {
					first = false;
					stringBuffer.append(TEXT_36);
					stringBuffer.append(modelInfo);
				} else {
					stringBuffer.append(TEXT_37);
					stringBuffer.append(modelInfo);
				}
			}
			if (first) {
				stringBuffer.append(TEXT_38);
			}
		}
		stringBuffer.append(TEXT_39);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}