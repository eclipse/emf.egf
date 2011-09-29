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

public class InterfacebasicSetGenFeatureoverride {
	protected static String nl;

	public static synchronized InterfacebasicSetGenFeatureoverride create(String lineSeparator) {
		nl = lineSeparator;
		InterfacebasicSetGenFeatureoverride result = new InterfacebasicSetGenFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL + "\tpublic ";
	protected final String TEXT_4 = " basicSet";
	protected final String TEXT_5 = "(";
	protected final String TEXT_6 = " new";
	protected final String TEXT_7 = ", ";
	protected final String TEXT_8 = " msgs)" + NL + "\t{";
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = NL + "\t\tmsgs = eBasicSetContainer((";
	protected final String TEXT_11 = ")new";
	protected final String TEXT_12 = ", ";
	protected final String TEXT_13 = ", msgs);";
	protected final String TEXT_14 = NL;
	protected final String TEXT_15 = NL + "\t\treturn msgs;";
	protected final String TEXT_16 = NL;
	protected final String TEXT_17 = NL + "\t\tmsgs = eDynamicInverseAdd((";
	protected final String TEXT_18 = ")new";
	protected final String TEXT_19 = ", ";
	protected final String TEXT_20 = ", msgs);";
	protected final String TEXT_21 = NL;
	protected final String TEXT_22 = NL + "\t\treturn msgs;";
	protected final String TEXT_23 = NL;
	protected final String TEXT_24 = NL + "\t\tObject old";
	protected final String TEXT_25 = " = eVirtualSet(";
	protected final String TEXT_26 = ", new";
	protected final String TEXT_27 = ");";
	protected final String TEXT_28 = NL + "\t\t";
	protected final String TEXT_29 = " old";
	protected final String TEXT_30 = " = ";
	protected final String TEXT_31 = ";" + NL + "\t\t";
	protected final String TEXT_32 = " = new";
	protected final String TEXT_33 = ";";
	protected final String TEXT_34 = NL + "\t\tboolean isSetChange = old";
	protected final String TEXT_35 = " == EVIRTUAL_NO_VALUE;";
	protected final String TEXT_36 = NL + "\t\tboolean old";
	protected final String TEXT_37 = "ESet = (";
	protected final String TEXT_38 = " & ";
	protected final String TEXT_39 = "_ESETFLAG) != 0;";
	protected final String TEXT_40 = NL + "\t\t";
	protected final String TEXT_41 = " |= ";
	protected final String TEXT_42 = "_ESETFLAG;";
	protected final String TEXT_43 = NL + "\t\tboolean old";
	protected final String TEXT_44 = "ESet = ";
	protected final String TEXT_45 = "ESet;";
	protected final String TEXT_46 = NL + "\t\t";
	protected final String TEXT_47 = "ESet = true;";
	protected final String TEXT_48 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t{";
	protected final String TEXT_49 = NL + "\t\t\t";
	protected final String TEXT_50 = " notification = new ";
	protected final String TEXT_51 = "(this, ";
	protected final String TEXT_52 = ".SET, ";
	protected final String TEXT_53 = ", ";
	protected final String TEXT_54 = "isSetChange ? null : old";
	protected final String TEXT_55 = "old";
	protected final String TEXT_56 = ", new";
	protected final String TEXT_57 = ", ";
	protected final String TEXT_58 = "isSetChange";
	protected final String TEXT_59 = "!old";
	protected final String TEXT_60 = "ESet";
	protected final String TEXT_61 = ");";
	protected final String TEXT_62 = NL + "\t\t\t";
	protected final String TEXT_63 = " notification = new ";
	protected final String TEXT_64 = "(this, ";
	protected final String TEXT_65 = ".SET, ";
	protected final String TEXT_66 = ", ";
	protected final String TEXT_67 = "old";
	protected final String TEXT_68 = " == EVIRTUAL_NO_VALUE ? null : old";
	protected final String TEXT_69 = "old";
	protected final String TEXT_70 = ", new";
	protected final String TEXT_71 = ");";
	protected final String TEXT_72 = NL + "\t\t\tif (msgs == null) msgs = notification; else msgs.add(notification);" + NL + "\t\t}";
	protected final String TEXT_73 = NL;
	protected final String TEXT_74 = NL + "\t\treturn msgs;";
	protected final String TEXT_75 = NL + "\t\treturn ((";
	protected final String TEXT_76 = ".Internal)((";
	protected final String TEXT_77 = ".Internal.Wrapper)get";
	protected final String TEXT_78 = "()).featureMap()).basicAdd(";
	protected final String TEXT_79 = ", new";
	protected final String TEXT_80 = ", msgs);";
	protected final String TEXT_81 = NL + "\t\treturn ((";
	protected final String TEXT_82 = ".Internal)get";
	protected final String TEXT_83 = "()).basicAdd(";
	protected final String TEXT_84 = ", new";
	protected final String TEXT_85 = ", msgs);";
	protected final String TEXT_86 = NL;
	protected final String TEXT_87 = NL + "\t}" + NL + NL;
	protected final String TEXT_88 = NL;
	protected final String TEXT_89 = NL;

	public InterfacebasicSetGenFeatureoverride() {
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
						for (Object isJDK50Parameter : isJDK50List) {
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
													this.isJDK50 = (java.lang.Boolean) isJDK50Parameter;
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
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_88);
		stringBuffer.append(TEXT_89);
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
			parameterValues.put("isJDK50", this.isJDK50);
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
		parameters.put("isJDK50", this.isJDK50);
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
		if (isJDK50) { //Class/basicSetGenFeature.annotations.insert.javajetinc
			stringBuffer.append(TEXT_2);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicSetGenFeature.annotations.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0xpGAGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

		}
		stringBuffer.append(TEXT_3);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genFeature.getAccessorName());
		stringBuffer.append(TEXT_5);
		stringBuffer.append(genFeature.getImportedInternalType(genClass));
		stringBuffer.append(TEXT_6);
		stringBuffer.append(genFeature.getCapName());
		stringBuffer.append(TEXT_7);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
		stringBuffer.append(TEXT_8);
		if (genFeature.isContainer()) {
			stringBuffer.append(TEXT_9);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicSetGenFeature.pre.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0xy3AGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			stringBuffer.append(TEXT_10);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
			stringBuffer.append(TEXT_11);
			stringBuffer.append(genFeature.getCapName());
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
			stringBuffer.append(positiveOffsetCorrection);
			stringBuffer.append(TEXT_13);
			stringBuffer.append(TEXT_14);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicSetGenFeature.post.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0x8oAGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			stringBuffer.append(TEXT_15);
		} else if (genModel.isDynamicDelegation()) {
			stringBuffer.append(TEXT_16);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicSetGenFeature.pre.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0xy3AGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			stringBuffer.append(TEXT_17);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genFeature.getCapName());
			stringBuffer.append(TEXT_19);
			stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
			stringBuffer.append(positiveOffsetCorrection);
			stringBuffer.append(TEXT_20);
			stringBuffer.append(TEXT_21);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicSetGenFeature.post.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0x8oAGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			stringBuffer.append(TEXT_22);
		} else if (!genFeature.isVolatile()) {
			stringBuffer.append(TEXT_23);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicSetGenFeature.pre.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0xy3AGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			if (genModel.isVirtualDelegation()) {
				stringBuffer.append(TEXT_24);
				stringBuffer.append(genFeature.getCapName());
				stringBuffer.append(TEXT_25);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				stringBuffer.append(positiveOffsetCorrection);
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genFeature.getCapName());
				stringBuffer.append(TEXT_27);
			} else {
				stringBuffer.append(TEXT_28);
				stringBuffer.append(genFeature.getImportedType(genClass));
				stringBuffer.append(TEXT_29);
				stringBuffer.append(genFeature.getCapName());
				stringBuffer.append(TEXT_30);
				stringBuffer.append(genFeature.getSafeName());
				stringBuffer.append(TEXT_31);
				stringBuffer.append(genFeature.getSafeName());
				stringBuffer.append(TEXT_32);
				stringBuffer.append(genFeature.getCapName());
				stringBuffer.append(TEXT_33);
			}
			if (genFeature.isUnsettable()) {
				if (genModel.isVirtualDelegation()) {
					if (!genModel.isSuppressNotification()) {
						stringBuffer.append(TEXT_34);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_35);
					}
				} else if (genClass.isESetFlag(genFeature)) {
					stringBuffer.append(TEXT_36);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_37);
					stringBuffer.append(genClass.getESetFlagsField(genFeature));
					stringBuffer.append(TEXT_38);
					stringBuffer.append(genFeature.getUpperName());
					stringBuffer.append(TEXT_39);
					if (!genModel.isSuppressNotification()) {
						stringBuffer.append(TEXT_40);
						stringBuffer.append(genClass.getESetFlagsField(genFeature));
						stringBuffer.append(TEXT_41);
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_42);
					}
				} else {
					if (!genModel.isSuppressNotification()) {
						stringBuffer.append(TEXT_43);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_44);
						stringBuffer.append(genFeature.getUncapName());
						stringBuffer.append(TEXT_45);
					}
					stringBuffer.append(TEXT_46);
					stringBuffer.append(genFeature.getUncapName());
					stringBuffer.append(TEXT_47);
				}
			}
			if (!genModel.isSuppressNotification()) {
				stringBuffer.append(TEXT_48);
				if (genFeature.isUnsettable()) {
					stringBuffer.append(TEXT_49);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
					stringBuffer.append(TEXT_50);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
					stringBuffer.append(TEXT_51);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
					stringBuffer.append(TEXT_52);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(positiveOffsetCorrection);
					stringBuffer.append(TEXT_53);
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_54);
						stringBuffer.append(genFeature.getCapName());
					} else {
						stringBuffer.append(TEXT_55);
						stringBuffer.append(genFeature.getCapName());
					}
					stringBuffer.append(TEXT_56);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_57);
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_58);
					} else {
						stringBuffer.append(TEXT_59);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_60);
					}
					stringBuffer.append(TEXT_61);
				} else {
					stringBuffer.append(TEXT_62);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
					stringBuffer.append(TEXT_63);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
					stringBuffer.append(TEXT_64);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
					stringBuffer.append(TEXT_65);
					stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
					stringBuffer.append(positiveOffsetCorrection);
					stringBuffer.append(TEXT_66);
					if (genModel.isVirtualDelegation()) {
						stringBuffer.append(TEXT_67);
						stringBuffer.append(genFeature.getCapName());
						stringBuffer.append(TEXT_68);
						stringBuffer.append(genFeature.getCapName());
					} else {
						stringBuffer.append(TEXT_69);
						stringBuffer.append(genFeature.getCapName());
					}
					stringBuffer.append(TEXT_70);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_71);
				}
				stringBuffer.append(TEXT_72);
			}
			stringBuffer.append(TEXT_73);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicSetGenFeature.post.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0x8oAGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			stringBuffer.append(TEXT_74);
		} else if (genFeature.hasDelegateFeature()) {
			GenFeature delegateFeature = genFeature.getDelegateFeature();
			if (delegateFeature.isWrappedFeatureMapType()) {
				stringBuffer.append(TEXT_75);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
				stringBuffer.append(TEXT_76);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
				stringBuffer.append(TEXT_77);
				stringBuffer.append(delegateFeature.getAccessorName());
				stringBuffer.append(TEXT_78);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_79);
				stringBuffer.append(genFeature.getCapName());
				stringBuffer.append(TEXT_80);
			} else {
				stringBuffer.append(TEXT_81);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
				stringBuffer.append(TEXT_82);
				stringBuffer.append(delegateFeature.getAccessorName());
				stringBuffer.append(TEXT_83);
				stringBuffer.append(genFeature.getQualifiedFeatureAccessor());
				stringBuffer.append(TEXT_84);
				stringBuffer.append(genFeature.getCapName());
				stringBuffer.append(TEXT_85);
			}
		} else {
			stringBuffer.append(TEXT_86);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicSetGenFeature.TODO.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				callParameters.put("isJDK50", isJDK50);
				callParameters.put("isInterface", isInterface);
				callParameters.put("isImplementation", isImplementation);
				callParameters.put("publicStaticFinalFlag", publicStaticFinalFlag);
				callParameters.put("singleWildcard", singleWildcard);
				callParameters.put("negativeOffsetCorrection", negativeOffsetCorrection);
				callParameters.put("positiveOffsetCorrection", positiveOffsetCorrection);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0x8oFGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/basicSetGenFeature.todo.override.javajetinc
		}
		stringBuffer.append(TEXT_87);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return true;
	}
}