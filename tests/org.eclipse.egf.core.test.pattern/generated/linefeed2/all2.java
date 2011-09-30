package linefeed2;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class all2 {
	protected static String nl;

	public static synchronized all2 create(String lineSeparator) {
		nl = lineSeparator;
		all2 result = new all2();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "c";
	protected final String TEXT_2 = "d";
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public all2() {
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
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_id8LsF3JEd-mZb1ihLU3ug", ctx_local, parameters);
		}

		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_sv0rMF3JEd-mZb1ihLU3ug", ctx_local, parameters);
		}

		method_d(new StringBuffer(), ictx);

		method_c(new StringBuffer(), ictx);

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

	protected void method_c(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1d635a (description: null) (name: c) (patternFilePath: platform:/plugin/org.eclipse.egf.core.test.pattern/templates/pattern._DAhtIF3KEd-mZb1ihLU3ug/method._DAhtI13KEd-mZb1ihLU3ug.pt)", stringBuffer.toString());
	}

	protected void method_d(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@15134f5 (description: null) (name: d) (patternFilePath: platform:/plugin/org.eclipse.egf.core.test.pattern/templates/pattern._DAhtIF3KEd-mZb1ihLU3ug/method._GjUecF3KEd-mZb1ihLU3ug.pt)", stringBuffer.toString());
	}
}