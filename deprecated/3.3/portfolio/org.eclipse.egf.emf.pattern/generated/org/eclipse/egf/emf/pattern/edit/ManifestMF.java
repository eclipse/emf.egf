package org.eclipse.egf.emf.pattern.edit;

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

public class ManifestMF extends org.eclipse.egf.emf.pattern.base.GenModelText {
	protected static String nl;

	public static synchronized ManifestMF create(String lineSeparator) {
		nl = lineSeparator;
		ManifestMF result = new ManifestMF();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "Manifest-Version: 1.0" + NL + "Bundle-ManifestVersion: 2" + NL + "Bundle-Name: %pluginName" + NL + "Bundle-SymbolicName: ";
	protected final String TEXT_2 = "; singleton:=true" + NL + "Bundle-Version: 1.0.0" + NL + "Bundle-ClassPath: ";
	protected final String TEXT_3 = ".jar";
	protected final String TEXT_4 = ".";
	protected final String TEXT_5 = NL + "Bundle-Activator: ";
	protected final String TEXT_6 = "$Implementation" + NL + "Bundle-Vendor: %providerName" + NL + "Bundle-Localization: plugin";
	protected final String TEXT_7 = NL + "Bundle-RequiredExecutionEnvironment: J2SE-1.5";
	protected final String TEXT_8 = NL + "Bundle-RequiredExecutionEnvironment: JavaSE-1.6";
	protected final String TEXT_9 = NL + "Export-Package: ";
	protected final String TEXT_10 = ",";
	protected final String TEXT_11 = NL + " ";
	protected final String TEXT_12 = NL + "Require-Bundle: ";
	protected final String TEXT_13 = ";visibility:=reexport";
	protected final String TEXT_14 = ",";
	protected final String TEXT_15 = NL + " ";
	protected final String TEXT_16 = ";visibility:=reexport";
	protected final String TEXT_17 = NL + "Eclipse-LazyStart: true" + NL;
	protected final String TEXT_18 = NL;
	protected final String TEXT_19 = NL;

	public ManifestMF() {
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

			if (preCondition()) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_18);
		stringBuffer.append(TEXT_19);
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

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenModel genModel = parameter;
		targetPathName = genModel.getEditProjectDirectory() + "/META-INF/MANIFEST.MF";
		overwrite = genModel.isUpdateClasspath() && !new CodegenGeneratorAdapter(parameter).exists(new CodegenGeneratorAdapter(parameter).toURI(genModel.getEditProjectDirectory()).appendSegment("plugin.xml"));
		encoding = "UTF-8";

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		GenModel genModel = parameter;
		argument = parameter;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditDirectory(), genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * <copyright>
		 *
		 * Copyright (c) 2005 IBM Corporation and others.
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

		GenModel genModel = (GenModel) argument;
		stringBuffer.append(TEXT_1);
		stringBuffer.append(genModel.getEditPluginID());
		stringBuffer.append(TEXT_2);
		if (genModel.isRuntimeJar()) {
			stringBuffer.append(genModel.getEditPluginID());
			stringBuffer.append(TEXT_3);
		} else {
			stringBuffer.append(TEXT_4);
		}
		stringBuffer.append(TEXT_5);
		stringBuffer.append(genModel.getQualifiedEditPluginClassName());
		stringBuffer.append(TEXT_6);
		if (genModel.getComplianceLevel() == GenJDKLevel.JDK50_LITERAL) {
			stringBuffer.append(TEXT_7);
		} else if (genModel.getComplianceLevel() == GenJDKLevel.JDK60_LITERAL) {
			stringBuffer.append(TEXT_8);
		}
		Iterator<String> packagesIterator = genModel.getEditQualifiedPackageNames().iterator();
		if (packagesIterator.hasNext()) {
			String pack = packagesIterator.next();
			stringBuffer.append(TEXT_9);
			stringBuffer.append(pack);
			while (packagesIterator.hasNext()) {
				pack = packagesIterator.next();
				stringBuffer.append(TEXT_10);
				stringBuffer.append(TEXT_11);
				stringBuffer.append(pack);
			}
		}
		Iterator<String> requiredPluginIterator = genModel.getEditRequiredPlugins().iterator();
		if (requiredPluginIterator.hasNext()) {
			String pluginID = requiredPluginIterator.next();
			stringBuffer.append(TEXT_12);
			stringBuffer.append(pluginID);
			if (!pluginID.startsWith("org.eclipse.core.runtime")) {
				stringBuffer.append(TEXT_13);
			}
			while (requiredPluginIterator.hasNext()) {
				pluginID = requiredPluginIterator.next();
				stringBuffer.append(TEXT_14);
				stringBuffer.append(TEXT_15);
				stringBuffer.append(pluginID);
				if (!pluginID.startsWith("org.eclipse.core.runtime")) {
					stringBuffer.append(TEXT_16);
				}
			}
		}
		stringBuffer.append(TEXT_17);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		GenModel genModel = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
		canGenerate = canGenerate && (genModel.isBundleManifest() && !new CodegenGeneratorAdapter(parameter).exists(new CodegenGeneratorAdapter(parameter).toURI(genModel.getEditProjectDirectory()).appendSegment("plugin.xml"))) && (!genModel.sameEditEditorProject());
		return canGenerate;
	}
}