package emf.docgen.html.forStrategy;

import java.util.*;
import java.util.Map.Entry;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.emf.docgen.html.util.*;

public class PackageReport extends emf.docgen.html.EPackageDocGen {
  protected static String nl;
  public static synchronized PackageReport create(String lineSeparator)
  {
    nl = lineSeparator;
    PackageReport result = new PackageReport();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">" + NL + "<html>" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_2 = "</title>" + NL + "</HEAD>" + NL + "" + NL + "<BODY BGCOLOR=\"#ffffff\">" + NL + "" + NL + "<h1 class=\"Head\">";
  protected final String TEXT_3 = "</h1>";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "\t<p>";
  protected final String TEXT_6 = "</p>";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + "\t<h2>SubPackages</h2>" + NL + "\t<ul>" + NL + "\t";
  protected final String TEXT_9 = NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
  protected final String TEXT_10 = "\">";
  protected final String TEXT_11 = "</a>" + NL + "\t\t</li>" + NL + "\t";
  protected final String TEXT_12 = NL + "\t</ul>";
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL + "\t<h2>Classes</h2>" + NL + "\t<ul>" + NL + "\t";
  protected final String TEXT_15 = NL + "\t\t" + NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
  protected final String TEXT_16 = "\">";
  protected final String TEXT_17 = "</a>" + NL + "\t\t</li>" + NL + "\t";
  protected final String TEXT_18 = NL + "\t</ul>";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "\t<h2>Data Type</h2>" + NL + "\t<ul>" + NL + "\t";
  protected final String TEXT_21 = NL + "\t\t" + NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
  protected final String TEXT_22 = "\">";
  protected final String TEXT_23 = "</a>" + NL + "\t\t</li>" + NL + "\t";
  protected final String TEXT_24 = NL + "\t</ul>";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "\t<h2>Enumerations</h2>" + NL + "\t<ul>" + NL + "\t";
  protected final String TEXT_27 = NL + "\t\t" + NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
  protected final String TEXT_28 = "\">";
  protected final String TEXT_29 = "</a>" + NL + "\t\t</li>" + NL + "\t";
  protected final String TEXT_30 = NL + "\t</ul>";
  protected final String TEXT_31 = NL;
  protected final String TEXT_32 = NL + "\t<p><i>back to </i> <a href=\"";
  protected final String TEXT_33 = "\">";
  protected final String TEXT_34 = "</a> </p>";
  protected final String TEXT_35 = "\t<br/>" + NL + "\t<p><i>";
  protected final String TEXT_36 = "</i></p>" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_37 = NL;

	public PackageReport()
	{
	//Here is the constructor
StringBuffer stringBuffer = new StringBuffer();

    // add initialisation of the pattern variables (declaration has been already done).
    
	}
  	
  	public String generate(Object argument) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    InternalPatternContext ctx = (InternalPatternContext)argument;
Map<String, String> queryCtx = null;
IQuery.ParameterDescription paramDesc = null;

    
List<Object> elementList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object elementParameter : elementList ) {


    generate(ctx, elementParameter);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getBuffer().toString(), ctx);
    ctx.getBuffer().setLength(0);
}
    stringBuffer.append(TEXT_37);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object elementParameter) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EPackage element = (org.eclipse.emf.ecore.EPackage)elementParameter;
parameterValues.put("element", elementParameter);

    
method_setVariable(ictx.getBuffer(), ictx, element);

    
method_setSpecificVariables(ictx.getBuffer(), ictx);

    
method_fileHeader(ictx.getBuffer(), ictx);

    
method_writeEAnnotations(ictx.getBuffer(), ictx);

    
method_writeESubpackages(ictx.getBuffer(), ictx);

    
method_writeEClasses(ictx.getBuffer(), ictx);

    
method_writeEDataType(ictx.getBuffer(), ictx);

    
method_writeEEnum(ictx.getBuffer(), ictx);

    
method_writeEPackageReference(ictx.getBuffer(), ictx);

    
method_fileFooter(ictx.getBuffer(), ictx);

    CallHelper.callBack(new ExecutionContext(ictx), element);

    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
