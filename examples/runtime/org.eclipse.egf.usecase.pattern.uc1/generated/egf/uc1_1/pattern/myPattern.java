package egf.uc1_1.pattern;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class myPattern 
{
  protected static String nl;
  public static synchronized myPattern create(String lineSeparator)
  {
    nl = lineSeparator;
    myPattern result = new myPattern();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "  - ";
  protected final String TEXT_2 = " attribute";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;

	public myPattern()
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

    
List<Object> anAttributeList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object anAttributeParameter : anAttributeList ) {


    generate(ctx, anAttributeParameter);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getBuffer().toString(), ctx);
    ctx.getBuffer().setLength(0);
}
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object anAttributeParameter) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EAttribute anAttribute = (org.eclipse.emf.ecore.EAttribute)anAttributeParameter;
parameterValues.put("anAttribute", anAttributeParameter);

    
method_body(ictx.getBuffer(), ictx, anAttribute);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
ictx.getBuffer().setLength(0);}
return loop;
} 


    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx, final org.eclipse.emf.ecore.EAttribute anAttribute)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append( anAttribute.getName() );
    stringBuffer.append(TEXT_2);
    }
    }