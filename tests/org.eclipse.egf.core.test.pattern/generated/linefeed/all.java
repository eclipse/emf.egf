package linefeed;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class all 
{
  protected static String nl;
  public static synchronized all create(String lineSeparator)
  {
    nl = lineSeparator;
    all result = new all();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "-----" + NL;
  protected final String TEXT_2 = NL;

	public all()
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

    orchestration(ctx);
    if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();}
    
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();

    {
final Map<String, Object> parameters = new HashMap<String, Object>();
ExecutionContext ctx__jj_AF3LEd1EutVAbEdBQ = new ExecutionContext(ictx);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_fW0RcF3DEd-W5eBkkAoHaA", ctx__jj_AF3LEd1EutVAbEdBQ, parameters);
}

    
method_separator(ictx.getBuffer(), ictx);
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
ExecutionContext ctx__jj_AV3LEd1EutVAbEdBQ = new ExecutionContext(ictx);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_s8JesF3DEd-W5eBkkAoHaA", ctx__jj_AV3LEd1EutVAbEdBQ, parameters);
}

    
method_separator(ictx.getBuffer(), ictx);
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
ExecutionContext ctx__jj_Al3LEd1EutVAbEdBQ = new ExecutionContext(ictx);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_5P020F3DEd-W5eBkkAoHaA", ctx__jj_Al3LEd1EutVAbEdBQ, parameters);
}

    
method_separator(ictx.getBuffer(), ictx);
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
ExecutionContext ctx__jj_A13LEd1EutVAbEdBQ = new ExecutionContext(ictx);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.core.test.pattern/fc/linefeed.fcore#_DAhtIF3KEd-mZb1ihLU3ug", ctx__jj_A13LEd1EutVAbEdBQ, parameters);
}

    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    ictx.clearBuffer();}
return loop;
} 

public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
return parameters; }

    protected void method_separator(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    }