package org.eclipse.egf.emf.pattern.edit.call.ItemProvider;

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

public class ItemProvidernewChildDescriptorsReferenceFeatureoverride {
    protected static String nl;

    public static synchronized ItemProvidernewChildDescriptorsReferenceFeatureoverride create(String lineSeparator) {
        nl = lineSeparator;
        ItemProvidernewChildDescriptorsReferenceFeatureoverride result = new ItemProvidernewChildDescriptorsReferenceFeatureoverride();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL + NL + "\t\tnewChildDescriptors.add" + NL + "\t\t\t(createChildParameter" + NL + "\t\t\t\t(";
    protected final String TEXT_3 = ",";
    protected final String TEXT_4 = NL + "\t\t\t\t ";
    protected final String TEXT_5 = ".create(";
    protected final String TEXT_6 = ")));";
    protected final String TEXT_7 = NL + "\t\t\t\t ";
    protected final String TEXT_8 = ".create";
    protected final String TEXT_9 = "()));";
    protected final String TEXT_10 = NL;
    protected final String TEXT_11 = NL;
    protected final String TEXT_12 = NL;
    protected final String TEXT_13 = NL;

    public ItemProvidernewChildDescriptorsReferenceFeatureoverride() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        List<Object> createFeatureList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> genClassList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> genPackageList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> genModelList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> _ListList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object createFeatureParameter : createFeatureList) {
            for (Object genClassParameter : genClassList) {
                for (Object genPackageParameter : genPackageList) {
                    for (Object genModelParameter : genModelList) {
                        for (Object _ListParameter : _ListList) {

                            this.createFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) createFeatureParameter;
                            this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
                            this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
                            this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
                            this._List = (java.lang.String) _ListParameter;

                            if (preCondition())
                                orchestration(ctx);

                        }
                    }
                }
            }
        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_12);
        stringBuffer.append(TEXT_13);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        method_doGenerate(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("createFeature", this.createFeature);
            parameterValues.put("genClass", this.genClass);
            parameterValues.put("genPackage", this.genPackage);
            parameterValues.put("genModel", this.genModel);
            parameterValues.put("_List", this._List);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.emf.codegen.ecore.genmodel.GenFeature createFeature = null;

    public void set_createFeature(org.eclipse.emf.codegen.ecore.genmodel.GenFeature object) {
        this.createFeature = object;
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
        parameters.put("createFeature", this.createFeature);
        parameters.put("genClass", this.genClass);
        parameters.put("genPackage", this.genPackage);
        parameters.put("genModel", this.genModel);
        parameters.put("_List", this._List);
        return parameters;
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        for (GenClass createClass : genClass.getChildrenClasses(createFeature)) {
            stringBuffer.append(TEXT_2);
            stringBuffer.append(createFeature.getQualifiedFeatureAccessor());
            stringBuffer.append(TEXT_3);
            if (createClass.isMapEntry()) {
                stringBuffer.append(TEXT_4);
                stringBuffer.append(createClass.getGenPackage().getQualifiedEFactoryInstanceAccessor());
                stringBuffer.append(TEXT_5);
                stringBuffer.append(createClass.getQualifiedClassifierAccessor());
                stringBuffer.append(TEXT_6);
            } else {
                stringBuffer.append(TEXT_7);
                stringBuffer.append(createClass.getGenPackage().getQualifiedFactoryInstanceAccessor());
                stringBuffer.append(TEXT_8);
                stringBuffer.append(createClass.getName());
                stringBuffer.append(TEXT_9);
            }
        }
        stringBuffer.append(TEXT_10);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvider.newChildDescriptorsReferenceFeature.insert" args="createFeature:createFeature,genClass:genClass,genPackage:genPackage,genModel:genModel,_List:_List"%>

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("createFeature", createFeature);
            callParameters.put("genClass", genClass);
            callParameters.put("genPackage", genPackage);
            callParameters.put("genModel", genModel);
            callParameters.put("_List", _List);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_04y24GJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
        }

        stringBuffer.append(TEXT_11);
    }

    public boolean preCondition() throws Exception {
        return true;
    }
}