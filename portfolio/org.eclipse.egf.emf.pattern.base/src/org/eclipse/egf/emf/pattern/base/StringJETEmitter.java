/**
 * 
 */
package org.eclipse.egf.emf.pattern.base;

import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.util.Monitor;

/**
 * @author Matthieu Helleboid
 * 
 */
public class StringJETEmitter extends JETEmitter {

    protected String output;

    public StringJETEmitter(String output) {
        super(null);
        this.output = output;
    }

    @Override
    public String generate(Monitor progressMonitor, Object[] arguments, String lineDelimiter) throws JETException {
        return output;
    }

}
