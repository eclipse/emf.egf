/**
 * <copyright>
 *
 *  Copyright (c) 2009 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Thales Corporate Services S.A.S - Initial API and implementation
 *      Soyatec - Contribution
 *
 * </copyright>
 * 
 */

package org.eclipse.egf.pattern.internal.builders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.osgi.framework.Bundle;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.util.NLS;

import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.ExtensionPointHelper;
import org.eclipse.egf.common.helper.MathHelper;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.pattern.PatternActivator;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.internal.PatternRegistry;
import org.eclipse.egf.pattern.internal.PatternTemplateRegistry;
import org.eclipse.egf.pattern.production.GeneratedContentHelper;
import org.eclipse.egf.pattern.production.PatternTemplateProducer;


public class PatternTemplateBuilder extends IncrementalProjectBuilder {
  
  private static boolean DEBUG = PatternActivator.getDefault().isDebugging();
  
  private static IProject[] EMPTY_LIST = new IProject [0];

  private BinaryGeneratedPatternFolderVisitor _patternVisitor = new BinaryGeneratedPatternFolderVisitor();
      
  private IPath _binaryOutputPatternPath;
  
  private IJavaProject _javaProject;
    
  private Map<String, IDescriptor> _patterns;
  
  private Map<String, IDescriptor> _patternTemplates;  

  class BinaryGeneratedPatternFolderVisitor implements IResourceDeltaVisitor {
    
    private Collection<IDescriptor> _generate = new ArrayList<IDescriptor>();
        
    private Collection<IDescriptor> _clean = new ArrayList<IDescriptor>();    

		public boolean visit(IResourceDelta delta) throws CoreException {
			if (delta != null) {
				int kind = delta.getKind();
				IResource resource = delta.getResource();
				// Process Folders who contain Pattern model generated classes
				if (resource.getType() == IResource.FOLDER) {
					if (_binaryOutputPatternPath.toString().startsWith(resource.getFullPath().toString())) {
						// Parent folder, Deeper analysis
						return true;
					} else if (_binaryOutputPatternPath.equals(resource.getFullPath())) {
						// Root folder of pattern model generated classes
						// Everything has been deleted
						if (kind == IResourceDelta.REMOVED) {
							// Clean all existing pattern templates
							_clean.addAll(getPatternTemplates().values());
							// Stop deeper analysis
							return false;
						}
						// Deeper analysis
						return true;
					} else if (resource.getFullPath().toString().startsWith(_binaryOutputPatternPath.toString())) {
						// Inner pattern model generated classes folder
						// Pattern Folder has been removed
						if (kind == IResourceDelta.REMOVED) {
							// check if we have an existing pattern template
							// descriptor
							IDescriptor patternTemplateDescriptor = getPatternTemplate((IFolder) resource);
							if (patternTemplateDescriptor == null) {
								// Nothing to process, Stop deeper analysis
								return false;
							}
							_clean.add(patternTemplateDescriptor);
						}
						// Pattern Folder has been added or changed descriptor
						if (kind == IResourceDelta.ADDED || kind == IResourceDelta.CHANGED) {
							// check if we have an existing pattern
							IDescriptor patternDescriptor = getPattern((IFolder) resource);
							if (patternDescriptor == null) {
								// Nothing to process, Stop deeper analysis
								return false;
							}
							_generate.add(patternDescriptor);
						}
						// Stop deeper analysis
						return false;
					}
				} else if (resource.getType() == IResource.PROJECT) {
					// Project, Deep analysis
					return true;
				} else if (resource.getType() == IResource.FILE) {
					String fileExtension = resource.getFileExtension();
					if ( fileExtension == null || "".equals(fileExtension) || !PatternConstants.PATTERN_METHOD_FILE_EXTENSION.equals(fileExtension) || !(resource.getParent() instanceof IFolder))
						return false;
					IDescriptor patternDescriptor = getPattern((IFolder) resource.getParent());
					if (patternDescriptor == null) 
						return false;
					_generate.add(patternDescriptor);
				}
			}
			return true;
		}

    public void reset() {
      _generate.clear();      
      _clean.clear();      
    }

    public Collection<IDescriptor> getGenerate() {
      return _generate;
    }
    
    public Collection<IDescriptor> getClean() {
      return _clean;
    }    

  }

  @SuppressWarnings("unchecked")
  protected IProject[] build(int kind_p, Map args_p, IProgressMonitor monitor_p) throws CoreException {
    // Initialize   
    if (initialize(monitor_p) == false) {
      return EMPTY_LIST;
    }
    // Let's build our delta
    try {
      IResourceDelta delta = getDelta(_javaProject.getProject());    
      if (kind_p != FULL_BUILD || delta != null) {
        if (delta.getKind() != IResourceDelta.NO_CHANGE) {
          // Visit delta
          _patternVisitor.reset();
          delta.accept(_patternVisitor);
          // Clean
          clean(_patternVisitor.getClean());
          // Generate
          generate(_patternVisitor.getGenerate(), monitor_p);          
        }
      } else {
        // Generate All available patterns
        generate(getPatterns().values(), monitor_p);        
      }
    } finally {
      cleanup();
    }
    // Nothing to return yet
    return EMPTY_LIST;
  }
      
