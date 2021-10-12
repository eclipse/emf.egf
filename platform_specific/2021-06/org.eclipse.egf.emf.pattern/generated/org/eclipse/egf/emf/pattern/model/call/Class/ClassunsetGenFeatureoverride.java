//Generated with EGF 1.6.2.201911290829
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

public class ClassunsetGenFeatureoverride {
	protected static String nl;

	public static synchronized ClassunsetGenFeatureoverride create(String lineSeparator) {
		nl = lineSeparator;
		ClassunsetGenFeatureoverride result = new ClassunsetGenFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->";
	protected final String TEXT_4 = NL + "\t * ";
	protected final String TEXT_5 = NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_6 = NL + "\t@Deprecated";
	protected final String TEXT_7 = NL + "\tvoid unset";
	protected final String TEXT_8 = "();" + NL;
	protected final String TEXT_9 = NL + "\t@Override";
	protected final String TEXT_10 = NL + "\tpublic void unset";
	protected final String TEXT_11 = "_";
	protected final String TEXT_12 = "()" + NL + "\t{";
	protected final String TEXT_13 = NL + "\t\teDynamicUnset(";
	protected final String TEXT_14 = " - ESTATIC_FEATURE_COUNT";
	protected final String TEXT_15 = ", ";
	protected final String TEXT_16 = ");";
	protected final String TEXT_17 = NL + "\t\teUnset(";
	protected final String TEXT_18 = NL + "\t\t";
	protected final String TEXT_19 = "__ESETTING_DELEGATE.dynamicUnset(this, null, 0);";
	protected final String TEXT_20 = " ";
	protected final String TEXT_21 = " = (";
	protected final String TEXT_22 = ")eVirtualGet(";
	protected final String TEXT_23 = NL + "\t\tif (";
	protected final String TEXT_24 = " != null) ((";
	protected final String TEXT_25 = ".Unsettable";
	protected final String TEXT_26 = ")";
	protected final String TEXT_27 = ").unset();";
	protected final String TEXT_28 = " != null)" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_29 = " msgs = null;";
	protected final String TEXT_30 = NL + "\t\t\tmsgs = ";
	protected final String TEXT_31 = ".eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_32 = ", null, msgs);";
	protected final String TEXT_33 = ".eInverseRemove(this, ";
	protected final String TEXT_34 = ".class, msgs);";
	protected final String TEXT_35 = NL + "\t\t\tmsgs = basicUnset";
	protected final String TEXT_36 = "(msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}" + NL
			+ "\t\telse" + NL + "\t\t{";
	protected final String TEXT_37 = NL + "\t\t\tboolean old";
	protected final String TEXT_38 = "ESet = eVirtualIsSet(";
	protected final String TEXT_39 = "ESet = (";
	protected final String TEXT_40 = " & ";
	protected final String TEXT_41 = "_ESETFLAG) != 0;";
	protected final String TEXT_42 = NL + "\t\t\t";
	protected final String TEXT_43 = " &= ~";
	protected final String TEXT_44 = "_ESETFLAG;";
	protected final String TEXT_45 = "ESet = ";
	protected final String TEXT_46 = "ESet;";
	protected final String TEXT_47 = "ESet = false;";
	protected final String TEXT_48 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
	protected final String TEXT_49 = "(this, ";
	protected final String TEXT_50 = ".UNSET, ";
	protected final String TEXT_51 = ", null, null, old";
	protected final String TEXT_52 = "ESet));";
	protected final String TEXT_53 = NL + "\t\t}";
	protected final String TEXT_54 = " old";
	protected final String TEXT_55 = "_EFLAG) != 0;";
	protected final String TEXT_56 = " = ";
	protected final String TEXT_57 = "_EFLAG_VALUES[(";
	protected final String TEXT_58 = "_EFLAG) >>> ";
	protected final String TEXT_59 = "_EFLAG_OFFSET];";
	protected final String TEXT_60 = NL + "\t\tObject old";
	protected final String TEXT_61 = " = eVirtualUnset(";
	protected final String TEXT_62 = ";";
	protected final String TEXT_63 = NL + "\t\tboolean isSetChange = old";
	protected final String TEXT_64 = " != EVIRTUAL_NO_VALUE;";
	protected final String TEXT_65 = NL + "\t\tboolean old";
	protected final String TEXT_66 = " = null;";
	protected final String TEXT_67 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_68 = "isSetChange ? old";
	protected final String TEXT_69 = " : null";
	protected final String TEXT_70 = "old";
	protected final String TEXT_71 = ", null, ";
	protected final String TEXT_72 = "isSetChange";
	protected final String TEXT_73 = "ESet";
	protected final String TEXT_74 = "));";
	protected final String TEXT_75 = ") ";
	protected final String TEXT_76 = " |= ";
	protected final String TEXT_77 = "_EFLAG; else ";
	protected final String TEXT_78 = "_EFLAG;";
	protected final String TEXT_79 = " & ~";
	protected final String TEXT_80 = "_EFLAG | ";
	protected final String TEXT_81 = "_EFLAG_DEFAULT;";
	protected final String TEXT_82 = " : ";
	protected final String TEXT_83 = NL + "\t\t((";
	protected final String TEXT_84 = ".Internal)((";
	protected final String TEXT_85 = ".Internal.Wrapper)get";
	protected final String TEXT_86 = "()).featureMap()).clear(";
	protected final String TEXT_87 = ".Internal)get";
	protected final String TEXT_88 = "()).clear(";
	protected final String TEXT_89 = NL + "\t}" + NL;
	protected final String TEXT_90 = NL;

