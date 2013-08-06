//Generated on Tue Aug 06 15:15:15 CEST 2013 with EGF 1.0.0.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildcore.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

public class buildxmlpublishStepfeature extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmlpublishStepfeature create(String lineSeparator) {
        nl = lineSeparator;
        buildxmlpublishStepfeature result = new buildxmlpublishStepfeature();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\" depends=\"init,install.buckminster\" >" + NL;
    protected final String TEXT_3 = NL + "\t\t" + NL + "\t\t<echo message=\"Generate Site\"/>" + NL + "\t\t<buckminster command=\"perform\">" + NL + "\t\t\t<globargs>" + NL + "\t\t\t\t<arg value=\"-Dsite.include.top=true\"/>" + NL + "\t\t\t\t<arg value=\"-Dsite.signing=";
    protected final String TEXT_4 = "\"/>\t\t\t\t" + NL + "\t\t\t\t<arg value=\"-Dcbi.include.source=";
    protected final String TEXT_5 = "\"/>\t\t\t\t" + NL + "\t\t\t</globargs>" + NL + "\t\t\t<cmdargs>" + NL + "\t\t\t\t<arg value=\"";
    protected final String TEXT_6 = ":eclipse.feature#site.p2\" />" + NL + "\t\t\t</cmdargs>" + NL + "\t\t</buckminster>" + NL + "" + NL + "\t\t<echo message=\"Publish site\"/>" + NL + "\t\t<mkdir dir=\"";
    protected final String TEXT_7 = "/site.p2/\"/>" + NL + "\t\t<copy todir=\"";
    protected final String TEXT_8 = "/site.p2/\">" + NL + "\t\t\t<fileset dir=\"${result}/output\">" + NL + "\t\t\t\t<include name=\"";
    protected final String TEXT_9 = "*/site.p2/*\"/>" + NL + "\t\t\t\t<include name=\"";
    protected final String TEXT_10 = "*/site.p2/**\"/>" + NL + "\t\t\t</fileset>" + NL + "\t\t\t<filtermapper>" + NL + "\t\t\t\t<replaceregex pattern=\".*site\\.p2\" replace=\"\" />" + NL + "\t\t\t</filtermapper>" + NL + "\t\t</copy>" + NL;
    protected final String TEXT_11 = NL + "\t\t<echo message=\"Publish dropins\"/>" + NL + "\t\t<condition property=\"site.src\" value=\"site.signed\" else=\"site\">" + NL + "\t\t\t<istrue value=\"${site.signing}\" />" + NL + "\t\t</condition>" + NL + "" + NL + "\t\t<copy todir=\"";
    protected final String TEXT_12 = "/dropins/";
    protected final String TEXT_13 = "/eclipse/\">" + NL + "\t\t\t<fileset dir=\"${result}/output\">" + NL + "\t\t\t\t<include name=\"";
    protected final String TEXT_14 = "*/${site.src}/plugins/*.jar\"/>" + NL + "\t\t\t\t<include name=\"";
    protected final String TEXT_15 = "*/${site.src}/features/*.jar\"/>" + NL + "\t\t\t</fileset>" + NL + "\t\t\t<filtermapper>" + NL + "\t\t\t\t<replaceregex pattern=\".*_.*-eclipse\\.feature.${site.src}.plugins\" replace=\"plugins\" />" + NL + "\t\t\t\t<replaceregex pattern=\".*_.*-eclipse\\.feature.${site.src}.features\" replace=\"features\" />" + NL + "\t\t\t</filtermapper>" + NL + "\t\t</copy>" + NL + "" + NL + "\t\t<buckminster command=\"perform\">" + NL + "\t\t\t<globargs>" + NL + "\t\t\t\t<arg value=\"-DsiteDir=";
    protected final String TEXT_16 = "/dropins/";
    protected final String TEXT_17 = "/eclipse/\" />" + NL + "\t\t\t</globargs>" + NL + "\t\t\t<cmdargs>";
    protected final String TEXT_18 = "\t\t\t" + NL + "\t\t\t\t<arg value=\"";
    protected final String TEXT_19 = ":buckminster#convertSiteToRuntime\" />" + NL + "\t\t\t</cmdargs>" + NL + "\t\t</buckminster>" + NL + "\t\t" + NL + "\t\t<pathconvert property=\"featurefile";
    protected final String TEXT_20 = "\">" + NL + "\t\t\t<first count=\"1\">" + NL + "\t\t\t\t<fileset dir=\"${result}/output\" includes=\"";
    protected final String TEXT_21 = "*eclipse.feature/temp/feature.xml\" />" + NL + "\t\t\t</first>" + NL + "\t\t</pathconvert>" + NL + "\t\t<loadfile property=\"featureversion";
    protected final String TEXT_22 = "\" srcFile=\"${featurefile";
    protected final String TEXT_23 = "}\">" + NL + "\t\t\t<filterchain>" + NL + "\t\t\t\t<striplinebreaks/>" + NL + "\t\t\t\t<replaceregex" + NL + "\t\t\t\t\tpattern=\"^.*&lt;feature[^&gt;]*version=&quot;([^&quot;]*)&quot;.*$\"" + NL + "\t\t\t\t\treplace=\"\\1\"/>" + NL + "\t\t\t</filterchain>" + NL + "\t\t</loadfile>" + NL + "" + NL + "\t\t<touch file=\"";
    protected final String TEXT_24 = "/dropins/";
    protected final String TEXT_25 = "/";
    protected final String TEXT_26 = "_version_${featureversion";
    protected final String TEXT_27 = "}\" />";
    protected final String TEXT_28 = "\t\t" + NL + "\t</target>" + NL + NL;
    protected final String TEXT_29 = NL;
    protected final String TEXT_30 = NL;

