//Generated on Thu Jan 12 17:21:25 CET 2012 with EGF 0.6.1.qualifier
package object.docgen.html;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ObjectDocGen {
	protected static String nl;

	public static synchronized ObjectDocGen create(String lineSeparator) {
		nl = lineSeparator;
		ObjectDocGen result = new ObjectDocGen();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "//default content";
	protected final String TEXT_2 = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">" + NL + "<html>" + NL + "<head>" + NL + "<title>";
	protected final String TEXT_3 = "</title>" + NL + "</HEAD>" + NL + "" + NL + "<BODY BGCOLOR=\"#ffffff\">" + NL + "" + NL + "<h1 class=\"Head\">";
	protected final String TEXT_4 = "</h1>" + NL;
	protected final String TEXT_5 = "\t<br/>" + NL + "\t<p><i>";
	protected final String TEXT_6 = "</i></p>" + NL + "</body>" + NL + "</html>" + NL;
	protected final String TEXT_7 = NL;
	protected final String TEXT_8 = NL;

	public ObjectDocGen() {
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
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_7);
		stringBuffer.append(TEXT_8);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);

		return null;
	}

	protected java.lang.String _Title = null;

	public void set__Title(java.lang.String object) {
		this._Title = object;
	}

	protected java.lang.String _copyright = null;

	public void set__copyright(java.lang.String object) {
		this._copyright = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	protected void method_fileHeader(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		stringBuffer.append(_Title);
		stringBuffer.append(TEXT_3);
		stringBuffer.append(_Title);
		stringBuffer.append(TEXT_4);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "fileHeader", stringBuffer.toString());
	}

	protected void method_fileFooter(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_5);
		stringBuffer.append(_copyright);
		stringBuffer.append(TEXT_6);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "fileFooter", stringBuffer.toString());
	}

	protected void method_setSpecificVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		_copyright = "";

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setSpecificVariables", stringBuffer.toString());
	}
}