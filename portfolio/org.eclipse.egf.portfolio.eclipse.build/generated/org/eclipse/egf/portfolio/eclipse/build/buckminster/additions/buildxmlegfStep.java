package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;

public class buildxmlegfStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmlegfStep create(String lineSeparator) {
        nl = lineSeparator;
        buildxmlegfStep result = new buildxmlegfStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\" depends=\"init,install.egf\">" + NL + "\t\t<egf>" + NL + "            <globargs>";
    protected final String TEXT_3 = NL + "\t\t\t\t<jvmarg value=\"-D";
    protected final String TEXT_4 = "=";
    protected final String TEXT_5 = "\" />";
    protected final String TEXT_6 = "            " + NL + "\t\t\t</globargs>" + NL + "\t\t\t<activities>";
    protected final String TEXT_7 = NL + "\t\t\t\t<arg value=\"";
    protected final String TEXT_8 = "\"/>";
    protected final String TEXT_9 = NL + "\t\t\t</activities>" + NL + "\t\t</egf>" + NL + "\t</target>" + NL;
    protected final String TEXT_10 = NL;
    protected final String TEXT_11 = NL;

    public buildxmlegfStep() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("egfStep", "http://www.eclipse.org/egf/1.0.0/buildstep#//EgfStep");
        queryCtx = new HashMap<String, String>();
        List<Object> egfStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);

        for (Object egfStepParameter : egfStepList) {

            this.egfStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep) egfStepParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_10);
        stringBuffer.append(TEXT_11);
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
            parameterValues.put("egfStep", this.egfStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep egfStep = null;

    public void set_egfStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.EgfStep object) {
        this.egfStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("egfStep", this.egfStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(new GenerationHelper().getPositionString(egfStep));
        stringBuffer.append(TEXT_2);
        for (Property property : egfStep.getProperties()) {
            stringBuffer.append(TEXT_3);
            stringBuffer.append(property.getKey());
            stringBuffer.append(TEXT_4);
            stringBuffer.append(property.getValue());
            stringBuffer.append(TEXT_5);
        }
        stringBuffer.append(TEXT_6);
        for (String activity : egfStep.getActivities()) {
            stringBuffer.append(TEXT_7);
            stringBuffer.append(activity);
            stringBuffer.append(TEXT_8);
        }
        stringBuffer.append(TEXT_9);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}