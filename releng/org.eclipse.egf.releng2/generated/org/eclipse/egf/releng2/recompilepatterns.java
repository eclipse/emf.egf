package org.eclipse.egf.releng2;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class recompilepatterns extends org.eclipse.egf.portfolio.eclipse.build.buckminster.additions.buildxmlbuildStep {
    protected static String nl;

    public static synchronized recompilepatterns create(String lineSeparator) {
        nl = lineSeparator;
        recompilepatterns result = new recompilepatterns();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "    <target name=\"";
    protected final String TEXT_2 = "\" depends=\"";
    protected final String TEXT_3 = "init,install.buckminster, install.egf\">" + NL;
    protected final String TEXT_4 = "        <echo message=\"Recompile all patterns workspace ${workspace}\" />" + NL + "\t\t<egf>" + NL + "            <globargs>" + NL + "\t\t\t\t<jvmarg value=\"-Degf.target.bundle.priority=true\" />" + NL + "\t\t\t</globargs>" + NL + "\t\t\t<activities>" + NL + "\t\t\t\t<arg value=\"platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_gKQyUdBbEd-GApoE4u-xfw\"/>" + NL + "\t\t\t</activities>" + NL + "\t\t</egf>" + NL + "" + NL + "        <echo message=\"Invoking all eclipse builders on workspace ${workspace}\" />" + NL + "        <buckminster command=\"build\" >" + NL + "            <cmdargs>" + NL + "                <arg value=\"--clean\" />" + NL + "                <arg value=\"--thorough\" />" + NL + "            </cmdargs>" + NL
            + "\t\t</buckminster>" + NL + "\t\t";
    protected final String TEXT_5 = NL;
    protected final String TEXT_6 = NL;

    public recompilepatterns() {
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

        stringBuffer.append(TEXT_5);
        stringBuffer.append(TEXT_6);
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

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("buildStep", this.buildStep);
        return parameters;
    }

    protected void method_begin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(new GenerationHelper().getCleanTypeString("", ",", buildStep.getCleanBeforeBuild()));
        stringBuffer.append(TEXT_3);
    }

    protected void method_build(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_4);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}