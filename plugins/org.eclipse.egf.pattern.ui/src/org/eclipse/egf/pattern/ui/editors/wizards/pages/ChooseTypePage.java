/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.wizards.pages;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.epackage.IProxyEObject;
import org.eclipse.egf.core.epackage.IProxyERoot;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.IEGFCoreUIImages;
import org.eclipse.egf.core.ui.dialogs.ISelectionDialogListener;
import org.eclipse.egf.core.ui.dialogs.TargetPlatformEcoreSelectionDialog;
import org.eclipse.egf.core.ui.dialogs.TypeSelectionDialog;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.PlatformUI;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class ChooseTypePage extends WizardPage {

    private static final URI NSURI_GENMODEL = URI.createURI("http://www.eclipse.org/emf/2002/GenModel"); //$NON-NLS-1$      
    private static final URI NSURI_ECORE = URI.createURI("http://www.eclipse.org/emf/2002/Ecore"); //$NON-NLS-1$      

    private Object[] _selectedJavaType;

    private Object[] _selectedEcoreType;

    private TargetPlatformEcoreSelectionDialog _ecoreDialog;

    private TypeSelectionDialog _typeDialog;

    private TabFolder _tabFolder;

    private String _currentType;

    private IJavaProject _javaProject;

    public ChooseTypePage(String currentType) {
        super(Messages.ChooseTypePage_title);
        setTitle(Messages.ChooseTypePage_title);
        setDescription(Messages.ChooseTypePage_description);
        _currentType = currentType;
    }

    public ChooseTypePage(String currentType, EObject current) {
        this(currentType);
        if (current != null) {
            // IJavaProject lookup
            _javaProject = EMFHelper.getJavaProject(current.eResource());
        }
    }

    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        createTabFolder(container);
        setControl(container);
    }

    private void createTabFolder(Composite container) {

        _tabFolder = new TabFolder(container, SWT.NONE);
        _tabFolder.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                try {
                    if (_javaProject != null) {
                        _javaProject.close();
                    }
                } catch (JavaModelException jme) {
                    // Ignore
                }
            }

        });

        _tabFolder.setLayoutData(new GridData(GridData.FILL_BOTH));

        TabItem ecoreTabItem = new TabItem(_tabFolder, SWT.NONE);
        ecoreTabItem.setText(Messages.ChooseTypePage_coreTypeTabItem_title);
        ecoreTabItem.setImage(EGFCoreUIPlugin.getDefault().getImage(IEGFCoreUIImages.IMG_ECORE_MODEL));

        Composite compositeEcore = new Composite(_tabFolder, SWT.NONE);
        compositeEcore.setLayout(new GridLayout());
        compositeEcore.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                _ecoreDialog.close();
            }

        });

        _ecoreDialog = new TargetPlatformEcoreSelectionDialog(container.getShell()) {

            /*
             * (non-Javadoc)
             * 
             * @see
             * org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse
             * .swt.widgets.Composite)
             */
            @Override
            protected Control createDialogArea(Composite parent) {
                Control content = super.createDialogArea(parent);
                URI uri = null;
                if (_currentType != null && _currentType.trim().length() != 0 && _currentType.equals("#//") == false) { //$NON-NLS-1$
                    uri = URI.createURI(_currentType.trim());
                } else {
                    uri = NSURI_ECORE;
                }
                // Locate already loaded root
                IProxyERoot root = EGFCorePlugin.getTargetPlatformIProxyERoot(uri);
                // no model to load, so display the default one.
                if (root == null)
                    root = EGFCorePlugin.getTargetPlatformIProxyERoot(NSURI_ECORE);
                _ecoreTypeTreeViewer.setInput(root);
                _ecoreTypeTreeViewer.expandToLevel(2);
                if (root != null && uri != null) {
                    IProxyEObject proxy = root.getIProxyEObject(uri);
                    if (proxy != null) {
                        _ecoreTypeTreeViewer.setSelection(new StructuredSelection(proxy));
                    }
                }
                return content;
            }

            @Override
            protected void handleDoubleClick() {
                IWizard wizard = getWizard();
                wizard.performFinish();
                super.handleDoubleClick();
                IWizardContainer wizardContainer = wizard.getContainer();
                if (wizardContainer instanceof WizardDialog) {
                    ((WizardDialog) wizardContainer).close();
                }
            }

            @Override
            protected void searchTypeModel(String buffer) {
                if (buffer == null || buffer.trim().length() == 0) {
                    return;
                }
                String[] textUris = buffer.split("  "); //$NON-NLS-1$
                IProxyERoot root = null;
                for (String textUri : textUris) {
                    try {
                        if (textUri == null || textUri.trim().length() == 0) {
                            continue;
                        }
                        URI uri = URI.createURI(textUri.trim());
                        root = EGFCorePlugin.getTargetPlatformIProxyERoot(uri);
                        if (root != null) {
                            break;
                        }
                    } catch (Throwable t) {
                        EGFCoreUIPlugin.getDefault().logError(NLS.bind(CoreUIMessages.ModelSelection_errorMessage, textUri));
                    }
                }
                // no model to load, so display the default one.
                if (root == null)
                    root = EGFCorePlugin.getTargetPlatformIProxyERoot(NSURI_ECORE);

                _ecoreTypeTreeViewer.setInput(root);
                _ecoreTypeTreeViewer.expandToLevel(2);
            }

        };

        _ecoreDialog.createPage(compositeEcore);
        _ecoreDialog.addSelectionListeners(new ISelectionDialogListener() {

            public void handleSelected(Object[] selected) {
                _selectedEcoreType = selected;
                setPageComplete(isPageComplete());
            }

        });

        ecoreTabItem.setControl(compositeEcore);

        TabItem typeTabItem = new TabItem(_tabFolder, SWT.NONE);
        typeTabItem.setText(Messages.ChooseTypePage_javaTypeTabItem_title);
        typeTabItem.setImage(Activator.getDefault().getImage(ImageShop.IMG_CLASS_OBJ));

        Composite compositeType = new Composite(_tabFolder, SWT.NONE);
        compositeType.setLayout(new GridLayout());
        compositeType.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e) {
                _typeDialog.close();
            }

        });

        _typeDialog = new TypeSelectionDialog(container.getShell(), false, PlatformUI.getWorkbench().getProgressService(), _javaProject, IJavaSearchConstants.CLASS_AND_INTERFACE) {

            @Override
            protected void handleDoubleClick() {
                IWizard wizard = getWizard();
                wizard.performFinish();
                super.handleDoubleClick();
                IWizardContainer wizardContainer = wizard.getContainer();
                if (wizardContainer instanceof WizardDialog) {
                    ((WizardDialog) wizardContainer).close();
                }
            }

        };

        _typeDialog.createPage(compositeType);
        _typeDialog.addSelectionListeners(new ISelectionDialogListener() {

            public void handleSelected(Object[] selected) {
                _selectedJavaType = selected;
                setPageComplete(isPageComplete());
            }

        });

        typeTabItem.setControl(compositeType);

    }

    /**
     * Drop any package or uri information of the type.
     */
    public static String getType(String type) {
        if (type == null || type.length() == 0) {
            return ""; //$NON-NLS-1$
        }
        int index = type.lastIndexOf("."); //$NON-NLS-1$
        if (index != -1) {
            return type.substring(index + 1);
        }
        return type;
    }

    public Object getSelectedEcoreType() {
        return isPageComplete() ? _selectedEcoreType != null && _selectedEcoreType.length > 0 ? _selectedEcoreType[0] : null : null;
    }

    @Override
    public boolean isPageComplete() {
        return (_selectedEcoreType != null && _selectedEcoreType.length > 0) || (_selectedJavaType != null && _selectedJavaType.length > 0);
    }

    public Object getSelectedJavaType() {
        return isPageComplete() ? _selectedJavaType != null && _selectedJavaType.length > 0 ? _selectedJavaType[0] : null : null;
    }

    public boolean isInCoreTab() {
        return _tabFolder.getSelectionIndex() == 0;
    }

}
