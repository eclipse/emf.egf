//Generated on Mon Nov 07 17:44:53 CET 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.example.strategy.modeldriven.validation;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.eclipse.emf.common.util.*;

public class classWithoutAttributes extends org.eclipse.egf.pattern.validation.AbstractValidationPattern {

	public classWithoutAttributes() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> eClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object eClassParameter : eClassList) {

			this.eClass = (org.eclipse.emf.ecore.EClass) eClassParameter;

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
		method_checkAttributes(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("eClass", this.eClass);
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return loop;
	}

	protected void method_checkAttributes(final StringBuffer out, final PatternContext ctx) throws Exception {
		if (eClass.getEAllAttributes().isEmpty()) {
			BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.ERROR, "org.eclipse.egf.example.strategy.modeldriven", 0, "eClass " + eClass.getName() + " doesn't have any attribute", new Object[] { eClass });
			diagnosticChain.add(diagnostic);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "checkAttributes", out.toString());
	}

	protected org.eclipse.emf.ecore.EClass eClass;

	public void set_eClass(org.eclipse.emf.ecore.EClass eClass) {
		this.eClass = eClass;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("eClass", this.eClass);
		return parameters;
	}

	public boolean preCondition() {
		return true;
	}
}
