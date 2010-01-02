package org.eclipse.egf.pattern.ui.editors.selector;

import org.eclipse.emf.validation.model.IClientSelector;

public class ParameterValidationDelegateClientSelector implements IClientSelector  {
    public static boolean running = false;

    public boolean selects(Object object) {

        return running;
    }
}
