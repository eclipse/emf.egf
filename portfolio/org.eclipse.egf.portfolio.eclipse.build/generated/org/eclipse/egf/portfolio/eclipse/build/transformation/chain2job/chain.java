//Generated on Tue Jan 10 17:23:25 CET 2012 with EGF 0.6.1.qualifier
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
		method_createNewJob(new StringBuffer(), ictx);
		method_putNewJobInContext(new StringBuffer(), ictx);
		method_addNewJobToChain(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("chain", this.chain);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_createNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
		newJob = BuildcoreFactory.eINSTANCE.createJob();
		newJob.setName(chain.getName());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "createNewJob", out.toString());
	}

	protected void method_putNewJobInContext(final StringBuffer out, final PatternContext ctx) throws Exception {
		ctx.setValue("newJob", newJob);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "putNewJobInContext", out.toString());
	}

	protected void method_addNewJobToChain(final StringBuffer out, final PatternContext ctx) throws Exception {
		chain.getJobs().add(newJob);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "addNewJobToChain", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
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
