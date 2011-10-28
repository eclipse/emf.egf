//Generated on Fri Oct 28 15:21:42 CEST 2011 with EGF 0.6.1.qualifier
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

		method_body(new StringBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			;
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
			//<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.core.test.pattern/fc/jet_tags.fcore#LogicalName=jet_tags.Callee" args="variable:parameter, variable2:parameter2" %>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			callParameters.put("parameter", variable);
			callParameters.put("parameter2", variable2);
			CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/jet_tags.fcore#_0FqG8FaPEd-xDMudhFTQKg", new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		toInject = EcoreFactory.eINSTANCE.createEClass();
		toInject.setName("MyClassName");

		stringBuffer.append(TEXT_2);
		{
			//<%@ egf:patternInjectedCall patternId="platform:/plugin/org.eclipse.egf.core.test.pattern/fc/jet_tags.fcore#LogicalName=jet_tags.CalleeInjected" toInject="toInject" %>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			ExecutionContext callCtx = new ExecutionContext((InternalPatternContext) ctx);
			callCtx.setValue(PatternContext.INJECTED_CONTEXT, toInject);
			CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/jet_tags.fcore#_-d1XsFa7Ed-_dcUlU_GyPA", callCtx);
			stringBuffer.setLength(0);

		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition() {
		return true;
	}
}