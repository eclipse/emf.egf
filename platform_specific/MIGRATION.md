# How to migrate this plugin (org.eclipse.egf.emf.pattern)

This foder contains platform-specific version of the `org.eclipse.egf.emf.pattern` plugin.
This plugin contains the EGF version of the EMF codegen generation patterns. These EGF specific 
patterns are generated from the ones provided in the emf.codegen plugin and thus needs to be updated 
when a newer version of EMF is used by the platform. Some tooling have been created to this extend.

In this document we will refer to `PLATFORM` as the name of the Eclipse platform towards which we
want to migrate the EGF patterns.

## Migration setup

- Get an Eclipse SDK with the EGF product installed: rely on any Eclipse product with EGF-SDK feature installed or a runtime from the content of the source code repository
- Install the additional `tools\org.eclipse.egf.emf.pattern.codegen*` plugins (or launch a runtime including these plugins)
- Run this product

## What to do

In this new product:
- Import the `PLATFORM` (with sources) version of the `org.eclipse.emf.codegen` plugin
- Patch this plugin with the patch located in `platform_specific/PLATFORM-1/org.eclipse.egf.emf.pattern/org.eclipse.emf.codegen.ecore.patch`
- Import a copy of the latest version of the `platform_specific/PLATFORM-1/org.eclipse.egf.emf.pattern` plugin
- Right click on the `org.eclipse.emf.codegen.ecore` plugin and launch the `Reverse codegen` command
- On the wizard select the `egf` folder located in the `org.eclipse.egf.emf.pattern` plugin
- Keep the fcore file name as is (it should be the name of the fcore file located in the `egf` folder: `EMF_Pattern.fcore`)
- Finish the wizard
- Let the tooling operate (it takes some time)
- After the migration, check the value for:
  - `Bundle-Version` field in `org.eclipse.egf.emf.pattern/META-INF/MANIFEST.MF`
  - `target` folder inclusion in `org.eclipse.egf.emf.pattern/build.properties`

The `org.eclipse.egf.emf.pattern` project can now be used in the new version of EGF and added to the dedicated `platform_specific/PLATFORM` folder.

## How to validate

In a runtime EGF environment, launch the generation for all the **fcore** files located in: `examples/workspace/org.eclipse.egf.usecase.emf.uc2/egf` and `examples/workspace/org.eclipse.egf.usecase.emf.uc3/egf` and check the generated content. TODO: integrate these in automated test cases.