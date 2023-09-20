//Generated with EGF 1.6.3.202110291409
package org.eclipse.egf.emf.pattern.model;

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

public class AdapterFactoryClass extends org.eclipse.egf.emf.pattern.base.GenPackageJava {
	protected static String nl;

	public static synchronized AdapterFactoryClass create(String lineSeparator) {
		nl = lineSeparator;
		AdapterFactoryClass result = new AdapterFactoryClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "package ";
	protected final String TEXT_3 = ";" + NL;
	protected final String TEXT_4 = NL + NL + "/**" + NL + " * <!-- begin-user-doc -->" + NL
			+ " * The <b>Adapter Factory</b> for the model." + NL
			+ " * It provides an adapter <code>createXXX</code> method for each class of the model." + NL
			+ " * <!-- end-user-doc -->" + NL + " * @see ";
	protected final String TEXT_5 = NL + " * ";
	protected final String TEXT_6 = NL + " * @generated" + NL + " */";
	protected final String TEXT_7 = NL + "@Deprecated";
	protected final String TEXT_8 = NL + "@SuppressWarnings(\"deprecation\")";
	protected final String TEXT_9 = NL + "public class ";
	protected final String TEXT_10 = " extends AdapterFactoryImpl" + NL + "{";
	protected final String TEXT_11 = NL + "\t/**" + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
	protected final String TEXT_12 = " copyright = ";
	protected final String TEXT_13 = ";";
	protected final String TEXT_14 = NL;
	protected final String TEXT_15 = NL + "\t/**" + NL + "\t * The cached model package." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tprotected static ";
	protected final String TEXT_16 = " modelPackage;" + NL + "" + NL + "\t/**" + NL
			+ "\t * Creates an instance of the adapter factory." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
	protected final String TEXT_17 = "()" + NL + "\t{" + NL + "\t\tif (modelPackage == null)" + NL + "\t\t{" + NL
			+ "\t\t\tmodelPackage = ";
	protected final String TEXT_18 = ".eINSTANCE;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL
			+ "\t * Returns whether this factory is applicable for the type of the object." + NL
			+ "\t * <!-- begin-user-doc -->" + NL
			+ "\t * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model."
			+ NL + "\t * <!-- end-user-doc -->" + NL
			+ "\t * @return whether this factory is applicable for the type of the object." + NL + "\t * @generated"
			+ NL + "\t */";
	protected final String TEXT_19 = NL + "\t@Override";
	protected final String TEXT_20 = NL + "\tpublic boolean isFactoryForType(Object object)" + NL + "\t{" + NL
			+ "\t\tif (object == modelPackage)" + NL + "\t\t{" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL
			+ "\t\tif (object instanceof EObject)" + NL + "\t\t{" + NL
			+ "\t\t\treturn ((EObject)object).eClass().getEPackage() == modelPackage;" + NL + "\t\t}" + NL
			+ "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL
			+ "\t * The switch that delegates to the <code>createXXX</code> methods." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @generated" + NL + "\t */"
			+ NL + "\tprotected ";
	protected final String TEXT_21 = " modelSwitch =" + NL + "\t\tnew ";
	protected final String TEXT_22 = "()" + NL + "\t\t{";
	protected final String TEXT_23 = NL + "\t\t\t@Override";
	protected final String TEXT_24 = NL + "\t\t\tpublic ";
	protected final String TEXT_25 = " case";
	protected final String TEXT_26 = "(";
	protected final String TEXT_27 = " object)" + NL + "\t\t\t{" + NL + "\t\t\t\treturn create";
	protected final String TEXT_28 = "Adapter();" + NL + "\t\t\t}";
	protected final String TEXT_29 = " defaultCase(EObject object)" + NL + "\t\t\t{" + NL + "\t\t\t\treturn create";
	protected final String TEXT_30 = "Adapter();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "" + NL + "\t/**" + NL
			+ "\t * Creates an adapter for the <code>target</code>." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @param target the object to adapt." + NL
			+ "\t * @return the adapter for the <code>target</code>." + NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_31 = NL + "\tpublic Adapter createAdapter(Notifier target)" + NL + "\t{" + NL
			+ "\t\treturn ";
	protected final String TEXT_32 = "modelSwitch.doSwitch((EObject)target);" + NL + "\t}" + NL;
	protected final String TEXT_33 = NL + NL + "\t/**" + NL
			+ "\t * Creates a new adapter for an object of class '{@link ";
	protected final String TEXT_34 = " <em>";
	protected final String TEXT_35 = "</em>}'." + NL + "\t * <!-- begin-user-doc -->" + NL
			+ "\t * This default implementation returns null so that we can easily ignore cases;" + NL
			+ "\t * it's useful to ignore a case when inheritance will catch all the cases anyway." + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @return the new adapter." + NL + "\t * @see ";
	protected final String TEXT_36 = NL + "\t * ";
	protected final String TEXT_37 = NL + "\t * @generated" + NL + "\t */";
	protected final String TEXT_38 = NL + "\t\t@Deprecated";
	protected final String TEXT_39 = NL + "\tpublic Adapter create";
	protected final String TEXT_40 = "Adapter()" + NL + "\t{" + NL + "\t\treturn null;" + NL + "\t}";
	protected final String TEXT_41 = NL + NL + "\t/**" + NL + "\t * Creates a new adapter for the default case." + NL
			+ "\t * <!-- begin-user-doc -->" + NL + "\t * This default implementation returns null." + NL
			+ "\t * <!-- end-user-doc -->" + NL + "\t * @return the new adapter." + NL + "\t * @generated" + NL
			+ "\t */" + NL + "\tpublic Adapter create";
	protected final String TEXT_42 = "Adapter()" + NL + "\t{" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL
			+ "} //";
	protected final String TEXT_43 = NL;

	public AdapterFactoryClass() {
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

		stringBuffer.append(TEXT_43);
		stringBuffer.append(TEXT_43);
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

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		GenPackage genPackage = parameter;
		targetPath = genPackage.getGenModel().getModelDirectory();
		packageName = genPackage.getUtilitiesPackageName();
		className = genPackage.getAdapterFactoryClassName();

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenPackage genPackage = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getModelDirectory(), genModel,
				GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * Copyright (c) 2002-2006 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v2.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v20.html
		 *
		 * Contributors:
		 *   IBM - Initial API and implementation
		 */

		GenPackage genPackage = (GenPackage) argument;
		GenModel genModel = genPackage.getGenModel();
		/* Trick to import java.util.* without warnings */Iterator.class.getName();
		final boolean isJDK50 = genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
		stringBuffer.append(TEXT_1);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderJava" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_XHLrsCwtEd-jc5T-XaRJlg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genPackage.getUtilitiesPackageName());
		stringBuffer.append(TEXT_3);
		genModel.addImport("org.eclipse.emf.common.notify.Adapter");
		genModel.addImport("org.eclipse.emf.common.notify.Notifier");
		genModel.addImport("org.eclipse.emf.common.notify.impl.AdapterFactoryImpl");
		genModel.addImport("org.eclipse.emf.ecore.EObject");
		if (!genPackage.hasJavaLangConflict()
				&& !genPackage.getUtilitiesPackageName().equals(genPackage.getInterfacePackageName()))
			genModel.addImport(genPackage.getInterfacePackageName() + ".*");
		String typeArgument = genModel.useGenerics() ? "<Adapter>" : "";
		String returnType = genModel.useGenerics() ? "Adapter" : genModel.getImportedName("java.lang.Object");
		String adapterCast = genModel.useGenerics() ? "" : "(Adapter)";
		genModel.markImportLocation(stringBuffer);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genPackage.getQualifiedPackageInterfaceName());
		if (genPackage.hasAPITags()) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genPackage.getAPITags(genModel.getIndentation(stringBuffer)));
		}
		stringBuffer.append(TEXT_6);
		if (isJDK50 && genPackage.hasAPIDeprecatedTag()) {
			stringBuffer.append(TEXT_7);
		} else if (isJDK50 && GenModelUtil.hasAPIDeprecatedTag(genPackage.getAllSwitchGenClasses())) {
			stringBuffer.append(TEXT_8);
		}
		stringBuffer.append(TEXT_9);
		stringBuffer.append(genPackage.getAdapterFactoryClassName());
		stringBuffer.append(TEXT_10);
		if (genModel.hasCopyrightField()) {
			stringBuffer.append(TEXT_11);
			stringBuffer.append(genModel.getImportedName("java.lang.String"));
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genModel.getCopyrightFieldLiteral());
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genModel.getNonNLS());
			stringBuffer.append(TEXT_14);
		}
		stringBuffer.append(TEXT_15);
		stringBuffer.append(genPackage.getImportedPackageInterfaceName());
		stringBuffer.append(TEXT_16);
		stringBuffer.append(genPackage.getAdapterFactoryClassName());
		stringBuffer.append(TEXT_17);
		stringBuffer.append(genPackage.getImportedPackageInterfaceName());
		stringBuffer.append(TEXT_18);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_19);
		}
		stringBuffer.append(TEXT_20);
		stringBuffer.append(genPackage.getSwitchClassName());
		stringBuffer.append(typeArgument);
		stringBuffer.append(TEXT_21);
		stringBuffer.append(genPackage.getSwitchClassName());
		stringBuffer.append(typeArgument);
		stringBuffer.append(TEXT_22);
		for (GenClass genClass : genPackage.getAllSwitchGenClasses()) {
			if (genModel.useClassOverrideAnnotation()) {
				stringBuffer.append(TEXT_23);
			}
			stringBuffer.append(TEXT_24);
			stringBuffer.append(genClass.getTypeParameters());
			stringBuffer.append(returnType);
			stringBuffer.append(TEXT_25);
			stringBuffer.append(genPackage.getClassUniqueName(genClass));
			stringBuffer.append(TEXT_26);
			stringBuffer.append(genClass.getImportedInterfaceName());
			stringBuffer.append(genClass.getInterfaceTypeArguments());
			stringBuffer.append(TEXT_27);
			stringBuffer.append(genPackage.getClassUniqueName(genClass));
			stringBuffer.append(TEXT_28);
		}
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_23);
		}
		stringBuffer.append(TEXT_24);
		stringBuffer.append(returnType);
		stringBuffer.append(TEXT_29);
		stringBuffer.append(genPackage.getClassUniqueName(null));
		stringBuffer.append(TEXT_30);
		if (genModel.useClassOverrideAnnotation()) {
			stringBuffer.append(TEXT_19);
		}
		stringBuffer.append(TEXT_31);
		stringBuffer.append(adapterCast);
		stringBuffer.append(TEXT_32);
		for (GenClass genClass : genPackage.getAllSwitchGenClasses()) {
			stringBuffer.append(TEXT_33);
			stringBuffer.append(genClass.getRawQualifiedInterfaceName());
			stringBuffer.append(TEXT_34);
			stringBuffer.append(genClass.getFormattedName());
			stringBuffer.append(TEXT_35);
			stringBuffer.append(genClass.getRawQualifiedInterfaceName());
			if (genClass.hasAPITags()) {
				stringBuffer.append(TEXT_36);
				stringBuffer.append(genClass.getAPITags(genModel.getIndentation(stringBuffer)));
			}
			stringBuffer.append(TEXT_37);
			if (isJDK50 && genClass.hasAPIDeprecatedTag()) {
				stringBuffer.append(TEXT_38);
			}
			stringBuffer.append(TEXT_39);
			stringBuffer.append(genPackage.getClassUniqueName(genClass));
			stringBuffer.append(TEXT_40);
		}
		stringBuffer.append(TEXT_41);
		stringBuffer.append(genPackage.getClassUniqueName(null));
		stringBuffer.append(TEXT_42);
		stringBuffer.append(genPackage.getAdapterFactoryClassName());
		genModel.emitSortedImports();
		stringBuffer.append(TEXT_14);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenPackage genPackage = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
		canGenerate = canGenerate && (genPackage.hasClassifiers() && genPackage.isAdapterFactory()
				&& !genPackage.getGenClasses().isEmpty());
		return canGenerate;
	}
}