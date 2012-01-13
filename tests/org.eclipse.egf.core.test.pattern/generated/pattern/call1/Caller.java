//Generated on Thu Jan 12 17:21:57 CET 2012 with EGF 0.6.1.qualifier
package pattern.call1;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class Caller {
	protected static String nl;

	public static synchronized Caller create(String lineSeparator) {
		nl = lineSeparator;
		Caller result = new Caller();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "Message from caller";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public Caller() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		{
			ctx.setNode(new Node.Container(currentNode, getClass()));
			orchestration(ctx);
		}

		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);
		{
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			ctx_local.setValue(PatternContext.INJECTED_CONTEXT, variable);
			CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/patternCall_1.fcore#_F9NFkFa3Ed-upsLSxDR5IA", ctx_local);
		}

		return null;
	}

	protected org.eclipse.emf.ecore.EClass variable = null;

	public void set_variable(org.eclipse.emf.ecore.EClass object) {
		this.variable = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}