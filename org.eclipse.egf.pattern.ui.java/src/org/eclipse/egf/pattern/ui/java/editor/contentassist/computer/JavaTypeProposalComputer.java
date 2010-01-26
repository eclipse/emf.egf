/**
 * <copyright>
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.java.editor.contentassist.computer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.egf.pattern.ui.editors.templateEditor.computer.AbstractProposalComputer;
import org.eclipse.jdt.core.CompletionProposal;
import org.eclipse.jdt.core.CompletionRequestor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.javaeditor.JavaEditor;
import org.eclipse.jdt.internal.ui.text.JavaHeuristicScanner;
import org.eclipse.jdt.internal.ui.text.Symbols;
import org.eclipse.jdt.internal.ui.text.java.FillArgumentNamesCompletionProposalCollector;
import org.eclipse.jdt.internal.ui.text.java.JavaMethodCompletionProposal;
import org.eclipse.jdt.internal.ui.text.java.ProposalSorterRegistry;
import org.eclipse.jdt.internal.ui.text.java.TemplateCompletionProposalComputer;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jdt.ui.text.java.CompletionProposalCollector;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.JavaContentAssistInvocationContext;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.IEditorPart;

/**
 * @author XiaoRu Chen - Soyatec
 * 
 */
public class JavaTypeProposalComputer extends AbstractProposalComputer {
    private IProgressMonitor fTimeoutProgressMonitor;
    private int offset;
    private IEditorPart templateEditorPart;
    private static final long JAVA_CODE_ASSIST_TIMEOUT = Long.getLong("org.eclipse.jdt.ui.codeAssistTimeout", 5000).longValue(); // ms //$NON-NLS-1$

    public JavaTypeProposalComputer(ITextViewer viewer, int offset, IEditorPart templateEditorPart) {
        this.offset = offset;
        this.templateEditorPart = templateEditorPart;
        fTimeoutProgressMonitor = createTimeoutProgressMonitor(JAVA_CODE_ASSIST_TIMEOUT);
    }

    public List<ICompletionProposal> computeProposal() {
        if (templateEditorPart == null || ((JavaEditor) templateEditorPart).getViewer() == null)
            return null;

        JavaContentAssistInvocationContext context = createContext(offset);
        ICompilationUnit unit = context.getCompilationUnit();
        if (unit == null)
            return null;

        List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();

        List<ICompletionProposal> javaTypeProposal = computeJavaTypeProposal(unit, context);
        proposals.addAll(javaTypeProposal);
        List<ICompletionProposal> templateProposal = computeTemplateProposal(context);
        proposals.addAll(templateProposal);
        // Sort proposals.
        ProposalSorterRegistry.getDefault().getCurrentSorter().sortProposals(context, proposals);

        return proposals;
    }

    private List<ICompletionProposal> computeJavaTypeProposal(ICompilationUnit unit, JavaContentAssistInvocationContext context) {
        ITextViewer viewer = context.getViewer();

        CompletionProposalCollector collector = createCollector(context);
        collector.setInvocationContext(context);

        // Allow completions for unresolved types - since 3.3
        collector.setAllowsRequiredProposals(CompletionProposal.FIELD_REF, CompletionProposal.TYPE_REF, true);
        collector.setAllowsRequiredProposals(CompletionProposal.FIELD_REF, CompletionProposal.TYPE_IMPORT, true);
        collector.setAllowsRequiredProposals(CompletionProposal.FIELD_REF, CompletionProposal.FIELD_IMPORT, true);

        collector.setAllowsRequiredProposals(CompletionProposal.METHOD_REF, CompletionProposal.TYPE_REF, true);
        collector.setAllowsRequiredProposals(CompletionProposal.METHOD_REF, CompletionProposal.TYPE_IMPORT, true);
        collector.setAllowsRequiredProposals(CompletionProposal.METHOD_REF, CompletionProposal.METHOD_IMPORT, true);

        collector.setAllowsRequiredProposals(CompletionProposal.CONSTRUCTOR_INVOCATION, CompletionProposal.TYPE_REF, true);

        collector.setAllowsRequiredProposals(CompletionProposal.ANONYMOUS_CLASS_CONSTRUCTOR_INVOCATION, CompletionProposal.TYPE_REF, true);
        collector.setAllowsRequiredProposals(CompletionProposal.ANONYMOUS_CLASS_DECLARATION, CompletionProposal.TYPE_REF, true);

        collector.setAllowsRequiredProposals(CompletionProposal.TYPE_REF, CompletionProposal.TYPE_REF, true);

        setCollectorIgnored(collector);

        // Set the favorite list to propose static members - since 3.3
        collector.setFavoriteReferences(getFavoriteStaticMembers());

        try {
            Point selection = viewer.getSelectedRange();
            if (selection.y > 0)
                collector.setReplacementLength(selection.y);
            unit.codeComplete(offset, collector, fTimeoutProgressMonitor);
        } catch (OperationCanceledException x) {
        } catch (JavaModelException x) {
        }

        ICompletionProposal[] javaProposals = collector.getJavaCompletionProposals();
        int contextInformationOffset = guessMethodContextInformationPosition(context, offset);
        if (contextInformationOffset != offset) {
            for (int i = 0; i < javaProposals.length; i++) {
                if (javaProposals[i] instanceof JavaMethodCompletionProposal) {
                    JavaMethodCompletionProposal jmcp = (JavaMethodCompletionProposal) javaProposals[i];
                    jmcp.setContextInformationPosition(contextInformationOffset);
                }
            }
        }
        return Arrays.asList(javaProposals);
    }

