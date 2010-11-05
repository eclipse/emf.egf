package org.eclipse.egf.portfolio.eclipse.build.transformation.chain2job;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

public class cleanStep {

    public cleanStep() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        List<Object> cleanStepList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object cleanStepParameter : cleanStepList) {

            this.cleanStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep) cleanStepParameter;

            if (preCondition())
                orchestration((PatternContext) argument);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();
        method_removeCleanStep(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("cleanStep", this.cleanStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected void method_removeCleanStep(final StringBuffer out, final PatternContext ctx) throws Exception {
        cleanStep.getJob().getSteps().remove(cleanStep);
    }

    public boolean preCondition() throws Exception {
        return true;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep cleanStep;

    public void set_cleanStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep cleanStep) {
        this.cleanStep = cleanStep;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("cleanStep", this.cleanStep);
        return parameters;
    }

}
