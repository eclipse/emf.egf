package egf.uc1_4.helloWorld.forInjection;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class ForInjectionPattern 
{
  protected static String nl;
  public static synchronized ForInjectionPattern create(String lineSeparator)
  {
    nl = lineSeparator;
    ForInjectionPattern result = new ForInjectionPattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "    - \"";
  protected final String TEXT_2 = "\" ";
  protected final String TEXT_3 = NL;

	public ForInjectionPattern()
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

    
paramDesc = new IQuery.ParameterDescription("parameter", "http://www.eclipse.org/emf/2002/Ecore#//ENamedElement");
queryCtx = new HashMap<String, String>();
List<Object> parameterList = QueryHelper.load(ctx, "org.eclipse.egf.usecase.pattern.uc1.query1").execute(paramDesc, queryCtx, ctx);


for (Object parameterParameter : parameterList ) {


    generate(ctx, parameterParameter);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getBuffer().toString(), ctx);
    ctx.getBuffer().setLength(0);
}
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object parameterParameter) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.ENamedElement parameter = (org.eclipse.emf.ecore.ENamedElement)parameterParameter;
parameterValues.put("parameter", parameterParameter);

    
method_body(ictx.getBuffer(), ictx, parameter);

    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
ictx.getBuffer().setLength(0);}
return loop;
} 


    protected void method_body(StringBuilder stringBuffer, PatternContext ctx, org.eclipse.emf.ecore.ENamedElement parameter)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(parameter.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(parameter.getClass().getSimpleName());
    }
    }