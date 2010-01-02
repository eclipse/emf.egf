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

import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.internal.ui.util.StringMatcher;
import org.eclipse.jdt.ui.dialogs.ITypeInfoFilterExtension;

public class TypeInfoFilter {

  public static boolean startsWithIgnoreCase(String text, String prefix) {
    int textLength = text.length();
    int prefixLength = prefix.length();
    if (textLength < prefixLength)
      return false;
    for (int i = prefixLength - 1; i >= 0; i--) {
      if (Character.toLowerCase(prefix.charAt(i)) != Character.toLowerCase(text.charAt(i)))
        return false;
    }
    return true;
  }

  public static boolean isCamelCasePattern(String pattern) {
    return SearchPattern.validateMatchRule(pattern, SearchPattern.R_CAMELCASE_MATCH) == SearchPattern.R_CAMELCASE_MATCH;
  }

  private static class PatternMatcher {

    private String fPattern;

    private int fMatchKind;

    private StringMatcher fStringMatcher;

    private static final char END_SYMBOL = '<';

    private static final char ANY_STRING = '*';

    private static final char BLANK = ' ';

    public PatternMatcher(String pattern) {
      this(pattern, SearchPattern.R_EXACT_MATCH | SearchPattern.R_PREFIX_MATCH | SearchPattern.R_PATTERN_MATCH | SearchPattern.R_CAMELCASE_MATCH | SearchPattern.R_CAMELCASE_SAME_PART_COUNT_MATCH);
    }

    private PatternMatcher(String pattern, int allowedModes) {
      initializePatternAndMatchKind(pattern);
      fMatchKind = fMatchKind & allowedModes;
      if (fMatchKind == SearchPattern.R_PATTERN_MATCH) {
        fStringMatcher = new StringMatcher(fPattern, true, false);
      }
    }

    public String getPattern() {
      return fPattern;
    }

    public int getMatchKind() {
      return fMatchKind;
    }

    public boolean matches(String text) {
      switch (fMatchKind) {
      case SearchPattern.R_PATTERN_MATCH:
        return fStringMatcher.match(text);
      case SearchPattern.R_EXACT_MATCH:
        return fPattern.equalsIgnoreCase(text);
      case SearchPattern.R_CAMELCASE_SAME_PART_COUNT_MATCH:
        return SearchPattern.camelCaseMatch(fPattern, text, true);
      case SearchPattern.R_CAMELCASE_MATCH:
        if (SearchPattern.camelCaseMatch(fPattern, text)) {
          return true;
        }
        // fall back to prefix match if camel case failed (bug 137244)
        return startsWithIgnoreCase(text, fPattern);
      default:
        return startsWithIgnoreCase(text, fPattern);
      }
    }

    private void initializePatternAndMatchKind(String pattern) {
      int length = pattern.length();
      if (length == 0) {
        fMatchKind = SearchPattern.R_EXACT_MATCH;
        fPattern = pattern;
        return;
      }
      char last = pattern.charAt(length - 1);

      if (pattern.indexOf('*') != -1 || pattern.indexOf('?') != -1) {
        fMatchKind = SearchPattern.R_PATTERN_MATCH;
        switch (last) {
        case END_SYMBOL:
        case BLANK:
          fPattern = pattern.substring(0, length - 1);
          break;
        case ANY_STRING:
          fPattern = pattern;
          break;
        default:
          fPattern = pattern + ANY_STRING;
        }
        return;
      }

      if (last == END_SYMBOL || last == BLANK) {
        fPattern = pattern.substring(0, length - 1);
        if (SearchPattern.validateMatchRule(fPattern, SearchPattern.R_CAMELCASE_SAME_PART_COUNT_MATCH) == SearchPattern.R_CAMELCASE_SAME_PART_COUNT_MATCH) {
          fMatchKind = SearchPattern.R_CAMELCASE_SAME_PART_COUNT_MATCH;
        } else {
          fMatchKind = SearchPattern.R_EXACT_MATCH;
        }
        return;
      }

      if (isCamelCasePattern(pattern)) {
        fMatchKind = SearchPattern.R_CAMELCASE_MATCH;
        fPattern = pattern;
        return;
      }

      fMatchKind = SearchPattern.R_PREFIX_MATCH;
      fPattern = pattern;
    }
  }

  private final String fText;

  private final ITypeInfoFilterExtension fFilterExtension;

