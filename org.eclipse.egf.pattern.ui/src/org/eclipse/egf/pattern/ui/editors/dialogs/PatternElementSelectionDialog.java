/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.editors.dialogs;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * 
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class PatternElementSelectionDialog extends SelectionStatusDialog {

    public PatternElementSelectionDialog(Shell parent) {
        super(parent);

    }

    @Override
    protected void computeResult() {
    }

    /**
     * Matching patternElements.
     */
    public static boolean searchContainer(String content, String regex) {
        if (regex == null || regex.length() == 0)
            return true;
        try {
            Matcher matcher = Pattern.compile(regex.toLowerCase()).matcher(content.toLowerCase());
            if (matcher.find()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Make list area's first element selected.
     */
    protected Object selectDefault(List<?> list, TableViewer tableViewer) {
        if (list.size() > 0) {
            tableViewer.setSelection(new StructuredSelection(list.get(0)));
            return list.get(0);
        }
        return null;
    }
}
