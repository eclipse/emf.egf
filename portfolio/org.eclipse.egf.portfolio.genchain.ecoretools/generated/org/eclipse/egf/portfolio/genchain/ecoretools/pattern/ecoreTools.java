package org.eclipse.egf.portfolio.genchain.ecoretools.pattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.model.types.TypeURI;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.egf.portfolio.genchain.generationChain.GenerationElement;
import org.eclipse.egf.portfolio.genchain.tools.FcoreBuilderConstants;
import org.eclipse.egf.portfolio.genchain.tools.utils.ActivityInvocationHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ecoreTools {

    public ecoreTools() {
        // Here is the constructor
        // add initialisation of the pattern variables (declaration has been
        // already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        Node.Container currentNode = ctx.getNode();
        List<Object> parameterList = null;
        // this pattern can only be called by another (i.e. it's not an entry
        // point in execution)

        for (Object parameterParameter : parameterList) {

            this.parameter = (org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration) parameterParameter;

            if (preCondition()) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration((PatternContext) argument);

            }
        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(Node.flatten(ctx.getNode()), ctx);
        }
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        Node.Container currentNode = ictx.getNode();
        method_body(new StringBuffer(), ictx);
        ictx.setNode(currentNode);
        String loop = Node.flattenWithoutCallback(ictx.getNode());
        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("parameter", this.parameter);
            String outputWithCallBack = Node.flatten(ictx.getNode());
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return loop;
    }

    protected void method_body(final StringBuffer out, final PatternContext ctx) throws Exception {
        Map<GenerationElement, FactoryComponent> fcs = (Map<GenerationElement, FactoryComponent>) ctx.getValue(FcoreBuilderConstants.CURRENT_FCORE);
        FactoryComponent fc = fcs.get((GenerationElement) (parameter.eContainer()));
        ResourceSet resourceSet = fc.eResource().getResourceSet();
        ProductionPlan pp = (ProductionPlan) fc.getOrchestration();
        URI uri = URI.createURI("platform:/plugin/org.eclipse.egf.portfolio.genchain.ecoretools/egf/ecoreToolsExtension.fcore#_wQgLIHS0EeC3aZAQAbtFJA", false);
        Activity activity = (Activity) resourceSet.getEObject(uri, true);

        Map<String, Type> contract2type = new HashMap<String, Type>();

        TypeURI typeURI = TypesFactory.eINSTANCE.createTypeURI();
        typeURI.setValue(URI.createPlatformResourceURI(parameter.getModelPath(), true));

        TypeString typeString = TypesFactory.eINSTANCE.createTypeString();
        typeString.setValue(parameter.getFileName());

        contract2type.put("model", typeURI);
        contract2type.put("fileName", typeString);

        ActivityInvocationHelper.addInvocation(pp, activity, contract2type);

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.Leaf(ictx.getNode(), getClass(), out.toString());
    }

    public boolean preCondition() throws Exception {
        return true;
    }

    protected org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration parameter;

    public void set_parameter(org.eclipse.egf.portfolio.genchain.ecoretools.ecoreToolsExtension.EcoreToolsGeneration parameter) {
        this.parameter = parameter;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("parameter", this.parameter);
        return parameters;
    }

}
