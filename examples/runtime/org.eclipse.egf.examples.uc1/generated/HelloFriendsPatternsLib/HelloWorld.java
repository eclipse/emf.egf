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

    


List<Object> elementList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object elementParameter : elementList ) {
parameterValues.put("element", elementParameter);


    generate(stringBuffer, ctx, elementParameter);
    
String loop = stringBuffer.toString();
reporter.loopFinished(loop, ctx, null );
collector.append(loop);
stringBuffer.setLength(0);
}
reporter.executionFinished(collector.toString(), ctx);

    return stringBuffer.toString();
  }
public void generate(final StringBuffer stringBuffer, PatternContext ctx, Object elementParameter) {

org.eclipse.emf.ecore.EClass element = (org.eclipse.emf.ecore.EClass)elementParameter;

    
    // add initialisation of the pattern variables (declaration has been already done).
    stringBuffer.append(TEXT_1);
    stringBuffer.append( element.getName() );
    } 
}
