//Generated on Thu Jan 12 17:22:09 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

public class buildrmap extends org.eclipse.egf.portfolio.eclipse.build.BuildStepFilePattern {
	protected static String nl;

	public static synchronized buildrmap create(String lineSeparator) {
		nl = lineSeparator;
		buildrmap result = new buildrmap();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<rmap xmlns=\"http://www.eclipse.org/buckminster/RMap-1.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:mp=\"http://www.eclipse.org/buckminster/MavenProvider-1.0\"" + NL + "\txmlns:pmp=\"http://www.eclipse.org/buckminster/PDEMapProvider-1.0\" xmlns:bc=\"http://www.eclipse.org/buckminster/Common-1.0\">" + NL + "" + NL + "\t<locator searchPathRef=\"buckminster\" failOnError=\"false\" />" + NL + "\t<searchPath name=\"buckminster\">" + NL + "\t\t<!-- buckminster provider for windows -->" + NL + "\t\t<provider componentTypes=\"buckminster\" readerType=\"local\" source=\"true\">" + NL + "\t\t\t<uri format=\"file:/{0}/buckminster_";
	protected final String TEXT_2 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"relengDir\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t\t<!-- buckminster provider for unix -->" + NL + "\t\t<provider componentTypes=\"buckminster\" readerType=\"local\" source=\"true\">" + NL + "\t\t\t<uri format=\"file://{0}/buckminster_";
	protected final String TEXT_3 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"relengDir\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t</searchPath>" + NL + NL;
	protected final String TEXT_4 = NL + "\t";
	protected final String TEXT_5 = "</rmap>" + NL;
	protected final String TEXT_6 = NL;
	protected final String TEXT_7 = NL;

	public buildrmap() {
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

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_6);
		stringBuffer.append(TEXT_7);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_begin(new StringBuffer(), ictx);

		method_callBuildRmapLocationAdd(new StringBuffer(), ictx);

		method_end(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("buildStep", this.buildStep);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("buildStep", this.buildStep);
		return parameters;
	}

	protected void method_setFileName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		fileName = "build.rmap";
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setFileName", stringBuffer.toString());
	}

	protected void method_begin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		{
			//<%@ egf:patternCall
			//	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.XmlHeader"
			//%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_LhlsYJ5OEd-3wvN5SnesGA", new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_1);
		stringBuffer.append(buildStepName);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(buildStepName);
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "begin", stringBuffer.toString());
	}

	protected void method_callBuildRmapLocationAdd(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		for (BuildLocation buildLocation : buildStep.getBuildLocations()) {
			stringBuffer.append(TEXT_4);
			{
				//<%@ egf:patternInjectedCall toInject="buildLocation"
				//		patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.buckminster.call.build.rmap.location.add"
				//	%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				ExecutionContext callCtx = new ExecutionContext((InternalPatternContext) ctx);
				callCtx.setValue(PatternContext.INJECTED_CONTEXT, buildLocation);
				CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_AAXisJMbEd-pjLQZUcJ3fw", callCtx);
				stringBuffer.setLength(0);

			}

		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "callBuildRmapLocationAdd", stringBuffer.toString());
	}

	protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "end", stringBuffer.toString());
	}
}