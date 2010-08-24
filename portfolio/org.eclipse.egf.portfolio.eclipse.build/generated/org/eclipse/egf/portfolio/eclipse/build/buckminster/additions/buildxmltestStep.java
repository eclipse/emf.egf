package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildxmltestStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmltestStep create(String lineSeparator) {
        nl = lineSeparator;
        buildxmltestStep result = new buildxmltestStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\" depends=\"init,install.buckminster\">" + NL + "\t  <echo message=\"Running Junit tests ";
    protected final String TEXT_3 = "\" />" + NL + "      <buckminster command=\"";
    protected final String TEXT_4 = "\">" + NL + "        <cmdargs>" + NL + "          <arg value=\"-l\" />" + NL + "          <arg value=\"";
    protected final String TEXT_5 = "\" />" + NL + "          <arg value=\"-o\" />" + NL + "          <arg value=\"${result}/testReport";
    protected final String TEXT_6 = ".xml\" />" + NL + "          <arg value=\"--terseXML\" />" + NL + "          <arg value=\"--flatXML\"/>";
    protected final String TEXT_7 = NL + "          <arg value=\"--xml\" />" + NL + "          <arg value=\"${result}/coverageReport";
    protected final String TEXT_8 = ".xml\" />";
    protected final String TEXT_9 = NL + "        </cmdargs>" + NL + "      </buckminster>" + NL + "\t</target>" + NL + NL;
    protected final String TEXT_10 = NL;
    protected final String TEXT_11 = NL;

    public buildxmltestStep() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("testStep", "http://www.eclipse.org/egf/1.0.0/buildstep#//TestStep");
        queryCtx = new HashMap<String, String>();
        List<Object> testStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);

        for (Object testStepParameter : testStepList) {

            this.testStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep) testStepParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_10);
        stringBuffer.append(TEXT_11);
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
            parameterValues.put("testStep", this.testStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep testStep = null;

    public void set_testStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.TestStep object) {
        this.testStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("testStep", this.testStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        String stepName = new GenerationHelper().getPositionString(testStep);
        stringBuffer.append(TEXT_1);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(testStep.isCodeCoverage() ? "and Emma code coverage" : "");
        stringBuffer.append(TEXT_3);
        stringBuffer.append(testStep.isCodeCoverage() ? "emma" : "junit");
        stringBuffer.append(TEXT_4);
        stringBuffer.append(testStep.getLaunchConfigurationPath());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_6);
        if (testStep.isCodeCoverage()) {
            stringBuffer.append(TEXT_7);
            stringBuffer.append(stepName);
            stringBuffer.append(TEXT_8);
        }
        stringBuffer.append(TEXT_9);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}