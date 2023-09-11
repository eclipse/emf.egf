//Generated with EGF 1.6.3.202110291409
package org.eclipse.egf.emf.pattern.edit.call.ItemProvider;

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

public class ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride {
	protected static String nl;

	public static synchronized ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride create(
			String lineSeparator) {
		nl = lineSeparator;
		ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride result = new ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL
			+ "\t\t\t\t(";
	protected final String TEXT_2 = "," + NL + "\t\t\t\t ";
	protected final String TEXT_3 = ".createEntry" + NL + "\t\t\t\t\t(";
	protected final String TEXT_4 = ",";
	protected final String TEXT_5 = NL + "\t\t\t\t\t ";
	protected final String TEXT_6 = ".create(";
	protected final String TEXT_7 = "))));";
	protected final String TEXT_8 = ".create";
	protected final String TEXT_9 = "())));";
	protected final String TEXT_10 = NL;
	protected final String TEXT_11 = NL;

	public ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride() {
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

		List<Object> createClassList = null;
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
		List<Object> isJDK50List = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object createClassParameter : createClassList) {
			for (Object createFeatureParameter : createFeatureList) {
				for (Object delegatedFeatureParameter : delegatedFeatureList) {
					for (Object createClassifierParameter : createClassifierList) {
						for (Object childCreationDataParameter : childCreationDataList) {
							for (Object genClassParameter : genClassList) {
								for (Object genPackageParameter : genPackageList) {
									for (Object genModelParameter : genModelList) {
										for (Object isJDK50Parameter : isJDK50List) {

											this.createClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) createClassParameter;
											this.createFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) createFeatureParameter;
											this.delegatedFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) delegatedFeatureParameter;
											this.createClassifier = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier) createClassifierParameter;
											this.childCreationData = (org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData) childCreationDataParameter;
											this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
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

		stringBuffer.append(TEXT_11);
		stringBuffer.append(TEXT_11);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("createClass", this.createClass);
			parameterValues.put("createFeature", this.createFeature);
			parameterValues.put("delegatedFeature", this.delegatedFeature);
			parameterValues.put("createClassifier", this.createClassifier);
			parameterValues.put("childCreationData", this.childCreationData);
			parameterValues.put("genClass", this.genClass);
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("isJDK50", this.isJDK50);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenClass createClass = null;

	public void set_createClass(org.eclipse.emf.codegen.ecore.genmodel.GenClass object) {
		this.createClass = object;
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

	protected java.lang.Boolean isJDK50 = null;

	public void set_isJDK50(java.lang.Boolean object) {
		this.isJDK50 = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createClass", this.createClass);
		parameters.put("createFeature", this.createFeature);
		parameters.put("delegatedFeature", this.delegatedFeature);
		parameters.put("createClassifier", this.createClassifier);
		parameters.put("childCreationData", this.childCreationData);
		parameters.put("genClass", this.genClass);
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		parameters.put("isJDK50", this.isJDK50);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
		stringBuffer.append(TEXT_2);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
		stringBuffer.append(TEXT_3);
		stringBuffer.append(delegatedFeature.getQualifiedFeatureAccessor());
		stringBuffer.append(TEXT_4);
		if (createClass.isMapEntry()) {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
			stringBuffer.append(TEXT_6);
			stringBuffer.append(createClass.getQualifiedClassifierAccessor());
			stringBuffer.append(TEXT_7);
		} else {
			stringBuffer.append(TEXT_5);
			stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
			stringBuffer.append(TEXT_8);
			stringBuffer.append(createClass.getName());
			stringBuffer.append(TEXT_9);
		}
		stringBuffer.append(TEXT_10);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceDelegatedFeature.insert" args="createClass:createClass,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel,isJDK50:isJDK50"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("createClass", createClass);
			callParameters.put("createFeature", createFeature);
			callParameters.put("delegatedFeature", delegatedFeature);
			callParameters.put("createClassifier", createClassifier);
			callParameters.put("childCreationData", childCreationData);
			callParameters.put("genClass", genClass);
			callParameters.put("genPackage", genPackage);
			callParameters.put("genModel", genModel);
			callParameters.put("isJDK50", isJDK50);
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04NBAGJ-Ed-FqczH3ESmRw",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_10);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}