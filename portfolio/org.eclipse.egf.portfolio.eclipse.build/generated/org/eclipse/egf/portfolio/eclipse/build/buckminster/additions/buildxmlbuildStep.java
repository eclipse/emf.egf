//Generated with EGF 1.2.0.v20140805-0858
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

public class buildxmlbuildStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
	protected static String nl;

	public static synchronized buildxmlbuildStep create(String lineSeparator) {
		nl = lineSeparator;
		buildxmlbuildStep result = new buildxmlbuildStep();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = "    <target name=\"";
	protected final String TEXT_3 = "\" depends=\"init,install.buckminster\">" + NL;
	protected final String TEXT_4 = "        <echo message=\"Importing projects into workspace ${workspace} and binaries into target platform\" />" + NL + NL;
	protected final String TEXT_5 = "\t\t<echo message=\"install JRE ${env.JAVA_HOME}\" />" + NL + "    \t<buckminster command=\"installJRE\">" + NL + "            <cmdargs>" + NL
			+ "                <arg value=\"--location\" />" + NL + "                <arg value=\"${env.JAVA_HOME}\" />" + NL + "            </cmdargs>" + NL
			+ "        </buckminster>" + NL + NL;
	protected final String TEXT_6 = NL + "\t\t<echo message=\"import target platform\" />" + NL + "        <buckminster command=\"importtargetdefinition\">" + NL
			+ "            <cmdargs>" + NL + "                <arg value=\"--active\" />" + NL + "                <arg value=\"${relengDir}/buckminster_";
	protected final String TEXT_7 = "/build.target\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>";
	protected final String TEXT_8 = NL;
	protected final String TEXT_9 = "\t\t<echo message=\"provision : import projects in workspace\" />" + NL + "        <buckminster command=\"import\">" + NL
			+ "            <!-- Uncomment to debug <globargs><jvmarg value=\"-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=y\"/></globargs> -->" + NL
			+ "            <cmdargs>" + NL + "                <arg value=\"${relengDir}/buckminster_";
	protected final String TEXT_10 = "/build.mspec\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>" + NL + NL;
	protected final String TEXT_11 = NL + "        <echo message=\"No builders invocation specified\" />";
	protected final String TEXT_12 = NL + "        <echo message=\"Invoking all eclipse builders on workspace ${workspace}\" />" + NL + "        <buckminster command=\"build\" >"
			+ NL + "            <cmdargs>" + NL + "                <arg value=\"--clean\" />" + NL + "                <arg value=\"--thorough\" />" + NL + "            </cmdargs>"
			+ NL + "\t\t</buckminster>";
	protected final String TEXT_13 = NL;
	protected final String TEXT_14 = "    </target>" + NL + NL;
	protected final String TEXT_15 = NL;
	protected final String TEXT_16 = NL;

	public buildxmlbuildStep() {
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

		paramDesc = new IQuery.ParameterDescription("buildStep", "http://www.eclipse.org/egf/1.0.2/buildstep#//BuildStep");
		queryCtx = new HashMap<String, String>();
		List<Object> buildStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

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

		stringBuffer.append(TEXT_15);
		stringBuffer.append(TEXT_16);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_computeStepName(new StringBuffer(), ictx);

		method_begin(new StringBuffer(), ictx);

		method_echo(new StringBuffer(), ictx);

		method_installJRE(new StringBuffer(), ictx);

		method_importTargetDefinition(new StringBuffer(), ictx);

		method_importWorkspace(new StringBuffer(), ictx);

		method_build(new StringBuffer(), ictx);

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

	protected java.lang.String stepName = null;

	public void set_stepName(java.lang.String object) {
		this.stepName = object;
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

	protected void method_computeStepName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stepName = new GenerationHelper().getNameOrGeneratedIdString(buildStep);
		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "computeStepName", stringBuffer.toString());
	}

	protected void method_begin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		stringBuffer.append(stepName);
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "begin", stringBuffer.toString());
	}

	protected void method_echo(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "echo", stringBuffer.toString());
	}

	protected void method_installJRE(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "installJRE", stringBuffer.toString());
	}

	protected void method_importTargetDefinition(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		if (new GenerationHelper().hasBinaryBuildLocation(buildStep)) {
			stringBuffer.append(TEXT_6);
			stringBuffer.append(stepName);
			stringBuffer.append(TEXT_7);
		}
		stringBuffer.append(TEXT_8);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "importTargetDefinition", stringBuffer.toString());
	}

	protected void method_importWorkspace(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_9);
		stringBuffer.append(stepName);
		stringBuffer.append(TEXT_10);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "importWorkspace", stringBuffer.toString());
	}

	protected void method_build(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		if (buildStep.isNoBuildersInvocation()) {
			stringBuffer.append(TEXT_11);
		} else {
			stringBuffer.append(TEXT_12);
		}
		stringBuffer.append(TEXT_13);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "build", stringBuffer.toString());
	}

	protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_14);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "end", stringBuffer.toString());
	}
}