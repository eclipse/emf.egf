//Generated on Wed Nov 30 10:57:00 CET 2011 with EGF 0.6.1.qualifier
package jet_tags;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

public class Callee {

	public Callee() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> parameter2List = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {
			for (Object parameter2Parameter : parameter2List) {

				this.parameter = (java.lang.Object) parameterParameter;
				this.parameter2 = (java.lang.Object) parameter2Parameter;

				{
					ctx.setNode(new Node.Container(currentNode, getClass()));
					orchestration((PatternContext) argument);

				}
			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_body(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			parameterValues.put("parameter2", this.parameter2);
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return loop;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		out.append("Callee : ");

		out.append("parameter=");
		if (parameter != null)
			out.append(parameter.toString());

		out.append(", parameter2=");
		if (parameter2 != null)
			out.append(parameter2.toString());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	protected java.lang.Object parameter;

	public void set_parameter(java.lang.Object parameter) {
		this.parameter = parameter;
	}

	protected java.lang.Object parameter2;

	public void set_parameter2(java.lang.Object parameter2) {
		this.parameter2 = parameter2;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		parameters.put("parameter2", this.parameter2);
		return parameters;
	}

	public boolean preCondition() {
		return true;
	}
}
