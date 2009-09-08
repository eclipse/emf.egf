/*******************************************************************************
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.eclipse.egf.core.ui.data.explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.egf.core.ui.data.explorer.adapter.Messages;
import org.eclipse.egf.core.ui.data.listener.IWorkingSetListener;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.ui.workingsets.OthersWorkingSetUpdater;
import org.eclipse.jdt.internal.ui.workingsets.WorkingSetModel;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.ILocalWorkingSetManager;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PlatformUI;


/**
 * @author Guillaume Brocard
 */
public class FactoryComponentWorkingSetManager implements IAdaptable, IPropertyChangeListener {
  /**
   * Used the JDT Other working set ID to get the icon resource
   */
  private static final String OTHER_PROJECTS_WORKING_SET_ID = "org.eclipse.jdt.ui.JavaWorkingSetPage"; //$NON-NLS-1$

  /**
   * Handled working set. Do not use a map because hashCode of IWorkingSet are based on working set name.<br>
   * Hence, when names changed, the Map.get(key) method fails...
   */
  private List<FactoryComponentWorkingSet> _workingSets;
  /**
   * List of the listeners to notify when changes occurred to working sets.
   */
  private List<IWorkingSetListener> _workingSetListeners;

  private ILocalWorkingSetManager _localWorkingSetManager;
  private FactoryComponentWorkingSet _otherFcs;

  /**
   * Constructor.
   * @param workingSetListener_p
   */
  public FactoryComponentWorkingSetManager() {
    // At least the Factory Component Explorer would be registered as a listener.
    _workingSetListeners = new ArrayList<IWorkingSetListener>(1);
  }

  /**
   * Dispose allocated resources, listeners,...
   */
  public void dispose() {
    // Dispose the local working set.
    if (null != _localWorkingSetManager) {
      _localWorkingSetManager.dispose();
      _localWorkingSetManager = null;
    }
  }

  /**
   * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
   */
  @SuppressWarnings("unchecked")
  public Object getAdapter(Class adapter_p) {
    return Platform.getAdapterManager().getAdapter(this, adapter_p);
  }

  /**
   * Get the working set manager registered for the workbench.
   * @return
   */
  protected IWorkingSetManager getWorkingsetManager() {
    IWorkbench workbench = PlatformUI.getWorkbench();
    IWorkingSetManager workingSetManager = workbench.getWorkingSetManager();
    return workingSetManager;
  }

  /**
   * Get all existing working sets in the workspace.
   * @return a shallow copy of the internal collection.
   */
  public synchronized Collection<FactoryComponentWorkingSet> getAllWorkingSets() {
    if (null == _workingSets) {
      // Get the available working sets from the workspace.
      IWorkingSetManager workingSetManager = getWorkingsetManager();
      IWorkingSet[] workingSets = workingSetManager.getWorkingSets();
      // If some working sets exist, create their equivalent in EGF world.
      if (workingSets.length > 0) {
        // Loop over platform working sets.
        for (int i = 0; i < workingSets.length; i++) {
          IWorkingSet currentWorkingSet = workingSets[i];
          // Add it.
          addWorkingSet(currentWorkingSet);
        }
      }
      // Create a local working set manager to handle the Other Projects working set as JDT does...
      _localWorkingSetManager = PlatformUI.getWorkbench().createLocalWorkingSetManager();
      IWorkingSet others = _localWorkingSetManager.createWorkingSet(Messages.FactoryComponentWorkingSetManager_OtherWorkingSet_Title, new IAdaptable[0]);
      others.setId(OTHER_PROJECTS_WORKING_SET_ID);
      _localWorkingSetManager.addWorkingSet(others);
      _otherFcs = addWorkingSet(others);
    }
    return new ArrayList<FactoryComponentWorkingSet>(_workingSets);
  }

  /**
   * Get all public working sets in the workspace.
   * @return a shallow copy of the internal collection.
   */
  public synchronized Collection<FactoryComponentWorkingSet> getPublicWorkingSets() {
    ArrayList<FactoryComponentWorkingSet> workingSets = new ArrayList<FactoryComponentWorkingSet>(_workingSets);
    workingSets.remove(_otherFcs);
    return workingSets;
  }

  /**
   * Update the public working sets order to follow the given collection.
   */
  public synchronized void updatePublicWorkingSetsOrder(List<IWorkingSet> upToDateWorkingSets_p) {
    List<FactoryComponentWorkingSet> upToDateFcWorkingSets = new ArrayList<FactoryComponentWorkingSet>(upToDateWorkingSets_p.size());
    Iterator<IWorkingSet> iter = upToDateWorkingSets_p.iterator();
    while (iter.hasNext()) {
      IWorkingSet currentWorkingSet = iter.next();
      FactoryComponentWorkingSet relatedFcWorkingSet = getFactoryComponentWorkingSet(currentWorkingSet);
      if (null != relatedFcWorkingSet) {
        upToDateFcWorkingSets.add(relatedFcWorkingSet);
      } else {
        // Is it the Other Project working set ?
        if (currentWorkingSet instanceof OthersWorkingSetUpdater) {
          upToDateFcWorkingSets.add(_otherFcs);
        } else {
          // Case a working set was hidden and now it is revealed again.
          FactoryComponentWorkingSet fcWorkingSet = new FactoryComponentWorkingSet(currentWorkingSet);
          upToDateFcWorkingSets.add(fcWorkingSet);
        }
      }
    }
    // Update internal list.
    _workingSets = upToDateFcWorkingSets;
  }

