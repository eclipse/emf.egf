//Generated with EGF 1.6.3.202110181143
package fcore.builder.patterns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomain;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.FcoreBuilderConstants;
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.egf.model.types.*;
import java.util.ArrayList;

public class ModeEcorelPattern {

	public ModeEcorelPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
		this.modelActivity = "platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_Pcm9sDG0Ed-kc8dEZsdm2w";
		this.editActivity = "platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_PiIW4DG0Ed-kc8dEZsdm2w";
		this.editorActivity = "platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_PkqGcDG0Ed-kc8dEZsdm2w";
		this.testActivity = "platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_PoF08DG0Ed-kc8dEZsdm2w";
		this.javadocActivity = "platform:/plugin/org.eclipse.egf.portfolio.ant.javadoc/egf/javadocTask.fcore#_dj3IUEKMEeCptI_ayXHmng";

	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration((PatternContext) argument);

			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_body(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		Map<GenerationElement, FactoryComponent> fcs = (Map<GenerationElement, FactoryComponent>) ctx
				.getValue(FcoreBuilderConstants.CURRENT_FCORE);

		FactoryComponent fc = fcs.get((GenerationElement) (parameter.eContainer()));

		ProductionPlan pp = (ProductionPlan) fc.getOrchestration();
		DomainViewpoint dvp = (DomainViewpoint) fc.getViewpointContainer().getViewpoint(DomainViewpoint.class);

		EMFDomain genModelEMFDomain = null;
		URI uri = ((HashMap<EmfGeneration, URI>) ctx.getValue(FcoreBuilderConstants.GENMODEL_URIS))
				.get(parameter.getModelPath());
		genModelEMFDomain = ActivityInvocationHelper.getDomain(dvp, uri);
		if (genModelEMFDomain == null) {
			genModelEMFDomain = DomainFactory.eINSTANCE.createEMFDomain();
			genModelEMFDomain.setUri(uri);
			dvp.getDomains().add(genModelEMFDomain);
		}

		Map<String, Type> contracts = new HashMap<String, Type>();
		Map<String, OrchestrationParameter> parameters = new HashMap<String, OrchestrationParameter>();

		for (OrchestrationParameter param : pp.getOrchestrationParameters()) {
			if (ActivityInvocationHelper.GENERATION_EXTENSION_PARAMETER_NAME.equals(param.getName())) {
				parameters.put("pattern.substitutions", param);
			}
		}

		ResourceSet resourceSet = fc.eResource().getResourceSet();
		if (parameter.isGenerateModel()) {
			TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
			typeEMFDomain.setDomain(genModelEMFDomain);
			contracts.put("genModel", typeEMFDomain);
			ActivityInvocationHelper.addInvocation(pp,
					(Activity) resourceSet.getEObject(URI.createURI(this.modelActivity, false), true), contracts,
					parameters);
		}
		if (parameter.isGenerateEdit()) {
			TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
			typeEMFDomain.setDomain(genModelEMFDomain);
			contracts.put("genModel", typeEMFDomain);
			ActivityInvocationHelper.addInvocation(pp,
					(Activity) resourceSet.getEObject(URI.createURI(this.editActivity, false), true), contracts,
					parameters);
		}
		if (parameter.isGenerateEditor()) {
			TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
			typeEMFDomain.setDomain(genModelEMFDomain);
			contracts.put("genModel", typeEMFDomain);
			ActivityInvocationHelper.addInvocation(pp,
					(Activity) resourceSet.getEObject(URI.createURI(this.editorActivity, false), true), contracts,
					parameters);
		}
		if (parameter.isGenerateTest()) {
			TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
			typeEMFDomain.setDomain(genModelEMFDomain);
			contracts.put("genModel", typeEMFDomain);
			ActivityInvocationHelper.addInvocation(pp,
					(Activity) resourceSet.getEObject(URI.createURI(this.testActivity, false), true), contracts,
					parameters);
		}
		if (parameter.isGenerateJavadoc()) {
			TypeDomain typeEMFDomain = DomainFactory.eINSTANCE.createTypeDomain();
			typeEMFDomain.setDomain(genModelEMFDomain);
			contracts.put("genModel", typeEMFDomain);
			ActivityInvocationHelper.addInvocation(pp,
					(Activity) resourceSet.getEObject(URI.createURI(this.javadocActivity, false), true), contracts,
					parameters);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration parameter;

	public void set_parameter(org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration parameter) {
		this.parameter = parameter;
	}

	protected java.lang.String modelActivity;

	public void set_modelActivity(java.lang.String modelActivity) {
		this.modelActivity = modelActivity;
	}

	protected java.lang.String editActivity;

	public void set_editActivity(java.lang.String editActivity) {
		this.editActivity = editActivity;
	}

	protected java.lang.String editorActivity;

	public void set_editorActivity(java.lang.String editorActivity) {
		this.editorActivity = editorActivity;
	}

	protected java.lang.String testActivity;

	public void set_testActivity(java.lang.String testActivity) {
		this.testActivity = testActivity;
	}

	protected java.lang.String javadocActivity;

	public void set_javadocActivity(java.lang.String javadocActivity) {
		this.javadocActivity = javadocActivity;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
