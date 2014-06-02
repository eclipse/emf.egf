//Generated on Mon Jun 02 19:03:24 CEST 2014 with EGF 1.1.0.qualifier
package org.eclipse.egf.emf.pattern.edit.call.ItemProvider;

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

public class ItemProvidernewChildDescriptorsAttributeFeatureinsert {
	protected static String nl;

	public static synchronized ItemProvidernewChildDescriptorsAttributeFeatureinsert create(String lineSeparator) {
		nl = lineSeparator;
		ItemProvidernewChildDescriptorsAttributeFeatureinsert result = new ItemProvidernewChildDescriptorsAttributeFeatureinsert();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public ItemProvidernewChildDescriptorsAttributeFeatureinsert() {
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

		List<Object> createDataTypeList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> createFeatureList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> delegatedFeatureList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> createClassifierList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> childCreationDataList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genPackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object createDataTypeParameter : createDataTypeList) {
			for (Object createFeatureParameter : createFeatureList) {
				for (Object delegatedFeatureParameter : delegatedFeatureList) {
					for (Object createClassifierParameter : createClassifierList) {
						for (Object childCreationDataParameter : childCreationDataList) {
							for (Object genClassParameter : genClassList) {
								for (Object genPackageParameter : genPackageList) {
									for (Object genModelParameter : genModelList) {

										this.createDataType = (org.eclipse.emf.codegen.ecore.genmodel.GenDataType) createDataTypeParameter;
										this.createFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) createFeatureParameter;
										this.delegatedFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) delegatedFeatureParameter;
										this.createClassifier = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier) createClassifierParameter;
										this.childCreationData = (org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData) childCreationDataParameter;
										this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
										this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
										this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;

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
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("createDataType", this.createDataType);
			parameterValues.put("createFeature", this.createFeature);
			parameterValues.put("delegatedFeature", this.delegatedFeature);
			parameterValues.put("createClassifier", this.createClassifier);
			parameterValues.put("childCreationData", this.childCreationData);
			parameterValues.put("genClass", this.genClass);
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenDataType createDataType = null;

	public void set_createDataType(org.eclipse.emf.codegen.ecore.genmodel.GenDataType object) {
		this.createDataType = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenFeature createFeature = null;

	public void set_createFeature(org.eclipse.emf.codegen.ecore.genmodel.GenFeature object) {
		this.createFeature = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenFeature delegatedFeature = null;

	public void set_delegatedFeature(org.eclipse.emf.codegen.ecore.genmodel.GenFeature object) {
		this.delegatedFeature = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenClassifier createClassifier = null;

	public void set_createClassifier(org.eclipse.emf.codegen.ecore.genmodel.GenClassifier object) {
		this.createClassifier = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData childCreationData = null;

	public void set_childCreationData(org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData object) {
		this.childCreationData = object;
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

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createDataType", this.createDataType);
		parameters.put("createFeature", this.createFeature);
		parameters.put("delegatedFeature", this.delegatedFeature);
		parameters.put("createClassifier", this.createClassifier);
		parameters.put("childCreationData", this.childCreationData);
		parameters.put("genClass", this.genClass);
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}