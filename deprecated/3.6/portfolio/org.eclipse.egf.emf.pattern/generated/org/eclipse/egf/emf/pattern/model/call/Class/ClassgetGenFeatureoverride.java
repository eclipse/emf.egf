//Generated on Mon Nov 07 17:44:47 CET 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.emf.pattern.model.call.Class;

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

public class ClassgetGenFeatureoverride {
	protected static String nl;

	public static synchronized ClassgetGenFeatureoverride create(String lineSeparator) {
		nl = lineSeparator;
		ClassgetGenFeatureoverride result = new ClassgetGenFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL + "\t";
	protected final String TEXT_6 = " ";
	protected final String TEXT_7 = "();" + NL;
	protected final String TEXT_8 = NL + "\t@SuppressWarnings(\"unchecked\")";
	protected final String TEXT_9 = NL + "\tpublic ";
	protected final String TEXT_10 = " ";
	protected final String TEXT_11 = "_";
	protected final String TEXT_12 = "()" + NL + "\t{";
	protected final String TEXT_13 = NL;
	protected final String TEXT_14 = NL + "\t\treturn ";
	protected final String TEXT_15 = "(";
	protected final String TEXT_16 = "(";
	protected final String TEXT_17 = ")eDynamicGet(";
	protected final String TEXT_18 = ", ";
	protected final String TEXT_19 = ", true, ";
	protected final String TEXT_20 = ")";
	protected final String TEXT_21 = ").";
	protected final String TEXT_22 = "()";
	protected final String TEXT_23 = ";";
	protected final String TEXT_24 = NL + "\t\treturn ";
	protected final String TEXT_25 = "(";
	protected final String TEXT_26 = "(";
	protected final String TEXT_27 = ")eGet(";
	protected final String TEXT_28 = ", true)";
	protected final String TEXT_29 = ").";
	protected final String TEXT_30 = "()";
	protected final String TEXT_31 = ";";
	protected final String TEXT_32 = NL + "\t\treturn ";
	protected final String TEXT_33 = "(";
	protected final String TEXT_34 = "(";
	protected final String TEXT_35 = ")";
	protected final String TEXT_36 = "__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false)";
	protected final String TEXT_37 = ").";
	protected final String TEXT_38 = "()";
	protected final String TEXT_39 = ";";
	protected final String TEXT_40 = NL + "\t\t";
	protected final String TEXT_41 = " ";
	protected final String TEXT_42 = " = (";
	protected final String TEXT_43 = ")eVirtualGet(";
	protected final String TEXT_44 = ");";
	protected final String TEXT_45 = NL + "\t\tif (";
	protected final String TEXT_46 = " == null)" + NL + "\t\t{";
	protected final String TEXT_47 = NL + "\t\t\teVirtualSet(";
	protected final String TEXT_48 = ", ";
	protected final String TEXT_49 = " = new ";
	protected final String TEXT_50 = ");";
	protected final String TEXT_51 = NL + "\t\t\t";
	protected final String TEXT_52 = " = new ";
	protected final String TEXT_53 = ";";
	protected final String TEXT_54 = NL + "\t\t}" + NL + "\t\treturn ";
	protected final String TEXT_55 = ";";
	protected final String TEXT_56 = NL + "\t\tif (eContainerFeatureID() != ";
	protected final String TEXT_57 = ") return null;" + NL + "\t\treturn (";
	protected final String TEXT_58 = ")eContainer();";
	protected final String TEXT_59 = NL + "\t\t";
	protected final String TEXT_60 = " ";
	protected final String TEXT_61 = " = (";
	protected final String TEXT_62 = ")eVirtualGet(";
	protected final String TEXT_63 = ", ";
	protected final String TEXT_64 = ");";
	protected final String TEXT_65 = NL + "\t\tif (";
	protected final String TEXT_66 = " != null && ";
	protected final String TEXT_67 = ".eIsProxy())" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_68 = " old";
	protected final String TEXT_69 = " = (";
	protected final String TEXT_70 = ")";
	protected final String TEXT_71 = ";" + NL + "\t\t\t";
	protected final String TEXT_72 = " = ";
	protected final String TEXT_73 = "eResolveProxy(old";
	protected final String TEXT_74 = ");" + NL + "\t\t\tif (";
	protected final String TEXT_75 = " != old";
	protected final String TEXT_76 = ")" + NL + "\t\t\t{";
	protected final String TEXT_77 = NL + "\t\t\t\t";
	protected final String TEXT_78 = " new";
	protected final String TEXT_79 = " = (";
	protected final String TEXT_80 = ")";
	protected final String TEXT_81 = ";";
	protected final String TEXT_82 = NL + "\t\t\t\t";
	protected final String TEXT_83 = " msgs = old";
	protected final String TEXT_84 = ".eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_85 = ", null, null);";
	protected final String TEXT_86 = NL + "\t\t\t\t";
	protected final String TEXT_87 = " msgs =  old";
	protected final String TEXT_88 = ".eInverseRemove(this, ";
	protected final String TEXT_89 = ", ";
	protected final String TEXT_90 = ".class, null);";
	protected final String TEXT_91 = NL + "\t\t\t\tif (new";
	protected final String TEXT_92 = ".eInternalContainer() == null)" + NL + "\t\t\t\t{";
	protected final String TEXT_93 = NL + "\t\t\t\t\tmsgs = new";
	protected final String TEXT_94 = ".eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_95 = ", null, msgs);";
	protected final String TEXT_96 = NL + "\t\t\t\t\tmsgs =  new";
	protected final String TEXT_97 = ".eInverseAdd(this, ";
	protected final String TEXT_98 = ", ";
	protected final String TEXT_99 = ".class, msgs);";
	protected final String TEXT_100 = NL + "\t\t\t\t}" + NL + "\t\t\t\tif (msgs != null) msgs.dispatch();";
	protected final String TEXT_101 = NL + "\t\t\t\teVirtualSet(";
	protected final String TEXT_102 = ", ";
	protected final String TEXT_103 = ");";
	protected final String TEXT_104 = NL + "\t\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\t\teNotify(new ";
	protected final String TEXT_105 = "(this, ";
	protected final String TEXT_106 = ".RESOLVE, ";
	protected final String TEXT_107 = ", old";
	protected final String TEXT_108 = ", ";
	protected final String TEXT_109 = "));";
	protected final String TEXT_110 = NL + "\t\t\t}" + NL + "\t\t}";
	protected final String TEXT_111 = NL + "\t\treturn (";
	protected final String TEXT_112 = ")eVirtualGet(";
	protected final String TEXT_113 = ", ";
	protected final String TEXT_114 = ");";
	protected final String TEXT_115 = NL + "\t\treturn (";
	protected final String TEXT_116 = " & ";
	protected final String TEXT_117 = "_EFLAG) != 0;";
	protected final String TEXT_118 = NL + "\t\treturn ";
	protected final String TEXT_119 = "_EFLAG_VALUES[(";
	protected final String TEXT_120 = " & ";
	protected final String TEXT_121 = "_EFLAG) >>> ";
	protected final String TEXT_122 = "_EFLAG_OFFSET];";
	protected final String TEXT_123 = NL + "\t\treturn ";
	protected final String TEXT_124 = ";";
	protected final String TEXT_125 = NL + "\t\t";
	protected final String TEXT_126 = " ";
	protected final String TEXT_127 = " = basicGet";
	protected final String TEXT_128 = "();" + NL + "\t\treturn ";
	protected final String TEXT_129 = " != null && ";
	protected final String TEXT_130 = ".eIsProxy() ? ";
	protected final String TEXT_131 = "eResolveProxy((";
	protected final String TEXT_132 = ")";
	protected final String TEXT_133 = ") : ";
	protected final String TEXT_134 = ";";
	protected final String TEXT_135 = NL + "\t\treturn new ";
	protected final String TEXT_136 = "((";
	protected final String TEXT_137 = ".Internal)((";
	protected final String TEXT_138 = ".Internal.Wrapper)get";
	protected final String TEXT_139 = "()).featureMap().";
	protected final String TEXT_140 = "list(";
	protected final String TEXT_141 = "));";
	protected final String TEXT_142 = NL + "\t\treturn (";
	protected final String TEXT_143 = ")get";
	protected final String TEXT_144 = "().";
	protected final String TEXT_145 = "list(";
	protected final String TEXT_146 = ");";
	protected final String TEXT_147 = NL + "\t\treturn ((";
	protected final String TEXT_148 = ".Internal.Wrapper)get";
	protected final String TEXT_149 = "()).featureMap().list(";
	protected final String TEXT_150 = ");";
	protected final String TEXT_151 = NL + "\t\treturn get";
	protected final String TEXT_152 = "().list(";
	protected final String TEXT_153 = ");";
	protected final String TEXT_154 = NL + "\t\treturn ";
	protected final String TEXT_155 = "(";
	protected final String TEXT_156 = "(";
	protected final String TEXT_157 = ")";
	protected final String TEXT_158 = "((";
	protected final String TEXT_159 = ".Internal.Wrapper)get";
	protected final String TEXT_160 = "()).featureMap().get(";
	protected final String TEXT_161 = ", true)";
	protected final String TEXT_162 = ").";
	protected final String TEXT_163 = "()";
	protected final String TEXT_164 = ";";
	protected final String TEXT_165 = NL + "\t\treturn ";
	protected final String TEXT_166 = "(";
	protected final String TEXT_167 = "(";
	protected final String TEXT_168 = ")";
	protected final String TEXT_169 = "get";
	protected final String TEXT_170 = "().get(";
	protected final String TEXT_171 = ", true)";
	protected final String TEXT_172 = ").";
	protected final String TEXT_173 = "()";
	protected final String TEXT_174 = ";";
	protected final String TEXT_175 = NL + "\t\t";
	protected final String TEXT_176 = NL;
	protected final String TEXT_177 = NL + "\t}" + NL;
	protected final String TEXT_178 = NL;
	protected final String TEXT_179 = NL;
	protected final String TEXT_180 = NL;

	public ClassgetGenFeatureoverride() {
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
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_179);
		stringBuffer.append(TEXT_180);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		String loop = OutputManager.getOutputWithoutCallback(ictx);
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
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
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
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.getGenFeature.javadoc.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0kroEGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/getGenFeature.javadoc.override.javajetinc
		} else {
			stringBuffer.append(TEXT_3);
			if (isJDK50) { //Class/getGenFeature.annotations.insert.javajetinc
				stringBuffer.append(TEXT_4);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.getGenFeature.annotations.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
					CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0lIUFGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

			}
		}
		if (!isImplementation) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genFeature.getImportedType(genClass));
			stringBuffer.append(TEXT_6);
			stringBuffer.append(genFeature.getGetAccessor());
			stringBuffer.append(TEXT_7);
		} else {
			if (genModel.useGenerics() && ((genFeature.isContainer() || genFeature.isResolveProxies()) && !genFeature.isListType() && !(genModel.isReflectiveDelegation() && genModel.isDynamicDelegation()) && genFeature.isUncheckedCast(genClass) || genFeature.isListType() && !genFeature.isFeatureMapType() && (genModel.isReflectiveDelegation() || genModel.isVirtualDelegation() || genModel.isDynamicDelegation()) || genFeature.isListDataType() && genFeature.hasDelegateFeature() || genFeature.isListType() && genFeature.hasSettingDelegate())) {
				stringBuffer.append(TEXT_8);
			}
			stringBuffer.append(TEXT_9);
			stringBuffer.append(genFeature.getImportedType(genClass));
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genFeature.getGetAccessor());
			if (genClass.hasCollidingGetAccessorOperation(genFeature)) {
				stringBuffer.append(TEXT_11);
			}
			stringBuffer.append(TEXT_12);
			stringBuffer.append(TEXT_13);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.getGenFeature.pre.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0lSFDGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			if (genModel.isDynamicDelegation()) {
				stringBuffer.append(TEXT_14);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_15);
				}
				stringBuffer.append(TEXT_16);
				stringBuffer.append(genFeature.getObjectType(genClass));
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				stringBuffer.append(TEXT_18);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_19);
				stringBuffer.append(!genFeature.isEffectiveSuppressEMFTypes());
				stringBuffer.append(TEXT_20);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_21);
					stringBuffer.append(genFeature.getPrimitiveValueFunction());
					stringBuffer.append(TEXT_22);
				}
				stringBuffer.append(TEXT_23);
			} else if (genModel.isReflectiveDelegation()) {
				stringBuffer.append(TEXT_24);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_25);
				}
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genFeature.getObjectType(genClass));
				stringBuffer.append(TEXT_27);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_28);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_29);
					stringBuffer.append(genFeature.getPrimitiveValueFunction());
					stringBuffer.append(TEXT_30);
				}
				stringBuffer.append(TEXT_31);
			} else if (genFeature.hasSettingDelegate()) {
				stringBuffer.append(TEXT_32);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_33);
				}
				stringBuffer.append(TEXT_34);
				stringBuffer.append(genFeature.getObjectType(genClass));
				stringBuffer.append(TEXT_35);
				stringBuffer.append(genFeature.getUpperName());
				stringBuffer.append(TEXT_36);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_37);
					stringBuffer.append(genFeature.getPrimitiveValueFunction());
					stringBuffer.append(TEXT_38);
				}
				stringBuffer.append(TEXT_39);
			} else if (!genFeature.isVolatile()) {
				if (genFeature.isListType()) {
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_40);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_41);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_42);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_43);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_44);
					}
					stringBuffer.append(TEXT_45);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_46);
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_47);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_48);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_49);
						stringBuffer.append(genClass.getListConstructor(genFeature));
						stringBuffer.append(TEXT_50);
					} else {
						stringBuffer.append(TEXT_51);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_52);
						stringBuffer.append(genClass.getListConstructor(genFeature));
						stringBuffer.append(TEXT_53);
					}
					stringBuffer.append(TEXT_54);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(genFeature.isMapType() && genFeature.isEffectiveSuppressEMFTypes() ? ".map()" : "");
					stringBuffer.append(TEXT_55);
				} else if (genFeature.isContainer()) {
					stringBuffer.append(TEXT_56);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(positiveOffsetCorrection);
					stringBuffer.append(TEXT_57);
					stringBuffer.append(genFeature.getImportedType(genClass));
					stringBuffer.append(TEXT_58);
				} else {
					if (genFeature.isResolveProxies()) {
						if (genModel.isVirtualDelegation()) {
							stringBuffer.append(TEXT_59);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_60);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_61);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_62);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							if (genFeature.hasEDefault()) {
								stringBuffer.append(TEXT_63);
								stringBuffer.append(genFeature.getEDefault());
							}
							stringBuffer.append(TEXT_64);
						}
						stringBuffer.append(TEXT_65);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_66);
						stringBuffer.append(genFeature.getSafeNameAsEObject());
						stringBuffer.append(TEXT_67);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_68);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_69);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_70);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_71);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_72);
						stringBuffer.append(genFeature.getNonEObjectInternalTypeCast(genClass));
						stringBuffer.append(TEXT_73);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_74);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_75);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_76);
						if (genFeature.isEffectiveContains()) {
							stringBuffer.append(TEXT_77);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
							stringBuffer.append(TEXT_78);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_79);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
							stringBuffer.append(TEXT_80);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_81);
							if (!genFeature.isBidirectional()) {
								stringBuffer.append(TEXT_82);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
								stringBuffer.append(TEXT_83);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_84);
								stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
								stringBuffer.append(negativeOffsetCorrection);
								stringBuffer.append(TEXT_85);
							} else {
								GenFeature reverseFeature = genFeature.getReverse();
								GenClass targetClass = reverseFeature.getGenClass();
								String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(genFeature) : "";
								stringBuffer.append(TEXT_86);
								stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
								stringBuffer.append(TEXT_87);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_88);
								stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
								stringBuffer.append(reverseOffsetCorrection);
								stringBuffer.append(TEXT_89);
								stringBuffer.append(targetClass.getRawImportedInterfaceName());
								stringBuffer.append(TEXT_90);
							}
							stringBuffer.append(TEXT_91);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_92);
							if (!genFeature.isBidirectional()) {
								stringBuffer.append(TEXT_93);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_94);
								stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
								stringBuffer.append(negativeOffsetCorrection);
								stringBuffer.append(TEXT_95);
							} else {
								GenFeature reverseFeature = genFeature.getReverse();
								GenClass targetClass = reverseFeature.getGenClass();
								String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(genFeature) : "";
								stringBuffer.append(TEXT_96);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_97);
								stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
								stringBuffer.append(reverseOffsetCorrection);
								stringBuffer.append(TEXT_98);
								stringBuffer.append(targetClass.getRawImportedInterfaceName());
								stringBuffer.append(TEXT_99);
							}
							stringBuffer.append(TEXT_100);
						} else if (genModel.isVirtualDelegation()) {
							stringBuffer.append(TEXT_101);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_102);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_103);
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_104);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_105);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_106);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_107);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_108);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_109);
						}
						stringBuffer.append(TEXT_110);
					}
					if (!genFeature.isResolveProxies() && genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_111);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_112);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						if (genFeature.hasEDefault()) {
							stringBuffer.append(TEXT_113);
							stringBuffer.append(genFeature.getEDefault());
						}
						stringBuffer.append(TEXT_114);
					} else if (genClass.isFlag(genFeature)) {
						if (genFeature.isBooleanType()) {
							stringBuffer.append(TEXT_115);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_116);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_117);
						} else {
							stringBuffer.append(TEXT_118);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_119);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_120);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_121);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_122);
						}
					} else {
						stringBuffer.append(TEXT_123);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_124);
					}
				}
			} else {//volatile
				if (genFeature.isResolveProxies() && !genFeature.isListType()) {
					stringBuffer.append(TEXT_125);
					stringBuffer.append(genFeature.getImportedType(genClass));
					stringBuffer.append(TEXT_126);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_127);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_128);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_129);
					stringBuffer.append(genFeature.getSafeNameAsEObject());
					stringBuffer.append(TEXT_130);
					stringBuffer.append(genFeature.getNonEObjectInternalTypeCast(genClass));
					stringBuffer.append(TEXT_131);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
					stringBuffer.append(TEXT_132);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_133);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_134);
				} else if (genFeature.hasDelegateFeature()) {
					GenFeature delegateFeature = genFeature.getDelegateFeature();
					if (genFeature.isFeatureMapType()) {
						String featureMapEntryTemplateArgument = isJDK50 ? "<" + genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap") + ".Entry>" : "";
						if (delegateFeature.isWrappedFeatureMapType()) {
							stringBuffer.append(TEXT_135);
							stringBuffer.append(genFeature.getImportedEffectiveFeatureMapWrapperClass());
							stringBuffer.append(TEXT_136);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
							stringBuffer.append(TEXT_137);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
							stringBuffer.append(TEXT_138);
							stringBuffer.append(delegateFeature.getAccessorName());
							stringBuffer.append(TEXT_139);
							stringBuffer.append(featureMapEntryTemplateArgument);
							stringBuffer.append(TEXT_140);
							stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
							stringBuffer.append(TEXT_141);
						} else {
							stringBuffer.append(TEXT_142);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
							stringBuffer.append(TEXT_143);
							stringBuffer.append(delegateFeature.getAccessorName());
							stringBuffer.append(TEXT_144);
							stringBuffer.append(featureMapEntryTemplateArgument);
							stringBuffer.append(TEXT_145);
							stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
							stringBuffer.append(TEXT_146);
						}
					} else if (genFeature.isListType()) {
						if (delegateFeature.isWrappedFeatureMapType()) {
							stringBuffer.append(TEXT_147);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
							stringBuffer.append(TEXT_148);
							stringBuffer.append(delegateFeature.getAccessorName());
							stringBuffer.append(TEXT_149);
							stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
							stringBuffer.append(TEXT_150);
						} else {
							stringBuffer.append(TEXT_151);
							stringBuffer.append(delegateFeature.getAccessorName());
							stringBuffer.append(TEXT_152);
							stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
							stringBuffer.append(TEXT_153);
						}
					} else {
						if (delegateFeature.isWrappedFeatureMapType()) {
							stringBuffer.append(TEXT_154);
							if (!isJDK50 && genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_155);
							}
							if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType()) {
								stringBuffer.append(TEXT_156);
								stringBuffer.append(genFeature.getObjectType(genClass));
								stringBuffer.append(TEXT_157);
							}
							stringBuffer.append(TEXT_158);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
							stringBuffer.append(TEXT_159);
							stringBuffer.append(delegateFeature.getAccessorName());
							stringBuffer.append(TEXT_160);
							stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
							stringBuffer.append(TEXT_161);
							if (!isJDK50 && genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_162);
								stringBuffer.append(genFeature.getPrimitiveValueFunction());
								stringBuffer.append(TEXT_163);
							}
							stringBuffer.append(TEXT_164);
						} else {
							stringBuffer.append(TEXT_165);
							if (!isJDK50 && genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_166);
							}
							if (genFeature.getTypeGenDataType() == null || !genFeature.getTypeGenDataType().isObjectType()) {
								stringBuffer.append(TEXT_167);
								stringBuffer.append(genFeature.getObjectType(genClass));
								stringBuffer.append(TEXT_168);
							}
							stringBuffer.append(TEXT_169);
							stringBuffer.append(delegateFeature.getAccessorName());
							stringBuffer.append(TEXT_170);
							stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
							stringBuffer.append(TEXT_171);
							if (!isJDK50 && genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_172);
								stringBuffer.append(genFeature.getPrimitiveValueFunction());
								stringBuffer.append(TEXT_173);
							}
							stringBuffer.append(TEXT_174);
						}
					}
				} else if (genClass.getGetAccessorOperation(genFeature) != null) {
					stringBuffer.append(TEXT_175);
					stringBuffer.append(genClass.getGetAccessorOperation(genFeature).getBody(genModel.getIndentation(stringBuffer)));
				} else {
					stringBuffer.append(TEXT_176);
					{
						//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Class.Class.getGenFeature.TODO.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
						CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0lbPAWJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
						stringBuffer.setLength(0);
					}

					//Class/getGenFeature.todo.override.javajetinc
				}
			}
			stringBuffer.append(TEXT_177);
		}
		stringBuffer.append(TEXT_178);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	public boolean preCondition() {
		return true;
	}
}