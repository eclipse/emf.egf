//Generated on Wed Jan 18 13:40:31 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildrmaprunningPlatform extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildrmaplocationadd {
    protected static String nl;

    public static synchronized buildrmaprunningPlatform create(String lineSeparator) {
        nl = lineSeparator;
        buildrmaprunningPlatform result = new buildrmaprunningPlatform();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "    ";
    protected final String TEXT_2 = NL + "\t<locator searchPathRef=\"targetPlatform";
    protected final String TEXT_3 = "\" ";
    protected final String TEXT_4 = " failOnError=\"false\" />" + NL + "\t<searchPath name=\"targetPlatform";
    protected final String TEXT_5 = "\">" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"eclipse.platform\">" + NL + "\t\t\t<uri format=\"plugin/{0}\">" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"eclipse.platform\">" + NL + "\t\t\t<uri format=\"feature/{0}\">" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t</searchPath>" + NL + NL;
    protected final String TEXT_6 = NL;
    protected final String TEXT_7 = NL;

    public buildrmaprunningPlatform() {
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

        stringBuffer.append(TEXT_6);
        stringBuffer.append(TEXT_7);
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
        String id = new GenerationHelper().getIdOrPositionString(runningPlatformBuildLocation);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(id);
        stringBuffer.append(TEXT_3);
        stringBuffer.append(new GenerationHelper().getPatternString(runningPlatformBuildLocation));
        stringBuffer.append(TEXT_4);
        stringBuffer.append(id);
        stringBuffer.append(TEXT_5);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}