/**
 * <copyright>
 *
 *  Copyright (c) 2009-2010 Thales Corporate Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Thales Corporate Services S.A.S - initial API and implementation
 * 
 * </copyright>
 */

package org.eclipse.egf.emf.pattern.codegen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.emf.pattern.base.ContentTypePatternExecutionReporter;
import org.eclipse.egf.emf.pattern.codegen.model.PatternInfo;
import org.eclipse.egf.emf.pattern.util.PartType;
import org.eclipse.egf.model.domain.DomainFactory;
import org.eclipse.egf.model.fcore.Activity;
import org.eclipse.egf.model.fcore.Contract;
import org.eclipse.egf.model.fcore.ContractContainer;
import org.eclipse.egf.model.fcore.FactoryComponent;
import org.eclipse.egf.model.fcore.FactoryComponentContract;
import org.eclipse.egf.model.fcore.FcoreFactory;
import org.eclipse.egf.model.fcore.FcorePackage;
import org.eclipse.egf.model.fcore.InvocationContract;
import org.eclipse.egf.model.fcore.InvocationContractContainer;
import org.eclipse.egf.model.fcore.NamedModelElement;
import org.eclipse.egf.model.fcore.ViewpointContainer;
import org.eclipse.egf.model.fprod.FprodFactory;
import org.eclipse.egf.model.fprod.FprodPackage;
import org.eclipse.egf.model.fprod.ProductionPlan;
import org.eclipse.egf.model.fprod.ProductionPlanInvocation;
import org.eclipse.egf.model.pattern.Pattern;
import org.eclipse.egf.model.pattern.PatternElement;
import org.eclipse.egf.model.pattern.PatternFactory;
import org.eclipse.egf.model.pattern.PatternLibrary;
import org.eclipse.egf.model.pattern.PatternMethod;
import org.eclipse.egf.model.pattern.PatternPackage;
import org.eclipse.egf.model.pattern.PatternViewpoint;
import org.eclipse.egf.model.pattern.TypePatternExecutionReporter;
import org.eclipse.egf.model.pattern.TypePatternList;
import org.eclipse.egf.model.types.TypesFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * @author Matthieu Helleboid
 * 
 */
public class CodegenEGFHelper {

    protected Resource emfPatternResource;

    private Map<Key, Object> createdObjects = new HashMap<Key, Object>();

    private Map<Key, String> xmiIds = new HashMap<Key, String>();

    private Map<String, Integer> patternElementOrder = new LinkedHashMap<String, Integer>();

    public CodegenEGFHelper(Resource emfPatternResource, CodegenEGFHelper oldCodegenEGFHelper) {
        this.emfPatternResource = emfPatternResource;
        if (oldCodegenEGFHelper != null) {
            this.xmiIds = oldCodegenEGFHelper.getXmiIds();
            this.patternElementOrder = oldCodegenEGFHelper.getPatternElementOrder();
        }
    }

    public Map<Key, String> getXmiIds() {
        return xmiIds;
    }

    public Map<String, Integer> getPatternElementOrder() {
        return patternElementOrder;
    }

    public void createAllFactoryComponent() {
        List<Key> activitiesKeys = new ArrayList<Key>();
        for (Key key : createdObjects.keySet()) {
            if (createdObjects.get(key) instanceof Activity) {
                activitiesKeys.add(key);
            }
        }

        Collections.sort(activitiesKeys, new Comparator<Key>() {

            public int compare(Key key1, Key key2) {
                return key1.partType.compareTo(key2.partType);
            }
        });

        ProductionPlan allProductionPlan = getProductionPlan(null);

        for (Key key : activitiesKeys) {
            ProductionPlanInvocation productionPlanInvocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
            productionPlanInvocation.setProductionPlan(allProductionPlan);
            productionPlanInvocation.setInvokedActivity((Activity) createdObjects.get(key));

            InvocationContractContainer invocationContractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
            productionPlanInvocation.setInvocationContractContainer(invocationContractContainer);

            for (FactoryComponentContractType fccType : FactoryComponentContractType.values()) {
                // do not expose pattern.ids for All
                if (fccType == FactoryComponentContractType.patternIds)
                    continue;

                FactoryComponentContract allFactoryComponentContract = getFactoryComponentContract(null, fccType);

                InvocationContract invocationContract = FcoreFactory.eINSTANCE.createInvocationContract();
                invocationContract.setInvocationContractContainer(invocationContractContainer);
                invocationContract.setInvokedContract(getFactoryComponentContract(key.partType, fccType));
                invocationContract.setFactoryComponentContract(allFactoryComponentContract);
            }
        }
    }

