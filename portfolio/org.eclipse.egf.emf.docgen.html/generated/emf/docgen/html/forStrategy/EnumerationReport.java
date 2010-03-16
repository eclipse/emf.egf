package emf.docgen.html.forStrategy;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.emf.docgen.html.util.*;

public class EnumerationReport extends emf.docgen.html.EEnumDocGen {
  protected static String nl;
  public static synchronized EnumerationReport create(String lineSeparator)
  {
    nl = lineSeparator;
    EnumerationReport result = new EnumerationReport();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//default content";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;

	public EnumerationReport()
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


    generate(ctx, elementParameter);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getBuffer().toString(), ctx);
    ctx.getBuffer().setLength(0);
}
    
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object elementParameter) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EEnum element = (org.eclipse.emf.ecore.EEnum)elementParameter;
parameterValues.put("element", elementParameter);

    
method_setVariable(ictx.getBuffer(), ictx, element);
    
method_setSpecificVariables(ictx.getBuffer(), ictx);
    
method_fileHeader(ictx.getBuffer(), ictx);
    
method_writeEEnumLiteral(ictx.getBuffer(), ictx);
    
method_writeEPackageReference(ictx.getBuffer(), ictx);
    
method_fileFooter(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
ictx.getBuffer().setLength(0);}
return loop;
} 


    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx, final org.eclipse.emf.ecore.EEnum element)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    protected void method_setVariable(final StringBuffer stringBuffer, final PatternContext ctx, final org.eclipse.emf.ecore.EEnum element)throws Exception {

    
	// Set Object variables
	_Title = element.getName() + " Enumeration";

	// Set EObject variables
	_element = element;

    }
    }