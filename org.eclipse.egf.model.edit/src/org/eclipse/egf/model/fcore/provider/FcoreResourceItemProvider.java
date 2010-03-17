/**
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.model.fcore.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.edit.EGFModelEditPlugin;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.commands.ResourceAddCommand;
import org.eclipse.egf.model.fcore.commands.ResourceFeatureAddCommand;
import org.eclipse.egf.model.fcore.commands.ResourceMoveCommand;
import org.eclipse.egf.model.fcore.commands.ResourceRemoveCommand;
import org.eclipse.egf.model.fcore.util.FcoreResourceImpl;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.emf.edit.provider.resource.ResourceItemProvider;

/**
 * @author Xavier Maysonnave
 * 
 */
public class FcoreResourceItemProvider extends ResourceItemProvider {

  protected ResourceChildCreationExtenderManager _resourceExtenderManager;

  protected Collection<EClass> _roots;

  /**
   * This constructs an instance from a factory and a notifier.
   */
  public FcoreResourceItemProvider(AdapterFactory adapterFactory, ResourceChildCreationExtenderManager resourceExtenderManager) {
    super(adapterFactory);
    _resourceExtenderManager = resourceExtenderManager;
  }

  public Collection<EClass> getRoots() {
    if (_roots == null) {
      _roots = new UniqueEList<EClass>();
      _roots.add(FcorePackage.Literals.FACTORY_COMPONENT);
      // Add roots defined by extenders
      _roots.addAll(_resourceExtenderManager.getRoots());
    }
    return _roots;
  }

