package org.eclipse.egf.emf.pattern.base;

import java.util.Map;

import org.eclipse.egf.model.pattern.PatternContext;

public class ContentTypePatternExecutionReporter extends CodegenPatternExecutionReporter {

    @Override
    public void loopFinished(String output, String outputWithCallBack, PatternContext context, Map<String, Object> parameterValues) {
        super.loopFinished(output, outputWithCallBack, context, parameterValues);

        if (!canGenerate)
            return;

        ContentType contentType = (ContentType) context.getValue("contentType"); //$NON-NLS-1$

        if (contentType == null || contentType.equals(ContentType.Undefined))
            throw new IllegalStateException("Variable contentType must be set."); //$NON-NLS-1$

        switch (contentType) {
        case Java:
            generateJava(output, context);
            break;

        case Properties:
            generateProperties(output, context);
            break;

        case Text:
            generateText(output, context);
            break;

        case GIF:
            generateGIF(output, context);
            break;
        }
    }
}
