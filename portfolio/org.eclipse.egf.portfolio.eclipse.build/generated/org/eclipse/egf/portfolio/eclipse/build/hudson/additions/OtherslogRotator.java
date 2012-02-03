//Generated on Fri Feb 03 18:20:05 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class OtherslogRotator extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Othersadd {
    protected static String nl;

    public static synchronized OtherslogRotator create(String lineSeparator) {
        nl = lineSeparator;
        OtherslogRotator result = new OtherslogRotator();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "  <logRotator>" + NL + "    <daysToKeep>-1</daysToKeep>" + NL + "    <numToKeep>10</numToKeep>" + NL + "    <artifactDaysToKeep>-1</artifactDaysToKeep>" + NL + "    <artifactNumToKeep>-1</artifactNumToKeep>" + NL + "  </logRotator>" + NL;
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public OtherslogRotator() {
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

        if (preCondition(ctx)) {
            ctx.setNode(new Node.Container(currentNode, getClass()));
            orchestration(ctx);
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

        return null;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}