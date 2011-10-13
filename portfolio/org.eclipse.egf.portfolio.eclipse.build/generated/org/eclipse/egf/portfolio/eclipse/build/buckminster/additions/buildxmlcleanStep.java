package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.eclipse.egf.portfolio.eclipse.build.*;
import org.eclipse.egf.portfolio.eclipse.build.buildstep.*;

public class buildxmlcleanStep extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildxmladd {
    protected static String nl;

    public static synchronized buildxmlcleanStep create(String lineSeparator) {
        nl = lineSeparator;
        buildxmlcleanStep result = new buildxmlcleanStep();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "\t<target name=\"";
    protected final String TEXT_2 = "\" >";
    protected final String TEXT_3 = NL + "\t\t<antcall target=\"clean.workspace\" />";
    protected final String TEXT_4 = NL + "\t\t<antcall target=\"clean.result\" />";
    protected final String TEXT_5 = NL + "\t\t<antcall target=\"clean.tools\" />";
    protected final String TEXT_6 = NL + "\t\t<antcall target=\"clean.all\" />";
    protected final String TEXT_7 = NL + "\t</target>" + NL;
    protected final String TEXT_8 = NL;
    protected final String TEXT_9 = NL;

    public buildxmlcleanStep() {
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

        paramDesc = new IQuery.ParameterDescription("cleanStep", "http://www.eclipse.org/egf/1.0.1/buildstep#//CleanStep");
        queryCtx = new HashMap<String, String>();
        List<Object> cleanStepList = QueryHelper.load(ctx, "org.eclipse.egf.pattern.query.EObjectInjectedContextQuery").execute(paramDesc, queryCtx, ctx);

        for (Object cleanStepParameter : cleanStepList) {

            this.cleanStep = (org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep) cleanStepParameter;

            if (preCondition()) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
        }

        stringBuffer.append(TEXT_8);
        stringBuffer.append(TEXT_9);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        String loop = Node.flattenWithoutCallback(ictx.getNode());
        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("cleanStep", this.cleanStep);
            String outputWithCallBack = Node.flatten(ictx.getNode());
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ;
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep cleanStep = null;

    public void set_cleanStep(org.eclipse.egf.portfolio.eclipse.build.buildstep.CleanStep object) {
        this.cleanStep = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("cleanStep", this.cleanStep);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        stringBuffer.append(new GenerationHelper().getIdOrPositionString(cleanStep));
        stringBuffer.append(TEXT_2);
        if (cleanStep.getType() == CLEAN_TYPE.WORKSPACE) {
            stringBuffer.append(TEXT_3);
        }
        if (cleanStep.getType() == CLEAN_TYPE.RESULT) {
            stringBuffer.append(TEXT_4);
        }
        if (cleanStep.getType() == CLEAN_TYPE.TOOLS) {
            stringBuffer.append(TEXT_5);
        }
        if (cleanStep.getType() == CLEAN_TYPE.ALL) {
            stringBuffer.append(TEXT_6);
        }
        stringBuffer.append(TEXT_7);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}