/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package test.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import test.TestPackage;
import test.ValidationErrorSeverity;
import test.ValidationErrorTestResult;

/**
 * This is the item provider adapter for a {@link test.ValidationErrorTestResult} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ValidationErrorTestResultItemProvider
  extends TestResultItemProvider
  implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource {
  /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public ValidationErrorTestResultItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

  /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addSeverityPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

  /**
     * This adds a property descriptor for the Severity feature.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  protected void addSeverityPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_ValidationErrorTestResult_severity_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_ValidationErrorTestResult_severity_feature", "_UI_ValidationErrorTestResult_type"),
                 TestPackage.Literals.VALIDATION_ERROR_TEST_RESULT__SEVERITY,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

  /**
     * This returns ValidationErrorTestResult.gif.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ValidationErrorTestResult"));
    }

  /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public String getText(Object object) {
        ValidationErrorSeverity labelValue = ((ValidationErrorTestResult)object).getSeverity();
        String label = labelValue == null ? null : labelValue.toString();
        return label == null || label.length() == 0 ?
            getString("_UI_ValidationErrorTestResult_type") :
            getString("_UI_ValidationErrorTestResult_type") + " " + label;
    }

  /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(ValidationErrorTestResult.class)) {
            case TestPackage.VALIDATION_ERROR_TEST_RESULT__SEVERITY:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

  /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
