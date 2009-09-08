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

import org.eclipse.egf.common.misc.Couple;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;


/**
 * UI Forms helper.<br>
 * Allows creation of Composites, Layouts and Forms widgets.
 * @author Guillaume Brocard
 */
public class FormHelper {
  
  /**
   * Layout usable types.
   */
  public static enum LayoutType {GRID_LAYOUT, TABLEWRAP_LAYOUT}

  /**
   * Create a new composite and set the layout using {@link #updateCompositeLayoutWithLayoutType(Composite, org.eclipse.egf.common.ui.helper.FormHelper.LayoutType, int)} method.
   * @param toolkit_p
   * @param parent_p
   * @param numColumns_p
   * @return
   */
  public static Composite createCompositeWithLayoutType(
    FormToolkit toolkit_p, 
    Composite parent_p, 
    LayoutType layoutType_p, 
    int numColumns_p, 
    boolean equalWidth_p
  ) {
    Composite result = toolkit_p.createComposite(parent_p);
    updateCompositeLayoutWithLayoutType(result, layoutType_p, numColumns_p, equalWidth_p);
    return result;
  }

  /**
   * Update given composite with given layout type and given number of columns (if it makes any sense).<br>
   * Also set the layout data to {@link #updateControlLayoutDataWithLayoutTypeData(Composite, org.eclipse.egf.common.ui.helper.FormHelper.LayoutType)}.
   * @param composite_p
   * @param layoutType_p
   * @param numColumns_p
   */
  public static Object updateCompositeLayoutWithLayoutType(
    Composite composite_p, 
    LayoutType layoutType_p, 
    int numColumns_p, 
    boolean equalWidth_p
  ) {
    Layout selectedLayout = null;
    if (LayoutType.GRID_LAYOUT.equals(layoutType_p)) {
      GridLayout layout = new GridLayout();
      layout.numColumns = numColumns_p;
      layout.makeColumnsEqualWidth = equalWidth_p;
      selectedLayout = layout;
    } else if (LayoutType.TABLEWRAP_LAYOUT.equals(layoutType_p)) {
      TableWrapLayout layout = new TableWrapLayout();
      layout.numColumns = numColumns_p;
      layout.makeColumnsEqualWidth = equalWidth_p;
      selectedLayout = layout;
    }
    // Do not set neither layout nor layout data if layout could not be created.
    if (null != selectedLayout) {
      composite_p.setLayout(selectedLayout);
      updateControlLayoutDataWithLayoutTypeData(composite_p, layoutType_p);
    }
    return selectedLayout;
  }

  /**
   * Update given control layout data depending on given layout type.<br>
   * Replace layout data is set to fill/grab in both directions, if it makes any sense.
   * @param control_p
   */
  public static Object updateControlLayoutDataWithLayoutTypeData(Control control_p, LayoutType layoutType_p) {
    Object layoutData = null;
    if (LayoutType.GRID_LAYOUT.equals(layoutType_p)) {
      layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
    } else if (LayoutType.TABLEWRAP_LAYOUT.equals(layoutType_p)) {
      layoutData = new TableWrapData(TableWrapData.FILL_GRAB);
    }
    // Do not set layout data if it could not be created.
    if (null != layoutData) {
      control_p.setLayoutData(layoutData);
    }
    return layoutData;
  }

  /**
   * Create a section with a composite child using given child layout type.
   * @param toolkit_p
   * @param parent_p
   * @param sectionStyle_p
   * @param layoutType_p
   * @param childNumColumns_p
   * @param equalWidth_p
   * @return
   */
  public static Couple<Section, Composite> createSectionWithChildComposite(
    FormToolkit toolkit_p, 
    Composite parent_p, 
    int sectionStyle_p, 
    LayoutType layoutType_p, 
    int childNumColumns_p, 
    boolean equalWidth_p
  ) {
    Section resultingSection = toolkit_p.createSection(parent_p, sectionStyle_p);
    updateControlLayoutDataWithLayoutTypeData(resultingSection, layoutType_p);
    Composite childComposite = createCompositeWithLayoutType(
      toolkit_p, 
      resultingSection, 
      layoutType_p, 
      childNumColumns_p, 
      equalWidth_p
    );
    resultingSection.setClient(childComposite);
    return new Couple<Section, Composite>(resultingSection, childComposite);
  }

