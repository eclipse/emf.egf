//Generated on Tue Jan 10 17:23:22 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;

public class buildxmlstepContainer_steps extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
	protected static String nl;

	public static synchronized buildxmlstepContainer_steps create(String lineSeparator) {
		nl = lineSeparator;
		buildxmlstepContainer_steps result = new buildxmlstepContainer_steps();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t<target name=\"";
	protected final String TEXT_2 = "\" depends=\"";
	protected final String TEXT_3 = "\" />" + NL;
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL;

	public buildxmlstepContainer_steps() {
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

		paramDesc = new IQuery.ParameterDescription("stepContainer", "http://www.eclipse.org/egf/1.0.0/buildcore#//StepContainer");
		queryCtx = new HashMap<String, String>();
		List<Object> stepContainerList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object stepContainerParameter : stepContainerList) {

			this.stepContainer = (org.eclipse.egf.portfolio.eclipse.build.buildcore.StepContainer) stepContainerParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_4);
		stringBuffer.append(TEXT_5);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("stepContainer", this.stepContainer);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildcore.StepContainer stepContainer = null;

	public void set_stepContainer(org.eclipse.egf.portfolio.eclipse.build.buildcore.StepContainer object) {
		this.stepContainer = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("stepContainer", this.stepContainer);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		StringBuilder steps = new StringBuilder();
		for (Step step : stepContainer.getSteps()) {
			if (steps.length() > 0)
				steps.append(',');
			steps.append(new GenerationHelper().getIdOrPositionString(step));
		}

		stringBuffer.append(TEXT_1);
		stringBuffer.append(new GenerationHelper().getIdOrPositionString(stepContainer));
		stringBuffer.append(TEXT_2);
		stringBuffer.append(steps.toString());
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}