package org.eclipse.egf.emf.pattern.edit;

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

public class CreateChildIconsForGenClass extends org.eclipse.egf.emf.pattern.base.GenClassGIF {
	protected static String nl;

	public static synchronized CreateChildIconsForGenClass create(String lineSeparator) {
		nl = lineSeparator;
		CreateChildIconsForGenClass result = new CreateChildIconsForGenClass();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public CreateChildIconsForGenClass() {
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

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {

			this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) parameterParameter;

			if (preCondition()) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_1);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_preGenerate(ictx.getBuffer(), ictx);

		method_doGenerate(ictx.getBuffer(), ictx);
		{
			ictx.setExecutionCurrentIndex(ictx.getBuffer().length());
			ictx.getExecutionBuffer().append(ictx.getBuffer());
			final Map<String, Object> parameters = getParameters();
			CallbackContext ctx_callback = new CallbackContext(ictx);
			CallHelper.callBack(ctx_callback, parameters);
		}

		method_postGenerate(ictx.getBuffer(), ictx);

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

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		return parameters;
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {
		final IndexValue idx = new IndexValue(stringBuffer.length());

		new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditDirectory(), genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.substring(idx.value));
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {
		final IndexValue idx = new IndexValue(stringBuffer.length());

		GenClass genClass = parameter;
		GenModel genModel = genClass.getGenModel();
		if (genModel.isCreationCommands() && genModel.isCreationIcons()) {
			for (GenFeature feature : genClass.getCreateChildFeaturesIncludingDelegation()) {
				for (GenClass childClass : genClass.getChildrenClasses(feature)) {
					new CodegenGeneratorAdapter(parameter).generateGIF("edit/CreateChild.gif", genClass.getCreateChildIconFileName(feature, childClass), genClass.getName(), childClass.getName(), false);
				}
			}
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.substring(idx.value));
	}

	public boolean preCondition() throws Exception {
		GenClass genClass = parameter;
		genModel = parameter.getGenModel();
		boolean canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");
		return canGenerate;
	}
}