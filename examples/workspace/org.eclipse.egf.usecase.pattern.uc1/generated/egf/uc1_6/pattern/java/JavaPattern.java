//Generated with EGF 1.6.3.202110181143
package egf.uc1_6.pattern.java;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.core.EGFCorePlugin;

public class JavaPattern {

	public JavaPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).

	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> aClassList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object aClassParameter : aClassList) {

			this.aClass = (org.eclipse.emf.ecore.EClass) aClassParameter;

			{
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration((PatternContext) argument);

			}
		}
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		method_body(new StringBuffer(), ictx);
		ictx.setNode(currentNode);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("aClass", this.aClass);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {

		// Message on the default console
		System.out.println("Java: " + aClass.getName()); //$NON-NLS-1$

		// Message on the EGF console
		EGFCorePlugin.getDefault().logInfo("Java: " + aClass.getName());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	protected org.eclipse.emf.ecore.EClass aClass;

	public void set_aClass(org.eclipse.emf.ecore.EClass aClass) {
		this.aClass = aClass;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("aClass", this.aClass);
		return parameters;
	}

}
