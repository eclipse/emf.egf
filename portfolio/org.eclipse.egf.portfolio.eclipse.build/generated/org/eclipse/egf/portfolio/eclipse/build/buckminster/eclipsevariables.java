//Generated on Fri Feb 03 18:20:04 CET 2012 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class eclipsevariables extends org.eclipse.egf.portfolio.eclipse.build.JobFilePattern {
    protected static String nl;

    public static synchronized eclipsevariables create(String lineSeparator) {
        nl = lineSeparator;
        eclipsevariables result = new eclipsevariables();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = "#Wed Jan 04 10:05:55 CET 2012"
            + NL
            + "eclipse.preferences.version=1"
            + NL
            + "org.eclipse.core.variables.valueVariables=<?xml version\\=\"1.0\" encoding\\=\"UTF-8\" standalone\\=\"no\"?><valueVariables><valueVariable description\\=\"\" name\\=\"relengDir\" readOnly\\=\"false\" value\\=\"${system_property\\:relengDir}\"/><valueVariable description\\=\"\" name\\=\"build.root\" readOnly\\=\"false\" value\\=\"${system_property\\:build.root}\"/><valueVariable description\\=\"\" name\\=\"tools\" readOnly\\=\"false\" value\\=\"${system_property\\:tools}\"/><valueVariable description\\=\"\" name\\=\"result\" readOnly\\=\"false\" value\\=\"${system_property\\:result}\"/><valueVariable description\\=\"\" name\\=\"publish\" readOnly\\=\"false\" value\\=\"${system_property\\:publish}\"/><valueVariable description\\=\"\" name\\=\"workspace\" readOnly\\=\"false\" value\\=\"${system_property\\:workspace}\"/><valueVariable description\\=\"\" name\\=\"timestamp\" readOnly\\=\"false\" value\\=\"${system_property\\:timestamp}\"/>";
    protected final String TEXT_3 = "<valueVariable description\\=\"\" name\\=\"";
    protected final String TEXT_4 = "\" readOnly\\=\"false\" value\\=\"${system_property\\:";
    protected final String TEXT_5 = "}\"/>";
    protected final String TEXT_6 = "</valueVariables>" + NL;
    protected final String TEXT_7 = NL;
    protected final String TEXT_8 = NL;

    public eclipsevariables() {
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

        List<Object> jobList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object jobParameter : jobList) {

            this.job = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Job) jobParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_7);
        stringBuffer.append(TEXT_8);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        method_content(new StringBuffer(), ictx);

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("job", this.job);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("job", this.job);
        return parameters;
    }

    protected void method_setFileName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        fileName = "org.eclipse.core.variables.prefs";
        stringBuffer.append(TEXT_1);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setFileName", stringBuffer.toString());
    }

    protected void method_alterFilePath(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        filePath = filePath + "/releng/templates/";
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "alterFilePath", stringBuffer.toString());
    }

    protected void method_content(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_2);
        for (String key : new GenerationHelper().getAllPropertiesKeys(job)) {
            stringBuffer.append(TEXT_3);
            stringBuffer.append(key);
            stringBuffer.append(TEXT_4);
            stringBuffer.append(key);
            stringBuffer.append(TEXT_5);
        }
        stringBuffer.append(TEXT_6);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "content", stringBuffer.toString());
    }
}