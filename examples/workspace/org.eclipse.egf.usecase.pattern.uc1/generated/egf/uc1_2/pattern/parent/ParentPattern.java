package egf.uc1_2.pattern.parent;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ParentPattern {
	protected static String nl;

	public static synchronized ParentPattern create(String lineSeparator) {
		nl = lineSeparator;
		ParentPattern result = new ParentPattern();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "//default content";
	protected final String TEXT_2 = NL + "Hello ";
	protected final String TEXT_3 = " from my parent";
	protected final String TEXT_4 = NL;
	protected final String TEXT_5 = NL;

	public ParentPattern() {
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

		stringBuffer.append(TEXT_4);
		stringBuffer.append(TEXT_5);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_sayHello(new StringBuffer(), ictx);

		method_sayFromParent(new StringBuffer(), ictx);

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
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@7b5f64 (description: null) (name: body) (patternFilePath: platform:/plugin/org.eclipse.egf.usecase.pattern.uc1/templates/pattern._RfrD8BVgEd-JoY-b5_Vpcw/method._RfrD8xVgEd-JoY-b5_Vpcw.pt)", stringBuffer.toString());
	}

	protected void method_sayHello(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@15b185c (description: null) (name: sayHello) (patternFilePath: platform:/plugin/org.eclipse.egf.usecase.pattern.uc1/templates/pattern._RfrD8BVgEd-JoY-b5_Vpcw/method._X63lwBVgEd-JoY-b5_Vpcw.pt)", stringBuffer.toString());
	}

	protected void method_sayFromParent(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_3);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@19c5f7c (description: null) (name: sayFromParent) (patternFilePath: platform:/plugin/org.eclipse.egf.usecase.pattern.uc1/templates/pattern._RfrD8BVgEd-JoY-b5_Vpcw/method._PbStEBbvEd-thalzjBN9kg.pt)", stringBuffer.toString());
	}
}