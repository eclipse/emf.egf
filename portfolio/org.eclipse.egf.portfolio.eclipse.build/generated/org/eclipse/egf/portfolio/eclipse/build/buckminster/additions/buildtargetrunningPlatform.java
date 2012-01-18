//Generated on Wed Jan 18 13:40:32 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildtargetrunningPlatform extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildtargetadd {
    protected static String nl;

    public static synchronized buildtargetrunningPlatform create(String lineSeparator) {
        nl = lineSeparator;
        buildtargetrunningPlatform result = new buildtargetrunningPlatform();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t\t<location path=\"${eclipse_home}\" type=\"Profile\"/>" + NL;
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public buildtargetrunningPlatform() {
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

        paramDesc = new IQuery.ParameterDescription("runningPlatformBuildLocation", "http://www.eclipse.org/egf/1.0.1/buildstep#//RunningPlatformBuildLocation");
        queryCtx = new HashMap<String, String>();
        List<Object> runningPlatformBuildLocationList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object runningPlatformBuildLocationParameter : runningPlatformBuildLocationList) {

            this.runningPlatformBuildLocation = (org.eclipse.egf.portfolio.eclipse.build.buildstep.RunningPlatformBuildLocation) runningPlatformBuildLocationParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(TEXT_3);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("runningPlatformBuildLocation", this.runningPlatformBuildLocation);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.RunningPlatformBuildLocation runningPlatformBuildLocation = null;

    public void set_runningPlatformBuildLocation(org.eclipse.egf.portfolio.eclipse.build.buildstep.RunningPlatformBuildLocation object) {
        this.runningPlatformBuildLocation = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("runningPlatformBuildLocation", this.runningPlatformBuildLocation);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}