package org.eclipse.egf.emf.pattern.edit.call.ItemProviderAdapterFactory;

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

public class ItemProviderAdapterFactorynewChildDescriptorsAttributeFeatureoverride 
{
  protected static String nl;
  public static synchronized ItemProviderAdapterFactorynewChildDescriptorsAttributeFeatureoverride create(String lineSeparator)
  {
    nl = lineSeparator;
    ItemProviderAdapterFactorynewChildDescriptorsAttributeFeatureoverride result = new ItemProviderAdapterFactorynewChildDescriptorsAttributeFeatureoverride();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tnewChildDescriptors.add" + NL + "\t\t\t\t\t(createChildParameter" + NL + "\t\t\t\t\t\t(";
  protected final String TEXT_2 = ",";
  protected final String TEXT_3 = NL + "\t\t\t\t\t\t ";
  protected final String TEXT_4 = "));";
  protected final String TEXT_5 = NL + "\t\t\t\t\t\t ";
  protected final String TEXT_6 = "));";
  protected final String TEXT_7 = NL + "\t\t\t\t\t\t ";
  protected final String TEXT_8 = ".createFromString(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ")));";
  protected final String TEXT_11 = " // TODO: ensure this is a valid literal value";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL;
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = NL;

	public ItemProviderAdapterFactorynewChildDescriptorsAttributeFeatureoverride()
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

    
List<Object> createDataTypeList = null;
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
List<Object> classEntryList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> packageEntryList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genPackageList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> genModelList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> useGenericsList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _ArrayListList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)
List<Object> _CollectionList = null;
//this pattern can only be called by another (i.e. it's not an entry point in execution)


for (Object createDataTypeParameter : createDataTypeList ) {
for (Object createFeatureParameter : createFeatureList ) {
for (Object delegatedFeatureParameter : delegatedFeatureList ) {
for (Object createClassifierParameter : createClassifierList ) {
for (Object childCreationDataParameter : childCreationDataList ) {
for (Object genClassParameter : genClassList ) {
for (Object classEntryParameter : classEntryList ) {
for (Object packageEntryParameter : packageEntryList ) {
for (Object genPackageParameter : genPackageList ) {
for (Object genModelParameter : genModelList ) {
for (Object useGenericsParameter : useGenericsList ) {
for (Object _ArrayListParameter : _ArrayListList ) {
for (Object _CollectionParameter : _CollectionList ) {

this.createDataType = (org.eclipse.emf.codegen.ecore.genmodel.GenDataType)createDataTypeParameter;
this.createFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature)createFeatureParameter;
this.delegatedFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature)delegatedFeatureParameter;
this.createClassifier = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)createClassifierParameter;
this.childCreationData = (org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData)childCreationDataParameter;
this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass)genClassParameter;
this.classEntry = (java.util.Map.Entry)classEntryParameter;
this.packageEntry = (java.util.Map.Entry)packageEntryParameter;
this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage)genPackageParameter;
this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel)genModelParameter;
this.useGenerics = (java.lang.Boolean)useGenericsParameter;
this._ArrayList = (java.lang.String)_ArrayListParameter;
this._Collection = (java.lang.String)_CollectionParameter;


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
    parameterValues.put("createDataType", this.createDataType);
    parameterValues.put("createFeature", this.createFeature);
    parameterValues.put("delegatedFeature", this.delegatedFeature);
    parameterValues.put("createClassifier", this.createClassifier);
    parameterValues.put("childCreationData", this.childCreationData);
    parameterValues.put("genClass", this.genClass);
    parameterValues.put("classEntry", this.classEntry);
    parameterValues.put("packageEntry", this.packageEntry);
    parameterValues.put("genPackage", this.genPackage);
    parameterValues.put("genModel", this.genModel);
    parameterValues.put("useGenerics", this.useGenerics);
    parameterValues.put("_ArrayList", this._ArrayList);
    parameterValues.put("_Collection", this._Collection);
    String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
    ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
    ictx.clearBuffer();}
return loop;
} 

protected org.eclipse.emf.codegen.ecore.genmodel.GenDataType createDataType = null;
public void set_createDataType(org.eclipse.emf.codegen.ecore.genmodel.GenDataType object) {
this.createDataType = object;
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
protected java.util.Map.Entry classEntry = null;
public void set_classEntry(java.util.Map.Entry object) {
this.classEntry = object;
}
protected java.util.Map.Entry packageEntry = null;
public void set_packageEntry(java.util.Map.Entry object) {
this.packageEntry = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage = null;
public void set_genPackage(org.eclipse.emf.codegen.ecore.genmodel.GenPackage object) {
this.genPackage = object;
}
protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;
public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel object) {
this.genModel = object;
}
protected java.lang.Boolean useGenerics = null;
public void set_useGenerics(java.lang.Boolean object) {
this.useGenerics = object;
}
protected java.lang.String _ArrayList = null;
public void set__ArrayList(java.lang.String object) {
this._ArrayList = object;
}
protected java.lang.String _Collection = null;
public void set__Collection(java.lang.String object) {
this._Collection = object;
}
public Map<String, Object> getParameters() {
final Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("createDataType", this.createDataType);
parameters.put("createFeature", this.createFeature);
parameters.put("delegatedFeature", this.delegatedFeature);
parameters.put("createClassifier", this.createClassifier);
parameters.put("childCreationData", this.childCreationData);
parameters.put("genClass", this.genClass);
parameters.put("classEntry", this.classEntry);
parameters.put("packageEntry", this.packageEntry);
parameters.put("genPackage", this.genPackage);
parameters.put("genModel", this.genModel);
parameters.put("useGenerics", this.useGenerics);
parameters.put("_ArrayList", this._ArrayList);
parameters.put("_Collection", this._Collection);
return parameters; }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx)throws Exception {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
    stringBuffer.append(TEXT_2);
    if (createFeature.isEnumBasedType()) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(createFeature.getTypeGenEnum().getStaticValue(createFeature.getEcoreFeature().getDefaultValueLiteral()));
    stringBuffer.append(TEXT_4);
    } else if (createFeature.isStringBasedType()) {
    stringBuffer.append(TEXT_5);
    stringBuffer.append(createFeature.getCreateChildValueLiteral());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genModel.getNonNLS());
    } else { String literal = createFeature.getCreateChildValueLiteral();
    stringBuffer.append(TEXT_7);
    stringBuffer.append(createDataType.getGenPackage().getQualifiedEFactoryInstanceAccessor());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(createDataType.getQualifiedClassifierAccessor());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(literal);
    stringBuffer.append(TEXT_10);
    if (literal != null) {
    stringBuffer.append(genModel.getNonNLS());
    } else {
    stringBuffer.append(TEXT_11);
    }
    }
    stringBuffer.append(TEXT_12);
    final Map<String, Object> parameters__5NcQ8GNEEdLjd_RFzaClA = new HashMap<String, Object>();
parameters__5NcQ8GNEEdLjd_RFzaClA.put("createDataType", createDataType);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("createFeature", createFeature);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("delegatedFeature", delegatedFeature);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("createClassifier", createClassifier);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("childCreationData", childCreationData);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("genClass", genClass);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("classEntry", classEntry);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("packageEntry", packageEntry);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("genPackage", genPackage);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("genModel", genModel);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("useGenerics", useGenerics);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("_ArrayList", _ArrayList);
parameters__5NcQ8GNEEdLjd_RFzaClA.put("_Collection", _Collection);
CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_08rRUGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), parameters__5NcQ8GNEEdLjd_RFzaClA);

    stringBuffer.append(TEXT_13);
    }
    }