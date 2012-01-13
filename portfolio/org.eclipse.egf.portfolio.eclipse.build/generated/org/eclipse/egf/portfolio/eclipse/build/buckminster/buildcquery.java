//Generated on Thu Jan 12 17:22:07 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildcquery extends org.eclipse.egf.portfolio.eclipse.build.BuildStepFilePattern {
	protected static String nl;

	public static synchronized buildcquery create(String lineSeparator) {
		nl = lineSeparator;
		buildcquery result = new buildcquery();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<cq:componentQuery xmlns:cq=\"http://www.eclipse.org/buckminster/CQuery-1.0\" resourceMap=\"build.rmap\">" + NL + "    <cq:rootRequest name=\"";
	protected final String TEXT_2 = "\" componentType=\"buckminster\"/>" + NL + "" + NL + "    <!-- we ignore source plugin and feature by default -->" + NL + "    <cq:advisorNode namePattern=\".*\\.source\" skipComponent=\"true\"/>" + NL + "" + NL + "    <!-- we ignore some missing plugins -->" + NL + "\t<cq:advisorNode namePattern=\"^org\\.eclipse\\.swt\\.(?:gtk\\.(?:linux\\.s390x|aix\\.ppc(?:64)?)|motif\\.solaris\\.sparc|photon\\.qnx\\.x86)\\.source$\" skipComponent=\"true\"/>" + NL + "\t<cq:advisorNode namePattern=\"^org\\.eclipse\\.swt\\.(?:gtk\\.aix\\.ppc(?:64)?|motif\\.solaris\\.sparc|photon\\.qnx\\.x86)$\" skipComponent=\"true\"/>" + NL + "\t<cq:advisorNode namePattern=\"^org\\.eclipse\\.equinox\\.launcher\\.gtk\\.aix\\.ppc(?:64)?$\" skipComponent=\"true\"/>" + NL + "" + NL
			+ "    <cq:advisorNode namePattern=\".*\" useMaterialization=\"false\" useTargetPlatform=\"false\"/>" + NL + "</cq:componentQuery>" + NL;
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public buildcquery() {
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

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_body(new StringBuffer(), ictx);

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

		fileName = "build.cquery";
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setFileName", stringBuffer.toString());
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

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
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}