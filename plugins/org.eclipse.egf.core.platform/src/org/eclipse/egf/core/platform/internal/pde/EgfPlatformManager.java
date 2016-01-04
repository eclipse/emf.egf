package org.eclipse.egf.core.platform.internal.pde;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.egf.common.helper.BundleHelper;
import org.eclipse.egf.common.helper.CollectionHelper;
import org.eclipse.egf.core.platform.EGFPlatformPlugin;
import org.eclipse.egf.core.platform.pde.IPlatformBundle;
import org.eclipse.egf.core.platform.pde.IPlatformExtensionPoint;
import org.eclipse.pde.core.plugin.IPluginModelBase;

public class EgfPlatformManager extends BasePlatformManager {

	public IPlatformBundle getPlatformBundle(String id) {
		IPlatformBundle bundle = workspaceRegistry.get(id);
		if (bundle != null)
			return bundle;
		return runtimeRegistry.get(id);
	}

	public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(Class<T> clazz) {
		Set<Object> extensionPoints = new HashSet<Object>();
		collectPlatformExtensionPoints(workspaceExtensionPointRegistry, clazz, extensionPoints);
		collectPlatformExtensionPoints(runtimeExtensionPointRegistry, clazz, extensionPoints);
		return CollectionHelper.toArray(extensionPoints, clazz);
	}

	public <T extends IPlatformExtensionPoint> T[] getRuntimePlatformExtensionPoints(Class<T> clazz) {
		List<Object> extensionPoints = new ArrayList<Object>();
		collectPlatformExtensionPoints(runtimeExtensionPointRegistry, clazz, extensionPoints);
		return CollectionHelper.toArray(extensionPoints, clazz);
	}

	public <T extends IPlatformExtensionPoint> T[] getWorkspacePlatformExtensionPoints(Class<T> clazz) {
		List<Object> extensionPoints = new ArrayList<Object>();
		collectPlatformExtensionPoints(workspaceExtensionPointRegistry, clazz, extensionPoints);
		return CollectionHelper.toArray(extensionPoints, clazz);
	}

	public <T extends IPlatformExtensionPoint> T[] getRuntimePlatformExtensionPoints(String id, Class<T> clazz) {
		if (id != null && clazz != null && EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz)) {
			IPlatformBundle platformBundle = runtimeRegistry.get(id);
			if (platformBundle != null)
				return platformBundle.getPlatformExtensionPoints(clazz);
		}
		return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
	}

	public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(String id, Class<T> clazz) {
		if (id != null && clazz != null && EGFPlatformPlugin.getPlatformExtensionPoints().values().contains(clazz)) {
			IPlatformBundle platformBundle = getPlatformBundle(id);
			if (platformBundle != null)
				return platformBundle.getPlatformExtensionPoints(clazz);
		}
		return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
	}

	public <T extends IPlatformExtensionPoint> T[] getPlatformExtensionPoints(IPluginModelBase model, Class<T> clazz) {
		if (model != null && clazz != null && EGFPlatformPlugin.getPlatformExtensionPointClasses().contains(clazz)) {
			IPlatformBundle platformBundle = getPlatformBundle(BundleHelper.getBundleId(model));
			if (platformBundle != null)
				return platformBundle.getPlatformExtensionPoints(clazz);
		}
		return CollectionHelper.toArray(new ArrayList<Object>(0), clazz);
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

}
