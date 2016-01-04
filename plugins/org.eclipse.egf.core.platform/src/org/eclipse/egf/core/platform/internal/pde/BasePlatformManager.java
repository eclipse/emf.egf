package org.eclipse.egf.core.platform.internal.pde;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.internal.registry.Handle;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointDelta;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPointListener;
import org.eclipse.egf.core.platform.pde.IPlatformManager;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.IExtensionDeltaEvent;
import org.eclipse.pde.internal.core.IExtensionDeltaListener;
import org.eclipse.pde.internal.core.IPluginModelListener;
import org.eclipse.pde.internal.core.PDECore;
import org.eclipse.pde.internal.core.PluginModelDelta;
import org.osgi.framework.Bundle;

public abstract class BasePlatformManager implements IPlatformManager {

	protected final Map<String, IPlatformBundle> workspaceRegistry = new HashMap<String, IPlatformBundle>();
	protected final Map<String, IPlatformBundle> runtimeRegistry = new HashMap<String, IPlatformBundle>();
	protected final Map<Class<?>, Set<Object>> runtimeExtensionPointRegistry = new HashMap<Class<?>, Set<Object>>();
	protected final Map<Class<?>, Set<Object>> workspaceExtensionPointRegistry = new HashMap<Class<?>, Set<Object>>();

	private final List<IPlatformExtensionPointListener> listeners = new ArrayList<IPlatformExtensionPointListener>();
	private final WorkspaceListener listener = new WorkspaceListener();

	public BasePlatformManager() {
		super();
		initializeRegistry();
		PDECore.getDefault().getModelManager().addPluginModelListener(listener);
		PDECore.getDefault().getModelManager().addExtensionDeltaListener(listener);
		for (Map.Entry<String, Class<? extends IPlatformExtensionPoint>> entry : EGFPlatformPlugin.getPlatformExtensionPoints().entrySet()) {
			String point = entry.getKey().trim();
			RuntimeRegistryListener l = new RuntimeRegistryListener(point, entry.getValue());
			RegistryFactory.getRegistry().addListener(l, point);
		}

	}

	private void initializeRegistry() {
		// runtime registry
		for (Map.Entry<String, Class<? extends IPlatformExtensionPoint>> entry : EGFPlatformPlugin.getPlatformExtensionPoints().entrySet()) {
			IConfigurationElement[] elements = RegistryFactory.getRegistry().getConfigurationElementsFor(entry.getKey());
			if (elements == null) {
				continue;
			}
			for (IConfigurationElement element : elements) {
				addRuntimeElement(element, entry.getValue(), true);
			}
		}

		// workspace registry
		for (IPluginModelBase base : PluginRegistry.getWorkspaceModels()) {
			addWorkspaceElement(base);
		}

	}

	private void addWorkspaceElement(IPluginModelBase base) {
		IPlatformBundle bundle = createPlatformBundle(base);
		workspaceRegistry.put(bundle.getBundleId(), bundle);
		for (Class<? extends IPlatformExtensionPoint> clazz : EGFPlatformPlugin.getPlatformExtensionPoints().values()) {
			for (IPlatformExtensionPoint extensionPoint : bundle.getPlatformExtensionPoints(clazz)) {
				Set<Object> extensionPoints = workspaceExtensionPointRegistry.get(clazz);
				if (extensionPoints == null) {
					extensionPoints = new HashSet<Object>();
					workspaceExtensionPointRegistry.put(clazz, extensionPoints);
				}
				if (extensionPoints.add(extensionPoint) == false)
					EGFPlatformPlugin.getDefault().logWarning(NLS.bind("AbstractPlatformManager.addExtensionPoint(..) _ ''{0}'' already added Extension Point.", extensionPoint.getId()));

			}
		}
	}

	protected static IPlatformBundle createPlatformBundle(IPluginModelBase base) {
		// Always create a new PlatformBundle
		PlatformBundle platformBundle = new PlatformBundle(base);
		// Process extension point
		for (IPluginExtension extension : base.getExtensions(false).getExtensions()) {
			Class<? extends IPlatformExtensionPoint> clazz = EGFPlatformPlugin.getPlatformExtensionPoints().get(extension.getPoint());
			if (clazz != null) {
				for (IPluginObject pluginObject : extension.getChildren()) {
					if (pluginObject instanceof IPluginElement) {
						platformBundle.createPlatformExtensionPoint(clazz, pluginObject);
					}
				}
			}
		}
		return platformBundle;
	}

	private void addRuntimeElement(IConfigurationElement element, Class<? extends IPlatformExtensionPoint> clazz, boolean init) {
		Bundle bundle = BundleHelper.getBundle(element.getDeclaringExtension().getContributor());
		if (bundle == null || element.isValid() == false) {
			return;
		}
		// Create a PlatformBundle if necessary
		PlatformBundle platformBundle = (PlatformBundle) runtimeRegistry.get(bundle.getSymbolicName());
		if (platformBundle == null) {
			platformBundle = new PlatformBundle(bundle);
		}
		// Is there something to do ?
		IPlatformExtensionPoint extensionPoint = platformBundle.createPlatformExtensionPoint(clazz, element);
		if (extensionPoint == null) {
			return;
		}
		if (init == false && extensionPoint instanceof AbstractPlatformExtensionPoint) {
			((AbstractPlatformExtensionPoint) extensionPoint).setPlatformBundle(platformBundle);
		}
		// Fill registries
		runtimeRegistry.put(bundle.getSymbolicName(), platformBundle);
		Set<Object> objects = runtimeExtensionPointRegistry.get(clazz);
		if (objects == null) {
			objects = new HashSet<Object>();
			runtimeExtensionPointRegistry.put(clazz, objects);
		}
		objects.add(extensionPoint);

	}

