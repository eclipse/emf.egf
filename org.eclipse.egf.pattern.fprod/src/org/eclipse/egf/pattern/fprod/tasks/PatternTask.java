package org.eclipse.egf.pattern.fprod.tasks;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.fprod.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.PatternContext;
import org.eclipse.egf.model.PatternException;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.fprod.Messages;

public class PatternTask extends AbstractPatternTask {

    private Pattern pattern;

    public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
        String patternId = context.getInputValue(PatternContext.PATTERN_ID, String.class); //$NON-NLS-1$
        pattern = PatternHelper.getPattern(patternId);
        if (pattern == null)
            throw new InvocationException(Messages.bind(Messages.Missing_pattern_error1, patternId));
    }

    public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
        try {
            PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
            String reason = extension.canExecute(pattern);
            PatternContext ctx = createPatternContext(context);

            readContext(context, ctx);

            if (reason == null)
                extension.createEngine(pattern).execute(ctx);
            else
                throw new InvocationException(reason);

            writeContext(context, ctx);

        } catch (MissingExtensionException e) {
            throw new InvocationException(e);
        } catch (PatternException e) {
            throw new InvocationException(e);
        }
    }

    public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor_p) throws InvocationException {
        pattern = null;
    }
}
