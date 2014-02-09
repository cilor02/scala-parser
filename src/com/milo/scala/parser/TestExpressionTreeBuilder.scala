package com.milo.scala.parser

import com.milo.scala.parser.node.LeafVarNode

object TestExpressionTreeBuilder extends App
{
  val tree = new ExpressionTreeBuilder(List("6","*","7","+","4","**","2","/","3.2"))
  tree.process
  val root = new LeafVarNode(tree.newList.head)
  println(root.getMap)
  println(root.value)
}