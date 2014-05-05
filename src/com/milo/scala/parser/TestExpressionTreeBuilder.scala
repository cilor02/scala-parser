package com.milo.scala.parser

import com.milo.scala.parser.node.LeafVarNode

object TestExpressionTreeBuilder extends App
{
  val tree1 = new ExpressionTreeBuilder(List("6","*","7","+","4","**","2","/","3.2"))
  val tree2 = new ExpressionTreeBuilder(List("200"))
  tree1.process
  tree2.process
  
  printExpinfo(tree1)
  printExpinfo(tree2)

  
  def printExpinfo(tree: ExpressionTreeBuilder)
  {
    val root = new LeafVarNode(tree.newList.head)
    println(root.getMap)
    println(root.value)
  }
}