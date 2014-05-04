package com.milo.scala.parser.node

class BooleanBinaryNode (left:BooleanStatementNode,right:BooleanStatementNode,op:String )extends BooleanStatementNode
{
    val fValue = op match
    {
    
    case "or" => (a:Boolean,b:Boolean) => a || b
    case "and" => (a:Boolean,b:Boolean) => a && b
        
    }

  def value = fValue (left.value,right.value)

}