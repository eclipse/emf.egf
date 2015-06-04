//Generated with EGF 1.3.0.qualifier
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

public class PluginXML extends org.eclipse.egf.emf.pattern.base.GenModelText {
	protected static String nl;

	public static synchronized PluginXML create(String lineSeparator) {
		nl = lineSeparator;
		PluginXML result = new PluginXML();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>"
			+ NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL + "<plugin>";
	protected final String TEXT_5 = NL + "<plugin" + NL + "      name=\"%pluginName\"" + NL + "      id=\"";
	protected final String TEXT_6 = "\"" + NL + "      version=\"1.0.0\"" + NL
			+ "      provider-name=\"%providerName\">" + NL + "" + NL + "   <requires>";
	protected final String TEXT_7 = NL + "      <import plugin=\"";
	protected final String TEXT_8 = "\"";
	protected final String TEXT_9 = " export=\"true\"";
	protected final String TEXT_10 = "/>";
	protected final String TEXT_11 = NL + "   </requires>" + NL + "" + NL + "   <runtime>";
	protected final String TEXT_12 = NL + "      <library name=\"";
	protected final String TEXT_13 = ".jar\">";
	protected final String TEXT_14 = NL + "      <library name=\".\">";
	protected final String TEXT_15 = NL + "         <export name=\"*\"/>" + NL + "      </library>" + NL
			+ "   </runtime>" + NL;
	protected final String TEXT_16 = NL + "</plugin>" + NL;
	protected final String TEXT_17 = NL;
	protected final String TEXT_18 = NL;

	public PluginXML() {
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

		stringBuffer.append(TEXT_17);
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
		targetPathName = genModel.getTestsProjectDirectory() + "/plugin.xml";
		overwrite = true;
		encoding = "UTF-8";

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

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getTestsDirectory(), genModel,
				GenBaseGeneratorAdapter.TESTS_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "ensureProjectExists", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * Copyright (c) 2005 IBM Corporation and others.
		 * All rights reserved.   This program and the accompanying materials
		 * are made available under the terms of the Eclipse Public License v1.0
		 * which accompanies this distribution, and is available at
		 * http://www.eclipse.org/legal/epl-v10.html
		 * 
		 * Contributors: 
		 *   IBM - Initial API and implementation
		 */

		GenModel genModel = (GenModel) argument;
		/* Trick to import java.util.* without warnings */Iterator.class.getName();
		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#LogicalName=org.eclipse.egf.emf.pattern.base.HeaderXml" args="parameter:argument"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("argument", parameter);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore#__h1VkCwtEd-jc5T-XaRJlg",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_3);
		if (genModel.isBundleManifest()) {
			stringBuffer.append(TEXT_4);
		} else {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genModel.getTestsPluginID());
			stringBuffer.append(TEXT_6);
			for (String pluginID : genModel.getTestsRequiredPlugins()) {
				stringBuffer.append(TEXT_7);
				stringBuffer.append(pluginID);
				stringBuffer.append(TEXT_8);
				if (!pluginID.startsWith("org.eclipse.core.runtime")) {
					stringBuffer.append(TEXT_9);
				}
				stringBuffer.append(TEXT_10);
			}
			stringBuffer.append(TEXT_11);
			if (genModel.isRuntimeJar()) {
				stringBuffer.append(TEXT_12);
				stringBuffer.append(genModel.getTestsPluginID());
				stringBuffer.append(TEXT_13);
			} else {
				stringBuffer.append(TEXT_14);
			}
			stringBuffer.append(TEXT_15);
		}
		stringBuffer.append(TEXT_16);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenModel genModel = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.TestsProject");
		canGenerate = canGenerate && (genModel.getRuntimePlatform() != GenRuntimePlatform.GWT)
				&& (!(genModel.isBundleManifest())) && (!genModel.sameModelTestsProject());
		return canGenerate;
	}
}