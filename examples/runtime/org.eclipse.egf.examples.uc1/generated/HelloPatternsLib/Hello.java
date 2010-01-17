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

    generate(stringBuffer, ctx);
    reporter.executionFinished(stringBuffer.toString(), ctx);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
public void generate(final StringBuffer stringBuffer, PatternContext ctx) {

    
    // add initialisation of the pattern variables (declaration has been already done).
    stringBuffer.append(TEXT_1);
    } 
}
