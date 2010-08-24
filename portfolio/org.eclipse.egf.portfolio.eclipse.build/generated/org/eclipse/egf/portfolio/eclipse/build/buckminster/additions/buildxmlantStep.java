package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildxmlantStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmlantStep create(String lineSeparator) {
        nl = lineSeparator;
        buildxmlantStep result = new buildxmlantStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\" depends=\"init,install.egf\" >" + NL + "\t\t<anteclipse target=\"";
    protected final String TEXT_3 = "\" />" + NL + "\t</target>\t";
    protected final String TEXT_4 = NL + "\t<target name=\"";
    protected final String TEXT_5 = "\">" + NL + "\t\t<antcall target=\"";
    protected final String TEXT_6 = "\"/>" + NL + "\t</target>";
    protected final String TEXT_7 = NL;
    protected final String TEXT_8 = NL;
    protected final String TEXT_9 = NL + NL;
    protected final String TEXT_10 = NL;
    protected final String TEXT_11 = NL;

    public buildxmlantStep() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("antStep", "http://www.eclipse.org/egf/1.0.0/buildstep#//AntStep");
        queryCtx = new HashMap<String, String>();
        List<Object> antStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.basic.query").execute(paramDesc, queryCtx, ctx);

        for (Object antStepParameter : antStepList) {

            this.antStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep) antStepParameter;

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
            parameterValues.put("antStep", this.antStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep antStep = null;

    public void set_antStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.AntStep object) {
        this.antStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("antStep", this.antStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        if (antStep.isRunInEclipse()) {
            stringBuffer.append(TEXT_1);
            stringBuffer.append(new GenerationHelper().getPositionString(antStep));
            stringBuffer.append(TEXT_2);
            stringBuffer.append(antStep.getTargetName());
            stringBuffer.append(TEXT_3);
        } else {
            stringBuffer.append(TEXT_4);
            stringBuffer.append(new GenerationHelper().getPositionString(antStep));
            stringBuffer.append(TEXT_5);
            stringBuffer.append(antStep.getTargetName());
            stringBuffer.append(TEXT_6);
        }
        stringBuffer.append(TEXT_7);
        stringBuffer.append(TEXT_8);
        stringBuffer.append(antStep.getXml() == null ? "" : antStep.getXml());
        stringBuffer.append(TEXT_9);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}