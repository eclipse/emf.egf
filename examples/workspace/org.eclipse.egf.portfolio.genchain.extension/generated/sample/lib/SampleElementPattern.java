//Generated on Wed Oct 26 15:25:31 CEST 2011 with EGF 0.6.1.qualifier
package sample.lib;

import java.util.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.FcoreBuilderConstants;
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;

public class SampleElementPattern {

	public SampleElementPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleElement) parameterParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration((PatternContext) argument);

			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_body(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return loop;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		Map<GenerationElement, FactoryComponent> fcs = (Map<GenerationElement, FactoryComponent>) ctx.getValue(FcoreBuilderConstants.CURRENT_FCORE);
		FactoryComponent fc = fcs.get((GenerationElement) (parameter.eContainer()));
		ResourceSet resourceSet = fc.eResource().getResourceSet();
		ProductionPlan pp = (ProductionPlan) fc.getOrchestration();
		URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.portfolio.genchain.extension/egf/sampleExtension.fcore#_ZPAkkaYjEd-c68Bv_MO43Q", false);
		ActivityInvocationHelper.addInvocation(pp, (Activity) resourceSet.getEObject(uri, true));

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleElement parameter;

	public void set_parameter(org.eclipse.egf.portfolio.genchain.extension.SampleExtension.SampleElement parameter) {
		this.parameter = parameter;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

}
