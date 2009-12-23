/**
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.common.helper;

/**
 * Extra mathematical functions.
 * 
 * @author brocard
 */
public class MathHelper {
  
  public final static long SECOND = 1000;

  public final static long MINUTE = SECOND * 60;

  public final static long HOUR = MINUTE * 60;

  public final static long DAY = HOUR * 24;
  
  public static String formatAsDuration(long duration) {
    long temp = 0;
    StringBuilder formatted = new StringBuilder();
    // Days
    temp = duration / DAY;
    if (temp > 0) {
      formatted
        .append(temp)
        .append(" day"); //$NON-NLS-1$
      if (temp > 1) {
        formatted.append("s"); //$NON-NLS-1$
      }
      duration = duration - (temp * DAY);
    }
    // Hours
    temp = duration / HOUR;
    if (temp > 0) {
      if (formatted.length() > 0) {
       formatted.append(" "); //$NON-NLS-1$ 
      }
      formatted
        .append(temp)
        .append(" hr"); //$NON-NLS-1$
      if (temp > 1) {
        formatted.append("s"); //$NON-NLS-1$
      }
      duration = duration - (temp * HOUR);        
    }
    // Minutes
    temp = duration / MINUTE;
    if (temp > 0) {
      if (formatted.length() > 0) {
        formatted.append(" "); //$NON-NLS-1$ 
       }        
      formatted
        .append(temp)
        .append(" min"); //$NON-NLS-1$
      if (temp > 1) {
        formatted.append("s"); //$NON-NLS-1$
      }  
      duration = duration - (temp * MINUTE);        
    }
    // Seconds
    if (duration >= SECOND) {
      temp = duration / SECOND;
      if (temp > 0) {
        if (formatted.length() > 0) {
          formatted.append(" "); //$NON-NLS-1$ 
         }        
        formatted
          .append(temp)
          .append(" sec"); //$NON-NLS-1$
        if (temp > 1) {
          formatted.append("s"); //$NON-NLS-1$
        }
        duration = duration - (temp * SECOND);        
      }
    }
    // Millisecond
    if (duration > 0) {
      if (formatted.length() > 0) {
        formatted.append(" "); //$NON-NLS-1$ 
       }        
      formatted
        .append(duration)
        .append(" ms"); //$NON-NLS-1$        
    } 
    return formatted.toString();
  }  
  
  /**
   * Multiply given integer and float value, and return result as an int.
   * @param sourceValue_p
   * @param multiplier_p
   * @return
   */
  public static int multiply(int sourceValue_p, float multiplier_p) {
    return (int) (sourceValue_p * multiplier_p);
  }
  
}
