package fcore.builder.patterns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.domain.Domain;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.DomainURI;
import org.eclipse.egf.model.domain.DomainViewpoint;
import org.eclipse.egf.model.domain.TypeDomainURI;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.OrchestrationParameter;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.FcoreBuilderConstants;
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ModeEcorelPattern {

	public ModeEcorelPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
		this.modelActivity = "platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_Pcm9sDG0Ed-kc8dEZsdm2w";
		this.editActivity = "platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_PiIW4DG0Ed-kc8dEZsdm2w";
		this.editorActivity = "platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_PkqGcDG0Ed-kc8dEZsdm2w";
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration) parameterParameter;

			if (preCondition())
				orchestration((PatternContext) argument);

		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
			ctx.clearBuffer();
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		int executionIndex = ictx.getExecutionBuffer().length();
		method_body(ictx.getBuffer(), ictx);

		String loop = ictx.getBuffer().toString();
		if (ictx.useReporter()) {
			ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
			ictx.setExecutionCurrentIndex(0);
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			ictx.clearBuffer();
		}
		return loop;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		Map<GenerationElement, FactoryComponent> fcs = (Map<GenerationElement, FactoryComponent>) ctx.getValue(FcoreBuilderConstants.CURRENT_FCORE);

		FactoryComponent fc = fcs.get((GenerationElement) (parameter.eContainer()));

		ProductionPlan pp = (ProductionPlan) fc.getOrchestration();
		DomainViewpoint dvp = (DomainViewpoint) fc.getViewpointContainer().getViewpoint(DomainViewpoint.class);

		DomainURI genModelDomainURI = null;
		URI uri = ((HashMap<EmfGeneration, URI>) ctx.getValue(FcoreBuilderConstants.GENMODEL_URIS)).get(parameter);
		genModelDomainURI = ActivityInvocationHelper.getDomain(dvp, uri);
		if (genModelDomainURI == null) {
			genModelDomainURI = DomainFactory.eINSTANCE.createDomainURI();
			genModelDomainURI.setUri(uri);
			dvp.getDomains().add(genModelDomainURI);
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
			TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
			typeDomainURI.setDomain(genModelDomainURI);
			contracts.put("genModelURI", typeDomainURI);
			ActivityInvocationHelper.addInvocation(pp, (Activity) resourceSet.getEObject(URI.createURI(this.modelActivity, false), true), contracts, parameters);
		}
		if (parameter.isGenerateEdit()) {
			TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
			typeDomainURI.setDomain(genModelDomainURI);
			contracts.put("genModelURI", typeDomainURI);
			ActivityInvocationHelper.addInvocation(pp, (Activity) resourceSet.getEObject(URI.createURI(this.editActivity, false), true), contracts, parameters);
		}
		if (parameter.isGenerateEditor()) {
			TypeDomainURI typeDomainURI = DomainFactory.eINSTANCE.createTypeDomainURI();
			typeDomainURI.setDomain(genModelDomainURI);
			contracts.put("genModelURI", typeDomainURI);
			ActivityInvocationHelper.addInvocation(pp, (Activity) resourceSet.getEObject(URI.createURI(this.editorActivity, false), true), contracts, parameters);
		}

	}

	public boolean preCondition() throws Exception {
		return true;
	}

	protected org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration parameter;

	public void set_parameter(org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration parameter) {
		this.parameter = parameter;
	}

	private java.lang.String modelActivity;

	public void set_modelActivity(java.lang.String modelActivity) {
		this.modelActivity = modelActivity;
	}

	private java.lang.String editActivity;

	public void set_editActivity(java.lang.String editActivity) {
		this.editActivity = editActivity;
	}

	private java.lang.String editorActivity;

	public void set_editorActivity(java.lang.String editorActivity) {
		this.editorActivity = editorActivity;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
