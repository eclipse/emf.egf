/**
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 */
package org.eclipse.egf.pattern.templates;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.egf.common.helper.EMFHelper;
import org.eclipse.egf.common.helper.JavaHelper;
import org.eclipse.egf.core.fcore.IPlatformFcore;
import org.eclipse.egf.core.pattern.PatternPreferences;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.processor.IFcoreProcessor;
import org.eclipse.egf.model.EGFModelPlugin;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.fcore.util.FcoreResourceImpl;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.model.pattern.template.TemplateModelFileHelper;
import org.eclipse.egf.pattern.EGFPatternPlugin;
import org.eclipse.egf.pattern.common.java.BaseJavaAssemblyHelper;
import org.eclipse.egf.pattern.engine.TranslationHelper;
import org.eclipse.egf.pattern.l10n.EGFPatternMessages;
import org.eclipse.egf.pattern.utils.TemplateFileHelper;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.ChangeKind;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.ListChange;
import org.eclipse.emf.ecore.change.ResourceChange;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

/**
 * @author Xavier Maysonnave
 *
 */
public class TemplateProcessor implements IFcoreProcessor {

    public TemplateProcessor() {
        // Nothing to do
    }

    // Container analysis for Patterns
    protected List<Pattern> getPatterns(List<? extends Object> objects) {
        List<Pattern> patterns = new UniqueEList<Pattern>();
        for (Object object : objects) {
            // FactoryComponent
            if (object instanceof FactoryComponent) {
                patterns.addAll(getPatterns(Collections.singletonList(((FactoryComponent) object).getViewpointContainer())));
                // ViwpointContainer
            } else if (object instanceof ViewpointContainer) {
                patterns.addAll(getPatterns(((ViewpointContainer) object).getViewpoints()));
                // PatternViewpoint
            } else if (object instanceof PatternViewpoint) {
                patterns.addAll(getPatterns(((PatternViewpoint) object).getLibraries()));
                // PatternLibrary
            } else if (object instanceof PatternLibrary) {
                patterns.addAll(getPatterns(((PatternLibrary) object).getElements()));
                // Pattern
            } else if (object instanceof Pattern) {
                patterns.addAll(Collections.singletonList((Pattern) object));
            }
        }
        return patterns;
    }

    protected void processPatternToRemove(EObject eObject, FeatureChange change, Map<Pattern, PatternLibrary> deletedPatterns, List<Pattern> patternsToUpdate) {
        if (eObject == null || change == null) {
            return;
        }
        List<Object> values = null;
        if (change.getFeature().isMany()) {
            values = new BasicEList<Object>((Collection<?>) eObject.eGet(change.getFeature()));
        } else {
            values = Collections.singletonList(eObject.eGet(change.getFeature()));
        }
        LOOP: for (Object object : values) {
            if (change.getListChanges().isEmpty() == false) {
                for (ListChange listChange : change.getListChanges()) {
                    if (listChange.getKind() == ChangeKind.REMOVE_LITERAL) {
                        if (((List<?>) change.getValue()).isEmpty() == false) {
                            if (((List<?>) change.getValue()).contains(object) == false) {
                                processPatternMethodToRemove(object, deletedPatterns, patternsToUpdate);
                                continue LOOP;
                            }
                        }
                    }
                }
            } else {
                processPatternMethodToRemove(object, deletedPatterns, patternsToUpdate);
            }
        }
    }

    protected void processPatternMethodToRemove(Object object, Map<Pattern, PatternLibrary> deletedPatterns, List<Pattern> patternsToUpdate) {
        if (object instanceof PatternMethod) {
            processPatternConstraint(((PatternMethod) object).getPattern(), deletedPatterns, patternsToUpdate);
        } else {
            for (Pattern pattern : getPatterns(Collections.singletonList(object))) {
                processPatternConstraint(pattern, deletedPatterns, patternsToUpdate);
            }
        }
    }

