require "java"

include_class "org.eclipse.egf.ftask.producer.invocation.TaskProductionForRuby"

include_class "org.eclipse.emf.codegen.merge.java.JMerger"

module JavaLang
  include_package("java.lang")
end

module JavaUtil
  include_package("java.util")
end

# To read input contract values and write output contract values, 
# the class should extends the TaskProductionForRuby java class, 
# and override the preExecute(), doExecute() and postExecute() methods.

class TestReadInputValues < TaskProductionForRuby
  
  # ------- override the superclass preExecute() method --------
  
  def preExecute(context,monitor)

    input_parameter = context.getInputValue("input_parameter", JavaLang::String.java_class);

    puts "Ruby task read: " + input_parameter

  end

end

# instance the class
TestReadInputValues.new()

