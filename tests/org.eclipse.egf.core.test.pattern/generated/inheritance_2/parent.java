package inheritance_2;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class parent 
{
  protected static String nl;
  public static synchronized parent create(String lineSeparator)
  {
    nl = lineSeparator;
    parent result = new parent();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "fromParent";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

	public parent()
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

    orchestration(ctx);
    if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearLoopBuffers();}
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0;

    
method_setVariables(ictx.getBuffer(), ictx);
    
method_body(ictx.getBuffer(), ictx);
    
method_putVariablesInContesxt(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
return loop;
} 

protected java.lang.String targetFile = null;

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    protected void method_setVariables(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    targetFile = null;
    }
    protected void method_putVariablesInContesxt(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    ctx.setValue("targetFile", targetFile);
    }
    }