/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.pattern.ui.internal.editor.page.specification.wizard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.EcoreHelper;
import org.eclipse.egf.common.ui.helper.FormHelper;
import org.eclipse.egf.common.ui.helper.FormHelper.LayoutType;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.egf.pattern.ui.editor.page.PatternSpecificationPage;
import org.eclipse.egf.pattern.ui.editor.page.util.DisplayHelper;
import org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider;
import org.eclipse.egf.pattern.ui.internal.editor.page.wizard.AbstractPatternWizardPage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.ExtendedLoadResourceDialog;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


/**
 * @author Guillaume Brocard
 */
public class ParameterTypeSelectionPage extends AbstractPatternWizardPage {
  /**
   * Page unique id.
   */
  protected static final String PAGE_ID = "parameterType"; //$NON-NLS-1$

  /**
   * Constructor.
   */
  public ParameterTypeSelectionPage() {
    super(PAGE_ID);
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getHelpContextId()
   */
  @Override
  protected String getHelpContextId() {
    return PatternUiActivator.getDefault().getPluginID() + ICommonConstants.DOT_CHARACTER + PatternSpecificationPage.ID;
  }

  /**
   * @see org.eclipse.jface.wizard.WizardPage#getWizard()
   */
  @Override
  public ParameterWizard getWizard() {
    return (ParameterWizard) super.getWizard();
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.wizard.AbstractPatternWizardPage#createViewer(org.eclipse.swt.widgets.Composite)
   */
  @Override
  protected StructuredViewer createViewer(Composite parent_p) {
    // Create containing composite.
    Composite viewerAndButtonComposite = FormHelper.createCompositeWithLayoutType(getToolkit(), parent_p, LayoutType.GRID_LAYOUT, 1, false);
    // Create the viewer part.
    final TreeViewer viewer = new TreeViewer(viewerAndButtonComposite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
    // Create the button one.
    // Create button.
    Button button = getToolkit().createButton(parent_p, Messages.ParameterTypeSelectionPage_ChooseModelButtonLabel, SWT.PUSH);
    button.addSelectionListener(new SelectionAdapter() {
      /**
       * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
       */
      @Override
      public void widgetSelected(SelectionEvent e_p) {
        ExtendedLoadResourceDialog dialog = new ExtendedLoadResourceDialog(getShell(), null);
        int returnCode = dialog.open();
        if (Window.OK != returnCode) {
          return;
        }
        List<URI> uris = dialog.getURIs();
        if (!uris.isEmpty()) {
          URI resourceUri = uris.get(0);
          viewer.setInput(getRootPackage(resourceUri));
        }
      }
    });
    // Set content provider.
    viewer.setContentProvider(new ParameterTypeContentProvider());
    // Set label provider.
    viewer.setLabelProvider(new LabelProvider() {
      /**
       * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
       */
      @Override
      public String getText(Object element_p) {
        return ((ENamedElement) element_p).getName();
      }
    });
    EClass eClass = getWizard().getParameter().getType();
    // Set initial input.
    viewer.setInput(initializeContent(eClass));
    // Set initial selection.
    if (null != eClass) {
      viewer.expandAll();
      viewer.setSelection(new StructuredSelection(eClass));
    }
    return viewer;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.wizard.AbstractPatternWizardPage#endPageAreaCreation(org.eclipse.jface.viewers.StructuredViewer)
   */
  @Override
  protected void endPageAreaCreation(StructuredViewer viewer_p) {
    // Force UI to get a bounded representation.
    FormHelper.forceControlSize(viewer_p.getControl(), DisplayHelper.DEFAULT_TEXT_WIDTH_IN_CHARS, DisplayHelper.DEFAULT_TEXT_HEIGHT_IN_CHARS);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.internal.editor.page.wizard.AbstractPatternWizardPage#delegateSelectionChanged(java.lang.Object)
   */
  @Override
  protected boolean delegateSelectionChanged(Object selectedElement_p) {
    boolean result = (selectedElement_p instanceof EClass);
    if (result) {
      getWizard().getParameter().setType((EClass) selectedElement_p);
    }
    return result;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getPageDescription()
   */
  @Override
  protected String getPageDescription() {
    return Messages.ParameterTypeSelectionPage_Description;
  }

  /**
   * @see org.eclipse.egf.common.ui.wizard.page.AbstractWizardPage#getPageTitle()
   */
  @Override
  protected String getPageTitle() {
    return Messages.ParameterTypeSelectionPage_Title;
  }

  /**
   * Initialize view content.
   * @param initialClass_p
   * @return
   */
  protected InitialInput initializeContent(EClass initialClass_p) {
    EPackage result = null;
    // Get root package from given existing type.
    if (null != initialClass_p) {
      EPackage rootPackage = EcoreHelper.getRootPackage(initialClass_p.getEPackage());
      result = rootPackage;
//      result = EcoreHelper.getStaticPackage(rootPackage);
    }
    // If not found, always fall back to Ecore root package.
    if (null == result) {
      result = EcorePackage.eINSTANCE;
    }
    return createContainer(result);
  }

  /**
   * Get static root package initial input for identified model.
   * @param resourceUri_p
   * @return
   */
  protected InitialInput getRootPackage(URI resourceUri_p) {
    ResourceSet resourceSet = new ResourceSetImpl();
    Resource resource = resourceSet.getResource(resourceUri_p, true);
    EPackage result = null;
    for (Iterator<EObject> eObjects = resource.getAllContents(); eObjects.hasNext();) {
      EObject eObject = eObjects.next();
      if (eObject instanceof EPackage) {
        EPackage serializedPackage = (EPackage) eObject;
//        EPackage staticPackage = EcoreHelper.getStaticPackage(EcoreHelper.getRootPackage(serializedPackage));
        EPackage staticPackage = EcoreHelper.getRootPackage(serializedPackage);
        result = staticPackage;
        break;
      }
    }
    return createContainer(result);
  }

  /**
   * Create initial input for given input package.
   * @param inputPackage_p
   * @return
   */
  protected InitialInput createContainer(EPackage inputPackage_p) {
    InitialInput result = new InitialInput();
    if (null != inputPackage_p) {
      result._rootPackage = inputPackage_p;
    }
    return result;
  }

  /**
   * Initial input element.
   * @author Guillaume Brocard
   */
  protected class InitialInput {
    // Root package.
    protected EPackage _rootPackage;

    /**
     * Get root package.
     * @return
     */
    protected EPackage getRootPackage() {
      return _rootPackage;
    }
  }

  /**
   * Parameter type content provider.
   * @author Guillaume Brocard
   */
  protected class ParameterTypeContentProvider extends AbstractPatternPageContentProvider implements ITreeContentProvider {
    /**
     * {@link ENamedElement} comparator.
     */
    private Comparator<ENamedElement> _comparator;

    /**
     * Constructor.
     */
    protected ParameterTypeContentProvider() {
      // Create comparator.
      _comparator = new Comparator<ENamedElement>() {
        public int compare(ENamedElement o1_p, ENamedElement o2_p) {
          try {
            return o1_p.getName().compareTo(o2_p.getName());
          } catch (Exception e_p) {
            return 0;
          }
        }
      };
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doDispose()
     */
    @Override
    protected void doDispose() {
      // Nothing to do.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementUpdated(java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    protected void doHandleElementUpdated(Object oldInput_p, Object newInput_p) {
      // Nothing to do.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementsAdded(java.lang.Object)
     */
    @Override
    protected void doHandleElementsAdded(Object addedElements_p) {
      // Nothing to do.
    }

    /**
     * @see org.eclipse.egf.pattern.ui.internal.editor.page.AbstractPatternPageContentProvider#doHandleElementsRemoved(java.lang.Object)
     */
    @Override
    protected void doHandleElementsRemoved(Object removedElements_p) {
      // Nothing to do.
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
     */
    public Object[] getChildren(Object parentElement_p) {
      Object[] result = null;
      if (parentElement_p instanceof EPackage) {
        EPackage ePackage = ((EPackage) parentElement_p);
        // Sort all classifiers.
        List<EClassifier> classifiers = new ArrayList<EClassifier>(0);
        classifiers.addAll(ePackage.getEClassifiers());
        Collections.sort(classifiers, _comparator);
        // Sort all sub-packages.
        List<EPackage> subpackages = new ArrayList<EPackage>(0);
        subpackages.addAll(ePackage.getESubpackages());
        Collections.sort(subpackages, _comparator);
        // Create resulting list.
        List<Object> children = new ArrayList<Object>(0);
        children.addAll(EcoreUtil.getObjectsByType(classifiers, EcorePackage.Literals.ECLASS));
        children.addAll(subpackages);
        result = children.toArray();
      } else if (parentElement_p instanceof InitialInput) {
        result = new Object[] { ((InitialInput) parentElement_p).getRootPackage() };
      }
      return result;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
     */
    public Object getParent(Object element_p) {
      Object parent = null;
      if (element_p instanceof EClassifier) {
        parent = ((EClassifier) element_p).getEPackage();
      }
      return parent;
    }

    /**
     * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
     */
    public boolean hasChildren(Object element_p) {
      return !(element_p instanceof EClassifier);
    }

    /**
     * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
     */
    public Object[] getElements(Object inputElement_p) {
      return getChildren(inputElement_p);
    }
  }
}
