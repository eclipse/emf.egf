package org.eclipse.egf.pattern.strategy;

import java.util.List;

import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;

/**
 * A strategy is responsible for managing the executing a set of
 * Pattern objects.
 * 
 * @author Thomas Guiu
 * 
 */

public interface Strategy {

    public void setPatternElements(List<PatternElement> patterns);

    public void execute(PatternContext context, Object parameter) throws PatternException, MissingExtensionException;

}