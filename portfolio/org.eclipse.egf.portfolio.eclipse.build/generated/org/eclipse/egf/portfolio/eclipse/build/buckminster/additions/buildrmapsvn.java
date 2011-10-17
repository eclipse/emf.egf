package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class buildrmapsvn extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildrmaplocationadd {
    protected static String nl;

    public static synchronized buildrmapsvn create(String lineSeparator) {
        nl = lineSeparator;
        buildrmapsvn result = new buildrmapsvn();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<locator searchPathRef=\"";
    protected final String TEXT_2 = "\" ";
    protected final String TEXT_3 = " failOnError=\"false\" />" + NL + "\t<searchPath name=\"";
    protected final String TEXT_4 = "\">" + NL + "\t    <!-- provider for windows if checkouted with Hudson -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"local\" source=\"true\">" + NL + "\t\t\t<uri format=\"file:/{0}/";
    protected final String TEXT_5 = "/";
    protected final String TEXT_6 = "/{1}";
    protected final String TEXT_7 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"build.root\" />" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t    <!-- provider for unix if checkouted with Hudson -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"local\" source=\"true\">" + NL + "\t\t\t<uri format=\"file://{0}/";
    protected final String TEXT_8 = "/";
    protected final String TEXT_9 = "/{1}";
    protected final String TEXT_10 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"build.root\" />" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t    <!-- standalone provider -->" + NL + "\t\t<provider componentTypes=\"eclipse.feature,osgi.bundle\" readerType=\"svn\" source=\"true\">" + NL + "\t\t\t<uri format=\"";
    protected final String TEXT_11 = ":";
    protected final String TEXT_12 = "@";
    protected final String TEXT_13 = "/";
    protected final String TEXT_14 = "/{0}";
    protected final String TEXT_15 = "\">" + NL + "\t\t\t\t<bc:propertyRef key=\"buckminster.component\" />" + NL + "\t\t\t</uri>" + NL + "\t\t</provider>" + NL + "\t</searchPath>" + NL + NL;
    protected final String TEXT_16 = NL;
    protected final String TEXT_17 = NL;

    public buildrmapsvn() {
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

        paramDesc = new IQuery.ParameterDescription("svnBuildLocation", "http://www.eclipse.org/egf/1.0.0/buildscm#//SVNBuildLocation");
        queryCtx = new HashMap<String, String>();
        List<Object> svnBuildLocationList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object svnBuildLocationParameter : svnBuildLocationList) {

            this.svnBuildLocation = (org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNBuildLocation) svnBuildLocationParameter;

            if (preCondition()) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
        }

        stringBuffer.append(TEXT_16);
        stringBuffer.append(TEXT_17);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        String loop = Node.flattenWithoutCallback(ictx.getNode());
        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("svnBuildLocation", this.svnBuildLocation);
            String outputWithCallBack = Node.flatten(ictx.getNode());
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ;
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNBuildLocation svnBuildLocation = null;

    public void set_svnBuildLocation(org.eclipse.egf.portfolio.eclipse.build.buildscm.SVNBuildLocation object) {
        this.svnBuildLocation = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("svnBuildLocation", this.svnBuildLocation);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        SVNLocation svnLocation = ((SVNLocation) svnBuildLocation.getSvnLocation());
        String id = new GenerationHelper().getIdOrPositionString(svnBuildLocation);
        stringBuffer.append(TEXT_1);
        stringBuffer.append(id);
        stringBuffer.append(TEXT_2);
        stringBuffer.append(new GenerationHelper().getPatternString(svnBuildLocation));
        stringBuffer.append(TEXT_3);
        stringBuffer.append(id);
        stringBuffer.append(TEXT_4);
        stringBuffer.append(svnLocation.getLocalPath());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(svnBuildLocation.getFolderName());
        stringBuffer.append(TEXT_6);
        stringBuffer.append(new GenerationHelper().getStringIfNotNull(svnBuildLocation.getSuffix()));
        stringBuffer.append(TEXT_7);
        stringBuffer.append(svnLocation.getLocalPath());
        stringBuffer.append(TEXT_8);
        stringBuffer.append(svnBuildLocation.getFolderName());
        stringBuffer.append(TEXT_9);
        stringBuffer.append(new GenerationHelper().getStringIfNotNull(svnBuildLocation.getSuffix()));
        stringBuffer.append(TEXT_10);
        stringBuffer.append(svnLocation.getProtocol().getLiteral());
        if (svnLocation.getUsername() != null) {
            stringBuffer.append(svnLocation.getUsername());
            stringBuffer.append(TEXT_11);
            stringBuffer.append(svnLocation.getPassword());
            stringBuffer.append(TEXT_12);
        }
        stringBuffer.append(svnLocation.getUrl());
        stringBuffer.append(TEXT_13);
        stringBuffer.append(svnBuildLocation.getFolderName());
        stringBuffer.append(TEXT_14);
        stringBuffer.append(new GenerationHelper().getStringIfNotNull(svnBuildLocation.getSuffix()));
        stringBuffer.append(TEXT_15);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}