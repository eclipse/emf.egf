package org.eclipse.egf.portfolio.egf.type.edit.call.ItemProvider;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.egf.model.fcore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ItemProviderInvocationContractnewChildDescriptorsReferenceDelegatedFeatureoverride extends org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvidernewChildDescriptorsReferenceDelegatedFeatureoverride {
	protected static String nl;

	public static synchronized ItemProviderInvocationContractnewChildDescriptorsReferenceDelegatedFeatureoverride create(String lineSeparator) {
		nl = lineSeparator;
		ItemProviderInvocationContractnewChildDescriptorsReferenceDelegatedFeatureoverride result = new ItemProviderInvocationContractnewChildDescriptorsReferenceDelegatedFeatureoverride();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = NL + "        {" + NL + "            if (object.getInvokedContract() != null && object.getInvokedContract().getType() != null) {";
	protected final String TEXT_2 = NL + "                ";
	protected final String TEXT_3 = " invokedContractType = object.getInvokedContract().getType();";
	protected final String TEXT_4 = NL + "                ";
	protected final String TEXT_5 = " type = ";
	protected final String TEXT_6 = ".create";
	protected final String TEXT_7 = "();" + NL + "                if (invokedContractType.isCompatible(type)) {" + NL + "                    newChildDescriptors.add(createChildParameter(";
	protected final String TEXT_8 = ", ";
	protected final String TEXT_9 = ".createEntry(";
	protected final String TEXT_10 = ", type)));" + NL + "                }" + NL + "            }" + NL + "        }";
	protected final String TEXT_11 = NL;
	protected final String TEXT_12 = NL;
	protected final String TEXT_13 = NL;
	protected final String TEXT_14 = NL;

	public ItemProviderInvocationContractnewChildDescriptorsReferenceDelegatedFeatureoverride() {
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

		for (Object createClassParameter : createClassList) {
			for (Object createFeatureParameter : createFeatureList) {
				for (Object delegatedFeatureParameter : delegatedFeatureList) {
					for (Object createClassifierParameter : createClassifierList) {
						for (Object childCreationDataParameter : childCreationDataList) {
							for (Object genClassParameter : genClassList) {
								for (Object genPackageParameter : genPackageList) {
									for (Object genModelParameter : genModelList) {

										this.createClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) createClassParameter;
										this.createFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) createFeatureParameter;
										this.delegatedFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) delegatedFeatureParameter;
										this.createClassifier = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier) createClassifierParameter;
										this.childCreationData = (org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData) childCreationDataParameter;
										this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
										this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
										this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;

										if (preCondition()) {
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
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_13);
		stringBuffer.append(TEXT_14);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = Node.flattenWithoutCallback(ictx.getNode());
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
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
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
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(genModel.getImportedName("org.eclipse.egf.model.types.Type"));
		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(genModel.getImportedName(createClass.getImportedInstanceClassName()));
		stringBuffer.append(TEXT_5);
		stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
		stringBuffer.append(TEXT_6);
		stringBuffer.append(createClass.getName());
		stringBuffer.append(TEXT_7);
		stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
		stringBuffer.append(TEXT_8);
		stringBuffer.append(genModel.getImportedName("org.eclipse.emf.ecore.util.FeatureMapUtil"));
		stringBuffer.append(TEXT_9);
		stringBuffer.append(delegatedFeature.getQualifiedFeatureAccessor());
		stringBuffer.append(TEXT_10);
		stringBuffer.append(TEXT_11);
		{
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceDelegatedFeature.insert" args="createClass:createClass,createFeature:createFeature,delegatedFeature:delegatedFeature,createClassifier:createClassifier,childCreationData:childCreationData,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
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
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04NBAGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_12);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		if (createClass.isMapEntry() == false && FcorePackage.Literals.INVOCATION_CONTRACT == EMFHelper.solveAgainstStaticPackage(genClass.getEcoreClass())) {
			return true;
		}
		return false;
	}
}