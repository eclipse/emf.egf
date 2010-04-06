package emf.docgen.html.forStrategy;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.emf.docgen.html.util.*;

public class DataTypeReport extends emf.docgen.html.EDataTypeDocGen {
  protected static String nl;
  public static synchronized DataTypeReport create(String lineSeparator)
  {
    nl = lineSeparator;
    DataTypeReport result = new DataTypeReport();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//default content";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

	public DataTypeReport()
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

    
List<Object> elementList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object elementParameter : elementList ) {

this.element = (org.eclipse.emf.ecore.EDataType)elementParameter;


    orchestration(ctx);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0, executionIndex = ictx.getExecutionBuffer().length();

    
method_setVariable(ictx.getBuffer(), ictx);
    
method_setSpecificVariables(ictx.getBuffer(), ictx);
    
method_fileHeader(ictx.getBuffer(), ictx);
    
method_writeEPackageReference(ictx.getBuffer(), ictx);
    
method_fileFooter(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(index));
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("element", this.element);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 

protected org.eclipse.emf.ecore.EDataType element = null;
public void set_element(org.eclipse.emf.ecore.EDataType object) {
this.element = object;
}

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    protected void method_setVariable(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
	// Set Object variables
	_Title = element.getName() + " Package";

	// Set EObject variables
	_element = element;

    }
    }