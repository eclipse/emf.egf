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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.osgi.util.NLS;

import org.eclipse.egf.common.constant.IPatternConstants;
import org.eclipse.egf.common.descriptor.IDescriptor;
import org.eclipse.egf.common.helper.FileHelper;
import org.eclipse.egf.common.helper.MathHelper;
import org.eclipse.egf.console.EGFConsolePlugin;
import org.eclipse.egf.pattern.PatternActivator;
import org.eclipse.egf.pattern.ecore.PatternConstants;
import org.eclipse.egf.pattern.ecore.PatternHandler;
import org.eclipse.egf.pattern.ecore.PatternHandler.PatternData;
import org.eclipse.egf.pattern.internal.PatternRegistry;
import org.eclipse.egf.pattern.production.PatternProducer;


public class PatternBuilder extends IncrementalProjectBuilder {
  
  private static boolean DEBUG = PatternActivator.getDefault().isDebugging();
  
  private static IProject[] EMPTY_LIST = new IProject [0];

  private PatternVisitor _patternVisitor = new PatternVisitor();
        
  private IJavaProject _javaProject;
    
  private Map<String, IDescriptor> _patterns;
  
  class PatternVisitor implements IResourceDeltaVisitor {
    
    private Collection<IDescriptor> _rebuildPatternModel = new ArrayList<IDescriptor>();    
    
    private Collection<IDescriptor> _rebuildFactoryComponent = new ArrayList<IDescriptor>();    
    
    private Collection<IDescriptor> _produce = new ArrayList<IDescriptor>();   

    public boolean visit(IResourceDelta delta) throws CoreException {
      if (delta == null) {
        return false;
      }
      int kind = delta.getKind();
      IResource resource = delta.getResource();
      // Process Pattern Model and Pattern Method file extension
      if (resource.getType() == IResource.FILE) {
        if (PatternConstants.PATTERN_MODEL_FILE_EXTENSION.equals(resource.getFileExtension())) {
          // Process Pattern Model          
          // Looking for an existing descriptor
          IDescriptor descriptor = getPatterns().get(resource.getFullPath().removeFileExtension().lastSegment());
          if (descriptor == null) {
            return false;
          }        
          String model = (String) descriptor.getValue(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME);
          if (model == null || model.trim().length() == 0) {
            return false;
          }
          // Check if the model attribute match an existing workspace resource
          IResource modelResource = FileHelper.getPlatformResource(new Path(model));
          if (modelResource == null || modelResource.equals(resource) == false) {
            return false;
          }
          if (kind == IResourceDelta.REMOVED) {
            _rebuildFactoryComponent.add(descriptor);
          }
          if (kind == IResourceDelta.ADDED || kind == IResourceDelta.CHANGED) {
            _produce.add(descriptor);
          }
        } else if (PatternConstants.PATTERN_METHOD_FILE_EXTENSION.equals(resource.getFileExtension())) {
          // Process Pattern Method          
          // Looking for an existing descriptor
          IDescriptor descriptor = getPatterns().get(resource.getParent().getFullPath().lastSegment());
          if (descriptor == null) {
            return false;
          }        
          // Pattern Methods are described in the Pattern Model
          // Deeper analysis should be done
          if (kind == IResourceDelta.REMOVED) {              
            _rebuildPatternModel.add(descriptor);
          }
          // Added are ignored as they cannot appear magically in the pattern model
          if (kind == IResourceDelta.CHANGED) {
            _produce.add(descriptor);
          }          
        }
        return false;
      }
      return true;
    }

    public void reset() {
      _produce.clear();
      _rebuildPatternModel.clear();        
      _rebuildFactoryComponent.clear();      
    }

    public Collection<IDescriptor> getProduce() {
      return _produce;
    }
    
    public Collection<IDescriptor> getRebuildFactoryComponent() {
      return _rebuildFactoryComponent;
    }
    
    public Collection<IDescriptor> getRebuildPatternModel() {
      return _rebuildPatternModel;
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
          // Rebuild FactoryComponent
          rebuildFactoryComponent(_patternVisitor.getRebuildFactoryComponent());
          // Rebuild PatternModel
          rebuildPatternModel(_patternVisitor.getRebuildPatternModel());          
          // Produce
          produce(_patternVisitor.getProduce(), monitor_p);          
        }
      } else {
        // Produce All available Pattern Model
        produce(getPatterns().values(), monitor_p);        
      }
    } finally {
      cleanup();
    }
    // Nothing to return yet
    return EMPTY_LIST;
  }
      
  protected void produce(Collection<IDescriptor> descriptors_p, IProgressMonitor monitor_p) {
    if (descriptors_p == null) {
      return;
    }
    // Debug Stuff
    int rank = 1;
    long start = System.currentTimeMillis();
    long stepStart = start;
    // Produce
    for (IDescriptor descriptor : descriptors_p) {
      String definition = (String) descriptor.getValue(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME);
      if (definition == null || definition.trim().length() == 0) {
        continue;
      }
      PatternHandler patternHandler = new PatternHandler(true);
      try {        
        PatternData patternData = patternHandler.load(definition);
        if (patternData != null) {
          PatternProducer.producePatterns(patternData.getPattern().getId(), monitor_p);
          long stepStop = System.currentTimeMillis();
          if (DEBUG) {
            EGFConsolePlugin.getConsole().logInfo(
              NLS.bind(
                "Produce Pattern Model ''{0}'', step {1}/{2}", //$NON-NLS-1$ 
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
  }  
  
  protected void rebuildFactoryComponent(Collection<IDescriptor> descriptors_p) {
    if (descriptors_p == null) {
      return;
    }
    for (IDescriptor descriptor : descriptors_p) {
      String definition = (String) descriptor.getValue(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME);
      if (definition == null || definition.trim().length() == 0) {
        continue;
      }
      PatternHandler patternHandler = new PatternHandler(true);      
      try {
        PatternData patternData = patternHandler.load(definition);
        if (patternData != null) {
          if (DEBUG) {
            EGFConsolePlugin.getConsole().logWarning(
              NLS.bind(
                "Factory Component Should be updated ''{0}''", //$NON-NLS-1$ 
                patternData.getFactoryComponentId()
              )
            );
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
      }          
    }    
  }
  
  protected void rebuildPatternModel(Collection<IDescriptor> descriptors_p) {
    if (descriptors_p == null) {
      return;
    }
    for (IDescriptor descriptor : descriptors_p) {
      String definition = (String) descriptor.getValue(IPatternConstants.PATTERN_MODEL_ATTRIBUTE_NAME);
      if (definition == null || definition.trim().length() == 0) {
        continue;
      }
      PatternHandler patternHandler = new PatternHandler(true);      
      try {
        PatternData patternData = patternHandler.load(definition);
        if (patternData != null) {
          if (DEBUG) {
            EGFConsolePlugin.getConsole().logWarning(
              NLS.bind(
                "Pattern Model Should be updated ''{0}''", //$NON-NLS-1$ 
                definition
              )
            );
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
      }            
    }    
  }  
        
  private void cleanup() {
    _patterns = null;
  }  

  /* (non-Javadoc)
   * @see org.eclipse.core.resources.IncrementalProjectBuilder#clean(org.eclipse.core.runtime.IProgressMonitor)
   */
  protected void clean(IProgressMonitor monitor_p) throws CoreException {
    // Nothing to do
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
    return true;
  }
  
  protected Map<String, IDescriptor> getPatterns() {
    if (_patterns == null) {
      _patterns = PatternRegistry.getPatterns(_javaProject.getProject());
    }
    return _patterns;
  }
            
}
