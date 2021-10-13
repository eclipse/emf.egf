//Generated with EGF 1.6.3.202110181143
package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class PublishertestStep extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Publisheradd {
	protected static String nl;

	public static synchronized PublishertestStep create(String lineSeparator) {
		nl = lineSeparator;
		PublishertestStep result = new PublishertestStep();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "    <hudson.tasks.junit.JUnitResultArchiver>" + NL
			+ "      <testResults>result/testReport*.xml</testResults>" + NL
			+ "      <keepLongStdio>false</keepLongStdio>" + NL + "      <testDataPublishers/>" + NL
			+ "    </hudson.tasks.junit.JUnitResultArchiver>";
	protected final String TEXT_2 = NL + "    <hudson.plugins.emma.EmmaPublisher>" + NL
			+ "      <includes>result/coverageReport*.xml</includes>" + NL + "      <healthReports>" + NL
			+ "        <minClass>0</minClass>" + NL + "        <maxClass>0</maxClass>" + NL
			+ "        <minMethod>0</minMethod>" + NL + "        <maxMethod>0</maxMethod>" + NL
			+ "        <minBlock>0</minBlock>" + NL + "        <maxBlock>0</maxBlock>" + NL
			+ "        <minLine>0</minLine>" + NL + "        <maxLine>0</maxLine>" + NL + "      </healthReports>" + NL
			+ "    </hudson.plugins.emma.EmmaPublisher>";
	protected final String TEXT_3 = NL;

	public PublishertestStep() {
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

		paramDesc = new IQuery.ParameterDescription("testStep",
				"http://www.eclipse.org/egf/1.0.2/buildstep#//TestStep");
		queryCtx = new HashMap<String, String>();
		List<Object> testStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery")
				.execute(paramDesc, queryCtx, ctx);

		for (Object testStepParameter : testStepList) {

			this.testStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep) testStepParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("testStep", this.testStep);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep testStep = null;

	public void set_testStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep object) {
		this.testStep = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("testStep", this.testStep);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		if (testStep.isCodeCoverage()) {
			stringBuffer.append(TEXT_2);
		}
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}