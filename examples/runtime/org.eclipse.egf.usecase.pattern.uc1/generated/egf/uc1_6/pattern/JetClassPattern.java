package egf.uc1_6.pattern;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class JetClassPattern 
{
  protected static String nl;
  public static synchronized JetClassPattern create(String lineSeparator)
  {
    nl = lineSeparator;
    JetClassPattern result = new JetClassPattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "- Jet: ";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

	public JetClassPattern()
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

    
List<Object> aClassList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object aClassParameter : aClassList ) {

this.aClass = (org.eclipse.emf.ecore.EClass)aClassParameter;


    orchestration(ctx);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0, executionIndex = ictx.getExecutionBuffer().length();

    
    
method_body(ictx.getBuffer(), ictx);
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("aClass", this.aClass);
ExecutionContext ctx__we1hQC2EdCRPSkD_BdCg = new ExecutionContext(ictx);
CallHelper.executeWithInjection("_iXOsIBrgEd-cXtp4jDfJVg", ctx__we1hQC2EdCRPSkD_BdCg, parameters);
}

    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(index));
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("aClass", this.aClass);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 

protected org.eclipse.emf.ecore.EClass aClass = null;
public void set_aClass(org.eclipse.emf.ecore.EClass object) {
this.aClass = object;
}

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append( aClass.getName () );
    }
    }