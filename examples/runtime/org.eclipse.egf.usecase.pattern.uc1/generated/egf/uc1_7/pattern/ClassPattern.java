package egf.uc1_7.pattern;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ClassPattern 
{
  protected static String nl;
  public static synchronized ClassPattern create(String lineSeparator)
  {
    nl = lineSeparator;
    ClassPattern result = new ClassPattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL;
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = " contains:";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;

	public ClassPattern()
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
    ctx.getReporter().executionFinished(ctx.getBuffer().toString(), ctx);
    ctx.getBuffer().setLength(0);
}
    
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

    
method_body(ictx.getBuffer(), ictx);
    
method_setupVariable(ictx.getBuffer(), ictx);
    ExecutionContext ctx___7b5cB1oEdwnbXYpQsM5g = new ExecutionContext(ictx);
ctx___7b5cB1oEdwnbXYpQsM5g.setValue(PatternContext.INJECTED_CONTEXT, variable);
CallHelper.execute("_RdSMYBViEd-JoY-b5_Vpcw", ctx___7b5cB1oEdwnbXYpQsM5g);


    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
    ictx.getBuffer().setLength(0);}
return loop;
} 

protected org.eclipse.emf.ecore.EClass variable = null;
protected org.eclipse.emf.ecore.EClass parameter = null;
public void set_parameter(org.eclipse.emf.ecore.EClass object) {
this.parameter = object;
}

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_3);
    }
    protected void method_setupVariable(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    variable = parameter;
    }
    }