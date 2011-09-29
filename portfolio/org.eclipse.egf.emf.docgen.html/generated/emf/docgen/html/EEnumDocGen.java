package emf.docgen.html;

import org.eclipse.egf.emf.docgen.html.util.*;
import org.eclipse.emf.common.util.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class EEnumDocGen extends emf.docgen.html.EDataTypeDocGen {
	protected static String nl;

	public static synchronized EEnumDocGen create(String lineSeparator) {
		nl = lineSeparator;
		EEnumDocGen result = new EEnumDocGen();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "//default content";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL + "\t<h2>Enum Literals</h2>" + NL + "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL + "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Value</th>" + NL + "\t\t</tr>" + NL + "\t";
	protected final String TEXT_4 = NL + "\t\t<tr>" + NL + "   \t\t\t<td align=left><b>";
	protected final String TEXT_5 = "</b></td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_6 = "</td>" + NL + "   \t\t</tr>" + NL + "\t";
	protected final String TEXT_7 = NL + "\t</table>";
	protected final String TEXT_8 = NL;
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = NL;

	public EEnumDocGen() {
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

		stringBuffer.append(TEXT_9);
		stringBuffer.append(TEXT_10);
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

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}

	protected void method_writeEEnumLiteral(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EEnumLiteral> enumLiterals = ((EEnum) _element).getELiterals();
		stringBuffer.append(TEXT_2);
		if (enumLiterals.size() > 0) {
			stringBuffer.append(TEXT_3);
			for (EEnumLiteral _EEnumLiteral : enumLiterals) {
				stringBuffer.append(TEXT_4);
				stringBuffer.append(EmfHtmlDocGen.getName(_EEnumLiteral));
				stringBuffer.append(TEXT_5);
				stringBuffer.append(_EEnumLiteral.getValue());
				stringBuffer.append(TEXT_6);
			} // end for
			stringBuffer.append(TEXT_7);
		} // end if 
		stringBuffer.append(TEXT_8);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.Leaf(ictx.getNode(), getClass(), stringBuffer.toString());
	}
}