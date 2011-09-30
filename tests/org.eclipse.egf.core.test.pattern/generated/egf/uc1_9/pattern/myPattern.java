package egf.uc1_9.pattern;

import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.common.helper.*;

public class myPattern {

	public myPattern() {
		//Here is the constructor
		// add initialisation of the pattern variables (declaration has been already done).
	}

	public void generate(Object argument) throws Exception {
		InternalPatternContext ctx = (InternalPatternContext) argument;
		IQuery.ParameterDescription paramDesc = null;
		Map<String, String> queryCtx = null;
		Node.Container currentNode = ctx.getNode();

		if (preCondition())
			orchestration((PatternContext) argument);

		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		Node.Container currentNode = ictx.getNode();
		ictx.setNode(currentNode);
		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
		}
		return loop;
	}

	protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
		//default content

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "org.eclipse.egf.model.pattern.impl.PatternMethodImpl@11ba9df (description: null) (name: body) (patternFilePath: platform:/plugin/org.eclipse.egf.core.test.pattern/templates/pattern._ZjRQ4NlfEeCsc6vQ20O_Mw/method._ZjRQ5dlfEeCsc6vQ20O_Mw.pt)", out.toString());
	}

	public boolean preCondition() throws Exception {
		return true;
	}

}
