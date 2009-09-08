/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.ui.editor.page;

import org.apache.log4j.Logger;

import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.helper.PatternHelper;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.ui.helper.DataBindingHelper;
import org.eclipse.egf.common.ui.helper.FormHelper;
import org.eclipse.egf.common.ui.helper.FormHelper.LayoutType;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.ui.PatternUiActivator;
import org.eclipse.egf.pattern.ui.editor.PatternEditorInput;
import org.eclipse.egf.pattern.ui.editor.page.util.DisplayHelper;
import org.eclipse.egf.pattern.ui.editor.util.PatternEditorPageLinkListener;
import org.eclipse.egf.pattern.ui.internal.editor.PatternEditorContentOutlinePage.PatternDataNode;
import org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler;


/**
 * Pattern overview page.
 * @author Guillaume Brocard
 */
public class PatternOverviewPage extends AbstractPatternPage {
  
  /**
   * Log4j reference logger.
   */
  static final Logger __logger = Logger.getLogger(PatternOverviewPage.class.getPackage().getName());
  
  /**
   * Inheritance page image key.
   */
  private static final String INHERITANCE_IMAGE_KEY = "full/obj16/EGenericSuperType"; //$NON-NLS-1$
  
  /**
   * Page id.
   */
  protected static final String ID = "egf_pattern_overview_page"; //$NON-NLS-1$
  
  /**
   * Help context id.
   */
  protected static final String HELP_CONTEXT_ID = PatternUiActivator.getDefault().getPluginID() + ICommonConstants.DOT_CHARACTER + ID;
  
  /**
   * Constructor.
   * @param editor_p
   */
  public PatternOverviewPage(FormEditor editor_p) {
    super(editor_p, ID, Messages.PatternOverviewPage_Title);
    // Initialize external selection triggers.
    getExternalSelectionManager().addExternalHandlerFor(PatternDataNode.class, this);
  }

