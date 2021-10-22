//Generated with EGF 1.6.3.202110181143
package org.eclipse.egf.portfolio.eclipse.build.buckminster;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildxml extends org.eclipse.egf.portfolio.eclipse.build.JobFilePattern {
	protected static String nl;

	public static synchronized buildxml create(String lineSeparator) {
		nl = lineSeparator;
		buildxml result = new buildxml();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "<project name=\"project\" default=\"all\">" + NL;
	protected final String TEXT_2 = "    <property environment=\"env\" />" + NL + "" + NL
			+ "\t<property name=\"relengDir\" value=\"${basedir}\"/>" + NL + "\t<tstamp>" + NL
			+ "\t\t<format property=\"myTimestamp\" pattern=\"yyyyMMdd-HHmm\"/>" + NL + "\t</tstamp>" + NL;
	protected final String TEXT_3 = NL + "    <condition property=\"";
	protected final String TEXT_4 = "\" value=\"${";
	protected final String TEXT_5 = "}\">" + NL + "        <isset property=\"";
	protected final String TEXT_6 = "\" />" + NL + "    </condition>";
	protected final String TEXT_7 = NL + NL + "    <property file=\"build.properties\" />" + NL + NL;
	protected final String TEXT_8 = "    <!-- This macro executes the default application of an eclipse installation that resides"
			+ NL + "         in the folder ${buildtools}/@app" + NL + "      -->" + NL
			+ "    <macrodef name=\"eclipse.launch\">" + NL + "        <attribute name=\"app\" />" + NL
			+ "        <attribute name=\"workspace\" default=\"${workspace}\" />" + NL
			+ "        <element name=\"args\" optional=\"true\" />" + NL + "        <sequential>" + NL
			+ "            <!-- We assume that the eclipse installation is beneath ${tools} -->" + NL
			+ "            <property name=\"@{app}.deploy.dir\" value=\"${tools}/@{app}\" />" + NL + "" + NL
			+ "            <!-- Find the Eclipse launcher and assing its location to the @{app}.launcher property -->"
			+ NL + "            <pathconvert property=\"@{app}.launcher\">" + NL + "                <first count=\"1\">"
			+ NL + "                    <sort>" + NL
			+ "                        <fileset dir=\"${@{app}.deploy.dir}/plugins\" includes=\"**/org.eclipse.equinox.launcher_*.jar\" />"
			+ NL + "                        <reverse xmlns=\"antlib:org.apache.tools.ant.types.resources.comparators\">"
			+ NL + "                            <date />" + NL + "                        </reverse>" + NL
			+ "                    </sort>" + NL + "                </first>" + NL + "            </pathconvert>" + NL
			+ "" + NL + "\t\t\t<!-- Copy Eclipse Variables preferences -->" + NL
			+ "\t\t\t<copy file=\"${relengDir}/templates/org.eclipse.core.variables.prefs\"" + NL
			+ "\t\t\t\ttoFile=\"@{workspace}/.metadata/.plugins/org.eclipse.core.runtime/.settings/org.eclipse.core.variables.prefs\"/>"
			+ NL + "" + NL + "            <!-- Launch the eclipse application -->" + NL
			+ "            <java fork=\"true\" jar=\"${@{app}.launcher}\" dir=\"${@{app}.deploy.dir}\" failonerror=\"true\">";
	protected final String TEXT_9 = NL;
	protected final String TEXT_10 = NL + "\t                <jvmarg value=\"-DrelengDir=relengDir\"/>";
	protected final String TEXT_11 = NL + "\t                <jvmarg value=\"-D";
	protected final String TEXT_12 = "=${";
	protected final String TEXT_13 = "}\"/>";
	protected final String TEXT_14 = NL + "                    <arg value=\"-data\" />" + NL
			+ "                    <arg value=\"@{workspace}\" />" + NL + "                <args />" + NL
			+ "            </java>" + NL + "        </sequential>" + NL + "    </macrodef>" + NL;
	protected final String TEXT_15 = "    <target name=\"install.director\">" + NL
			+ "        <available file=\"${tools}/director/director\" property=\"director.exists\" />" + NL
			+ "        <antcall target=\"do.install.director\" />" + NL + "    </target>" + NL + "    " + NL
			+ "    <target name=\"do.install.director\" unless=\"director.exists\">" + NL
			+ "        <echo message=\"Fetching headless director application\" />" + NL
			+ "        <tempfile destdir=\"${java.io.tmpdir}\" prefix=\"director-\" suffix=\".zip\" property=\"director.zip\" deleteonexit=\"true\" />"
			+ NL + "        <get src=\"${director.url}\" dest=\"${director.zip}\" />" + NL
			+ "        <mkdir dir=\"${tools}\" />" + NL + "        <unzip src=\"${director.zip}\" dest=\"${tools}\" />"
			+ NL + "        <delete file=\"${director.zip}\" />" + NL + "    </target>" + NL;
	protected final String TEXT_16 = "    <target name=\"install.buckminster\">" + NL
			+ "        <available file=\"${tools}/buckminster/buckminster\" property=\"buckminster.exists\" />" + NL
			+ "        <antcall target=\"do.install.buckminster\" />" + NL + "\t</target>" + NL + "\t" + NL
			+ "    <target name=\"do.install.buckminster\" unless=\"buckminster.exists\" depends=\"install.director\">"
			+ NL + "        <echo message=\"Configuring headless buckminster with needed features\" />" + NL
			+ "        <echo message=\"Headless site: ${bm.headless.site}\" />" + NL
			+ "        <echo message=\"External site: ${bm.external.site}\" />" + NL
			+ "        <eclipse.launch app=\"director\">" + NL + "            <args>" + NL
			+ "                <jvmarg value=\"-Declipse.p2.mirrors=false\" />" + NL
			+ "                <arg value=\"-r\" />" + NL + "                <arg value=\"${bm.headless.site}\" />" + NL
			+ "                <arg value=\"-r\" />" + NL + "                <arg value=\"${bm.external.site}\" />" + NL
			+ "                <arg value=\"-r\" />" + NL + "                <arg value=\"${polarion.site}\" />" + NL
			+ "                <arg value=\"-d\" />" + NL + "                <arg value=\"${tools}/buckminster\" />"
			+ NL + "                <arg value=\"-p\" />" + NL + "                <arg value=\"Buckminster\" />" + NL
			+ "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.buckminster.cmdline.product\" />" + NL
			+ "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.buckminster.core.headless.feature.feature.group\" />" + NL
			+ "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.buckminster.pde.headless.feature.feature.group\" />" + NL
			+ "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.buckminster.cvs.headless.feature.feature.group\" />" + NL
			+ "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.buckminster.subversive.headless.feature.feature.group\" />" + NL
			+ "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.buckminster.git.headless.feature.feature.group\" />" + NL
			+ "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.buckminster.emma.headless.feature.feature.group\" />" + NL
			+ "            </args>" + NL + "        </eclipse.launch>" + NL + "    </target>" + NL;
	protected final String TEXT_17 = "    <target name=\"install.egf\">" + NL
			+ "        <available file=\"${tools}/egf/eclipse.ini\" property=\"egf.exists\" />" + NL
			+ "        <antcall target=\"do.install.egf\" />" + NL + "\t</target>" + NL + "" + NL
			+ "\t<target name=\"do.install.egf\" unless=\"egf.exists\" depends=\"install.director\">" + NL
			+ "        <echo message=\"Configuring EGF with needed features\" />" + NL
			+ "        <echo message=\"EGF site: ${egf.site}\" />" + NL
			+ "        <echo message=\"EGF eclipse site: ${egf.eclipse.site}\" />" + NL
			+ "        <eclipse.launch app=\"director\">" + NL + "            <args>" + NL
			+ "                <jvmarg value=\"-Declipse.p2.mirrors=false\" />" + NL
			+ "                <arg value=\"-r\" />" + NL + "                <arg value=\"${egf.site}\" />" + NL
			+ "                <arg value=\"-r\" />" + NL + "                <arg value=\"${egf.eclipse.site}\" />" + NL
			+ "                <arg value=\"-d\" />" + NL + "                <arg value=\"${tools}/egf\" />" + NL
			+ "                <arg value=\"-p\" />" + NL + "                <arg value=\"EGF\" />" + NL
			+ "                <arg value=\"-i\" />" + NL + "                <arg value=\"org.eclipse.platform.ide\" />"
			+ NL + "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.egf.feature.group\" />" + NL
			+ "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.egf.portfolio.feature.group\" />" + NL
			+ "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.egf.portfolio.emf.feature.group\" />" + NL
			+ "                <arg value=\"-i\" />" + NL
			+ "                <arg value=\"org.eclipse.egf.portfolio.genchain.feature.group\" />" + NL
			+ "            </args>" + NL + "        </eclipse.launch>" + NL + "    </target>" + NL;
	protected final String TEXT_18 = "    <macrodef name=\"buckminster\">" + NL
			+ "        <attribute name=\"command\" />" + NL + "        <element name=\"globargs\" optional=\"true\" />"
			+ NL + "        <element name=\"cmdargs\" optional=\"true\" />" + NL + "        <sequential>" + NL
			+ "            <eclipse.launch app=\"buckminster\">" + NL + "                <args>" + NL
			+ "                    <jvmarg value=\"-Dbugfix.288796=true\"/>" + NL
			+ "                    <arg value=\"--loglevel\" />" + NL
			+ "                    <arg value=\"${buckminster.loglevel}\" />" + NL
			+ "                    <arg value=\"--displaystacktrace\" />" + NL + "                    <globargs />" + NL
			+ "                    <arg value=\"@{command}\" />" + NL + "                    <arg value=\"-P\" />" + NL
			+ "                    <arg value=\"${properties.tmp}\" />" + NL + "                    <cmdargs />" + NL
			+ "                </args>" + NL + "            </eclipse.launch>" + NL + "        </sequential>" + NL
			+ "    </macrodef>" + NL;
	protected final String TEXT_19 = "\t<macrodef name=\"egf\">" + NL + "        <element name=\"activities\" />" + NL
			+ "        <element name=\"globargs\" optional=\"true\" />" + NL
			+ "        <element name=\"cmdargs\" optional=\"true\" />" + NL + "        <sequential>" + NL
			+ "            <eclipse.launch app=\"egf\">" + NL + "                <args>" + NL
			+ "                    <arg value=\"-application\" />" + NL
			+ "                    <arg value=\"org.eclipse.egf.application.activity\" />" + NL
			+ "                    <arg value=\"-consoleLog\" />" + NL + "                    <globargs />" + NL
			+ "                    <arg value=\"-activities\" />" + NL + "                    <activities />" + NL
			+ "                    <cmdargs />" + NL + "                </args>" + NL + "            </eclipse.launch>"
			+ NL + "        </sequential>" + NL + "    </macrodef>" + NL;
	protected final String TEXT_20 = "\t<macrodef name=\"anteclipse\">" + NL
			+ "        <attribute name=\"buildfile\" default=\"${relengDir}/build.xml\" />" + NL
			+ "        <attribute name=\"target\" />" + NL + "        <element name=\"globargs\" optional=\"true\" />"
			+ NL + "        <sequential>" + NL + "            <eclipse.launch app=\"egf\">" + NL
			+ "                <args>" + NL + "\t\t\t\t\t<arg value=\"-application\" />" + NL
			+ "\t\t\t\t\t<arg value=\"org.eclipse.ant.core.antRunner\" />" + NL
			+ "\t\t\t\t\t<arg value=\"-consoleLog\" />" + NL + "                    <globargs />" + NL
			+ "\t\t\t\t\t<arg value=\"-buildfile\" />" + NL + "\t\t\t\t\t<arg value=\"@{buildfile}\" />" + NL
			+ "\t\t\t\t\t<arg value=\"@{target}\" />" + NL + "                </args>" + NL
			+ "            </eclipse.launch>" + NL + "        </sequential>" + NL + "    </macrodef>" + NL;
	protected final String TEXT_21 = "    <target name=\"clean.result\">" + NL
			+ "        <delete dir=\"${result}\" failonerror=\"true\" quiet=\"true\" />" + NL + "    </target>" + NL
			+ "" + NL + "    <target name=\"clean.workspace\">" + NL
			+ "        <delete dir=\"${workspace}\" failonerror=\"true\" quiet=\"true\" />" + NL + "    </target>" + NL
			+ "" + NL + "    <target name=\"clean.tools\">" + NL
			+ "        <delete dir=\"${tools}\" failonerror=\"true\" quiet=\"true\" />" + NL + "    </target>" + NL + ""
			+ NL + "    <target name=\"clean.all\">" + NL + "\t\t<antcall target=\"clean.workspace\" />" + NL
			+ "\t\t<antcall target=\"clean.result\" />" + NL + "\t\t<antcall target=\"clean.tools\" />" + NL
			+ "    </target>" + NL;
	protected final String TEXT_22 = "\t<target name=\"init\" depends=\"init.build.properties\" >" + NL
			+ "\t\t<echo message=\"Available variables are : \"/>" + NL
			+ "\t\t<echo message=\"Builtin $${relengDir} : ${relengDir}\" />";
	protected final String TEXT_23 = NL + "\t\t<echo message=\"";
	protected final String TEXT_24 = " $${";
	protected final String TEXT_25 = "} : ${";
	protected final String TEXT_26 = "}\" />";
	protected final String TEXT_27 = NL + "\t</target>" + NL + "" + NL + "    <target name=\"init.build.properties\">"
			+ NL + "        <!-- Echo relevant properties to a temporary file so that Buckminster can read them -->"
			+ NL
			+ "        <tempfile destdir=\"${java.io.tmpdir}\" prefix=\"build-\" suffix=\".properties\" deleteonexit=\"true\" property=\"properties.tmp\" />"
			+ NL + "        <echoproperties destfile=\"${properties.tmp}\">" + NL
			+ "            <!-- We don't want these. basedir in particular will cause problems if passed explicitly -->"
			+ NL + "            <propertyset negate=\"true\">" + NL + "                <propertyref name=\"basedir\" />"
			+ NL + "                <propertyref name=\"eclipse.home\" />" + NL
			+ "                <propertyref name=\"properties.tmp\" />" + NL
			+ "                <propertyref name=\"line.separator\" />" + NL
			+ "                <propertyref name=\"path.separator\" />" + NL
			+ "                <propertyref prefix=\"ant.\" />" + NL
			+ "                <propertyref prefix=\"file.\" />" + NL
			+ "                <propertyref prefix=\"java.\" />" + NL
			+ "                <propertyref prefix=\"sun.\" />" + NL
			+ "                <propertyref prefix=\"user.\" />" + NL + "            </propertyset>" + NL
			+ "        </echoproperties>" + NL + "    </target>" + NL + "\t" + NL;
	protected final String TEXT_28 = "</project>";

	public buildxml() {
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

		stringBuffer.append(TEXT_9);
		stringBuffer.append(TEXT_9);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		super.orchestration(new SuperOrchestrationContext(ictx));

		method_begin(new StringBuffer(), ictx);

		method_properties(new StringBuffer(), ictx);

		method_eclipse_launch(new StringBuffer(), ictx);

		method_install_director(new StringBuffer(), ictx);

		method_install_buckminster(new StringBuffer(), ictx);

		method_install_egf(new StringBuffer(), ictx);

		method_buckminster(new StringBuffer(), ictx);

		method_egf(new StringBuffer(), ictx);

		method_anteclipse(new StringBuffer(), ictx);

		method_cleans(new StringBuffer(), ictx);

		method_inits(new StringBuffer(), ictx);
		{
			ExecutionContext ctx_local = new ExecutionContext(ictx);
			ctx_local.setValue(PatternContext.INJECTED_CONTEXT, job);
			CallHelper.executeWithContextInjection(
					"platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_C_qLIJTYEd-fvPvNnKEvJg",
					ctx_local);
		}

		method_end(new StringBuffer(), ictx);

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

	protected void method_setFileName(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		fileName = "build.xml";
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "setFileName", stringBuffer.toString());
	}

	protected void method_alterFilePath(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		filePath = filePath + "/releng/";
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "alterFilePath", stringBuffer.toString());
	}

	protected void method_begin(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		{
			//<%@ egf:patternCall
			//	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.XmlHeader"
			//%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_LhlsYJ5OEd-3wvN5SnesGA",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_1);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "begin", stringBuffer.toString());
	}

	protected void method_properties(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_2);
		for (PropertyWrapper propertyWrapper : new PropertiesHelper().getRuntimeProperties(job)) {
			stringBuffer.append(TEXT_3);
			stringBuffer.append(propertyWrapper.getKey());
			stringBuffer.append(TEXT_4);
			stringBuffer.append(propertyWrapper.getEnvKey());
			stringBuffer.append(TEXT_5);
			stringBuffer.append(propertyWrapper.getEnvKey());
			stringBuffer.append(TEXT_6);
		}
		stringBuffer.append(TEXT_7);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "properties", stringBuffer.toString());
	}

	protected void method_eclipse_launch(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_8);
		stringBuffer.append(TEXT_9);
		{
			//<%@ egf:patternCall
			//	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.buckminster.call.build.xml.Xmx"
			//%>

			InternalPatternContext ictx = (InternalPatternContext) ctx;
			new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
			stringBuffer.setLength(0);

			final Map<String, Object> callParameters = new HashMap<String, Object>();
			CallHelper.executeWithParameterInjection(
					"platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_VCSRcJ5MEd-3wvN5SnesGA",
					new ExecutionContext((InternalPatternContext) ctx), callParameters);
			stringBuffer.setLength(0);
		}

		stringBuffer.append(TEXT_10);
		for (PropertyWrapper propertyWrapper : new PropertiesHelper().getRuntimeProperties(job)) {
			stringBuffer.append(TEXT_11);
			stringBuffer.append(propertyWrapper.getKey());
			stringBuffer.append(TEXT_12);
			stringBuffer.append(propertyWrapper.getKey());
			stringBuffer.append(TEXT_13);
		}
		stringBuffer.append(TEXT_14);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "eclipse_launch", stringBuffer.toString());
	}

	protected void method_install_director(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_15);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "install_director", stringBuffer.toString());
	}

	protected void method_install_buckminster(final StringBuffer stringBuffer, final PatternContext ctx)
			throws Exception {

		stringBuffer.append(TEXT_16);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "install_buckminster", stringBuffer.toString());
	}

	protected void method_install_egf(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_17);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "install_egf", stringBuffer.toString());
	}

	protected void method_buckminster(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_18);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "buckminster", stringBuffer.toString());
	}

	protected void method_egf(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_19);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "egf", stringBuffer.toString());
	}

	protected void method_anteclipse(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_20);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "anteclipse", stringBuffer.toString());
	}

	protected void method_cleans(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_21);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "cleans", stringBuffer.toString());
	}

	protected void method_inits(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_22);
		for (PropertyWrapper propertyWrapper : new PropertiesHelper().getRuntimeProperties(job)) {
			stringBuffer.append(TEXT_23);
			stringBuffer.append(propertyWrapper.getType());
			stringBuffer.append(TEXT_24);
			stringBuffer.append(propertyWrapper.getKey());
			stringBuffer.append(TEXT_25);
			stringBuffer.append(propertyWrapper.getKey());
			stringBuffer.append(TEXT_26);
		}
		stringBuffer.append(TEXT_27);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "inits", stringBuffer.toString());
	}

	protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		stringBuffer.append(TEXT_28);
		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "end", stringBuffer.toString());
	}
}