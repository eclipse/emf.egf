package HelloWorldPatternsLib;

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
  protected final String TEXT_1 = NL + "Hello ";
  protected final String TEXT_2 = "!";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    PatternContext ctx = (PatternContext)argument;
Map<String, Object> parameterValues = new HashMap<String, Object>();
StringBuilder collector = new StringBuilder(2000);
Map<String, String> queryCtx = null;
IQuery.ParameterDescription paramDesc = null;
PatternExecutionReporter reporter = (PatternExecutionReporter)ctx.getValue(PatternContext.PATTERN_REPORTER);
if (reporter == null) reporter = new ConsoleReporter();

    


paramDesc = new IQuery.ParameterDescription("aClass", "http://www.eclipse.org/emf/2002/Ecore#//EClass");
queryCtx = new HashMap<String, String>();
queryCtx.put("type", "http://www.eclipse.org/emf/2002/Ecore#//EClass");
List<Object> aClassList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);


for (Object aClassParameter : aClassList ) {
parameterValues.put("aClass", aClassParameter);


    generate(stringBuffer, ctx, aClassParameter);
    
String loop = stringBuffer.toString();
reporter.loopFinished(loop, ctx, null );
collector.append(loop);
stringBuffer.setLength(0);
}
reporter.executionFinished(collector.toString(), ctx);

    return stringBuffer.toString();
  }
public void generate(final StringBuffer stringBuffer, PatternContext ctx, Object aClassParameter) {

org.eclipse.emf.ecore.EClass aClass = (org.eclipse.emf.ecore.EClass)aClassParameter;

    
    // add initialisation of the pattern variables (declaration has been already done).
    // add initialisation of the pattern variables (declaration has been already done).
    stringBuffer.append(TEXT_1);
    stringBuffer.append( aClass.getName() );
    org.eclipse.emf.ecore.EClass element__KPk9gOiJEd6N7yXRz81IQ = aClass;
PatternContext ctx_HelloFriends__7MX9IOgREd6HIbEpfKYLw = new PatternContext(ctx);
ctx_HelloFriends__7MX9IOgREd6HIbEpfKYLw.setValue("key", "value");
 new HelloFriendsPatternsLib.HelloWorld().generate(stringBuffer, ctx_HelloFriends__7MX9IOgREd6HIbEpfKYLw, element__KPk9gOiJEd6N7yXRz81IQ);
    stringBuffer.append(TEXT_2);
    } 
}
