package org.eclipse.egf.portfolio.eclipse.build;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class XmlHeader {
    protected static String nl;

    public static synchronized XmlHeader create(String lineSeparator) {
        nl = lineSeparator;
        XmlHeader result = new XmlHeader();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<!--";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL + "-->" + NL;
    protected final String TEXT_4 = NL;
    protected final String TEXT_5 = NL;

    public XmlHeader() {
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

        stringBuffer.append(TEXT_4);
        stringBuffer.append(TEXT_5);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        method_body(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            ictx.clearBuffer();
        }
        return loop;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(ctx.getValue("copyright"));
        stringBuffer.append(TEXT_3);
    }

    public boolean preCondition() throws Exception {
        return true;
    }
}