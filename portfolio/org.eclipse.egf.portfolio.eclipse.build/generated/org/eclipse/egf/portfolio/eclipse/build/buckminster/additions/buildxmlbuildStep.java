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
    protected final String TEXT_3 = "\" depends=\"";
    protected final String TEXT_4 = "init,install.buckminster\">" + NL;
    protected final String TEXT_5 = "        <echo message=\"Importing projects into workspace ${workspace} and binaries into target platform\" />" + NL + NL;
    protected final String TEXT_6 = "    \t<buckminster command=\"installJRE\">" + NL + "            <cmdargs>" + NL + "                <arg value=\"--location\" />" + NL + "                <arg value=\"${env.JAVA_HOME}\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>" + NL + NL;
    protected final String TEXT_7 = "        <buckminster command=\"importtargetdefinition\">" + NL + "            <cmdargs>" + NL + "                <arg value=\"--active\" />" + NL + "                <arg value=\"${relengDir}/buckminster_";
    protected final String TEXT_8 = "/build.target\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>" + NL + "    \t" + NL;
    protected final String TEXT_9 = "        <buckminster command=\"import\">" + NL + "            <!-- Uncomment to debug <globargs><jvmarg value=\"-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=y\"/></globargs> -->" + NL + "            <cmdargs>" + NL + "                <arg value=\"-P\" />" + NL + "                <arg value=\"${relengDir}/build.properties\" />" + NL + "                <arg value=\"${relengDir}/buckminster_";
    protected final String TEXT_10 = "/build.mspec\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>" + NL + NL;
    protected final String TEXT_11 = "        <echo message=\"Invoking all eclipse builders on workspace ${workspace}\" />" + NL + "        <buckminster command=\"build\" >" + NL + "            <cmdargs>" + NL + "                <arg value=\"--clean\" />" + NL + "                <arg value=\"--thorough\" />" + NL + "            </cmdargs>" + NL + "\t\t</buckminster>" + NL;
    protected final String TEXT_12 = "    </target>" + NL + NL;
    protected final String TEXT_13 = NL;
    protected final String TEXT_14 = NL;

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

        paramDesc = new IQuery.ParameterDescription("buildStep", "http://www.eclipse.org/egf/1.0.0/buildstep#//BuildStep");
        queryCtx = new HashMap<String, String>();
        List<Object> buildStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object buildStepParameter : buildStepList) {

            this.buildStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep) buildStepParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_13);
        stringBuffer.append(TEXT_14);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        method_computeStepName(ictx.getBuffer(), ictx);

        method_begin(ictx.getBuffer(), ictx);

        method_echo(ictx.getBuffer(), ictx);

        method_installJRE(ictx.getBuffer(), ictx);

        method_importTargetDefinition(ictx.getBuffer(), ictx);

        method_importWorkspace(ictx.getBuffer(), ictx);

        method_build(ictx.getBuffer(), ictx);

        method_end(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("buildStep", this.buildStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
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

        stepName = new GenerationHelper().getPositionString(buildStep);
        stringBuffer.append(TEXT_1);
    }

    protected void method_begin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_2);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_3);
        stringBuffer.append(new GenerationHelper().getCleanTypeString("", ",", buildStep.getCleanBeforeBuild()));
        stringBuffer.append(TEXT_4);
    }

    protected void method_echo(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_5);
    }

    protected void method_installJRE(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_6);
    }

    protected void method_importTargetDefinition(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_7);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_8);
    }

    protected void method_importWorkspace(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_9);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_10);
    }

    protected void method_build(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_11);
    }

    protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_12);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}