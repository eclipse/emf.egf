package inheritance_2;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class child extends inheritance_2.parent {
  protected static String nl;
  public static synchronized child create(String lineSeparator)
  {
    nl = lineSeparator;
    child result = new child();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "fromChild : ";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

	public child()
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

this.parameter = (org.eclipse.emf.ecore.EClass)parameterParameter;


    orchestration(ctx);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearLoopBuffers();
}
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0;

    super.orchestration(new SuperOrchestrationContext(ictx));

    
method_setToInject(ictx.getBuffer(), ictx);
    ExecutionContext ctx__hscqUCUTEdQdzPvNxSFg = new ExecutionContext(ictx);
ctx__hscqUCUTEdQdzPvNxSFg.setValue(PatternContext.INJECTED_CONTEXT, toInject);
CallHelper.execute("_nfk5LCH-Ed-CStHKuCL0dg", ctx__hscqUCUTEdQdzPvNxSFg);


    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(index));
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
    ictx.clearLoopBuffers();}
return loop;
} 

protected org.eclipse.emf.ecore.EClass toInject = null;
protected org.eclipse.emf.ecore.EClass parameter = null;
public void set_parameter(org.eclipse.emf.ecore.EClass object) {
this.parameter = object;
}

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(parameter.getName());
    }
    protected void method_setToInject(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    toInject = parameter;
    }
    protected void method_setVariables(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    targetFile = "/org.eclipse.egf.core.test.pattern/result/" + parameter.getName();
    }
    }