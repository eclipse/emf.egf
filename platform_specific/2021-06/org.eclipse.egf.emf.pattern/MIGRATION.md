# How to migrate this plugin (org.eclipse.egf.emf.pattern)

Blah what is it

## Setup

Runtime EGF (with updated TP) + tools/*codegen* plugins installed
On runtime, import:
- target version of org.eclipse.emf.codegen plugin
- apply patch
- copy of org.eclipse.egf.emf.pattern

## What to do

Reverse codegen on org.eclipse.emf.codegen.plugin with:
- target org.eclipse.egf.emf.pattern/egf/
- fcore file name: keep default
- GO

Copy new version of org.eclipse.egf.emf.pattern project in platform_specific folder.