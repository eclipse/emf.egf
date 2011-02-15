--------------------------------------------------------------------------------
-- Acceleo 3 Task
--------------------------------------------------------------------------------

--- Platform
Validated with EGF 0.4.1, and Acceleo-SDK-3.0.1

--- Example
The example is the located in the egf folder.
This example generate classes from the Library ecore model.

--- Practice
* How to create and execute an Acceleo3 Task?
1. Creation of a new Acceleo3 Task with EGF:
	Precondition:
		- The Acceleo3 generation file already exists
 
	1.1. Creation in a new fcore file
   		- In a folder, [File / New / Other... / EGF / EGF Activity]
   		- In the Task, set "kind" to "Acceleo3"
	OR
	1.1. Creation in an existing fcore file
   		- On a factory component or task, [New Sibling / Task Acceleo3]

	1.2. Set the name of the task

	1.3. Declaration of the implementation
		- In the implementation property, select a generation Java file 

	1.4. Creation of the parameters
		- On the Acceleo task, creation of the parameter container [New Child / Contract Container]
		- "Model URI" Parameter.
			New In parameter (contract), Name = "modelURI"
			New child, Type URI - In "Value" Property, Path expected, such as "platform:/resource/org.eclipse.egf.usecase.acceleo3/models/extlibrary.ecore"     
		- "output" Parameter.
			New In parameter (contract), Name = "output"
			New child, Type String - In "Value" Property, Path expected, such as "/org.eclipse.egf.usecase.acceleo3/output"     

2. Execution of an Acceleo3 task:
	Precondition:
		- Validity of the generation file 
		- Existence of the source model
		- Existence of the output directory as specified 
 
	2.1. On the fcore file when just one task, or on the task, "Run EGF Activity..."
	2.2. The result is in the output directory - Refresh required
 