//Generated with EGF 1.6.3.202110291409
package org.eclipse.egf.emf.pattern.edit;

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

public class PluginProperties extends org.eclipse.egf.emf.pattern.base.GenModelProperties {
	protected static String nl;

	public static synchronized PluginProperties create(String lineSeparator) {
		nl = lineSeparator;
		PluginProperties result = new PluginProperties();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + NL + "pluginName = ";
	protected final String TEXT_3 = NL + "providerName = ";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL + "_UI_CreateChild_text = {0}" + NL + "_UI_CreateChild_text2 = {1} ";
	protected final String TEXT_6 = "| ";
	protected final String TEXT_7 = "{0}" + NL + "_UI_CreateChild_text3 = {1}" + NL
			+ "_UI_CreateChild_tooltip = Create New {0} Under {1} Feature" + NL
			+ "_UI_CreateChild_description = Create a new child of type {0} for the {1} feature of the selected {2}."
			+ NL
			+ "_UI_CreateSibling_description = Create a new sibling of type {0} for the selected {2}, under the {1} feature of their parent."
			+ NL;
	protected final String TEXT_8 = NL + "_UI_PropertyDescriptor_description = The {0} of the {1}" + NL;
	protected final String TEXT_9 = NL + "_UI_";
	protected final String TEXT_10 = "_type = ";
	protected final String TEXT_11 = NL + "_UI_Unknown_type = Object" + NL + "" + NL + "_UI_Unknown_datatype= Value"
			+ NL;
	protected final String TEXT_12 = "_";
	protected final String TEXT_13 = "_feature = ";
	protected final String TEXT_14 = "_description = ";
	protected final String TEXT_15 = NL + "_UI_Unknown_feature = Unspecified" + NL;
	protected final String TEXT_16 = "_literal = ";
	protected final String TEXT_17 = " = ";
	protected final String TEXT_18 = NL;

	public PluginProperties() {
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

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_18);
		stringBuffer.append(TEXT_18);
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

		GenModel genModel = parameter;
		targetPathName = genModel.getEditProjectDirectory() + "/" + genModel.getEditBundleLocalization()
				+ ".properties";

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setReporterVariables", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenModel genModel = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setArgument", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditDirectory(), genModel,
				GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * Copyright (c) 2002-2007 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v2.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v20.html
		 * 
		 * Contributors: 
		 *   IBM - Initial API and implementation
		 */

		GenModel genModel = (GenModel) argument;
		/* Trick to import java.util.* without warnings */Iterator.class.getName();
		stringBuffer.append(TEXT_1);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderProperties" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#_FEoPwCwuEd-jc5T-XaRJlg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(genModel.getEditBundleName());
		stringBuffer.append(TEXT_3);
		stringBuffer.append(genModel.getEditBundleVendorName());
		if (genModel.getRuntimePlatform() != GenRuntimePlatform.GWT) {
			stringBuffer.append(TEXT_4);
			if (genModel.isCreationCommands()) {
				stringBuffer.append(TEXT_5);
				if (genModel.isCreationSubmenus()) {
					stringBuffer.append(TEXT_6);
				}
				stringBuffer.append(TEXT_7);
			}
			stringBuffer.append(TEXT_8);
			for (GenPackage genPackage : genModel.getAllGenAndUsedGenPackagesWithClassifiers()) {
				if (genPackage.getGenModel() == genModel || !genPackage.getGenModel().hasEditSupport()) {
					for (GenClass genClass : genPackage.getGenClasses()) {
						stringBuffer.append(TEXT_9);
						stringBuffer.append(genClass.getName());
						stringBuffer.append(TEXT_10);
						stringBuffer.append(genClass.getFormattedName());
					}
				}
			}
			stringBuffer.append(TEXT_11);
			for (GenFeature genFeature : genModel.getFilteredAllGenFeatures()) {
				String description = genFeature.getPropertyDescription();
				stringBuffer.append(TEXT_9);
				stringBuffer.append(genFeature.getGenClass().getName());
				stringBuffer.append(TEXT_12);
				stringBuffer.append(genFeature.getName());
				stringBuffer.append(TEXT_13);
				stringBuffer.append(genFeature.getFormattedName());
				if (description != null && description.length() > 0) {
					stringBuffer.append(TEXT_9);
					stringBuffer.append(genFeature.getGenClass().getName());
					stringBuffer.append(TEXT_12);
					stringBuffer.append(genFeature.getName());
					stringBuffer.append(TEXT_14);
					stringBuffer.append(description);
				}
			}
			stringBuffer.append(TEXT_15);
			for (GenPackage genPackage : genModel.getAllGenAndUsedGenPackagesWithClassifiers()) {
				if (genPackage.getGenModel() == genModel || !genPackage.getGenModel().hasEditSupport()) {
					for (GenEnum genEnum : genPackage.getGenEnums()) {
						for (GenEnumLiteral genEnumLiteral : genEnum.getGenEnumLiterals()) {
							stringBuffer.append(TEXT_9);
							stringBuffer.append(genEnum.getName());
							stringBuffer.append(TEXT_12);
							stringBuffer.append(genEnumLiteral.getName());
							stringBuffer.append(TEXT_16);
							stringBuffer.append(genEnumLiteral.getLiteral());
						}
					}
				}
			}
			for (String category : genModel.getPropertyCategories()) {
				stringBuffer.append(TEXT_4);
				stringBuffer.append(genModel.getPropertyCategoryKey(category));
				stringBuffer.append(TEXT_17);
				stringBuffer.append(category);
			}
		}
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenModel genModel = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
		canGenerate = canGenerate && (true);
		return canGenerate;
	}
}