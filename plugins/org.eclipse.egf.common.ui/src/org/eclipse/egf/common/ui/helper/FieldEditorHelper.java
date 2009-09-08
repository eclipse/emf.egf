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
package org.eclipse.egf.common.ui.helper;

import org.osgi.framework.Bundle;

import org.eclipse.core.resources.IContainer;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.ui.field.ContextElementFieldEditor;
import org.eclipse.egf.common.ui.field.DomainFieldEditor;
import org.eclipse.egf.common.ui.field.JavaClassFieldEditor;
import org.eclipse.egf.common.ui.field.JavaScopeClassFieldEditor;
import org.eclipse.egf.common.ui.field.WorkspaceFileFieldEditor;
import org.eclipse.egf.common.ui.internal.validators.JavaClassValidator;
import org.eclipse.egf.common.ui.toolkit.adapters.BooleanFieldEditorAdapter;
import org.eclipse.egf.common.ui.toolkit.fields.CRadioGroupFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.CStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.fields.ValidatingStringFieldEditor;
import org.eclipse.egf.common.ui.toolkit.validators.IValidator;


/**
 * Helper to deal with field editors used in UI.
 * @author fournier
 */
public class FieldEditorHelper {
  
  /**
   * Create the description field editor.
   * @param parent_p
   * @param label_p
   * @param tooltip_p t
   * @param initialText_p
   * @param numColumns_p
   * @param textModificationListener_p listener used to notify modification performed on description field content.
   */
  public static StyledText createDescriptionFieldEditor(
    Composite parent_p, 
    String label_p, 
    String tooltip_p, 
    String initialText_p, 
    int numColumns_p,
    IDocumentListener textModificationListener_p,
    boolean readOnly_p
  ) {
    // Create description widget.
    Composite textComposite = new Composite(parent_p, SWT.NONE);
    GridLayout gridLayout = new GridLayout();
    // The composite only have one column.
    gridLayout.numColumns = 1;
    // No margin.
    gridLayout.marginWidth = 0;
    gridLayout.marginHeight = 0;
    // Set the text composite layout.
    textComposite.setLayout(gridLayout);
    // Set the text composite grid data.
    GridData textCompositeLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
    textComposite.setLayoutData(textCompositeLayoutData);
    textCompositeLayoutData.horizontalSpan = numColumns_p;
    // Create the description label on left edge.
    Label descriptionLabel = new Label(textComposite, SWT.LEFT);
    descriptionLabel.setText(label_p);
    // Create the text field using jface.text framework.
    IDocument document = new Document();
    // Set initial value.
    if (null != initialText_p) {
      document.set(initialText_p);
    }
    // Register listener.
    document.addDocumentListener(textModificationListener_p);
    // Back to ui stuff.
    // Create a viewer to display the text.
    int textViewerStyle = SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER;
    SourceViewer textViewer = new SourceViewer(
      textComposite, 
      null, 
      readOnly_p ? textViewerStyle | SWT.READ_ONLY : textViewerStyle
    );
    textViewer.setDocument(document);
    // Get the created text.
    StyledText styledText = textViewer.getTextWidget();
    styledText.setFont(parent_p.getFont());
    // Set its layout data.
    GridData styledTextLayoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
    styledText.setLayoutData(styledTextLayoutData);
    // Force the composite to get an user-friendly size.
    FormHelper.forceControlSize(textComposite, 60, 8);
    return styledText;
  }

