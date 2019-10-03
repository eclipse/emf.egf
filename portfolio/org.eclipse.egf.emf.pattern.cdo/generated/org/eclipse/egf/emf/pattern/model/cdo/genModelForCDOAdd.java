//Generated on Fri Nov 30 18:17:37 CET 2012 with EGF 1.0.0.qualifier
package org.eclipse.egf.emf.pattern.model.cdo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.execution.OutputManager;
import org.eclipse.egf.pattern.execution.SuperOrchestrationContext;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class genModelForCDOAdd extends org.eclipse.egf.emf.pattern.model.cdo.genModelForCDO {

    public genModelForCDOAdd() {
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
        super.orchestration(new SuperOrchestrationContext(ictx));
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

    protected void method_customizeGenModel(final StringBuffer out, final PatternContext ctx) throws Exception {
        String cdoSuffix = (String) ctx.getValue("cdoSuffix");
        newGenModel.setModelPluginID(newGenModel.getModelPluginID() + "." + cdoSuffix);
        newGenModel.setModelDirectory(newGenModel.getModelDirectory().replace(genModel.getModelPluginID(), newGenModel.getModelPluginID()));

        //replace usedGenPackages by cdo usedGenPackages
        List<GenPackage> usedGenPackages = new ArrayList<GenPackage>();
        for (GenPackage genPackage : genModel.getUsedGenPackages()) {
            URI uri = EcoreUtil.getURI(genPackage);

            URI newURI = null;
            if (uri.toString().contains(genPackage.getGenModel().getModelPluginID())) {
                newURI = URI.createURI(uri.toString().replace(genPackage.getGenModel().getModelPluginID(), genPackage.getGenModel().getModelPluginID() + "." + cdoSuffix));
            } else {
                newURI = URI.createPlatformResourceURI(genPackage.getGenModel().getModelPluginID() + "." + cdoSuffix + "/model/" + uri.lastSegment(), true).appendFragment(uri.fragment());
            }

            try {
                Resource resource = genPackage.eResource().getResourceSet().getResource(newURI.trimFragment(), true);
                GenPackage newGenPackage = (GenPackage) resource.getEObject(newURI.fragment());
                if (newGenPackage != null)
                    usedGenPackages.add(newGenPackage);
                else
                    usedGenPackages.add(genPackage);
            } catch (Exception exception) {
                usedGenPackages.add(genPackage);
            }
        }

        newGenModel.getUsedGenPackages().clear();
        newGenModel.getUsedGenPackages().addAll(usedGenPackages);

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "customizeGenModel", out.toString());
    }

    protected void method_genModelResourceURI(final StringBuffer out, final PatternContext ctx) throws Exception {
        String genModelResourceURIString = genModel.eResource().getURI().toString();

        if (genModelResourceURIString.contains(genModel.getModelPluginID())) {
            genModelResourceURIString = genModelResourceURIString.replace(genModel.getModelPluginID(), newGenModel.getModelPluginID());
            newGenModelResourceURI = URI.createURI(genModelResourceURIString);
        } else {
            newGenModelResourceURI = URI.createPlatformResourceURI(newGenModel.getModelPluginID() + "/model/" + genModel.eResource().getURI().lastSegment(), true);
        }

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "genModelResourceURI", out.toString());
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("genModel", this.genModel);
        return parameters;
    }

}
