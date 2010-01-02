/**
 * Copyright (c) 2000, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * IBM Corporation - initial API and implementation
 */
package org.eclipse.egf.core.ui.dialogs;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.ui.helper.ThrowableHandler;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.ui.EGFCoreUIPlugin;
import org.eclipse.egf.core.ui.l10n.CoreUIMessages;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.internal.corext.util.TypeFilter;
import org.eclipse.jdt.internal.ui.JavaUIMessages;
import org.eclipse.jdt.internal.ui.preferences.TypeFilterPreferencePage;
import org.eclipse.jdt.internal.ui.search.JavaSearchQuery;
import org.eclipse.jdt.internal.ui.search.JavaSearchResult;
import org.eclipse.jdt.internal.ui.search.JavaSearchScopeFactory;
import org.eclipse.jdt.internal.ui.viewsupport.BasicElementLabels;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.IVMInstallType;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.jdt.ui.dialogs.ITypeInfoFilterExtension;
import org.eclipse.jdt.ui.dialogs.ITypeInfoImageProvider;
import org.eclipse.jdt.ui.dialogs.TypeSelectionExtension;
import org.eclipse.jdt.ui.search.PatternQuerySpecification;
import org.eclipse.jdt.ui.search.QuerySpecification;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.PreferencesUtil;

public class TypeSelectionDialog extends FilteredItemsSelectionDialog {

  private static final String DIALOG_SETTINGS = "org.eclipse.egf.core.ui.dialogs.TypeSelectionDialog"; //$NON-NLS-1$

  private IProject _project;

  private Class<?> _clazz;

  private final TypeInfoUtil _infoUtil;

  private int _filterVersion = 0;

  private TypeItemsFilter _filter;

  private final ITypeInfoFilterExtension _filterExtension;

  public static boolean isLowerCase(char ch) {
    return Character.toLowerCase(ch) == ch;
  }

  private class TypeSelectionHistory extends SelectionHistory {
    public TypeSelectionHistory() {
      super();
    }

    @Override
    protected Object restoreItemFromMemento(IMemento memento) {
      return null;
    }

    @Override
    protected void storeItemToMemento(Object item, IMemento element) {
      // Nothing to do
    }

  }

  /**
   * Replaces functionality of {@link org.eclipse.ui.dialogs.SearchPattern} with an
   * adapter implementation that delegates to {@link TypeInfoFilter}.
   */
  private static class TypeSearchPattern extends org.eclipse.ui.dialogs.SearchPattern {

    private String fPattern;

    @Override
    public void setPattern(String stringPattern) {
      fPattern = stringPattern;
    }

    @Override
    public String getPattern() {
      return fPattern;
    }
  }

  private class TypeFiltersPreferencesAction extends Action {

    public TypeFiltersPreferencesAction() {
      super(JavaUIMessages.FilteredTypesSelectionDialog_TypeFiltersPreferencesAction_label);
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run() {
      String typeFilterID = TypeFilterPreferencePage.TYPE_FILTER_PREF_PAGE_ID;
      PreferencesUtil.createPreferenceDialogOn(getShell(), typeFilterID, new String[] { typeFilterID }, null).open();
      triggerSearch();
    }
  }

  private class TypeItemsFilter extends ItemsFilter {

    private final int _MyFilterVersion = _filterVersion;

    private final TypeInfoFilter _infoFilter;

    public TypeItemsFilter(ITypeInfoFilterExtension extension) {
      super(new TypeSearchPattern());
      _infoFilter = new TypeInfoFilter(patternMatcher.getPattern(), extension);
    }

    @Override
    public boolean matchItem(Object item) {
      IType type = (IType) item;
      return _infoFilter.matchesHistoryElement(type);
    }

    @Override
    public boolean isConsistentItem(Object item) {
      return true;
    }

    public int getMyFilterVersion() {
      return _MyFilterVersion;
    }

