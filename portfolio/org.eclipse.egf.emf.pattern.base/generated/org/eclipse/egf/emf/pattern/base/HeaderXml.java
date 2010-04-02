package org.eclipse.egf.emf.pattern.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.execution.SuperOrchestrationContext;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;

@SuppressWarnings("all")
public class HeaderXml extends org.eclipse.egf.emf.pattern.base.HeaderAbstract {
    protected static String nl;

    public static synchronized HeaderXml create(String lineSeparator) {
        nl = lineSeparator;
        HeaderXml result = new HeaderXml();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "<!--";
    protected final String TEXT_2 = NL + " ";
    protected final String TEXT_3 = NL + " <copyright>" + NL + " </copyright>";
    protected final String TEXT_4 = NL;
    protected final String TEXT_5 = NL + " ";
    protected final String TEXT_6 = "Id";
    protected final String TEXT_7 = NL + "-->";
    protected final String TEXT_8 = NL;
    protected final String TEXT_9 = NL;

    public HeaderXml() {
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

        List<Object> argumentList = null;
        // this pattern can only be called by another (i.e. it's not an entry
        // point in execution)

        for (Object argumentParameter : argumentList) {

            this.argument = (java.lang.Object) argumentParameter;

            orchestration(ctx);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_8);
        stringBuffer.append(TEXT_9);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int index = 0, executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(index));
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("argument", this.argument);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        {
            GenBase copyrightHolder = argument instanceof GenBase ? (GenBase) argument : argument instanceof Object[] && ((Object[]) argument)[0] instanceof GenBase ? (GenBase) ((Object[]) argument)[0] : null;
            if (copyrightHolder != null && copyrightHolder.hasCopyright()) {
                stringBuffer.append(TEXT_2);
                stringBuffer.append(copyrightHolder.getCopyright(copyrightHolder.getGenModel().getIndentation(stringBuffer)));
            } else {
                stringBuffer.append(TEXT_3);
            }
        }
        stringBuffer.append(TEXT_4);
        stringBuffer.append(TEXT_5);
        stringBuffer.append("$");
        stringBuffer.append(TEXT_6);
        stringBuffer.append("$");
        stringBuffer.append(TEXT_7);
    }
}