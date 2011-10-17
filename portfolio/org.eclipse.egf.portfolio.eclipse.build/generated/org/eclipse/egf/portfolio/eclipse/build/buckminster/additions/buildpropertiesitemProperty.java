package org.eclipse.egf.portfolio.eclipse.build.buckminster.additions;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class buildpropertiesitemProperty extends org.eclipse.egf.portfolio.eclipse.build.buckminster.call.buildpropertiesadd {
    protected static String nl;

    public static synchronized buildpropertiesitemProperty create(String lineSeparator) {
        nl = lineSeparator;
        buildpropertiesitemProperty result = new buildpropertiesitemProperty();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "=";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;
    protected final String TEXT_4 = NL;

    public buildpropertiesitemProperty() {
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

        paramDesc = new IQuery.ParameterDescription("property", "http://www.eclipse.org/egf/1.0.0/buildcore#//Property");
        queryCtx = new HashMap<String, String>();
        List<Object> propertyList = QueryHelper.load(ctx, "org.eclipse.egf.portfolio.eclipse.build.ItemPropertiesQuery").execute(paramDesc, queryCtx, ctx);

        for (Object propertyParameter : propertyList) {

            this.property = (org.eclipse.egf.portfolio.eclipse.build.buildcore.Property) propertyParameter;

            if (preCondition()) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration(ctx);
            }

        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
        }

        stringBuffer.append(TEXT_3);
        stringBuffer.append(TEXT_4);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        String loop = Node.flattenWithoutCallback(ictx.getNode());
        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("property", this.property);
            String outputWithCallBack = Node.flatten(ictx.getNode());
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ;
        }
        return loop;
    }

    protected org.eclipse.egf.portfolio.eclipse.build.buildcore.Property property = null;

    public void set_property(org.eclipse.egf.portfolio.eclipse.build.buildcore.Property object) {
        this.property = object;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("property", this.property);
        return parameters;
    }

    protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(property.getKey());
        stringBuffer.append(TEXT_1);
        stringBuffer.append(property.getValue());
        stringBuffer.append(TEXT_2);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
    }

    public boolean preCondition() throws Exception {
        return super.preCondition();
    }
}