    @Override
    public boolean isSubFilter(ItemsFilter filter) {
      if (filter instanceof TypeItemsFilter == false) {
        return false;
      }
      TypeItemsFilter typeItemsFilter = (TypeItemsFilter) filter;
      if (_MyFilterVersion != typeItemsFilter.getMyFilterVersion()) {
        return false;
      }
      // Caveat: This method is defined the wrong way 'round in FilteredItemsSelectionDialog!
      // WRONG (has reverse meaning!): return fTypeInfoFilter.isSubFilter(filter.getPattern());
      return typeItemsFilter._infoFilter.isSubFilter(_infoFilter.getText());
    }

    @Override
    public boolean equalsFilter(ItemsFilter iFilter) {
      if (iFilter instanceof TypeItemsFilter == false) {
        return false;
      }
      TypeItemsFilter typeItemsFilter = (TypeItemsFilter) iFilter;
      if (getPattern().equals(typeItemsFilter.getPattern()) == false) {
        return false;
      }
      if (_MyFilterVersion != typeItemsFilter.getMyFilterVersion()) {
        return false;
      }
      return true;
    }

    @Override
    public boolean matchesRawNamePattern(Object item) {
      return matchesRawNamePattern((IType) item);
    }

    public String getNamePattern() {
      return _infoFilter.getNamePattern();
    }

    public String getPackagePattern() {
      return _infoFilter.getPackagePattern();
    }

    public int getPackageFlags() {
      return _infoFilter.getPackageFlags();
    }

    public boolean matchesRawNamePattern(IType type) {
      return _infoFilter.matchesRawNamePattern(type);
    }

    public boolean matchesFilterExtension(IType type) {
      return _infoFilter.matchesFilterExtension(type);
    }

    @Override
    public int getMatchRule() {
      return _infoFilter.getSearchFlags();
    }

    @Override
    public String getPattern() {
      return _infoFilter.getText();
    }

    @Override
    public boolean isCamelCasePattern() {
      return _infoFilter.isCamelCasePattern();
    }

  }

  /**
   * A <code>LabelProvider</code> for (the table of) types.
   */
  private class TypeItemLabelProvider extends LabelProvider implements ILabelDecorator, IStyledLabelProvider {

    private boolean fContainerInfo = false;

    private LocalResourceManager fImageManager;

    private Font fBoldFont;

    private Styler fBoldStyler;

    private Styler fBoldQualifierStyler;

    public TypeItemLabelProvider() {
      fImageManager = new LocalResourceManager(JFaceResources.getResources());
      fBoldStyler = createBoldStyler();
      fBoldQualifierStyler = createBoldQualifierStyler();
    }

