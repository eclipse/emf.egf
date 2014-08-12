//Generated with EGF 1.2.0.v20140805-0858
package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.builddeploy.*;

public class OthershudsonDeployment extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Othersadd {
	protected static String nl;

	public static synchronized OthershudsonDeployment create(String lineSeparator) {
		nl = lineSeparator;
		OthershudsonDeployment result = new OthershudsonDeployment();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "  <disabled>true</disabled>";
	protected final String TEXT_2 = NL + "  <assignedNode>";
	protected final String TEXT_3 = "</assignedNode>";
	protected final String TEXT_4 = NL + "  <jdk>";
	protected final String TEXT_5 = "</jdk>";
	protected final String TEXT_6 = NL + "  <!--userDeployServerUrl=";
	protected final String TEXT_7 = "-->";
	protected final String TEXT_8 = NL + "  <!--userDeployJobName=";
	protected final String TEXT_9 = "-->";
	protected final String TEXT_10 = NL;
	protected final String TEXT_11 = NL;
	protected final String TEXT_12 = NL;

	public OthershudsonDeployment() {
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

		paramDesc = new IQuery.ParameterDescription("deployment", "http://www.eclipse.org/egf/1.0.0/builddeploy#//HudsonDeployment");
		queryCtx = new HashMap<String, String>();
		List<Object> deploymentList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object deploymentParameter : deploymentList) {

			this.deployment = (org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment) deploymentParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_11);
		stringBuffer.append(TEXT_12);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("deployment", this.deployment);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment deployment = null;

	public void set_deployment(org.eclipse.egf.portfolio.eclipse.build.builddeploy.HudsonDeployment object) {
		this.deployment = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("deployment", this.deployment);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		if (!deployment.isEnabled()) {
			stringBuffer.append(TEXT_1);
		}
		if (deployment.getAssignedNode() != null && deployment.getAssignedNode().length() > 0) {
			stringBuffer.append(TEXT_2);
			stringBuffer.append(deployment.getAssignedNode());
			stringBuffer.append(TEXT_3);
		}
		if (deployment.getJdkName() != null && deployment.getJdkName().length() > 0) {
			stringBuffer.append(TEXT_4);
			stringBuffer.append(deployment.getJdkName());
			stringBuffer.append(TEXT_5);
		}
		if (deployment.getUserDeployServerUrl() != null && deployment.getUserDeployServerUrl().length() > 0) {
			stringBuffer.append(TEXT_6);
			stringBuffer.append(deployment.getUserDeployServerUrl());
			stringBuffer.append(TEXT_7);
		}
		if (deployment.getUserDeployJobName() != null && deployment.getUserDeployJobName().length() > 0) {
			stringBuffer.append(TEXT_8);
			stringBuffer.append(deployment.getUserDeployJobName());
			stringBuffer.append(TEXT_9);
		}
		stringBuffer.append(TEXT_10);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}