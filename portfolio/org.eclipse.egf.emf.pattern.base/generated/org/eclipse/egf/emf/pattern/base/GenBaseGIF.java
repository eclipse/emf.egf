package org.eclipse.egf.emf.pattern.base;

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.execution.SuperOrchestrationContext;
import org.eclipse.egf.pattern.query.IQuery;

@SuppressWarnings("all")
public class GenBaseGIF extends org.eclipse.egf.emf.pattern.base.GenAbstract {
    protected static String nl;

    public static synchronized GenBaseGIF create(String lineSeparator) {
        nl = lineSeparator;
        GenBaseGIF result = new GenBaseGIF();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "";
    protected final String TEXT_2 = NL;

    public GenBaseGIF() {
        // Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been
        // already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

        orchestration(ctx);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_1);
        stringBuffer.append(TEXT_2);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int index = 0, executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        String loop = ictx.getBuffer().toString();
        return loop;
    }

    protected java.lang.String targetPathName = null;

    protected void method_putContentTypeInContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        ctx.setValue("contentType", ContentType.GIF);

    }
}