    private List<ICompletionProposal> computeTemplateProposal(JavaContentAssistInvocationContext context) {
        // Get the template proposals.
        TemplateCompletionProposalComputer templateCompletionProposalComputer = new TemplateCompletionProposalComputer();
        List computeCompletionProposals = templateCompletionProposalComputer.computeCompletionProposals(context, null);
        return computeCompletionProposals;
    }

    private void setCollectorIgnored(CompletionProposalCollector collector) {
        collector.setIgnored(CompletionProposal.ANNOTATION_ATTRIBUTE_REF, false);
        collector.setIgnored(CompletionProposal.ANONYMOUS_CLASS_DECLARATION, false);
        collector.setIgnored(CompletionProposal.ANONYMOUS_CLASS_CONSTRUCTOR_INVOCATION, false);
        collector.setIgnored(CompletionProposal.FIELD_REF, false);
        collector.setIgnored(CompletionProposal.FIELD_REF_WITH_CASTED_RECEIVER, false);
        collector.setIgnored(CompletionProposal.KEYWORD, false);
        collector.setIgnored(CompletionProposal.LABEL_REF, false);
        collector.setIgnored(CompletionProposal.LOCAL_VARIABLE_REF, false);
        collector.setIgnored(CompletionProposal.METHOD_DECLARATION, false);
        collector.setIgnored(CompletionProposal.METHOD_NAME_REFERENCE, false);
        collector.setIgnored(CompletionProposal.METHOD_REF, false);
        collector.setIgnored(CompletionProposal.CONSTRUCTOR_INVOCATION, false);
        collector.setIgnored(CompletionProposal.METHOD_REF_WITH_CASTED_RECEIVER, false);
        collector.setIgnored(CompletionProposal.PACKAGE_REF, false);
        collector.setIgnored(CompletionProposal.POTENTIAL_METHOD_DECLARATION, false);
        collector.setIgnored(CompletionProposal.VARIABLE_DECLARATION, false);
        collector.setIgnored(CompletionProposal.TYPE_REF, false);
    }

    /**
     * Creates the context that is passed to the completion proposal
     * computers.
     * 
     * @param viewer
     *            the viewer that content assist is invoked on
     * @param offset
     *            the content assist offset
     * @return the context to be passed to the computers
     */
    protected JavaContentAssistInvocationContext createContext(int offset) {
        if (templateEditorPart instanceof JavaEditor) {
            JavaContentAssistInvocationContext javaContentAssistInvocationContext = new JavaContentAssistInvocationContext(((JavaEditor) templateEditorPart).getViewer(), offset, templateEditorPart);
            return javaContentAssistInvocationContext;
        }
        return null;
    }

    /**
     * Creates the collector used to get proposals from core.
     * 
     * @param context
     *            the context
     * @return the collector
     */
    protected CompletionProposalCollector createCollector(JavaContentAssistInvocationContext context) {
        if (PreferenceConstants.getPreferenceStore().getBoolean(PreferenceConstants.CODEASSIST_FILL_ARGUMENT_NAMES))
            return new FillArgumentNamesCompletionProposalCollector(context);
        else
            return new CompletionProposalCollector(context.getCompilationUnit(), true);
    }

    /**
     * Returns the array with favorite static members.
     * 
     * @return the <code>String</code> array with with favorite static members
     * @see CompletionRequestor#setFavoriteReferences(String[])
     * @since 3.3
     */
    private String[] getFavoriteStaticMembers() {
        String serializedFavorites = PreferenceConstants.getPreferenceStore().getString(PreferenceConstants.CODEASSIST_FAVORITE_STATIC_MEMBERS);
        if (serializedFavorites != null && serializedFavorites.length() > 0)
            return serializedFavorites.split(";"); //$NON-NLS-1$
        return new String[0];
    }

    protected final int guessMethodContextInformationPosition(ContentAssistInvocationContext context, int offset) {
        final int contextPosition = context.getInvocationOffset();

        IDocument document = context.getDocument();
        if ("".equals(document.get())) {
            return offset;
        }
        JavaHeuristicScanner scanner = new JavaHeuristicScanner(document);
        int bound = Math.max(-1, contextPosition - 200);

        // try the innermost scope of parentheses that looks like a method call
        int pos = contextPosition - 1;
        do {
            try {
                int paren = scanner.findOpeningPeer(pos, bound, '(', ')');
                if (paren == JavaHeuristicScanner.NOT_FOUND)
                    break;
                int token = scanner.previousToken(paren - 1, bound);
                // next token must be a method name (identifier) or the closing
                // angle of a
                // constructor call of a parameterized type.
                if (token == Symbols.TokenIDENT || token == Symbols.TokenGREATERTHAN)
                    return paren + 1;
                pos = paren - 1;
            } catch (Exception e) {
                return offset;
            }

        } while (true);

        return contextPosition;
    }

    /**
     * Returns a new progress monitor that get cancelled after the given
     * timeout.
     * 
     * @param timeout
     *            the timeout in ms
     * @return the progress monitor
     * @since 3.5
     */
    private IProgressMonitor createTimeoutProgressMonitor(final long timeout) {
        return new IProgressMonitor() {

            private long fEndTime;

            public void beginTask(String name, int totalWork) {
                fEndTime = System.currentTimeMillis() + timeout;
            }

            public boolean isCanceled() {
                return fEndTime <= System.currentTimeMillis();
            }

            public void done() {
            }

            public void internalWorked(double work) {
            }

            public void setCanceled(boolean value) {
            }

            public void setTaskName(String name) {
            }

            public void subTask(String name) {
            }

            public void worked(int work) {
            }
        };
    }
}
