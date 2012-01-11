//Generated on Wed Jan 11 17:47:35 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.emf.pattern.tests;

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

public class TestCase extends org.eclipse.egf.emf.pattern.base.GenClassJava {
	protected static String nl;

	public static synchronized TestCase create(String lineSeparator) {
		nl = lineSeparator;
		TestCase result = new TestCase();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";" + NL;
	protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL + " * A test case for the model object '<em><b>";
	protected final String TEXT_5 = "</b></em>'." + NL + " * <!-- end-user-doc -->";
	protected final String TEXT_6 = NL + " * <p>" + NL + " * The following features are tested:" + NL + " * <ul>";
	protected final String TEXT_7 = NL + " *   <li>{@link ";
	protected final String TEXT_8 = "#";
	protected final String TEXT_9 = "() <em>";
	protected final String TEXT_10 = "</em>}</li>";
	protected final String TEXT_11 = NL + " * </ul>" + NL + " * </p>";
	protected final String TEXT_12 = NL + " * <p>" + NL + " * The following operations are tested:" + NL + " * <ul>";
	protected final String TEXT_13 = NL + " *   <li>{@link ";
	protected final String TEXT_14 = "#";
	protected final String TEXT_15 = "(";
	protected final String TEXT_16 = ") <em>";
	protected final String TEXT_17 = "</em>}</li>";
	protected final String TEXT_18 = NL + " * </ul>" + NL + " * </p>";
	protected final String TEXT_19 = NL + " * @generated" + NL + " */" + NL + "public";
	protected final String TEXT_20 = " abstract";
	protected final String TEXT_21 = " class ";
	protected final String TEXT_22 = " extends ";
	protected final String TEXT_23 = NL + "{";
	protected final String TEXT_24 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_25 = " copyright = ";
	protected final String TEXT_26 = ";";
	protected final String TEXT_27 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_28 = " mofDriverNumber = \"";
	protected final String TEXT_29 = "\";";
	protected final String TEXT_30 = NL + NL + "\t/**" + NL + "\t * The fixture for this ";
	protected final String TEXT_31 = " test case." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
	protected final String TEXT_32 = " fixture = null;";
	protected final String TEXT_33 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void main(String[] args)" + NL + "\t{" + NL + "\t\t";
	protected final String TEXT_34 = ".run(";
	protected final String TEXT_35 = ".class);" + NL + "\t}";
	protected final String TEXT_36 = NL + NL + "\t/**" + NL + "\t * Constructs a new ";
	protected final String TEXT_37 = " test case with the given name." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_38 = "(String name)" + NL + "\t{" + NL + "\t\tsuper(name);" + NL + "\t}";
	protected final String TEXT_39 = NL + NL + "\t/**" + NL + "\t * Sets the fixture for this ";
	protected final String TEXT_40 = " test case." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFixture(";
	protected final String TEXT_41 = " fixture)" + NL + "\t{" + NL + "\t\tthis.fixture = fixture;" + NL + "\t}";
	protected final String TEXT_42 = NL + NL + "\t/**" + NL + "\t * Returns the fixture for this ";
	protected final String TEXT_43 = " test case." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_44 = NL + "\t@Override";
	protected final String TEXT_45 = NL + "\t";
	protected final String TEXT_46 = "protected";
	protected final String TEXT_47 = "private";
	protected final String TEXT_48 = " ";
	protected final String TEXT_49 = " getFixture()" + NL + "\t{";
	protected final String TEXT_50 = NL + "\t\treturn fixture;";
	protected final String TEXT_51 = NL + "\t\treturn (";
	protected final String TEXT_52 = ")fixture;";
	protected final String TEXT_53 = NL + "\t}";
	protected final String TEXT_54 = NL + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see junit.framework.TestCase#setUp()" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_55 = NL + "\t@Override";
	protected final String TEXT_56 = NL + "\t@SuppressWarnings(\"unchecked\")";
	protected final String TEXT_57 = NL + "\tprotected void setUp() throws Exception" + NL + "\t{";
	protected final String TEXT_58 = NL + "\t\tsetFixture((";
	protected final String TEXT_59 = ")";
	protected final String TEXT_60 = ".create(";
	protected final String TEXT_61 = "));";
	protected final String TEXT_62 = NL + "\t\tsetFixture(";
	protected final String TEXT_63 = ".create";
	protected final String TEXT_64 = "());";
	protected final String TEXT_65 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see junit.framework.TestCase#tearDown()" + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_66 = NL + "\t@Override";
	protected final String TEXT_67 = NL + "\tprotected void tearDown() throws Exception" + NL + "\t{" + NL + "\t\tsetFixture(null);" + NL + "\t}";
	protected final String TEXT_68 = NL;
	protected final String TEXT_69 = NL;
	protected final String TEXT_70 = NL;
	protected final String TEXT_71 = NL;
	protected final String TEXT_72 = NL + "} //";
	protected final String TEXT_73 = NL;
	protected final String TEXT_74 = NL;
	protected final String TEXT_75 = NL;

	public TestCase() {
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

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) parameterParameter;

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
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
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

		GenClass genClass = parameter;
		targetPath = genClass.getGenModel().getTestsDirectory();
		packageName = genClass.getGenPackage().getTestsPackageName();
		className = genClass.getTestCaseClassName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenClass genClass = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getTestsDirectory(), genModel, GenBaseGeneratorAdapter.TESTS_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * <copyright>
		 *
		 * Copyright (c) 2005, 2007 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 *
		 * Contributors:
		 *   IBM - Initial API and implementation
		 *
		 * </copyright>
		 */

		GenClass genClass = (GenClass) argument;
		GenPackage genPackage = genClass.getGenPackage();
		GenModel genModel = genPackage.getGenModel(); /* Trick to import java.util.* without warnings */
		Iterator.class.getName();
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
		stringBuffer.append(genPackage.getTestsPackageName());
		stringBuffer.append(TEXT_3);
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genClass.getFormattedName());
		stringBuffer.append(TEXT_5);
		if (!genClass.getImplementedGenFeatures().isEmpty()) {
			boolean first = true;
			for (GenFeature genFeature : genClass.getImplementedGenFeatures()) {
				if (genFeature.isTested() && !genFeature.isSuppressedGetVisibility()) {
					if (first) {
						first = false;
						stringBuffer.append(TEXT_6);
					}
					stringBuffer.append(TEXT_7);
					stringBuffer.append(genFeature.getGenClass().getQualifiedInterfaceName());
					stringBuffer.append(TEXT_8);
					stringBuffer.append(genFeature.getGetAccessor());
					stringBuffer.append(TEXT_9);
					stringBuffer.append(genFeature.getFormattedName());
					stringBuffer.append(TEXT_10);
				}
			}
			if (!first) {
				stringBuffer.append(TEXT_11);
			}
		}
		if (!genClass.getImplementedGenOperations().isEmpty()) {
			boolean first = true;
			for (GenOperation genOperation : genClass.getImplementedGenOperations()) {
				if (first) {
					first = false;
					stringBuffer.append(TEXT_12);
				}
				stringBuffer.append(TEXT_13);
				stringBuffer.append(genOperation.getGenClass().getQualifiedInterfaceName());
				stringBuffer.append(TEXT_14);
				stringBuffer.append(genOperation.getName());
				stringBuffer.append(TEXT_15);
				stringBuffer.append(genOperation.getParameterTypes(", "));
				stringBuffer.append(TEXT_16);
				stringBuffer.append(genOperation.getFormattedName());
				stringBuffer.append(TEXT_17);
			}
			if (!first) {
				stringBuffer.append(TEXT_18);
			}
		}
		stringBuffer.append(TEXT_19);
		if (genClass.isAbstract()) {
			stringBuffer.append(TEXT_20);
		}
		stringBuffer.append(TEXT_21);
		stringBuffer.append(genClass.getTestCaseClassName());
		stringBuffer.append(TEXT_22);
		stringBuffer.append(genClass.isModelRoot() ? genModel.getImportedName("junit.framework.TestCase") : genClass.getClassExtendsGenClass().getImportedTestCaseClassName());
		stringBuffer.append(TEXT_23);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_24);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_25);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_26);
			stringBuffer.append(genModel.getNonNLS());
		}
		if (genModel.getDriverNumber() != null) {
			stringBuffer.append(TEXT_27);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_28);
			stringBuffer.append(genModel.getDriverNumber());
			stringBuffer.append(TEXT_29);
			stringBuffer.append(genModel.getNonNLS());
		}
		if (genClass.isModelRoot()) {
			stringBuffer.append(TEXT_30);
			stringBuffer.append(genClass.getFormattedName());
			stringBuffer.append(TEXT_31);
			stringBuffer.append(genClass.getImportedInterfaceName());
			stringBuffer.append(genClass.getInterfaceWildTypeArguments());
			stringBuffer.append(TEXT_32);
		}
		if (!genClass.isAbstract()) {
			stringBuffer.append(TEXT_33);
			stringBuffer.append(genModel.getImportedName("junit.textui.TestRunner"));
			stringBuffer.append(TEXT_34);
			stringBuffer.append(genClass.getTestCaseClassName());
			stringBuffer.append(TEXT_35);
		}
		stringBuffer.append(TEXT_36);
		stringBuffer.append(genClass.getFormattedName());
		stringBuffer.append(TEXT_37);
		stringBuffer.append(genClass.getTestCaseClassName());
		stringBuffer.append(TEXT_38);
		if (genClass.isModelRoot()) {
			stringBuffer.append(TEXT_39);
			stringBuffer.append(genClass.getFormattedName());
			stringBuffer.append(TEXT_40);
			stringBuffer.append(genClass.getImportedInterfaceName());
			stringBuffer.append(genClass.getInterfaceWildTypeArguments());
			stringBuffer.append(TEXT_41);
		}
		stringBuffer.append(TEXT_42);
		stringBuffer.append(genClass.getFormattedName());
		stringBuffer.append(TEXT_43);
		if (!genClass.isModelRoot() && genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_44);
		}
		stringBuffer.append(TEXT_45);
		if (genModel.useGenerics()) {
			stringBuffer.append(TEXT_46);
		} else {
			stringBuffer.append(TEXT_47);
		}
		stringBuffer.append(TEXT_48);
		stringBuffer.append(genClass.getImportedInterfaceName());
		stringBuffer.append(genClass.getInterfaceWildTypeArguments());
		stringBuffer.append(TEXT_49);
		if (genClass.isModelRoot()) {
			stringBuffer.append(TEXT_50);
		} else {
			stringBuffer.append(TEXT_51);
			stringBuffer.append(genClass.getImportedInterfaceName());
			stringBuffer.append(genClass.getInterfaceWildTypeArguments());
			stringBuffer.append(TEXT_52);
		}
		stringBuffer.append(TEXT_53);
		if (!genClass.isAbstract()) {
			stringBuffer.append(TEXT_54);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_55);
			}
			if (genModel.useGenerics() && genClass.isMapEntry()) {
				stringBuffer.append(TEXT_56);
			}
			stringBuffer.append(TEXT_57);
			if (genClass.isMapEntry()) {
				stringBuffer.append(TEXT_58);
				stringBuffer.append(genClass.getImportedInterfaceName());
				stringBuffer.append(genClass.getInterfaceWildTypeArguments());
				stringBuffer.append(TEXT_59);
				stringBuffer.append(genPackage.getQualifiedEFactoryInternalInstanceAccessor());
				stringBuffer.append(TEXT_60);
				stringBuffer.append(genClass.getQualifiedClassifierAccessor());
				stringBuffer.append(TEXT_61);
			} else {
				stringBuffer.append(TEXT_62);
				stringBuffer.append(genPackage.getQualifiedEFactoryInternalInstanceAccessor());
				stringBuffer.append(TEXT_63);
				stringBuffer.append(genClass.getName());
				stringBuffer.append(TEXT_64);
			}
			stringBuffer.append(TEXT_65);
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_66);
			}
			stringBuffer.append(TEXT_67);
		}
		for (GenFeature genFeature : genClass.getImplementedGenFeatures()) {
			stringBuffer.append(TEXT_68);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.tests.call.TestCase.TestCase.implementedGenFeature.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genFeature", genFeature);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_09kCIWJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//TestCase/implementedGenFeature.override.javajetinc
		}
		for (GenOperation genOperation : genClass.getImplementedGenOperations()) {
			stringBuffer.append(TEXT_69);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.tests.call.TestCase.TestCase.implementedGenOperation.override" args="genOperation:genOperation,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("genOperation", genOperation);
				callParameters.put("genClass", genClass);
				callParameters.put("genPackage", genPackage);
				callParameters.put("genModel", genModel);
				CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_1Cx5UGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

			//TestCase/implementedGenOperation.override.javajetinc
		}
		stringBuffer.append(TEXT_70);
		stringBuffer.append(TEXT_71);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.tests.call.TestCase.TestCase.insert" args="genClass:genClass,genPackage:genPackage,genModel:genModel"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_1DYWQGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_72);
		stringBuffer.append(genClass.getTestCaseClassName());
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_73);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenClass genClass = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.TestsProject");
		canGenerate = canGenerate && true;
		return canGenerate;
	}
}