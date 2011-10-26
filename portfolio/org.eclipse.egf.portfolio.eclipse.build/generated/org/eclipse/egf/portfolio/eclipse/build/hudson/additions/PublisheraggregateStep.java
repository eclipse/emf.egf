//Generated on Wed Oct 26 15:29:35 CEST 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class PublisheraggregateStep extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Publisheradd {
	protected static String nl;

	public static synchronized PublisheraggregateStep create(String lineSeparator) {
		nl = lineSeparator;
		PublisheraggregateStep result = new PublisheraggregateStep();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "    <hudson.tasks.ArtifactArchiver>" + NL + "      <artifacts>result/publish/**</artifacts>" + NL + "      <latestOnly>false</latestOnly>" + NL + "    </hudson.tasks.ArtifactArchiver>" + NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public PublisheraggregateStep() {
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

		paramDesc = new IQuery.ParameterDescription("aggregateStep", "http://www.eclipse.org/egf/1.0.1/buildstep#//AggregateStep");
		queryCtx = new HashMap<String, String>();
		List<Object> aggregateStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object aggregateStepParameter : aggregateStepList) {

			this.aggregateStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep) aggregateStepParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("aggregateStep", this.aggregateStep);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep aggregateStep = null;

	public void set_aggregateStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep object) {
		this.aggregateStep = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("aggregateStep", this.aggregateStep);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}