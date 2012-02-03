//Generated on Fri Feb 03 18:20:05 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildxmlzipStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmlzipStep create(String lineSeparator) {
        nl = lineSeparator;
        buildxmlzipStep result = new buildxmlzipStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\" depends=\"init\">" + NL + "\t\t<zip destfile=\"";
    protected final String TEXT_3 = "\" basedir=\"";
    protected final String TEXT_4 = "\" ";
    protected final String TEXT_5 = " >";
    protected final String TEXT_6 = NL;
    protected final String TEXT_7 = NL + "\t\t</zip>" + NL + "\t</target>" + NL + NL;
    protected final String TEXT_8 = NL;
    protected final String TEXT_9 = NL;

    public buildxmlzipStep() {
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

        paramDesc = new IQuery.ParameterDescription("zipStep", "http://www.eclipse.org/egf/1.0.0/buildfile#//ZipStep");
        queryCtx = new HashMap<String, String>();
        List<Object> zipStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object zipStepParameter : zipStepList) {

            this.zipStep = (org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep) zipStepParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_8);
        stringBuffer.append(TEXT_9);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("zipStep", this.zipStep);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep zipStep = null;

    public void set_zipStep(org.eclipse.egf.portfolio.eclipse.build.buildfile.ZipStep object) {
        this.zipStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("zipStep", this.zipStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        String stepName = new GenerationHelper().getNameOrGeneratedIdString(zipStep);
        stringBuffer.append(TEXT_1);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(zipStep.getDestinationFilePath());
        stringBuffer.append(TEXT_3);
        stringBuffer.append(zipStep.getBaseDir());
        stringBuffer.append(TEXT_4);
        stringBuffer.append(new GenerationHelper().getAdditionalParametersString(zipStep));
        stringBuffer.append(TEXT_5);
        stringBuffer.append(TEXT_6);
        {
            //<%@ egf:patternCall 
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.buckminster.util.build.xml.filesetProvider" 
            //	args="zipStep:filesetProvider"%>

            InternalPatternContext ictx = (InternalPatternContext) ctx;
            new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
            stringBuffer.setLength(0);

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            callParameters.put("filesetProvider", zipStep);
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_p-drcEwzEeG-l60d03D_Og", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        stringBuffer.append(TEXT_7);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}