  private final TypeInfoRequestorAdapter fAdapter = new TypeInfoRequestorAdapter();

  private final PatternMatcher fPackageMatcher;

  private final PatternMatcher fNameMatcher;

  public TypeInfoFilter(String text, ITypeInfoFilterExtension extension) {
    fText = text;
    fFilterExtension = extension;
    int index = text.lastIndexOf("."); //$NON-NLS-1$
    if (index == -1) {
      fNameMatcher = new PatternMatcher(text);
      fPackageMatcher = null;
    } else {
      fPackageMatcher = new PatternMatcher(evaluatePackagePattern(text.substring(0, index)));
      String name = text.substring(index + 1);
      if (name.length() == 0) {
        name = "*"; //$NON-NLS-1$
      }
      fNameMatcher = new PatternMatcher(name);
    }
  }

  /*
   * Transforms o.e.j to o*.e*.j*
   */
  private String evaluatePackagePattern(String s) {
    StringBuffer buf = new StringBuffer();
    boolean hasWildCard = false;
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char ch = s.charAt(i);
      if (ch == '.') {
        if (hasWildCard == false) {
          buf.append('*');
        }
        hasWildCard = false;
      } else if (ch == '*' || ch == '?') {
        hasWildCard = true;
      }
      buf.append(ch);
    }
    if (hasWildCard == false) {
      if (len == 0) {
        buf.append('?');
      }
      buf.append('*');
    }
    return buf.toString();
  }

  public String getText() {
    return fText;
  }

  /**
   * Checks whether <code>this</code> filter is a subFilter of the given <code>text</code>.
   * <p>
   * <i>WARNING: This is the <b>reverse</b> interpretation compared to
   * {@link org.eclipse.ui.dialogs.SearchPattern#isSubPattern(org.eclipse.ui.dialogs.SearchPattern)}
   * and {@link org.eclipse.ui.dialogs.FilteredItemsSelectionDialog.ItemsFilter#isSubFilter}.
   * </i>
   * </p>
   * 
   * @param text
   *          another filter text
   * @return <code>true</code> if <code>this</code> filter is a subFilter of <code>text</code>
   *         e.g. "List" is a subFilter of "L". In this case, the filters matches a proper subset of
   *         the items matched by <code>text</code>.
   */
  public boolean isSubFilter(String text) {
    if (fText.startsWith(text) == false) {
      return false;
    }
    return fText.indexOf('.', text.length()) == -1;
  }

  public boolean isCamelCasePattern() {
    int ccMask = SearchPattern.R_CAMELCASE_MATCH | SearchPattern.R_CAMELCASE_SAME_PART_COUNT_MATCH;
    return (fNameMatcher.getMatchKind() & ccMask) != 0;
  }

  public String getPackagePattern() {
    if (fPackageMatcher == null) {
      return null;
    }
    return fPackageMatcher.getPattern();
  }

  public String getNamePattern() {
    return fNameMatcher.getPattern();
  }

  public int getSearchFlags() {
    return fNameMatcher.getMatchKind();
  }

  public int getPackageFlags() {
    if (fPackageMatcher == null) {
      return SearchPattern.R_EXACT_MATCH;
    }
    return fPackageMatcher.getMatchKind();
  }

  public boolean matchesRawNamePattern(IType type) {
    return startsWithIgnoreCase(type.getElementName(), fNameMatcher.getPattern());
  }

  public boolean matchesCachedResult(IType type) {
    if ((matchesPackage(type) && matchesFilterExtension(type)) == false) {
      return false;
    }
    return matchesName(type);
  }

  public boolean matchesHistoryElement(IType type) {
    if ((matchesPackage(type) && matchesFilterExtension(type)) == false) {
      return false;
    }
    return matchesName(type);
  }

  public boolean matchesFilterExtension(IType type) {
    if (fFilterExtension == null) {
      return true;
    }
    fAdapter.setMatch(type);
    return fFilterExtension.select(fAdapter);
  }

  private boolean matchesName(IType type) {
    if (fText.length() == 0) {
      return true; // empty pattern matches all names
    }
    return fNameMatcher.matches(type.getElementName());
  }

  private boolean matchesPackage(IType type) {
    if (fPackageMatcher == null) {
      return true;
    }
    return fPackageMatcher.matches(type.getPackageFragment().getElementName());
  }

}
