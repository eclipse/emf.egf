/*******************************************************************************
 * Copyright (c) 2005, 2007 ILOG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Joel Cheuoua - Initial API and implementation
 *******************************************************************************/
package org.eclipse.jet.internal.editor.annotations;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

public class JETAnnotationModel extends ResourceMarkerAnnotationModel {
  private boolean fireChanges;

  public JETAnnotationModel(IResource resource) {
    super(resource);
    fireChanges = true;
  }

  public synchronized boolean isFireChanges() {
    return fireChanges;
  }

  public synchronized void setFireChanges(boolean b) {
    fireChanges = b;
  }

  public synchronized void addAnnotation(Annotation annotation, Position position) {
    try {
      addAnnotation(annotation, position, fireChanges);
    } catch (BadLocationException _ex) {
    }
  }

  public synchronized void removeAllAnnotations() {
    super.removeAllAnnotations(fireChanges);
  }

  public synchronized void removeAnnotation(Annotation annotation) {
    super.removeAnnotation(annotation, fireChanges);
  }

  public MarkerAnnotation createMarkerAnnotation(IMarker marker) {
    return super.createMarkerAnnotation(marker);
  }

  public Position createPositionFromMarker(IMarker marker) {
    return super.createPositionFromMarker(marker);
  }

  public void fireAnnotationModelChanged() {
    fireModelChanged();
  }

}