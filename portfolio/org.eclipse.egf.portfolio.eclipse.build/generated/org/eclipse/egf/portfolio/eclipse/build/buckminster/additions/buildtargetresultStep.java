package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

public class buildtargetresultStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildtargetadd {
    protected static String nl;

    public static synchronized buildtargetresultStep create(String lineSeparator) {
        nl = lineSeparator;
        buildtargetresultStep result = new buildtargetresultStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = " " + NL + "\t\t<location path=\"";
    protected final String TEXT_2 = "\" type=\"Directory\"/>" + NL;
    protected final String TEXT_3 = NL;
    protected final String TEXT_4 = NL;

    public buildtargetresultStep() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("resultStepBuildLocation", "http://www.eclipse.org/egf/1.0.1/buildstep#//ResultStepBuildLocation");
        queryCtx = new HashMap<String, String>();
        List<Object> resultStepBuildLocationList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object resultStepBuildLocationParameter : resultStepBuildLocationList) {

            this.resultStepBuildLocation = (org.eclipse.egf.portfolio.eclipse.build.buildstep.ResultStepBuildLocation) resultStepBuildLocationParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_3);
        stringBuffer.append(TEXT_4);
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
            parameterValues.put("resultStepBuildLocation", this.resultStepBuildLocation);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
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

        String name = null;
        if (resultStepBuildLocation.getResultStep() instanceof PublishStep)
            name = ((PublishStep) resultStepBuildLocation.getResultStep()).getComponent().getName();
        else if (resultStepBuildLocation.getResultStep() instanceof AggregateStep)
            name = ((AggregateStep) resultStepBuildLocation.getResultStep()).getName();
        String location = "${workspace_loc}/../../../../" + new GenerationHelper().getJobName(ctx, resultStepBuildLocation.getResultStep().getJob()) + "/workspace/result/publish/" + name + "/dropins/" + name + "/eclipse";

        stringBuffer.append(TEXT_1);
        stringBuffer.append(location);
        stringBuffer.append(TEXT_2);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}