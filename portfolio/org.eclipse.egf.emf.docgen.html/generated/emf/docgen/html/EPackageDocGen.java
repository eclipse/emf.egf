//Generated with EGF 1.6.3.202110181143
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
	protected final String TEXT_8 = NL + "\t<h2>Data Type</h2>" + NL + "\t<ul>" + NL + "\t";
	protected final String TEXT_9 = NL + "\t<h2>Enumerations</h2>" + NL + "\t<ul>" + NL + "\t";
	protected final String TEXT_10 = NL + "\t<h2>SubPackages</h2>" + NL + "\t<ul>" + NL + "\t";
	protected final String TEXT_11 = NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
	protected final String TEXT_12 = NL + "\t<p><i>back to </i> <a href=\"";
	protected final String TEXT_13 = "</a> </p>";

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
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeEClasses", stringBuffer.toString());
	}

	protected void method_writeEDataType(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EClassifier> dclassifiers = ((EPackage) _element).getEClassifiers();
		stringBuffer.append(TEXT_2);
		if (dclassifiers.size() > 0) {
			stringBuffer.append(TEXT_8);
			for (EClassifier _EClassifier : dclassifiers) {
				if (_EClassifier instanceof EDataType && !(_EClassifier instanceof EEnum)) {
					stringBuffer.append(TEXT_4);
					stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(_EClassifier));
					stringBuffer.append(TEXT_5);
					stringBuffer.append(EmfHtmlDocGen.getName(_EClassifier));
					stringBuffer.append(TEXT_6);
				}
			} // end for
			stringBuffer.append(TEXT_7);
		} // end if 
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeEDataType", stringBuffer.toString());
	}

	protected void method_writeEEnum(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		EList<EClassifier> eclassifiers = ((EPackage) _element).getEClassifiers();
		stringBuffer.append(TEXT_2);
		if (eclassifiers.size() > 0) {
			stringBuffer.append(TEXT_9);
			for (EClassifier _EClassifier : eclassifiers) {
				if (_EClassifier instanceof EEnum) {
					stringBuffer.append(TEXT_4);
					stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(_EClassifier));
					stringBuffer.append(TEXT_5);
					stringBuffer.append(EmfHtmlDocGen.getName(_EClassifier));
					stringBuffer.append(TEXT_6);
				}
			} // end for
			stringBuffer.append(TEXT_7);
		} // end if 
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeEEnum", stringBuffer.toString());
	}

	protected void method_writeESubpackages(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		EList<EPackage> packages = ((EPackage) _element).getESubpackages();
		stringBuffer.append(TEXT_2);
		if (packages.size() > 0) {
			stringBuffer.append(TEXT_10);
			for (EPackage _package : packages) {
				stringBuffer.append(TEXT_11);
				stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(_package));
				stringBuffer.append(TEXT_5);
				stringBuffer.append(EmfHtmlDocGen.getName(_package));
				stringBuffer.append(TEXT_6);
			} // end for
			stringBuffer.append(TEXT_7);
		} // end if 
		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeESubpackages", stringBuffer.toString());
	}

	protected void method_writeEPackageReference(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		EPackage pOwner = ((EPackage) _element).getESuperPackage();
		stringBuffer.append(TEXT_2);
		if (pOwner != null) {
			stringBuffer.append(TEXT_12);
			stringBuffer.append(EmfHtmlDocGen.getHtmlFileName(pOwner));
			stringBuffer.append(TEXT_5);
			stringBuffer.append(EmfHtmlDocGen.getName(pOwner));
			stringBuffer.append(TEXT_13);
		}
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "writeEPackageReference", stringBuffer.toString());
	}
}