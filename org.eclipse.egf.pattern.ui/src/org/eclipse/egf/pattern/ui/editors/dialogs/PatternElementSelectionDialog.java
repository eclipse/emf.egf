package org.eclipse.egf.pattern.ui.editors.dialogs;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

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
    protected boolean searchContainer(String content, String regex) {
        if (regex.isEmpty() || regex == null)
            return true;
        try {
            Matcher matcher = Pattern.compile(regex).matcher(content);
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
