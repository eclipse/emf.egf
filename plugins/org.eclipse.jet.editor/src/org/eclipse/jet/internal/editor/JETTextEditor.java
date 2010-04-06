/*******************************************************************************
 * Copyright (c) 2005, 2007 ILOG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Joel Cheuoua - Initial API and implementation
 *******************************************************************************/
package org.eclipse.jet.internal.editor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jet.core.parser.ast.Comment;
import org.eclipse.jet.core.parser.ast.IncludedContent;
import org.eclipse.jet.core.parser.ast.JETASTElement;
import org.eclipse.jet.core.parser.ast.JETASTVisitor;
import org.eclipse.jet.core.parser.ast.JETCompilationUnit;
import org.eclipse.jet.core.parser.ast.JETDirective;
import org.eclipse.jet.core.parser.ast.JavaDeclaration;
import org.eclipse.jet.core.parser.ast.JavaExpression;
import org.eclipse.jet.core.parser.ast.JavaScriptlet;
import org.eclipse.jet.core.parser.ast.TextElement;
import org.eclipse.jet.core.parser.ast.XMLBodyElement;
import org.eclipse.jet.core.parser.ast.XMLBodyElementEnd;
import org.eclipse.jet.core.parser.ast.XMLEmptyElement;
import org.eclipse.jet.internal.compiler.CompilationHelper;
import org.eclipse.jet.internal.editor.configuration.JETDocumentProvider;
import org.eclipse.jet.internal.editor.configuration.JETEditorPreferenceConstants;
import org.eclipse.jet.internal.editor.configuration.JETSourceViewerConfiguration;
import org.eclipse.jet.internal.editor.configuration.JETTokenStyleManager;
import org.eclipse.jet.internal.editor.configuration.delegates.IJETDefaultTextColorerDelegate;
import org.eclipse.jet.internal.editor.outline.JETOutlinePage;
import org.eclipse.jet.internal.editor.partition.JETDocumentPartitionScanner;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.IEncodingSupport;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osgi.framework.Bundle;

/**
 * The editor for JET templates files
 * 
 * @author Joel
 */
public class JETTextEditor extends TextEditor {

	private JETTokenStyleManager tokenStyleManager;

	private JETSourceViewer sourceViewer;

	private JETDocumentPartitionScanner partitionScanner;

	private ProjectionSupport projectionSupport;

	private IContentOutlinePage outlinePage;

	private JETCompilationUnit cUnit;

	private IProject project;

	private Map positions;

	private boolean cUnitInvalidated;

	private ArrayList defaultContentColorerDelegates;

	private IJETDefaultTextColorerDelegate currentDelegate;

	/**
	 * Creates a new JET editor
	 */
	public JETTextEditor() {
		positions = Collections.EMPTY_MAP;
		IPreferenceStore preferenceStore = Activator.getDefault()
				.getPreferenceStore();
		JETEditorPreferenceConstants.initializeDefaultValues(preferenceStore);
		setPreferenceStore(preferenceStore);
		tokenStyleManager = new JETTokenStyleManager(preferenceStore);
		partitionScanner = new JETDocumentPartitionScanner(this);
		setSourceViewerConfiguration(new JETSourceViewerConfiguration(this));
		setDocumentProvider(new JETDocumentProvider(this));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.editors.text.TextEditor#dispose()
	 */
	public void dispose() {
		tokenStyleManager.dispose();
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.texteditor.AbstractTextEditor#init(org.eclipse.ui.IEditorSite
	 * , org.eclipse.ui.IEditorInput)
	 */
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		if (input instanceof IFileEditorInput)
			project = ((IFileEditorInput) input).getFile().getProject();
		super.init(site, input);
		initDefaultContentColorerDelegetes();
		if (!defaultContentColorerDelegates.isEmpty())
			currentDelegate = (IJETDefaultTextColorerDelegate) defaultContentColorerDelegates
					.get(0);
	}

	/**
	 * Set the content colorer delegate (used for syntax coloring of non JET
	 * text) to use.
	 * 
	 * @param delegate
	 */
	public void setCurrentColorerDelegate(
			IJETDefaultTextColorerDelegate delegate) {
		currentDelegate = delegate;
		// notify the damager repairers so that they recompute the partitions
		// and the tokens to colorize
		partitionScanner.updateJETTextContentDamagerRepairer();
		// reset the text display
		if (isDirty())
			getSourceViewer().getDocument().set(
					getSourceViewer().getDocument().get());
		else
			setInput(getEditorInput());
	}

	/**
	 * Returns the content colorer delegate (used for syntax coloring of non JET
	 * text) in use.
	 * 
	 * @return the content colorer delegate
	 */
	public IJETDefaultTextColorerDelegate getCurrentColorerDelegate() {
		return currentDelegate;
	}

