//Generated on Wed Nov 30 10:56:58 CET 2011 with EGF 0.6.1.qualifier
package substitution_chain;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

public class caller {

	public caller() {
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
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/substitution_chain.fcore#_9yQgsJmOEd-BDZHgxyTzjQ", ctx_local, parameters);
		}
		ictx.setNode(currentNode);
		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
		}
		return loop;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		//default content

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	public boolean preCondition() {
		return true;
	}
}
