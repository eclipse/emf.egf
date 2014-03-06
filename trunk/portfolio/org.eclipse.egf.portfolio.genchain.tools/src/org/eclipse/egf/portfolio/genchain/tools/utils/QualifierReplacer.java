/**
 * <copyright>
 *
 *  Copyright (c) 2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.portfolio.genchain.tools.utils;

import java.util.Calendar;

/**
 * Copied from org.eclipse.pde.internal.build.site.QualifierReplacer
 * 
 * @author Thomas Guiu
 */
public class QualifierReplacer {
    public static String getDate() {
        final String empty = ""; //$NON-NLS-1$
        int monthNbr = Calendar.getInstance().get(Calendar.MONTH) + 1;
        String month = (monthNbr < 10 ? "0" : empty) + monthNbr; //$NON-NLS-1$

        int dayNbr = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        String day = (dayNbr < 10 ? "0" : empty) + dayNbr; //$NON-NLS-1$

        int hourNbr = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        String hour = (hourNbr < 10 ? "0" : empty) + hourNbr; //$NON-NLS-1$

        int minuteNbr = Calendar.getInstance().get(Calendar.MINUTE);
        String minute = (minuteNbr < 10 ? "0" : empty) + minuteNbr; //$NON-NLS-1$

        return empty + Calendar.getInstance().get(Calendar.YEAR) + month + day + hour + minute; //$NON-NLS-1$
    }

}
