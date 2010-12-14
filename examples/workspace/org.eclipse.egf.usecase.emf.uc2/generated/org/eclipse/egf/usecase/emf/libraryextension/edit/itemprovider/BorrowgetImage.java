package org.eclipse.egf.usecase.emf.libraryextension.edit.itemprovider;

import org.eclipse.egf.common.helper.*;
import java.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;

public class BorrowgetImage extends org.eclipse.egf.emf.pattern.edit.call.ItemProvider.ItemProviderinsert {
    protected static String nl;

    public static synchronized BorrowgetImage create(String lineSeparator) {
        nl = lineSeparator;
        BorrowgetImage result = new BorrowgetImage();
        nl = null;
        return result;
    }

    public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
    protected final String TEXT_1 = "//INJECTED-CODE-BEGIN : Borrow#overlayImage()" + NL + "/**" + NL + "* This adds an overlay to the given image if the object is controlled." + NL + "*/" + NL + "@Override" + NL + "protected Object overlayImage(Object object, Object image)" + NL + "{" + NL + "\treturn super.overlayImage(object, image);" + NL + "}" + NL + "//INJECTED-CODE-END : Borrow#overlayImage()" + NL + "  ";
    protected final String TEXT_2 = NL;
    protected final String TEXT_3 = NL;

    public BorrowgetImage() {
        //Here is the constructor
        StringBuffer stringBuffer = new StringBuffer();

        // add initialisation of the pattern variables (declaration has been already done).

    }

    public String generate(Object argument) throws Exception {
        final StringBuffer stringBuffer = new StringBuffer();

        InternalPatternContext ctx = (InternalPatternContext) argument;
        Map<String, String> queryCtx = null;
        IQuery.ParameterDescription paramDesc = null;

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

                        if (preCondition())
                            orchestration(ctx);

                    }
                }
            }
        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }

        stringBuffer.append(TEXT_2);
        stringBuffer.append(TEXT_3);
        return stringBuffer.toString();
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();

        super.orchestration(new SuperOrchestrationContext(ictx));

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("genClass", this.genClass);
            parameterValues.put("genPackage", this.genPackage);
            parameterValues.put("genModel", this.genModel);
            parameterValues.put("_List", this._List);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
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
    }

    public boolean preCondition() throws Exception {
        return "Borrow".equals(genClass.getName());
    }
}