  /**
   * Create a check box field editor.
   * @param parent_p parent_p of the underlying widgets.
   * @param page_p the page where the created field editor is displayed.
   * @param label_p label of the field editor.
   * @param labelTooltip_p tooltip of the Label of the created field editor, provides information related to the field.
   * @param initialValue_p initial value of the check box.
   * @param horizintalIndent_p
   * @param verticalIndent_p
   * @return
   */
  public static BooleanFieldEditorAdapter createCheckBoxFieldEditor(
    Composite parent_p, 
    DialogPage page_p, 
    String label_p, 
    String labelTooltip_p,
    boolean initialValue_p, 
    final int horizintalIndent_p, 
    final int verticalIndent_p,
    final boolean readOnly_p
  ) {
    BooleanFieldEditorAdapter checkBoxFieldEditor = new BooleanFieldEditorAdapter(
      ICommonConstants.EMPTY_STRING, 
      label_p, 
      SWT.LEFT, 
      parent_p
    ) {
      /**
       * @see org.eclipse.jface.preference.BooleanFieldEditor#doFillIntoGrid(org.eclipse.swt.widgets.Composite, int)
       */
      @Override
      protected void doFillIntoGrid(Composite parent__p, int numColumns_p) {
        super.doFillIntoGrid(parent__p, numColumns_p);
        Button checkBox = getChangeControl(parent__p);
        // Read Only Mode
        checkBox.setEnabled(readOnly_p == false);        
        // Get the layout data.
        GridData gd = (GridData) checkBox.getLayoutData();
        // Insert horizontal and vertical values.
        gd.horizontalIndent = horizintalIndent_p;
        gd.verticalIndent = verticalIndent_p;
      }
    };    
    // Set the owner page.
    checkBoxFieldEditor.setPage(page_p);
    Button checkbox = (Button) checkBoxFieldEditor.getValueControl();
    // Set the tooltip
    checkbox.setToolTipText(labelTooltip_p);
    // Set the initial value.
    checkbox.setSelection(initialValue_p);
    return checkBoxFieldEditor;
  }

  /**
   * Create a group with given parameters.
   * @param parent_p
   * @param label_p label displayed by the widget (can be null).
   * @param style_p
   * @param numColumns_p value of the horizontal span
   * @return
   */
  public static Group createGroup(
    Composite parent_p, 
    String label_p, 
    int style_p, 
    int numColumns_p
  ) {
    Group group = new Group(parent_p, style_p);
    if (null != label_p) {
      group.setText(label_p);
    }
    group.setFont(parent_p.getFont());
    GridLayout layout = new GridLayout();
    layout.horizontalSpacing = 8;
    layout.numColumns = numColumns_p;
    // Set the layout.
    group.setLayout(layout);
    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    gd.horizontalSpan = numColumns_p;
    // Set the layout data.
    group.setLayoutData(gd);
    return group;
  }

  /**
   * Create a string field editor for given parameters.
   * @param parent_p parent_p of the underlying widgets.
   * @param page_p the page where the created field editor is displayed.
   * @param label_p label of the field editor.
   * @param labelTooltip_p tooltip of the Label of the created field editor, provides information related to the field.
   * @param textTooltip_p tooltip of the Text of the created field editor, used as an advisor to help the end-user to enter data that match the expected field
   *          format.
   * @param textLimit_p the maximum number of characters that the field editor is capable of holding, {@link SWT#DEFAULT} means unlimited.
   * @param fieldEditorValidator_p the field editor validator used when the editor check its state.
   * @return
   */
  public static ValidatingStringFieldEditor createStringFieldEditor(
    Composite parent_p, 
    DialogPage page_p, 
    String label_p, 
    String labelTooltip_p,
    String textTooltip_p, 
    int textLimit_p, 
    IValidator fieldEditorValidator_p,
    boolean readOnly_p
  ) {
    // Create the field editor.
    ValidatingStringFieldEditor fieldEditor = new ValidatingStringFieldEditor(
      ICommonConstants.EMPTY_STRING, 
      label_p, 
      CStringFieldEditor.UNLIMITED,
      CStringFieldEditor.VALIDATE_ON_MODIFICATION, 
      parent_p, 
      readOnly_p ? SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY : SWT.SINGLE | SWT.BORDER
    );
    // Set the owner page.
    fieldEditor.setPage(page_p);
    // Set the validator.
    fieldEditor.setValidator(fieldEditorValidator_p);
    // Set the label tooltip
    if (null != labelTooltip_p) {
      Label label = fieldEditor.getLabel();
      label.setToolTipText(labelTooltip_p);
    }
    // Set the text tooltip
    if (null != textTooltip_p) {
      Text text = fieldEditor.getTextControl();
      text.setToolTipText(textTooltip_p);
    }
    // Set the text limit
    if (textLimit_p != SWT.DEFAULT) {
      fieldEditor.setTextLimit(textLimit_p);
    }
    return fieldEditor;
  }

