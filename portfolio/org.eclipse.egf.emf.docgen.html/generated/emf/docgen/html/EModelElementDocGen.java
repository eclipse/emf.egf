package emf.docgen.html;

import org.eclipse.egf.emf.docgen.html.util.*;
import org.eclipse.emf.common.util.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class EModelElementDocGen extends emf.docgen.html.EObjectDocGen {
  protected static String nl;
  public static synchronized EModelElementDocGen create(String lineSeparator)
  {
    nl = lineSeparator;
    EModelElementDocGen result = new EModelElementDocGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "//default content";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t<p>";
  protected final String TEXT_4 = "</p>";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL;

	public EModelElementDocGen()
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
    
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0, executionIndex = ictx.getExecutionBuffer().length();

    
method_body(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
return loop;
} 


    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    }
    protected void method_writeEAnnotations(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
String result = new String();

for (EAnnotation annotation : ((EModelElement) _element).getEAnnotations()) {

	if (annotation.getSource() == "http://www.eclipse.org/emf/2002/GenModel"
		|| annotation.getSource() == "http://www.eclipse.org/egf/2010/GenDoc") {
		for (Map.Entry<String, String> detail : annotation.getDetails().entrySet()) {
			if (detail.getKey()== "documentation" && detail.getValue() != "") {
				result = result + detail.getValue();
			}
		}
	}
}

    stringBuffer.append(TEXT_2);
    	if (result.length() > 0) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append( result );
    stringBuffer.append(TEXT_4);
     } // end if 
    }
    }