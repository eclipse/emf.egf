package egf.uc1_4.pattern;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.usecase.pattern.uc1.helper.*;

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
  protected final String TEXT_1 = "//default content";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "[Begin. ";
  protected final String TEXT_4 = "]" + NL;
  protected final String TEXT_5 = "\t=> ";
  protected final String TEXT_6 = " attribute(s)" + NL + "[End. ";
  protected final String TEXT_7 = "]" + NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL;

	public ClassPattern()
	{
	//Here is the constructor
StringBuffer stringBuffer = new StringBuffer();

    
	_separator = "'";

    
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
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();

    
method_before(ictx.getBuffer(), ictx);
    {
ictx.setExecutionCurrentIndex(ictx.getBuffer().length());
ictx.getExecutionBuffer().append(ictx.getBuffer());
final Map<String, Object> parameters = getParameters();
CallbackContext ctx_callback = new CallbackContext(ictx);
CallHelper.callBack(ctx_callback, parameters);
}

    
method_after(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 

protected java.lang.String _separator = null;
public void set__separator(java.lang.String object) {
this._separator = object;
}
protected org.eclipse.emf.ecore.EClass parameter = null;
public void set_parameter(org.eclipse.emf.ecore.EClass object) {
this.parameter = object;
}
public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("parameter", this.parameter);
return parameters; }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    protected void method_before(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_2);
     MyHelper.resetCounter (ctx); 
    stringBuffer.append(TEXT_3);
    stringBuffer.append( _separator );
    stringBuffer.append(parameter.getName());
    stringBuffer.append( _separator );
    stringBuffer.append(TEXT_4);
    }
    protected void method_after(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_5);
    stringBuffer.append( MyHelper.getCounter (ctx) );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( _separator );
    stringBuffer.append(parameter.getName());
    stringBuffer.append( _separator );
    stringBuffer.append(TEXT_7);
    }
    }