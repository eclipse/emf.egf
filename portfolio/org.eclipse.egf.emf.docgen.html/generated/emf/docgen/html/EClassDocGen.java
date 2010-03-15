package emf.docgen.html;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class EClassDocGen extends emf.docgen.html.EClassifierDocGen {
  protected static String nl;
  public static synchronized EClassDocGen create(String lineSeparator)
  {
    nl = lineSeparator;
    EClassDocGen result = new EClassDocGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// Class body contents";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

	public EClassDocGen()
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
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

    
method_body(ictx.getBuffer(), ictx);

    
String loop = ictx.getBuffer().toString();
return loop;
} 


    protected void method_body(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    }