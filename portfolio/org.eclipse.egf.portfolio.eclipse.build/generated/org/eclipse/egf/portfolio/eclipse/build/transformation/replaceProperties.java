//Generated on Thu Jan 12 17:22:07 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.transformation;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class replaceProperties {

	public replaceProperties() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();
		List<Object> eObjectList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object eObjectParameter : eObjectList) {

			this.eObject = (org.eclipse.emf.ecore.EObject) eObjectParameter;

			if (preCondition(ctx)) {
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
			parameterValues.put("eObject", this.eObject);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		List<EAttribute> eAllAttributes = eObject.eClass().getEAllAttributes();
		for (EAttribute eAttribute : eAllAttributes) {
			if ("EString".equals(eAttribute.getEType().getName())) {
				if (eAttribute.getUpperBound() == 1) {
					String string = (String) eObject.eGet(eAttribute);
					eObject.eSet(eAttribute, new GenerationHelper().replaceProperties(eObject, string));
				} else {
					List<String> stringList = (List<String>) eObject.eGet(eAttribute);
					for (int i = 0; i < stringList.size(); i++) {
						String string = stringList.get(i);
						stringList.set(i, new GenerationHelper().replaceProperties(eObject, string));
					}
				}
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", out.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}

	protected org.eclipse.emf.ecore.EObject eObject;

	public void set_eObject(org.eclipse.emf.ecore.EObject eObject) {
		this.eObject = eObject;
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("eObject", this.eObject);
		return parameters;
	}

}
