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
    protected final String TEXT_1 = "    <target name=\"";
    protected final String TEXT_2 = "\" depends=\"";
    protected final String TEXT_3 = "init,install.buckminster\">" + NL + "        <echo message=\"Importing projects into workspace ${workspace} and binaries into target platform\" />" + NL + "" + NL + "    \t<buckminster command=\"installJRE\">" + NL + "            <cmdargs>" + NL + "                <arg value=\"--location\" />" + NL + "                <arg value=\"${env.JAVA_HOME}\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>" + NL + "" + NL + "        <buckminster command=\"importtargetdefinition\">" + NL + "            <cmdargs>" + NL + "                <arg value=\"--active\" />" + NL + "                <arg value=\"${basedir}/buckminster/";
    protected final String TEXT_4 = "/build.target\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>" + NL + "    \t" + NL + "        <buckminster command=\"import\">" + NL + "            <!-- Uncomment to debug <globargs><jvmarg value=\"-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=y\"/></globargs> -->" + NL + "            <cmdargs>" + NL + "                <arg value=\"-P\" />" + NL + "                <arg value=\"${basedir}/build.properties\" />" + NL + "                <arg value=\"${basedir}/buckminster/";
    protected final String TEXT_5 = "/build.mspec\" />" + NL + "            </cmdargs>" + NL + "        </buckminster>" + NL + "" + NL + "        <echo message=\"Invoking all eclipse builders on workspace ${workspace}\" />" + NL + "        <buckminster command=\"build\" />" + NL + "    </target>" + NL + NL;
    protected final String TEXT_6 = NL;
    protected final String TEXT_7 = NL;

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
        List<Object> buildStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);

        for (Object buildStepParameter : buildStepList) {

            this.buildStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep) buildStepParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_6);
        stringBuffer.append(TEXT_7);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

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

        String stepName = new GenerationHelper().getPositionString(buildStep);
        stringBuffer.append(TEXT_1);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(new GenerationHelper().getCleanTypeString("", ",", buildStep.getCleanBeforeBuild()));
        stringBuffer.append(TEXT_3);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_4);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_5);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}