    public void createOrchestration(Resource emfPatternBaseResource, Resource mdpstResource, Collection<PatternInfo> patternInfos, IProgressMonitor monitor, CodegenPatternHelper codegenPatternHelper) {
        List<PartType> partsDone = new ArrayList<PartType>();
        for (PatternInfo patternInfo : patternInfos) {
            PartType partType = patternInfo.getPartType();
            if (partsDone.contains(partType))
                continue;

            partsDone.add(partType);

            ProductionPlanInvocation invocation = FprodFactory.eINSTANCE.createProductionPlanInvocation();
            ProductionPlan productionPlan = getProductionPlan(partType);
            invocation.setProductionPlan(productionPlan);
            invocation.setName(PartType.getFactoryComponentName(partType));

            InvocationContractContainer contractContainer = FcoreFactory.eINSTANCE.createInvocationContractContainer();
            contractContainer.setInvocation(invocation);

            Activity activity = (Activity) emfPatternBaseResource.getEObject("_jT-SgD1hEd-m5uHrCQ1Jew"); //$NON-NLS-1$
            invocation.setInvokedActivity(activity);

            Contract domainContract = (Contract) mdpstResource.getEObject("_DgB2IP6fEd64XaYPo3s6sPg"); //$NON-NLS-1$
            InvocationContract domainContractInvocation = createInvocationContract(contractContainer, domainContract);
            getFactoryComponentContract(partType, FactoryComponentContractType.genModelURI).getInvocationContracts().add(domainContractInvocation);

            Contract reporterContract = (Contract) mdpstResource.getEObject("_L6JSwAHAEd-4faJMEplCjxw"); //$NON-NLS-1$
            InvocationContract reporterContractInvocation = createInvocationContract(contractContainer, reporterContract);
            TypePatternExecutionReporter reporter = PatternFactory.eINSTANCE.createTypePatternExecutionReporter();
            reporter.setValue(ContentTypePatternExecutionReporter.class.getName());
            reporterContractInvocation.setType(reporter);
            getFactoryComponentContract(partType, FactoryComponentContractType.patternExecutionReporter).getInvocationContracts().add(reporterContractInvocation);

            Contract patternContract = (Contract) mdpstResource.getEObject("_nz1HkSCaEd-Sse0r9LJWbA"); //$NON-NLS-1$
            InvocationContract patternContractInvocation = createInvocationContract(contractContainer, patternContract);
            TypePatternList patternList = PatternFactory.eINSTANCE.createTypePatternList();
            patternList.getElements().add(getPatternViewpoint(partType).getLibraries().get(0));
            patternContractInvocation.setType(patternList);
            getFactoryComponentContract(partType, FactoryComponentContractType.patternIds).getInvocationContracts().add(patternContractInvocation);

            Contract patternSubstitutions = (Contract) mdpstResource.getEObject("_NFhJ4UMgEd-Ixul1H5ANhg"); //$NON-NLS-1$
            InvocationContract patternSubstitutionsContractInvocation = createInvocationContract(contractContainer, patternSubstitutions);
            getFactoryComponentContract(partType, FactoryComponentContractType.patternSubstitutions).getInvocationContracts().add(patternSubstitutionsContractInvocation);

            Contract usedGenPackages = (Contract) emfPatternBaseResource.getEObject("_JWI2sPI7Ed-Pp8S8RvVOuQ"); //$NON-NLS-1$
            InvocationContract usedGenPackagesContractInvocation = createInvocationContract(contractContainer, usedGenPackages);
            getFactoryComponentContract(partType, FactoryComponentContractType.usedGenPackages).getInvocationContracts().add(usedGenPackagesContractInvocation);

            Contract mergeRulesURI = (Contract) emfPatternBaseResource.getEObject("_vtlEAFLMEd-ZSLMRjxSbVQ"); //$NON-NLS-1$
            InvocationContract mergeRulesURIContractInvocation = createInvocationContract(contractContainer, mergeRulesURI);
            getFactoryComponentContract(partType, FactoryComponentContractType.mergeRulesURI).getInvocationContracts().add(mergeRulesURIContractInvocation);

            monitor.worked(5);
        }
    }

