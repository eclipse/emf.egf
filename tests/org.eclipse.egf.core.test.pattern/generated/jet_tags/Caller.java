package jet_tags;

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
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

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

		orchestration(ctx);

		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
			ctx.clearBuffer();
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		int executionIndex = ictx.getExecutionBuffer().length();

		method_body(ictx.getBuffer(), ictx);

		String loop = ictx.getBuffer().toString();
		if (ictx.useReporter()) {
			ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
			ictx.setExecutionCurrentIndex(0);
			ictx.clearBuffer();
		}
		return loop;
	}

	protected java.lang.Object variable = null;

	public void set_variable(java.lang.Object object) {
		this.variable = object;
	}

	protected java.lang.Object variable2 = null;

	public void set_variable2(java.lang.Object object) {
		this.variable2 = object;
	}

	protected org.eclipse.emf.ecore.EClass toInject = null;

	public void set_toInject(org.eclipse.emf.ecore.EClass object) {
		this.toInject = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		variable = "CallValue";
		variable2 = "CallValue2";

		stringBuffer.append(TEXT_1);
		{
			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("parameter", variable);
			callParameters.put("parameter2", variable2);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/jet_tags.fcore#_0FqG8FaPEd-xDMudhFTQKg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
		}

		toInject = EcoreFactory.eINSTANCE.createEClass();
		toInject.setName("MyClassName");

		stringBuffer.append(TEXT_2);
		{
			ExecutionContext callCtx = new ExecutionContext((InternalPatternContext) ctx);
			callCtx.setValue(PatternContext.INJECTED_CONTEXT, toInject);
			CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/jet_tags.fcore#_-d1XsFa7Ed-_dcUlU_GyPA", callCtx);
		}

	}
}