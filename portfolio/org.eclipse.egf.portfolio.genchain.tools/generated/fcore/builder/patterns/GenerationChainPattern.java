package fcore.builder.patterns;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.FcoreBuilderConstants;
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;
import org.eclipse.egf.portfolio.genchain.tools.utils.FCMatcher;

public class GenerationChainPattern {

    public GenerationChainPattern() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        List<Object> parameterList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object parameterParameter : parameterList) {

            this.parameter = (org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain) parameterParameter;

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
        method_body(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("parameter", this.parameter);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
        Map<GenerationElement, FactoryComponent> fcs = (Map<GenerationElement, FactoryComponent>) ctx.getValue(FcoreBuilderConstants.CURRENT_FCORE);

        FactoryComponent parentFC = fcs.get((GenerationElement) (parameter.eContainer()));

        Collection<FactoryComponent> unused = (Collection<FactoryComponent>) ctx.getValue(FcoreBuilderConstants.UNUSED_FCORE);
        FactoryComponent fc = FCMatcher.getFC(unused, parameter);
        if (fc == null) {
            fc = ActivityInvocationHelper.createDefaultFC(parameter.getName());
            parentFC.eResource().getContents().add(fc);
        } else {
            ActivityInvocationHelper.clearOrchestration(fc);
            unused.remove(fc);
        }
        fcs.put(parameter, fc);

        ActivityInvocationHelper.addInvocation((ProductionPlan) parentFC.getOrchestration(), fc);

    }

    public boolean preCondition() throws Exception {
        return true;
    }

    protected org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain parameter;

    public void set_parameter(org.eclipse.egf.portfolio.genchain.generationChain.GenerationChain parameter) {
        this.parameter = parameter;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("parameter", this.parameter);
        return parameters;
    }

}
