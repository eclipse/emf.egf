/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.portfolio.task.ant.engine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.core.platform.uri.TargetPlatformURIConverter;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.egf.model.types.Type;
import org.eclipse.egf.model.types.TypeString;
import org.eclipse.egf.portfolio.task.ant.Messages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

/**
 * @author xiaoru chen
 * 
 */
public class AntScriptEngine {

    private static final String XML = "xml"; //$NON-NLS-1$
    private static final String DYNAMIC = "dynamic"; //$NON-NLS-1$
    public final static String TASK_PRODUCTION_CONTEXT = "TaskProductionContext"; //$NON-NLS-1$

    public void executeAntTask(Task task, ITaskProductionContext context, SubMonitor monitor) throws Exception {
        String implementation = task.getImplementationValue().trim();

        File antFile = null;
        if (DYNAMIC.equals(implementation.toLowerCase())) {
            antFile = handleDynamicAntFile(context, task);
        } else
            antFile = getFile(implementation);

        if (!antFile.exists()) {
            throw new Exception("Can not find the ant file :\'" + implementation + "\'!"); //$NON-NLS-1$ //$NON-NLS-2$
        }

        // Create a ant project
        AntProject p = new AntProject();
        // Create a default log listeners
        AntTaskBuildLogger consoleLogger = new AntTaskBuildLogger();
        consoleLogger.setErrorPrintStream(System.err);
        consoleLogger.setOutputPrintStream(System.out);
        consoleLogger.setMessageOutputLevel(Project.MSG_INFO);
        p.addBuildListener(consoleLogger);
        try {
            // Execute the ant task.
            SubMonitor subMonitor = ((SubMonitor) monitor).newChild(100, SubMonitor.SUPPRESS_NONE);
            p.fireBuildStarted();
            // Init the project
            p.init();
            ProjectHelper helper = ProjectHelper.getProjectHelper();
            // Analytical project construction documents
            helper.parse(p, antFile);
            // execute some target.
            String defaultTarget = p.getDefaultTarget();
            p.addReference(TASK_PRODUCTION_CONTEXT, context);
            p.executeTarget(defaultTarget);
            p.fireBuildFinished(null);
            doSubMonitor(subMonitor);
        } catch (BuildException be) {
            p.fireBuildFinished(be);
            throw be;
        } finally {
            if (DYNAMIC.equals(implementation.toLowerCase())) 
                antFile.delete();
        }
    }

    protected File handleDynamicAntFile(ITaskProductionContext context, Task task) throws IOException, InvocationException {
        Contract contract = task.getContract(XML);
        if (contract == null)
            throw new IllegalStateException(Messages.AntScriptEngine_2);
        
        Type type = contract.getType();
        if (type == null || !(type instanceof TypeString)) 
            throw new IllegalStateException(Messages.AntScriptEngine_3);
        
        String xml = (String) context.getInputValue(contract.getName(), contract.getType().getType());
        
        if (xml == null)
            throw new IllegalStateException(Messages.AntScriptEngine_4);
        
        File antFile = File.createTempFile("egf", "tempAntFile"); //$NON-NLS-1$ //$NON-NLS-2$
        
        FileWriter fileWriter = new FileWriter(antFile);
        fileWriter.write(xml);
        fileWriter.close();
        
        return antFile;
    }

    private void doSubMonitor(SubMonitor subMonitor) {
        subMonitor.worked(100);
        if (subMonitor.isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    private File getFile(String value) throws IOException {
        URI uri = URI.createURI(value);
        TargetPlatformURIConverter converter = new TargetPlatformURIConverter();
        URL resolveTarget = resolveTarget(converter.normalize(uri));
        File antfile = new File(resolveTarget.getPath());
        return antfile;
    }

    /**
     * @see org.eclipse.egf.core.platform.uri.TargetPlatformURIHandlerImpl#resolveTarget()
     */
    public static URL resolveTarget(URI uri) throws IOException {
        if (uri.isPlatform() == false) {
            return new URL(uri.toString());
        }
        String pluginID = uri.segment(1);
        // Retrieve the target bundle (either workspace or target) if any
        IPluginModelBase model = PluginRegistry.findModel(pluginID);
        if (model == null) {
            throw new IOException(NLS.bind("Unable to resolve target plug-in \"{0}\".", pluginID)); //$NON-NLS-1$                    
        }
        // Not sure if it's needed however we are conservative here
        if (model.isEnabled() == false) {
            throw new IOException(NLS.bind("Target plug-in is disabled \"{0}\".", pluginID)); //$NON-NLS-1$
        }
        IPath path = new Path(uri.toPlatformString(true)).removeFirstSegments(1);
        File file = new File(model.getInstallLocation());
        if (file.exists() == false) {
            throw new IOException(NLS.bind("Target install location \"{0}\" doesn't exist.", file.toString())); //$NON-NLS-1$
        }
        // regular directory
        if (file.isFile() == false) {
            file = new File(model.getInstallLocation(), path.toOSString());
            if (file.exists() == false) {
                throw new IOException(NLS.bind("Target resource \"{0}\" doesn't exist.", file.toString())); //$NON-NLS-1$
            }
            return file.toURL();
        }
        // jar or zip file see getInstallLocation() for comments
        // inner jar or zip file are not supported
        return new URL("jar:" + file.toURL().toString() + "!/" + path.toString()); //$NON-NLS-1$ //$NON-NLS-2$
    }
}
