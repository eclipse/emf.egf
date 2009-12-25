package org.eclipse.egf.pattern.ui.editors.dialogs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.egf.pattern.ui.editors.models.CommonModel;
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
        if(regex.isEmpty()|| regex == null)
            return true;
        try{
            Matcher matcher = Pattern.compile(regex.toLowerCase()).matcher(content.toLowerCase());
            if (matcher.find()) {
                return true;
            } else {
                return false;
            }
        }catch(Exception e){
            return false;
        }
    }
    
    /**
     * Make list area's first element selected.
     */
    protected Object selectDefault(CommonModel model, TableViewer tableViewer) {
        if (model.elements().length > 0) {
            tableViewer.setSelection(new StructuredSelection(model.elements()[0]));
            return model.elements()[0];
        }
        return null;
    }
}
