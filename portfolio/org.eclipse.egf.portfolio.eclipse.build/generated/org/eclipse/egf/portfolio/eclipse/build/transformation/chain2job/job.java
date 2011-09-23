package org.eclipse.egf.portfolio.eclipse.build.transformation.chain2job;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

public class job {

    public job() {
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
        method_getNewJob(ictx.getBuffer(), ictx);
        method_movePropertiesToNewJob(ictx.getBuffer(), ictx);
        method_moveScmToNewJob(ictx.getBuffer(), ictx);
        method_moveStepsToNewJob(ictx.getBuffer(), ictx);
        method_moveTriggersToNewJob(ictx.getBuffer(), ictx);
        method_removeJobFromChain(ictx.getBuffer(), ictx);
        method_handleCleanStep(ictx.getBuffer(), ictx);

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

    protected void method_getNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
        newJob = (Job) ctx.getValue("newJob");
    }

    protected void method_movePropertiesToNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (job.equals(newJob))
            return;

        newJob.getProperties().addAll(job.getProperties());
    }

    protected void method_moveScmToNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (job.equals(newJob))
            return;

        if (job.getScms() != null && job.getScms().eClass().equals(BuildscmPackage.eINSTANCE.getSVN())) {
            if (newJob.getScms() == null)
                newJob.setScms(BuildscmFactory.eINSTANCE.createSVN());

            SVN newScm = (SVN) newJob.getScms();
            SVN scm = (SVN) job.getScms();
            for (SVNLocation svnLocation : scm.getLocations()) {
                svnLocation.setLocalPath(job.getName() + "_" + svnLocation.getLocalPath());
            }
            newScm.getLocations().addAll(scm.getLocations());
        }
    }

    protected void method_moveStepsToNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (job.equals(newJob))
            return;

        newJob.getSteps().addAll(job.getSteps());
    }

    protected void method_moveTriggersToNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (job.equals(newJob))
            return;

        newJob.getTriggers().addAll(job.getTriggers());
    }

    protected void method_removeJobFromChain(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (job.equals(newJob))
            return;

        Chain chain = (Chain) job.eContainer();
        chain.getJobs().remove(job);
    }

    protected void method_handleCleanStep(final StringBuffer out, final PatternContext ctx) throws Exception {
        boolean firstOne = true;
        for (Step step : newJob.getSteps()) {
            if (step instanceof CleanStep) {
                CleanStep cleanStep = (CleanStep) step;
                if (!firstOne && CLEAN_TYPE.RESULT == cleanStep.getType())
                    cleanStep.setType(CLEAN_TYPE.WORKSPACE);
                firstOne = false;
            }
        }
    }

    public boolean preCondition() throws Exception {
        return true;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Job job;

    public void set_job(org.eclipse.egf.portfolio.eclipse.build.buildcore.Job job) {
        this.job = job;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Job newJob;

    public void set_newJob(org.eclipse.egf.portfolio.eclipse.build.buildcore.Job newJob) {
        this.newJob = newJob;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("job", this.job);
        return parameters;
    }

}
