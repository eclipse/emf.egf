package org.eclipse.egf.portfolio.eclipse.build;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

import java.io.*;

public class TextHeader {

    public TextHeader() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;

        if (preCondition())
            orchestration((PatternContext) argument);

        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }
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

    protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
        String copyright = (String) ctx.getValue("copyright");
        BufferedReader reader = new BufferedReader(new StringReader(copyright));
        String line = "";
        while ((line = reader.readLine()) != null) {
            out.append("#");
            out.append(line);
            out.append("\n");
        }
    }

    public boolean preCondition() throws Exception {
        return true;
    }

}
