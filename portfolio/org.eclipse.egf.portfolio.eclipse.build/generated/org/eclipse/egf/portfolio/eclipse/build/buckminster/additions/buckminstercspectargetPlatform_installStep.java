package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buckminstercspectargetPlatform_installStep {
	protected static String nl;

	public static synchronized buckminstercspectargetPlatform_installStep create(String lineSeparator) {
		nl = lineSeparator;
		buckminstercspectargetPlatform_installStep result = new buckminstercspectargetPlatform_installStep();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "        <cs:dependency name=\"org.eclipse.equinox.executable\" componentType=\"eclipse.feature\"/>" + NL + "        <cs:dependency name=\"org.eclipse.rcp\" componentType=\"eclipse.feature\"/>" + NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public buckminstercspectargetPlatform_installStep() {
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

		paramDesc = new IQuery.ParameterDescription("buildStep", "http://www.eclipse.org/egf/1.0.1/buildstep#//BuildStep");
		queryCtx = new HashMap<String, String>();
		List<Object> buildStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object buildStepParameter : buildStepList) {

			this.buildStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep) buildStepParameter;

			if (preCondition()) {
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

		method_body(new StringBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("buildStep", this.buildStep);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep buildStep = null;

	public void set_buildStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep object) {
		this.buildStep = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("buildStep", this.buildStep);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@115afd9 (description: null) (name: body) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._SbudAJWHEd-9uNs2Xd57Cg/method._SbudBJWHEd-9uNs2Xd57Cg.pt)", stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return !(new GenerationHelper().hasTargetPlatformBuildLocation(buildStep)) && !(new GenerationHelper().hasInstallStepBuildLocation(buildStep));
	}
}