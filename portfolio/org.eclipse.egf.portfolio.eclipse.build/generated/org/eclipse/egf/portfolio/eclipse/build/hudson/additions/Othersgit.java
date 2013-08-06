//Generated on Tue Aug 06 15:15:15 CEST 2013 with EGF 1.0.0.qualifier
package org.eclipse.egf.portfolio.eclipse.build.hudson.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.buildscm.*;
import org.eclipse.egf.portfolio.eclipse.build.*;

public class Othersgit extends org.eclipse.egf.portfolio.eclipse.build.hudson.call.Othersadd {
    protected static String nl;

    public static synchronized Othersgit create(String lineSeparator) {
        nl = lineSeparator;
        Othersgit result = new Othersgit();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "  <scm class=\"hudson.plugins.git.GitSCM\">" + NL + "    <configVersion>2</configVersion>" + NL + "    <userRemoteConfigs>";
    protected final String TEXT_2 = NL + "        <hudson.plugins.git.UserRemoteConfig>" + NL + "          <name></name>" + NL + "          <refspec></refspec>" + NL + "          <url>";
    protected final String TEXT_3 = "</url>" + NL + "        </hudson.plugins.git.UserRemoteConfig>";
    protected final String TEXT_4 = NL + "    </userRemoteConfigs>" + NL + "    <branches>" + NL + "      <hudson.plugins.git.BranchSpec>" + NL + "        <name>**</name>" + NL + "      </hudson.plugins.git.BranchSpec>" + NL + "    </branches>" + NL + "    <disableSubmodules>false</disableSubmodules>" + NL + "    <recursiveSubmodules>false</recursiveSubmodules>" + NL + "    <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>" + NL + "    <authorOrCommitter>false</authorOrCommitter>" + NL + "    <clean>false</clean>" + NL + "    <wipeOutWorkspace>false</wipeOutWorkspace>" + NL + "    <pruneBranches>false</pruneBranches>" + NL + "    <remotePoll>false</remotePoll>" + NL + "    <ignoreNotifyCommit>false</ignoreNotifyCommit>" + NL
            + "    <buildChooser class=\"hudson.plugins.git.util.DefaultBuildChooser\"/>" + NL + "    <gitTool>Default</gitTool>" + NL + "    <submoduleCfg class=\"list\"/>" + NL + "    <relativeTargetDir>git</relativeTargetDir>" + NL + "    <reference></reference>" + NL + "    <excludedRegions></excludedRegions>" + NL + "    <excludedUsers></excludedUsers>" + NL + "    <gitConfigName></gitConfigName>" + NL + "    <gitConfigEmail></gitConfigEmail>" + NL + "    <skipTag>false</skipTag>" + NL + "    <includedRegions></includedRegions>" + NL + "    <scmName></scmName>" + NL + "  </scm>" + NL + "  ";
    protected final String TEXT_5 = NL;
    protected final String TEXT_6 = NL;

    public Othersgit() {
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

        paramDesc = new IQuery.ParameterDescription("git", "http://www.eclipse.org/egf/1.0.0/buildscm#//GIT");
        queryCtx = new HashMap<String, String>();
        List<Object> gitList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object gitParameter : gitList) {

            this.git = (org.eclipse.egf.portfolio.eclipse.build.buildscm.GIT) gitParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_5);
        stringBuffer.append(TEXT_6);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("git", this.git);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildscm.GIT git = null;

    public void set_git(org.eclipse.egf.portfolio.eclipse.build.buildscm.GIT object) {
        this.git = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("git", this.git);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        Iterator<GITLocation> iterator = git.getLocations().iterator();
        while (iterator.hasNext()) {
            GITLocation gitLocation = iterator.next();
            stringBuffer.append(TEXT_2);
            stringBuffer.append(gitLocation.getProtocol().getLiteral());
            stringBuffer.append(gitLocation.getUrl());
            stringBuffer.append(TEXT_3);
        }
        stringBuffer.append(TEXT_4);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }
}