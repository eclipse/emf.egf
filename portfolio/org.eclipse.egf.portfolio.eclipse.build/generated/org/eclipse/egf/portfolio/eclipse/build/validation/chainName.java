//Generated on Fri Feb 03 19:11:11 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.validation;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.eclipse.emf.common.util.*;

public class chainName extends org.eclipse.egf.pattern.validation.AbstractValidationPattern {

    public chainName() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        Node.Container currentNode = ctx.getNode();
        List<Object> chainList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object chainParameter : chainList) {

            this.chain = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain) chainParameter;

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
        super.orchestration(new SuperOrchestrationContext(ictx));
        method_body(new StringBuffer(), ictx);
        ictx.setNode(currentNode);
        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("chain", this.chain);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (chain.getName() == null || chain.getName().trim().length() == 0) {
            BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.ERROR, "org.eclipse.egf.portfolio.build", 0, "Chains must have a name ", new Object[] { chain });
            diagnosticChain.add(diagnostic);
        }

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain chain;

    public void set_chain(org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain chain) {
        this.chain = chain;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chain", this.chain);
        return parameters;
    }

}
