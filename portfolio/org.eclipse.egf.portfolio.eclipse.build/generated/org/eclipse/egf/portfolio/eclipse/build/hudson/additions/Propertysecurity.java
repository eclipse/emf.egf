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

public class Propertysecurity extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Propertyadd {
	protected static String nl;

	public static synchronized Propertysecurity create(String lineSeparator) {
		nl = lineSeparator;
		Propertysecurity result = new Propertysecurity();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "    <hudson.security.AuthorizationMatrixProperty>";
	protected final String TEXT_2 = NL + "      <permission>hudson.model.Item.Read:";
	protected final String TEXT_3 = "</permission>" + NL + "\t\t\t";
	protected final String TEXT_4 = NL + "      <permission>hudson.model.Run.Update:";
	protected final String TEXT_5 = "</permission>" + NL + "      <permission>hudson.model.Run.Delete:";
	protected final String TEXT_6 = "</permission>" + NL + "      <permission>hudson.model.Item.Build:";
	protected final String TEXT_7 = "</permission>" + NL + "      <permission>hudson.model.Item.Workspace:";
	protected final String TEXT_8 = "</permission>" + NL + "\t\t\t";
	protected final String TEXT_9 = NL + "      <permission>hudson.model.Item.Cancel:";
	protected final String TEXT_10 = "</permission>" + NL + "      <permission>hudson.model.Item.Read:";
	protected final String TEXT_11 = "</permission>" + NL + "      <permission>hudson.model.Item.Delete:";
	protected final String TEXT_12 = "</permission>" + NL + "      <permission>hudson.model.Item.Workspace:";
	protected final String TEXT_13 = "</permission>" + NL + "      <permission>hudson.model.Item.Build:";
	protected final String TEXT_14 = "</permission>" + NL + "      <permission>hudson.model.Item.Configure:";
	protected final String TEXT_15 = "</permission>" + NL + "      <permission>hudson.model.Run.Update:";
	protected final String TEXT_16 = "</permission>" + NL + "      <permission>hudson.model.Run.Delete:";
	protected final String TEXT_17 = "</permission>" + NL + "\t\t\t";
	protected final String TEXT_18 = NL + "    </hudson.security.AuthorizationMatrixProperty>";
	protected final String TEXT_19 = NL;
	protected final String TEXT_20 = NL;
	protected final String TEXT_21 = NL;

	public Propertysecurity() {
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

		paramDesc = new IQuery.ParameterDescription("job", "http://www.eclipse.org/egf/1.0.1/buildcore#//Job");
		queryCtx = new HashMap<String, String>();
		List<Object> jobList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object jobParameter : jobList) {

			this.job = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Job) jobParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_20);
		stringBuffer.append(TEXT_21);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("job", this.job);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Job job = null;

	public void set_job(org.eclipse.egf.portfolio.eclipse.build.buildcore.Job object) {
		this.job = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("job", this.job);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		if (job.getDeployment() instanceof HudsonDeployment) {
			HudsonDeployment deployment = (HudsonDeployment) job.getDeployment();
			if (deployment.getUsers().size() > 0) {

				stringBuffer.append(TEXT_1);

				for (User user : deployment.getUsers()) {
					if (user.getPermission() == PermissionType.READ) {

						stringBuffer.append(TEXT_2);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_3);

					}
					if (user.getPermission() == PermissionType.EXECUTE) {

						stringBuffer.append(TEXT_4);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_5);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_6);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_7);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_8);

					}
					if (user.getPermission() == PermissionType.WRITE) {

						stringBuffer.append(TEXT_9);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_10);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_11);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_12);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_13);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_14);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_15);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_16);
						stringBuffer.append(user.getLogin());
						stringBuffer.append(TEXT_17);

					}
				}

				stringBuffer.append(TEXT_18);

			}
		}

		stringBuffer.append(TEXT_19);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}