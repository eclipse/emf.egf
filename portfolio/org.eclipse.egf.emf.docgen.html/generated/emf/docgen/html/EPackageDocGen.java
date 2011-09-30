package emf.docgen.html;

import org.eclipse.egf.emf.docgen.html.util.*;
import org.eclipse.emf.common.util.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class EPackageDocGen extends emf.docgen.html.ENamedElementDocGen {
	protected static String nl;

	public static synchronized EPackageDocGen create(String lineSeparator) {
		nl = lineSeparator;
		EPackageDocGen result = new EPackageDocGen();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "//default content";
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL + "\t<h2>Classes</h2>" + NL + "\t<ul>" + NL + "\t";
	protected final String TEXT_4 = NL + "\t\t" + NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
	protected final String TEXT_5 = "\">";
	protected final String TEXT_6 = "</a>" + NL + "\t\t</li>" + NL + "\t";
	protected final String TEXT_7 = NL + "\t</ul>";
	protected final String TEXT_8 = NL;
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = NL + "\t<h2>Data Type</h2>" + NL + "\t<ul>" + NL + "\t";
	protected final String TEXT_11 = NL + "\t\t" + NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
	protected final String TEXT_12 = "\">";
	protected final String TEXT_13 = "</a>" + NL + "\t\t</li>" + NL + "\t";
	protected final String TEXT_14 = NL + "\t</ul>";
	protected final String TEXT_15 = NL;
	protected final String TEXT_16 = NL;
	protected final String TEXT_17 = NL + "\t<h2>Enumerations</h2>" + NL + "\t<ul>" + NL + "\t";
	protected final String TEXT_18 = NL + "\t\t" + NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
	protected final String TEXT_19 = "\">";
	protected final String TEXT_20 = "</a>" + NL + "\t\t</li>" + NL + "\t";
	protected final String TEXT_21 = NL + "\t</ul>";
	protected final String TEXT_22 = NL;
	protected final String TEXT_23 = NL + "\t<h2>SubPackages</h2>" + NL + "\t<ul>" + NL + "\t";
	protected final String TEXT_24 = NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
	protected final String TEXT_25 = "\">";
	protected final String TEXT_26 = "</a>" + NL + "\t\t</li>" + NL + "\t";
	protected final String TEXT_27 = NL + "\t</ul>";
	protected final String TEXT_28 = NL;
	protected final String TEXT_29 = NL;
	protected final String TEXT_30 = NL + "\t<p><i>back to </i> <a href=\"";
	protected final String TEXT_31 = "\">";
	protected final String TEXT_32 = "</a> </p>";
	protected final String TEXT_33 = NL;
	protected final String TEXT_34 = NL;

	public EPackageDocGen() {
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

		stringBuffer.append(TEXT_33);
		stringBuffer.append(TEXT_34);
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
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@18d6cf4 (description: null) (name: body) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.docgen.html/templates/pattern._ChgNwAa1Ed-6kIajn4nnRQ/method._ChgNwwa1Ed-6kIajn4nnRQ.pt)", stringBuffer.toString());
	}

	protected void method_writeEClasses(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EClassifier> cclassifiers = ((EPackage) _element).getEClassifiers();
		stringBuffer.append(TEXT_2);
		if (cclassifiers.size() > 0) {
			stringBuffer.append(TEXT_3);
			for (EClassifier _EClassifier : cclassifiers) {
				if (_EClassifier instanceof EClass) {
					stringBuffer.append(TEXT_4);
					stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(_EClassifier));
					stringBuffer.append(TEXT_5);
					stringBuffer.append(EmfHtmlDocGen.getName(_EClassifier));
					stringBuffer.append(TEXT_6);
				}
			} // end for
			stringBuffer.append(TEXT_7);
		} // end if 
		stringBuffer.append(TEXT_8);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@ff207b (description: null) (name: writeEClasses) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.docgen.html/templates/pattern._ChgNwAa1Ed-6kIajn4nnRQ/method._rImoUAbuEd-6kIajn4nnRQ.pt)", stringBuffer.toString());
	}

	protected void method_writeEDataType(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EClassifier> dclassifiers = ((EPackage) _element).getEClassifiers();
		stringBuffer.append(TEXT_9);
		if (dclassifiers.size() > 0) {
			stringBuffer.append(TEXT_10);
			for (EClassifier _EClassifier : dclassifiers) {
				if (_EClassifier instanceof EDataType && !(_EClassifier instanceof EEnum)) {
					stringBuffer.append(TEXT_11);
					stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(_EClassifier));
					stringBuffer.append(TEXT_12);
					stringBuffer.append(EmfHtmlDocGen.getName(_EClassifier));
					stringBuffer.append(TEXT_13);
				}
			} // end for
			stringBuffer.append(TEXT_14);
		} // end if 
		stringBuffer.append(TEXT_15);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1ad96d5 (description: null) (name: writeEDataType) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.docgen.html/templates/pattern._ChgNwAa1Ed-6kIajn4nnRQ/method._3yCh0AheEd-6kIajn4nnRQ.pt)", stringBuffer.toString());
	}

	protected void method_writeEEnum(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EClassifier> eclassifiers = ((EPackage) _element).getEClassifiers();
		stringBuffer.append(TEXT_16);
		if (eclassifiers.size() > 0) {
			stringBuffer.append(TEXT_17);
			for (EClassifier _EClassifier : eclassifiers) {
				if (_EClassifier instanceof EEnum) {
					stringBuffer.append(TEXT_18);
					stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(_EClassifier));
					stringBuffer.append(TEXT_19);
					stringBuffer.append(EmfHtmlDocGen.getName(_EClassifier));
					stringBuffer.append(TEXT_20);
				}
			} // end for
			stringBuffer.append(TEXT_21);
		} // end if 
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@1899788 (description: null) (name: writeEEnum) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.docgen.html/templates/pattern._ChgNwAa1Ed-6kIajn4nnRQ/method._5-QhwAheEd-6kIajn4nnRQ.pt)", stringBuffer.toString());
	}

	protected void method_writeESubpackages(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EPackage> packages = ((EPackage) _element).getESubpackages();
		stringBuffer.append(TEXT_22);
		if (packages.size() > 0) {
			stringBuffer.append(TEXT_23);
			for (EPackage _package : packages) {
				stringBuffer.append(TEXT_24);
				stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(_package));
				stringBuffer.append(TEXT_25);
				stringBuffer.append(EmfHtmlDocGen.getName(_package));
				stringBuffer.append(TEXT_26);
			} // end for
			stringBuffer.append(TEXT_27);
		} // end if 
		stringBuffer.append(TEXT_28);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@3b7c27 (description: null) (name: writeESubpackages) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.docgen.html/templates/pattern._ChgNwAa1Ed-6kIajn4nnRQ/method._XJctwAhYEd-6kIajn4nnRQ.pt)", stringBuffer.toString());
	}

	protected void method_writeEPackageReference(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EPackage pOwner = ((EPackage) _element).getESuperPackage();
		stringBuffer.append(TEXT_29);
		if (pOwner != null) {
			stringBuffer.append(TEXT_30);
			stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(pOwner));
			stringBuffer.append(TEXT_31);
			stringBuffer.append(EmfHtmlDocGen.getName(pOwner));
			stringBuffer.append(TEXT_32);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@153ebbd (description: null) (name: writeEPackageReference) (patternFilePath: platform:/plugin/org.eclipse.egf.emf.docgen.html/templates/pattern._ChgNwAa1Ed-6kIajn4nnRQ/method._9IqvoAhbEd-6kIajn4nnRQ.pt)", stringBuffer.toString());
	}
}