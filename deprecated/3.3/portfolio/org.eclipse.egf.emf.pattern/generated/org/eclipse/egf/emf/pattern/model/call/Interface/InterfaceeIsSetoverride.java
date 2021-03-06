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

public class InterfaceeIsSetoverride {
	protected static String nl;

	public static synchronized InterfaceeIsSetoverride create(String lineSeparator) {
		nl = lineSeparator;
		InterfaceeIsSetoverride result = new InterfaceeIsSetoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_2 = NL + "\t@SuppressWarnings(\"unchecked\")";
	protected final String TEXT_3 = NL + "\t@Override";
	protected final String TEXT_4 = NL + "\tpublic boolean eIsSet(int featureID)" + NL + "\t{" + NL + "\t\tswitch (featureID";
	protected final String TEXT_5 = ")" + NL + "\t\t{";
	protected final String TEXT_6 = NL + "\t\t\tcase ";
	protected final String TEXT_7 = ":";
	protected final String TEXT_8 = NL + "\t\t\t\treturn !((";
	protected final String TEXT_9 = ".Internal.Wrapper)";
	protected final String TEXT_10 = "()).featureMap().isEmpty();";
	protected final String TEXT_11 = NL + "\t\t\t\treturn ";
	protected final String TEXT_12 = " != null && !";
	protected final String TEXT_13 = ".featureMap().isEmpty();";
	protected final String TEXT_14 = NL + "\t\t\t\treturn ";
	protected final String TEXT_15 = " != null && !";
	protected final String TEXT_16 = ".isEmpty();";
	protected final String TEXT_17 = NL + "\t\t\t\t";
	protected final String TEXT_18 = " ";
	protected final String TEXT_19 = " = (";
	protected final String TEXT_20 = ")eVirtualGet(";
	protected final String TEXT_21 = ");" + NL + "\t\t\t\treturn ";
	protected final String TEXT_22 = " != null && !";
	protected final String TEXT_23 = ".isEmpty();";
	protected final String TEXT_24 = NL + "\t\t\t\treturn !";
	protected final String TEXT_25 = "().isEmpty();";
	protected final String TEXT_26 = NL + "\t\t\t\treturn isSet";
	protected final String TEXT_27 = "();";
	protected final String TEXT_28 = NL + "\t\t\t\treturn ";
	protected final String TEXT_29 = " != null;";
	protected final String TEXT_30 = NL + "\t\t\t\treturn eVirtualGet(";
	protected final String TEXT_31 = ") != null;";
	protected final String TEXT_32 = NL + "\t\t\t\treturn basicGet";
	protected final String TEXT_33 = "() != null;";
	protected final String TEXT_34 = NL + "\t\t\t\treturn ";
	protected final String TEXT_35 = " != null;";
	protected final String TEXT_36 = NL + "\t\t\t\treturn eVirtualGet(";
	protected final String TEXT_37 = ") != null;";
	protected final String TEXT_38 = NL + "\t\t\t\treturn ";
	protected final String TEXT_39 = "() != null;";
	protected final String TEXT_40 = NL + "\t\t\t\treturn ((";
	protected final String TEXT_41 = " & ";
	protected final String TEXT_42 = "_EFLAG) != 0) != ";
	protected final String TEXT_43 = ";";
	protected final String TEXT_44 = NL + "\t\t\t\treturn ";
	protected final String TEXT_45 = " != ";
	protected final String TEXT_46 = ";";
	protected final String TEXT_47 = NL + "\t\t\t\treturn eVirtualGet(";
	protected final String TEXT_48 = ", ";
	protected final String TEXT_49 = ") != ";
	protected final String TEXT_50 = ";";
	protected final String TEXT_51 = NL + "\t\t\t\treturn ";
	protected final String TEXT_52 = "() != ";
	protected final String TEXT_53 = ";";
	protected final String TEXT_54 = NL + "\t\t\t\treturn ";
	protected final String TEXT_55 = " == null ? ";
	protected final String TEXT_56 = " != null : !";
	protected final String TEXT_57 = ".equals(";
	protected final String TEXT_58 = ");";
	protected final String TEXT_59 = NL + "\t\t\t\t";
	protected final String TEXT_60 = " ";
	protected final String TEXT_61 = " = (";
	protected final String TEXT_62 = ")eVirtualGet(";
	protected final String TEXT_63 = ", ";
	protected final String TEXT_64 = ");" + NL + "\t\t\t\treturn ";
	protected final String TEXT_65 = " == null ? ";
	protected final String TEXT_66 = " != null : !";
	protected final String TEXT_67 = ".equals(";
	protected final String TEXT_68 = ");";
	protected final String TEXT_69 = NL + "\t\t\t\treturn ";
	protected final String TEXT_70 = " == null ? ";
	protected final String TEXT_71 = "() != null : !";
	protected final String TEXT_72 = ".equals(";
	protected final String TEXT_73 = "());";
	protected final String TEXT_74 = NL + "\t\t}";
	protected final String TEXT_75 = NL + "\t\treturn super.eIsSet(featureID);";
	protected final String TEXT_76 = NL + "\t\treturn eDynamicIsSet(featureID);";
	protected final String TEXT_77 = NL + "\t}" + NL + NL;
	protected final String TEXT_78 = NL;
	protected final String TEXT_79 = NL;

	public InterfaceeIsSetoverride() {
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

		for (Object genClassParameter : genClassList) {
			for (Object genPackageParameter : genPackageList) {
				for (Object genModelParameter : genModelList) {
					for (Object isInterfaceParameter : isInterfaceList) {
						for (Object isImplementationParameter : isImplementationList) {
							for (Object publicStaticFinalFlagParameter : publicStaticFinalFlagList) {
								for (Object singleWildcardParameter : singleWildcardList) {
									for (Object negativeOffsetCorrectionParameter : negativeOffsetCorrectionList) {
										for (Object positiveOffsetCorrectionParameter : positiveOffsetCorrectionList) {

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
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_78);
		stringBuffer.append(TEXT_79);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
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
		if (genModel.useGenerics()) {
			for (GenFeature genFeature : genClass.getEIsSetGenFeatures()) {
				if (genFeature.isListType() && !genFeature.isUnsettable() && !genFeature.isWrappedFeatureMapType() && !genClass.isField(genFeature) && genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
					stringBuffer.append(TEXT_2);
					break;
				}
			}
		}
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_3);
		}
		stringBuffer.append(TEXT_4);
		stringBuffer.append(negativeOffsetCorrection);
		stringBuffer.append(TEXT_5);
		for (GenFeature genFeature : genClass.getEIsSetGenFeatures()) {
			stringBuffer.append(TEXT_6);
			stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
			stringBuffer.append(TEXT_7);
			if (genFeature.isListType() && !genFeature.isUnsettable()) {
				if (genFeature.isWrappedFeatureMapType()) {
					if (genFeature.isVolatile()) {
						stringBuffer.append(TEXT_8);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
						stringBuffer.append(TEXT_9);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_10);
					} else {
						stringBuffer.append(TEXT_11);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_12);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_13);
					}
				} else {
					if (genClass.isField(genFeature)) {
						stringBuffer.append(TEXT_14);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_15);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_16);
					} else {
						if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
							stringBuffer.append(TEXT_17);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_18);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_19);
							stringBuffer.append(genFeature.getImportedType(genClass));
							stringBuffer.append(TEXT_20);
							stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
							stringBuffer.append(positiveOffsetCorrection);
							stringBuffer.append(TEXT_21);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_22);
							stringBuffer.append(genFeature.getSafeName());
							stringBuffer.append(TEXT_23);
						} else {
							stringBuffer.append(TEXT_24);
							stringBuffer.append(genFeature.getGetAccessor());
							stringBuffer.append(TEXT_25);
						}
					}
				}
			} else if (genFeature.isUnsettable()) {
				stringBuffer.append(TEXT_26);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_27);
			} else if (genFeature.isResolveProxies()) {
				if (genClass.isField(genFeature)) {
					stringBuffer.append(TEXT_28);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_29);
				} else {
					if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
						stringBuffer.append(TEXT_30);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_31);
					} else {
						stringBuffer.append(TEXT_32);
						stringBuffer.append(genFeature.getAccessorName());
						stringBuffer.append(TEXT_33);
					}
				}
			} else if (!genFeature.hasEDefault()) {
				if (genClass.isField(genFeature)) {
					stringBuffer.append(TEXT_34);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_35);
				} else {
					if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
						stringBuffer.append(TEXT_36);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_37);
					} else {
						stringBuffer.append(TEXT_38);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_39);
					}
				}
			} else if (genFeature.isPrimitiveType() || genFeature.isEnumType()) {
				if (genClass.isField(genFeature)) {
					if (genClass.isFlag(genFeature)) {
						stringBuffer.append(TEXT_40);
						stringBuffer.append(genClass.getFlagsField(genFeature));
						stringBuffer.append(TEXT_41);
						stringBuffer.append(genFeature.getUpperName());
						stringBuffer.append(TEXT_42);
						stringBuffer.append(genFeature.getEDefault());
						stringBuffer.append(TEXT_43);
					} else {
						stringBuffer.append(TEXT_44);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_45);
						stringBuffer.append(genFeature.getEDefault());
						stringBuffer.append(TEXT_46);
					}
				} else {
					if (genFeature.isEnumType() && genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
						stringBuffer.append(TEXT_47);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_48);
						stringBuffer.append(genFeature.getEDefault());
						stringBuffer.append(TEXT_49);
						stringBuffer.append(genFeature.getEDefault());
						stringBuffer.append(TEXT_50);
					} else {
						stringBuffer.append(TEXT_51);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_52);
						stringBuffer.append(genFeature.getEDefault());
						stringBuffer.append(TEXT_53);
					}
				}
			} else {//datatype
				if (genClass.isField(genFeature)) {
					stringBuffer.append(TEXT_54);
					stringBuffer.append(genFeature.getEDefault());
					stringBuffer.append(TEXT_55);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_56);
					stringBuffer.append(genFeature.getEDefault());
					stringBuffer.append(TEXT_57);
					stringBuffer.append(genFeature.getSafeName());
					stringBuffer.append(TEXT_58);
				} else {
					if (genFeature.isField() && genClass.getImplementingGenModel(genFeature).isVirtualDelegation()) {
						stringBuffer.append(TEXT_59);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_60);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_61);
						stringBuffer.append(genFeature.getImportedType(genClass));
						stringBuffer.append(TEXT_62);
						stringBuffer.append(genClass.getQualifiedFeatureID(genFeature));
						stringBuffer.append(positiveOffsetCorrection);
						stringBuffer.append(TEXT_63);
						stringBuffer.append(genFeature.getEDefault());
						stringBuffer.append(TEXT_64);
						stringBuffer.append(genFeature.getEDefault());
						stringBuffer.append(TEXT_65);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_66);
						stringBuffer.append(genFeature.getEDefault());
						stringBuffer.append(TEXT_67);
						stringBuffer.append(genFeature.getSafeName());
						stringBuffer.append(TEXT_68);
					} else {
						stringBuffer.append(TEXT_69);
						stringBuffer.append(genFeature.getEDefault());
						stringBuffer.append(TEXT_70);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_71);
						stringBuffer.append(genFeature.getEDefault());
						stringBuffer.append(TEXT_72);
						stringBuffer.append(genFeature.getGetAccessor());
						stringBuffer.append(TEXT_73);
					}
				}
			}
		}
		stringBuffer.append(TEXT_74);
		if (genModel.isMinimalReflectiveMethods()) {
			stringBuffer.append(TEXT_75);
		} else {
			stringBuffer.append(TEXT_76);
		}
		stringBuffer.append(TEXT_77);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return true;
	}
}