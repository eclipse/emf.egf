package org.eclipse.egf.portfolio.eclipse.build.transformation.chain2job;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;

public class chain {

    public chain() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        List<Object> chainList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object chainParameter : chainList) {

            this.chain = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain) chainParameter;

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
        method_createNewJob(ictx.getBuffer(), ictx);
        method_putNewJobInContext(ictx.getBuffer(), ictx);
        method_addNewJobToChain(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("chain", this.chain);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected void method_createNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
        newJob = BuildcoreFactory.eINSTANCE.createJob();
        newJob.setName("all");
    }

    protected void method_putNewJobInContext(final StringBuffer out, final PatternContext ctx) throws Exception {
        ctx.setValue("newJob", newJob);
    }

    protected void method_addNewJobToChain(final StringBuffer out, final PatternContext ctx) throws Exception {
        chain.getJobs().add(0, newJob);
    }

    public boolean preCondition() throws Exception {
        return true;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain chain;

    public void set_chain(org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain chain) {
        this.chain = chain;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Job newJob;

    public void set_newJob(org.eclipse.egf.portfolio.eclipse.build.buildcore.Job newJob) {
        this.newJob = newJob;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chain", this.chain);
        return parameters;
    }

}
