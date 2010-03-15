package emf.docgen.html.forStrategy;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.emf.docgen.html.util.*;

public class EnumerationReport extends emf.docgen.html.EEnumDocGen {
  protected static String nl;
  public static synchronized EnumerationReport create(String lineSeparator)
  {
    nl = lineSeparator;
    EnumerationReport result = new EnumerationReport();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">" + NL + "<html>" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_2 = "</title>" + NL + "</HEAD>" + NL + "" + NL + "<BODY BGCOLOR=\"#ffffff\">" + NL + "" + NL + "<h1 class=\"Head\">";
  protected final String TEXT_3 = "</h1>";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "\t<h2>Enum Literals</h2>" + NL + "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL + "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Value</th>" + NL + "\t\t</tr>" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\t<tr>" + NL + "   \t\t\t<td align=left><b>";
  protected final String TEXT_7 = "</b></td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_8 = "</td>" + NL + "   \t\t</tr>" + NL + "\t";
  protected final String TEXT_9 = NL + "\t</table>";
  protected final String TEXT_10 = NL + "<p><i>back to </i> <a href=\"";
  protected final String TEXT_11 = "\">";
  protected final String TEXT_12 = "</a> </p>";
  protected final String TEXT_13 = "\t<br/>" + NL + "\t<p><i>";
  protected final String TEXT_14 = "</i></p>" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_15 = NL;

	public EnumerationReport()
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
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object elementParameter) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EEnum element = (org.eclipse.emf.ecore.EEnum)elementParameter;
parameterValues.put("element", elementParameter);

    
method_setVariable(ictx.getBuffer(), ictx, element);

    
method_setSpecificVariables(ictx.getBuffer(), ictx);

    
method_fileHeader(ictx.getBuffer(), ictx);

    
method_writeEEnumLiteral(ictx.getBuffer(), ictx);

    
method_writeEPackageReference(ictx.getBuffer(), ictx);

    
method_fileFooter(ictx.getBuffer(), ictx);

    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
ictx.getBuffer().setLength(0);}
return loop;
} 


    protected void method_setVariable(StringBuilder stringBuffer, PatternContext ctx, org.eclipse.emf.ecore.EEnum element)throws Exception {

    
	// Set Object variables
	_Title = element.getName() + " Enumeration";

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
    
    protected void method_writeEEnumLiteral(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EList<EEnumLiteral> enumLiterals = ((EEnum) _element).getELiterals();
    stringBuffer.append(TEXT_4);
     if (enumLiterals.size() > 0) { 
    stringBuffer.append(TEXT_5);
     for (EEnumLiteral _EEnumLiteral : enumLiterals) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append( EmfHtmlDocGen.getName(_EEnumLiteral) );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( _EEnumLiteral.getValue() );
    stringBuffer.append(TEXT_8);
    } // end for
    stringBuffer.append(TEXT_9);
     } // end if 
    }
    
    protected void method_writeEPackageReference(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EPackage pOwner = ((EClassifier) _element).getEPackage(); 
    stringBuffer.append(TEXT_10);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(pOwner));
    stringBuffer.append(TEXT_11);
    stringBuffer.append( EmfHtmlDocGen.getName(pOwner) );
    stringBuffer.append(TEXT_12);
    }
    
    protected void method_fileFooter(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(_copyright);
    stringBuffer.append(TEXT_14);
    }
    }