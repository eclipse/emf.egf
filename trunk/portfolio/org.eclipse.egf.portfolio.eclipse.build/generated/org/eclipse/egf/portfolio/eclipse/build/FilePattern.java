//Generated on Tue Aug 06 15:15:13 CEST 2013 with EGF 1.0.0.qualifier
package org.eclipse.egf.portfolio.eclipse.build;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class FilePattern {
    protected static String nl;

    public static synchronized FilePattern create(String lineSeparator) {
        nl = lineSeparator;
        FilePattern result = new FilePattern();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "//default content";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public FilePattern() {
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

        if (preCondition(ctx)) {
            ctx.setNode(new Node.Container(currentNode, getClass()));
            orchestration(ctx);
        }

        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(TEXT_3);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        method_setFileName(new StringBuffer(), ictx);

        method_setFilePath(new StringBuffer(), ictx);

        method_alterFilePath(new StringBuffer(), ictx);

        method_setContext(new StringBuffer(), ictx);

        return null;
    }

    protected java.lang.String filePath = null;

    public void set_filePath(java.lang.String object) {
        this.filePath = object;
    }

    protected java.lang.String fileName = null;

    public void set_fileName(java.lang.String object) {
        this.fileName = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        return parameters;
    }

    protected void method_setFileName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setFileName", stringBuffer.toString());
    }

    protected void method_setFilePath(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setFilePath", stringBuffer.toString());
    }

    protected void method_alterFilePath(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "alterFilePath", stringBuffer.toString());
    }

    protected void method_setContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        ctx.setValue("filePath", filePath);
        ctx.setValue("fileName", fileName);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setContext", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return true;
    }
}