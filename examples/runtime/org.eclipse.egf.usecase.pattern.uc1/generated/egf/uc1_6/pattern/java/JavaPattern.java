package egf.uc1_6.pattern.java;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.core.EGFCorePlugin;

public class JavaPattern {

	public JavaPattern() {
		//Here is the constructor
// add initialisation of the pattern variables (declaration has been already done).
	}



public void generate (Object argument) throws Exception {
InternalPatternContext ctx = (InternalPatternContext)argument;
IQuery.ParameterDescription paramDesc = null;
Map<String, String> queryCtx = null;
List<Object> aClassList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object aClassParameter : aClassList ) {

generate((PatternContext)argument, aClassParameter);
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getBuffer().toString(), ctx);
    ctx.getBuffer().setLength(0);}
}

public String generate(PatternContext ctx, Object aClassParameter) throws Exception {
InternalPatternContext ictx = (InternalPatternContext)ctx;
Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EClass aClass = (org.eclipse.emf.ecore.EClass)aClassParameter;
parameterValues.put("aClass", aClassParameter);

method_body(ictx.getBuffer(), ictx, aClass);

String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
ictx.getBuffer().setLength(0);}
return loop;
}

protected void method_body(final StringBuffer out, final PatternContext ctx, final org.eclipse.emf.ecore.EClass aClass)throws Exception 
{

	  // Message on the default console
	  System.out.println("Java: " + aClass.getName()); //$NON-NLS-1$

	  // Message on the EGF console
	  EGFCorePlugin.getDefault().logInfo("Java: " + aClass.getName());

}

}
