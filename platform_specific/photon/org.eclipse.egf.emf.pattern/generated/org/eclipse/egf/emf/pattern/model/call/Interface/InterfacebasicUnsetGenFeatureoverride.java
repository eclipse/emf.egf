//Generated with EGF 1.5.0.qualifier
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

public class InterfacebasicUnsetGenFeatureoverride {
	protected static String nl;

	public static synchronized InterfacebasicUnsetGenFeatureoverride create(String lineSeparator) {
		nl = lineSeparator;
		InterfacebasicUnsetGenFeatureoverride result = new InterfacebasicUnsetGenFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->";
	protected final String TEXT_2 = NL + "\t * ";
	protected final String TEXT_3 = NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL + "\t@Deprecated";
	protected final String TEXT_6 = NL + "\tpublic ";
	protected final String TEXT_7 = " basicUnset";
	protected final String TEXT_8 = "(";
	protected final String TEXT_9 = " msgs)" + NL + "\t{";
	protected final String TEXT_10 = NL + "\t\treturn eDynamicInverseRemove((";
	protected final String TEXT_11 = ")";
	protected final String TEXT_12 = "basicGet";
	protected final String TEXT_13 = "(), ";
	protected final String TEXT_14 = ", msgs);";
	protected final String TEXT_15 = "Object old";
	protected final String TEXT_16 = " = ";
	protected final String TEXT_17 = "eVirtualUnset(";
	protected final String TEXT_18 = ");";
	protected final String TEXT_19 = NL + "\t\t";
	protected final String TEXT_20 = " old";
	protected final String TEXT_21 = ";";
	protected final String TEXT_22 = " = null;";
	protected final String TEXT_23 = NL + "\t\tboolean isSetChange = old";
	protected final String TEXT_24 = " != EVIRTUAL_NO_VALUE;";
	protected final String TEXT_25 = NL + "\t\tboolean old";
	protected final String TEXT_26 = "ESet = (";
	protected final String TEXT_27 = " & ";
	protected final String TEXT_28 = "_ESETFLAG) != 0;";
	protected final String TEXT_29 = " &= ~";
	protected final String TEXT_30 = "_ESETFLAG;";
	protected final String TEXT_31 = "ESet = ";
	protected final String TEXT_32 = "ESet;";
	protected final String TEXT_33 = "ESet = false;";
	protected final String TEXT_34 = NL + "\t\tif (eNotificationRequired())" + NL + "\t\t{" + NL + "\t\t\t";
	protected final String TEXT_35 = " notification = new ";
	protected final String TEXT_36 = "(this, ";
	protected final String TEXT_37 = ".UNSET, ";
	protected final String TEXT_38 = ", ";
	protected final String TEXT_39 = "isSetChange ? old";
	protected final String TEXT_40 = " : null";
	protected final String TEXT_41 = "old";
	protected final String TEXT_42 = ", null, ";
	protected final String TEXT_43 = "isSetChange";
	protected final String TEXT_44 = "ESet";
	protected final String TEXT_45 = ");" + NL
			+ "\t\t\tif (msgs == null) msgs = notification; else msgs.add(notification);" + NL + "\t\t}" + NL
			+ "\t\treturn msgs;";
	protected final String TEXT_46 = NL + "\t}" + NL + NL;
	protected final String TEXT_47 = NL;

	public InterfacebasicUnsetGenFeatureoverride() {
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

		stringBuffer.append(TEXT_47);
		stringBuffer.append(TEXT_47);
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
		if (genFeature.hasAPITags()) {
			stringBuffer.append(TEXT_2);
			stringBuffer.append(genFeature.getAPITags(genModel.getIndentation(stringBuffer)));
		}
		stringBuffer.append(TEXT_3);
		if (isJDK50) { //Class/basicUnsetGenFeature.annotations.insert.javajetinc
			stringBuffer.append(TEXT_4);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicUnsetGenFeature.annotations.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0zb1wGJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

		}
		if (isJDK50 && genFeature.hasAPIDeprecatedTag()) {
			stringBuffer.append(TEXT_5);
		}
		stringBuffer.append(TEXT_6);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
		stringBuffer.append(TEXT_7);
		stringBuffer.append(genFeature.getAccessorName());
		stringBuffer.append(TEXT_8);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.NotificationChain"));
		stringBuffer.append(TEXT_9);
		if (genModel.isDynamicDelegation()) {
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.InternalEObject"));
			stringBuffer.append(TEXT_11);
			if (genFeature.isResolveProxies()) {
				stringBuffer.append(TEXT_12);
				stringBuffer.append(genFeature.getAccessorName());
			} else {
				stringBuffer.append(genFeature.getGetAccessor());
			}
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
			stringBuffer.append(positiveOffsetCorrection);
			stringBuffer.append(TEXT_14);
		} else if (!genFeature.isVolatile()) {
			if (genModel.isVirtualDelegation()) {
				if (!genModel.isSuppressNotification()) {
					stringBuffer.append(TEXT_15);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_16);
				}
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				stringBuffer.append(positiveOffsetCorrection);
				stringBuffer.append(TEXT_18);
			} else {
				if (!genModel.isSuppressNotification()) {
					stringBuffer.append(TEXT_19);
					stringBuffer.append(genFeature.getImportedType(genClass));
					stringBuffer.append(TEXT_20);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_16);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_21);
				}
				stringBuffer.append(TEXT_19);
				stringBuffer.append(genFeature.getSafeName());
				stringBuffer.append(TEXT_22);
			}
			if (genModel.isVirtualDelegation()) {
				if (!genModel.isSuppressNotification()) {
					stringBuffer.append(TEXT_23);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_24);
				}
			} else if (genClass.isESetFlag(genFeature)) {
				if (!genModel.isSuppressNotification()) {
					stringBuffer.append(TEXT_25);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_26);
					stringBuffer.append(genClass.getESetFlagsField(genFeature));
					stringBuffer.append(TEXT_27);
					stringBuffer.append(genFeature.getUpperName());
					stringBuffer.append(TEXT_28);
				}
				stringBuffer.append(TEXT_19);
				stringBuffer.append(genClass.getESetFlagsField(genFeature));
				stringBuffer.append(TEXT_29);
				stringBuffer.append(genFeature.getUpperName());
				stringBuffer.append(TEXT_30);
			} else {
				if (!genModel.isSuppressNotification()) {
					stringBuffer.append(TEXT_25);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_31);
					stringBuffer.append(genFeature.getUncapName());
					stringBuffer.append(TEXT_32);
				}
				stringBuffer.append(TEXT_19);
				stringBuffer.append(genFeature.getUncapName());
				stringBuffer.append(TEXT_33);
			}
			if (!genModel.isSuppressNotification()) {
				stringBuffer.append(TEXT_34);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
				stringBuffer.append(TEXT_35);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.impl.ENotificationImpl"));
				stringBuffer.append(TEXT_36);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.notify.Notification"));
				stringBuffer.append(TEXT_37);
				stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
				stringBuffer.append(positiveOffsetCorrection);
				stringBuffer.append(TEXT_38);
				if (genModel.isVirtualDelegation()) {
					stringBuffer.append(TEXT_39);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_40);
				} else {
					stringBuffer.append(TEXT_41);
					stringBuffer.append(genFeature.getCapName());
				}
				stringBuffer.append(TEXT_42);
				if (genModel.isVirtualDelegation()) {
					stringBuffer.append(TEXT_43);
				} else {
					stringBuffer.append(TEXT_41);
					stringBuffer.append(genFeature.getCapName());
					stringBuffer.append(TEXT_44);
				}
				stringBuffer.append(TEXT_45);
			}
		} else {
			stringBuffer.append(TEXT_4);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.basicUnsetGenFeature.TODO.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

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
						"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0zlmwGJ-Ed-FqczH3ESmRw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/basicUnsetGenFeature.todo.override.javajetinc
		}
		stringBuffer.append(TEXT_46);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}