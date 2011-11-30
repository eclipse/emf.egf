//Generated on Mon Nov 07 17:44:34 CET 2011 with EGF 0.6.1.qualifier
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
	protected final String TEXT_3 = NL + "\t<h2>Attributes</h2>" + NL + "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL + "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Bounds</th>" + NL + "\t\t\t<th>Type</th>" + NL + "\t\t\t<th>Changeable</th>" + NL + "\t\t\t<th>Volatile</th>" + NL + "\t\t\t<th>Transient</th>" + NL + "\t\t\t<th>Derived</th>" + NL + "\t\t\t<th>Ordered</th>" + NL + "\t\t\t<th>Unique</th>" + NL + "\t\t</tr>" + NL + "\t";
	protected final String TEXT_4 = NL + "\t\t<tr>" + NL + "   \t\t\t<td align=left><b>";
	protected final String TEXT_5 = "</b></td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_6 = "  </td>" + NL + "   \t\t\t<td align=left>";
	protected final String TEXT_7 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_8 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_9 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_10 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_11 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_12 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_13 = "</td>" + NL + "   \t\t</tr>" + NL + "\t";
	protected final String TEXT_14 = NL + "\t</table>";
	protected final String TEXT_15 = NL;
	protected final String TEXT_16 = NL;
	protected final String TEXT_17 = NL + "\t<h2>Operations</h2>" + NL + "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL + "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Bounds</th>" + NL + "\t\t\t<th>Return</th>" + NL + "\t\t\t<th>Parameter(s)</th>" + NL + "\t\t\t<th>Required</th>" + NL + "\t\t\t<th>Ordered</th>" + NL + "\t\t\t<th>Unique</th>" + NL + "\t\t</tr>" + NL + "\t";
	protected final String TEXT_18 = NL + "\t\t<tr>" + NL + "   \t\t\t<td align=left><b>";
	protected final String TEXT_19 = "</b></td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_20 = "</td>" + NL + "   \t\t\t<td align=center>" + NL + "   \t\t\t\t";
	protected final String TEXT_21 = NL + "   \t\t\t\t";
	protected final String TEXT_22 = NL + "   \t\t\t\t";
	protected final String TEXT_23 = NL + "   \t\t\t\t";
	protected final String TEXT_24 = NL + "   \t\t\t\t";
	protected final String TEXT_25 = NL + "   \t\t\t</td>" + NL + "\t\t\t<td align=left>" + NL + "\t\t\t\t";
	protected final String TEXT_26 = NL + "\t\t\t\t\t<p>";
	protected final String TEXT_27 = " - ";
	protected final String TEXT_28 = "</p>" + NL + "\t\t\t\t";
	protected final String TEXT_29 = NL + "\t\t\t</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_30 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_31 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_32 = "</td>" + NL + "" + NL + "   \t\t</tr>" + NL + "" + NL + "" + NL + "\t";
	protected final String TEXT_33 = NL + "\t</table>";
	protected final String TEXT_34 = NL;
	protected final String TEXT_35 = NL;
	protected final String TEXT_36 = NL + "\t<h2>References</h2>" + NL + "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL + "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Bounds</th>" + NL + "\t\t\t<th>Type</th>" + NL + "\t\t\t<th>Containment</th>" + NL + "\t\t\t<th>Changeable</th>" + NL + "\t\t\t<th>Derived</th>" + NL + "\t\t\t<th>Required</th>" + NL + "\t\t\t<th>Ordered</th>" + NL + "\t\t\t<th>Unique</th>" + NL + "\t\t</tr>" + NL + "\t";
	protected final String TEXT_37 = NL + "\t\t<tr>" + NL + "\t   \t\t<td align=left><b>";
	protected final String TEXT_38 = "</b></td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_39 = "</td>" + NL + "   \t\t\t<td align=left>";
	protected final String TEXT_40 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_41 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_42 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_43 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_44 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_45 = "</td>" + NL + "   \t\t\t<td align=center>";
	protected final String TEXT_46 = "</td>" + NL + "   \t\t</tr>" + NL + "\t";
	protected final String TEXT_47 = NL + "\t</table>";
	protected final String TEXT_48 = NL;
	protected final String TEXT_49 = NL;
	protected final String TEXT_50 = NL + "\t<p>SuperClasses:" + NL + "\t";
	protected final String TEXT_51 = NL + "\t\t<a href=\"";
	protected final String TEXT_52 = "\">";
	protected final String TEXT_53 = "</a>" + NL + "\t";
	protected final String TEXT_54 = NL;
	protected final String TEXT_55 = NL;
	protected final String TEXT_56 = NL;

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
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_55);
		stringBuffer.append(TEXT_56);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);

		String loop = OutputManager.getOutputWithoutCallback(ictx);
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
				stringBuffer.append(TEXT_8);
				stringBuffer.append(_EAttribute.isVolatile());
				stringBuffer.append(TEXT_9);
				stringBuffer.append(_EAttribute.isTransient());
				stringBuffer.append(TEXT_10);
				stringBuffer.append(_EAttribute.isDerived());
				stringBuffer.append(TEXT_11);
				stringBuffer.append(_EAttribute.isOrdered());
				stringBuffer.append(TEXT_12);
				stringBuffer.append(_EAttribute.isUnique());
				stringBuffer.append(TEXT_13);
			} // end for
			stringBuffer.append(TEXT_14);
		} // end if 
		stringBuffer.append(TEXT_15);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeEAttributes", stringBuffer.toString());
	}

	protected void method_writeEOperations(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EOperation> operations = ((EClass) _element).getEAllOperations();
		stringBuffer.append(TEXT_16);
		if (operations.size() > 0) {
			stringBuffer.append(TEXT_17);
			for (EOperation _EOperation : operations) {
				stringBuffer.append(TEXT_18);
				stringBuffer.append(EmfHtmlDocGen.getName(_EOperation));
				stringBuffer.append(TEXT_19);
				stringBuffer.append(EmfHtmlDocGen.getBounds(_EOperation));
				stringBuffer.append(TEXT_20);
				if (_EOperation.getEType() != null) {
					stringBuffer.append(TEXT_21);
					stringBuffer.append(_EOperation.getEType().getName());
					stringBuffer.append(TEXT_22);
				} else {
					stringBuffer.append(TEXT_23);
					stringBuffer.append("-");
					stringBuffer.append(TEXT_24);
				}
				stringBuffer.append(TEXT_25);
				for (EParameter _EParameter : _EOperation.getEParameters()) {
					stringBuffer.append(TEXT_26);
					stringBuffer.append(EmfHtmlDocGen.getName(_EParameter));
					stringBuffer.append(TEXT_27);
					stringBuffer.append(EmfHtmlDocGen.getName(_EParameter.getEType()));
					stringBuffer.append(TEXT_28);
				} // end for
				stringBuffer.append(TEXT_29);
				stringBuffer.append(_EOperation.isRequired());
				stringBuffer.append(TEXT_30);
				stringBuffer.append(_EOperation.isOrdered());
				stringBuffer.append(TEXT_31);
				stringBuffer.append(_EOperation.isUnique());
				stringBuffer.append(TEXT_32);
			} // end for
			stringBuffer.append(TEXT_33);
		} // end if 
		stringBuffer.append(TEXT_34);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeEOperations", stringBuffer.toString());
	}

	protected void method_writeEReferences(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EReference> references = ((EClass) _element).getEAllReferences();
		stringBuffer.append(TEXT_35);
		if (references.size() > 0) {
			stringBuffer.append(TEXT_36);
			for (EReference _EReference : references) {
				stringBuffer.append(TEXT_37);
				stringBuffer.append(EmfHtmlDocGen.getName(_EReference));
				stringBuffer.append(TEXT_38);
				stringBuffer.append(EmfHtmlDocGen.getBounds(_EReference));
				stringBuffer.append(TEXT_39);
				stringBuffer.append(EmfHtmlDocGen.getName(_EReference.getEReferenceType()));
				stringBuffer.append(TEXT_40);
				stringBuffer.append(_EReference.isContainment());
				stringBuffer.append(TEXT_41);
				stringBuffer.append(_EReference.isChangeable());
				stringBuffer.append(TEXT_42);
				stringBuffer.append(_EReference.isDerived());
				stringBuffer.append(TEXT_43);
				stringBuffer.append(_EReference.isRequired());
				stringBuffer.append(TEXT_44);
				stringBuffer.append(_EReference.isOrdered());
				stringBuffer.append(TEXT_45);
				stringBuffer.append(_EReference.isUnique());
				stringBuffer.append(TEXT_46);
			} // end for
			stringBuffer.append(TEXT_47);
		} // end if 
		stringBuffer.append(TEXT_48);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeEReferences", stringBuffer.toString());
	}

	protected void method_writeSuperTypes(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EClass> superTypes = ((EClass) _element).getESuperTypes();
		stringBuffer.append(TEXT_49);
		if (superTypes.size() > 0) {
			stringBuffer.append(TEXT_50);
			for (EClass _SuperEClass : superTypes) {
				stringBuffer.append(TEXT_51);
				stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(_SuperEClass));
				stringBuffer.append(TEXT_52);
				stringBuffer.append(EmfHtmlDocGen.getName(_SuperEClass));
				stringBuffer.append(TEXT_53);
			} // end for
		} // end if 
		stringBuffer.append(TEXT_54);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeSuperTypes", stringBuffer.toString());
	}

	public boolean preCondition() {
		return true;
	}
}