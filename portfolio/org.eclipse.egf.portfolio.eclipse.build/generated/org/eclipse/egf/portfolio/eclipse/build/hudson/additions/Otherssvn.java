//Generated on Wed Nov 30 10:57:37 CET 2011 with EGF 0.6.1.qualifier
package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class Otherssvn extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Othersadd {
	protected static String nl;

	public static synchronized Otherssvn create(String lineSeparator) {
		nl = lineSeparator;
		Otherssvn result = new Otherssvn();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "  <scm class=\"hudson.scm.SubversionSCM\">" + NL + "    <locations>";
	protected final String TEXT_2 = NL + "      <hudson.scm.SubversionSCM_-ModuleLocation>" + NL + "        <remote>";
	protected final String TEXT_3 = "</remote>" + NL + "        <local>svn/";
	protected final String TEXT_4 = "</local>" + NL + "      </hudson.scm.SubversionSCM_-ModuleLocation>";
	protected final String TEXT_5 = NL + "    </locations>" + NL + "    <useUpdate>true</useUpdate>" + NL + "    <doRevert>true</doRevert>" + NL + "    <excludedRegions></excludedRegions>" + NL + "    <includedRegions></includedRegions>" + NL + "    <excludedUsers></excludedUsers>" + NL + "    <excludedRevprop></excludedRevprop>" + NL + "    <excludedCommitMessages></excludedCommitMessages>" + NL + "  </scm>" + NL;
	protected final String TEXT_6 = NL;
	protected final String TEXT_7 = NL;

	public Otherssvn() {
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

		paramDesc = new IQuery.ParameterDescription("svn", "http://www.eclipse.org/egf/1.0.0/buildscm#//SVN");
		queryCtx = new HashMap<String, String>();
		List<Object> svnList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

		for (Object svnParameter : svnList) {

			this.svn = (org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN) svnParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.getOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_6);
		stringBuffer.append(TEXT_7);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		String loop = OutputManager.getOutputWithoutCallback(ictx);
		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("svn", this.svn);
			String outputWithCallBack = OutputManager.getOutput(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
			;
		}
		return loop;
	}

	protected org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN svn = null;

	public void set_svn(org.eclipse.egf.portfolio.eclipse.build.buildscm.SVN object) {
		this.svn = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("svn", this.svn);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		Iterator<SVNLocation> iterator = svn.getLocations().iterator();
		while (iterator.hasNext()) {
			SVNLocation svnLocation = iterator.next();
			stringBuffer.append(TEXT_2);
			stringBuffer.append(svnLocation.getProtocol().getLiteral());
			stringBuffer.append(svnLocation.getUrl());
			stringBuffer.append(TEXT_3);
			stringBuffer.append(new GenerationHelper().getStringIfNotNull(svnLocation.getLocalPath()));
			stringBuffer.append(TEXT_4);
		}
		stringBuffer.append(TEXT_5);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition() {
		return true;
	}
}