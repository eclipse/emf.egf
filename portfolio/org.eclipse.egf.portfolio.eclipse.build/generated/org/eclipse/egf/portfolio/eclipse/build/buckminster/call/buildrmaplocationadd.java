//Generated on Tue Jan 10 13:46:21 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.call;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class buildrmaplocationadd {
    protected static String nl;

    public static synchronized buildrmaplocationadd create(String lineSeparator) {
        nl = lineSeparator;
        buildrmaplocationadd result = new buildrmaplocationadd();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL;

    public buildrmaplocationadd() {
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
            ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_1);
        stringBuffer.append(TEXT_2);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        method_body(new StringBuffer(), ictx);

        String loop = OutputManager.getOutputWithoutCallback(ictx);
        if (ictx.useReporter()) {
            ;
        }
        return loop;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return true;
    }
}