    public buildxmlpublishStepfeature() {
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

        paramDesc = new IQuery.ParameterDescription("publishStep", "http://www.eclipse.org/egf/1.0.2/buildstep#//PublishStep");
        queryCtx = new HashMap<String, String>();
        List<Object> publishStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object publishStepParameter : publishStepList) {

            this.publishStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep) publishStepParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_29);
        stringBuffer.append(TEXT_30);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("publishStep", this.publishStep);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep publishStep = null;

    public void set_publishStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.PublishStep object) {
        this.publishStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("publishStep", this.publishStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        String stepName = new GenerationHelper().getNameOrGeneratedIdString(publishStep);
        stringBuffer.append(TEXT_1);
        stringBuffer.append(stepName);
        stringBuffer.append(TEXT_2);
        String featurename = publishStep.getComponent().getId();
        String publishdirectory = "${publish}/" + featurename;
        stringBuffer.append(TEXT_3);
        stringBuffer.append(publishStep.isSigning());
        stringBuffer.append(TEXT_4);
        stringBuffer.append(publishStep.isGenerateSources());
        stringBuffer.append(TEXT_5);
        stringBuffer.append(featurename);
        stringBuffer.append(TEXT_6);
        stringBuffer.append(publishdirectory);
        stringBuffer.append(TEXT_7);
        stringBuffer.append(publishdirectory);
        stringBuffer.append(TEXT_8);
        stringBuffer.append(featurename);
        stringBuffer.append(TEXT_9);
        stringBuffer.append(featurename);
        stringBuffer.append(TEXT_10);
        if (publishStep.isGenerateDropins()) {
            stringBuffer.append(TEXT_11);
            stringBuffer.append(publishdirectory);
            stringBuffer.append(TEXT_12);
            stringBuffer.append(featurename);
            stringBuffer.append(TEXT_13);
            stringBuffer.append(featurename);
            stringBuffer.append(TEXT_14);
            stringBuffer.append(featurename);
            stringBuffer.append(TEXT_15);
            stringBuffer.append(publishdirectory);
            stringBuffer.append(TEXT_16);
            stringBuffer.append(featurename);
            stringBuffer.append(TEXT_17);
            BuildStep buildStep = publishStep.getComponent().getBuildStep();
            String buildStepName = new GenerationHelper().getNameOrGeneratedIdString(buildStep);
            stringBuffer.append(TEXT_18);
            stringBuffer.append(buildStepName);
            stringBuffer.append(TEXT_19);
            stringBuffer.append(stepName);
            stringBuffer.append(TEXT_20);
            stringBuffer.append(featurename);
            stringBuffer.append(TEXT_21);
            stringBuffer.append(stepName);
            stringBuffer.append(TEXT_22);
            stringBuffer.append(stepName);
            stringBuffer.append(TEXT_23);
            stringBuffer.append(publishdirectory);
            stringBuffer.append(TEXT_24);
            stringBuffer.append(featurename);
            stringBuffer.append(TEXT_25);
            stringBuffer.append(featurename);
            stringBuffer.append(TEXT_26);
            stringBuffer.append(stepName);
            stringBuffer.append(TEXT_27);
        }
        stringBuffer.append(TEXT_28);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return BuildstepPackage.eINSTANCE.getFeature().equals(publishStep.getComponent().eClass());
    }
}