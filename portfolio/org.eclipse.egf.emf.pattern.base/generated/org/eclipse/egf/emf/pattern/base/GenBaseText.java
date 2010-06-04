package org.eclipse.egf.emf.pattern.base;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class GenBaseText extends org.eclipse.egf.emf.pattern.base.GenAbstract {
  protected static String nl;
  public static synchronized GenBaseText create(String lineSeparator)
  {
    nl = lineSeparator;
    GenBaseText result = new GenBaseText();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

	public GenBaseText()
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
    ctx.clearBuffer();}
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();

    super.orchestration(new SuperOrchestrationContext(ictx));

    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    ictx.clearBuffer();}
return loop;
} 

protected java.lang.String targetPathName = null;
public void set_targetPathName(java.lang.String object) {
this.targetPathName = object;
}
protected java.lang.Boolean overwrite = null;
public void set_overwrite(java.lang.Boolean object) {
this.overwrite = object;
}
protected java.lang.String encoding = null;
public void set_encoding(java.lang.String object) {
this.encoding = object;
}
public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
return parameters; }

    protected void method_putReporterVariablesInContext(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
ctx.setValue("targetPathName", targetPathName);
ctx.setValue("overwrite", overwrite);
ctx.setValue("encoding", encoding);

    }
    protected void method_putContentTypeInContext(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
ctx.setValue("contentType", ContentType.Text);

    }
    }