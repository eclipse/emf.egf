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

public class InterfacesetGenFeatureoverride {
	protected static String nl;

	public static synchronized InterfacesetGenFeatureoverride create(String lineSeparator) {
		nl = lineSeparator;
		InterfacesetGenFeatureoverride result = new InterfacesetGenFeatureoverride();
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
	protected final String TEXT_7 = NL + "\tvoid set";
	protected final String TEXT_8 = "(";
	protected final String TEXT_9 = " value);" + NL;
	protected final String TEXT_10 = NL + "\t@Override";
	protected final String TEXT_11 = NL + "\tpublic void set";
	protected final String TEXT_12 = "_";
	protected final String TEXT_13 = " ";
	protected final String TEXT_14 = ")" + NL + "\t{";
	protected final String TEXT_15 = NL + "\t\teDynamicSet(";
	protected final String TEXT_16 = " - ESTATIC_FEATURE_COUNT";
	protected final String TEXT_17 = ", ";
	protected final String TEXT_18 = "new ";
	protected final String TEXT_19 = "new";
	protected final String TEXT_20 = ")";
	protected final String TEXT_21 = ");";
	protected final String TEXT_22 = NL + "\t\teSet(";
	protected final String TEXT_23 = NL + "\t\t";
	protected final String TEXT_24 = "__ESETTING_DELEGATE.dynamicSet(this, null, 0, ";
	protected final String TEXT_25 = NL + "\t\tif (new";
	protected final String TEXT_26 = " != eInternalContainer() || (eContainerFeatureID() != ";
	protected final String TEXT_27 = " && new";
	protected final String TEXT_28 = " != null))" + NL + "\t\t{" + NL + "\t\t\tif (";
	protected final String TEXT_29 = ".isAncestor(this, ";
	protected final String TEXT_30 = "))" + NL + "\t\t\t\tthrow new ";
	protected final String TEXT_31 = "(\"Recursive containment not allowed for \" + toString());";
	protected final String TEXT_32 = NL + "\t\t\t";
	protected final String TEXT_33 = " msgs = null;" + NL + "\t\t\tif (eInternalContainer() != null)" + NL
			+ "\t\t\t\tmsgs = eBasicRemoveFromContainer(msgs);" + NL + "\t\t\tif (new";
	protected final String TEXT_34 = " != null)" + NL + "\t\t\t\tmsgs = ";
	protected final String TEXT_35 = ".eInverseAdd(this, ";
	protected final String TEXT_36 = ".class, msgs);" + NL + "\t\t\tmsgs = basicSet";
	protected final String TEXT_37 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
	protected final String TEXT_38 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_39 = "(this, ";
	protected final String TEXT_40 = ".SET, ";
	protected final String TEXT_41 = ", new";
	protected final String TEXT_42 = "));";
	protected final String TEXT_43 = " = (";
	protected final String TEXT_44 = ")eVirtualGet(";
	protected final String TEXT_45 = " != ";
	protected final String TEXT_46 = ")" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_47 = " msgs = null;" + NL + "\t\t\tif (";
	protected final String TEXT_48 = " != null)";
	protected final String TEXT_49 = NL + "\t\t\t\tmsgs = ";
	protected final String TEXT_50 = ".eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_51 = ", null, msgs);" + NL + "\t\t\tif (new";
	protected final String TEXT_52 = ".eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_53 = ", null, msgs);";
	protected final String TEXT_54 = ".eInverseRemove(this, ";
	protected final String TEXT_55 = ".class, msgs);" + NL + "\t\t\tif (new";
	protected final String TEXT_56 = ".class, msgs);";
	protected final String TEXT_57 = NL + "\t\t\tmsgs = basicSet";
	protected final String TEXT_58 = NL + "\t\telse" + NL + "\t\t{";
	protected final String TEXT_59 = NL + "\t\t\tboolean old";
	protected final String TEXT_60 = "ESet = eVirtualIsSet(";
	protected final String TEXT_61 = "ESet = (";
	protected final String TEXT_62 = " & ";
	protected final String TEXT_63 = "_ESETFLAG) != 0;";
	protected final String TEXT_64 = " |= ";
	protected final String TEXT_65 = "_ESETFLAG;";
	protected final String TEXT_66 = "ESet = ";
	protected final String TEXT_67 = "ESet;";
	protected final String TEXT_68 = "ESet = true;";
	protected final String TEXT_69 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
	protected final String TEXT_70 = ", !old";
	protected final String TEXT_71 = "ESet));";
	protected final String TEXT_72 = NL + "\t\t}";
	protected final String TEXT_73 = " old";
	protected final String TEXT_74 = "_EFLAG) != 0;";
	protected final String TEXT_75 = " = ";
	protected final String TEXT_76 = "_EFLAG_VALUES[(";
	protected final String TEXT_77 = "_EFLAG) >>> ";
	protected final String TEXT_78 = "_EFLAG_OFFSET];";
	protected final String TEXT_79 = ") ";
	protected final String TEXT_80 = "_EFLAG; else ";
	protected final String TEXT_81 = " &= ~";
	protected final String TEXT_82 = "_EFLAG;";
	protected final String TEXT_83 = " == null) new";
	protected final String TEXT_84 = "_EDEFAULT;" + NL + "\t\t";
	protected final String TEXT_85 = " & ~";
	protected final String TEXT_86 = "_EFLAG | ";
	protected final String TEXT_87 = ".ordinal()";
	protected final String TEXT_88 = ".VALUES.indexOf(new";
	protected final String TEXT_89 = " << ";
	protected final String TEXT_90 = "_EFLAG_OFFSET;";
	protected final String TEXT_91 = ";";
	protected final String TEXT_92 = " = new";
	protected final String TEXT_93 = " == null ? ";
	protected final String TEXT_94 = " : new";
	protected final String TEXT_95 = NL + "\t\tObject old";
	protected final String TEXT_96 = " = eVirtualSet(";
	protected final String TEXT_97 = NL + "\t\tboolean isSetChange = old";
	protected final String TEXT_98 = " == EVIRTUAL_NO_VALUE;";
	protected final String TEXT_99 = NL + "\t\tboolean old";
	protected final String TEXT_100 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_101 = "isSetChange ? ";
	protected final String TEXT_102 = " : old";
	protected final String TEXT_103 = "old";
	protected final String TEXT_104 = "isSetChange";
	protected final String TEXT_105 = "!old";
	protected final String TEXT_106 = "ESet";
	protected final String TEXT_107 = " == EVIRTUAL_NO_VALUE ? ";
	protected final String TEXT_108 = NL + "\t\t((";
	protected final String TEXT_109 = ".Internal)((";
	protected final String TEXT_110 = ".Internal.Wrapper)get";
	protected final String TEXT_111 = "()).featureMap()).set(";
	protected final String TEXT_112 = ".Internal)get";
	protected final String TEXT_113 = "()).set(";
	protected final String TEXT_114 = NL + "\t}" + NL;
	protected final String TEXT_115 = NL;

