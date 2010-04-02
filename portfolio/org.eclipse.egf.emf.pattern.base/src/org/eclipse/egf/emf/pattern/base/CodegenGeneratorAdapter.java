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

package org.eclipse.egf.emf.pattern.base;

import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapter;
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil;
import org.eclipse.emf.codegen.util.GIFEmitter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenGeneratorAdapter extends GenModelGeneratorAdapter {

    protected Generator generator;

    protected GenModel genModel;

    public CodegenGeneratorAdapter(GenModel genModel) {
        super(null);
        this.genModel = genModel;
    }

    @Override
    public Generator getGenerator() {
        if (generator == null) {
            generator = GenModelUtil.createGenerator(genModel);
        }
        return generator;
    }

    @Override
    public boolean canGenerate(Object object, Object projectType) {
        return super.canGenerate(object, projectType);
    }

    @Override
    public URI toURI(String pathName) {
        return super.toURI(pathName);
    }

    @Override
    public boolean exists(URI workspacePath) {
        return super.exists(workspacePath);
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
        StringJETEmitter stringJETEmitter = new StringJETEmitter(output);
        BasicMonitor monitor = new BasicMonitor();
        super.generateJava(targetPath, packageName, className, stringJETEmitter, null, monitor);
    }

    public void generateText(String targetPathName, boolean overwrite, String encoding, String output) {
        StringJETEmitter stringJETEmitter = new StringJETEmitter(output);
        BasicMonitor monitor = new BasicMonitor();
        super.generateText(targetPathName, stringJETEmitter, null, overwrite, encoding, monitor);
    }

    public void generateProperties(String targetPathName, String output) {
        StringJETEmitter stringJETEmitter = new StringJETEmitter(output);
        BasicMonitor monitor = new BasicMonitor();
        super.generateProperties(targetPathName, stringJETEmitter, null, monitor);
    }

    @Override
    public GIFEmitter createGIFEmitter(String inputPathName) {
        return super.createGIFEmitter(inputPathName);
    }

    public void generateGIF(String targetPathName, GIFEmitter gifEmitter, String parentKey, String childKey, boolean overwrite, Monitor monitor) {
        super.generateGIF(targetPathName, gifEmitter, parentKey, childKey, overwrite, monitor);
    }

    public void generateGIF(GenBase parameter, String inputPathName, String targetPathName, String parentKey, String childKey, boolean overwrite) {
        this.generatingObject = parameter;
        GIFEmitter gifEmitter = createGIFEmitter(inputPathName);
        BasicMonitor monitor = new BasicMonitor();
        generateGIF(targetPathName, gifEmitter, parentKey, childKey, overwrite, monitor);
        this.generatingObject = null;
    }
}
