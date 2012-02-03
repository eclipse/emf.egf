//Generated on Fri Feb 03 18:20:05 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildxmlunzipStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmlunzipStep create(String lineSeparator) {
        nl = lineSeparator;
        buildxmlunzipStep result = new buildxmlunzipStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\" depends=\"init\">" + NL + "\t\t<unzip src=\"";
    protected final String TEXT_3 = "\" dest=\"";
    protected final String TEXT_4 = "\" ";
    protected final String TEXT_5 = " >" + NL + "\t\t</unzip>" + NL + "\t</target>" + NL + NL;
    protected final String TEXT_6 = NL;
    protected final String TEXT_7 = NL;

    public buildxmlunzipStep() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;
        Node.Container currentNode = ctx.getNode();

        paramDesc = new IQuery.ParameterDescription("unzipStep", "http://www.eclipse.org/egf/1.0.0/buildfile#//UnzipStep");
        queryCtx = new HashMap<String, String>();
        List<Object> unzipStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object unzipStepParameter : unzipStepList) {

            this.unzipStep = (org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep) unzipStepParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_6);
        stringBuffer.append(TEXT_7);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("unzipStep", this.unzipStep);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep unzipStep = null;

    public void set_unzipStep(org.eclipse.egf.portfolio.eclipse.build.buildfile.UnzipStep object) {
        this.unzipStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("unzipStep", this.unzipStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        String stepName = new GenerationHelper().getNameOrGeneratedIdString(unzipStep);
        stringBuffer.append(TEXT_1);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(unzipStep.getSourceFilePath());
        stringBuffer.append(TEXT_3);
        stringBuffer.append(unzipStep.getDestinationFolderPath());
        stringBuffer.append(TEXT_4);
        stringBuffer.append(new GenerationHelper().getAdditionalParametersString(unzipStep));
        stringBuffer.append(TEXT_5);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}