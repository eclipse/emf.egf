/**
 * <copyright>
 * 
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * XiaoRu Chen, Soyatec
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.wizards.pages;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.IEGFCoreUIImages;
import org.eclipse.egf.core.ui.dialogs.EcoreSelectionDialog;
import org.eclipse.egf.core.ui.dialogs.ISelectionDialogListener;
import org.eclipse.egf.core.ui.dialogs.TypeSelectionDialog;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.Messages;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
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

    private Object[] _selectedJavaType;

    private Object[] _selectedEcoreType;

    private EcoreSelectionDialog _ecoreDialog;

    private TypeSelectionDialog _typeDialog;

    private TabFolder _tabFolder;

    private EditingDomain _editingDomain;

    private String _currentType;

    private IJavaProject _javaProject;

    public ChooseTypePage(EditingDomain editingDomain, String currentType) {
        super(Messages.ChooseTypePage_title);
        setTitle(Messages.ChooseTypePage_title);
        setDescription(Messages.ChooseTypePage_description);
        _editingDomain = editingDomain;
        _currentType = currentType;
    }

    public ChooseTypePage(EditingDomain editingDomain, String currentType, EObject current) {
        this(editingDomain, currentType);
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
                    ThrowableHandler.handleThrowable(Activator.getDefault().getPluginID(), jme);
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
        _ecoreDialog = new EcoreSelectionDialog(container.getShell(), _editingDomain) {

            /*
             * (non-Javadoc)
             * 
             * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
             */
            @Override
            protected Control createDialogArea(Composite parent) {
                Control content = super.createDialogArea(parent);
                URI nsURI;
                if (!"".equals(_currentType) && _currentType != null) { //$NON-NLS-1$
                    int index = _currentType.indexOf("#//"); //$NON-NLS-1$
                    if (index != -1) {
                        nsURI = URI.createURI(_currentType.substring(0, index));
                    } else {
                        nsURI = NSURI_GENMODEL;
                    }
                } else {
                    nsURI = NSURI_GENMODEL;
                }
                Resource resource = _editingDomain.getResourceSet().getResource(nsURI, true);
                _ecoreTypeTreeViewer.setInput(resource.getContents());
                _ecoreTypeTreeViewer.expandToLevel(2);
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
        return isPageComplete() ? _selectedEcoreType[0] : null;
    }

    @Override
    public boolean isPageComplete() {
        return (_selectedEcoreType != null && _selectedEcoreType.length > 0) || (_selectedJavaType != null && _selectedJavaType.length > 0);
    }

    public Object getSelectedJavaType() {
        return isPageComplete() ? _selectedJavaType[0] : null;
    }

    public boolean isInCoreTab() {
        return _tabFolder.getSelectionIndex() == 0;
    }

}
