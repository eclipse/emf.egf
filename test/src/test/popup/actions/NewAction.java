package test.popup.actions;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.pattern.extension.ExtensionHelper;
import org.eclipse.egf.pattern.extension.PatternExtension;
import org.eclipse.egf.pattern.jet.JetPatternFactory;
import org.eclipse.egf.pattern.jet.JetRunner_to_be_moved_to_model1;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class NewAction implements IObjectActionDelegate {

	static String DATA_FILE = "/test4/myPattern.xmi";
	
	private Shell shell;
	
	/**
	 * Constructor for Action1.
	 */
	public NewAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	private void createPattern() {
		List<PatternExtension> extensions = ExtensionHelper.getExtensions();
		List<Pattern> patterns = new JetPatternFactory().createDebugPattern3();
		
		XMIResourceImpl res = new XMIResourceImpl(URI.createPlatformResourceURI(DATA_FILE));
		res.getContents().addAll(patterns);
		try {
			res.save(Collections.EMPTY_MAP);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void run(IAction action) {
		createPattern();
		Pattern pattern = loadPattern();
		JetRunner_to_be_moved_to_model1 runner = new JetRunner_to_be_moved_to_model1();
		runner.setPattern(pattern);
		runner.translate();
	}

	/**
	 * @return
	 */
	private Pattern loadPattern() {
		XMIResourceImpl res = new XMIResourceImpl(URI.createPlatformResourceURI(DATA_FILE));
		try {
			res.load(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Pattern pattern = (Pattern)res.getContents().get(0);
		return pattern;
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
