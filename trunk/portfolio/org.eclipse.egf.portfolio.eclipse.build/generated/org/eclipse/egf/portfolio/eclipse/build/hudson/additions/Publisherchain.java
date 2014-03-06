//Generated on Tue Aug 06 15:15:14 CEST 2013 with EGF 1.0.0.qualifier
package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;

public class Publisherchain extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Publisheradd {
    protected static String nl;

    public static synchronized Publisherchain create(String lineSeparator) {
        nl = lineSeparator;
        Publisherchain result = new Publisherchain();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t";
    protected final String TEXT_2 = NL + "    <hudson.tasks.BuildTrigger>" + NL + "      <childProjects>";
    protected final String TEXT_3 = "</childProjects>" + NL + "      <threshold>" + NL + "        <name>UNSTABLE</name>" + NL + "        <ordinal>1</ordinal>" + NL + "        <color>YELLOW</color>" + NL + "      </threshold>" + NL + "    </hudson.tasks.BuildTrigger>";
    protected final String TEXT_4 = NL;
    protected final String TEXT_5 = NL;

    public Publisherchain() {
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

        paramDesc = new IQuery.ParameterDescription("job", "http://www.eclipse.org/egf/1.0.1/buildcore#//Job");
        queryCtx = new HashMap<String, String>();
        List<Object> jobList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object jobParameter : jobList) {

            this.job = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Job) jobParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_4);
        stringBuffer.append(TEXT_5);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("job", this.job);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Job job = null;

    public void set_job(org.eclipse.egf.portfolio.eclipse.build.buildcore.Job object) {
        this.job = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("job", this.job);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        Job nextJob = new GenerationHelper().getNextChainJob(job);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(new GenerationHelper().getJobName(ctx, nextJob));
        stringBuffer.append(TEXT_3);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return new GenerationHelper().getNextChainJob(job) != null;
    }
}