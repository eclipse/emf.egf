//Generated on Wed Oct 26 15:29:07 CEST 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildrmaplocal extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildrmaplocationadd {
	protected static String nl;

	public static synchronized buildrmaplocal create(String lineSeparator) {
		nl = lineSeparator;
		buildrmaplocal result = new buildrmaplocal();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "\t<locator searchPathRef=\"";
	protected final String TEXT_2 = "\" ";
	protected final String TEXT_3 = " failOnError=\"false\" />" + NL + "\t<searchPath name=\"";
	protected final String TEXT_4 = "\">" + NL + "\t    <!-- provider for windows -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"local\" source=\"true\">" + NL + "\t\t\t<uri format=\"file:/";
	protected final String TEXT_5 = "/{0}";
	protected final String TEXT_6 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t    <!-- provider for unix -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"local\" source=\"true\">" + NL + "\t\t\t<uri format=\"file://";
	protected final String TEXT_7 = "/{0}";
	protected final String TEXT_8 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t</searchPath>" + NL + NL;
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = NL;

	public buildrmaplocal() {
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

		paramDesc = new IQuery.ParameterDescription("localBuildLocation", "http://www.eclipse.org/egf/1.0.1/buildstep#//LocalBuildLocation");
		queryCtx = new HashMap<String, String>();
		List<Object> localBuildLocationList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object localBuildLocationParameter : localBuildLocationList) {

			this.localBuildLocation = (org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation) localBuildLocationParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
		}

		stringBuffer.append(TEXT_9);
		stringBuffer.append(TEXT_10);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = Node.flattenWithoutCallback(ictx.getNode());
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("localBuildLocation", this.localBuildLocation);
			String outputWithCallBack = Node.flatten(ictx.getNode());
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation localBuildLocation = null;

	public void set_localBuildLocation(org.eclipse.egf.portfolio.eclipse.build.buildstep.LocalBuildLocation object) {
		this.localBuildLocation = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("localBuildLocation", this.localBuildLocation);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		String id = new GenerationHelper().getIdOrPositionString(localBuildLocation);
		stringBuffer.append(TEXT_1);
		stringBuffer.append(id);
		stringBuffer.append(TEXT_2);
		stringBuffer.append(new GenerationHelper().getPatternString(localBuildLocation));
		stringBuffer.append(TEXT_3);
		stringBuffer.append(id);
		stringBuffer.append(TEXT_4);
		stringBuffer.append(localBuildLocation.getPath());
		stringBuffer.append(TEXT_5);
		stringBuffer.append(new GenerationHelper().getStringIfNotNull(localBuildLocation.getSuffix()));
		stringBuffer.append(TEXT_6);
		stringBuffer.append(localBuildLocation.getPath());
		stringBuffer.append(TEXT_7);
		stringBuffer.append(new GenerationHelper().getStringIfNotNull(localBuildLocation.getSuffix()));
		stringBuffer.append(TEXT_8);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}
}