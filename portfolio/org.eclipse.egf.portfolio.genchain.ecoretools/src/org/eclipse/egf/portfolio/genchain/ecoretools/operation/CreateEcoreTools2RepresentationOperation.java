/**
 * <copyright>
 * 
 * Copyright (c) 2014, 2019 Thales Corporate Services S.A.S.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.ecoretools.operation;
	
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.egf.portfolio.genchain.ecoretools.command.CreateEdgeCommand;
import org.eclipse.egf.portfolio.genchain.ecoretools.command.CreateNodeCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutService;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.dialect.command.CreateRepresentationCommand;
import org.eclipse.sirius.business.api.dialect.command.RefreshRepresentationsCommand;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.CustomDataConstants;
import org.eclipse.sirius.business.api.session.DefaultLocalSessionCreationOperation;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionCreationOperation;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.DragAndDropTarget;
import org.eclipse.sirius.diagram.business.api.query.EdgeMappingQuery;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizer;
import org.eclipse.sirius.diagram.business.api.refresh.CanonicalSynchronizerFactory;
import org.eclipse.sirius.diagram.business.api.refresh.DiagramCreationUtil;
import org.eclipse.sirius.diagram.business.internal.metamodel.helper.ContentHelper;
import org.eclipse.sirius.diagram.description.AbstractNodeMapping;
import org.eclipse.sirius.diagram.description.ContainerMapping;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.EdgeMapping;
import org.eclipse.sirius.diagram.description.NodeMapping;
import org.eclipse.sirius.diagram.ui.internal.refresh.SynchronizeGMFModelCommand;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.table.metamodel.table.DTable;
import org.eclipse.sirius.tools.api.command.semantic.AddSemanticResourceCommand;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.ui.business.internal.commands.ChangeViewpointSelectionCommand;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * <p>
 * This operation allows to :
 * <ul>
 * <li> create a Sirius representation file (aird)</li>
 * <li> associate an ecore model to the representation as a semantic resource</li>
 * <li> select a set of viewpoint </li>
 * <li> create diagrams on ecore {@link EPackage} elements</li>
 * </ul>
 * </p>
 * @see CreateEdgeCommand
 * @see CreateNodeCommand
 * @author Boubekeur Zendagui
 */
@SuppressWarnings("restriction")
public class CreateEcoreTools2RepresentationOperation extends WorkspaceModifyOperation {

	/** Sirius representation files extension **/
	private final static String _AIRD_FILE_EXTENSION = "aird";

	/** Viewpoint and diagrams names **/
	protected final static String VIEWPOINT_ECORE_DESIGN = "Design";
	protected final static String REPRESENTATION__ENTITIES_DIAGRAM = "Entities";
	protected final static String REPRESENTATION__DOCUMENTATION_TABLE = "Classes";

	/** List of all representation names to create**/
	protected Set<Viewpoint> viewpoints = new HashSet<Viewpoint>();
	protected List<RepresentationDescription> representations = new ArrayList<RepresentationDescription>();

	/** Representation file information **/
	private String representationFileName;
	private URI representationFileURI;
	private IProject representationProject;

	/** {@link URI} of the ecore model **/
	private URI ecoreModelURI;

	/**
	 * Default constructor
	 * @param ecoreURI ecore model URI
	 * @param fileName name of the representation file. If its value is <code> null <code/>,
	 * the representation file will have the same name of the ecore model
	 */
	public CreateEcoreTools2RepresentationOperation(URI ecoreURI, String fileName) {
		super();
		// ecoreModelURI value set must be the first operation
		this.ecoreModelURI = ecoreURI;
		// compute representation informations
		initRepresentationFileInformations(fileName);
		// Initialize Ecore Tools supported Viewpoint and available representations
		initViewpointsList();
	}

	private void initRepresentationFileInformations(String fileName) {
		this.representationFileName = getRepresentationFileName(fileName);
		this.representationFileURI = getRepresentationUri(fileName);
		this.representationProject = getRepresentationProject(fileName);
	}

	private boolean isFqnFileName(String fileName) {
		if (fileName != null && !fileName.isEmpty() && fileName.contains("/"))
			return true;
		else
			return false;
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		/** Step 1: create representation file and get the session **/
		Session session = createRepresentationFile(monitor);

		/** Step 2: Create diagrams on EPackages**/
		if (session != null) {// Create diagrams if session was well created in the previous step
			DDiagram diagram = createDiagrams(session, monitor);
			// Create diagram content
			if (diagram != null) {
				populateEntitiesDiagram(session, diagram);

				// Layout diagram content
				arrangeAll(session, diagram);
			}

			// Save session
			session.save(monitor);

			// CLose session
			//			session.close(monitor);
		}
	}

