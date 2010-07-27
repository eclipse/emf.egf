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

class TestwriteOutputValues < TaskProductionForRuby
  
  # ------- override the superclass preExecute() method --------
  
  def preExecute(context,monitor)
    
    context.setOutputValue("output_parameter_string", "hello ruby")
    
    context.setOutputValue("output_parameter_integer", JavaLang::Integer.new(100))
    
    context.setOutputValue("output_parameter_long", 300)
    
    context.setOutputValue("output_parameter_float", JavaLang::Float.new(20.0))
    
  end
  
  # -------- override the superclass doExecute() method --------
  
  def doExecute(context,monitor)
    
    context.setOutputValue("output_parameter_byte", JavaLang::Byte.new(128))
    
    context.setOutputValue("output_parameter_character", JavaLang::Character.new(97))
    
    context.setOutputValue("output_parameter_double", 30.2)
    
    context.setOutputValue("output_parameter_short", JavaLang::Short.new(1));
    
  end
  
  # ------- override the superclass postExecute() method --------
  
  def postExecute(context,monitor)
    
    _parameters = JavaUtil::ArrayList.new();
    
    _parameters.add("param1")
    _parameters.add("param2")
    _parameters.add("param3")
    
    context.setOutputValue("output_parameter_collection", _parameters)
    
    context.setOutputValue("output_parameter_jmerger", JMerger.new());
    
  end
  
end

# instance the class
TestwriteOutputValues.new()