	public void addPlatformExtensionPointListener(IPlatformExtensionPointListener listener) {
		if (!listeners.contains(listener))
			listeners.add(listener);
	}

	public void removePlatformExtensionPointListener(IPlatformExtensionPointListener listener) {
		listeners.remove(listener);
	}

	protected void firePlatformExtensionPoint(IPlatformExtensionPointDelta delta) {
		for (IPlatformExtensionPointListener listener : listeners)
			listener.platformExtensionPointChanged(delta);
	}

	protected static void collectPlatformExtensionPoints(Map<Class<?>, Set<Object>> registry, Class<?> clazz, Collection<Object> collector) {
		if (clazz != null) {
			if (registry.get(clazz) != null) {
				collector.addAll(registry.get(clazz));
			}
		}
	}

	public class WorkspaceListener implements IExtensionDeltaListener, IPluginModelListener {

		private void reload() {
			BasePlatformManager.this.workspaceRegistry.clear();
			BasePlatformManager.this.runtimeRegistry.clear();
			BasePlatformManager.this.workspaceExtensionPointRegistry.clear();
			BasePlatformManager.this.runtimeExtensionPointRegistry.clear();
			BasePlatformManager.this.initializeRegistry();
		}

		public void extensionsChanged(IExtensionDeltaEvent event) {
			reload();
		}

		public void modelsChanged(PluginModelDelta delta) {
			reload();
		}

	}

	private class RuntimeRegistryListener implements IRegistryEventListener {

		private Class<? extends IPlatformExtensionPoint> _clazz;

		public RuntimeRegistryListener(String point, Class<? extends IPlatformExtensionPoint> clazz) {
			Assert.isNotNull(point);
			Assert.isLegal(point.trim().length() != 0);
			Assert.isNotNull(clazz);
			_clazz = clazz;
		}

		public void removed(IExtension[] extensions) {
			// Initialize a delta
			PlatformExtensionPointDelta delta = new PlatformExtensionPointDelta();
			// Lock PlatformManager
			{
				if (extensions == null) {
					return;
				}
				// Process
				for (IExtension extension : extensions) {
					for (Iterator<IPlatformBundle> it = runtimeRegistry.values().iterator(); it.hasNext();) {
						PlatformBundle bundle = (PlatformBundle) it.next();
						// Analyse Removed Extension Points
						for (IPlatformExtensionPoint extensionPoint : bundle.getPlatformExtensionPoints(_clazz)) {
							if (originatesFrom(extension, extensionPoint.getUniqueIdentifier(), extensionPoint.getHandleId())) {
								// Remove this ExtensionPoint from our existing
								// model
								if (bundle.removePlatformExtensionPoint(_clazz, extensionPoint) == false) {
									EGFPlatformPlugin.getDefault().logError(NLS.bind("RuntimePlatformManager$RuntimeRegistryListener.removed(..) _ ''{0}'' unable to remove Extension Point from IPlatformBundle.", //$NON-NLS-1$
											extensionPoint));
								}
								removeExtensionPoint(extensionPoint, _clazz, runtimeExtensionPointRegistry, delta);
							}
						}
						if (bundle.isEmpty()) {
							it.remove();
						}
					}
				}
			}
			// Broadcast
			if (delta.isEmpty() == false) {
				// Notify all interested listeners
				firePlatformExtensionPoint(delta);
			}
		}

		protected void removeExtensionPoint(IPlatformExtensionPoint extensionPoint, Class<? extends IPlatformExtensionPoint> clazz, Map<Class<?>, Set<Object>> extensions, PlatformExtensionPointDelta delta) {
			// remove extension point from Extension registry
			if (extensions.get(clazz).remove(extensionPoint)) {
				// Clean Extension registry if necessary
				if (extensions.get(clazz).isEmpty()) {
					extensions.remove(clazz);
				}
				// Update delta
				if (delta != null) {
					delta.storeRemovedPlatformExtensionPoint(clazz, extensionPoint);
				}
			}
		}

		public void added(IExtension[] extensions) {
			// Initialize a delta
			PlatformExtensionPointDelta delta = new PlatformExtensionPointDelta();
			// Lock PlatformManager
			{
				// Process
				for (IExtension extension : extensions) {
					for (IConfigurationElement element : extension.getConfigurationElements()) {
						addRuntimeElement(element, _clazz, false);
					}
				}
			}
			// Broadcast
			if (delta.isEmpty() == false) {
				// Notify all interested listeners
				firePlatformExtensionPoint(delta);
			}
		}

		public void added(IExtensionPoint[] extensionPoints) {
			// Nothing to do
			System.out.println();
		}

		public void removed(IExtensionPoint[] extensionPoints) {
			// Nothing to do
			System.out.println();
		}

		public boolean originatesFrom(IExtension extension, String uniqueIdentifier, int handleId) {
			String id = extension.getUniqueIdentifier();
			if (id != null) {
				return id.equals(uniqueIdentifier);
			}
			if (extension instanceof Handle == false) {
				return false;
			}
			return (handleId == ((Handle) extension).getId());
		}

	}

}
