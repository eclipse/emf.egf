/**
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.core.ui.dialogs;

import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jdt.internal.ui.JavaUIMessages;
import org.eclipse.jdt.internal.ui.viewsupport.BasicElementLabels;
import org.eclipse.jdt.internal.ui.viewsupport.JavaElementImageProvider;
import org.eclipse.jdt.ui.JavaElementImageDescriptor;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

public class TypeNameMatchLabelProvider extends LabelProvider {

  public static final int SHOW_FULLYQUALIFIED = 0x01;

  public static final int SHOW_PACKAGE_POSTFIX = 0x02;

  public static final int SHOW_PACKAGE_ONLY = 0x04;

  public static final int SHOW_ROOT_POSTFIX = 0x08;

  public static final int SHOW_TYPE_ONLY = 0x10;

  public static final int SHOW_TYPE_CONTAINER_ONLY = 0x20;

  public static final int SHOW_POST_QUALIFIED = 0x40;

  public static String getTypeContainerName(IType type) {
    IType outerType = type.getDeclaringType();
    if (outerType != null) {
      return outerType.getFullyQualifiedName('.');
    }
    return type.getPackageFragment().getElementName();
  }

  public static IPackageFragmentRoot getPackageFragmentRoot(IType type) {
    return (IPackageFragmentRoot) type.getAncestor(IJavaElement.PACKAGE_FRAGMENT_ROOT);
  }

  private int fFlags;

  public TypeNameMatchLabelProvider(int flags) {
    fFlags = flags;
  }

  /**
   * non java-doc
   * 
   * @see ILabelProvider#getText
   */
  @Override
  public String getText(Object element) {
    if (element instanceof IType == false)
      return super.getText(element);

    return getText((IType) element, fFlags);
  }

  /*
   * non java-doc
   * 
   * @see ILabelProvider#getImage
   */
  @Override
  public Image getImage(Object element) {
    if (element instanceof IType == false)
      return super.getImage(element);
    return getImage((IType) element, fFlags);
  }

  private static boolean isSet(int flag, int flags) {
    return (flags & flag) != 0;
  }

  private static String getPackageName(String packName) {
    if (packName.length() == 0) {
      return JavaUIMessages.TypeInfoLabelProvider_default_package;
    }
    return packName;
  }

  public static String getText(IType type, int flags) {
    StringBuffer buf = new StringBuffer();
    if (isSet(SHOW_TYPE_ONLY, flags)) {
      buf.append(type.getElementName());
    } else if (isSet(SHOW_TYPE_CONTAINER_ONLY, flags)) {
      String containerName = getTypeContainerName(type);
      buf.append(getPackageName(containerName));
    } else if (isSet(SHOW_PACKAGE_ONLY, flags)) {
      String packName = type.getPackageFragment().getElementName();
      buf.append(getPackageName(packName));
    } else {
      if (isSet(SHOW_FULLYQUALIFIED, flags)) {
        buf.append(type.getFullyQualifiedName());
      } else if (isSet(SHOW_POST_QUALIFIED, flags)) {
        buf.append(type.getElementName());
        String containerName = getTypeContainerName(type);
        if (containerName != null && containerName.length() > 0) {
          buf.append(JavaElementLabels.CONCAT_STRING);
          buf.append(containerName);
        }
      } else {
        buf.append(type.getTypeQualifiedName());
      }

      if (isSet(SHOW_PACKAGE_POSTFIX, flags)) {
        buf.append(JavaElementLabels.CONCAT_STRING);
        String packName = type.getPackageFragment().getElementName();
        buf.append(getPackageName(packName));
      }
    }
    if (isSet(SHOW_ROOT_POSTFIX, flags)) {
      buf.append(JavaElementLabels.CONCAT_STRING);
      IPackageFragmentRoot root = getPackageFragmentRoot(type);
      JavaElementLabels.getPackageFragmentRootLabel(root, JavaElementLabels.ROOT_QUALIFIED, buf);
    }
    return BasicElementLabels.getJavaElementName(buf.toString());
  }

  public static ImageDescriptor getImageDescriptor(IType type, int flags) {
    if (isSet(SHOW_TYPE_CONTAINER_ONLY, flags)) {
      if (type.getPackageFragment().getElementName().equals(getTypeContainerName(type)))
        return JavaPluginImages.DESC_OBJS_PACKAGE;

      // XXX cannot check outer type for interface efficiently (5887)
      return JavaPluginImages.DESC_OBJS_CLASS;

    } else if (isSet(SHOW_PACKAGE_ONLY, flags)) {
      return JavaPluginImages.DESC_OBJS_PACKAGE;
    } else {
      boolean isInner = getTypeContainerName(type).indexOf('.') != -1;
      int modifiers = -1;
      try {
        modifiers = type.getFlags();
      } catch (JavaModelException jme) {
        EGFCoreUIPlugin.getDefault().logError(jme);
      }
      ImageDescriptor desc = JavaElementImageProvider.getTypeImageDescriptor(isInner, false, modifiers, false);
      int adornmentFlags = 0;
      if (Flags.isFinal(modifiers)) {
        adornmentFlags |= JavaElementImageDescriptor.FINAL;
      }
      if (Flags.isAbstract(modifiers) && !Flags.isInterface(modifiers)) {
        adornmentFlags |= JavaElementImageDescriptor.ABSTRACT;
      }
      if (Flags.isStatic(modifiers)) {
        adornmentFlags |= JavaElementImageDescriptor.STATIC;
      }
      if (Flags.isDeprecated(modifiers)) {
        adornmentFlags |= JavaElementImageDescriptor.DEPRECATED;
      }
      return new JavaElementImageDescriptor(desc, adornmentFlags, JavaElementImageProvider.BIG_SIZE);
    }
  }

  public static Image getImage(IType type, int flags) {
    return JavaPlugin.getImageDescriptorRegistry().get(getImageDescriptor(type, flags));
  }

}
