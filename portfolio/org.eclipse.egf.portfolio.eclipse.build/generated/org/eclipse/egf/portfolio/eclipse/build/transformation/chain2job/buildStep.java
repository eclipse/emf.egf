package org.eclipse.egf.portfolio.eclipse.build.transformation.chain2job;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;

public class buildStep {

    public buildStep() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        List<Object> buildStepList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object buildStepParameter : buildStepList) {

            this.buildStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep) buildStepParameter;

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
        method_handleCleanType(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("buildStep", this.buildStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected void method_handleCleanType(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (buildStep.getCleanBeforeBuild() == CLEAN_TYPE.RESULT) {
            buildStep.setCleanBeforeBuild(CLEAN_TYPE.WORKSPACE);
            Step firstStep = buildStep.getJob().getSteps().get(0);
            if (!firstStep.eClass().equals(BuildstepPackage.eINSTANCE.getCleanStep())) {
                CleanStep cleanStep = BuildstepFactory.eINSTANCE.createCleanStep();
                cleanStep.setType(CLEAN_TYPE.RESULT);
                buildStep.getJob().getSteps().add(0, cleanStep);
            }
        }

    }

    public boolean preCondition() throws Exception {
        return true;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep buildStep;

    public void set_buildStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.BuildStep buildStep) {
        this.buildStep = buildStep;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("buildStep", this.buildStep);
        return parameters;
    }

}
