package com.milo.scala.parser.node

object TestLeafNumericNode {
  
  def main(args:Array[String]) :Unit =
  {    
    val binaryNode = new BinaryNode("-","12","2.4")
    
    println(binaryNode.value)
    
    
    val ops = List("+","-","*","/")
    
    ops.foreach(x =>println(new BinaryNode( x,"12","2.4").value ))
  }

}