  /**
   * @see org.eclipse.ui.forms.editor.FormPage#dispose()
   */
  @Override
  public void dispose() {
    super.dispose();
    // Remove external selection triggers.
    getExternalSelectionManager().removeExternalHandler(this, PatternDataNode.class);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#handleSelection(java.lang.Object, org.eclipse.jface.viewers.IStructuredSelection)
   */
  @Override
  public void handleSelection(Object firstSelectedObject_p, IStructuredSelection selection_p) {
    // Set active page to current one.
    getEditor().setActivePage(ID);
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#createPatternBlock()
   */
  @Override
  protected AbstractPatternBlock createPatternBlock() {
    return null;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#doCreateFormContent(org.eclipse.ui.forms.widgets.FormToolkit,
   *      org.eclipse.swt.widgets.Composite, org.eclipse.egf.pattern.ecore.PatternHandler.PatternData, org.eclipse.ui.forms.IManagedForm)
   */
  @Override
  protected void doCreateFormContent(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p, IManagedForm managedForm_p) {
    // Main composite is made of 2 columns of the same size.
    FormHelper.updateCompositeLayoutWithLayoutType(parent_p, LayoutType.GRID_LAYOUT, 2, false);
    // Create general section.
    createGeneralSection(toolkit_p, parent_p, patternData_p);
    // Create content section.
    createContentSection(toolkit_p, parent_p);
    // Mark as dirty
    // See PatternEditorInput.initialize
    // This works as long as this EditorPart is the first activated one
    // See PatternEditor.addPages
    if (isEditable()) {
      if (getEditorInput() instanceof PatternEditorInput && ((PatternEditorInput) getEditorInput()).isDirty()) {
        setDirty(true);
      }
    }
  }

  /**
   * Create general section.
   * @param toolkit_p
   * @param parent_p
   * @param patternData_p
   */
  private void createGeneralSection(FormToolkit toolkit_p, Composite parent_p, PatternData patternData_p) {
    // Handle general information.
    GeneralInformationHandler handler = new GeneralInformationHandler(patternData_p);
    // Create general section.
    Couple<Section, Composite> generalCouple = FormHelper.createSectionWithChildComposite(
      toolkit_p, parent_p, 
      ExpandableComposite.TITLE_BAR + ExpandableComposite.EXPANDED,
      LayoutType.GRID_LAYOUT, 
      2, 
      false
    );
    Section generalSection = generalCouple.getKey();
    generalSection.setText(Messages.PatternOverviewPage_Section_GeneralInformation_Text);
    // Create general section sub-composite.
    Composite generalComposite = generalCouple.getValue();
    {
      // Create description label.
      Label generalInformationLabel = toolkit_p.createLabel(
        generalComposite, 
        Messages.PatternOverviewPage_Section_GeneralInformation_Description, 
        SWT.WRAP
      );
      GridData gilData = new GridData(GridData.FILL_HORIZONTAL);
      gilData.horizontalSpan = 2;
      generalInformationLabel.setLayoutData(gilData);
      // Create name content.
      Text nameText = FormHelper.createLabelAndText(
        toolkit_p, 
        generalComposite, 
        Messages.PatternOverviewPage_Pattern_LogicalName_Label, 
        null, 
        isEditable()
      ).getValue();
      TextValidator textValidator = new TextValidator(nameText) {
        @Override
        protected String getErrorMessageFor(String errorKey_p, String value_p) {
          if (ERROR_KEY_REG_EXP == errorKey_p) {
            return Messages.PatternOverviewPage_PatternNameErrorMessage;
          }
          return null;
        }
      };
      textValidator.setRegularExpression(org.eclipse.egf.core.ui.Messages.PatternOverviewPage_PatternNameRegularExpression);
      DataBindingHelper.bindTextToProperty(
        nameText, 
        GeneralInformationHandler.DATA_BINDING_PATTERN_LOGICAL_NAME, 
        handler, 
        textValidator
      );
      // Create parent library content.
      FormHelper.createLabelAndText(
        toolkit_p, 
        generalComposite, 
        Messages.PatternOverviewPage_Pattern_ParentLibrary_Id_Name_Label, 
        handler.getParentLibraryFullId(), 
        false
      );
      // Create pattern local id content.
      FormHelper.createLabelAndText(
        toolkit_p, 
        generalComposite, 
        Messages.PatternOverviewPage_Pattern_Local_Id_Name_Label, 
        handler.getPatternLocalId(), 
        false
      );
      // Create description section.
      Couple<Section, Composite> descriptionCouple = FormHelper.createSectionWithChildComposite(
        toolkit_p, 
        generalComposite, 
        ExpandableComposite.EXPANDED,
        LayoutType.GRID_LAYOUT, 
        1, 
        true
      );
      Section descriptionSection = descriptionCouple.getKey();
      GridData dsData = (GridData) descriptionSection.getLayoutData();
      dsData.horizontalSpan = 2;
      descriptionSection.setText(Messages.PatternOverviewPage_Pattern_Description_Label);
      descriptionSection.setFont(nameText.getFont());
      descriptionSection.setForeground(toolkit_p.getColors().getColor(IFormColors.TITLE));
      Composite descriptionComposite = descriptionCouple.getValue();
      {
        // Create description label.
        toolkit_p.createLabel(
          descriptionComposite, 
          Messages.PatternOverviewPage_Pattern_Description_Description, 
          SWT.WRAP
        );
        // Create description text.
        Composite textComposite = FormHelper.createCompositeWithLayoutType(
          toolkit_p, 
          descriptionComposite, 
          LayoutType.GRID_LAYOUT, 
          1, 
          true
        );
        int styles = SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER;
        IDocument document = new Document();
        // Set existing value.
        document.set(handler.getPatternDescription());
        // Register listener.
        document.addDocumentListener(handler);
        // Back to ui stuff.
        SourceViewer textViewer = new SourceViewer(
          textComposite, 
          null, 
          isEditable() ? styles : styles | SWT.READ_ONLY
        );
        textViewer.setDocument(document);
        StyledText styledText = textViewer.getTextWidget();
        styledText.setFont(JFaceResources.getTextFont());
        FormHelper.updateControlLayoutDataWithLayoutTypeData(styledText, LayoutType.GRID_LAYOUT);
        FormHelper.forceControlSize(
          textViewer.getControl(), 
          DisplayHelper.DEFAULT_TEXT_WIDTH_IN_CHARS, 
          DisplayHelper.DEFAULT_TEXT_HEIGHT_IN_CHARS
        );
      }
    }
  }

  /**
   * Create content section.
   * @param toolkit_p
   * @param parent_p
   */
  private void createContentSection(FormToolkit toolkit_p, Composite parent_p) {
    // Create content section.
    int patternContentNumColumns = 2;
    Couple<Section, Composite> patternContentCouple = FormHelper.createSectionWithChildComposite(
      toolkit_p, 
      parent_p, 
      ExpandableComposite.TITLE_BAR + ExpandableComposite.EXPANDED,
      LayoutType.GRID_LAYOUT, 
      patternContentNumColumns, 
      false
    );
    Section patternContentSection = patternContentCouple.getKey();
    patternContentSection.setText(Messages.PatternOverviewPage_Section_PatternContent_Text);
    Composite patternContentComposite = patternContentCouple.getValue();
    {
      Label contentDescriptionLabel = toolkit_p.createLabel(
        patternContentComposite, 
        Messages.PatternOverviewPage_Section_PatternContent_Description, 
        SWT.WRAP
      );
      GridData cdlData = new GridData(GridData.FILL_HORIZONTAL);
      cdlData.horizontalSpan = patternContentNumColumns;
      contentDescriptionLabel.setLayoutData(cdlData);
      PatternEditorPageLinkListener listener = (PatternEditorPageLinkListener) getEditor().getAdapter(PatternEditorPageLinkListener.class);
      // JDT image registry.
      ImageRegistry jdtImageRegistry = JavaPlugin.getDefault().getImageRegistry();
      // Link to production.
      Image productionImage = jdtImageRegistry.get(JavaPluginImages.IMG_OBJS_JSEARCH);
      FormHelper.createLinkWithDescription(
        toolkit_p, 
        patternContentComposite, 
        productionImage, 
        Messages.PatternOverviewPage_Link_Production_Text,
        PatternProductionPage.ID, 
        Messages.PatternOverviewPage_Link_Production_Description, 
        listener
      );      
      // Link to specification.
      Image specificationImage = jdtImageRegistry.get(JavaPluginImages.IMG_OBJS_LOCAL_VARIABLE);
      FormHelper.createLinkWithDescription(
        toolkit_p, 
        patternContentComposite, 
        specificationImage, 
        Messages.PatternOverviewPage_Link_Specification_Text,
        PatternSpecificationPage.ID, 
        Messages.PatternOverviewPage_Link_Specification_Description, 
        listener
      );
      // Link to inheritance.
      Image inheritanceImage = ExtendedImageRegistry.INSTANCE.getImage(EcoreEditPlugin.INSTANCE.getImage(INHERITANCE_IMAGE_KEY));
      FormHelper.createLinkWithDescription(
        toolkit_p, 
        patternContentComposite, 
        inheritanceImage, 
        Messages.PatternOverviewPage_Link_Inheritance_Text,
        PatternInheritancePage.ID, 
        Messages.PatternOverviewPage_Link_Inheritance_Description, 
        listener
      );
      // Link to implementation.
      Image implementationImage = jdtImageRegistry.get(JavaPluginImages.IMG_MISC_PUBLIC);
      FormHelper.createLinkWithDescription(
        toolkit_p, 
        patternContentComposite, 
        implementationImage, 
        Messages.PatternOverviewPage_Link_Implementation_Text,
        PatternImplementationPage.ID, 
        Messages.PatternOverviewPage_Link_Implementation_Description, 
        listener
      );
    }
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage#getHelpContextId()
   */
  @Override
  public String getHelpContextId() {
    return HELP_CONTEXT_ID;
  }

  /**
   * General information handler.
   * @author Guillaume Brocard
   */
  private class GeneralInformationHandler extends DefaultContentHandler implements IDocumentListener {
    
    /**
     * Pattern name property binding.
     */
    protected static final String DATA_BINDING_PATTERN_LOGICAL_NAME = "patternLogicalName"; //$NON-NLS-1$
    
    /**
     * Pattern description property binding.
     */
    protected static final String DATA_BINDING_PATTERN_DESCRIPTION = "patternDescription"; //$NON-NLS-1$
    
    /**
     * Parent library full id.
     */
    private String _parentLibraryFullId;
    
    /**
     * Id local to parent library.
     */
    private String _patternLocalId;

    /**
     * Constructor.
     * @param pattern_p
     */
    protected GeneralInformationHandler(PatternData patternData_p) {
      super(patternData_p, PatternOverviewPage.this);
      unmakePatternFullId();
    }

    /**
     * Get pattern local id.
     * @return
     */
    public String getPatternLocalId() {
      return _patternLocalId;
    }

    /**
     * Set pattern description.
     * @param newDescription_p
     */
    public void setPatternDescription(String newDescription_p) {
      getPattern().setDescription(newDescription_p);
      notifyModification();
    }

    /**
     * Get pattern description.
     * @return
     */
    public String getPatternDescription() {
      return getPattern().getDescription();
    }

    /**
     * Set new pattern name.
     * @param newName_p
     */
    public void setPatternLogicalName(String newName_p) {
      if (newName_p != null && ICommonConstants.EMPTY_STRING.equals(newName_p.trim()) == false) {
        String oldName = getPattern().getLogicalName();
        if (newName_p.equals(oldName) == false) {
          getPattern().setLogicalName(newName_p);
          notifyModification();
        }
      }
    }

    /**
     * Get pattern name.
     * @return
     */
    public String getPatternLogicalName() {
      return getPattern().getLogicalName();
    }

    /**
     * Get parent library full id.
     * @return
     */
    public String getParentLibraryFullId() {
      return _parentLibraryFullId;
    }

    /**
     * Unmake pattern full id.
     */
    protected void unmakePatternFullId() {
      String patternFullId = getPattern().getId();
      Couple<String, String> deresolvedId = PatternHelper.deresolveId(patternFullId);
      _parentLibraryFullId = deresolvedId.getKey();
      _patternLocalId = deresolvedId.getValue();
    }

    /**
     * @see org.eclipse.jface.text.IDocumentListener#documentAboutToBeChanged(org.eclipse.jface.text.DocumentEvent)
     */
    public void documentAboutToBeChanged(DocumentEvent event_p) {
      // Nothing to do here.
    }

    /**
     * @see org.eclipse.jface.text.IDocumentListener#documentChanged(org.eclipse.jface.text.DocumentEvent)
     */
    public void documentChanged(DocumentEvent event_p) {
      IDocument document = event_p.getDocument();
      String newDescription = document.get();
      setPatternDescription(newDescription);
    }
  }
  
}