  /**
   * return the working set related to "Other Factory Components".
   * @return
   */
  public FactoryComponentWorkingSet getOtherFcsWorkingSet() {
    return _otherFcs;
  }

  /**
   * Add a working set in the internal map.
   * @param workingSet_p
   */
  private synchronized FactoryComponentWorkingSet addWorkingSet(IWorkingSet workingSet_p) {
    if (null == _workingSets) {
      _workingSets = new ArrayList<FactoryComponentWorkingSet>(1);
    }
    FactoryComponentWorkingSet fcWorkingSet = new FactoryComponentWorkingSet(workingSet_p);
    _workingSets.add(fcWorkingSet);
    return fcWorkingSet;
  }

  /**
   * Remove a working set from the internal map.
   * @param workingSet_p
   */
  private synchronized FactoryComponentWorkingSet removeWorkingSet(IWorkingSet workingSet_p) {
    FactoryComponentWorkingSet removedWorkingSet = null;
    if (null != _workingSets) {
      Iterator<FactoryComponentWorkingSet> iter = _workingSets.iterator();
      while (iter.hasNext() && (null == removedWorkingSet)) {
        FactoryComponentWorkingSet fcWorkingSet = iter.next();
        // the equals method compares references first
        if (workingSet_p.equals(fcWorkingSet.getWorkingSet())) {
          removedWorkingSet = fcWorkingSet;
          iter.remove();
        }
      }
    }
    return removedWorkingSet;
  }

  /**
   * Get the factory component working set for specified platform working set.
   * @return <code>null</code> if not found.
   */
  public synchronized FactoryComponentWorkingSet getFactoryComponentWorkingSet(IWorkingSet workingSet_p) {
    FactoryComponentWorkingSet result = null;
    if (null != _workingSets) {
      Iterator<FactoryComponentWorkingSet> iter = _workingSets.iterator();
      while (iter.hasNext() && (null == result)) {
        FactoryComponentWorkingSet fcWorkingSet = iter.next();
        // the equals method compares references first
        if (workingSet_p.equals(fcWorkingSet.getWorkingSet())) {
          result = fcWorkingSet;
        }
      }
    }
    return result;
  }

  /**
   * Add a working set listener.
   * @param listener_p
   */
  public void addWorkingSetListener(IWorkingSetListener listener_p) {
    _workingSetListeners.add(listener_p);
  }

  /**
   * Remove a working set listener.
   * @param listener_p
   */
  public void removeWorkingSetListener(IWorkingSetListener listener_p) {
    _workingSetListeners.remove(listener_p);
  }

  /**
   * Notify received working set events to registered listeners.
   * @param notifier_p
   */
  private void notifyListeners(Notifier notifier_p) {
    for (Iterator<IWorkingSetListener> iter = _workingSetListeners.iterator(); iter.hasNext();) {
      notifier_p.setListener(iter.next());
      notifier_p.run();
    }
  }

  /**
   * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
   */
  public void propertyChange(PropertyChangeEvent event_p) {
    String property = event_p.getProperty();
    if (IWorkingSetManager.CHANGE_WORKING_SET_CONTENT_CHANGE.equals(property)) {
      IWorkingSet workingSet = (IWorkingSet) event_p.getNewValue();
      handleWorkingSetContentChanged(workingSet, event_p);
    } else if (IWorkingSetManager.CHANGE_WORKING_SET_REMOVE.equals(property)) {
      IWorkingSet workingSet = (IWorkingSet) event_p.getOldValue();
      handleWorkingSetRemoved(workingSet, event_p);
    } else if (IWorkingSetManager.CHANGE_WORKING_SET_ADD.equals(property)) {
      IWorkingSet workingSet = (IWorkingSet) event_p.getNewValue();
      handleWorkingSetAdded(workingSet, event_p);
    } else if (IWorkingSetManager.CHANGE_WORKING_SET_NAME_CHANGE.equals(property)) {
      IWorkingSet workingSet = (IWorkingSet) event_p.getNewValue();
      handleWorkingSetNameChanged(workingSet, event_p);
    } else if (IWorkingSetManager.CHANGE_WORKING_SET_LABEL_CHANGE.equals(property)) {
      IWorkingSet workingSet = (IWorkingSet) event_p.getNewValue();
      handleWorkingSetLabelChanged(workingSet, event_p);
    } else if (WorkingSetModel.CHANGE_WORKING_SET_MODEL_CONTENT.equals(property)) {
      // Specific event sent by Package Explorer when working sets change: working sets order, content and so...
      // Get the new active working set from the Package Explorer.
      handleWorkingSetModelContentChanged(event_p);
    }
  }

