package emf.docgen.html;

import org.eclipse.egf.emf.docgen.html.util.*;
import org.eclipse.emf.common.util.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class EClassifierDocGen extends emf.docgen.html.ENamedElementDocGen {
  protected static String nl;
  public static synchronized EClassifierDocGen create(String lineSeparator)
  {
    nl = lineSeparator;
    EClassifierDocGen result = new EClassifierDocGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//default content";
  protected final String TEXT_2 = NL + "<p><i>back to </i> <a href=\"";
  protected final String TEXT_3 = "\">";
  protected final String TEXT_4 = "</a> </p>";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;

	public EClassifierDocGen()
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

    generate(ctx);
    if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getBuffer().toString(), ctx);
    ctx.getBuffer().setLength(0);}
    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

    
method_body(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
return loop;
} 


    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    protected void method_writeEPackageReference(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

     EPackage pOwner = ((EClassifier) _element).getEPackage(); 
    stringBuffer.append(TEXT_2);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(pOwner));
    stringBuffer.append(TEXT_3);
    stringBuffer.append( EmfHtmlDocGen.getName(pOwner) );
    stringBuffer.append(TEXT_4);
    }
    }