ictx.getBuffer().setLength(0);}
return loop;
} 


    protected void method_setVariable(StringBuilder stringBuffer, PatternContext ctx, org.eclipse.emf.ecore.EPackage element)throws Exception {

    
	// Set Object variables
	_Title = element.getName() + " Package";

	// Set EObject variables
	_element = element;

    }
    
    protected void method_setSpecificVariables(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    
	_copyright = "";

    }
    
    protected void method_fileHeader(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append( _Title );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( _Title );
    stringBuffer.append(TEXT_3);
    }
    
    protected void method_writeEAnnotations(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    
String result = new String();

for (EAnnotation annotation : ((EModelElement) _element).getEAnnotations()) {

	if (annotation.getSource() == "http://www.eclipse.org/emf/2002/GenModel"
		|| annotation.getSource() == "http://www.eclipse.org/egf/2010/GenDoc") {
		for (Entry<String, String> detail : annotation.getDetails().entrySet()) {
			if (detail.getKey()== "documentation" && detail.getValue() != "") {
				result = result + detail.getValue();
			}
		}
	}
}

    stringBuffer.append(TEXT_4);
    	if (result.length() > 0) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append( result );
    stringBuffer.append(TEXT_6);
     } // end if 
    }
    
    protected void method_writeESubpackages(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EList<EPackage> packages = ((EPackage) _element).getESubpackages();
    stringBuffer.append(TEXT_7);
     if (packages.size() > 0) { 
    stringBuffer.append(TEXT_8);
     for (EPackage _package : packages) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(_package));
    stringBuffer.append(TEXT_10);
    stringBuffer.append( EmfHtmlDocGen.getName(_package));
    stringBuffer.append(TEXT_11);
    } // end for
    stringBuffer.append(TEXT_12);
     } // end if 
    }
    
    protected void method_writeEClasses(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EList<EClassifier> cclassifiers = ((EPackage) _element).getEClassifiers();
    stringBuffer.append(TEXT_13);
     if (cclassifiers.size() > 0) { 
    stringBuffer.append(TEXT_14);
     for (EClassifier _EClassifier : cclassifiers) {
		if (_EClassifier instanceof EClass) { 
    stringBuffer.append(TEXT_15);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(_EClassifier));
    stringBuffer.append(TEXT_16);
    stringBuffer.append( EmfHtmlDocGen.getName(_EClassifier));
    stringBuffer.append(TEXT_17);
    	}
	} // end for
    stringBuffer.append(TEXT_18);
     } // end if 
    }
    
    protected void method_writeEDataType(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EList<EClassifier> dclassifiers = ((EPackage) _element).getEClassifiers();
    stringBuffer.append(TEXT_19);
     if (dclassifiers.size() > 0) { 
    stringBuffer.append(TEXT_20);
     for (EClassifier _EClassifier : dclassifiers) {
		if (_EClassifier instanceof EDataType && ! (_EClassifier instanceof EEnum)) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(_EClassifier));
    stringBuffer.append(TEXT_22);
    stringBuffer.append( EmfHtmlDocGen.getName(_EClassifier));
    stringBuffer.append(TEXT_23);
    	}
	} // end for
    stringBuffer.append(TEXT_24);
     } // end if 
    }
    
    protected void method_writeEEnum(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EList<EClassifier> eclassifiers = ((EPackage) _element).getEClassifiers();
    stringBuffer.append(TEXT_25);
     if (eclassifiers.size() > 0) { 
    stringBuffer.append(TEXT_26);
     for (EClassifier _EClassifier : eclassifiers) {
		if (_EClassifier instanceof EEnum) { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(_EClassifier));
    stringBuffer.append(TEXT_28);
    stringBuffer.append( EmfHtmlDocGen.getName(_EClassifier));
    stringBuffer.append(TEXT_29);
    	}
	} // end for
    stringBuffer.append(TEXT_30);
     } // end if 
    }
    
    protected void method_writeEPackageReference(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EPackage pOwner = ((EPackage) _element).getESuperPackage(); 
    stringBuffer.append(TEXT_31);
     if (pOwner != null) { 
    stringBuffer.append(TEXT_32);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(pOwner));
    stringBuffer.append(TEXT_33);
    stringBuffer.append( EmfHtmlDocGen.getName(pOwner) );
    stringBuffer.append(TEXT_34);
     } 
    }
    
    protected void method_fileFooter(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(_copyright);
    stringBuffer.append(TEXT_36);
    }
    }