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
package org.eclipse.egf.pattern.ui.internal.editor.page.specification;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.listener.DefaultResourceListener;
import org.eclipse.egf.common.misc.Couple;
import org.eclipse.egf.common.ui.helper.FormHelper;
import org.eclipse.egf.common.ui.helper.WorkbenchHelper;
import org.eclipse.egf.common.ui.helper.FormHelper.LayoutType;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.production.GeneratedContentProducer;
import org.eclipse.egf.pattern.ui.editor.page.util.DisplayHelper;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;


/**
 * Pattern condition viewer.<br>
 * Abide to UI Forms presentation.
 * @author Guillaume Brocard
 */
public class ConditionViewer {
  /**
   * Log4j reference logger.
   */
  protected static final Logger __logger = Logger.getLogger(ConditionViewer.class.getPackage().getName());
  /**
   * In use form toolkit.
   */
  private FormToolkit _toolkit;
  /**
   * Pattern data.
   */
  protected PatternData _patternData;
  /**
   * Condition link listener.
   */
  private ConditionLinkListener _conditionLinkListener;
  /**
   * Pattern handler reference.
   */
  protected PatternHandler _patternHandler;
  /**
   * Is viewer editable ?
   */
  protected boolean _isEditable;
  /**
   * Resource change listener for condition preview content.
   */
  private DefaultResourceListener _listener;

  /**
   * Constructor.
   * @param parent_p
   * @param toolkit_p
   */
  public ConditionViewer(Composite parent_p, FormToolkit toolkit_p, PatternData patternData_p, PatternHandler handler_p, boolean isEditable_p) {
    _isEditable = isEditable_p;
    _toolkit = toolkit_p;
    _patternData = patternData_p;
    _patternHandler = handler_p;
    doCreateContent(parent_p);
  }

  /**
   * Dispose viewer resources.
   */
  public void dispose() {
    // Unregister resource listener.
    if (null != _listener) {
      _listener.dispose();
      _listener = null;
    }
  }

  /**
   * Create viewer content.
   * @param parent_p
   */
  protected void doCreateContent(Composite parent_p) {
    // Create top composite.
    Composite conditionComposite = FormHelper.createCompositeWithLayoutType(_toolkit, parent_p, LayoutType.GRID_LAYOUT, 2, false);
    // Create left section, with button to edit condition.
    Couple<Section, Composite> editionCouple =
                                               FormHelper.createSectionWithChildComposite(_toolkit, conditionComposite, ExpandableComposite.TITLE_BAR
                                                                                                                        + ExpandableComposite.EXPANDED,
                                                                                          LayoutType.GRID_LAYOUT, 2, false);
    Section editionSection = editionCouple.getKey();
    editionSection.setText(Messages.ConditionViewer_EditSectionTitle);
    Composite editionComposite = editionCouple.getValue();
    {
      Image image = JavaPlugin.getDefault().getImageRegistry().get(JavaPluginImages.IMG_OBJS_CFILECLASS);
      _conditionLinkListener = new ConditionLinkListener();
      FormHelper.createLinkWithDescription(_toolkit, editionComposite, image, Messages.ConditionViewer_EditSectionLinkLabel, null,
                                           Messages.ConditionViewer_EditSectionLinkDescription, _conditionLinkListener);
      // Allow edition of condition class ?
      editionComposite.setEnabled(_isEditable);
    }
    // Create right section, with preview of the condition class content.
    Couple<Section, Composite> previewCouple =
                                               FormHelper.createSectionWithChildComposite(_toolkit, conditionComposite, ExpandableComposite.TITLE_BAR
                                                                                                                        + ExpandableComposite.EXPANDED,
                                                                                          LayoutType.GRID_LAYOUT, 1, false);
    Section previewSection = previewCouple.getKey();
    previewSection.setText(Messages.ConditionViewer_HowToSectionTitle);
    Composite previewComposite = previewCouple.getValue();
    {
      final String conditionFileRelativePath = GeneratedContentProducer.getConditionFileRelativePath(_patternData);
      String content = FileHelper.readFile(conditionFileRelativePath);
      final Text conditionText = _toolkit.createText(previewComposite, content, SWT.H_SCROLL | SWT.V_SCROLL | SWT.WRAP);
      if (_isEditable) {
        final Display display = conditionText.getShell().getDisplay();
        final IResource fileResource = FileHelper.getPlatformFile(conditionFileRelativePath);
        _listener = new DefaultResourceListener() {
          @Override
          protected void handleResourceChanged(IResourceChangeEvent event_p, IResource watchedResource_p) {
            display.asyncExec(new Runnable() {
              public void run() {
                conditionText.setText(FileHelper.readFile(conditionFileRelativePath));
              }
            });
          }
        };
        _listener.setResourceToWatch(fileResource);
      }
      // Just a consultation tip, do not allow modification here.
      conditionText.setEditable(false);
      FormHelper.updateControlLayoutDataWithLayoutTypeData(conditionText, LayoutType.GRID_LAYOUT);
      FormHelper.forceControlSize(conditionText, DisplayHelper.DEFAULT_TEXT_WIDTH_IN_CHARS, DisplayHelper.DEFAULT_TEXT_HEIGHT_IN_CHARS);
    }
  }

  /**
   * Condition edition link listener.
   */
  protected class ConditionLinkListener extends HyperlinkAdapter {
    /**
     * Condition class editor id.
     */
    private static final String EDITOR_ID = "org.eclipse.jdt.ui.CompilationUnitEditor"; //$NON-NLS-1$

    /**
     * @see org.eclipse.ui.forms.events.HyperlinkAdapter#linkActivated(org.eclipse.ui.forms.events.HyperlinkEvent)
     */
    @Override
    public void linkActivated(HyperlinkEvent e_p) {
      _patternHandler.recomputeConditionStructures();
      String generatedClassRelativePath = GeneratedContentProducer.getConditionFileRelativePath(_patternData);
      WorkbenchHelper.openFileEditor(generatedClassRelativePath, EDITOR_ID, _isEditable);
    }
  }
  
}
