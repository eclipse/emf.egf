package org.eclipse.egf.pattern.fprod.tasks;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.fprod.Messages;

public class PatternTask extends AbstractPatternTask {

  private final LinkedHashSet<Pattern> patterns = new LinkedHashSet<Pattern>();

  @Override
  public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    String patternId = context.getInputValue(PatternContext.PATTERN_ID, String.class);
    Set<String> ids = new HashSet<String>();
    ids.add(patternId);
    Map<String, PatternElement> patternElements = helper.getPatternElements(ids);
    if (patternElements.isEmpty())
      throw new InvocationException(Messages.bind(Messages.Missing_pattern_error1, patternId));
    PatternElement patternElement = patternElements.get(patternId);
    // to replace libraries by their contents
    PatternCollector.INSTANCE.collect(new PatternElement[] { patternElement }, patterns);
  }

  @Override
  public void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    try {
      PatternContext ctx = createPatternContext(context);
      readContext(context, ctx);

      for (Pattern pattern : patterns) {
        PatternExtension extension = ExtensionHelper.getExtension(pattern.getNature());
        String reason = extension.canExecute(pattern);

        if (reason == null)
          extension.createEngine(pattern).execute(ctx);
        else
          throw new InvocationException(reason);
      }
      writeContext(context, ctx);

    } catch (MissingExtensionException e) {
      throw new InvocationException(e);
    } catch (PatternException e) {
      throw new InvocationException(e);
    }
  }

  @Override
  public void postExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    super.postExecute(context, monitor);
    patterns.clear();
  }
}
