package inheritance_1;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class child extends inheritance_1.parent {
  protected static String nl;
  public static synchronized child create(String lineSeparator)
  {
    nl = lineSeparator;
    child result = new child();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "childContent";
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

    
paramDesc = new IQuery.ParameterDescription("parameter", "http://www.eclipse.org/emf/2002/Ecore#//EClass");
queryCtx = new HashMap<String, String>();
List<Object> parameterList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);


for (Object parameterParameter : parameterList ) {

this.parameter = (org.eclipse.emf.ecore.EClass)parameterParameter;


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

    ExecutionContext ctx__LmLAByOEd4jqDvptqaWA = new ExecutionContext(ictx);
super.orchestration(ctx__LmLAByOEd4jqDvptqaWA);

    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
    ictx.getBuffer().setLength(0);}
return loop;
} 

protected org.eclipse.emf.ecore.EClass parameter = null;
public void set_parameter(org.eclipse.emf.ecore.EClass object) {
this.parameter = object;
}

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    }