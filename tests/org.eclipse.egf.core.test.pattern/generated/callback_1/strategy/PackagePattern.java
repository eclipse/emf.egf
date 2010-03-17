package callback_1.strategy;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class PackagePattern 
{
  protected static String nl;
  public static synchronized PackagePattern create(String lineSeparator)
  {
    nl = lineSeparator;
    PackagePattern result = new PackagePattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "[Package ";
  protected final String TEXT_2 = "]" + NL;
  protected final String TEXT_3 = "[End Package]" + NL + NL + NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;

	public PackagePattern()
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

    
List<Object> parameterList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object parameterParameter : parameterList ) {

this.parameter = (org.eclipse.emf.ecore.EPackage)parameterParameter;


    orchestration(ctx);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearLoopBuffers();
}
    
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0;

    
method_before(ictx.getBuffer(), ictx);
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
index = ictx.getBuffer().length();
ictx.getExecutionBuffer().append(ictx.getBuffer());
parameters.put("parameter", this.parameter);
CallbackContext ctx_callback = new CallbackContext(ictx);
CallHelper.callBack(ctx_callback, parameters);
ictx.getExecutionBuffer().append(ctx_callback.getBuffer());
}

    
method_after(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(index));
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
    ictx.clearLoopBuffers();}
return loop;
} 

protected org.eclipse.emf.ecore.EPackage parameter = null;
public void set_parameter(org.eclipse.emf.ecore.EPackage object) {
this.parameter = object;
}

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    }
    protected void method_before(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_2);
    }
    protected void method_after(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_3);
    }
    }