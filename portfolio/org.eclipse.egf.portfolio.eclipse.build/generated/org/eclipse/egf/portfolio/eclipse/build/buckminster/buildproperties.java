package org.eclipse.egf.portfolio.eclipse.build.buckminster;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class buildproperties extends org.eclipse.egf.portfolio.eclipse.build.JobFilePattern {
    protected static String nl;

    public static synchronized buildproperties create(String lineSeparator) {
        nl = lineSeparator;
        buildproperties result = new buildproperties();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = NL + "#eclipse" + NL + "eclipse.download.prefix=file:/home/data/httpd/download.eclipse.org" + NL + "" + NL + "#buckminster installation" + NL + "buckminster.download.url=${eclipse.download.prefix}/tools/buckminster" + NL + "director.url=${buckminster.download.url}/products/director_latest.zip" + NL + "buckminster.release=3.6" + NL + "bm.headless.site=${buckminster.download.url}/headless-${buckminster.release}" + NL + "bm.external.site=http://download.cloudsmith.com/buckminster/external-${buckminster.release}" + NL + "" + NL + "#egf installation" + NL + "#TODO change url site" + NL + "egf.site=file:/C:/matt/hudson/jobs/buckminster-egf-workspace-36/workspace/result/publish/org.eclipse.egf.application/site" + NL + "" + NL
            + "#do not generate version range with buckminster in manifest.mf and content.jar" + NL + "pde.bundle.range.generation=false" + NL + "" + NL + "#build" + NL + "buckminster.loglevel=INFO" + NL + "" + NL + "#qualifier" + NL + "qualifier.replacement.*=generator:buildTimestamp" + NL + "generator.buildTimestamp.format='v'yyyyMMdd-HHmm" + NL + "" + NL + "#signing" + NL + "signing.type=eclipse.local" + NL + "site.pack200=true" + NL + "site.retain.unpacked=false" + NL + "" + NL + "#local" + NL + "eclipse.download.prefix=http://download.eclipse.org" + NL;
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public buildproperties() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> jobList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object jobParameter : jobList) {

            this.job = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Job) jobParameter;

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

        method_body(ictx.getBuffer(), ictx);
        {
            ExecutionContext ctx_local = new ExecutionContext(ictx);
            ctx_local.setValue(PatternContext.INJECTED_CONTEXT, job);
            CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_4NTLAJNGEd-BJKD_XS9R2A", ctx_local);
        }

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("job", this.job);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("job", this.job);
        return parameters;
    }

    protected void method_setFileName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        fileName = "build.properties";
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        {
            //<%@ egf:patternCall
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.TextHeader"
            //%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_xJwAgJ5OEd-3wvN5SnesGA", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_1);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}