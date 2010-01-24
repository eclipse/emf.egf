package HelloFriendsPatternsLib;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class HelloWorld 
{
  protected static String nl;
  public static synchronized HelloWorld create(String lineSeparator)
  {
    nl = lineSeparator;
    HelloWorld result = new HelloWorld();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = ", and all friends of ";

	public HelloWorld()
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

    


List<Object> elementList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object elementParameter : elementList ) {


    collector.append(generate(ctx, elementParameter));
    
}
ctx.getReporter().executionFinished(collector.toString(), ctx);

    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object elementParameter) throws Exception  {
final StringBuffer stringBuffer = new StringBuffer();
PatternCallReporter callReporter =  new PatternCallReporter(stringBuffer);

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EClass element = (org.eclipse.emf.ecore.EClass)elementParameter;
parameterValues.put("element", elementParameter);

    stringBuffer.append(TEXT_1);
    stringBuffer.append( element.getName() );
    
String loop = stringBuffer.toString();
ctx.getReporter().loopFinished(loop, ctx, parameterValues);
return loop;
} 

}