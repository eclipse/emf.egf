//Generated on Wed Mar 12 18:39:07 CET 2014 with EGF 1.1.0.qualifier
package org.eclipse.egf.emf.pattern.model;

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

public class SwitchClass extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
	protected static String nl;

	public static synchronized SwitchClass create(String lineSeparator) {
		nl = lineSeparator;
		SwitchClass result = new SwitchClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";" + NL;
	protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * The <b>Switch</b> for the model's inheritance hierarchy." + NL + " * It supports the call {@link #doSwitch(EObject) doSwitch(object)}" + NL
			+ " * to invoke the <code>caseXXX</code> method for each class of the model," + NL + " * starting with the actual class of the object" + NL + " * and proceeding up the inheritance hierarchy" + NL + " * until a non-null result is returned," + NL
			+ " * which is the result of the switch." + NL + " * <!-- end-user-doc -->" + NL + " * @see ";
	protected final String TEXT_5 = NL + " * @generated" + NL + " */" + NL + "public class ";
	protected final String TEXT_6 = " extends Switch";
	protected final String TEXT_7 = NL + "{";
	protected final String TEXT_8 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_9 = " copyright = ";
	protected final String TEXT_10 = ";";
	protected final String TEXT_11 = NL;
	protected final String TEXT_12 = NL + "\t/**" + NL + "\t * The cached model package" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected static ";
	protected final String TEXT_13 = " modelPackage;" + NL + "" + NL + "\t/**" + NL + "\t * Creates an instance of the switch." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_14 = "()" + NL + "\t{" + NL + "\t\tif (modelPackage == null)" + NL + "\t\t{" + NL + "\t\t\tmodelPackage = ";
	protected final String TEXT_15 = ".eINSTANCE;" + NL + "\t\t}" + NL + "\t}" + NL;
	protected final String TEXT_16 = NL + "\t/**" + NL + "\t * Checks whether this is a switch for the given package." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @parameter ePackage the package in question." + NL
			+ "\t * @return whether this is a switch for the given package." + NL + "\t * @generated" + NL + "\t */" + NL + "\t@Override" + NL + "\tprotected boolean isSwitchFor(EPackage ePackage)" + NL + "\t{" + NL + "\t\treturn ePackage == modelPackage;" + NL + "\t}";
	protected final String TEXT_17 = NL + "\t/**" + NL + "\t * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @return the first non-null result returned by a <code>caseXXX</code> call." + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_18 = " doSwitch(EObject theEObject)" + NL + "\t{" + NL + "\t\treturn doSwitch(theEObject.eClass(), theEObject);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL
			+ "\t * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @return the first non-null result returned by a <code>caseXXX</code> call." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
	protected final String TEXT_19 = " doSwitch(EClass theEClass, EObject theEObject)" + NL + "\t{" + NL + "\t\tif (theEClass.eContainer() == modelPackage)" + NL + "\t\t{" + NL + "\t\t\treturn doSwitch(theEClass.getClassifierID(), theEObject);" + NL + "\t\t}";
	protected final String TEXT_20 = NL + "\t\telse" + NL + "\t\t{";
	protected final String TEXT_21 = NL + "\t\t";
	protected final String TEXT_22 = "<";
	protected final String TEXT_23 = ">";
	protected final String TEXT_24 = " eSuperTypes = theEClass.getESuperTypes();" + NL + "\t\t";
	protected final String TEXT_25 = "return" + NL + "\t\t";
	protected final String TEXT_26 = "\teSuperTypes.isEmpty() ?" + NL + "\t\t";
	protected final String TEXT_27 = "\t\tdefaultCase(theEObject) :" + NL + "\t\t";
	protected final String TEXT_28 = "\t\tdoSwitch(";
	protected final String TEXT_29 = "(EClass)";
	protected final String TEXT_30 = "eSuperTypes.get(0), theEObject);";
	protected final String TEXT_31 = NL + "\t\t}";
	protected final String TEXT_32 = NL + "\t}";
	protected final String TEXT_33 = NL + NL + "\t/**" + NL + "\t * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @return the first non-null result returned by a <code>caseXXX</code> call." + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_34 = NL + "\t@Override";
	protected final String TEXT_35 = NL + "\tprotected ";
	protected final String TEXT_36 = " doSwitch(int classifierID, EObject theEObject)" + NL + "\t{" + NL + "\t\tswitch (classifierID)" + NL + "\t\t{";
	protected final String TEXT_37 = NL + "\t\t\tcase ";
	protected final String TEXT_38 = ".";
	protected final String TEXT_39 = ":" + NL + "\t\t\t{" + NL + "\t\t\t\t";
	protected final String TEXT_40 = "@SuppressWarnings(\"unchecked\") ";
	protected final String TEXT_41 = " ";
	protected final String TEXT_42 = " = (";
	protected final String TEXT_43 = ")theEObject;" + NL + "\t\t\t\t";
	protected final String TEXT_44 = " ";
	protected final String TEXT_45 = " = case";
	protected final String TEXT_46 = "(";
	protected final String TEXT_47 = ");";
	protected final String TEXT_48 = NL + "\t\t\t\tif (";
	protected final String TEXT_49 = " == null) ";
	protected final String TEXT_50 = " = ";
	protected final String TEXT_51 = "(";
	protected final String TEXT_52 = ")";
	protected final String TEXT_53 = "case";
	protected final String TEXT_54 = "(";
	protected final String TEXT_55 = "(";
	protected final String TEXT_56 = ")";
	protected final String TEXT_57 = ");";
	protected final String TEXT_58 = NL + "\t\t\t\tif (";
	protected final String TEXT_59 = " == null) ";
	protected final String TEXT_60 = " = defaultCase(theEObject);" + NL + "\t\t\t\treturn ";
	protected final String TEXT_61 = ";" + NL + "\t\t\t}";
	protected final String TEXT_62 = NL + "\t\t\tdefault: return defaultCase(theEObject);" + NL + "\t\t}" + NL + "\t}";
	protected final String TEXT_63 = NL + NL + "\t/**" + NL + "\t * Returns the result of interpreting the object as an instance of '<em>";
	protected final String TEXT_64 = "</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * This implementation returns null;" + NL + "\t * returning a non-null result will terminate the switch." + NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @param object the target of the switch." + NL + "\t * @return the result of interpreting the object as an instance of '<em>";
	protected final String TEXT_65 = "</em>'." + NL + "\t * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_66 = " case";
	protected final String TEXT_67 = "(";
	protected final String TEXT_68 = " object)" + NL + "\t{" + NL + "\t\treturn null;" + NL + "\t}";
	protected final String TEXT_69 = NL + NL + "\t/**" + NL + "\t * Returns the result of interpreting the object as an instance of '<em>EObject</em>'." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * This implementation returns null;" + NL
			+ "\t * returning a non-null result will terminate the switch, but this is the last case anyway." + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @param object the target of the switch." + NL
			+ "\t * @return the result of interpreting the object as an instance of '<em>EObject</em>'." + NL + "\t * @see #doSwitch(org.eclipse.emf.ecore.EObject)" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_70 = NL + "\t@Override";
	protected final String TEXT_71 = NL + "\tpublic ";
	protected final String TEXT_72 = " defaultCase(EObject object)" + NL + "\t{" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "} //";
	protected final String TEXT_73 = NL;
	protected final String TEXT_74 = NL;
	protected final String TEXT_75 = NL;

	public SwitchClass() {
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

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_74);
		stringBuffer.append(TEXT_75);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_preGenerate(new StringBuffer(), ictx);

		method_doGenerate(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_postGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenPackage genPackage = parameter;
		targetPath = genPackage.getGenModel().getModelDirectory();
		packageName = genPackage.getUtilitiesPackageName();
		className = genPackage.getSwitchClassName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenPackage genPackage = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * Copyright (c) 2002-2006 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 *
		 * Contributors:
		 *   IBM - Initial API and implementation
		 */

		GenPackage genPackage = (GenPackage) argument;
		GenModel genModel = genPackage.getGenModel();
		boolean supportsComposition = genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF27_VALUE;
		stringBuffer.append(TEXT_1);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genPackage.getUtilitiesPackageName());
		stringBuffer.append(TEXT_3);
		if (supportsComposition) {
			genModel.addImport("org.eclipse.emf.ecore.EObject");
			genModel.addImport("org.eclipse.emf.ecore.EPackage");
			genModel.addImport("org.eclipse.emf.ecore.util.Switch");
		} else {
			genModel.addImport("org.eclipse.emf.ecore.EClass");
			genModel.addImport("org.eclipse.emf.ecore.EObject");
		}
		if (!genPackage.hasJavaLangConflict() && !genPackage.getUtilitiesPackageName().equals(genPackage.getInterfacePackageName()))
			genModel.addImport(genPackage.getInterfacePackageName() + ".*");

		String templateParameterName = null;
		if (genModel.useGenerics()) {
			Set<String> usedNames = new HashSet<String>();
			for (GenEnum genEnum : genPackage.getGenEnums()) {
				usedNames.add(genEnum.getName());
			}
			for (GenClass genClass : genPackage.getAllSwitchGenClasses()) {
				if (!genClass.isDynamic() && !genClass.isExternalInterface()) {
					usedNames.add(genClass.getName());
				}
				for (GenTypeParameter genTypeParameter : genClass.getGenTypeParameters()) {
					usedNames.add(genTypeParameter.getName());
				}
			}
			templateParameterName = "T";
			for (int i = 1; usedNames.contains(templateParameterName); ++i) {
				templateParameterName = "T" + i;
			}
		}

		String templateParameters = genModel.useGenerics() ? "<" + templateParameterName + ">" : "";
		String returnType = genModel.useGenerics() ? templateParameterName : genModel.getImportedName("java.lang.Object");
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
		stringBuffer.append(TEXT_5);
		stringBuffer.append(genPackage.getSwitchClassName());
		stringBuffer.append(templateParameters);
		if (supportsComposition) {
			stringBuffer.append(TEXT_6);
			stringBuffer.append(templateParameters);
		}
		stringBuffer.append(TEXT_7);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_8);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_9);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_11);
		}
		stringBuffer.append(TEXT_12);
		stringBuffer.append(genPackage.getImportedPackageInterfaceName());
		stringBuffer.append(TEXT_13);
		stringBuffer.append(genPackage.getSwitchClassName());
		stringBuffer.append(TEXT_14);
		stringBuffer.append(genPackage.getImportedPackageInterfaceName());
		stringBuffer.append(TEXT_15);
		if (supportsComposition) {
			stringBuffer.append(TEXT_16);
		} else {
			boolean isUnnecessaryElse = genModel.isUnnecessaryElse();
			String indent = isUnnecessaryElse ? "" : "\t";
			stringBuffer.append(TEXT_17);
			stringBuffer.append(returnType);
			stringBuffer.append(TEXT_18);
			stringBuffer.append(returnType);
			stringBuffer.append(TEXT_19);
			if (!isUnnecessaryElse) {
				stringBuffer.append(TEXT_20);
			}
			stringBuffer.append(TEXT_21);
			stringBuffer.append(indent);
			stringBuffer.append(genModel.getImportedName("java.util.List"));
			if (genModel.useGenerics()) {
				stringBuffer.append(TEXT_22);
				stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.EClass"));
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_24);
			stringBuffer.append(indent);
			stringBuffer.append(TEXT_25);
			stringBuffer.append(indent);
			stringBuffer.append(TEXT_26);
			stringBuffer.append(indent);
			stringBuffer.append(TEXT_27);
			stringBuffer.append(indent);
			stringBuffer.append(TEXT_28);
			if (!genModel.useGenerics()) {
				stringBuffer.append(TEXT_29);
			}
			stringBuffer.append(TEXT_30);
			if (!isUnnecessaryElse) {
				stringBuffer.append(TEXT_31);
			}
			stringBuffer.append(TEXT_32);
		}
		stringBuffer.append(TEXT_33);
		if (supportsComposition) {
			stringBuffer.append(TEXT_34);
		}
		stringBuffer.append(TEXT_35);
		stringBuffer.append(returnType);
		stringBuffer.append(TEXT_36);
		for (GenClass genClass : genPackage.getGenClasses()) {
			if (!genClass.isEObject()) {
				String result = "result".equals(genClass.getSafeUncapName()) ? "theResult" : "result";
				stringBuffer.append(TEXT_37);
				stringBuffer.append(genPackage.getImportedPackageInterfaceName());
				stringBuffer.append(TEXT_38);
				stringBuffer.append(genPackage.getClassifierID(genClass));
				stringBuffer.append(TEXT_39);
				if (genClass.isUncheckedCast() || genClass.isMapEntry() && genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) {
					stringBuffer.append(TEXT_40);
				}
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(genClass.getInterfaceWildTypeArguments());
				stringBuffer.append(TEXT_41);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_42);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(genClass.getInterfaceWildTypeArguments());
				stringBuffer.append(TEXT_43);
				stringBuffer.append(returnType);
				stringBuffer.append(TEXT_44);
				stringBuffer.append(result);
				stringBuffer.append(TEXT_45);
				stringBuffer.append(genPackage.getClassUniqueName(genClass));
				stringBuffer.append(TEXT_46);
				stringBuffer.append(genClass.getSafeUncapName());
				stringBuffer.append(TEXT_47);
				for (GenClass baseGenClass : genClass.getSwitchGenClasses()) {
					stringBuffer.append(TEXT_48);
					stringBuffer.append(result);
					stringBuffer.append(TEXT_49);
					stringBuffer.append(result);
					stringBuffer.append(TEXT_50);
					if (genClass.isRawBaseClass(baseGenClass)) {
						stringBuffer.append(TEXT_51);
						stringBuffer.append(returnType);
						stringBuffer.append(TEXT_52);
					}
					stringBuffer.append(TEXT_53);
					stringBuffer.append(genPackage.getClassUniqueName(baseGenClass));
					stringBuffer.append(TEXT_54);
					if (genClass.isMapEntry()) {
						stringBuffer.append(TEXT_55);
						stringBuffer.append(baseGenClass.getImportedInterfaceName());
						stringBuffer.append(baseGenClass.getInterfaceTypeArguments());
						stringBuffer.append(TEXT_56);
					}
					stringBuffer.append(genClass.getSafeUncapName());
					stringBuffer.append(TEXT_57);
				}
				stringBuffer.append(TEXT_58);
				stringBuffer.append(result);
				stringBuffer.append(TEXT_59);
				stringBuffer.append(result);
				stringBuffer.append(TEXT_60);
				stringBuffer.append(result);
				stringBuffer.append(TEXT_61);
			}
		}
		stringBuffer.append(TEXT_62);
		for (GenClass genClass : genPackage.getAllSwitchGenClasses()) {
			stringBuffer.append(TEXT_63);
			stringBuffer.append(genClass.getFormattedName());
			stringBuffer.append(TEXT_64);
			stringBuffer.append(genClass.getFormattedName());
			stringBuffer.append(TEXT_65);
			stringBuffer.append(genClass.getTypeParameters());
			stringBuffer.append(returnType);
			stringBuffer.append(TEXT_66);
			stringBuffer.append(genPackage.getClassUniqueName(genClass));
			stringBuffer.append(TEXT_67);
			stringBuffer.append(genClass.getImportedInterfaceName());
			stringBuffer.append(genClass.getInterfaceTypeArguments());
			stringBuffer.append(TEXT_68);
		}
		stringBuffer.append(TEXT_69);
		if (supportsComposition) {
			stringBuffer.append(TEXT_70);
		}
		stringBuffer.append(TEXT_71);
		stringBuffer.append(returnType);
		stringBuffer.append(TEXT_72);
		stringBuffer.append(genPackage.getSwitchClassName());
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_73);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenPackage genPackage = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
		canGenerate = canGenerate && (genPackage.hasClassifiers() && genPackage.isAdapterFactory() && !genPackage.getGenClasses().isEmpty());
		return canGenerate;
	}
}