    /**
     * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
     */
    @Override
    public void dispose() {
      super.dispose();
      fImageManager.dispose();
      if (fBoldFont != null) {
        fBoldFont.dispose();
        fBoldFont = null;
      }
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
     */
    @Override
    public Image getImage(Object element) {
      if (element instanceof IType == false) {
        return super.getImage(element);
      }
      ImageDescriptor contributedImageDescriptor = _infoUtil.getContributedImageDescriptor(element);
      if (contributedImageDescriptor == null) {
        return TypeNameMatchLabelProvider.getImage((IType) element, TypeNameMatchLabelProvider.SHOW_TYPE_ONLY);
      }
      return fImageManager.createImage(contributedImageDescriptor);
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
     */
    @Override
    public String getText(Object element) {
      if (element instanceof IType == false) {
        return super.getText(element);
      }
      IType type = (IType) element;
      if (fContainerInfo && isDuplicateElement(element)) {
        return BasicElementLabels.getJavaElementName(_infoUtil.getFullyQualifiedText(type));
      }

      if (!fContainerInfo && isDuplicateElement(element)) {
        return BasicElementLabels.getJavaElementName(_infoUtil.getQualifiedText(type));
      }

      return BasicElementLabels.getJavaElementName(type.getElementName());
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ILabelDecorator#decorateImage(org.eclipse.swt.graphics.Image,
     *      java.lang.Object)
     */
    public Image decorateImage(Image image, Object element) {
      return image;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ILabelDecorator#decorateText(java.lang.String,
     * java.lang.Object)
     */
    public String decorateText(String text, Object element) {
      if (element instanceof IType == false) {
        return null;
      }
      if (isDuplicateElement(element)) {
        return BasicElementLabels.getJavaElementName(_infoUtil.getFullyQualifiedText((IType) element));
      }
      return BasicElementLabels.getJavaElementName(_infoUtil.getQualifiedText((IType) element));
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider#getStyledText
     *      (java.lang.Object)
     */
    public StyledString getStyledText(Object element) {
      String text = getText(element);
      StyledString string = new StyledString(text);
      int index = text.indexOf(JavaElementLabels.CONCAT_STRING);
      final String namePattern = _filter != null ? _filter.getNamePattern() : null;
      if (namePattern != null && "*".equals(namePattern) == false) { //$NON-NLS-1$
        String typeName = index == -1 ? text : text.substring(0, index);
        int[] matchingRegions = SearchPattern.getMatchingRegions(namePattern, typeName, _filter.getMatchRule());
        markMatchingRegions(string, 0, matchingRegions, fBoldStyler);
      }
      if (index != -1) {
        string.setStyle(index, text.length() - index, StyledString.QUALIFIER_STYLER);
        final String packagePattern = _filter != null ? _filter.getPackagePattern() : null;
        if (packagePattern != null && "*".equals(packagePattern) == false) { //$NON-NLS-1$
          index = index + JavaElementLabels.CONCAT_STRING.length();
          int endIndex = text.indexOf(JavaElementLabels.CONCAT_STRING, index);
          String packageName;
          if (endIndex == -1) {
            packageName = text.substring(index);
          } else {
            packageName = text.substring(index, endIndex);
          }
          int[] matchingRegions = SearchPattern.getMatchingRegions(packagePattern, packageName, _filter.getPackageFlags());
          markMatchingRegions(string, index, matchingRegions, fBoldQualifierStyler);
        }
      }
      return string;
    }

    private void markMatchingRegions(StyledString string, int index, int[] matchingRegions, Styler styler) {
      if (matchingRegions != null) {
        int offset = -1;
        int length = 0;
        for (int i = 0; i + 1 < matchingRegions.length; i = i + 2) {
          if (offset == -1) {
            offset = index + matchingRegions[i];
          }
          // Concatenate adjacent regions
          if (i + 2 < matchingRegions.length && matchingRegions[i] + matchingRegions[i + 1] == matchingRegions[i + 2]) {
            length = length + matchingRegions[i + 1];
          } else {
            string.setStyle(offset, length + matchingRegions[i + 1], styler);
            offset = -1;
            length = 0;
          }
        }
      }
    }

    /**
     * Create the bold variant of the currently used font.
     * 
     * @return the bold font
     * @since 3.5
     */
    private Font getBoldFont() {
      if (fBoldFont == null) {
        Font font = getDialogArea().getFont();
        FontData[] data = font.getFontData();
        for (int i = 0; i < data.length; i++) {
          data[i].setStyle(SWT.BOLD);
        }
        fBoldFont = new Font(font.getDevice(), data);
      }
      return fBoldFont;
    }

    private Styler createBoldStyler() {
      return new Styler() {
        @Override
        public void applyStyles(TextStyle textStyle) {
          textStyle.font = getBoldFont();
        }
      };
    }

    private Styler createBoldQualifierStyler() {
      return new Styler() {
        @Override
        public void applyStyles(TextStyle textStyle) {
          StyledString.QUALIFIER_STYLER.applyStyles(textStyle);
          textStyle.font = getBoldFont();
        }
      };
    }

  }

  private static class TypeInfoUtil {

    private final ITypeInfoImageProvider fProviderExtension;

    private final TypeInfoRequestorAdapter fAdapter = new TypeInfoRequestorAdapter();

    private final Map<String, String> fLib2Name = new HashMap<String, String>();

    private final String[] fInstallLocations;

    private final String[] fVMNames;

    public TypeInfoUtil(ITypeInfoImageProvider extension) {
      fProviderExtension = extension;
      List<String> locations = new ArrayList<String>();
      List<String> labels = new ArrayList<String>();
      IVMInstallType[] installs = JavaRuntime.getVMInstallTypes();
      for (int i = 0; i < installs.length; i++) {
        processVMInstallType(installs[i], locations, labels);
      }
      fInstallLocations = locations.toArray(new String[locations.size()]);
      fVMNames = labels.toArray(new String[labels.size()]);
    }

    private void processVMInstallType(IVMInstallType installType, List<String> locations, List<String> labels) {
      if (installType != null) {
        IVMInstall[] installs = installType.getVMInstalls();
        boolean isMac = Platform.OS_MACOSX.equals(Platform.getOS());
        final String HOME_SUFFIX = "/Home"; //$NON-NLS-1$
        for (int i = 0; i < installs.length; i++) {
          String label = getFormattedLabel(installs[i].getName());
          LibraryLocation[] libLocations = installs[i].getLibraryLocations();
          if (libLocations != null) {
            processLibraryLocation(libLocations, label);
          } else {
            String filePath = installs[i].getInstallLocation().getAbsolutePath();
            // on MacOS X install locations end in an additional
            // "/Home" segment; remove it
            if (isMac && filePath.endsWith(HOME_SUFFIX))
              filePath = filePath.substring(0, filePath.length() - HOME_SUFFIX.length() + 1);
            locations.add(filePath);
            labels.add(label);
          }
        }
      }
    }

    private void processLibraryLocation(LibraryLocation[] libLocations, String label) {
      for (int l = 0; l < libLocations.length; l++) {
        LibraryLocation location = libLocations[l];
        fLib2Name.put(location.getSystemLibraryPath().toOSString(), label);
      }
    }

    private String getFormattedLabel(String name) {
      return NLS.bind(CoreUIMessages._UI_FilteredTypesSelectionDialog_library_name_format, name);
    }

    public String getQualifiedText(IType type) {
      StringBuffer result = new StringBuffer();
      result.append(type.getElementName());
      String containerName = TypeNameMatchLabelProvider.getTypeContainerName(type);
      result.append(JavaElementLabels.CONCAT_STRING);
      if (containerName.length() > 0) {
        result.append(containerName);
      } else {
        result.append(JavaUIMessages.FilteredTypesSelectionDialog_default_package);
      }
      return result.toString();
    }

    public String getFullyQualifiedText(IType type) {
      StringBuffer result = new StringBuffer();
      result.append(type.getElementName());
      String containerName = TypeNameMatchLabelProvider.getTypeContainerName(type);
      if (containerName.length() > 0) {
        result.append(JavaElementLabels.CONCAT_STRING);
        result.append(containerName);
      }
      result.append(JavaElementLabels.CONCAT_STRING);
      result.append(getContainerName(type));
      return result.toString();
    }

    public String getQualificationText(IType type) {
      StringBuffer result = new StringBuffer();
      String containerName = TypeNameMatchLabelProvider.getTypeContainerName(type);
      if (containerName.length() > 0) {
        result.append(containerName);
        result.append(JavaElementLabels.CONCAT_STRING);
      }
      result.append(getContainerName(type));
      return result.toString();
    }

    public ImageDescriptor getContributedImageDescriptor(Object element) {
      IType type = (IType) element;
      if (fProviderExtension != null) {
        fAdapter.setMatch(type);
        return fProviderExtension.getImageDescriptor(fAdapter);
      }
      return null;
    }

    private String getContainerName(IType type) {
      IPackageFragmentRoot root = TypeNameMatchLabelProvider.getPackageFragmentRoot(type);
      if (root.isExternal()) {
        String name = root.getPath().toOSString();
        for (int i = 0; i < fInstallLocations.length; i++) {
          if (name.startsWith(fInstallLocations[i])) {
            return fVMNames[i];
          }
        }
        String lib = fLib2Name.get(name);
        if (lib != null) {
          return lib;
        }
      }
      StringBuffer buf = new StringBuffer();
      JavaElementLabels.getPackageFragmentRootLabel(root, JavaElementLabels.ROOT_QUALIFIED | JavaElementLabels.ROOT_VARIABLE, buf);
      return buf.toString();
    }
  }

  /**
   * A <code>LabelProvider</code> for the label showing type details.
   */
  private static class TypeItemDetailsLabelProvider extends LabelProvider {

    private final TypeInfoUtil fTypeInfoUtil;

    public TypeItemDetailsLabelProvider(TypeInfoUtil typeInfoUtil) {
      fTypeInfoUtil = typeInfoUtil;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
     */
    @Override
    public Image getImage(Object element) {
      if (element instanceof IType) {
        return TypeNameMatchLabelProvider.getImage((IType) element, TypeNameMatchLabelProvider.SHOW_TYPE_CONTAINER_ONLY);
      }
      return super.getImage(element);
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
     */
    @Override
    public String getText(Object element) {
      if (element instanceof IType) {
        return BasicElementLabels.getJavaElementName(fTypeInfoUtil.getQualificationText((IType) element));
      }

      return super.getText(element);
    }
  }

  /**
   * Compares TypeItems is used during sorting
   */
  private static class TypeItemsComparator implements Comparator<IType> {

    private final Map<String, String> fLib2Name = new HashMap<String, String>();

    private final String[] fInstallLocations;

    private final String[] fVMNames;

    /**
     * Creates new instance of TypeItemsComparator
     */
    public TypeItemsComparator() {
      List<String> locations = new ArrayList<String>();
      List<String> labels = new ArrayList<String>();
      IVMInstallType[] installs = JavaRuntime.getVMInstallTypes();
      for (int i = 0; i < installs.length; i++) {
        processVMInstallType(installs[i], locations, labels);
      }
      fInstallLocations = locations.toArray(new String[locations.size()]);
      fVMNames = labels.toArray(new String[labels.size()]);
    }

    private void processVMInstallType(IVMInstallType installType, List<String> locations, List<String> labels) {
      if (installType != null) {
        IVMInstall[] installs = installType.getVMInstalls();
        boolean isMac = Platform.OS_MACOSX.equals(Platform.getOS());
        final String HOME_SUFFIX = "/Home"; //$NON-NLS-1$
        for (int i = 0; i < installs.length; i++) {
          String label = getFormattedLabel(installs[i].getName());
          LibraryLocation[] libLocations = installs[i].getLibraryLocations();
          if (libLocations != null) {
            processLibraryLocation(libLocations, label);
          } else {
            String filePath = installs[i].getInstallLocation().getAbsolutePath();
            // on MacOS X install locations end in an additional
            // "/Home" segment; remove it
            if (isMac && filePath.endsWith(HOME_SUFFIX))
              filePath = filePath.substring(0, filePath.length() - HOME_SUFFIX.length() + 1);
            locations.add(filePath);
            labels.add(label);
          }
        }
      }
    }

    private void processLibraryLocation(LibraryLocation[] libLocations, String label) {
      for (int l = 0; l < libLocations.length; l++) {
        LibraryLocation location = libLocations[l];
        fLib2Name.put(location.getSystemLibraryPath().toString(), label);
      }
    }

    private String getFormattedLabel(String name) {
      return MessageFormat.format(JavaUIMessages.FilteredTypesSelectionDialog_library_name_format, new Object[] { name });
    }

    public int compare(IType left, IType right) {
      int result = compareName(left.getElementName(), right.getElementName());
      if (result != 0) {
        return result;
      }
      result = compareTypeContainerName(TypeNameMatchLabelProvider.getTypeContainerName(left), TypeNameMatchLabelProvider.getTypeContainerName(right));
      if (result != 0) {
        return result;
      }
      int leftCategory = getElementTypeCategory(left);
      int rightCategory = getElementTypeCategory(right);
      if (leftCategory < rightCategory) {
        return -1;
      }
      if (leftCategory > rightCategory) {
        return +1;
      }
      return compareContainerName(left, right);
    }

    private int compareName(String leftString, String rightString) {
      int result = leftString.compareToIgnoreCase(rightString);
      if (result != 0 || rightString.length() == 0) {
        return result;
      } else if (isLowerCase(leftString.charAt(0)) && isLowerCase(rightString.charAt(0)) == false) {
        return +1;
      } else if (isLowerCase(rightString.charAt(0)) && isLowerCase(leftString.charAt(0)) == false) {
        return -1;
      } else {
        return leftString.compareTo(rightString);
      }
    }

    private int compareTypeContainerName(String leftString, String rightString) {
      int leftLength = leftString.length();
      int rightLength = rightString.length();
      if (leftLength == 0 && rightLength > 0) {
        return -1;
      }
      if (leftLength == 0 && rightLength == 0) {
        return 0;
      }
      if (leftLength > 0 && rightLength == 0) {
        return +1;
      }
      return compareName(leftString, rightString);
    }

    private int compareContainerName(IType leftType, IType rightType) {
      return getContainerName(leftType).compareTo(getContainerName(rightType));
    }

    private String getContainerName(IType type) {
      IPackageFragmentRoot root = TypeNameMatchLabelProvider.getPackageFragmentRoot(type);
      if (root.isExternal()) {
        String name = root.getPath().toOSString();
        for (int i = 0; i < fInstallLocations.length; i++) {
          if (name.startsWith(fInstallLocations[i])) {
            return fVMNames[i];
          }
        }
        String lib = fLib2Name.get(name);
        if (lib != null) {
          return lib;
        }
      }
      StringBuffer buf = new StringBuffer();
      JavaElementLabels.getPackageFragmentRootLabel(root, JavaElementLabels.ROOT_QUALIFIED | JavaElementLabels.ROOT_VARIABLE, buf);
      return buf.toString();
    }

    private int getElementTypeCategory(IType type) {
      try {
        if (TypeNameMatchLabelProvider.getPackageFragmentRoot(type).getKind() == IPackageFragmentRoot.K_SOURCE)
          return 0;
      } catch (JavaModelException jme) {
        EGFCoreUIPlugin.getDefault().logError(jme);
      }
      return 1;
    }
  }

  public TypeSelectionDialog(Shell parentShell, IProject project, Class<?> clazz, String current, TypeSelectionExtension extension, boolean multipleSelection) {
    super(parentShell, multipleSelection);
    Assert.isNotNull(project);
    Assert.isNotNull(clazz);
    _project = project;
    _clazz = clazz;
    _infoUtil = new TypeInfoUtil(null);
    _filterExtension = (extension == null) ? null : extension.getFilterExtension();
    setTitle(CoreUIMessages._UI_TypeSelection_label);
    setMessage(NLS.bind(CoreUIMessages._UI_SelectType, _clazz.getName()));
    setListLabelProvider(new TypeItemLabelProvider());
    setDetailsLabelProvider(new TypeItemDetailsLabelProvider(_infoUtil));
    setSelectionHistory(current);
    setSeparatorLabel(NLS.bind(CoreUIMessages._UI_FilteredItemsSelectionDialog_separatorLabel, BundleHelper.getBundleId(_project)));
  }

  private void setSelectionHistory(String current) {
    if (current == null || current.trim().length() == 0) {
      return;
    }
    IJavaProject javaProject = null;
    try {
      // IProject should be a JavaProject
      try {
        if (_project.isAccessible() && _project.hasNature(JavaCore.NATURE_ID)) {
          javaProject = JavaCore.create(_project);
        }
      } catch (CoreException e) {
        EGFCoreUIPlugin.getDefault().logError(e);
      }
      if (javaProject != null) {
        SelectionHistory history = new TypeSelectionHistory();
        IType type = javaProject.findType(current.trim());
        if (type != null) {
          history.accessed(type);
        }
        setSelectionHistory(history);
      }
    } catch (JavaModelException jme) {
      EGFCoreUIPlugin.getDefault().logError(jme);
    } finally {
      try {
        if (javaProject != null) {
          javaProject.close();
        }
      } catch (JavaModelException jme) {
        EGFCoreUIPlugin.getDefault().logError(jme);
      }
    }
  }

  @Override
  protected Control createExtendedContentArea(Composite parent) {
    return null;
  }

  @Override
  protected ItemsFilter createFilter() {
    _filter = new TypeItemsFilter(_filterExtension);
    return _filter;
  }

  @Override
  protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor monitor) throws CoreException {
    // Invoke
    SubMonitor subMonitor = SubMonitor.convert(monitor, NLS.bind(CoreUIMessages.TypeSelectionDialog_findTypeHierarchy, _clazz.getName()), 1000);
    final List<IType> types = new UniqueEList<IType>();
    final TypeItemsFilter typeSearchFilter = (TypeItemsFilter) itemsFilter;
    IJavaProject javaProject = null;
    try {
      // IProject should be a JavaProject
      try {
        if (_project.isAccessible() && _project.hasNature(JavaCore.NATURE_ID)) {
          javaProject = JavaCore.create(_project);
        }
      } catch (CoreException e) {
        EGFCoreUIPlugin.getDefault().logError(e);
      }
      if (javaProject != null) {
        // Hierarchy Lookup
        // Retrieve IType
        IType classType = javaProject.findType(_clazz.getName(), subMonitor.newChild(200, SubMonitor.SUPPRESS_NONE));
        if (classType == null) {
          return;
        }
        // Filter and public, non interface and non abstract are processed
        if (TypeFilter.isFiltered(classType) == false && Flags.isPublic(classType.getFlags()) && Flags.isInterface(classType.getFlags()) == false && Flags.isAbstract(classType.getFlags()) == false) {
          String bundleId = BundleHelper.getBundleId(classType.getJavaProject().getProject());
          // type should be contained in a bundle
          if (bundleId != null && typeSearchFilter.matchesFilterExtension(classType)) {
            types.add(classType);
          }
        }
        // Hierarchy
        ITypeHierarchy typeHierarchy = classType.newTypeHierarchy(javaProject, subMonitor.newChild(300, SubMonitor.SUPPRESS_NONE));
        if (typeHierarchy == null) {
          return;
        }
        for (IType type : typeHierarchy.getAllSubtypes(classType)) {
          // Filter and public, non interface and non abstract are processed
          if (TypeFilter.isFiltered(type) == false && Flags.isPublic(type.getFlags()) && Flags.isInterface(type.getFlags()) == false && Flags.isAbstract(type.getFlags()) == false) {
            String bundleId = BundleHelper.getBundleId(type.getJavaProject().getProject());
            // type should be contained in a bundle
            if (bundleId != null && typeSearchFilter.matchesFilterExtension(type)) {
              types.add(type);
            }
          }
        }
        // Java Search Lookup
        // Java Search Lookup
        IJavaElement[] javaElements = new IJavaElement[] { javaProject };
        JavaSearchScopeFactory factory = JavaSearchScopeFactory.getInstance();
        IJavaSearchScope scope = factory.createJavaSearchScope(javaElements, JavaSearchScopeFactory.ALL);
        String scopeDescription = factory.getSelectionScopeDescription(javaElements, JavaSearchScopeFactory.ALL);
        QuerySpecification querySpec = new PatternQuerySpecification(classType.getElementName(), IJavaSearchConstants.TYPE, true, IJavaSearchConstants.CLASS | IJavaSearchConstants.IMPLEMENTORS, scope, scopeDescription);
        JavaSearchQuery searchJob = new JavaSearchQuery(querySpec);
        searchJob.run(subMonitor.newChild(300, SubMonitor.SUPPRESS_NONE));
        JavaSearchResult result = (JavaSearchResult) searchJob.getSearchResult();
        for (Object object : result.getElements()) {
          if (object instanceof IType == false) {
            continue;
          }
          IType type = (IType) object;
          // Filter and public, non interface and non abstract are processed
          if (TypeFilter.isFiltered(type) == false && Flags.isPublic(type.getFlags()) && Flags.isInterface(type.getFlags()) == false && Flags.isAbstract(type.getFlags()) == false) {
            String bundleId = BundleHelper.getBundleId(type.getJavaProject().getProject());
            // type should be contained in a bundle
            if (bundleId != null && typeSearchFilter.matchesFilterExtension(type)) {
              types.add(type);
            }
          }
        }
        // Feed Content Provider
        for (IType type : types) {
          contentProvider.add(type, typeSearchFilter);
        }
      }
    } catch (OperationCanceledException e) {
      return;
    } catch (Throwable t) {
      ThrowableHandler.handleThrowable(EGFCoreUIPlugin.getDefault().getPluginID(), t);
      return;
    } finally {
      try {
        if (javaProject != null) {
          javaProject.close();
        }
      } catch (JavaModelException jme) {
        EGFCoreUIPlugin.getDefault().logError(jme);
      }
      monitor.done();
    }
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.dialogs.AbstractSearchDialog#fillViewMenu(org.eclipse.jface.action.IMenuManager)
   */
  @Override
  protected void fillViewMenu(IMenuManager menuManager) {
    super.fillViewMenu(menuManager);
    menuManager.add(new Separator());
    menuManager.add(new TypeFiltersPreferencesAction());
  }

  @Override
  protected IDialogSettings getDialogSettings() {
    IDialogSettings settings = EGFCoreUIPlugin.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);
    if (settings == null) {
      settings = EGFCoreUIPlugin.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
    }
    return settings;
  }

  @Override
  public String getElementName(Object item) {
    if (item instanceof IPlatformFcore) {
      IPlatformFcore fc = (IPlatformFcore) item;
      return fc.getURI().toString();
    }
    return null;
  }

  @Override
  protected Comparator<IType> getItemsComparator() {
    return new TypeItemsComparator();
  }

  @Override
  protected IStatus validateItem(Object item) {
    return new Status(IStatus.OK, EGFCoreUIPlugin.getDefault().getBundle().getSymbolicName(), 0, "", null); //$NON-NLS-1$
  }

  /**
   * @see org.eclipse.jdt.ui.dialogs.ITypeSelectionComponent#triggerSearch()
   */
  public void triggerSearch() {
    _filterVersion++;
    applyFilter();
  }

  /**
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.dialogs.SelectionDialog#setResult(java.util.List)
   */
  @Override
  @SuppressWarnings("unchecked")
  protected void setResult(List newResult) {
    List resultToReturn = new ArrayList();
    for (int i = 0; i < newResult.size(); i++) {
      if (newResult.get(i) instanceof IType) {
        IType type = (IType) newResult.get(i);
        if (type.exists()) {
          // items are added to history in the
          // org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#computeResult()
          // method
          resultToReturn.add(type);
        } else {
          IPackageFragmentRoot root = TypeNameMatchLabelProvider.getPackageFragmentRoot(type);
          String containerName = JavaElementLabels.getElementLabel(root, JavaElementLabels.ROOT_QUALIFIED);
          String message = NLS.bind(CoreUIMessages._UI_FilteredTypesSelectionDialog_dialogMessage, new String[] { TypeNameMatchLabelProvider.getText(type, TypeNameMatchLabelProvider.SHOW_FULLYQUALIFIED), containerName });
          MessageDialog.openError(getShell(), CoreUIMessages._UI_TypeSelection_label, message);
          getSelectionHistory().remove(type);
        }
      }
    }
    super.setResult(resultToReturn);
  }

}
