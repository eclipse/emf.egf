package org.eclipse.egf.core.test.pattern;

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

public class JunitConsoleReporter implements PatternExecutionReporter {

    public void executionFinished(String output, PatternContext context) {
        System.out.println("exec finished:");
        System.out.println(output);

    }

    public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
        System.out.println("loop finished:");
        System.out.println(output);

    }

}
