/**
 * <copyright>
 * Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.compare;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.compare.IEditableContent;
import org.eclipse.compare.IStreamContentAccessor;
import org.eclipse.compare.ITypedElement;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.egf.pattern.ui.Activator;
import org.eclipse.egf.pattern.ui.ImageShop;
import org.eclipse.egf.pattern.ui.editors.providers.PatternElementLabelProvider;
import org.eclipse.egf.pattern.utils.TemplateFileHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.graphics.Image;

/**
 * @author Matthieu Helleboid
 */
public class MethodCompareItem implements IStreamContentAccessor, ITypedElement, IEditableContent {
	
	private PatternMethod patternMethod;
	private String name;

	public MethodCompareItem(PatternMethod patternMethod) {
		this.patternMethod = patternMethod;
	}

	public InputStream getContents() throws CoreException {
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = TemplateModelFileHelper.getInputStream(patternMethod);
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				if (stringBuilder.length() > 0)
					stringBuilder.append("\n"); //$NON-NLS-1$
				stringBuilder.append(line); //$NON-NLS-1$
			}
			
			return new ByteArrayInputStream(stringBuilder.toString().getBytes());
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, null, e.getMessage(), e));
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public Image getImage() {
		return Activator.getDefault().getImage(ImageShop.IMG_METHOD);
	}

	public String getName() {
		if (name == null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(new PatternElementLabelProvider().getText(patternMethod.getPattern()));
			stringBuilder.append(".");
			stringBuilder.append(patternMethod.getName());
			name = stringBuilder.toString();
		}
		return name;
	}

	public String getType() {
		return ITypedElement.TEXT_TYPE;
	}

	public boolean isEditable() {
		return getFile().exists();
	}

	public ITypedElement replace(ITypedElement dest, ITypedElement src) {
		return dest;
	}

	public void setContent(byte[] newContent) {
		try {
			TemplateFileHelper.setContent(getFile(), new String(newContent));
		} catch (CoreException e) {
			Activator.getDefault().log(new Status(IStatus.ERROR, null, e.getMessage(), e));
		}
	}

	public IFile getFile() {
		URI templateURI = TemplateModelFileHelper.getTemplateURI(patternMethod);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(templateURI.toPlatformString(true)));
		return file;
	}
}