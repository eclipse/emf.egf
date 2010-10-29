package fcore.builder.patterns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.egf.pattern.execution.CallHelper;
import org.eclipse.egf.pattern.execution.ExecutionContext;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.pattern.execution.InternalPatternContext;
import org.eclipse.egf.pattern.query.IQuery;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.importer.ecore.EcoreImporter;

import org.eclipse.egf.portfolio.genchain.tools.FcoreBuilderConstants;
import org.eclipse.egf.portfolio.genchain.tools.utils.EcoreImporterHelper;
import org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration;
import org.eclipse.emf.common.util.BasicMonitor;

import org.eclipse.core.resources.*;
import org.eclipse.egf.core.domain.*;

public class ModelGenmodelPattern {

    public ModelGenmodelPattern() {
        //Here is the constructor
        // add initialisation of the pattern variables (declaration has been already done).
    }

    public void generate(Object argument) throws Exception {
        InternalPatternContext ctx = (InternalPatternContext) argument;
        IQuery.ParameterDescription paramDesc = null;
        Map<String, String> queryCtx = null;
        List<Object> parameterList = null;
        //this pattern can only be called by another (i.e. it's not an entry point in execution)

        for (Object parameterParameter : parameterList) {

            this.parameter = (org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration) parameterParameter;

            if (preCondition())
                orchestration((PatternContext) argument);

        }
        if (ctx.useReporter()) {
            ctx.getReporter().executionFinished(ctx.getExecutionBuffer().toString(), ctx);
            ctx.clearBuffer();
        }
    }

    public String orchestration(PatternContext ctx) throws Exception {
        InternalPatternContext ictx = (InternalPatternContext) ctx;
        int executionIndex = ictx.getExecutionBuffer().length();
        method_create(ictx.getBuffer(), ictx);
        method_updateContent(ictx.getBuffer(), ictx);
        method_save(ictx.getBuffer(), ictx);

        String loop = ictx.getBuffer().toString();
        if (ictx.useReporter()) {
            ictx.getExecutionBuffer().append(ictx.getBuffer().substring(ictx.getExecutionCurrentIndex()));
            ictx.setExecutionCurrentIndex(0);
            Map<String, Object> parameterValues = new HashMap<String, Object>();
            parameterValues.put("parameter", this.parameter);
            String outputWithCallBack = ictx.getExecutionBuffer().substring(executionIndex);
            ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
            ictx.clearBuffer();
        }
        return loop;
    }

    protected void method_create(final StringBuffer out, final PatternContext ctx) throws Exception {
        ResourceSet resourceSet = new TargetPlatformResourceSet();
        Resource resource = null;

        IPath ecorePath = new Path(parameter.getModelPath());
        URI ecoreURI = URI.createPlatformPluginURI(ecorePath.toString(), false);

        IPath genmodelPath = ecorePath.removeFileExtension().addFileExtension("genmodel");
        URI genmodelURI = URI.createPlatformPluginURI(genmodelPath.toString(), false);

        try {
            //see if a genmodel exists
            resource = resourceSet.getResource(genmodelURI, true);
        } catch (Exception e) {
            genmodelPath = new Path(parameter.getPluginName()).append(genmodelPath.removeFirstSegments(1));
            genmodelURI = URI.createPlatformResourceURI(genmodelPath.toString(), false);

            try {
                //see if a created genmodel exists
                resource = resourceSet.getResource(genmodelURI, true);
            } catch (Exception e1) {
                //create it
                IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(parameter.getPluginName());
                if (!project.exists())
                    project.create(null);
                if (!project.isOpen())
                    project.open(null);

                resource = resourceSet.createResource(genmodelURI);
                importer = EcoreImporterHelper.createEcoreImporter(genmodelPath.removeLastSegments(1), ecoreURI, parameter);
            }
        } finally {
            ((HashMap<EmfGeneration, URI>) ctx.getValue(FcoreBuilderConstants.GENMODEL_URIS)).put(parameter, genmodelURI);
        }

    }

    protected void method_save(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (importer != null)
            importer.saveGenModelAndEPackages(new BasicMonitor());

    }

    protected void method_updateContent(final StringBuffer out, final PatternContext ctx) throws Exception {
        if (importer == null)
            return;
        GenModel genModel = importer.getGenModel();
        String emfModelPath = parameter.getModelPath();
        for (GenPackage genPackage : genModel.getGenPackages()) {
            String ecoreFileName = genPackage.getEcorePackage().eResource().getURI().lastSegment();
            if (emfModelPath.contains(ecoreFileName)) {
                genPackage.setBasePackage(parameter.getBasePackage());
            }

            // EMDE Extension Genmodel
            genPackage.setResource(GenResourceKind.XMI_LITERAL);
            genPackage.setDisposableProviderFactory(true);
            genPackage.setGenerateExampleClass(false);
            genPackage.setMultipleEditorPages(false);
            genPackage.setExtensibleProviderFactory(true);
            genPackage.setChildCreationExtenders(true);
            // EMDE Extension Genmodel

        }

        String emfPluginName = parameter.getPluginName();
        genModel.setModelPluginID(emfPluginName);
        genModel.setModelDirectory("/" + emfPluginName + "/src");

        // EMDE Extension Genmodel
        genModel.setNonNLSMarkers(true);
        genModel.setRootExtendsClass("org.eclipse.emf.ecore.impl.MinimalEObjectImpl.Container");
        genModel.setCodeFormatting(true);
        genModel.setBooleanFlagsField("flags");
        genModel.setOptimizedHasChildren(true);
        genModel.setTableProviders(true);
        genModel.setColorProviders(true);
        genModel.setPackedEnums(true);
        // EMDE Extension Genmodel

    }

    public boolean preCondition() throws Exception {
        return true;
    }

    protected org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration parameter;

    public void set_parameter(org.eclipse.egf.portfolio.genchain.generationChain.EmfGeneration parameter) {
        this.parameter = parameter;
    }

    protected org.eclipse.emf.importer.ecore.EcoreImporter importer;

    public void set_importer(org.eclipse.emf.importer.ecore.EcoreImporter importer) {
        this.importer = importer;
    }

    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("parameter", this.parameter);
        return parameters;
    }

}
