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

	public final String NL = nl == null ? (System.getProperties()
			.getProperty("line.separator")) : nl;
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
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()),
					ctx);
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
			CallHelper
					.executeWithParameterInjection(
							"platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_fW0RcF3DEd-W5eBkkAoHaA",
							ctx_local, parameters);
		}

		method_separator(ictx.getBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper
					.executeWithParameterInjection(
							"platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_s8JesF3DEd-W5eBkkAoHaA",
							ctx_local, parameters);
		}

		method_separator(ictx.getBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper
					.executeWithParameterInjection(
							"platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_5P020F3DEd-W5eBkkAoHaA",
							ctx_local, parameters);
		}

		method_separator(ictx.getBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper
					.executeWithParameterInjection(
							"platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_DAhtIF3KEd-mZb1ihLU3ug",
							ctx_local, parameters);
		}

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			;
		}
		return loop;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_separator(final StringBuffer stringBuffer,
			final PatternContext ctx) throws Exception {
		final IndexValue idx = new IndexValue(stringBuffer.length());

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(),
				stringBuffer.substring(idx.value));
	}
}