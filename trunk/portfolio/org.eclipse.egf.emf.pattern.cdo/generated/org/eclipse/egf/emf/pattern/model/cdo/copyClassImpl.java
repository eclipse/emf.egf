//Generated on Wed Aug 08 13:35:48 CEST 2012 with EGF 1.0.0.qualifier
package org.eclipse.egf.emf.pattern.model.cdo;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

public class copyClassImpl extends org.eclipse.egf.emf.pattern.model.cdo.abstractCopy {

    public copyClassImpl() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        Node.Container currentNode = ctx.getNode();
        List<Object> genClassList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object genClassParameter : genClassList) {

            this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;

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
            parameterValues.put("genClass", this.genClass);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected void method_setQualifiedName(final StringBuffer out, final PatternContext ctx) throws Exception {
        qualifiedName = genClass.getQualifiedClassName();

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setQualifiedName", out.toString());
    }

    protected org.eclipse.emf.codegen.ecore.genmodel.GenClass genClass;

    public void set_genClass(org.eclipse.emf.codegen.ecore.genmodel.GenClass genClass) {
        this.genClass = genClass;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("genClass", this.genClass);
        return parameters;
    }

}
