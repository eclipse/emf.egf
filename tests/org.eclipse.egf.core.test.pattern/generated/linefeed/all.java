//Generated on Thu Jan 12 17:21:56 CET 2012 with EGF 0.6.1.qualifier
package linefeed;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class all {
	protected static String nl;

	public static synchronized all create(String lineSeparator) {
		nl = lineSeparator;
		all result = new all();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "-----" + NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public all() {
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

		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_fW0RcF3DEd-W5eBkkAoHaA", ctx_local, parameters);
		}

		method_separator(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_s8JesF3DEd-W5eBkkAoHaA", ctx_local, parameters);
		}

		method_separator(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_5P020F3DEd-W5eBkkAoHaA", ctx_local, parameters);
		}

		method_separator(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_DAhtIF3KEd-mZb1ihLU3ug", ctx_local, parameters);
		}

		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_separator(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "separator", stringBuffer.toString());
	}
}