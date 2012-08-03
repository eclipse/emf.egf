//Generated on Thu Aug 02 17:34:51 CEST 2012 with EGF 1.0.0.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;

public class buildxmljavadocStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmljavadocStep create(String lineSeparator) {
        nl = lineSeparator;
        buildxmljavadocStep result = new buildxmljavadocStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\">" + NL + "\t\t<delete dir=\"${build.root}/../javadoc\" />" + NL + "\t\t<javadoc" + NL + "\t\t\tdestdir=\"${build.root}/../javadoc\"" + NL + "\t\t\tmaxmemory=\"1024m\"" + NL + "\t\t\tsource=\"1.5\"" + NL + "\t\t\tuseexternalfile=\"true\"" + NL + "\t\t\tauthor=\"true\"" + NL + "\t\t\tversion=\"true\"" + NL + "\t\t\tuse=\"true\"" + NL + "\t\t\twindowtitle=\"Javadoc\">" + NL;
    protected final String TEXT_3 = " " + NL + "\t\t<link offline=\"false\" href=\"";
    protected final String TEXT_4 = "\"/>";
    protected final String TEXT_5 = NL + NL + "<!-- TODO better handling of dir parameter -->" + NL + "<!-- TODO better handling of SourceBuildLocation model extension -->";
    protected final String TEXT_6 = NL;
    protected final String TEXT_7 = NL + "\t\t<fileset dir=\"";
    protected final String TEXT_8 = "\" defaultexcludes=\"true\">";
    protected final String TEXT_9 = NL;
    protected final String TEXT_10 = NL + "\t\t<fileset dir=\"${build.root}/svn/";
    protected final String TEXT_11 = "/";
    protected final String TEXT_12 = "\" defaultexcludes=\"true\">";
    protected final String TEXT_13 = NL + "\t\t<fileset dir=\"${build.root}/git/";
    protected final String TEXT_14 = "\" defaultexcludes=\"true\">";
    protected final String TEXT_15 = NL;
    protected final String TEXT_16 = " " + NL + "\t\t\t<include name=\"";
    protected final String TEXT_17 = "\"/>";
    protected final String TEXT_18 = " " + NL + "\t\t\t<exclude name=\"";
    protected final String TEXT_19 = "\"/>";
    protected final String TEXT_20 = NL + "\t\t</fileset>";
    protected final String TEXT_21 = NL + NL + "<!-- TODO better handling of copyright (escape chars) -->" + NL + "<!-- <bottom>copyright</bottom> -->" + NL + "\t</javadoc>" + NL + "</target>" + NL + NL;
    protected final String TEXT_22 = NL;
    protected final String TEXT_23 = NL;

    public buildxmljavadocStep() {
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

        paramDesc = new IQuery.ParameterDescription("javadocStep", "http://www.eclipse.org/egf/1.0.2/buildstep#//JavadocStep");
        queryCtx = new HashMap<String, String>();
        List<Object> javadocStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object javadocStepParameter : javadocStepList) {

            this.javadocStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep) javadocStepParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_22);
        stringBuffer.append(TEXT_23);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("javadocStep", this.javadocStep);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep javadocStep = null;

    public void set_javadocStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.JavadocStep object) {
        this.javadocStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("javadocStep", this.javadocStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(new GenerationHelper().getNameOrGeneratedIdString(javadocStep));
        stringBuffer.append(TEXT_2);
        for (String linkString : javadocStep.getLinks()) {
            stringBuffer.append(TEXT_3);
            stringBuffer.append(linkString);
            stringBuffer.append(TEXT_4);
        }
        stringBuffer.append(TEXT_5);
        for (SourceBuildLocation sourceLocation : javadocStep.getSources()) {
            stringBuffer.append(TEXT_6);
            if (sourceLocation instanceof LocalBuildLocation) {
                stringBuffer.append(TEXT_7);
                stringBuffer.append(((LocalBuildLocation) sourceLocation).getPath());
                stringBuffer.append(TEXT_8);
            }
            stringBuffer.append(TEXT_9);
            if (sourceLocation instanceof SVNBuildLocation) {
                SVNBuildLocation svnBuildLocation = (SVNBuildLocation) sourceLocation;
                SVNLocation svnLocation = (SVNLocation) svnBuildLocation.getSvnLocation();
                stringBuffer.append(TEXT_10);
                stringBuffer.append(svnLocation.getLocalPath());
                stringBuffer.append(TEXT_11);
                stringBuffer.append(svnBuildLocation.getFolderName());
                stringBuffer.append(TEXT_12);
            }
            if (sourceLocation instanceof GITBuildLocation) {
                GITBuildLocation gitBuildLocation = (GITBuildLocation) sourceLocation;
                GITLocation gitLocation = (GITLocation) gitBuildLocation.getGitLocation();
                stringBuffer.append(TEXT_13);
                stringBuffer.append(gitBuildLocation.getFolderName());
                stringBuffer.append(TEXT_14);
            }
            stringBuffer.append(TEXT_15);
            for (String includeString : javadocStep.getIncludes()) {
                stringBuffer.append(TEXT_16);
                stringBuffer.append(includeString);
                stringBuffer.append(TEXT_17);
            }
            for (String excludeString : javadocStep.getExcludes()) {
                stringBuffer.append(TEXT_18);
                stringBuffer.append(excludeString);
                stringBuffer.append(TEXT_19);
            }
            stringBuffer.append(TEXT_20);
        }
        stringBuffer.append(TEXT_21);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}