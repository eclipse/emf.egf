package emf.docgen.html.forStrategy;

import java.util.*;
import java.util.Map.Entry;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.common.util.EList;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.emf.docgen.html.util.*;

public class ClassReport extends emf.docgen.html.EClassDocGen {
  protected static String nl;
  public static synchronized ClassReport create(String lineSeparator)
  {
    nl = lineSeparator;
    ClassReport result = new ClassReport();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">" + NL + "<html>" + NL + "<head>" + NL + "<title>";
  protected final String TEXT_2 = "</title>" + NL + "</HEAD>" + NL + "" + NL + "<BODY BGCOLOR=\"#ffffff\">" + NL + "" + NL + "<h1 class=\"Head\">";
  protected final String TEXT_3 = "</h1>";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "\t<p>";
  protected final String TEXT_6 = "</p>";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + "\t<p>SuperClasses:" + NL + "\t";
  protected final String TEXT_9 = NL + "\t\t<a href=\"";
  protected final String TEXT_10 = "\">";
  protected final String TEXT_11 = "</a>" + NL + "\t";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "\t<h2>Attributes</h2>" + NL + "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL + "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Bounds</th>" + NL + "\t\t\t<th>Type</th>" + NL + "\t\t\t<th>Changeable</th>" + NL + "\t\t\t<th>Volatile</th>" + NL + "\t\t\t<th>Transient</th>" + NL + "\t\t\t<th>Derived</th>" + NL + "\t\t\t<th>Ordered</th>" + NL + "\t\t\t<th>Unique</th>" + NL + "\t\t</tr>" + NL + "\t";
  protected final String TEXT_14 = NL + "\t\t<tr>" + NL + "   \t\t\t<td align=left><b>";
  protected final String TEXT_15 = "</b></td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_16 = "  </td>" + NL + "   \t\t\t<td align=left>";
  protected final String TEXT_17 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_18 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_19 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_20 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_21 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_22 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_23 = "</td>" + NL + "   \t\t</tr>" + NL + "\t";
  protected final String TEXT_24 = NL + "\t</table>";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "\t<h2>References</h2>" + NL + "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL + "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Bounds</th>" + NL + "\t\t\t<th>Type</th>" + NL + "\t\t\t<th>Containment</th>" + NL + "\t\t\t<th>Changeable</th>" + NL + "\t\t\t<th>Derived</th>" + NL + "\t\t\t<th>Required</th>" + NL + "\t\t\t<th>Ordered</th>" + NL + "\t\t\t<th>Unique</th>" + NL + "\t\t</tr>" + NL + "\t";
  protected final String TEXT_27 = NL + "\t\t<tr>" + NL + "\t   \t\t<td align=left><b>";
  protected final String TEXT_28 = "</b></td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_29 = "</td>" + NL + "   \t\t\t<td align=left>";
  protected final String TEXT_30 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_31 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_32 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_33 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_34 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_35 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_36 = "</td>" + NL + "   \t\t</tr>" + NL + "\t";
  protected final String TEXT_37 = NL + "\t</table>";
  protected final String TEXT_38 = NL;
  protected final String TEXT_39 = NL + "\t<h2>Operations</h2>" + NL + "\t\t<table border=1 cellspacing=\"0\" width=\"100%\">" + NL + "\t\t<tr>" + NL + "\t\t\t<th align=left>Name</th>" + NL + "\t\t\t<th>Bounds</th>" + NL + "\t\t\t<th>Return</th>" + NL + "\t\t\t<th>Parameter(s)</th>" + NL + "\t\t\t<th>Required</th>" + NL + "\t\t\t<th>Ordered</th>" + NL + "\t\t\t<th>Unique</th>" + NL + "\t\t</tr>" + NL + "\t";
  protected final String TEXT_40 = NL + "\t\t<tr>" + NL + "   \t\t\t<td align=left><b>";
  protected final String TEXT_41 = "</b></td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_42 = "</td>" + NL + "   \t\t\t<td align=center>" + NL + "   \t\t\t\t";
  protected final String TEXT_43 = NL + "   \t\t\t\t";
  protected final String TEXT_44 = NL + "   \t\t\t\t";
  protected final String TEXT_45 = NL + "   \t\t\t\t";
  protected final String TEXT_46 = NL + "   \t\t\t\t";
  protected final String TEXT_47 = NL + "   \t\t\t</td>" + NL + "\t\t\t<td align=left>" + NL + "\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t<p>";
  protected final String TEXT_49 = " - ";
  protected final String TEXT_50 = "</p>" + NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_52 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_53 = "</td>" + NL + "   \t\t\t<td align=center>";
  protected final String TEXT_54 = "</td>" + NL + "" + NL + "   \t\t</tr>" + NL + "" + NL + "" + NL + "\t";
  protected final String TEXT_55 = NL + "\t</table>";
  protected final String TEXT_56 = NL + "<p><i>back to </i> <a href=\"";
  protected final String TEXT_57 = "\">";
  protected final String TEXT_58 = "</a> </p>";
  protected final String TEXT_59 = "\t<br/>" + NL + "\t<p><i>";
  protected final String TEXT_60 = "</i></p>" + NL + "</body>" + NL + "</html>";
  protected final String TEXT_61 = NL;

	public ClassReport()
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
    stringBuffer.append(TEXT_61);
    return stringBuffer.toString();
  }
public String generate(PatternContext ctx, Object elementParameter) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;

Map<String, Object> parameterValues = new HashMap<String, Object>();
org.eclipse.emf.ecore.EClass element = (org.eclipse.emf.ecore.EClass)elementParameter;
parameterValues.put("element", elementParameter);

    
method_setVariable(ictx.getBuffer(), ictx, element);

    
method_setSpecificVariables(ictx.getBuffer(), ictx);

    
method_fileHeader(ictx.getBuffer(), ictx);

    
method_writeEAnnotations(ictx.getBuffer(), ictx);

    
method_writeSuperTypes(ictx.getBuffer(), ictx);

    
method_writeEAttributes(ictx.getBuffer(), ictx);

    
method_writeEReferences(ictx.getBuffer(), ictx);

    
method_writeEOperations(ictx.getBuffer(), ictx);

    
method_writeEPackageReference(ictx.getBuffer(), ictx);

    
method_fileFooter(ictx.getBuffer(), ictx);

    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getReporter().loopFinished(loop, ictx, parameterValues);
ictx.getBuffer().setLength(0);}
return loop;
} 


    protected void method_setVariable(StringBuilder stringBuffer, PatternContext ctx, org.eclipse.emf.ecore.EClass element)throws Exception {

    
	// Set Object variables
	_Title = element.getName() + " Class";

	// Set EObject variables
	_element = element;

    }
    
    protected void method_setSpecificVariables(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    
	_copyright = "";

    }
    
    protected void method_fileHeader(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append( _Title );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( _Title );
    stringBuffer.append(TEXT_3);
    }
    
    protected void method_writeEAnnotations(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    
String result = new String();

for (EAnnotation annotation : ((EModelElement) _element).getEAnnotations()) {

	if (annotation.getSource() == "http://www.eclipse.org/emf/2002/GenModel"
		|| annotation.getSource() == "http://www.eclipse.org/egf/2010/GenDoc") {
		for (Entry<String, String> detail : annotation.getDetails().entrySet()) {
			if (detail.getKey()== "documentation" && detail.getValue() != "") {
				result = result + detail.getValue();
			}
		}
	}
}

    stringBuffer.append(TEXT_4);
    	if (result.length() > 0) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append( result );
    stringBuffer.append(TEXT_6);
     } // end if 
    }
    
    protected void method_writeSuperTypes(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EList<EClass> superTypes = ((EClass) _element).getESuperTypes();
    stringBuffer.append(TEXT_7);
     if (superTypes.size() > 0) { 
    stringBuffer.append(TEXT_8);
     for (EClass _SuperEClass : superTypes) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(_SuperEClass));
    stringBuffer.append(TEXT_10);
    stringBuffer.append( EmfHtmlDocGen.getName(_SuperEClass));
    stringBuffer.append(TEXT_11);
    } // end for
     } // end if 
    }
    
    protected void method_writeEAttributes(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EList<EAttribute> attributes = ((EClass) _element).getEAllAttributes();
    stringBuffer.append(TEXT_12);
     if (attributes.size() > 0) { 
    stringBuffer.append(TEXT_13);
     for (EAttribute _EAttribute : attributes) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append( EmfHtmlDocGen.getName(_EAttribute) );
    stringBuffer.append(TEXT_15);
    stringBuffer.append( EmfHtmlDocGen.getBounds(_EAttribute) );
    stringBuffer.append(TEXT_16);
    stringBuffer.append( EmfHtmlDocGen.getName(_EAttribute.getEAttributeType()) );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( _EAttribute.isChangeable() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( _EAttribute.isVolatile() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append( _EAttribute.isTransient() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( _EAttribute.isDerived() );
    stringBuffer.append(TEXT_21);
    stringBuffer.append( _EAttribute.isOrdered() );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( _EAttribute.isUnique() );
    stringBuffer.append(TEXT_23);
    } // end for
    stringBuffer.append(TEXT_24);
     } // end if 
    }
    
    protected void method_writeEReferences(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EList<EReference> references = ((EClass) _element).getEAllReferences();
    stringBuffer.append(TEXT_25);
     if (references.size() > 0) { 
    stringBuffer.append(TEXT_26);
     for (EReference _EReference : references) { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append( EmfHtmlDocGen.getName(_EReference) );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( EmfHtmlDocGen.getBounds(_EReference) );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( EmfHtmlDocGen.getName(_EReference.getEReferenceType()) );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( _EReference.isContainment() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( _EReference.isChangeable() );
    stringBuffer.append(TEXT_32);
    stringBuffer.append( _EReference.isDerived() );
    stringBuffer.append(TEXT_33);
    stringBuffer.append( _EReference.isRequired() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append( _EReference.isOrdered() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append( _EReference.isUnique() );
    stringBuffer.append(TEXT_36);
    } // end for
    stringBuffer.append(TEXT_37);
     } // end if 
    }
    
    protected void method_writeEOperations(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EList<EOperation> operations = ((EClass) _element).getEAllOperations();
    stringBuffer.append(TEXT_38);
     if (operations.size() > 0) { 
    stringBuffer.append(TEXT_39);
     for (EOperation _EOperation : operations) { 
    stringBuffer.append(TEXT_40);
    stringBuffer.append( EmfHtmlDocGen.getName(_EOperation) );
    stringBuffer.append(TEXT_41);
    stringBuffer.append( EmfHtmlDocGen.getBounds(_EOperation) );
    stringBuffer.append(TEXT_42);
     if (_EOperation.getEType() != null) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append( _EOperation.getEType().getName() );
    stringBuffer.append(TEXT_44);
     }
   				   else {
    stringBuffer.append(TEXT_45);
    stringBuffer.append( "-");
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
     for (EParameter _EParameter : _EOperation.getEParameters()) { 
    stringBuffer.append(TEXT_48);
    stringBuffer.append( EmfHtmlDocGen.getName(_EParameter) );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( EmfHtmlDocGen.getName(_EParameter.getEType()) );
    stringBuffer.append(TEXT_50);
    } // end for
    stringBuffer.append(TEXT_51);
    stringBuffer.append( _EOperation.isRequired() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append( _EOperation.isOrdered() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( _EOperation.isUnique() );
    stringBuffer.append(TEXT_54);
    } // end for
    stringBuffer.append(TEXT_55);
     } // end if 
    }
    
    protected void method_writeEPackageReference(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

     EPackage pOwner = ((EClassifier) _element).getEPackage(); 
    stringBuffer.append(TEXT_56);
    stringBuffer.append( EmfHtmlDocGen.getHtmlFileName(pOwner));
    stringBuffer.append(TEXT_57);
    stringBuffer.append( EmfHtmlDocGen.getName(pOwner) );
    stringBuffer.append(TEXT_58);
    }
    
    protected void method_fileFooter(StringBuilder stringBuffer, PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(_copyright);
    stringBuffer.append(TEXT_60);
    }
    }