  /**
   * Create a radio group field editor.
   * @param parent_p
   * @param page_p the page where the created field editor is displayed.
   * @param title_p
   * @param numColumns_p
   * @param labelAndValues_p
   * @param readOnly_p 
   * @return
   */
  public static CRadioGroupFieldEditor createRadioGroupFieldEditor(
    Composite parent_p, 
    String title_p, 
    int numColumns_p, 
    String[][] labelAndValues_p,
    boolean readOnly_p
  ) {
    CRadioGroupFieldEditor group = new CRadioGroupFieldEditor(
      ICommonConstants.EMPTY_STRING, 
      title_p, 
      numColumns_p, 
      labelAndValues_p, 
      parent_p, 
      true
    );
    // Read Only Mode
    group.getRadioBoxControl(parent_p).setEnabled(readOnly_p == false);
    return group;
  }
  
  /**
   * Create a Java class field editor.
   * @param parent_p
   * @param page_p the page where the created field editor is displayed.
   * @param title_p
   * @param openTypeDialogTitle_p
   * @param classLoader_p
   * @param bundle_p 
   * @param classTypeFilter_p
   * @return
   */
  public static JavaScopeClassFieldEditor createJavaScopeClassFieldEditor(
    Composite parent_p, 
    DialogPage page_p, 
    String title_p, 
    String openTypeDialogTitle_p,
    IJavaProject javaProject_p,
    Class<?> classTypeFilter_p,
    final boolean readOnly_p
  ) {
    JavaScopeClassFieldEditor fieldEditor = new JavaScopeClassFieldEditor(
      title_p, 
      openTypeDialogTitle_p, 
      parent_p, 
      javaProject_p,
      classTypeFilter_p
    ) {
      @Override
      protected void doFillIntoGrid(Composite parent__p, int numColumns_p) {
        super.doFillIntoGrid(parent__p, numColumns_p);
        getChangeControl(parent__p).setEnabled(readOnly_p == false);        
      }
    };    
    fieldEditor.setPage(page_p);
    // An empty string is not allowed
    fieldEditor.setEmptyStringAllowed(false);
    // Enter directly the class name is not allowed.
    ((Text) fieldEditor.getValueControl()).setEditable(false);
    return fieldEditor;
  }  

  /**
   * Create a Java class field editor.
   * @param parent_p
   * @param page_p the page where the created field editor is displayed.
   * @param title_p
   * @param openTypeDialogTitle_p
   * @param classLoader_p
   * @param bundle_p 
   * @param classTypeFilter_p
   * @return
   */
  public static JavaClassFieldEditor createJavaClassFieldEditor(
    Composite parent_p, 
    DialogPage page_p, 
    String title_p, 
    String openTypeDialogTitle_p,
    ClassLoader classLoader_p, 
    Bundle bundle_p,
    Class<?> classTypeFilter_p,
    final boolean readOnly_p
  ) {
    JavaClassFieldEditor fieldEditor = new JavaClassFieldEditor(
      title_p, 
      openTypeDialogTitle_p, 
      parent_p, 
      classTypeFilter_p
    ) {
      @Override
      protected void doFillIntoGrid(Composite parent__p, int numColumns_p) {
        super.doFillIntoGrid(parent__p, numColumns_p);
        getChangeControl(parent__p).setEnabled(readOnly_p == false);        
      }
    };    
    initializeJavaClassFieldEditor(
      page_p, 
      classLoader_p,
      bundle_p,
      classTypeFilter_p, 
      fieldEditor
    );
    return fieldEditor;
  }

  /**
   * Create a context element field editor.
   * @param parent_p
   * @param page_p the page where the created field editor is displayed.
   * @param title_p
   * @param openTypeDialogTitle_p
   * @param classLoader_p
   * @param classTypeFilter_p
   * @return
   */
  public static ContextElementFieldEditor createContextElementFieldEditor(
    Composite parent_p, 
    DialogPage page_p, 
    String title_p, 
    String openTypeDialogTitle_p,
    ClassLoader classLoader_p, 
    Bundle bundle_p,
    Class<?> classTypeFilter_p,
    final boolean readOnly_p
  ) {
    ContextElementFieldEditor fieldEditor = new ContextElementFieldEditor(
      title_p, 
      openTypeDialogTitle_p, 
      parent_p, 
      classTypeFilter_p
    ) {
      @Override
      protected void doFillIntoGrid(Composite parent__p, int numColumns_p) {
        super.doFillIntoGrid(parent__p, numColumns_p);
        getChangeControl(parent__p).setEnabled(readOnly_p == false);        
      }
    }; 
    initializeJavaClassFieldEditor(
      page_p, 
      classLoader_p, 
      bundle_p,
      classTypeFilter_p, 
      fieldEditor
    );
    return fieldEditor;
  }

