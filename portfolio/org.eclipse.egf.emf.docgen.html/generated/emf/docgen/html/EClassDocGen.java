//Generated with EGF 1.6.3.202110181143
package emf.docgen.html;

import org.eclipse.egf.emf.docgen.html.util.*;
import org.eclipse.emf.common.util.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class EClassDocGen extends emf.docgen.html.EClassifierDocGen {
	protected static String nl;

	public static synchronized EClassDocGen create(String lineSeparator) {
		nl = lineSeparator;
		EClassDocGen result = new EClassDocGen();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "// Class body contents";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL + "\t<h2>Attributes</h2>" + NL
			+ "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL
			+ "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Bounds</th>" + NL + "\t\t\t<th>Type</th>" + NL
			+ "\t\t\t<th>Changeable</th>" + NL + "\t\t\t<th>Volatile</th>" + NL + "\t\t\t<th>Transient</th>" + NL
			+ "\t\t\t<th>Derived</th>" + NL + "\t\t\t<th>Ordered</th>" + NL + "\t\t\t<th>Unique</th>" + NL + "\t\t</tr>"
			+ NL + "\t";
	protected final String TEXT_4 = NL + "\t\t<tr>" + NL + "   \t\t\t<td align=left><b>";
	protected final String TEXT_5 = "</b></td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_6 = "  </td>" + NL + "   \t\t\t<td align=left>";
	protected final String TEXT_7 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_8 = "</td>" + NL + "   \t\t</tr>" + NL + "\t";
	protected final String TEXT_9 = NL + "\t</table>";
	protected final String TEXT_10 = NL + "\t<h2>Operations</h2>" + NL
			+ "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL
			+ "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Bounds</th>" + NL + "\t\t\t<th>Return</th>" + NL
			+ "\t\t\t<th>Parameter(s)</th>" + NL + "\t\t\t<th>Required</th>" + NL + "\t\t\t<th>Ordered</th>" + NL
			+ "\t\t\t<th>Unique</th>" + NL + "\t\t</tr>" + NL + "\t";
	protected final String TEXT_11 = "</td>" + NL + "   \t\t\t<td align=center>" + NL + "   \t\t\t\t";
	protected final String TEXT_12 = NL + "   \t\t\t\t";
	protected final String TEXT_13 = NL + "   \t\t\t</td>" + NL + "\t\t\t<td align=left>" + NL + "\t\t\t\t";
	protected final String TEXT_14 = NL + "\t\t\t\t\t<p>";
	protected final String TEXT_15 = " - ";
	protected final String TEXT_16 = "</p>" + NL + "\t\t\t\t";
	protected final String TEXT_17 = NL + "\t\t\t</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_18 = "</td>" + NL + "" + NL + "   \t\t</tr>" + NL + "" + NL + "" + NL + "\t";
	protected final String TEXT_19 = NL + "\t<h2>References</h2>" + NL
			+ "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL
			+ "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Bounds</th>" + NL + "\t\t\t<th>Type</th>" + NL
			+ "\t\t\t<th>Containment</th>" + NL + "\t\t\t<th>Changeable</th>" + NL + "\t\t\t<th>Derived</th>" + NL
			+ "\t\t\t<th>Required</th>" + NL + "\t\t\t<th>Ordered</th>" + NL + "\t\t\t<th>Unique</th>" + NL
			+ "\t\t</tr>" + NL + "\t";
	protected final String TEXT_20 = NL + "\t\t<tr>" + NL + "\t   \t\t<td align=left><b>";
	protected final String TEXT_21 = "</td>" + NL + "   \t\t\t<td align=left>";
	protected final String TEXT_22 = NL + "\t<p>SuperClasses:" + NL + "\t";
	protected final String TEXT_23 = NL + "\t\t<a href=\"";
	protected final String TEXT_24 = "\">";
	protected final String TEXT_25 = "</a>" + NL + "\t";

	public EClassDocGen() {
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

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);

		return null;
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

	protected void method_writeEAttributes(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EAttribute> attributes = ((EClass) _element).getEAllAttributes();
		stringBuffer.append(TEXT_2);
		if (attributes.size() > 0) {
			stringBuffer.append(TEXT_3);
			for (EAttribute _EAttribute : attributes) {
				stringBuffer.append(TEXT_4);
				stringBuffer.append(EmfHtmlDocGen.getName(_EAttribute));
				stringBuffer.append(TEXT_5);
				stringBuffer.append(EmfHtmlDocGen.getBounds(_EAttribute));
				stringBuffer.append(TEXT_6);
				stringBuffer.append(EmfHtmlDocGen.getName(_EAttribute.getEAttributeType()));
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EAttribute.isChangeable());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EAttribute.isVolatile());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EAttribute.isTransient());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EAttribute.isDerived());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EAttribute.isOrdered());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EAttribute.isUnique());
				stringBuffer.append(TEXT_8);
			} // end for
			stringBuffer.append(TEXT_9);
		} // end if 
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeEAttributes", stringBuffer.toString());
	}

	protected void method_writeEOperations(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EOperation> operations = ((EClass) _element).getEAllOperations();
		stringBuffer.append(TEXT_2);
		if (operations.size() > 0) {
			stringBuffer.append(TEXT_10);
			for (EOperation _EOperation : operations) {
				stringBuffer.append(TEXT_4);
				stringBuffer.append(EmfHtmlDocGen.getName(_EOperation));
				stringBuffer.append(TEXT_5);
				stringBuffer.append(EmfHtmlDocGen.getBounds(_EOperation));
				stringBuffer.append(TEXT_11);
				if (_EOperation.getEType() != null) {
					stringBuffer.append(TEXT_12);
					stringBuffer.append(_EOperation.getEType().getName());
					stringBuffer.append(TEXT_12);
				} else {
					stringBuffer.append(TEXT_12);
					stringBuffer.append("-");
					stringBuffer.append(TEXT_12);
				}
				stringBuffer.append(TEXT_13);
				for (EParameter _EParameter : _EOperation.getEParameters()) {
					stringBuffer.append(TEXT_14);
					stringBuffer.append(EmfHtmlDocGen.getName(_EParameter));
					stringBuffer.append(TEXT_15);
					stringBuffer.append(EmfHtmlDocGen.getName(_EParameter.getEType()));
					stringBuffer.append(TEXT_16);
				} // end for
				stringBuffer.append(TEXT_17);
				stringBuffer.append(_EOperation.isRequired());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EOperation.isOrdered());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EOperation.isUnique());
				stringBuffer.append(TEXT_18);
			} // end for
			stringBuffer.append(TEXT_9);
		} // end if 
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeEOperations", stringBuffer.toString());
	}

	protected void method_writeEReferences(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EReference> references = ((EClass) _element).getEAllReferences();
		stringBuffer.append(TEXT_2);
		if (references.size() > 0) {
			stringBuffer.append(TEXT_19);
			for (EReference _EReference : references) {
				stringBuffer.append(TEXT_20);
				stringBuffer.append(EmfHtmlDocGen.getName(_EReference));
				stringBuffer.append(TEXT_5);
				stringBuffer.append(EmfHtmlDocGen.getBounds(_EReference));
				stringBuffer.append(TEXT_21);
				stringBuffer.append(EmfHtmlDocGen.getName(_EReference.getEReferenceType()));
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EReference.isContainment());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EReference.isChangeable());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EReference.isDerived());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EReference.isRequired());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EReference.isOrdered());
				stringBuffer.append(TEXT_7);
				stringBuffer.append(_EReference.isUnique());
				stringBuffer.append(TEXT_8);
			} // end for
			stringBuffer.append(TEXT_9);
		} // end if 
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeEReferences", stringBuffer.toString());
	}

	protected void method_writeSuperTypes(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EClass> superTypes = ((EClass) _element).getESuperTypes();
		stringBuffer.append(TEXT_2);
		if (superTypes.size() > 0) {
			stringBuffer.append(TEXT_22);
			for (EClass _SuperEClass : superTypes) {
				stringBuffer.append(TEXT_23);
				stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(_SuperEClass));
				stringBuffer.append(TEXT_24);
				stringBuffer.append(EmfHtmlDocGen.getName(_SuperEClass));
				stringBuffer.append(TEXT_25);
			} // end for
		} // end if 
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeSuperTypes", stringBuffer.toString());
	}
}