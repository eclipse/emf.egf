package org.eclipse.egf.emf.pattern.base;

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.query.IQuery;

@SuppressWarnings("all")
public class GenAbstract {
    protected static String nl;

    public static synchronized GenAbstract create(String lineSeparator) {
        nl = lineSeparator;
        GenAbstract result = new GenAbstract();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "//default content";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public GenAbstract() {
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

        stringBuffer.append(TEXT_2);
        stringBuffer.append(TEXT_3);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int index = 0, executionIndex = ictx.getExecutionBuffer().length();

        method_setGenModel(ictx.getBuffer(), ictx);

        method_putGenModelInContext(ictx.getBuffer(), ictx);

        method_setChildVariables(ictx.getBuffer(), ictx);

        method_setReporterVariables(ictx.getBuffer(), ictx);

        method_putReporterVariablesInContext(ictx.getBuffer(), ictx);

        method_putCanGenerateInContext(ictx.getBuffer(), ictx);

        method_putContentTypeInContext(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        return loop;
    }

    protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel = null;
    protected java.lang.Object arguments = null;
    protected java.lang.Boolean canGenerate = null;

    protected void method_setGenModel(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    }

    protected void method_putGenModelInContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        ctx.setValue("genModel", genModel);

    }

    protected void method_setChildVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    }

    protected void method_setReporterVariables(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
    }

    protected void method_putReporterVariablesInContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    }

    protected void method_putCanGenerateInContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        ctx.setValue("canGenerate", canGenerate);

    }

    protected void method_putContentTypeInContext(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        ctx.setValue("contentType", ContentType.Undefined);

    }

    protected void method_preGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    }

    protected void method_postGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

    }
}