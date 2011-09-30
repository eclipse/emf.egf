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
	protected final String TEXT_5 = "\t\t<echo message=\"install JRE ${env.JAVA_HOME}\" />" + NL + "    \t<buckminster command=\"installJRE\">" + NL + "            <cmdargs>" + NL + "                <arg value=\"--location\" />" + NL + "                <arg value=\"${env.JAVA_HOME}\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>" + NL + NL;
	protected final String TEXT_6 = "        <buckminster command=\"importtargetdefinition\">" + NL + "            <cmdargs>" + NL + "                <arg value=\"--active\" />" + NL + "                <arg value=\"${relengDir}/buckminster_";
	protected final String TEXT_7 = "/build.target\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>" + NL + "    \t" + NL;
	protected final String TEXT_8 = "        <buckminster command=\"import\">" + NL + "            <!-- Uncomment to debug <globargs><jvmarg value=\"-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=y\"/></globargs> -->" + NL + "            <cmdargs>" + NL + "                <arg value=\"-P\" />" + NL + "                <arg value=\"${relengDir}/build.properties\" />" + NL + "                <arg value=\"${relengDir}/buckminster_";
	protected final String TEXT_9 = "/build.mspec\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>" + NL + NL;
	protected final String TEXT_10 = NL + "        <echo message=\"No builders invocation specified\" />";
	protected final String TEXT_11 = NL + "        <echo message=\"Invoking all eclipse builders on workspace ${workspace}\" />" + NL + "        <buckminster command=\"build\" >" + NL + "            <cmdargs>" + NL + "                <arg value=\"--clean\" />" + NL + "                <arg value=\"--thorough\" />" + NL + "            </cmdargs>" + NL + "\t\t</buckminster>";
	protected final String TEXT_12 = NL;
	protected final String TEXT_13 = "    </target>" + NL + NL;
	protected final String TEXT_14 = NL;
	protected final String TEXT_15 = NL;

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

		stringBuffer.append(TEXT_14);
		stringBuffer.append(TEXT_15);
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

		stepName = new GenerationHelper().getIdOrPositionString(buildStep);
		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@111d1f1 (description: null) (name: computeStepName) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._sTvtQJVuEd-fvPvNnKEvJg/method._sTvtRJVuEd-fvPvNnKEvJg.pt)", stringBuffer.toString());
	}

	protected void method_begin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		stringBuffer.append(stepName);
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@8557ee (description: null) (name: begin) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._sTvtQJVuEd-fvPvNnKEvJg/method._d7QDMNXkEd-lsanF2JdPMA.pt)", stringBuffer.toString());
	}

	protected void method_echo(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@4fffde (description: null) (name: echo) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._sTvtQJVuEd-fvPvNnKEvJg/method._gveeUNXkEd-lsanF2JdPMA.pt)", stringBuffer.toString());
	}

	protected void method_installJRE(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@274d1c (description: null) (name: installJRE) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._sTvtQJVuEd-fvPvNnKEvJg/method._ks-1sNXkEd-lsanF2JdPMA.pt)", stringBuffer.toString());
	}

	protected void method_importTargetDefinition(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_6);
		stringBuffer.append(stepName);
		stringBuffer.append(TEXT_7);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@376e79 (description: null) (name: importTargetDefinition) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._sTvtQJVuEd-fvPvNnKEvJg/method._nW7TcNXkEd-lsanF2JdPMA.pt)", stringBuffer.toString());
	}

	protected void method_importWorkspace(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_8);
		stringBuffer.append(stepName);
		stringBuffer.append(TEXT_9);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@135d761 (description: null) (name: importWorkspace) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._sTvtQJVuEd-fvPvNnKEvJg/method._p3VasNXkEd-lsanF2JdPMA.pt)", stringBuffer.toString());
	}

	protected void method_build(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		if (buildStep.isNoBuildersInvocation()) {
			stringBuffer.append(TEXT_10);
		} else {
			stringBuffer.append(TEXT_11);
		}
		stringBuffer.append(TEXT_12);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1cf3877 (description: null) (name: build) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._sTvtQJVuEd-fvPvNnKEvJg/method._uOm88NXkEd-lsanF2JdPMA.pt)", stringBuffer.toString());
	}

	protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_13);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1842212 (description: null) (name: end) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._sTvtQJVuEd-fvPvNnKEvJg/method._w_jakNXkEd-lsanF2JdPMA.pt)", stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return super.preCondition();
	}
}