	public ClassunsetGenFeatureoverride() {
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

		stringBuffer.append(TEXT_90);
		stringBuffer.append(TEXT_90);
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
		if (isInterface) {
			stringBuffer.append(TEXT_2);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.unsetGenFeature.javadoc.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0rPjEGJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/unsetGenFeature.javadoc.override.javajetinc
		} else {
			stringBuffer.append(TEXT_3);
			if (genFeature.hasAPITags()) {
				stringBuffer.append(TEXT_4);
				stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
			}
			stringBuffer.append(TEXT_5);
			if (isJDK50) { //Class/unsetGenFeature.annotations.insert.javajetinc
				stringBuffer.append(TEXT_2);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.unsetGenFeature.annotations.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
							"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0rrn8GJ-Ed-FqczH3ESmRw",
							new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

			}
		}
		if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
			stringBuffer.append(TEXT_6);
		}
		if (!isImplementation) {
			stringBuffer.append(TEXT_7);
			stringBuffer.append(genFeature.getAccessorName());
			stringBuffer.append(TEXT_8);
		} else {
			if (useInterfaceOverrideAnnotation && !genClass.isMapEntry()
					&& !genClass.hasCollidingUnsetAccessorOperation(genFeature)
					&& !genFeature.isSuppressedUnsetVisibility()) {
				stringBuffer.append(TEXT_9);
			}
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genFeature.getAccessorName());
			if (genClass.hasCollidingUnsetAccessorOperation(genFeature)) {
				stringBuffer.append(TEXT_11);
			}
			stringBuffer.append(TEXT_12);
			if (genModel.isDynamicDelegation() && !genFeature.isVolatile()) {
				stringBuffer.append(TEXT_13);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				if (genClass.hasStaticFeatures()) {
					stringBuffer.append(TEXT_14);
				}
				stringBuffer.append(TEXT_15);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_16);
			} else if (genModel.isReflectiveDelegation()) {
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_16);
			} else if (genFeature.hasSettingDelegate()) {
				stringBuffer.append(TEXT_18);
				stringBuffer.append(genFeature.getUpperName());
				stringBuffer.append(TEXT_19);
			} else if (!genFeature.isVolatile()) {
				if (genFeature.isListType()) {
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_18);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_20);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_21);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_22);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_16);
					}
					stringBuffer.append(TEXT_23);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_24);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.InternalEList"));
					stringBuffer.append(TEXT_25);
					stringBuffer.append(singleWildcard);
					stringBuffer.append(TEXT_26);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_27);
				} else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_18);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_20);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_21);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_22);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_16);
					}
					stringBuffer.append(TEXT_23);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_28);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
					stringBuffer.append(TEXT_29);
					if (!genFeature.isBidirectional()) {
						stringBuffer.append(TEXT_30);
						stringBuffer.append(genFeature.getAsInternalEObject(genFeature.getSafeName(), true));
						stringBuffer.append(TEXT_31);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(negativeOffsetCorrection);
						stringBuffer.append(TEXT_32);
					} else {
						GenFeature reverseFeature = genFeature.getReverse();
						GenClass targetClass = reverseFeature.getGenClass();
						String reverseOffsetCorrection = targetClass.hasOffsetCorrection()
								? " + " + genClass.getOffsetCorrectionField(genFeature)
								: "";
						stringBuffer.append(TEXT_30);
						stringBuffer.append(genFeature.getAsInternalEObject(genFeature.getSafeName(), true));
						stringBuffer.append(TEXT_33);
						stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
						stringBuffer.append(reverseOffsetCorrection);
						stringBuffer.append(TEXT_15);
						stringBuffer.append(targetClass.getRawImportedInterfaceName());
						stringBuffer.append(TEXT_34);
					}
					stringBuffer.append(TEXT_35);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_36);
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_37);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_38);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_16);
					} else if (genClass.isESetFlag(genFeature)) {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_37);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_39);
							stringBuffer.append(genClass.getESetFlagsField(genFeature));
							stringBuffer.append(TEXT_40);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_41);
						}
						stringBuffer.append(TEXT_42);
						stringBuffer.append(genClass.getESetFlagsField(genFeature));
						stringBuffer.append(TEXT_43);
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_44);
					} else {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_37);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_45);
							stringBuffer.append(genFeature.getUncapName());
							stringBuffer.append(TEXT_46);
						}
						stringBuffer.append(TEXT_42);
						stringBuffer.append(genFeature.getUncapName());
						stringBuffer.append(TEXT_47);
					}
					if (!genModel.isSuppressNotification()) {
						stringBuffer.append(TEXT_48);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
						stringBuffer.append(TEXT_49);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
						stringBuffer.append(TEXT_50);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_51);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_52);
					}
					stringBuffer.append(TEXT_53);
				} else {
					if (genClass.isFlag(genFeature)) {
						if (!genModel.isSuppressNotification()) {
							if (genFeature.isBooleanType()) {
								stringBuffer.append(TEXT_18);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_54);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_21);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_40);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_55);
							} else {
								stringBuffer.append(TEXT_18);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_54);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_56);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_57);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_40);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_58);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_59);
							}
						}
					} else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_60);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_61);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_16);
					} else {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_18);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_54);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_56);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_62);
						}
					}
					if (!genModel.isSuppressNotification()) {
						if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_63);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_64);
						} else if (genClass.isESetFlag(genFeature)) {
							stringBuffer.append(TEXT_65);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_39);
							stringBuffer.append(genClass.getESetFlagsField(genFeature));
							stringBuffer.append(TEXT_40);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_41);
						} else {
							stringBuffer.append(TEXT_65);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_45);
							stringBuffer.append(genFeature.getUncapName());
							stringBuffer.append(TEXT_46);
						}
					}
					if (genFeature.isReferenceType()) {
						stringBuffer.append(TEXT_18);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_66);
						if (!genModel.isVirtualDelegation()) {
							if (genClass.isESetFlag(genFeature)) {
								stringBuffer.append(TEXT_18);
								stringBuffer.append(genClass.getESetFlagsField(genFeature));
								stringBuffer.append(TEXT_43);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_44);
							} else {
								stringBuffer.append(TEXT_18);
								stringBuffer.append(genFeature.getUncapName());
								stringBuffer.append(TEXT_47);
							}
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_67);
							stringBuffer
									.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_49);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_50);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_15);
							if (genModel.isVirtualDelegation()) {
								stringBuffer.append(TEXT_68);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_69);
							} else {
								stringBuffer.append(TEXT_70);
								stringBuffer.append(genFeature.getCapName());
							}
							stringBuffer.append(TEXT_71);
							if (genModel.isVirtualDelegation()) {
								stringBuffer.append(TEXT_72);
							} else {
								stringBuffer.append(TEXT_70);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_73);
							}
							stringBuffer.append(TEXT_74);
						}
					} else {
						if (genClass.isFlag(genFeature)) {
							if (genFeature.isBooleanType()) {
								stringBuffer.append(TEXT_23);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_75);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_76);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_77);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_43);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_78);
							} else {
								stringBuffer.append(TEXT_18);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_56);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_79);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_80);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_81);
							}
						} else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_18);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_56);
							stringBuffer.append(genFeature.getEDefault());
							stringBuffer.append(TEXT_62);
						}
						if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
							if (genClass.isESetFlag(genFeature)) {
								stringBuffer.append(TEXT_18);
								stringBuffer.append(genClass.getESetFlagsField(genFeature));
								stringBuffer.append(TEXT_43);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_44);
							} else {
								stringBuffer.append(TEXT_18);
								stringBuffer.append(genFeature.getUncapName());
								stringBuffer.append(TEXT_47);
							}
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_67);
							stringBuffer
									.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_49);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_50);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_15);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_68);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_82);
								stringBuffer.append(genFeature.getEDefault());
							} else {
								stringBuffer.append(TEXT_70);
								stringBuffer.append(genFeature.getCapName());
							}
							stringBuffer.append(TEXT_15);
							stringBuffer.append(genFeature.getEDefault());
							stringBuffer.append(TEXT_15);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_72);
							} else {
								stringBuffer.append(TEXT_70);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_73);
							}
							stringBuffer.append(TEXT_74);
						}
					}
				}
			} else if (genFeature.hasDelegateFeature()) {
				GenFeature delegateFeature = genFeature.getDelegateFeature();
				if (delegateFeature.isWrappedFeatureMapType()) {
					stringBuffer.append(TEXT_83);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_84);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_85);
					stringBuffer.append(delegateFeature.getAccessorName());
					stringBuffer.append(TEXT_86);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_16);
				} else {
					stringBuffer.append(TEXT_83);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_87);
					stringBuffer.append(delegateFeature.getAccessorName());
					stringBuffer.append(TEXT_88);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_16);
				}
			} else if (genClass.getUnsetAccessorOperation(genFeature) != null) {
				stringBuffer.append(TEXT_18);
				stringBuffer.append(
						genClass.getUnsetAccessorOperation(genFeature).getBody(genModel.getIndentation(stringBuffer)));
			} else {
				stringBuffer.append(TEXT_2);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.unsetGenFeature.TODO.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
							"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0r_J8GJ-Ed-FqczH3ESmRw",
							new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

				//Class/unsetGenFeature.todo.override.javajetinc
			}
			stringBuffer.append(TEXT_89);
		}
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}