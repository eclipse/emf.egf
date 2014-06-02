//Generated on Mon Jun 02 19:03:22 CEST 2014 with EGF 1.1.0.qualifier
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
	protected final String TEXT_3 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL + "\tvoid set";
	protected final String TEXT_6 = "(";
	protected final String TEXT_7 = " value);" + NL;
	protected final String TEXT_8 = NL + "\tpublic void set";
	protected final String TEXT_9 = "_";
	protected final String TEXT_10 = "(";
	protected final String TEXT_11 = " ";
	protected final String TEXT_12 = ")" + NL + "\t{";
	protected final String TEXT_13 = NL;
	protected final String TEXT_14 = NL + "\t\teDynamicSet(";
	protected final String TEXT_15 = " - ESTATIC_FEATURE_COUNT";
	protected final String TEXT_16 = ", ";
	protected final String TEXT_17 = ", ";
	protected final String TEXT_18 = "new ";
	protected final String TEXT_19 = "(";
	protected final String TEXT_20 = "new";
	protected final String TEXT_21 = ")";
	protected final String TEXT_22 = ");";
	protected final String TEXT_23 = NL + "\t\teSet(";
	protected final String TEXT_24 = ", ";
	protected final String TEXT_25 = "new ";
	protected final String TEXT_26 = "(";
	protected final String TEXT_27 = "new";
	protected final String TEXT_28 = ")";
	protected final String TEXT_29 = ");";
	protected final String TEXT_30 = NL + "\t\t";
	protected final String TEXT_31 = "__ESETTING_DELEGATE.dynamicSet(this, null, 0, ";
	protected final String TEXT_32 = "new ";
	protected final String TEXT_33 = "(";
	protected final String TEXT_34 = "new";
	protected final String TEXT_35 = ")";
	protected final String TEXT_36 = ");";
	protected final String TEXT_37 = NL + "\t\tif (new";
	protected final String TEXT_38 = " != eInternalContainer() || (eContainerFeatureID() != ";
	protected final String TEXT_39 = " && new";
	protected final String TEXT_40 = " != null))" + NL + "\t\t{" + NL + "\t\t\tif (";
	protected final String TEXT_41 = ".isAncestor(this, ";
	protected final String TEXT_42 = "new";
	protected final String TEXT_43 = "))" + NL + "\t\t\t\tthrow new ";
	protected final String TEXT_44 = "(\"Recursive containment not allowed for \" + toString());";
	protected final String TEXT_45 = NL + "\t\t\t";
	protected final String TEXT_46 = " msgs = null;" + NL + "\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\tmsgs = eBasicRemoveFromContainer(msgs);" + NL + "\t\t\tif (new";
	protected final String TEXT_47 = " != null)" + NL + "\t\t\t\tmsgs = ((";
	protected final String TEXT_48 = ")new";
	protected final String TEXT_49 = ").eInverseAdd(this, ";
	protected final String TEXT_50 = ", ";
	protected final String TEXT_51 = ".class, msgs);" + NL + "\t\t\tmsgs = basicSet";
	protected final String TEXT_52 = "(";
	protected final String TEXT_53 = "new";
	protected final String TEXT_54 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
	protected final String TEXT_55 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_56 = "(this, ";
	protected final String TEXT_57 = ".SET, ";
	protected final String TEXT_58 = ", new";
	protected final String TEXT_59 = ", new";
	protected final String TEXT_60 = "));";
	protected final String TEXT_61 = NL + "\t\t";
	protected final String TEXT_62 = " ";
	protected final String TEXT_63 = " = (";
	protected final String TEXT_64 = ")eVirtualGet(";
	protected final String TEXT_65 = ");";
	protected final String TEXT_66 = NL + "\t\tif (new";
	protected final String TEXT_67 = " != ";
	protected final String TEXT_68 = ")" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_69 = " msgs = null;" + NL + "\t\t\tif (";
	protected final String TEXT_70 = " != null)";
	protected final String TEXT_71 = NL + "\t\t\t\tmsgs = ((";
	protected final String TEXT_72 = ")";
	protected final String TEXT_73 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_74 = ", null, msgs);" + NL + "\t\t\tif (new";
	protected final String TEXT_75 = " != null)" + NL + "\t\t\t\tmsgs = ((";
	protected final String TEXT_76 = ")new";
	protected final String TEXT_77 = ").eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_78 = ", null, msgs);";
	protected final String TEXT_79 = NL + "\t\t\t\tmsgs = ((";
	protected final String TEXT_80 = ")";
	protected final String TEXT_81 = ").eInverseRemove(this, ";
	protected final String TEXT_82 = ", ";
	protected final String TEXT_83 = ".class, msgs);" + NL + "\t\t\tif (new";
	protected final String TEXT_84 = " != null)" + NL + "\t\t\t\tmsgs = ((";
	protected final String TEXT_85 = ")new";
	protected final String TEXT_86 = ").eInverseAdd(this, ";
	protected final String TEXT_87 = ", ";
	protected final String TEXT_88 = ".class, msgs);";
	protected final String TEXT_89 = NL + "\t\t\tmsgs = basicSet";
	protected final String TEXT_90 = "(";
	protected final String TEXT_91 = "new";
	protected final String TEXT_92 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
	protected final String TEXT_93 = NL + "\t\telse" + NL + "\t\t{";
	protected final String TEXT_94 = NL + "\t\t\tboolean old";
	protected final String TEXT_95 = "ESet = eVirtualIsSet(";
	protected final String TEXT_96 = ");";
	protected final String TEXT_97 = NL + "\t\t\tboolean old";
	protected final String TEXT_98 = "ESet = (";
	protected final String TEXT_99 = " & ";
	protected final String TEXT_100 = "_ESETFLAG) != 0;";
	protected final String TEXT_101 = NL + "\t\t\t";
	protected final String TEXT_102 = " |= ";
	protected final String TEXT_103 = "_ESETFLAG;";
	protected final String TEXT_104 = NL + "\t\t\tboolean old";
	protected final String TEXT_105 = "ESet = ";
	protected final String TEXT_106 = "ESet;";
	protected final String TEXT_107 = NL + "\t\t\t";
	protected final String TEXT_108 = "ESet = true;";
	protected final String TEXT_109 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
	protected final String TEXT_110 = "(this, ";
	protected final String TEXT_111 = ".SET, ";
	protected final String TEXT_112 = ", new";
	protected final String TEXT_113 = ", new";
	protected final String TEXT_114 = ", !old";
	protected final String TEXT_115 = "ESet));";
	protected final String TEXT_116 = NL + "\t\t}";
	protected final String TEXT_117 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_118 = "(this, ";
	protected final String TEXT_119 = ".SET, ";
	protected final String TEXT_120 = ", new";
	protected final String TEXT_121 = ", new";
	protected final String TEXT_122 = "));";
	protected final String TEXT_123 = NL + "\t\t";
	protected final String TEXT_124 = " old";
	protected final String TEXT_125 = " = (";
	protected final String TEXT_126 = " & ";
	protected final String TEXT_127 = "_EFLAG) != 0;";
	protected final String TEXT_128 = NL + "\t\t";
	protected final String TEXT_129 = " old";
	protected final String TEXT_130 = " = ";
	protected final String TEXT_131 = "_EFLAG_VALUES[(";
	protected final String TEXT_132 = " & ";
	protected final String TEXT_133 = "_EFLAG) >>> ";
	protected final String TEXT_134 = "_EFLAG_OFFSET];";
	protected final String TEXT_135 = NL + "\t\tif (new";
	protected final String TEXT_136 = ") ";
	protected final String TEXT_137 = " |= ";
	protected final String TEXT_138 = "_EFLAG; else ";
	protected final String TEXT_139 = " &= ~";
	protected final String TEXT_140 = "_EFLAG;";
	protected final String TEXT_141 = NL + "\t\tif (new";
	protected final String TEXT_142 = " == null) new";
	protected final String TEXT_143 = " = ";
	protected final String TEXT_144 = "_EDEFAULT;" + NL + "\t\t";
	protected final String TEXT_145 = " = ";
	protected final String TEXT_146 = " & ~";
	protected final String TEXT_147 = "_EFLAG | ";
	protected final String TEXT_148 = "new";
	protected final String TEXT_149 = ".ordinal()";
	protected final String TEXT_150 = ".VALUES.indexOf(new";
	protected final String TEXT_151 = ")";
	protected final String TEXT_152 = " << ";
	protected final String TEXT_153 = "_EFLAG_OFFSET;";
	protected final String TEXT_154 = NL + "\t\t";
	protected final String TEXT_155 = " old";
	protected final String TEXT_156 = " = ";
	protected final String TEXT_157 = ";";
	protected final String TEXT_158 = NL + "\t\t";
	protected final String TEXT_159 = " ";
	protected final String TEXT_160 = " = new";
	protected final String TEXT_161 = " == null ? ";
	protected final String TEXT_162 = " : new";
	protected final String TEXT_163 = ";";
	protected final String TEXT_164 = NL + "\t\t";
	protected final String TEXT_165 = " = new";
	protected final String TEXT_166 = " == null ? ";
	protected final String TEXT_167 = " : new";
	protected final String TEXT_168 = ";";
	protected final String TEXT_169 = NL + "\t\t";
	protected final String TEXT_170 = " ";
	protected final String TEXT_171 = " = ";
	protected final String TEXT_172 = "new";
	protected final String TEXT_173 = ";";
	protected final String TEXT_174 = NL + "\t\t";
	protected final String TEXT_175 = " = ";
	protected final String TEXT_176 = "new";
	protected final String TEXT_177 = ";";
	protected final String TEXT_178 = NL + "\t\tObject old";
	protected final String TEXT_179 = " = eVirtualSet(";
	protected final String TEXT_180 = ", ";
	protected final String TEXT_181 = ");";
	protected final String TEXT_182 = NL + "\t\tboolean isSetChange = old";
	protected final String TEXT_183 = " == EVIRTUAL_NO_VALUE;";
	protected final String TEXT_184 = NL + "\t\tboolean old";
	protected final String TEXT_185 = "ESet = (";
	protected final String TEXT_186 = " & ";
	protected final String TEXT_187 = "_ESETFLAG) != 0;";
	protected final String TEXT_188 = NL + "\t\t";
	protected final String TEXT_189 = " |= ";
	protected final String TEXT_190 = "_ESETFLAG;";
	protected final String TEXT_191 = NL + "\t\tboolean old";
	protected final String TEXT_192 = "ESet = ";
	protected final String TEXT_193 = "ESet;";
	protected final String TEXT_194 = NL + "\t\t";
	protected final String TEXT_195 = "ESet = true;";
	protected final String TEXT_196 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_197 = "(this, ";
	protected final String TEXT_198 = ".SET, ";
	protected final String TEXT_199 = ", ";
	protected final String TEXT_200 = "isSetChange ? ";
	protected final String TEXT_201 = " : old";
	protected final String TEXT_202 = "old";
	protected final String TEXT_203 = ", ";
	protected final String TEXT_204 = "new";
	protected final String TEXT_205 = ", ";
	protected final String TEXT_206 = "isSetChange";
	protected final String TEXT_207 = "!old";
	protected final String TEXT_208 = "ESet";
	protected final String TEXT_209 = "));";
	protected final String TEXT_210 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_211 = "(this, ";
	protected final String TEXT_212 = ".SET, ";
	protected final String TEXT_213 = ", ";
	protected final String TEXT_214 = "old";
	protected final String TEXT_215 = " == EVIRTUAL_NO_VALUE ? ";
	protected final String TEXT_216 = " : old";
	protected final String TEXT_217 = "old";
	protected final String TEXT_218 = ", ";
	protected final String TEXT_219 = "new";
	protected final String TEXT_220 = "));";
	protected final String TEXT_221 = NL;
	protected final String TEXT_222 = NL + "\t\t((";
	protected final String TEXT_223 = ".Internal)((";
	protected final String TEXT_224 = ".Internal.Wrapper)get";
	protected final String TEXT_225 = "()).featureMap()).set(";
	protected final String TEXT_226 = ", ";
	protected final String TEXT_227 = "new ";
	protected final String TEXT_228 = "(";
	protected final String TEXT_229 = "new";
	protected final String TEXT_230 = ")";
	protected final String TEXT_231 = ");";
	protected final String TEXT_232 = NL + "\t\t((";
	protected final String TEXT_233 = ".Internal)get";
	protected final String TEXT_234 = "()).set(";
	protected final String TEXT_235 = ", ";
	protected final String TEXT_236 = "new ";
	protected final String TEXT_237 = "(";
	protected final String TEXT_238 = "new";
	protected final String TEXT_239 = ")";
	protected final String TEXT_240 = ");";
	protected final String TEXT_241 = NL + "\t\t";
	protected final String TEXT_242 = NL;
	protected final String TEXT_243 = NL + "\t}" + NL;
	protected final String TEXT_244 = NL;
	protected final String TEXT_245 = NL;
	protected final String TEXT_246 = NL;

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
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_245);
		stringBuffer.append(TEXT_246);
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
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.javadoc.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0yZT8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/setGenFeature.javadoc.override.javajetinc
		} else {
			stringBuffer.append(TEXT_3);
			if (isJDK50) { //Class/setGenFeature.annotations.insert.javajetinc
				stringBuffer.append(TEXT_4);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.annotations.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
					CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0ysO4GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

			}
		}
		if (!isImplementation) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genFeature.getAccessorName());
			stringBuffer.append(TEXT_6);
			stringBuffer.append(genFeature.getImportedType(genClass));
			stringBuffer.append(TEXT_7);
		} else {
			GenOperation setAccessorOperation = genClass.getSetAccessorOperation(genFeature);
			stringBuffer.append(TEXT_8);
			stringBuffer.append(genFeature.getAccessorName());
			if (genClass.hasCollidingSetAccessorOperation(genFeature)) {
				stringBuffer.append(TEXT_9);
			}
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genFeature.getImportedType(genClass));
			stringBuffer.append(TEXT_11);
			stringBuffer.append(setAccessorOperation == null ? "new" + genFeature.getCapName() : setAccessorOperation.getGenParameters().get(0).getName());
			stringBuffer.append(TEXT_12);
			stringBuffer.append(TEXT_13);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.pre.insert" args="setAccessorOperation:setAccessorOperation,genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
				callParameters.put("isGWT", isGWT);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				callParameters.put("negativeOperationOffsetCorrection", negativeOperationOffsetCorrection);
				callParameters.put("positiveOperationOffsetCorrection", positiveOperationOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0y1Y0GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			if (genModel.isDynamicDelegation()) {
				stringBuffer.append(TEXT_14);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				if (genClass.hasStaticFeatures()) {
					stringBuffer.append(TEXT_15);
				}
				stringBuffer.append(TEXT_16);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_17);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_18);
					stringBuffer.append(genFeature.getObjectType(genClass));
					stringBuffer.append(TEXT_19);
				}
				stringBuffer.append(TEXT_20);
				stringBuffer.append(genFeature.getCapName());
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_21);
				}
				stringBuffer.append(TEXT_22);
			} else if (genModel.isReflectiveDelegation()) {
				stringBuffer.append(TEXT_23);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_24);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_25);
					stringBuffer.append(genFeature.getObjectType(genClass));
					stringBuffer.append(TEXT_26);
				}
				stringBuffer.append(TEXT_27);
				stringBuffer.append(genFeature.getCapName());
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_28);
				}
				stringBuffer.append(TEXT_29);
			} else if (genFeature.hasSettingDelegate()) {
				stringBuffer.append(TEXT_30);
				stringBuffer.append(genFeature.getUpperName());
				stringBuffer.append(TEXT_31);
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_32);
					stringBuffer.append(genFeature.getObjectType(genClass));
					stringBuffer.append(TEXT_33);
				}
				stringBuffer.append(TEXT_34);
				stringBuffer.append(genFeature.getCapName());
				if (!isJDK50 && genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_35);
				}
				stringBuffer.append(TEXT_36);
			} else if (!genFeature.isVolatile()) {
				if (genFeature.isContainer()) {
					GenFeature reverseFeature = genFeature.getReverse();
					GenClass targetClass = reverseFeature.getGenClass();
					String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(genFeature) : "";
					stringBuffer.append(TEXT_37);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_38);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(positiveOffsetCorrection);
					stringBuffer.append(TEXT_39);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_40);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
					stringBuffer.append(TEXT_41);
					stringBuffer.append(genFeature.getEObjectCast());
					stringBuffer.append(TEXT_42);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_43);
					stringBuffer.append(genModel.getImportedName("java.lang.IllegalArgumentException"));
					stringBuffer.append(TEXT_44);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(TEXT_45);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
					stringBuffer.append(TEXT_46);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_47);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
					stringBuffer.append(TEXT_48);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_49);
					stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
					stringBuffer.append(reverseOffsetCorrection);
					stringBuffer.append(TEXT_50);
					stringBuffer.append(targetClass.getRawImportedInterfaceName());
					stringBuffer.append(TEXT_51);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_52);
					stringBuffer.append(genFeature.getInternalTypeCast());
					stringBuffer.append(TEXT_53);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_54);
					if (!genModel.isSuppressNotification()) {
						stringBuffer.append(TEXT_55);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
						stringBuffer.append(TEXT_56);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
						stringBuffer.append(TEXT_57);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_58);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_59);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_60);
					}
				} else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_61);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_62);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_63);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_64);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_65);
					}
					stringBuffer.append(TEXT_66);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_67);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_68);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
					stringBuffer.append(TEXT_69);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_70);
					if (!genFeature.isBidirectional()) {
						stringBuffer.append(TEXT_71);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_72);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_73);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(negativeOffsetCorrection);
						stringBuffer.append(TEXT_74);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_75);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_76);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_77);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(negativeOffsetCorrection);
						stringBuffer.append(TEXT_78);
					} else {
						GenFeature reverseFeature = genFeature.getReverse();
						GenClass targetClass = reverseFeature.getGenClass();
						String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(genFeature) : "";
						stringBuffer.append(TEXT_79);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_80);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_81);
						stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
						stringBuffer.append(reverseOffsetCorrection);
						stringBuffer.append(TEXT_82);
						stringBuffer.append(targetClass.getRawImportedInterfaceName());
						stringBuffer.append(TEXT_83);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_84);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_85);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_86);
						stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
						stringBuffer.append(reverseOffsetCorrection);
						stringBuffer.append(TEXT_87);
						stringBuffer.append(targetClass.getRawImportedInterfaceName());
						stringBuffer.append(TEXT_88);
					}
					stringBuffer.append(TEXT_89);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_90);
					stringBuffer.append(genFeature.getInternalTypeCast());
					stringBuffer.append(TEXT_91);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_92);
					if (genFeature.isUnsettable()) {
						stringBuffer.append(TEXT_93);
						if (genModel.isVirtualDelegation()) {
							stringBuffer.append(TEXT_94);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_95);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_96);
						} else if (genClass.isESetFlag(genFeature)) {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_97);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_98);
								stringBuffer.append(genClass.getESetFlagsField(genFeature));
								stringBuffer.append(TEXT_99);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_100);
							}
							stringBuffer.append(TEXT_101);
							stringBuffer.append(genClass.getESetFlagsField(genFeature));
							stringBuffer.append(TEXT_102);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_103);
						} else {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_104);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_105);
								stringBuffer.append(genFeature.getUncapName());
								stringBuffer.append(TEXT_106);
							}
							stringBuffer.append(TEXT_107);
							stringBuffer.append(genFeature.getUncapName());
							stringBuffer.append(TEXT_108);
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_109);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_110);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_111);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_112);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_113);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_114);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_115);
						}
						stringBuffer.append(TEXT_116);
					} else {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_117);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_118);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_119);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_120);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_121);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_122);
						}
					}
				} else {
					if (genClass.isFlag(genFeature)) {
						if (!genModel.isSuppressNotification()) {
							if (genFeature.isBooleanType()) {
								stringBuffer.append(TEXT_123);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_124);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_125);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_126);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_127);
							} else {
								stringBuffer.append(TEXT_128);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_129);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_130);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_131);
								stringBuffer.append(genClass.getFlagsField(genFeature));
								stringBuffer.append(TEXT_132);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_133);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_134);
							}
						}
						if (genFeature.isBooleanType()) {
							stringBuffer.append(TEXT_135);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_136);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_137);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_138);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_139);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_140);
						} else {
							stringBuffer.append(TEXT_141);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_142);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_143);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_144);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_145);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_146);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_147);
							if (isJDK50) {
								stringBuffer.append(TEXT_148);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_149);
							} else {
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_150);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_151);
							}
							stringBuffer.append(TEXT_152);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_153);
						}
					} else {
						if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_154);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_155);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_156);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_157);
							}
						}
						if (genFeature.isEnumType()) {
							if (genModel.isVirtualDelegation()) {
								stringBuffer.append(TEXT_158);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_159);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_160);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_161);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_162);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_163);
							} else {
								stringBuffer.append(TEXT_164);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_165);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_166);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_167);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_168);
							}
						} else {
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_169);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_170);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_171);
								stringBuffer.append(genFeature.getInternalTypeCast());
								stringBuffer.append(TEXT_172);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_173);
							} else {
								stringBuffer.append(TEXT_174);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_175);
								stringBuffer.append(genFeature.getInternalTypeCast());
								stringBuffer.append(TEXT_176);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_177);
							}
						}
						if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_178);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_179);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_180);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_181);
						}
					}
					if (genFeature.isUnsettable()) {
						if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_182);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_183);
						} else if (genClass.isESetFlag(genFeature)) {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_184);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_185);
								stringBuffer.append(genClass.getESetFlagsField(genFeature));
								stringBuffer.append(TEXT_186);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_187);
							}
							stringBuffer.append(TEXT_188);
							stringBuffer.append(genClass.getESetFlagsField(genFeature));
							stringBuffer.append(TEXT_189);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_190);
						} else {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_191);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_192);
								stringBuffer.append(genFeature.getUncapName());
								stringBuffer.append(TEXT_193);
							}
							stringBuffer.append(TEXT_194);
							stringBuffer.append(genFeature.getUncapName());
							stringBuffer.append(TEXT_195);
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_196);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_197);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_198);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_199);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_200);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_201);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(TEXT_202);
								stringBuffer.append(genFeature.getCapName());
							}
							stringBuffer.append(TEXT_203);
							if (genClass.isFlag(genFeature)) {
								stringBuffer.append(TEXT_204);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(genFeature.getSafeName());
							}
							stringBuffer.append(TEXT_205);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_206);
							} else {
								stringBuffer.append(TEXT_207);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_208);
							}
							stringBuffer.append(TEXT_209);
						}
					} else {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_210);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_211);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_212);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_213);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_214);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_215);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_216);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(TEXT_217);
								stringBuffer.append(genFeature.getCapName());
							}
							stringBuffer.append(TEXT_218);
							if (genClass.isFlag(genFeature)) {
								stringBuffer.append(TEXT_219);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(genFeature.getSafeName());
							}
							stringBuffer.append(TEXT_220);
						}
					}
				}
				stringBuffer.append(TEXT_221);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.post.insert" args="setAccessorOperation:setAccessorOperation,genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
					callParameters.put("isGWT", isGWT);
					callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
					callParameters.put("singleWildcard", singleWildcard);
					callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
					callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
					callParameters.put("negativeOperationOffsetCorrection", negativeOperationOffsetCorrection);
					callParameters.put("positiveOperationOffsetCorrection", positiveOperationOffsetCorrection);
					CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0y_J0GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

			} else if (genFeature.hasDelegateFeature()) {
				GenFeature delegateFeature = genFeature.getDelegateFeature();
				if (delegateFeature.isWrappedFeatureMapType()) {
					stringBuffer.append(TEXT_222);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_223);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_224);
					stringBuffer.append(delegateFeature.getAccessorName());
					stringBuffer.append(TEXT_225);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_226);
					if (!isJDK50 && genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_227);
						stringBuffer.append(genFeature.getObjectType(genClass));
						stringBuffer.append(TEXT_228);
					}
					stringBuffer.append(TEXT_229);
					stringBuffer.append(genFeature.getCapName());
					if (!isJDK50 && genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_230);
					}
					stringBuffer.append(TEXT_231);
				} else {
					stringBuffer.append(TEXT_232);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_233);
					stringBuffer.append(delegateFeature.getAccessorName());
					stringBuffer.append(TEXT_234);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_235);
					if (!isJDK50 && genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_236);
						stringBuffer.append(genFeature.getObjectType(genClass));
						stringBuffer.append(TEXT_237);
					}
					stringBuffer.append(TEXT_238);
					stringBuffer.append(genFeature.getCapName());
					if (!isJDK50 && genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_239);
					}
					stringBuffer.append(TEXT_240);
				}
			} else if (setAccessorOperation != null) {
				stringBuffer.append(TEXT_241);
				stringBuffer.append(setAccessorOperation.getBody(genModel.getIndentation(stringBuffer)));
			} else {
				stringBuffer.append(TEXT_242);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.TODO.override" args="setAccessorOperation:setAccessorOperation,genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
					callParameters.put("isGWT", isGWT);
					callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
					callParameters.put("singleWildcard", singleWildcard);
					callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
					callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
					callParameters.put("negativeOperationOffsetCorrection", negativeOperationOffsetCorrection);
					callParameters.put("positiveOperationOffsetCorrection", positiveOperationOffsetCorrection);
					CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0y_J5WJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

				//Class/setGenFeature.todo.override.javajetinc
			}
			stringBuffer.append(TEXT_243);
		}
		stringBuffer.append(TEXT_244);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}