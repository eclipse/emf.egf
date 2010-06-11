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

public class InterfacegetGenFeaturejavadocoverride {
	protected static String nl;

	public static synchronized InterfacegetGenFeaturejavadocoverride create(String lineSeparator) {
		nl = lineSeparator;
		InterfacegetGenFeaturejavadocoverride result = new InterfacegetGenFeaturejavadocoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t/**" + NL + "\t * Returns the value of the '<em><b>";
	protected final String TEXT_2 = "</b></em>' ";
	protected final String TEXT_3 = ".";
	protected final String TEXT_4 = NL + "\t * The key is of type ";
	protected final String TEXT_5 = "list of {@link ";
	protected final String TEXT_6 = "}";
	protected final String TEXT_7 = "{@link ";
	protected final String TEXT_8 = "}";
	protected final String TEXT_9 = "," + NL + "\t * and the value is of type ";
	protected final String TEXT_10 = "list of {@link ";
	protected final String TEXT_11 = "}";
	protected final String TEXT_12 = "{@link ";
	protected final String TEXT_13 = "}";
	protected final String TEXT_14 = ",";
	protected final String TEXT_15 = NL + "\t * The list contents are of type {@link ";
	protected final String TEXT_16 = "}";
	protected final String TEXT_17 = ".";
	protected final String TEXT_18 = NL + "\t * The default value is <code>";
	protected final String TEXT_19 = "</code>.";
	protected final String TEXT_20 = NL + "\t * The literals are from the enumeration {@link ";
	protected final String TEXT_21 = "}.";
	protected final String TEXT_22 = NL + "\t * It is bidirectional and its opposite is '{@link ";
	protected final String TEXT_23 = "#";
	protected final String TEXT_24 = " <em>";
	protected final String TEXT_25 = "</em>}'.";
	protected final String TEXT_26 = NL;
	protected final String TEXT_27 = NL + "\t * <!-- begin-user-doc -->";
	protected final String TEXT_28 = NL + "\t * <p>" + NL + "\t * If the meaning of the '<em>";
	protected final String TEXT_29 = "</em>' ";
	protected final String TEXT_30 = " isn't clear," + NL + "\t * there really should be more of a description here..." + NL + "\t * </p>";
	protected final String TEXT_31 = NL + "\t * <!-- end-user-doc -->";
	protected final String TEXT_32 = NL + "\t * <!-- begin-model-doc -->" + NL + "\t * ";
	protected final String TEXT_33 = NL + "\t * <!-- end-model-doc -->";
	protected final String TEXT_34 = NL + "\t * @return the value of the '<em>";
	protected final String TEXT_35 = "</em>' ";
	protected final String TEXT_36 = ".";
	protected final String TEXT_37 = NL + "\t * @see ";
	protected final String TEXT_38 = NL + "\t * @see #isSet";
	protected final String TEXT_39 = "()";
	protected final String TEXT_40 = NL + "\t * @see #unset";
	protected final String TEXT_41 = "()";
	protected final String TEXT_42 = NL + "\t * @see #set";
	protected final String TEXT_43 = "(";
	protected final String TEXT_44 = ")";
	protected final String TEXT_45 = NL + "\t * @see ";
	protected final String TEXT_46 = "#get";
	protected final String TEXT_47 = "()";
	protected final String TEXT_48 = NL + "\t * @see ";
	protected final String TEXT_49 = "#";
	protected final String TEXT_50 = NL + "\t * @model ";
	protected final String TEXT_51 = NL + "\t *        ";
	protected final String TEXT_52 = NL + "\t * @model";
	protected final String TEXT_53 = NL + "\t * @generated" + NL + "\t */" + NL;
	protected final String TEXT_54 = NL;
	protected final String TEXT_55 = NL;

	public InterfacegetGenFeaturejavadocoverride() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;

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

													if (preCondition())
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
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
			ctx.clearBuffer();
		}

		stringBuffer.append(TEXT_54);
		stringBuffer.append(TEXT_55);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		int executionIndex = ictx.getExecutionBuffer().length();

		method_doGenerate(ictx.getBuffer(), ictx);

