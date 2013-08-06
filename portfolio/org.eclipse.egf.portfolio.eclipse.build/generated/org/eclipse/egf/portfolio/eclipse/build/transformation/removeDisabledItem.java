//Generated on Tue Aug 06 15:15:16 CEST 2013 with EGF 1.0.0.qualifier
package org.eclipse.egf.portfolio.eclipse.build.transformation;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

public class removeDisabledItem {

    public removeDisabledItem() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        Node.Container currentNode = ctx.getNode();
        List<Object> itemList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object itemParameter : itemList) {

            this.item = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Item) itemParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration((PatternContext) argument);

            }
        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        Node.Container currentNode = ictx.getNode();
        method_body(new StringBuffer(), ictx);
        ictx.setNode(currentNode);
        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("item", this.item);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (!item.isEnabled()) {
            org.eclipse.emf.ecore.util.EcoreUtil.delete(item);
        }

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return true;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Item item;

    public void set_item(org.eclipse.egf.portfolio.eclipse.build.buildcore.Item item) {
        this.item = item;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("item", this.item);
        return parameters;
    }

}
