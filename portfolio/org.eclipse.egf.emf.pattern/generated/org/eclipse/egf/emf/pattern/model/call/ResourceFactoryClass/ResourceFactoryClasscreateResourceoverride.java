package org.eclipse.egf.emf.pattern.model.call.ResourceFactoryClass;

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

public class ResourceFactoryClasscreateResourceoverride {
	protected static String nl;

	public static synchronized ResourceFactoryClasscreateResourceoverride create(String lineSeparator) {
		nl = lineSeparator;
		ResourceFactoryClasscreateResourceoverride result = new ResourceFactoryClasscreateResourceoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t\t";
	protected final String TEXT_2 = " result = new ";
	protected final String TEXT_3 = "(uri);" + NL + "\t\tresult.getDefaultSaveOptions().put(";
	protected final String TEXT_4 = ".OPTION_EXTENDED_META_DATA, ";
	protected final String TEXT_5 = "Boolean.TRUE";
	protected final String TEXT_6 = "extendedMetaData";
	protected final String TEXT_7 = ");" + NL + "\t\tresult.getDefaultLoadOptions().put(";
	protected final String TEXT_8 = ".OPTION_EXTENDED_META_DATA, ";
	protected final String TEXT_9 = "Boolean.TRUE";
	protected final String TEXT_10 = "extendedMetaData";
	protected final String TEXT_11 = ");" + NL + "" + NL + "\t\tresult.getDefaultSaveOptions().put(";
	protected final String TEXT_12 = ".OPTION_SCHEMA_LOCATION, Boolean.TRUE);" + NL + "" + NL + "\t\tresult.getDefaultLoadOptions().put(";
	protected final String TEXT_13 = ".OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);" + NL + "\t\tresult.getDefaultSaveOptions().put(";
	protected final String TEXT_14 = ".OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);" + NL + "" + NL
			+ "\t\tresult.getDefaultLoadOptions().put(";
	protected final String TEXT_15 = ".OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);";
	protected final String TEXT_16 = NL + "\t\tresult.getDefaultLoadOptions().put(";
	protected final String TEXT_17 = ".OPTION_USE_DATA_CONVERTER, Boolean.TRUE);";
	protected final String TEXT_18 = NL + "\t\t";
	protected final String TEXT_19 = " result = new ";
	protected final String TEXT_20 = "(uri);" + NL + "\t\tresult.getDefaultSaveOptions().put(";
	protected final String TEXT_21 = ".OPTION_XML_MAP, xmlMap);" + NL + "\t\tresult.getDefaultLoadOptions().put(";
	protected final String TEXT_22 = ".OPTION_XML_MAP, xmlMap);";
	protected final String TEXT_23 = NL + "\t\tResource result = new ";
	protected final String TEXT_24 = "(uri);";
	protected final String TEXT_25 = NL + "\t\treturn result;" + NL;
	protected final String TEXT_26 = NL;
	protected final String TEXT_27 = NL;

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

		List<Object> genPackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genPackageParameter : genPackageList) {
			for (Object genModelParameter : genModelList) {

				this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
				this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;

				if (preCondition())
					orchestration(ctx);

			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
			ctx.clearBuffer();
		}

		stringBuffer.append(TEXT_26);
		stringBuffer.append(TEXT_27);
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
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			ictx.clearBuffer();
		}
		return loop;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage = null;

	public void set_genPackage(org.eclipse.emf.codegen.ecore.genmodel.GenPackage object) {
		this.genPackage = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;

	public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel object) {
		this.genModel = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		if (genPackage.hasExtendedMetaData()) {
			stringBuffer.append(TEXT_1);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_2);
			stringBuffer.append(genPackage.getResourceClassName());
			stringBuffer.append(TEXT_3);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_4);
			if (genPackage.hasTargetNamespace()) {
				stringBuffer.append(TEXT_5);
			} else {
				stringBuffer.append(TEXT_6);
			}
			stringBuffer.append(TEXT_7);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_8);
			if (genPackage.hasTargetNamespace()) {
				stringBuffer.append(TEXT_9);
			} else {
				stringBuffer.append(TEXT_10);
			}
			stringBuffer.append(TEXT_11);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_12);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_13);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_14);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_15);
			if (genPackage.isDataTypeConverters() && genPackage.hasDocumentRoot()) {
				stringBuffer.append(TEXT_16);
				stringBuffer.append(genPackage.getResourceClassName());
				stringBuffer.append(TEXT_17);
			}
		} else if (genPackage.hasXMLMap()) {
			stringBuffer.append(TEXT_18);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_19);
			stringBuffer.append(genPackage.getResourceClassName());
			stringBuffer.append(TEXT_20);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_21);
			stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.xmi.XMLResource"));
			stringBuffer.append(TEXT_22);
		} else {
			stringBuffer.append(TEXT_23);
			stringBuffer.append(genPackage.getResourceClassName());
			stringBuffer.append(TEXT_24);
		}
		stringBuffer.append(TEXT_25);
	}

	public boolean preCondition() throws Exception {
		return true;
	}
}