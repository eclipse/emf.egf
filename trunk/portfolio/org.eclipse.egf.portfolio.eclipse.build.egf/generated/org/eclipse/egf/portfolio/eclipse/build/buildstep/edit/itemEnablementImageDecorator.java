//Generated on Tue Aug 06 15:14:50 CEST 2013 with EGF 1.0.0.qualifier
package org.eclipse.egf.portfolio.eclipse.build.buildstep.edit;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class itemEnablementImageDecorator extends org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProviderinsert {
    protected static String nl;

    public static synchronized itemEnablementImageDecorator create(String lineSeparator) {
        nl = lineSeparator;
        itemEnablementImageDecorator result = new itemEnablementImageDecorator();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "    /**" + NL + "     * @generated" + NL + "     */" + NL + "    @Override" + NL + "    protected Object overlayImage(Object object, Object image) {" + NL + "        " + NL + "        if (object instanceof Item && !((Item) object).isEnabled())" + NL + "        {" + NL + "          List<Object> images = new java.util.ArrayList<Object>(2);" + NL + "          images.add(image);" + NL + "          images.add(org.eclipse.egf.portfolio.eclipse.build.buildcore.presentation.BuildCoreEditorPlugin.INSTANCE.getImage(\"disabled\"));" + NL + "          image = new org.eclipse.emf.edit.provider.ComposedImage(images) {" + NL + "" + NL + "                @Override" + NL + "                public List<Point> getDrawPoints(Size size) {" + NL
            + "                    List<Point> results = new java.util.ArrayList<Point>();" + NL + "                    results.add(new Point());" + NL + "                    Point overlay = new Point();" + NL + "                    overlay.x = 0;" + NL + "                    overlay.y = 9;" + NL + "                    results.add(overlay);" + NL + "                    return results;" + NL + "                }" + NL + "            };" + NL + "        }" + NL + "" + NL + "        return super.overlayImage(object, image);" + NL + "    }";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public itemEnablementImageDecorator() {
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

        List<Object> genClassList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> genPackageList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> genModelList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)
        List<Object> _ListList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object genClassParameter : genClassList) {
            for (Object genPackageParameter : genPackageList) {
                for (Object genModelParameter : genModelList) {
                    for (Object _ListParameter : _ListList) {

                        this.genClass = (org.eclipse.emf.codegen.ecore.genmodel.GenClass) genClassParameter;
                        this.genPackage = (org.eclipse.emf.codegen.ecore.genmodel.GenPackage) genPackageParameter;
                        this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;
                        this._List = (java.lang.String) _ListParameter;

                        if (preCondition(ctx)) {
                            ctx.setNode(new Node.Container(currentNode, getClass()));
                            orchestration(ctx);
                        }

                    }
                }
            }
        }
        ctx.setNode(currentNode);
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(TEXT_3);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;

        super.orchestration(new SuperOrchestrationContext(ictx));

        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("genClass", this.genClass);
            parameterValues.put("genPackage", this.genPackage);
            parameterValues.put("genModel", this.genModel);
            parameterValues.put("_List", this._List);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    public Map<String, Object> getParameters() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("genClass", this.genClass);
        parameters.put("genPackage", this.genPackage);
        parameters.put("genModel", this.genModel);
        parameters.put("_List", this._List);
        return parameters;
    }

    protected void method_doGenerate(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

        stringBuffer.append(TEXT_1);
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "doGenerate", stringBuffer.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return "Item".equals(genClass.getName());
    }
}