	/**
	 * Create all diagrams for ecore {@link EPackage}.
	 * @param session The {@link Session} opened on the created representation file 
	 * @param monitor {@link IProgressMonitor}
	 */
	private DDiagram createDiagrams(final Session session, IProgressMonitor monitor) {
		DDiagram entitiesDiagram = null;
		List<EPackage> ecoreEPackages = getEcoreEPackagesFromSession(session);
		for (EPackage iEPackage : ecoreEPackages) {
			Collection<DRepresentation> representations = DialectManager.INSTANCE.getRepresentations(iEPackage, session);
			if (representations.isEmpty()) {// Create all representation
				entitiesDiagram = createEntitiesDiagram(iEPackage, session, monitor);
				createClassesTable(iEPackage, session, monitor);
			} else {
				// Check no existence of "Entities" and "Classes" representations
				List<String> representationDescriptionNames = new ArrayList<String>();
				for (DRepresentation representation : representations) {
					if (representation instanceof DDiagram) {
						final DDiagram dDiagram = (DDiagram) representation;
						final RepresentationDescription description = dDiagram.getDescription();
						representationDescriptionNames.add(description.getName());
						final EList<DDiagramElement> ownedDiagramElements = dDiagram.getOwnedDiagramElements();
						if (ownedDiagramElements.isEmpty())
							entitiesDiagram = dDiagram;
						else {
							if (ownedDiagramElements.size() == 1) {
								final DDiagramElement dDiagramElement = ownedDiagramElements.get(0);
								if (dDiagramElement.getMapping().getName().equals("Empty Diagram")) {
									entitiesDiagram = dDiagram;
								}
							}
						}
					} else {
						if (representation instanceof DTable) {
							final RepresentationDescription description = ((DTable) representation).getDescription();
							representationDescriptionNames.add(description.getName());
						}
					}
				}

				if (!representationDescriptionNames.contains(REPRESENTATION__ENTITIES_DIAGRAM))
					entitiesDiagram = createEntitiesDiagram(iEPackage, session, monitor);

				if (!representationDescriptionNames.contains(REPRESENTATION__DOCUMENTATION_TABLE))
					createClassesTable(iEPackage, session, monitor);
			}
		}
		return entitiesDiagram;
	}

	/**
	 * Allows to arrange all on a given diagram
	 * @param session uses {@link Session} to edit diagrams
	 * @param diagram {@link DDiagram} to arrange
	 */
	private void arrangeAll(final Session session, final DDiagram diagram) {
		final DiagramCreationUtil util = new DiagramCreationUtil(diagram);
		Diagram associatedGMFDiagram = null;
		if (!util.findAssociatedGMFDiagram()) {// If GMF diagram is not initialized, create it
			util.createNewGMFDiagram();
			associatedGMFDiagram = util.getAssociatedGMFDiagram();
			if (associatedGMFDiagram != null)
				session.getServices().putCustomData(CustomDataConstants.GMF_DIAGRAMS, diagram, associatedGMFDiagram);
		} else {// Get the GMF diagram
			associatedGMFDiagram = util.getAssociatedGMFDiagram();
		}

		// Synchronize Sirius diagram with GMF diagram 
		final TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
		if (associatedGMFDiagram != null) {
			final CanonicalSynchronizer canonicalSynchronizer = CanonicalSynchronizerFactory.INSTANCE.createCanonicalSynchronizer(associatedGMFDiagram);
			Command gmfNotationModelSynchronizationCmd = new SynchronizeGMFModelCommand(domain, canonicalSynchronizer);
			domain.getCommandStack().execute(gmfNotationModelSynchronizationCmd);
		}

		final Diagram associatedGMFDiagram_f = associatedGMFDiagram;
		Display.getDefault().syncExec(new Runnable() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public void run() {
				Shell shell = new Shell(Display.getDefault());
				try {
					DiagramEditPart diagramEP = org.eclipse.sirius.diagram.ui.tools.internal.part.OffscreenEditPartFactory.getInstance().createDiagramEditPart(associatedGMFDiagram_f, shell);

					/** Register Nodes Edit Part in diagram viewpoint Registry **/
					final ListIterator listIterator = associatedGMFDiagram_f.getChildren().listIterator();
					while (listIterator.hasNext()) {
						final Object next = listIterator.next();
						org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart g = ((org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart) diagramEP.getPrimaryEditParts().get(0));
						next.toString();
						diagramEP.getViewer().getEditPartRegistry().put(next, g);
					}

					/** Define hint**/
					List<Object> hints = new ArrayList<Object>(2);
					hints.add(LayoutType.DEFAULT);
					hints.add(diagramEP);
					IAdaptable layoutHint = new ObjectAdapter(hints);

					/** Process layout **/
					List layoutNodes = LayoutService.getInstance().getLayoutNodes(diagramEP, associatedGMFDiagram_f.getChildren());
					Runnable layoutRun = LayoutService.getInstance().layoutLayoutNodes(layoutNodes, false, layoutHint);
					layoutRun.run();
				} finally {
					//					shell.dispose();
				}
			}
		});

