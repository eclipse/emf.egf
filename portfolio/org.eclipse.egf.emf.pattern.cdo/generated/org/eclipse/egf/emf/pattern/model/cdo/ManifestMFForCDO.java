//Generated with EGF 1.6.3.202110181143
package org.eclipse.egf.emf.pattern.model.cdo;

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

public class ManifestMFForCDO extends org.eclipse.egf.emf.pattern.model.ManifestMF {
	protected static String nl;

	public static synchronized ManifestMFForCDO create(String lineSeparator) {
		nl = lineSeparator;
		ManifestMFForCDO result = new ManifestMFForCDO();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "Manifest-Version: 1.0" + NL + "Bundle-ManifestVersion: 2" + NL
			+ "Bundle-Name: %pluginName" + NL + "Bundle-SymbolicName: ";
	protected final String TEXT_2 = ";singleton:=true" + NL + "Bundle-Version: 1.0.0" + NL + "Bundle-ClassPath: ";
	protected final String TEXT_3 = ".jar";
	protected final String TEXT_4 = ".";
	protected final String TEXT_5 = NL + "Bundle-Activator: ";
	protected final String TEXT_6 = "$Implementation";
	protected final String TEXT_7 = NL + "Bundle-Vendor: %providerName" + NL + "Bundle-Localization: plugin";
	protected final String TEXT_8 = NL + "Bundle-RequiredExecutionEnvironment: J2SE-1.5";
	protected final String TEXT_9 = NL + "Bundle-RequiredExecutionEnvironment: JavaSE-1.6";
	protected final String TEXT_10 = NL + "Export-Package: ";
	protected final String TEXT_11 = ",";
	protected final String TEXT_12 = NL + " ";
	protected final String TEXT_13 = NL + "Import-Package: ";
	protected final String TEXT_14 = NL + "Require-Bundle: ";
	protected final String TEXT_15 = ";visibility:=reexport";
	protected final String TEXT_16 = NL + "Eclipse-LazyStart: true";
	protected final String TEXT_17 = NL + "Bundle-ActivationPolicy: lazy" + NL;
	protected final String TEXT_18 = NL;

	public ManifestMFForCDO() {
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

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		/**
		 * <copyright>
		 *
		 * Copyright (c) 2005-2007 IBM Corporation and others.
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
		stringBuffer.append(genModel.getModelPluginID());
		stringBuffer.append(TEXT_2);
		if (genModel.isRuntimeJar()) {
			stringBuffer.append(genModel.getModelPluginID());
			stringBuffer.append(TEXT_3);
		} else {
			stringBuffer.append(TEXT_4);
		}
		if (genModel.hasModelPluginClass()) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(genModel.getQualifiedModelPluginClassName());
			stringBuffer.append(TEXT_6);
		}
		stringBuffer.append(TEXT_7);
		if (genModel.getComplianceLevel() == GenJDKLevel.JDK50_LITERAL) {
			stringBuffer.append(TEXT_8);
		} else if (genModel.getComplianceLevel() == GenJDKLevel.JDK60_LITERAL) {
			stringBuffer.append(TEXT_9);
		}

		TreeIterator<GenPackage> genPackagesIterator = new AbstractTreeIterator<GenPackage>(genModel.getGenPackages(),
				false) {
			protected Iterator<GenPackage> getChildren(Object object) {
				return object instanceof Collection<?> ? ((Collection<GenPackage>) object).iterator()
						: ((GenPackage) object).getNestedGenPackages().iterator();
			}
		};

		if (genPackagesIterator.hasNext()) {
			GenPackage genPackage = genPackagesIterator.next();
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genPackage.getClassPackageName());
			while (genPackagesIterator.hasNext()) {
				genPackage = genPackagesIterator.next();
				stringBuffer.append(TEXT_11);
				stringBuffer.append(TEXT_12);
				stringBuffer.append(genPackage.getClassPackageName());
			}
		}

		TreeIterator<GenPackage> genPackagesIterator2 = new AbstractTreeIterator<GenPackage>(genModel.getGenPackages(),
				false) {
			protected Iterator<GenPackage> getChildren(Object object) {
				return object instanceof Collection<?> ? ((Collection<GenPackage>) object).iterator()
						: ((GenPackage) object).getNestedGenPackages().iterator();
			}
		};

		Iterator<GenPackage> usedGenPackagesIterator = genModel.getUsedGenPackages().iterator();

		if (genPackagesIterator2.hasNext()) {
			GenPackage genPackage = genPackagesIterator2.next();
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genPackage.getInterfacePackageName());
			while (genPackagesIterator2.hasNext()) {
				genPackage = genPackagesIterator2.next();
				stringBuffer.append(TEXT_11);
				stringBuffer.append(TEXT_12);
				stringBuffer.append(genPackage.getInterfacePackageName());
			}
			while (usedGenPackagesIterator.hasNext()) {
				genPackage = usedGenPackagesIterator.next();
				stringBuffer.append(TEXT_11);
				stringBuffer.append(TEXT_12);
				stringBuffer.append(genPackage.getInterfacePackageName());
			}
		}
		//we want to depend on cdo generated plugins before eventual others modelPluginVariables, because they may depend on the non cdo code
		List<String> modelRequiredPlugins = genModel.getModelRequiredPlugins();
		modelRequiredPlugins.removeAll(((GenModelImpl) genModel).getEffectiveModelPluginIDs());
		modelRequiredPlugins.addAll(((GenModelImpl) genModel).getEffectiveModelPluginIDs());
		Iterator<String> requiredPluginIterator = modelRequiredPlugins.iterator();
		if (requiredPluginIterator.hasNext()) {
			String pluginID = requiredPluginIterator.next();
			stringBuffer.append(TEXT_14);
			stringBuffer.append(pluginID);
			if (!pluginID.startsWith("org.eclipse.core.runtime")) {
				stringBuffer.append(TEXT_15);
			}
			while (requiredPluginIterator.hasNext()) {
				pluginID = requiredPluginIterator.next();
				stringBuffer.append(TEXT_11);
				stringBuffer.append(TEXT_12);
				stringBuffer.append(pluginID);
				if (!pluginID.startsWith("org.eclipse.core.runtime")) {
					stringBuffer.append(TEXT_15);
				}
			}
		}
		if (genModel.getRuntimeVersion() == GenRuntimeVersion.EMF22
				|| genModel.getRuntimeVersion() == GenRuntimeVersion.EMF23) {
			stringBuffer.append(TEXT_16);
		}
		stringBuffer.append(TEXT_17);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		GenModel genModel = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter)
				.canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.ModelProject");
		canGenerate = canGenerate && (genModel.isBundleManifest()) && (genModel.hasPluginSupport()
				&& !genModel.sameModelEditProject() && !genModel.sameModelEditorProject());
		return canGenerate;
	}
}