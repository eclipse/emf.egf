package substitution3.base;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;


public class myPattern {

	public myPattern() {
		//Here is the constructor
// add initialisation of the pattern variables (declaration has been already done).
	}



public void generate (Object argument) throws Exception {
InternalPatternContext ctx = (InternalPatternContext)argument;
IQuery.ParameterDescription paramDesc = null;
Map<String, String> queryCtx = null;
orchestration((PatternContext)argument);
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();}
}

public String orchestration(PatternContext ctx) throws Exception {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();

String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    ictx.clearBuffer();}
return loop;
}

protected void method_body(final StringBuffer out, final PatternContext ctx)throws Exception 
{
//default content

}

}
