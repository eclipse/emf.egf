package myLib;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class packagePattern 
{
  protected static String nl;
  public static synchronized packagePattern create(String lineSeparator)
  {
    nl = lineSeparator;
    packagePattern result = new packagePattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL;
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

	public packagePattern()
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
    ctx.getReporter().executionFinished(ctx.getBuffer().toString(), ctx);
    ctx.getBuffer().setLength(0);
}
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

    
method_body(ictx.getBuffer(), ictx);
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("parameter", this.parameter);
CallHelper.callBack(new CallbackContext(ictx), parameters);
}

    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
    ictx.getBuffer().setLength(0);}
return loop;
} 

protected org.eclipse.emf.ecore.EPackage parameter = null;
public void set_parameter(org.eclipse.emf.ecore.EPackage object) {
this.parameter = object;
}

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append("package "+parameter.getName());
    stringBuffer.append(TEXT_1);
    }
    }