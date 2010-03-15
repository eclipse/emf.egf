package egf.uc1_3.helloWorld.parent;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ParentPattern 
{
  protected static String nl;
  public static synchronized ParentPattern create(String lineSeparator)
  {
    nl = lineSeparator;
    ParentPattern result = new ParentPattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "Hello ";
  protected final String TEXT_2 = " from parent";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;

	public ParentPattern()
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
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

    
method_sayHello(ictx.getBuffer(), ictx);

    
method_sayFromParent(ictx.getBuffer(), ictx);

    
String loop = ictx.getBuffer().toString();
return loop;
} 


    protected void method_sayHello(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    
    protected void method_sayFromParent(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_2);
    }
    }