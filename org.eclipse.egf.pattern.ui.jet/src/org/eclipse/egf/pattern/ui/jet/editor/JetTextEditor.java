/**
 * <copyright>
 * 
 * Copyright (c) 2009 Thales Corporate Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.pattern.ui.jet.editor;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.jet.internal.editor.JETTextEditor;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Yahong Song - Soyatec
 * 
 */
public class JetTextEditor extends JETTextEditor {

    private RefreshUIJob job;

    private Pattern pattern;

    public JetTextEditor(Pattern pattern) throws CoreException, IOException {
        super();
        this.pattern = pattern;
        setSourceViewerConfiguration(new JetSourceViewerConfigure(this));
        setDocumentProvider(new JetDocumentProvider(this));
    }

    public Pattern getPattern() {
        return pattern;
    }

    /**
     * @return the source viewer used by this editor
     */
    public final ISourceViewer getViewer() {
        return getSourceViewer();
    }

    @Override
    public void createPartControl(Composite parent) {
        super.createPartControl(parent);
        // StyledText textWidget = getSourceViewer().getTextWidget();
        // textWidget.addModifyListener((ModifyListener) new
        // JetModifyListener());
    }

    class JetModifyListener implements ModifyListener {
        public void modifyText(ModifyEvent e) {
            if (job == null) {
                job = new RefreshUIJob("RefreshTemplateEditor");
            }
            job.start();
        }
    }

    class RefreshUIJob extends Job {

        private long timestamp = -1;

        private boolean lazy = false;

        public RefreshUIJob(String name) {
            super(name);
        }

        private void start() {
            if (!lazy) {
                schedule(1000);
            } else if (System.currentTimeMillis() - timestamp > 999 && !lazy) {
                lazy = true;
            }
            timestamp = System.currentTimeMillis();
        }

        protected IStatus run(IProgressMonitor monitor) {
            System.out.println("Refresh_begin");
            JetEditorHelper.refreshPublicTemplateEditor(JetTextEditor.this);
            if (lazy) {
                schedule();
                lazy = false;
            }
            System.out.println("Refresh_end");
            return Status.OK_STATUS;
        }
    }

    public RefreshUIJob getJob() {
        return job;
    }

}
