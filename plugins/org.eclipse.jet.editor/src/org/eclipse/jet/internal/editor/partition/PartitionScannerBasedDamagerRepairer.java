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
package org.eclipse.jet.internal.editor.partition;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.*;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.rules.*;
import org.eclipse.swt.custom.StyleRange;

public class PartitionScannerBasedDamagerRepairer implements IPresentationDamager, IPresentationRepairer {

  protected IDocument document;
  protected IPartitionTokenScanner partitionScanner;
  protected ITokenScannerProvider tokenScannerProvider;
  protected TextAttribute defaultTextAttribute;
  
  public PartitionScannerBasedDamagerRepairer(IPartitionTokenScanner scanner, ITokenScannerProvider provider) {
    Assert.isNotNull(scanner);
    Assert.isNotNull(provider);
    partitionScanner = scanner;
    tokenScannerProvider = provider;
    defaultTextAttribute = new TextAttribute(null);
  }

  public void setDocument(IDocument document) {
    this.document = document;
  }

  public void setPartitionScanner(IPartitionTokenScanner partitionScanner) {
    this.partitionScanner = partitionScanner;
  }

  public void setTokenScannerProvider(ITokenScannerProvider provider) {
    tokenScannerProvider = provider;
  }

  public IRegion getDamageRegion(ITypedRegion partition, DocumentEvent e, boolean documentPartitioningChanged) {
    if (!documentPartitioningChanged)
      return new Region(partition.getOffset(), partition.getLength());
    else
      return partition;
  }

  public void createPresentation(TextPresentation presentation, ITypedRegion region) {
    partitionScanner.setRange(document, region.getOffset(), region.getLength());
    String lastContentType = null;
    int partitionScannerTokenLength = 0;
    int partitionScannerTokenOffset = region.getOffset();
    do {
      IToken partitionToken = partitionScanner.nextToken();
      if (partitionToken.isEOF()) {
        if (lastContentType != null) {
          ITokenScanner tokenScanner = tokenScannerProvider.getTokenScanner(lastContentType);
          if (tokenScanner == null)
            addRange(presentation, partitionScanner.getTokenOffset(), partitionScanner.getTokenLength(),
                defaultTextAttribute);
          else
            applyTokenScanner(presentation, partitionScannerTokenLength, partitionScannerTokenOffset, tokenScanner);
        }
        break;
      }
      String contentType = getTokenContentType(partitionToken);
      if (contentType == null)
        contentType = IDocument.DEFAULT_CONTENT_TYPE;
      if (contentType.equals(lastContentType)) {
        partitionScannerTokenLength += partitionScanner.getTokenLength();
      } else {
        if (lastContentType != null) {
          ITokenScanner tokenScanner = tokenScannerProvider.getTokenScanner(lastContentType);
          if (tokenScanner == null)
            addRange(presentation, partitionScanner.getTokenOffset(), partitionScanner.getTokenLength(),
                defaultTextAttribute);
          else
            applyTokenScanner(presentation, partitionScannerTokenLength, partitionScannerTokenOffset, tokenScanner);
        }
        lastContentType = contentType;
        partitionScannerTokenOffset = partitionScanner.getTokenOffset();
        partitionScannerTokenLength = partitionScanner.getTokenLength();
      }
    } while (true);
  }

  private void applyTokenScanner(TextPresentation presentation, int partitionScannerTokenLength,
      int partitionScannerTokenOffset, ITokenScanner tokenScanner) {
    int lastStart = partitionScannerTokenOffset;
    int length = 0;
    boolean firstToken = true;
    IToken lastToken = Token.UNDEFINED;
    TextAttribute lastAttribute = getTokenTextAttribute(lastToken);
    tokenScanner.setRange(document, partitionScannerTokenOffset, partitionScannerTokenLength);
    do {
      IToken token = tokenScanner.nextToken();
      if (!token.isEOF()) {
        TextAttribute attribute = getTokenTextAttribute(token);
        if (lastAttribute != null && lastAttribute.equals(attribute)) {
          length += tokenScanner.getTokenLength();
          firstToken = false;
        } else {
          if (!firstToken)
            addRange(presentation, lastStart, length, lastAttribute);
          firstToken = false;
          lastToken = token;
          lastAttribute = attribute;
          lastStart = tokenScanner.getTokenOffset();
          length = tokenScanner.getTokenLength();
        }
      } else {
        addRange(presentation, lastStart, length, lastAttribute);
        return;
      }
    } while (true);
  }

  protected String getTokenContentType(IToken token) {
    Object data = token.getData();
    if (data instanceof String)
      return (String) data;
    else
      return null;
  }

  protected TextAttribute getTokenTextAttribute(IToken token) {
    Object data = token.getData();
    if (data instanceof TextAttribute)
      return (TextAttribute) data;
    else
      return defaultTextAttribute;
  }

  protected void addRange(TextPresentation presentation, int offset, int length, TextAttribute attr) {
    if (attr != null) {
      int style = attr.getStyle();
      int fontStyle = style & 3;
      StyleRange styleRange = new StyleRange(offset, length, attr.getForeground(), attr.getBackground(), fontStyle);
      styleRange.strikeout = (style & 0x20000000) != 0;
      styleRange.underline = (style & 0x40000000) != 0;
      styleRange.font = attr.getFont();
      presentation.addStyleRange(styleRange);
    }
  }
}