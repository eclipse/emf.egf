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

        if (preCondition())
            orchestration(ctx);

        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(TEXT_3);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        method_setFileName(ictx.getBuffer(), ictx);

        method_setFilePath(ictx.getBuffer(), ictx);

        method_setContext(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            ictx.clearBuffer();
        }
        return loop;
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

    }

    protected void method_setFilePath(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
    }

    protected void method_setContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        ctx.setValue("filePath", filePath);
        ctx.setValue("fileName", fileName);
    }

    public boolean preCondition() throws Exception {
        return true;
    }
}