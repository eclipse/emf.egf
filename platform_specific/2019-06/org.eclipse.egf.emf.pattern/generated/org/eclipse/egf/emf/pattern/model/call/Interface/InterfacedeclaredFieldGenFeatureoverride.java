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

public class InterfacedeclaredFieldGenFeatureoverride {
	protected static String nl;

	public static synchronized InterfacedeclaredFieldGenFeatureoverride create(String lineSeparator) {
		nl = lineSeparator;
		InterfacedeclaredFieldGenFeatureoverride result = new InterfacedeclaredFieldGenFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "\t/**" + NL + "\t * The cached setting delegate for the '{@link #";
	protected final String TEXT_3 = "() <em>";
	protected final String TEXT_4 = "</em>}' ";
	protected final String TEXT_5 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @see #";
	protected final String TEXT_6 = "()";
	protected final String TEXT_7 = NL + "\t * ";
	protected final String TEXT_8 = NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */";
	protected final String TEXT_9 = NL + "\t@";
	protected final String TEXT_10 = NL + "\t@Deprecated";
	protected final String TEXT_11 = NL + "\tprotected ";
	protected final String TEXT_12 = ".Internal.SettingDelegate ";
	protected final String TEXT_13 = "__ESETTING_DELEGATE = ((";
	protected final String TEXT_14 = ".Internal)";
	protected final String TEXT_15 = ").getSettingDelegate();" + NL;
	protected final String TEXT_16 = NL + "\t/**" + NL + "\t * The cached value of the '{@link #";
	protected final String TEXT_17 = " ";
	protected final String TEXT_18 = ";" + NL;
	protected final String TEXT_19 = NL + "\t/**" + NL + "\t * The empty value for the '{@link #";
	protected final String TEXT_20 = "</em>}' array accessor." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
	protected final String TEXT_21 = NL + "\t@SuppressWarnings(\"rawtypes\")";
	protected final String TEXT_22 = NL + "\tprotected static final ";
	protected final String TEXT_23 = "[] ";
	protected final String TEXT_24 = "_EEMPTY_ARRAY = new ";
	protected final String TEXT_25 = " [0]";
	protected final String TEXT_26 = NL + "\t/**" + NL + "\t * The default value of the '{@link #";
	protected final String TEXT_27 = NL + "\t@SuppressWarnings(\"unchecked\")";
	protected final String TEXT_28 = "; // TODO The default value literal \"";
	protected final String TEXT_29 = "\" is not valid.";
	protected final String TEXT_30 = " = ";
	protected final String TEXT_31 = ";";
	protected final String TEXT_32 = NL;
	protected final String TEXT_33 = NL + "\t/**" + NL
			+ "\t * An additional set of bit flags representing the values of boolean attributes and whether unsettable features have been set."
			+ NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL
			+ "\t * @ordered" + NL + "\t */";
	protected final String TEXT_34 = NL + "\tprotected int ";
	protected final String TEXT_35 = " = 0;" + NL;
	protected final String TEXT_36 = NL + "\t/**" + NL
			+ "\t * The offset of the flags representing the value of the '{@link #";
	protected final String TEXT_37 = "." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
	protected final String TEXT_38 = NL + "\tprotected static final int ";
	protected final String TEXT_39 = "_EFLAG_OFFSET = ";
	protected final String TEXT_40 = ";" + NL + "" + NL + "\t/**" + NL
			+ "\t * The flags representing the default value of the '{@link #";
	protected final String TEXT_41 = "_EFLAG_DEFAULT = ";
	protected final String TEXT_42 = ".ordinal()";
	protected final String TEXT_43 = ".VALUES.indexOf(";
	protected final String TEXT_44 = ")";
	protected final String TEXT_45 = " << ";
	protected final String TEXT_46 = "_EFLAG_OFFSET;" + NL + "" + NL + "\t/**" + NL
			+ "\t * The array of enumeration values for '{@link ";
	protected final String TEXT_47 = "}'" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->";
	protected final String TEXT_48 = NL + "\tprivate static final ";
	protected final String TEXT_49 = "_EFLAG_VALUES = ";
	protected final String TEXT_50 = ".values()";
	protected final String TEXT_51 = "(";
	protected final String TEXT_52 = "[])";
	protected final String TEXT_53 = ".VALUES.toArray(new ";
	protected final String TEXT_54 = "[";
	protected final String TEXT_55 = ".VALUES.size()])";
	protected final String TEXT_56 = NL + "\t/**" + NL + "\t * The flag";
	protected final String TEXT_57 = " representing the value of the '{@link #";
	protected final String TEXT_58 = "_EFLAG = ";
	protected final String TEXT_59 = "_EFLAG_OFFSET";
	protected final String TEXT_60 = NL + "\t/**" + NL + "\t * The flag representing whether the ";
	protected final String TEXT_61 = " has been set." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->";
	protected final String TEXT_62 = "_ESETFLAG = 1 << ";
	protected final String TEXT_63 = NL + "\t/**" + NL + "\t * This is true if the ";
	protected final String TEXT_64 = NL + "\tprotected boolean ";
	protected final String TEXT_65 = "ESet;" + NL;
	protected final String TEXT_66 = NL;

	public InterfacedeclaredFieldGenFeatureoverride() {
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

		for (Object genFeatureParameter : genFeatureList) {
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

																			this.genFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) genFeatureParameter;
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
																				ctx.setNode(new Node.Container(
																						currentNode, getClass()));
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
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_66);
		stringBuffer.append(TEXT_66);
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
		parameters.put("genFeature", this.genFeature);
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
		if (genFeature.hasSettingDelegate()) {
			stringBuffer.append(TEXT_2);
			stringBuffer.append(genFeature.getGetAccessor());
			stringBuffer.append(TEXT_3);
			stringBuffer.append(genFeature.getFormattedName());
			stringBuffer.append(TEXT_4);
			stringBuffer.append(genFeature.getFeatureKind());
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genFeature.getGetAccessor());
			stringBuffer.append(TEXT_6);
			if (genFeature.hasAPITags()) {
				stringBuffer.append(TEXT_7);
				stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
			}
			stringBuffer.append(TEXT_8);
			if (isGWT) {
				stringBuffer.append(TEXT_9);
				stringBuffer.append(genModel.getImportedName("com.google.gwt.user.client.rpc.GwtTransient"));
			}
			if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
				stringBuffer.append(TEXT_10);
			}
			stringBuffer.append(TEXT_11);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genFeature.getUpperName());
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
			stringBuffer.append(TEXT_14);
			stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
			stringBuffer.append(TEXT_15);
		} else if (genFeature.isListType() || genFeature.isReferenceType()) {
			if (genClass.isField(genFeature)) {
				stringBuffer.append(TEXT_16);
				stringBuffer.append(genFeature.getGetAccessor());
				stringBuffer.append(TEXT_3);
				stringBuffer.append(genFeature.getFormattedName());
				stringBuffer.append(TEXT_4);
				stringBuffer.append(genFeature.getFeatureKind());
				stringBuffer.append(TEXT_5);
				stringBuffer.append(genFeature.getGetAccessor());
				stringBuffer.append(TEXT_6);
				if (genFeature.hasAPITags()) {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
				}
				stringBuffer.append(TEXT_8);
				if (isGWT) {
					stringBuffer.append(TEXT_9);
					stringBuffer.append(genModel.getImportedName("com.google.gwt.user.client.rpc.GwtTransient"));
				}
				if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
					stringBuffer.append(TEXT_10);
				}
				stringBuffer.append(TEXT_11);
				stringBuffer.append(genFeature.getImportedInternalType(genClass));
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genFeature.getSafeName());
				stringBuffer.append(TEXT_18);
			}
			if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType()
					&& !genFeature.isMapType()) {
				String rawListItemType = genFeature.getRawListItemType(genClass);
				int index = rawListItemType.indexOf('[');
				String head = rawListItemType;
				String tail = "";
				if (index != -1) {
					head = rawListItemType.substring(0, index);
					tail = rawListItemType.substring(index);
				}
				stringBuffer.append(TEXT_19);
				stringBuffer.append(genFeature.getGetArrayAccessor());
				stringBuffer.append(TEXT_3);
				stringBuffer.append(genFeature.getFormattedName());
				stringBuffer.append(TEXT_20);
				stringBuffer.append(genFeature.getGetArrayAccessor());
				stringBuffer.append(TEXT_6);
				if (genFeature.hasAPITags()) {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
				}
				stringBuffer.append(TEXT_8);
				if (genFeature.getQualifiedListItemType(genClass).contains("<")
						|| genFeature.getArrayItemType(genClass).contains("<")) {
					stringBuffer.append(TEXT_21);
				}
				if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
					stringBuffer.append(TEXT_10);
				}
				stringBuffer.append(TEXT_22);
				stringBuffer.append(rawListItemType);
				stringBuffer.append(TEXT_23);
				stringBuffer.append(genFeature.getUpperName());
				stringBuffer.append(TEXT_24);
				stringBuffer.append(head);
				stringBuffer.append(TEXT_25);
				stringBuffer.append(tail);
				stringBuffer.append(TEXT_18);
			}
		} else {
			if (genFeature.hasEDefault() && (!genFeature.isVolatile() || !genModel.isReflectiveDelegation()
					&& (!genFeature.hasDelegateFeature() || !genFeature.isUnsettable()))) {
				String staticDefaultValue = genFeature.getStaticDefaultValue();
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genFeature.getGetAccessor());
				stringBuffer.append(TEXT_3);
				stringBuffer.append(genFeature.getFormattedName());
				stringBuffer.append(TEXT_4);
				stringBuffer.append(genFeature.getFeatureKind());
				stringBuffer.append(TEXT_5);
				stringBuffer.append(genFeature.getGetAccessor());
				stringBuffer.append(TEXT_6);
				if (genFeature.hasAPITags()) {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
				}
				stringBuffer.append(TEXT_8);
				if (genModel.useGenerics() && genFeature.isListDataType() && genFeature.isSetDefaultValue()) {
					stringBuffer.append(TEXT_27);
				}
				if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
					stringBuffer.append(TEXT_10);
				}
				stringBuffer.append(TEXT_22);
				stringBuffer.append(genFeature.getImportedType(genClass));
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genFeature.getEDefault());
				if ("".equals(staticDefaultValue)) {
					stringBuffer.append(TEXT_28);
					stringBuffer.append(genFeature.getEcoreFeature().getDefaultValueLiteral());
					stringBuffer.append(TEXT_29);
				} else {
					stringBuffer.append(TEXT_30);
					stringBuffer.append(staticDefaultValue);
					stringBuffer.append(TEXT_31);
					stringBuffer.append(genModel.getNonNLS(staticDefaultValue));
				}
				stringBuffer.append(TEXT_32);
			}
			if (genClass.isField(genFeature)) {
				if (genClass.isFlag(genFeature)) {
					int flagIndex = genClass.getFlagIndex(genFeature);
					if (flagIndex > 31 && flagIndex % 32 == 0) {
						stringBuffer.append(TEXT_33);
						if (isGWT) {
							stringBuffer.append(TEXT_9);
							stringBuffer
									.append(genModel.getImportedName("com.google.gwt.user.client.rpc.GwtTransient"));
						}
						stringBuffer.append(TEXT_34);
						stringBuffer.append(genClass.getFlagsField(genFeature));
						stringBuffer.append(TEXT_35);
					}
					if (genFeature.isEnumType()) {
						stringBuffer.append(TEXT_36);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_3);
						stringBuffer.append(genFeature.getFormattedName());
						stringBuffer.append(TEXT_4);
						stringBuffer.append(genFeature.getFeatureKind());
						stringBuffer.append(TEXT_37);
						if (genFeature.hasAPITags()) {
							stringBuffer.append(TEXT_7);
							stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
						}
						stringBuffer.append(TEXT_8);
						if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
							stringBuffer.append(TEXT_10);
						}
						stringBuffer.append(TEXT_38);
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_39);
						stringBuffer.append(flagIndex % 32);
						stringBuffer.append(TEXT_40);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_3);
						stringBuffer.append(genFeature.getFormattedName());
						stringBuffer.append(TEXT_4);
						stringBuffer.append(genFeature.getFeatureKind());
						stringBuffer.append(TEXT_37);
						if (genFeature.hasAPITags()) {
							stringBuffer.append(TEXT_7);
							stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
						}
						stringBuffer.append(TEXT_8);
						if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
							stringBuffer.append(TEXT_10);
						}
						stringBuffer.append(TEXT_38);
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_41);
						if (isJDK50) {
							stringBuffer.append(genFeature.getEDefault());
							stringBuffer.append(TEXT_42);
						} else {
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_43);
							stringBuffer.append(genFeature.getEDefault());
							stringBuffer.append(TEXT_44);
						}
						stringBuffer.append(TEXT_45);
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_46);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_17);
						stringBuffer.append(genFeature.getTypeGenClassifier().getFormattedName());
						stringBuffer.append(TEXT_47);
						if (genFeature.hasAPITags()) {
							stringBuffer.append(TEXT_7);
							stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
						}
						stringBuffer.append(TEXT_8);
						if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
							stringBuffer.append(TEXT_10);
						}
						stringBuffer.append(TEXT_48);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_23);
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_49);
						if (isJDK50) {
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_50);
						} else {
							stringBuffer.append(TEXT_51);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_52);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_53);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_54);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_55);
						}
						stringBuffer.append(TEXT_18);
					}
					stringBuffer.append(TEXT_56);
					stringBuffer.append(genClass.getFlagSize(genFeature) > 1 ? "s" : "");
					stringBuffer.append(TEXT_57);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_3);
					stringBuffer.append(genFeature.getFormattedName());
					stringBuffer.append(TEXT_4);
					stringBuffer.append(genFeature.getFeatureKind());
					stringBuffer.append(TEXT_5);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_6);
					if (genFeature.hasAPITags()) {
						stringBuffer.append(TEXT_7);
						stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
					}
					stringBuffer.append(TEXT_8);
					if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
						stringBuffer.append(TEXT_10);
					}
					stringBuffer.append(TEXT_38);
					stringBuffer.append(genFeature.getUpperName());
					stringBuffer.append(TEXT_58);
					stringBuffer.append(genClass.getFlagMask(genFeature));
					stringBuffer.append(TEXT_45);
					if (genFeature.isEnumType()) {
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_59);
					} else {
						stringBuffer.append(flagIndex % 32);
					}
					stringBuffer.append(TEXT_18);
				} else {
					stringBuffer.append(TEXT_16);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_3);
					stringBuffer.append(genFeature.getFormattedName());
					stringBuffer.append(TEXT_4);
					stringBuffer.append(genFeature.getFeatureKind());
					stringBuffer.append(TEXT_5);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_6);
					if (genFeature.hasAPITags()) {
						stringBuffer.append(TEXT_7);
						stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
					}
					stringBuffer.append(TEXT_8);
					if (isGWT) {
						stringBuffer.append(TEXT_9);
						stringBuffer.append(genModel.getImportedName("com.google.gwt.user.client.rpc.GwtTransient"));
					}
					if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
						stringBuffer.append(TEXT_10);
					}
					stringBuffer.append(TEXT_11);
					stringBuffer.append(genFeature.getImportedType(genClass));
					stringBuffer.append(TEXT_17);
					stringBuffer.append(genFeature.getSafeName());
					if (genFeature.hasEDefault()) {
						stringBuffer.append(TEXT_30);
						stringBuffer.append(genFeature.getEDefault());
					}
					stringBuffer.append(TEXT_18);
				}
			}
		}
		if (genClass.isESetField(genFeature)) {
			if (genClass.isESetFlag(genFeature)) {
				int flagIndex = genClass.getESetFlagIndex(genFeature);
				if (flagIndex > 31 && flagIndex % 32 == 0) {
					stringBuffer.append(TEXT_33);
					if (isGWT) {
						stringBuffer.append(TEXT_9);
						stringBuffer.append(genModel.getImportedName("com.google.gwt.user.client.rpc.GwtTransient"));
					}
					stringBuffer.append(TEXT_34);
					stringBuffer.append(genClass.getESetFlagsField(genFeature));
					stringBuffer.append(TEXT_35);
				}
				stringBuffer.append(TEXT_60);
				stringBuffer.append(genFeature.getFormattedName());
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genFeature.getFeatureKind());
				stringBuffer.append(TEXT_61);
				if (genFeature.hasAPITags()) {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
				}
				stringBuffer.append(TEXT_8);
				if (genFeature.hasAPITags()) {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
				}
				stringBuffer.append(TEXT_38);
				stringBuffer.append(genFeature.getUpperName());
				stringBuffer.append(TEXT_62);
				stringBuffer.append(flagIndex % 32);
				stringBuffer.append(TEXT_18);
			} else {
				stringBuffer.append(TEXT_63);
				stringBuffer.append(genFeature.getFormattedName());
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genFeature.getFeatureKind());
				stringBuffer.append(TEXT_61);
				if (genFeature.hasAPITags()) {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
				}
				stringBuffer.append(TEXT_8);
				if (isGWT) {
					stringBuffer.append(TEXT_9);
					stringBuffer.append(genModel.getImportedName("com.google.gwt.user.client.rpc.GwtTransient"));
				}
				if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
					stringBuffer.append(TEXT_10);
				}
				stringBuffer.append(TEXT_64);
				stringBuffer.append(genFeature.getUncapName());
				stringBuffer.append(TEXT_65);
			}
		}
		stringBuffer.append(TEXT_32);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.declaredFieldGenFeature.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
			callParameters.put("useInterfaceOverrideAnnotation", useInterfaceOverrideAnnotation);
			callParameters.put("isGWT", isGWT);
			callParameters.put("forceDefaultCase", forceDefaultCase);
			callParameters.put("indentDefaultCase", indentDefaultCase);
			callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
			callParameters.put("singleWildcard", singleWildcard);
			callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
			callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
			callParameters.put("negativeOperationOffsetCorrection", negativeOperationOffsetCorrection);
			callParameters.put("positiveOperationOffsetCorrection", positiveOperationOffsetCorrection);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0vHWcGJ-Ed-FqczH3ESmRw",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_32);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}