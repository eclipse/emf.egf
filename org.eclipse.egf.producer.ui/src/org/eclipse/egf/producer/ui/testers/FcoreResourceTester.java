/**
 * Copyright (c) THALES, 2007. All rights reserved.
 */
package org.eclipse.egf.producer.ui.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.helper.ResourceHelper;
import org.eclipse.egf.producer.ui.EGFProducerUIPlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcoreResourceTester extends PropertyTester {

  /**
   * Test property of Fcore
   */
  public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
    if (receiver instanceof IFile) {
      IFile file = (IFile) receiver;
      if ("fcoreResource".equals(property)) { //$NON-NLS-1$
        if ("fcore".equals(file.getFileExtension())) { //$NON-NLS-1$
          // Load this IFile as an EMF Resource
          try {
            ResourceSet resourceSet = new ResourceSetImpl();
            Resource resource = ResourceHelper.loadResource(resourceSet, file);
            if (EGFCorePlugin.getPlatformFcore(resource) != null) {
              return true;
            }
          } catch (Throwable t) {
            EGFProducerUIPlugin.getDefault().logError(t);
          }
        }
      }
    }
    return false;
  }

}
