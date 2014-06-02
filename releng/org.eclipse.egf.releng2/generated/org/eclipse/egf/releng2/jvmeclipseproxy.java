//Generated on Tue May 13 16:16:28 CEST 2014 with EGF 1.1.0.qualifier
package org.eclipse.egf.releng2;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class jvmeclipseproxy extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmlXmx {
	protected static String nl;

	public static synchronized jvmeclipseproxy create(String lineSeparator) {
		nl = lineSeparator;
		jvmeclipseproxy result = new jvmeclipseproxy();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "                    <jvmarg value=\"-Xmx1024m\"/>" + NL + "                    <jvmarg value=\"-XX:MaxPermSize=256m\"/>" + NL + "                    " + NL + "                    <jvmarg value=\"-Dhttp.proxyHost=proxy.eclipse.org\"/>" + NL
			+ "                    <jvmarg value=\"-Dhttp.proxyPort=9898\"/>" + NL + "                    <jvmarg value=\"-Dhttps.proxyHost=proxy.eclipse.org\"/>" + NL + "                    <jvmarg value=\"-Dhttps.proxyPort=9898\"/>" + NL
			+ "                    <jvmarg value=\"-Dhttp.nonProxyHosts=*.eclipse.org\"/>" + NL + "                    <jvmarg value=\"-Dhttps.nonProxyHosts=*.eclipse.org\"/>" + NL + "                    <jvmarg value=\"-Dftp.proxyHost=proxy.eclipse.org\"/>" + NL
			+ "                    <jvmarg value=\"-Dftp.proxyPort=9898\"/>" + NL + "                    <jvmarg value=\"-Dftp.nonProxyHosts=*.eclipse.org\"/>" + NL + NL;
	protected final String TEXT_2 = NL;
	protected final String TEXT_3 = NL;

	public jvmeclipseproxy() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		if (preCondition(ctx)) {
			ctx.setNode(new Node.Container(currentNode, getClass()));
			orchestration(ctx);
		}

		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_3);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}