  @Override
  public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain, Object sibling) {
    // Resource
    FcoreResourceImpl resource = (FcoreResourceImpl) object;
    // Build the collection of new child descriptors.
    Collection<Object> newChildDescriptors = new ArrayList<Object>();
    collectNewChildDescriptors(newChildDescriptors, object);
    // Add child descriptors contributed by extenders.
    if (adapterFactory instanceof IChildCreationExtender) {
      newChildDescriptors.addAll(((IChildCreationExtender) adapterFactory).getNewChildDescriptors(object, editingDomain));
    }
    // If a sibling has been specified, add the best index possible to each CommandParameter.
    if (sibling != null) {
      // Unwrap
      sibling = unwrap(sibling);
      // Find the index of the sibling.
      Collection<EObject> children = resource.getContents();
      // For each CommandParameter with a non-null, multi-valued structural feature...
      int i = 0;
      DESCRIPTORS_LOOP: for (Object descriptor : newChildDescriptors) {
        if (descriptor instanceof CommandParameter) {
          CommandParameter parameter = (CommandParameter) descriptor;
          // Look for the sibling value or an equivalent in the new child's feature.
          // If it is found, the child should immediately follow it.
          i = 0;
          for (Object innerObject : children) {
            if (isEquivalentValue(sibling, innerObject)) {
              parameter.index = i + 1;
              continue DESCRIPTORS_LOOP;
            }
            ++i;
          }
        }
      }
    }
    return newChildDescriptors;
  }

  /**
   * This adds to <code>newChildDescriptors</code>, a collection of new child
   * descriptors. Typically, {@link org.eclipse.emf.edit.command.CommandParameter}s
   * will be used as descriptors. This implementation adds nothing to the
   * collection, but derived classes should override this method, invoking the
   * superclass implementation and then adding to the collection.
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
    newChildDescriptors.add(createChildParameter(FcorePackage.Literals.FACTORY_COMPONENT, FcoreFactory.eINSTANCE.createFactoryComponent()));
  }

  /**
   * This is a convenience method that creates a <code>CommandParameter</code>
   * for a given parent feature and child object.
   */
  @Override
  protected CommandParameter createChildParameter(Object feature, Object child) {
    return new CommandParameter(null, feature, child);
  }

  /**
   * This returns the label text for the adapted class.
   */
  @Override
  public String getText(Object object) {
    Resource resource = (Resource) object;
    StringBuffer buffer = new StringBuffer(resource.getURI() == null ? "" : URI.decode(resource.getURI().toString())); //$NON-NLS-1$
    IPlatformFcore fc = EGFCorePlugin.getPlatformFcore(resource);
    if (fc != null) {
      if (fc.getPlatformBundle().isTarget()) {
        buffer.append(" [Target]"); //$NON-NLS-1$
      } else {
        buffer.append(" [Workspace]"); //$NON-NLS-1$
      }
      buffer.append(" ["); //$NON-NLS-1$
      buffer.append(fc.getPlatformBundle().getBundleLocation());
      buffer.append("]"); //$NON-NLS-1$
    }
    return buffer.toString();
  }

  /**
   * This returns Fcore.gif.
   */
  @Override
  public Object getImage(Object object) {
    return URI.createURI(EGFModelEditPlugin.INSTANCE.getPluginResourceLocator().getImage("full/obj16/Fcore").toString()); //$NON-NLS-1$
  }

  /**
   * Return the resource locator for this item provider's resources.
   */
  @Override
  public ResourceLocator getResourceLocator() {
    return ((IChildCreationExtender) adapterFactory).getResourceLocator();
  }

  /**
   * This implements delegated command creation for the given object.
   */
  @Override
  public Command createCommand(Object object, EditingDomain domain, Class<? extends Command> commandClass, CommandParameter commandParameter) {
    // Commands should operate on the values, not their wrappers. If the command's values needed to be unwrapped,
    // we'll back get a new CommandParameter.
    CommandParameter oldCommandParameter = commandParameter;
    commandParameter = unwrapCommandValues(commandParameter, commandClass);
    Command result = UnexecutableCommand.INSTANCE;
    if (commandParameter.owner instanceof FcoreResourceImpl) {
      if (commandClass == RemoveCommand.class) {
        result = createRemoveCommand(domain, (FcoreResourceImpl) commandParameter.owner, commandParameter.getCollection());
      } else if (commandClass == AddCommand.class) {
        result = createAddCommand(domain, (FcoreResourceImpl) commandParameter.owner, commandParameter.getCollection(), commandParameter.getIndex());
      } else if (commandClass == MoveCommand.class) {
        result = createMoveCommand(domain, (FcoreResourceImpl) commandParameter.owner, commandParameter.getValue(), commandParameter.getIndex());
      } else if (commandClass == CreateChildCommand.class) {
        CommandParameter newChildParameter = (CommandParameter) commandParameter.getValue();
        result = createCreateChildCommand(domain, (FcoreResourceImpl) commandParameter.owner, newChildParameter.getEStructuralFeature(), newChildParameter.getValue(), newChildParameter.getIndex(), commandParameter.getCollection());
      } else {
        return super.createCommand(object, domain, commandClass, commandParameter);
      }
    } else {
      return super.createCommand(object, domain, commandClass, commandParameter);
    }
    // If necessary, get a command that replaces unwrapped values by their wrappers in the result and affected objects.
    return wrapCommand(result, object, commandClass, commandParameter, oldCommandParameter);
  }

  /**
   * This creates a primitive {@link org.eclipse.emf.edit.command.RemoveCommand}.
   */
  protected Command createRemoveCommand(EditingDomain domain, FcoreResourceImpl resource, Collection<?> collection) {
    return new ResourceRemoveCommand(domain, resource, collection);
  }

  /**
   * This creates a primitive {@link org.eclipse.emf.edit.command.AddCommand}.
   */
  protected Command createAddCommand(EditingDomain domain, FcoreResourceImpl resource, Collection<?> collection, int index) {
    boolean isValid = true;
    Collection<EClass> roots = getRoots();
    for (Object object : collection) {
      if (object instanceof EObject) {
        EObject eObject = (EObject) object;
        if (roots.contains(EMFHelper.solveAgainstStaticPackage(eObject.eClass())) == false) {
          isValid = false;
          break;
        }
      }
    }
    if (isValid) {
      return new ResourceAddCommand(domain, resource, collection, index);
    }
    return UnexecutableCommand.INSTANCE;
  }

  /**
   * This creates a primitive {@link org.eclipse.emf.edit.command.MoveCommand}.
   */
  protected Command createMoveCommand(EditingDomain domain, FcoreResourceImpl resource, Object value, int index) {
    if (value instanceof EObject) {
      Collection<EClass> roots = getRoots();
      EObject eObject = (EObject) value;
      if (roots.contains(EMFHelper.solveAgainstStaticPackage(eObject.eClass()))) {
        return new ResourceMoveCommand(domain, resource, value, index);
      }
    }
    return UnexecutableCommand.INSTANCE;
  }

  /**
   * This creates a primitive {@link org.eclipse.emf.edit.command.CreateChildCommand}.
   */
  protected Command createCreateChildCommand(EditingDomain domain, FcoreResourceImpl resource, EStructuralFeature feature, Object value, int index, Collection<?> collection) {
    if (collection != null && collection.size() == 1) {
      Object object = collection.iterator().next();
      if (object instanceof EObject) {
        Collection<EClass> roots = getRoots();
        EObject eObject = (EObject) object;
        if (roots.contains(EMFHelper.solveAgainstStaticPackage(eObject.eClass()))) {
          return new ResourceFeatureAddCommand(domain, resource, feature, value, resource.getContents().indexOf(eObject) == CommandParameter.NO_INDEX ? CommandParameter.NO_INDEX : resource.getContents().indexOf(eObject) + 1);
        }
      }
    }
    return UnexecutableCommand.INSTANCE;
  }

  /**
   * This handles notification by calling {@link #fireNotifyChanged(Notification) fireNotifyChanged}.
   */
  @Override
  public void notifyChanged(Notification notification) {
    switch (notification.getFeatureID(Resource.class)) {
    case Resource.RESOURCE__URI:
    case Resource.RESOURCE__IS_MODIFIED:
    case Resource.RESOURCE__IS_LOADED:
      // case Resource.RESOURCE__IS_TRACKING_MODIFICATION:
    case Resource.RESOURCE__RESOURCE_SET: {
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
      return;
    }
      // When an object is controlled, the only change will be in the new resource's contents, so it must
      // refresh the whole viewer to hit the object's label.
      //
    case Resource.RESOURCE__CONTENTS: {
      fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
      return;
    }
    }
    super.notifyChanged(notification);
  }

}
