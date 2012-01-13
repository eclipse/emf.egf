//Generated on Thu Jan 12 17:22:05 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.transformation.chain2job;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class job {

	public job() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> jobList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object jobParameter : jobList) {

			this.job = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Job) jobParameter;

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
		method_getNewJob(new StringBuffer(), ictx);
		method_movePropertiesToNewJob(new StringBuffer(), ictx);
		method_moveScmToNewJob(new StringBuffer(), ictx);
		method_moveStepsToNewJob(new StringBuffer(), ictx);
		method_moveTriggersToNewJob(new StringBuffer(), ictx);
		method_removeJobFromChain(new StringBuffer(), ictx);
		method_handleCleanStep(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("job", this.job);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_getNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
		newJob = (Job) ctx.getValue("newJob");

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getNewJob", out.toString());
	}

	protected void method_movePropertiesToNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (job.equals(newJob))
			return;

		newJob.getProperties().addAll(job.getProperties());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "movePropertiesToNewJob", out.toString());
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

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "moveScmToNewJob", out.toString());
	}

	protected void method_moveStepsToNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (job.equals(newJob))
			return;

		newJob.getSteps().addAll(job.getSteps());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "moveStepsToNewJob", out.toString());
	}

	protected void method_moveTriggersToNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (job.equals(newJob))
			return;

		newJob.getTriggers().addAll(job.getTriggers());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "moveTriggersToNewJob", out.toString());
	}

	protected void method_removeJobFromChain(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (job.equals(newJob))
			return;

		Chain chain = (Chain) job.eContainer();
		chain.getJobs().remove(job);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "removeJobFromChain", out.toString());
	}

	protected void method_handleCleanStep(final StringBuffer out, final PatternContext ctx) throws Exception {
		boolean firstOne = true;
		for (Step step : new GenerationHelper().getAllSteps(newJob)) {
			if (step instanceof CleanStep) {
				CleanStep cleanStep = (CleanStep) step;
				if (!firstOne && CLEAN_TYPE.RESULT == cleanStep.getType())
					cleanStep.setType(CLEAN_TYPE.WORKSPACE);
				firstOne = false;
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "handleCleanStep", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
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
