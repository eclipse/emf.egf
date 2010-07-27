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
    
    input_parameter_string = context.getInputValue("input_parameter_string", JavaLang::String.java_class);
    
    input_parameter_integer = context.getInputValue("input_parameter_integer", JavaLang::Integer.java_class);
    
    input_parameter_long = context.getInputValue("input_parameter_long", JavaLang::Long.java_class);
    
    input_parameter_float = context.getInputValue("input_parameter_float", JavaLang::Float.java_class);
    
  end
  
  # -------- override the superclass doExecute() method --------
  
  def doExecute(context,monitor)

    input_parameter_byte = context.getInputValue("input_parameter_byte", JavaLang::Byte.java_class);

    input_parameter_character = context.getInputValue("input_parameter_character", JavaLang::Character.java_class);

    input_parameter_double = context.getInputValue("input_parameter_double", JavaLang::Double.java_class);
    
    input_parameter_short = context.getInputValue("input_parameter_short", JavaLang::Short.java_class);
    
  end
  
  # ------- override the superclass postExecute() method --------
  
  def postExecute(context,monitor)
    
    input_parameter_collection = context.getInputValue("input_parameter_collection", JavaUtil::Collection.java_class);
    
    input_parameter_jmerger = context.getInputValue("input_parameter_jmerger", JMerger.java_class);
    
  end
  
end

# instance the class
TestReadInputValues.new()

