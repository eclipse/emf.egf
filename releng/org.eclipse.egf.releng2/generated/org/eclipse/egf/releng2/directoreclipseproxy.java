//Generated on Mon Jun 02 18:06:26 CEST 2014 with EGF 1.1.0.qualifier
package org.eclipse.egf.releng2;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class directoreclipseproxy extends org.eclipse.egf.portfolio.eclipse.build.buckminster.buildxml {
	protected static String nl;

	public static synchronized directoreclipseproxy create(String lineSeparator) {
		nl = lineSeparator;
		directoreclipseproxy result = new directoreclipseproxy();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "    <target name=\"install.director\">" + NL + "        <available file=\"${tools}/director/director\" property=\"director.exists\" />" + NL + "        <antcall target=\"do.install.director\" />" + NL + "    </target>" + NL + "    " + NL
			+ "    <target name=\"do.install.director\" unless=\"director.exists\">" + NL + "        <echo message=\"Fetching headless director application\" />" + NL
			+ "        <tempfile destdir=\"${java.io.tmpdir}\" prefix=\"director-\" suffix=\".zip\" property=\"director.zip\" deleteonexit=\"true\" />" + NL + "        <get src=\"${director.url}\" dest=\"${director.zip}\" />" + NL + "        <mkdir dir=\"${tools}\" />" + NL
			+ "        <unzip src=\"${director.zip}\" dest=\"${tools}\" />" + NL + "        <delete file=\"${director.zip}\" />" + NL + "" + NL + "        <echo message=\"install eclipse proxy\"/>" + NL + "        <mkdir dir=\"${tools}/director/configuration/.settings/\"/>" + NL
			+ "<echo file=\"${tools}/director/configuration/.settings/org.eclipse.core.net.prefs\">#Fri May 17 19:15:07 CEST 2013" + NL + "systemProxiesEnabled=false" + NL + "org.eclipse.core.net.hasMigrated=true" + NL + "proxyData/HTTPS/port=9898" + NL
			+ "proxyData/HTTP/host=proxy.eclipse.org" + NL + "nonProxiedHosts=172.30.206.*|localhost|127.0.0.1" + NL + "proxyData/HTTP/hasAuth=false" + NL + "proxyData/HTTP/port=9898" + NL + "eclipse.preferences.version=1" + NL + "proxyData/HTTPS/hasAuth=false" + NL
			+ "proxyData/HTTPS/host=proxy.eclipse.org" + NL + "" + NL + "</echo>" + NL + "    </target>";
	protected final String TEXT_2 = "    <target name=\"install.buckminster\">" + NL + "        <available file=\"${tools}/buckminster/buckminster\" property=\"buckminster.exists\" />" + NL + "        <antcall target=\"do.install.buckminster\" />" + NL + "\t</target>" + NL
			+ "\t" + NL + "    <target name=\"do.install.buckminster\" unless=\"buckminster.exists\" depends=\"install.director\">" + NL + "        <echo message=\"Configuring headless buckminster with needed features\" />" + NL
			+ "        <echo message=\"Headless site: ${bm.headless.site}\" />" + NL + "        <echo message=\"External site: ${bm.external.site}\" />" + NL + "        <eclipse.launch app=\"director\">" + NL + "            <args>" + NL
			+ "                <jvmarg value=\"-Declipse.p2.mirrors=false\" />" + NL + "                <arg value=\"-r\" />" + NL + "                <arg value=\"${bm.headless.site}\" />" + NL + "                <arg value=\"-d\" />" + NL
			+ "                <arg value=\"${tools}/buckminster\" />" + NL + "                <arg value=\"-p\" />" + NL + "                <arg value=\"Buckminster\" />" + NL + "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.buckminster.cmdline.product\" />" + NL + "                <arg value=\"-i\" />" + NL + "                <arg value=\"org.eclipse.buckminster.core.headless.feature.feature.group\" />" + NL
			+ "                <arg value=\"-i\" />" + NL + "                <arg value=\"org.eclipse.buckminster.pde.headless.feature.feature.group\" />" + NL + "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.buckminster.emma.headless.feature.feature.group\" />" + NL + "            </args>" + NL + "        </eclipse.launch>" + NL + "    </target>" + NL + "    " + NL;
	protected final String TEXT_3 = NL;
	protected final String TEXT_4 = NL;

	public directoreclipseproxy() {
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

		List<Object> jobList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object jobParameter : jobList) {

			this.job = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Job) jobParameter;

			if (preCondition(ctx)) {
				ctx.setNode(new Node.Container(currentNode, getClass()));
				orchestration(ctx);
			}

		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_3);
		stringBuffer.append(TEXT_4);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("job", this.job);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("job", this.job);
		return parameters;
	}

	protected void method_install_director(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "install_director", stringBuffer.toString());
	}

	protected void method_install_buckminster(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "install_buckminster", stringBuffer.toString());
	}
}