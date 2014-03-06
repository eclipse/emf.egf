//Generated on Wed Aug 08 15:49:13 CEST 2012 with EGF 1.0.0.qualifier
package org.eclipse.egf.emf.pattern.model.cdo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.emf.pattern.base.CodegenGeneratorAdapter;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.execution.OutputManager;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;

public class abstractCopy {

    public abstractCopy() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        Node.Container currentNode = ctx.getNode();

        if (preCondition(ctx))
            orchestration((PatternContext) argument);

        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        Node.Container currentNode = ictx.getNode();
        method_setQualifiedName(new StringBuffer(), ictx);
        method_copyClass(new StringBuffer(), ictx);
        ictx.setNode(currentNode);
        return null;
    }

    protected void method_setQualifiedName(final StringBuffer out, final PatternContext ctx) throws Exception {

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setQualifiedName", out.toString());
    }

    protected void method_copyClass(final StringBuffer out, final PatternContext ctx) throws Exception {
        List list = (List) ctx.getValue("domain");
        GenModel genModel = (GenModel) list.get(0);

        EMFDomain domainOut = (EMFDomain) ctx.getValue("domainOut");
        GenModel newGenModel = (GenModel) domainOut.getContent().get(0);

        String modelDirectory = genModel.getModelDirectory();
        String newModelDirectory = newGenModel.getModelDirectory();

        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

        Path srcPath = new Path(modelDirectory + "/" + qualifiedName.replace('.', '/') + ".java");
        Path destPath = new Path(newModelDirectory + "/" + qualifiedName.replace('.', '/') + ".java");

        IFile srcFile = root.getFile(srcPath);
        if (srcFile.exists()) {
            URI containerURI = URI.createURI(destPath.removeLastSegments(1).toPortableString());
            new CodegenGeneratorAdapter(newGenModel).ensureContainerExists(containerURI, new BasicMonitor());
            srcFile.copy(destPath, true, new NullProgressMonitor());
        }

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "copyClass", out.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return true;
    }

    protected java.lang.String qualifiedName;

    public void set_qualifiedName(java.lang.String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        return parameters;
    }

}