    protected InvocationContract createInvocationContract(InvocationContractContainer contractContainer, Contract domainContract) {
        InvocationContract domainContractInvocation = FcoreFactory.eINSTANCE.createInvocationContract();
        contractContainer.getInvocationContracts().add(domainContractInvocation);
        domainContractInvocation.setInvokedContract(domainContract);

        return domainContractInvocation;
    }

    public PatternLibrary getPatternLibrary(PartType partType, String libraryName) {
        Key key = new Key(PatternPackage.eINSTANCE.getPatternLibrary(), partType, libraryName);
        PatternLibrary patternLibrary = (PatternLibrary) createdObjects.get(key);

        if (patternLibrary == null) {
            patternLibrary = org.eclipse.egf.model.pattern.PatternFactory.eINSTANCE.createPatternLibrary();
            patternLibrary.setName(libraryName);
            getPatternViewpoint(partType).getLibraries().add(patternLibrary);
            createdObjects.put(key, patternLibrary);
            fixXmiId(patternLibrary, partType);
        }

        return patternLibrary;
    }

    public FactoryComponent getFactoryComponent(PartType partType) {
        Key key = new Key(FcorePackage.eINSTANCE.getFactoryComponent(), partType);
        FactoryComponent factoryComponent = (FactoryComponent) createdObjects.get(key);

        if (factoryComponent == null) {
            factoryComponent = FcoreFactory.eINSTANCE.createFactoryComponent();
            factoryComponent.setName(PartType.getFactoryComponentName(partType));

            emfPatternResource.getContents().add(factoryComponent);
            createdObjects.put(key, factoryComponent);
            fixXmiId(factoryComponent, partType);
        }

        return factoryComponent;
    }

    private enum FactoryComponentContractType {
        genModelURI("genModelURI", true), //$NON-NLS-1$
        patternExecutionReporter("pattern.execution.reporter", false), //$NON-NLS-1$
        patternIds("pattern.ids", false), //$NON-NLS-1$
        patternSubstitutions("pattern.substitutions", false), //$NON-NLS-1$
        usedGenPackages("usedGenPackages", false), //$NON-NLS-1$
        mergeRulesURI("mergeRulesURI", false); //$NON-NLS-1$

        String name;

        boolean mandatory;

        FactoryComponentContractType(String name, boolean mandatory) {
            this.name = name;
            this.mandatory = mandatory;
        }
    }

    public FactoryComponentContract getFactoryComponentContract(PartType partType, FactoryComponentContractType fccType) {
        Key key = new Key(FcorePackage.eINSTANCE.getFactoryComponentContract(), partType, fccType.name);
        FactoryComponentContract contract = (FactoryComponentContract) createdObjects.get(key);

        if (contract == null) {
            contract = FcoreFactory.eINSTANCE.createFactoryComponentContract();
            getContractContainer(partType).getContracts().add(contract);
            contract.setMandatory(fccType.mandatory);
            contract.setName(fccType.name);
            contract.setDescription(PartType.getFactoryComponentName(partType));

            switch (fccType) {
                case genModelURI:
                    contract.setType(DomainFactory.eINSTANCE.createTypeDomain());
                    break;
                case usedGenPackages:
                    contract.setType(DomainFactory.eINSTANCE.createTypeGenPackages());
                    break;
                case mergeRulesURI:
                    contract.setType(TypesFactory.eINSTANCE.createTypeURI());
                    break;
                case patternSubstitutions:
                    contract.setType(PatternFactory.eINSTANCE.createTypePatternSubstitution());
                    break;
                case patternExecutionReporter:
                    contract.setType(PatternFactory.eINSTANCE.createTypePatternExecutionReporter());
                    break;
                case patternIds:
                    contract.setType(PatternFactory.eINSTANCE.createTypePatternList());
                    break;
            }

            createdObjects.put(key, contract);
            fixXmiId(contract, partType);
        }

        return contract;
    }

