package org.eclipse.egf.portfolio.eclipse.build;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class BuildStepFilePattern extends org.eclipse.egf.portfolio.eclipse.build.FilePattern {
	protected static String nl;

	public static synchronized BuildStepFilePattern create(String lineSeparator) {
		nl = lineSeparator;
		BuildStepFilePattern result = new BuildStepFilePattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public BuildStepFilePattern() {
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

		List<Object> buildStepList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

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

		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_setBuildStepName(new StringBuffer(), ictx);

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

	protected java.lang.String buildStepName = null;

	public void set_buildStepName(java.lang.String object) {
		this.buildStepName = object;
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

	protected void method_setFilePath(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		filePath = new GenerationHelper().getJobName(ctx, buildStep.getJob());
		filePath = filePath + "/releng/buckminster_" + new GenerationHelper().getIdOrPositionString(buildStep);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1f15b67 (description: null) (name: setFilePath) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._ST8cYKbSEd-qVbFBxWG7lA/method._ST8cZKbSEd-qVbFBxWG7lA.pt)", stringBuffer.toString());
	}

	protected void method_setBuildStepName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		buildStepName = new GenerationHelper().getIdOrPositionString(buildStep);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@34160 (description: null) (name: setBuildStepName) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._ST8cYKbSEd-qVbFBxWG7lA/method._QPmCMKbWEd-qVbFBxWG7lA.pt)", stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return buildStep.getJob().isEnabled();
	}
}