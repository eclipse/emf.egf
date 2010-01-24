package org.eclipse.egf.pattern.fprod.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.model.pattern.PatternContext;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternException;
import org.eclipse.egf.pattern.extension.ExtensionHelper.MissingExtensionException;
import org.eclipse.egf.pattern.fprod.Messages;
import org.eclipse.egf.pattern.strategy.Strategy;

public abstract class AbstractStrategyTask extends AbstractPatternTask {
  private final Strategy strategy;
  protected Object parameter;
  protected final List<PatternElement> patterns = new ArrayList<PatternElement>();

  protected AbstractStrategyTask(Strategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public void preExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    // WORKAROUND how to read an array ?
    String ids = context.getInputValue(PatternContext.PATTERN_IDS_PARAMETER, String.class);
    String[] idArray = ids.split(", "); //$NON-NLS-1$
    Set<String> idSet = new HashSet<String>();
    idSet.addAll(Arrays.asList(idArray));

    Map<String, PatternElement> patternElements = helper.getPatternElements(idSet);
    for (String id : idArray) {
      PatternElement pe = patternElements.get(id);
      if (pe != null)
        patterns.add(pe);
    }
  }

  @Override
  public final void doExecute(final ITaskProductionContext context, final IProgressMonitor monitor) throws InvocationException {
    if (parameter == null)
      throw new InvocationException(Messages.taskInvocation_error1);
    if (patterns.isEmpty())
      // Activator.getDefault().logWarning(Messages.taskInvocation_error3);
      throw new InvocationException(Messages.taskInvocation_error3);

    try {
      PatternContext ctx = createPatternContext(context);
      readContext(context, ctx);
      strategy.setPatternElements(patterns);
      strategy.execute(ctx, parameter);
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
    parameter = null;
  }
}
