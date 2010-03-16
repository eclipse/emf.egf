package egf.uc1_5.helloWorld;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ClassPattern {
	protected static String nl;

	public static synchronized ClassPattern create(String lineSeparator) {
		nl = lineSeparator;
		ClassPattern result = new ClassPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties()
			.getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "//default content";
	protected final String TEXT_2 = "[begin Class '";
	protected final String TEXT_3 = "']" + NL;
	protected final String TEXT_4 = "[End Class '";
	protected final String TEXT_5 = "']" + NL;
	protected final String TEXT_6 = NL;
	protected final String TEXT_7 = NL;

	public ClassPattern() {
		// Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been
		// already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;

		List<Object> parameterList = null;
		// this pattern can only be called by another (i.e. it's not an entry
		// point in execution)

		for (Object parameterParameter : parameterList) {

			generate(ctx, parameterParameter);

		}
		if (ctx.useReporter()) {
			ctx.getReporter()
					.executionFinished(ctx.getBuffer().toString(), ctx);
			ctx.getBuffer().setLength(0);
		}

		stringBuffer.append(TEXT_6);
		stringBuffer.append(TEXT_7);
		return stringBuffer.toString();
	}

	public String generate(PatternContext ctx, Object parameterParameter)
			throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		Map<String, Object> parameterValues = new HashMap<String, Object>();
		org.eclipse.emf.ecore.EClass parameter = (org.eclipse.emf.ecore.EClass) parameterParameter;
		parameterValues.put("parameter", parameterParameter);

		method_before(ictx.getBuffer(), ictx, parameter);
		CallHelper.callBack(new CallbackContext(ictx), parameter);

		method_after(ictx.getBuffer(), ictx, parameter);

		String loop = ictx.getBuffer().toString();
		if (ictx.useReporter()) {
			ictx.getReporter().loopFinished(loop, ictx, parameterValues);
			ictx.getBuffer().setLength(0);
		}
		return loop;
	}

	protected void method_body(final StringBuffer stringBuffer,
			final PatternContext ctx,
			final org.eclipse.emf.ecore.EClass parameter) throws Exception {

		stringBuffer.append(TEXT_1);
	}

	protected void method_before(final StringBuffer stringBuffer,
			final PatternContext ctx,
			final org.eclipse.emf.ecore.EClass parameter) throws Exception {

		stringBuffer.append(TEXT_2);
		stringBuffer.append(parameter.getName());
		stringBuffer.append(TEXT_3);
	}

	protected void method_after(final StringBuffer stringBuffer,
			final PatternContext ctx,
			final org.eclipse.emf.ecore.EClass parameter) throws Exception {

		stringBuffer.append(TEXT_4);
		stringBuffer.append(parameter.getName());
		stringBuffer.append(TEXT_5);
	}
}