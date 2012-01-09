//Generated on Mon Jan 09 15:41:04 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buildstep.edit;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;
import org.eclipse.egf.emf.pattern.base.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class newChildDescriptorscreateJavadocStep extends org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProvidernewChildDescriptorsReferenceFeatureoverride {
    protected static String nl;

    public static synchronized newChildDescriptorscreateJavadocStep create(String lineSeparator) {
        nl = lineSeparator;
        newChildDescriptorscreateJavadocStep result = new newChildDescriptorscreateJavadocStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "        newChildDescriptors.add" + NL + "            (createChildParameter" + NL + "                (BuildcorePackage.Literals.JOB__STEPS," + NL + "                 BuildstepFactory.eINSTANCE.createJavadocStepFilled()));" + NL;
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public newChildDescriptorscreateJavadocStep() {
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

        for (Object createClassParameter : createClassList) {
            for (Object createFeatureParameter : createFeatureList) {
                for (Object delegatedFeatureParameter : delegatedFeatureList) {
                    for (Object createClassifierParameter : createClassifierList) {
                        for (Object childCreationDataParameter : childCreationDataList) {
                            for (Object genClassParameter : genClassList) {
                                for (Object genPackageParameter : genPackageList) {
                                    for (Object genModelParameter : genModelList) {

                                        this.createClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) createClassParameter;
                                        this.createFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) createFeatureParameter;
                                        this.delegatedFeature = (org.eclipse.emf.codegen.ecore.genmodel.GenFeature) delegatedFeatureParameter;
                                        this.createClassifier = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier) createClassifierParameter;
                                        this.childCreationData = (org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData) childCreationDataParameter;
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
                    }
                }
            }
        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(TEXT_3);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        String loop = OutputManager.getOutputWithoutCallback(ictx);
        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("createClass", this.createClass);
            parameterValues.put("createFeature", this.createFeature);
            parameterValues.put("delegatedFeature", this.delegatedFeature);
            parameterValues.put("createClassifier", this.createClassifier);
            parameterValues.put("childCreationData", this.childCreationData);
            parameterValues.put("genClass", this.genClass);
            parameterValues.put("genPackage", this.genPackage);
            parameterValues.put("genModel", this.genModel);
            String outputWithCallBack = OutputManager.getOutput(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ;
        }
        return loop;
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
        return parameters;
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        //workaroud : usage of reflection instead of this.createClass (to keep compatibility with emf 2.3)
        try {
            GenClass createClass = (GenClass) getParameters().get("createClass");
            return EMFPatternHelper.isSameEClass(BuildstepPackage.eINSTANCE.getJavadocStep(), createClass.getEcoreClass());
        } catch (Exception e) {
            return false;
        }
    }
}