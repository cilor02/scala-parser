package com.milo.scala.parser

import com.milo.scala.parser.node.Node
import com.milo.scala.parser.node.BinaryNode
import scala.collection.mutable.Map
import com.milo.scala.parser.node.LeafNumericNode



class NoBracketExpressionBuilder (tokens:List[String])
{

  val operators = List ("**","/","*","+","-")
  var newList:List[String] = tokens
  def process :Unit =
  {
    if(tokens.size == 1)
    {
      val n = new LeafNumericNode( Integer.parseInt(tokens.head))
      val name = NoBracketExpressionBuilder.newName
      n.store(name)
      newList = List(name)
    }else
    {
      operators.foreach(processOp(_))
    }
  }
  
   def processOp (op:String) :Unit = 
   {
    newList = processAllOccsOps(newList,op)
    println(newList)
   }
  
  def processAllOccsOps (lstTkns:List[String], op:String):List[String] =
  { 
    val i = lstTkns.indexWhere(s =>s.==(op))
    println(i)
    if (i >= 0)
    {
      val n:BinaryNode = new BinaryNode(lstTkns(i),lstTkns(i-1),lstTkns(i+1))
      
      val name = NoBracketExpressionBuilder.newName

      n.store(name)
      lstTkns.take(i-1):::processAllOccsOps(name::(lstTkns drop i+2),op)
    }else
    {
      
      lstTkns
    }
  }
}

object NoBracketExpressionBuilder
{
    var k:Int = 0
  def newName():String = {k += 1; "com_milo_var" + k}
    
}