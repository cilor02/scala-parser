package com.milo.scala.node.bool

class BinaryBooleanNode (op:String,leftNode:String,rightNode:String) extends BooleanNode
{

  
  val left:BooleanNode = null
  val right:BooleanNode = null
  
  
  val operation = op match 
  {
    case "and" => (a:Boolean,b:Boolean) => a&&b
    case "or" => (a:Boolean,b:Boolean) => a||b
        
  }
  
  override def value = operation(left.value,right.value)
  
  
}