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

			if (preCondition()) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration((PatternContext) argument);

			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_createNewJob(new StringBuffer(), ictx);
		method_putNewJobInContext(new StringBuffer(), ictx);
		method_addNewJobToChain(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("chain", this.chain);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return loop;
	}

	protected void method_createNewJob(final StringBuffer out, final PatternContext ctx) throws Exception {
		newJob = BuildcoreFactory.eINSTANCE.createJob();
		newJob.setName("all");

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@ba709 (description: null) (name: createNewJob) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._VmwQYOD7Ed-wsOGCR2RJpg/method._VmwQZeD7Ed-wsOGCR2RJpg.pt)", out.toString());
	}

	protected void method_putNewJobInContext(final StringBuffer out, final PatternContext ctx) throws Exception {
		ctx.setValue("newJob", newJob);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@c2ef53 (description: null) (name: putNewJobInContext) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._VmwQYOD7Ed-wsOGCR2RJpg/method._bX9uIOEIEd-wsOGCR2RJpg.pt)", out.toString());
	}

	protected void method_addNewJobToChain(final StringBuffer out, final PatternContext ctx) throws Exception {
		chain.getJobs().add(0, newJob);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1ee470d (description: null) (name: addNewJobToChain) (patternFilePath: platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/templates/pattern._VmwQYOD7Ed-wsOGCR2RJpg/method._nJpvUOEPEd-wsOGCR2RJpg.pt)", out.toString());
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
