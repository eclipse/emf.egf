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

class TaskProduction < TaskProductionForRuby
  
  # ------- override the superclass preExecute() method --------
  
  def preExecute(context,monitor)
    
    $_quantity = context.getInputValue("quantity", JavaLang::Integer.java_class);
    $_price = context.getInputValue("price", JavaLang::Float.java_class);
    $_parameters = context.getInputValue("parameters", JavaUtil::Collection.java_class);
    context.getOutputValue("jmerger", JMerger.java_class);
    
  end
  
  # -------- override the superclass doExecute() method --------
  
  def doExecute(context,monitor)
    
    $_amount = $_quantity * $_price;
    
  end
  
  # ------- override the superclass postExecute() method --------
  
  def postExecute(context,monitor)
    
    context.setOutputValue("amount",  JavaLang::Float.new($_amount));
    context.setOutputValue("jmerger", JMerger.new());
    $_parameters = JavaUtil::ArrayList.new();
    $_parameters.add("param1");
    $_parameters.add("param2");
    context.setOutputValue("parameters", $_parameters);
    
  end
  
end

# instance the class
TaskProduction.new()

