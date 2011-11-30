//Generated on Mon Nov 07 17:44:34 CET 2011 with EGF 0.6.1.qualifier
package emf.docgen.html.forStrategy;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.emf.docgen.html.util.*;

public class DataTypeReport extends emf.docgen.html.EDataTypeDocGen {
	protected static String nl;

	public static synchronized DataTypeReport create(String lineSeparator) {
		nl = lineSeparator;
		DataTypeReport result = new DataTypeReport();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "//default content";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public DataTypeReport() {
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

		List<Object> elementList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object elementParameter : elementList) {

			this.element = (org.eclipse.emf.ecore.EDataType) elementParameter;

			{
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_setVariable(new StringBuffer(), ictx);

		method_setSpecificVariables(new StringBuffer(), ictx);

		method_fileHeader(new StringBuffer(), ictx);

		method_writeEPackageReference(new StringBuffer(), ictx);

		method_fileFooter(new StringBuffer(), ictx);

		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("element", this.element);
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.emf.ecore.EDataType element = null;

	public void set_element(org.eclipse.emf.ecore.EDataType object) {
		this.element = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("element", this.element);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	protected void method_setVariable(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		// Set Object variables
		_Title = element.getName() + " Package";

		// Set EObject variables
		_element = element;

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setVariable", stringBuffer.toString());
	}

	public boolean preCondition() {
		return true;
	}
}