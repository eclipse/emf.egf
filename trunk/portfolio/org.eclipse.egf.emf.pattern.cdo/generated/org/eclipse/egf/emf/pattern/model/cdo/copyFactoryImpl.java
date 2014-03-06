//Generated on Wed Aug 08 13:16:46 CEST 2012 with EGF 1.0.0.qualifier
package org.eclipse.egf.emf.pattern.model.cdo;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

public class copyFactoryImpl extends org.eclipse.egf.emf.pattern.model.cdo.abstractCopy {

    public copyFactoryImpl() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        Node.Container currentNode = ctx.getNode();
        List<Object> genPackageList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object genPackageParameter : genPackageList) {

            this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;

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
            parameterValues.put("genPackage", this.genPackage);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected void method_setQualifiedName(final StringBuffer out, final PatternContext ctx) throws Exception {
        qualifiedName = genPackage.getQualifiedFactoryClassName();

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setQualifiedName", out.toString());
    }

    protected org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage;

    public void set_genPackage(org.eclipse.emf.codegen.ecore.genmodel.GenPackage genPackage) {
        this.genPackage = genPackage;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("genPackage", this.genPackage);
        return parameters;
    }

}
