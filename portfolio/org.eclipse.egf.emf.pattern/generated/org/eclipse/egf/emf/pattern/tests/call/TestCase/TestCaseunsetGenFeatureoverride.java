//Generated on Mon Jan 23 11:17:11 CET 2012 with EGF 0.6.1.qualifier
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

public class TestCaseunsetGenFeatureoverride {
    protected static String nl;

    public static synchronized TestCaseunsetGenFeatureoverride create(String lineSeparator) {
        nl = lineSeparator;
        TestCaseunsetGenFeatureoverride result = new TestCaseunsetGenFeatureoverride();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = NL + NL + "\t/**" + NL + "\t * Tests the '{@link ";
    protected final String TEXT_2 = "#unset";
    protected final String TEXT_3 = "() <em>unset";
    protected final String TEXT_4 = "()</em>}' method." + NL + "\t * <!-- begin-user-doc -->" + NL + "\t * <!-- end-user-doc -->" + NL + "\t * @see ";
    protected final String TEXT_5 = "#unset";
    protected final String TEXT_6 = "()" + NL + "\t * @generated" + NL + "\t */";
    protected final String TEXT_7 = NL;
    protected final String TEXT_8 = NL + "\tpublic void testUnset";
    protected final String TEXT_9 = "()" + NL + "\t{";
    protected final String TEXT_10 = NL;
    protected final String TEXT_11 = NL + "\t}" + NL;
    protected final String TEXT_12 = NL;
    protected final String TEXT_13 = NL;

    public TestCaseunsetGenFeatureoverride() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;
        Node.Container currentNode = ctx.getNode();

        List<Object> genFeatureList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> genClassList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> genPackageList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> genModelList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object genFeatureParameter : genFeatureList) {
            for (Object genClassParameter : genClassList) {
                for (Object genPackageParameter : genPackageList) {
                    for (Object genModelParameter : genModelList) {

                        this.genFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) genFeatureParameter;
                        this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
                        this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
                        this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;

                        if (preCondition(ctx)) {
                            ctx.setNode(new Node.Container(currentNode, getClass()));
                            orchestration(ctx);
                        }

                    }
                }
            }
        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_12);
        stringBuffer.append(TEXT_13);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        method_doGenerate(new StringBuffer(), ictx);

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("genFeature", this.genFeature);
            parameterValues.put("genClass", this.genClass);
            parameterValues.put("genPackage", this.genPackage);
            parameterValues.put("genModel", this.genModel);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
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
        return parameters;
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(genFeature.getGenClass().getQualifiedInterfaceName());
        stringBuffer.append(TEXT_2);
        stringBuffer.append(genFeature.getAccessorName());
        stringBuffer.append(TEXT_3);
        stringBuffer.append(genFeature.getAccessorName());
        stringBuffer.append(TEXT_4);
        stringBuffer.append(genFeature.getGenClass().getQualifiedInterfaceName());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(genFeature.getAccessorName());
        stringBuffer.append(TEXT_6);
        if (genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50) { //TestCase/unsetGenFeature.annotations.insert.javajetinc
            stringBuffer.append(TEXT_7);
            {
                //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.tests.call.TestCase.TestCase.unsetGenFeature.annotations.insert" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

                InternalPatternContext ictx = (InternalPatternContext) ctx;
                new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
                stringBuffer.setLength(0);

                final Map<String, Object> callParameters = new HashMap<String, Object>();
                callParameters.put("genFeature", genFeature);
                callParameters.put("genClass", genClass);
                callParameters.put("genPackage", genPackage);
                callParameters.put("genModel", genModel);
                CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_1BcckGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
                stringBuffer.setLength(0);
            }

        }
        stringBuffer.append(TEXT_8);
        stringBuffer.append(genFeature.getAccessorName());
        stringBuffer.append(TEXT_9);
        stringBuffer.append(TEXT_10);
        {
            //<%@ egf:patternCall patternId="platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#LogicalName=org.eclipse.egf.emf.pattern.tests.call.TestCase.TestCase.unsetGenFeature.TODO.override" args="genFeature:genFeature,genClass:genClass,genPackage:genPackage,genModel:genModel"%>

            InternalPatternContext ictx = (InternalPatternContext) ctx;
            new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
            stringBuffer.setLength(0);

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("genFeature", genFeature);
            callParameters.put("genClass", genClass);
            callParameters.put("genPackage", genPackage);
            callParameters.put("genModel", genModel);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.emf.pattern/egf/EMF_Pattern.fcore#_1BlmgGJ-Ed-FqczH3ESmRw", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        //TestCase/unsetGenFeature.todo.override.javajetinc
        stringBuffer.append(TEXT_11);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return true;
    }
}