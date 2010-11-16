package org.eclipse.egf.example.strategy.modeldriven.validation;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;
import org.eclipse.emf.common.util.*;

public class classWithoutAttributes extends org.eclipse.egf.pattern.validation.AbstractValidationPattern {

    public classWithoutAttributes() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        List<Object> eClassList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object eClassParameter : eClassList) {

            this.eClass = (org.eclipse.emf.ecore.EClass) eClassParameter;

            if (preCondition())
                orchestration((PatternContext) argument);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();
        super.orchestration(new SuperOrchestrationContext(ictx));
        method_checkAttributes(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("eClass", this.eClass);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected void method_checkAttributes(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (eClass.getEAllAttributes().isEmpty()) {
            BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.ERROR, "org.eclipse.egf.example.strategy.modeldriven", 0, "eClass " + eClass.getName() + " doesn't have any attribute", new Object[] {
                eClass
            });
            diagnosticChain.add(diagnostic);
        }
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }

    protected org.eclipse.emf.ecore.EClass eClass;

    public void set_eClass(org.eclipse.emf.ecore.EClass eClass) {
        this.eClass = eClass;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("eClass", this.eClass);
        return parameters;
    }

}
