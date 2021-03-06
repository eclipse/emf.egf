/**
 * <copyright>
 * 
 * Copyright (c) 2009, 2018 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenGeneratorAdapter extends GenBaseGeneratorAdapter {

    protected Generator _generator;

    protected GenModel _genModel;

    protected URI _mergeRulesURI;

    public CodegenGeneratorAdapter(GenBase generatingObject) {
        super(null);
        this.generatingObject = generatingObject;
        _genModel = generatingObject.getGenModel();
    }

    public void setMergeRulesURI(URI mergeRulesURI) {
        _mergeRulesURI = mergeRulesURI;
    }

    @Override
    public Generator getGenerator() {
        if (_generator == null) {
            _generator = EGFGenModelUtil.createGenerator(_genModel, _mergeRulesURI);
        }
        return _generator;
    }

    public boolean canGenerate(Object projectType) {
        return super.canGenerate(generatingObject, projectType);
    }

    @Override
    public URI toURI(String pathName) {
        return super.toURI(pathName);
    }

    protected OutputStream createOutputStream(final URI workspacePath) throws Exception {
        return new ByteArrayOutputStream(5000) {

            @Override
            public void close() throws IOException {
                final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(workspacePath.toString()));
                try {
                    // use buf directly to avoid duplication of the array.
                    if (file.exists())
                        file.setContents(new ByteArrayInputStream(buf, 0, count), IResource.KEEP_HISTORY | IResource.FORCE, null);
                    else
                        file.create(new ByteArrayInputStream(buf, 0, count), true, null);
                } catch (CoreException e) {
                    final IOException ioException = new IOException(e.getMessage());
                    ioException.initCause(e);
                    throw ioException;
                }
            }

        };
        // return
        // getURIConverter().createOutputStream(toPlatformResourceURI(workspacePath),
        // null);
    }

    @Override
    public boolean exists(URI workspacePath) {
        return ResourcesPlugin.getWorkspace().getRoot().exists(new Path(workspacePath.toString()));
    }

    @Override
    public void ensureProjectExists(String workspacePath, Object object, Object projectType, boolean force, Monitor monitor) {
        super.ensureProjectExists(workspacePath, object, projectType, force, monitor);
    }

    @Override
    public void ensureContainerExists(URI workspacePath, Monitor monitor) {
        super.ensureContainerExists(workspacePath, monitor);
    }

    public void generateJava(String targetPath, String packageName, String className, String output) {
        generateJava(targetPath, packageName, className, new StringJETEmitter(output), (Object[]) null, new BasicMonitor());
    }

    public void generateText(String targetPathName, boolean overwrite, String encoding, String output) {
        generateText(targetPathName, new StringJETEmitter(output), (Object[]) null, overwrite, encoding, new BasicMonitor());
    }

    public void generateProperties(String targetPathName, String output) {
        generateProperties(targetPathName, new StringJETEmitter(output), (Object[]) null, new BasicMonitor());
    }

    public void generateGIF(String inputPathName, String targetPathName, String parentKey, String childKey, boolean overwrite) {
        generateGIF(targetPathName, createGIFEmitter(inputPathName), parentKey, childKey, overwrite, new BasicMonitor());
    }

}
