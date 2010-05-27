/**
 * <copyright>
 * 
 * Copyright (c) 2002-2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM - Initial API and implementation
 * 
 * </copyright>
 * 
 * $Id: InitializeCopyCommand.java,v 1.9 2007/09/28 19:37:46 emerks Exp $
 */
package org.eclipse.egf.model.fcore.commands;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.command.CopyCommand;
import org.eclipse.emf.edit.command.InitializeCopyCommand;
import org.eclipse.emf.edit.command.OverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * The initialize copy command is implemented to set the values of an object copy based on those
 * of the original (copied) object. It is a helper command used by the CopyCommand.
 * 
 * <p>
 * An initialize copy command is an {@link OverrideableCommand}.
 */
public class FcoreInitializeCopyCommand extends InitializeCopyCommand {

  /**
   * This constructs an instance that will copy the attribute values of value to those of owner.
   */
  public FcoreInitializeCopyCommand(EditingDomain domain, EObject owner, CopyCommand.Helper copyHelper) {
    super(domain, owner, copyHelper);
  }

  @Override
  protected boolean prepare() {
    return owner.eClass().isInstance(copy);
  }

  @Override
  public void doExecute() {
    copyAttributes();
    copyReferences();
  }

  @Override
  protected Collection<? extends EAttribute> getAttributesToCopy() {
    return owner.eClass().getEAllAttributes();
  }

  /**
   * This method will iterate over the attributes of the owner object and set them
   * accordingly in the copy.
   */
  @Override
  protected void copyAttributes() {
    for (EAttribute attribute : getAttributesToCopy()) {
      if (attribute.isChangeable() && !attribute.isDerived() && (attribute.isMany() || owner.eIsSet(attribute))) {
        Object value = owner.eGet(attribute);
        if (!attribute.isMany()) {
          copy.eSet(attribute, value);
        } else {
          @SuppressWarnings("unchecked")
          List<Object> list = (List<Object>) copy.eGet(attribute);
          if (FeatureMapUtil.isFeatureMap(attribute)) {
            FeatureMap featureMap = (FeatureMap) (List<?>) list;
            LOOP: for (FeatureMap.Entry entry : (FeatureMap) value) {
              EStructuralFeature entryFeature = entry.getEStructuralFeature();
              if (entryFeature instanceof EAttribute) {
                featureMap.add(entry);
              } else {
                EReference reference = (EReference) entryFeature;
                EReference reverseReference = reference.getEOpposite();
                Object entryValue = entry.getValue();
                boolean copiedTargetRequired = reverseReference != null || reference.isContainment();
                EObject target = copyHelper.getCopyTarget((EObject) entryValue, copiedTargetRequired);
                if (target != null) {
                  if (reverseReference != null) {
                    for (FeatureMap.Entry copyEntry : featureMap) {
                      if (copyEntry.getEStructuralFeature() == reference && copyEntry.getValue() == target) {
                        featureMap.move(featureMap.size() - 1, copyEntry);
                        continue LOOP;
                      }
                    }
                  }
                  featureMap.add(reference, target);
                }
              }
            }
          } else {
            list.addAll((List<?>) value);
          }
        }
      }
    }
  }

  @Override
  protected Collection<? extends EReference> getReferencesToCopy() {
    return owner.eClass().getEAllReferences();
  }

  /**
   * This method will iterate over the references of the owner object and sets them.
   * accordingly in the copy.
   */
  @Override
  protected void copyReferences() {
    for (EReference reference : getReferencesToCopy()) {
      if (!reference.isChangeable() || reference.isDerived() || !owner.eIsSet(reference)) {
        continue;
      }

      EReference reverseReference = reference.getEOpposite();

      Object value = owner.eGet(reference);
      if (value == null) {
        // It must be an unsettable feature to be null and considered set.
        //
        copy.eSet(reference, null);
        continue;
      }

      boolean copiedTargetRequired = reverseReference != null || reference.isContainment();
      if (reference.isMany()) {
        @SuppressWarnings("unchecked")
        List<EObject> valueList = (List<EObject>) value;
        @SuppressWarnings("unchecked")
        EList<EObject> copyList = (EList<EObject>) copy.eGet(reference);
        if (valueList.isEmpty()) {
          // It must be an unsettable feature to be empty and considered set.
          //
          copyList.clear();
        } else {
          int index = 0;
          for (EObject item : valueList) {
            EObject target = copyHelper.getCopyTarget(item, copiedTargetRequired);
            if (target == null)
              break; // if one is null, they'll all be null
            if (reverseReference != null) {
              int position = copyList.indexOf(target);
              if (position == -1) {
                copyList.add(index, target);
              } else {
                copyList.move(index, target);
              }
            } else {
              copyList.add(target);
            }
            ++index;
          }
        }
      } else {
        EObject target = copyHelper.getCopyTarget((EObject) value, copiedTargetRequired);
        if (target != null) {
          copy.eSet(reference, target);
        }
      }
    }
  }

}
