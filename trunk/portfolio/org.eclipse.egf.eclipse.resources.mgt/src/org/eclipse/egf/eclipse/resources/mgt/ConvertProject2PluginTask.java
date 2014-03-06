/**
 * 
 */
package org.eclipse.egf.eclipse.resources.mgt;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.pde.tools.ConvertProjectOperation;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.ui.internal.editors.text.WorkspaceOperationRunner;

/**
 * @author Thomas Guiu
 * 
 */
public class ConvertProject2PluginTask implements ITaskProduction {
	public static final String PROJECT_CONTRACT = "name";

	public void doExecute(ITaskProductionContext context, IProgressMonitor monitor) throws InvocationException {
		String projectId = context.getInputValue(PROJECT_CONTRACT, String.class);
		if (projectId == null || "".equals(projectId))
			throw new InvocationException("empty project name");

		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectId);
			WorkspaceOperationRunner runner = new WorkspaceOperationRunner();
			runner.setProgressMonitor(monitor);
			runner.run(false, false, new ConvertProjectOperation(project, false, true));

		} catch (Exception e) {
			throw new InvocationException(e);
		}
	}

	public void postExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
	}

	public void preExecute(ITaskProductionContext productionContext, IProgressMonitor monitor) throws InvocationException {
	}

}