    public ContractContainer getContractContainer(PartType partType) {
        Key key = new Key(FcorePackage.eINSTANCE.getContractContainer(), partType);
        ContractContainer contractContainer = (ContractContainer) createdObjects.get(key);

        if (contractContainer == null) {
            contractContainer = FcoreFactory.eINSTANCE.createContractContainer();
            getFactoryComponent(partType).setContractContainer(contractContainer);
            createdObjects.put(key, contractContainer);
            fixXmiId(contractContainer, partType);
        }

        return contractContainer;
    }

    public ViewpointContainer getViewpointContainer(PartType partType) {
        Key key = new Key(FcorePackage.eINSTANCE.getViewpointContainer(), partType);
        ViewpointContainer viewpointContainer = (ViewpointContainer) createdObjects.get(key);

        if (viewpointContainer == null) {
            viewpointContainer = FcoreFactory.eINSTANCE.createViewpointContainer();
            getFactoryComponent(partType).setViewpointContainer(viewpointContainer);
            createdObjects.put(key, viewpointContainer);
            fixXmiId(viewpointContainer, partType);
        }

        return viewpointContainer;
    }

    public PatternViewpoint getPatternViewpoint(PartType partType) {
        Key key = new Key(PatternPackage.eINSTANCE.getPatternViewpoint(), partType);
        PatternViewpoint patternViewpoint = (PatternViewpoint) createdObjects.get(key);

        if (patternViewpoint == null) {
            patternViewpoint = PatternFactory.eINSTANCE.createPatternViewpoint();
            getViewpointContainer(partType).getViewpoints().add(patternViewpoint);
            createdObjects.put(key, patternViewpoint);
            fixXmiId(patternViewpoint, partType);
        }

        return patternViewpoint;
    }

    public ProductionPlan getProductionPlan(PartType partType) {
        Key key = new Key(FprodPackage.eINSTANCE.getProductionPlan(), partType);
        ProductionPlan productionPlan = (ProductionPlan) createdObjects.get(key);

        if (productionPlan == null) {
            productionPlan = FprodFactory.eINSTANCE.createProductionPlan();
            getFactoryComponent(partType).setOrchestration(productionPlan);
            createdObjects.put(key, productionPlan);
            fixXmiId(productionPlan, partType);
        }

        return productionPlan;
    }

    private static class Key {

        private EClass eClass;

        private PartType partType;

        private String name;

        public Key(EClass eClass, PartType partType, String name) {
            this.eClass = eClass;
            this.partType = partType;
            this.name = name;
        }

        public Key(EClass eClass, PartType partType) {
            this(eClass, partType, null);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((eClass == null) ? 0 : eClass.hashCode());
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((partType == null) ? 0 : partType.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Key other = (Key) obj;
            if (eClass == null) {
                if (other.eClass != null)
                    return false;
            } else if (!eClass.equals(other.eClass))
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (partType == null) {
                if (other.partType != null)
                    return false;
            } else if (!partType.equals(other.partType))
                return false;
            return true;
        }
    }

