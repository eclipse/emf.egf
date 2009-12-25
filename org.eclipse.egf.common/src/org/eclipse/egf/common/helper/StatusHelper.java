/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 * 
 */

package org.eclipse.egf.common.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.common.EGFCommonPlugin;

public class StatusHelper {

  private StatusHelper() {
    // Prevent Instantiation
  }

  /**
   * 
   * Utility method for creating status.
   * 
   * @param severity
   * @param message
   * @param exception
   * @return {@link IStatus}
   */
  public static IStatus newStatus(int severity, String message, Throwable exception) {
    String statusMessage = message;
    if (message == null || message.trim().length() == 0) {
      if (exception == null) {
        throw new IllegalArgumentException();
      } else if (exception.getMessage() == null) {
        statusMessage = exception.toString();
      } else {
        statusMessage = exception.getMessage();
      }
    }
    return new Status(severity, EGFCommonPlugin.getDefault().getPluginID(), severity, statusMessage, exception);
  }

  /**
   * 
   * Utility method for creating status.
   */
  protected static IStatus newStatus(String pluginID, IStatus[] stati, String message, Throwable exception) {
    if (message == null || message.trim().length() == 0) {
      throw new IllegalArgumentException();
    }
    return new MultiStatus(pluginID != null && pluginID.trim().length() > 0 ? pluginID : EGFCommonPlugin.getDefault().getPluginID(), IStatus.ERROR, stati, message, exception);
  }

  /**
   * 
   * Utility method for creating status.
   */
  public static IStatus newStatus(String pluginID, int severity, String message, Throwable exception) {
    String statusMessage = message;
    if (message == null || message.trim().length() == 0) {
      if (exception == null) {
        throw new IllegalArgumentException();
      } else if (exception.getMessage() == null) {
        statusMessage = exception.toString();
      } else {
        statusMessage = exception.getMessage();
      }
    }
    return new Status(severity, pluginID != null && pluginID.trim().length() > 0 ? pluginID : EGFCommonPlugin.getDefault().getPluginID(), severity, statusMessage, exception);
  }

  /**
   * 
   * Utility method for creating status.
   */
  public static IStatus newStatus(String pluginID, List<IStatus> children, String message, Throwable exception) {
    List<IStatus> flatStatusCollection = new ArrayList<IStatus>();
    Iterator<IStatus> iter = children.iterator();
    while (iter.hasNext()) {
      IStatus currentStatus = iter.next();
      Iterator<IStatus> childrenIter = flatten(currentStatus).iterator();
      while (childrenIter.hasNext()) {
        flatStatusCollection.add(childrenIter.next());
      }
    }
    IStatus[] stati = new IStatus[flatStatusCollection.size()];
    flatStatusCollection.toArray(stati);
    return newStatus(pluginID, stati, message, exception);
  }

  /**
   * Answer a flat collection of the passed status and its recursive children
   */
  protected static List<IStatus> flatten(IStatus aStatus) {
    List<IStatus> result = new ArrayList<IStatus>();
    if (aStatus.isMultiStatus()) {
      IStatus[] children = aStatus.getChildren();
      for (int i = 0; i < children.length; i++) {
        IStatus currentChild = children[i];
        if (currentChild.isMultiStatus()) {
          Iterator<IStatus> childStatiiEnum = flatten(currentChild).iterator();
          while (childStatiiEnum.hasNext()) {
            result.add(childStatiiEnum.next());
          }
        } else {
          result.add(currentChild);
        }
      }
    } else {
      result.add(aStatus);
    }
    return result;
  }

}
