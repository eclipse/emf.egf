package HelloPatternsLib;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class Hello 
{
  protected static String nl;
  public static synchronized Hello create(String lineSeparator)
  {
    nl = lineSeparator;
    Hello result = new Hello();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Hello - Hello!";
  protected final String TEXT_2 = NL;

	public Hello()
	{
	//Here is the constructor
StringBuffer stringBuffer = new StringBuffer();

    // add initialisation of the pattern variables (declaration has been already done).
    
	}
  	
  	public String generate(Object argument) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    PatternContext ctx = (PatternContext)argument;
StringBuilder collector = new StringBuilder(2000);
Map<String, String> queryCtx = null;
IQuery.ParameterDescription paramDesc = null;

    collector.append(generate(ctx));
    ctx.getReporter().executionFinished(stringBuffer.toString(), ctx);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx) throws Exception  {
final StringBuffer stringBuffer = new StringBuffer();
PatternCallReporter callReporter =  new PatternCallReporter(stringBuffer);

    stringBuffer.append(TEXT_1);
    
String loop = stringBuffer.toString();
return loop;
} 

}