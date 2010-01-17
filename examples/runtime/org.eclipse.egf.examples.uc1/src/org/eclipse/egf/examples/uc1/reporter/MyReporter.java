package org.eclipse.egf.examples.uc1.reporter;

import java.util.Map;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

public class MyReporter implements PatternExecutionReporter {

  public void executionFinished(String output, PatternContext context) {
		String outputMessage = new String ("Result of pattern:\n"+output);
		// Message on the default console
		System.out.println(outputMessage);
		// Message on the EGF console
	    EGFCorePlugin.getDefault().logInfo(outputMessage); 		  
  }

  public void loopFinished(String output, PatternContext context, Map<String, Object> parameterValues) {
    // TODO Auto-generated method stub
  }

}
