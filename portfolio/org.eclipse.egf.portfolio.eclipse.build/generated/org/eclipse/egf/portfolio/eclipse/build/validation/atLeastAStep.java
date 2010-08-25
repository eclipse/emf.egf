package org.eclipse.egf.portfolio.eclipse.build.validation;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.eclipse.emf.common.util.*;

public class atLeastAStep extends org.eclipse.egf.pattern.validation.AbstractValidationPattern {

    public atLeastAStep() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        List<Object> jobList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object jobParameter : jobList) {

            this.job = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Job) jobParameter;

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
        super.orchestration(new SuperOrchestrationContext(ictx));
        method_body(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("job", this.job);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (job.getSteps().isEmpty()) {
            BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.WARNING, "org.eclipse.egf.portfolio.build", 0, "a job should have at least a step", new Object[] { job });
            diagnosticChain.add(diagnostic);
        }

    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Job job;

    public void set_job(org.eclipse.egf.portfolio.eclipse.build.buildcore.Job job) {
        this.job = job;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("job", this.job);
        return parameters;
    }

}
