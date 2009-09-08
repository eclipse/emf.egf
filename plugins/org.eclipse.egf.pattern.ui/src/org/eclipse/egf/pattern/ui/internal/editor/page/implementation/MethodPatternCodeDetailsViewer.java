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
package org.eclipse.egf.pattern.ui.internal.editor.page.implementation;

import org.eclipse.egf.common.constant.ICommonConstants;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.ui.helper.FormHelper;
import org.eclipse.egf.common.ui.helper.FormHelper.LayoutType;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ui.editor.page.AbstractPatternDetails;
import org.eclipse.egf.pattern.ui.editor.page.AbstractPatternPage;
import org.eclipse.egf.pattern.ui.editor.page.util.DisplayHelper;
import org.eclipse.egf.pattern.ui.internal.editor.DefaultPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.IPatternModificationNotification;
import org.eclipse.egf.pattern.ui.internal.editor.page.DefaultContentHandler;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.PatternCodeActionParameterWizard;
import org.eclipse.egf.pattern.ui.internal.editor.page.implementation.wizard.PatternCodeActionTypeSelectionPage;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;


/**
 * @author Guillaume Brocard
 */
public class MethodPatternCodeDetailsViewer extends AbstractPatternDetails {
  
  /**
   * Content handler.
   */
  private MethodPatternCodeActionHandler _handler;
  
  /**
   * Containing pattern page.
   */
  private AbstractPatternPage _page;
  
  /**
   * Action parameter text widget.
   */
  private Text _actionParameterText;
  
  /**
   * Display helper.
   */
  private DisplayHelper _displayHelper;
  
  /**
   * Action type.
   */
  private String _actionType;

  /**
   * Constructor.
   * @param masterPart_p
   */
  public MethodPatternCodeDetailsViewer(IFormPart masterPart_p, AbstractPatternPage patternPage_p) {
    super(masterPart_p);
    _page = patternPage_p;
  }

  /**
   * @see org.eclipse.egf.pattern.ui.editor.page.AbstractPatternDetails#doCreateContents(org.eclipse.ui.forms.widgets.FormToolkit,
   *      org.eclipse.swt.widgets.Composite, java.lang.Object)
   */
  @Override
  protected void doCreateContents(FormToolkit toolkit_p, Composite parent_p, Object initialContent_p) {
    MethodActionHandler actionHandler = (MethodActionHandler) initialContent_p;
    Couple<String, String> action = actionHandler.getAction();
    _actionType = action.getKey();
    // Update parent composite.
    FormHelper.updateCompositeLayoutWithLayoutType(parent_p, LayoutType.GRID_LAYOUT, 1, false);
    // Create action section.
    Couple<Section, Composite> actionCouple = FormHelper.createSectionWithChildComposite(
      toolkit_p, 
      parent_p, 
      ExpandableComposite.TITLE_BAR + ExpandableComposite.EXPANDED,
      LayoutType.GRID_LAYOUT, 
      3, 
      false
    );
    actionCouple.getKey().setText(Messages.MethodPatternCodeDetailsViewer_ActionPropertiesSectionText);
    Composite actionComposite = actionCouple.getValue();
    // Create action name.
    Couple<Label, Text> actionName = FormHelper.createLabelAndText(
      toolkit_p, 
      actionComposite,
      Messages.MethodPatternCodeDetailsViewer_ActionPropertiesNameLabel,
      PatternCodeActionTypeSelectionPage.getActionTypeDisplayableText(_actionType), 
      false
    );
    GridData actionNameTextData = (GridData) actionName.getValue().getLayoutData();
    actionNameTextData.horizontalSpan = 2;
    // Create action parameter.
    _handler = new MethodPatternCodeActionHandler(_page);
    Couple<Text, Button> actionParameter = FormHelper.createLabelTextAndButton(
      toolkit_p, 
      actionComposite,
      Messages.MethodPatternCodeDetailsViewer_ActionPropertiesParameterLabel,
      Messages.MethodPatternCodeDetailsViewer_ActionPropertiesParameterButtonLabel,
      _handler
    );
    _actionParameterText = actionParameter.getKey();
    _actionParameterText.setEditable(false);
    String actionParameterValue = action.getValue();
    if (null == actionParameterValue) {
      actionParameterValue = ICommonConstants.EMPTY_STRING;
    }
    setParameterValue(actionParameterValue);
  }

  /**
   * Set widget parameter value to given one.
   * @param actionParameterValue_p
   */
  protected void setParameterValue(String actionParameterValue_p) {
    // Get display helper.
    if (null == _displayHelper) {
      _displayHelper = new DisplayHelper();
    }
    // Displayed parameter value depends on action type.
    if (PatternConstants.PC_TAG_PATTERN.equals(_actionType)) {
      _actionParameterText.setText(_displayHelper.getPatternOrLibraryFullName(actionParameterValue_p));
    } else {
      _actionParameterText.setText(actionParameterValue_p);
    }
  }

  /**
   * Method pattern code action handler.
   * @author Guillaume Brocard
   */
  protected class MethodPatternCodeActionHandler extends DefaultContentHandler implements SelectionListener {
    
    /**
     * Constructor.
     */
    public MethodPatternCodeActionHandler(AbstractPatternPage page_p) {
      super(null, page_p);
    }

    /**
     * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
     */
    public void widgetDefaultSelected(SelectionEvent se_p) {
      // Nothing to do here.
    }

    /**
     * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
     */
    @SuppressWarnings( { "synthetic-access" })
    public void widgetSelected(SelectionEvent se_p) {
      MethodActionHandler patternCodeActionHandler = (MethodActionHandler) getInitialContent();
      Couple<String, String> patternCodeAction = patternCodeActionHandler.getAction();
      // Get old parameter value.
      String oldParameterValue = patternCodeAction.getValue();
      Couple<String, String> temporaryAction = patternCodeAction.clone();
      // Open selection wizard.
      WizardDialog wizardDialog = new WizardDialog(_page.getSite().getShell(), new PatternCodeActionParameterWizard(_page.getPatternData(), temporaryAction));
      int returnCode = wizardDialog.open();
      if (Window.OK == returnCode) {
        // Get new parameter value.
        String newParameterValue = temporaryAction.getValue();
        // Change known value.
        patternCodeAction.setValue(newParameterValue);
        // Notify text widget.
        setParameterValue(newParameterValue);
        // Then notify listeners.
        // Create notification.
        IPatternModificationNotification notification = DefaultPatternModificationNotification.createNotification(
          IPatternModificationNotification.SET,
          patternCodeActionHandler, 
          oldParameterValue,
          newParameterValue
        );
        // And send it.
        getPage().getEditor().sendNotification(notification);
        // Notify editor.
        notifyModification();
      }
    }
    
  }
  
}