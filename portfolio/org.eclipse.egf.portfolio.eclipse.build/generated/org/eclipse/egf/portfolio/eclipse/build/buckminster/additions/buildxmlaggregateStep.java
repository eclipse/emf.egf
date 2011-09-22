package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

public class buildxmlaggregateStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmlaggregateStep create(String lineSeparator) {
        nl = lineSeparator;
        buildxmlaggregateStep result = new buildxmlaggregateStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\" depends=\"init,install.egf\" >" + NL + "\t\t<anteclipse target=\"";
    protected final String TEXT_3 = "_dropins\" />" + NL + "\t\t<anteclipse target=\"";
    protected final String TEXT_4 = "_sitep2\" />" + NL + "\t</target>\t" + NL + "" + NL + "\t<target name=\"";
    protected final String TEXT_5 = "_dropins\">";
    protected final String TEXT_6 = NL + "\t\t<pathconvert property=\"";
    protected final String TEXT_7 = "\">" + NL + "\t\t\t<first count=\"1\">" + NL + "\t\t\t\t<dirset dir=\"";
    protected final String TEXT_8 = "\" includes=\"**/eclipse/\" />" + NL + "\t\t\t</first>" + NL + "\t\t</pathconvert>" + NL + "\t\t<copy todir=\"${publish}/";
    protected final String TEXT_9 = "/dropins/";
    protected final String TEXT_10 = "/eclipse/\" >" + NL + "\t\t\t<fileset dir=\"${";
    protected final String TEXT_11 = "}\"/>" + NL + "\t\t</copy>" + NL + "\t\t<pathconvert property=\"";
    protected final String TEXT_12 = "\">" + NL + "\t\t\t<first count=\"1\">" + NL + "\t\t\t\t<fileset dir=\"";
    protected final String TEXT_13 = "\" includes=\"**/*_version_*\" />" + NL + "\t\t\t</first>" + NL + "\t\t</pathconvert>" + NL + "\t\t<copy todir=\"${publish}/";
    protected final String TEXT_14 = "/dropins/";
    protected final String TEXT_15 = "/\" >" + NL + "\t\t\t<fileset file=\"${";
    protected final String TEXT_16 = "}\"/>" + NL + "\t\t</copy>";
    protected final String TEXT_17 = NL + "\t</target>\t" + NL + "" + NL + "\t<target name=\"";
    protected final String TEXT_18 = "_sitep2\">" + NL + "\t\t<!-- see http://wiki.eclipse.org/Equinox/p2/Ant_Tasks -->" + NL + "\t\t<p2.mirror>" + NL + "\t\t\t<repository location=\"file:/${publish}/";
    protected final String TEXT_19 = "/site.p2\" name=\"";
    protected final String TEXT_20 = "/";
    protected final String TEXT_21 = "\" />" + NL + "\t\t\t<source>";
    protected final String TEXT_22 = NL + "\t\t\t\t<repository location=\"";
    protected final String TEXT_23 = "\" />";
    protected final String TEXT_24 = NL + "\t\t\t\t<repository location=\"";
    protected final String TEXT_25 = "\" />";
    protected final String TEXT_26 = NL + "\t\t\t</source>" + NL + "\t\t</p2.mirror>" + NL + "\t</target>" + NL;
    protected final String TEXT_27 = NL;
    protected final String TEXT_28 = NL;

    public buildxmlaggregateStep() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        paramDesc = new IQuery.ParameterDescription("aggregateStep", "http://www.eclipse.org/egf/1.0.0/buildstep#//AggregateStep");
        queryCtx = new HashMap<String, String>();
        List<Object> aggregateStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object aggregateStepParameter : aggregateStepList) {

            this.aggregateStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep) aggregateStepParameter;

            if (preCondition())
                orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_27);
        stringBuffer.append(TEXT_28);
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
            parameterValues.put("aggregateStep", this.aggregateStep);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep aggregateStep = null;

    public void set_aggregateStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.AggregateStep object) {
        this.aggregateStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("aggregateStep", this.aggregateStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(new GenerationHelper().getIdOrPositionString(aggregateStep));
        stringBuffer.append(TEXT_2);
        stringBuffer.append(new GenerationHelper().getIdOrPositionString(aggregateStep));
        stringBuffer.append(TEXT_3);
        stringBuffer.append(new GenerationHelper().getIdOrPositionString(aggregateStep));
        stringBuffer.append(TEXT_4);
        stringBuffer.append(new GenerationHelper().getIdOrPositionString(aggregateStep));
        stringBuffer.append(TEXT_5);
        for (PublishStep publishStep : aggregateStep.getPublishSteps()) {
            if (publishStep.getJob().isEnabled()) {
                String location = "${build.root}/../../" + new GenerationHelper().getJobName(ctx, publishStep.getJob()) + "/workspace/result/publish/" + publishStep.getComponent().getName() + "/dropins";
                String propertyName = "aggregateDropinsFrom_" + publishStep.getComponent().getName();
                String propertyName2 = "aggregateVersionFrom_" + publishStep.getComponent().getName();
                stringBuffer.append(TEXT_6);
                stringBuffer.append(propertyName);
                stringBuffer.append(TEXT_7);
                stringBuffer.append(location);
                stringBuffer.append(TEXT_8);
                stringBuffer.append(aggregateStep.getName());
                stringBuffer.append(TEXT_9);
                stringBuffer.append(aggregateStep.getName());
                stringBuffer.append(TEXT_10);
                stringBuffer.append(propertyName);
                stringBuffer.append(TEXT_11);
                stringBuffer.append(propertyName2);
                stringBuffer.append(TEXT_12);
                stringBuffer.append(location);
                stringBuffer.append(TEXT_13);
                stringBuffer.append(aggregateStep.getName());
                stringBuffer.append(TEXT_14);
                stringBuffer.append(aggregateStep.getName());
                stringBuffer.append(TEXT_15);
                stringBuffer.append(propertyName2);
                stringBuffer.append(TEXT_16);
            }
        }
        stringBuffer.append(TEXT_17);
        stringBuffer.append(new GenerationHelper().getIdOrPositionString(aggregateStep));
        stringBuffer.append(TEXT_18);
        stringBuffer.append(aggregateStep.getName());
        stringBuffer.append(TEXT_19);
        stringBuffer.append(aggregateStep.getJob().getName());
        stringBuffer.append(TEXT_20);
        stringBuffer.append(aggregateStep.getName());
        stringBuffer.append(TEXT_21);
        for (PublishStep publishStep : aggregateStep.getPublishSteps()) {
            if (publishStep.getJob().isEnabled()) {
                if (publishStep.getComponent() instanceof Feature) {
                    String location = "file:/${build.root}/../../" + new GenerationHelper().getJobName(ctx, publishStep.getJob()) + "/workspace/result/publish/" + publishStep.getComponent().getName() + "/site.p2";
                    stringBuffer.append(TEXT_22);
                    stringBuffer.append(location);
                    stringBuffer.append(TEXT_23);
                }
            }
        }
        for (String updateSiteUrl : aggregateStep.getUpdateSiteUrls()) {
            stringBuffer.append(TEXT_24);
            stringBuffer.append(updateSiteUrl);
            stringBuffer.append(TEXT_25);
        }
        stringBuffer.append(TEXT_26);
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}