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
package org.eclipse.jet.internal.editor.contentassist;

import java.util.*;

import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jet.taglib.*;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class JETCustomTagAssistProcessor extends AbstractXMLTagsBasedAssistProcessor {

  private String rootTags[];
  private String tagAttributes[][];

  public JETCustomTagAssistProcessor(JETTextEditor editor) {
    super(editor);
  }

  public String[] getRootTags() {
    if (rootTags == null) {
      Collection tagNames = new ArrayList();
      String tagLibIds[] = TagLibraryManager.getInstance().getKnownLibraryIds();
      for (int i = 0; i < tagLibIds.length; i++) {
        String id = tagLibIds[i];
        TagLibrary tagLib = TagLibraryManager.getInstance().getTagLibrary(id, true);
        String names[] = tagLib.getTagNames();
        for (int j = 0; j < names.length; j++) {
          String name = names[j];
          tagNames.add((new StringBuilder(String.valueOf(tagLib.getDefaultPrefix()))).append(":").append(name)
              .toString());
        }

      }

      rootTags = new String[tagNames.size()];
      tagNames.toArray(rootTags);
    }
    return rootTags;
  }

  public String[][] getTagAttributes() {
    if (tagAttributes == null) {
      Map tagAttributesMap = new HashMap();
      String tagLibIds[] = TagLibraryManager.getInstance().getKnownLibraryIds();
      for (int i = 0; i < tagLibIds.length; i++) {
        String id = tagLibIds[i];
        TagLibrary tagLib = TagLibraryManager.getInstance().getTagLibrary(id, true);
        String names[] = tagLib.getTagNames();
        for (int j = 0; j < names.length; j++) {
          String name = names[j];
          TagDefinition tagDef = tagLib.getTagDefinition(name);
          Collection tagAttributeDefinitions = tagDef.getAttributeDefinitions();
          String attributeNames[] = new String[tagAttributeDefinitions.size() + 1];
          attributeNames[0] = (new StringBuilder(String.valueOf(tagLib.getDefaultPrefix()))).append(":").append(name)
              .toString();
          int cpt = 1;
          for (Iterator iterator = tagAttributeDefinitions.iterator(); iterator.hasNext();) {
            TagAttributeDefinition tagAttributeDef = (TagAttributeDefinition) iterator.next();
            attributeNames[cpt++] = tagAttributeDef.getName();
          }

          tagAttributesMap.put((new StringBuilder(String.valueOf(tagLib.getDefaultPrefix()))).append(":").append(name)
              .toString(), attributeNames);
        }

      }

      int cpt = 0;
      tagAttributes = new String[tagAttributesMap.size()][];
      for (Iterator iterator = tagAttributesMap.keySet().iterator(); iterator.hasNext();) {
        String tagName = (String) iterator.next();
        String attributeNames[] = (String[]) tagAttributesMap.get(tagName);
        tagAttributes[cpt++] = attributeNames;
      }

    }
    return tagAttributes;
  }

  protected char getRootTagPrevChar() {
    return '<';
  }

  public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
    return null;
  }

  public char[] getCompletionProposalAutoActivationCharacters() {
    return null;
  }

  public char[] getContextInformationAutoActivationCharacters() {
    return null;
  }

  public IContextInformationValidator getContextInformationValidator() {
    return null;
  }
}