package com.milo.scala.parser.node

class RelationalBinaryNode (left:Node,right:Node,op:String )extends BooleanStatementNode
{
    val fValue = op match
    {
    
    case "<" => (a:Node,b:Node) => a.value < b.value
    case ">" => (a:Node,b:Node) => a.value > b.value
    case "=" => (a:Node,b:Node) => a.value == b.value
    case ">=" => (a:Node,b:Node) => a.value >= b.value
    case "<=>" => (a:Node,b:Node) => a.value <= b.value
    case "factorOf" => (a:Node,b:Node) => b.value % a.value == 0
    case "multipleOf" => (a:Node,b:Node) => a.value % b.value == 0
    
    }

  def value = fValue (left,right)

}