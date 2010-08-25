package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class PublisherjavadocStep extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Publisheradd {
    protected static String nl;

    public static synchronized PublisherjavadocStep create(String lineSeparator) {
        nl = lineSeparator;
        PublisherjavadocStep result = new PublisherjavadocStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "    <hudson.tasks.JavadocArchiver>" + NL + "      <javadocDir>../javadoc</javadocDir>" + NL + "      <keepAll>false</keepAll>" + NL + "    </hudson.tasks.JavadocArchiver>" + NL;
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public PublisherjavadocStep() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("javadocStep", "http://www.eclipse.org/egf/1.0.0/buildstep#//JavadocStep");
        queryCtx = new HashMap<String, String>();
        List<Object> javadocStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);

        for (Object javadocStepParameter : javadocStepList) {

            this.javadocStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep) javadocStepParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(TEXT_3);
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
            parameterValues.put("javadocStep", this.javadocStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep javadocStep = null;

    public void set_javadocStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep object) {
        this.javadocStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("javadocStep", this.javadocStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}