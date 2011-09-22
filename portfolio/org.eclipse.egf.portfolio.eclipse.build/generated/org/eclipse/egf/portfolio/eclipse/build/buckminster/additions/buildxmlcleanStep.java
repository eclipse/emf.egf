package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

public class buildxmlcleanStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmlcleanStep create(String lineSeparator) {
        nl = lineSeparator;
        buildxmlcleanStep result = new buildxmlcleanStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\" >" + NL + "\t\t<antcall target=\"";
    protected final String TEXT_3 = "\" />" + NL + "\t</target>" + NL;
    protected final String TEXT_4 = NL;
    protected final String TEXT_5 = NL;

    public buildxmlcleanStep() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("cleanStep", "http://www.eclipse.org/egf/1.0.0/buildstep#//CleanStep");
        queryCtx = new HashMap<String, String>();
        List<Object> cleanStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object cleanStepParameter : cleanStepList) {

            this.cleanStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep) cleanStepParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_4);
        stringBuffer.append(TEXT_5);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("cleanStep", this.cleanStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep cleanStep = null;

    public void set_cleanStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep object) {
        this.cleanStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("cleanStep", this.cleanStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(new GenerationHelper().getIdOrPositionString(cleanStep));
        stringBuffer.append(TEXT_2);
        stringBuffer.append(new GenerationHelper().getCleanTypeString("", "", cleanStep.getType()));
        stringBuffer.append(TEXT_3);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}