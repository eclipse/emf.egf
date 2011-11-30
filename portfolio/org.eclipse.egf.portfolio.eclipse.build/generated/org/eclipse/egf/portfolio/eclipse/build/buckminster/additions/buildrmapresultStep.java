//Generated on Wed Nov 30 10:58:08 CET 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildrmapresultStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildrmaplocationadd {
	protected static String nl;

	public static synchronized buildrmapresultStep create(String lineSeparator) {
		nl = lineSeparator;
		buildrmapresultStep result = new buildrmapresultStep();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "    ";
	protected final String TEXT_2 = NL + "\t<locator searchPathRef=\"targetPlatform";
	protected final String TEXT_3 = "\" ";
	protected final String TEXT_4 = " failOnError=\"false\" />" + NL + "\t<searchPath name=\"targetPlatform";
	protected final String TEXT_5 = "\">" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"eclipse.platform\">" + NL + "\t\t\t<uri format=\"plugin/{0}\">" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"eclipse.platform\">" + NL + "\t\t\t<uri format=\"feature/{0}\">" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t</searchPath>" + NL + NL;
	protected final String TEXT_6 = NL;
	protected final String TEXT_7 = NL;

	public buildrmapresultStep() {
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

		paramDesc = new IQuery.ParameterDescription("resultStepBuildLocation", "http://www.eclipse.org/egf/1.0.1/buildstep#//ResultStepBuildLocation");
		queryCtx = new HashMap<String, String>();
		List<Object> resultStepBuildLocationList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object resultStepBuildLocationParameter : resultStepBuildLocationList) {

			this.resultStepBuildLocation = (org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation) resultStepBuildLocationParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_6);
		stringBuffer.append(TEXT_7);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("resultStepBuildLocation", this.resultStepBuildLocation);
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation resultStepBuildLocation = null;

	public void set_resultStepBuildLocation(org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation object) {
		this.resultStepBuildLocation = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("resultStepBuildLocation", this.resultStepBuildLocation);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		String id = new GenerationHelper().getIdOrPositionString(resultStepBuildLocation);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(id);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(new GenerationHelper().getPatternString(resultStepBuildLocation));
		stringBuffer.append(TEXT_4);
		stringBuffer.append(id);
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition() {
		return true;
	}
}