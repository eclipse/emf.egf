package egf.uc1_2.helloWorld.friends;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class HelloFriends 
{
  protected static String nl;
  public static synchronized HelloFriends create(String lineSeparator)
  {
    nl = lineSeparator;
    HelloFriends result = new HelloFriends();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = ", and all friends of ";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

	public HelloFriends()
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
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object elementParameter) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EClass element = (org.eclipse.emf.ecore.EClass)elementParameter;
parameterValues.put("element", elementParameter);

    
method_body(ictx.getBuffer(), ictx, element);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
ictx.getBuffer().setLength(0);}
return loop;
} 


    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx, final org.eclipse.emf.ecore.EClass element)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append( element.getName() );
    }
    }