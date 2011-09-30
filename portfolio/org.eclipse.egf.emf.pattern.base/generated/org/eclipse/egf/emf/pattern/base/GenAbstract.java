package org.eclipse.egf.emf.pattern.base;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class GenAbstract {
	protected static String nl;

	public static synchronized GenAbstract create(String lineSeparator) {
		nl = lineSeparator;
		GenAbstract result = new GenAbstract();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public GenAbstract() {
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

		if (preCondition()) {
			ctx.setNode(new Node.Container(currentNode, getClass()));
			orchestration(ctx);
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

		method_setGenModel(new StringBuffer(), ictx);

		method_putGenModelInContext(new StringBuffer(), ictx);

		method_setChildVariables(new StringBuffer(), ictx);

		method_setReporterVariables(new StringBuffer(), ictx);

		method_putReporterVariablesInContext(new StringBuffer(), ictx);

		method_putContentTypeInContext(new StringBuffer(), ictx);

		method_setArgument(new StringBuffer(), ictx);

		method_ensureProjectExists(new StringBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			;
		}
		return loop;
	}

	protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;

	public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel object) {
		this.genModel = object;
	}

	protected java.lang.Object argument = null;

	public void set_argument(java.lang.Object object) {
		this.argument = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_setGenModel(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@cb8484 (description: null) (name: setGenModel) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._MNwccCg6Ed-ROrlGa8LEeQ.pt)", stringBuffer.toString());
	}

	protected void method_putGenModelInContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		ctx.setValue("genModel", genModel);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1692199 (description: null) (name: putGenModelInContext) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._o2QEsCqcEd-UleeK_bBdeg.pt)", stringBuffer.toString());
	}

	protected void method_setChildVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@11d0422 (description: null) (name: setChildVariables) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._EjOFwChSEd-TQrf-Ye9EBQ.pt)", stringBuffer.toString());
	}

	protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1fa54c0 (description: null) (name: setReporterVariables) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._TT9fkyg5Ed-ROrlGa8LEeQ.pt)", stringBuffer.toString());
	}

	protected void method_putReporterVariablesInContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@184b4e8 (description: null) (name: putReporterVariablesInContext) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._ajYToCg5Ed-ROrlGa8LEeQ.pt)", stringBuffer.toString());
	}

	protected void method_putContentTypeInContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		ctx.setValue("contentType", ContentType.Undefined);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@180fe96 (description: null) (name: putContentTypeInContext) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._ROCT4Cq1Ed-Id7h7r1RDwA.pt)", stringBuffer.toString());
	}

	protected void method_setArgument(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1ca402a (description: null) (name: setArgument) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._NOSdQGKOEd-SV9Sq5xD-BA.pt)", stringBuffer.toString());
	}

	protected void method_ensureProjectExists(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@13a96ba (description: null) (name: ensureProjectExists) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._BItdcGKMEd-vV655ccA3JQ.pt)", stringBuffer.toString());
	}

	protected void method_preGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@17dc141 (description: null) (name: preGenerate) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._Chxo4ChGEd-zj5CV40Ozyg.pt)", stringBuffer.toString());
	}

	protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@11ac882 (description: null) (name: doGenerate) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._C8cLoChGEd-zj5CV40Ozyg.pt)", stringBuffer.toString());
	}

	protected void method_postGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@161ef2b (description: null) (name: postGenerate) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.pattern.base/templates/pattern._TT9fkCg5Ed-ROrlGa8LEeQ/method._DrPLUChGEd-zj5CV40Ozyg.pt)", stringBuffer.toString());
	}

	public boolean preCondition() throws Exception {
		return true;
	}
}