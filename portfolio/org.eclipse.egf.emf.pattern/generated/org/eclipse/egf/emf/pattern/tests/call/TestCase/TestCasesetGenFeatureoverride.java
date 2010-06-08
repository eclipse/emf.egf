package org.eclipse.egf.emf.pattern.tests.call.TestCase;

import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.ecore.genmodel.impl.*;
import org.eclipse.emf.codegen.ecore.genmodel.generator.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class TestCasesetGenFeatureoverride 
{
  protected static String nl;
  public static synchronized TestCasesetGenFeatureoverride create(String lineSeparator)
  {
    nl = lineSeparator;
    TestCasesetGenFeatureoverride result = new TestCasesetGenFeatureoverride();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t/**" + NL + "\t * Tests the '{@link ";
  protected final String TEXT_2 = "#set";
  protected final String TEXT_3 = "(";
  protected final String TEXT_4 = ") <em>";
  protected final String TEXT_5 = "</em>}' feature setter." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see ";
  protected final String TEXT_6 = "#set";
  protected final String TEXT_7 = "(";
  protected final String TEXT_8 = ")" + NL + "\t * @generated" + NL + "\t */";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL + "\tpublic void testSet";
  protected final String TEXT_11 = "()" + NL + "\t{";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = "\t}" + NL;
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL;

	public TestCasesetGenFeatureoverride()
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

    
List<Object> genFeatureList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genClassList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genPackageList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genModelList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object genFeatureParameter : genFeatureList ) {
for (Object genClassParameter : genClassList ) {
for (Object genPackageParameter : genPackageList ) {
for (Object genModelParameter : genModelList ) {

this.genFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature)genFeatureParameter;
this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass)genClassParameter;
this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage)genPackageParameter;
this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel)genModelParameter;


    orchestration(ctx);
    
}
}
}
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_14);
    stringBuffer.append(TEXT_15);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int executionIndex = ictx.getExecutionBuffer().length();

    
    
method_doGenerate(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
    ictx.setExecutionCurrentIndex(0);
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("genFeature", this.genFeature);
    parameterValues.put("genClass", this.genClass);
    parameterValues.put("genPackage", this.genPackage);
    parameterValues.put("genModel", this.genModel);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 

protected org.eclipse.emf.codegen.ecore.genmodel.GenFeature genFeature = null;
public void set_genFeature(org.eclipse.emf.codegen.ecore.genmodel.GenFeature object) {
this.genFeature = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenClass genClass = null;
public void set_genClass(org.eclipse.emf.codegen.ecore.genmodel.GenClass object) {
this.genClass = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage = null;
public void set_genPackage(org.eclipse.emf.codegen.ecore.genmodel.GenPackage object) {
this.genPackage = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;
public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel object) {
this.genModel = object;
}
public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("genFeature", this.genFeature);
parameters.put("genClass", this.genClass);
parameters.put("genPackage", this.genPackage);
parameters.put("genModel", this.genModel);
return parameters; }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genFeature.getRawBoundType());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genFeature.getFormattedName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genFeature.getGenClass().getQualifiedInterfaceName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genFeature.getRawBoundType());
    stringBuffer.append(TEXT_8);
    if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //TestCase/setGenFeature.annotations.insert.javajetinc
    stringBuffer.append(TEXT_9);
    final Map<String, Object> parameters__5ZqIAGNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5ZqIAGNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5ZqIAGNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5ZqIAGNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5ZqIAGNEEdLjd_RFzaClA.put("genModel", genModel);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0-wU8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5ZqIAGNEEdLjd_RFzaClA);

    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genFeature.getAccessorName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    final Map<String, Object> parameters__5ZqIAWNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5ZqIAWNEEdLjd_RFzaClA.put("genFeature", genFeature);
parameters__5ZqIAWNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5ZqIAWNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5ZqIAWNEEdLjd_RFzaClA.put("genModel", genModel);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_0-6F8GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5ZqIAWNEEdLjd_RFzaClA);

    //TestCase/setGenFeature.todo.override.javajetinc
    stringBuffer.append(TEXT_13);
    }
    }