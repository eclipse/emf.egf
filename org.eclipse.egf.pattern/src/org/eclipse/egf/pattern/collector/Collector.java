package org.eclipse.egf.pattern.collector;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

public abstract class Collector<E> {

    protected Collector() {
        super();
    }

    protected abstract void doCollect(EObject source, final Set<E> result, final Set<String> ids);

    public void collect(EObject source, final Set<E> result) {
        collect(source, result, EMPTY_ID_SET);
    }

    public void collect(EObject source, final Set<E> result, final Set<String> ids) {
        if (ids == null)
            throw new IllegalArgumentException();
        if (result == null)
            throw new IllegalArgumentException();
        if (source == null)
            throw new IllegalArgumentException();
        doCollect(source, result, ids);
    }

    public void collect(List<EObject> source, final Set<E> result) {
        collect(source, result, EMPTY_ID_SET);
    }

    public void collect(List<EObject> source, final Set<E> result, final Set<String> ids) {
        if (ids == null)
            throw new IllegalArgumentException();
        if (result == null)
            throw new IllegalArgumentException();
        if (source == null)
            throw new IllegalArgumentException();
        for (EObject obj : source)
            collect(obj, result, ids);
    }

    public void collect(EObject[] source, final Set<E> result) {
        collect(source, result, EMPTY_ID_SET);
    }

    public void collect(EObject[] source, final Set<E> result, final Set<String> ids) {
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