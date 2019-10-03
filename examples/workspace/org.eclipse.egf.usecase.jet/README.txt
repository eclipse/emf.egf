--------------------------------------------------------------------------------
-- Jet Task
--------------------------------------------------------------------------------

--- Example
The example is the located in the egf folder.


--- Practice
* How to create and execute a Jet Task?
1. Creation of a new Jet Task with EGF:
	Precondition:
	    - The project is created and is a JET Project :
     		-- The Jet project is created with [File / New / Other... / new JET Transformation Project]
	    	OR 
		    -- An existing project is converted to a JET Project [File / New / Other... / Convert Projects to JET Projects]
		- Existence of the JET template 
	    - The JET template is located in the templates directory
 
	1.1. Creation in a new fcore file
   		- In a folder, [File / New / Other... / EGF / EGF Activity]
   		- In the Task, set "kind" to "JET"
	OR
	1.1. Creation in an existing fcore file
   		- On a factory component or task, [New Sibling / Task Jet]

	1.2. Set the name of the task

	1.3. Declaration of the implementation
		- In the implementation property, select a jet template

	1.4. Creation of the parameters
		- On the JET task, creation of the parameter container [New Child / Contract Container]
		- "parameter" Parameter.
			New In parameter (contract), Name = "parameter"
			New child, Type URI - In "Value" Property, URI expected, such as "platform:/resource/org.eclipse.egf.usecase.jet/model/extlibrary.ecore"     
		- "result" Parameter.
			New Out parameter (contract), Name = "result"
			New child, Type String     


2. Execution of an JET task:
	Precondition:
		- Existence of the model
	    - The project is created and is a JET Project :
     		-- The Jet project is created with [File / New / Other... / new JET Transformation Project]
	    	OR 
		    -- An existing project is converted to a JET Project [File / New / Other... / Convert Projects to JET Projects]
		- Existence of the JET template 
	    - The JET template is located in the templates directory
 
	2.1. On the fcore file when just one task, or on the task, "Run EGF Activity..."
	2.2. The result has to be used to fill another contract

--- Platform
Validated with EGF 0.6.0, and JET SDK-1.1.0