  protected void generate(Collection<IDescriptor> descriptors_p, IProgressMonitor monitor_p) {
    if (descriptors_p == null) {
      return;
    }
    // Debug Stuff
    int rank = 1;
    long start = System.currentTimeMillis();
    long stepStart = start;
    // Generate
    for (IDescriptor descriptor : descriptors_p) {
      String definition = (String) descriptor.getValue(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME);
      if (definition == null || definition.trim().length() == 0) {
        continue;
      }
      PatternHandler patternHandler = new PatternHandler(true);
      try {        
        PatternData patternData = patternHandler.load(definition);
        if (patternData != null) {                  
          PatternTemplateProducer.generateTemplate(patternData);          
          if (DEBUG) {
            long stepStop = System.currentTimeMillis();            
            EGFConsolePlugin.getConsole().logInfo(
              NLS.bind(
                "Generate Pattern Template ''{0}'', step {1}/{2}", //$NON-NLS-1$ 
                new Object[] {
                  definition,
                  rank++,
                  descriptors_p.size()
                }
              )
            );
            EGFConsolePlugin.getConsole().logWarning(
              NLS.bind(
                "Total elapsed {0}, Step elapsed {1}", //$NON-NLS-1$ 
                MathHelper.formatAsDuration(stepStop - start),                  
                MathHelper.formatAsDuration(stepStop - stepStart)
              ),
              1
            );            
            stepStart = System.currentTimeMillis();            
          }             
        }
      } catch (Throwable t) {
        if (DEBUG) {
          EGFConsolePlugin.getConsole().logThrowable(
            NLS.bind(
              "Unable to load Pattern Model ''{0}''", //$NON-NLS-1$ 
              definition
            ), 
            t
          );
        }
        PatternActivator.getDefault().log(t);
        continue;
      } finally {
        // Check Monitor
        if (monitor_p.isCanceled()) {
          break;
        }
      }
    }
    // Refresh project.
    try {
      _javaProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor_p);
    } catch (CoreException ce) {
      PatternActivator.getDefault().log(ce);
      if (DEBUG) {
        EGFConsolePlugin.getConsole().logThrowable(
          NLS.bind(
            "Unable to refresh project ''{0}''", //$NON-NLS-1$
            _javaProject.getProject().getName()
          ),
          ce
        );
      }
    }
  }  
  
  protected void clean(Collection<IDescriptor> descriptors_p) {
    if (descriptors_p == null) {
      return;
    }
    for (IDescriptor descriptor : descriptors_p) {
      String id = (String) descriptor.getValue(ExtensionPointHelper.ATT_ID);
      if (id == null || id.trim().length() == 0) {
        continue;
      }
      if (DEBUG) {
        EGFConsolePlugin.getConsole().logInfo(
          NLS.bind(
            "Clean Pattern Template ''{0}''", //$NON-NLS-1$ 
            id
          )
        ); 
      }         
      PatternTemplateProducer.cleanGeneratedStructures(_javaProject, descriptor);               
    }    
  }
        
  private void cleanup() {
    _patterns = null;
    _patternTemplates = null;
  }  

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IncrementalProjectBuilder#clean(org.eclipse.core.runtime.IProgressMonitor)
   */
  protected void clean(IProgressMonitor monitor_p) throws CoreException {
    // Initialize   
    if (initialize(monitor_p) == false) {
      return;
    }
    // Let's do our clean job
    try {
      // Clean all available pattern templates
      clean(getPatternTemplates().values()); 
    } finally {
      cleanup();
    }    
  }
  
  private boolean initialize(IProgressMonitor monitor_p) throws CoreException {
    // Check    
    if (PatternActivator.getDefault().getBundle().getState() != Bundle.ACTIVE || monitor_p.isCanceled()) {
      return false;
    }
    // Get the current Project
    IProject project = getProject();
    // At this stage we check unknown, binary or non java project
    if (project == null || project.isAccessible() == false || project.hasNature(JavaCore.NATURE_ID) == false) {
      return false;
    }
    // Store the current JavaProject
    _javaProject = JavaCore.create(project);
    // Get the generated output bin pattern folder
    _binaryOutputPatternPath = GeneratedContentHelper.getBinaryOutputPatternGeneratedFolder(_javaProject);
    if (_binaryOutputPatternPath == null) {
      return false;
    }
    return true;
  }
  
  protected Map<String, IDescriptor> getPatterns() {
    if (_patterns == null) {
      _patterns = PatternRegistry.getPatterns(_javaProject.getProject());
    }
    return _patterns;
  }
  
  protected Map<String, IDescriptor> getPatternTemplates() {
    if (_patternTemplates == null) {
      _patternTemplates = PatternTemplateRegistry.getPatternTemplates(_javaProject.getProject());
    }
    return _patternTemplates;
  }  
    
  protected IDescriptor getPattern(IFolder folder_p) {
    if (folder_p == null) {
      return null;
    }
    // Build a possible pattern shortID
    String shortID = GeneratedContentHelper.getPatternIdentifier(folder_p);
    if (shortID == null) {
      return null;
    }
    return getPatterns().get(shortID);
  }
    
  protected IDescriptor getPatternTemplate(IFolder folder_p) {
    if (folder_p == null) {
      return null;
    }
    // Build a possible pattern shortID
    String shortID = GeneratedContentHelper.getPatternIdentifier(folder_p);
    if (shortID == null) {
      return null;
    }
    return getPatternTemplates().get(shortID);
  }  
  
}
