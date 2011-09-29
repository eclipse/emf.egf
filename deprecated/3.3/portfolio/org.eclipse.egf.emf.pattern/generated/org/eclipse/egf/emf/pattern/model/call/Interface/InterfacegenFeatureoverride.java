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

public class InterfacegenFeatureoverride {
	protected static String nl;

	public static synchronized InterfacegenFeatureoverride create(String lineSeparator) {
		nl = lineSeparator;
		InterfacegenFeatureoverride result = new InterfacegenFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_3 = NL + "\t";
	protected final String TEXT_4 = "[] ";
	protected final String TEXT_5 = "();" + NL;
	protected final String TEXT_6 = NL + "\t@SuppressWarnings(\"unchecked\")";
	protected final String TEXT_7 = NL + "\tpublic ";
	protected final String TEXT_8 = "[] ";
	protected final String TEXT_9 = "()" + NL + "\t{";
	protected final String TEXT_10 = NL + "\t\t";
	protected final String TEXT_11 = " list = (";
	protected final String TEXT_12 = ")";
	protected final String TEXT_13 = "();" + NL + "\t\tif (list.isEmpty()) return ";
	protected final String TEXT_14 = "(";
	protected final String TEXT_15 = "[])";
	protected final String TEXT_16 = "_EEMPTY_ARRAY;";
	protected final String TEXT_17 = NL + "\t\tif (";
	protected final String TEXT_18 = " == null || ";
	protected final String TEXT_19 = ".isEmpty()) return ";
	protected final String TEXT_20 = "(";
	protected final String TEXT_21 = "[])";
	protected final String TEXT_22 = "_EEMPTY_ARRAY;" + NL + "\t\t";
	protected final String TEXT_23 = " list = (";
	protected final String TEXT_24 = ")";
	protected final String TEXT_25 = ";";
	protected final String TEXT_26 = NL + "\t\tlist.shrink();" + NL + "\t\treturn (";
	protected final String TEXT_27 = "[])list.data();" + NL + "\t}" + NL;
	protected final String TEXT_28 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_29 = NL + "\t";
	protected final String TEXT_30 = " get";
	protected final String TEXT_31 = "(int index);" + NL;
	protected final String TEXT_32 = NL + "\tpublic ";
	protected final String TEXT_33 = " get";
	protected final String TEXT_34 = "(int index)" + NL + "\t{" + NL + "\t\treturn ";
	protected final String TEXT_35 = "(";
	protected final String TEXT_36 = ")";
	protected final String TEXT_37 = "().get(index);" + NL + "\t}" + NL;
	protected final String TEXT_38 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_39 = NL + "\tint get";
	protected final String TEXT_40 = "Length();" + NL;
	protected final String TEXT_41 = NL + "\tpublic int get";
	protected final String TEXT_42 = "Length()" + NL + "\t{";
	protected final String TEXT_43 = NL + "\t\treturn ";
	protected final String TEXT_44 = "().size();";
	protected final String TEXT_45 = NL + "\t\treturn ";
	protected final String TEXT_46 = " == null ? 0 : ";
	protected final String TEXT_47 = ".size();";
	protected final String TEXT_48 = NL + "\t}" + NL;
	protected final String TEXT_49 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_50 = NL + "\tvoid set";
	protected final String TEXT_51 = "(";
	protected final String TEXT_52 = "[] new";
	protected final String TEXT_53 = ");" + NL;
	protected final String TEXT_54 = NL + "\tpublic void set";
	protected final String TEXT_55 = "(";
	protected final String TEXT_56 = "[] new";
	protected final String TEXT_57 = ")" + NL + "\t{" + NL + "\t\t((";
	protected final String TEXT_58 = ")";
	protected final String TEXT_59 = "()).setData(new";
	protected final String TEXT_60 = ".length, new";
	protected final String TEXT_61 = ");" + NL + "\t}" + NL;
	protected final String TEXT_62 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_63 = NL + "\tvoid set";
	protected final String TEXT_64 = "(int index, ";
	protected final String TEXT_65 = " element);" + NL;
	protected final String TEXT_66 = NL + "\tpublic void set";
	protected final String TEXT_67 = "(int index, ";
	protected final String TEXT_68 = " element)" + NL + "\t{" + NL + "\t\t";
	protected final String TEXT_69 = "().set(index, element);" + NL + "\t}" + NL;
	protected final String TEXT_70 = NL;
	protected final String TEXT_71 = NL;
	protected final String TEXT_72 = NL;
	protected final String TEXT_73 = NL;
	protected final String TEXT_74 = NL;
	protected final String TEXT_75 = NL;
	protected final String TEXT_76 = NL;
	protected final String TEXT_77 = NL;
	protected final String TEXT_78 = NL;
	protected final String TEXT_79 = NL;
	protected final String TEXT_80 = NL;

	public InterfacegenFeatureoverride() {
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

		stringBuffer.append(TEXT_79);
		stringBuffer.append(TEXT_80);
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
		if (genModel.isArrayAccessors() && genFeature.isListType() && !genFeature.isFeatureMapType() && !genFeature.isMapType()) {
			stringBuffer.append(TEXT_2);
			if (!isImplementation) {
				stringBuffer.append(TEXT_3);
				stringBuffer.append(genFeature.getListItemType(genClass));
				stringBuffer.append(TEXT_4);
				stringBuffer.append(genFeature.getGetArrayAccessor());
				stringBuffer.append(TEXT_5);
			} else {
				if (genModel.useGenerics()) {
					stringBuffer.append(TEXT_6);
				}
				stringBuffer.append(TEXT_7);
				stringBuffer.append(genFeature.getListItemType(genClass));
				stringBuffer.append(TEXT_8);
				stringBuffer.append(genFeature.getGetArrayAccessor());
				stringBuffer.append(TEXT_9);
				if (genFeature.isVolatile()) {
					stringBuffer.append(TEXT_10);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
					stringBuffer.append(genFeature.getListTemplateArguments(genClass));
					stringBuffer.append(TEXT_11);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
					stringBuffer.append(genFeature.getListTemplateArguments(genClass));
					stringBuffer.append(TEXT_12);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_13);
					if (genModel.useGenerics() && !genFeature.getListItemType(genClass).contains("<") && !genFeature.getListItemType(null).equals(genFeature.getListItemType(genClass))) {
						stringBuffer.append(TEXT_14);
						stringBuffer.append(genFeature.getListItemType(genClass));
						stringBuffer.append(TEXT_15);
					}
					stringBuffer.append(genFeature.getUpperName());
					stringBuffer.append(TEXT_16);
				} else {
					stringBuffer.append(TEXT_17);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_18);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_19);
					if (genModel.useGenerics() && !genFeature.getListItemType(genClass).contains("<") && !genFeature.getListItemType(null).equals(genFeature.getListItemType(genClass))) {
						stringBuffer.append(TEXT_20);
						stringBuffer.append(genFeature.getListItemType(genClass));
						stringBuffer.append(TEXT_21);
					}
					stringBuffer.append(genFeature.getUpperName());
					stringBuffer.append(TEXT_22);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
					stringBuffer.append(genFeature.getListTemplateArguments(genClass));
					stringBuffer.append(TEXT_23);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
					stringBuffer.append(genFeature.getListTemplateArguments(genClass));
					stringBuffer.append(TEXT_24);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_25);
				}
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genFeature.getListItemType(genClass));
				stringBuffer.append(TEXT_27);
			}
			stringBuffer.append(TEXT_28);
			if (!isImplementation) {
				stringBuffer.append(TEXT_29);
				stringBuffer.append(genFeature.getListItemType(genClass));
				stringBuffer.append(TEXT_30);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_31);
			} else {
				stringBuffer.append(TEXT_32);
				stringBuffer.append(genFeature.getListItemType(genClass));
				stringBuffer.append(TEXT_33);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_34);
				if (!genModel.useGenerics()) {
					stringBuffer.append(TEXT_35);
					stringBuffer.append(genFeature.getListItemType(genClass));
					stringBuffer.append(TEXT_36);
				}
				stringBuffer.append(genFeature.getGetAccessor());
				stringBuffer.append(TEXT_37);
			}
			stringBuffer.append(TEXT_38);
			if (!isImplementation) {
				stringBuffer.append(TEXT_39);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_40);
			} else {
				stringBuffer.append(TEXT_41);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_42);
				if (genFeature.isVolatile()) {
					stringBuffer.append(TEXT_43);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_44);
				} else {
					stringBuffer.append(TEXT_45);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_46);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_47);
				}
				stringBuffer.append(TEXT_48);
			}
			stringBuffer.append(TEXT_49);
			if (!isImplementation) {
				stringBuffer.append(TEXT_50);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_51);
				stringBuffer.append(genFeature.getListItemType(genClass));
				stringBuffer.append(TEXT_52);
				stringBuffer.append(genFeature.getCapName());
				stringBuffer.append(TEXT_53);
			} else {
				stringBuffer.append(TEXT_54);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_55);
				stringBuffer.append(genFeature.getListItemType(genClass));
				stringBuffer.append(TEXT_56);
				stringBuffer.append(genFeature.getCapName());
				stringBuffer.append(TEXT_57);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
				stringBuffer.append(genFeature.getListTemplateArguments(genClass));
				stringBuffer.append(TEXT_58);
				stringBuffer.append(genFeature.getGetAccessor());
				stringBuffer.append(TEXT_59);
				stringBuffer.append(genFeature.getCapName());
				stringBuffer.append(TEXT_60);
				stringBuffer.append(genFeature.getCapName());
				stringBuffer.append(TEXT_61);
			}
			stringBuffer.append(TEXT_62);
			if (!isImplementation) {
				stringBuffer.append(TEXT_63);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_64);
				stringBuffer.append(genFeature.getListItemType(genClass));
				stringBuffer.append(TEXT_65);
			} else {
				stringBuffer.append(TEXT_66);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_67);
				stringBuffer.append(genFeature.getListItemType(genClass));
				stringBuffer.append(TEXT_68);
				stringBuffer.append(genFeature.getGetAccessor());
				stringBuffer.append(TEXT_69);
			}
		}
		if (genFeature.isGet() && (isImplementation || !genFeature.isSuppressedGetVisibility())) {
			stringBuffer.append(TEXT_70);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.getGenFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0vkCYGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/getGenFeature.override.javajetinc
		}
		if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicGet()) {
			stringBuffer.append(TEXT_71);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicGetGenFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0wwVMGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/basicGetGenFeature.override.javajetinc
		}
		if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicSet()) {
			stringBuffer.append(TEXT_72);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicSetGenFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0xWLEGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/basicSetGenFeature.override.javajetinc
		}
		if (genFeature.isSet() && (isImplementation || !genFeature.isSuppressedSetVisibility())) {
			stringBuffer.append(TEXT_73);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.setGenFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0yPi8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/setGenFeature.override.javajetinc
		}
		if (isImplementation && !genModel.isReflectiveDelegation() && genFeature.isBasicUnset()) {
			stringBuffer.append(TEXT_74);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicUnsetGenFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0zSEwGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class.basicUnsetGenFeature.override.javajetinc
		}
		if (genFeature.isUnset() && (isImplementation || !genFeature.isSuppressedUnsetVisibility())) {
			stringBuffer.append(TEXT_75);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.unsetGenFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0z4hsGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/unsetGenFeature.override.javajetinc
		}
		if (genFeature.isIsSet() && (isImplementation || !genFeature.isSuppressedIsSetVisibility())) {
			stringBuffer.append(TEXT_76);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.isSetGenFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_00oIkGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/isSetGenFeature.override.javajetinc
		}
		stringBuffer.append(TEXT_77);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.genFeature.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isInterface:isInterface,isImplementation:isImplementation,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection"%>

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
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_010bYGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_78);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return true;
	}
}