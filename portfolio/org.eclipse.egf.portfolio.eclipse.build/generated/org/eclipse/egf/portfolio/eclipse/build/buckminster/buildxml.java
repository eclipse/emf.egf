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
    protected final String TEXT_1 = "<project name=\"project\" default=\"all\">" + NL + "    <!--Property file containing overrides for the default properties -->" + NL + "    <property environment=\"env\" />" + NL + "    <property file=\"build.properties\" />" + NL + "" + NL + "\t<property name=\"relengDir\" value=\"${basedir}\"/>" + NL + "" + NL + "    <!-- if we are not running in Hudson, we some up with a reasonable default -->" + NL + "    <condition property=\"build.root\" value=\"${env.WORKSPACE}\" else=\"${relengDir}/../workspace\">" + NL + "        <isset property=\"env.WORKSPACE\" />" + NL + "    </condition>" + NL + "" + NL + "    <!--Default properties intended to be overridden by entries in the above property file. -->" + NL
            + "    <property name=\"tools\" location=\"${build.root}/tools\" />" + NL + "    <property name=\"result\" location=\"${build.root}/result\" />" + NL + "\t" + NL + "    <property name=\"workspace\" location=\"${result}/workspace\" />" + NL + "    <property name=\"publish\" location=\"${result}/publish\" />" + NL + "    <property name=\"buckminster.output.root\" location=\"${result}/output\" />" + NL + "    <property name=\"buckminster.temp.root\" location=\"${result}/temp\" />" + NL + "    <property name=\"eclipse.staging.area\" location=\"${result}/signing\" />" + NL + "" + NL + "    <!-- This macro executes the default application of an eclipse installation that resides" + NL + "         in the folder ${buildtools}/@app" + NL + "      -->" + NL
            + "    <macrodef name=\"eclipse.launch\">" + NL + "        <attribute name=\"app\" />" + NL + "        <element name=\"args\" optional=\"true\" />" + NL + "        <sequential>" + NL + "            <!-- We assume that the eclipse installation is beneath ${buildtools} -->" + NL + "            <property name=\"@{app}.deploy.dir\" value=\"${tools}/@{app}\" />" + NL + "" + NL + "            <!-- Find the Eclipse launcher and assing its location to the @{app}.launcher property -->" + NL + "            <pathconvert property=\"@{app}.launcher\">" + NL + "                <first count=\"1\">" + NL + "                    <sort>" + NL + "                        <fileset dir=\"${@{app}.deploy.dir}/plugins\" includes=\"**/org.eclipse.equinox.launcher_*.jar\" />" + NL
            + "                        <reverse xmlns=\"antlib:org.apache.tools.ant.types.resources.comparators\">" + NL + "                            <date />" + NL + "                        </reverse>" + NL + "                    </sort>" + NL + "                </first>" + NL + "            </pathconvert>" + NL + "" + NL + "            <!-- Launch the eclipse application -->" + NL + "            <java fork=\"true\" jar=\"${@{app}.launcher}\" dir=\"${@{app}.deploy.dir}\" failonerror=\"true\">" + NL + "                <args />" + NL + "            </java>" + NL + "        </sequential>" + NL + "    </macrodef>" + NL + "" + NL + "    <macrodef name=\"buckminster\">" + NL + "        <attribute name=\"command\" />" + NL + "        <attribute name=\"workspace\" default=\"${workspace}\" />"
            + NL + "        <element name=\"globargs\" optional=\"true\" />" + NL + "        <element name=\"cmdargs\" optional=\"true\" />" + NL + "        <sequential>" + NL + "            <eclipse.launch app=\"buckminster\">" + NL + "                <args>" + NL + "                    <jvmarg value=\"-Dbugfix.288796=true\"/>";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL + "                    <arg value=\"-data\" />" + NL + "                    <arg value=\"@{workspace}\" />" + NL + "                    <arg value=\"--loglevel\" />" + NL + "                    <arg value=\"${buckminster.loglevel}\" />" + NL + "                    <arg value=\"--displaystacktrace\" />" + NL + "                    <globargs />" + NL + "                    <arg value=\"@{command}\" />" + NL + "                    <arg value=\"-P\" />" + NL + "                    <arg value=\"${properties.tmp}\" />" + NL + "                    <cmdargs />" + NL + "                </args>" + NL + "            </eclipse.launch>" + NL + "        </sequential>" + NL + "    </macrodef>" + NL + "" + NL + "\t<macrodef name=\"egf\">" + NL
            + "        <attribute name=\"workspace\" default=\"${workspace}\" />" + NL + "        <element name=\"activities\" />" + NL + "        <element name=\"globargs\" optional=\"true\" />" + NL + "        <element name=\"cmdargs\" optional=\"true\" />" + NL + "        <sequential>" + NL + "            <eclipse.launch app=\"egf\">" + NL + "                <args>";
    protected final String TEXT_4 = NL;
    protected final String TEXT_5 = NL + "                    <arg value=\"-consoleLog\" />" + NL + "                    <arg value=\"-data\" />" + NL + "                    <arg value=\"@{workspace}\" />" + NL + "                    <globargs />" + NL + "                    <arg value=\"-activities\" />" + NL + "                    <activities />" + NL + "                    <cmdargs />" + NL + "                </args>" + NL + "            </eclipse.launch>" + NL + "        </sequential>" + NL + "    </macrodef>" + NL + "" + NL + "\t<macrodef name=\"anteclipse\">" + NL + "        <attribute name=\"workspace\" default=\"${workspace}\" />" + NL + "        <attribute name=\"buildfile\" default=\"${relengDir}/build.xml\" />" + NL + "        <attribute name=\"target\" />" + NL
            + "        <element name=\"globargs\" optional=\"true\" />" + NL + "        <sequential>" + NL + "            <eclipse.launch app=\"egf\">" + NL + "                <args>";
    protected final String TEXT_6 = NL;
    protected final String TEXT_7 = NL + "\t\t\t\t\t<arg value=\"-application\" />" + NL + "\t\t\t\t\t<arg value=\"org.eclipse.ant.core.antRunner\" />" + NL + "\t\t\t\t\t<arg value=\"-consoleLog\" />" + NL + "\t\t\t\t\t<arg value=\"-data\" />" + NL + "\t\t\t\t\t<arg value=\"@{workspace}\" />" + NL + "                    <globargs />" + NL + "\t\t\t\t\t<arg value=\"-buildfile\" />" + NL + "\t\t\t\t\t<arg value=\"@{buildfile}\" />" + NL + "\t\t\t\t\t<arg value=\"@{target}\" />" + NL + "                </args>" + NL + "            </eclipse.launch>" + NL + "        </sequential>" + NL + "    </macrodef>" + NL + "\t" + NL + "    <target name=\"init.checks\">" + NL + "        <available file=\"${tools}/director/director\" property=\"director.exists\" />" + NL
            + "        <available file=\"${tools}/buckminster/buckminster\" property=\"buckminster.exists\" />" + NL + "        <available file=\"${tools}/egf/eclipse.ini\" property=\"egf.exists\" />" + NL + "        <available file=\"${workspace}\" type=\"dir\" property=\"workspace.exists\" />" + NL + "    </target>" + NL + "\t" + NL + "    <target name=\"get.director\" unless=\"director.exists\">" + NL + "        <echo message=\"Fetching headless director application\" />" + NL + "        <tempfile destdir=\"${java.io.tmpdir}\" prefix=\"director-\" suffix=\".zip\" property=\"director.zip\" deleteonexit=\"true\" />" + NL + "        <get src=\"${director.url}\" dest=\"${director.zip}\" />" + NL + "        <mkdir dir=\"${tools}\" />" + NL
            + "        <unzip src=\"${director.zip}\" dest=\"${tools}\" />" + NL + "        <delete file=\"${director.zip}\" />" + NL + "    </target>" + NL + "" + NL + "    <target name=\"install.buckminster\" unless=\"buckminster.exists\" depends=\"get.director\">" + NL + "        <echo message=\"Configuring headless buckminster with needed features\" />" + NL + "        <echo message=\"Headless site: ${bm.headless.site}\" />" + NL + "        <echo message=\"External site: ${bm.external.site}\" />" + NL + "        <eclipse.launch app=\"director\">" + NL + "            <args>" + NL + "                <jvmarg value=\"-Declipse.p2.mirrors=false\" />" + NL + "                <arg value=\"-r\" />" + NL + "                <arg value=\"${bm.headless.site}\" />" + NL
            + "                <arg value=\"-r\" />" + NL + "                <arg value=\"${bm.external.site}\" />" + NL + "                <arg value=\"-r\" />" + NL + "                <arg value=\"${polarion.site}\" />" + NL + "                <arg value=\"-d\" />" + NL + "                <arg value=\"${tools}/buckminster\" />" + NL + "                <arg value=\"-p\" />" + NL + "                <arg value=\"Buckminster\" />" + NL + "                <arg value=\"-i\" />" + NL + "                <arg value=\"org.eclipse.buckminster.cmdline.product\" />" + NL + "                <arg value=\"-i\" />" + NL + "                <arg value=\"org.eclipse.buckminster.core.headless.feature.feature.group\" />" + NL + "                <arg value=\"-i\" />" + NL
            + "                <arg value=\"org.eclipse.buckminster.pde.headless.feature.feature.group\" />" + NL + "                <arg value=\"-i\" />" + NL + "                <arg value=\"org.eclipse.buckminster.cvs.headless.feature.feature.group\" />" + NL + "                <arg value=\"-i\" />" + NL + "                <arg value=\"org.eclipse.buckminster.subversive.headless.feature.feature.group\" />" + NL + "                <arg value=\"-i\" />" + NL + "                <arg value=\"org.eclipse.buckminster.emma.headless.feature.feature.group\" />" + NL + "            </args>" + NL + "        </eclipse.launch>" + NL + "    </target>" + NL + "" + NL + "\t<target name=\"install.egf\" unless=\"egf.exists\" depends=\"get.director\">" + NL
            + "        <echo message=\"Configuring EGF with needed features\" />" + NL + "        <echo message=\"EGF site: ${egf.site}\" />" + NL + "        <eclipse.launch app=\"director\">" + NL + "            <args>" + NL + "                <jvmarg value=\"-Declipse.p2.mirrors=false\" />" + NL + "                <arg value=\"-r\" />" + NL + "                <arg value=\"${egf.site}\" />" + NL + "                <arg value=\"-d\" />" + NL + "                <arg value=\"${tools}/egf\" />" + NL + "                <arg value=\"-p\" />" + NL + "                <arg value=\"EGF\" />" + NL + "                <arg value=\"-i\" />" + NL + "                <arg value=\"org.eclipse.egf.application.product\" />" + NL + "            </args>" + NL + "        </eclipse.launch>" + NL
            + "    </target>" + NL + "" + NL + "    <target name=\"clean.result\">" + NL + "        <delete dir=\"${result}\" failonerror=\"true\" quiet=\"true\" />" + NL + "    </target>" + NL + "" + NL + "    <target name=\"clean.workspace\">" + NL + "        <delete dir=\"${workspace}\" failonerror=\"true\" quiet=\"true\" />" + NL + "    </target>" + NL + "" + NL + "    <target name=\"clean.tools\">" + NL + "        <delete dir=\"${tools}\" failonerror=\"true\" quiet=\"true\" />" + NL + "    </target>" + NL + "" + NL + "    <target name=\"clean.build.root\">" + NL + "        <delete dir=\"${build.root}\" failonerror=\"true\" quiet=\"true\" />" + NL + "    </target>" + NL + "        " + NL + "    <target name=\"init.workspace\" unless=\"workspace.exists\">" + NL
            + "        <mkdir dir=\"${workspace}\" />" + NL + "    </target>" + NL + "" + NL + "    <target name=\"init.build.properties\">" + NL + "        <!-- Echo relevant properties to a temporary file so that Buckminster can read them -->" + NL + "        <tempfile destdir=\"${java.io.tmpdir}\" prefix=\"build-\" suffix=\".properties\" deleteonexit=\"true\" property=\"properties.tmp\" />" + NL + "        <echoproperties destfile=\"${properties.tmp}\">" + NL + "            <!-- We don't want these. basedir in particular will cause problems if passed explicitly -->" + NL + "            <propertyset negate=\"true\">" + NL + "                <propertyref name=\"basedir\" />" + NL + "                <propertyref name=\"eclipse.home\" />" + NL
            + "                <propertyref name=\"properties.tmp\" />" + NL + "                <propertyref name=\"line.separator\" />" + NL + "                <propertyref name=\"path.separator\" />" + NL + "                <propertyref prefix=\"ant.\" />" + NL + "                <propertyref prefix=\"file.\" />" + NL + "                <propertyref prefix=\"java.\" />" + NL + "                <propertyref prefix=\"sun.\" />" + NL + "                <propertyref prefix=\"user.\" />" + NL + "            </propertyset>" + NL + "        </echoproperties>" + NL + "    </target>" + NL + "" + NL + "\t<target name=\"init\" depends=\"init.checks,init.workspace,init.build.properties\" />\t" + NL + "\t" + NL + "\t<target name=\"all\" depends=\"";
    protected final String TEXT_8 = "\" />" + NL + NL;
    protected final String TEXT_9 = "</project>";
    protected final String TEXT_10 = NL;
    protected final String TEXT_11 = NL;

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

            if (preCondition()) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
        }

        stringBuffer.append(TEXT_10);
        stringBuffer.append(TEXT_11);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        method_begin(new StringBuffer(), ictx);
        {
            ExecutionContext ctx_local = new ExecutionContext(ictx);
            ctx_local.setValue(PatternContext.INJECTED_CONTEXT, job);
            CallHelper.executeWithContextInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_C_qLIJTYEd-fvPvNnKEvJg", ctx_local);
        }

        method_end(new StringBuffer(), ictx);

        String loop = Node.flattenWithoutCallback(ictx.getNode());
        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("job", this.job);
            String outputWithCallBack = Node.flatten(ictx.getNode());
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ;
        }
        return loop;
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
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_LhlsYJ5OEd-3wvN5SnesGA", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        stringBuffer.append(TEXT_1);
        stringBuffer.append(TEXT_2);
        {
            //<%@ egf:patternCall
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.buckminster.call.build.xml.Xmx"
            //%>

            InternalPatternContext ictx = (InternalPatternContext) ctx;
            new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
            stringBuffer.setLength(0);

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_VCSRcJ5MEd-3wvN5SnesGA", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        stringBuffer.append(TEXT_3);
        stringBuffer.append(TEXT_4);
        {
            //<%@ egf:patternCall
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.buckminster.call.build.xml.Xmx"
            //%>

            InternalPatternContext ictx = (InternalPatternContext) ctx;
            new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
            stringBuffer.setLength(0);

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_VCSRcJ5MEd-3wvN5SnesGA", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        stringBuffer.append(TEXT_5);
        stringBuffer.append(TEXT_6);
        {
            //<%@ egf:patternCall
            //	patternId="platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#LogicalName=org.eclipse.egf.portfolio.eclipse.build.buckminster.call.build.xml.Xmx"
            //%>

            InternalPatternContext ictx = (InternalPatternContext) ctx;
            new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
            stringBuffer.setLength(0);

            final Map<String, Object> callParameters = new HashMap<String, Object>();
            CallHelper.executeWithParameterInjection("platform:/plugin/org.eclipse.egf.portfolio.eclipse.build/egf/Build.fcore#_VCSRcJ5MEd-3wvN5SnesGA", new ExecutionContext((InternalPatternContext) ctx), callParameters);
            stringBuffer.setLength(0);
        }

        stringBuffer.append(TEXT_7);
        stringBuffer.append(new GenerationHelper().generateJobStepsString(job, ','));
        stringBuffer.append(TEXT_8);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "begin", stringBuffer.toString());
    }

    protected void method_end(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_9);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "end", stringBuffer.toString());
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}