package HelloWorldPatternsLib;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class HelloWorld extends HelloPatternsLib.Hello {
  protected static String nl;
  public static synchronized HelloWorld create(String lineSeparator)
  {
    nl = lineSeparator;
    HelloWorld result = new HelloWorld();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Hello ";
  protected final String TEXT_2 = "!";

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

    


paramDesc = new IQuery.ParameterDescription("aClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass");
queryCtx = new HashMap<String, String>();
List<Object> aClassList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);


for (Object aClassParameter : aClassList ) {


    collector.append(generate(ctx, aClassParameter));
    
}
ctx.getReporter().executionFinished(collector.toString(), ctx);

    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object aClassParameter) throws Exception  {
final StringBuffer stringBuffer = new StringBuffer();
PatternCallReporter callReporter =  new PatternCallReporter(stringBuffer);

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EClass aClass = (org.eclipse.emf.ecore.EClass)aClassParameter;
parameterValues.put("aClass", aClassParameter);

    stringBuffer.append(TEXT_1);
    stringBuffer.append( aClass.getName() );
    org.eclipse.emf.ecore.EClass element__KPk9gOiJEd6N7yXRz81IQ = aClass;
PatternContext ctx__7vwigPxTEd6QrqCYyi2MrA = new PatternContext(ctx);
ctx__7vwigPxTEd6QrqCYyi2MrA.setReporter(callReporter);
ctx__7vwigPxTEd6QrqCYyi2MrA.setValue("key", "value");
EngineHelper.executeWithInjection("_7MX9IOgREd6H-IbEpfKYLw", ctx__7vwigPxTEd6QrqCYyi2MrA, element__KPk9gOiJEd6N7yXRz81IQ);
    stringBuffer.append(TEXT_2);
    
String loop = stringBuffer.toString();
ctx.getReporter().loopFinished(loop, ctx, parameterValues);
return loop;
} 

}