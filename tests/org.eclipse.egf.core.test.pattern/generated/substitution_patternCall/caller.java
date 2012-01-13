//Generated on Thu Jan 12 17:21:54 CET 2012 with EGF 0.6.1.qualifier
package substitution_patternCall;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class caller {
	protected static String nl;

	public static synchronized caller create(String lineSeparator) {
		nl = lineSeparator;
		caller result = new caller();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "caller eClass : ";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public caller() {
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

		List<Object> eClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object eClassParameter : eClassList) {

			this.eClass = (org.eclipse.emf.ecore.EClass) eClassParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);
		{
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			ctx_local.setValue(PatternContext.INJECTED_CONTEXT, eClass);
			CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/substitution_patternCall.fcore#_ZHxDMJAhEd-qRrvFxb1RDA", ctx_local);
		}

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("eClass", this.eClass);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.emf.ecore.EClass eClass = null;

	public void set_eClass(org.eclipse.emf.ecore.EClass object) {
		this.eClass = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("eClass", this.eClass);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		stringBuffer.append(eClass.getName());
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}