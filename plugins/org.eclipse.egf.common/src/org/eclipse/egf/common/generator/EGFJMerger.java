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
package org.eclipse.egf.common.generator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.merge.java.facade.JMember;
import org.eclipse.emf.codegen.merge.java.facade.JMethod;
import org.eclipse.emf.codegen.merge.java.facade.JNode;

/**
 * @author Xavier Maysonnave
 * 
 */
public class EGFJMerger extends JMerger {

  public EGFJMerger(JControlModel controlModel) {
    super(controlModel);
  }

  @Override
  protected void applyPullRules(JNode sourceNode, JNode targetNode) {

    try {

      for (JControlModel.PullRule pullRule : getControlModel().getPullRules()) {
        if (pullRule.getSourceGetFeature().getFeatureMethod() != null && pullRule.getSourceGetFeature().getFeatureClass().isInstance(sourceNode) && pullRule.getTargetPutFeature().getFeatureMethod() != null && pullRule.getTargetPutFeature().getFeatureClass().isInstance(targetNode)
            && sourcePatternDictionary.isMarkedUp(pullRule.getSourceMarkup(), pullRule.getSourceParentMarkup(), sourceNode) && targetPatternDictionary.isMarkedUp(pullRule.getTargetMarkup(), pullRule.getTargetParentMarkup(), targetNode)) {
          // Skip if there's an equality filter and the values aren't equal.
          //
          if (pullRule.getEqualityFeature() != null) {
            Method equalityFeatureMethod = pullRule.getEqualityFeature().getFeatureMethod();
            Object value1 = equalityFeatureMethod.invoke(sourceNode, NO_ARGUMENTS);
            Object value2 = equalityFeatureMethod.invoke(targetNode, NO_ARGUMENTS);
            if (value1 == null ? value2 != null : value1.equals(value2) == false) {
              continue;
            }
          }
          Method sourceGetMethod = pullRule.getSourceGetFeature().getFeatureMethod();
          Object value = sourceGetMethod.invoke(sourceNode, NO_ARGUMENTS);
          Method targetPutMethod = pullRule.getTargetPutFeature().getFeatureMethod();
          if (sourceGetMethod.getReturnType().isArray() == false || targetPutMethod.getParameterTypes()[0].isAssignableFrom(sourceGetMethod.getReturnType())) {
            if (value instanceof String) {
              String stringValue = (String) value;
              stringValue = getControlModel().getFacadeHelper().applyFormatRules(stringValue);
              Pattern sourceTransfer = pullRule.getSourceTransfer();
              if (sourceTransfer != null) {
                String oldStringValue = (String) sourceGetMethod.invoke(targetNode, NO_ARGUMENTS);
                if (oldStringValue != null) {
                  oldStringValue = getControlModel().getFacadeHelper().applyFormatRules(oldStringValue);
                  Matcher sourceMatcher = sourceTransfer.matcher(stringValue);
                  Matcher targetMatcher = sourceTransfer.matcher(oldStringValue);
                  if (sourceMatcher.groupCount() >= 1 && targetMatcher.groupCount() >= 1) {
                    StringBuilder result = new StringBuilder();
                    int index = 0;
                    int sourceStart = 0;
                    int targetStart = 0;
                    if (sourceTransfer.pattern().startsWith("(\\s*<!--")) { //$NON-NLS-1$
                      sourceStart = getStartIndex(stringValue);
                      targetStart = getStartIndex(oldStringValue);
                    }
                    // Something to merge
                    //
                    for (boolean match = sourceMatcher.find(sourceStart) && targetMatcher.find(targetStart); match; match = sourceMatcher.find() && targetMatcher.find()) {
                      result.append(stringValue.substring(index, sourceMatcher.start(1)));
                      result.append(targetMatcher.group(1));
                      index = sourceMatcher.end(1);
                    }
                    // There must be at least one match.
                    //
                    if (result.length() == 0) {
                      stringValue = null;
                    } else {
                      result.append(stringValue.substring(index));
                      stringValue = result.toString();
                    }
                  } else {
                    stringValue = null;
                  }
                }
              }
              value = stringValue;
            }

            if (value != null || targetPutMethod.getName().equals("setInitializer") //$NON-NLS-1$
                || targetPutMethod.getName().equals("setSuperclass") //$NON-NLS-1$
                || targetPutMethod.getName().equals("setExceptions") //$NON-NLS-1$
            ) {
              // Ignore if there is not substantial change.
              //
              Object oldValue = sourceGetMethod.invoke(targetNode, NO_ARGUMENTS);
              if (value == null ? oldValue == null : value.equals(oldValue)) {
                continue;
              } else if (value instanceof Object[] && oldValue instanceof Object[] && Arrays.equals((Object[]) value, (Object[]) oldValue)) {
                continue;
              } else if (targetPutMethod.getName().equals("setSuperclass")) { //$NON-NLS-1$
                if (oldValue != null && value != null && ((String) oldValue).trim().equals(((String) value).trim())) {
                  continue;
                }
                Pattern sourceTransfer = pullRule.getSourceTransfer();
                String comment = ((JMember) targetNode).getComment();
                if (sourceTransfer != null && comment != null) {
                  Matcher matcher = sourceTransfer.matcher(comment);
                  while (matcher.find() && matcher.groupCount() >= 1) {
                    String clientStrings = comment.substring(matcher.start(matcher.groupCount()), matcher.end(matcher.groupCount()));
                    for (StringTokenizer stringTokenizer = new StringTokenizer(clientStrings, ", \t\n\r\f"); stringTokenizer.hasMoreTokens();) { //$NON-NLS-1$
                      value = stringTokenizer.nextToken();
                    }
                  }
                }
              }

              // The block pattern needs to prevent merging of the return type, to allow changing from the modeled data
              // type (Bugzilla 102209).
              //
              if (sourceGetMethod.getName().equals("getReturnType") //$NON-NLS-1$
                  && getControlModel().getBlockPattern() != null && ((JMethod) targetNode).getComment() != null && getControlModel().getBlockPattern().matcher(((JMethod) targetNode).getComment()).find()) {
                continue;
              }

              targetPutMethod.invoke(targetNode, new Object[] { value });
              targetCompilationChanged = true;
              if (targetPutMethod.getName().equals("setBody") && sourceNode instanceof JMethod) { //$NON-NLS-1$
                JMethod sourceMethod = (JMethod) sourceNode;
                JMethod targetMethod = (JMethod) targetNode;
                String[] sourceParameterTypes = sourceMethod.getParameterTypes();
                String[] targetParameterTypes = targetMethod.getParameterTypes();
                if (Arrays.equals(sourceParameterTypes, targetParameterTypes)) {
                  targetMethod.setParameterNames(sourceMethod.getParameterNames());
                } else {
                  // The methods were matched by a process that doesn't consider the
                  // parameters
                  targetMethod.setParameters(sourceMethod.getParameters());
                }
              }
            }
          } else {
            // source method return type is array (getExceptions), target is not array (i.e. addException)
            ArrayList<String> additionalStrings = new ArrayList<String>();
            String[] sourceStrings = (String[]) value;
            if (sourceStrings != null) {
              additionalStrings.addAll(Arrays.asList(sourceStrings));
            }

            if (targetPutMethod.getName().equals("addSuperInterface")) { //$NON-NLS-1$
              Pattern sourceTransfer = pullRule.getSourceTransfer();
              String comment = ((JMember) targetNode).getComment();
              if (sourceTransfer != null && comment != null) {
                Matcher matcher = sourceTransfer.matcher(comment);
                while (matcher.find() && matcher.groupCount() >= 1) {
                  String clientStrings = comment.substring(matcher.start(matcher.groupCount()), matcher.end(matcher.groupCount()));
                  for (StringTokenizer stringTokenizer = new StringTokenizer(clientStrings, ", \t\n\r\f"); stringTokenizer.hasMoreTokens();) { //$NON-NLS-1$
                    String token = stringTokenizer.nextToken();
                    if (additionalStrings.contains(token) == false) {
                      additionalStrings.add(token);
                    }
                  }
                }
              }
              String[] oldSuperInterfaces = (String[]) sourceGetMethod.invoke(targetNode);
              String[] superInterfaces = additionalStrings.toArray(new String[additionalStrings.size()]);
              if (oldSuperInterfaces == null ? superInterfaces.length != 0 : Arrays.equals(oldSuperInterfaces, superInterfaces) == false) {
                Method putMethod = targetNode.getClass().getMethod("setSuperInterfaces", String[].class); //$NON-NLS-1$
                putMethod.invoke(targetNode, new Object[] { superInterfaces });
                targetCompilationChanged = true;
              }
            } else {
              // target method is NOT addSuperInterface
              String[] oldStringValues = (String[]) sourceGetMethod.invoke(targetNode, NO_ARGUMENTS);
              List<String> old = oldStringValues == null ? Collections.<String> emptyList() : Arrays.<String> asList(oldStringValues);
              for (String string : additionalStrings) {
                if (old.contains(string) == false) {
                  targetPutMethod.invoke(targetNode, new Object[] { string });
                  targetCompilationChanged = true;
                }
              }
            }
          }
        }
      }

    } catch (InvocationTargetException exception) {
      if (DEBUG) {
        exception.printStackTrace();
      }
    } catch (IllegalAccessException exception) {
      if (DEBUG) {
        exception.printStackTrace();
      }
    } catch (SecurityException e) {
      if (DEBUG) {
        e.printStackTrace();
      }
    } catch (NoSuchMethodException e) {
      if (DEBUG) {
        e.printStackTrace();
      }
    }

  }

  // Method created to increase the performance of regular expressions
  // by reducing the length of the string that is matched.
  //
  private int getStartIndex(String string) {
    int index = string.indexOf("<!--"); //$NON-NLS-1$ 
    if (index > 0) {
      while (Character.isWhitespace(string.charAt(--index)) && index > 0) {
        // Back up over the whitespace.
      }
      return index;
    }
    return 0;
  }

}
