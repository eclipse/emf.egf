package org.eclipse.egf.emf.pattern.edit;

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

public class CreateChildIconsForGenPackage extends org.eclipse.egf.emf.pattern.base.GenPackageGIF {
  protected static String nl;
  public static synchronized CreateChildIconsForGenPackage create(String lineSeparator)
  {
    nl = lineSeparator;
    CreateChildIconsForGenPackage result = new CreateChildIconsForGenPackage();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;

	public CreateChildIconsForGenPackage()
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

    
List<Object> parameterList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object parameterParameter : parameterList ) {

this.parameter = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage)parameterParameter;


    orchestration(ctx);
    
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
public String orchestration(PatternContext ctx) throws Exception  {
InternalPatternContext ictx = (InternalPatternContext)ctx;
int index = 0, executionIndex = ictx.getExecutionBuffer().length();

    super.orchestration(new SuperOrchestrationContext(ictx));

    
method_preGenerate(ictx.getBuffer(), ictx);
    
method_doGenerate(ictx.getBuffer(), ictx);
    {
final Map<String, Object> parameters = new HashMap<String, Object>();
index = ictx.getBuffer().length();
ictx.getExecutionBuffer().append(ictx.getBuffer());
parameters.put("parameter", this.parameter);
CallbackContext ctx_callback = new CallbackContext(ictx);
CallHelper.callBack(ctx_callback, parameters);
}

    
method_postGenerate(ictx.getBuffer(), ictx);
    
String loop = ictx.getBuffer().toString();
if (ictx.useReporter()){
    ictx.getExecutionBuffer().append(ictx.getBuffer().substring(index));
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    parameterValues.put("parameter", this.parameter);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 


    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
canGenerate = new CodegenGeneratorAdapter(parameter).canGenerate("org.eclipse.emf.codegen.ecore.genmodel.generator.EditProject");

    }
    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    
if (!canGenerate)
    return;
new CodegenGeneratorAdapter(parameter).ensureProjectExists(genModel.getEditDirectory(), genModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE, genModel.isUpdateClasspath(), new BasicMonitor());
GenPackage genPackage = parameter;
GenModel genModel=genPackage.getGenModel();
if (genModel.isCreationCommands() && genModel.isCreationIcons() && genPackage.isChildCreationExtenders()) {
  for (  Map.Entry<GenPackage,Map<GenClass,List<GenClass.ChildCreationData>>> packageEntry : genPackage.getExtendedChildCreationData().entrySet()) {
    for (    Map.Entry<GenClass,List<GenClass.ChildCreationData>> classEntry : packageEntry.getValue().entrySet()) {
      GenClass genClass=classEntry.getKey();
      for (      GenClass.ChildCreationData childCreationData : classEntry.getValue()) {
        if (childCreationData.createClassifier instanceof GenClass && (childCreationData.delegatedFeature == null || classEntry.getKey().getAllGenFeatures().contains(childCreationData.delegatedFeature))) {
          GenClass childClass=(GenClass)childCreationData.createClassifier;
          GenFeature feature=childCreationData.createFeature;
new CodegenGeneratorAdapter(parameter).generateGIF("edit/CreateChild.gif", genClass.getCreateChildIconFileName(genModel,feature,childClass), genClass.getName(), childClass.getName(), false);
        }
      }
    }
  }
}

    }
    }