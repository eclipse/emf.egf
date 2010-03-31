package org.eclipse.egf.dev.pattern.actions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.egf.core.EGFCorePlugin;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.collector.PatternCollector;
import org.eclipse.egf.pattern.engine.TranslationHelper;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be
 * delegated to it.
 * 
 * @see IWorkbenchWindowActionDelegate
 */
public class TranslateAllAction implements IWorkbenchWindowActionDelegate {
    private IWorkbenchWindow window;

    /**
     * The constructor.
     */
    public TranslateAllAction() {
    }

    /**
     * The action has been activated. The argument of the
     * method represents the 'real' action sitting
     * in the workbench UI.
     * 
     * @see IWorkbenchWindowActionDelegate#run
     */
    public void run(IAction action) {
        // List<Pattern> result = new ArrayList<Pattern>(200);
        Set<Pattern> result = new HashSet<Pattern>(200);
        IPlatformFcore[] platformFcores = EGFCorePlugin.getPlatformFcores();
        ResourceSet resourceSet = new ResourceSetImpl();
        try {
            for (IPlatformFcore platformFcore : platformFcores) {
                URI uri = platformFcore.getURI();
                Resource res = resourceSet.getResource(uri, true);
                PatternCollector.INSTANCE.collect(res.getContents(), result, PatternCollector.EMPTY_ID_SET);
            }
            new TranslationHelper().translate(new ArrayList<Pattern>(result));
        } catch (Exception e) {
            MessageDialog.openError(window.getShell(), "Error", e.getMessage());
        }

    }

    /**
     * Selection in the workbench has been changed. We
     * can change the state of the 'real' action here
     * if we want, but this can only happen after
     * the delegate has been created.
     * 
     * @see IWorkbenchWindowActionDelegate#selectionChanged
     */
    public void selectionChanged(IAction action, ISelection selection) {
    }

    /**
     * We can use this method to dispose of any system
     * resources we previously allocated.
     * 
     * @see IWorkbenchWindowActionDelegate#dispose
     */
    public void dispose() {
    }

    /**
     * We will cache window object in order to
     * be able to provide parent shell for the message dialog.
     * 
     * @see IWorkbenchWindowActionDelegate#init
     */
    public void init(IWorkbenchWindow window) {
        this.window = window;
    }
}