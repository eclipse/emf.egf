//Generated with EGF 1.6.3.202110181143
package org.eclipse.egf.portfolio.ant.javadoc;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.*;

public class ant {
	protected static String nl;

	public static synchronized ant create(String lineSeparator) {
		nl = lineSeparator;
		ant result = new ant();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<?xml version=\"1.0\"?>" + NL + "" + NL
			+ "<project name=\"Javadoc Generation\" default=\"main\">" + NL + "\t<target name=\"main\">" + NL;
	protected final String TEXT_2 = "\t\t<delete dir=\"";
	protected final String TEXT_3 = "\" />";
	protected final String TEXT_4 = "\t\t<javadoc" + NL + "\t\t\tdestdir=\"";
	protected final String TEXT_5 = "\"" + NL + "\t\t\tmaxmemory=\"1024m\"" + NL + "\t\t\tsource=\"1.5\"" + NL
			+ "\t\t\tuseexternalfile=\"true\"" + NL + "\t\t\tauthor=\"true\"" + NL + "\t\t\tversion=\"true\"" + NL
			+ "\t\t\tuse=\"true\"" + NL + "\t\t\twindowtitle=\"Javadoc\">";
	protected final String TEXT_6 = "\t\t<link offline=\"false\" href=\"http://download.oracle.com/javase/1.5.0/docs/api/\"/> "
			+ NL + "\t\t<link offline=\"false\" href=\"http://www.osgi.org/javadoc/r4v42/\"/> " + NL
			+ "\t\t<link offline=\"false\" href=\"http://download.eclipse.org/modeling/emf/emf/javadoc/2.5.0/\"/> " + NL
			+ "\t\t<link offline=\"false\" href=\"http://help.eclipse.org/galileo/index.jsp?topic=/org.eclipse.platform.doc.isv/reference/api/\"/>";
	protected final String TEXT_7 = NL + "\t\t<fileset dir=\"";
	protected final String TEXT_8 = "\" defaultexcludes=\"true\">" + NL + "\t\t\t<include name=\"**/*.java\"/>" + NL
			+ "\t\t</fileset>";
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = "\t</javadoc>";
	protected final String TEXT_11 = "\t</target>" + NL + "</project>" + NL + "\t";

	public ant() {
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

		if (preCondition(ctx)) {
			ctx.setNode(new Node.Container(currentNode, getClass()));
			orchestration(ctx);
		}

		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_9);
		stringBuffer.append(TEXT_9);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_computeVariables(new StringBuffer(), ictx);

		method_begin(new StringBuffer(), ictx);

		method_additionalBeginXml(new StringBuffer(), ictx);

		method_deleteOutput(new StringBuffer(), ictx);

		method_beginJavadoc(new StringBuffer(), ictx);

		method_javadocLinks(new StringBuffer(), ictx);

		method_javadocInput(new StringBuffer(), ictx);

		method_additionalJavadocXml(new StringBuffer(), ictx);

		method_endJavadoc(new StringBuffer(), ictx);

		method_additionalEndXml(new StringBuffer(), ictx);

		method_end(new StringBuffer(), ictx);

		return null;
	}

	protected java.lang.String outputFolderPath = null;

	public void set_outputFolderPath(java.lang.String object) {
		this.outputFolderPath = object;
	}

	protected java.util.List inputFolderPathsList = null;

	public void set_inputFolderPathsList(java.util.List object) {
		this.inputFolderPathsList = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_computeVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String inputFolderPaths = (String) ctx.getValue("inputFolderPaths");
		String outputProjectName = (String) ctx.getValue("outputProjectName");
		String outputFolderName = (String) ctx.getValue("outputFolderName");

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		IFolder outFolder = root.getProject(outputProjectName).getFolder(outputFolderName);
		outputFolderPath = outFolder.getLocation().toOSString();

		inputFolderPathsList = new ArrayList<String>();
		String[] split = inputFolderPaths.split(",");
		for (String inputFolderPath : split) {
			IFolder inputFolder = root.getFolder(new Path(inputFolderPath.trim()));
			if (inputFolder.exists() && inputFolder.getLocation() != null)
				inputFolderPathsList.add(inputFolder.getLocation().toOSString());
		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "computeVariables", stringBuffer.toString());
	}

	protected void method_begin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "begin", stringBuffer.toString());
	}

	protected void method_additionalBeginXml(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "additionalBeginXml", stringBuffer.toString());
	}

	protected void method_deleteOutput(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		stringBuffer.append(outputFolderPath);
		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "deleteOutput", stringBuffer.toString());
	}

	protected void method_beginJavadoc(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_4);
		stringBuffer.append(outputFolderPath);
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "beginJavadoc", stringBuffer.toString());
	}

	protected void method_javadocLinks(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_6);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "javadocLinks", stringBuffer.toString());
	}

	protected void method_javadocInput(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		for (Iterator iterator = inputFolderPathsList.iterator(); iterator.hasNext();) {
			String inputFolderPath = (String) iterator.next();

			stringBuffer.append(TEXT_7);
			stringBuffer.append(inputFolderPath);
			stringBuffer.append(TEXT_8);
		}
		stringBuffer.append(TEXT_9);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "javadocInput", stringBuffer.toString());
	}

	protected void method_additionalJavadocXml(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "additionalJavadocXml", stringBuffer.toString());
	}

	protected void method_endJavadoc(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_10);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "endJavadoc", stringBuffer.toString());
	}

	protected void method_additionalEndXml(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "additionalEndXml", stringBuffer.toString());
	}

	protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_11);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "end", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return true;
	}
}