/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.codegen;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.emf.pattern.codegen.CodegenPatternInitializer.CodegenJetPatternInitializer;
import org.eclipse.egf.emf.pattern.codegen.CodegenPatternInitializer.ContentProvider;
import org.eclipse.egf.emf.pattern.codegen.jdt.CodegenASTHelper;
import org.eclipse.egf.emf.pattern.codegen.jet.CodegenJetPatternHelper;
import org.eclipse.egf.emf.pattern.codegen.model.AbstractInfoComparator;
import org.eclipse.egf.emf.pattern.codegen.model.GIFPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.JetSubPatternInfo;
import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.extension.TemplateInitializer;
import org.eclipse.egf.pattern.jet.JetPreferences;
import org.eclipse.egf.pattern.jet.extension.JetPatternFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenFcoreUtil {

    public static final String ORG_ECLIPSE_EMF_CODEGEN_ECORE = "org.eclipse.emf.codegen.ecore"; //$NON-NLS-1$

    public static final String N = "\n"; //$NON-NLS-1$

    protected IProject codegenProject;

    protected IProject fcoreProject;

    protected Resource mdpstResource;

    protected Resource emfPatternBaseResource;

    protected Resource emfPatternResource;

    protected CodegenPatternHelper codegenPatternHelper;

    protected CodegenEGFHelper codegenEGFHelper;

    protected CodegenJetPatternHelper codegenJetPatternHelper;

    protected List<PatternInfo> patternInfos;

    protected CodegenVersionHelper codegenVersionHelper;

    protected class ClearCommand extends RecordingCommand {

        protected Exception exception;

        public ClearCommand(TransactionalEditingDomain domain) {
            super(domain);
        }

        @Override
        protected void doExecute() {
            try {
                emfPatternResource.getContents().clear();
            } catch (Exception e) {
                this.exception = e;
            }
        }

    }

    protected class CreateCommand extends RecordingCommand {

        protected Exception exception;

        protected IProgressMonitor monitor;

        public CreateCommand(TransactionalEditingDomain domain, IProgressMonitor monitor) {
            super(domain);
            this.monitor = monitor;
        }

        @Override
        protected void doExecute() {
            try {
                createPatterns(monitor);
                codegenEGFHelper.createOrchestration(emfPatternBaseResource, mdpstResource, patternInfos, monitor, codegenPatternHelper);
                codegenEGFHelper.createAllFactoryComponent();
                codegenEGFHelper.fixPatternElementOrder();
            } catch (Exception e) {
                this.exception = e;
            }
        }
    }

    public void createFcoreFile(IFile fcore, final IProgressMonitor monitor) throws Exception {
        final IOException[] ioExceptions = new IOException[1];

        // Retrieve our editing domain
        TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EGFCorePlugin.EDITING_DOMAIN_ID);

        // Feed our URIConverter
        URI platformPluginURI = URI.createPlatformPluginURI(fcore.getFullPath().toString(), false);
        URI platformResourceURI = URI.createPlatformResourceURI(fcore.getFullPath().toString(), true);
        editingDomain.getResourceSet().getURIConverter().getURIMap().put(platformPluginURI, platformResourceURI);

        // Create a resource for this file.
        if (fcore.exists()) {
            emfPatternResource = editingDomain.getResourceSet().getResource(platformPluginURI, true);
            keepPreviousFcoreIdsAndOrder(fcore, editingDomain, platformPluginURI);
            clearFcore(editingDomain);
        } else
            emfPatternResource = editingDomain.getResourceSet().createResource(platformPluginURI);

        URI emfPatternBaseResourceURI = URI.createPlatformPluginURI("/org.eclipse.egf.emf.pattern.base/egf/EMF_Pattern_Base.fcore", true); //$NON-NLS-1$
        emfPatternBaseResource = editingDomain.getResourceSet().getResource(emfPatternBaseResourceURI, true);
        URI mdpstResourceURI = URI.createPlatformPluginURI("/org.eclipse.egf.pattern.ftask/egf/Model_driven_pattern_strategy_task.fcore", true); //$NON-NLS-1$
        mdpstResource = editingDomain.getResourceSet().getResource(mdpstResourceURI, true);

        fcoreProject = fcore.getProject();
        codegenProject = ResourcesPlugin.getWorkspace().getRoot().getProject(CodegenFcoreUtil.ORG_ECLIPSE_EMF_CODEGEN_ECORE);
        if (!codegenProject.exists())
            throw new IllegalStateException("Cannot find project " + CodegenFcoreUtil.ORG_ECLIPSE_EMF_CODEGEN_ECORE + " in workspace"); //$NON-NLS-1$ //$NON-NLS-2$

        if (!codegenProject.isOpen())
            throw new IllegalStateException("Project " + CodegenFcoreUtil.ORG_ECLIPSE_EMF_CODEGEN_ECORE + " is closed"); //$NON-NLS-1$ //$NON-NLS-2$

        createCodegenVersionHelper();
        createCodegenPatternHelper();
        createCodegenEGFHelper(); //called with the newly created resource
        createCodegenJetPattenHelper();
        createPatternInfos(monitor);
        computePatternInfoNames();
        computeSubPatternInfo(monitor);
        computePatternInfoNames();
        computeMethodsContent(monitor);
        computePatternInfoDescription();
        replaceManifestVersion();

        // Add factory component to the contents.
        CreateCommand createCommand = new CreateCommand(editingDomain, monitor);
        editingDomain.getCommandStack().execute(createCommand);
        if (createCommand.exception != null)
            throw createCommand.exception;

        // save fcore
        try {
            editingDomain.runExclusive(new Runnable() {

                public void run() {
                    try {
                        emfPatternResource.save(Collections.EMPTY_MAP);
                    } catch (IOException ioe) {
                        ioExceptions[0] = ioe;
                    }
                }
            });
        } catch (InterruptedException ie) {
            return;
        }

        // Rethrow exception if any
        if (ioExceptions[0] != null) {
            throw ioExceptions[0];
        }

        return;
    }

    protected void replaceManifestVersion() throws CoreException, IOException {
        codegenVersionHelper.replaceManifestVersion();
    }

    protected void clearFcore(TransactionalEditingDomain editingDomain) throws Exception {
        ClearCommand clearCommand = new ClearCommand(editingDomain);
        editingDomain.getCommandStack().execute(clearCommand);
        if (clearCommand.exception != null)
            throw clearCommand.exception;
    }

    protected void keepPreviousFcoreIdsAndOrder(IFile fcore, TransactionalEditingDomain editingDomain, URI platformPluginURI) {
        // Try to keep xmi ids if fcore exists
        createCodegenEGFHelper(); //called with old resource
        codegenEGFHelper.populateXmiIds();
        codegenEGFHelper.populatePatternOrder();
    }

    protected void createCodegenPatternHelper() {
        codegenPatternHelper = new CodegenPatternHelper();
    }

    protected void createCodegenEGFHelper() {
        codegenEGFHelper = new CodegenEGFHelper(emfPatternResource, codegenEGFHelper);
    }

    public void createPatternInfos(IProgressMonitor monitor) throws Exception {
        patternInfos = new CodegenASTHelper().createPatternInfo(codegenProject, monitor);
        // sort list to have Model, Edit, Editor, Tests according to PartType
        // ordinal order
        Collections.sort(patternInfos, new AbstractInfoComparator());
    }

    public void computeSubPatternInfo(IProgressMonitor monitor) throws Exception {
        codegenJetPatternHelper.computeJetSubPatternInfo(patternInfos);
    }

    public void createCodegenJetPattenHelper() {
        codegenJetPatternHelper = new CodegenJetPatternHelper(codegenPatternHelper, codegenProject, emfPatternBaseResource, emfPatternResource);
    }

    public void createCodegenVersionHelper() {
        codegenVersionHelper = new CodegenVersionHelper(codegenProject, fcoreProject);
    }

    public void computePatternInfoNames() {
        new CodegenPatternNameResolver(codegenPatternHelper).computePatternName(patternInfos);
    }

    public void computePatternInfoDescription() throws Exception {
        new CodegenPatternDescriptionHandler(codegenProject).computeDescription(patternInfos, codegenVersionHelper);
    }

    public void computeMethodsContent(IProgressMonitor monitor) {
        for (PatternInfo patternInfo : patternInfos) {
            CodegenPatternMethodContentResolver codegenPatternMethodContentResolver = new CodegenPatternMethodContentResolver(codegenProject, codegenPatternHelper, emfPatternBaseResource, codegenJetPatternHelper);
            if (patternInfo instanceof JetPatternInfo) {
                JetPatternInfo jetPatternInfo = (JetPatternInfo) patternInfo;
                codegenPatternMethodContentResolver.computeMethodsContent(jetPatternInfo);
            } else if (patternInfo instanceof GIFPatternInfo) {
                GIFPatternInfo gifPatternInfo = (GIFPatternInfo) patternInfo;
                codegenPatternMethodContentResolver.computeMethodsContent(gifPatternInfo);
            } else if (patternInfo instanceof JetSubPatternInfo) {
                JetSubPatternInfo jetSubPatternInfo = (JetSubPatternInfo) patternInfo;
                codegenPatternMethodContentResolver.computeMethodsContent(jetSubPatternInfo);
            } else
                throw new IllegalStateException();

            monitor.worked(10);
        }
    }

    public void createPatterns(IProgressMonitor monitor) throws Exception {
        for (PatternInfo patternInfo : patternInfos) {
            Pattern pattern = getPatternFactory(patternInfo).createPattern();
            CodegenEngine codegenEngine = getCodeEngine(patternInfo);
            ContentProvider contentProvider = createContentProvider(patternInfo);
            TemplateInitializer initializer = getPatternTemplateInitializer(pattern, patternInfo, codegenEngine, contentProvider);
            initializer.initContent();

            monitor.worked(10);
        }
    }

    public TemplateInitializer getPatternTemplateInitializer(Pattern pattern, PatternInfo patternInfo, CodegenEngine codegenEngine, ContentProvider contentProvider) {
        return new CodegenJetPatternInitializer(fcoreProject, pattern, codegenEngine, contentProvider);
    }

    public ContentProvider createContentProvider(PatternInfo patternInfo) {
        return new ContentProvider(patternInfo);
    }

    public CodegenEngine getCodeEngine(PatternInfo patternInfo) {
        return new CodegenEngine(org.eclipse.egf.pattern.jet.Activator.getDefault().getPluginID(), fcoreProject, JetPreferences.getTemplateFileExtension());
    }

    public CodegenPatternFactory getPatternFactory(PatternInfo patternInfo) {
        return new CodegenPatternFactory(new JetPatternFactory(), emfPatternBaseResource, codegenEGFHelper, patternInfo, codegenPatternHelper);
    }
}
