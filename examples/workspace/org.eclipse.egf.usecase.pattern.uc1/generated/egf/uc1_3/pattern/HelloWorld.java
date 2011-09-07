package egf.uc1_3.pattern;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class HelloWorld extends egf.uc1_3.pattern.parent.Hello {
	protected static String nl;

	public static synchronized HelloWorld create(String lineSeparator) {
		nl = lineSeparator;
		HelloWorld result = new HelloWorld();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties()
			.getProperty("line.separator")) : nl;
	protected final String TEXT_1 = " ";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public HelloWorld() {
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

		List<Object> aClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object aClassParameter : aClassList) {

			this.aClass = (org.eclipse.emf.ecore.EClass) aClassParameter;

			{
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

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

		method_SayHello(ictx.getBuffer(), ictx);

		method_body(ictx.getBuffer(), ictx);
		{
			final Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("element", this.aClass);
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			CallHelper
					.executeWithParameterInjection(
							"platform:/plugin/org.eclipse.egf.usecase.pattern.uc1/egf/Pattern_UC1_3_InheritanceAndCall.fcore#_7-a0kAzxEd-sdvrVfWaxAw",
							ctx_local, parameters);
		}

		method_finish(ictx.getBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("aClass", this.aClass);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx,
					parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.emf.ecore.EClass aClass = null;

	public void set_aClass(org.eclipse.emf.ecore.EClass object) {
		this.aClass = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("aClass", this.aClass);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer,
			final PatternContext ctx) throws Exception {
		final IndexValue idx = new IndexValue(stringBuffer.length());

		stringBuffer.append(TEXT_1);
		stringBuffer.append(aClass.getName());
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(),
				stringBuffer.substring(idx.value));
	}
}