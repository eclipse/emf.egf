//Generated with EGF 1.6.0.201901231418
package org.eclipse.egf.emf.pattern.model.call.ResourceFactoryClass;

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

public class ResourceFactoryClasscreateResourceoverride {
	protected static String nl;

	public static synchronized ResourceFactoryClasscreateResourceoverride create(String lineSeparator) {
		nl = lineSeparator;
		ResourceFactoryClasscreateResourceoverride result = new ResourceFactoryClasscreateResourceoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL + "\t\t";
	protected final String TEXT_3 = " result = new ";
	protected final String TEXT_4 = "(uri);" + NL + "\t\tresult.getDefaultSaveOptions().put(";
	protected final String TEXT_5 = ".OPTION_EXTENDED_META_DATA, ";
	protected final String TEXT_6 = "Boolean.TRUE";
	protected final String TEXT_7 = "extendedMetaData";
	protected final String TEXT_8 = ");" + NL + "\t\tresult.getDefaultLoadOptions().put(";
	protected final String TEXT_9 = ");" + NL + "" + NL + "\t\tresult.getDefaultSaveOptions().put(";
	protected final String TEXT_10 = ".OPTION_SCHEMA_LOCATION, Boolean.TRUE);" + NL + "" + NL
			+ "\t\tresult.getDefaultLoadOptions().put(";
	protected final String TEXT_11 = ".OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);" + NL
			+ "\t\tresult.getDefaultSaveOptions().put(";
	protected final String TEXT_12 = ".OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);" + NL + "" + NL
			+ "\t\tresult.getDefaultLoadOptions().put(";
	protected final String TEXT_13 = ".OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);";
	protected final String TEXT_14 = NL + "\t\tresult.getDefaultLoadOptions().put(";
	protected final String TEXT_15 = ".OPTION_USE_DATA_CONVERTER, Boolean.TRUE);";
	protected final String TEXT_16 = ".OPTION_XML_MAP, xmlMap);" + NL + "\t\tresult.getDefaultLoadOptions().put(";
	protected final String TEXT_17 = ".OPTION_XML_MAP, xmlMap);";
	protected final String TEXT_18 = NL + "\t\tResource result = new ";
	protected final String TEXT_19 = "(uri);";
	protected final String TEXT_20 = NL + "\t\treturn result;" + NL;
	protected final String TEXT_21 = NL;

	public ResourceFactoryClasscreateResourceoverride() {
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

		List<Object> genPackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> isJDK50List = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genPackageParameter : genPackageList) {
			for (Object genModelParameter : genModelList) {
				for (Object isJDK50Parameter : isJDK50List) {

					this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
					this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
					this.isJDK50 = (java.lang.Boolean) isJDK50Parameter;

					if (preCondition(ctx)) {
						ctx.setNode(new Node.Container(currentNode, getClass()));
						orchestration(ctx);
					}

				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_21);
		stringBuffer.append(TEXT_21);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("isJDK50", this.isJDK50);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
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

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		parameters.put("isJDK50", this.isJDK50);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		if (genPackage.hasExtendedMetaData()) {
			stringBuffer.append(TEXT_2);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_3);
			stringBuffer.append(genPackage.getResourceClassName());
			stringBuffer.append(TEXT_4);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_5);
			if (genPackage.hasTargetNamespace()) {
				stringBuffer.append(TEXT_6);
			} else {
				stringBuffer.append(TEXT_7);
			}
			stringBuffer.append(TEXT_8);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_5);
			if (genPackage.hasTargetNamespace()) {
				stringBuffer.append(TEXT_6);
			} else {
				stringBuffer.append(TEXT_7);
			}
			stringBuffer.append(TEXT_9);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_10);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_11);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_13);
			if (genPackage.isDataTypeConverters() && genPackage.hasDocumentRoot()) {
				stringBuffer.append(TEXT_14);
				stringBuffer.append(genPackage.getResourceClassName());
				stringBuffer.append(TEXT_15);
			}
		} else if (genPackage.hasXMLMap()) {
			stringBuffer.append(TEXT_2);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_3);
			stringBuffer.append(genPackage.getResourceClassName());
			stringBuffer.append(TEXT_4);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_16);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_17);
		} else {
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genPackage.getResourceClassName());
			stringBuffer.append(TEXT_19);
		}
		stringBuffer.append(TEXT_20);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}