  /**
   * Create a user text widget with preceding label.<br>
   * Requires at least a two columns layout so that both the label and the text are displayed on the same line.
   * @param toolkit_p
   * @param parent_p
   * @param labelMessage_p
   * @param initialText_p
   * @param editable_p
   * @return
   */
  public static Couple<Label, Text> createLabelAndText(
    FormToolkit toolkit_p, 
    Composite parent_p, 
    String labelMessage_p, 
    String initialText_p, 
    boolean editable_p
  ) {
    // Create label.
    Label label = toolkit_p.createLabel(parent_p, labelMessage_p, SWT.WRAP);
    label.setForeground(toolkit_p.getColors().getColor(IFormColors.TITLE));
    // Create text. 
    Text text = new Text(
      parent_p, 
      editable_p ? SWT.BORDER : SWT.BORDER | SWT.READ_ONLY
    );
    text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    // Set existing value.
    if (null != initialText_p) {
      text.setText(initialText_p);
    }
    return new Couple<Label, Text>(label, text);
  }

  /**
   * Create a user text widget with preceding label and following button.<br>
   * Requires at least a three columns layout so that the label, the text and the button are displayed on the same line.
   * @param toolkit_p
   * @param parent_p
   * @param labelMessage_p
   * @param buttonLabel_p
   * @param listener_p
   * @return
   */
  public static Couple<Text, Button> createLabelTextAndButton(
    FormToolkit toolkit_p, 
    Composite parent_p, 
    String labelMessage_p, 
    String buttonLabel_p, 
    SelectionListener listener_p
  ) {
    // Create label and text.
    Couple<Label, Text> labelAndText = createLabelAndText(toolkit_p, parent_p, labelMessage_p, null, true);
    // Create button.
    Button button = toolkit_p.createButton(parent_p, buttonLabel_p, SWT.PUSH);
    // Add button listener.
    if (null != listener_p) {
      button.addSelectionListener(listener_p);
    }
    return new Couple<Text, Button>(labelAndText.getValue(), button);
  }

  /**
   * Create a link with a label description.<br>
   * Requires a two columns layout so that both the link and the label are displayed on the same line.
   * @param toolkit_p
   * @param parent_p
   * @param icon_p
   * @param linkText_p
   * @param linkRef_p
   * @param linkDescription_p
   * @param listener_p
   */
  public static void createLinkWithDescription(
    FormToolkit toolkit_p, 
    Composite parent_p, 
    Image icon_p, 
    String linkText_p, 
    Object linkRef_p, 
    String linkDescription_p, 
    IHyperlinkListener listener_p
  ) {
    ImageHyperlink specificationLink = toolkit_p.createImageHyperlink(parent_p, SWT.WRAP);
    specificationLink.setText(linkText_p);
    specificationLink.setImage(icon_p);
    specificationLink.setHref(linkRef_p);
    specificationLink.addHyperlinkListener(listener_p);
    toolkit_p.createLabel(parent_p, linkDescription_p, SWT.WRAP);
  }

  /**
   * Force control size.
   * @param control_p
   * @param widthInChars_p The expected width, in number of chars to display.
   * @param heightInChars_p The expected height, in number of chars to display.
   */
  public static void forceControlSize(Control control_p, int widthInChars_p, int heightInChars_p) {
    // Preconditions.
    if ((null == control_p) || (0 >= widthInChars_p) || (0 >= heightInChars_p)) {
      return;
    }
    // Get font metrics.
    GC gc = new GC(control_p);
    FontMetrics fontMetrics = gc.getFontMetrics();
    gc.dispose();
    // Get layout data.
    Object layoutData = control_p.getLayoutData();
    if (layoutData instanceof GridData) {
      GridData data = (GridData) layoutData;
      data.widthHint = Dialog.convertWidthInCharsToPixels(fontMetrics, widthInChars_p);
      data.heightHint = Dialog.convertHeightInCharsToPixels(fontMetrics, heightInChars_p);
    } else if (layoutData instanceof TableWrapData) {
      TableWrapData data = (TableWrapData) layoutData;
      data.heightHint = Dialog.convertHeightInCharsToPixels(fontMetrics, heightInChars_p);
    }
  }
  
}
