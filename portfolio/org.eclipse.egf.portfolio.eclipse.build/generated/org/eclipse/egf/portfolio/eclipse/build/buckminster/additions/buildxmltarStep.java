//Generated with EGF 1.2.0.v20140805-0858
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildxmltarStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
	protected static String nl;

	public static synchronized buildxmltarStep create(String lineSeparator) {
		nl = lineSeparator;
		buildxmltarStep result = new buildxmltarStep();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t<target name=\"";
	protected final String TEXT_2 = "\" depends=\"init\">" + NL + "\t\t<tar destfile=\"";
	protected final String TEXT_3 = "\" basedir=\"";
	protected final String TEXT_4 = "\" compression=\"";
	protected final String TEXT_5 = "\" ";
	protected final String TEXT_6 = " >";
	protected final String TEXT_7 = NL;
	protected final String TEXT_8 = NL + "\t\t</tar>" + NL + "\t</target>" + NL + NL;
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = NL;

	public buildxmltarStep() {
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

		paramDesc = new IQuery.ParameterDescription("tarStep", "http://www.eclipse.org/egf/1.0.0/buildfile#//TarStep");
		queryCtx = new HashMap<String, String>();
		List<Object> tarStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object tarStepParameter : tarStepList) {

			this.tarStep = (org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep) tarStepParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_9);
		stringBuffer.append(TEXT_10);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("tarStep", this.tarStep);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep tarStep = null;

	public void set_tarStep(org.eclipse.egf.portfolio.eclipse.build.buildfile.TarStep object) {
		this.tarStep = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("tarStep", this.tarStep);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String stepName = new GenerationHelper().getNameOrGeneratedIdString(tarStep);
		stringBuffer.append(TEXT_1);
		stringBuffer.append(stepName);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(tarStep.getDestfile());
		stringBuffer.append(TEXT_3);
		stringBuffer.append(tarStep.getBaseDir());
		stringBuffer.append(TEXT_4);
		stringBuffer.append(tarStep.getCompression().getName());
		stringBuffer.append(TEXT_5);
		stringBuffer.append(new GenerationHelper().getAdditionalParametersString(tarStep));
		stringBuffer.append(TEXT_6);
		stringBuffer.append(TEXT_7);
		{
			//<%@ egf:patternCall 
			//	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.buckminster.util.build.xml.filesetProvider" 
			//	args="tarStep:filesetProvider"%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("filesetProvider", tarStep);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_p-drcEwzEeG-l60d03D_Og", new ExecutionContext(
					(InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_8);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}