package egf.uc1_4.pattern;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.usecase.pattern.uc1.helper.*;

public class ClassPattern {
	protected static String nl;

	public static synchronized ClassPattern create(String lineSeparator) {
		nl = lineSeparator;
		ClassPattern result = new ClassPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "//default content";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL + "[Begin. ";
	protected final String TEXT_4 = "]" + NL + NL;
	protected final String TEXT_5 = "\t=> ";
	protected final String TEXT_6 = " attribute(s)" + NL + "[End. ";
	protected final String TEXT_7 = "]" + NL + NL;
	protected final String TEXT_8 = NL;
	protected final String TEXT_9 = NL;

	public ClassPattern() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		_separator = "'";

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.ecore.EClass) parameterParameter;

			{
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_8);
		stringBuffer.append(TEXT_9);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_before(new StringBuffer(), ictx);
		{
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_after(new StringBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected java.lang.String _separator = null;

	public void set__separator(java.lang.String object) {
		this._separator = object;
	}

	protected org.eclipse.emf.ecore.EClass parameter = null;

	public void set_parameter(org.eclipse.emf.ecore.EClass object) {
		this.parameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1f9f0ad (description: null) (name: body) (patternFilePath: platform:/plugin/org.eclipse.egf.usecase.pattern.uc1/templates/pattern._8lp8YBe1Ed-DaY2uHNBaQg/method._8lp8Yxe1Ed-DaY2uHNBaQg.pt)", stringBuffer.toString());
	}

	protected void method_before(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		MyHelper.resetCounter(ctx);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(_separator);
		stringBuffer.append(parameter.getName());
		stringBuffer.append(_separator);
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@17c28fc (description: null) (name: before) (patternFilePath: platform:/plugin/org.eclipse.egf.usecase.pattern.uc1/templates/pattern._8lp8YBe1Ed-DaY2uHNBaQg/method._CFlv0Be2Ed-DaY2uHNBaQg.pt)", stringBuffer.toString());
	}

	protected void method_after(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_5);
		stringBuffer.append(MyHelper.getCounter(ctx));
		stringBuffer.append(TEXT_6);
		stringBuffer.append(_separator);
		stringBuffer.append(parameter.getName());
		stringBuffer.append(_separator);
		stringBuffer.append(TEXT_7);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@66bb34 (description: null) (name: after) (patternFilePath: platform:/plugin/org.eclipse.egf.usecase.pattern.uc1/templates/pattern._8lp8YBe1Ed-DaY2uHNBaQg/method._Co-JsBe2Ed-DaY2uHNBaQg.pt)", stringBuffer.toString());
	}
}