    public void populateXmiIds() {
        XMIResource xmiResource = getXMIResource();

        for (EObject eObject : emfPatternResource.getContents()) {
            if (eObject instanceof FactoryComponent) {
                FactoryComponent factoryComponent = (FactoryComponent) eObject;
                boolean found = false;
                for (PartType partType : PartType.values()) {
                    if (PartType.getFactoryComponentName(partType).equals(factoryComponent.getName())) {
                        found = true;
                        populateXmiIds(xmiResource, factoryComponent, partType);
                    }
                }
                if (!found)
                    populateXmiIds(xmiResource, factoryComponent, null);
            }
        }
    }

    protected void populateXmiIds(XMIResource xmiResource, EObject eObject, PartType partType) {
        Key key = new Key(eObject.eClass(), partType, getSymbolicName(eObject));
        xmiIds.put(key, xmiResource.getID(eObject));
        for (EObject child : eObject.eContents()) {
            populateXmiIds(xmiResource, child, partType);
        }
    }

    public void fixXmiId(EObject eObject, PartType partType) {
        Key key = new Key(eObject.eClass(), partType, getSymbolicName(eObject));
        if (xmiIds.get(key) == null)
            return;

        getXMIResource().setID(eObject, xmiIds.get(key));
    }

    private String getSymbolicName(EObject eObject) {
        if (eObject instanceof PatternLibrary) {
            PatternLibrary patternLibrary = (PatternLibrary) eObject;
            return patternLibrary.getName();
        } else if (eObject instanceof Pattern) {
            Pattern pattern = (Pattern) eObject;
            PatternLibrary patternLibrary = pattern.getContainer();
            return patternLibrary.getName() + "." + pattern.getName(); //$NON-NLS-1$
        } else if (eObject instanceof PatternMethod) {
            PatternMethod patternMethod = (PatternMethod) eObject;
            Pattern pattern = patternMethod.getPattern();
            PatternLibrary patternLibrary = pattern.getContainer();
            return patternLibrary.getName() + "." + pattern.getName() + "." + patternMethod.getName(); //$NON-NLS-1$ //$NON-NLS-2$
        } else if (eObject instanceof FactoryComponentContract) {
            NamedModelElement namedModelElement = (NamedModelElement) eObject;
            return namedModelElement.getName();
        }

        return null;
    }

    public void populatePatternOrder() {
        XMIResource xmiResource = getXMIResource();
        for (Iterator<EObject> i = emfPatternResource.getAllContents(); i.hasNext();) {
            EObject eObject = i.next();
            if (eObject instanceof PatternElement) {
                PatternElement patternElement = (PatternElement) eObject;
                patternElementOrder.put(xmiResource.getID(eObject), getSiblingCollection(patternElement).indexOf(patternElement));
            }
        }
    }

    public void fixPatternElementOrder() {
        XMIResource xmiResource = getXMIResource();
        for (String id : patternElementOrder.keySet()) {
            PatternElement patternElement = (PatternElement) xmiResource.getEObject(id);
            if (patternElement != null) {
                int newPosition = patternElementOrder.get(id);
                boolean moved = false;
                while (newPosition > -1 && !moved) {
                    try {
                        getSiblingCollection(patternElement).move(newPosition, patternElement);
                        moved = true;
                    } catch (IndexOutOfBoundsException e) {
                        newPosition--;
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    protected <E extends PatternElement> EList<E> getSiblingCollection(PatternElement patternElement) {
        if (patternElement instanceof PatternLibrary) {
            PatternLibrary patternLibrary = (PatternLibrary) patternElement;
            PatternViewpoint patternViewpoint = (PatternViewpoint) patternLibrary.eContainer();
            return (EList<E>) patternViewpoint.getLibraries();
        } else if (patternElement instanceof Pattern) {
            Pattern pattern = (Pattern) patternElement;
            PatternLibrary container = pattern.getContainer();
            return (EList<E>) container.getElements();
        } else
            throw new IllegalStateException("Unknown patternElement type"); //$NON-NLS-1$
    }

    protected XMIResource getXMIResource() {
        if (emfPatternResource instanceof XMIResource)
            return (XMIResource) emfPatternResource;
        throw new IllegalStateException(emfPatternResource + " should be a xmi resource"); //$NON-NLS-1$
    }
}
