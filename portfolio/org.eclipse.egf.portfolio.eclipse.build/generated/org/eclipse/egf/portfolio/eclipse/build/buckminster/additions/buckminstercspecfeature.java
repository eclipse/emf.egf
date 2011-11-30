//Generated on Wed Nov 30 10:57:16 CET 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class buckminstercspecfeature extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buckminstercspecdepsadd {
	protected static String nl;

	public static synchronized buckminstercspecfeature create(String lineSeparator) {
		nl = lineSeparator;
		buckminstercspecfeature result = new buckminstercspecfeature();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "        <cs:dependency name=\"";
	protected final String TEXT_2 = "\" componentType=\"eclipse.feature\"/>" + NL;
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public buckminstercspecfeature() {
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

		paramDesc = new IQuery.ParameterDescription("feature", "http://www.eclipse.org/egf/1.0.1/buildstep#//Feature");
		queryCtx = new HashMap<String, String>();
		List<Object> featureList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object featureParameter : featureList) {

			this.feature = (org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature) featureParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("feature", this.feature);
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature feature = null;

	public void set_feature(org.eclipse.egf.portfolio.eclipse.build.buildstep.Feature object) {
		this.feature = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("feature", this.feature);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(feature.getName());
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition() {
		return true;
	}
}