    protected void processPatternToRestore(EObject eObject, FeatureChange change, Set<Pattern> deletedPatterns, List<PatternMethod> methodsToDelete, List<PatternMethod> methodsToRestore) {
        if (eObject == null || change == null) {
            return;
        }
        List<Object> values = null;
        if (change.getFeature().isMany()) {
            values = new BasicEList<Object>((Collection<?>) eObject.eGet(change.getFeature()));
        } else {
            values = Collections.singletonList(eObject.eGet(change.getFeature()));
        }
        LOOP: for (Object object : values) {
            if (change.getListChanges().isEmpty() == false) {
                for (ListChange listChange : change.getListChanges()) {
                    if (listChange.getKind() == ChangeKind.ADD_LITERAL) {
                        if (listChange.getReferenceValues().isEmpty() == false) {
                            for (Object innerObject : listChange.getReferenceValues()) {
                                processPatternMethodToRestore(innerObject, deletedPatterns, methodsToDelete, methodsToRestore);
                            }
                        } else {
                            processPatternMethodToRestore(object, deletedPatterns, methodsToDelete, methodsToRestore);
                            continue LOOP;
                        }
                    }
                }
            } else {
                processPatternMethodToRestore(object, deletedPatterns, methodsToDelete, methodsToRestore);
            }
        }
    }

    protected void processPatternMethodToRestore(Object object, Set<Pattern> deletedPatterns, List<PatternMethod> methodsToDelete, List<PatternMethod> methodsToRestore) {
        if (object instanceof PatternMethod) {
            PatternMethod method = (PatternMethod) object;
            if (method.getPattern() == null || deletedPatterns.contains(method.getPattern()) == false) {
                processPatternMethodConstraint(method, methodsToDelete, methodsToRestore);
            }
        } else {
            for (Pattern pattern : getPatterns(Collections.singletonList(object))) {
                if (deletedPatterns.contains(pattern) == false) {
                    for (PatternMethod method : pattern.getMethods()) {
                        processPatternMethodConstraint(method, methodsToDelete, methodsToRestore);
                    }
                }
            }
        }
    }

    protected boolean processPatternConstraint(Pattern pattern, Map<Pattern, PatternLibrary> deletedPatterns, List<Pattern> patternsToUpdate) {
        if (pattern == null) {
            return false;
        }
        // Ignore deleted Pattern
        if (deletedPatterns.keySet().contains(pattern)) {
            return false;
        }
        // Analyse
        Pattern patternToRemove = null;
        LOOP: for (Pattern deletedPattern : deletedPatterns.keySet()) {
            // Populate
            List<URI> deletedURIs = new UniqueEList<URI>();
            for (PatternMethod deletedMethod : deletedPattern.getMethods()) {
                if (deletedMethod.getPatternFilePath() != null) {
                    deletedURIs.add(deletedMethod.getPatternFilePath());
                }
            }
            // Analyse
            for (PatternMethod method : pattern.getMethods()) {
                if (deletedURIs.contains(method.getPatternFilePath()) == false) {
                    continue LOOP;
                }
            }
            patternToRemove = deletedPattern;
            break LOOP;
        }
        // Matching, will be processed as an update
        if (patternToRemove != null) {
            deletedPatterns.remove(patternToRemove);
        }
        patternsToUpdate.add(pattern);
        return true;
    }

    protected void processPatternMethodConstraint(PatternMethod method, List<PatternMethod> methodsToDelete, List<PatternMethod> methodsToRestore) {
        if (method == null) {
            return;
        }
        //Ignore deleted PatternMethod
        if (methodsToDelete.contains(method)) {
            return;
        }
        methodsToRestore.add(method);
    }

