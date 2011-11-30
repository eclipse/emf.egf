//Generated on Wed Nov 30 10:57:51 CET 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.validation;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.Step;

public class stepId extends org.eclipse.egf.pattern.validation.AbstractValidationPattern {

	public stepId() {
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
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		super.orchestration(new SuperOrchestrationContext(ictx));
		method_checkDuplicateId(new StringBuffer(), ictx);
		method_checkNotEmptyStringId(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("job", this.job);
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return loop;
	}

	protected void method_checkDuplicateId(final StringBuffer out, final PatternContext ctx) throws Exception {
		Collection<String> stepIds = new ArrayList<String>();
		for (Step step : job.getSteps()) {
			if (step.getId() != null) {
				if (stepIds.contains(step.getId())) {
					BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.ERROR, "org.eclipse.egf.portfolio.build", 0, "duplicate step Id " + step.getId(), new Object[] { job });
					diagnosticChain.add(diagnostic);
				}
				stepIds.add(step.getId());
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "checkDuplicateId", out.toString());
	}

	protected void method_checkNotEmptyStringId(final StringBuffer out, final PatternContext ctx) throws Exception {
		for (Step step : job.getSteps()) {
			if ("".equals(step.getId())) {
				BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.ERROR, "org.eclipse.egf.portfolio.build", 0, "step Id is an empty string " + step.getId(), new Object[] { job });
				diagnosticChain.add(diagnostic);
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "checkNotEmptyStringId", out.toString());
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

	public boolean preCondition() {
		return true;
	}
}
