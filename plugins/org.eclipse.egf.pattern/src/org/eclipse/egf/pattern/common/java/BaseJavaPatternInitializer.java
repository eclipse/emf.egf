package org.eclipse.egf.pattern.common.java;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.engine.PatternHelper;
import org.eclipse.egf.pattern.extension.TemplateInitializer;
import org.eclipse.egf.pattern.templates.TemplateEngine;

public abstract class BaseJavaPatternInitializer extends TemplateInitializer {

    private static final String CLASS_KEY = "CLASS";
    private static final String PACKAGE_KEY = "PACKAGE";
    private Map<String, String> ctx;

    public BaseJavaPatternInitializer(IProject project, Pattern pattern, TemplateEngine engine) {
        super(project, pattern, engine);
    }

    @Override
    protected Map<String, String> createContext() {
        if (ctx != null)
            return ctx;
        ctx = new HashMap<String, String>();
        ctx.put(CLASS_KEY, PatternHelper.dropNonWordCharacter(getPattern().getName()));
        String fullLibraryName = PatternHelper.getFullLibraryName(getPattern());
        if (fullLibraryName == null || "".equals(fullLibraryName))
            fullLibraryName = "default_package";
        ctx.put(PACKAGE_KEY, fullLibraryName);
        return ctx;
    }

}