    public void processPreUnload(Resource resource, ChangeDescription changeDescription) {

        // Nothing to process
        if (changeDescription == null || resource instanceof FcoreResourceImpl == false) {
            return;
        }

        // Not a project
        final IPlatformFcore fcore = ((FcoreResourceImpl) resource).getIPlatformFcore();
        if (fcore == null || fcore.getPlatformBundle().getProject() == null) {
            return;
        }

        final long startTime = System.currentTimeMillis();
        // Process
        final Set<Pattern> deletedPatterns = new HashSet<Pattern>();
        final List<PatternMethod> methodsToDelete = new UniqueEList<PatternMethod>();
        final List<PatternMethod> methodsToRestore = new UniqueEList<PatternMethod>();

        // Analyse PatternMethods to be removed
        for (EObject eObject : changeDescription.getObjectsToDetach()) {
            // PatternMethod
            if (eObject instanceof PatternMethod) {
                methodsToDelete.add((PatternMethod) eObject);
            }
            // Containers
            else {
                for (Pattern pattern : getPatterns(Collections.singletonList(eObject))) {
                    deletedPatterns.add(pattern);
                }
            }
        }

        // Analyse PatternMethods to be restored
        for (Map.Entry<EObject, EList<FeatureChange>> entry : changeDescription.getObjectChanges().entrySet()) {

            // Ignore
            if (changeDescription.getObjectsToAttach().contains(entry.getKey())) {
                continue;
            }

            // FactoryComponent
            if (entry.getKey() instanceof FactoryComponent) {
                for (FeatureChange change : entry.getValue()) {
                    if (change.getFeature() == FcorePackage.Literals.FACTORY_COMPONENT__VIEWPOINT_CONTAINER) {
                        processPatternToRestore(entry.getKey(), change, deletedPatterns, methodsToDelete, methodsToRestore);
                        break;
                    }
                }
            }
            // ViewpointContainer
            else if (entry.getKey() instanceof ViewpointContainer) {
                for (FeatureChange change : entry.getValue()) {
                    if (change.getFeature() == FcorePackage.Literals.VIEWPOINT_CONTAINER__VIEWPOINTS) {
                        processPatternToRestore(entry.getKey(), change, deletedPatterns, methodsToDelete, methodsToRestore);
                        break;
                    }
                }
            }
            // PatternViewpoint
            else if (entry.getKey() instanceof PatternViewpoint) {
                for (FeatureChange change : entry.getValue()) {
                    if (change.getFeature() == PatternPackage.Literals.PATTERN_VIEWPOINT__LIBRARIES) {
                        processPatternToRestore(entry.getKey(), change, deletedPatterns, methodsToDelete, methodsToRestore);
                        break;
                    }
                }
            }
            // PatternLibrary
            else if (entry.getKey() instanceof PatternLibrary) {
                // Process container update
                for (FeatureChange change : entry.getValue()) {
                    if (change.getFeature() == PatternPackage.Literals.PATTERN_LIBRARY__ELEMENTS) {
                        processPatternToRestore(entry.getKey(), change, deletedPatterns, methodsToDelete, methodsToRestore);
                        break;
                    }
                }
            }
            // Pattern
            else if (entry.getKey() instanceof Pattern) {
                Pattern pattern = (Pattern) entry.getKey();
                // Ignore deleted Patterns
                if (deletedPatterns.contains(pattern)) {
                    continue;
                }
                // Process
                for (PatternMethod method : pattern.getMethods()) {
                    processPatternMethodConstraint(method, methodsToDelete, methodsToRestore);
                }
            }
            // PatternMethod
            else if (entry.getKey() instanceof PatternMethod) {
                PatternMethod method = (PatternMethod) entry.getKey();
                if (method.getPattern() != null && deletedPatterns.contains(method.getPattern())) {
                    continue;
                }
                processPatternMethodConstraint(method, methodsToDelete, methodsToRestore);
            }

        }

        // Analyse PatternMethods to be restored
        for (ResourceChange change : changeDescription.getResourceChanges()) {
            for (ListChange listChange : change.getListChanges()) {
                if (listChange.getKind() == ChangeKind.ADD_LITERAL) {
                    if (listChange.getReferenceValues().isEmpty() == false) {
                        for (Object object : listChange.getReferenceValues()) {
                            for (Pattern pattern : getPatterns(Collections.singletonList(object))) {
                                for (PatternMethod method : pattern.getMethods()) {
                                    processPatternMethodConstraint(method, methodsToDelete, methodsToRestore);
                                }
                            }
                        }
                    } else {
                        for (Object object : change.getValue()) {
                            for (Pattern pattern : getPatterns(Collections.singletonList(object))) {
                                for (PatternMethod method : pattern.getMethods()) {
                                    processPatternMethodConstraint(method, methodsToDelete, methodsToRestore);
                                }
                            }
                        }
                    }
                }
            }
        }

        // Nothing to do
        if (deletedPatterns.isEmpty() && methodsToDelete.isEmpty() && methodsToRestore.isEmpty()) {
            return;
        }

        // Workspace Updates
        WorkspaceJob job = new WorkspaceJob(EGFPatternMessages.Template_processor) {

            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {

                SubMonitor subMonitor = SubMonitor.convert(monitor, (deletedPatterns.size() * 200) + (methodsToDelete.size() * 100) + (methodsToRestore.size() * 100));
                subMonitor.beginTask(null, (deletedPatterns.size() * 100) + (methodsToDelete.size() * 100) + (methodsToRestore.size() * 100));

                try {

                    // 1 - Remove java resource and Pattern
                    for (Pattern pattern : deletedPatterns) {
                        // Clean current or previous if any, package based on based on entry.getValue()
                        JavaHelper.deleteJavaResource(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), fcore.getPlatformBundle().getProject(), PatternPreferences.getGenerationFolderName(), BaseJavaAssemblyHelper.getPackageName(pattern.getContainer()),
                                BaseJavaAssemblyHelper.getClassName(pattern), true);
                        // Remove templates
                        TemplateModelFileHelper.removeTemplates(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), pattern.getMethods());
                    }

                    // 2 - Remove PatternMethods
                    TemplateModelFileHelper.removeTemplates(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), methodsToDelete);

                    // 3 - Restore templates if any 
                    if (methodsToRestore.isEmpty() == false) {
                        TemplateModelFileHelper.restoreTemplates(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), fcore, methodsToRestore);
                    }

                } catch (Throwable t) {
                    if (t instanceof CoreException) {
                        return ((CoreException) t).getStatus();
                    }
                    return EGFModelPlugin.getPlugin().newStatus(Status.ERROR, NLS.bind(EGFPatternMessages.Template_processor_fcore_execute_exception, fcore.getURI()), t);

                } finally {
                    monitor.done();
                }

                //Tracing
                long endTime = System.currentTimeMillis();
                long time = (endTime - startTime);
                if (EGFPatternPlugin.getDefault().isDebugging()) {
                    EGFPlatformPlugin.getDefault().logInfo(NLS.bind("TemplateProcessor.processPreUnload(...) _ in ''{0}'' ms", time));//$NON-NLS-1$
                }
                return Status.OK_STATUS;
            }

        };

        job.setRule(EMFHelper.getProject(resource));
        job.schedule();

    }

    public void processPostSave(Resource resource, ChangeDescription changeDescription) {

        // Nothing to process
        if (changeDescription == null || resource instanceof FcoreResourceImpl == false) {
            return;
        }

        // Not a project
        final IPlatformFcore fcore = ((FcoreResourceImpl) resource).getIPlatformFcore();
        if (fcore == null || fcore.getPlatformBundle().getProject() == null) {
            return;
        }

        // Process
        final long startTime = System.currentTimeMillis();
        final List<Pattern> patternsToUpdate = new UniqueEList<Pattern>();
        final List<PatternMethod> methodsToDelete = new UniqueEList<PatternMethod>();
        final Map<Pattern, PatternLibrary> deletedPatterns = new HashMap<Pattern, PatternLibrary>();
        final Map<PatternLibrary, FeatureChange> updatedLibraries = new HashMap<PatternLibrary, FeatureChange>();
        final Map<Pattern, FeatureChange> updatedPatterns = new HashMap<Pattern, FeatureChange>();

        // Analyse PatternMethods to be removed
        for (Iterator<EObject> it = changeDescription.getObjectsToAttach().iterator(); it.hasNext();) {
            Object object = it.next();
            // PatternMethod
            if (object instanceof PatternMethod) {
                if (changeDescription.getObjectChanges().keySet().contains(object) == false) {
                    methodsToDelete.add((PatternMethod) object);
                }
            }
            // Containers
            else {
                for (Pattern pattern : getPatterns(Collections.singletonList(object))) {
                    if (changeDescription == null || changeDescription.getObjectChanges().keySet().contains(pattern)) {
                        continue;
                    }
                    if (changeDescription.getObjectChanges().get(pattern) != null) {
                        for (FeatureChange change : changeDescription.getObjectChanges().get(pattern)) {
                            if (change.getFeature() == PatternPackage.Literals.PATTERN__CONTAINER) {
                                Object innerObject = change.getValue();
                                if (innerObject != null && innerObject instanceof PatternLibrary) {
                                    deletedPatterns.put(pattern, (PatternLibrary) innerObject);
                                    break;
                                }
                            }
                        }
                    } else {
                        PatternLibrary library = pattern.getContainer();
                        if (library != null) {
                            deletedPatterns.put(pattern, library);
                        }
                    }
                }
            }
        }

        // Analyse Pattern to be updated
        for (Map.Entry<EObject, EList<FeatureChange>> entry : changeDescription.getObjectChanges().entrySet()) {

            // Ignore
            if (changeDescription.getObjectsToAttach().contains(entry.getKey())) {
                continue;
            }

            // FactoryComponent
            if (entry.getKey() instanceof FactoryComponent) {
                for (FeatureChange change : entry.getValue()) {
                    if (change.getFeature() == FcorePackage.Literals.FACTORY_COMPONENT__VIEWPOINT_CONTAINER) {
                        processPatternToRemove(entry.getKey(), change, deletedPatterns, patternsToUpdate);
                        break;
                    }
                }
            }
            // ViewpointContainer
            else if (entry.getKey() instanceof ViewpointContainer) {
                for (FeatureChange change : entry.getValue()) {
                    if (change.getFeature() == FcorePackage.Literals.VIEWPOINT_CONTAINER__VIEWPOINTS) {
                        processPatternToRemove(entry.getKey(), change, deletedPatterns, patternsToUpdate);
                        break;
                    }
                }
            }
            // PatternViewpoint
            else if (entry.getKey() instanceof PatternViewpoint) {
                for (FeatureChange change : entry.getValue()) {
                    if (change.getFeature() == PatternPackage.Literals.PATTERN_VIEWPOINT__LIBRARIES) {
                        processPatternToRemove(entry.getKey(), change, deletedPatterns, patternsToUpdate);
                        break;
                    }
                }
            }
            // PatternLibrary
            else if (entry.getKey() instanceof PatternLibrary) {
                PatternLibrary library = (PatternLibrary) entry.getKey();
                for (FeatureChange change : entry.getValue()) {
                    // Process name update
                    if (change.getFeature() == FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME) {
                        updatedLibraries.put(library, change);
                        // Process PatternLibrary Content
                        for (Pattern pattern : library.getElements()) {
                            processPatternConstraint(pattern, deletedPatterns, patternsToUpdate);
                        }
                    }
                    // Process container update
                    else if (change.getFeature() == PatternPackage.Literals.PATTERN_LIBRARY__ELEMENTS) {
                        processPatternToRemove(library, change, deletedPatterns, patternsToUpdate);
                    }
                }
            }
            // Pattern
            else if (entry.getKey() instanceof Pattern) {
                Pattern pattern = (Pattern) entry.getKey();
                if (processPatternConstraint(pattern, deletedPatterns, patternsToUpdate)) {
                    // Process
                    for (FeatureChange change : entry.getValue()) {
                        // Process name update
                        if (change.getFeature() == FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME) {
                            updatedPatterns.put(pattern, change);
                        }
                        // Process container update
                        else if (change.getFeature() == PatternPackage.Literals.PATTERN__CONTAINER) {
                            updatedPatterns.put(pattern, change);
                        }
                    }
                }
            }
            // PatternMethod
            else if (entry.getKey() instanceof PatternMethod) {
                PatternMethod method = (PatternMethod) entry.getKey();
                // Ignore orphan PatternMethod
                if (method.getPattern() == null) {
                    continue;
                }
                for (Iterator<PatternMethod> it = methodsToDelete.iterator(); it.hasNext();) {
                    PatternMethod deletedMethod = it.next();
                    if (deletedMethod.getPatternFilePath().equals(method.getPatternFilePath())) {
                        it.remove();
                        break;
                    }
                }
                // Changed PatternMethods imply that Pattern should always be updated
                patternsToUpdate.add(method.getPattern());
            }

        }

        // Analyse ResourceChange for Pattern to be removed
        for (ResourceChange change : changeDescription.getResourceChanges()) {
            for (ListChange listChange : change.getListChanges()) {
                if (listChange.getKind() == ChangeKind.REMOVE_LITERAL) {
                    for (EObject eObject : change.getResource().getContents()) {
                        if (change.getValue().contains(eObject) == false && eObject instanceof FactoryComponent) {
                            for (Pattern pattern : getPatterns(Collections.singletonList(eObject))) {
                                processPatternConstraint(pattern, deletedPatterns, patternsToUpdate);
                            }
                        }
                    }
                }
            }
        }

        // Nothing to do
        if (deletedPatterns.isEmpty() && methodsToDelete.isEmpty() && updatedLibraries.isEmpty() && updatedPatterns.isEmpty() && patternsToUpdate.isEmpty()) {
            return;
        }

        // Workspace Updates
        WorkspaceJob job = new WorkspaceJob(EGFPatternMessages.Template_processor) {

            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {

                try {

                    SubMonitor subMonitor = SubMonitor.convert(monitor, (deletedPatterns.size() * 200) + (methodsToDelete.size() * 100) + (updatedLibraries.size() * 100) + (updatedPatterns.size() * 100) + (patternsToUpdate.size() * 100));
                    subMonitor.beginTask(null, (deletedPatterns.size() * 100) + (methodsToDelete.size() * 100) + (updatedLibraries.size() * 100) + (updatedPatterns.size() * 100) + (patternsToUpdate.size() * 100));

                    // 1 - Remove java resource and Pattern
                    for (Map.Entry<Pattern, PatternLibrary> entry : deletedPatterns.entrySet()) {
                        // Clean current or previous if any, package based on based on entry.getValue()
                        JavaHelper.deleteJavaResource(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), fcore.getPlatformBundle().getProject(), PatternPreferences.getGenerationFolderName(), BaseJavaAssemblyHelper.getPackageName((entry.getValue())),
                                BaseJavaAssemblyHelper.getClassName(entry.getKey()), true);
                        // Remove templates
                        TemplateModelFileHelper.removeTemplates(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), entry.getKey().getMethods());
                    }

                    // 2 - Remove PatternMethods
                    TemplateModelFileHelper.removeTemplates(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), methodsToDelete);

                    // 3 - Updated Name PatternLibrary
                    for (Map.Entry<PatternLibrary, FeatureChange> entry : updatedLibraries.entrySet()) {
                        JavaHelper.moveJavaResource(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), fcore.getPlatformBundle().getProject(), PatternPreferences.getGenerationFolderName(), BaseJavaAssemblyHelper.getPackageName(entry.getValue().getDataValue()), null,
                                BaseJavaAssemblyHelper.getPackageName(entry.getKey()), null, true);
                    }

                    // 4 - Move generated java artifacts if any
                    for (Map.Entry<Pattern, FeatureChange> entry : updatedPatterns.entrySet()) {
                        if (entry.getValue().getFeature() == FcorePackage.Literals.NAMED_MODEL_ELEMENT__NAME) {
                            JavaHelper.moveJavaResource(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), fcore.getPlatformBundle().getProject(), PatternPreferences.getGenerationFolderName(), BaseJavaAssemblyHelper.getPackageName(entry.getKey().getContainer()),
                                    BaseJavaAssemblyHelper.getClassName(entry.getValue().getDataValue()), BaseJavaAssemblyHelper.getPackageName(entry.getKey().getContainer()), BaseJavaAssemblyHelper.getClassName(entry.getKey()), true);
                        } else if (entry.getValue().getFeature() == PatternPackage.Literals.PATTERN__CONTAINER) {
                            JavaHelper.moveJavaResource(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), fcore.getPlatformBundle().getProject(), PatternPreferences.getGenerationFolderName(), BaseJavaAssemblyHelper.getPackageName(((PatternLibrary) entry.getValue().getValue())),
                                    BaseJavaAssemblyHelper.getClassName(entry.getKey()), BaseJavaAssemblyHelper.getPackageName(entry.getKey().getContainer()), BaseJavaAssemblyHelper.getClassName(entry.getKey()), true);
                        }
                    }

                    // 6 - Touch Patterns to update
                    if (patternsToUpdate.isEmpty() == false) {
                        TemplateFileHelper.touchHeaderTemplates(subMonitor.newChild(100, SubMonitor.SUPPRESS_NONE), fcore, TranslationHelper.getOrderedList(new HashSet<Pattern>(patternsToUpdate)));
                    }

                } catch (Throwable t) {
                    if (t instanceof CoreException) {
                        return ((CoreException) t).getStatus();
                    }
                    return EGFModelPlugin.getPlugin().newStatus(Status.ERROR, NLS.bind(EGFPatternMessages.Template_processor_fcore_execute_exception, fcore.getURI()), t);

                } finally {
                    monitor.done();
                }

                // Tracing
                long endTime = System.currentTimeMillis();
                long time = (endTime - startTime);
                if (EGFPatternPlugin.getDefault().isDebugging()) {
                    EGFPlatformPlugin.getDefault().logInfo(NLS.bind("TemplateProcessor.processPostSave(...) _ in ''{0}'' ms", time));//$NON-NLS-1$      
                    for (Pattern pattern : patternsToUpdate) {
                        EGFPatternPlugin.getDefault().logInfo(NLS.bind("Touched Pattern {0}", EcoreUtil.getURI(pattern)), 1); //$NON-NLS-1$
                    }
                }

                return Status.OK_STATUS;

            }

        };

        job.setRule(EMFHelper.getProject(resource));
        job.schedule();

    }

}