	/**
	 * Returns the list of all the available (registered) content colorer
	 * delegates.
	 * 
	 * @return
	 */
	public IJETDefaultTextColorerDelegate[] getColorerDelegates() {
		IJETDefaultTextColorerDelegate results[] = new IJETDefaultTextColorerDelegate[defaultContentColorerDelegates
				.size()];
		defaultContentColorerDelegates.toArray(results);
		return results;
	}

	/**
	 * Compute the list of the registered content colorer delegates.
	 */
	private void initDefaultContentColorerDelegetes() {
		defaultContentColorerDelegates = new ArrayList();
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement elements[] = registry
				.getConfigurationElementsFor("org.eclipse.jet.internal.editor",
						"defaultContentColorerDelegates");
		for (int i = 0; i < elements.length; i++) {
			IConfigurationElement element = elements[i];
			Bundle bundle = Platform
					.getBundle(element.getNamespaceIdentifier());
			String delegateClass = element.getAttribute("delegateClass");
			IJETDefaultTextColorerDelegate delegate = null;
			try {
				Class clazz = bundle.loadClass(delegateClass);
				Class argTypes[] = { JETTextEditor.class };
				Constructor ctorWithTextEditor = null;
				try {
					ctorWithTextEditor = clazz.getConstructor(argTypes);
				} catch (SecurityException e) {
					Activator.log(e);
				} catch (NoSuchMethodException e) {
					Activator.log(e);
				}
				if (ctorWithTextEditor != null)
					delegate = (IJETDefaultTextColorerDelegate) ctorWithTextEditor
							.newInstance(new Object[] { this });
				else
					delegate = (IJETDefaultTextColorerDelegate) clazz
							.newInstance();
				defaultContentColorerDelegates.add(delegate);
			} catch (ClassNotFoundException e) {
				Activator.log(e);
			} catch (InstantiationException e) {
				Activator.log(e);
			} catch (IllegalAccessException e) {
				Activator.log(e);
			} catch (IllegalArgumentException e) {
				Activator.log(e);
			} catch (InvocationTargetException e) {
				Activator.log(e);
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#createSourceViewer
	 * (org.eclipse.swt.widgets.Composite,
	 * org.eclipse.jface.text.source.IVerticalRuler, int)
	 */
	protected ISourceViewer createSourceViewer(Composite parent,
			IVerticalRuler ruler, int styles) {
		fAnnotationAccess = getAnnotationAccess();
		fOverviewRuler = createOverviewRuler(getSharedColors());
		sourceViewer = new JETSourceViewer(parent, ruler, getOverviewRuler(),
				isOverviewRulerVisible(), styles, getPreferenceStore());
		getSourceViewerDecorationSupport(sourceViewer);
		projectionSupport = new ProjectionSupport(sourceViewer,
				getAnnotationAccess(), getSharedColors());
		projectionSupport
				.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.error");
		projectionSupport
				.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.warning");
		projectionSupport
				.setHoverControlCreator(new IInformationControlCreator() {
					public IInformationControl createInformationControl(
							Shell shell) {
						return new DefaultInformationControl(shell, true);
						// return new DefaultInformationControl(shell,
						// getOrientation(), 0, new HTMLTextPresenter());
					}
				});
		projectionSupport.install();
		return sourceViewer;
	}

	/**
	 * Return the editor's source viewer. This method exist to make this viewer
	 * accessible to other classes.
	 * 
	 * @return the editor's source viewer
	 */
	public ISourceViewer getEditorSourceViewer() {
		return sourceViewer;
	}

	/**
	 * Returns the editor's preference store. This method exist to make the
	 * preference store accessible to other classes.
	 * 
	 * @return the editor's preference store
	 */
	public IPreferenceStore getEditorPreferenceStore() {
		return super.getPreferenceStore();
	}

	public JETDocumentPartitionScanner getPartitionScanner() {
		return partitionScanner;
	}

	public JETTokenStyleManager getTokenStyleManager() {
		return tokenStyleManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.texteditor.StatusTextEditor#handleEditorInputChanged()
	 */
	protected void handleEditorInputChanged() {
		super.handleEditorInputChanged();
		handleDocumentChange(null);
	}

	public void handleDocumentChange(DocumentEvent e) {
		cUnitInvalidated = true;
		if (outlinePage != null && outlinePage.getControl().isVisible())
			((JETOutlinePage) outlinePage).setInput();
	}

	public boolean isCUnitInvalidated() {
		return cUnitInvalidated;
	}

	public CompilationHelper compilationHelper() {
		CompilationHelper jetCompilationHelper = new CompilationHelper(project);
		return jetCompilationHelper;
	}

	/**
	 * Compute and retrun the compilation unit of this document
	 * 
	 * @return the computed (or recomputed) compilation unit for this template
	 */
	public JETCompilationUnit requestCompilationUnit() {
		if (cUnit == null || cUnitInvalidated) {
			IEditorInput editorInput = getEditorInput();
			String templatePath = editorInput.getName();
			if (editorInput instanceof IFileEditorInput)
				templatePath = ((IFileEditorInput) editorInput).getFile()
						.getProjectRelativePath().toString();
			if (sourceViewer == null) { // sourceViewer is null ... we can parse
				// from the file directly
				cUnit = compilationHelper().getAST(templatePath);
			} else {
				cUnit = compilationHelper().getASTFromSource(
						sourceViewer.getDocument().get(), templatePath);
			}
			PositionsCollector collector = new PositionsCollector();
			cUnit.accept(collector);
			positions = collector.getPositions();
			cUnitInvalidated = false;
		}
		return cUnit;
	}

	public JETASTElement getASTElement(int offset) {
		requestCompilationUnit();
		return getCachedASTElement(offset);
	}

	public JETASTElement getCachedASTElement(int offset) {
		for (Iterator iterator = positions.keySet().iterator(); iterator
				.hasNext();) {
			Position pos = (Position) iterator.next();
			if (pos.offset <= offset && pos.length + pos.offset > offset)
				return (JETASTElement) positions.get(pos);
		}
		return null;
	}

	public IJavaProject getJavaProject() {
		return JavaCore.create(project);
	}

	protected void createActions() {
		super.createActions();
		ResourceBundle resourceBundle = ResourceBundle
				.getBundle("org.eclipse.jet.internal.editor.i18n.TextEditorMessages");
		Action action = new ContentAssistAction(resourceBundle,
				"ContentAssistProposal.", this);
		action
				.setActionDefinitionId("org.eclipse.ui.edit.text.contentAssist.proposals");
		setAction("ContentAssistProposal", action);
		markAsStateDependentAction("ContentAssistProposal", true);
	}

	protected void handlePreferenceStoreChanged(PropertyChangeEvent event) {
		super.handlePreferenceStoreChanged(event);
		if (event.getNewValue() instanceof RGB)
			getTokenStyleManager().bindColor(event.getProperty(),
					(RGB) event.getNewValue());
	}

	public Object getAdapter(Class required) {
		if (IContentOutlinePage.class.equals(required)) {
			if (outlinePage == null)
				outlinePage = createOutlinePage();
			return outlinePage;
		}
		if (IEncodingSupport.class.equals(required))
			return fEncodingSupport;
		if (projectionSupport != null) {
			Object adapter = projectionSupport.getAdapter(getSourceViewer(),
					required);
			if (adapter != null)
				return adapter;
		}
		return super.getAdapter(required);
	}

	public void editorContextMenuAboutToShow(IMenuManager menu) {
		super.editorContextMenuAboutToShow(menu);
		addAction(menu, "settings", "setDelegateColorerActionID");
	}

	protected IContentOutlinePage createOutlinePage() {
		JETOutlinePage page = new JETOutlinePage(this);
		page.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				handleContentOutlineSelection(event.getSelection());
			}
		});
		return page;
	}

	protected void handleContentOutlineSelection(ISelection selection) {
		IStructuredSelection ssel = (IStructuredSelection) selection;
		Object firstElement = ssel.getFirstElement();
		if (firstElement instanceof JETASTElement) {
			JETASTElement astElement = (JETASTElement) firstElement;
			int start = astElement.getStart();
			int end = astElement.getEnd();
			int length = end - start;
			if (astElement instanceof TextElement) {
				if (astElement.getPrevElement() != null)
					start = astElement.getPrevElement().getEnd();
				else
					start = 0;
				length = ((TextElement) astElement).getText().length;
			}
			sourceViewer.setSelectedRange(start, length);
			sourceViewer.revealRange(start, length);
		}
	}

	private static class PositionsCollector extends JETASTVisitor {
		private Map positions;

		private PositionsCollector() {
			positions = new HashMap();
		}

		public Map getPositions() {
			return positions;
		}

		public boolean visit(JavaDeclaration declaration) {
			return matchOffset(declaration);
		}

		public boolean visit(JETDirective directive) {
			return matchOffset(directive);
		}

		public boolean visit(JavaExpression expression) {
			return matchOffset(expression);
		}

		public boolean visit(IncludedContent content) {
			// don't process include content
			return false;
		}

		public boolean visit(JavaScriptlet scriptlet) {
			return matchOffset(scriptlet);
		}

		public boolean visit(XMLEmptyElement xmlEmptyElement) {
			return matchOffset(xmlEmptyElement);
		}

		public boolean visit(XMLBodyElement xmlBodyElement) {
			return matchOffset(xmlBodyElement);
		}

		public boolean visit(XMLBodyElementEnd xmlBodyElementEnd) {
			return matchOffset(xmlBodyElementEnd);
		}

		public boolean visit(Comment comment) {
			return matchOffset(comment);
		}

		public boolean matchOffset(JETASTElement astElement) {
			int start = astElement.getStart();
			if (start < 0) {
				return false;
			}
			int end = astElement.getEnd();
			int length = end - Math.abs(start);
			positions.put(new Position(start, length), astElement);
			return true;
		}
	}
}
