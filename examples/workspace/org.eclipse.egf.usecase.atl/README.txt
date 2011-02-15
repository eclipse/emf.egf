--------------------------------------------------------------------------------
-- ATL Task
--------------------------------------------------------------------------------

--- Example
The example is the located in the egf folder. It is based on the common ATL sample example.


--- Practice
* How to create and execute an ATL Task?
1. Creation of a new ATL Task with EGF:
	Precondition:
		- The ATL project is created
		- Existence of the "ASM" file corresponding to an ATL file
		- Existence of the metamodel
		- Existence of an source file for transformation
 
	1.1. Creation in a new fcore file
   		- In a folder, [File / New / Other... / EGF / EGF Activity]
   		- In the Task, set "kind" to "ATL"
	OR
	1.1. Creation in an existing fcore file
   		- On a factory component or task, [New Sibling / Task ATL]

	1.2. Set the name of the task

	1.3. Declaration of the implementation
		- In the implementation property, select an ASM file 

	1.4. Creation of the parameters
		- On the ATL task, creation of the parameter container [New Child / Contract Container]
		- "metaModelURI" Parameter.
			New In parameter (contract), Name = "metaModelURI"
			New child, Type URI - In "Value" Property, URI expected, such as "http://www.eclipse.org/uml2/2.1.0/UML"     
		- "modelIN" Parameter.
			New In parameter (contract), Name = "modelIN"
			New child, Type URI - In "Value" Property, Path expected, such as "platform:/resource/org.eclipse.egf.usecase.atl/model/sample.uml"     
		- "modelOUT" Parameter.
			New In parameter (contract), Name = "modelOUT"
			New child, Type String - In "Value" Property, Path expected, such as "platform:/resource/org.eclipse.egf.usecase.atl/model/sample-privatized.uml"     


2. Execution of an ATL task:
	Precondition:
		- Existence of the metamodel
		- Existence of the source model
		- Existence of the output directory as specified 
 
	2.1. On the fcore file when just one task, or on the task, "Run EGF Activity..."
	2.2. The result is in the output directory


--- Platform
Validated with EGF 0.4.1, and ATL SDK-3.2.0M4
