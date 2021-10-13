//Generated with EGF 1.6.3.202110181143
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildxmlcreateFolderStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
	protected static String nl;

	public static synchronized buildxmlcreateFolderStep create(String lineSeparator) {
		nl = lineSeparator;
		buildxmlcreateFolderStep result = new buildxmlcreateFolderStep();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t<target name=\"";
	protected final String TEXT_2 = "\" depends=\"init\">" + NL + "\t\t<mkdir dir=\"";
	protected final String TEXT_3 = "\">" + NL + "\t\t</mkdir>" + NL + "\t</target>" + NL + NL;
	protected final String TEXT_4 = NL;

	public buildxmlcreateFolderStep() {
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

		paramDesc = new IQuery.ParameterDescription("createFolderStep",
				"http://www.eclipse.org/egf/1.0.0/buildfile#//CreateFolderStep");
		queryCtx = new HashMap<String, String>();
		List<Object> createFolderStepList = QueryHelper
				.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery")
				.execute(paramDesc, queryCtx, ctx);

		for (Object createFolderStepParameter : createFolderStepList) {

			this.createFolderStep = (org.eclipse.egf.portfolio.eclipse.build.buildfile.CreateFolderStep) createFolderStepParameter;

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
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("createFolderStep", this.createFolderStep);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildfile.CreateFolderStep createFolderStep = null;

	public void set_createFolderStep(org.eclipse.egf.portfolio.eclipse.build.buildfile.CreateFolderStep object) {
		this.createFolderStep = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createFolderStep", this.createFolderStep);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String stepName = new GenerationHelper().getNameOrGeneratedIdString(createFolderStep);
		stringBuffer.append(TEXT_1);
		stringBuffer.append(stepName);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(createFolderStep.getFolderPath());
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}