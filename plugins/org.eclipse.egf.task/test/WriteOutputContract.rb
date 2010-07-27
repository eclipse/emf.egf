require "java"

include_class "org.eclipse.egf.ftask.producer.invocation.TaskProductionForRuby"

module JavaLang
  include_package("java.lang")
end

# To read input contract values and write output contract values, 
# the class should extends the TaskProductionForRuby java class, 
# and override the preExecute(), doExecute() and postExecute() methods.

class TestReadInputValues < TaskProductionForRuby
  
  # ------- override the superclass preExecute() method --------
  
  def preExecute(context,monitor)

    $input_parameter = context.getInputValue("input_parameter", JavaLang::String.java_class);
    
  end
  
   # -------- override the superclass doExecute() method --------
  
  def doExecute(context,monitor)

    context.setOutputValue("output_parameter", $input_parameter);

	$output_parameter = context.getOutputValue("output_parameter", JavaLang::String.java_class);
    
  end
  
  # ------- override the superclass postExecute() method --------
  
  def postExecute(context,monitor)
  
    puts "Ruby task writes: " + $output_parameter
    
  end

end

# instance the class
TestReadInputValues.new()

