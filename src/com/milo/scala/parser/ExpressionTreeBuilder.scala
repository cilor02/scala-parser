package com.milo.scala.parser

import com.milo.scala.parser.node.Node
import com.milo.scala.parser.node.BinaryNode
import scala.collection.mutable.Map



class ExpressionTreeBuilder (tokens:List[String])
{

  val operators = List ("**","/","*","+","-")
  var newList:List[String] = tokens
  //var nodeTable:Map[String,BinaryNode]  = Map()
  def process :Unit = operators.foreach(processOp(_)) 
  
  
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
      
      val name = ExpressionTreeBuilder.newName
      //println(name)
      //println(lstTkns)
      n.store(name)
      //nodeTable.+=((name->n))
      lstTkns.take(i-1):::processAllOccsOps(name::(lstTkns drop i+2),op)
    }else
    {
      
      lstTkns
    }
  }
}

object ExpressionTreeBuilder
{
    var k:Int = 0
  def newName():String = {k += 1; "com_milo_var" + k}
    
}