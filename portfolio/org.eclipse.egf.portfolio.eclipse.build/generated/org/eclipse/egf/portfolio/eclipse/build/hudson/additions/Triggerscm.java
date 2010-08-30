package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class Triggerscm extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Triggeradd {
    protected static String nl;

    public static synchronized Triggerscm create(String lineSeparator) {
        nl = lineSeparator;
        Triggerscm result = new Triggerscm();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "    <hudson.triggers.SCMTrigger>" + NL + "      <spec>";
    protected final String TEXT_2 = "</spec>" + NL + "    </hudson.triggers.SCMTrigger>" + NL;
    protected final String TEXT_3 = NL;
    protected final String TEXT_4 = NL;

    public Triggerscm() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("scmTrigger", "http://www.eclipse.org/egf/1.0.0/buildtrigger#//SCMTrigger");
        queryCtx = new HashMap<String, String>();
        List<Object> scmTriggerList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object scmTriggerParameter : scmTriggerList) {

            this.scmTrigger = (org.eclipse.egf.portfolio.eclipse.build.buildtrigger.SCMTrigger) scmTriggerParameter;

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
            parameterValues.put("scmTrigger", this.scmTrigger);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildtrigger.SCMTrigger scmTrigger = null;

    public void set_scmTrigger(org.eclipse.egf.portfolio.eclipse.build.buildtrigger.SCMTrigger object) {
        this.scmTrigger = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("scmTrigger", this.scmTrigger);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(scmTrigger.getPlanning());
        stringBuffer.append(TEXT_2);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}