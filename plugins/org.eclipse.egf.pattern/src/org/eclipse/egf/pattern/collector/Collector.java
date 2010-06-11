package org.eclipse.egf.pattern.collector;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.Viewpoint;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.emf.ecore.EObject;

public abstract class Collector<E extends PatternElement> {

    protected Collector() {
        super();
    }

    protected final void doCollect(EObject source, final List<E> result, final Set<String> ids) {
        if (FcorePackage.eINSTANCE.equals(source.eClass().getEPackage())) {
            switch (source.eClass().getClassifierID()) {
                case FcorePackage.FACTORY_COMPONENT:
                    ViewpointContainer viewpointContainer = ((FactoryComponent) source).getViewpointContainer();
                    if (viewpointContainer != null) {
                        for (Viewpoint viewpoint : viewpointContainer.getViewpoints())
                            doCollect(viewpoint, result, ids);
                    }
                    return;
            }
        } else if (PatternPackage.eINSTANCE.equals(source.eClass().getEPackage())) {
            switch (source.eClass().getClassifierID()) {
                case PatternPackage.PATTERN_VIEWPOINT:
                    casePatternViewpoint((PatternViewpoint) source, result, ids);
                    return;
                case PatternPackage.PATTERN_LIBRARY:
                    casePatternLibrary((PatternLibrary) source, result, ids);
                    return;
                case PatternPackage.PATTERN:
                    casePattern((Pattern) source, result, ids);
                    return;
            }
        }
    }

    protected void casePattern(Pattern source, final List<E> result, final Set<String> ids) {
    }

    protected void casePatternLibrary(PatternLibrary source, final List<E> result, final Set<String> ids) {
        for (PatternElement elem : source.getElements())
            doCollect(elem, result, ids);
    }

    protected void casePatternViewpoint(PatternViewpoint source, final List<E> result, final Set<String> ids) {
        for (PatternLibrary lib : source.getLibraries())
            doCollect(lib, result, ids);
        return;
    }

    public void collect(EObject source, final List<E> result) {
        collect(source, result, EMPTY_ID_SET);
    }

    public void collect(EObject source, final List<E> result, final Set<String> ids) {
        if (ids == null)
            throw new IllegalArgumentException();
        if (result == null)
            throw new IllegalArgumentException();
        if (source == null)
            throw new IllegalArgumentException();
        doCollect(source, result, ids);
    }

    public void collect(List<EObject> source, final List<E> result) {
        collect(source, result, EMPTY_ID_SET);
    }

    public void collect(List<EObject> source, final List<E> result, final Set<String> ids) {
        if (ids == null)
            throw new IllegalArgumentException();
        if (result == null)
            throw new IllegalArgumentException();
        if (source == null)
            throw new IllegalArgumentException();
        for (EObject obj : source)
            collect(obj, result, ids);
    }

    public void collect(EObject[] source, final List<E> result) {
        collect(source, result, EMPTY_ID_SET);
    }

    public void collect(EObject[] source, final List<E> result, final Set<String> ids) {
        if (ids == null)
            throw new IllegalArgumentException();
        if (result == null)
            throw new IllegalArgumentException();
        if (source == null)
            throw new IllegalArgumentException();
        for (EObject obj : source)
            collect(obj, result, ids);
    }

    public static final Set<String> EMPTY_ID_SET = new HashSet<String>();

}
