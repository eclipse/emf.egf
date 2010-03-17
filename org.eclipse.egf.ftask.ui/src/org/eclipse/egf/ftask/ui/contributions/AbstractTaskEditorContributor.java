/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
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

package org.eclipse.egf.ftask.ui.contributions;

import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.editor.contributions.AbstractTypeEditorContributor;
import org.eclipse.egf.model.ftask.FtaskPackage;
import org.eclipse.egf.model.ftask.Task;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * @author Thomas Guiu
 * 
 */
public abstract class AbstractTaskEditorContributor extends AbstractTypeEditorContributor {

    private final String kind;

    protected AbstractTaskEditorContributor(String kind) {
        super();
        this.kind = kind;
        if (kind == null)
            throw new IllegalArgumentException();
    }

    @Override
    public boolean canApply(Object object, IItemPropertyDescriptor descriptor) {
        Object feature = descriptor.getFeature(object);
        if (feature.equals(FtaskPackage.Literals.TASK__IMPLEMENTATION) && object instanceof Task) {
            Task task = (Task) object;
            return getKind().equals(task.getKind());
        }
        return false;
    }

    @Override
    protected String getCurrentClassname(Object object) {
        return ((Task) object).getImplementation();
    }

    @Override
    protected Class<?> getType(Object object) {
        return ITaskProduction.class;
    }

    protected String getKind() {
        return kind;
    }

}
