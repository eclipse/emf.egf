package org.eclipse.egf.emf.pattern.edit.internal.ItemProvider;

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

public class ItemProvidernewChildDescriptorsReferenceFeatureoverride 
{
  protected static String nl;
  public static synchronized ItemProvidernewChildDescriptorsReferenceFeatureoverride create(String lineSeparator)
  {
    nl = lineSeparator;
    ItemProvidernewChildDescriptorsReferenceFeatureoverride result = new ItemProvidernewChildDescriptorsReferenceFeatureoverride();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
  protected final String TEXT_2 = ",";
  protected final String TEXT_3 = NL + "\t\t\t\t ";
  protected final String TEXT_4 = ".create(";
  protected final String TEXT_5 = ")));";
  protected final String TEXT_6 = NL + "\t\t\t\t ";
  protected final String TEXT_7 = ".create";
  protected final String TEXT_8 = "()));";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL;

	public ItemProvidernewChildDescriptorsReferenceFeatureoverride()
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

    
List<Object> createClassList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> createFeatureList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> delegatedFeatureList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> createClassifierList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> childCreationDataList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genClassList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genPackageList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genModelList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _ListList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object createClassParameter : createClassList ) {
for (Object createFeatureParameter : createFeatureList ) {
for (Object delegatedFeatureParameter : delegatedFeatureList ) {
for (Object createClassifierParameter : createClassifierList ) {
for (Object childCreationDataParameter : childCreationDataList ) {
for (Object genClassParameter : genClassList ) {
for (Object genPackageParameter : genPackageList ) {
for (Object genModelParameter : genModelList ) {
for (Object _ListParameter : _ListList ) {

this.createClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass)createClassParameter;
this.createFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature)createFeatureParameter;
this.delegatedFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature)delegatedFeatureParameter;
this.createClassifier = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)createClassifierParameter;
this.childCreationData = (org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData)childCreationDataParameter;
this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass)genClassParameter;
this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage)genPackageParameter;
this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel)genModelParameter;
this._List = (java.lang.String)_ListParameter;


    orchestration(ctx);
    
}
}
}
}
}
}
}
}
}
if (ctx.useReporter()){
    ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
    ctx.clearBuffer();
}
    
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
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
    parameterValues.put("createClass", this.createClass);
    parameterValues.put("createFeature", this.createFeature);
    parameterValues.put("delegatedFeature", this.delegatedFeature);
    parameterValues.put("createClassifier", this.createClassifier);
    parameterValues.put("childCreationData", this.childCreationData);
    parameterValues.put("genClass", this.genClass);
    parameterValues.put("genPackage", this.genPackage);
    parameterValues.put("genModel", this.genModel);
    parameterValues.put("_List", this._List);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 

protected org.eclipse.emf.codegen.ecore.genmodel.GenClass createClass = null;
public void set_createClass(org.eclipse.emf.codegen.ecore.genmodel.GenClass object) {
this.createClass = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenFeature createFeature = null;
public void set_createFeature(org.eclipse.emf.codegen.ecore.genmodel.GenFeature object) {
this.createFeature = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenFeature delegatedFeature = null;
public void set_delegatedFeature(org.eclipse.emf.codegen.ecore.genmodel.GenFeature object) {
this.delegatedFeature = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenClassifier createClassifier = null;
public void set_createClassifier(org.eclipse.emf.codegen.ecore.genmodel.GenClassifier object) {
this.createClassifier = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData childCreationData = null;
public void set_childCreationData(org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData object) {
this.childCreationData = object;
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
protected java.lang.String _List = null;
public void set__List(java.lang.String object) {
this._List = object;
}
public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("createClass", this.createClass);
parameters.put("createFeature", this.createFeature);
parameters.put("delegatedFeature", this.delegatedFeature);
parameters.put("createClassifier", this.createClassifier);
parameters.put("childCreationData", this.childCreationData);
parameters.put("genClass", this.genClass);
parameters.put("genPackage", this.genPackage);
parameters.put("genModel", this.genModel);
parameters.put("_List", this._List);
return parameters; }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_2);
    if (createClass.isMapEntry()) { 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(createClass.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_5);
    } else {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(createClass.getName());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    final Map<String, Object> parameters__zwtYAGJ_EdFqczH3ESmRw = new HashMap<String, Object>();
parameters__zwtYAGJ_EdFqczH3ESmRw.put("createClass", createClass);
parameters__zwtYAGJ_EdFqczH3ESmRw.put("createFeature", createFeature);
parameters__zwtYAGJ_EdFqczH3ESmRw.put("delegatedFeature", delegatedFeature);
parameters__zwtYAGJ_EdFqczH3ESmRw.put("createClassifier", createClassifier);
parameters__zwtYAGJ_EdFqczH3ESmRw.put("childCreationData", childCreationData);
parameters__zwtYAGJ_EdFqczH3ESmRw.put("genClass", genClass);
parameters__zwtYAGJ_EdFqczH3ESmRw.put("genPackage", genPackage);
parameters__zwtYAGJ_EdFqczH3ESmRw.put("genModel", genModel);
parameters__zwtYAGJ_EdFqczH3ESmRw.put("_List", _List);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04y24GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__zwtYAGJ_EdFqczH3ESmRw);

    stringBuffer.append(TEXT_10);
    }
    }