  /**
   * Initialize a field editor based on {@link JavaClassFieldEditor}.
   * @param page_p
   * @param classLoader_p
   * @param classTypeFilter_p
   * @param fieldEditor_p
   */
  private static void initializeJavaClassFieldEditor(
    DialogPage page_p, 
    ClassLoader classLoader_p, 
    Bundle bundle_p,
    Class<?> classTypeFilter_p,
    JavaClassFieldEditor fieldEditor_p
  ) {
    fieldEditor_p.setPage(page_p);
    // An empty string is not allowed
    fieldEditor_p.setEmptyStringAllowed(false);
    // Enter directly the class name is not allowed.
    ((Text) fieldEditor_p.getValueControl()).setEditable(false);
    // Set a validator.
    fieldEditor_p.setValidator(new JavaClassValidator(classLoader_p, bundle_p, classTypeFilter_p));
  }

  /**
   * Create a field editor that allows the end-user to select a file located in given container.
   * @param parent_p
   * @param title_p
   * @param openResourceDialogTitle_p
   * @param container_p
   * @param filterExtension_p
   * @return
   */
  public static WorkspaceFileFieldEditor createWorkspaceFileEditor(
    Composite parent_p, 
    String title_p, 
    String openResourceDialogTitle_p,
    IContainer container_p, 
    String filterExtension_p,
    final boolean readOnly_p
  ) {
    WorkspaceFileFieldEditor fieldEditor = new WorkspaceFileFieldEditor(
      title_p, 
      openResourceDialogTitle_p, 
      parent_p, 
      container_p, 
      filterExtension_p
    ) {
      @Override
      protected void doFillIntoGrid(Composite parent__p, int numColumns_p) {
        super.doFillIntoGrid(parent__p, numColumns_p);
        getChangeControl(parent__p).setEnabled(readOnly_p == false);        
      }
    }; 
    // Empty string is not allowed.
    fieldEditor.setEmptyStringAllowed(false);
    return fieldEditor;
  }

  /**
   * Create a field editor that allows the end-user to select a domain file located in given container.
   * @param parent_p
   * @param title_p
   * @param openResourceDialogTitle_p
   * @param container_p
   * @param filterExtension_p
   * @return
   */
  public static DomainFieldEditor createDomainFieldEditor(
    Composite parent_p, 
    String title_p, 
    String openResourceDialogTitle_p, 
    IContainer container_p,
    String filterExtension_p,
    final boolean readOnly_p
  ) {
    DomainFieldEditor fieldEditor = new DomainFieldEditor(
      title_p, 
      openResourceDialogTitle_p, 
      parent_p, 
      container_p, 
      filterExtension_p
    ) {
      @Override
      protected void doFillIntoGrid(Composite parent__p, int numColumns_p) {
        super.doFillIntoGrid(parent__p, numColumns_p);
        getChangeControl(parent__p).setEnabled(readOnly_p == false);        
      }
    }; 
    // Empty string is not allowed.
    fieldEditor.setEmptyStringAllowed(false);
    // Set domain path Text widget as a non editable widget.
    ((Text) fieldEditor.getValueControl()).setEditable(false);
    return fieldEditor;
  }

  /**
   * Layout given field editor on given number of columns.
   * @param parent_p
   * @param fieldEditor_p
   * @param numColumns_p
   */
  public static void layoutFieldEditor(Composite parent_p, FieldEditor fieldEditor_p, int numColumns_p) {
    // Force parent layout to have given number of columns.
    ((GridLayout) parent_p.getLayout()).numColumns = numColumns_p;
    // Ask the type group to layout on given number of columns.
    fieldEditor_p.fillIntoGrid(parent_p, numColumns_p);
  }
  
}
