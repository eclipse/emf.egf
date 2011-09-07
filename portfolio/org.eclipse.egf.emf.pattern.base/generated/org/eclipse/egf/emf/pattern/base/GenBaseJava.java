package org.eclipse.egf.emf.pattern.base;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.emf.codegen.util.*;

public class GenBaseJava extends org.eclipse.egf.emf.pattern.base.GenAbstract {
	protected static String nl;

	public static synchronized GenBaseJava create(String lineSeparator) {
		nl = lineSeparator;
		GenBaseJava result = new GenBaseJava();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public GenBaseJava() {
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

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_createImportManager(ictx.getBuffer(), ictx);

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			;
		}
		return loop;
	}

	protected java.lang.String targetPath = null;

	public void set_targetPath(java.lang.String object) {
		this.targetPath = object;
	}

	protected java.lang.String packageName = null;

	public void set_packageName(java.lang.String object) {
		this.packageName = object;
	}

	protected java.lang.String className = null;

	public void set_className(java.lang.String object) {
		this.className = object;
	}

	protected org.eclipse.emf.codegen.util.ImportManager importManager = null;

	public void set_importManager(org.eclipse.emf.codegen.util.ImportManager object) {
		this.importManager = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_putReporterVariablesInContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {
		final IndexValue idx = new IndexValue(stringBuffer.length());

		ctx.setValue("targetPath", targetPath);
		ctx.setValue("packageName", packageName);
		ctx.setValue("className", className);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.substring(idx.value));
	}

	protected void method_putContentTypeInContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {
		final IndexValue idx = new IndexValue(stringBuffer.length());

		ctx.setValue("contentType", ContentType.Java);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.substring(idx.value));
	}

	protected void method_createImportManager(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {
		final IndexValue idx = new IndexValue(stringBuffer.length());

		importManager = new ImportManager(packageName);
		importManager.addMasterImport(packageName, className);
		genModel.setImportManager(importManager);

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.substring(idx.value));
	}

	public boolean preCondition() throws Exception {
		return super.preCondition();
	}
}