//Generated on Fri Oct 28 15:21:45 CEST 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.pattern.validation;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.eclipse.emf.common.util.*;

public class AbstractValidationPattern {

	public AbstractValidationPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();

		if (preCondition(ctx))
			orchestration((PatternContext) argument);

		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_getDiagnosticChainFromContext(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
		}
		return loop;
	}

	protected void method_getDiagnosticChainFromContext(final StringBuffer out, final PatternContext ctx) throws Exception {
		diagnosticChain = (DiagnosticChain) ctx.getValue("diagnostic");

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "getDiagnosticChainFromContext", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.eclipse.emf.common.util.DiagnosticChain diagnosticChain;

	public void set_diagnosticChain(org.eclipse.emf.common.util.DiagnosticChain diagnosticChain) {
		this.diagnosticChain = diagnosticChain;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	public boolean preCondition() {
		return true;
	}
}
