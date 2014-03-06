//Generated on Wed Aug 08 17:14:11 CEST 2012 with EGF 1.0.0.qualifier
package org.eclipse.egf.emf.pattern.model.cdo;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.common.util.URI;

public class genModelForCDOReplace extends org.eclipse.egf.emf.pattern.model.cdo.genModelForCDO {

    public genModelForCDOReplace() {
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

    protected void method_genModelResourceURI(final StringBuffer out, final PatternContext ctx) throws Exception {
        URI genModelResourceURI = genModel.eResource().getURI();
        String cdoSuffix = (String) ctx.getValue("cdoSuffix");
        newGenModelResourceURI = genModelResourceURI.trimFileExtension().appendFileExtension(cdoSuffix).appendFileExtension(genModelResourceURI.fileExtension());

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "genModelResourceURI", out.toString());
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("genModel", this.genModel);
        return parameters;
    }

}
