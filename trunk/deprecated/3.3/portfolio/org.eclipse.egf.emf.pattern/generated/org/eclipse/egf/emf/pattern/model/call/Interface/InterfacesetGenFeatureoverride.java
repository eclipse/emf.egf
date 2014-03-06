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
	protected final String TEXT_9 = "(";
	protected final String TEXT_10 = " new";
	protected final String TEXT_11 = ")" + NL + "\t{";
	protected final String TEXT_12 = NL;
	protected final String TEXT_13 = NL + "\t\teSet(";
	protected final String TEXT_14 = ", ";
	protected final String TEXT_15 = "new ";
	protected final String TEXT_16 = "(";
	protected final String TEXT_17 = "new";
	protected final String TEXT_18 = ")";
	protected final String TEXT_19 = ");";
	protected final String TEXT_20 = NL + "\t\tif (new";
	protected final String TEXT_21 = " != eInternalContainer() || (eContainerFeatureID != ";
	protected final String TEXT_22 = " && new";
	protected final String TEXT_23 = " != null))" + NL + "\t\t{" + NL + "\t\t\tif (";
	protected final String TEXT_24 = ".isAncestor(this, ";
	protected final String TEXT_25 = "new";
	protected final String TEXT_26 = "))" + NL + "\t\t\t\tthrow new ";
	protected final String TEXT_27 = "(\"Recursive containment not allowed for \" + toString());";
	protected final String TEXT_28 = NL + "\t\t\t";
	protected final String TEXT_29 = " msgs = null;" + NL + "\t\t\tif (eInternalContainer() != null)" + NL + "\t\t\t\tmsgs = eBasicRemoveFromContainer(msgs);" + NL + "\t\t\tif (new";
	protected final String TEXT_30 = " != null)" + NL + "\t\t\t\tmsgs = ((";
	protected final String TEXT_31 = ")new";
	protected final String TEXT_32 = ").eInverseAdd(this, ";
	protected final String TEXT_33 = ", ";
	protected final String TEXT_34 = ".class, msgs);" + NL + "\t\t\tmsgs = basicSet";
	protected final String TEXT_35 = "(";
	protected final String TEXT_36 = "new";
	protected final String TEXT_37 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
	protected final String TEXT_38 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_39 = "(this, ";
	protected final String TEXT_40 = ".SET, ";
	protected final String TEXT_41 = ", new";
	protected final String TEXT_42 = ", new";
	protected final String TEXT_43 = "));";
	protected final String TEXT_44 = NL + "\t\t";
	protected final String TEXT_45 = " ";
	protected final String TEXT_46 = " = (";
	protected final String TEXT_47 = ")eVirtualGet(";
	protected final String TEXT_48 = ");";
	protected final String TEXT_49 = NL + "\t\tif (new";
	protected final String TEXT_50 = " != ";
	protected final String TEXT_51 = ")" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_52 = " msgs = null;" + NL + "\t\t\tif (";
	protected final String TEXT_53 = " != null)";
	protected final String TEXT_54 = NL + "\t\t\t\tmsgs = ((";
	protected final String TEXT_55 = ")";
	protected final String TEXT_56 = ").eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_57 = ", null, msgs);" + NL + "\t\t\tif (new";
	protected final String TEXT_58 = " != null)" + NL + "\t\t\t\tmsgs = ((";
	protected final String TEXT_59 = ")new";
	protected final String TEXT_60 = ").eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ";
	protected final String TEXT_61 = ", null, msgs);";
	protected final String TEXT_62 = NL + "\t\t\t\tmsgs = ((";
	protected final String TEXT_63 = ")";
	protected final String TEXT_64 = ").eInverseRemove(this, ";
	protected final String TEXT_65 = ", ";
	protected final String TEXT_66 = ".class, msgs);" + NL + "\t\t\tif (new";
	protected final String TEXT_67 = " != null)" + NL + "\t\t\t\tmsgs = ((";
	protected final String TEXT_68 = ")new";
	protected final String TEXT_69 = ").eInverseAdd(this, ";
	protected final String TEXT_70 = ", ";
	protected final String TEXT_71 = ".class, msgs);";
	protected final String TEXT_72 = NL + "\t\t\tmsgs = basicSet";
	protected final String TEXT_73 = "(";
	protected final String TEXT_74 = "new";
	protected final String TEXT_75 = ", msgs);" + NL + "\t\t\tif (msgs != null) msgs.dispatch();" + NL + "\t\t}";
	protected final String TEXT_76 = NL + "\t\telse" + NL + "\t\t{";
	protected final String TEXT_77 = NL + "\t\t\tboolean old";
	protected final String TEXT_78 = "ESet = eVirtualIsSet(";
	protected final String TEXT_79 = ");";
	protected final String TEXT_80 = NL + "\t\t\tboolean old";
	protected final String TEXT_81 = "ESet = (";
	protected final String TEXT_82 = " & ";
	protected final String TEXT_83 = "_ESETFLAG) != 0;";
	protected final String TEXT_84 = NL + "\t\t\t";
	protected final String TEXT_85 = " |= ";
	protected final String TEXT_86 = "_ESETFLAG;";
	protected final String TEXT_87 = NL + "\t\t\tboolean old";
	protected final String TEXT_88 = "ESet = ";
	protected final String TEXT_89 = "ESet;";
	protected final String TEXT_90 = NL + "\t\t\t";
	protected final String TEXT_91 = "ESet = true;";
	protected final String TEXT_92 = NL + "\t\t\tif (eNotificationRequired())" + NL + "\t\t\t\teNotify(new ";
	protected final String TEXT_93 = "(this, ";
	protected final String TEXT_94 = ".SET, ";
	protected final String TEXT_95 = ", new";
	protected final String TEXT_96 = ", new";
	protected final String TEXT_97 = ", !old";
	protected final String TEXT_98 = "ESet));";
	protected final String TEXT_99 = NL + "\t\t}";
	protected final String TEXT_100 = NL + "\t\telse if (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_101 = "(this, ";
	protected final String TEXT_102 = ".SET, ";
	protected final String TEXT_103 = ", new";
	protected final String TEXT_104 = ", new";
	protected final String TEXT_105 = "));";
	protected final String TEXT_106 = NL + "\t\t";
	protected final String TEXT_107 = " old";
	protected final String TEXT_108 = " = (";
	protected final String TEXT_109 = " & ";
	protected final String TEXT_110 = "_EFLAG) != 0;";
	protected final String TEXT_111 = NL + "\t\tif (new";
	protected final String TEXT_112 = ") ";
	protected final String TEXT_113 = " |= ";
	protected final String TEXT_114 = "_EFLAG; else ";
	protected final String TEXT_115 = " &= ~";
	protected final String TEXT_116 = "_EFLAG;";
	protected final String TEXT_117 = NL + "\t\t";
	protected final String TEXT_118 = " old";
	protected final String TEXT_119 = " = ";
	protected final String TEXT_120 = ";";
	protected final String TEXT_121 = NL + "\t\t";
	protected final String TEXT_122 = " ";
	protected final String TEXT_123 = " = new";
	protected final String TEXT_124 = " == null ? ";
	protected final String TEXT_125 = " : new";
	protected final String TEXT_126 = ";";
	protected final String TEXT_127 = NL + "\t\t";
	protected final String TEXT_128 = " = new";
	protected final String TEXT_129 = " == null ? ";
	protected final String TEXT_130 = " : new";
	protected final String TEXT_131 = ";";
	protected final String TEXT_132 = NL + "\t\t";
	protected final String TEXT_133 = " ";
	protected final String TEXT_134 = " = ";
	protected final String TEXT_135 = "new";
	protected final String TEXT_136 = ";";
	protected final String TEXT_137 = NL + "\t\t";
	protected final String TEXT_138 = " = ";
	protected final String TEXT_139 = "new";
	protected final String TEXT_140 = ";";
	protected final String TEXT_141 = NL + "\t\tObject old";
	protected final String TEXT_142 = " = eVirtualSet(";
	protected final String TEXT_143 = ", ";
	protected final String TEXT_144 = ");";
	protected final String TEXT_145 = NL + "\t\tboolean isSetChange = old";
	protected final String TEXT_146 = " == EVIRTUAL_NO_VALUE;";
	protected final String TEXT_147 = NL + "\t\tboolean old";
	protected final String TEXT_148 = "ESet = (";
	protected final String TEXT_149 = " & ";
	protected final String TEXT_150 = "_ESETFLAG) != 0;";
	protected final String TEXT_151 = NL + "\t\t";
	protected final String TEXT_152 = " |= ";
	protected final String TEXT_153 = "_ESETFLAG;";
	protected final String TEXT_154 = NL + "\t\tboolean old";
	protected final String TEXT_155 = "ESet = ";
	protected final String TEXT_156 = "ESet;";
	protected final String TEXT_157 = NL + "\t\t";
	protected final String TEXT_158 = "ESet = true;";
	protected final String TEXT_159 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_160 = "(this, ";
	protected final String TEXT_161 = ".SET, ";
	protected final String TEXT_162 = ", ";
	protected final String TEXT_163 = "isSetChange ? ";
	protected final String TEXT_164 = " : old";
	protected final String TEXT_165 = "old";
	protected final String TEXT_166 = ", ";
	protected final String TEXT_167 = "new";
	protected final String TEXT_168 = ", ";
	protected final String TEXT_169 = "isSetChange";
	protected final String TEXT_170 = "!old";
	protected final String TEXT_171 = "ESet";
	protected final String TEXT_172 = "));";
	protected final String TEXT_173 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t\teNotify(new ";
	protected final String TEXT_174 = "(this, ";
	protected final String TEXT_175 = ".SET, ";
	protected final String TEXT_176 = ", ";
	protected final String TEXT_177 = "old";
	protected final String TEXT_178 = " == EVIRTUAL_NO_VALUE ? ";
	protected final String TEXT_179 = " : old";
	protected final String TEXT_180 = "old";
	protected final String TEXT_181 = ", ";
	protected final String TEXT_182 = "new";
	protected final String TEXT_183 = "));";
	protected final String TEXT_184 = NL;
	protected final String TEXT_185 = NL + "\t\t((";
	protected final String TEXT_186 = ".Internal)((";
	protected final String TEXT_187 = ".Internal.Wrapper)get";
	protected final String TEXT_188 = "()).featureMap()).set(";
	protected final String TEXT_189 = ", ";
	protected final String TEXT_190 = "new ";
	protected final String TEXT_191 = "(";
	protected final String TEXT_192 = "new";
	protected final String TEXT_193 = ")";
	protected final String TEXT_194 = ");";
	protected final String TEXT_195 = NL + "\t\t((";
	protected final String TEXT_196 = ".Internal)get";
	protected final String TEXT_197 = "()).set(";
	protected final String TEXT_198 = ", ";
	protected final String TEXT_199 = "new ";
	protected final String TEXT_200 = "(";
	protected final String TEXT_201 = "new";
	protected final String TEXT_202 = ")";
	protected final String TEXT_203 = ");";
	protected final String TEXT_204 = NL;
	protected final String TEXT_205 = NL + "\t}" + NL;
	protected final String TEXT_206 = NL;
	protected final String TEXT_207 = NL;
	protected final String TEXT_208 = NL;

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
		List<Object> isInterfaceList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> isImplementationList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> publicStaticFinalFlagList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> singleWildcardList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> negativeOffsetCorrectionList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> positiveOffsetCorrectionList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genFeatureParameter : genFeatureList) {
			for (Object genClassParameter : genClassList) {
				for (Object genPackageParameter : genPackageList) {
					for (Object genModelParameter : genModelList) {
						for (Object isInterfaceParameter : isInterfaceList) {
							for (Object isImplementationParameter : isImplementationList) {
								for (Object publicStaticFinalFlagParameter : publicStaticFinalFlagList) {
									for (Object singleWildcardParameter : singleWildcardList) {
										for (Object negativeOffsetCorrectionParameter : negativeOffsetCorrectionList) {
											for (Object positiveOffsetCorrectionParameter : positiveOffsetCorrectionList) {

												this.genFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) genFeatureParameter;
												this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
												this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
												this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
												this.isInterface = (java.lang.Boolean) isInterfaceParameter;
												this.isImplementation = (java.lang.Boolean) isImplementationParameter;
												this.publicStaticFinalFlag = (java.lang.String) publicStaticFinalFlagParameter;
												this.singleWildcard = (java.lang.String) singleWildcardParameter;
												this.negativeOffsetCorrection = (java.lang.String) negativeOffsetCorrectionParameter;
												this.positiveOffsetCorrection = (java.lang.String) positiveOffsetCorrectionParameter;

												if (preCondition()) {
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
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_207);
		stringBuffer.append(TEXT_208);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("genFeature", this.genFeature);
			parameterValues.put("genClass", this.genClass);
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("isInterface", this.isInterface);
			parameterValues.put("isImplementation", this.isImplementation);
			parameterValues.put("publicStaticFinalFlag", this.publicStaticFinalFlag);
			parameterValues.put("singleWildcard", this.singleWildcard);
			parameterValues.put("negativeOffsetCorrection", this.negativeOffsetCorrection);
			parameterValues.put("positiveOffsetCorrection", this.positiveOffsetCorrection);
			String outputWithCallBack = Node.flatten(ictx.getNode());
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

	protected java.lang.Boolean isInterface = null;

	public void set_isInterface(java.lang.Boolean object) {
		this.isInterface = object;
	}

	protected java.lang.Boolean isImplementation = null;

	public void set_isImplementation(java.lang.Boolean object) {
		this.isImplementation = object;
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

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genFeature", this.genFeature);
		parameters.put("genClass", this.genClass);
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		parameters.put("isInterface", this.isInterface);
		parameters.put("isImplementation", this.isImplementation);
		parameters.put("publicStaticFinalFlag", this.publicStaticFinalFlag);
		parameters.put("singleWildcard", this.singleWildcard);
		parameters.put("negativeOffsetCorrection", this.negativeOffsetCorrection);
		parameters.put("positiveOffsetCorrection", this.positiveOffsetCorrection);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		if (isInterface) {
			stringBuffer.append(TEXT_2);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.javadoc.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0yZT8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/setGenFeature.javadoc.override.javajetinc
		} else {
			stringBuffer.append(TEXT_3);
			if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //Class/setGenFeature.annotations.insert.javajetinc
				stringBuffer.append(TEXT_4);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.annotations.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("genFeature", genFeature);
					callParameters.put("genClass", genClass);
					callParameters.put("genPackage", genPackage);
					callParameters.put("genModel", genModel);
					callParameters.put("isInterface", isInterface);
					callParameters.put("isImplementation", isImplementation);
					callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
					callParameters.put("singleWildcard", singleWildcard);
					callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
					callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
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
			stringBuffer.append(TEXT_8);
			stringBuffer.append(genFeature.getAccessorName());
			stringBuffer.append(TEXT_9);
			stringBuffer.append(genFeature.getImportedType(genClass));
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genFeature.getCapName());
			stringBuffer.append(TEXT_11);
			stringBuffer.append(TEXT_12);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.pre.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0y1Y0GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			if (genModel.isReflectiveDelegation()) {
				stringBuffer.append(TEXT_13);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_14);
				if (genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_15);
					stringBuffer.append(genFeature.getObjectType(genClass));
					stringBuffer.append(TEXT_16);
				}
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genFeature.getCapName());
				if (genFeature.isPrimitiveType()) {
					stringBuffer.append(TEXT_18);
				}
				stringBuffer.append(TEXT_19);
			} else if (!genFeature.isVolatile()) {
				if (genFeature.isContainer()) {
					GenFeature reverseFeature = genFeature.getReverse();
					GenClass targetClass = reverseFeature.getGenClass();
					String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
					stringBuffer.append(TEXT_20);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_21);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(positiveOffsetCorrection);
					stringBuffer.append(TEXT_22);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_23);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
					stringBuffer.append(TEXT_24);
					stringBuffer.append(genFeature.getEObjectCast());
					stringBuffer.append(TEXT_25);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_26);
					stringBuffer.append(genModel.getImportedName("java.lang.IllegalArgumentException"));
					stringBuffer.append(TEXT_27);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(TEXT_28);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
					stringBuffer.append(TEXT_29);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_30);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
					stringBuffer.append(TEXT_31);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_32);
					stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
					stringBuffer.append(reverseOffsetCorrection);
					stringBuffer.append(TEXT_33);
					stringBuffer.append(targetClass.getImportedInterfaceName());
					stringBuffer.append(TEXT_34);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_35);
					stringBuffer.append(genFeature.getInternalTypeCast());
					stringBuffer.append(TEXT_36);
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
						stringBuffer.append(TEXT_42);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_43);
					}
				} else if (genFeature.isBidirectional() || genFeature.isEffectiveContains()) {
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_44);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_45);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_46);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_47);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_48);
					}
					stringBuffer.append(TEXT_49);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_50);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_51);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
					stringBuffer.append(TEXT_52);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_53);
					if (!genFeature.isBidirectional()) {
						stringBuffer.append(TEXT_54);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_55);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_56);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(negativeOffsetCorrection);
						stringBuffer.append(TEXT_57);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_58);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_59);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_60);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(negativeOffsetCorrection);
						stringBuffer.append(TEXT_61);
					} else {
						GenFeature reverseFeature = genFeature.getReverse();
						GenClass targetClass = reverseFeature.getGenClass();
						String reverseOffsetCorrection = targetClass.hasOffsetCorrection() ? " + " + genClass.getOffsetCorrectionField(reverseFeature) : "";
						stringBuffer.append(TEXT_62);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_63);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_64);
						stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
						stringBuffer.append(reverseOffsetCorrection);
						stringBuffer.append(TEXT_65);
						stringBuffer.append(targetClass.getImportedInterfaceName());
						stringBuffer.append(TEXT_66);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_67);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
						stringBuffer.append(TEXT_68);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_69);
						stringBuffer.append(targetClass.getQualifiedFeatureID(reverseFeature));
						stringBuffer.append(reverseOffsetCorrection);
						stringBuffer.append(TEXT_70);
						stringBuffer.append(targetClass.getImportedInterfaceName());
						stringBuffer.append(TEXT_71);
					}
					stringBuffer.append(TEXT_72);
					stringBuffer.append(genFeature.getAccessorName());
					stringBuffer.append(TEXT_73);
					stringBuffer.append(genFeature.getInternalTypeCast());
					stringBuffer.append(TEXT_74);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_75);
					if (genFeature.isUnsettable()) {
						stringBuffer.append(TEXT_76);
						if (genModel.isVirtualDelegation()) {
							stringBuffer.append(TEXT_77);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_78);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_79);
						} else if (genClass.isESetFlag(genFeature)) {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_80);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_81);
								stringBuffer.append(genClass.getESetFlagsField(genFeature));
								stringBuffer.append(TEXT_82);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_83);
							}
							stringBuffer.append(TEXT_84);
							stringBuffer.append(genClass.getESetFlagsField(genFeature));
							stringBuffer.append(TEXT_85);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_86);
						} else {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_87);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_88);
								stringBuffer.append(genFeature.getUncapName());
								stringBuffer.append(TEXT_89);
							}
							stringBuffer.append(TEXT_90);
							stringBuffer.append(genFeature.getUncapName());
							stringBuffer.append(TEXT_91);
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_92);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_93);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_94);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_95);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_96);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_97);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_98);
						}
						stringBuffer.append(TEXT_99);
					} else {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_100);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_101);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_102);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_103);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_104);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_105);
						}
					}
				} else {
					if (genClass.isFlag(genFeature)) {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_106);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_107);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_108);
							stringBuffer.append(genClass.getFlagsField(genFeature));
							stringBuffer.append(TEXT_109);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_110);
						}
						stringBuffer.append(TEXT_111);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_112);
						stringBuffer.append(genClass.getFlagsField(genFeature));
						stringBuffer.append(TEXT_113);
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_114);
						stringBuffer.append(genClass.getFlagsField(genFeature));
						stringBuffer.append(TEXT_115);
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_116);
					} else {
						if (!genModel.isVirtualDelegation() || genFeature.isPrimitiveType()) {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_117);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_118);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_119);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_120);
							}
						}
						if (genFeature.isEnumType()) {
							if (genModel.isVirtualDelegation()) {
								stringBuffer.append(TEXT_121);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_122);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_123);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_124);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_125);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_126);
							} else {
								stringBuffer.append(TEXT_127);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_128);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_129);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_130);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_131);
							}
						} else {
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_132);
								stringBuffer.append(genFeature.getImportedType(genClass));
								stringBuffer.append(TEXT_133);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_134);
								stringBuffer.append(genFeature.getInternalTypeCast());
								stringBuffer.append(TEXT_135);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_136);
							} else {
								stringBuffer.append(TEXT_137);
								stringBuffer.append(genFeature.getSafeName());
								stringBuffer.append(TEXT_138);
								stringBuffer.append(genFeature.getInternalTypeCast());
								stringBuffer.append(TEXT_139);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_140);
							}
						}
						if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_141);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_142);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_143);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_144);
						}
					}
					if (genFeature.isUnsettable()) {
						if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
							stringBuffer.append(TEXT_145);
							stringBuffer.append(genFeature.getCapName());
							stringBuffer.append(TEXT_146);
						} else if (genClass.isESetFlag(genFeature)) {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_147);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_148);
								stringBuffer.append(genClass.getESetFlagsField(genFeature));
								stringBuffer.append(TEXT_149);
								stringBuffer.append(genFeature.getUpperName());
								stringBuffer.append(TEXT_150);
							}
							stringBuffer.append(TEXT_151);
							stringBuffer.append(genClass.getESetFlagsField(genFeature));
							stringBuffer.append(TEXT_152);
							stringBuffer.append(genFeature.getUpperName());
							stringBuffer.append(TEXT_153);
						} else {
							if (!genModel.isSuppressNotification()) {
								stringBuffer.append(TEXT_154);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_155);
								stringBuffer.append(genFeature.getUncapName());
								stringBuffer.append(TEXT_156);
							}
							stringBuffer.append(TEXT_157);
							stringBuffer.append(genFeature.getUncapName());
							stringBuffer.append(TEXT_158);
						}
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_159);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_160);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_161);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_162);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_163);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_164);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(TEXT_165);
								stringBuffer.append(genFeature.getCapName());
							}
							stringBuffer.append(TEXT_166);
							if (genClass.isFlag(genFeature)) {
								stringBuffer.append(TEXT_167);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(genFeature.getSafeName());
							}
							stringBuffer.append(TEXT_168);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_169);
							} else {
								stringBuffer.append(TEXT_170);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_171);
							}
							stringBuffer.append(TEXT_172);
						}
					} else {
						if (!genModel.isSuppressNotification()) {
							stringBuffer.append(TEXT_173);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
							stringBuffer.append(TEXT_174);
							stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
							stringBuffer.append(TEXT_175);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_176);
							if (genModel.isVirtualDelegation() && !genFeature.isPrimitiveType()) {
								stringBuffer.append(TEXT_177);
								stringBuffer.append(genFeature.getCapName());
								stringBuffer.append(TEXT_178);
								stringBuffer.append(genFeature.getEDefault());
								stringBuffer.append(TEXT_179);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(TEXT_180);
								stringBuffer.append(genFeature.getCapName());
							}
							stringBuffer.append(TEXT_181);
							if (genClass.isFlag(genFeature)) {
								stringBuffer.append(TEXT_182);
								stringBuffer.append(genFeature.getCapName());
							} else {
								stringBuffer.append(genFeature.getSafeName());
							}
							stringBuffer.append(TEXT_183);
						}
					}
				}
				stringBuffer.append(TEXT_184);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.post.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("genFeature", genFeature);
					callParameters.put("genClass", genClass);
					callParameters.put("genPackage", genPackage);
					callParameters.put("genModel", genModel);
					callParameters.put("isInterface", isInterface);
					callParameters.put("isImplementation", isImplementation);
					callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
					callParameters.put("singleWildcard", singleWildcard);
					callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
					callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
					CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0y_J0GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

			} else if (genFeature.hasDelegateFeature()) {
				GenFeature delegateFeature = genFeature.getDelegateFeature();
				if (delegateFeature.isWrappedFeatureMapType()) {
					stringBuffer.append(TEXT_185);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_186);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_187);
					stringBuffer.append(delegateFeature.getAccessorName());
					stringBuffer.append(TEXT_188);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_189);
					if (genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_190);
						stringBuffer.append(genFeature.getObjectType(genClass));
						stringBuffer.append(TEXT_191);
					}
					stringBuffer.append(TEXT_192);
					stringBuffer.append(genFeature.getCapName());
					if (genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_193);
					}
					stringBuffer.append(TEXT_194);
				} else {
					stringBuffer.append(TEXT_195);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
					stringBuffer.append(TEXT_196);
					stringBuffer.append(delegateFeature.getAccessorName());
					stringBuffer.append(TEXT_197);
					stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
					stringBuffer.append(TEXT_198);
					if (genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_199);
						stringBuffer.append(genFeature.getObjectType(genClass));
						stringBuffer.append(TEXT_200);
					}
					stringBuffer.append(TEXT_201);
					stringBuffer.append(genFeature.getCapName());
					if (genFeature.isPrimitiveType()) {
						stringBuffer.append(TEXT_202);
					}
					stringBuffer.append(TEXT_203);
				}
			} else {
				stringBuffer.append(TEXT_204);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.TODO.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("genFeature", genFeature);
					callParameters.put("genClass", genClass);
					callParameters.put("genPackage", genPackage);
					callParameters.put("genModel", genModel);
					callParameters.put("isInterface", isInterface);
					callParameters.put("isImplementation", isImplementation);
					callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
					callParameters.put("singleWildcard", singleWildcard);
					callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
					callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
					CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0y_J5WJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

				//Class/setGenFeature.todo.override.javajetinc
			}
			stringBuffer.append(TEXT_205);
		}
		stringBuffer.append(TEXT_206);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return true;
	}
}