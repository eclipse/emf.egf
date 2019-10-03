//Generated with EGF 1.5.0.qualifier
package org.eclipse.egf.emf.pattern.model.call.Interface;

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

public class InterfaceunsetGenFeatureoverride {
	protected static String nl;

	public static synchronized InterfaceunsetGenFeatureoverride create(String lineSeparator) {
		nl = lineSeparator;
		InterfaceunsetGenFeatureoverride result = new InterfaceunsetGenFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL + "\tvoid unset";
	protected final String TEXT_6 = "();" + NL;
	protected final String TEXT_7 = NL + "\tpublic void unset";
	protected final String TEXT_8 = "_";
	protected final String TEXT_9 = "()" + NL + "\t{";
	protected final String TEXT_10 = NL + "\t\teDynamicUnset(";
	protected final String TEXT_11 = " - ESTATIC_FEATURE_COUNT";
	protected final String TEXT_12 = ", ";
	protected final String TEXT_13 = ");";
	protected final String TEXT_14 = NL + "\t\teUnset(";
	protected final String TEXT_15 = ");";
	protected final String TEXT_16 = NL + "\t\t";
	protected final String TEXT_17 = "__ESETTING_DELEGATE.dynamicUnset(this, null, 0);";
	protected final String TEXT_18 = NL + "\t\t";
	protected final String TEXT_19 = " ";
	protected final String TEXT_20 = " = (";
	protected final String TEXT_21 = ")eVirtualGet(";
	protected final String TEXT_22 = ");";
	protected final String TEXT_23 = NL + "\t\tif (";
	protected final String TEXT_24 = " != null) ((";
	protected final String TEXT_25 = ".Unsettable";
	protected final String TEXT_26 = ")";
	protected final String TEXT_27 = ").unset();";
	protected final String TEXT_28 = NL + "\t\t";
	protected final String TEXT_29 = " ";
	protected final String TEXT_30 = " = (";
	protected final String TEXT_31 = ")eVirtualGet(";
	protected final String TEXT_32 = ");";
	protected final String TEXT_33 = NL + "\t\tif (";
	protected final String TEXT_34 = " != null)" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_35 = " msgs = null;";
	protected final String TEXT_36 = NL + "\t\t\tmsgs = ((";
	protected final String TEXT_37 = ")";
	protected final String TEXT_38 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_39 = ", null, msgs);";
	protected final String TEXT_40 = NL + "\t\t\tmsgs = ((";
	protected final String TEXT_41 = ")";
	protected final String TEXT_42 = ").eInverseRemove(this, ";
	protected final String TEXT_43 = ", ";
	protected final String TEXT_44 = ".class, msgs);";
	protected final String TEXT_45 = NL + "\t\t\tmsgs = basicUnset";
	protected final String TEXT_46 = "(msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}" + NL
			+ "\t\telse" + NL + "\t\t{";
	protected final String TEXT_47 = NL + "\t\t\tboolean old";
	protected final String TEXT_48 = "ESet = eVirtualIsSet(";
	protected final String TEXT_49 = ");";
	protected final String TEXT_50 = NL + "\t\t\tboolean old";
	protected final String TEXT_51 = "ESet = (";
	protected final String TEXT_52 = " & ";
	protected final String TEXT_53 = "_ESETFLAG) != 0;";
	protected final String TEXT_54 = NL + "\t\t\t";
	protected final String TEXT_55 = " &= ~";
	protected final String TEXT_56 = "_ESETFLAG;";
	protected final String TEXT_57 = NL + "\t\t\tboolean old";
	protected final String TEXT_58 = "ESet = ";
	protected final String TEXT_59 = "ESet;";
	protected final String TEXT_60 = NL + "\t\t\t";
	protected final String TEXT_61 = "ESet = false;";
	protected final String TEXT_62 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
	protected final String TEXT_63 = "(this, ";
	protected final String TEXT_64 = ".UNSET, ";
	protected final String TEXT_65 = ", null, null, old";
	protected final String TEXT_66 = "ESet));";
	protected final String TEXT_67 = NL + "\t\t}";
	protected final String TEXT_68 = NL + "\t\t";
	protected final String TEXT_69 = " old";
	protected final String TEXT_70 = " = (";
	protected final String TEXT_71 = " & ";
	protected final String TEXT_72 = "_EFLAG) != 0;";
	protected final String TEXT_73 = NL + "\t\t";
	protected final String TEXT_74 = " old";
	protected final String TEXT_75 = " = ";
	protected final String TEXT_76 = "_EFLAG_VALUES[(";
	protected final String TEXT_77 = " & ";
	protected final String TEXT_78 = "_EFLAG) >>> ";
	protected final String TEXT_79 = "_EFLAG_OFFSET];";
	protected final String TEXT_80 = NL + "\t\tObject old";
	protected final String TEXT_81 = " = eVirtualUnset(";
	protected final String TEXT_82 = ");";
	protected final String TEXT_83 = NL + "\t\t";
	protected final String TEXT_84 = " old";
	protected final String TEXT_85 = " = ";
	protected final String TEXT_86 = ";";
	protected final String TEXT_87 = NL + "\t\tboolean isSetChange = old";
	protected final String TEXT_88 = " != EVIRTUAL_NO_VALUE;";
	protected final String TEXT_89 = NL + "\t\tboolean old";
	protected final String TEXT_90 = "ESet = (";
	protected final String TEXT_91 = " & ";
	protected final String TEXT_92 = "_ESETFLAG) != 0;";
	protected final String TEXT_93 = NL + "\t\tboolean old";
	protected final String TEXT_94 = "ESet = ";
	protected final String TEXT_95 = "ESet;";
	protected final String TEXT_96 = NL + "\t\t";
	protected final String TEXT_97 = " = null;";
	protected final String TEXT_98 = NL + "\t\t";
	protected final String TEXT_99 = " &= ~";
	protected final String TEXT_100 = "_ESETFLAG;";
	protected final String TEXT_101 = NL + "\t\t";
	protected final String TEXT_102 = "ESet = false;";
	protected final String TEXT_103 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_104 = "(this, ";
	protected final String TEXT_105 = ".UNSET, ";
	protected final String TEXT_106 = ", ";
	protected final String TEXT_107 = "isSetChange ? old";
	protected final String TEXT_108 = " : null";
	protected final String TEXT_109 = "old";
	protected final String TEXT_110 = ", null, ";
	protected final String TEXT_111 = "isSetChange";
	protected final String TEXT_112 = "old";
	protected final String TEXT_113 = "ESet";
	protected final String TEXT_114 = "));";
	protected final String TEXT_115 = NL + "\t\tif (";
	protected final String TEXT_116 = ") ";
	protected final String TEXT_117 = " |= ";
	protected final String TEXT_118 = "_EFLAG; else ";
	protected final String TEXT_119 = " &= ~";
	protected final String TEXT_120 = "_EFLAG;";
	protected final String TEXT_121 = NL + "\t\t";
	protected final String TEXT_122 = " = ";
	protected final String TEXT_123 = " & ~";
	protected final String TEXT_124 = "_EFLAG | ";
	protected final String TEXT_125 = "_EFLAG_DEFAULT;";
	protected final String TEXT_126 = NL + "\t\t";
	protected final String TEXT_127 = " = ";
	protected final String TEXT_128 = ";";
	protected final String TEXT_129 = NL + "\t\t";
	protected final String TEXT_130 = " &= ~";
	protected final String TEXT_131 = "_ESETFLAG;";
	protected final String TEXT_132 = NL + "\t\t";
	protected final String TEXT_133 = "ESet = false;";
	protected final String TEXT_134 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_135 = "(this, ";
	protected final String TEXT_136 = ".UNSET, ";
	protected final String TEXT_137 = ", ";
	protected final String TEXT_138 = "isSetChange ? old";
	protected final String TEXT_139 = " : ";
	protected final String TEXT_140 = "old";
	protected final String TEXT_141 = ", ";
	protected final String TEXT_142 = ", ";
	protected final String TEXT_143 = "isSetChange";
	protected final String TEXT_144 = "old";
	protected final String TEXT_145 = "ESet";
	protected final String TEXT_146 = "));";
	protected final String TEXT_147 = NL + "\t\t((";
	protected final String TEXT_148 = ".Internal)((";
	protected final String TEXT_149 = ".Internal.Wrapper)get";
	protected final String TEXT_150 = "()).featureMap()).clear(";
	protected final String TEXT_151 = ");";
	protected final String TEXT_152 = NL + "\t\t((";
	protected final String TEXT_153 = ".Internal)get";
	protected final String TEXT_154 = "()).clear(";
	protected final String TEXT_155 = ");";
	protected final String TEXT_156 = NL + "\t\t";
	protected final String TEXT_157 = NL;
	protected final String TEXT_158 = NL + "\t}" + NL;
	protected final String TEXT_159 = NL;
	protected final String TEXT_160 = NL;
	protected final String TEXT_161 = NL;

	public InterfaceunsetGenFeatureoverride() {
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

		stringBuffer.append(TEXT_160);
		stringBuffer.append(TEXT_161);
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
		if (isInterface) {
			stringBuffer.append(TEXT_2);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.unsetGenFeature.javadoc.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_00BroGJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/unsetGenFeature.javadoc.override.javajetinc
		} else {
			stringBuffer.append(TEXT_3);
			if (isJDK50) { //Class/unsetGenFeature.annotations.insert.javajetinc
				stringBuffer.append(TEXT_4);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.unsetGenFeature.annotations.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
							"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_00VNoGJ-Ed-FqczH3ESmRw",
							new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

			}
		}
		if (!isImplementation) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genFeature.getAccessorName());
			stringBuffer.append(TEXT_6);
		} else {
			stringBuffer.append(TEXT_7);
			stringBuffer.append(genFeature.getAccessorName());
			if (genClass.hasCollidingUnsetAccessorOperation(genFeature)) {
				stringBuffer.append(TEXT_8);
			}
			stringBuffer.append(TEXT_9);
			if (genModel.isDynamicDelegation() && !genFeature.isVolatile()) {
				stringBuffer.append(TEXT_10);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				if (genClass.hasStaticFeatures()) {
					stringBuffer.append(TEXT_11);
				}
				stringBuffer.append(TEXT_12);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_13);
			} else if (genModel.isReflectiveDelegation()) {
				stringBuffer.append(TEXT_14);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_15);
			} else if (genFeature.hasSettingDelegate()) {
				stringBuffer.append(TEXT_16);
				stringBuffer.append(genFeature.getUpperName());
				stringBuffer.append(TEXT_17);
			} else if (!genFeature.isVolatile()) {
				if (genFeature.isListType()) {
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_18);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_19);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_20);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_21);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_22);
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
						stringBuffer.append(TEXT_28);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_29);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_30);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_31);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_32);
					}
					stringBuffer.append(TEXT_33);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_34);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
					stringBuffer.append(TEXT_35);
					if (!genFeature.isBidirectional()) {
						stringBuffer.append(TEXT_36);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_37);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_38);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(negativeOffsetCorrection);
						stringBuffer.append(TEXT_39);
					} else {
						GenFeature reverseFeature = genFeature.getReverse();
						GenClass targetClass = reverseFeature.getGenClass();
						String reverseOffsetCorrection = targetClass.hasOffsetCorrection()
								? " + " + genClass.getOffsetCorrectionField(genFeature)
								: "";
						stringBuffer.append(TEXT_40);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_41);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_42);
						stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
						stringBuffer.append(reverseOffsetCorrection);
						stringBuffer.append(TEXT_43);
						stringBuffer.append(targetClass.getRawImportedInterfaceName());
						stringBuffer.append(TEXT_44);
					}
					stringBuffer.append(TEXT_45);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_46);
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_47);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_48);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_49);
					} else if (genClass.isESetFlag(genFeature)) {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_50);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_51);
							stringBuffer.append(genClass.getESetFlagsField(genFeature));
							stringBuffer.append(TEXT_52);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_53);
						}
						stringBuffer.append(TEXT_54);
						stringBuffer.append(genClass.getESetFlagsField(genFeature));
						stringBuffer.append(TEXT_55);
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_56);
					} else {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_57);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_58);
							stringBuffer.append(genFeature.getUncapName());
							stringBuffer.append(TEXT_59);
						}
						stringBuffer.append(TEXT_60);
						stringBuffer.append(genFeature.getUncapName());
						stringBuffer.append(TEXT_61);
					}
					if (!genModel.isSuppressNotification()) {
						stringBuffer.append(TEXT_62);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
						stringBuffer.append(TEXT_63);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
						stringBuffer.append(TEXT_64);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_65);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_66);
					}
					stringBuffer.append(TEXT_67);
				} else {
					if (genClass.isFlag(genFeature)) {
						if (!genModel.isSuppressNotification()) {
							if (genFeature.isBooleanType()) {
								stringBuffer.append(TEXT_68);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_69);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_70);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_71);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_72);
							} else {
								stringBuffer.append(TEXT_73);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_74);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_75);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_76);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_77);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_78);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_79);
							}
						}
					} else if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_80);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_81);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_82);
					} else {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_83);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_84);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_85);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_86);
						}
					}
					if (!genModel.isSuppressNotification()) {
						if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_87);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_88);
						} else if (genClass.isESetFlag(genFeature)) {
							stringBuffer.append(TEXT_89);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_90);
							stringBuffer.append(genClass.getESetFlagsField(genFeature));
							stringBuffer.append(TEXT_91);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_92);
						} else {
							stringBuffer.append(TEXT_93);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_94);
							stringBuffer.append(genFeature.getUncapName());
							stringBuffer.append(TEXT_95);
						}
					}
					if (genFeature.isReferenceType()) {
						stringBuffer.append(TEXT_96);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_97);
						if (!genModel.isVirtualDelegation()) {
							if (genClass.isESetFlag(genFeature)) {
								stringBuffer.append(TEXT_98);
								stringBuffer.append(genClass.getESetFlagsField(genFeature));
								stringBuffer.append(TEXT_99);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_100);
							} else {
								stringBuffer.append(TEXT_101);
								stringBuffer.append(genFeature.getUncapName());
								stringBuffer.append(TEXT_102);
							}
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_103);
							stringBuffer
									.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_104);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_105);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_106);
							if (genModel.isVirtualDelegation()) {
								stringBuffer.append(TEXT_107);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_108);
							} else {
								stringBuffer.append(TEXT_109);
								stringBuffer.append(genFeature.getCapName());
							}
							stringBuffer.append(TEXT_110);
							if (genModel.isVirtualDelegation()) {
								stringBuffer.append(TEXT_111);
							} else {
								stringBuffer.append(TEXT_112);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_113);
							}
							stringBuffer.append(TEXT_114);
						}
					} else {
						if (genClass.isFlag(genFeature)) {
							if (genFeature.isBooleanType()) {
								stringBuffer.append(TEXT_115);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_116);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_117);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_118);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_119);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_120);
							} else {
								stringBuffer.append(TEXT_121);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_122);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_123);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_124);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_125);
							}
						} else if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_126);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_127);
							stringBuffer.append(genFeature.getEDefault());
							stringBuffer.append(TEXT_128);
						}
						if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
							if (genClass.isESetFlag(genFeature)) {
								stringBuffer.append(TEXT_129);
								stringBuffer.append(genClass.getESetFlagsField(genFeature));
								stringBuffer.append(TEXT_130);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_131);
							} else {
								stringBuffer.append(TEXT_132);
								stringBuffer.append(genFeature.getUncapName());
								stringBuffer.append(TEXT_133);
							}
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_134);
							stringBuffer
									.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_135);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_136);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_137);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_138);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_139);
								stringBuffer.append(genFeature.getEDefault());
							} else {
								stringBuffer.append(TEXT_140);
								stringBuffer.append(genFeature.getCapName());
							}
							stringBuffer.append(TEXT_141);
							stringBuffer.append(genFeature.getEDefault());
							stringBuffer.append(TEXT_142);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_143);
							} else {
								stringBuffer.append(TEXT_144);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_145);
							}
							stringBuffer.append(TEXT_146);
						}
					}
				}
			} else if (genFeature.hasDelegateFeature()) {
				GenFeature delegateFeature = genFeature.getDelegateFeature();
				if (delegateFeature.isWrappedFeatureMapType()) {
					stringBuffer.append(TEXT_147);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_148);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_149);
					stringBuffer.append(delegateFeature.getAccessorName());
					stringBuffer.append(TEXT_150);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_151);
				} else {
					stringBuffer.append(TEXT_152);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_153);
					stringBuffer.append(delegateFeature.getAccessorName());
					stringBuffer.append(TEXT_154);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_155);
				}
			} else if (genClass.getUnsetAccessorOperation(genFeature) != null) {
				stringBuffer.append(TEXT_156);
				stringBuffer.append(
						genClass.getUnsetAccessorOperation(genFeature).getBody(genModel.getIndentation(stringBuffer)));
			} else {
				stringBuffer.append(TEXT_157);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.unsetGenFeature.TODO.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
							"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_00eXkGJ-Ed-FqczH3ESmRw",
							new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

				//Class/unsetGenFeature.todo.override.javajetinc
			}
			stringBuffer.append(TEXT_158);
		}
		stringBuffer.append(TEXT_159);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}