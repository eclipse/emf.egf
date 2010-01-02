package org.eclipse.egf.examples.uc1.reporter;

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

public class MyReporter implements PatternExecutionReporter{

	@Override
	public void executionFinished(String output, PatternContext context) {
		System.out.println("Result of pattern:\n"+output);
		
	}

	@Override
	public void loopFinished(String output, PatternContext context,
			Map<String, Object> parameterValues) {
		// TODO Auto-generated method stub
		
	}

}
