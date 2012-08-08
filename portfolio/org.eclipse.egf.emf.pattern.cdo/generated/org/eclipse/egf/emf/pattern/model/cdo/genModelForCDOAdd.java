//Generated on Wed Aug 08 17:14:11 CEST 2012 with EGF 1.0.0.qualifier
package org.eclipse.egf.emf.pattern.model.cdo;

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

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "customizeGenModel", out.toString());
    }

    protected void method_genModelResourceURI(final StringBuffer out, final PatternContext ctx) throws Exception {
        URI genModelResourceURI = genModel.eResource().getURI();
        String genModelResourceURIString = genModelResourceURI.toString();
        genModelResourceURIString = genModelResourceURIString.replace(genModel.getModelPluginID(), newGenModel.getModelPluginID());
        newGenModelResourceURI = URI.createURI(genModelResourceURIString);

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "genModelResourceURI", out.toString());
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("genModel", this.genModel);
        return parameters;
    }

}
