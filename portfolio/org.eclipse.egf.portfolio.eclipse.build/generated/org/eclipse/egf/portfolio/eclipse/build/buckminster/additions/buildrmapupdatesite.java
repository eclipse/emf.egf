//Generated on Wed Jan 18 13:40:32 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildrmapupdatesite extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildrmaplocationadd {
    protected static String nl;

    public static synchronized buildrmapupdatesite create(String lineSeparator) {
        nl = lineSeparator;
        buildrmapupdatesite result = new buildrmapupdatesite();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<locator searchPathRef=\"";
    protected final String TEXT_2 = "\" ";
    protected final String TEXT_3 = " failOnError=\"false\" />" + NL + "\t<searchPath name=\"";
    protected final String TEXT_4 = "\">" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"p2\" source=\"false\" mutable=\"false\">" + NL + "\t\t\t<uri format=\"";
    protected final String TEXT_5 = "\">" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t</searchPath>" + NL + NL;
    protected final String TEXT_6 = NL;
    protected final String TEXT_7 = NL;

    public buildrmapupdatesite() {
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

        paramDesc = new IQuery.ParameterDescription("updateSiteBuildLocation", "http://www.eclipse.org/egf/1.0.1/buildstep#//UpdateSiteBuildLocation");
        queryCtx = new HashMap<String, String>();
        List<Object> updateSiteBuildLocationList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object updateSiteBuildLocationParameter : updateSiteBuildLocationList) {

            this.updateSiteBuildLocation = (org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation) updateSiteBuildLocationParameter;

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
            parameterValues.put("updateSiteBuildLocation", this.updateSiteBuildLocation);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation updateSiteBuildLocation = null;

    public void set_updateSiteBuildLocation(org.eclipse.egf.portfolio.eclipse.build.buildstep.UpdateSiteBuildLocation object) {
        this.updateSiteBuildLocation = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("updateSiteBuildLocation", this.updateSiteBuildLocation);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        String id = new GenerationHelper().getIdOrPositionString(updateSiteBuildLocation);
        stringBuffer.append(TEXT_1);
        stringBuffer.append(id);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(new GenerationHelper().getPatternString(updateSiteBuildLocation));
        stringBuffer.append(TEXT_3);
        stringBuffer.append(id);
        stringBuffer.append(TEXT_4);
        stringBuffer.append(updateSiteBuildLocation.getUrl());
        stringBuffer.append(TEXT_5);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}