		String loop = ictx.getBuffer().toString();
		if (ictx.useReporter()) {
			ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
			ictx.setExecutionCurrentIndex(0);
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
			String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			ictx.clearBuffer();
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
		stringBuffer.append(genFeature.getFormattedName());
		stringBuffer.append(TEXT_2);
		stringBuffer.append(genFeature.getFeatureKind());
		stringBuffer.append(TEXT_3);
		if (genFeature.isListType()) {
			if (genFeature.isMapType()) {
				GenFeature keyFeature = genFeature.getMapEntryTypeGenClass().getMapEntryKeyFeature();
				GenFeature valueFeature = genFeature.getMapEntryTypeGenClass().getMapEntryValueFeature();
				stringBuffer.append(TEXT_4);
				if (keyFeature.isListType()) {
					stringBuffer.append(TEXT_5);
					stringBuffer.append(keyFeature.getQualifiedListItemType(genClass));
					stringBuffer.append(TEXT_6);
				} else {
					stringBuffer.append(TEXT_7);
					stringBuffer.append(keyFeature.getType(genClass));
					stringBuffer.append(TEXT_8);
				}
				stringBuffer.append(TEXT_9);
				if (valueFeature.isListType()) {
					stringBuffer.append(TEXT_10);
					stringBuffer.append(valueFeature.getQualifiedListItemType(genClass));
					stringBuffer.append(TEXT_11);
				} else {
					stringBuffer.append(TEXT_12);
					stringBuffer.append(valueFeature.getType(genClass));
					stringBuffer.append(TEXT_13);
				}
				stringBuffer.append(TEXT_14);
			} else if (!genFeature.isWrappedFeatureMapType()
					&& !(genModel.isSuppressEMFMetaData() && "org.eclipse.emf.ecore.EObject".equals(genFeature
							.getQualifiedListItemType(genClass)))) {
				String typeName = genFeature.getQualifiedListItemType(genClass);
				String head = typeName;
				String tail = "";
				int index = typeName.indexOf('<');
				if (index == -1) {
					index = typeName.indexOf('[');
				}
				if (index != -1) {
					head = typeName.substring(0, index);
					tail = typeName.substring(index).replaceAll("<", "&lt;");
				}

				stringBuffer.append(TEXT_15);
				stringBuffer.append(head);
				stringBuffer.append(TEXT_16);
				stringBuffer.append(tail);
				stringBuffer.append(TEXT_17);
			}
		} else if (genFeature.isSetDefaultValue()) {
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genFeature.getDefaultValue());
			stringBuffer.append(TEXT_19);
		}
		if (genFeature.getTypeGenEnum() != null) {
			stringBuffer.append(TEXT_20);
			stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
			stringBuffer.append(TEXT_21);
		}
		if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) {
			GenFeature reverseGenFeature = genFeature.getReverse();
			if (!reverseGenFeature.isSuppressedGetVisibility()) {
				stringBuffer.append(TEXT_22);
				stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
				stringBuffer.append(TEXT_23);
				stringBuffer.append(reverseGenFeature.getGetAccessor());
				stringBuffer.append(TEXT_24);
				stringBuffer.append(reverseGenFeature.getFormattedName());
				stringBuffer.append(TEXT_25);
			}
		}
		stringBuffer.append(TEXT_26);
		{
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
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0wJ4QGJ-Ed-FqczH3ESmRw", new ExecutionContext(
							(InternalPatternContext) ctx), callParameters);
		}

		stringBuffer.append(TEXT_27);
		if (!genFeature.hasDocumentation()) {
			stringBuffer.append(TEXT_28);
			stringBuffer.append(genFeature.getFormattedName());
			stringBuffer.append(TEXT_29);
			stringBuffer.append(genFeature.getFeatureKind());
			stringBuffer.append(TEXT_30);
		}
		stringBuffer.append(TEXT_31);
		if (genFeature.hasDocumentation()) {
			stringBuffer.append(TEXT_32);
			stringBuffer.append(genFeature.getDocumentation(genModel.getIndentation(stringBuffer)));
			stringBuffer.append(TEXT_33);
		}
		stringBuffer.append(TEXT_34);
		stringBuffer.append(genFeature.getFormattedName());
		stringBuffer.append(TEXT_35);
		stringBuffer.append(genFeature.getFeatureKind());
		stringBuffer.append(TEXT_36);
		if (genFeature.getTypeGenEnum() != null) {
			stringBuffer.append(TEXT_37);
			stringBuffer.append(genFeature.getTypeGenEnum().getQualifiedName());
		}
		if (genFeature.isUnsettable()) {
			if (!genFeature.isSuppressedIsSetVisibility()) {
				stringBuffer.append(TEXT_38);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_39);
			}
			if (genFeature.isChangeable() && !genFeature.isSuppressedUnsetVisibility()) {
				stringBuffer.append(TEXT_40);
				stringBuffer.append(genFeature.getAccessorName());
				stringBuffer.append(TEXT_41);
			}
		}
		if (genFeature.isChangeable() && !genFeature.isListType() && !genFeature.isSuppressedSetVisibility()) {
			stringBuffer.append(TEXT_42);
			stringBuffer.append(genFeature.getAccessorName());
			stringBuffer.append(TEXT_43);
			stringBuffer.append(genFeature.getRawImportedBoundType());
			stringBuffer.append(TEXT_44);
		}
		if (!genModel.isSuppressEMFMetaData()) {
			stringBuffer.append(TEXT_45);
			stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
			stringBuffer.append(TEXT_46);
			stringBuffer.append(genFeature.getFeatureAccessorName());
			stringBuffer.append(TEXT_47);
		}
		if (genFeature.isBidirectional() && !genFeature.getReverse().getGenClass().isMapEntry()) {
			GenFeature reverseGenFeature = genFeature.getReverse();
			if (!reverseGenFeature.isSuppressedGetVisibility()) {
				stringBuffer.append(TEXT_48);
				stringBuffer.append(reverseGenFeature.getGenClass().getQualifiedInterfaceName());
				stringBuffer.append(TEXT_49);
				stringBuffer.append(reverseGenFeature.getGetAccessor());
			}
		}
		if (!genModel.isSuppressEMFModelTags()) {
			boolean first = true;
			for (StringTokenizer stringTokenizer = new StringTokenizer(genFeature.getModelInfo(), "\n\r"); stringTokenizer.hasMoreTokens();) {
				String modelInfo = stringTokenizer.nextToken();
				if (first) {
					first = false;
					stringBuffer.append(TEXT_50);
					stringBuffer.append(modelInfo);
				} else {
					stringBuffer.append(TEXT_51);
					stringBuffer.append(modelInfo);
				}
			}
			if (first) {
				stringBuffer.append(TEXT_52);
			}
		}
		stringBuffer.append(TEXT_53);
	}

	public boolean preCondition() throws Exception {
		return true;
	}
}