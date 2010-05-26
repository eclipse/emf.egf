package pattern.call1;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class Caller 
{
  protected static String nl;
  public static synchronized Caller create(String lineSeparator)
  {
    nl = lineSeparator;
    Caller result = new Caller();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Message from caller";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

	public Caller()
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
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();

    
method_body(ictx.getBuffer(), ictx);
    ExecutionContext ctx__FAS3oFhHEd7_ZgNDDfr_g = new ExecutionContext(ictx);
ctx__FAS3oFhHEd7_ZgNDDfr_g.setValue(PatternContext.INJECTED_CONTEXT, variable);
CallHelper.execute("_F9NFkFa3Ed-upsLSxDR5IA", ctx__FAS3oFhHEd7_ZgNDDfr_g);


    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    ictx.clearBuffer();}
return loop;
} 

protected org.eclipse.emf.ecore.EClass variable = null;
public void set_variable(org.eclipse.emf.ecore.EClass object) {
this.variable = object;
}
public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
return parameters; }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    }