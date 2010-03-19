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
  public static synchronized EPackageDocGen create(String lineSeparator)
  {
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
  protected final String TEXT_9 = NL + "\t<h2>Data Type</h2>" + NL + "\t<ul>" + NL + "\t";
  protected final String TEXT_10 = NL + "\t\t" + NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
  protected final String TEXT_11 = "\">";
  protected final String TEXT_12 = "</a>" + NL + "\t\t</li>" + NL + "\t";
  protected final String TEXT_13 = NL + "\t</ul>";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL + "\t<h2>Enumerations</h2>" + NL + "\t<ul>" + NL + "\t";
  protected final String TEXT_16 = NL + "\t\t" + NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
  protected final String TEXT_17 = "\">";
  protected final String TEXT_18 = "</a>" + NL + "\t\t</li>" + NL + "\t";
  protected final String TEXT_19 = NL + "\t</ul>";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL + "\t<h2>SubPackages</h2>" + NL + "\t<ul>" + NL + "\t";
  protected final String TEXT_22 = NL + "\t\t<li>" + NL + "\t\t\t<a href=\"";
  protected final String TEXT_23 = "\">";
  protected final String TEXT_24 = "</a>" + NL + "\t\t</li>" + NL + "\t";
  protected final String TEXT_25 = NL + "\t</ul>";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "\t<p><i>back to </i> <a href=\"";
  protected final String TEXT_28 = "\">";
  protected final String TEXT_29 = "</a> </p>";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL;

	public EPackageDocGen()
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

    orchestration(ctx);
    if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();}
    
    stringBuffer.append(TEXT_30);
    stringBuffer.append(TEXT_31);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0, executionIndex = ictx.getExecutionBuffer().length();

    
method_body(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
return loop;
} 


    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    protected void method_writeEClasses(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

     EList<EClassifier> cclassifiers = ((EPackage) _element).getEClassifiers();
    stringBuffer.append(TEXT_2);
     if (cclassifiers.size() > 0) { 
    stringBuffer.append(TEXT_3);
     for (EClassifier _EClassifier : cclassifiers) {
		if (_EClassifier instanceof EClass) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(_EClassifier));
    stringBuffer.append(TEXT_5);
    stringBuffer.append( EmfHtmlDocGen.getName(_EClassifier));
    stringBuffer.append(TEXT_6);
    	}
	} // end for
    stringBuffer.append(TEXT_7);
     } // end if 
    }
    protected void method_writeEDataType(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

     EList<EClassifier> dclassifiers = ((EPackage) _element).getEClassifiers();
    stringBuffer.append(TEXT_8);
     if (dclassifiers.size() > 0) { 
    stringBuffer.append(TEXT_9);
     for (EClassifier _EClassifier : dclassifiers) {
		if (_EClassifier instanceof EDataType && ! (_EClassifier instanceof EEnum)) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(_EClassifier));
    stringBuffer.append(TEXT_11);
    stringBuffer.append( EmfHtmlDocGen.getName(_EClassifier));
    stringBuffer.append(TEXT_12);
    	}
	} // end for
    stringBuffer.append(TEXT_13);
     } // end if 
    }
    protected void method_writeEEnum(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

     EList<EClassifier> eclassifiers = ((EPackage) _element).getEClassifiers();
    stringBuffer.append(TEXT_14);
     if (eclassifiers.size() > 0) { 
    stringBuffer.append(TEXT_15);
     for (EClassifier _EClassifier : eclassifiers) {
		if (_EClassifier instanceof EEnum) { 
    stringBuffer.append(TEXT_16);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(_EClassifier));
    stringBuffer.append(TEXT_17);
    stringBuffer.append( EmfHtmlDocGen.getName(_EClassifier));
    stringBuffer.append(TEXT_18);
    	}
	} // end for
    stringBuffer.append(TEXT_19);
     } // end if 
    }
    protected void method_writeESubpackages(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

     EList<EPackage> packages = ((EPackage) _element).getESubpackages();
    stringBuffer.append(TEXT_20);
     if (packages.size() > 0) { 
    stringBuffer.append(TEXT_21);
     for (EPackage _package : packages) { 
    stringBuffer.append(TEXT_22);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(_package));
    stringBuffer.append(TEXT_23);
    stringBuffer.append( EmfHtmlDocGen.getName(_package));
    stringBuffer.append(TEXT_24);
    } // end for
    stringBuffer.append(TEXT_25);
     } // end if 
    }
    protected void method_writeEPackageReference(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

     EPackage pOwner = ((EPackage) _element).getESuperPackage(); 
    stringBuffer.append(TEXT_26);
     if (pOwner != null) { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(pOwner));
    stringBuffer.append(TEXT_28);
    stringBuffer.append( EmfHtmlDocGen.getName(pOwner) );
    stringBuffer.append(TEXT_29);
     } 
    }
    }