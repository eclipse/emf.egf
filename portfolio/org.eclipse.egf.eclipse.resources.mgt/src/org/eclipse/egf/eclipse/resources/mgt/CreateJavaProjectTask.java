/**
 * 
 */
package org.eclipse.egf.eclipse.resources.mgt;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.pde.internal.core.ClasspathComputer;
import org.eclipse.pde.internal.core.util.CoreUtility;

/**
 * @author Thomas Guiu
 * 
 */
public class CreateJavaProjectTask implements ITaskProduction {
    public static final String PROJECT_CONTRACT = "name";
    public static final String EXECUTION_ENVIRONMENT_CONTRACT = "execution.environment";

    private static final String DEFAULT_SOURCE_FOLDER = "src";

    public void doExecute(ITaskProductionContext context, IProgressMonitor monitor) throws InvocationException {
        String projectId = context.getInputValue(PROJECT_CONTRACT, String.class);
        if (projectId == null || "".equals(projectId))
            throw new InvocationException("empty project name");

        String ee = context.getInputValue(EXECUTION_ENVIRONMENT_CONTRACT, String.class);
        if (ee == null || "".equals(ee))
            throw new InvocationException("no execution envirronment");
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(projectId);

        try {
            if (!project.exists())
                CoreUtility.createProject(project, root.getRawLocation(), monitor);
            project.open(monitor);
            // CoreUtility.addNatureToProject(project, PDE.PLUGIN_NATURE, null);
            CoreUtility.addNatureToProject(project, JavaCore.NATURE_ID, monitor);
            CoreUtility.createFolder(project.getFolder(DEFAULT_SOURCE_FOLDER));

            // set up classpath
            IJavaProject javaProject = JavaCore.create(project);
            // Set output folder
            IPath path = project.getFullPath().append("bin");
            javaProject.setOutputLocation(path, monitor);

            IClasspathEntry[] entries = new IClasspathEntry[3];
            entries[0] = JavaCore.newSourceEntry(project.getProject().getFullPath().append(DEFAULT_SOURCE_FOLDER));
            // entries[1] =
            // JavaCore.newSourceEntry(project.getProject().getFullPath().append(GENERATED_SOURCE_FOLDER));
            ClasspathComputer.setComplianceOptions(javaProject, ee);
            entries[1] = ClasspathComputer.createJREEntry(ee);
            entries[2] = ClasspathComputer.createContainerEntry();
            javaProject.setRawClasspath(entries, monitor);

        } catch (CoreException e) {
            throw new InvocationException(e);
        }
    }

    public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

    public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
    }

}
