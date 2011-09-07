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
		super.orchestration(new SuperOrchestrationContext(ictx));
		method_checkAttributes(ictx.getBuffer(), ictx);
		ictx.setNode(currentNode);
		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("eClass", this.eClass);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return loop;
	}

	protected void method_checkAttributes(final StringBuffer out, final PatternContext ctx) throws Exception {
		final IndexValue idx = new IndexValue(out.length());

		if (eClass.getEAllAttributes().isEmpty()) {
			BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.ERROR, "org.eclipse.egf.example.strategy.modeldriven", 0, "eClass " + eClass.getName() + " doesn't have any attribute", new Object[] { eClass });
			diagnosticChain.add(diagnostic);
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), out.substring(idx.value));
	}

	public boolean preCondition() throws Exception {
		return super.preCondition();
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

}
