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
package org.eclipse.egf.common.ui.resource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * This class is a registry of ({@link ImageDescriptor}, {@link Image}).<br>
 * Using this registry avoid to allocate multiple images for the same image descriptor.
 * @author fournier
 */
public class BasicImageRegistry {
  /**
   * Singleton instance.
   */
  private static BasicImageRegistry __instance = new BasicImageRegistry();

  /**
   * Registry of (ImageDescriptor, Image) Flyweight pattern
   */
  private Map<ImageDescriptor, Image> _registry;

  /**
   * Private constructor to implement singleton pattern.
   */
  private BasicImageRegistry() {
    this(PlatformUI.getWorkbench().getDisplay());
  }

  /**
   * Constructor.<br>
   * If using this constructor DO NOT use the {@link #getInstance()} that returns a different instance (singleton).
   * @param display_p
   */
  public BasicImageRegistry(Display display_p) {
    _registry = new HashMap<ImageDescriptor, Image>(0);
    // Hook the display to dispose images contained in the registry when the display is disposed.
    hookDisplayDispose(display_p);
  }

  /**
   * Get the singleton instance of this registry.<br>
   * This instance is based on Platform display.
   * @return a not null instance.
   */
  public static BasicImageRegistry getInstance() {
    return __instance;
  }

  /**
   * Get an image for its given descriptor.
   * @param imageDescriptor_p
   * @return
   */
  public Image getImage(ImageDescriptor imageDescriptor_p) {
    Image result = null;
    // Get the related image in the registry.
    result = _registry.get(imageDescriptor_p);
    // If returned image is null, create it from given descriptor.
    if (null == result) {
      result = imageDescriptor_p.createImage();
      // Store it for next usage.
      _registry.put(imageDescriptor_p, result);
    }
    return result;
  }

  /**
   * Remove given image descriptor from the registry.
   * @param imageDescriptor_p
   * @return previous value associated with specified image descriptor, or <tt>null</tt> if there was no mapping for specified image descriptor. A
   *         <tt>null</tt> return can also indicate that the registry previously associated <tt>null</tt> with the specified image descriptor.
   */
  public Image remove(ImageDescriptor imageDescriptor_p) {
    return _registry.remove(imageDescriptor_p);
  }

  /**
   * Hook the display disposed event to be called back when this event is raised.<br>
   * The goal is to dispose all images contained in the registry.
   * @param display
   */
  protected void hookDisplayDispose(Display display) {
    display.disposeExec(new Runnable() {
      public void run() {
        handleDisplayDisposedEvent();
      }
    });
  }

  /**
   * Handle display disposed event to dispose all images contained in the registry.
   */
  protected void handleDisplayDisposedEvent() {
    // Get all entries.
    Iterator<Image> entries = _registry.values().iterator();
    while (entries.hasNext()) {
      // Get the current image
      Image currentImage = entries.next();
      // If allocated and not disposed, dispose it to free OS resource.
      if (null != currentImage && !currentImage.isDisposed()) {
        currentImage.dispose();
      }
    }
    // All images are now disposed, reset to null the registry.
    _registry.clear();
    _registry = null;
  }
}
