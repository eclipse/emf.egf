package egf.uc1_2.helloWorld;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class HelloWorld extends egf.uc1_2.helloWorld.parent.Hello {
  protected static String nl;
  public static synchronized HelloWorld create(String lineSeparator)
  {
    nl = lineSeparator;
    HelloWorld result = new HelloWorld();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "Hello";
  protected final String TEXT_2 = " ";
  protected final String TEXT_3 = "!";
  protected final String TEXT_4 = NL;

	public HelloWorld()
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

    
List<Object> aClassList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object aClassParameter : aClassList ) {


    generate(ctx, aClassParameter);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getBuffer().toString(), ctx);
    ctx.getBuffer().setLength(0);
}
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object aClassParameter) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EClass aClass = (org.eclipse.emf.ecore.EClass)aClassParameter;
parameterValues.put("aClass", aClassParameter);

    
method_SayHello(ictx.getBuffer(), ictx);

    
method_body(ictx.getBuffer(), ictx, aClass);

    org.eclipse.emf.ecore.EClass element__AfpkEAzyEdsdvrVfWaxAw = aClass;
ExecutionContext ctx__5Vg2sRrpEdBBaGEtjBhQQ = new ExecutionContext(ictx);
CallHelper.executeWithInjection("_7-a0kAzxEd-sdvrVfWaxAw", ctx__5Vg2sRrpEdBBaGEtjBhQQ, element__AfpkEAzyEdsdvrVfWaxAw);
    
method_finish(ictx.getBuffer(), ictx);

    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
ictx.getBuffer().setLength(0);}
return loop;
} 

protected org.eclipse.emf.ecore.EClass currentClass = null;

    protected void method_SayHello(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    
    protected void method_body(StringBuilder stringBuffer, PatternContext ctx, org.eclipse.emf.ecore.EClass aClass)throws Exception {

    stringBuffer.append(TEXT_2);
    stringBuffer.append( aClass.getName() );
    }
    
    protected void method_finish(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_3);
    }
    }