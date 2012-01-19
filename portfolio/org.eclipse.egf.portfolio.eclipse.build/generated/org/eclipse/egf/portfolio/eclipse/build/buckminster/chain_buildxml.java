//Generated on Thu Jan 19 16:44:25 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;

public class chain_buildxml extends org.eclipse.egf.portfolio.eclipse.build.FilePattern {
    protected static String nl;

    public static synchronized chain_buildxml create(String lineSeparator) {
        nl = lineSeparator;
        chain_buildxml result = new chain_buildxml();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "<project name=\"";
    protected final String TEXT_2 = "\">" + NL;
    protected final String TEXT_3 = NL + "\t<echo message=\"Running Job ";
    protected final String TEXT_4 = " in ";
    protected final String TEXT_5 = "\"/>" + NL + "\t<ant dir=\"";
    protected final String TEXT_6 = "\"/>" + NL;
    protected final String TEXT_7 = NL + NL + "</project>";
    protected final String TEXT_8 = NL;
    protected final String TEXT_9 = NL;

    public chain_buildxml() {
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

        List<Object> chainList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object chainParameter : chainList) {

            this.chain = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain) chainParameter;

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

        method_body(new StringBuffer(), ictx);

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("chain", this.chain);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain chain = null;

    public void set_chain(org.eclipse.egf.portfolio.eclipse.build.buildcore.Chain object) {
        this.chain = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("chain", this.chain);
        return parameters;
    }

    protected void method_setFileName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        fileName = "build_" + chain.getName() + ".xml";
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setFileName", stringBuffer.toString());
    }

    protected void method_setFilePath(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        filePath = "";
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setFilePath", stringBuffer.toString());
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(chain.getName());
        stringBuffer.append(TEXT_2);
        for (Job job : chain.getJobs()) {
            if (job.isEnabled()) {
                String path = new GenerationHelper().getJobName(ctx, job) + "/releng";
                stringBuffer.append(TEXT_3);
                stringBuffer.append(job.getName());
                stringBuffer.append(TEXT_4);
                stringBuffer.append(path);
                stringBuffer.append(TEXT_5);
                stringBuffer.append(path);
                stringBuffer.append(TEXT_6);
            }
        }
        stringBuffer.append(TEXT_7);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}