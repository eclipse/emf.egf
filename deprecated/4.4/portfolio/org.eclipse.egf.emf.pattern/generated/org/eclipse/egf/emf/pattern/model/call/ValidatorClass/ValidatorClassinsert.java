//Generated with EGF 1.2.0.qualifier
package org.eclipse.egf.emf.pattern.model.call.ValidatorClass;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ValidatorClassinsert {
	protected static String nl;

	public static synchronized ValidatorClassinsert create(String lineSeparator) {
		nl = lineSeparator;
		ValidatorClassinsert result = new ValidatorClassinsert();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public ValidatorClassinsert() {
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

		List<Object> genPackageList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> genModelList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> singleWildcardList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> _MapList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> objectArgumentList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> countList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object genPackageParameter : genPackageList) {
			for (Object genModelParameter : genModelList) {
				for (Object singleWildcardParameter : singleWildcardList) {
					for (Object _MapParameter : _MapList) {
						for (Object objectArgumentParameter : objectArgumentList) {
							for (Object countParameter : countList) {

								this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
								this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
								this.singleWildcard = (java.lang.String) singleWildcardParameter;
								this._Map = (java.lang.String) _MapParameter;
								this.objectArgument = (java.lang.String) objectArgumentParameter;
								this.count = (java.lang.Integer) countParameter;

								if (preCondition(ctx)) {
									ctx.setNode(new Node.Container(currentNode, getClass()));
									orchestration(ctx);
								}

							}
						}
					}
				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_doGenerate(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("genPackage", this.genPackage);
			parameterValues.put("genModel", this.genModel);
			parameterValues.put("singleWildcard", this.singleWildcard);
			parameterValues.put("_Map", this._Map);
			parameterValues.put("objectArgument", this.objectArgument);
			parameterValues.put("count", this.count);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage = null;

	public void set_genPackage(org.eclipse.emf.codegen.ecore.genmodel.GenPackage object) {
		this.genPackage = object;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;

	public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel object) {
		this.genModel = object;
	}

	protected java.lang.String singleWildcard = null;

	public void set_singleWildcard(java.lang.String object) {
		this.singleWildcard = object;
	}

	protected java.lang.String _Map = null;

	public void set__Map(java.lang.String object) {
		this._Map = object;
	}

	protected java.lang.String objectArgument = null;

	public void set_objectArgument(java.lang.String object) {
		this.objectArgument = object;
	}

	protected java.lang.Integer count = null;

	public void set_count(java.lang.Integer object) {
		this.count = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("genPackage", this.genPackage);
		parameters.put("genModel", this.genModel);
		parameters.put("singleWildcard", this.singleWildcard);
		parameters.put("_Map", this._Map);
		parameters.put("objectArgument", this.objectArgument);
		parameters.put("count", this.count);
		return parameters;
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}