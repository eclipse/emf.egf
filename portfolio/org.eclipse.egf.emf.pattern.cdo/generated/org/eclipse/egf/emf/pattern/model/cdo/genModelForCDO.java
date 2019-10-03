//Generated on Tue Aug 28 15:01:11 CEST 2012 with EGF 1.0.0.qualifier
package org.eclipse.egf.emf.pattern.model.cdo;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.emf.cdo.internal.migrator.CDOMigratorUtil;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.domain.emf.EMFDomainHelper;
import org.eclipse.egf.emf.pattern.base.CodegenGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.codegen.ecore.genmodel.GenDelegationKind;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

public class genModelForCDO {

    public genModelForCDO() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        Node.Container currentNode = ctx.getNode();
        List<Object> genModelList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object genModelParameter : genModelList) {

            this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration((PatternContext) argument);

            }
        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        Node.Container currentNode = ictx.getNode();
        method_copyGenModel(new StringBuffer(), ictx);
        method_adjustGenModel(new StringBuffer(), ictx);
        method_customizeGenModel(new StringBuffer(), ictx);
        method_genModelResourceURI(new StringBuffer(), ictx);
        method_createGenModelResource(new StringBuffer(), ictx);
        method_checkGenModel(new StringBuffer(), ictx);
        method_ensureContainerExists(new StringBuffer(), ictx);
        method_saveGenModelResource(new StringBuffer(), ictx);
        method_setGenModelInContext(new StringBuffer(), ictx);
        ictx.setNode(currentNode);
        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("genModel", this.genModel);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected void method_copyGenModel(final StringBuffer out, final PatternContext ctx) throws Exception {
        newGenModel = EcoreUtil.copy(genModel);

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "copyGenModel", out.toString());
    }

    protected void method_adjustGenModel(final StringBuffer out, final PatternContext ctx) throws Exception {
        String featureDelegationString = (String) ctx.getValue("featureDelegation");
        GenDelegationKind genDelegationKind = GenDelegationKind.get(featureDelegationString);
        CDOMigratorUtil.adjustGenModel(newGenModel, genDelegationKind);

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "adjustGenModel", out.toString());
    }

    protected void method_customizeGenModel(final StringBuffer out, final PatternContext ctx) throws Exception {

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "customizeGenModel", out.toString());
    }

    protected void method_genModelResourceURI(final StringBuffer out, final PatternContext ctx) throws Exception {
        newGenModelResourceURI = URI.createURI("someURI");

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "genModelResourceURI", out.toString());
    }

    protected void method_createGenModelResource(final StringBuffer out, final PatternContext ctx) throws Exception {
        Resource newGenModelResource = genModel.eResource().getResourceSet().createResource(newGenModelResourceURI);
        newGenModelResource.getContents().add(newGenModel);

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "createGenModelResource", out.toString());
    }

    protected void method_checkGenModel(final StringBuffer out, final PatternContext ctx) throws Exception {
        for (GenPackage genPackage : newGenModel.getUsedGenPackages()) {
            boolean useCDO = false;
            for (String pluginVariable : genPackage.getGenModel().getModelPluginVariables()) {
                useCDO = useCDO || pluginVariable.startsWith("CDO");
            }
            if (!useCDO)
                throw new IllegalStateException("genModel " + EcoreUtil.getURI(genPackage.getGenModel()).trimFragment() + " is not generated for cdo");
        }

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "checkGenModel", out.toString());
    }

    protected void method_ensureContainerExists(final StringBuffer out, final PatternContext ctx) throws Exception {
        CodegenGeneratorAdapter codegenGeneratorAdapter = new CodegenGeneratorAdapter(newGenModel);
        BasicMonitor monitor = new BasicMonitor();
        String workspacePath = newGenModelResourceURI.trimSegments(1).toPlatformString(false);
        codegenGeneratorAdapter.ensureProjectExists(workspacePath, newGenModel, CodegenGeneratorAdapter.MODEL_PROJECT_TYPE, false, monitor);
        codegenGeneratorAdapter.ensureContainerExists(URI.createURI(workspacePath), monitor);

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "ensureContainerExists", out.toString());
    }

    protected void method_saveGenModelResource(final StringBuffer out, final PatternContext ctx) throws Exception {
        Resource newGenModelResource = genModel.eResource().getResourceSet().getResource(newGenModelResourceURI, false);
        newGenModelResource.save(Collections.EMPTY_MAP);

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "saveGenModelResource", out.toString());
    }

    protected void method_setGenModelInContext(final StringBuffer out, final PatternContext ctx) throws Exception {
        EMFDomain emfDomain = DomainFactory.eINSTANCE.createEMFDomain();
        emfDomain.setUri(newGenModelResourceURI);
        new EMFDomainHelper().loadDomain(emfDomain);
        ctx.setValue("domainOut", emfDomain);

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setGenModelInContext", out.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return true;
    }

    protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel;

    public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel) {
        this.genModel = genModel;
    }

    protected org.eclipse.emf.codegen.ecore.genmodel.GenModel newGenModel;

    public void set_newGenModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel newGenModel) {
        this.newGenModel = newGenModel;
    }

    protected org.eclipse.emf.common.util.URI newGenModelResourceURI;

    public void set_newGenModelResourceURI(org.eclipse.emf.common.util.URI newGenModelResourceURI) {
        this.newGenModelResourceURI = newGenModelResourceURI;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("genModel", this.genModel);
        return parameters;
    }

}