  /**
   * Handle Package Explorer working set model changed.
   * @param event_p
   */
  protected void handleWorkingSetModelContentChanged(final PropertyChangeEvent event_p) {
    // Notify received event.
    notifyListeners(new Notifier() {
      public void run() {
        getListener().workingSetModelChanged(event_p);
      }
    });
  }

  /**
   * Handle working set added.
   * @param workingSet_p
   * @param event_p
   */
  protected void handleWorkingSetAdded(IWorkingSet workingSet_p, final PropertyChangeEvent event_p) {
    final FactoryComponentWorkingSet addedWorkingSet = addWorkingSet(workingSet_p);
    // Notify received event.
    notifyListeners(new Notifier() {
      public void run() {
        getListener().workingSetAdded(addedWorkingSet, event_p);
      }
    });
  }

  /**
   * Handle working set content changed.
   * @param workingSet_p
   * @param event_p
   */
  protected void handleWorkingSetContentChanged(IWorkingSet workingSet_p, final PropertyChangeEvent event_p) {
    final FactoryComponentWorkingSet modifiedWorkingSet = getFactoryComponentWorkingSet(workingSet_p);
    if (null != modifiedWorkingSet) {
      // Notify received event.
      notifyListeners(new Notifier() {
        public void run() {
          getListener().workingSetContentChanged(modifiedWorkingSet, event_p);
        }
      });
    }
  }

  /**
   * Handle working set label changed.
   * @param workingSet_p
   * @param event_p
   */
  protected void handleWorkingSetLabelChanged(IWorkingSet workingSet_p, final PropertyChangeEvent event_p) {
    final FactoryComponentWorkingSet modifiedWorkingSet = getFactoryComponentWorkingSet(workingSet_p);
    // Notify received event.
    notifyListeners(new Notifier() {
      public void run() {
        getListener().workingSetLabelChanged(modifiedWorkingSet, event_p);
      }
    });
  }

  /**
   * Handle working set name changed.
   * @param workingSet_p
   * @param event_p
   */
  protected void handleWorkingSetNameChanged(IWorkingSet workingSet_p, final PropertyChangeEvent event_p) {
    final FactoryComponentWorkingSet modifiedWorkingSet = getFactoryComponentWorkingSet(workingSet_p);
    // Notify received event.
    notifyListeners(new Notifier() {
      public void run() {
        getListener().workingSetNameChanged(modifiedWorkingSet, event_p);
      }
    });
  }

  /**
   * Handle working set removed.
   * @param workingSet_p
   * @param event_p
   */
  protected void handleWorkingSetRemoved(IWorkingSet workingSet_p, final PropertyChangeEvent event_p) {
    final FactoryComponentWorkingSet removedWorkingSet = removeWorkingSet(workingSet_p);
    // Notify received event.
    notifyListeners(new Notifier() {
      public void run() {
        getListener().workingSetRemoved(removedWorkingSet, event_p);
      }
    });
  }

  /**
   * Inner class to ease notifications.
   * @author Guillaume Brocard
   */
  abstract class Notifier implements Runnable {
    private IWorkingSetListener _listener;

    /**
     * Set the listener used by the run implementation methods.
     * @param listener_p
     */
    public void setListener(IWorkingSetListener listener_p) {
      _listener = listener_p;
    }

    /**
     * Get the listener.
     * @return the listener
     */
    protected IWorkingSetListener getListener() {
      return _listener;
    }
  }

  /**
   * Get the parent working set of specified object
   * @param project_p
   * @return <code>null</code> if not found.
   */
  public FactoryComponentWorkingSet getParent(IProject project_p) {
    FactoryComponentWorkingSet result = null;
    // Iterate over all working sets to find out the parent of given objects.
    Iterator<FactoryComponentWorkingSet> allWorkingSets = getAllWorkingSets().iterator();
    while (allWorkingSets.hasNext() && (null == result)) {
      FactoryComponentWorkingSet currentFcWorkingSet = allWorkingSets.next();
      // Get elements contained in related workspace working set.
      IAdaptable[] elements = currentFcWorkingSet.getWorkingSet().getElements();
      if (FactoryComponentWorkingSetManager.getProjects(elements).contains(project_p)) {
        result = currentFcWorkingSet;
      }
    }
    // No working set found containing specified project, it may be the Other Projects the container hence let's return the "Other FCs" working set.
    if (null == result) {
      result = getOtherFcsWorkingSet();
    }
    return result;
  }

  /**
   * Get projects from specified elements.
   * @param elements_p
   * @return a not null list.
   */
  public static List<IProject> getProjects(IAdaptable[] elements_p) {
    List<IProject> projects = new ArrayList<IProject>(0);
    for (int i = 0; i < elements_p.length; i++) {
      IAdaptable adaptable = elements_p[i];
      if (adaptable instanceof IJavaProject) {
        projects.add(((IJavaProject) adaptable).getProject());
      }
    }
    return projects;
  }
}