		//		if (associatedGMFDiagram_f != null)
		//		{
		//			Display.getDefault().syncExec(new Runnable() {
		//				public void run() {
		//					RecordingCommand command = new RecordingCommand(session.getTransactionalEditingDomain()) {
		//						@Override
		//						protected void doExecute() {
		//							LayoutUtils.initializeDiagramLayout(associatedGMFDiagram_f, diagram);
		//						}
		//					};
		//					session.getTransactionalEditingDomain().getCommandStack().execute(command);	
		//				}
		//			});
		//		}
	}

	/**
	 * Create diagram content
	 * @param session used {@link Session} to edit diagrams
	 * @param diagram {@link DDiagram} to populate with containers, nodes and edges
	 */
	private void populateEntitiesDiagram(final Session session, final DDiagram diagram) {
		List<EPackage> ecoreEPackagesFromSession = getEcoreEPackagesFromSession(session);
		for (EPackage ePackage : ecoreEPackagesFromSession) {
			populateNodesAndContainers(session, diagram, ePackage);
			populateEdges(session, diagram, ePackage);
		}

		refreshDiagram(session, diagram);
	}

	/**
	 * Refresh a given diagram.
	 * @param session session used to edit <code>diagram</code>
	 * @param diagram the diagram to refresh
	 */
	private void refreshDiagram(final Session session, final DDiagram diagram) {
		final TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
		editingDomain.getCommandStack().execute(new RefreshRepresentationsCommand(editingDomain, new NullProgressMonitor(), diagram));
	}

	private void populateEdges(final Session session, final DDiagram diagram, EPackage ePackage) {
		/** List of diagram description edges mapping**/
		final DiagramDescription description = diagram.getDescription();
		EList<EdgeMapping> allEdgeMappings = description.getDefaultLayer().getEdgeMappings();
		// Create and execute edge creation commands
		TransactionalEditingDomain transactionalEditingDomain = session.getTransactionalEditingDomain();
		for (EdgeMapping edgeMapping : allEdgeMappings) {
			boolean useDomainElement = edgeMapping.isUseDomainElement();
			if (useDomainElement) {
				EdgeMappingQuery edgeMappingQuery = new EdgeMappingQuery(edgeMapping);
				Collection<EObject> candidates = edgeMappingQuery.evaluateCandidateExpression((DSemanticDiagram) diagram, session.getInterpreter(), (DragAndDropTarget) diagram);
				for (EObject eObject : candidates) {
					CreateEdgeCommand command = new CreateEdgeCommand(session, diagram, edgeMapping, eObject, useDomainElement);
					transactionalEditingDomain.getCommandStack().execute(command);
				}
			} else {
				for (EObject semantic : ePackage.eContents()) {
					CreateEdgeCommand command = new CreateEdgeCommand(session, diagram, edgeMapping, semantic, useDomainElement);
					transactionalEditingDomain.getCommandStack().execute(command);
				}
			}
		}
		transactionalEditingDomain.getCommandStack().flush();
	}

	/**
	 * Create nodes and containers diagram children
	 * @param session used {@link Session} to edit diagrams
	 * @param diagram {@link DDiagram} to populate with nodes and containers
	 * @param ePackage {@link EPackage} 
	 */
	private void populateNodesAndContainers(final Session session, final DDiagram diagram, EPackage ePackage) {
		/** List of diagram description node and container mapping**/
		EList<AbstractNodeMapping> abstractNodeMappings = new BasicEList<AbstractNodeMapping>();
		final DiagramDescription description = diagram.getDescription();
		/** Handle description NodeMppings **/
		EList<NodeMapping> nodeMappings = ContentHelper.getAllNodeMappings(description, true);
		if (!nodeMappings.isEmpty())
			abstractNodeMappings.addAll(nodeMappings);

		/** Handle description ContainerMppings **/
		EList<ContainerMapping> containerMappings = ContentHelper.getAllContainerMappings(description, true);
		if (!containerMappings.isEmpty())
			abstractNodeMappings.addAll(containerMappings);

		final ModelAccessor modelAccessor = session.getModelAccessor();
		for (final AbstractNodeMapping abstractNodeMapping : abstractNodeMappings) {
			final String domainClass = abstractNodeMapping.getDomainClass();
			// Handling EPackage content
			for (final EObject element : ePackage.eContents()) {
				if (modelAccessor.eInstanceOf(element, domainClass)) {
					CreateNodeCommand command = new CreateNodeCommand(session, diagram, abstractNodeMapping, element);
					session.getTransactionalEditingDomain().getCommandStack().execute(command);
				}
			}
		}
	}

	/**
	 * Create a diagram Representation
	 * @param semantic model element root of the representation to create
	 * @param session {@link Session} used to create the representation
	 * @param monitor {@link IProgressMonitor} to trace representation creation
	 * @return True if the representation is well created, false otherwise
	 */
	private DDiagram createEntitiesDiagram(final EPackage semantic, Session session, IProgressMonitor monitor) {
		final RepresentationDescription entitiesDiagram = getRepresentationDescription(REPRESENTATION__ENTITIES_DIAGRAM);
		final String diagramName = semantic.getName() + " entities diagram";
		DRepresentation createRepresentation = createRepresentation(semantic, session, entitiesDiagram, diagramName, monitor);
		return (DDiagram) createRepresentation;
	}

	/**
	 * Create a Table representation
	 * @param semantic model element root of the representation to create
	 * @param session {@link Session} used to create the representation
	 * @param monitor {@link IProgressMonitor} to trace representation creation
	 * @return True if the representation is well created, false otherwise
	 */
	private DTable createClassesTable(final EPackage semantic, final Session session, IProgressMonitor monitor) {
		final RepresentationDescription classesTable = getRepresentationDescription(REPRESENTATION__DOCUMENTATION_TABLE);
		final String tableName = semantic.getName() + " documentation";
		DRepresentation createRepresentation = createRepresentation(semantic, session, classesTable, tableName, monitor);
		return (DTable) createRepresentation;
	}

	/**
	 * Create one representation for a given semantic element in a given session
	 * @param semantic model element root of the representation to create
	 * @param session {@link Session} used to create the representation
	 * @param description {@link RepresentationDescription} used to create the representation
	 * @param name representation name
	 * @param monitor {@link IProgressMonitor} to trace representation creation
	 * @return the created {@link DRepresentation}
	 */
	private DRepresentation createRepresentation(final EObject semantic, final Session session, final RepresentationDescription description, final String name, IProgressMonitor monitor) {
		CreateRepresentationCommand createRepresentationCommand = new CreateRepresentationCommand(session, description, semantic, name, monitor);
		session.getTransactionalEditingDomain().getCommandStack().execute(createRepresentationCommand);
		DRepresentation createdRepresentation = createRepresentationCommand.getCreatedRepresentation();
		return createdRepresentation;
	}

	/**
	 * 
	 * @param representationName the name of sought representation
	 * @return a {@link RepresentationDescription} or null
	 */
	private RepresentationDescription getRepresentationDescription(String representationName) {
		for (RepresentationDescription representation : representations) {
			if (representation.getName().equals(representationName))
				return representation;
		}
		return null;
	}

	/**
	 * @return {@link EPackage} available in the ecore resource
	 */

	private List<EPackage> getEcoreEPackagesFromSession(Session session) {
		final List<EPackage> result = new ArrayList<EPackage>();
		for (Resource resource : session.getSemanticResources()) {
			if (resource.getURI().toString().equals(ecoreModelURI.toString())) {
				EList<EObject> contents = resource.getContents();
				if (contents != null && !contents.isEmpty()) {
					EObject eObject = contents.get(0);
					if (eObject instanceof EPackage) {
						EPackage ePackage = (EPackage) eObject;
						result.add(ePackage);
						List<EPackage> subPackages = getSubPackages(ePackage);
						if (!subPackages.isEmpty()) {
							result.addAll(subPackages);
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * @param parent the parent {@link EPackage}
	 * @return a {@link List} of sub packages
	 */
	private List<EPackage> getSubPackages(EPackage parent) {
		final List<EPackage> result = new ArrayList<EPackage>();

		EList<EPackage> eSubpackages = parent.getESubpackages();
		if (eSubpackages != null && !eSubpackages.isEmpty()) {
			result.addAll(eSubpackages);
			for (EPackage ePackage : eSubpackages) {
				List<EPackage> children = getSubPackages(ePackage);
				if (!children.isEmpty()) {
					result.addAll(children);
				}
			}
		}

		return result;
	}

	/**
	 * Create the representation file for the ecore
	 * @param monitor {@link IProgressMonitor} to trace operation
	 */
	private Session createRepresentationFile(IProgressMonitor monitor) {
		monitor.subTask("create the representation model..."); //$NON-NLS-1$ 
		/** Get the project containing the ecore model**/
		IProject project = this.representationProject; /*getRepresentationProject();*/

		/** Create the aird file and create a Session **/
		final Session session = createAird(project, representationFileURI, monitor);

		if (session == null) {// Session is not created
			throw new RuntimeException("Can't create a session for " + representationFileURI.toString());
		} else {// Session created with success
			/** prepare session ressource set for ecore models **/
			session.getTransactionalEditingDomain().getResourceSet().getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap(false));
		}

		// Command to link ecore model to the session
		AddSemanticResourceCommand addSemanticResourceCommand = new AddSemanticResourceCommand(session, ecoreModelURI, new SubProgressMonitor(monitor, 1));
		// Command to select Viewpoint in the current session
		ChangeViewpointSelectionCommand changeViewpointSelectionCommand = new ChangeViewpointSelectionCommand(session, new ViewpointSelectionCallback(), viewpoints, Collections.<Viewpoint> emptySet(), false, new SubProgressMonitor(monitor, 1));

		// Execute the 2 created commands bellow
		CompoundCommand compoundCommand = new CompoundCommand("Link resources to representation"); //$NON-NLS-1$ 
		compoundCommand.append(addSemanticResourceCommand);
		compoundCommand.append(changeViewpointSelectionCommand);
		session.getTransactionalEditingDomain().getCommandStack().execute(compoundCommand);

		return session;
	}

	/**
	 * Reworked code from org.eclipse.emf.ecoretools.design.wizard.EcoreModelingProjectCreationOperation.createAird(IProject, URI, IProgressMonitor) 
	 */
	public static Session createAird(IProject project, URI representationsURI, IProgressMonitor monitor) {
		Session session = null;
		// Get the corresponding modeling project
		Option<ModelingProject> modelingProject = ModelingProject.asModelingProject(project);
		if (modelingProject.some()) { // If project is a modeling project, then get it session
			session = modelingProject.get().getSession();
		} else {// Else, create a new session
			SessionCreationOperation sessionCreationOperation = new DefaultLocalSessionCreationOperation(representationsURI, monitor);
			try {
				sessionCreationOperation.execute();
				session = sessionCreationOperation.getCreatedSession();
			} catch (CoreException e) {
				throw new RuntimeException("Can't create session for " + representationsURI, e);
			}
		}
		return session;
	}

	/**
	 * Compute the representation file {@link URI}. This file will be created near of ecore model
	 * @return the representation file {@link URI}
	 */
	private URI getRepresentationUri(String fileName) {
		String stringRepresentationURI = "";

		if (isFqnFileName(fileName)) {
			stringRepresentationURI = fileName;
		} else {
			URI ecoreUriWithoutFileExtension = this.ecoreModelURI.trimFileExtension();
			if (ecoreUriWithoutFileExtension != null && ecoreUriWithoutFileExtension.segmentCount() > 1) {
				for (int i = 1; i < ecoreUriWithoutFileExtension.segments().length - 1; i++) {
					stringRepresentationURI += "/" + ecoreUriWithoutFileExtension.segments()[i];
				}
				stringRepresentationURI += "/" + this.representationFileName;
			} else {
				throw new RuntimeException("Ecore URI is not valid");
			}
		}

		if (stringRepresentationURI.length() > 0)
			return URI.createPlatformResourceURI(stringRepresentationURI, true);
		else
			throw new RuntimeException("Error on creating representation URI");

	}

	/**
	 * Check if fileName value is valid. If it is not the case, this method return ecore model file name + ".aird"
	 * @param fileName representation file name. This parameter accept <code> null <code/> value
	 * @param ecoreURI {@link URI} of the ecore model
	 * @return a valid representation file name
	 */
	private String getRepresentationFileName(String fileName) {
		// TODO: implement it
		if (fileName == null || (fileName != null && fileName.trim().length() < 1)) {
			URI ecoreUriWithoutFileExtension = this.ecoreModelURI.trimFileExtension();
			if (ecoreUriWithoutFileExtension != null && ecoreUriWithoutFileExtension.segmentCount() > 1) {
				String ecoreModelName = ecoreUriWithoutFileExtension.lastSegment();
				ecoreModelName += "." + _AIRD_FILE_EXTENSION;
				return ecoreModelName;
			} else {
				throw new RuntimeException("Ecore file URI is not valid");
			}
		} else {
			boolean fqnFileName = isFqnFileName(fileName);
			if (fqnFileName) {
				String[] segments = fileName.split("/");
				String lastSegment = segments[segments.length - 1];
				if (lastSegment.contains(_AIRD_FILE_EXTENSION))
					return lastSegment;
				else
					return lastSegment + "." + _AIRD_FILE_EXTENSION;

			}
		}
		return fileName;
	}

	/**
	 * @return the {@link IProject} containing the ecore model
	 */
	private IProject getRepresentationProject(String fileName) {
		String projectName = null;
		List<String> foldersToCreate = new ArrayList<String>();

		if (isFqnFileName(fileName)) {/* The file name provided by user is like: /PluginID/folders/filename.aird
										 * In this case, the project and folder will be created if they are not available */
			String[] segments = fileName.split("/");
			projectName = segments[0];
			// create the list of folders to create
			for (int i = 1; i < segments.length - 1; i++) {
				foldersToCreate.add(segments[i]);
			}
		} else {// The file name provided by user is like: filename.aird
				// FIXME: Check id we use the well segment 
			if (ecoreModelURI.isPlatform()) {// Case of platform URI (Plug-in or Resource URI) 
				projectName = ecoreModelURI.segment(1);
			} else {// Case of hierarchical URI. Only URI FQN like are handled.
				projectName = ecoreModelURI.segment(0);
			}
		}

		// Get/create the project from/into the workspace
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		NullProgressMonitor NPM = new NullProgressMonitor();

		try {
			if (!project.exists()) {
				project.create(NPM);
			}
			project.open(NPM);
		} catch (CoreException e) {
			throw new RuntimeException("Project with name : " + projectName + " can't be localized", e);
		}

		// Create folders if needed
		if (!foldersToCreate.isEmpty()) {
			IFolder currentFolder = null;
			for (String folderName : foldersToCreate) {
				if (currentFolder == null) {// Case of the first iteration, get the folder from the project
					currentFolder = project.getFolder(folderName);
				} else {// Case of the other iterations, get the folder from it parent folder
					currentFolder = currentFolder.getFolder(folderName);
				}

				if (!currentFolder.exists()) { // Create the folder if it is was not created yet.
					try {
						currentFolder.create(true, true, NPM);
					} catch (CoreException e) {
						throw new RuntimeException("Can't create folder : " + currentFolder, e);
					}
				}
			}
		}

		return project;
	}

	/**
	 * Initialize Viewpoints list
	 */
	private void initViewpointsList() {
		// Step 1: initialize Viewpoint list
		for (Viewpoint viewpoint : ViewpointRegistry.getInstance().getViewpoints()) {
			if (viewpoint.getName().equals(VIEWPOINT_ECORE_DESIGN) && viewpoint.eResource().getURI().segmentsList().contains("org.eclipse.emf.ecoretools.design")) {
				viewpoints.add(viewpoint);
				// At this state of work, we handle only Design viewpoint for ecore model
				break;
			}
		}

		// Step 2: initialize Representation list
		if (!viewpoints.isEmpty()) {
			for (Viewpoint viewpoint : viewpoints) {
				EList<RepresentationDescription> ownedRepresentations = viewpoint.getOwnedRepresentations();
				if (ownedRepresentations != null && !ownedRepresentations.isEmpty()) {
					for (RepresentationDescription representationDescription : ownedRepresentations) {
						if (representationDescription.getName().equals(REPRESENTATION__ENTITIES_DIAGRAM) || representationDescription.getName().equals(REPRESENTATION__DOCUMENTATION_TABLE)) {
							representations.add(representationDescription);
						}
					}
				}
			}
		}
	}
}
