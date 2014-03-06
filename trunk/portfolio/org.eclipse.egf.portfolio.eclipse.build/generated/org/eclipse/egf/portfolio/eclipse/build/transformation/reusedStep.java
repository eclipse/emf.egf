//Generated on Tue Aug 06 15:15:16 CEST 2013 with EGF 1.0.0.qualifier
package org.eclipse.egf.portfolio.eclipse.build.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.execution.OutputManager;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.ReuseStep;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class reusedStep {

    public reusedStep() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        Node.Container currentNode = ctx.getNode();
        List<Object> stepContainerList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object stepContainerParameter : stepContainerList) {

            this.stepContainer = (org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer) stepContainerParameter;

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
            parameterValues.put("stepContainer", this.stepContainer);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
        ArrayList<Step> steps = new ArrayList<Step>(stepContainer.getSteps());
        for (Step step : steps) {
            if (step instanceof ReuseStep) {
                ReuseStep reuseStep = (ReuseStep) step;
                Step reusedStep = reuseStep.getReusedStep();

                Step stepCopy = EcoreUtil.copy(reusedStep);
                if (reuseStep.getName() != null && reuseStep.getName().trim().length() > 0)
                    stepCopy.setName(reuseStep.getName());
                stepCopy.setEnabled(reuseStep.isEnabled() && reusedStep.isEnabled());

                int indexOfReuseStep = stepContainer.getSteps().indexOf(reuseStep);
                stepContainer.getSteps().set(indexOfReuseStep, stepCopy);
            }
        }

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return true;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer stepContainer;

    public void set_stepContainer(org.eclipse.egf.portfolio.eclipse.build.buildcore.AbstractStepContainer stepContainer) {
        this.stepContainer = stepContainer;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("stepContainer", this.stepContainer);
        return parameters;
    }

}
