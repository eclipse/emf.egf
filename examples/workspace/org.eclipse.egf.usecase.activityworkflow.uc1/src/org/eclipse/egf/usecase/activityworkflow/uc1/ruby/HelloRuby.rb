# Import
include_class "org.eclipse.egf.ftask.producer.invocation.TaskProductionForRuby"
include_class "org.eclipse.egf.core.EGFCorePlugin"

module JavaLang
  include_package("java.lang")
end

module JavaUtil
  include_package("java.util")
end

# To read input contract values and write output contract values, 
# the class should extends the TaskProductionForRuby java class, 
# and override the preExecute(), doExecute() and postExecute() methods.

# This Ruby task
# 	1) Reads the "message" variable from the context
#	2) Changes the "message" value
#	3) Changes the "message" variable in the context with the new value  

class HelloRuby < TaskProductionForRuby
  
  # ------- override the superclass preExecute() method --------
  
  def preExecute(context,monitor)
    
	# Get "message" value from context
    $_message = context.getInputValue("message", JavaLang::String.java_class);
    
  end
  
  # -------- override the superclass doExecute() method --------
  
  def doExecute(context,monitor)
    
	#-- Change "message" value from context
    $_message = $_message + " from Ruby"

 	#-- Display on console
	puts $_message
    
    #-- Display in the EGF Console
    EGFCorePlugin.getDefault().logInfo($_message);
	   
  end
  
  # ------- override the superclass postExecute() method --------
  
  def postExecute(context,monitor)
    
	#-- Set "message" value from context
    context.setOutputValue("message", $_message);
    
  end
  
end

# instantiate the class
HelloRuby.new()