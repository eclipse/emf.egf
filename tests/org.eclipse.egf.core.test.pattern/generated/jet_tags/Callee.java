package jet_tags;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;


public class Callee {

	public Callee() {
		//Here is the constructor
// add initialisation of the pattern variables (declaration has been already done).
	}



public void generate (Object argument) throws Exception {
InternalPatternContext ctx = (InternalPatternContext)argument;
IQuery.ParameterDescription paramDesc = null;
Map<String, String> queryCtx = null;
List<Object> parameterList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> parameter2List = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object parameterParameter : parameterList ) {
for (Object parameter2Parameter : parameter2List ) {

this.parameter = (java.lang.Object)parameterParameter;
this.parameter2 = (java.lang.Object)parameter2Parameter;

orchestration((PatternContext)argument);
}
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();}
}

public String orchestration(PatternContext ctx) throws Exception {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();
method_body(ictx.getBuffer(), ictx);

String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
Map<String, Object> parameterValues = new HashMap<String, Object>();
parameterValues.put("parameter", this.parameter);
parameterValues.put("parameter2", this.parameter2);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
}

protected void method_body(final StringBuffer out, final PatternContext ctx)throws Exception 
{
out.append("Callee : ");

out.append("parameter=");
if (parameter != null)
	out.append(parameter.toString());

out.append(", parameter2=");
if (parameter2 != null)
	out.append(parameter2.toString());

out.append("\n");

}

protected java.lang.Object parameter;

public void set_parameter(java.lang.Object parameter) {
  this.parameter = parameter;
}

protected java.lang.Object parameter2;

public void set_parameter2(java.lang.Object parameter2) {
  this.parameter2 = parameter2;
}

}