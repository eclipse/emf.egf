//Generated on Mon Nov 07 17:44:38 CET 2011 with EGF 0.6.1.qualifier
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

public class InterfacegenOperationoverride {
	protected static String nl;

	public static synchronized InterfacegenOperationoverride create(String lineSeparator) {
		nl = lineSeparator;
		InterfacegenOperationoverride result = new InterfacegenOperationoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "\t/**" + NL + "\t * The cached validation expression for the '{@link #";
	protected final String TEXT_3 = "(";
	protected final String TEXT_4 = ") <em>";
	protected final String TEXT_5 = "</em>}' invariant operation." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
	protected final String TEXT_6 = "(";
	protected final String TEXT_7 = ")" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
	protected final String TEXT_8 = " ";
	protected final String TEXT_9 = "__EEXPRESSION = \"";
	protected final String TEXT_10 = "\";";
	protected final String TEXT_11 = NL;
	protected final String TEXT_12 = NL + "\t/**" + NL + "\t * The cached invocation delegate for the '{@link #";
	protected final String TEXT_13 = "(";
	protected final String TEXT_14 = ") <em>";
	protected final String TEXT_15 = "</em>}' operation." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see #";
	protected final String TEXT_16 = "(";
	protected final String TEXT_17 = ")" + NL + "\t * @generated" + NL + "\t * @ordered" + NL + "\t */" + NL + "\tprotected static final ";
	protected final String TEXT_18 = ".Internal.InvocationDelegate ";
	protected final String TEXT_19 = "__EINVOCATION_DELEGATE = ((";
	protected final String TEXT_20 = ".Internal)";
	protected final String TEXT_21 = ").getInvocationDelegate();" + NL;
	protected final String TEXT_22 = NL;
	protected final String TEXT_23 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_24 = NL;
	protected final String TEXT_25 = NL + "\t";
	protected final String TEXT_26 = " ";
	protected final String TEXT_27 = "(";
	protected final String TEXT_28 = ")";
	protected final String TEXT_29 = ";" + NL;
	protected final String TEXT_30 = NL + "\tpublic ";
	protected final String TEXT_31 = " ";
	protected final String TEXT_32 = "(";
	protected final String TEXT_33 = ")";
	protected final String TEXT_34 = NL + "\t{";
	protected final String TEXT_35 = NL + "\t\t";
	protected final String TEXT_36 = NL + "\t\treturn" + NL + "\t\t\t";
	protected final String TEXT_37 = ".validate" + NL + "\t\t\t\t(";
	protected final String TEXT_38 = "," + NL + "\t\t\t\t this," + NL + "\t\t\t\t ";
	protected final String TEXT_39 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_40 = "," + NL + "\t\t\t\t \"";
	protected final String TEXT_41 = "\",";
	protected final String TEXT_42 = NL + "\t\t\t\t ";
	protected final String TEXT_43 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_44 = "__EEXPRESSION," + NL + "\t\t\t\t ";
	protected final String TEXT_45 = ".ERROR," + NL + "\t\t\t\t ";
	protected final String TEXT_46 = ".DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t ";
	protected final String TEXT_47 = ".";
	protected final String TEXT_48 = ");";
	protected final String TEXT_49 = NL + "\t\t// TODO: implement this method" + NL + "\t\t// -> specify the condition that violates the invariant" + NL + "\t\t// -> verify the details of the diagnostic, including severity and message" + NL + "\t\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t\tif (false)" + NL + "\t\t{" + NL + "\t\t\tif (";
	protected final String TEXT_50 = " != null)" + NL + "\t\t\t{" + NL + "\t\t\t\t";
	protected final String TEXT_51 = ".add" + NL + "\t\t\t\t\t(new ";
	protected final String TEXT_52 = NL + "\t\t\t\t\t\t(";
	protected final String TEXT_53 = ".ERROR," + NL + "\t\t\t\t\t\t ";
	protected final String TEXT_54 = ".DIAGNOSTIC_SOURCE," + NL + "\t\t\t\t\t\t ";
	protected final String TEXT_55 = ".";
	protected final String TEXT_56 = "," + NL + "\t\t\t\t\t\t ";
	protected final String TEXT_57 = ".INSTANCE.getString(\"_UI_GenericInvariant_diagnostic\", new Object[] { \"";
	protected final String TEXT_58 = "\", ";
	protected final String TEXT_59 = ".getObjectLabel(this, ";
	protected final String TEXT_60 = ") }),";
	protected final String TEXT_61 = NL + "\t\t\t\t\t\t new Object [] { this }));" + NL + "\t\t\t}" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\treturn true;";
	protected final String TEXT_62 = NL + "\t\ttry" + NL + "\t\t{";
	protected final String TEXT_63 = NL + "\t\t\t";
	protected final String TEXT_64 = "__EINVOCATION_DELEGATE.dynamicInvoke(this, ";
	protected final String TEXT_65 = "new ";
	protected final String TEXT_66 = ".UnmodifiableEList<Object>(";
	protected final String TEXT_67 = ", ";
	protected final String TEXT_68 = ")";
	protected final String TEXT_69 = "null";
	protected final String TEXT_70 = ");";
	protected final String TEXT_71 = NL + "\t\t\treturn ";
	protected final String TEXT_72 = "(";
	protected final String TEXT_73 = "(";
	protected final String TEXT_74 = ")";
	protected final String TEXT_75 = "__EINVOCATION_DELEGATE.dynamicInvoke(this, ";
	protected final String TEXT_76 = "new ";
	protected final String TEXT_77 = ".UnmodifiableEList<Object>(";
	protected final String TEXT_78 = ", ";
	protected final String TEXT_79 = ")";
	protected final String TEXT_80 = "null";
	protected final String TEXT_81 = ")";
	protected final String TEXT_82 = ").";
	protected final String TEXT_83 = "()";
	protected final String TEXT_84 = ";";
	protected final String TEXT_85 = NL + "\t\t}" + NL + "\t\tcatch (";
	protected final String TEXT_86 = " ite)" + NL + "\t\t{" + NL + "\t\t\tthrow new ";
	protected final String TEXT_87 = "(ite);" + NL + "\t\t}";
	protected final String TEXT_88 = NL;
	protected final String TEXT_89 = NL + "\t}" + NL;
	protected final String TEXT_90 = NL;
	protected final String TEXT_91 = NL;
	protected final String TEXT_92 = NL;
	protected final String TEXT_93 = NL;

	public InterfacegenOperationoverride() {
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

		List<Object> genOperationList = null;
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

		for (Object genOperationParameter : genOperationList) {
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

																this.genOperation = (org.eclipse.emf.codegen.ecore.genmodel.GenOperation) genOperationParameter;
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

		stringBuffer.append(TEXT_92);
		stringBuffer.append(TEXT_93);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("genOperation", this.genOperation);
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

	protected org.eclipse.emf.codegen.ecore.genmodel.GenOperation genOperation = null;

	public void set_genOperation(org.eclipse.emf.codegen.ecore.genmodel.GenOperation object) {
		this.genOperation = object;
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
		parameters.put("genOperation", this.genOperation);
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
		if (isImplementation) {
			if (genOperation.isInvariant() && genOperation.hasInvariantExpression()) {
				stringBuffer.append(TEXT_2);
				stringBuffer.append(genOperation.getName());
				stringBuffer.append(TEXT_3);
				stringBuffer.append(genOperation.getParameterTypes(", "));
				stringBuffer.append(TEXT_4);
				stringBuffer.append(genOperation.getFormattedName());
				stringBuffer.append(TEXT_5);
				stringBuffer.append(genOperation.getName());
				stringBuffer.append(TEXT_6);
				stringBuffer.append(genOperation.getParameterTypes(", "));
				stringBuffer.append(TEXT_7);
				stringBuffer.append(genModel.getImportedName("java.lang.String"));
				stringBuffer.append(TEXT_8);
				stringBuffer.append(CodeGenUtil.upperName(genClass.getUniqueName(genOperation), genModel.getLocale()));
				stringBuffer.append(TEXT_9);
				stringBuffer.append(genOperation.getInvariantExpression("\t\t"));
				stringBuffer.append(TEXT_10);
				stringBuffer.append(genModel.getNonNLS());
				stringBuffer.append(TEXT_11);
			} else if (genOperation.hasInvocationDelegate()) {
				stringBuffer.append(TEXT_12);
				stringBuffer.append(genOperation.getName());
				stringBuffer.append(TEXT_13);
				stringBuffer.append(genOperation.getParameterTypes(", "));
				stringBuffer.append(TEXT_14);
				stringBuffer.append(genOperation.getFormattedName());
				stringBuffer.append(TEXT_15);
				stringBuffer.append(genOperation.getName());
				stringBuffer.append(TEXT_16);
				stringBuffer.append(genOperation.getParameterTypes(", "));
				stringBuffer.append(TEXT_17);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EOperation"));
				stringBuffer.append(TEXT_18);
				stringBuffer.append(CodeGenUtil.upperName(genClass.getUniqueName(genOperation), genModel.getLocale()));
				stringBuffer.append(TEXT_19);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EOperation"));
				stringBuffer.append(TEXT_20);
				stringBuffer.append(genOperation.getQualifiedOperationAccessor());
				stringBuffer.append(TEXT_21);
			}
		}
		if (isInterface) {
			stringBuffer.append(TEXT_22);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.genOperation.javadoc.override" args="genOperation:genOperation,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genOperation", genOperation);
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
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_02HWUGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//Class/genOperation.javadoc.override.javajetinc
		} else {
			stringBuffer.append(TEXT_23);
			if (isJDK50) { //Class/genOperation.annotations.insert.javajetinc
				stringBuffer.append(TEXT_24);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.genOperation.annotations.insert" args="genOperation:genOperation,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("genOperation", genOperation);
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
					CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_02tzQGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

			}
		}
		if (!isImplementation) {
			stringBuffer.append(TEXT_25);
			stringBuffer.append(genOperation.getTypeParameters(genClass));
			stringBuffer.append(genOperation.getImportedType(genClass));
			stringBuffer.append(TEXT_26);
			stringBuffer.append(genOperation.getName());
			stringBuffer.append(TEXT_27);
			stringBuffer.append(genOperation.getParameters(genClass));
			stringBuffer.append(TEXT_28);
			stringBuffer.append(genOperation.getThrows(genClass));
			stringBuffer.append(TEXT_29);
		} else {
			stringBuffer.append(TEXT_30);
			stringBuffer.append(genOperation.getTypeParameters(genClass));
			stringBuffer.append(genOperation.getImportedType(genClass));
			stringBuffer.append(TEXT_31);
			stringBuffer.append(genOperation.getName());
			stringBuffer.append(TEXT_32);
			stringBuffer.append(genOperation.getParameters(genClass));
			stringBuffer.append(TEXT_33);
			stringBuffer.append(genOperation.getThrows(genClass));
			stringBuffer.append(TEXT_34);
			if (genOperation.hasBody()) {
				stringBuffer.append(TEXT_35);
				stringBuffer.append(genOperation.getBody(genModel.getIndentation(stringBuffer)));
			} else if (genOperation.isInvariant()) {
				GenClass opClass = genOperation.getGenClass();
				String diagnostics = genOperation.getGenParameters().get(0).getName();
				String context = genOperation.getGenParameters().get(1).getName();
				if (genOperation.hasInvariantExpression()) {
					stringBuffer.append(TEXT_36);
					stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
					stringBuffer.append(TEXT_37);
					stringBuffer.append(genClass.getQualifiedClassifierAccessor());
					stringBuffer.append(TEXT_38);
					stringBuffer.append(diagnostics);
					stringBuffer.append(TEXT_39);
					stringBuffer.append(context);
					stringBuffer.append(TEXT_40);
					stringBuffer.append(genOperation.getValidationDelegate());
					stringBuffer.append(TEXT_41);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(TEXT_42);
					stringBuffer.append(genOperation.getQualifiedOperationAccessor());
					stringBuffer.append(TEXT_43);
					stringBuffer.append(CodeGenUtil.upperName(genClass.getUniqueName(genOperation), genModel.getLocale()));
					stringBuffer.append(TEXT_44);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
					stringBuffer.append(TEXT_45);
					stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
					stringBuffer.append(TEXT_46);
					stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
					stringBuffer.append(TEXT_47);
					stringBuffer.append(opClass.getOperationID(genOperation));
					stringBuffer.append(TEXT_48);
				} else {
					stringBuffer.append(TEXT_49);
					stringBuffer.append(diagnostics);
					stringBuffer.append(TEXT_50);
					stringBuffer.append(diagnostics);
					stringBuffer.append(TEXT_51);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicDiagnostic"));
					stringBuffer.append(TEXT_52);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.Diagnostic"));
					stringBuffer.append(TEXT_53);
					stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
					stringBuffer.append(TEXT_54);
					stringBuffer.append(opClass.getGenPackage().getImportedValidatorClassName());
					stringBuffer.append(TEXT_55);
					stringBuffer.append(opClass.getOperationID(genOperation));
					stringBuffer.append(TEXT_56);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.plugin.EcorePlugin"));
					stringBuffer.append(TEXT_57);
					stringBuffer.append(genOperation.getName());
					stringBuffer.append(TEXT_58);
					stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.EObjectValidator"));
					stringBuffer.append(TEXT_59);
					stringBuffer.append(context);
					stringBuffer.append(TEXT_60);
					stringBuffer.append(genModel.getNonNLS());
					stringBuffer.append(genModel.getNonNLS(2));
					stringBuffer.append(TEXT_61);
				}
			} else if (genOperation.hasInvocationDelegate()) {
				int size = genOperation.getGenParameters().size();
				stringBuffer.append(TEXT_62);
				if (genOperation.isVoid()) {
					stringBuffer.append(TEXT_63);
					stringBuffer.append(CodeGenUtil.upperName(genClass.getUniqueName(genOperation), genModel.getLocale()));
					stringBuffer.append(TEXT_64);
					if (size > 0) {
						stringBuffer.append(TEXT_65);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
						stringBuffer.append(TEXT_66);
						stringBuffer.append(size);
						stringBuffer.append(TEXT_67);
						stringBuffer.append(genOperation.getParametersArray(genClass));
						stringBuffer.append(TEXT_68);
					} else {
						stringBuffer.append(TEXT_69);
					}
					stringBuffer.append(TEXT_70);
				} else {
					stringBuffer.append(TEXT_71);
					if (!isJDK50 && genOperation.isPrimitiveType()) {
						stringBuffer.append(TEXT_72);
					}
					stringBuffer.append(TEXT_73);
					stringBuffer.append(genOperation.getObjectType(genClass));
					stringBuffer.append(TEXT_74);
					stringBuffer.append(CodeGenUtil.upperName(genClass.getUniqueName(genOperation), genModel.getLocale()));
					stringBuffer.append(TEXT_75);
					if (size > 0) {
						stringBuffer.append(TEXT_76);
						stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.BasicEList"));
						stringBuffer.append(TEXT_77);
						stringBuffer.append(size);
						stringBuffer.append(TEXT_78);
						stringBuffer.append(genOperation.getParametersArray(genClass));
						stringBuffer.append(TEXT_79);
					} else {
						stringBuffer.append(TEXT_80);
					}
					stringBuffer.append(TEXT_81);
					if (!isJDK50 && genOperation.isPrimitiveType()) {
						stringBuffer.append(TEXT_82);
						stringBuffer.append(genOperation.getPrimitiveValueFunction());
						stringBuffer.append(TEXT_83);
					}
					stringBuffer.append(TEXT_84);
				}
				stringBuffer.append(TEXT_85);
				stringBuffer.append(genModel.getImportedName(isGWT ? "org.eclipse.emf.common.util.InvocationTargetException" : "java.lang.reflect.InvocationTargetException"));
				stringBuffer.append(TEXT_86);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.common.util.WrappedException"));
				stringBuffer.append(TEXT_87);
			} else {
				stringBuffer.append(TEXT_88);
				{
					//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.implementedGenOperation.TODO.override" args="genOperation:genOperation,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

					InternalPatternContext ictx = (InternalPatternContext) ctx;
					new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
					stringBuffer.setLength(0);

					final Map<String, Object> callParameters = new HashMap<String, Object>();
					callParameters.put("genOperation", genOperation);
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
					CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0229MGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
					stringBuffer.setLength(0);
				}

				//Class/implementedGenOperation.todo.override.javajetinc
			}
			stringBuffer.append(TEXT_89);
		}
		stringBuffer.append(TEXT_90);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.model.call.Interface.Interface.genOperation.insert" args="genOperation:genOperation,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50,isInterface:isInterface,isImplementation:isImplementation,isGWT:isGWT,publicStaticFinalFlag:publicStaticFinalFlag,singleWildcard:singleWildcard,negativeOffsetCorrection:negativeOffsetCorrection,positiveOffsetCorrection:positiveOffsetCorrection,negativeOperationOffsetCorrection:negativeOperationOffsetCorrection,positiveOperationOffsetCorrection:positiveOperationOffsetCorrection"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("genOperation", genOperation);
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
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_03AuMGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_91);
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