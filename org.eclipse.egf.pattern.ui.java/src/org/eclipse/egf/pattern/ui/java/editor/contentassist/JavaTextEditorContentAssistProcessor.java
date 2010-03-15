/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S. and other
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 *      XiaoRu Chen, Soyatec 
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.java.editor.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.ui.editors.templateEditor.TemplateEditorUtility;
import org.eclipse.egf.pattern.ui.editors.templateEditor.computer.PatternParameterProposalComputer;
import org.eclipse.egf.pattern.ui.editors.templateEditor.computer.PatternVariableProposalComputer;
import org.eclipse.egf.pattern.ui.java.editor.JavaTextEditor;
import org.eclipse.egf.pattern.ui.java.editor.JavaTextEditorHelper;
import org.eclipse.egf.pattern.ui.java.editor.contentassist.computer.JavaTypeProposalComputer;
import org.eclipse.egf.pattern.ui.java.template.JavaTemplateEditor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.ui.javaeditor.EditorUtility;
import org.eclipse.jdt.internal.ui.text.java.AbstractJavaCompletionProposal;
import org.eclipse.jdt.internal.ui.text.java.LazyGenericTypeProposal;
import org.eclipse.jdt.internal.ui.text.template.contentassist.TemplateProposal;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JavaTextEditorContentAssistProcessor implements IContentAssistProcessor {

    private JavaTextEditor editor;

    private IEditorPart templateEditorPart;

    private Pattern pattern;

    private final static String JAVA_LANG_PAKAGE = "java.lang.";

    private final static String JAVA_UTIL_PAKAGE = "java.util.";

    private char[] fCompletionAutoActivationCharacters;

    public JavaTextEditorContentAssistProcessor(JavaTextEditor editor) {
        this.editor = editor;
        fCompletionAutoActivationCharacters = editor.getEditorPreferenceStore().getString("content_assist_autoactivation_triggers_java").toCharArray();
    }

    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
        MultiPageEditorPart multiPageEditorPart = JavaTextEditorHelper.getMultiPageEditorPart(editor);
        if (multiPageEditorPart == null)
            return null;
        templateEditorPart = ((JavaTemplateEditor) multiPageEditorPart).getTemplateFileEditorPart();
        refreshPublicTemplateEditor();

        pattern = editor.getPattern();

        List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();

        // Get the pattern parameter proposals.
        PatternParameterProposalComputer parameterProposalComputer = new PatternParameterProposalComputer(viewer, offset, pattern);
        addProposal(proposals, parameterProposalComputer.computeProposal());

        // Get the pattern variable proposals.
        PatternVariableProposalComputer variableProposalComputer = new PatternVariableProposalComputer(viewer, offset, pattern);
        addProposal(proposals, variableProposalComputer.computeProposal());

        // Get the java type proposals.
        int mappingOffset = JavaTextEditorHelper.getMappingOffset(pattern, editor, offset);
        JavaTypeProposalComputer javaTypeProposalComputer = new JavaTypeProposalComputer(viewer, mappingOffset, templateEditorPart);
        List<ICompletionProposal> computeProposals = javaTypeProposalComputer.computeProposal();
        List<ICompletionProposal> javaTypeProposals = updateProposalOffset(computeProposals, offset, mappingOffset);
        addProposal(proposals, javaTypeProposals);

        ICompletionProposal[] result = null;

        if (proposals.size() == 0) {
            // result = new ICompletionProposal[1];
            //            JavaCompletionProposal propsal = new JavaCompletionProposal("", 0, 0, null, JavaTextEditorMessages.JavaTextEditorContentAssistProcessor_No_Default_proposals, 0); //$NON-NLS-1$
            // result[0] = propsal;
        } else {
            result = new ICompletionProposal[proposals.size()];
            for (int i = 0; i < proposals.size(); i++) {
                result[i] = proposals.get(i);
            }
        }
        return result;

    }

    /**
     * Update the offset of the proposal to mapping current methodEditor.
     * 
     * @param mappingOffset
     * @param offset
     */
    private List<ICompletionProposal> updateProposalOffset(List<ICompletionProposal> computeProposals, int offset, int mappingOffset) {
        if (computeProposals == null)
            return null;
        List<ICompletionProposal> newProposals = new ArrayList<ICompletionProposal>();
        int activePageIndex = JavaTextEditorHelper.getActivePageIndex(editor);
        for (ICompletionProposal computeProposal : computeProposals) {
            if (computeProposal instanceof AbstractJavaCompletionProposal) {
                AbstractJavaCompletionProposal currentPropsal = (AbstractJavaCompletionProposal) computeProposal;
                int replacementOffset = currentPropsal.getReplacementOffset() - (mappingOffset - offset);
                currentPropsal.setReplacementOffset(replacementOffset);
            }
            if (!(activePageIndex == 0) && computeProposal instanceof LazyGenericTypeProposal) {
                CompletionProposal javaProposal = changeLazyGenericTypeToJavaProposal(computeProposals, (LazyGenericTypeProposal) computeProposal);
                newProposals.add(javaProposal);
            } else if (computeProposal instanceof TemplateProposal) {
                CompletionProposal templateProposal = changTemplateToJavaProposal(computeProposals, (TemplateProposal) computeProposal, offset);
                newProposals.add(templateProposal);
            } else {
                newProposals.add(computeProposal);
            }
        }

        return newProposals;
    }

    private List<ICompletionProposal> reverseProposals(List<ICompletionProposal> computeProposals) {
        List<ICompletionProposal> newComputeProposals = new ArrayList<ICompletionProposal>();
        for (int i = computeProposals.size() - 1; i >= 0; i--) {
            newComputeProposals.add(computeProposals.get(i));
        }
        return newComputeProposals;
    }

    /**
     * Change the LazyGenericTypeProposal into CompletionProposal.
     * 
     * @param computeProposals
     * @param lazyGenericTypeProposal
     * @return
     */
    private CompletionProposal changeLazyGenericTypeToJavaProposal(List<ICompletionProposal> computeProposals, LazyGenericTypeProposal lazyGenericTypeProposal) {
        String replacementString = lazyGenericTypeProposal.getReplacementString();
        int replacementOffset = lazyGenericTypeProposal.getReplacementOffset();
        int replacementLength = lazyGenericTypeProposal.getReplacementLength();
        Image image = lazyGenericTypeProposal.getImage();
        String displayString = lazyGenericTypeProposal.getDisplayString();
        String qualifiedTypeName = lazyGenericTypeProposal.getQualifiedTypeName();
        if ((JAVA_LANG_PAKAGE + replacementString).equals(qualifiedTypeName) || (JAVA_UTIL_PAKAGE + replacementString).equals(qualifiedTypeName)) {
            qualifiedTypeName = replacementString;
        }
        CompletionProposal proposal = new CompletionProposal(qualifiedTypeName, replacementOffset, replacementLength, qualifiedTypeName.length(), image, displayString, null, null);
        return proposal;
    }

    /**
     * Change the TemplateProposal into CompletionProposal.
     * 
     * @param computeProposals
     * @param templateProposal
     * @param offset
     * @return
     */
    private CompletionProposal changTemplateToJavaProposal(List<ICompletionProposal> computeProposals, TemplateProposal templateProposal, int offset) {
        String replaceString = templateProposal.getAdditionalProposalInfo();
        Image image = templateProposal.getImage();
        String displayString = templateProposal.getDisplayString();
        // IDocument doc = editor.getViewer().getDocument();
        // JavaDocumentReader reader = new JavaDocumentReader(doc, offset);
        // char c = reader.readBackward();
        String allWords[] = TemplateEditorUtility.getAllWords(editor.getViewer(), offset);
        List<ICompletionProposal> parameterProposals = new ArrayList<ICompletionProposal>();
        if (allWords.length > 0) {
            String replacedWord = allWords[0];
            int replacementOffset = offset - replacedWord.length();
            CompletionProposal proposal = new CompletionProposal(replaceString, replacementOffset, replacedWord.length(), replaceString.length(), image, displayString, null, null);
            return proposal;
        }
        return null;
    }

    private void refreshPublicTemplateEditor() {
        IEditorInput editorInput = templateEditorPart.getEditorInput();
        if (editorInput instanceof IFileEditorInput) {
            IFile templateFile = ((IFileEditorInput) editorInput).getFile();
            JavaTextEditorHelper.refreshPublicTemplateEditor(pattern, templateFile, editor);
        }
    }

    /**
     * Add the find new proposals in to proposals.
     */
    private void addProposal(List proposals, List newProposals) {
        if (newProposals != null && newProposals.size() != 0) {
            proposals.addAll(newProposals);
        }
    }

    /**
     * Returns the compilation unit that content assist is invoked in,
     * <code>null</code> if there
     * is none.
     * 
     * @return the compilation unit that content assist is invoked in, possibly
     *         <code>null</code>
     */
    public ICompilationUnit getCompilationUnit() {
        IEditorPart fEditor = null;
        if (fEditor == null)
            return null;
        ICompilationUnit fCU = null;
        IJavaElement je = EditorUtility.getEditorInputJavaElement(fEditor, false);
        if (je instanceof ICompilationUnit)
            fCU = (ICompilationUnit) je;
        return fCU;
    }

    public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {

        return null;
    }

    public char[] getCompletionProposalAutoActivationCharacters() {

        return fCompletionAutoActivationCharacters;
    }

    public char[] getContextInformationAutoActivationCharacters() {

        return null;
    }

    public IContextInformationValidator getContextInformationValidator() {

        return null;
    }

    public String getErrorMessage() {

        return null;
    }

}
