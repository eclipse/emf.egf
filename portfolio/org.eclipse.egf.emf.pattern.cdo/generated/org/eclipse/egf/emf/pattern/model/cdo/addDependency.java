//Generated on Tue Aug 07 18:33:57 CEST 2012 with EGF 1.0.0.qualifier
package org.eclipse.egf.emf.pattern.model.cdo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.model.pattern.Node;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.execution.OutputManager;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.pde.core.IBaseModel;
import org.eclipse.pde.core.plugin.IPluginImport;
import org.eclipse.pde.internal.core.ICoreConstants;
import org.eclipse.pde.internal.core.ibundle.IBundlePluginModelBase;
import org.eclipse.pde.internal.core.text.plugin.PluginImportNode;
import org.eclipse.pde.internal.ui.util.ModelModification;
import org.eclipse.pde.internal.ui.util.PDEModelUtility;

public class addDependency {

    public addDependency() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        Node.Container currentNode = ctx.getNode();
        List<Object> genModelList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object genModelParameter : genModelList) {

            this.genModel = (org.eclipse.emf.codegen.ecore.genmodel.GenModel) genModelParameter;

            if (preCondition(ctx)) {
                ctx.setNode(new Node.Container(currentNode, getClass()));
                orchestration((PatternContext) argument);

            }
        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
        }
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        Node.Container currentNode = ictx.getNode();
        method_setPluginId(new StringBuffer(), ictx);
        method_addDependency(new StringBuffer(), ictx);
        ictx.setNode(currentNode);
        if (ictx.useReporter()) {
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("genModel", this.genModel);
            String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
            String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
        }
        return null;
    }

    protected void method_setPluginId(final StringBuffer out, final PatternContext ctx) throws Exception {

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "setPluginId", out.toString());
    }

    protected void method_addDependency(final StringBuffer out, final PatternContext ctx) throws Exception {
        String manifestMFPathString = genModel.getModelProjectDirectory() + "/" + ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR;
        IPath manifestMFPath = new Path(manifestMFPathString);
        IWorkspace workspace = ResourcesPlugin.getWorkspace();

        final IProject project = workspace.getRoot().getProject(manifestMFPath.segment(0));
        IFile manifestMFFile = project.getFile(ICoreConstants.BUNDLE_FILENAME_DESCRIPTOR);

        if (!manifestMFFile.exists())
            return;

        PDEModelUtility.modifyModel(new ModelModification(manifestMFFile) {

            @Override
            protected void modifyModel(IBaseModel model, IProgressMonitor innerMonitor) throws CoreException {
                if (model instanceof IBundlePluginModelBase) {
                    IBundlePluginModelBase bundlePluginModelBase = (IBundlePluginModelBase) model;

                    for (IPluginImport pluginImport : bundlePluginModelBase.getPluginBase().getImports()) {
                        if (pluginId.equals(pluginImport.getId())) {
                            return;
                        }
                    }

                    PluginImportNode pluginImportNode = new PluginImportNode(pluginId);
                    pluginImportNode.setReexported(true);
                    bundlePluginModelBase.getPluginBase().add(pluginImportNode);
                }
            }
        }, new NullProgressMonitor());

        InternalPatternContext ictx = (InternalPatternContext) ctx;
        new Node.DataLeaf(ictx.getNode(), getClass(), "addDependency", out.toString());
    }

    public boolean preCondition(PatternContext ctx) throws Exception {
        return true;
    }

    protected org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel;

    public void set_genModel(org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel) {
        this.genModel = genModel;
    }

    protected java.lang.String pluginId;

    public void set_pluginId(java.lang.String pluginId) {
        this.pluginId = pluginId;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("genModel", this.genModel);
        return parameters;
    }

}
