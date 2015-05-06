/**
 * <copyright>
 *
 *  Copyright (c) 2011 Thales Corporate Services S.A.S.
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
package org.eclipse.egf.portfolio.genchain.ecoretools.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecoretools.diagram.edit.parts.EPackageEditPart;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramContentInitializer;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorPlugin;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutService;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.ui.PlatformUI;

public class EcoreToolsTaskProduction implements ITaskProduction {

	private final class InitializeDiagramCommand extends
			AbstractTransactionalCommand {
		private final Diagram diagram;

		private InitializeDiagramCommand(TransactionalEditingDomain domain,
				String label, List affectedFiles, Diagram diagram) {
			super(domain, label, affectedFiles);
			this.diagram = diagram;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			EcoreDiagramContentInitializer initializer = new EcoreDiagramContentInitializer();

			initializer.setInitEPackageContent(false);
			initializer.initDiagramContent(diagram);
			
			if (!diagram.getChildren().isEmpty()) {
				List<Node> nodes = new ArrayList<Node>();
				for (Object view : diagram.getChildren()) {
					if (view instanceof Node) {
						nodes.add((Node) view);
					}
				}
				LayoutService.getInstance().layoutNodes(nodes, true, LayoutType.DEFAULT);
			}
			return CommandResult.newOKCommandResult();
		}
	}

	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {

	}

	public void postExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		URI modelUri = productionContext.getInputValue("model", URI.class);
		String fileName = productionContext.getInputValue("fileName",
				String.class);

		final TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();

		URI diagramModelURI = URI.createPlatformResourceURI(fileName, true);
		final Resource diagramResource = resourceSet
				.createResource(diagramModelURI);
		Resource resource = resourceSet.getResource(modelUri, true);
		final EObject modelRoot = (EObject) resource.getContents().get(0);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				editingDomain, "", Collections.emptyList()) {

			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {

				Diagram diagram = ViewService.createDiagram(modelRoot,
						EPackageEditPart.MODEL_ID,
						EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				diagramResource.getContents().add(diagram);
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					new NullProgressMonitor(), null);
			diagramResource.save(EcoreDiagramEditorUtil.getSaveOptions());

			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

				public void run() {
					EObject diagram = diagramResource.getContents().get(0);
					if (diagram instanceof Diagram) {
						AbstractTransactionalCommand command = new InitializeDiagramCommand(
								editingDomain, "", null, (Diagram) diagram);

						try {
							OperationHistoryFactory.getOperationHistory()
									.execute(command,
											new NullProgressMonitor(), null);

						} catch (ExecutionException e) {
							e.printStackTrace();
						}
					}

				}

			});

			diagramResource.save(EcoreDiagramEditorUtil.getSaveOptions());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {

	}

}
