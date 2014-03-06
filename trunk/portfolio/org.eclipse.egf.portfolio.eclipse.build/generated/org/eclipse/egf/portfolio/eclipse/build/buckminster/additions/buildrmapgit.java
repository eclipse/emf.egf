//Generated on Tue Aug 06 15:15:14 CEST 2013 with EGF 1.0.0.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildrmapgit extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildrmaplocationadd {
    protected static String nl;

    public static synchronized buildrmapgit create(String lineSeparator) {
        nl = lineSeparator;
        buildrmapgit result = new buildrmapgit();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<locator searchPathRef=\"";
    protected final String TEXT_2 = "\" ";
    protected final String TEXT_3 = " failOnError=\"false\" />" + NL + "\t<searchPath name=\"";
    protected final String TEXT_4 = "\">" + NL + "\t    <!-- provider for windows if checkouted with Hudson -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"local\" source=\"true\">" + NL + "\t\t\t<uri format=\"file:/{0}/git/";
    protected final String TEXT_5 = "/{1}";
    protected final String TEXT_6 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"build.root\" />" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t    <!-- provider for unix if checkouted with Hudson -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"local\" source=\"true\">" + NL + "\t\t\t<uri format=\"file://{0}/git/";
    protected final String TEXT_7 = "/{1}";
    protected final String TEXT_8 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"build.root\" />" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t    <!-- standalone provider -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"git\" source=\"true\">" + NL + "\t\t\t<property key=\"git.remote.uri\" value=\"";
    protected final String TEXT_9 = ":";
    protected final String TEXT_10 = "@";
    protected final String TEXT_11 = "\"/>" + NL + "      \t\t<property key=\"git.auto.fetch\" value=\"true\"/>" + NL + "  \t\t\t<uri format=\"{0}/git,";
    protected final String TEXT_12 = "/{1}";
    protected final String TEXT_13 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"build.root\" />" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t</searchPath>" + NL + NL;
    protected final String TEXT_14 = NL;
    protected final String TEXT_15 = NL;

    public buildrmapgit() {
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

        paramDesc = new IQuery.ParameterDescription("gitBuildLocation", "http://www.eclipse.org/egf/1.0.0/buildscm#//GITBuildLocation");
        queryCtx = new HashMap<String, String>();
        List<Object> gitBuildLocationList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object gitBuildLocationParameter : gitBuildLocationList) {

            this.gitBuildLocation = (org.eclipse.egf.portfolio.eclipse.build.buildscm.GITBuildLocation) gitBuildLocationParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_14);
        stringBuffer.append(TEXT_15);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("gitBuildLocation", this.gitBuildLocation);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildscm.GITBuildLocation gitBuildLocation = null;

    public void set_gitBuildLocation(org.eclipse.egf.portfolio.eclipse.build.buildscm.GITBuildLocation object) {
        this.gitBuildLocation = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("gitBuildLocation", this.gitBuildLocation);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        GITLocation gitLocation = ((GITLocation) gitBuildLocation.getGitLocation());
        String id = new GenerationHelper().getNameOrGeneratedIdString(gitBuildLocation);
        stringBuffer.append(TEXT_1);
        stringBuffer.append(id);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(new GenerationHelper().getPatternString(gitBuildLocation));
        stringBuffer.append(TEXT_3);
        stringBuffer.append(id);
        stringBuffer.append(TEXT_4);
        stringBuffer.append(gitBuildLocation.getFolderName());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(new GenerationHelper().getStringIfNotNull(gitBuildLocation.getSuffix()));
        stringBuffer.append(TEXT_6);
        stringBuffer.append(gitBuildLocation.getFolderName());
        stringBuffer.append(TEXT_7);
        stringBuffer.append(new GenerationHelper().getStringIfNotNull(gitBuildLocation.getSuffix()));
        stringBuffer.append(TEXT_8);
        stringBuffer.append(gitLocation.getProtocol().getLiteral());
        if (gitLocation.getUsername() != null) {
            stringBuffer.append(gitLocation.getUsername());
            stringBuffer.append(TEXT_9);
            stringBuffer.append(gitLocation.getPassword());
            stringBuffer.append(TEXT_10);
        }
        stringBuffer.append(gitLocation.getUrl());
        stringBuffer.append(TEXT_11);
        stringBuffer.append(gitBuildLocation.getFolderName());
        stringBuffer.append(TEXT_12);
        stringBuffer.append(new GenerationHelper().getStringIfNotNull(gitBuildLocation.getSuffix()));
        stringBuffer.append(TEXT_13);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}