//Generated on Tue Aug 06 15:15:14 CEST 2013 with EGF 1.0.0.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class buckminstercspecplugin extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buckminstercspecdepsadd {
    protected static String nl;

    public static synchronized buckminstercspecplugin create(String lineSeparator) {
        nl = lineSeparator;
        buckminstercspecplugin result = new buckminstercspecplugin();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "        <cs:dependency name=\"";
    protected final String TEXT_2 = "\" componentType=\"osgi.bundle\"/>" + NL;
    protected final String TEXT_3 = NL;
    protected final String TEXT_4 = NL;

    public buckminstercspecplugin() {
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

        paramDesc = new IQuery.ParameterDescription("plugin", "http://www.eclipse.org/egf/1.0.2/buildstep#//Plugin");
        queryCtx = new HashMap<String, String>();
        List<Object> pluginList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object pluginParameter : pluginList) {

            this.plugin = (org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin) pluginParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_3);
        stringBuffer.append(TEXT_4);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("plugin", this.plugin);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin plugin = null;

    public void set_plugin(org.eclipse.egf.portfolio.eclipse.build.buildstep.Plugin object) {
        this.plugin = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("plugin", this.plugin);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(plugin.getId());
        stringBuffer.append(TEXT_2);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}