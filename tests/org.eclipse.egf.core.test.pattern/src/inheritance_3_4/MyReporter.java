package inheritance_3_4;

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternExecutionReporter;

public class MyReporter implements PatternExecutionReporter{

	public void executionFinished(String output, PatternContext context) {
		System.out.println("exec finished:");
		System.out.println(output);
		
	} 

	public void loopFinished(String output, PatternContext context,
			Map<String, Object> parameterValues) {
		System.out.println("loop finished:");
		System.out.println(output);
		
	}

}
