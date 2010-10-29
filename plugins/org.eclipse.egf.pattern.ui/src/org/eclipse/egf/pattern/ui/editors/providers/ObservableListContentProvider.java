/*******************************************************************************
 * Copyright (c) 2006, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Tom Schindl<tom.schindl@bestsolution.at> - bugfix in: 214355
 *     Matthew Hall - bugs 215531, 226765, 222991, 238296, 226292, 266038
 *     XiaoRu Chen - Soyatec
 *******************************************************************************/
package org.eclipse.egf.pattern.ui.editors.providers;

import java.util.Set;

import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.databinding.internal.EMFObservableListDecorator;
import org.eclipse.jface.databinding.viewers.IViewerUpdater;
import org.eclipse.jface.internal.databinding.viewers.ObservableCollectionContentProvider;
import org.eclipse.jface.internal.databinding.viewers.ViewerElementSet;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.TableItem;

public class ObservableListContentProvider implements IStructuredContentProvider {

    private ObservableCollectionContentProvider impl;

    private static int patternMethodsCount = 0;

    private static TableViewer tableViewer;

    private static class Impl extends ObservableCollectionContentProvider implements IListChangeListener {

        private Viewer viewer;

        Impl(IViewerUpdater explicitViewerUpdater) {
            super(explicitViewerUpdater);
        }

        @Override
        public void inputChanged(Viewer innerViewer, Object oldInput, Object newInput) {
            viewer = innerViewer;
            super.inputChanged(innerViewer, oldInput, newInput);
        }

        @Override
        protected void checkInput(Object input) {
            Assert.isTrue(input instanceof IObservableList, "This content provider only works with input of type IObservableList"); //$NON-NLS-1$
        }

        @Override
        protected void addCollectionChangeListener(IObservableCollection collection) {
            ((IObservableList) collection).addListChangeListener(this);
        }

        @Override
        protected void removeCollectionChangeListener(IObservableCollection collection) {
            ((IObservableList) collection).removeListChangeListener(this);
        }

        @SuppressWarnings("unchecked")
        public void handleListChange(ListChangeEvent event) {
            if (isViewerDisposed())
                return;

            // Determine which elements were added and removed
            @SuppressWarnings("rawtypes")
            final Set knownElementAdditions = ViewerElementSet.withComparer(comparer);
            @SuppressWarnings("rawtypes")
            final Set knownElementRemovals = ViewerElementSet.withComparer(comparer);
            final boolean[] suspendRedraw = new boolean[] {
                false
            };
            event.diff.accept(new ListDiffVisitor() {

                @Override
                public void handleAdd(int index, Object element) {
                    knownElementAdditions.add(element);
                }

                @Override
                public void handleRemove(int index, Object element) {
                    knownElementRemovals.add(element);
                }

                @Override
                public void handleMove(int oldIndex, int newIndex, Object element) {
                    suspendRedraw[0] = true;
                    super.handleMove(oldIndex, newIndex, element);
                }

                @Override
                public void handleReplace(int index, Object oldElement, Object newElement) {
                    suspendRedraw[0] = true;
                    super.handleReplace(index, oldElement, newElement);
                }

            });
            knownElementAdditions.removeAll(knownElements);
            knownElementRemovals.removeAll(event.getObservableList());

            knownElements.addAll(knownElementAdditions);
            if (realizedElements != null) {
                realizedElements.removeAll(knownElementRemovals);
            }

            if (suspendRedraw[0])
                viewer.getControl().setRedraw(false);
            try {
                event.diff.accept(new ListDiffVisitor() {

                    @Override
                    public void handleAdd(int index, Object element) {
                        int indexInTable = getAddIndexInTable(index);
                        viewerUpdater.insert(element, indexInTable);
                    }

                    @Override
                    public void handleRemove(int index, Object element) {
                        int indexInTable = getIndexInTable(element);
                        viewerUpdater.remove(element, indexInTable);
                    }

                    @Override
                    public void handleReplace(int index, Object oldElement, Object newElement) {
                        viewerUpdater.replace(oldElement, newElement, index);
                    }

                    @Override
                    public void handleMove(int oldIndex, int newIndex, Object element) {
                        int moveFormIndexInTable = getIndexInTable(element);
                        int moveToIndexInTable = getMoveToIndexInTable(newIndex);
                        viewerUpdater.move(element, moveFormIndexInTable, moveToIndexInTable);
                    }

                });
            } finally {
                if (suspendRedraw[0])
                    viewer.getControl().setRedraw(true);
            }

            if (realizedElements != null) {
                realizedElements.addAll(knownElementAdditions);
            }
            knownElements.removeAll(knownElementRemovals);
        }
    }

    /**
     * Constructs an ObservableListContentProvider
     */
    public ObservableListContentProvider(int patternMethodsNum, TableViewer tableViewer) {
        this(null);
        ObservableListContentProvider.patternMethodsCount = patternMethodsNum;
        ObservableListContentProvider.tableViewer = tableViewer;
    }

    /**
     * Constructs an ObservableListContentProvider with the given viewer updater
     * 
     * @param viewerUpdater
     *            the viewer updater to use when elements are added, removed,
     *            moved or replaced in the input observable list.
     * @since 1.3
     */
    public ObservableListContentProvider(IViewerUpdater viewerUpdater) {
        impl = new Impl(viewerUpdater);
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        impl.inputChanged(viewer, oldInput, newInput);
    }

    public Object[] getElements(Object inputElement) {
        return impl.getElements(inputElement);
    }

    public void dispose() {
        impl.dispose();
    }

    /**
     * Returns the set of elements known to this content provider. Label
     * providers may track this set if they need to be notified about additions
     * before the viewer sees the added element, and notified about removals
     * after the element was removed from the viewer. This is intended for use
     * by label providers, as it will always return the items that need labels.
     * 
     * @return readableSet of items that will need labels
     */
    public IObservableSet getKnownElements() {
        return impl.getKnownElements();
    }

    /**
     * Returns the set of known elements which have been realized in the viewer.
     * Clients may track this set in order to perform custom actions on elements
     * while they are known to be present in the viewer.
     * 
     * @return the set of known elements which have been realized in the viewer.
     * @since 1.3
     */
    public IObservableSet getRealizedElements() {
        return impl.getRealizedElements();
    }

    protected static int getAddIndexInTable(int index) {
        return index - patternMethodsCount;
    }

    private static int getIndexInTable(Object element) {
        TableItem[] items = tableViewer.getTable().getItems();
        for (int i = 0; i < items.length; i++) {
            Object data = items[i].getData();
            if (element.equals(data)) {
                return i;
            }
        }
        return 0;
    }

    private static int getMoveToIndexInTable(int index) {
        Object input = tableViewer.getInput();
        if (input instanceof EMFObservableListDecorator) {
            Object[] array = ((EMFObservableListDecorator) input).toArray();
            Object moveToItem = array[index - 1];
            int indexInTable = getIndexInTable(moveToItem);
            return indexInTable;
        }
        return 0;
    }
}