	public InterfacesetGenFeatureoverride() {
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

		stringBuffer.append(TEXT_115);
		stringBuffer.append(TEXT_115);
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
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.javadoc.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0yZT8GJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/setGenFeature.javadoc.override.javajetinc
		} else {
			stringBuffer.append(TEXT_3);
			if (genFeature.hasAPITags()) {
				stringBuffer.append(TEXT_4);
				stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
			}
			stringBuffer.append(TEXT_5);
			if (isJDK50) { //Class/setGenFeature.annotations.insert.javajetinc
				stringBuffer.append(TEXT_2);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.annotations.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
							"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0ysO4GJ-Ed-FqczH3ESmRw",
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
			stringBuffer.append(genFeature.getImportedType(genClass));
			stringBuffer.append(TEXT_9);
		} else {
			GenOperation setAccessorOperation = genClass.getSetAccessorOperation(genFeature);
			if (useInterfaceOverrideAnnotation && !genClass.isMapEntry()
					&& !genClass.hasCollidingSetAccessorOperation(genFeature)
					&& !genFeature.isSuppressedSetVisibility()) {
				stringBuffer.append(TEXT_10);
			}
			stringBuffer.append(TEXT_11);
			stringBuffer.append(genFeature.getAccessorName());
			if (genClass.hasCollidingSetAccessorOperation(genFeature)) {
				stringBuffer.append(TEXT_12);
			}
			stringBuffer.append(TEXT_8);
			stringBuffer.append(genFeature.getImportedType(genClass));
			stringBuffer.append(TEXT_13);
			stringBuffer.append(setAccessorOperation == null ? "new" + genFeature.getCapName()
					: setAccessorOperation.getGenParameters().get(0).getName());
			stringBuffer.append(TEXT_14);
			stringBuffer.append(TEXT_2);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.pre.insert" args="setAccessorOperation:setAccessorOperation,genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("setAccessorOperation", setAccessorOperation);
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
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0y1Y0GJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			if (genModel.isDynamicDelegation() && !genFeature.isVolatile()) {
				stringBuffer.append(TEXT_2);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.dynamicSetGenFeature.pre.insert" args="setAccessorOperation:setAccessorOperation,genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("setAccessorOperation", setAccessorOperation);
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
							"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_eTdDcCSWEemxeP6B0lLOpA",
							new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

				stringBuffer.append(TEXT_15);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				if (genClass.hasStaticFeatures()) {
					stringBuffer.append(TEXT_16);
				}
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_17);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_18);
					stringBuffer.append(genFeature.getObjectType(genClass));
					stringBuffer.append(TEXT_8);
				}
				stringBuffer.append(TEXT_19);
				stringBuffer.append(genFeature.getCapName());
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_20);
				}
				stringBuffer.append(TEXT_21);
				stringBuffer.append(TEXT_2);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.dynamicSetGenFeature.post.insert" args="setAccessorOperation:setAccessorOperation,genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("setAccessorOperation", setAccessorOperation);
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
							"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_eZahgCSWEemxeP6B0lLOpA",
							new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

			} else if (genModel.isReflectiveDelegation()) {
				stringBuffer.append(TEXT_22);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_17);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_18);
					stringBuffer.append(genFeature.getObjectType(genClass));
					stringBuffer.append(TEXT_8);
				}
				stringBuffer.append(TEXT_19);
				stringBuffer.append(genFeature.getCapName());
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_20);
				}
				stringBuffer.append(TEXT_21);
			} else if (genFeature.hasSettingDelegate()) {
				stringBuffer.append(TEXT_23);
				stringBuffer.append(genFeature.getUpperName());
				stringBuffer.append(TEXT_24);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_18);
					stringBuffer.append(genFeature.getObjectType(genClass));
					stringBuffer.append(TEXT_8);
				}
				stringBuffer.append(TEXT_19);
				stringBuffer.append(genFeature.getCapName());
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_20);
				}
				stringBuffer.append(TEXT_21);
			} else if (!genFeature.isVolatile()) {
				if (genFeature.isContainer()) {
					GenFeature reverseFeature = genFeature.getReverse();
					GenClass targetClass = reverseFeature.getGenClass();
					String reverseOffsetCorrection = targetClass.hasOffsetCorrection()
							? " + " + genClass.getOffsetCorrectionField(genFeature)
							: "";
					stringBuffer.append(TEXT_25);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_26);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(positiveOffsetCorrection);
					stringBuffer.append(TEXT_27);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_28);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
					stringBuffer.append(TEXT_29);
					stringBuffer.append(genFeature.getEObjectCast());
					stringBuffer.append(TEXT_19);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_30);
					stringBuffer.append(genModel.getImportedName("java.lang.IllegalArgumentException"));
					stringBuffer.append(TEXT_31);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(TEXT_32);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
					stringBuffer.append(TEXT_33);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_34);
					stringBuffer.append(genFeature.getAsInternalEObject("new" + genFeature.getCapName(), true));
					stringBuffer.append(TEXT_35);
					stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
					stringBuffer.append(reverseOffsetCorrection);
					stringBuffer.append(TEXT_17);
					stringBuffer.append(targetClass.getRawImportedInterfaceName());
					stringBuffer.append(TEXT_36);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_8);
					stringBuffer.append(genFeature.getInternalTypeCast());
					stringBuffer.append(TEXT_19);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_37);
					if (!genModel.isSuppressNotification()) {
						stringBuffer.append(TEXT_38);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
						stringBuffer.append(TEXT_39);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
						stringBuffer.append(TEXT_40);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_41);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_41);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_42);
					}
				} else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_23);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_13);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_43);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_44);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_21);
					}
					stringBuffer.append(TEXT_25);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_45);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_46);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
					stringBuffer.append(TEXT_47);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_48);
					if (!genFeature.isBidirectional()) {
						stringBuffer.append(TEXT_49);
						stringBuffer.append(genFeature.getAsInternalEObject(genFeature.getSafeName(), true));
						stringBuffer.append(TEXT_50);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(negativeOffsetCorrection);
						stringBuffer.append(TEXT_51);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_34);
						stringBuffer.append(genFeature.getAsInternalEObject("new" + genFeature.getCapName(), true));
						stringBuffer.append(TEXT_52);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(negativeOffsetCorrection);
						stringBuffer.append(TEXT_53);
					} else {
						GenFeature reverseFeature = genFeature.getReverse();
						GenClass targetClass = reverseFeature.getGenClass();
						String reverseOffsetCorrection = targetClass.hasOffsetCorrection()
								? " + " + genClass.getOffsetCorrectionField(genFeature)
								: "";
						stringBuffer.append(TEXT_49);
						stringBuffer.append(genFeature.getAsInternalEObject(genFeature.getSafeName(), true));
						stringBuffer.append(TEXT_54);
						stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
						stringBuffer.append(reverseOffsetCorrection);
						stringBuffer.append(TEXT_17);
						stringBuffer.append(targetClass.getRawImportedInterfaceName());
						stringBuffer.append(TEXT_55);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_34);
						stringBuffer.append(genFeature.getAsInternalEObject("new" + genFeature.getCapName(), true));
						stringBuffer.append(TEXT_35);
						stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
						stringBuffer.append(reverseOffsetCorrection);
						stringBuffer.append(TEXT_17);
						stringBuffer.append(targetClass.getRawImportedInterfaceName());
						stringBuffer.append(TEXT_56);
					}
					stringBuffer.append(TEXT_57);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_8);
					stringBuffer.append(genFeature.getInternalTypeCast());
					stringBuffer.append(TEXT_19);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_37);
					if (genFeature.isUnsettable()) {
						stringBuffer.append(TEXT_58);
						if (genModel.isVirtualDelegation()) {
							stringBuffer.append(TEXT_59);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_60);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_21);
						} else if (genClass.isESetFlag(genFeature)) {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_59);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_61);
								stringBuffer.append(genClass.getESetFlagsField(genFeature));
								stringBuffer.append(TEXT_62);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_63);
							}
							stringBuffer.append(TEXT_32);
							stringBuffer.append(genClass.getESetFlagsField(genFeature));
							stringBuffer.append(TEXT_64);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_65);
						} else {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_59);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_66);
								stringBuffer.append(genFeature.getUncapName());
								stringBuffer.append(TEXT_67);
							}
							stringBuffer.append(TEXT_32);
							stringBuffer.append(genFeature.getUncapName());
							stringBuffer.append(TEXT_68);
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_69);
							stringBuffer
									.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_39);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_40);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_41);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_41);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_70);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_71);
						}
						stringBuffer.append(TEXT_72);
					} else {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_38);
							stringBuffer
									.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_39);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_40);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_41);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_41);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_42);
						}
					}
				} else {
					if (genClass.isFlag(genFeature)) {
						if (!genModel.isSuppressNotification()) {
							if (genFeature.isBooleanType()) {
								stringBuffer.append(TEXT_23);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_73);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_43);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_62);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_74);
							} else {
								stringBuffer.append(TEXT_23);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_73);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_75);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_76);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_62);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_77);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_78);
							}
						}
						if (genFeature.isBooleanType()) {
							stringBuffer.append(TEXT_25);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_79);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_64);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_80);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_81);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_82);
						} else {
							stringBuffer.append(TEXT_25);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_83);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_75);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_84);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_75);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_85);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_86);
							if (isJDK50) {
								stringBuffer.append(TEXT_19);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_87);
							} else {
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_88);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_20);
							}
							stringBuffer.append(TEXT_89);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_90);
						}
					} else {
						if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_23);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_73);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_75);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_91);
							}
						}
						if (genFeature.isEnumType()) {
							if (genModel.isVirtualDelegation()) {
								stringBuffer.append(TEXT_23);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_13);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_92);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_93);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_94);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_91);
							} else {
								stringBuffer.append(TEXT_23);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_92);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_93);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_94);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_91);
							}
						} else {
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_23);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_13);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_75);
								stringBuffer.append(genFeature.getInternalTypeCast());
								stringBuffer.append(TEXT_19);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_91);
							} else {
								stringBuffer.append(TEXT_23);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_75);
								stringBuffer.append(genFeature.getInternalTypeCast());
								stringBuffer.append(TEXT_19);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_91);
							}
						}
						if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_95);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_96);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_17);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_21);
						}
					}
					if (genFeature.isUnsettable()) {
						if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_97);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_98);
						} else if (genClass.isESetFlag(genFeature)) {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_99);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_61);
								stringBuffer.append(genClass.getESetFlagsField(genFeature));
								stringBuffer.append(TEXT_62);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_63);
							}
							stringBuffer.append(TEXT_23);
							stringBuffer.append(genClass.getESetFlagsField(genFeature));
							stringBuffer.append(TEXT_64);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_65);
						} else {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_99);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_66);
								stringBuffer.append(genFeature.getUncapName());
								stringBuffer.append(TEXT_67);
							}
							stringBuffer.append(TEXT_23);
							stringBuffer.append(genFeature.getUncapName());
							stringBuffer.append(TEXT_68);
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_100);
							stringBuffer
									.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_39);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_40);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_17);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_101);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_102);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(TEXT_103);
								stringBuffer.append(genFeature.getCapName());
							}
							stringBuffer.append(TEXT_17);
							if (genClass.isFlag(genFeature)) {
								stringBuffer.append(TEXT_19);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(genFeature.getSafeName());
							}
							stringBuffer.append(TEXT_17);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_104);
							} else {
								stringBuffer.append(TEXT_105);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_106);
							}
							stringBuffer.append(TEXT_42);
						}
					} else {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_100);
							stringBuffer
									.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_39);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_40);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_17);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_103);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_107);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_102);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(TEXT_103);
								stringBuffer.append(genFeature.getCapName());
							}
							stringBuffer.append(TEXT_17);
							if (genClass.isFlag(genFeature)) {
								stringBuffer.append(TEXT_19);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(genFeature.getSafeName());
							}
							stringBuffer.append(TEXT_42);
						}
					}
				}
				stringBuffer.append(TEXT_2);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.post.insert" args="setAccessorOperation:setAccessorOperation,genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("setAccessorOperation", setAccessorOperation);
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
							"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0y_J0GJ-Ed-FqczH3ESmRw",
							new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

			} else if (genFeature.hasDelegateFeature()) {
				GenFeature delegateFeature = genFeature.getDelegateFeature();
				if (delegateFeature.isWrappedFeatureMapType()) {
					stringBuffer.append(TEXT_108);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_109);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_110);
					stringBuffer.append(delegateFeature.getAccessorName());
					stringBuffer.append(TEXT_111);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_17);
					if (!isJDK50 && genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_18);
						stringBuffer.append(genFeature.getObjectType(genClass));
						stringBuffer.append(TEXT_8);
					}
					stringBuffer.append(TEXT_19);
					stringBuffer.append(genFeature.getCapName());
					if (!isJDK50 && genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_20);
					}
					stringBuffer.append(TEXT_21);
				} else {
					stringBuffer.append(TEXT_108);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_112);
					stringBuffer.append(delegateFeature.getAccessorName());
					stringBuffer.append(TEXT_113);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_17);
					if (!isJDK50 && genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_18);
						stringBuffer.append(genFeature.getObjectType(genClass));
						stringBuffer.append(TEXT_8);
					}
					stringBuffer.append(TEXT_19);
					stringBuffer.append(genFeature.getCapName());
					if (!isJDK50 && genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_20);
					}
					stringBuffer.append(TEXT_21);
				}
			} else if (setAccessorOperation != null) {
				stringBuffer.append(TEXT_23);
				stringBuffer.append(setAccessorOperation.getBody(genModel.getIndentation(stringBuffer)));
			} else {
				stringBuffer.append(TEXT_2);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.TODO.override" args="setAccessorOperation:setAccessorOperation,genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,useInterfaceOverrideAnnotation:useInterfaceOverrideAnnotation,isGWT:isGWT,forceDefaultCase:forceDefaultCase,indentDefaultCase:indentDefaultCase,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("setAccessorOperation", setAccessorOperation);
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
							"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0y_J5WJ-Ed-FqczH3ESmRw",
							new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

				//Class/setGenFeature.todo.override.javajetinc
			}
			stringBuffer.append(TEXT_114);
		}
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}