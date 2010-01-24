package myLib;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class attributePattern 
{
  protected static String nl;
  public static synchronized attributePattern create(String lineSeparator)
  {
    nl = lineSeparator;
    attributePattern result = new attributePattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	public attributePattern()
	{
	//Here is the constructor
StringBuffer stringBuffer = new StringBuffer();

    // add initialisation of the pattern variables (declaration has been already done).
    
	}
  	
  	public String generate(Object argument) throws Exception
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    PatternContext ctx = (PatternContext)argument;
StringBuilder collector = new StringBuilder(2000);
Map<String, String> queryCtx = null;
IQuery.ParameterDescription paramDesc = null;

    


List<Object> parameterList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object parameterParameter : parameterList ) {


    collector.append(generate(ctx, parameterParameter));
    
}
ctx.getReporter().executionFinished(collector.toString(), ctx);

    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object parameterParameter) throws Exception  {
final StringBuffer stringBuffer = new StringBuffer();
PatternCallReporter callReporter =  new PatternCallReporter(stringBuffer);

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EAttribute parameter = (org.eclipse.emf.ecore.EAttribute)parameterParameter;
parameterValues.put("parameter", parameterParameter);

    stringBuffer.append("attribute "+parameter.getName());
    CallHelper.callBack(ctx, parameter);

    
String loop = stringBuffer.toString();
ctx.getReporter().loopFinished(loop, ctx, parameterValues);
return loop;
} 

}