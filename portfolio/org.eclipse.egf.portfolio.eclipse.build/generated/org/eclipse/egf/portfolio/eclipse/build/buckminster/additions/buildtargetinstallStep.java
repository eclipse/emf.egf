package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildtargetinstallStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildtargetadd {
	protected static String nl;

	public static synchronized buildtargetinstallStep create(String lineSeparator) {
		nl = lineSeparator;
		buildtargetinstallStep result = new buildtargetinstallStep();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t\t<location path=\"";
	protected final String TEXT_2 = "\" type=\"Profile\"/>" + NL;
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public buildtargetinstallStep() {
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

		paramDesc = new IQuery.ParameterDescription("installStepBuildLocation", "http://www.eclipse.org/egf/1.0.1/buildstep#//InstallStepBuildLocation");
		queryCtx = new HashMap<String, String>();
		List<Object> installStepBuildLocationList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object installStepBuildLocationParameter : installStepBuildLocationList) {

			this.installStepBuildLocation = (org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation) installStepBuildLocationParameter;

			if (preCondition()) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("installStepBuildLocation", this.installStepBuildLocation);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation installStepBuildLocation = null;

	public void set_installStepBuildLocation(org.eclipse.egf.portfolio.eclipse.build.buildstep.InstallStepBuildLocation object) {
		this.installStepBuildLocation = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("installStepBuildLocation", this.installStepBuildLocation);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String location = "${workspace_loc}/../../../../" + new GenerationHelper().getJobName(ctx, installStepBuildLocation.getInstallStep().getJob()) + "/workspace/result/publish/" + installStepBuildLocation.getInstallStep().getName();

		stringBuffer.append(TEXT_1);
		stringBuffer.append(location);
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1673408 (description: null) (name: body) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._YLrGcKh4EeCyIabjY3cKRg/method._YLrGdah4EeCyIabjY3cKRg.pt)", stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return super.preCondition();
	}
}